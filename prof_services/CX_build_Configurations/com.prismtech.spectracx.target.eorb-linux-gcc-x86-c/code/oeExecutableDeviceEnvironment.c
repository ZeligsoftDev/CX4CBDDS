#ifndef _GNU_SOURCE
#define _GNU_SOURCE /* needed in order to get RTLD_DEFAULT for dlsym */
#endif

#include "oeExecutableDeviceEnvironment.h"
#include <dlfcn.h>
#include <errno.h>
#include <malloc.h>
#include <pthread.h>
#include <stdlib.h>
#include "oeUtil.h"

OEFileInfo * OE_sequence_OEFileInfo_find( const OE_sequence_OEFileInfo * seq, const char * filename )
{
    CORBA_unsigned_long i = 0;
    if( ! seq || ! seq->_buffer ) {
        return NULL;
    }

    for( i = 0; i < seq->_length; ++i ) {
        if( ! strcmp( filename, seq->_buffer[i].filename ) ) {
            return &seq->_buffer[i];
        }
    }

    return NULL;
}

CORBA_boolean OE_sequence_OEFileInfo_insert( OE_sequence_OEFileInfo * seq, char * filename, char * localFilename, CF_LoadableDevice_LoadType type, unsigned int refCount, void * module )
{
	CORBA_unsigned_long i = 0;
    if( ! seq )
        return FALSE;

    /* see if we can just replace an existing entry */
    if( seq->_buffer )
    {
        for( i = 0; i < seq->_length; ++i ) {
            if( !strcmp( filename, seq->_buffer[i].filename ) ) {
                if( seq->_buffer[i].filename ) {
                    CORBA_free( seq->_buffer[i].filename );
                }
                if( seq->_buffer[i].localFilename ) {
					CORBA_free( seq->_buffer[i].localFilename );
				}

                seq->_buffer[i].filename = CORBA_string_dup( filename);;
                seq->_buffer[i].localFilename = CORBA_string_dup( localFilename);
                seq->_buffer[i].type = type;
                seq->_buffer[i].refCount = refCount;
                seq->_buffer[i].module = module;
                return TRUE;
            }
        }
    }

    /* otherwise, append to the end of the sequence */
    if( ! seq->_buffer || seq->_length >= seq->_maximum ) {
        int new_max = seq->_buffer ? seq->_maximum * 2 : 4;
        OEFileInfo * new_buffer = OE_sequence_OEFileInfo_allocbuf( new_max );
        memcpy( new_buffer, seq->_buffer, sizeof( seq->_buffer ) * seq->_length );
        if( CORBA_sequence_get_release( seq ) ) {
        	CORBA_free( seq->_buffer );
        }
        seq->_buffer = new_buffer;
        seq->_maximum = new_max;
        CORBA_sequence_set_release( seq, TRUE );
    }

    seq->_buffer[seq->_length].filename = CORBA_string_dup( filename);
    seq->_buffer[seq->_length].localFilename = CORBA_string_dup( localFilename);
    seq->_buffer[seq->_length].type = type;
    seq->_buffer[seq->_length].refCount = refCount;
    seq->_buffer[seq->_length].module = module;
    ++seq->_length;

    return TRUE;
}

CORBA_boolean OE_sequence_OEFileInfo_remove( OE_sequence_OEFileInfo * seq, OEFileInfo * fileInfo )
{
	CORBA_unsigned_long index = 0;
    if( fileInfo < &seq->_buffer[0]
     || fileInfo > &seq->_buffer[seq->_length] )
        return FALSE;

    if( fileInfo->filename ) {
		CORBA_free( fileInfo->filename );
	}
	if( fileInfo->localFilename ) {
		CORBA_free( fileInfo->localFilename );
	}

	fileInfo->filename = NULL;
	fileInfo->localFilename = NULL;
	fileInfo->type = 0;
	fileInfo->refCount = 0;
	fileInfo->module = NULL;

    index = ( (unsigned long) fileInfo - (unsigned long) &seq->_buffer[0] ) / sizeof( seq->_buffer[0] );
    while( index < ( seq->_length - 1 ) ) {
        seq->_buffer[index] = seq->_buffer[index + 1];
        index++;
    }
    --seq->_length;
    return TRUE;
}


