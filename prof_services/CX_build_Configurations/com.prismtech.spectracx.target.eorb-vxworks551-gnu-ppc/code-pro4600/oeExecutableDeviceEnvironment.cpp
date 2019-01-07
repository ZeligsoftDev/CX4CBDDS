#include "oeExecutableDeviceEnvironment.h"

bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize,
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr)
{
	extern SYMTAB_ID sysSymTbl;
	char * address;
	SYM_TYPE type;

	// Set default stack size and priority
	if (ulStackSize == 0) {
		ulStackSize = 20000;
	}
	if (ulPriority == 0) {
		ulPriority = 100;
	}

	id = -1;
	if (OK == symFindByName(sysSymTbl, argv[0], &address, &type))
	{
		char **new_argv = new char*[argc + 1];
		int i = 0;
		for (i = 0; i < argc; i++)
		{
			new_argv[i] = new char[strlen(argv[i]) + 1];
			strcpy(new_argv[i], argv[i]);
		}
		new_argv[argc] = 0;

		pid_type pid = taskSpawn(argv[0], ulPriority, 0, ulStackSize,
				(FUNCPTR) address, argc, (int) new_argv, 0, 0, 0, 0, 0, 0, 0, 0);

		if (pid == 0)
		{
			std::cerr << "ERROR: Failed to spawn task: "
					<< std::string(argv[0]) << std::endl;
			for (i = 0; new_argv[i] != 0; i++)
			{
				delete [] new_argv[i];
			}
			delete [] new_argv;
			return false;
		}
		id = (CF::ExecutableDevice::ProcessID_Type) pid;
	}
	else
	{
		std::cerr<<"ERROR: Could not find symbol: "<<std::string(argv[0])<<std::endl;
		return false;
	}

	return true;
}

bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr)
{
	return true;
}

int runInitOrFini (const char *file, void *libHandle, char *extName, void **sym_ptr)
{
   char *fileName = NULL;
   char *stemName = NULL;
   char *startPtr = NULL;
   char *endPtr = NULL;
   char *functionName = NULL;
   int stemLen;
   int result = 0;
   extern SYMTAB_ID sysSymTbl;
   char *address = NULL;
   SYM_TYPE type;

   fileName = new char[strlen (file) + 1];
   strcpy (fileName, file);
   startPtr = strrchr (fileName, (int) '/');
   startPtr = (startPtr ? ++startPtr : fileName);
   endPtr = strchr (startPtr, (int) '.');
   endPtr = (endPtr ? --endPtr : fileName + strlen (fileName));
   stemLen = (endPtr - startPtr) + 1;
   stemName = new char[stemLen + 1];
   strncpy (stemName, startPtr, stemLen);
   stemName[stemLen] = '\0';

   functionName = new char [stemLen + 9];
   strcpy (functionName, "__");
   strcat (functionName, stemName);
   strcat (functionName, extName);

   if (symFindByName (sysSymTbl, functionName, &address, &type) == OK)
   {
      *sym_ptr = address;
      result = 0;
   }
   else
   {
	   result = 1;
   }

   delete [] functionName;
   delete [] stemName;

   return result;
}

void runConstructor (const char *fileName, void *libHandle)
{
   void *sym_ptr;
   int result = 0;
   result = runInitOrFini (fileName, libHandle, "__init", &sym_ptr);

   if (result == 0)
   {
      ((init_lib_func_t) sym_ptr) ();
   }
}

void runDestructor (const char *fileName, void *libHandle)
{
   void *sym_ptr;
   int result = 0;
   result = runInitOrFini (fileName, libHandle, "__fini", &sym_ptr);

   if (result == 0)
   {
      ((fini_lib_func_t) sym_ptr) ();
   }
}

OEFileInfo * FindFile (const char * filename, FileList& fileList)
{
	return fileList.find (filename);
}

