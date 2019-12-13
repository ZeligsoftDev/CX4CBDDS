// Add file header between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 678c55e0-4d96-4d29-bc58-2b3688499ff7
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010-2019 -- ALL RIGHTS RESERVED
//==============================================================================
//
//==============================================================================
// EXPORT REGULATIONS (EAR99)
//==============================================================================
// DISCLOSURE: 
//
// Warning - This data is subject to the Export Administration Act (Title 22 
// U.S.C. App. 2401 et seq.), as amended. The implementing regulation for 
// this statute is the Export Administration Regulations (EAR) (15 C.F.R.
// 730-774). It may not be transferred, either in its original form, derivative 
// documents, or after being incorporated into other data without first 
// obtaining approval from the U.S. government or as otherwise authorized by 
// U.S. law and regulations. 
//==============================================================================
/// @addtogroup SNA_Examples_BasicPublisher_comp
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
//@@{__SNA_REGEN_MARKER__} - END : 678c55e0-4d96-4d29-bc58-2b3688499ff7

#include "SNA_Examples_BasicPublisher_comp_exec.h"

#include "SNA_Tracer.h"

// Add includes between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 0af6e969-7aec-48b2-88c8-22a2070655cc
// EXAMPLE: These includes were added by hand in order to create a timer and to
//          to read a configuration file.
#include "ace/Event_Handler_T.h"
#include "SNA_ConfigParams.h"
//@@{__SNA_REGEN_MARKER__} - END : 0af6e969-7aec-48b2-88c8-22a2070655cc

namespace SNA_Examples_BasicPublisher_comp_Impl
{
SNA_WARN_UNUSED_PARAMS

   testDataPub_CSL_exec_i::testDataPub_CSL_exec_i(
      IDL::traits< ::SNA_Examples::CCM_BasicPublisher_comp_Context>::ref_type context,
      SNA_CompBoilerplate_t & boilerplate) :
        context_(context),
          
         // Add initializer list items between tags below
         //@@{__SNA_REGEN_MARKER__} - BEGIN : 08945c22-fd7a-4dd3-9c54-ffcbab9d5d5c
         boilerplate_(boilerplate)
         //@@{__SNA_REGEN_MARKER__} - END : 08945c22-fd7a-4dd3-9c54-ffcbab9d5d5c

   {
      // Add constructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 015fafa5-8018-409d-923d-03264606cf51
      // EXAMPLE: log4cxx statements contained in the connector status listener
      //          implementation class should contain a log4cxx prefix which is
      //          consistent with the object hierarchy. This will allow users to
      //          determine where each log statement originates from.
      impl_.setLoggerNamePrefix(boilerplate_.getLoggerNameFull());
      //@@{__SNA_REGEN_MARKER__} - END : 015fafa5-8018-409d-923d-03264606cf51
   }

   testDataPub_CSL_exec_i::~testDataPub_CSL_exec_i()
   {
      // Add destructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : b909a293-27b3-465b-add6-be432f91089c
      //@@{__SNA_REGEN_MARKER__} - END : b909a293-27b3-465b-add6-be432f91089c
   }

SNA_IGNORE_UNUSED_PARAMS

   void
   testDataPub_CSL_exec_i::on_inconsistent_topic(
      IDL::traits< DDS::Topic>::ref_type the_topic,
      const DDS::InconsistentTopicStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : c18f7928-0870-4da6-bd3d-c471570f6661
      impl_.on_inconsistent_topic(the_topic, status);
      //@@{__SNA_REGEN_MARKER__} - END : c18f7928-0870-4da6-bd3d-c471570f6661
   }

   void
   testDataPub_CSL_exec_i::on_requested_incompatible_qos(
      IDL::traits< DDS::DataReader>::ref_type the_reader,
      const DDS::RequestedIncompatibleQosStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : ca802bdb-d81d-40b9-a202-5b89c27d5c25
      impl_.on_requested_incompatible_qos(the_reader, status);
      //@@{__SNA_REGEN_MARKER__} - END : ca802bdb-d81d-40b9-a202-5b89c27d5c25
   }

   void
   testDataPub_CSL_exec_i::on_sample_rejected(
      IDL::traits< DDS::DataReader>::ref_type the_reader,
      const DDS::SampleRejectedStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : a31454ff-b00d-4ba7-bac6-cb17d855999a
      impl_.on_sample_rejected(the_reader, status);
      //@@{__SNA_REGEN_MARKER__} - END : a31454ff-b00d-4ba7-bac6-cb17d855999a
   }

   void
   testDataPub_CSL_exec_i::on_offered_deadline_missed(
      IDL::traits< DDS::DataWriter>::ref_type the_writer,
      const DDS::OfferedDeadlineMissedStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 3cc0b684-4905-4d92-9fb3-763cd20ca3a5
      impl_.on_offered_deadline_missed(the_writer, status);
      //@@{__SNA_REGEN_MARKER__} - END : 3cc0b684-4905-4d92-9fb3-763cd20ca3a5
   }

