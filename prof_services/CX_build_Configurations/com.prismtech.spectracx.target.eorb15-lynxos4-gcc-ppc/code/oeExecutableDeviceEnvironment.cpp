#include "oeExecutableDeviceEnvironment.h"

// GetProcessId or ThreadId function prototype
bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize,
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr)
{
	id = -1;
	// verify the file is loaded before it is executed
	struct stat st;
	if (stat(argv[0], &st)) { // != 0 implies file does not exist
		return false;
	}

	pid_type pid = -1;
	if ((pid = fork()) < 0) {
		strErr = "Could not execute fork()";
		return false;
	}
	id = (CF::ExecutableDevice::ProcessID_Type) pid;

	char** new_argv = new char*[argc + 1];

	for (int i = 0; i < argc; i++) {
		new_argv[i] = argv[i];
	}

	new_argv[argc] = NULL;

	if (pid == 0) // child process
	{
		if (execv(argv[0], new_argv) == -1)
		{
			exit (1);
		}
	}

	delete[] new_argv;

	return true;
}

bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr)
{
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

	return true;
}

bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileMap& fileMap, std::string& strErr OE_ENV_ARGN)
{
	FILE *pTmpFile = 0;
	CF::File_var pCurFile;
	int iNumRead = 0;
	int iBufLen = 255;
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
	
	OEFileInfo fInfo = { path, loadKind, 1 };
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
