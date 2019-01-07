#include "oeResourceFactoryEnvironment.h"
#include "oeUtil.h"

OEResourceInfo * OE_sequence_OEResourceInfo_find( OE_sequence_OEResourceInfo * seq, char * resourceId )
{
    CORBA_unsigned_long i;

	if( ! seq || ! seq->_buffer ) {
        return NULL;
    }

    for( i = 0; i < seq->_length; ++i ) {
        if( oe_strcasecmp( resourceId, seq->_buffer[i].resourceId ) == 0 ) {
            return &seq->_buffer[i];
        }
    }

    return NULL;
}

CORBA_boolean     OE_sequence_OEResourceInfo_insert( OE_sequence_OEResourceInfo * seq, char * resourceId, char * resourceType, PortableServer_Servant  resourceServant, CORBA_Environment * ev )
{
    if( ! seq ) {
        return FALSE;
	}
    /* see if we can just find an existing entry */
    if( seq->_buffer ) {
    	CORBA_unsigned_long i;
        for( i = 0; i < seq->_length; ++i ) {
            if( oe_strcasecmp( resourceId, seq->_buffer[i].resourceId ) == 0 ) {
                seq->_buffer[i].refCount ++;
                return TRUE;
            }
        }
    }

    /* otherwise, append to the end of the sequence */
    if( ! seq->_buffer || seq->_length >= seq->_maximum ) {
        int new_max = seq->_buffer ? seq->_maximum * 2 : 4;
        OEResourceInfo * new_buffer = OE_sequence_OEResourceInfo_allocbuf( new_max );
        memcpy( new_buffer, seq->_buffer, sizeof( seq->_buffer ) * seq->_length );
        if( CORBA_sequence_get_release( seq ) ) {
        	CORBA_free( seq->_buffer );
        }
        seq->_buffer = new_buffer;
        seq->_maximum = new_max;
        CORBA_sequence_set_release( seq, TRUE );
    }

    seq->_buffer[seq->_length].resourceId = CORBA_string_dup( resourceId );
    seq->_buffer[seq->_length].resourceType = CORBA_string_dup( resourceType );

    if (resourceServant != NULL) {
        CORBA_exception_free( ev );
		seq->_buffer[seq->_length].resourceServant = resourceServant;

		if (ev->_major != CORBA_NO_EXCEPTION) {
		    CORBA_exception_free( ev );
			return FALSE;
		}
		(seq->_buffer[seq->_length].refCount) ++;
		++seq->_length;
		return TRUE;
	}

    return FALSE;
}

CORBA_boolean  OE_sequence_OEResourceInfo_remove( OE_sequence_OEResourceInfo * seq, OEResourceInfo * resourceInfo )
{
	CORBA_unsigned_long index = 0;

	if( resourceInfo < &seq->_buffer[0]
     || resourceInfo > &seq->_buffer[seq->_length] ){
        return FALSE;
    }

    index = ( (unsigned long) resourceInfo - (unsigned long) &seq->_buffer[0] ) / sizeof( seq->_buffer[0] );
    while( index < ( seq->_length - 1 ) ) {
    	seq->_buffer[index] = seq->_buffer[index + 1];
    	index++;
    }

    --seq->_length;

    return TRUE;

}


CORBA_boolean  OE_sequence_OEResourceInfo_clearMem( OE_sequence_OEResourceInfo * seq )
{
	if( ! seq ) {
		return FALSE;
	}

    if( CORBA_sequence_get_release( seq ) ) {
     	CORBA_free( seq->_buffer );
     	seq->_buffer = NULL;
     	seq->_maximum = 0;
     	seq->_length = 0;
     	return TRUE;
    }

    return FALSE;
}
