// Add file header between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 43be9e11-d233-4642-84d8-637597616b20
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
/// @addtogroup SNA_Examples_BasicSubscriber_comp
/// @{
/// @file   SNA_Examples_BasicSubscriber_comp_exec.cpp
/// @brief  Implementation of executor classes for the BasicSubscriber_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//
//@@{__SNA_REGEN_MARKER__} - END : 43be9e11-d233-4642-84d8-637597616b20

#include "SNA_Examples_BasicSubscriber_comp_exec.h"

#include "SNA_Tracer.h"

// Add includes between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 65b39dd0-83ac-40d2-81bc-adf93d02a807
//@@{__SNA_REGEN_MARKER__} - END : 65b39dd0-83ac-40d2-81bc-adf93d02a807

namespace SNA_Examples_BasicSubscriber_comp_Impl
{
SNA_WARN_UNUSED_PARAMS

   testDataSub_data_listener_exec_i::testDataSub_data_listener_exec_i(
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context,
      SNA_CompBoilerplate_t & boilerplate) :
        context_(context),
          
         // Add initializer list items between tags below
         //@@{__SNA_REGEN_MARKER__} - BEGIN : d3381671-2d79-4f93-8507-95cfd1d32c47
         boilerplate_(boilerplate)
         //@@{__SNA_REGEN_MARKER__} - END : d3381671-2d79-4f93-8507-95cfd1d32c47

   {
      // Add constructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 14cb2056-7044-449b-b326-8947ffb49fa2
      //@@{__SNA_REGEN_MARKER__} - END : 14cb2056-7044-449b-b326-8947ffb49fa2
   }

   testDataSub_data_listener_exec_i::~testDataSub_data_listener_exec_i()
   {
      // Add destructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 8a7db06e-4cbf-4777-a578-2495b9b48e74
      //@@{__SNA_REGEN_MARKER__} - END : 8a7db06e-4cbf-4777-a578-2495b9b48e74
   }

SNA_IGNORE_UNUSED_PARAMS

   void
   testDataSub_data_listener_exec_i::on_one_data(
      const SNA_Examples::TestData_msg& datum,
      const CCM_DDS::ReadInfo& info)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 2b897402-aeb4-4fc8-bb15-c8ae754176bf
      // EXAMPLE: The is the data receive callback for the testDataSub DDS4CCM
      //          listen port. This method simply logs the content of the test
      //          data structure.
      LOG4CXX_INFO(boilerplate_.getLogger(),
                   "Event has been received with contents\n"
                   << "myInt32  = " << datum.myInt32()  << "\n"
                   << "myInt64  = " << datum.myInt64()  << "\n"
                   << "myDouble = " << datum.myDouble() << "\n"
                   << "myString = " << datum.myString() << "\n"
                   << "myState  = " << datum.myState()  << "\n"
                   << "myColor  = " << datum.myColor()  << "\n");
      //@@{__SNA_REGEN_MARKER__} - END : 2b897402-aeb4-4fc8-bb15-c8ae754176bf
   }

   void
   testDataSub_data_listener_exec_i::on_many_data(
      const SNA_Examples::TestData_msgSeq& data,
      const CCM_DDS::ReadInfoSeq& infos)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 8c9eae52-a025-46de-8426-78cb00998c67
      //@@{__SNA_REGEN_MARKER__} - END : 8c9eae52-a025-46de-8426-78cb00998c67
   }

SNA_WARN_UNUSED_PARAMS

   // Add public method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 7ee14ef7-44f7-4eb3-af8f-99ea635d98df
   //@@{__SNA_REGEN_MARKER__} - END : 7ee14ef7-44f7-4eb3-af8f-99ea635d98df

   // Add private method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : fb406711-51d2-460e-88e8-8d387d6a8253
   //@@{__SNA_REGEN_MARKER__} - END : fb406711-51d2-460e-88e8-8d387d6a8253

SNA_WARN_UNUSED_PARAMS

   testDataSub_status_exec_i::testDataSub_status_exec_i(
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context,
      SNA_CompBoilerplate_t & boilerplate) :
        context_(context),
          
         // Add initializer list items between tags below
         //@@{__SNA_REGEN_MARKER__} - BEGIN : 808de46d-d852-4304-9366-bd5eb0a75e92
         boilerplate_(boilerplate)
         //@@{__SNA_REGEN_MARKER__} - END : 808de46d-d852-4304-9366-bd5eb0a75e92

   {
      // Add constructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 1c32051b-ba6a-46ee-8a91-85aac1e939f0
      //
      // EXAMPLE: log4cxx statements contained in the SNA::PortStatusListener
      //          class should contain a log4cxx prefix which is consistent with
      //          the object hierarchy. This will allow users to determine where
      //          each log statement originates from.
      //

      impl_.setLoggerNamePrefix(boilerplate_.getLoggerNameFull());
      //@@{__SNA_REGEN_MARKER__} - END : 1c32051b-ba6a-46ee-8a91-85aac1e939f0
   }

   testDataSub_status_exec_i::~testDataSub_status_exec_i()
   {
      // Add destructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 8e3b1df6-80e4-4f47-b246-99032ba14a4a
      //@@{__SNA_REGEN_MARKER__} - END : 8e3b1df6-80e4-4f47-b246-99032ba14a4a
   }

