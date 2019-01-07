#ifndef __OE_OPERATING_ENVIRONMENT_H
#define __OE_OPERATING_ENVIRONMENT_H

// Includes for the SCA
#include "CF.h"
#include "PortTypes.h"
#include "oeOrbHeader.h"
#include "oeCorbaExceptionMacros.h"

// General operating environment includes
#include <windows.h>
#include <string>

// Includes for thread handling
#include "Mutex.h"

using namespace std;

#ifndef NULL
	#define NULL 0
#endif

enum oeStatus {
	OE_STATUS_NONE = -1,
	OE_STATUS_RUNNING = 0,
	OE_STATUS_SHUTTINGDOWN = 1,
	OE_STATUS_FINISHED = 2
};

void shutdown_component(CORBA::ORB_var orb, PortableServer::Servant component, bool wait OE_ENV_ARGN);

CORBA::ORB_var init_orb(int argc, const char * argv[] OE_ENV_ARGN);

bool activate_component(CORBA::ORB_var orb, PortableServer::Servant servant OE_ENV_ARGN);

void deactivate_component(PortableServer::Servant servant OE_ENV_ARGN);

bool register_with_naming_service (CORBA::ORB_var orb, const char* ior, const char* name_binding,
		CORBA::Object_var component OE_ENV_ARGN);

CORBA::ORB_var get_orb();

class OperatingEnvironment {
public :
	static CORBA::ORB_var orb_;

	static oeStatus status;

	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::BooleanSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::CharSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::DoubleSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::FloatSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::ShortSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::LongSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			CF::OctetSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			CF::StringSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::UlongSequence& to);
	static CORBA::Boolean AnyToSequence(const CORBA::Any& any,
			PortTypes::UshortSequence& to);

	static void AnyFromSequence(CORBA::Any& any, PortTypes::BooleanSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::CharSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::DoubleSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::FloatSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::ShortSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::LongSequence& to);
	static void AnyFromSequence(CORBA::Any& any, CF::OctetSequence& to);
	static void AnyFromSequence(CORBA::Any& any, CF::StringSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::UlongSequence& to);
	static void AnyFromSequence(CORBA::Any& any, PortTypes::UshortSequence& to);
};

std::string IfIsDCEUUIDConvertToUpper( std::string candidate);

int str_case_cmp(const char* str1, const char* str2);

void oe_bzero (void* p, size_t s);

void* shutdown_thread(void* data);

//Set the callback handler that will capture when the process is manually being killed
bool CtrlHandler( DWORD fdwCtrlType );

void register_process_termination_callback ();

#endif     // __OE_OPERATING_ENVIRONMENT_H

// End-Of-File
//------------------------------------------------------------------------------
