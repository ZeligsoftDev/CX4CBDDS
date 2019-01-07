#ifndef OE_RESOURCE_FACTORY_ENVIRONMENT_H
#define OE_RESOURCE_FACTORY_ENVIRONMENT_H

#include "CF.h"
#include "eOrbC/CORBA.h"
#include "eOrbC/PortableServer.h"
#include "eOrbC/CORBA/sequence.h"
#include "eOrbC/EORB/alloc.h"
#include <string.h>

#ifndef ERROR_MSG_SIZE
#define ERROR_MSG_SIZE 1024
#endif

typedef struct
{
	char         * resourceId;
	char		 * resourceType;
	unsigned int   refCount;
	PortableServer_Servant    resourceServant;
} OEResourceInfo;

typedef struct
{
    CORBA_unsigned_long _maximum;
    CORBA_unsigned_long _length;
    OEResourceInfo   * _buffer;
    CORBA_boolean       _release;
} OE_sequence_OEResourceInfo;

#define OE_sequence_OEResourceInfo__alloc \
   ( (OE_sequence_OEResourceInfo *)EORB_allocVar( EORB_seqFree, sizeof( OE_sequence_OEResourceInfo ) ) )
#define OE_sequence_OEResourceInfo_allocbuf( L ) \
   ( (OEResourceInfo *)EORB_allocBuffer( (EORB_DtorFN)NULL, sizeof( OEResourceInfo ), L ) )

extern OEResourceInfo * OE_sequence_OEResourceInfo_find( OE_sequence_OEResourceInfo * seq, char * resourceId );
extern CORBA_boolean     OE_sequence_OEResourceInfo_insert( OE_sequence_OEResourceInfo * seq, char * resourceId,  char * resourceType, PortableServer_Servant  resourceServant, CORBA_Environment * ev );
extern CORBA_boolean     OE_sequence_OEResourceInfo_remove( OE_sequence_OEResourceInfo * seq, OEResourceInfo * resourceInfo );
extern CORBA_boolean     OE_sequence_OEResourceInfo_clearMem( OE_sequence_OEResourceInfo * seq );


#endif
