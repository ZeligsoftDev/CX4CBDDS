//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup BasicPublisher_comp
/// @{
/// @file   SNA_Examples_BasicPublisher_comp_exec.cpp
/// @brief  Implementation of executor classes for the BasicPublisher_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_BasicPublisher_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: These includes were added by hand in order to create a timer and to
//          to read a configuration file.
#include "SNA_GeneralTimer.h"
#include "SNA_ConfigParams.h"

// This is needed to translate DDS4CCM return codes into readable strings.
#include "Utils.h"

namespace CIAO_SNA_Examples_BasicPublisher_comp_Impl
{

   /**
    * Facet Executor Implementation Class: testDataPubConnStatus_exec_i
    */

   // EXAMPLE: When using the inherited implementation, make sure to initilize
   //          the SNA::LoggingObject base class
   testDataPubConnStatus_exec_i::testDataPubConnStatus_exec_i(
      ::SNA_Examples::CCM_BasicPublisher_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         SNA::LoggingObject(boilerplate.getLoggerNameFull()),
         ciao_context_(
            ::SNA_Examples::CCM_BasicPublisher_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   testDataPubConnStatus_exec_i::~testDataPubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

// These are defined out so that:
// 1. The inherited implementations will be used
// 2. The declarations are still available if the user decides to overload a
//    particular callback
// 3. Ease of merging/melding/diffing
#if 0
   void
   testDataPubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataPubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataPubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataPubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataPubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataPubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
      /* Your code here. */
   }
#endif

   /**
    * Component Executor Implementation Class: BasicPublisher_comp_exec_i
    */

   BasicPublisher_comp_exec_i::BasicPublisher_comp_exec_i() :
         boilerplate_("BasicPublisher_comp",
                      "SNA_Examples"),
         timerId_(-1),
         numSamplesToPublishEachTime_(1)
   {
   }

   BasicPublisher_comp_exec_i::~BasicPublisher_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   BasicPublisher_comp_exec_i::reactor()
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

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   BasicPublisher_comp_exec_i::get_testDataPubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_testDataPubConnStatus_.in()))
      {
         testDataPubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            testDataPubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_testDataPubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_testDataPubConnStatus_.in());
   }

   // Operations from Components::SessionComponent.

   void
   BasicPublisher_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_BasicPublisher_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   BasicPublisher_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void
   BasicPublisher_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: There is a configuration file that was created just for this
      //          basic publisher component.  We want to read from it the number
      //          of samples to publish each time the timer we are also setting
      //          below fires off.
      SNA::ConfigParams basicPubParams;

      if (basicPubParams.init("BasicPublisher.cfg"))
      {
         basicPubParams.lookupValue(
            "BasicPublisher.numSamplesToPublishEachTime",
            numSamplesToPublishEachTime_);
      }

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      typedef SNA_GENERAL_TIMER_T(BasicPublisher_comp_exec_i) TimerType;

      ACE_Event_Handler_var sendTimer =
         new TimerType(this,
                       &BasicPublisher_comp_exec_i::sendSample,
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
   BasicPublisher_comp_exec_i::ccm_passivate()
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
   BasicPublisher_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   int
   BasicPublisher_comp_exec_i::sendSample()
   {
      // EXAMPLE: This is the generated C++ structure given by the IDL
      //          definition from the ports directory. This structure has no
      //          meaning and is shown only for example. The fields of this
      //          structure provide examples of using the various IDL to C++
      //          data types.
      SNA_Examples::TestData_msg sample;

      sample.myInt32  = 10;
      sample.myInt64  = 5824169525;
      sample.myDouble = 3.5;
      sample.myString = CORBA::string_dup("Hello, World!");
      sample.myState  = SNA_Examples::STATE_PASS;
      sample.myColor  = SNA_Examples::COLOR_RED;

      /**
       * Reference to the writer interface to the DDS4CCM connector for the
       * SNA_Examples::TestData type
       */
      ::SNA_Examples::TestData_conn::Writer_var testDataPubWriter;

      testDataPubWriter = ciao_context_->get_connection_testDataPub_data();

      if (CORBA::is_nil(testDataPubWriter.in()))
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "The writer receptacle is null");

         return -1; // Don't reschedule timer
      }

      // EXAMPLE: This will write the sample constructed above for the number of
      //          times previously configured in the ccm_activate method. The
      //          testDataPubWriter is a data member created by hand above.
      try
      {
         for (unsigned int cnt = 0; cnt < numSamplesToPublishEachTime_; ++cnt)
         {
            testDataPubWriter->write_one(sample, DDS::HANDLE_NIL);
         }
      }
      catch (CCM_DDS::InternalError & ex) // catch "normal" exception
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught InternalError exception from write_one call. "
                       "Contained DDS error code is "
                       << ::CIAO::DDS4CCM::translate_retcode(ex.error_code));


         return -1; // Don't reschedule timer
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex);

         return -1; // Don't reschedule timer
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         return -1; // Don't reschedule timer
      }

      // EXAMPLE: Logs a message displaying the number of samples that were sent
      LOG4CXX_INFO(boilerplate_.getLogger(),
                   "Sent "<< numSamplesToPublishEachTime_ << " test sample(s)");

      return 0;
   }

   extern "C"
   SNA_EXAMPLES_BASICPUBLISHER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_BasicPublisher_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         BasicPublisher_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
