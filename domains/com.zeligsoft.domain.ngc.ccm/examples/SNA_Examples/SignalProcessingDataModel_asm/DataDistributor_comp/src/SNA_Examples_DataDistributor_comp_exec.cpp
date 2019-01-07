//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataDistributor_comp
/// @{
/// @file   SNA_Examples_DataDistributor_comp_exec.cpp
/// @brief  Implementation of executor classes for the DataDistributor_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_DataDistributor_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This is needed to create a timer.
#include "SNA_GeneralTimer.h"

// EXAMPLE: This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

#include <vsip/matrix.hpp>
#include <vsip/dense.hpp>

#include "SNA_DataViewTranslator.h"

#include "PSAT_Publishing_UDM_ref_T.h"

namespace CIAO_SNA_Examples_DataDistributor_comp_Impl
{

   /**
    * Facet Executor Implementation Class: dataMapPub_status_exec_i
    */

   dataMapPub_status_exec_i::dataMapPub_status_exec_i(
      ::SNA_Examples::CCM_DataDistributor_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataDistributor_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   dataMapPub_status_exec_i::~dataMapPub_status_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::CCM_PSAT::PSAT_Writer_Status_Listener

   void
   dataMapPub_status_exec_i::on_buffer_available()
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_INFO(boilerplate_.getLogger(),
             "There is an AD buffer available now - restarting sendData timer");

      /*
       * EXAMPLE: Previously while trying to invoke create_data, we got a
       *          CCM_PSAT::AD_Buffer_None_Available_Excp exception and asked
       *          to be notified when a buffer became available.  This callback
       *          is being invoked because a buffer is now available.
       *
       *          In real applications, a developer would have a common function
       *          that attempts to create and send a complete sample that they
       *          would then call from here.  In this example since we are using
       *          a repeating timer to call a function for that purpose, and
       *          since that repeating timer was canceled when we ran out of
       *          buffers, all we need to do is to restart that repeating timer
       *          ASAP and we will start publishing again.
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
                      "Unable to restart sendData timer in on_buffer_available");
      }
   }

   // --------------------------------------------------------------------------

   void
   dataMapPub_status_exec_i::on_buffer_wait_timeout()
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Timeout occurred waiting for free buffer");
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Facet Executor Implementation Class: dataMapPubConnStatus_exec_i
    */

   dataMapPubConnStatus_exec_i::dataMapPubConnStatus_exec_i(
      ::SNA_Examples::CCM_DataDistributor_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataDistributor_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   dataMapPubConnStatus_exec_i::~dataMapPubConnStatus_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   dataMapPubConnStatus_exec_i::on_inconsistent_topic(
         ::DDS::Topic_ptr /* the_topic */,
         const ::DDS::InconsistentTopicStatus & status )
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_inconsistent_topic : "
            "total_count = " << status.total_count << ", "
            "total_count_change = " << status.total_count_change);
   }

   // --------------------------------------------------------------------------

