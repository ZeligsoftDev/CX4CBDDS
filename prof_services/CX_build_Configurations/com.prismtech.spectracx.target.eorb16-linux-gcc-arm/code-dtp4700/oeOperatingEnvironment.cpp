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

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::BooleanSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::CharSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::DoubleSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::FloatSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::ShortSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::LongSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		CF::OctetSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		CF::StringSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::UlongSequence& from) {
	any <<= from;
}

void OperatingEnvironment::AnyFromSequence(CORBA::Any& any,
		PortTypes::UshortSequence& from) {
	any <<= from;
}

std::string IfIsDCEUUIDConvertToUpper(std::string candidate) {

	if (candidate.length() != 40) {
		return candidate;
	}

	for (unsigned int i = 0; i < candidate.length(); i += 1) {
		if (i == 0 && candidate[i] != 'D') {
			return candidate;
		} else if (i == 0 && candidate[i] == 'D') {
			continue;
		} else if (i == 1 && candidate[i] != 'C') {
			return candidate;
		} else if (i == 1 && candidate[i] == 'C') {
			continue;
		} else if (i == 2 && candidate[i] != 'E') {
			return candidate;
		} else if (i == 2 && candidate[i] == 'E') {
			continue;
		} else if (i == 3 && candidate[i] != ':') {
			return candidate;
		} else if (i == 3 && candidate[i] == ':') {
			continue;
		} else if ((i == 12 || i == 17 || i == 22 || i == 27) && candidate[i]
				!= '-') {
			return candidate;
		} else if ((i == 12 || i == 17 || i == 22 || i == 27) && candidate[i]
				== '-') {
			continue;
		} else {
			char c = candidate[i];
			switch (c) {
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
			case '9': {
				break;
			}
			default: {
				return candidate;
			}
			}
		}
	}

	std::string newstring = candidate;
	for (unsigned int j = 0; j < newstring.length(); ++j) {
		newstring[j] = (char) toupper(newstring[j]);
	}

	return newstring;
}

int str_case_cmp(const char* str1, const char* str2) {
	const char *char1 = str1, *char2 = str2;

	while ((*char1 != '\0') && (tolower((int) (*char1)) == tolower(
			(int) (*char2)))) {
		++char1;
		++char2;
	}

	return tolower(*char1) - tolower(*char2);
}

void CtrlHandler(int iSignal) {
	//We'll take care of shutting down ourselves
	while (OperatingEnvironment::status != OE_STATUS_FINISHED) {
		if ((OperatingEnvironment::status != OE_STATUS_SHUTTINGDOWN)) {
			Shutdown_Thread(NULL);
		}
		struct timespec sleepTime;
		sleepTime.tv_sec = 1;
		sleepTime.tv_nsec = 0;
		nanosleep(&sleepTime, NULL);
	}
	return; //Prevent default behaviour to occur
}

void register_process_termination_callback ()
{
	struct sigaction sa;
	oe_bzero(&sa, sizeof (sa));
	sa.sa_handler = CtrlHandler;
	sigfillset(&(sa.sa_mask));
	sa.sa_flags = 0;
	sigaction(SIGABRT, &sa, NULL);
	sigaction(SIGHUP, &sa, NULL);
	sigaction(SIGINT, &sa, NULL);
	sigaction(SIGQUIT, &sa, NULL);
	sigaction(SIGTERM, &sa, NULL);
}

void* Shutdown_Thread(void* data)
{
	OE_DECLARE_ENV;

	if (OperatingEnvironment::status == OE_STATUS_RUNNING)
	{
		OperatingEnvironment::status = OE_STATUS_SHUTTINGDOWN;
		struct timespec sleepTime;
		sleepTime.tv_sec = 1;
		sleepTime.tv_nsec = 0;
		nanosleep(&sleepTime, NULL);

		OE_TRY
		{
			OperatingEnvironment::orb_->shutdown(false OE_ENV_VARN);
			OE_CHECK_ENV;
			OperatingEnvironment::status = OE_STATUS_FINISHED;
		}
		OE_CATCH_ANY
		{
			std::cerr << "oeOperatingEnvironment : Exception caught during orb->shutdown()." << std::endl;
			return NULL;
		}
		OE_END_TRY
	}
	return NULL;
}

// add a '-' to any ORB options if necessary then initialize ORB if necessary
CORBA::ORB_var init_orb(int argc, const char * argv[] OE_ENV_ARGN)
{
	if(CORBA::is_nil(OperatingEnvironment::orb_))
	{
		int newArgc = argc;
		char** newArgv = new char*[newArgc + 1];
		newArgv[newArgc] = 0;

		EORB::Plugin::IIOP::add();
		EORB::Plugin::POA::add();
		EORB::Plugin::Any::add();

#ifdef CX_USE_MSGQIOP
		EORB::Plugin::MSGQIOP::add();
#endif

		for (int i = 0; i < newArgc; i++)
		{
			if( argv[i][0]=='O' && argv[i][1]=='R' && argv[i][2]=='B')
			{
				newArgv[i] = new char[strlen(argv[i]) + 2];
				newArgv[i][0] = '-';
				strcpy(&newArgv[i][1], argv[i]);
			}
			else
			{
				newArgv[i] = new char[strlen(argv[i]) + 1];
				strcpy(newArgv[i], argv[i]);
			}
		}

		OE_TRY
		{
			OperatingEnvironment::orb_ = CORBA::ORB_init(newArgc, newArgv OE_ENV_VARN);
			OE_CHECK_ENV;
		}
		OE_CATCH_ANY
		{
			for (int i = 0; i < newArgc; i++)
			{
				delete [] newArgv[i];
			}
			delete [] newArgv;
			OE_RETHROW_RETURN(OperatingEnvironment::orb_);
		}
		OE_END_TRY
		for (int i = 0; i < newArgc; i++)
		{
			delete [] newArgv[i];
		}
		delete [] newArgv;
	}
	return OperatingEnvironment::orb_;
}

CORBA::ORB_var get_orb()
{
	return OperatingEnvironment::orb_;
}

bool activate_component(CORBA::ORB_var orb, PortableServer::Servant servant OE_ENV_ARGN)
{
	CORBA::Object_var tempobj = orb->resolve_initial_references("RootPOA" OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	PortableServer::POA_var rootpoa = PortableServer::POA::_narrow(tempobj OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);
	if(CORBA::is_nil(rootpoa))
	{
		std::cerr << "Failed to narrow the POA.";
		return false;
	}

	PortableServer::ObjectId_var oid = rootpoa->activate_object(servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	PortableServer::POAManager_var manager = rootpoa->the_POAManager();
	manager->activate(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);

	return true;
}

void deactivate_component(PortableServer::Servant servant OE_ENV_ARGN)
{
	PortableServer::POA_var poa = servant->_default_POA();
	PortableServer::ObjectId_var oid = poa->servant_to_id(servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN_VOID;
	poa->deactivate_object(oid OE_ENV_VARN);
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

void shutdown_component(CORBA::ORB_var orb, PortableServer::Servant component, bool wait OE_ENV_ARGN)
{
	pthread_t tid_;
	pthread_create(&tid_, NULL, Shutdown_Thread, component);
}

void oe_bzero (void* p, size_t s)
{
   size_t size;
   char * ptr = (char*) (p);
   for (size = 0; size++ < (s); *ptr++ = 0);
}

// End-Of-File
//------------------------------------------------------------------------------