SNA_IGNORE_UNUSED_PARAMS

   void
   testDataSub_status_exec_i::on_requested_deadline_missed(
      IDL::traits< DDS::DataReader>::ref_type the_reader,
      const DDS::RequestedDeadlineMissedStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 9dc880c5-b42a-4b87-9c3d-8605b2283e64
      impl_.on_requested_deadline_missed(the_reader, status);
      //@@{__SNA_REGEN_MARKER__} - END : 9dc880c5-b42a-4b87-9c3d-8605b2283e64
   }

   void
   testDataSub_status_exec_i::on_sample_lost(
      IDL::traits< DDS::DataReader>::ref_type the_reader,
      const DDS::SampleLostStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 62b926d2-4c76-4c41-b98c-df37c8accfa6
      impl_.on_sample_lost(the_reader, status);
      //@@{__SNA_REGEN_MARKER__} - END : 62b926d2-4c76-4c41-b98c-df37c8accfa6
   }

SNA_WARN_UNUSED_PARAMS

   // Add public method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 934dee74-bc13-4fcc-8327-78a2b968ee42
   //@@{__SNA_REGEN_MARKER__} - END : 934dee74-bc13-4fcc-8327-78a2b968ee42

   // Add private method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 2435ca78-f3d6-4bec-a937-d167c7cdb4b8
   //@@{__SNA_REGEN_MARKER__} - END : 2435ca78-f3d6-4bec-a937-d167c7cdb4b8

SNA_WARN_UNUSED_PARAMS

   testDataSub_CSL_exec_i::testDataSub_CSL_exec_i(
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context,
      SNA_CompBoilerplate_t & boilerplate) :
        context_(context),
          
         // Add initializer list items between tags below
         //@@{__SNA_REGEN_MARKER__} - BEGIN : 884234f3-1e90-448b-8016-389652395ec3
         boilerplate_(boilerplate)
         //@@{__SNA_REGEN_MARKER__} - END : 884234f3-1e90-448b-8016-389652395ec3

   {
      // Add constructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 189cbcb8-340b-4328-88c7-2092de0159de
      // EXAMPLE: log4cxx statements contained in the SNA::PortStatusListener
      //          class should contain a log4cxx prefix which is consistent with
      //          the object hierarchy. This will allow users to determine where
      //          each log statement originates from.
      impl_.setLoggerNamePrefix(boilerplate_.getLoggerNameFull());
      //@@{__SNA_REGEN_MARKER__} - END : 189cbcb8-340b-4328-88c7-2092de0159de
   }

   testDataSub_CSL_exec_i::~testDataSub_CSL_exec_i()
   {
      // Add destructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 311d22eb-4733-44e5-bd6c-550781eadf48
      //@@{__SNA_REGEN_MARKER__} - END : 311d22eb-4733-44e5-bd6c-550781eadf48
   }

