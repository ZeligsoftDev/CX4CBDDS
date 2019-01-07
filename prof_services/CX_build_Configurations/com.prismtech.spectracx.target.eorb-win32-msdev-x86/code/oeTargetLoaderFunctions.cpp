#include "oeTargetLoaderFunctions.h"

#include <sys/stat.h>
#include <sys/types.h>
#include <signal.h>
#include <errno.h>
#include <direct.h>
#include "eOrb/RTCORBA/Protocol.h"
#include "eOrb/RTCORBA/ServerProtocolPolicy.h"
#include "eOrb/RTCORBA/TCPProtocolProperties.h"

#ifndef HOST_NAME_MAX
   #define HOST_NAME_MAX 255
#endif

sem_t shutdown_mutex;

CORBA::String getHostName ()
{
	char hostname[HOST_NAME_MAX];

	if (gethostname (hostname, HOST_NAME_MAX) == 0)
	{
		return CORBA::string_dup (hostname);
	}
	else
	{
		return CORBA::string_dup ("Unknown");
	}
}

CORBA::String getOSName ()
{

	return CORBA::string_dup ("Windows");
}

CORBA::String getOSVersion ()
{
	OSVERSIONINFO osvi;
	char version[5];

	ZeroMemory(&osvi, sizeof(OSVERSIONINFO));
	osvi.dwOSVersionInfoSize = sizeof(OSVERSIONINFO);
	GetVersionEx(&osvi);

	sprintf(version, "%d.%d", osvi.dwMajorVersion, osvi.dwMinorVersion);
	return CORBA::string_dup (version);
}

CORBA::String getProcessorName ()
{
	SYSTEM_INFO sysInfo;
	char processor[10];

	GetSystemInfo (&sysInfo);

	switch( sysInfo.wProcessorArchitecture )
	{
	case PROCESSOR_ARCHITECTURE_INTEL:
		strcpy(processor, "x86");
		break;
	case PROCESSOR_ARCHITECTURE_IA64:
		strcpy(processor, "IA64");
		break;
	case PROCESSOR_ARCHITECTURE_AMD64:
		strcpy(processor, "x64");
		break;
	case PROCESSOR_ARCHITECTURE_ARM:
		strcpy(processor, "ARM");
		break;
	default:
		strcpy(processor, "unknown");
	}

	return CORBA::string_dup (processor);
}

static char * fs_remove_final_slash (const char * path)
{
	char * nativePath = NULL;
	int pathLen = strlen (path);

	if (path[pathLen - 1] == SYSTEM_PATH_SEPARATOR)
	{
		nativePath = (char *) malloc (pathLen);
		strncpy (nativePath, path, pathLen - 1);
		nativePath[pathLen - 1] = '\0';
	}
	else
	{
		nativePath = _strdup (path);
	}

	return nativePath;
}

bool fs_exists (const char* path)
{
	WIN32_FIND_DATA findFileData;
	HANDLE findHandle = INVALID_HANDLE_VALUE;
	bool exists = 0;
	char * nativePath = fs_remove_final_slash (path);

	findHandle = FindFirstFile (nativePath, &findFileData);
	exists = (findHandle != INVALID_HANDLE_VALUE);
	if (exists)
	{
		FindClose (findHandle);
	}
	free (nativePath);
	return exists;
}

bool fs_mkdir (const char *path)
{
	char *currentPath, *tmp, *saveptr, *token;

	if (fs_exists (path))
	{
		return false;
	}

	// account for the fact we may have to add a trailing separator
	currentPath = new char[strlen (path) + 2];
	strcpy (currentPath, "");

	tmp = new char[strlen (path) + 2];
	strcpy (tmp, path);
	saveptr = NULL;

	token = strtok_r (tmp, SYSTEM_PATH_SEPARATOR_STR, &saveptr);

	while (token)
	{
		strcat (currentPath, token);

		// if token is a drive letter add '/'
		/*
		if( strlen(currentPath) == 2 && *(currentPath + 1) == ':') {
			strcat (currentPath, SYSTEM_PATH_SEPARATOR_STR);
		}
		*/

		if (!fs_exists (currentPath))
		{
			if (CreateDirectory (currentPath, NULL) == 0)
			{
				delete [] currentPath;
				delete [] tmp;
				return false;
			}
		}
		else if (fs_getFileType (currentPath) != 1)
		{
			delete [] currentPath;
			delete [] tmp;
			return false;
		}

		// if last char is not '/'
		if( currentPath[strlen(currentPath) - 1] != SYSTEM_PATH_SEPARATOR) {
			strcat (currentPath, SYSTEM_PATH_SEPARATOR_STR);
		}
		token = strtok_r (NULL, SYSTEM_PATH_SEPARATOR_STR, &saveptr);
	}

	delete [] currentPath;
	delete [] tmp;

	return true;
}