CORBA_boolean OEExecInfo_cmp( const OEExecInfo * lhs, const OEExecInfo * rhs )
{
    if( ! lhs )
        return rhs == NULL;
    else if( ! rhs )
        return FALSE;

    return lhs->id == rhs->id
        && lhs->loadKind == rhs->loadKind;
}

CORBA_boolean OE_sequence_OEExecInfo_push_back( OE_sequence_OEExecInfo * seq, CF_ExecutableDevice_ProcessID_Type id, CF_LoadableDevice_LoadType loadKind )
{
    if( seq->_length >= seq->_maximum )
    {
        int new_max = seq->_maximum == 0 ? 4 : ( seq->_maximum * 2 );
        OEExecInfo * new_buffer = OE_sequence_OEExecInfo_allocbuf( new_max );
        memcpy( new_buffer, seq->_buffer, sizeof( seq->_buffer ) * seq->_length );

        if( CORBA_sequence_get_release( seq ) ) {
        	CORBA_free( seq->_buffer );
		}
        seq->_buffer = new_buffer;
        seq->_maximum = new_max;
        CORBA_sequence_set_release( seq, TRUE );
    }

    seq->_buffer[seq->_length].id = id;
    seq->_buffer[seq->_length].loadKind = loadKind;
    ++seq->_length;
    return TRUE;
}

CORBA_boolean OE_sequence_OEExecInfo_remove( OE_sequence_OEExecInfo * seq, OEExecInfo * execInfo )
{
	CORBA_unsigned_long index = 0;

    if( execInfo < &seq->_buffer[0] || execInfo > &seq->_buffer[seq->_length] ) {
        return FALSE;
    }

    index = ( (unsigned long) execInfo - (unsigned long) &seq->_buffer[0] ) / sizeof( seq->_buffer[0] );
    while( index < ( seq->_length - 1 ) ) {
        seq->_buffer[index] = seq->_buffer[index + 1];
        index++;
    }
    --seq->_length;
    return TRUE;
}

/* entry point function pointer for shared library components */
typedef int (*entrypoint_func_t)( int, const char ** );

/* needed for pthread_create which only takes one argument */
typedef struct {
	entrypoint_func_t func;
	int argc;
	char** argv;
} argsStruct_t;

/* we need this helper function because pthread_create only takes one argument
 * static to limit it's scope to this file */
static void* pthread_create_helper(void* args)
{
	int i;
	argsStruct_t* _args = (argsStruct_t *) args;

	(*_args->func)(_args->argc, (const char**) _args->argv);

	for( i = 0; i < _args->argc; ++i ){
	    free( _args->argv[i] );
	}
	free( _args );

	return 0;
}