SNA_IGNORE_UNUSED_PARAMS

   void
   testDataSub_CSL_exec_i::on_inconsistent_topic(
      IDL::traits< DDS::Topic>::ref_type the_topic,
      const DDS::InconsistentTopicStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 3e7dfff0-f69b-4511-aa97-f82177fa8cab
      impl_.on_inconsistent_topic(the_topic, status);
      //@@{__SNA_REGEN_MARKER__} - END : 3e7dfff0-f69b-4511-aa97-f82177fa8cab
   }

   void
   testDataSub_CSL_exec_i::on_requested_incompatible_qos(
      IDL::traits< DDS::DataReader>::ref_type the_reader,
      const DDS::RequestedIncompatibleQosStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : be422cd5-acff-4d65-bff5-88d2e025384c
      impl_.on_requested_incompatible_qos(the_reader, status);
      //@@{__SNA_REGEN_MARKER__} - END : be422cd5-acff-4d65-bff5-88d2e025384c
   }

   void
   testDataSub_CSL_exec_i::on_sample_rejected(
      IDL::traits< DDS::DataReader>::ref_type the_reader,
      const DDS::SampleRejectedStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : b403c7a3-24e9-4c14-97f7-b6577a516c33
      impl_.on_sample_rejected(the_reader, status);
      //@@{__SNA_REGEN_MARKER__} - END : b403c7a3-24e9-4c14-97f7-b6577a516c33
   }

   void
   testDataSub_CSL_exec_i::on_offered_deadline_missed(
      IDL::traits< DDS::DataWriter>::ref_type the_writer,
      const DDS::OfferedDeadlineMissedStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 437fe2bc-9e1d-4e07-9add-a279194d8391
      //@@{__SNA_REGEN_MARKER__} - END : 437fe2bc-9e1d-4e07-9add-a279194d8391
   }

   void
   testDataSub_CSL_exec_i::on_offered_incompatible_qos(
      IDL::traits< DDS::DataWriter>::ref_type the_writer,
      const DDS::OfferedIncompatibleQosStatus& status)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 3f4fb739-341e-4da8-8260-9c8dd56777fd
      impl_.on_offered_incompatible_qos(the_writer, status);
      //@@{__SNA_REGEN_MARKER__} - END : 3f4fb739-341e-4da8-8260-9c8dd56777fd
   }

   void
   testDataSub_CSL_exec_i::on_unexpected_status(
      IDL::traits< DDS::Entity>::ref_type the_entity,
      DDS::StatusKind status_kind)
   {
      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : e2602c38-7b71-4647-b114-1d37756b43de
      impl_.on_unexpected_status(the_entity, status_kind);
      //@@{__SNA_REGEN_MARKER__} - END : e2602c38-7b71-4647-b114-1d37756b43de
   }

SNA_WARN_UNUSED_PARAMS

   // Add public method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : ec27a6b2-0399-4272-80ce-9480ce70ab98
   //@@{__SNA_REGEN_MARKER__} - END : ec27a6b2-0399-4272-80ce-9480ce70ab98

   // Add private method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : d1955029-73f0-41bc-b856-9bb6a8a6c595
   //@@{__SNA_REGEN_MARKER__} - END : d1955029-73f0-41bc-b856-9bb6a8a6c595

