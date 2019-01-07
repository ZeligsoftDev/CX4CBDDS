#include "oeTargetLoaderFunctions.h"

#include <sys/utsname.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <errno.h>
#include <time.h>
#include <dirent.h>
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
	struct utsname uts;
	uname (&uts);

	return CORBA::string_dup (uts.sysname);
}

CORBA::String getOSVersion ()
{
	struct utsname uts;

	uname (&uts);

	return CORBA::string_dup (uts.release);
}

CORBA::String getProcessorName ()
{
	struct utsname uts;

	uname (&uts);

	return CORBA::string_dup (uts.machine);
}

bool fs_exists (const char* path)
{
	struct stat buf;
	return (stat (path, &buf) == 0);
}

bool fs_mkdir (const char *path)
{
	char *currentPath, *tmp, *saveptr, *token;

	if (fs_exists (path))
	{
		return false;
	}

	currentPath = new char[strlen (path) + 1];
	strcpy (currentPath, "");

	tmp = new char[strlen (path) + 1];
	strcpy (tmp, path);
	saveptr = NULL;

	token = strtok_r (tmp, "/", &saveptr);

	while (token)
	{
		strcat (currentPath, "/");
		strcat (currentPath, token);

		if (!fs_exists (currentPath))
		{
			if (mkdir (currentPath, S_IRWXU | S_IRWXG | S_IRWXO) != 0)
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
		token = strtok_r (NULL, "/", &saveptr);
	}

	delete [] currentPath;
	delete [] tmp;

	return true;
}

Target::FileSystem::FileType fs_getFileType (const char *path)
{
	struct stat buf;
	int res;

	res = stat (path, &buf);

	if (res != 0)
	{
		return Target::FileSystem::FILETYPE_UNKNOWN;
	}
	else if((S_IFDIR & buf.st_mode) != 0)
    {
		return Target::FileSystem::FILETYPE_DIRECTORY;
	}
	else
	{
		return Target::FileSystem::FILETYPE_PLAIN;
	}
}

int fs_open (const char *path, bool read_only, bool create, bool truncate)
{
	int oFlag;

	if (read_only)
	{
		oFlag = O_RDONLY;
	}
	else
	{
		oFlag = O_RDWR;
	}
	if (create)
	{
		oFlag = oFlag | O_CREAT;
	}
	if (truncate)
	{
		oFlag = oFlag | O_TRUNC;
	}

	return open (path, oFlag, S_IRWXU | S_IRWXG | S_IRWXO);
}

CORBA::LongLong fs_getFileSize (const char *path)
{
	struct stat buf;
	int res;

	res = stat (path, &buf);

	if (res != 0)
	{
		return -1;
	}
	else
	{
		return buf.st_size;
	}
}

bool fs_setFilePointer (int fd, CORBA::ULong offset)
{
	return lseek (fd, offset, SEEK_SET) == (off_t) offset;
}

CORBA::LongLong fs_read (int fd, void *buffer, CORBA::ULong count)
{
	return read (fd, buffer, count);
}

CORBA::LongLong fs_write (int fd, const void *buffer, CORBA::ULong count)
{
	return write (fd, buffer, count);
}

bool fs_close (int fd)
{
	return close (fd) == 0;
}

bool fs_remove (const char * path)
{
	return (remove (path) == 0);
}

bool fs_rmdir (const char *path, bool deleteContents)
{
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
					strcat (itemPath, "/");
					strcat (itemPath, contents[i]);

					type = fs_getFileType (itemPath);
					if (type == 0)
					{
						remove (itemPath);
					}
					else if (type == 1)
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
	return rmdir (path) == 0;
}

bool fs_ls (const char *path, char** &contents, CORBA::ULong &size)
{
	DIR *dir = opendir (path);

	if (dir != NULL)
	{
		struct dirent *entry;
		CORBA::ULong max = 25;
		contents = new char*[max];
		size = 0;

		while ((entry = readdir (dir)))
		{
			if (size >= max)
			{
				char** temp;

				max *= 2;
				temp = new char*[max];

				for (CORBA::ULong j = 0; j < size; j++)
				{
					temp[j] = contents[j];
				}
				delete [] contents;
				contents = temp;
			}

			contents[size] = new char[strlen (entry->d_name) + 1];
			strcpy (contents[size++], entry->d_name);
		}
		closedir (dir);
		return true;
	}
	return false;
}

char* fs_getcwd ()
{
	int cwdlen = 32;
	char *cwd = new char[cwdlen];
	while (getcwd (cwd, cwdlen) == 0)
	{
		delete [] cwd;
		cwdlen *= 2;
		cwd = new char[cwdlen];
	}
	return cwd;
}

int exec (char **argv, char **options, const char *working_dir, LoadInfo *loadInfo)
{
	int pid = fork ();

	if (pid == 0) // child process
	{
		chdir (working_dir);
		if (execv(argv[0], argv) == -1)
		{
			exit (EXIT_FAILURE);
		}
	}
	return pid;
}

bool terminate_process (int pid, const char *path, LoadInfo *loadInfo)
{
	pid_t nRet = 0;
	int status;

	do
	{
		nRet = waitpid (pid, &status, WNOHANG);
		if (nRet == pid)
		{
			// Child has gone
			return true;
		}
	}
	while (nRet == -1 && errno == EINTR);

	int signals[] =
	{
		SIGQUIT,
		SIGTERM,
		SIGKILL
	};

	for (int signal = 0; signal < 2; signal++)
	{
		if (kill (pid, signals[signal]) == -1)
		{
			if (errno == ESRCH)
			{
				return true;
			}
			else
			{
				continue;
			}
		}

		for (int pause = 8; pause < 32768; pause <<= 1)
		{
			nRet = waitpid (pid, &status, WNOHANG);

			if (nRet == pid)
			{
				return true;
			}
			else if (nRet == 0 || (nRet == -1 && errno == EINTR))
			{
				struct timespec wait;
				wait.tv_sec = pause / 1000;
				wait.tv_nsec = (pause % 1000) * 1000000;
				nanosleep (&wait, NULL);
			}
			else
			{
				return false;
			}
		}
	}
	return false;
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

		RTCORBA::TCPProtocolProperties_var tcp = RTCORBA::TCPProtocolProperties::create (0, 0, 0, 0, 0);
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
	OE_DECLARE_ENV;

	sem_wait (&shutdown_mutex);

	OE_TRY
	{
		((Target::TargetLoader_ptr) targetLoader)->shutdown(OE_ENV_VAR1);
		OE_CHECK_ENV;
	}
	OE_CATCH_ANY
	{
		std::cerr << "oeTargetLoaderFunctions : Caught exception during targetLoader->shutdown()." << std::endl;
		return NULL;
	}
	OE_END_TRY
	return NULL;
}

void sig_handler (int iSignal)
{
	sem_post (&shutdown_mutex);
	return; //Prevent default behaviour to occur
}

void register_process_termination_callback (const Target::TargetLoader_ptr targetLoader)
{
	sem_init (&shutdown_mutex, 0, 0);

	pthread_t thread;
	int rc = pthread_create (&thread, NULL, shutdown_thread, (void *) targetLoader);

	if (rc == 0)
	{
		struct sigaction sa;
		bzero((char *) &sa, sizeof (sa));
#ifdef SCX_OLD_SIGNAL_H
		sa.sa_handler = (void(*)(_MATCH_ALL)) sig_handler;
#else
		sa.sa_handler = sig_handler;
#endif
		sigfillset(&(sa.sa_mask));
		sa.sa_flags = 0;
		sigaction(SIGABRT, &sa, NULL);
		sigaction(SIGHUP, &sa, NULL);
		sigaction(SIGINT, &sa, NULL);
		sigaction(SIGQUIT, &sa, NULL);
		sigaction(SIGTERM, &sa, NULL);
	}
	else
	{
		std::cerr << "oeTargetLoaderFunctions : Failed to create shutdown thread." << std::endl;
	}
}
