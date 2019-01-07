#include "oeExecutableDeviceEnvironment.h"

#include <Windows.h>

// Includes for File control
#include <sys/types.h>
#include <sys/stat.h>
#include <direct.h>  	// _rmdir
#include <algorithm>

using namespace std;

static char * fs_remove_final_slash (const char * path)
{
	char * nativePath = NULL;
	int pathLen = strlen (path);

	if (path[pathLen - 1] == '\\')
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
	bool exists = false;
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
			cerr << "Error deleting " << path << " [error: " << GetLastError () << "]" << endl;
			break;
		}
	}

	return (error == 0);
}

bool fs_rmdir (const char *path)
{
	BOOL deleted;

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

// GetProcessId or ThreadId function prototype
bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize,
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr)
{
	DWORD fileAttr;
	std::string strCmd = "";
	BOOL bTmpResult;
	OEExecInfo execInfo;

	// verify the file is loaded before it is executed
	fileAttr = GetFileAttributes(argv[0]);
	if(fileAttr == INVALID_FILE_ATTRIBUTES || (fileAttr & FILE_ATTRIBUTE_DIRECTORY)) {
		return false;
	}

	id = -1;

	for(int i = 1; i < argc; i++)
	{
		strCmd += " ";
		strCmd += argv[i];
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
			strErr = (LPCTSTR)lpMsgBuf;
			LocalFree( lpMsgBuf );
		}

		return false;
	}

    pid_type pid = pi.dwProcessId;

	if(!pid)
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
			strErr = (LPCTSTR)lpMsgBuf;
			LocalFree( lpMsgBuf );
		}

		CloseHandle (pi.hProcess);
		CloseHandle (pi.hThread);
		return false;
	}

	execInfo.id = pid;
	execInfo.pi = pi;
	execInfoList.push_back (execInfo);

	id = (CF::ExecutableDevice::ProcessID_Type) pid;
	return true;
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
					std::cerr << "WaitForSingleObject : " << lpMsgBuf << endl;
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
			std::cerr << "GetModuleHandle (\"Kernel32\") failed : " << lpMsgBuf << endl;
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
			std::cerr << "GetProcAddress (hKernel, \"ExitProcess\") failed : " << lpMsgBuf << endl;
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
			std::cerr <<  "CreateRemoteThread failed : " << lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
		return false;
	}
	CloseHandle (hrt);

	return true;
}

static bool terminate_process (HANDLE hProcess)
{
	bool result = true;

	if (!TerminateProcess (hProcess, 1))
	{
		LPVOID lpMsgBuf = NULL;
		if (FormatMessage (FORMAT_MESSAGE_ALLOCATE_BUFFER | FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,
				NULL, GetLastError(), MAKELANGID (LANG_NEUTRAL, SUBLANG_DEFAULT), (LPTSTR) &lpMsgBuf, 0, NULL))
		{
			std::cerr << "TerminateProcess failed : " << lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
		result = false;
	}

	return result;
}

bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr)
{
	bool finished = false;
	DWORD exitCode = -1;
	bool ret = false;
	PROCESS_INFORMATION pi;
	OEExecInfo execInfo;

	ExecInfoList::iterator items = std::find (execInfoList.begin (), execInfoList.end (), id);
	if (items == execInfoList.end ())
	{
        std::cerr << "No process info found for pid " << id << endl;
        return false;
	}

	execInfo = *items;
	pi = execInfo.pi;

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
		if (terminate_process (pi.hProcess))
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
			std::cerr << "GetExitCodeProcess(" << id << ") failed : " << lpMsgBuf << endl;
			LocalFree (lpMsgBuf);
		}
	}
	else if (exitCode != STILL_ACTIVE)
	{
		ret = true;
	}

	execInfoList.remove (execInfo);

	CloseHandle (pi.hProcess);
	CloseHandle (pi.hThread);

	return ret;
}

