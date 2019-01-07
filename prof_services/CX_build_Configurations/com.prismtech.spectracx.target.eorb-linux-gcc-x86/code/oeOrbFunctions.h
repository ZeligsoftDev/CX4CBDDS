#ifndef __OE_ORB_FUNCTIONS_H
#define __OE_ORB_FUNCTIONS_H

#include "oeOrbHeader.h"
#include "oeCorbaExceptionMacros.h"

namespace oeOrbFunctions {

	CORBA::ORB_ptr init_orb (int argc, const char * argv[] OE_ENV_ARGN);

	void orb_run(CORBA::ORB_ptr orb OE_ENV_ARGN);

	PortableServer::POA_ptr get_rootpoa (CORBA::ORB_ptr orb OE_ENV_ARGN);

	bool activate_component (PortableServer::POA_ptr poa, PortableServer::Servant servant OE_ENV_ARGN);

	bool activate_component_with_id (PortableServer::POA_ptr poa, const char* id, PortableServer::Servant servant OE_ENV_ARGN);

	void deactivate_component(PortableServer::Servant servant OE_ENV_ARGN);

	CosNaming::NamingContext_ptr get_naming_service (CORBA::ORB_ptr orb OE_ENV_ARGN);

	bool naming_service_bind (CosNaming::NamingContext_ptr root_context, const char* context_name,
			const char* name_binding, bool &context_created, CORBA::Object_ptr component OE_ENV_ARGN);

	bool naming_service_unbind (CosNaming::NamingContext_ptr root_context, const char* context_name,
			const char* name_binding, bool destroy_context OE_ENV_ARGN);
}
#endif     // __OE_ORB_FUNCTIONS_H
