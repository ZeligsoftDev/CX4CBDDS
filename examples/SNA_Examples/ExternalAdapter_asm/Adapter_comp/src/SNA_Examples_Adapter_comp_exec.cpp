//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Adapter_comp
/// @{
/// @file   SNA_Examples_Adapter_comp_exec.cpp
/// @brief  Implementation of executor classes for the Adapter_comp component
///         and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#include "SNA_Examples_Adapter_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"


// EXAMPLE: These includes were added by hand in order to create a timer
#include "SNA_GeneralTimer.h"
// EXAMPLE: Include TCP_Client to be utilized by the Adapter component to create
//          socket connections.
#include "SNA_Examples_Adapter_TCP_Client.h"

namespace CIAO_SNA_Examples_Adapter_comp_Impl
{
   /**
    * Component Executor Implementation Class: Adapter_comp_exec_i
    */
   Adapter_comp_exec_i::Adapter_comp_exec_i() :
      boilerplate_("Adapter_comp", "SNA_Examples")
   {
   }

   Adapter_comp_exec_i::~Adapter_comp_exec_i()
   {
      delete(signalHandler_);    // Added by hand
   }

   // Supported operations and attributes.
   ACE_Reactor*
   Adapter_comp_exec_i::reactor()
   {
      ACE_Reactor * reactor = 0;
      ::CORBA::Object_var ccm_object = this->ciao_context_->get_CCM_object();

      if (!::CORBA::is_nil(ccm_object.in()))
      {
         ::CORBA::ORB_var orb = ccm_object->_get_orb();

         if (!::CORBA::is_nil(orb.in()))
         {
            reactor = orb->orb_core()->reactor();
         }
      }

      if (reactor == 0)
      {
         throw ::CORBA::INTERNAL();
      }

      return reactor;
   }

   // Component attributes and port operations.

   // Operations from Components::SessionComponent.

   void Adapter_comp_exec_i::set_session_context(
         ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ = ::SNA_Examples::CCM_Adapter_comp_Context::_narrow(
            ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void Adapter_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void Adapter_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      // Step 1: Set up the timer to check the socket connection
      ACE_Time_Value delay(5, 0); // timer = 5 seconds + 0 usec = 5 sec
      ACE_Time_Value repeat(20, 0); // timer = 20 seconds + 0 usec = 20 sec

      //EXAMPLE: Instantiate new Adapter_TCP_Clients for both sockets.
      connection_ = new SNA_Examples::Adapter_TCP_Client(boilerplate_,
                                                 "HardwareEmulator_bin.cfg",
                                                 ( *reactor() ) );
      connection2_ = new SNA_Examples::Adapter_TCP_Client(boilerplate_,
                                                 "HardwareEmulator_bin2.cfg",
                                                 ( *reactor() ) );

      typedef SNA_GENERAL_TIMER_T(SNA_Examples::Adapter_TCP_Client) TimerType;

      // EXAMPLE: The first parameter of the SNA_GENERAL_TIMER class constructor
      // passes a reference to the component, used when registering the callback
      // handler. The second parameter of this constructor is the method to
      // callback on timer events. The third parameter of this constructor
      // passes the logger to the timer to provide context into where the log
      // messages are coming from within the timer class.
      ACE_Event_Handler_var connectTimer =
            new TimerType(connection_,
                          &SNA_Examples::Adapter_TCP_Client::connect,
                          boilerplate_.getLogger());

      ACE_Event_Handler_var connectTimer2 =
                  new TimerType(connection2_,
                                &SNA_Examples::Adapter_TCP_Client::connect,
                                boilerplate_.getLogger());

      // EXAMPLE: Using the time manager object, you can schedule the timer by
      // calling schedule_timer. The parameters to schedule timer are:
      //
      // connectTimer - The SNA_GENERAL_TIMER_T object constructed above, this
      //             provides an event handler that is registered with the ACE
      //             reactor.
      // 0         - In this example we do not provide arguments to the reactor.
      // delay     - The amount to delay the 1st timer event by.
      // repeat    - The amount of time between timer events.
      timerId_ =
            timeManager_.schedule_timer(connectTimer.handler(),0, delay, repeat);

      timerId2_ =
            timeManager_.schedule_timer(connectTimer2.handler(),0, delay, repeat);

      if (timerId_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }

      if (timerId2_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }

      if (0 == this->reactor())
      {
         boilerplate_.failed_state_change("Null reactor pointer");
      }


      //An Empty Handler, i.e. an event handler that does not do anything,
      //is used to handle the SIGPIPE, which if left unhandled will cause
      //the deployment to crash. The SIGPIPE is sent when the other end of
      //the socket connection goes down. This a normal part of the shutdown
      //but must be handled regardless.
      signalHandler_ = new ::SNA_Examples::EmptyHandler();

      this->reactor()->register_handler(SIGPIPE, signalHandler_);
   }

   void Adapter_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_passivate");

      boilerplate_.ccm_passivate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      //          will also destroy the general timer class constructed in
      //          ccm_activate.
      timeManager_.cancel_timer(timerId_);
      timeManager_.cancel_timer(timerId2_);

      //EXAMPLE: Must remove handlers at shutdown (just as with timers)
      reactor()->remove_handler(SIGPIPE, (ACE_Sig_Action *)0);
      //EXAMPLE: Must remove connection objects to prevent memory leak,
      //destructor for Adapter_TCP_Client removes these handlers.
      delete(connection_);
      delete(connection2_);
   }

   void Adapter_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_remove");

      boilerplate_.ccm_remove();
   }


   /////////////////////////////////////////////////////////////////////////////
   // EXAMPLE: Following function was auto-generated
   /////////////////////////////////////////////////////////////////////////////
   extern "C"
   SNA_EXAMPLES_ADAPTER_COMP_EXEC_Export::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Adapter_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
            ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
            retval,
            Adapter_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
