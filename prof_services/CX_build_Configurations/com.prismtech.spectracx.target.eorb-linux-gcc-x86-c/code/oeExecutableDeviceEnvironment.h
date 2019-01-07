
#ifndef OE_EXECUTABLE_DEVICE_ENVIRONMENT_H
#define OE_EXECUTABLE_DEVICE_ENVIRONMENT_H

#include "oeCFExecutableDevice.h"
#include "eOrbC/CORBA.h"
#include "eOrbC/CORBA/sequence.h"
#include "eOrbC/EORB/alloc.h"
#include <string.h>
#include <sys/wait.h>
#include <sys/stat.h>

#define ERROR_MSG_SIZE 1024

typedef struct
{
	char * filename;
	char * localFilename;
	CF_LoadableDevice_LoadType type;
	unsigned int refCount;
	void * module;
} OEFileInfo;

typedef struct
{
    CORBA_unsigned_long _maximum;
    CORBA_unsigned_long _length;
    OEFileInfo * _buffer;
    CORBA_boolean _release;
} OE_sequence_OEFileInfo;

#define OE_sequence_OEFileInfo__alloc \
   ( (OE_sequence_OEFileInfo *)EORB_allocVar( EORB_seqFree, sizeof( OE_sequence_OEFileInfo ) ) )
#define OE_sequence_OEFileInfo_allocbuf( L ) \
   ( (OEFileInfo *)EORB_allocBuffer( (EORB_DtorFN)NULL, sizeof( OEFileInfo ), L ) )

extern OEFileInfo * OE_sequence_OEFileInfo_find( const OE_sequence_OEFileInfo * seq, const char * filename );
extern CORBA_boolean OE_sequence_OEFileInfo_insert( OE_sequence_OEFileInfo * seq, char * filename, char * localFilename, CF_LoadableDevice_LoadType type, unsigned int refCount, void * module );
extern CORBA_boolean OE_sequence_OEFileInfo_remove( OE_sequence_OEFileInfo * seq, OEFileInfo * fileInfo );

typedef pid_t pid_type;
typedef pthread_t tid_type;

typedef struct
{
	CF_ExecutableDevice_ProcessID_Type id;
	CF_LoadableDevice_LoadType loadKind;
} OEExecInfo;

extern CORBA_boolean OEExecInfo_cmp( const OEExecInfo * lhs, const OEExecInfo * rhs );

typedef struct
{
    CORBA_unsigned_long _maximum;
    CORBA_unsigned_long _length;
    OEExecInfo * _buffer;
    CORBA_boolean _release;
} OE_sequence_OEExecInfo;

extern CORBA_boolean OE_sequence_OEExecInfo_push_back( OE_sequence_OEExecInfo * seq, CF_ExecutableDevice_ProcessID_Type id, CF_LoadableDevice_LoadType loadKind );
extern CORBA_boolean OE_sequence_OEExecInfo_remove( OE_sequence_OEExecInfo * seq, OEExecInfo * execInfo );

#define OE_sequence_OEExecInfo__alloc \
   ( (OE_sequence_OEExecInfo *)EORB_allocVar( EORB_seqFree, sizeof( OE_sequence_OEExecInfo ) ) )
#define OE_sequence_OEExecInfo_allocbuf( L ) \
   ( (OEExecInfo *)EORB_allocBuffer( (EORB_DtorFN)NULL, sizeof( OEExecInfo ), L ) )

/* Provides boolean of what LoadType is supported */
#define IS_SUPPORTED_LOADTYPE( type ) ( ( type ) == CF_LoadableDevice_EXECUTABLE || ( type ) == CF_LoadableDevice_SHARED_LIBRARY )

/* Spawn a new process */
extern CORBA_boolean SpawnProcess( int argc, char ** argv, unsigned long ulStackSize, unsigned long ulPriority, CF_ExecutableDevice_ProcessID_Type * id, OE_sequence_OEExecInfo * execInfoList, char * strErr );

/* Kill a running process */
extern CORBA_boolean KillProcess( CF_ExecutableDevice_ProcessID_Type id, OE_sequence_OEExecInfo * execInfoList, char * strErr );

/* Platform dependent load */
extern CORBA_boolean LoadFile( CF_FileSystem fs, char * fileName, const char* deviceId, CF_LoadableDevice_LoadType loadKind, OE_sequence_OEFileInfo * fileMap, char * strErr, CORBA_Environment * ev );

/* Platform dependent unload */
extern CORBA_boolean UnloadFile( const char *fileName, OE_sequence_OEFileInfo * fileMap, char * strErr );

#endif
