#include "oeOperatingEnvironment.h"

oeStatus OperatingEnvironment::status = OE_STATUS_NONE;

CORBA::ORB_var OperatingEnvironment::orb_ = CORBA::ORB::_nil();

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any, PortTypes::BooleanSequence& to)
{
	PortTypes::BooleanSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::CharSequence& to) {
	PortTypes::CharSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::DoubleSequence& to) {
	PortTypes::DoubleSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::FloatSequence& to) {
	PortTypes::FloatSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::ShortSequence& to) {
	PortTypes::ShortSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::LongSequence& to) {
	PortTypes::LongSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		CF::OctetSequence& to) {
	CF::OctetSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		CF::StringSequence& to) {
	CF::StringSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::UlongSequence& to) {
	PortTypes::UlongSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

CORBA::Boolean OperatingEnvironment::AnyToSequence(const CORBA::Any& any,
		PortTypes::UshortSequence& to) {
	PortTypes::UshortSequence *ptr = 0;

	if (any >>= ptr)
	{
		to = *ptr;
		return true;
	}

	return false;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::BooleanSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::CharSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::DoubleSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::FloatSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::ShortSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::LongSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, CF::OctetSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, CF::StringSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::UlongSequence& from)
{
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any, PortTypes::UshortSequence& from)
{
	any <<= from;
}

std::string IfIsDCEUUIDConvertToUpper( std::string candidate)
{
	if (candidate.length()!=40)
	{
		return candidate;
	}

	for (unsigned int i = 0; i < candidate.length(); i+=1)
	{
		if (i==0 && candidate[i]!='D')
		{
			return candidate;
		}
		else if (i==0 && candidate[i]=='D')
		{
			continue;
		}
		else if (i==1 && candidate[i]!='C')
		{
			return candidate;
		}
		else if (i==1 && candidate[i]=='C')
		{
			continue;
		}
		else if (i==2 && candidate[i]!='E')
		{
			return candidate;
		}
		else if (i==2 && candidate[i]=='E')
		{
			continue;
		}
		else if (i==3 && candidate[i]!=':')
		{
			return candidate;
		}
		else if (i==3 && candidate[i]==':')
		{
			continue;
		}
		else if ( (i==12 || i==17 || i ==22 || i==27) && candidate[i]!='-')
		{
			return candidate;
		}
		else if ( (i==12 || i==17 || i ==22 || i==27) && candidate[i]=='-')
		{
			continue;
		}
		else
		{
			char c = candidate[i];
			switch (c)
			{
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			{
				break;
			}
			default:
			{
				return candidate;
			}
			}
		}
	}

	std::string newstring = candidate;
	for (unsigned int j=0; j<newstring.length(); ++j)
	{
		newstring[j] = (char) toupper(newstring[j]);
	}

	return newstring;
}


void convert_set_to_string(std::set<std::string>::iterator begin, std::set<std::string>::iterator end, std::string& result)
{
	result += "{";

	for(std::set<std::string>::iterator p = begin; p != end; ++p)
	{
		if(p != begin) result += ", ";
		result += *p;
	}

	result += "}";
}

void convert_map_to_string(std::map<std::string, std::string>::iterator begin, std::map<std::string, std::string>::iterator end, std::string& result)
{
	result += "{";

	for(std::map<std::string, std::string>::iterator p = begin; p != end; ++p)
	{
		if(p != begin) result += ", ";
		result += "(" + p->first + ", " + p->second + ")";
	}

	result += "}";
}

int str_case_cmp(const char* str1, const char* str2)
{
	const char *char1 = str1, *char2 = str2;

	while((*char1 != '\0') && (tolower((int)(*char1)) == tolower((int)(*char2))))
	{
		++char1;
		++char2;
	}

	return tolower(*char1) - tolower(*char2);
}

void exception_to_string(const CORBA::Exception& e, std::string& exString)
{
	exString = e._name();
}

void shutdown_component(CORBA::ORB_var orb, PortableServer::Servant component, bool wait OE_ENV_ARGN)
{
}

CORBA::ORB_var init_orb(int argc, const char * argv[] OE_ENV_ARGN)
{
	return get_orb();
}

CORBA::ORB_var get_orb()
{
	if (CORBA::is_nil (OperatingEnvironment::orb_))
	{
		int newArgc = 0;
		char ** newArgv = NULL;
		OperatingEnvironment::orb_ = CORBA::ORB_init (newArgc, newArgv);
	}
	return OperatingEnvironment::orb_;
}

bool activate_component(CORBA::ORB_var orb, PortableServer::Servant servant OE_ENV_ARGN)
{
	CORBA::Object_var tempobj = orb->resolve_initial_references("RootPOA" OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	PortableServer::POA_var rootpoa = PortableServer::POA::_narrow(tempobj OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);
	if(CORBA::is_nil(rootpoa ))
	{
		std::cerr << "Failed to narrow the POA.";
		return false;
	}

	PortableServer::ObjectId_var oid = rootpoa->activate_object(servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	return true;
}

void deactivate_component(PortableServer::Servant servant OE_ENV_ARGN)
{
	PortableServer::POA_var poa = servant->_default_POA();
	PortableServer::ObjectId_var oid = poa->servant_to_id(servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN_VOID;
	poa->deactivate_object(oid.in() OE_ENV_VARN);
	OE_CHECK_ENV_RETURN_VOID;
}

bool register_with_naming_service (CORBA::ORB_var orb, const char* naming_context_ior, const char* name_binding,
		CORBA::Object_var component OE_ENV_ARGN)
{
	CORBA::Object_var obj = orb->string_to_object(naming_context_ior OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);
	if(CORBA::is_nil(obj))
	{
		std::cerr << "Failed to resolve the naming context.";
		return false;
	}
	CosNaming::NamingContext_var nc = CosNaming::NamingContext::_narrow(obj OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);
	if(CORBA::is_nil(nc))
	{
		std::cerr << "Failed to narrow the naming context.";
		return false;
	}
	CosNaming::Name name;
	name.length(1);
	name[0].id = CORBA::string_dup(name_binding);
	nc->rebind(name, component OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);
	return true;
}

void register_process_termination_callback ()
{
	// do nothing
}

// End-Of-File
//------------------------------------------------------------------------------
