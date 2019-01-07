#include "oeOrbFunctions.h"

// add a '-' to any ORB options if necessary then initialize ORB if necessary
CORBA::ORB_ptr oeOrbFunctions::init_orb(int argc, const char *argv[] OE_ENV_ARGN)
{
	CORBA::ORB_var orb = NULL;

	int newArgc = argc;
	char** newArgv = new char*[newArgc + 1];
	newArgv[newArgc] = 0;

#ifdef SCX_USE_EORB_20
	EORB_IIOP_plugin ();
#else
	EORB::Plugin::IIOP::add();
#endif
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

void oeOrbFunctions::orb_run(CORBA::ORB_ptr orb OE_ENV_ARGN)
{
	OE_TRY
	{
		orb->run(OE_ENV_VAR1);
	}
	OE_CATCH_NOOP(CORBA::BAD_INV_ORDER)
	{
		// Ignore CORBA::BAD_INV_ORDER exception
	}
	OE_END_TRY
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
	PortableServer::ObjectId_var oid = PortableServer::string_to_ObjectId (id);
	OE_CHECK_ENV_RETURN(false);

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

CosNaming::NamingContext_ptr oeOrbFunctions::get_naming_service (CORBA::ORB_ptr orb OE_ENV_ARGN)
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
		CosNaming::Name_var context_cosname = EORB::NamingService::to_name (context_name);
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
		context_cosname = EORB::NamingService::to_name (context_name);
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