/* GetProcessId or ThreadId function prototype */
CORBA_boolean SpawnProcess(
        int argc,
        char ** argv,
        unsigned long stackSize,
        unsigned long priority,
        CF_ExecutableDevice_ProcessID_Type * id,
        OE_sequence_OEExecInfo * execInfoList,
        char * strErr )
{
	entrypoint_func_t entrypoint_func = NULL;
	struct stat st;
	CORBA_boolean fileLoaded = FALSE;
	CORBA_boolean libraryLoaded = FALSE;
	char ** new_argv = NULL;
	argsStruct_t * args = NULL;
	tid_type tid = -1;
	int i = 0;

	*id = -1;

	/* verify the file is loaded before it is executed */
	/* != 0 implies file does not exist */
	if( ! stat( argv[0], &st ) )
		fileLoaded = TRUE;
	else
	{
		char * error = NULL;
		dlerror();    /* Clear any existing error */
		entrypoint_func = (entrypoint_func_t) dlsym( RTLD_DEFAULT, argv[0] );
		error = dlerror();
		if( error != NULL )
		{
			static char fmt[] = "Could not find the address of the shared library entry point: %s";
			strErr = CORBA_string_alloc( ERROR_MSG_SIZE );
		    sprintf( strErr, fmt, error );
			return FALSE;
		}

		libraryLoaded = TRUE;
	}

	if( fileLoaded )
	{
		pid_type pid = -1;
		if( ( pid = fork() ) < 0 )
		{
			strErr = CORBA_string_dup( "Could not execute fork()" );
			return FALSE;
		}

		*id = (CF_ExecutableDevice_ProcessID_Type)pid;
		OE_sequence_OEExecInfo_push_back( execInfoList, *id, CF_LoadableDevice_EXECUTABLE );

		new_argv = malloc( sizeof( char * ) * ( argc + 1 ) );

		for( i = 0; i < argc; ++i )
			new_argv[i] = argv[i];
		new_argv[argc] = NULL;

		if( pid == 0
		 && execv( argv[0], new_argv ) == -1 )
			exit( EXIT_FAILURE );

		free( new_argv );
	}

	else if( libraryLoaded )
	{
		/* create thread */
		pthread_attr_t attr;
		int result = -1;

		if( pthread_attr_init( &attr ) != 0 )
		{
			strErr = CORBA_string_dup( "Could not initialize thread's attributes" );
			return FALSE;
		}

		pthread_attr_setinheritsched( &attr, PTHREAD_INHERIT_SCHED );
		if( stackSize > 0
		 && pthread_attr_setstacksize( &attr, stackSize ) != 0 )
		{
			strErr = CORBA_string_dup( "Could not set thread's stack size" );
			return FALSE;
		}

		if( priority > 0 )
		{
			struct sched_param schedParam;
			schedParam.sched_priority = priority;
			if( pthread_attr_setschedparam( &attr, &schedParam ) != 0 )
			{
				strErr = CORBA_string_dup( "Could not set thread's priority" );
				return FALSE;
			}
		}

		args = malloc( sizeof( argsStruct_t ) );
		args->func = entrypoint_func;
		args->argc = argc;
		args->argv = malloc( sizeof( char * ) * argc );

		for( i = 0; i < argc; ++i )
		{
			args->argv[i] = malloc( strlen( argv[i] ) + 1 );
			strcpy( args->argv[i], argv[i] );
		}

		result = pthread_create( &tid, &attr, pthread_create_helper, args );
		pthread_attr_destroy( &attr );

		if( result != 0 )
		{
			strErr = CORBA_string_dup( "Could not create pthread" );
			return FALSE;
		}

        *id = (CF_ExecutableDevice_ProcessID_Type)tid;
        OE_sequence_OEExecInfo_push_back( execInfoList, *id, CF_LoadableDevice_SHARED_LIBRARY );
	}
	else
	{
		strErr = CORBA_string_dup( "Unrecognized SCABinary type" );
		return FALSE;
	}

	return TRUE;
}

