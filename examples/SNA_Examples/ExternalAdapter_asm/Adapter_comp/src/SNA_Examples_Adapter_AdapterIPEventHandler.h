//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Adapter_comp
/// @{
/// @file   SNA_Examples_Adapter_AdapterIPEventHandler.h
/// @brief  Declarations of EmptyHandler and AdapterIPEventHandler classes
///         This class incorporates all event handler tasks into a separate
///         class. Previously the Adapter_comp_exec_i inherited the
///         ACE_Event_Handler. Separating this into its own class helps to
///         create a more modular and readable design with a clearer separation
///         of concern.
//==============================================================================

#ifndef SNA_EXAMPLES_ADAPTER_ADAPTER_IP_EVENT_HANDLER_H_
#define SNA_EXAMPLES_ADAPTER_ADAPTER_IP_EVENT_HANDLER_H_

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
#include <ace/INET_Addr.h>
#include <ace/SOCK_Stream.h>
#include <ace/SOCK_Connector.h>
#include <ace/SOCK_Acceptor.h>
#include <ace/Reactor.h>

namespace SNA_Examples
{
   /**
    * Empty Event Handler created to handle SIGPIPE in Adapter_comp_exec_i
    */
   class EmptyHandler: public ACE_Event_Handler
   {
   public:
      /**
       * Default constructor declaration
       */
      EmptyHandler();

      /**
       * Default destructor declaration
       */
      virtual ~EmptyHandler();
   };

   /**
    * A custom event handler to be used with the Adapter component.
    */
   class AdapterIPEventHandler: public ACE_Event_Handler,
         public virtual SNA::LoggingObject
   {
   public:

      /**
       * AdapterIPEventHandler constructor
       * @param[in,out] ciao_context   ciao context associated with Adapter
       *                               component
       *
       * @param[in] loggerPrefix       Prefix to be used for the event handler's
       *                               LoggerObject
       *
       * @param[in,out] peer           Peer obtained from the connection created
       *                               in the adapter component.
       */
      AdapterIPEventHandler(
            ::SNA_Examples::CCM_Adapter_comp_Context_ptr ciao_context,
            const std::string                            &loggerPrefix,
            ACE_SOCK_Stream                              &peer);

      /**
       * AdapterIPEventHandler destructor
       */
      virtual ~AdapterIPEventHandler();

      /**
       * Responds to a request from the client
       * (overloaded from ACE_Event_Handler)
       *
       * @param[in] fd file descriptor
       */
      virtual int handle_input(ACE_HANDLE fd = ACE_INVALID_HANDLE);

      /**
       * Handles the end of a client session
       * (overloaded from ACE_Event_Handler)
       *
       * @param[in] handle file descriptor for this socket
       *            (overloaded from ACE_Event_Handler)
       * @param[in] mask
       *            (overloaded from ACE_Event_Handler)
       *
       * @returns int 0 normally, -1 to cancel handler
       */
      virtual int handle_close(ACE_HANDLE handle, ACE_Reactor_Mask mask);

      /**
       * Handles OS signals (overloaded from ACE_Event_Handler). In this example
       * this handler is used to handle and ignore the SIGPIPE signal, which can
       * be signaled if a socket receive fails because the hardware emulator
       * went down first. This condition is not an error.
       *
       * @param[in] signum  - Signal number (SIGPIPE, etc.)
       * @param[in] info    - Information about signal
       * @param[in] context - Processing context when signal was sent
       */
      virtual int handle_signal(int signum, siginfo_t * info = 0,
            ucontext_t * context = 0);

      /**
       * Returns the handle associated with this handler
       * (overloaded from ACE_Event_Handler)
       *
       * @returns file descriptor for this socket
       */
      virtual ACE_HANDLE get_handle(void) const;

   private:

      /**
       * Portable socket class from ACE library
       */
      ACE_SOCK_Stream & peer_;

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Adapter_comp_Context_var ciao_context_;
   };
}
;
#endif /* SNA_EXAMPLES_ADAPTER_ADAPTERIP_EVENT_HANDLER_H_ */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
