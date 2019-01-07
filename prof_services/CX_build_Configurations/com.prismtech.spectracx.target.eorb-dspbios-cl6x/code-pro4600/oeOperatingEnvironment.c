
#include "oeOperatingEnvironment.h"
#include "oeUtil.h"

oeStatus OE_status = OE_STATUS_NONE;
static CORBA_ORB OE_orb = CORBA_OBJECT_NIL;
static PortableServer_POA OE_rootpoa = CORBA_OBJECT_NIL;

void register_process_termination_callback ()
{
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
   EORB_plugin (EORB_Any);
   EORB_plugin (EORB_QCIOP);
   EORB_plugin (EORB_MQCIOP);

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
