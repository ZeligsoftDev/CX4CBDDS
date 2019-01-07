#ifndef OE_OPERATING_ENVIRONMENT_H
#define OE_OPERATING_ENVIRONMENT_H

#include "eOrbC/CORBA.h"
#include "eOrbC/EORB/NamingService.h"
#include "eOrbC/PortableServer/ServantBase.h"

/* Includes for the SCA */
#include "CF.h"
#include "PortTypes.h"

typedef enum oeStatus {
	OE_STATUS_NONE = -1,
	OE_STATUS_RUNNING = 0,
	OE_STATUS_SHUTTINGDOWN = 1,
	OE_STATUS_FINISHED = 2
} oeStatus;

#if defined(EORB_VERNUM) && EORB_VERNUM > 172
#define OE_IDL_INIT(n) EORB_IDL_##n##_init()
#else
#define OE_IDL_INIT(n)
#endif

extern CORBA_ORB OE_init_orb( int argc, const char * argv[], CORBA_Environment * ev );
extern void OE_shutdown_object(Uint32 event, void * arg, void * info);
extern CORBA_ORB OE_get_orb();

/* Returns the singleton RootPOA. Note the returned POA should not be free'd */
extern PortableServer_POA OE_get_rootpoa ();

extern void register_process_termination_callback ();

extern oeStatus OE_status;

#endif
