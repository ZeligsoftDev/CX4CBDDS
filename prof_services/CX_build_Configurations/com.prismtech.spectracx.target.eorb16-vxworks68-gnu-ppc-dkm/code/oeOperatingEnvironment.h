#ifndef __OE_OPERATINGENVIRONMENT_H
#define __OE_OPERATINGENVIRONMENT_H


#if defined(OS_WIN32)
//use STL without warnings
#pragma warning(disable:4786)
#endif

// General operating environment includes
#include <string>
#include <set>
#include <map>

// Includes for the SCA
#include "CF.h"
#include "PortTypes.h"
#include "oeOrbHeader.h"
#include "oeCorbaExceptionMacros.h"

// Includes for thread handling
#include "Mutex.h"

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

void register_process_termination_callback ();

class OperatingEnvironment
{
	public :
		static CORBA::ORB_var orb_;
		static oeStatus status;

		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::BooleanSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::CharSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::DoubleSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::FloatSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::ShortSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::LongSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, CF::OctetSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, CF::StringSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::UlongSequence& to);
		static CORBA::Boolean AnyToSequence(const CORBA::Any& any, PortTypes::UshortSequence& to);

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

void convert_set_to_string(std::set<std::string>::iterator begin, std::set<std::string>::iterator end, std::string& result);

void convert_map_to_string(std::map<std::string, std::string>::iterator begin, std::map<std::string, std::string>::iterator end, std::string& result);

int str_case_cmp(const char* str1, const char* str2);

void exception_to_string(const CORBA::Exception& e, std::string& exString);


#endif     // __OE_OPERATINGENVIRONMENT_H

// End-Of-File
//------------------------------------------------------------------------------
