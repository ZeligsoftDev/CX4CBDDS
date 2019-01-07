#include "scxExecutableDeviceEnvironment.h"
#include <dlfcn.h>  // shared library support
#include <pthread.h>

#define RTLD_DEFAULT NULL

// entry point function pointer for shared library components
typedef int (*entrypoint_func_t) (int, const char **);

// needed for pthread_create which only takes one argument
typedef struct {
	entrypoint_func_t func;
	int argc;
	char** argv;
} argsStruct_t;

// we need this helper function because pthread_create only takes one argument
// static to limit it's scope to this file
static void* pthread_create_helper(void* args)
{
	argsStruct_t* _args = (argsStruct_t *) args;

	(*_args->func)(_args->argc, (const char**) _args->argv);

	return 0;
}

// GetProcessId or ThreadId function prototype
bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize,
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr)
{
	// function declaration for shared library entry point
	entrypoint_func_t entrypoint_func = NULL;

	id = -1;
	// verify the file is loaded before it is executed
	struct stat st;
	bool fileLoaded = false;
	bool libraryLoaded = false;

	if (!stat(argv[0], &st)) { // != 0 implies file does not exist
		fileLoaded = true;
	} else {
		char* error = NULL;
		dlerror();    /* Clear any existing error */
		entrypoint_func = (entrypoint_func_t) dlsym(RTLD_DEFAULT, argv[0]);
		if ((error = dlerror()) != NULL)  {
			strErr = "Could not find the address of the shared library entry point: " + std::string(error);
			return false;
		} else {
			libraryLoaded = true;
		}
	}

	if(!fileLoaded && !libraryLoaded) {
		strErr = "Cannot find file or entry point to execute";
		return false;
	}

	if(fileLoaded) {

		pid_type pid = -1;
		// check stack size
		if(ulStackSize <= 0) {
			strErr = "Invalid Stack size";
			return false;
		}

		// check priority
		if(ulPriority < 0 || ulPriority > 255) {
			strErr = "Invalid Priority";
			return false;
		}

		pid = rtpSpawn (argv[0], (const char **)argv, (const char **)environ, ulPriority, ulStackSize, RTP_LOADED_WAIT, 0);

		if (pid == ERROR)
		{
			pid = -1;
			strErr = "Failed to spawn RTP.";
			return false;
		}

		id = (CF::ExecutableDevice::ProcessID_Type) pid;
		ScxExecInfo execInfo = {id, CF::LoadableDevice::EXECUTABLE};
		execInfoList.push_back(execInfo);

	} else if(libraryLoaded) {

		// create thread
		pthread_attr_t attr;
		int result = -1;

		result = pthread_attr_init(&attr);
		if(result != 0) {  // 0 indicates success
			strErr = "Could not initialize thread's attributes";
			return false;
		}

		pthread_attr_setinheritsched(&attr, PTHREAD_INHERIT_SCHED);

		if(ulStackSize > 0) {
			result = pthread_attr_setstacksize(&attr, ulStackSize);
			if(result != 0) {  // 0 indicates success
				strErr = "Could not set thread's stack size";
				return false;
			}
		}

		if(ulPriority > 0) {
			struct sched_param schedParam;
			schedParam.sched_priority = ulPriority;
			result = pthread_attr_setschedparam(&attr,&schedParam);
			if(result != 0) {  // 0 indicates success
				strErr = "Could not set thread's priority";
				return false;
			}
		}

		argsStruct_t* args = new argsStruct_t;
		args->func = entrypoint_func;
		args->argc = argc;
		args->argv = new char*[argc];
		for(int i=0; i<argc; i++) {
			args->argv[i] = new char[strlen(argv[i]) + 1];
			strcpy(args->argv[i], argv[i]);
		}

		tid_type tid = -1;
		result = pthread_create(&tid, &attr, pthread_create_helper, args);

		pthread_attr_destroy(&attr);

		for (int i = 0; i < args->argc; i++)
		{
			delete [] args->argv[i];
		}
		delete [] args;

		if(result) { // !0 indicates failure
			strErr = "Could not create pthread";
			return false;
		}

		id = (CF::ExecutableDevice::ProcessID_Type) tid;
		ScxExecInfo execInfo = {id, CF::LoadableDevice::SHARED_LIBRARY};
		execInfoList.push_back(execInfo);

	} else {
		strErr = "Unrecognized SCABinary type";
		return false;
	}

	return true;
}

bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr)
{
	// find the process or thread id
	ExecInfoList::iterator lit;

	for(lit = execInfoList.begin(); lit != execInfoList.end(); lit++) {
		if(id == (*lit).id) {
			break;
		}
	}

	if(lit == execInfoList.end()) {
		strErr = "UnloadFile failed to find passed-in process or thread id";
		return false;
	}

	// remove the process or thread info from the list
	execInfoList.remove(*lit);

	if((*lit).loadKind == CF::LoadableDevice::EXECUTABLE) {

		int status = kill((pid_type) id, SIGTERM); // 0 is returned on success

		if (status) {
			strErr = "Could not send SIGTERM signal";
			return false;
		}

		pid_t nRet = waitpid((pid_type) id, &status, WNOHANG); // Check if process is terminated

		if (nRet == -1) {
			strErr = "Process did not change state";
			return false;
		}

	} else if((*lit).loadKind == CF::LoadableDevice::SHARED_LIBRARY) {

		if( pthread_kill((tid_type) id, SIGTERM) == 0) { // 0 is returned on success
			return true;
		} else if(errno != ESRCH) {  // thread not found. it may have terminated gracefully on releaseObject()
			return true;
		} else {
			strErr = "Could not send SIGTERM signal to thread";
			return false;
		}
	} else {
		strErr = "Unrecognized SCABinary type";
		return false;
	}

	return true;
}

bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileMap& fileMap, std::string& strErr OE_ENV_ARGN)
{
	FILE *pTmpFile = 0;
	CF::File_var pCurFile;
	int iNumRead = 0;
	int iBufLen = 32768;
	CF::OctetSequence_var buffer;
	std::string strTmpPath = "tmp/";

	struct stat st;
	if( stat( strTmpPath.c_str(), &st)) { // directory does not exist, returns 0 on success
		if( mkdir(strTmpPath.c_str(), S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH)) { // failed, returns 0 on success
			strErr = "LoadFile failed to create directory";
			return false;
		}
	}
	
	size_t found=deviceId.find(":");
	if( found != std::string::npos) {
		deviceId = deviceId.replace(deviceId.find(":"), 1, "_");
	}
	std::string path = strTmpPath + deviceId + "/" ;
	
	if( stat( path.c_str(), &st) ) {
		if( mkdir( path.c_str(), S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH )) {
			strErr = "LoadFile failed to create subdirectory";
			return FALSE;
		}
	}

	// strip path information if it exists
	const char * filestr = strrchr(fileName,'/');
	if(filestr == NULL)
	{
		path += fileName;
	}
	else
	{
		path += filestr + 1;
	}

	pTmpFile = fopen( path.c_str(), "wb");

	if(!pTmpFile)
	{
		strErr = "Could not open temporary file.";
		return false;
	}

	pCurFile = fs->open(fileName, 1 OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	if(CORBA::is_nil(pCurFile))
	{
		strErr = "Could not open the passed-in fileName.";
		fclose(pTmpFile);
		return false;
	}

	do
	{
		OE_TRY_LABEL(A)
		{
			pCurFile->read(buffer, iBufLen OE_ENV_VARN);
			OE_CHECK_ENV_LABEL(A);
		}
		OE_CATCH(CF::File::IOException, e)
		{
			strErr = "Could not read from the passed-in fileName.";
			fclose(pTmpFile);

			OE_TRY_LABEL(B)
			{
				pCurFile->close(OE_ENV_VAR1);
				OE_CHECK_ENV_LABEL(B);
			}
			OE_CATCH_ANY
			{
				// Ignore exception
			}
			OE_END_TRY

			OE_THROW_RETURN(e, false);
		}
		OE_END_TRY

		iNumRead = buffer->length();
		fwrite((void*)buffer->get_buffer(), sizeof(CORBA::Octet), iNumRead, pTmpFile);
	}
	while(iNumRead> 0);

	fclose(pTmpFile);
	pCurFile->close(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);

	if(chmod(path.c_str(), S_IRWXU | S_IRWXG | S_IROTH | S_IWOTH) < 0)
	{
		return false;
	}

	// shared library
	void* module = NULL;
	if(loadKind == CF::LoadableDevice::SHARED_LIBRARY) {
		module = dlopen(strTmpPath.c_str(), RTLD_GLOBAL | RTLD_NOW);
		if (!module) {
			strErr = "Could not dlopen the passed-in fileName.";
			return false;
		 }
	}

	OEFileInfo fInfo = { path, loadKind, 1, module};
	fileMap[fileName] = fInfo;

	return true;
}

bool UnloadFile(const char *fileName, FileMap& fileMap, std::string& strErr)
{
	int result = 1;
	int i= 0;

	FileMap::iterator fmit = fileMap.find(fileName);
	if(fmit == fileMap.end()) {
		strErr = "UnloadFile failed to find passed-in fileName";
		return false;
	}

	do
	{
		if( result)
		{
			sleep(1);
		}
		if(fmit->second.type == CF::LoadableDevice::SHARED_LIBRARY && fmit->second.module != NULL) {
			dlclose(fmit->second.module);
		}
		result = remove( fmit->second.strLocalFilename.c_str()); // 0 == success
		++i;
	}
	while( result && (i < 3));

	if( result) // could not delete file
	{
		strErr = "UnloadFile failed to delete file";
		return false;
	}

	size_t found = fmit->second.strLocalFilename .rfind( "/" );
	if( found != std::string::npos) {
		std::string path = fmit->second.strLocalFilename.substr( 0, found );
		// rmdir() only removes a directory that is empty.
		rmdir( path.c_str() );
		rmdir("tmp/");
	}

	return true;
}

// End-Of-File
//------------------------------------------------------------------------------
