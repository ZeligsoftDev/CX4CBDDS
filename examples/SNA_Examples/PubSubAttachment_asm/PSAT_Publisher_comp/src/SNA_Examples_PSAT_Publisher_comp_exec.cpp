//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup PSAT_Publisher_comp
/// @{
/// @file   SNA_Examples_PSAT_Publisher_comp_exec.cpp
/// @brief  Implementation of executor classes for the PSAT_Publisher_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_PSAT_Publisher_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This is needed to create a timer.
#include "SNA_GeneralTimer.h"

// EXAMPLE: included to create logging strings
#include <sstream>

// EXAMPLE: This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

// EXAMPLE: This include file was added by hand in order to use the subscribing
//          UDM reference.
#include "PSAT_Publishing_UDM_ref_T.h"


namespace CIAO_SNA_Examples_PSAT_Publisher_comp_Impl
{

   /**
    * Facet Executor Implementation Class: numArrayPub_status_exec_i
    */

   numArrayPub_status_exec_i::numArrayPub_status_exec_i(
      ::SNA_Examples::CCM_PSAT_Publisher_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PSAT_Publisher_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   numArrayPub_status_exec_i::~numArrayPub_status_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::CCM_PSAT::PSAT_Writer_Status_Listener

   void
   numArrayPub_status_exec_i::on_buffer_available()
   {
      LOG4CXX_INFO(boilerplate_.getLogger(),
             "There is an AD buffer available now - restarting sendMsg timer");

      /*
       * EXAMPLE: Previously while trying to invoke create_data, we got a
       *          CCM_PSAT::AD_Buffer_None_Available_Excp exception and asked
       *          to be notified when a buffer became available.  This callback
       *          is being invoked because a buffer is now available.
       *
       *          In real applications, a developer would have a common function
       *          that attempts to create and send a PSAT message that they
       *          would then call from here.  In this example since we are using
       *          a repeating timer to call a function for that purpose, and
       *          since that repeating timer was canceled when we ran out of
       *          buffers, all we need to do is to restart that repeating timer
       *          ASAP and we will start publishing messages again.
       *
       * Note: We will use the boilerplate's "getCompExecPtr()" to get access
       *       to a reference to the component executor so that we
       *       can make calls on its public methods.
       */

      ACE_Time_Value delay (0, 0); // timer = 0 seconds + 0 usec = 0 sec
      bool timerStarted = boilerplate_.getCompExecPtr()->startSendTimer(delay);


      if ( ! timerStarted)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                      "Unable to restart sendMsg timer in on_buffer_available");
      }
   }

   // --------------------------------------------------------------------------

   void
   numArrayPub_status_exec_i::on_buffer_wait_timeout()
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Timeout occurred waiting for free buffer");
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Facet Executor Implementation Class: numArrayPubConnStatus_exec_i
    */

   numArrayPubConnStatus_exec_i::numArrayPubConnStatus_exec_i(
      ::SNA_Examples::CCM_PSAT_Publisher_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PSAT_Publisher_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   numArrayPubConnStatus_exec_i::~numArrayPubConnStatus_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   numArrayPubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_inconsistent_topic");
   }

   // --------------------------------------------------------------------------

   void
   numArrayPubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_requested_incompatible_qos");
   }

   // --------------------------------------------------------------------------

   void
   numArrayPubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_sample_rejected");
   }

   // --------------------------------------------------------------------------

   void
   numArrayPubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_offered_deadline_missed");
   }

   // --------------------------------------------------------------------------

   void
   numArrayPubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_offered_incompatible_qos");
   }

   // --------------------------------------------------------------------------

   void
   numArrayPubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind status_kind)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_DEBUG(boilerplate_.getLogger(),
               "on_unexpected_status called with status "
            << CIAO::DDS4CCM::translate_statuskind(status_kind));
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Component Executor Implementation Class: PSAT_Publisher_comp_exec_i
    */
   PSAT_Publisher_comp_exec_i::PSAT_Publisher_comp_exec_i() :
         boilerplate_("PSAT_Publisher_comp",
                      "SNA_Examples"),
         compId_               (0),
         sendTimerId_          (-1),
         sendTimerInitialDelay_(5, 0), // 5 secs + 0 usec = 5 sec
         sendTimerRepeat_      (5, 0), // 5 secs + 0 usec = 5 sec
         sendMsgLoggingModulo_ (1),
         sendMsgCount_         (0)
   {
   }

   // --------------------------------------------------------------------------

   PSAT_Publisher_comp_exec_i::~PSAT_Publisher_comp_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Supported operations and attributes.
   ACE_Reactor*
   PSAT_Publisher_comp_exec_i::reactor()
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

   // --------------------------------------------------------------------------

   // Component attributes and port operations.

   ::CORBA::Long
   PSAT_Publisher_comp_exec_i::compId()
   {
      return this->compId_;
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Publisher_comp_exec_i::compId(
      const ::CORBA::Long compId)
   {
      this->compId_ = compId;
   }

   // --------------------------------------------------------------------------

   ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
   PSAT_Publisher_comp_exec_i::get_numArrayPub_status()
   {
      if (::CORBA::is_nil(this->ciao_numArrayPub_status_.in()))
      {
         numArrayPub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numArrayPub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener::_nil());

         this->ciao_numArrayPub_status_ = tmp;
      }

      return
         ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener::_duplicate(
            this->ciao_numArrayPub_status_.in());
   }

   // --------------------------------------------------------------------------

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   PSAT_Publisher_comp_exec_i::get_numArrayPubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_numArrayPubConnStatus_.in()))
      {
         numArrayPubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numArrayPubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_numArrayPubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_numArrayPubConnStatus_.in());
   }

   // --------------------------------------------------------------------------

   // Operations from Components::SessionComponent.

   void
   PSAT_Publisher_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_PSAT_Publisher_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Publisher_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to read values from an example configuration file
      //////////////////////////////////////////////////////////////////////////

      SNA::ConfigParams psat_example_cfg;
      const std::string PSAT_ExampleConfigFilename = "PSAT_Example.cfg";

      if ( psat_example_cfg.init(PSAT_ExampleConfigFilename) )
      {
         this->read_config_ace_time_value
                         ("PSAT_Example.publisher.sendMsgTimer.initialDelay",
                          psat_example_cfg,
                          sendTimerInitialDelay_);

         this->read_config_ace_time_value
                         ("PSAT_Example.publisher.sendMsgTimer.repeat",
                          psat_example_cfg,
                          sendTimerRepeat_);

         psat_example_cfg.lookupValue
            ("PSAT_Example.publisher.sendMsgLoggingModulo",
             sendMsgLoggingModulo_);
      }
      else
      {
         LOG4CXX_WARN(boilerplate_.getLogger(),
                      "Could not open config file '" <<
                      PSAT_ExampleConfigFilename <<
                      "' for the PSAT example.  Using defaults");
      }

      LOG4CXX_DEBUG(boilerplate_.getLogger(),
         "================== RUN PARAMETERS ==================\n" <<
         "sendTimerInitialDelay_ : " << sendTimerInitialDelay_ << " secs\n" <<
         "sendTimerRepeat_       : " << sendTimerRepeat_       << " secs\n" <<
         "sendMsgLoggingModulo_  : Log every " <<
         sendMsgLoggingModulo_  << "th published message\n" <<
         "====================================================");

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Publisher_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to setup the send message timer here.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: Attempt to start a repeating timer to invoke this component's
      //          sendMsg function.  If we are unable to start a timer, this
      //          means the component has failed the state change into
      //          ccm_activate and we should indicate this.
      //
      bool timerStarted = this->startSendTimer(sendTimerInitialDelay_);
      if ( ! timerStarted)
      {
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Publisher_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      // will also destroy the general timer class constructed in ccm_activate.
      timeManager_.cancel_timer(sendTimerId_, 0, 0);
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Publisher_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   extern "C"
   SNA_EXAMPLES_PSAT_PUBLISHER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_PSAT_Publisher_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         PSAT_Publisher_comp_exec_i);

      return retval;
   }

   // --------------------------------------------------------------------------

   bool PSAT_Publisher_comp_exec_i::startSendTimer(const ACE_Time_Value & delay)
   {
      typedef SNA_GENERAL_TIMER_T(PSAT_Publisher_comp_exec_i) TimerType;

      // EXAMPLE: The first parameter of the SNA_GENERAL_TIMER class constructor
      // passes a reference to the component executor, used when registering the
      // callback handler. The second parameter of this constructor is the
      // method to callback on timer events. The third parameter of this
      // constructor passes the logger to the timer to provide context into
      // where the log messages are coming from within the timer class.
      ACE_Event_Handler_var sendMsgTimer =
            new TimerType(this,
                          &PSAT_Publisher_comp_exec_i::sendMsg,
                          boilerplate_.getLogger());

      /*
       * EXAMPLE: Using the time manager object, you can schedule the send
       * message timer by calling schedule_timer. The parameters to schedule
       * timer are:
       *
       * sendMsgTimer     - The SNA_GENERAL_TIMER_T object constructed above,
       *                    this provides an event handler that is registered
       *                    with the ACE reactor.
       * 0                - In this example we do not provide arguments to the
       *                    reactor.
       * delay            - The amount to delay the 1st timer event by.
       * sendTimerRepeat_ - Once the timer has fired for the first time, this is
       *                    the time interval between each subsequent firings.
       *                    It can not be set by the caller in order to ensure
       *                    that if it is shutdown (because sendMsg cannot get
       *                    anymore AD buffers), when it is restarted, the same
       *                    repeat interval will be used.
       *
       */
      sendTimerId_ = timeManager_.schedule_timer(sendMsgTimer.handler(),
                                                 0,
                                                 delay,
                                                 sendTimerRepeat_);

      // EXAMPLE: If the sendTimerId_ is less then 0, this indicates that we had
      // issues starting the timer and should indicate this as a failure.

      return (sendTimerId_ >= 0);
   }

   // --------------------------------------------------------------------------

   bool PSAT_Publisher_comp_exec_i::isOkayToLogMsg(int msgCnt)
   {
      return ((msgCnt - 1) % sendMsgLoggingModulo_) == 0;
   }

   // --------------------------------------------------------------------------

   int PSAT_Publisher_comp_exec_i::sendMsg()
   {
      sendMsgCount_++;

      // Get object reference for writer interface
      ::SNA_Examples::PSAT_Example_UDM_conn::PSAT_Writer_var writerObj =
            ciao_context_->get_connection_numArrayPub_data();

      if (CORBA::is_nil(writerObj.in()))
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Connector writer receptacle is nil");

         return -1; // Timer invoking this function will be canceled.
      }

      // Get a PSAT buffer, write data into it, and then publish
      try
      {
         // Step 1: Create the UDM reference using the templated smart pointer
         // class.
         typedef CCM_PSAT::Publishing_UDM_ref<
               ::SNA_Examples::PSAT_Example_UDM_msg,
               ::SNA_Examples::PSAT_Example_UDM_conn::PSAT_Writer>
               PSAT_Example_UDM_msg_Ref_t;

         // Create data is called in the constructor of the smart pointer class.
         PSAT_Example_UDM_msg_Ref_t udm_ref(writerObj.in());

         // ----------------

         // STEP 2: Fill out the UDM and AD buffer

         SNA_Examples::PSAT_Example_UDM_msg & udm = udm_ref.udm();

         // Filling out a custom field in the UDM
         udm.sequenceNum = sendMsgCount_;

         // Get pointer to beginning of the PSAT buffer
         uint64_t * data = reinterpret_cast<uint64_t *>(
               udm.psat_hdr.sample_start_address);

         if (0 == data)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "Got a null pointer from UDM");

            return -1; // Timer invoking this function will be canceled.
         }

         const int numNumsWritten = 1000; // EXAMPLE: how many numbers to write

         // writer data into buffer
         for (int i = 0; i < numNumsWritten; ++i)
         {
            data[i] = sendMsgCount_ * (compId_ + i);
         }

         // Set the size of the data to send. This prevents the entire buffer
         // being transferred unnecessarily
         udm.psat_hdr.psat_view.block_length =
               numNumsWritten * sizeof(uint64_t);

         /*
          * These two fields are only in the UDM so they can be used on the
          * subscriber side to easily correlate the logging output from each
          * publisher to each subscriber.  They are not otherwise required
          * for a PSAT message.
          */
         udm.publisherId = compId_;
         udm.msgCnt      = sendMsgCount_;

         // ----------------

         if (this->isOkayToLogMsg(sendMsgCount_))
         {
            // EXAMPLE: create a string with first several numbers written so
            //          that correct transmission can be checked on the other
            //          side
            std::stringstream dataStringStream;
            for(int i = 0; i < 10; ++i)
            {
               dataStringStream << "data[" << i << "] = " <<
                     data[i] << std::endl;
            }

            // EXAMPLE: use log4cxx to write out data sent
            LOG4CXX_INFO(boilerplate_.getLogger(),
                         "MSG[" << compId_ << " : " <<
                         sendMsgCount_      << "] .. " <<
                         "Sending Attachment (first 10 numbers):\n" <<
                         dataStringStream.str());
         }

         // ----------------

         // STEP3: Publish the PSAT sample
         writerObj->write_one(udm);
      }
      catch (CCM_DDS::InternalError & excep)
      {
         // This exception can be thrown due to a DDS error. The
         // translate_retcode function creates a human-readable string from a
         // DDS return code.

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught InternalError on write_one call with "
                       "DDS return code: "
               << ::CIAO::DDS4CCM::translate_retcode(excep.error_code));

         return -1; // Timer invoking this function will be canceled.
      }
      catch (CCM_PSAT::AD_Buffer_None_Available_Excp & excep)
      {
         // This exception can be thrown due to no buffers being available when
         // calling create_data

         LOG4CXX_WARN(boilerplate_.getLogger(),
                       "Caught AD_Buffer_None_Available_Excp with information: "
               << "topic name = "   << excep.topic_name   << " : "
               << "connector id = " << excep.connector_id << " : "
               << "explanation = "  << excep.explanation);

         // get a notification callback (on_buffer_available) when a buffer is
         // free. Note that no blocking occurs here. This is purely callback
         // driven and sets up a future notification using the callback.
         writerObj->notify_when_buffer_is_free(CCM_PSAT::PSAT_TIMEOUT_INFINITE);

         return -1; // Timer invoking this function will be canceled.
      }
      catch (CCM_PSAT::Invalid_UDM_PSAT_Header_Excp & excep)
      {
         // This exception can be thrown by filling out the UDM incorrectly or
         // by releasing a buffer more than once

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught Invalid_UDM_PSAT_Header_Excp with information: "
               << "topic name = "   << excep.topic_name   << " : "
               << "connector id = " << excep.connector_id << " : "
               << "explanation = "  << excep.explanation);

         return -1; // Timer invoking this function will be canceled.
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex);

         return -1; // Timer invoking this function will be canceled.
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         return -1; // Timer invoking this function will be canceled.
      }

      return 0; // Normal return.  Timer invoking this function will fire again
                // at the next repeat interval.
   }

   // --------------------------------------------------------------------------

   bool PSAT_Publisher_comp_exec_i::read_config_ace_time_value
                                  (const std::string & configTagName,
                                   SNA::ConfigParams & configParams,
                                   ACE_Time_Value    & timeValue)
   {
      int secs;
      int microsecs;

      if (configParams.lookupValue(configTagName + ".secs",     secs) &&
         (configParams.lookupValue(configTagName + ".microsecs",microsecs)))
      {
         timeValue.set(secs, microsecs);
         return true;
      }
      return false;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
