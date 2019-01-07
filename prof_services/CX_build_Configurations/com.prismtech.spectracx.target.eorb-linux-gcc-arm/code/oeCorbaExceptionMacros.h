#ifndef __OE_CORBA_EXCEPTION_MACROS_H
#define __OE_CORBA_EXCEPTION_MACROS_H

#include "eOrb/CORBA/Environment.h"

#define OE_DECLARE_ENV EORB_DECLARE_ENV

#define OE_ENV_ARG1 EORB_ENV_ARG1
#define OE_ENV_ARGN EORB_ENV_ARGN
#define OE_ENV_VAR1 EORB_ENV_VAR1
#define OE_ENV_VARN EORB_ENV_VARN

#define OE_THROW(exc) EORB_THROW(exc)
#define OE_THROW_LABEL(exc, lbl) EORB_THROW_LABEL(exc, lbl)
#define OE_THROW_RETURN(exc, ret) EORB_THROW_RETURN(exc, ret)
#define OE_THROW_RETURN_VOID(exc) EORB_THROW_RETURN_VOID(exc)

#define OE_RETHROW_RETURN(ret) EORB_RETHROW_RETURN(ret)
#define OE_RETHROW_RETURN_VOID EORB_RETHROW_RETURN_VOID

#define OE_TRY EORB_TRY
#define OE_TRY_LABEL(lbl) EORB_TRY_LABEL(lbl)

#define OE_CHECK_ENV EORB_CHECK_ENV
#define OE_CHECK_ENV_LABEL(lbl) EORB_CHECK_ENV_LABEL(lbl)
#define OE_CHECK_ENV_RETURN(ret) EORB_CHECK_ENV_RETURN(ret)
#define OE_CHECK_ENV_RETURN_VOID EORB_CHECK_ENV_RETURN_VOID

#define OE_CATCH(type, var) EORB_CATCH(type, var)
#define OE_CATCH_NOOP(type) EORB_CATCH_NOOP(type)
#define OE_CATCH_ANY EORB_CATCH_ANY

#define OE_END_TRY EORB_END_TRY

#endif     // __OE_CORBA_EXCEPTION_MACROS_H
// End-Of-File
//------------------------------------------------------------------------------