SNA_WARN_UNUSED_PARAMS

   BasicSubscriber_comp_exec_i::BasicSubscriber_comp_exec_i() :
         // Add initializer list items between tags below
         //@@{__SNA_REGEN_MARKER__} - BEGIN : fe2fdb89-f0f3-47e8-af59-6d88aeafc9b3
         boilerplate_("BasicSubscriber_comp")
         //@@{__SNA_REGEN_MARKER__} - END : fe2fdb89-f0f3-47e8-af59-6d88aeafc9b3
   {
      // Add constructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 49e1e04f-4a7d-4a4e-8e54-871551e1585d
      //@@{__SNA_REGEN_MARKER__} - END : 49e1e04f-4a7d-4a4e-8e54-871551e1585d
   }

   BasicSubscriber_comp_exec_i::~BasicSubscriber_comp_exec_i()
   {
      // Add destructor implementation between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 8e04a31d-8b57-4c01-82c3-4c3dfd5a4867
      //@@{__SNA_REGEN_MARKER__} - END : 8e04a31d-8b57-4c01-82c3-4c3dfd5a4867
   }

   IDL::traits<::SNA_Examples::TestData_conn::CCM_Listener >::ref_type
   BasicSubscriber_comp_exec_i::get_testDataSub_data_listener()
   {
      if (!this->testDataSub_data_listener_)
     {
        this->testDataSub_data_listener_ = taox11::CORBA::make_reference<testDataSub_data_listener_exec_i>(
              this->context_,this->boilerplate_);
     }
     return this->testDataSub_data_listener_;
   }

   IDL::traits<::CCM_DDS::CCM_PortStatusListener >::ref_type
   BasicSubscriber_comp_exec_i::get_testDataSub_status()
   {
      if (!this->testDataSub_status_)
     {
        this->testDataSub_status_ = taox11::CORBA::make_reference<testDataSub_status_exec_i>(
              this->context_,this->boilerplate_);
     }
     return this->testDataSub_status_;
   }

   IDL::traits<::CCM_DDS::CCM_ConnectorStatusListener >::ref_type
   BasicSubscriber_comp_exec_i::get_testDataSub_CSL()
   {
      if (!this->testDataSub_CSL_)
     {
        this->testDataSub_CSL_ = taox11::CORBA::make_reference<testDataSub_CSL_exec_i>(
              this->context_,this->boilerplate_);
     }
     return this->testDataSub_CSL_;
   }

   void
   BasicSubscriber_comp_exec_i::set_session_context(
      IDL::traits<Components::SessionContext>::ref_type ctx)
   {
      this->context_ = 
          IDL::traits<:: SNA_Examples::CCM_BasicSubscriber_comp_Context >::narrow (ctx);

      this->boilerplate_.set_session_context(this->context_, this);
      
   }

   void
   BasicSubscriber_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(
         this->boilerplate_.getLogger(), "configuration_complete");
      boilerplate_.configuration_complete();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : a5c513c8-3a6e-4b12-81c8-fd308b2e5885
      //@@{__SNA_REGEN_MARKER__} - END : a5c513c8-3a6e-4b12-81c8-fd308b2e5885
   }

   void
   BasicSubscriber_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_activate");
      boilerplate_.ccm_activate();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 0a6951a4-dc15-4a22-a4a9-f08ae97efefd
      // EXAMPLE: Gets a reference to the listener control interface for the
      //          testdataSub DDS4CCM listen port. This is usually needed by
      //          all components which have listen ports as by default the
      //          data listener mode is set to NOT_ENABLED so NO data will be
      //          received.
      //
      //          This listener mode can be changed at any time but is usually
      //          set in ccm_activate.
      IDL::traits< ::CCM_DDS::DataListenerControl>::ref_type listenerCtrl =
         context_->get_connection_testDataSub_data_control();

      if (listenerCtrl != nullptr)
      {
         // EXAMPLE: Setting the listener mode to ONE_BY_ONE meaning the
         //          on_one_data callback is called for every sample received.
         //
         //          This setting is the recommended one as it is faster than
         //          MANY_BY_MANY (which calls the on_many_data callback with a
         //          sequences of samples) as the MANY_BY_MANY mode is harder to
         //          use and has data copies due to differences between CCM and
         //          DDS sequence types.
         try
         {
            listenerCtrl->mode(CCM_DDS::ListenerMode::ONE_BY_ONE);
         }
         catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex.what());
         }
      }
      else
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a data
         //          listener.
         boilerplate_.failed_state_change(
               "The listener control receptacle is null");
      }
      //@@{__SNA_REGEN_MARKER__} - END : 0a6951a4-dc15-4a22-a4a9-f08ae97efefd
   }

   void
   BasicSubscriber_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_passivate");
      boilerplate_.ccm_passivate();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 19b1bd6d-1e6e-4453-a3db-755468a638b2
      IDL::traits< ::CCM_DDS::DataListenerControl>::ref_type listenerCtrl =
         context_->get_connection_testDataSub_data_control();

      if (listenerCtrl != nullptr)
      {
         //
         // EXAMPLE: Since the this component is passivated, the listener
         //          should be disabled.
         //

         try
         {
            listenerCtrl->mode(CCM_DDS::ListenerMode::NOT_ENABLED);
         }
         catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "Caught CORBA exception "
                  "while trying to set the listener control mode to "
                  "'NOT_ENABLED' : " << ex.what());
         }
      }
      else
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "The listener control receptacle is null");
      }
      //@@{__SNA_REGEN_MARKER__} - END : 19b1bd6d-1e6e-4453-a3db-755468a638b2
   }

   void
   BasicSubscriber_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_remove");
      boilerplate_.ccm_remove();

      // Add all code between begin and end tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : b898bbf2-e0c1-4598-9b8b-f87e40c7f944
      //@@{__SNA_REGEN_MARKER__} - END : b898bbf2-e0c1-4598-9b8b-f87e40c7f944
   }

   ACE_Reactor *
   BasicSubscriber_comp_exec_i::reactor()
   {
     IDL::traits<taox11::CORBA::Object>::ref_type orb_object =
      this->context_->the_service_registry()->resolve_service (
        CIAOX11::SVCID_ORB);
    IDL::traits<taox11::CORBA::ORB>::ref_type orb =
      IDL::traits<taox11::CORBA::ORB>::narrow (orb_object);
    return orb->reactor ();
   }

   // Add public method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : 4c1c02cb-3cd2-4efc-b9f2-52df43118941
   //@@{__SNA_REGEN_MARKER__} - END : 4c1c02cb-3cd2-4efc-b9f2-52df43118941

   // Add private method implementations between tags below
   //@@{__SNA_REGEN_MARKER__} - BEGIN : ed2f5eb9-9d3f-4b9c-80a3-294b529b22cd
   //@@{__SNA_REGEN_MARKER__} - END : ed2f5eb9-9d3f-4b9c-80a3-294b529b22cd

 extern "C" void
   create_SNA_Examples_BasicSubscriber_comp_Impl(
      IDL::traits<Components::EnterpriseComponent>::ref_type& component)
   {
    component = taox11::CORBA::make_reference <BasicSubscriber_comp_exec_i> ();
   }
   

}

// Add file footer between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : f721757a-096d-45ce-9fa3-b735432285e9
/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
//@@{__SNA_REGEN_MARKER__} - END : f721757a-096d-45ce-9fa3-b735432285e9
