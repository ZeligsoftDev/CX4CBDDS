#include "oeExecutableDeviceEnvironment.h"

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

	if (pid == 0) // child process
	{
		if (execv(argv[0], argv) == -1)
		{
			exit (1);
		}
	}

	return true;
}

bool KillProcess(CF::ExecutableDevice::ProcessID_Type processId, ExecInfoList& execInfoList, std::string &strErr)
{
	/*
	 * Before we start sending signals to the child process, to stop it, check
	 * it's still running by doing a waitpid() call. If it's not still running
	 * because it terminated abnormally, we can issue a warning to say why. If
	 * it's not running because it terminated normally, we shouldn't issue a
	 * warning.
	 */

	while (1) {
		int status;
		pid_t pid = waitpid((pid_t) processId, &status, WNOHANG);
		if (pid == (pid_t) processId) /* Child has gone */
		{
#if defined(DEBUG_MSGS)
			std::string debug_message;
			if (WIFEXITED (status))
			{
				debug_message = params_.COMPONENT_IDENTIFIER + " terminated prematurely (but normally) with exit status = " + WEXITSTATUS (status));
			}
			else if (WIFSIGNALED (status))
			{
				debug_message = params_.COMPONENT_IDENTIFIER + " terminated prematurely by signal " + WTERMSIG (status));
			}
			else
			{
				debug_message = params_.COMPONENT_IDENTIFIER + " terminated prematurely with status = " + status);
			}
			worker_->debugMsg(debug_message);
#endif
			return true;
		} else if (pid == 0) /* No status available yet - presumably still running */
		{
#if defined(DEBUG_MSGS)
			std::string debug_message = params_.COMPONENT_IDENTIFIER + " still running", processId);
			worker_->debugMsg(debug_message);
#endif
			break;
		} else if (pid == -1) /* An error occurred in the waitpid() call */
		{
			if (errno == EINTR) /* waitpid() was interrupted so retry */
			{
#if defined(DEBUG_MSGS)
				std::string debug_message = params_.COMPONENT_IDENTIFIER + " waitpid interrupted, retrying");
				worker_->debugMsg(debug_message);
#endif
				continue;
			} else /* waitpid() got some other error */
			{
#if defined(DEBUG_MSGS)
				std::string debug_message = params_.COMPONENT_IDENTIFIER + " waitpid failed with errno " + errno);
				worker_->debugMsg(debug_message);
#endif
				break;
			}
		}
	}

	/*
	 * If we get here it means that waitpid() said the process still exists
	 */
	{
		int signal;
		int pause;
		int signals[] = { SIGQUIT, /* SCA termination */
		SIGINT, /* ^C */
		SIGTERM, /* kill */
		SIGKILL /* kill -9 */
		};

		for (signal = 0; signal < (sizeof(signals) / sizeof(signals[0])); signal++) {
#if defined(DEBUG_MSGS)
			std::string debug_message = params_.COMPONENT_IDENTIFIER + " Sending signal " + signals[signal]);
			worker_->debugMsg(debug_message);
#endif

			if (kill((pid_t) processId, signals[signal]) == -1) {
				/*
				 * kill() can fail with EINVAL, EPERM or ESRCH.
				 */
				assert(errno != EINVAL); /* This means the signal number is somehow invalid */
				assert(errno != EPERM); /* We started it so we must be able to kill it */

				if (errno == ESRCH) {
					/*
					 * This ought not to happen because even if the process dies prematurely, it should hang around defunct.
					 * Given that kill() can't see the process, we shouldn't carry on and try a waitpid() on it, so just return.
					 */
#if defined(DEBUG_MSGS)
					debug_message = params_.COMPONENT_IDENTIFIER + " kill() failed: errno=" + errno);
					worker_->debugMsg(debug_message);
#endif
					return true;
				} else {
#if defined(DEBUG_MSGS)
					debug_message = params_.COMPONENT_IDENTIFIER + " kill() failed: errno=" + errno);
					worker_->debugMsg(debug_message);
#endif
				}
			}

			/*
			 * Wait for child process to terminate and synchronize with this parent
			 * process. We call waitpid() with the WNOHANG option so that it does
			 * not block. This allows us to put it in a timeout loop so that we do
			 * not hang indefinitely, and so that if the child is ignoreing the
			 * signal sent to it, we can move on to try a different signal.
			 */
			for (pause = 8; pause < 32768; pause <<= 1) {
				pid_t pid;
				int status;

				pid = waitpid((pid_t) processId, &status, WNOHANG);

				if (pid == (pid_t) processId) /* Child has gone */
				{
					if (WIFEXITED(status)) {
#if defined(DEBUG_MSGS)
						debug_message = params_.COMPONENT_IDENTIFIER + " terminated normally with exit status = " + WEXITSTATUS(status));
						worker_->debugMsg(debug_message);
#endif
					} else if (WIFSIGNALED(status)) {
#if defined(DEBUG_MSGS)
						debug_message = params_.COMPONENT_IDENTIFIER + " terminated by signal =" + WTERMSIG(status));
						worker_->debugMsg(debug_message);
#endif
					} else {
#if defined(DEBUG_MSGS)
						debug_message = params_.COMPONENT_IDENTIFIER + " terminated with status = " + status);
						worker_->debugMsg(debug_message);
