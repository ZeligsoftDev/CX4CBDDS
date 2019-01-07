#include "oeOrbFunctions.h"

// add a '-' to any ORB options if necessary then initialize ORB if necessary
CORBA::ORB_ptr oeOrbFunctions::init_orb(int argc, const char *argv[] OE_ENV_ARGN)
{
	CORBA::ORB_var orb = NULL;

	int newArgc = argc;
	char** newArgv = new char*[newArgc + 1];
	newArgv[newArgc] = 0;

	EORB::Plugin::IIOP::add();
	EORB::Plugin::POA::add();
	EORB::Plugin::Any::add();

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
		orb = CORBA::ORB_init(newArgc, newArgv OE_ENV_VARN);
		OE_CHECK_ENV;
	}
	OE_CATCH_ANY
	{
		for (int i = 0; i < newArgc; i++)
		{
			delete [] newArgv[i];
		}
		delete [] newArgv;
		OE_RETHROW_RETURN(NULL);
	}
	OE_END_TRY

	for (int i = 0; i < newArgc; i++)
	{
		delete [] newArgv[i];
	}
	delete [] newArgv;

	return orb._retn();
}

PortableServer::POA_ptr oeOrbFunctions::get_rootpoa (CORBA::ORB_ptr orb OE_ENV_ARGN)
{
	CORBA::Object_var tempobj = orb->resolve_initial_references("RootPOA" OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);

	PortableServer::POA_var rootpoa = PortableServer::POA::_narrow(tempobj OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);

	return rootpoa._retn ();
}

