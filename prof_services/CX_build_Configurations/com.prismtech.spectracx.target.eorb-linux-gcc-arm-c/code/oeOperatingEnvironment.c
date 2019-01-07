#include "oeOperatingEnvironment.h"
#include "oeUtil.h"

oeStatus OE_status = OE_STATUS_NONE;
static CORBA_ORB OE_orb = CORBA_OBJECT_NIL;
static PortableServer_POA OE_rootpoa = CORBA_OBJECT_NIL;

void * Shutdown_Thread (void * data)
{
   CORBA_Environment * ev = (CORBA_Environment *) data;

   if (OE_status == OE_STATUS_RUNNING)
   {
      OE_status = OE_STATUS_SHUTTINGDOWN;

      CORBA_ORB_destroy (OE_orb, ev);
      EORB_CHECK_EXC_RETURN_VAL ("Exception caught during orb->shutdown()\n", ev, NULL);
      OE_status = OE_STATUS_FINISHED;
   }
   return NULL;
}

void CtrlHandler (int iSignal)
{
   if ((OE_status != OE_STATUS_FINISHED) && (OE_status != OE_STATUS_SHUTTINGDOWN))
   {
      CORBA_Environment ev;
      oe_bzero (&ev, sizeof (ev));
      Shutdown_Thread (&ev);
   }
}

void register_process_termination_callback ()
{
   struct sigaction sa;
   oe_bzero (&sa, sizeof (sa));
   sa.sa_handler = CtrlHandler;
   sigfillset (&sa.sa_mask);
   sa.sa_flags = 0;
   sigaction (SIGABRT, &sa, NULL);
   sigaction (SIGHUP, &sa, NULL);
   sigaction (SIGINT, &sa, NULL);
   sigaction (SIGQUIT, &sa, NULL);
   sigaction (SIGTERM, &sa, NULL);
}

/* add a '-' to any ORB options if necessary then initialize ORB if necessary */
CORBA_ORB OE_init_orb (int argc, const char * argv[], CORBA_Environment * ev)
{
   int i, newArgc;
   char ** newArgv;
   PortableServer_POAManager manager;

   if (!CORBA_Object_is_nil (OE_orb, ev))
   {
      return OE_orb;
   }
   EORB_CHECK_EXC_RETURN_VAL ("Caught exception while checking if ORB was NIL\n", ev, NULL);

   newArgc = argc;
   newArgv = malloc (sizeof (char *) * newArgc);

   EORB_plugin (EORB_POA);
   EORB_plugin (EORB_IIOP);
#ifdef CX_USE_MSGQIOP
   EORB_plugin (EORB_MSGQIOP);
#endif
   EORB_plugin (EORB_Any);

   for (i = 0; i < newArgc; ++i)
   {
      if (strncmp (argv[i], "ORB", 3) == 0)
      {
         newArgv[i] = malloc (strlen (argv[i]) + 2);
         strcpy (newArgv[i], "-");
         strcat (newArgv[i], argv[i]);
      }
      else
      {
         newArgv[i] = malloc (strlen (argv[i]) + 1);
         strcpy (newArgv[i], argv[i]);
      }
   }

   OE_orb = CORBA_ORB_init (&newArgc, newArgv, "", ev);

   for (i = 0; i < newArgc; ++i)
   {
      free (newArgv[i]);
   }
   free (newArgv);

   EORB_CHECK_EXC_RETURN_VAL ("Caught exception while initializing the ORB\n", ev, NULL);

   OE_rootpoa = CORBA_ORB_resolve_initial_references(OE_orb, "RootPOA", ev);
   EORB_CHECK_EXC_RETURN_VAL ("Caught exception while resolving the RootPOA\n", ev, NULL);

   manager = PortableServer_POA__get_the_POAManager (OE_rootpoa, ev);
   EORB_CHECK_EXC_RETURN_VAL ("Caught exception while resolving the RootPOA's POAManager\n", ev, NULL);

   PortableServer_POAManager_activate (manager, ev);
   EORB_CHECK_EXC_RETURN_VAL ("Caught exception while activating the RootPOA's POAManager\n", ev, NULL);

   return OE_orb;
}

CORBA_ORB OE_get_orb ()
{
   return OE_orb;
}

extern PortableServer_POA OE_get_rootpoa ()
{
   return OE_rootpoa;
}

void OE_shutdown_object( CORBA_ORB orb, PortableServer_Servant component, CORBA_boolean wait, CORBA_Environment * ev )
{
	pthread_t tid_;
	pthread_create( &tid_, NULL, Shutdown_Thread, ev );
}
