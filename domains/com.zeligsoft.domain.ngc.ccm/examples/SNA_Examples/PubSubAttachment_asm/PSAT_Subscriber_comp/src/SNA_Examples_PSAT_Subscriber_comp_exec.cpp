//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup PSAT_Subscriber_comp
/// @{
/// @file   SNA_Examples_PSAT_Subscriber_comp_exec.cpp
/// @brief  Implementation of executor classes for the PSAT_Subscriber_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_PSAT_Subscriber_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: included to get byte swapping code
#include "SNA_EndianSwap.h"

// EXAMPLE: included to create logging strings
#include <sstream>

// EXAMPLE: This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

// EXAMPLE: This include file was added by hand in order to be able to use the
//          SNA extensions to the SNA Config Parameter Access API.
#include "SNA_ConfigParams.h"

// EXAMPLE: This include file was added by hand in order to use the subscribing
//          UDM reference.
#include "PSAT_Subscribing_UDM_ref_T.h"

namespace CIAO_SNA_Examples_PSAT_Subscriber_comp_Impl
{

   /**
    * Facet Executor Implementation Class: numArraySub_status_exec_i
    */

   numArraySub_status_exec_i::numArraySub_status_exec_i(
      ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   numArraySub_status_exec_i::~numArraySub_status_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::SNA_Examples::PSAT_Example_UDM_conn::PSAT_Reader_Status_Listener

   void
   numArraySub_status_exec_i::on_requested_deadline_missed(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedDeadlineMissedStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_requested_deadline_missed callback");
   }

   // --------------------------------------------------------------------------

   void
   numArraySub_status_exec_i::on_sample_lost(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleLostStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_sample_lost callback");
   }

   // --------------------------------------------------------------------------

   void
   numArraySub_status_exec_i::on_copy_unsupported(
      const ::SNA_Examples::PSAT_Example_UDM_msg & datum,
      const ::CCM_PSAT::Error_Callback_Info & info)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_copy_unsupported callback for UDM with "
                    "sequence number (" << datum.sequenceNum << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // --------------------------------------------------------------------------

   void
   numArraySub_status_exec_i::on_buffer_invalidation(
      const ::SNA_Examples::PSAT_Example_UDM_msg & datum,
      const ::CCM_PSAT::Error_Callback_Info & info)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_buffer_invalidation callback for UDM with "
                    "sequence number (" << datum.sequenceNum << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // --------------------------------------------------------------------------

   void
   numArraySub_status_exec_i::on_incomplete_transfer(
      const ::SNA_Examples::PSAT_Example_UDM_msg & datum,
      const ::CCM_PSAT::Error_Callback_Info & info)
   {
      // Note that this is a warning and not an error since UDMs could be
      // received before PSAT discovery completes, which may or may not be an
      // error depending on the context.
      // Once PSAT has a callback for discovery completion/updates, then this
      // could be made an error again.
      LOG4CXX_WARN(boilerplate_.getLogger(),
                    "Received on_incomplete_transfer callback for UDM with "
                    "sequence number (" << datum.sequenceNum << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // --------------------------------------------------------------------------

   void
   numArraySub_status_exec_i::on_invalid_udm_psat_header(
      const ::SNA_Examples::PSAT_Example_UDM_msg & datum,
      const ::CCM_PSAT::Error_Callback_Info & info)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_invalid_udm_psat_header callback for UDM with "
                    "sequence number (" << datum.sequenceNum << ") and "
                    "explanation (" << info.explanation << ")");
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   //============================================================
   // Facet Executor Implementation Class: numArraySub_listener_exec_i
   //============================================================

   numArraySub_listener_exec_i::numArraySub_listener_exec_i(
      ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context::_duplicate(ctx)),
         boilerplate_ (boilerplate),
         recvMsgCount_(0)
   {
   }

   // --------------------------------------------------------------------------

   numArraySub_listener_exec_i::~numArraySub_listener_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::SNA_Examples::PSAT_Example_UDM_conn::PSAT_Listener

   void
   numArraySub_listener_exec_i::on_one_data(
      const ::SNA_Examples::PSAT_Example_UDM_msg & datum,
      const ::CCM_DDS::ReadInfo & /* read_info */)
   {
      recvMsgCount_++;

      // Get object reference for attachment control interface
      ::SNA_Examples::PSAT_Example_UDM_conn::PSAT_Attachment_Control_var
         attachCtrlObj =
            ciao_context_->get_connection_numArraySub_attachment_control();

      if (CORBA::is_nil(attachCtrlObj.in()))
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
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
               ::SNA_Examples::PSAT_Example_UDM_msg,
               ::SNA_Examples::PSAT_Example_UDM_conn::PSAT_Attachment_Control>
               DataMap_Subscribing_UDM_Ref_t;

         DataMap_Subscribing_UDM_Ref_t udm_ref(attachCtrlObj.in(),datum);

         // -----------------

         // Get address to start of the PSAT sample and cast it to an appropriate
         // type
         uint64_t * numArray = reinterpret_cast<uint64_t *>(
               udm_ref.udm().psat_hdr.sample_start_address);

         if (0 == numArray)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "Got a null pointer from UDM");
            return;
         }

         // -----------------

         // calculate the number of 64-bit integers in the sample
         uint64_t numElements =
               udm_ref.udm().psat_hdr.psat_view.block_length / sizeof(uint64_t);

         // -----------------

         bool okayToLog =
               this->boilerplate_.getCompExecPtr()->isOkayToLogMsg(recvMsgCount_);

         if (okayToLog)
         {
            // Create log message with the first several numbers to check if this
            // component received the data correctly
            std::stringstream numStr;
            numStr << "MSG[" << udm_ref.udm().publisherId << " : "
                   <<           udm_ref.udm().msgCnt      << "] .. " <<
                  "Received attachment (" << numElements
                   << " elements) .. (first 10 numbers):" << std::endl;

            // Use method added to class to perform endian translation on first 10
            // elements of the attachment
            this->translate_endian(numArray, 10, udm_ref.udm().psat_hdr);

            for (int i = 0; i < 10; ++i)
            {
               numStr << "numArray[" << i << "] = " << numArray[i] << std::endl;
            }

            LOG4CXX_INFO(boilerplate_.getLogger(), numStr.str());
         }
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
   numArraySub_listener_exec_i::on_metadata_intercept(
      ::SNA_Examples::PSAT_Example_UDM_msg & /* datum */)
   {
      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   numArraySub_listener_exec_i::translate_endian(
      uint64_t                    * data,
      size_t                        numElements,
      const CCM_PSAT::PSAT_Header & psat_info)
   {
      bool needsSwap =
            (psat_info.source_endian !=
             psat_info.sub_side_info.destination_endian);

      if (needsSwap)
      {
         for (size_t i = 0; i < numElements; ++i)
         {
            data[i] = SNA::byteSwap(data[i]);
         }
      }
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Facet Executor Implementation Class: numArraySubConnStatus_exec_i
    */

   numArraySubConnStatus_exec_i::numArraySubConnStatus_exec_i(
      ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   numArraySubConnStatus_exec_i::~numArraySubConnStatus_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   numArraySubConnStatus_exec_i::on_inconsistent_topic(
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
   numArraySubConnStatus_exec_i::on_requested_incompatible_qos(
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
   numArraySubConnStatus_exec_i::on_sample_rejected(
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
   numArraySubConnStatus_exec_i::on_offered_deadline_missed(
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
   numArraySubConnStatus_exec_i::on_offered_incompatible_qos(
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
   numArraySubConnStatus_exec_i::on_unexpected_status(
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
    * Component Executor Implementation Class: PSAT_Subscriber_comp_exec_i
    */

   PSAT_Subscriber_comp_exec_i::PSAT_Subscriber_comp_exec_i() :
         boilerplate_("PSAT_Subscriber_comp",
                      "SNA_Examples"),
         receiveMsgLoggingModulo_      (1),
         receiveMsgLoggingModuloExtent_(2)
   {
   }

   // --------------------------------------------------------------------------

   PSAT_Subscriber_comp_exec_i::~PSAT_Subscriber_comp_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Supported operations and attributes.
   ACE_Reactor*
   PSAT_Subscriber_comp_exec_i::reactor()
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

   ::SNA_Examples::PSAT_Example_UDM_conn::CCM_PSAT_Reader_Status_Listener_ptr
   PSAT_Subscriber_comp_exec_i::get_numArraySub_status()
   {
      if (::CORBA::is_nil(this->ciao_numArraySub_status_.in()))
      {
         numArraySub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numArraySub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::PSAT_Example_UDM_conn::CCM_PSAT_Reader_Status_Listener::_nil());

         this->ciao_numArraySub_status_ = tmp;
      }

      return
         ::SNA_Examples::PSAT_Example_UDM_conn::CCM_PSAT_Reader_Status_Listener::_duplicate(
            this->ciao_numArraySub_status_.in());
   }

   // --------------------------------------------------------------------------

   ::SNA_Examples::PSAT_Example_UDM_conn::CCM_PSAT_Listener_ptr
   PSAT_Subscriber_comp_exec_i::get_numArraySub_listener()
   {
      if (::CORBA::is_nil(this->ciao_numArraySub_listener_.in()))
      {
         numArraySub_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numArraySub_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::PSAT_Example_UDM_conn::CCM_PSAT_Listener::_nil());

         this->ciao_numArraySub_listener_ = tmp;
      }

      return
         ::SNA_Examples::PSAT_Example_UDM_conn::CCM_PSAT_Listener::_duplicate(
            this->ciao_numArraySub_listener_.in());
   }

   // --------------------------------------------------------------------------

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   PSAT_Subscriber_comp_exec_i::get_numArraySubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_numArraySubConnStatus_.in()))
      {
         numArraySubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numArraySubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_numArraySubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_numArraySubConnStatus_.in());
   }

   // --------------------------------------------------------------------------

   // Operations from Components::SessionComponent.

   void
   PSAT_Subscriber_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_PSAT_Subscriber_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Subscriber_comp_exec_i::configuration_complete()
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
         psat_example_cfg.lookupValue
            ("PSAT_Example.subscriber.receiveMsgLoggingModulo",
                  receiveMsgLoggingModulo_);

         psat_example_cfg.lookupValue
            ("PSAT_Example.subscriber.receiveMsgLoggingModuloExtent",
                  receiveMsgLoggingModuloExtent_);
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
         "receiveMsgLoggingModulo_       : "            <<
            receiveMsgLoggingModulo_  << "\n"   <<
         "receiveMsgLoggingModuloExtent_ : "          <<
            receiveMsgLoggingModuloExtent_ << "\n"                <<
            "These parameters mean that every " << receiveMsgLoggingModulo_
            << "th message will be the start of a set of "
            << receiveMsgLoggingModuloExtent_ << " received messages that will "
                  "be logged.\n" <<
         "====================================================");
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Subscriber_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to enable the PSAT listener
      //////////////////////////////////////////////////////////////////////////

      CCM_PSAT::PSAT_Listener_Control_var listenControl =
            ciao_context_->get_connection_numArraySub_listener_control();

      if (CORBA::is_nil(listenControl.in()))
      {
         boilerplate_.failed_state_change(
               "The listener control receptacle is null");
      }

      try
      {
         listenControl->on_metadata_intercept_enable(
               CCM_PSAT::CALLBACK_DISABLED);

         listenControl->on_one_data_enable(CCM_PSAT::CALLBACK_ENABLED);
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
      }
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Subscriber_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();
   }

   // --------------------------------------------------------------------------

   void
   PSAT_Subscriber_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   // --------------------------------------------------------------------------

   bool PSAT_Subscriber_comp_exec_i::isOkayToLogMsg(int msgCnt)
   {
      return ((msgCnt - 1) % receiveMsgLoggingModulo_) <
            receiveMsgLoggingModuloExtent_;
   }

   // --------------------------------------------------------------------------

   extern "C"
   SNA_EXAMPLES_PSAT_SUBSCRIBER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_PSAT_Subscriber_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         PSAT_Subscriber_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