bool oeOrbFunctions::activate_component(PortableServer::POA_ptr poa, PortableServer::Servant servant OE_ENV_ARGN)
{
	PortableServer::ObjectId_var oid = poa->activate_object(servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	PortableServer::POAManager_var manager = poa->the_POAManager();
	manager->activate(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);

	return true;
}

bool oeOrbFunctions::activate_component_with_id(PortableServer::POA_ptr poa, const char* id, PortableServer::Servant servant OE_ENV_ARGN)
{
	PortableServer::ObjectId_var oid = new PortableServer::ObjectId ();
	CORBA::ULong len = strlen (id);
	oid->length (len);
	memcpy (oid->get_buffer (), id, len);

	poa->activate_object_with_id (oid.in(), servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	PortableServer::POAManager_var manager = poa->the_POAManager();
	manager->activate(OE_ENV_VAR1);
	OE_CHECK_ENV_RETURN(false);

	return true;
}

void oeOrbFunctions::deactivate_component(PortableServer::Servant servant OE_ENV_ARGN)
{
	PortableServer::POA_var poa = servant->_default_POA();
	PortableServer::ObjectId_var oid = poa->servant_to_id(servant OE_ENV_VARN);
	OE_CHECK_ENV_RETURN_VOID;
	poa->deactivate_object(oid OE_ENV_VARN);
	OE_CHECK_ENV_RETURN_VOID;
}

#define OE_MAX_NAME_SIZE 64

CORBA::ULong OE_NamingService_count (const char * str)
{
	CORBA::ULong count = 1;
	bool escaped = false;

	while (*str != '\0')
	{
		if (*str == '\\')
		{
			escaped = ! escaped;
		}
		else
		{
			if (! escaped && (*str == '/'))
			{
				count++;
			}
			escaped = false;
		}
		str++;
	}

	return count;
}

void OE_NamingService_parse (CosNaming::Name & name, const char * str)
{
	CORBA::ULong index = 0;
	bool init = true;

	bool escaped;
	bool have_kind;
	char id [OE_MAX_NAME_SIZE];
	char kind [OE_MAX_NAME_SIZE];
	char * id_ptr;
	char * kind_ptr;

	while (*str != '\0')
	{
		if (init)
		{
			memset (id, 0, OE_MAX_NAME_SIZE);
			memset (kind, 0, OE_MAX_NAME_SIZE);
			id_ptr = id;
			kind_ptr = kind;
			have_kind = false;
			escaped = false;
			init = false;
		}

		if (*str == '\\')
		{
			escaped = ! escaped;
			if (escaped)
			{
				str++;
				continue;
			}
		}

		if (*str == '/' && ! escaped)
		{
			init = true;
		}
		else if (*str == '.' && ! escaped)
		{
			have_kind = true;
		}
		else if (have_kind)
		{
			*kind_ptr = *str;
			kind_ptr++;
		}
		else
		{
			*id_ptr = *str;
			id_ptr++;
		}

		escaped = false;
		str++;

		if (init || (*str == '\0'))
		{
			name[index].kind = CORBA::string_dup (kind);
			name[index].id = CORBA::string_dup (id);
			index++;
		}
	}
}

CosNaming::Name * oe_to_name (const char * sn)
{
	CosNaming::Name * name = new CosNaming::Name ();
	CORBA::ULong count;

	count = OE_NamingService_count (sn);
	name->length (count);
	OE_NamingService_parse (*name, sn);

	return name;
}

CosNaming::NamingContext_ptr get_naming_service (CORBA::ORB_ptr orb OE_ENV_ARGN)
{
	CosNaming::NamingContext_var root_context;

	CORBA::Object_var tempObj = orb->resolve_initial_references ("NameService" OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);

	if (CORBA::is_nil(tempObj))
	{
		return NULL;
	}
	root_context = CosNaming::NamingContext::_narrow(tempObj OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(NULL);
	return root_context._retn ();
}

bool oeOrbFunctions::naming_service_bind (CosNaming::NamingContext_ptr root_context, const char* context_name,
		const char* name_binding, bool &context_created, CORBA::Object_ptr component OE_ENV_ARGN)
{
	CosNaming::NamingContext_var context;
	context_created = false;

	if (strlen (context_name) > 0)
	{
		CosNaming::Name_var context_cosname = oe_to_name (context_name);
		OE_CHECK_ENV_RETURN(false);

		OE_TRY
		{
			CORBA::Object_var tmpContext = root_context->resolve (context_cosname OE_ENV_VARN);
			OE_CHECK_ENV;
			context = CosNaming::NamingContext::_narrow(tmpContext OE_ENV_VARN);
			OE_CHECK_ENV;
		}
		OE_CATCH_NOOP (CosNaming::NamingContext::NotFound)
		{
			context = root_context->bind_new_context (context_cosname OE_ENV_VARN);
			OE_CHECK_ENV_RETURN(false);

			if(CORBA::is_nil(context))
			{
				return false;
			}
			context_created = true;
		}
		OE_CATCH_ANY
		{
			return false;
		}
		OE_END_TRY
	}
	else
	{
		context = CosNaming::NamingContext::_duplicate(root_context);
	}

	CosNaming::Name name;
	name.length(1);
	name[0].id = CORBA::string_dup(name_binding);
	context->rebind(name, component OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);
	return true;
}

bool oeOrbFunctions::naming_service_unbind (CosNaming::NamingContext_ptr root_context, const char* context_name,
		const char* name_binding, bool destroy_context OE_ENV_ARGN)
{
	CosNaming::NamingContext_var context;
	CosNaming::Name_var context_cosname;

	if (strlen (context_name) > 0)
	{
		context_cosname = oe_to_name (context_name);
		OE_CHECK_ENV_RETURN(false);

		OE_TRY
		{
			CORBA::Object_var tmpContext = root_context->resolve (context_cosname OE_ENV_VARN);
			OE_CHECK_ENV;
			context = CosNaming::NamingContext::_narrow(tmpContext OE_ENV_VARN);
			OE_CHECK_ENV;
		}
		OE_CATCH_ANY
		{
			return false;
		}
		OE_END_TRY

		if(CORBA::is_nil(context))
		{
			return false;
		}
	}
	else
	{
		context = CosNaming::NamingContext::_duplicate(root_context);
	}

	CosNaming::Name name;
	name.length(1);
	name[0].id = CORBA::string_dup(name_binding);
	context->unbind(name OE_ENV_VARN);
	OE_CHECK_ENV_RETURN(false);

	if (destroy_context && strlen (context_name) > 0)
	{
		context->destroy (OE_ENV_VAR1);
		OE_CHECK_ENV_RETURN(false);
		root_context->unbind (context_cosname OE_ENV_VARN);
		OE_CHECK_ENV_RETURN(false);
	}

	return true;
}
