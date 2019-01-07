#ifndef __OE_TARGET_LOADER_FUNCTIONS_H
#define __OE_TARGET_LOADER_FUNCTIONS_H

#include "oeOrbFunctions.h"
#include "oeTargetLoader.h"

#ifndef MAX_FILE_DESCRIPTORS
   #define MAX_FILE_DESCRIPTORS 255
#endif

#ifndef SYSTEM_PATH_SEPARATOR
   #define SYSTEM_PATH_SEPARATOR '/'
#endif

class LoadInfo
{
};

CORBA::String getHostName ();

CORBA::String getOSName ();

CORBA::String getOSVersion ();

CORBA::String getProcessorName ();

bool fs_exists (const char* path);

bool fs_mkdir (const char *path);

Target::FileSystem::FileType fs_getFileType (const char *path);

int fs_open (const char *path, bool read_only, bool create, bool truncate);

CORBA::LongLong fs_getFileSize (const char *path);

bool fs_setFilePointer (int fd, CORBA::ULong offset);

CORBA::LongLong fs_read (int fd, void *buffer, CORBA::ULong count);

CORBA::LongLong fs_write (int fd, const void *buffer, CORBA::ULong count);

bool fs_close (int fd);

bool fs_remove (const char * path);

bool fs_rmdir (const char *path, bool deleteContents);

bool fs_ls (const char *path, char** &contents, CORBA::ULong &size);

char* fs_getcwd ();

int exec (char **argv, char **options, const char *working_dir, LoadInfo *loadInfo);

bool terminate_process (int pid, const char *path, LoadInfo *loadInfo);

PortableServer::POA_ptr create_target_loader_poa (CORBA::ORB_ptr orb, int port, const char* poa_name OE_ENV_ARGN);

void register_process_termination_callback (Target::TargetLoader_ptr targetLoader);

#endif     // __OE_TARGET_LOADER_FUNCTIONS_H
