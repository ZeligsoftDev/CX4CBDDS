//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Airplane_comp
/// @{
/// @file   SNA_Examples_Airplane_comp_exec.cpp
/// @brief  Implementation of executor classes for the Airplane_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_Airplane_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This include was added by hand in order to create a timer
#include "SNA_GeneralTimer.h"

namespace CIAO_SNA_Examples_Airplane_comp_Impl
{

   /**
    * Component Executor Implementation Class: Airplane_comp_exec_i
    */

   Airplane_comp_exec_i::Airplane_comp_exec_i() :
      boilerplate_("Airplane_comp", "SNA_Examples")
   {
   }

   Airplane_comp_exec_i::~Airplane_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   Airplane_comp_exec_i::reactor()
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

   void Airplane_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ = ::SNA_Examples::CCM_Airplane_comp_Context::_narrow(
         ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void Airplane_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void Airplane_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      typedef SNA_GENERAL_TIMER_T(Airplane_comp_exec_i) TimerType;

      ACE_Event_Handler_var sendTimer =
         new TimerType(this,
                       &Airplane_comp_exec_i::queryWeather,
                       boilerplate_.getLogger());

      ACE_Time_Value delay(5, 0); // timer = 5 seconds + 0 usec = 5 sec
      ACE_Time_Value repeat(1, 0); // timer = 5 seconds + 0 usec = 5 sec

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

   void Airplane_comp_exec_i::ccm_passivate()
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
   }

   void Airplane_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_remove");

      boilerplate_.ccm_remove();
   }

   int Airplane_comp_exec_i::queryWeather()
   {
      // EXAMPLE: Since this is a non-local (i.e., non-collocated) object
      //          reference, caching of the reference is not safe as the
      //          remote object could be moved, etc. This is the reason that
      //          the object reference is placed into a local variable that is
      //          recreated every time the reference is used.
      SNA_Examples::WeatherInformation_obj_var obj =
         ciao_context_->get_connection_weatherInformationRecept();

      if ( ! CORBA::is_nil(obj.in()))
      {
         // EXAMPLE: Since this is an out parameter, it is allocated by the
         //          caller to be filled in by the callee.
         SNA_Examples::WeatherInformation info;

         CORBA::Boolean ok = false;

         try
         {
            ok = obj->getWeatherInformation(info);

            if (ok)
            {
               LOG4CXX_INFO(boilerplate_.getLogger(),
                  "Last Temperature Reading = " << info.lastTemperature);

               LOG4CXX_INFO(boilerplate_.getLogger(),
                  "Average Temperature Reading = " << info.averageTemperature);
            }
            else
            {
               LOG4CXX_INFO(boilerplate_.getLogger(),
                  "Invalid temperature reading, maybe the weather station has "
                  "not received a temperature reading yet?");
            }
         }
         catch (const CORBA::Exception & ex)
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

   extern "C" SNA_EXAMPLES_AIRPLANE_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Airplane_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         Airplane_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
