#include "oeTargetLoaderFunctions.h"

#include <sys/stat.h>
#include <sysLib.h>
#include <sigLib.h>
#include <rebootLib.h>
#include <loadLib.h>
#include <unldLib.h>
#include <dirent.h>
#include <version.h>
#include "eOrb/RTCORBA/Protocol.h"
#include "eOrb/RTCORBA/ServerProtocolPolicy.h"
#include "eOrb/RTCORBA/TCPProtocolProperties.h"

#ifndef HOST_NAME_MAX
   #define HOST_NAME_MAX 255
#endif

static SEM_ID shutdown_sepahore;

int callInitOrFini (const char *file, void *libHandle, char *extName, void **sym_ptr)
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

void callConstructor (const char *fileName, void *libHandle)
{
   void *sym_ptr;
   int result = 0;
   result = callInitOrFini (fileName, libHandle, "__init", &sym_ptr);

   if (result == 0)
   {
      ((init_lib_func_t) sym_ptr) ();
   }
}

void callDestructor (const char *fileName, void *libHandle)
{
   void *sym_ptr;
   int result = 0;
   result = callInitOrFini (fileName, libHandle, "__fini", &sym_ptr);

   if (result == 0)
   {
      ((fini_lib_func_t) sym_ptr) ();
   }
}

LoadInfo::LoadInfo ()
{
	int i;
	size = 16;
	modules = new ModuleState*[size];

	for (i = 0; i < size; i++)
	{
		modules[i] = NULL;
	}
}

LoadInfo::~LoadInfo ()
{
	int i;
	for (i = 0; i < size; i++)
	{
		if (modules[i] != NULL)
		{
			unld (i);
		}
	}
	delete [] modules;
}

int LoadInfo::isLoaded (const char *file)
{
	int i;
	for (i = 0; i < size; i++)
	{
		if (modules[i] != NULL)
		{
			if (strcmp (modules[i]->file, file) == 0)
			{
				return i;
			}
		}
	}
	return -1;
}

bool LoadInfo::load (const char *file)
{
	int i = isLoaded (file);

	if (i == -1)
	{
		for (i = 0; i < size; i++)
		{
			if (modules[i] == NULL)
			{
				break;
			}
		}

		if (i == size)
		{
			int j;
			ModuleState **tmp = new ModuleState*[size * 2];

			for (j = 0; j < size; j++)
			{
				tmp[j] = modules[j];
			}

			size *=2;
			delete [] modules;
			modules = tmp;

			while (j < size)
			{
				modules[j] = NULL;
			}
		}
		return loadModule (i, file);
	}
	else
	{
		modules[i]->loadCount++;
		return true;
	}
}

bool LoadInfo::unload (const char *file)
{
	int i = isLoaded (file);

	if (i == -1)
	{
		return false;
	}
	else
	{
		modules[i]->loadCount--;
		if (modules[i]->loadCount == 0)
		{
			return unld (i);
		}
		return true;
	}
}

bool LoadInfo::loadModule (int i, const char *file)
{
	int fd;
	fd = open (file, O_RDONLY, 0);	// Check

	if (fd == 0)
	{
		return false;
	}

	MODULE_ID mid = ::loadModule (fd, LOAD_ALL_SYMBOLS);
	close (fd);

	if (mid == 0)
	{
		return false;
	}

	callConstructor (file, mid);

	modules[i] = new ModuleState;
	modules[i]->file = new char[strlen (file) + 1];
	strcpy (modules[i]->file, file);
	modules[i]->loadCount = 1;
	modules[i]->mid = mid;

	return true;
}

bool LoadInfo::unld (int i)
{
	callDestructor (modules[i]->file, modules[i]->mid);

	STATUS result = ::unld (modules[i]->mid, 0);

	if (result == OK)
	{
		delete [] modules[i]->file;
		delete modules[i];
		modules[i] = NULL;
		return true;
	}
	return false;
}

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
	return CORBA::string_dup (RUNTIME_NAME);
}

CORBA::String getOSVersion ()
{
	return CORBA::string_dup (RUNTIME_VERSION);
}

CORBA::String getProcessorName ()
{
	return CORBA::string_dup ("Unknown");
}

