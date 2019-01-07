//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SourceClient_comp
/// @{
/// @file   SNA_Examples_SourceClient_comp_exec.cpp
/// @brief  Implementation of executor classes for the SourceClient_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#include "SNA_Examples_SourceClient_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: These include was added by hand in order to create a timer which
//          periodically invokes a CORBA interface
#include "SNA_GeneralTimer.h"

// EXAMPLE: This include was added by hand so a stringstream could be used to
//          help format a logging message
#include <sstream>

namespace CIAO_SNA_Examples_SourceClient_comp_Impl
{

   /**
    * Component Executor Implementation Class: SourceClient_comp_exec_i
    */

   SourceClient_comp_exec_i::SourceClient_comp_exec_i() :
         boilerplate_("SourceClient_comp",
                      "SNA_Examples"),
         counter_(0)
   {
   }

   SourceClient_comp_exec_i::~SourceClient_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   SourceClient_comp_exec_i::reactor()
   {
      ACE_Reactor * reactor = 0;
      ::CORBA::Object_var ccm_object =
         this->ciao_context_->get_CCM_object();

      if (! ::CORBA::is_nil(ccm_object.in()))
      {
         ::CORBA::ORB_var orb = ccm_object->_get_orb();

         if (! ::CORBA::is_nil(orb.in()))
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

   void
   SourceClient_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_SourceClient_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   SourceClient_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      /* Your code here. */
   }

   void
   SourceClient_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      typedef SNA_GENERAL_TIMER_T(SourceClient_comp_exec_i) TimerType;

      ACE_Event_Handler_var sendTimer =
            new TimerType(this,
                          &SourceClient_comp_exec_i::invokeInterface,
                          boilerplate_.getLogger());

      ACE_Time_Value delay(5, 0);  // timer = 5 seconds + 0 usec = 5 sec
      ACE_Time_Value repeat(5, 0); // timer = 5 seconds + 0 usec = 5 sec

      timerId_ = timeManager_.schedule_timer(sendTimer.handler(),
                                             0,
                                             delay,
                                             repeat);

      if (timerId_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }
   }

   void
   SourceClient_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      //          will also destroy the general timer class constructed in
      //          ccm_activate.
      timeManager_.cancel_timer(timerId_);
   }

   void
   SourceClient_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   int
   SourceClient_comp_exec_i::invokeInterface()
   {
      std::stringstream msg;

      msg << "* This is message # " << counter_
          << " from the SourceClientBizLogic! *";

      ++counter_;

      std::string message = msg.str();

      // EXAMPLE: Since this is a non-local (i.e., non-collocated) object
      //          reference, caching of the reference is not safe as the
      //          remote object could be moved, etc. This is the reason that
      //          the object reference is placed into a local variable that is
      //          recreated every time the reference is used.
      SNA_Examples::EchoConnect_obj_var obj =
            ciao_context_->get_connection_echoConnectRecept();

      if ( ! CORBA::is_nil(obj.in()))
      {
         try {
            obj->echoText(message.c_str());
         } catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
         }
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(), "Error calling echoText()");
         return -1;
      }

      return 0;
   }

   extern "C"
   SNA_EXAMPLES_SOURCECLIENT_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_SourceClient_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         SourceClient_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
