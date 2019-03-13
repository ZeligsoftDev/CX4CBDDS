//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Slave_comp
/// @{
/// @file   SNA_Examples_Slave_comp_exec.cpp
/// @brief  Implementation of executor classes for the Slave_comp component and
///         its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#include "SNA_Examples_Slave_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: Added to get ACE_OS::sleep
#include <ace/OS_NS_unistd.h>

namespace CIAO_SNA_Examples_Slave_comp_Impl
{

   /**
    * Facet Executor Implementation Class: stateControlFacet_exec_i
    */

   stateControlFacet_exec_i::stateControlFacet_exec_i(
      ::SNA_Examples::CCM_Slave_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_Slave_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   stateControlFacet_exec_i::~stateControlFacet_exec_i()
   {
   }

   // Operations from ::SNA_Examples::StateControl_obj

   ::SNA_Examples::ReturnStatus
   stateControlFacet_exec_i::changeState(
      ::SNA_Examples::SystemState newState)
   {
      // Attempt to change internal state
      bool valid =
         boilerplate_.getCompExecPtr()->setCurrentState(newState, true);

      // Sleep 2 seconds to simulate a state machine transition which takes a
      // long length of time
      ACE_OS::sleep(2);

      SNA_Examples::ReturnStatus ret;

      if (valid)
      {
         ret = SNA_Examples::SUCCESS;
      }
      else
      {
         ret = SNA_Examples::FAILURE;
      }

      return ret;
   }

   ::SNA_Examples::SystemState
   stateControlFacet_exec_i::getState()
   {
      return boilerplate_.getCompExecPtr()->getCurrentState();
   }

   /**
    * Component Executor Implementation Class: Slave_comp_exec_i
    */

   Slave_comp_exec_i::Slave_comp_exec_i() :
         boilerplate_("Slave_comp",
                      "SNA_Examples"),
         currentState_(SNA_Examples::STARTUP_STATE)
   {
   }

   Slave_comp_exec_i::~Slave_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   Slave_comp_exec_i::reactor()
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

   ::SNA_Examples::CCM_StateControl_obj_ptr
   Slave_comp_exec_i::get_stateControlFacet()
   {
      if (::CORBA::is_nil(this->ciao_stateControlFacet_.in()))
      {
         stateControlFacet_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            stateControlFacet_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_StateControl_obj::_nil());

         this->ciao_stateControlFacet_ = tmp;
      }

      return
         ::SNA_Examples::CCM_StateControl_obj::_duplicate(
            this->ciao_stateControlFacet_.in());
   }

   // Operations from Components::SessionComponent.

   void
   Slave_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_Slave_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   Slave_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void
   Slave_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: Change state to STANDBY. In reality, this component would most
      // likely perform self-tests here. Then if pass, go to STANDBY and if
      // failure go to TEST.
      setCurrentState(SNA_Examples::STANDBY_STATE, false);
   }

   void
   Slave_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();
   }

   void
   Slave_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   SNA_Examples::SystemState
   Slave_comp_exec_i::getCurrentState()
   {
      return currentState_;
   }

   bool
   Slave_comp_exec_i::setCurrentState(
      SNA_Examples::SystemState newState,
      bool                      externalCommand)
   {
      bool validTransition = false;

      // table of valid transitions from current state
      switch(currentState_)
      {
         case SNA_Examples::STARTUP_STATE:
            if ( ! externalCommand &&
                  (newState == SNA_Examples::STANDBY_STATE ||
                   newState == SNA_Examples::TEST_STATE))
            {
               validTransition = true;
            }

            break;
         case SNA_Examples::STANDBY_STATE:
            if ( ! externalCommand && newState == SNA_Examples::TEST_STATE)
            {
               validTransition = true;
            }
            else if (externalCommand &&
                       (newState == SNA_Examples::STANDBY_STATE ||
                        newState == SNA_Examples::TEST_STATE ||
                        newState == SNA_Examples::DAYTIME_OPERATIONAL_STATE ||
                        newState == SNA_Examples::NIGHTTIME_OPERATIONAL_STATE ||
                        newState == SNA_Examples::SHUTDOWN_STATE))
            {
               validTransition = true;
            }

            break;
         case SNA_Examples::TEST_STATE:
            if (externalCommand &&
                  (newState == SNA_Examples::TEST_STATE ||
                   newState == SNA_Examples::SHUTDOWN_STATE))
            {
               validTransition = true;
            }

            break;
         case SNA_Examples::DAYTIME_OPERATIONAL_STATE:
            if ( ! externalCommand && newState == SNA_Examples::TEST_STATE)
            {
               validTransition = true;
            }
            else if (externalCommand &&
                       (newState == SNA_Examples::STANDBY_STATE ||
                        newState == SNA_Examples::DAYTIME_OPERATIONAL_STATE))
            {
               validTransition = true;
            }

            break;
         case SNA_Examples::NIGHTTIME_OPERATIONAL_STATE:
            if ( ! externalCommand && newState == SNA_Examples::TEST_STATE)
            {
               validTransition = true;
            }
            else if (externalCommand &&
                       (newState == SNA_Examples::STANDBY_STATE ||
                        newState == SNA_Examples::NIGHTTIME_OPERATIONAL_STATE))
            {
               validTransition = true;
            }

            break;
         case SNA_Examples::SHUTDOWN_STATE:
            // No valid transitions from SHUTDOWN
            break;
      }

      if (validTransition)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Transitioning from " << currentState_ << " to "
                      << newState);

         currentState_ = newState;
      }
      else
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "Invalid transition from " << currentState_ << " to "
                       << newState);

         // Only go to TEST state on failure if not already in SHUTDOWN
         if (currentState_ != SNA_Examples::SHUTDOWN_STATE)
         {
            currentState_ = SNA_Examples::TEST_STATE;
         }
      }

      return validTransition;
   }

   extern "C"
   SNA_EXAMPLES_SLAVE_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Slave_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         Slave_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                            U N C L A S S I F I E D
//==============================================================================
