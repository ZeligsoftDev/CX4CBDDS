#include "oeLogEnvironment.h"
#include "oeCosLwLogStatus.h"

// extracts from Any and converts the CosLwLog::LogLevelSequence to a PortTypes::UshortSequence
CORBA::Boolean LogEnvironment::AnyToSequence(const CORBA::Any& any, PortTypes::UshortSequence& to) {
	CosLwLog::LogLevelSequence* lls = 0;

	if(any >>= lls)
	{
		to.length(lls->length());
		for(unsigned long j = 0; j < to.length(); j++)
		{
			to[j] = (CORBA::UShort) lls->operator[] (j);
		}
		return true;
	}
	return false;
}

// converts a PortTypes::UshortSequence to a CosLwLog::LogLevelSequence and inserts into Any
void LogEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::UshortSequence& from) {
	CosLwLog::LogLevelSequence lls;

	lls.length(from.length());
	for(unsigned long j = 0; j < from.length(); j++)
	{
		lls[j] = (CosLwLog::LogLevel) from[j];
	}

	any <<= lls;
}

// End-Of-File
//------------------------------------------------------------------------------