//Platform dependent load
bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileMap& fileMap, std::string& strErr OE_ENV_ARGN)
{
	HANDLE pTmpFile;
	CF::File_var pCurFile;
	char * strTmpPath = "%TEMP%";
	int i, iLen, iNumRead, iBufLen = 255;
	CF::OctetSequence_var buffer;
	char pszTmp[260];
	OEFileInfo fInfo;
	bool error = false;

	if(!::ExpandEnvironmentStrings(strTmpPath, pszTmp, 260))
	{
		strErr = "Could not open temporary file.";
		return false;
	}

	// Convert the temp path to long names
	if (!GetLongPathName(pszTmp, pszTmp, 260))
	{
		strErr = "Could not open temporary file.";
		return false;
	}

	size_t found=deviceId.find(":");
	if( found != std::string::npos) {
		deviceId = deviceId.replace(deviceId.find(":"), 1, "_");
	}

	strcat (pszTmp, "\\");
	strcat (pszTmp, deviceId.c_str());
	strcat (pszTmp, "\\");

	// strip path information if it exists
	const char * filestr = strrchr(fileName,'\\');
	if(filestr == NULL)
	{
		strcat (pszTmp, fileName);
	}
	else
	{
		strcat (pszTmp, filestr + 1);
	}

	//Create missing directories
	iLen = strlen(pszTmp);
	for(i = 3; i < iLen; ++i)
	{
		if (pszTmp[i] == '/')
		{
			pszTmp[i] = '\\';
		}
		if(pszTmp[i] == '\\')
		{
			pszTmp[i] = '\0';
			if(!fs_exists (pszTmp))
			{
				if(!CreateDirectory(pszTmp, NULL))
				{
					strErr = "Could not create directory.";
					return false;
				}
			}
			pszTmp[i] = '\\';
		}
	}


	pTmpFile = CreateFile(pszTmp, GENERIC_READ | GENERIC_WRITE,
			FILE_SHARE_READ | FILE_SHARE_WRITE | FILE_SHARE_DELETE, NULL,
			CREATE_NEW, FILE_ATTRIBUTE_NORMAL | FILE_FLAG_WRITE_THROUGH, NULL);

	if(pTmpFile == INVALID_HANDLE_VALUE)
	{
		strErr = "Could not open temporary file.";
		return false;
	}

	pCurFile = fs->open(fileName, 1 OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	if(CORBA::is_nil(pCurFile))
	{
		strErr = "Could not open the passed-in fileName.";
		CloseHandle(pTmpFile);
		return false;
	}

	do
	{
		DWORD blocksWritten;
		int ret = 0;

		OE_TRY_LABEL(A)
		{
			pCurFile->read(buffer, iBufLen OE_ENV_VARN);
			OE_CHECK_ENV_LABEL(A);
		}
		OE_CATCH(CF::File::IOException, e)
		{
			strErr = "Could not read from the passed-in fileName.";
			CloseHandle(pTmpFile);

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
		ret = WriteFile(pTmpFile, (void*)buffer->get_buffer(), iNumRead, &blocksWritten, NULL);
		if (ret == 0 || blocksWritten != iNumRead)
		{
			cerr << "Error writing to file. Error " << GetLastError () << endl;
			error = true;
			break;
		}
	}
	while(iNumRead > 0);

	CloseHandle(pTmpFile);
	pCurFile->close(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);

	if (error)
	{
		if (fs_exists (pszTmp))
		{
			fs_remove (pszTmp);
		}
	}
	else
	{
		fInfo.strLocalFilename = pszTmp;
		fInfo.type = loadKind;
		fInfo.refCount = 1;
		fileMap[fileName] = fInfo;
	}

	return !error;
}

bool UnloadFile(const char *fileName, FileMap& fileMap, std::string& strErr)
{
	FileMap::iterator fmit;
	int result = 1;
	int i= 0;

	fmit = fileMap.find(fileName);

	cout << "Unload: removing file " << fmit->second.strLocalFilename << endl;
	result = fs_remove (fmit->second.strLocalFilename.c_str());

	if(!result) // could not delete file
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
			strErr = (LPCTSTR)lpMsgBuf;
			LocalFree( lpMsgBuf );
		}
		return false;
	}

	char * nativeFile = _strdup (fileName);
	int fileNameLen = strlen (fileName);
	for (int i = 0; i < fileNameLen; i++)
	{
		if (fileName[i] == '/')
		{
			nativeFile[i] = '\\';
		}
	}

	size_t found = fmit->second.strLocalFilename.rfind (nativeFile);
	if (found != std::string::npos)
	{
		std::string deviceDir = fmit->second.strLocalFilename.substr (0, found);
		std::string tempDir = deviceDir.substr (0, deviceDir.rfind ('\\'));

		std::string dir = fmit->second.strLocalFilename.substr (0, fmit->second.strLocalFilename.rfind ('\\'));

		while (dir != deviceDir)
		{
			if (!fs_rmdir (dir.c_str ()))
			{
				break;
			}
			else
			{
				dir = dir.substr (0, dir.rfind ('\\'));
			}
		}

		// Attempt to delete the device's root directory.
		fs_rmdir (deviceDir.c_str());

	}

	free (nativeFile);
	return true;
}
