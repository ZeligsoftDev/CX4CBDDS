#ifndef __OE_ORB_HEADER_H
#define __OE_ORB_HEADER_H

#include "eOrb/CORBA.h"
#include "eOrb/EORB/NamingService.h"
#include "eOrb/CORBA/INTERNAL.h"
#include "eOrb/CORBA/OBJECT_NOT_EXIST.h"
#include "eOrb/CORBA/ORB/InvalidName.h"
#include "eOrb/PortableServer/RefCountServantBase.h"
#include "eOrb/PortableServer/POA.h"
#include "eOrb/PortableServer/POAManager.h"
#include "eOrb/PortableServer/Current.h"
#include "eOrb/EORB/Plugin/POA.h"
#include "eOrb/EORB/Plugin/Any.h"

#ifdef SCX_USE_EORB_20
#include "eOrbC/EORB/IIOP.h"
#else
#include "eOrb/EORB/Plugin/IIOP.h"
#endif

#endif     // __OE_ORB_HEADER_H