   void
   testDataPub_CSL_exec_i::on_offered_incompatible_qos(
      IDL::traits< DDS::DataWriter>::ref_type the_writer,
      const DDS::OfferedIncompatibleQosStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 8b7c61f1-d1d9-40ee-b933-1f1c483f2447
      impl_.on_offered_incompatible_qos(the_writer, status);
      //@@{__SNA_REGEN_MARKER__} - END : 8b7c61f1-d1d9-40ee-b933-1f1c483f2447
   }

   void
   testDataPub_CSL_exec_i::on_unexpected_status(
      IDL::traits< DDS::Entity>::ref_type the_entity,
      DDS::StatusKind status_kind)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 3f185952-5a03-48af-af32-74062190a15c
      impl_.on_unexpected_status(the_entity, status_kind);
      //@@{__SNA_REGEN_MARKER__} - END : 3f185952-5a03-48af-af32-74062190a15c
   }

SNA_WARN_UNUSED_PARAMS

   // Add public method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : a9cc7d8e-35c9-4b14-b3e9-2b1cda813869
   //@@{__SNA_REGEN_MARKER__} - END : a9cc7d8e-35c9-4b14-b3e9-2b1cda813869

   // Add private method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 5adb5974-8b7f-41ec-afb7-0516206f7b9d
   //@@{__SNA_REGEN_MARKER__} - END : 5adb5974-8b7f-41ec-afb7-0516206f7b9d

