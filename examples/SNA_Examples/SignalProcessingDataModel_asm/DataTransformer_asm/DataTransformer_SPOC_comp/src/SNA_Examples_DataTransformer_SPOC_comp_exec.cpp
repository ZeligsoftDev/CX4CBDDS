//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataTransformer_SPOC_comp
/// @{
/// @file   SNA_Examples_DataTransformer_SPOC_comp_exec.cpp
/// @brief  Implementation of executor classes for the DataTransformer_SPOC_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_DataTransformer_SPOC_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This include file was added by hand in order to be able to use the
//          SNA extensions to the SNA Config Parameter Access API.
#include "SNA_ConfigParams.h"

#include "SNA_DataViewTranslator.h"

// EXAMPLE: This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

// EXAMPLE: included to get byte swapping code
#include "SNA_EndianSwap.h"

#include "vsip/serialization.hpp"

#include "PSAT_Publishing_UDM_ref_T.h"
#include "PSAT_Subscribing_UDM_ref_T.h"

namespace CIAO_SNA_Examples_DataTransformer_SPOC_comp_Impl
{

   /**
    * Facet Executor Implementation Class: dataMapPub_status_exec_i
    */

   dataMapPub_status_exec_i::dataMapPub_status_exec_i(
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context::_duplicate(ctx)),
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
      LOG4CXX_INFO(boilerplate_.getLogger(), "There is a buffer available now");