Target::FileSystem::FileType fs_getFileType (const char *path)
{
	WIN32_FIND_DATA findFileData;
	HANDLE findHandle = INVALID_HANDLE_VALUE;
	Target::FileSystem::FileType fileType;
	char * nativePath = fs_remove_final_slash (path);

	findHandle = FindFirstFile (nativePath, &findFileData);
	free (nativePath);

	if (findHandle == INVALID_HANDLE_VALUE)
	{
		fileType = Target::FileSystem::FILETYPE_UNKNOWN;
	}
	else if((findFileData.dwFileAttributes & FILE_ATTRIBUTE_DIRECTORY))
    {
		fileType = Target::FileSystem::FILETYPE_DIRECTORY;
	}
	else
	{
		fileType = Target::FileSystem::FILETYPE_PLAIN;
	}

	FindClose (findHandle);
	return fileType;
}

int fs_open (const char *path, bool read_only, bool create, bool truncate)
{
	DWORD access = GENERIC_READ;
	DWORD creation = OPEN_EXISTING;
	DWORD shareMode = FILE_SHARE_READ | FILE_SHARE_WRITE | FILE_SHARE_DELETE;
	DWORD flags = FILE_ATTRIBUTE_NORMAL;
	HANDLE fileHandle = INVALID_HANDLE_VALUE;

	if (!read_only)
	{
		access |= GENERIC_WRITE;
	}

	if (create)
	{
		if (!fs_exists (path))
		{
			creation = CREATE_NEW;
			flags |= FILE_FLAG_WRITE_THROUGH;
		}
	}
	else if (truncate)
	{
		creation = TRUNCATE_EXISTING;
	}

	fileHandle = CreateFile (path, access, shareMode, NULL, creation, flags, NULL);
	if (fileHandle != INVALID_HANDLE_VALUE)
	{
		return _open_osfhandle ((intptr_t)fileHandle, _O_RDONLY);
	}
	return -1;
}

CORBA::LongLong fs_getFileSize (const char *path)
{
	WIN32_FILE_ATTRIBUTE_DATA fad;
	if (!GetFileAttributesEx (path, GetFileExInfoStandard, &fad))
	{
		return -1;
	}
	return ((CORBA::LongLong) fad.nFileSizeHigh << 32) + (CORBA::LongLong) fad.nFileSizeLow;
}

bool fs_setFilePointer (int fd, CORBA::ULong offset)
{
	int result = 0;
	LARGE_INTEGER li;
	HANDLE handle = (HANDLE) _get_osfhandle (fd);

	li.QuadPart = offset;

	result = SetFilePointer (handle, li.LowPart, &li.HighPart, FILE_BEGIN);

	return (result != INVALID_SET_FILE_POINTER);
}

CORBA::LongLong fs_read (int fd, void *buffer, CORBA::ULong count)
{
	DWORD blocksRead = 0;
	HANDLE handle = (HANDLE) _get_osfhandle (fd);
	BOOL success = ReadFile
	(
		handle,
		buffer,
		count,
		&blocksRead,
		NULL
	);

	return (success ? blocksRead : (CORBA::LongLong) -1);
}

CORBA::LongLong fs_write (int fd, const void *buffer, CORBA::ULong count)
{
	DWORD blocksWritten = 0;
	HANDLE handle = (HANDLE) _get_osfhandle (fd);
	BOOL success = WriteFile
	(
		handle,
		buffer,
		count,
		&blocksWritten,
		NULL
	);

	return (success ? blocksWritten : (CORBA::LongLong) -1);
}