CORBA_boolean KillProcess( CF_ExecutableDevice_ProcessID_Type id, OE_sequence_OEExecInfo * execInfoList, char * strErr )
{
	CF_LoadableDevice_LoadType loadKind;
    OEExecInfo * execInfo = NULL;
    pid_t nRet = -1;
    CORBA_unsigned_long i = 0;

    for( i = 0; ! execInfo && i < execInfoList->_length; ++i ) {
        if( execInfoList->_buffer[i].id == id ) {
            execInfo = &execInfoList->_buffer[i];
        }
    }

	if( ! execInfo  )
	{
		strErr = CORBA_string_dup( "KillProcess failed to find passed-in process or thread id" );
		return FALSE;
	}

	/* Remove the process or thread info from the list */
	loadKind = execInfo->loadKind;
	OE_sequence_OEExecInfo_remove( execInfoList, execInfo );

    if( loadKind == CF_LoadableDevice_EXECUTABLE )
    {
		if( kill( (pid_type)id, SIGTERM ) != 0 )
		{
			strErr = CORBA_string_dup( "Could not send SIGTERM signal to process" );
			return FALSE;
		}

		/* check if process is terminated */
		nRet = waitpid( (pid_type)id, NULL, WNOHANG );
		if( nRet == -1 )
		{
			strErr = CORBA_string_dup( "Process did not change state" );
			return FALSE;
		}
	}
    else if( loadKind == CF_LoadableDevice_SHARED_LIBRARY )
    {
		if( pthread_kill( (tid_type)id, SIGTERM ) == 0 )
			return TRUE;

		/* thread not found. it may have terminated gracefully on releaseObject() */
		if(errno != ESRCH )
			return TRUE;
		else
		{
			strErr = CORBA_string_dup( "Could not send SIGTERM signal to thread" );
			return FALSE;
		}
	}
    else
    {
		strErr = CORBA_string_dup( "Unrecognized SCABinary type" );
		return FALSE;
	}

	return TRUE;
}

CORBA_boolean LoadFile( CF_FileSystem fs, char * fileName, const char * deviceId, CF_LoadableDevice_LoadType loadKind, OE_sequence_OEFileInfo * fileMap, char * strErr, CORBA_Environment * ev )
{
	FILE * pTmpFile = NULL;
	const char * strTmpPath = "tmp/";
	char * path = NULL;
	char * localFilename = NULL;
    CF_OctetSequence * buffer = NULL;
    const char * filestr = NULL;
    CF_File curFile = NULL;
	void * module = NULL;
	char * cptr = NULL;

	struct stat st;
 	if( stat( strTmpPath, &st ) == -1
	 && errno == ENOENT )
	{
		if( mkdir( strTmpPath, S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH ) != 0 )
		{
			strErr = CORBA_string_dup( "LoadFile failed to create directory" );
			free( path );
			return FALSE;
		}
	}
		
	path = malloc( strlen(strTmpPath) + strlen( deviceId ) + strlen("/") + 1 );
    sprintf( path, "%s%s%s", strTmpPath, deviceId, "/" );

    cptr = strstr( path, ":");
    if( cptr != NULL) {
    	*cptr = '_';
    }

 	if( stat( path, &st ) == -1
	 && errno == ENOENT )
	{
 		if( mkdir( path, S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH ) != 0 )
 		{
 			strErr = CORBA_string_dup( "LoadFile failed to create subdirectory" );
 			free( path );
 			return FALSE;
 		}
	}

	/* strip path information if it exists */
	filestr = strrchr( fileName, '/' );
	if( ! filestr )
	{
	    localFilename = malloc( strlen( path ) + strlen( fileName ) + 1 );
	    sprintf( localFilename, "%s%s", path, fileName );
	}
	else
	{
        localFilename = malloc( strlen( path ) + strlen( filestr ) );
        sprintf( localFilename, "%s%s", path, filestr + 1 );
	}
	pTmpFile = fopen( localFilename, "wb");
	if( ! pTmpFile )
	{
		strErr = CORBA_string_dup( "Could not open temporary file" );
		free( localFilename );
		free( path );
		return FALSE;
	}

    curFile = CF_FileSystem_open( fs, fileName, TRUE, ev );
	if( ev->_major != CORBA_NO_EXCEPTION )
	{
	    free( localFilename );
		free( path );
        fclose( pTmpFile );
        CORBA_exception_free( ev );
	    return FALSE;
	}

	if( CORBA_Object_is_nil( curFile, ev ) )
	{
		strErr = CORBA_string_dup( "Could not open the passed-in fileName" );
		free( localFilename );
		free( path );
		fclose( pTmpFile );
		CORBA_exception_free( ev );
		return FALSE;
	}

	do
	{
	    int iBufLen = 255;

	    CF_File_read( curFile, &buffer, iBufLen, ev );
	    if( ev->_major != CORBA_NO_EXCEPTION )
	    {
	    	if( strcmp (CORBA_exception_id (ev), ex_CF_File_IOException ))
	        {
	        	CORBA_Environment ignore;
	        	oe_bzero( &ignore, sizeof(ignore) );
				strErr = CORBA_string_dup( "Could not read from the passed-in fileName" );
	            CF_File_close( curFile, &ignore );
	            CORBA_exception_free( &ignore );
	            CORBA_Object_release( curFile, &ignore );
	        }

		    free( localFilename );
			free( path );
		    fclose( pTmpFile );
	        CORBA_exception_free( ev );
		    return FALSE;
        }

		fwrite( buffer->_buffer, sizeof( CORBA_octet ), buffer->_length, pTmpFile );
		CORBA_free( buffer );
	} while( buffer->_length > 0 );

	fclose(pTmpFile);
    CF_File_close( curFile, ev );
    if( ev->_major != CORBA_NO_EXCEPTION )
    {
        free( localFilename );
		free( path );
        CORBA_exception_free( ev );
        CORBA_Object_release( curFile, ev );
        return FALSE;
    }
    CORBA_Object_release( curFile, ev );
    if( ev->_major != CORBA_NO_EXCEPTION )
    {
        free( localFilename );
		free( path );
		CORBA_exception_free( ev );
        return FALSE;
    }

    CORBA_exception_free( ev );

	if( chmod( localFilename, S_IRWXU | S_IRWXG | S_IROTH | S_IWOTH ) != 0 )
	{
	    free( localFilename );
		free( path );
		return FALSE;
	}

	/* shared library */
	if( loadKind == CF_LoadableDevice_SHARED_LIBRARY )
	{
		module = dlopen( localFilename, RTLD_GLOBAL | RTLD_NOW );
		if( ! module )
		{
			strErr = CORBA_string_dup( "Could not dlopen the passed-in fileName" );
			free( localFilename );
			free( path );
			return FALSE;
		 }
	}

	if( ! OE_sequence_OEFileInfo_insert( fileMap, fileName, localFilename, loadKind, 1, module ) )
	{
		strErr = CORBA_string_dup( "Could not insert file information into fileMap" );
	    free( localFilename );
		free( path );
	    return FALSE;
	}

	free( localFilename );
	free( path );
	return TRUE;
}


