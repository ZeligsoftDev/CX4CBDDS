//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup StateManager_comp
/// @{
/// @file   SNA_Examples_StateManager_comp_exec.cpp
/// @brief  Implementation of executor classes for the StateManager_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#include "SNA_Examples_StateManager_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: Included for random number generation
#include <ace/OS_NS_stdlib.h>
#include <ace/OS_NS_time.h>

// EXAMPLE: This include was added by hand in order to create a timer
#include "SNA_GeneralTimer.h"

namespace CIAO_SNA_Examples_StateManager_comp_Impl
{

   /**
    * Component Executor Implementation Class: StateManager_comp_exec_i
    */

   StateManager_comp_exec_i::StateManager_comp_exec_i() :
      boilerplate_("StateManager_comp",
                   "SNA_Examples"),
      lastStateCommanded_(SNA_Examples::STARTUP_STATE),
      timerCount_ (0),
      timerId_    (-1)
   {
   }

   StateManager_comp_exec_i::~StateManager_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   StateManager_comp_exec_i::reactor()
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

   void StateManager_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_
         = ::SNA_Examples::CCM_StateManager_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void StateManager_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void StateManager_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      scheduleNewTimer(5);

      // Initialize random number generator
      ACE_OS::srand(ACE_OS::time(0));
   }

   void StateManager_comp_exec_i::ccm_passivate()
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

   void StateManager_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   void StateManager_comp_exec_i::scheduleNewTimer(time_t sec, suseconds_t usec)
   {
      // Cancel any existing timer
      timeManager_.cancel_timer(timerId_);

      // Don't schedule a new timer if component has been passivated and removed
      if (boilerplate_.getComponentState() != SNA::CompBoilerplate::ACTIVATED)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Timer not scheduled since component is no longer in "
                      "the activated state");

         return;
      }

      typedef SNA_GENERAL_TIMER_T(StateManager_comp_exec_i) TimerType;

      ACE_Event_Handler_var sendTimer =
         new TimerType(this,
                       &StateManager_comp_exec_i::changeState,
                       boilerplate_.getLogger());

      ACE_Time_Value delay(sec, usec);

      timerId_ = timeManager_.schedule_timer(sendTimer.handler(), 0, delay);

      if (timerId_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule timer");
      }
   }

   SNA_Examples::SystemState StateManager_comp_exec_i::getNextState()
   {
      SNA_Examples::SystemState nextState;

      // If last commanded STANDBY, then randomly choose between the two
      // operational states.
      if (lastStateCommanded_ == SNA_Examples::STANDBY_STATE)
      {
         int num = ACE_OS::rand() % 2;

         if (0 == num)
         {
            nextState = SNA_Examples::DAYTIME_OPERATIONAL_STATE;
         }
         else
         {
            nextState = SNA_Examples::NIGHTTIME_OPERATIONAL_STATE;
         }
      }
      else
      {
         // If already in an operational state, command transition to STANDBY.
         nextState = SNA_Examples::STANDBY_STATE;
      }

      // Update
      lastStateCommanded_ = nextState;

      return nextState;
   }

   int StateManager_comp_exec_i::changeState()
   {
      SNA_Examples::SystemState newState = getNextState();

      // String describing type of call. This is used in the logging calls
      std::string callType;

      try
      {
         // If number of timer invocations is even, use AMI4CCM
         if (timerCount_ % 2 == 0)
         {
            callType = "AMI4CCM";

            LOG4CXX_INFO(boilerplate_.getLogger(),
                         "Changing state using AMI4CCM calls");

            // Get connections for the AMI4CCM multiplex receptacle. This is
            // the same as the "normal" CORBA way to do this with the exception
            // that instead of using receptacle name yyy from the IDL, the
            // generated receptacle sendc_yyy is used
            SNA_Examples::StateManager_comp::
               sendc_stateControlReceptConnections_var ami_objs =
                  ciao_context_->get_connections_sendc_stateControlRecept();

            unsigned int numResponsesExpected = ami_objs->length();

            // AMI4CCM requires a reply handler to be created to be called when
            // the server completes the implementation of the call, whether due
            // to proper completion or throwing an exception.
            //
            // In this particular example, a reply handler instance is shared
            // between each time the AMI4CCM call is "fanned out" so that the
            // reply handler can keep a scoreboard of responses.
            //
            // The type of the handler is
            // AMI4CCM_<interface name>ReplyHandler_<receptacle name>_i
            ::SNA_Examples::AMI4CCM_StateControl_objReplyHandler_var handler =
                  new AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i(
                        ciao_context_.in(),
                        boilerplate_,
                        numResponsesExpected);


            // Loop through the object references and call AMI4CCM version of
            // call
            for (unsigned int i = 0; i < ami_objs->length(); ++i)
            {
               // The AMI4CCM version of the object reference is similar to the
               // "normal" CORBA version with the exception of the "AMI4CCM_"
               // prefix.
               SNA_Examples::AMI4CCM_StateControl_obj_var obj =
                  ami_objs[i].objref;

               if ( ! CORBA::is_nil(obj.in()))
               {
                  // The AMI4CCM version of the object reference has the AMI
                  // sendc_* versions of all of the methods in the interface.
                  // The sendc_* version of a method as the following
                  // differences from the "normal" version:
                  //    * Always a void return value
                  //    * The first argument is a pointer to an AMI4CCM reply
                  //      handler instance or 0 if the user doesn't care about
                  //      return values, out params, etc.
                  //    * The rest of the arguments include all in and inout
                  //      parameters of the original method. All return values,
                  //      out parameters, and final values of inout parameters
                  //      are inputs to the associated callback in the reply
                  //      handler.
                  obj->sendc_changeState(handler.in(), newState);
               }
            }
         }
         else // If number of timer invocations is odd, use blocking calls
         {
            callType = "synchronous";

            LOG4CXX_INFO(boilerplate_.getLogger(),
                         "Changing state using synchronous calls");

            // Get connections for the multiplex receptacle
            SNA_Examples::StateManager_comp::
               stateControlReceptConnections_var objs =
                  ciao_context_->get_connections_stateControlRecept();

            // Loop through the object references and call interface method
            for (unsigned int i = 0; i < objs->length(); ++i)
            {
               SNA_Examples::StateControl_obj_var obj = objs[i].objref;

               if ( ! CORBA::is_nil(obj.in()))
               {
                  SNA_Examples::ReturnStatus status =
                     obj->changeState(newState);

                  if (status == SNA_Examples::SUCCESS)
                  {
                     LOG4CXX_INFO(boilerplate_.getLogger(),
                                  "Received successful return value from "
                                  "synchronous call");
                  }
                  else
                  {
                     LOG4CXX_ERROR(boilerplate_.getLogger(),
                                  "Received failed return value from "
                                  "synchronous call");
                  }
               }
            }

            // For the synchronous invocations, once they are complete then
            // schedule a new timer
            scheduleNewTimer(5);
         }
      }
      catch (CORBA::OBJECT_NOT_EXIST &)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Caught an OBJECT_NOT_EXIST exception. This is usually "
                      "due to a normal condition where one or more server "
                      "components passivate before this client component");

         return -1;
      }
      catch (CORBA::Exception & excep)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught " << excep._name() <<
                       " exception in " << callType << " call");

         return -1;
      }
      catch (...)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception in " << callType << " call");

         return -1;
      }

      timerCount_++;

      return 0;
   }

   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i::
   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i(
      ::SNA_Examples::CCM_StateManager_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate,
      unsigned int numResponsesExpected) :
         ciao_context_(
               ::SNA_Examples::CCM_StateManager_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate),
         numResponsesExpected_(numResponsesExpected),
         numSuccess_(0),
         numFail_(0)
   {
   }

   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i::
   ~AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i()
   {
   }

   void
   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i::changeState(
      ::SNA_Examples::ReturnStatus ami_return_val)
   {
      if (ami_return_val == SNA_Examples::SUCCESS)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Received successful return value from AMI4CCM call");

         numSuccess_++;
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                      "Received failed return value from AMI4CCM call");

         numFail_++;
      }

      // If the expected number of responses has been received, then reset the
      // counts and schedule a new timer
      if (numSuccess_ + numFail_ == numResponsesExpected_)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Received responses from all AMI4CCM invocations. "
                      "Scheduling a new timer");

         numSuccess_ = 0;
         numFail_    = 0;

         boilerplate_.getCompExecPtr()->scheduleNewTimer(5);
      }
   }

   void
   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i::changeState_excep(
      ::CCM_AMI::ExceptionHolder_ptr excep_holder)
   {
      // Re-raise exception and handle it
      try
      {
         excep_holder->raise_exception();
      }
      catch (CORBA::OBJECT_NOT_EXIST &)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Caught an OBJECT_NOT_EXIST exception. This is usually "
                      "due to a normal condition where one or more server "
                      "components passivate before this client component");
      }
      catch (CORBA::Exception & excep)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught " << excep._name() <<
                       " exception from AMI4CCM changeState call");
      }
      catch (...)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from AMI4CCM "
                       "changeState call");
      }
   }

   void
   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i::getState(
      ::SNA_Examples::SystemState ami_return_val)
   {
      LOG4CXX_INFO(boilerplate_.getLogger(), "Got state " << ami_return_val);
   }

   void
   AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i::getState_excep(
      ::CCM_AMI::ExceptionHolder_ptr excep_holder)
   {
      // Re-raise exception and handle it
      try
      {
         excep_holder->raise_exception();
      }
      catch (CORBA::OBJECT_NOT_EXIST &)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Caught an OBJECT_NOT_EXIST exception. This is usually "
                      "due to a normal condition where one or more server "
                      "components passivate before this client component");
      }
      catch (CORBA::Exception & excep)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught " << excep._name() <<
                       " exception from AMI4CCM getState call");
      }
      catch (...)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from AMI4CCM getState call");
      }
   }

   extern "C"
   SNA_EXAMPLES_STATEMANAGER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_StateManager_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         StateManager_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                            U N C L A S S I F I E D
//==============================================================================