bool fs_close (int fd)
{
	/* The call to _close() also closes the underlying handle. */
	return _close (fd) == 0;
}

bool fs_remove (const char * path)
{
	int error = 0;
	int retries = 0;
	int exists = 1;

	while (exists && retries < 20)
	{
		BOOL deleted = DeleteFile (path);
		if (!deleted)
		{
			error = GetLastError ();
		}

		if (deleted || error == ERROR_ACCESS_DENIED)
		{
			if ((exists = fs_exists (path)))
			{
				Sleep (100);
				retries ++;
				error = ERROR_ACCESS_DENIED;
			}
			else
			{
				error = 0;
			}
		}
		else
		{
			/* Delete failed for another reason, so exit now. */
			break;
		}
	}

	if (error != 0)
	{
		cerr << "Error removing " << path << " [error: " << GetLastError () << "]" << endl;
	}
	return (error == 0);
}

bool fs_rmdir (const char *path, bool deleteContents)
{
	BOOL deleted;
	
	if (deleteContents)
	{
		char **contents = NULL;
		CORBA::ULong size;

		if (fs_ls (path, contents, size))
		{
			for (CORBA::ULong i = 0; i < size; i++)
			{
				if (strcmp (contents[i], ".") != 0 && strcmp (contents[i], "..") != 0)
				{
					char *itemPath;
					CORBA::Short type;

					itemPath = new char[strlen(path) + strlen(contents[i]) + 2];
					strcpy (itemPath, path);
					strcat (itemPath, SYSTEM_PATH_SEPARATOR_STR);
					strcat (itemPath, contents[i]);

					type = fs_getFileType (itemPath);
					if (type == Target::FileSystem::FILETYPE_PLAIN)
					{
						fs_remove (itemPath);
					}
					else if (type == Target::FileSystem::FILETYPE_DIRECTORY)
					{
						fs_rmdir (itemPath, true);
					}

					delete [] itemPath;
				}
			}
		}

		if (contents != NULL)
		{
			for (CORBA::ULong i = 0; i < size; i++)
			{
				delete [] contents[i];
			}
			delete [] contents;
		}
	}
	
	deleted = RemoveDirectory (path);
	if (deleted || GetLastError () == ERROR_ACCESS_DENIED)
	{
		int retries = 0;
		int error = 0;
		do
		{
			if (fs_exists (path))
			{
				/* Sleep for 100ms before retrying */
				Sleep (100);
				retries ++;
				error = ERROR_ACCESS_DENIED;
			}
			else
			{
				error = 0;
				break;
			}
		} while (retries < 20); /* Max 2 seconds */
		return (error == 0);
	}
	
	return false;
}

bool fs_ls (const char *path, char** &contents, CORBA::ULong &size)
{
	WIN32_FIND_DATA ffd;
	HANDLE hFind = INVALID_HANDLE_VALUE;
	char* tmpPath;
	int len;

	len = strlen( path);
	// add wild card * to directory
	if(path[len - 1] == SYSTEM_PATH_SEPARATOR) {
		tmpPath = new char[len += 2];
		strcpy( tmpPath, path);
	} else {
		tmpPath = new char[len += 3];
		strcpy( tmpPath, path);
		tmpPath[len - 3] = SYSTEM_PATH_SEPARATOR;
	}
	tmpPath[len - 2] = '*';
	tmpPath[len - 1] = '\0';

	hFind = FindFirstFile(tmpPath, &ffd);
	/* delete [] tmpPath; */

	if (INVALID_HANDLE_VALUE == hFind)
   {
	  delete [] tmpPath;
	  return false;
   }

	CORBA::ULong max = 25;
	contents = new char*[max];
	size = 0;
   // List all the files in the directory
   do {
	   if (size >= max) {
		   char** temp;

		   max *= 2;
		   temp = new char*[max];

		   for (CORBA::ULong j = 0; j < size; j++) {
			   temp[j] = contents[j];
		   }
		   delete [] contents;
		   contents = temp;
	   }
	   contents[size] = new char[strlen (ffd.cFileName) + 1];
	   strcpy (contents[size++], ffd.cFileName);
	}  while (FindNextFile(hFind, &ffd) != 0);

    FindClose (hFind);
	return true;
}