      /*
       * EXAMPLE: In real applications, a developer might call create_data
       *          here and then use the buffer which is now free.
       *
       *          In the case of this example (and in some real applications),
       *          since the DataDistributor component is continuing to send new
       *          messages for us to transform, we had to throw away all the
       *          ones that were received while we didn't have a buffer to use
       *          for the transformed output.  Therefore when a buffer becomes
       *          available, there is really nothing to do because we have
       *          already thrown away the last received message.
       *
       *          So we do nothing here, and then the next time we receive a
       *          new message in our on_one_data callback, it will be processed
       *          normally.
       */
   }

   // --------------------------------------------------------------------------

   void
   dataMapPub_status_exec_i::on_buffer_wait_timeout()
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Timeout occurred waiting for free buffer");
   }

   // --------------------------------------------------------------------------

   /**
    * Facet Executor Implementation Class: dataMapSub_status_exec_i
    */

   dataMapSub_status_exec_i::dataMapSub_status_exec_i(
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context::_duplicate(ctx)),
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
   dataMapSub_status_exec_i::on_requested_deadline_missed(
         ::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::RequestedDeadlineMissedStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "Received on_requested_deadline_missed callback");
   }

   // --------------------------------------------------------------------------

   void
   dataMapSub_status_exec_i::on_sample_lost(::DDS::DataReader_ptr /* the_reader */,
         const ::DDS::SampleLostStatus & /* status */)
   {
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
         const ::SNA_Examples::DataMap_UDM_msg & datum ,
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
         const ::SNA_Examples::DataMap_UDM_msg & datum ,
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
         const ::SNA_Examples::DataMap_UDM_msg & datum ,
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
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate),
         recvMsgCount_(0),
         lib_()
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
         const ::SNA_Examples::DataMap_UDM_msg & datum,
         const ::CCM_DDS::ReadInfo & /* read_info */)
   {
      recvMsgCount_++;

      bool okayToLog =
            this->boilerplate_.getCompExecPtr()->isOkayToLogMsg(recvMsgCount_);

      if (okayToLog)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "MSG[" << recvMsgCount_ << "] .. " <<
                      "on_one_data called for subsample " <<
                      datum.message_number << " with ad_buffer_id = " <<
                      datum.psat_hdr.ad_buffer_id);
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

      // Creating writerObj for (potential) use in exception
      ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Writer_var writerObj;

      try
      {
         // EXAMPLE:
         // This is a "smart pointer" to a UDM. When you create a Subscribing
         // UDM reference, the destructor will call "release_buffer()" when the
         // last reference has been removed. If you invoke the copy constructor of
         // this UDM ref, the reference count will be incremented.
         typedef CCM_PSAT::Subscribing_UDM_ref<
               ::SNA_Examples::DataMap_UDM_msg,
               ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Attachment_Control>
               DataMap_Subscribing_UDM_Ref_t;

         DataMap_Subscribing_UDM_Ref_t sub_udm_ref(attachCtrlObj.in(),datum);

         // -----------------

         // Get object reference for writer interface
         writerObj = ciao_context_->get_connection_dataMapPub_data();

         if (CORBA::is_nil(writerObj.in()))
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << recvMsgCount_ << "] .. " <<
                          "Connector writer receptacle is nil");

            return;
         }

         // -----------------

         // EXAMPLE:
         // This is a "smart pointer" to a UDM. When you create a Publishing
         // UDM reference, the constructor will call "create_data()" and the
         // destructor will call "release_buffer()" when the last reference
         // has been removed. If you invoke the copy constructor of this UDM ref
         // the reference count will be incremented.
         typedef CCM_PSAT::Publishing_UDM_ref<
               ::SNA_Examples::DataMap_UDM_msg,
               ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Writer>
               DataMap_Publishing_UDM_Ref_t;

         DataMap_Publishing_UDM_Ref_t pub_udm_ref(writerObj.in());

         // fill out the publisher's role, and copy udm fields from the
         // received UDM to the publishers UDM. This component is publishing
         // transformed child data.
         pub_udm_ref.udm().spdm_hdr          = sub_udm_ref.udm().spdm_hdr;
         pub_udm_ref.udm().spdm_hdr.pub_role = CCM_SPDM::TRANS_CHILD_DATA;

         // Make sure to copy the ad_buffer_id. This field is used by the
         // DataCollector_comp to aggregate sub-samples. It is an identifier
         // which was generated by the DataDistributor_comp.
         pub_udm_ref.udm().psat_hdr.ad_buffer_id =
               sub_udm_ref.udm().psat_hdr.ad_buffer_id;

         // Custom field populated by the DataDistributor_comp. You would need
         // to copy any other custom fields here.
         //
         // NOTE: You should NOT copy the entire UDM since the publishing
         // connector and the subscribing connector will have fields specific
         // to each in the psat_hdr.
         pub_udm_ref.udm().message_number        =
               sub_udm_ref.udm().message_number;

         // -----------------

         // Get pointer to the beginning of the output PSAT buffer
         int * publisherData =
               reinterpret_cast<int *>(
                     pub_udm_ref.udm().psat_hdr.sample_start_address);

         // Get a pointer to the beginning of the input PSAT buffer
         int * subscriberData =
               reinterpret_cast<int *>(
                     sub_udm_ref.udm().psat_hdr.sample_start_address);

         // Make sure both headers gave back a valid buffer pointer
         if (0 == publisherData || 0 == subscriberData)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << recvMsgCount_ << "] .. " <<
                          "Got a null pointer from UDM");

            return;
         }

         // Descriptor object is a VSIPL++ meta data object
         vsip::serialization::Descriptor dataDescriptor;

         // This function will translate the spdm header into a vsipl descriptor
         // object.
         SNA::DataViewTranslator::spdm_idl_to_cpp(
               sub_udm_ref.udm().spdm_hdr,
               dataDescriptor);

         // -----------------

         unsigned int matrixSize = dataDescriptor.size[0] *
                                   dataDescriptor.size[1];

         if (okayToLog)
         {
            LOG4CXX_INFO(boilerplate_.getLogger(),
                         "MSG[" << recvMsgCount_ << "] .. " <<
                         "Received matrix with " << matrixSize << " elements!");
         }

         SNA::ByteSequence dataInPtr(
               (matrixSize) * sizeof(int),
               (matrixSize) * sizeof(int),
               (::CORBA::Octet *)subscriberData);

         SNA::ByteSequence dataOutPtr(
               (matrixSize) * sizeof(int),
               (matrixSize) * sizeof(int),
               (::CORBA::Octet *)publisherData);

         // Unlike regular DDS, SPDM/PSAT requires the application developer to
         // manually swap the contents of the attachment.  SNA provides the
         // capability to endian swap raw data in a VSIPL++ view.
         if (sub_udm_ref.udm().psat_hdr.source_endian !=
              sub_udm_ref.udm().psat_hdr.sub_side_info.destination_endian)
         {
            if (okayToLog)
            {
               LOG4CXX_INFO(boilerplate_.getLogger(),
                            "MSG[" << recvMsgCount_ << "] .. " <<
                            "Endian swapping data");
            }

            SNA::DataViewTranslator::EndianSwapViewData(dataDescriptor,
                                                        subscriberData);
         }

         // --------------------------------------------------------------------
         //                 MKC->init()
         // --------------------------------------------------------------------

         //     Since this is a non-local (i.e., non-collocated) object
         //     reference, caching of the reference is not safe as the
         //     remote object could be moved, etc. This is the reason that
         //     the object reference is placed into a local variable that is
         //     recreated every time the reference is used.

         SNA_Examples::DataTransformerMath_obj_var mathObj =
                                     ciao_context_->get_connection_mathRecept();

         if ( ! CORBA::is_nil(mathObj.in()))
         {
            // call init on the MKC component
            mathObj->init();

            // Need to create a child SP data header for the MKC object. The
            // SP data header contained in the UDM
            SNA::SP_DataHdr dataDescriptorIdl;

            SNA::DataViewTranslator::cpp_to_idl(dataDescriptor,     // vsipl in
                                                dataDescriptorIdl); // idl out

            // call the compute method for this MKC
            mathObj->compute(dataDescriptorIdl,
                             dataInPtr,
                             dataOutPtr);

            // call cleanup on the MKC component
            mathObj->cleanup();
         }
         else
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                          "MSG[" << recvMsgCount_ << "] .. " <<
                          "Error calling init() - mathObj is nil");
            return;
         }

         // -----------------

         if (okayToLog)
         {
            LOG4CXX_INFO(boilerplate_.getLogger(),
                         "MSG[" << recvMsgCount_ << "] .. " <<
                         "write_one for transformed data chip!");
         }

         // -----------------

         // Publish the PSAT sample
         writerObj->write_one(pub_udm_ref.udm());
      }
      catch (CCM_DDS::InternalError & excep)
      {
         // This exception can be thrown due to a DDS error. The
         // translate_retcode function creates a human-readable string from a
         // DDS return code.

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << recvMsgCount_ << "] .. " <<
                       "Caught InternalError on write_one call with "
                       "DDS return code: "
               << ::CIAO::DDS4CCM::translate_retcode(excep.error_code));

         return;
      }
      catch (CCM_PSAT::AD_Buffer_None_Available_Excp & excep)
      {
         // This exception can be thrown due to no buffers being available when
         // calling create_data

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << recvMsgCount_ << "] .. " <<
                       "Caught AD_Buffer_None_Available_Excp with information: "
                       << "topic name = " << excep.topic_name << " : "
                       << "connector id = " << excep.connector_id << " : "
                       << "explanation = " << excep.explanation);

         // get a notification callback (on_buffer_available) when a buffer is
         // free. Note that no blocking occurs here. This is purely callback
         // driven and sets up a future notification using the callback.
         //
         writerObj->notify_when_buffer_is_free(CCM_PSAT::PSAT_TIMEOUT_INFINITE);

         return;
      }
      catch (CCM_PSAT::Invalid_UDM_PSAT_Header_Excp & excep)
      {
         // This exception can be thrown by filling out the UDM incorrectly or
         // by releasing a buffer more than once

         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << recvMsgCount_ << "] .. " <<
                       "Caught Invalid_UDM_PSAT_Header_Excp with information: "
               << "topic name = " << excep.topic_name << " : "
               << "connector id = " << excep.connector_id << " : "
               << "explanation = " << excep.explanation);

         return;
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
   dataMapSub_listener_exec_i::on_metadata_intercept(
         ::SNA_Examples::DataMap_UDM_msg & /* datum */)
   {
      /* Your code here. */
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Facet Executor Implementation Class: dataMapPubConnStatus_exec_i
    */

   dataMapPubConnStatus_exec_i::dataMapPubConnStatus_exec_i(
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context::_duplicate(ctx)),
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
   dataMapPubConnStatus_exec_i::on_sample_rejected(::DDS::DataReader_ptr /* the_reader */,
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
   dataMapPubConnStatus_exec_i::on_offered_deadline_missed(::DDS::DataWriter_ptr /* the_writer */,
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
   dataMapPubConnStatus_exec_i::on_offered_incompatible_qos(::DDS::DataWriter_ptr /* the_writer */,
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
   dataMapPubConnStatus_exec_i::on_unexpected_status(::DDS::Entity_ptr /* the_entity */,
         ::DDS::StatusKind status_kind )
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_DEBUG(boilerplate_.getLogger(),
               "on_unexpected_status called with status "
            << CIAO::DDS4CCM::translate_statuskind(status_kind));
   }

   // --------------------------------------------------------------------------

   /**
    * Facet Executor Implementation Class: dataMapPubConnStatus_exec_i
    */

   dataMapSubConnStatus_exec_i::dataMapSubConnStatus_exec_i(
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   // --------------------------------------------------------------------------

   dataMapSubConnStatus_exec_i::~dataMapSubConnStatus_exec_i()
   {
   }

   // --------------------------------------------------------------------------

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
   dataMapSubConnStatus_exec_i::on_sample_rejected(::DDS::DataReader_ptr /* the_reader */,
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
   dataMapSubConnStatus_exec_i::on_offered_deadline_missed(::DDS::DataWriter_ptr /* the_writer */,
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
   dataMapSubConnStatus_exec_i::on_offered_incompatible_qos(::DDS::DataWriter_ptr /* the_writer */,
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
   dataMapSubConnStatus_exec_i::on_unexpected_status(::DDS::Entity_ptr /* the_entity */,
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
    * Component Executor Implementation Class: DataTransformer_SPOC_comp_exec_i
    */

   DataTransformer_SPOC_comp_exec_i::DataTransformer_SPOC_comp_exec_i() :
         boilerplate_("DataTransformer_SPOC_comp","SNA_Examples"),
         messageNumber_          (0),
         receiveMsgLoggingModulo_(1)
   {
   }

   // --------------------------------------------------------------------------

   DataTransformer_SPOC_comp_exec_i::~DataTransformer_SPOC_comp_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Supported operations and attributes.
   ACE_Reactor*
   DataTransformer_SPOC_comp_exec_i::reactor()
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
    DataTransformer_SPOC_comp_exec_i::messageNumber()
   {
      return this->messageNumber_;
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_SPOC_comp_exec_i::messageNumber(
      const ::CORBA::Long messageNumber)
   {
      this->messageNumber_ = messageNumber;
   }

   // --------------------------------------------------------------------------

   ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
   DataTransformer_SPOC_comp_exec_i::get_dataMapPub_status()
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

   ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener_ptr
   DataTransformer_SPOC_comp_exec_i::get_dataMapSub_status()
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
   DataTransformer_SPOC_comp_exec_i::get_dataMapSub_listener()
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
   DataTransformer_SPOC_comp_exec_i::get_dataMapPubConnStatus()
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

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   DataTransformer_SPOC_comp_exec_i::get_dataMapSubConnStatus()
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
   DataTransformer_SPOC_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_SPOC_comp_exec_i::configuration_complete()
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
            ("SPDM_Example.dataTransformer.receiveMsgLoggingModulo",
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
   DataTransformer_SPOC_comp_exec_i::ccm_activate()
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

      //////////////////////////////////////////////////////////////////////////
      // Handewritten code to set the filter parameters
      //
      // Note: This should be done in activate to ensure that the connector
      // has also entered/exited configuration_complete().
      //////////////////////////////////////////////////////////////////////////
      ::CCM_DDS::ContentFilterSetting_var filterSetting =
            ciao_context_->get_connection_dataMapSub_filter_config();

      if (CORBA::is_nil(filterSetting.in()))
      {
         // This will throw an exception to be caught by the deployment system.
         boilerplate_.failed_state_change(
               "The content filter setting receptacle is null");
      }

      // EXAMPLE:
      // create a string from the messageNumber_ attribute. This will be used
      // to update the filter expression.
      std::stringstream messageNumber;
      messageNumber << messageNumber_;

      // EXAMPLE:
      // Update the filter parameters. To do this, you need to use the
      // DDS::StringSeq type. First set the length, then perform a string_dup
      // (similar to a string copy) into the first array element. Use the filter
      // setting to update the parameters dynamically.
      //
      // By setting parameters[0] here, we are effectively replacing the first
      // parameter in the content filter expression given by %0. The content
      // filter expression must be set in the deployment plan via a deployment
      // planning tool.
      ::DDS::StringSeq parameters;
      parameters.length(1);
      parameters[0] = CORBA::string_dup(messageNumber.str().c_str());
      try
      {
         filterSetting->set_filter_parameters(parameters);
      }
      catch (CCM_DDS::InternalError & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
            "While attempting to invoke set_filter_parameters(), " <<
            "caught InternalError exception.  Contained DDS error code is "
            << ::CIAO::DDS4CCM::translate_retcode(ex.error_code));

         boilerplate_.failed_state_change(
               "Caught InternalError exception while attempting to invoke"
               "set_filter_parameters()!");
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
            "While attempting to invoke set_filter_parameters(), " <<
            "caught CORBA::Exception: " << ex);

         boilerplate_.failed_state_change(
               "Caught CORBA::Exception while attempting to invoke"
               "set_filter_parameters()!");
      }
      catch (...) // catch everything else. If invoked something is very wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
            "While attempting to invoke set_filter_parameters(), " <<
            "caught an unknown exception.");

         boilerplate_.failed_state_change(
               "Caught unknown exception while attempting to invoke"
               "set_filter_parameters()!");
      }
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_SPOC_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_SPOC_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   // --------------------------------------------------------------------------

   bool DataTransformer_SPOC_comp_exec_i::isOkayToLogMsg(int msgCnt)
   {
      return ((msgCnt - 1) % receiveMsgLoggingModulo_) == 0;
   }

   // --------------------------------------------------------------------------

   extern "C"
   SNA_EXAMPLES_DATATRANSFORMER_SPOC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataTransformer_SPOC_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         DataTransformer_SPOC_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