void FileList::add (std::string filename, std::string localFilename, CF::LoadableDevice::LoadType type, MODULE_ID id)
{
	OEFileInfo * fileInfo = new OEFileInfo (filename, localFilename, type, id);

	if (head) {
		tail->next = fileInfo;
		tail = fileInfo;
	}
	else {
		head = tail = fileInfo;
	}
}

bool FileList::remove (std::string filename)
{
	OEFileInfo *prev = NULL;

	for (OEFileInfo *temp = head; temp; prev = temp, temp = temp->next) {
		if (filename.compare (temp->strFilename) == 0) {
			if (prev) {
				prev->next = temp->next;
				if (temp->next == NULL) {
					tail = prev;
				}
			}
			else {
				head = temp->next;
				if (temp->next == NULL) {
					tail = NULL;
				}
			}
			delete temp;
			return true;
		}
	}
	return false;
}

OEFileInfo * FileList::find (std::string filename)
{
	for (OEFileInfo * fileInfo = head; fileInfo; fileInfo = fileInfo->next) {
		if (filename.compare (fileInfo->strFilename) == 0) {
			return fileInfo;
		}
	}
	return NULL;
}

bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileList& fileList, std::string& strErr OE_ENV_ARGN)
{
	FILE *pTmpFile = 0;
	CF::File_var pCurFile;
	int iNumRead = 0;
	int iBufLen = 255;
	CF::OctetSequence_var buffer;
	std::string strTmpPath = "tmp";

	struct stat st;
	if (stat ((char *)strTmpPath.c_str(), &st)) // directory does not exist, returns 0 on success
	{
		if (mkdir (strTmpPath.c_str())) // failed, returns 0 on success
		{
			strErr = "LoadFile failed to create directory";
			return false;
		}
	}
	
	size_t found=deviceId.find(":");
	if( found != std::string::npos) {
		deviceId = deviceId.replace(deviceId.find(":"), 1, "_");
	}
	std::string path = strTmpPath + "/" + deviceId;
	
	if( stat( (char *)path.c_str(), &st) ) {
		if( mkdir( path.c_str())) {
			strErr = "LoadFile failed to create subdirectory";
			return FALSE;
		}
	}

	path += "/";

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

		if (iNumRead <= 0)
		{
			break;
		}
		if ( fwrite((void*)buffer->get_buffer(), sizeof(CORBA::Octet), iNumRead, pTmpFile) != iNumRead )
		{
			strErr = std::string("Error: fwrite failed to write to file: ") + strTmpPath;
			std::cerr << strErr << std::endl;
			fclose(pTmpFile);
			pCurFile->close(OE_ENV_VAR1);
			OE_CHECK_ENV_RETURN(false);
			return false;
		}
	} while (iNumRead > 0);
	pCurFile->close(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);
	fclose(pTmpFile);

	//open the file with os open call and load it ...
	std::string file = path;
	int fdX;
	fdX = open (file.c_str(), O_RDONLY, 0);

	if (fdX==0)
	{
		std::cerr << "Failed to open file: "<<file<<std::endl;
		strErr = std::string("Failed to open file: ") +file;
		return false;
	}

	MODULE_ID mid = loadModule (fdX, LOAD_ALL_SYMBOLS);
	close (fdX);
	if (mid == 0)
	{
		std::cerr << "Failed to load file: "<<std::string(fileName)<<std::endl;
		strErr = std::string("Failed to load file: ")+std::string(fileName);
		return false;
	}

	runConstructor (fileName, mid);

	fileList.add (fileName, path, loadKind, mid);

	return true;
}

bool UnloadFile(const char *fileName, FileList& fileList, std::string& strErr)
{
	OEFileInfo *file = FindFile (fileName, fileList);

	if (file == NULL)
	{
		strErr = "UnloadFile failed to find passed-in fileName";
		return false;
	}

	runDestructor (fileName, file->m_id);

	if ( OK != unld(file->m_id, 0) )
	{
		strErr = "UnloadFile failed to unload the file";
		return false;
	}

	remove (file->strLocalFilename.c_str());

	fileList.remove (fileName);
	return true;
}

// End-Of-File
//------------------------------------------------------------------------------