char* fs_getcwd ()
{
	int cwdlen = GetCurrentDirectory (0, NULL);
	if (cwdlen > 0)
	{
	   char *cwd = new char[cwdlen];
	   cwdlen = GetCurrentDirectory (cwdlen, cwd);
	   if (cwdlen > 0)
	   {
		   return cwd;
	   }
	   else
	   {
		   delete [] cwd;
	   }
	}
	
	return NULL;
}

int exec (char **argv, char **options, const char *working_dir, LoadInfo *loadInfo)
{
	DWORD fileAttr;
	std::string strCmd = "";
	BOOL bTmpResult;
	int pid = -1;

	// verify the file exists
	fileAttr = GetFileAttributes(argv[0]);
	if(fileAttr == INVALID_FILE_ATTRIBUTES || (fileAttr & FILE_ATTRIBUTE_DIRECTORY)) {
		return pid;
	}

	int i = 1;
	while( argv[i] != NULL) {
		strCmd += " ";
		strCmd += argv[i++];
	}

	STARTUPINFO         si = { 0 };
	PROCESS_INFORMATION pi = { 0 };
	si.cb = sizeof(si);

	bTmpResult = CreateProcess( argv[0],  		// Module name i.e. executable
					 (char*)strCmd.c_str(), 	// Command line
					 NULL,
					 NULL,
					 false,           			// handle inheritance set to false
					 CREATE_NEW_PROCESS_GROUP,
					 NULL,
					 NULL,
					 &si,
					 &pi);

	if(!bTmpResult)
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage(
			FORMAT_MESSAGE_ALLOCATE_BUFFER |
			FORMAT_MESSAGE_FROM_SYSTEM |
			FORMAT_MESSAGE_IGNORE_INSERTS,
			NULL,
			GetLastError(),
			MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
			(LPTSTR) &lpMsgBuf,
			0,
			NULL ))
		{
			std::cerr << "CreateProcess() failed : " << lpMsgBuf << endl;
			LocalFree( lpMsgBuf );
		}

		return pid;
	}

	pid = pi.dwProcessId;
	loadInfo->processList[pi.dwProcessId] = pi;

	return pid;
}

static bool wait_for_process_to_finish (HANDLE hProcess, DWORD timeout, int tries)
{
	int i;
	bool finished = false;

	/* Wait for the process to finish */
	for (i = 0; (i < tries) && !finished; i++)
	{
		DWORD waitresult;
		waitresult = WaitForSingleObject (hProcess, timeout);
		switch (waitresult)
		{
			case WAIT_OBJECT_0 : /* The state is signaled */
			{
				finished = true;
				break;
			}
			case WAIT_TIMEOUT : /* Timeout elapsed, state is nonsignaled. */
			{
				break;
			}
			case WAIT_FAILED :
			{
				LPVOID lpMsgBuf = NULL;
				if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
					NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
				{
					std::cerr << "WaitForSingleObject : " << (LPTSTR) lpMsgBuf << endl;
					LocalFree (lpMsgBuf);
				}
				break;
			}
			default :
			{
				break;
			}
		}
	}

	return finished;
}

static bool exit_process (HANDLE hProcess, UINT uExitCode)
{
	HINSTANCE hKernel;
	FARPROC pfnExitProc;
	HANDLE hrt;
	DWORD dwTID;

	hKernel = GetModuleHandle ("Kernel32");
	if (hKernel == NULL)
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
			NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
		{
			std::cerr << "GetModuleHandle (\"Kernel32\") failed : " << (LPTSTR) lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
		return false;
	}

	pfnExitProc = GetProcAddress (hKernel, "ExitProcess");
	if (pfnExitProc == NULL)
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
			NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
		{
			std::cerr << "GetProcAddress (hKernel, \"ExitProcess\") failed : " << (LPTSTR) lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
		return false;
	}

	hrt = CreateRemoteThread (hProcess, NULL, 0,
			(LPTHREAD_START_ROUTINE)pfnExitProc,
			(PVOID)uExitCode, 0, &dwTID);
	if (hrt == NULL)
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
				NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
		{
			std::cerr <<  "CreateRemoteThread failed : " << (LPTSTR) lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
		return false;
	}

	return true;
}

