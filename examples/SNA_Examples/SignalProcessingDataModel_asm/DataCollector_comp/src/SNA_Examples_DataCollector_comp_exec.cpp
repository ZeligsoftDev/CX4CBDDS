//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataCollector_comp
/// @{
/// @file   SNA_Examples_DataCollector_comp_exec.cpp
/// @brief  Implementation of executor classes for the DataCollector_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_DataCollector_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

// EXAMPLE: included to get byte swapping code
#include "SNA_EndianSwap.h"

// EXAMPLE: This include file was added by hand in order to be able to use the
//          SNA extensions to the SNA Config Parameter Access API.
#include "SNA_ConfigParams.h"

// EXAMPLE: Required to use vsipl utility functions to go from idl to cpp
#include "SNA_DataViewTranslator.h"

// EXAMPLE: required for VSIPL
#include <vsip/matrix.hpp>
#include <vsip/dense.hpp>

#include "PSAT_Subscribing_UDM_ref_T.h"

namespace CIAO_SNA_Examples_DataCollector_comp_Impl
{

   /**
    * Facet Executor Implementation Class: dataMapSub_status_exec_i
    */

   dataMapSub_status_exec_i::dataMapSub_status_exec_i(
      ::SNA_Examples::CCM_DataCollector_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataCollector_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   dataMapSub_status_exec_i::~dataMapSub_status_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Reader_Status_Listener

   void
   dataMapSub_status_exec_i::on_requested_deadline_missed(::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::RequestedDeadlineMissedStatus & status )
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_requested_deadline_missed callback : "
                    "total_count = " << status.total_count <<
                    ", total_count_change = " << status.total_count_change);
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_status_exec_i::on_sample_lost(::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::SampleLostStatus & status )
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_sample_lost callback : total_count = " <<
                    status.total_count << ", total_count_change = " <<
                    status.total_count_change);
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_status_exec_i::on_copy_unsupported(
         const ::SNA_Examples::DataMap_UDM_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info )
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_copy_unsupported callback for UDM with "
                    "message number (" << datum.message_number << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_status_exec_i::on_buffer_invalidation(
         const ::SNA_Examples::DataMap_UDM_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info )
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_buffer_invalidation callback for UDM with "
                    "message number (" << datum.message_number << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_status_exec_i::on_incomplete_transfer(
         const ::SNA_Examples::DataMap_UDM_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info )
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_incomplete_transfer callback for UDM with "
                    "message number (" << datum.message_number << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_status_exec_i::on_invalid_udm_psat_header(
         const ::SNA_Examples::DataMap_UDM_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info )
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_invalid_udm_psat_header callback for UDM with "
                    "message number (" << datum.message_number << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Facet Executor Implementation Class: dataMapSub_listener_exec_i
    */

   dataMapSub_listener_exec_i::dataMapSub_listener_exec_i(
      ::SNA_Examples::CCM_DataCollector_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataCollector_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate),
         recvMsgCount_(0)
   {
   }

   // --------------------------------------------------------------------------

   dataMapSub_listener_exec_i::~dataMapSub_listener_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Listener

   void
   dataMapSub_listener_exec_i::on_one_data(
         const ::SNA_Examples::DataMap_UDM_msg & datum ,
         const ::CCM_DDS::ReadInfo & /* read_info */)
   {
      recvMsgCount_++;

      bool okayToLog =
            this->boilerplate_.getCompExecPtr()->isOkayToLogMsg(recvMsgCount_);

      if (okayToLog)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "MSG[" << recvMsgCount_ << "] .. " <<
                      "On one data called!");
      }

      // -----------------

      // Get object reference for attachment control interface
     ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Attachment_Control_var
         attachCtrlObj =
            ciao_context_->get_connection_dataMapSub_attachment_control();

      if (CORBA::is_nil(attachCtrlObj.in()))
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << recvMsgCount_ << "] .. " <<
                       "Attachment control receptacle is nil");

         return;
      }

      try
      {
         // EXAMPLE:
         // This is a "smart pointer" to a UDM. When you create a Subscribing
         // UDM reference, the destructor will call "release_buffer()" when the
         // last reference has been removed. If you invoke the copy constructor
         // of this UDM ref, the reference count will be incremented.
         typedef CCM_PSAT::Subscribing_UDM_ref<
               ::SNA_Examples::DataMap_UDM_msg,
               ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Attachment_Control>
               DataMap_Subscribing_UDM_Ref_t;

         DataMap_Subscribing_UDM_Ref_t udm_ref(attachCtrlObj.in(),datum);

         // -----------------

         // Get address to start of the PSAT sample and cast it to an
         // appropriate type
         int * dataPtr = reinterpret_cast<int *>(
               udm_ref.udm().psat_hdr.sample_start_address);

         if (0 == dataPtr)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << recvMsgCount_ << "] .. " <<
                          "Got a null pointer from UDM");
            return;
         }

         // -----------------

         // Descriptor object is a VSIPL++ meta data object
         vsip::serialization::Descriptor dataDescriptor;

         // This function will translate the spdm header into a vsipl descriptor
         // object.
         SNA::DataViewTranslator::spdm_idl_to_cpp(
               udm_ref.udm().spdm_hdr,
               dataDescriptor);

         // -----------------

         // Calculate the number of elements by multiplying the rows * columns
         int numElements = dataDescriptor.size[0] *
                           dataDescriptor.size[1];

         if (okayToLog)
         {
            LOG4CXX_INFO(boilerplate_.getLogger(),
                         "MSG[" << recvMsgCount_ << "] .. " <<
                         "Received " << numElements << " elements");
         }

         // -----------------

         // Unlike regular DDS, SPDM/PSAT requires the application developer to
         // manually swap the contents of the attachment.  SNA provides the
         // capability to endian swap raw data in a VSIPL++ view.
         if (udm_ref.udm().psat_hdr.source_endian !=
               udm_ref.udm().psat_hdr.sub_side_info.destination_endian)
         {
            if (okayToLog)
            {
               LOG4CXX_INFO(boilerplate_.getLogger(),
                            "MSG[" << recvMsgCount_ << "] .. " <<
                            "Endian swapping data");
            }

            SNA::DataViewTranslator::EndianSwapViewData( dataDescriptor,dataPtr);
         }

         // -----------------

         // Create an empty data block
         vsip::Dense<2, int> dataBlock(
               vsip::Domain<2>(0,0),
               static_cast<int*>(0));

         // VSIPL++ View of the data
         vsip::Matrix<int> finalMatrix(dataBlock);

         // Check to see if the view can be binded from this descriptor
         bool valid = vsip::serialization::is_compatible<vsip::Dense<2, int> >
                                                               (dataDescriptor);

         // Transfer this Block to the View
         if (valid)
         {
            finalMatrix.block().rebind(dataPtr, vsip::Domain<2>(
                  dataDescriptor.size[0],
                  dataDescriptor.size[1]));

            finalMatrix.block().admit(true);;
         }
         else
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << recvMsgCount_ << "] .. " <<
                          "Can't unmarshal data!");
         }

         // -----------------

         // Check the ramp to make sure that the data was received as expected by
         // looping throw the index of each dimension.
         bool dataAsExpected = true;
         int  scaleFactor    = 10;       // amount scaled by the MKC component(s)
         for (unsigned int i=0; i < finalMatrix.size(0); ++i)
         {
            for (unsigned int j=0; j < finalMatrix.size(1); ++j)
            {
               // expected values should ramp based on the index
               int expectedValue = (i * finalMatrix.size(1) + j) * scaleFactor;

               if (finalMatrix.get(i,j) != expectedValue)
               {
                  dataAsExpected = false;
               }
            }
         }

         // -----------------

         if (okayToLog)
         {
            this->printMatrix("Reconstructed data map:", finalMatrix);
         }

         // -----------------

         if ( dataAsExpected)
         {
            if (okayToLog)
            {
               LOG4CXX_INFO(boilerplate_.getLogger(),
                            "MSG[" << recvMsgCount_ << "] .. " <<
                            "Received the Data Map Successfully!");
            }
         }
         else
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << recvMsgCount_ << "] .. " <<
                          "Data was not transferred correctly. Expected to see "
                          "a ramp of values scaled by 10!");
         }

         // -----------------

         // Release the data from VSIPL++ control
         finalMatrix.block().release(true);

      }
      catch (CORBA::Exception & excep)
      {
         // This exception is thrown when the UDM is nil

         LOG4CXX_WARN(boilerplate_.getLogger(),
               "Caught CORBA::Exception with info: " + excep._info());
         return;
      }
      catch (...)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(), "Caught unknown exception!");
         return;
      }
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_listener_exec_i::printMatrix(const std::string &msg,
                                  const vsip::Matrix<int>& data)
   {
      std::stringstream strm;
      strm.unsetf(ios::floatfield);

      std::string dashSep = "--------------------";

      strm << "MSG[" << recvMsgCount_ << "] .. " << std::endl;
      strm << dashSep << std::endl;
      strm << msg << std::endl;
      strm << dashSep << std::endl;

      for (unsigned int i = 0; i < data.size(0); ++i)
      {
         for (unsigned int j=0; j < data.size(1); ++j)
         {
            strm << setw(3) << data.get(i,j) << " ";
         }

         strm << std::endl;
      }

      strm << dashSep << std::endl;
      strm << std::endl;

      LOG4CXX_INFO(boilerplate_.getLogger(), strm.str());
      strm.str("");
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_listener_exec_i::on_metadata_intercept(
         ::SNA_Examples::DataMap_UDM_msg & /* datum */)
   {
      /* Your code here. */
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Facet Executor Implementation Class: dataMapSubConnStatus_exec_i
    */

   dataMapSubConnStatus_exec_i::dataMapSubConnStatus_exec_i(
      ::SNA_Examples::CCM_DataCollector_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataCollector_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   dataMapSubConnStatus_exec_i::~dataMapSubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   dataMapSubConnStatus_exec_i::on_inconsistent_topic(
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
   dataMapSubConnStatus_exec_i::on_requested_incompatible_qos(
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
   dataMapSubConnStatus_exec_i::on_sample_rejected(
         ::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::SampleRejectedStatus &  status )
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
   dataMapSubConnStatus_exec_i::on_offered_deadline_missed(
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
   dataMapSubConnStatus_exec_i::on_offered_incompatible_qos(
         ::DDS::DataWriter_ptr /* the_writer */,
         const ::DDS::OfferedIncompatibleQosStatus & status )
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_ERROR(boilerplate_.getLogger(), "on_offered_incompatible_qos : "
            "total_count = " << status.total_count << ", "
            "total_count_change = " << status.total_count_change << ", "
            "last_policy_id = " << status.last_policy_id);
   }

   // --------------------------------------------------------------------------

   void
   dataMapSubConnStatus_exec_i::on_unexpected_status(
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
    * Component Executor Implementation Class: DataCollector_comp_exec_i
    */

   DataCollector_comp_exec_i::DataCollector_comp_exec_i() :
         boilerplate_("DataCollector_comp",
                      "SNA_Examples"),
         lib_(),
         receiveMsgLoggingModulo_(1)
   {
   }

   // --------------------------------------------------------------------------

   DataCollector_comp_exec_i::~DataCollector_comp_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Supported operations and attributes.
   ACE_Reactor*
   DataCollector_comp_exec_i::reactor()
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

   ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener_ptr
   DataCollector_comp_exec_i::get_dataMapSub_status()
   {
      if (::CORBA::is_nil(this->ciao_dataMapSub_status_.in()))
      {
         dataMapSub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            dataMapSub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener::_nil());

         this->ciao_dataMapSub_status_ = tmp;
      }

      return
         ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener::_duplicate(
            this->ciao_dataMapSub_status_.in());
   }

   // --------------------------------------------------------------------------

   ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Listener_ptr
   DataCollector_comp_exec_i::get_dataMapSub_listener()
   {
      if (::CORBA::is_nil(this->ciao_dataMapSub_listener_.in()))
      {
         dataMapSub_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            dataMapSub_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Listener::_nil());

         this->ciao_dataMapSub_listener_ = tmp;
      }

      return
         ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Listener::_duplicate(
            this->ciao_dataMapSub_listener_.in());
   }

   // --------------------------------------------------------------------------

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   DataCollector_comp_exec_i::get_dataMapSubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_dataMapSubConnStatus_.in()))
      {
         dataMapSubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            dataMapSubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_dataMapSubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_dataMapSubConnStatus_.in());
   }

   // --------------------------------------------------------------------------

   // Operations from Components::SessionComponent.

   void
   DataCollector_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_DataCollector_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   // --------------------------------------------------------------------------

   void
   DataCollector_comp_exec_i::configuration_complete()
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
         spdm_example_cfg.lookupValue
            ("SPDM_Example.dataCollector.receiveMsgLoggingModulo",
                  receiveMsgLoggingModulo_);
      }
      else
      {
         LOG4CXX_WARN(boilerplate_.getLogger(),
                      "Could not open config file '" <<
                      SPDM_ExampleConfigFilename <<
                      "' for the SPDM example.  Using defaults");
      }

      LOG4CXX_DEBUG(boilerplate_.getLogger(),
         "================== RUN PARAMETERS ==================\n" <<
         "receiveMsgLoggingModulo_  : Log every "         <<
            receiveMsgLoggingModulo_  << "th received message\n"   <<
         "====================================================");
   }

   // --------------------------------------------------------------------------

   void
   DataCollector_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to enable the PSAT listener
      //////////////////////////////////////////////////////////////////////////

      CCM_PSAT::PSAT_Listener_Control_var listenControl =
            ciao_context_->get_connection_dataMapSub_listener_control();

      if (CORBA::is_nil(listenControl.in()))
      {
         boilerplate_.failed_state_change(
               "The listener control receptacle is null");
      }

      listenControl->on_metadata_intercept_enable(CCM_PSAT::CALLBACK_DISABLED);
      listenControl->on_one_data_enable(CCM_PSAT::CALLBACK_ENABLED);
   }

   // --------------------------------------------------------------------------

   void
   DataCollector_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();
   }

   // --------------------------------------------------------------------------

   void
   DataCollector_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   // --------------------------------------------------------------------------

   bool DataCollector_comp_exec_i::isOkayToLogMsg(int msgCnt)
   {
      return ((msgCnt - 1) % receiveMsgLoggingModulo_) == 0;
   }

   // --------------------------------------------------------------------------

   extern "C"
   SNA_EXAMPLES_DATACOLLECTOR_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataCollector_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         DataCollector_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
