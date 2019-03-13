//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SourceClient_comp
/// @{
/// @file   SNA_Examples_SourceClient_comp_exec.h
/// @brief  Definition of executor classes for the SourceClient_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#ifndef CIAO_BS_SNA_EXAMPLES_SOURCECLIENT_COMP_EXEC_3BGP5F_H_
#define CIAO_BS_SNA_EXAMPLES_SOURCECLIENT_COMP_EXEC_3BGP5F_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_SourceClient_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_SourceClient_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

/// Auto-generated namespace for SNA_Examples_SourceClient_comp
namespace CIAO_SNA_Examples_SourceClient_comp_Impl
{
   /// Forward declaration of component executor class
   class SourceClient_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_SourceClient_comp_Context,
       SourceClient_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Component Executor Implementation Class: SourceClient_comp_exec_i
    */

   class SourceClient_comp_exec_i
   : public virtual SourceClient_comp_Exec,
   public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SourceClient_comp_exec_i();

      /// Destructor
      virtual ~SourceClient_comp_exec_i();

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      /**
       * Callback (which invokes the CORBA interface) which is called when the
       * timer expires.
       */
      int invokeInterface();

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_SourceClient_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: The members in this class below this line were added by hand.
      //          The ones above were generated.
      //////////////////////////////////////////////////////////////////////////

      /**
       * Invocation timer ID number.
       */
      long             timerId_;

      /**
       * Time Manager used to schedule invocation timer.
       */
      SNA::TimeManager timeManager_;

      /**
       * Number of invocations on the CORBA interface from this component
       */
      int              counter_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C"
   SNA_EXAMPLES_SOURCECLIENT_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_SourceClient_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