bool fs_exists (const char* path)
{
	char* tmp = new char[strlen (path) + 1];
	strcpy (tmp, path);
	struct stat buf;
	bool result = stat (tmp, &buf) == 0;
	delete [] tmp;
	return result;
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
			if (mkdir (currentPath) != 0)
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
	char* tmp = new char[strlen (path) + 1];
	strcpy (tmp, path);
	struct stat buf;
	int res;

	res = stat (tmp, &buf);
	delete [] tmp;

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

	// Open should fail if path is not a plain file
	if (fs_getFileType (path) == Target::FileSystem::FILETYPE_DIRECTORY)
	{
		return -1;
	}

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
	char* tmp = new char[strlen (path) + 1];
	strcpy (tmp, path);
	struct stat buf;
	int res;

	res = stat (tmp, &buf);
	delete [] tmp;

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
	return read (fd, (char *) buffer, count);
}

CORBA::LongLong fs_write (int fd, const void *buffer, CORBA::ULong count)
{
	int res = write (fd, (char *) buffer, count);
	ioctl (fd, FIOSYNC, 0);
	return res;
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
	char* tmp = new char[strlen (path) + 1];
	strcpy (tmp, path);
	DIR *dir = opendir (tmp);
	delete [] tmp;

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
	// Check entry point specified
	char *entrypoint = NULL;
	int i, pid, argc;
	extern SYMTAB_ID sysSymTbl;
	SYM_TYPE type;
	char *address;

	for (i = 0; options[i] != NULL; i++)
	{
		if (strcmp (options[i], Target::Session::ENTRY_POINT_OPTION) == 0)
		{
			if (options[i + 1] != NULL)
			{
				entrypoint = new char [strlen (options[i + 1]) + 1];
				strcpy (entrypoint, options[i + 1]);
			}
			break;
		}
	}

	if (entrypoint == NULL)
	{
		return -1;
	}

	argc = 0;
	while (argv[argc] != NULL)
	{
		argc++;
	}

	if (loadInfo->load (argv[0]) == false)
	{
		delete [] entrypoint;
		return -1;
	}

	if (symFindByName(sysSymTbl, entrypoint, &address, &type) == OK)
	{
		char **new_argv;

		new_argv = new char*[argc + 1];

		for (i = 0; i < argc; i++)
		{
			new_argv[i] = new char[strlen(argv[i]) + 1];
			strcpy(new_argv[i], argv[i]);
		}
		new_argv[argc] = 0;

		delete[] entrypoint;
		pid = sp((FUNCPTR) address, argc, (int) new_argv, 0, 0, 0, 0, 0, 0, 0);

		if (pid > 0)
		{
			return pid;
		}
		else
		{
			for (i = 0; new_argv[i] != 0; i++)
			{
				delete [] new_argv[i];
			}
			delete [] new_argv;
		}
	}
	else
	{
		delete [] entrypoint;
	}
	return -1;
}

bool terminate_process (int pid, const char *path, LoadInfo *loadInfo)
{
	STATUS nRet = 0;
	int status, pause;

	nRet = taskIdVerify (pid);
	if (nRet == ERROR)
	{
		// task has gone
		return loadInfo->unload(path);
	}

	if (kill (pid, SIGQUIT) == OK)
	{
		for (pause = 8; pause < 32768; pause <<= 1)
		{
			nRet = taskIdVerify (pid);

			if (nRet == ERROR)
			{
				// task has gone
				return loadInfo->unload(path);
			}
			else
			{
				struct timespec wait;
				wait.tv_sec = pause / 1000;
				wait.tv_nsec = (pause % 1000) * 1000000;
				nanosleep (&wait, NULL);
			}
		}
	}

	if (taskDelete (pid) == OK)
	{
		return loadInfo->unload(path);
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
	OE_DECLARE_ENV;

	semTake (shutdown_sepahore, WAIT_FOREVER);

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
	semGive (shutdown_sepahore);
	return; //Prevent default behaviour to occur
}

void oe_bzero (void* p, size_t s)
{
   size_t size;
   char * ptr = (char*) (p);
   for (size = 0; size++ < (s); *ptr++ = 0);
}

void register_process_termination_callback (const Target::TargetLoader_ptr targetLoader)
{
	shutdown_sepahore = semBCreate (SEM_Q_PRIORITY, SEM_EMPTY);

	pthread_t thread;
	int rc = pthread_create (&thread, NULL, shutdown_thread, (void *) targetLoader);

	if (rc == 0)
	{
		struct sigaction sa;
		oe_bzero(&sa, sizeof (sa));
		sa.sa_handler = sig_handler;
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