   void
   dataMapPubConnStatus_exec_i::on_requested_incompatible_qos(
         ::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::RequestedIncompatibleQosStatus & status )
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_requested_incompatible_qos : "
            "total_count = " << status.total_count << ", "
            "total_count_change = " << status.total_count_change << ", "
            "last_policy_id = " << status.last_policy_id);
   }

   // --------------------------------------------------------------------------

   void
   dataMapPubConnStatus_exec_i::on_sample_rejected(
         ::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::SampleRejectedStatus & status )
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_sample_rejected : " <<
            "total_count = " << status.total_count << ", " <<
            "total_count_change = " << status.total_count_change << ", " <<
            "last_reason = " <<
            CIAO::DDS4CCM::translate_rejectedstatuskind(status.last_reason));
   }

   // --------------------------------------------------------------------------

   void
   dataMapPubConnStatus_exec_i::on_offered_deadline_missed(
         ::DDS::DataWriter_ptr /* the_writer */,
         const ::DDS::OfferedDeadlineMissedStatus & status )
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_offered_deadline_missed : "
            "total_count = " << status.total_count << ", "
            "total_count_change = " << status.total_count_change);
   }

   // --------------------------------------------------------------------------

   void
   dataMapPubConnStatus_exec_i::on_offered_incompatible_qos(
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
   dataMapPubConnStatus_exec_i::on_unexpected_status(
         ::DDS::Entity_ptr /* the_entity */,
         ::DDS::StatusKind status_kind )
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
    * Component Executor Implementation Class: DataDistributor_comp_exec_i
    */

   DataDistributor_comp_exec_i::DataDistributor_comp_exec_i() :
         boilerplate_("DataDistributor_comp",
                      "SNA_Examples"),
         sendTimerId_           (-1),
         sendTimerInitialDelay_ (5, 0), // 5 secs + 0 usec = 5 sec
         sendTimerRepeat_       (5, 0), // 5 secs + 0 usec = 5 sec
         sendDataLoggingModulo_ (1),
         sendDataCount_         (0),
         timeManager_           (),
         lib_()
   {
   }

   // --------------------------------------------------------------------------

   DataDistributor_comp_exec_i::~DataDistributor_comp_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Supported operations and attributes.
   ACE_Reactor*
   DataDistributor_comp_exec_i::reactor()
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

   ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
   DataDistributor_comp_exec_i::get_dataMapPub_status()
   {
      if (::CORBA::is_nil(this->ciao_dataMapPub_status_.in()))
      {
         dataMapPub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            dataMapPub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener::_nil());

         this->ciao_dataMapPub_status_ = tmp;
      }

      return
         ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener::_duplicate(
            this->ciao_dataMapPub_status_.in());
   }

   // --------------------------------------------------------------------------

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   DataDistributor_comp_exec_i::get_dataMapPubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_dataMapPubConnStatus_.in()))
      {
         dataMapPubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            dataMapPubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_dataMapPubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_dataMapPubConnStatus_.in());
   }

   // --------------------------------------------------------------------------

   // Operations from Components::SessionComponent.

   void
   DataDistributor_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_DataDistributor_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   // --------------------------------------------------------------------------

   void
   DataDistributor_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to read values from an example configuration file
      //////////////////////////////////////////////////////////////////////////

      SNA::ConfigParams spdm_example_cfg;
      const std::string SPDM_ExampleConfigFilename = "SPDM_Example.cfg";

      if ( spdm_example_cfg.init(SPDM_ExampleConfigFilename) )
      {
         this->read_config_ace_time_value
                   ("SPDM_Example.dataDistributor.sendDataTimer.initialDelay",
                    spdm_example_cfg,
                    sendTimerInitialDelay_);

         this->read_config_ace_time_value
                   ("SPDM_Example.dataDistributor.sendDataTimer.repeat",
                    spdm_example_cfg,
                    sendTimerRepeat_);

         spdm_example_cfg.lookupValue
            ("SPDM_Example.dataDistributor.sendDataLoggingModulo",
             sendDataLoggingModulo_);
      }
      else
      {
         LOG4CXX_WARN(boilerplate_.getLogger(),
                      "Could not open config file '" <<
                      SPDM_ExampleConfigFilename <<
                      "' for the SPDM example.  Using defaults");
      }

      LOG4CXX_DEBUG(boilerplate_.getLogger(),
         "==================== RUN PARAMETERS ========================\n" <<
         "sendTimerInitialDelay_ : " << sendTimerInitialDelay_ << " secs\n" <<
         "sendTimerRepeat_       : " << sendTimerRepeat_       << " secs\n" <<
         "sendDataLoggingModulo_ : Log every " <<
         sendDataLoggingModulo_  << "th complete sample\n" <<
         "============================================================");

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   DataDistributor_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to setup the send Data timer here.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: Attempt to start a repeating timer to invoke this component's
      //          sendData function.  If we are unable to start a timer, this
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
   DataDistributor_comp_exec_i::ccm_passivate()
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
   DataDistributor_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   extern "C"
   SNA_EXAMPLES_DATADISTRIBUTOR_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataDistributor_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         DataDistributor_comp_exec_i);

      return retval;
   }

   // --------------------------------------------------------------------------

   bool DataDistributor_comp_exec_i::startSendTimer(const ACE_Time_Value& delay)
   {
      typedef SNA_GENERAL_TIMER_T(DataDistributor_comp_exec_i) TimerType;

      // EXAMPLE: The first parameter of the SNA_GENERAL_TIMER class constructor
      // passes a reference to the component executor, used when registering the
      // callback handler. The second parameter of this constructor is the
      // method to callback on timer events. The third parameter of this
      // constructor passes the logger to the timer to provide context into
      // where the log messages are coming from within the timer class.
      ACE_Event_Handler_var sendDataTimer =
            new TimerType(this,
                          &DataDistributor_comp_exec_i::sendData,
                          boilerplate_.getLogger());

      /*
       * EXAMPLE: Using the time manager object, you can schedule the send
       * message timer by calling schedule_timer. The parameters to schedule
       * timer are:
       *
       * sendDataTimer    - The SNA_GENERAL_TIMER_T object constructed above,
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
      sendTimerId_ = timeManager_.schedule_timer(sendDataTimer.handler(),
                                                 0,
                                                 delay,
                                                 sendTimerRepeat_);

      // EXAMPLE: If the sendTimerId_ is less then 0, this indicates that we had
      // issues starting the timer and should indicate this as a failure.

      return (sendTimerId_ >= 0);
   }

   // --------------------------------------------------------------------------

   bool DataDistributor_comp_exec_i::isOkayToLogMsg(int msgCnt)
   {
      return ((msgCnt - 1) % sendDataLoggingModulo_) == 0;
   }

   // --------------------------------------------------------------------------

   int DataDistributor_comp_exec_i::sendData()
   {
      sendDataCount_++; // Sending One complete sample (4 sub-samples)

      // Get object reference for writer interface
      ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Writer_var writerObj =
            ciao_context_->get_connection_dataMapPub_data();

      if (CORBA::is_nil(writerObj.in()))
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << sendDataCount_ << "] .. " <<
                       "Connector writer receptacle is nil");

         return -1;
      }

      // Get a PSAT buffer, write data into it, and then publish
      try
      {
         typedef CCM_PSAT::Publishing_UDM_ref<
               ::SNA_Examples::DataMap_UDM_msg,
               ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Writer>
               DataMap_UDM_Ref_t;

         DataMap_UDM_Ref_t udm_ref(writerObj.in());

         // Fill out the publisher role. This component is publishing child
         // data samples
         udm_ref.udm().spdm_hdr.pub_role = ::CCM_SPDM::CHILD_DATA;

         // Fill out the number of sub-samples (i.e., number of chips/children)
         udm_ref.udm().spdm_hdr.number_of_sub_samples = 4;

         // Get pointer to beginning of the PSAT buffer
         int * dataPtr =
               reinterpret_cast<int *>(udm_ref.udm().psat_hdr.sample_start_address);

         if (0 == dataPtr)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << sendDataCount_ << "] .. " <<
                          "Got a null pointer from UDM");
            return -1;
         }

         // EXAMPLE: This example will interpret the parent data above to be a
         // matrix with 10 rows by 10 columns

         // Create a new Dense block with user-defined storage to our data
         vsip::Dense<2,int> dataBlock(vsip::Domain<2>(10,10),dataPtr);

         // Create a Matrix that uses the Block with our user data
         vsip::Matrix<int> firstMatrix(dataBlock);

         // Admit data to VSIPL++ control.  This must be done before the data is
         // accessed using VSIPL++ constructs.
         firstMatrix.block().admit(true);

         for (unsigned int row=0; row < firstMatrix.size(0); ++row)
         {
            for (unsigned int col=0; col < firstMatrix.size(1); ++col)
            {
                  // expected values should ramp based on the index
                  int rampValue = row * firstMatrix.size(1) + col;
                  firstMatrix(row,col) = rampValue;
            }
         }

         vsip::serialization::Descriptor dataDescriptor;
         vsip::serialization::describe_user_storage(
               firstMatrix.block(),dataDescriptor);

         // Initialize the custom field in the UDM. This is used for content
         // filtering to enable the chip to arrive at the transformer with which
         // it is assigned.
         udm_ref.udm().message_number = 0;

         // EXAMPLE:
         // This example will take the map populated above data, and split it up
         // into 4 chips (children) from the original 10 X 10 matrix. The chips
         // will each be a 5 X 5 matrix as shown below:
         //
         // -----------------------------------
         //     message 0         message 1
         // -----------------------------------
         // - 0  1  2  3  4  - 5  6  7  8  9  -
         // - 10 11 12 13 14 - 15 16 17 18 19 -
         // - 20 21 22 23 24 - 25 26 27 28 29 -
         // - 30 31 32 33 34 - 35 36 37 38 39 -
         // - 40 41 42 43 44 - 45 46 47 48 49 -
         // --------------------------------- -
         //     message 2        message 3
         // --------------------------------- -
         // - 50 51 52 53 54 - 55 56 57 58 59 -
         // - 60 61 62 63 64 - 65 66 67 68 69 -
         // - 70 71 72 73 74 - 75 76 77 78 79 -
         // - 80 81 82 83 84 - 85 86 87 88 89 -
         // - 90 91 92 93 94 - 95 96 97 98 99 -
         // -----------------------------------

         // Set up the chip row and chip column sizes to allow us to calculate
         // the actual offset of each message.
         int chipRowSize = 5;
         int chipColSize = 5;

         // The loop shown below will go through the indices of the chips
         // shown above. You can consider the messages above to have the
         // following values:
         // ----
         //
         // message 0 - chipRow = 0
         //             chipCol = 0
         // ----
         // message 1 - chipRow = 0
         //             chipCol = 1
         // ----
         // message 2 - chipRow = 1
         //             chipCol = 0
         // ----
         // message 3 - chipRow = 1
         //             chipCol = 1
         // ----
         //
         for (int chipRow = 0; chipRow < 2; ++chipRow)
         {
            for (int chipCol = 0; chipCol < 2; ++chipCol)
            {
               if (this->isOkayToLogMsg(sendDataCount_))
               {
                  // EXAMPLE: print a log message giving the -
                  //           o Complete sample number
                  //           o Message number (within the complete sample)
                  //           o The ad buffer id
                  LOG4CXX_INFO(boilerplate_.getLogger(),
                        "MSG[" << sendDataCount_ << "] .. " <<
                        "Sending subsample " << udm_ref.udm().message_number <<
                        " with ad_buffer_id = " << udm_ref.udm().psat_hdr.ad_buffer_id);
               }

               // EXAMPLE:
               // Calculate the column and row offset from the parent data
               // to extract each sub-view.
               int columnOffset = chipCol * chipColSize;
               int rowOffset    = chipRow * chipRowSize;

               // EXAMPLE:
               // This function will fill out the appropriate values in the spdm
               // header for us using the VSIPL descriptor. We need to tell this
               // function the child offset/stride/size information using the
               // VSIPL domain objects shown below.
               SNA::DataViewTranslator::cpp_to_spdm_idl(
                     dataDescriptor,
                     vsip::Domain<2>(vsip::Domain<1>(rowOffset,1,5),
                                     vsip::Domain<1>(columnOffset,1,5)),
                                     udm_ref.udm().spdm_hdr);

               // Release the data from VSIPL++ control
               firstMatrix.block().release(true);

               // Publish the PSAT sample
               writerObj->write_one(udm_ref.udm());

               // Increment the udm message number
               ++udm_ref.udm().message_number;
            }
         }
      }
      catch (CCM_DDS::InternalError & excep)
      {
         // This exception can be thrown due to a DDS error. The
         // translate_retcode function creates a human-readable string from a
         // DDS return code.

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << sendDataCount_ << "] .. " <<
                       "Caught InternalError on write_one call with "
                       "DDS return code: "
               << ::CIAO::DDS4CCM::translate_retcode(excep.error_code));

         return -1;
      }
      catch (CCM_PSAT::AD_Buffer_None_Available_Excp & excep)
      {
         // This exception can be thrown due to no buffers being available when
         // calling create_data

         LOG4CXX_WARN(boilerplate_.getLogger(),
                      "MSG[" << sendDataCount_ << "] .. " <<
                      "Caught AD_Buffer_None_Available_Excp with information: "
               << "topic name = "   << excep.topic_name   << " : "
               << "connector id = " << excep.connector_id << " : "
               << "explanation = "  << excep.explanation);

         // get a notification callback (on_buffer_available) when a buffer is
         // free. Note that no blocking occurs here. This is purely callback
         // driven and sets up a future notification using the callback.
         writerObj->notify_when_buffer_is_free(CCM_PSAT::PSAT_TIMEOUT_INFINITE);

         return -1;
      }
      catch (CCM_PSAT::Invalid_UDM_PSAT_Header_Excp & excep)
      {
         // This exception can be thrown by filling out the UDM incorrectly or
         // by releasing a buffer more than once

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << sendDataCount_ << "] .. " <<
                       "Caught Invalid_UDM_PSAT_Header_Excp with information: "
               << "topic name = "   << excep.topic_name   << " : "
               << "connector id = " << excep.connector_id << " : "
               << "explanation = "  << excep.explanation);

         return -1;
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex);

         return -1;
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         return -1;
      }

      return 0;
   }

   // --------------------------------------------------------------------------

   bool DataDistributor_comp_exec_i::read_config_ace_time_value
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