#endif
					}
					return true;
				} else if (pid == 0) /* No status available yet */
				{
					struct timespec wait;

#if defined(DEBUG_MSGS)
					debug_message = params_.COMPONENT_IDENTIFIER + "Waiting for child process");
					worker_->debugMsg(debug_message);
#endif

					wait.tv_sec = pause / 1000;
					wait.tv_nsec = (pause % 1000) * 1000000;

					nanosleep(&wait, NULL);

				} else if (pid == -1) /* An error occurred */
				{
					if (errno == EINTR) /* waitpid() was interrupted so retry */
					{
						struct timespec wait;

#if defined(DEBUG_MSGS)
						debug_message = params_.COMPONENT_IDENTIFIER + " waitpid interrupted, retrying");
						worker_->debugMsg(debug_message);
#endif

						wait.tv_sec = pause / 1000;
						wait.tv_nsec = (pause % 1000) * 1000000;

						nanosleep(&wait, NULL);

						continue;
					} else /* waitpid() got some other error */
					{
#if defined(DEBUG_MSGS)
						debug_message = params_.COMPONENT_IDENTIFIER + " waitpid failed: errno=" + errno);
						worker_->debugMsg(debug_message);
#endif
						return true;
					}
				}
			}
		}
	}
	return true;
}

OEFileInfo * FindFile (const char * filename, FileList& fileList)
{
	return fileList.find (filename);
}

void FileList::add (std::string filename, std::string localFilename, CF::LoadableDevice::LoadType type)
{
	OEFileInfo * fileInfo = new OEFileInfo (filename, localFilename, type);

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
	int iBufLen = 32768;
	CF::OctetSequence_var buffer;
	std::string strTmpPath = "tmp";

	struct stat st;
	if( stat( strTmpPath.c_str(), &st)) { // directory does not exist, returns 0 on success
		if( mkdir(strTmpPath.c_str(), S_IRWXU | S_IRWXG | S_IRWXO)) { // returns 0 on success, -1 on failure
			strErr = "LoadFile failed to create directory";
			return false;
		}
	}
	
	size_t found=deviceId.find(":");
	if( found != std::string::npos) {
		deviceId = deviceId.replace(deviceId.find(":"), 1, "_");
	}
	std::string path = strTmpPath + "/" + deviceId;
	
	if( stat( path.c_str(), &st) ) {
		if( mkdir( path.c_str(), S_IRWXU | S_IRWXG | S_IRWXO )) { // returns 0 on success, -1 on failure
			strErr = "LoadFile failed to create subdirectory";
			return FALSE;
		}
	}

	// strip path information if it exists
	const char * filestr = strrchr(fileName,'/');
	path += "/";
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

	if(chmod(path.c_str(), S_IRWXU | S_IRWXG | S_IRWXO) < 0)
	{
		return false;
	}
	
	fileList.add (fileName, path, loadKind);

	return true;
}

bool UnloadFile(const char *fileName, FileList& fileList, std::string& strErr)
{
	int result = 1;
	int i= 0;

	OEFileInfo *file = FindFile (fileName, fileList);

	if (file == NULL)
	{
		strErr = "UnloadFile failed to find passed-in fileName";
		return false;
	}

	do
	{
		if( result)
		{
			sleep(1);
		}
		result = remove( file->strLocalFilename.c_str()); // 0 == success
		++i;
	}
	while( result && (i < 3));

	if( result) // could not delete file
	{
		strErr = "UnloadFile failed to delete file";
		return false;
	}

	size_t found = file->strLocalFilename.rfind( "/" );
	if( found != std::string::npos) {
		std::string path = file->strLocalFilename.substr( 0, found );
		// rmdir() only removes a directory that is empty.
		rmdir( path.c_str() );
		rmdir("tmp/");
	}

	// Erase file from list
	fileList.remove (fileName);

	return true;
}

// End-Of-File
//------------------------------------------------------------------------------