CORBA_boolean UnloadFile( const char * fileName, OE_sequence_OEFileInfo * fileMap, char * strErr )
{
	CORBA_unsigned_long i = 0;
    CORBA_boolean result = FALSE;
    char * path = NULL;
    const char * filestr = NULL;
    unsigned long  length = 0;

	OEFileInfo * fileInfo = OE_sequence_OEFileInfo_find( fileMap, fileName );
	if( ! fileInfo )
	{
		strErr = CORBA_string_dup( "UnloadFile failed to find passed-in fileName" );
		return FALSE;
	}

    result = FALSE;
    for( i = 0; result == FALSE && i < 3; ++i )
	{
		if( fileInfo->type == CF_LoadableDevice_SHARED_LIBRARY
		 && fileInfo->module != NULL )
			dlclose( fileInfo->module );

		result = remove( fileInfo->localFilename ) == 0;

		if( result == FALSE ) {
			sleep( 1 );
		}
	}

	if( result == FALSE) /* could not delete file */
	{
		strErr = CORBA_string_dup( "UnloadFile failed to delete file" );
		return FALSE;
	}

	filestr = strrchr( fileInfo->localFilename, '/' );
	if( filestr )
	{
    	length = (unsigned long) filestr - (unsigned long) fileInfo->localFilename + 1;
    	path = malloc( length  );
    	strncpy( path, fileInfo->localFilename, length -1 );
		path[length - 1] = '\0';

		/* rmdir() only removes a directory that is empty. */
		rmdir( path );
		rmdir( "tmp/" );
		free( path );
	}
	return TRUE;
}
