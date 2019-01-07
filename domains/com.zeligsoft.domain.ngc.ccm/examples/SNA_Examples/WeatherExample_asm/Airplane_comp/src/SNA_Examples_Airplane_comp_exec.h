//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Airplane_comp
/// @{
/// @file   SNA_Examples_Airplane_comp_exec.h
/// @brief  Definition of executor classes for the Airplane_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_AIRPLANE_COMP_EXEC_MK9D6M_H_
#define CIAO_BS_SNA_EXAMPLES_AIRPLANE_COMP_EXEC_MK9D6M_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_Airplane_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_Airplane_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

/// Auto-generated namespace for SNA_Examples_Airplane_comp
namespace CIAO_SNA_Examples_Airplane_comp_Impl
{
   /// Forward declaration of component executor class
   class Airplane_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_Airplane_comp_Context,
      Airplane_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Component Executor Implementation Class: Airplane_comp_exec_i
    */

   class Airplane_comp_exec_i :
      public virtual Airplane_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      Airplane_comp_exec_i();

      /// Destructor
      virtual ~Airplane_comp_exec_i();

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      /**
       * Callback for the send timer.
       */
      int queryWeather();

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Airplane_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      /**
       * Id given when registering the timer with the reactor
       */
      int timerId_;

      /**
       * Time Manager used to schedule send timer.
       */
      SNA::TimeManager timeManager_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_AIRPLANE_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Airplane_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