SNA_WARN_UNUSED_PARAMS

   BasicPublisher_comp_exec_i::BasicPublisher_comp_exec_i() :
         // Add initializer list items between tags below
         //@@{__SNA_REGEN_MARKER__} - BEGIN : 4fc94288-9dd6-422a-8834-8f2d0164f9d9
         boilerplate_("BasicPublisher_comp"),
         timerId_(-1),
         numSamplesToPublishEachTime_(1),
         sendTimer_(this,0)
         //@@{__SNA_REGEN_MARKER__} - END : 4fc94288-9dd6-422a-8834-8f2d0164f9d9
   {
      // Add constructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 6f537944-7abc-45ae-b33e-ac054ef7e19d
      // EXAMPLE: log4cxx statements contained in the SNA::TimeManager class
      //          should contain a log4cxx prefix which is consistent with the
      //          object hierarchy. This will allow users to determine where
      //          each log statement originates from.
      timeManager_.setLoggerNamePrefix(boilerplate_.getLoggerNameFull());
      //@@{__SNA_REGEN_MARKER__} - END : 6f537944-7abc-45ae-b33e-ac054ef7e19d
   }

   BasicPublisher_comp_exec_i::~BasicPublisher_comp_exec_i()
   {
      // Add destructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 12ff1fc1-097d-4af3-88e7-ea71d5719afe
      //@@{__SNA_REGEN_MARKER__} - END : 12ff1fc1-097d-4af3-88e7-ea71d5719afe
   }

   IDL::traits<::CCM_DDS::CCM_ConnectorStatusListener >::ref_type
   BasicPublisher_comp_exec_i::get_testDataPub_CSL()
   {
      if (!this->testDataPub_CSL_)
     {
        this->testDataPub_CSL_ = taox11::CORBA::make_reference<testDataPub_CSL_exec_i>(
              this->context_,this->boilerplate_);
     }
     return this->testDataPub_CSL_;
   }

   std::string
   BasicPublisher_comp_exec_i::BasicPublisher_config()
   {
      return this->BasicPublisher_config_;
   }

   void
   BasicPublisher_comp_exec_i::BasicPublisher_config(
      const std::string& BasicPublisher_config)
   {
      this->BasicPublisher_config_ = BasicPublisher_config;
   }

   void
   BasicPublisher_comp_exec_i::set_session_context(
      IDL::traits<Components::SessionContext>::ref_type ctx)
   {
      this->context_ = 
          IDL::traits<:: SNA_Examples::CCM_BasicPublisher_comp_Context >::narrow (ctx);

      this->boilerplate_.set_session_context(this->context_, this);
      
   }

   void
   BasicPublisher_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(
         this->boilerplate_.getLogger(), "configuration_complete");
      boilerplate_.configuration_complete();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 89e059d0-6bff-4026-9e5f-83405b2bbe7d
      //@@{__SNA_REGEN_MARKER__} - END : 89e059d0-6bff-4026-9e5f-83405b2bbe7d
   }

   void
   BasicPublisher_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_activate");
      boilerplate_.ccm_activate();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 9d9392de-677e-43d0-bf01-b26d78acf195
      // EXAMPLE: There is a configuration file that was created just for this
      //          basic publisher component.  We want to read from it the number
      //          of samples to publish each time the timer we are also setting
      //          below fires off.
      SNA::ConfigParams basicPubParams;

      // EXAMPLE: log4cxx statements contained in the SNA::ConfigParams class
      //          should contain a log4cxx prefix which is consistent with the
      //          object hierarchy. This will allow users to determine where
      //          each log statement originates from.
      basicPubParams.setLoggerNamePrefix(boilerplate_.getLoggerNameFull());

      if(BasicPublisher_config_.empty())
      {
         boilerplate_.failed_state_change("BasicPublisher expected "
               "configuration file, none received.");
      }

      if (basicPubParams.init(BasicPublisher_config_))
      {
         basicPubParams.lookupValue(
            "BasicPublisher.numSamplesToPublishEachTime",
            numSamplesToPublishEachTime_);
      }

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      /*
       * Schedule a timer using ACE_Event_Handler_T
       */
      sendTimer_.to_handler(&BasicPublisher_comp_exec_i::sendSample);
      
      ACE_Time_Value delay(5, 0);  // timer = 5 seconds + 0 usec = 5 sec
      ACE_Time_Value repeat(5, 0); // timer = 5 seconds + 0 usec = 5 sec
      /*
      timerId_ = this->reactor()->schedule_timer(&sendTimer_,
                                             0,
                                             delay,
                                             repeat);
   
      */
      timerId_ = timeManager_.schedule_timer(this->reactor(), &sendTimer_,
                                             0,
                                             delay,
                                             repeat);
      
      
      if (timerId_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }
      //@@{__SNA_REGEN_MARKER__} - END : 9d9392de-677e-43d0-bf01-b26d78acf195
   }

   void
   BasicPublisher_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_passivate");
      boilerplate_.ccm_passivate();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : d68889ce-9410-4f13-abb9-3ea28160f111
      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      //          will also destroy the general timer class constructed in
      //          ccm_activate.
      timeManager_.cancel_timer(this->reactor(), timerId_);
      //@@{__SNA_REGEN_MARKER__} - END : d68889ce-9410-4f13-abb9-3ea28160f111
   }

   void
   BasicPublisher_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_remove");
      boilerplate_.ccm_remove();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 53a090c0-16ae-416e-8d61-e15093d64c10
      //@@{__SNA_REGEN_MARKER__} - END : 53a090c0-16ae-416e-8d61-e15093d64c10
   }

   ACE_Reactor *
   BasicPublisher_comp_exec_i::reactor()
   {
     IDL::traits<taox11::CORBA::Object>::ref_type orb_object =
      this->context_->the_service_registry()->resolve_service (
        CIAOX11::SVCID_ORB);
    IDL::traits<taox11::CORBA::ORB>::ref_type orb =
      IDL::traits<taox11::CORBA::ORB>::narrow (orb_object);
    return orb->reactor ();
   }

   // Add public method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 4e92a3fe-426f-42c5-b786-3cb1ca040f7e
   int
   BasicPublisher_comp_exec_i::sendSample(const ACE_Time_Value &, const void *)
   {
      // EXAMPLE: This is the generated C++ structure given by the IDL
      //          definition from the ports directory. This structure has no
      //          meaning and is shown only for example. The fields of this
      //          structure provide examples of using the various IDL to C++
      //          data types.
      SNA_Examples::TestData_msg sample;

      sample.myInt32(10);
      sample.myInt64(5824169525);
      sample.myDouble(3.5);
      sample.myString("Hello, World!");
      sample.myState(SNA_Examples::State::STATE_PASS);
      sample.myColor(SNA_Examples::Color::COLOR_RED);

      /**
       * Reference to the writer interface to the DDS4CCM connector for the
       * SNA_Examples::TestData type
       */
      SNA_Examples::TestData_conn::Writer::_ref_type testDataPubWriter;

      testDataPubWriter = context_->get_connection_testDataPub_data();

      if (testDataPubWriter == nullptr)
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
                       << translate_retcode(ex.error_code()));

         return -1; // Don't reschedule timer
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex.what());

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
   //@@{__SNA_REGEN_MARKER__} - END : 4e92a3fe-426f-42c5-b786-3cb1ca040f7e

   // Add private method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 7096e4da-04cc-4003-a12e-4f3af9c2dd93
   //@@{__SNA_REGEN_MARKER__} - END : 7096e4da-04cc-4003-a12e-4f3af9c2dd93

 extern "C" void
   create_SNA_Examples_BasicPublisher_comp_Impl(
      IDL::traits<Components::EnterpriseComponent>::ref_type& component)
   {
    component = taox11::CORBA::make_reference <BasicPublisher_comp_exec_i> ();
   }
   

}

// Add file footer between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : e7e591fd-68f6-4ac1-9945-3e5c88bffb2e
//@@{__SNA_REGEN_MARKER__} - END : e7e591fd-68f6-4ac1-9945-3e5c88bffb2e