static bool kill_process (HANDLE hProcess)
{
	bool result = true;

	if (!TerminateProcess (hProcess, 1))
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
				NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
		{
			std::cerr << "TerminateProcess failed : " << (LPTSTR) lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
		result = false;
	}
	return result;
}

bool terminate_process (int pid, const char *path, LoadInfo *loadInfo)
{
	bool finished = false;
	bool ret = false;
	DWORD exitCode = -1;
	
	PROCESS_INFORMATION pi;
	std::map<DWORD, PROCESS_INFORMATION>::iterator it;

	it = loadInfo->processList.find (pid);
	if (it == loadInfo->processList.end())
	{
		std::cerr << "Unable to find process info for pid " << pid << endl;
		return false;
	}

	pi = it->second;

	finished = wait_for_process_to_finish (pi.hProcess, 0, 1);
	if (!finished)
	{
		if (exit_process (pi.hProcess, 1))
		{
			finished = wait_for_process_to_finish (pi.hProcess, 200, 25);
		}
	}
	if (!finished)
	{
		if (kill_process (pi.hProcess))
		{
			finished = wait_for_process_to_finish (pi.hProcess, 200, 25);
		}
	}

	if (GetExitCodeProcess (pi.hProcess, &exitCode) == 0)
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
		    NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
		{
		    std::cerr << "GetExitCodeProcess(" << pid << ") failed : " << (LPTSTR) lpMsgBuf << endl;
		    LocalFree (lpMsgBuf);
		}
	}
	else if (exitCode != STILL_ACTIVE)
	{
		ret = true;
	}
	else
	{
		std::cerr << "Process is still active." << endl;
	}
	
	CloseHandle (pi.hProcess);
	CloseHandle (pi.hThread);

	loadInfo->processList.erase (pid);

	return ret;
}

PortableServer::POA_ptr create_target_loader_poa (CORBA::ORB_ptr orb, int port, const char* poa_name OE_ENV_ARGN)
{
	CORBA::Object_var tempobj = orb->resolve_initial_references("RootPOA" OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);

	PortableServer::POA_var rootpoa = PortableServer::POA::_narrow(tempobj OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);
	if(CORBA::is_nil(rootpoa))
	{
		return NULL;
	}

	CORBA::PolicyList policies;
	policies.length (port > 0 ? 3 : 2);

	policies[0] = rootpoa->create_id_assignment_policy(PortableServer::USER_ID OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);
	policies[1] = rootpoa->create_lifespan_policy(PortableServer::PERSISTENT OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);

	if (port > 0)
	{
		RTCORBA::ProtocolList protocolList;
		protocolList.length (1);

		RTCORBA::TCPProtocolProperties_var tcp = new RTCORBA::TCPProtocolProperties ();
		OE_CHECK_ENV_RETURN(NULL);
		tcp->port (port);
		tcp->reuse_addr (true);

		protocolList[0].protocol_type = IOP_TAG_INTERNET_IOP;
		protocolList[0].orb_protocol_properties = RTCORBA::ProtocolProperties::_nil ();
		protocolList[0].transport_protocol_properties = RTCORBA::ProtocolProperties::_duplicate (tcp.in ());

		policies[2] = new RTCORBA::ServerProtocolPolicy (protocolList);
	}

	PortableServer::POA_var childpoa = rootpoa->create_POA (poa_name, PortableServer::POAManager::_nil(), policies OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);

	return childpoa._retn();
}

void* shutdown_thread(void* targetLoader)
{
	return NULL;
}

bool CtrlHandler( DWORD fdwCtrlType )
{
	/* Signals not currently supported on Windows. */
	return true;
}

void register_process_termination_callback(const Target::TargetLoader_ptr targetLoader)
{
	/* Do nothing */
}
