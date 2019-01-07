#ifndef __OE_LOGENVIRONMENT_H
#define __OE_LOGENVIRONMENT_H

// General operating environment includes
#include "oeOrbHeader.h"
#include "oePortTypes.h"

class LogEnvironment {
public:
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::UshortSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::UshortSequence& to);
};

#endif     // __OE_LOGENVIRONMENT_H
// End-Of-File
//------------------------------------------------------------------------------

