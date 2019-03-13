//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Adapter_comp
/// @{
/// @file   SNA_Examples_Adapter_comp_exec.h
/// @brief  Definition of executor classes for the Adapter_comp component and
///         its facets. This component makes connections with two simulated
///         instances of external hardware from which it receives messages.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#ifndef CIAO_BS_SNA_EXAMPLES_ADAPTER_COMP_EXEC_QF6KWF_H_
#define CIAO_BS_SNA_EXAMPLES_ADAPTER_COMP_EXEC_QF6KWF_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_Adapter_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_Adapter_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

#include <string>

//Required Includes for ACE
#include <ace/Reactor.h>

namespace SNA_Examples
{
   class AdapterIPEventHandler;
   class EmptyHandler;
   class Adapter_TCP_Client;
}

/// Auto-generated namespace for SNA_Examples_Adapter_comp
namespace CIAO_SNA_Examples_Adapter_comp_Impl
{
   /// Forward declaration of component executor class
   class Adapter_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_Adapter_comp_Context,
      Adapter_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Component Executor Implementation Class: Adapter_comp_exec_i
    */

   class Adapter_comp_exec_i :
      public virtual Adapter_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      Adapter_comp_exec_i();

      /// Destructor
      virtual ~Adapter_comp_exec_i();

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      /**
       * Callback called by the event handler to respond to data received over a
       * socket.
       *
       * @param[in] fd - Unix style file descriptor which represents a socket
       *                 being used to communicate with some external device
       *                 (simulated) that the adaptor component is "adapting"
       *                 to the SNA component framework.
       */
      int onExternalEvent(int fd);

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Adapter_comp_Context_var ciao_context_;

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
       * Connect timer ID number.
       */
      long             timerId_;

      /**
       * Connect timer ID number.
       */
      long             timerId2_;
      /**
       * Time Manager used to schedule send timer.
       */
      SNA::TimeManager timeManager_;

      /**
       * Event Handler to handle the SIGPIPE in the activate method
       */
      ::SNA_Examples::EmptyHandler * signalHandler_;

      /**
       * Connection object for first socket.
       */
      ::SNA_Examples::Adapter_TCP_Client * connection_;

      /**
       * Connection object for first socket.
       */
      ::SNA_Examples::Adapter_TCP_Client * connection2_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_ADAPTER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Adapter_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
