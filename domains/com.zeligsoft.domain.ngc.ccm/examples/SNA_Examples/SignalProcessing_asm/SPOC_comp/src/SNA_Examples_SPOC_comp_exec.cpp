//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SPOC_comp
/// @{
/// @file   SNA_Examples_SPOC_comp_exec.cpp
/// @brief  Implementation of executor classes for the SPOC_comp component and
///         its facets.  The SPOC component subscribes to data from the
///         SPOC_Starter and upon receiving it invokes a math function
///         on the data through a facet provided by the Math Kernel Component
///         (MKC).
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_SPOC_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                   Business logic: includes and typedefs
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

// This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

// C++ -> IDL conversions for the Descriptor metadata used with VSIPL++ objects
// and Endian Swapping, if required
#include "SNA_DataViewTranslator.h"

// Print VSIPL++ Views
#include "SNA_Examples_DataObjectPrinter.h"

// block marshal API in Code Sourcery's library
#include <vsip/serialization.hpp>

namespace CIAO_SNA_Examples_SPOC_comp_Impl
{

   /**
    * Facet Executor Implementation Class: SP_DataPub_status_exec_i
    */

   SP_DataPub_status_exec_i::SP_DataPub_status_exec_i(
      ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   SP_DataPub_status_exec_i::~SP_DataPub_status_exec_i()
   {
   }

   // Operations from ::CCM_PSAT::PSAT_Writer_Status_Listener

   void
   SP_DataPub_status_exec_i::on_buffer_available()
   {
      LOG4CXX_DEBUG(boilerplate_.getLogger(),
                    "SP_DataPub: on buffer available");
   }

   void
   SP_DataPub_status_exec_i::on_buffer_wait_timeout()
   {
      LOG4CXX_DEBUG(boilerplate_.getLogger(),
                    "SP_DataPub: on buffer wait timeout");
   }

   /**
    * Facet Executor Implementation Class: SP_DataPubConnStatus_exec_i
    */

   SP_DataPubConnStatus_exec_i::SP_DataPubConnStatus_exec_i(
      ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   SP_DataPubConnStatus_exec_i::~SP_DataPubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   SP_DataPubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "SP_DataPub: inconsistent topic");
   }

   void
   SP_DataPubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "SP_DataPub: requested incompatible QoS");
   }

   void
   SP_DataPubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "SP_DataPub: sample rejected");
   }

   void
   SP_DataPubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "SP_DataPub: offered deadline missed");
   }

   void
   SP_DataPubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "SP_DataPub: offered incompatible QoS");
   }

   void
   SP_DataPubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind status_kind)
   {
      /* Your code here. */
      LOG4CXX_DEBUG(boilerplate_.getLogger(),
            "on_unexpected_status called with status "
            << CIAO::DDS4CCM::translate_statuskind(status_kind));
   }

   /**
    * Facet Executor Implementation Class: SP_DataSub_status_exec_i
    */

   SP_DataSub_status_exec_i::SP_DataSub_status_exec_i(
      ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   SP_DataSub_status_exec_i::~SP_DataSub_status_exec_i()
   {
   }

   // Operations from ::SNA_Examples::SPOC_Data_conn::PSAT_Reader_Status_Listener

   void
   SP_DataSub_status_exec_i::on_requested_deadline_missed(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "SP_DataSub: requested deadline missed");
   }

   void
   SP_DataSub_status_exec_i::on_sample_lost(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleLostStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "SP_DataSub: sample lost");
   }

   void
   SP_DataSub_status_exec_i::on_copy_unsupported(
      const ::SNA_Examples::SPOC_Data_msg & /* datum */,
      const ::CCM_PSAT::Error_Callback_Info & /* info */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "SP_DataSub: copy unsupported");
   }

   void
   SP_DataSub_status_exec_i::on_buffer_invalidation(
      const ::SNA_Examples::SPOC_Data_msg & /* datum */,
      const ::CCM_PSAT::Error_Callback_Info & /* info */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "SP_DataSub: buffer invalidation");
   }

   void
   SP_DataSub_status_exec_i::on_incomplete_transfer(
      const ::SNA_Examples::SPOC_Data_msg & /* datum */,
      const ::CCM_PSAT::Error_Callback_Info & /* info */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "SP_DataSub: incomplete transfer");
   }

   void
   SP_DataSub_status_exec_i::on_invalid_udm_psat_header(
      const ::SNA_Examples::SPOC_Data_msg & /* datum */,
      const ::CCM_PSAT::Error_Callback_Info & /* info */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "SP_DataSub: invalid udm psat header");
   }

   /**
    * Facet Executor Implementation Class: SP_DataSub_listener_exec_i
    */

   // NOTE the initialization of VSIPL++ objects here.  This is necessary
   // because VSIPL++ data objects like Views and Blocks do not support
   // 'empty constructors' - i.e, if you don't know how big a View or Block
   // needs to be, you should not be creating one yet.  This means that if you
   // want to have a VSIPL++ object as a class member variable, it must be
   // initialized with some dummy data in the class's constructor
   SP_DataSub_listener_exec_i::SP_DataSub_listener_exec_i(
      ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate),
         lib_(),
         denseMatIn(vsip::Domain<2>(0,0),(float *)0, (float *)0),
         dataIn(denseMatIn),
         denseMatOut(vsip::Domain<2>(0,0),(float *)0, (float *)0),
         dataOut(denseMatOut)
   {
   }

   SP_DataSub_listener_exec_i::~SP_DataSub_listener_exec_i()
   {
   }

   // Operations from ::SNA_Examples::SPOC_Data_conn::PSAT_Listener

   void
   SP_DataSub_listener_exec_i::on_one_data(
      const ::SNA_Examples::SPOC_Data_msg & receivedData,
      const ::CCM_DDS::ReadInfo & /* read_info */)
   {
      // Get a pointer to the attachment portion of the PSAT message
      // that we just received
      get_attachment_pointer(receivedData);

      // Create the output buffer for the PSAT message that will be published
      // and set a pointer to the attachment portion of that message
      prepare_output_buffer();

      // Using the two data pointers to both the received and publishing
      // attachment memories, instantiate actual VSIPL++ data View objects such
      // that their data will not need to be copied
      create_data_views(receivedData);

      // Invoke the math operations provided by the Math Kernel Component (MKC)
      // using the VSIPL++ data Views we have created
      use_MKC();

      // Publish the output data to the next SPOC (or anyone else) that
      // wants it
      publish_data();

      // Release the buffer so that the memory can be used for other PSAT
      // activities
      bufferControlObj->release_buffer(receivedData);

      // Release the publishing buffer (although we never actually published
      // our data from this component, the buffer must be released regardless
      try {
         dataPubWriter->release_buffer(publishData);
     } catch (const CORBA::Exception & ex)
     {
          LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
     }
   }

   void
   SP_DataSub_listener_exec_i::on_metadata_intercept(
      ::SNA_Examples::SPOC_Data_msg & /* datum */)
   {
      /* Your code here. */
   }

   void SP_DataSub_listener_exec_i::get_attachment_pointer(
         const ::SNA_Examples::SPOC_Data_msg & receivedData)
   {
      bufferControlObj = ciao_context_->
            get_connection_SP_DataSub_attachment_control();



      if (CORBA::is_nil(bufferControlObj.in()))
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "The PSAT_Buffer_Control_var is null");
         return;
      }

      // Get a pointer to the beginning of the sample that we received.  Note
      // that this pointer is to the beginning of the 'blob' that was
      // transfered via PSAT, not to the 'psat header'

      // VSIPL++ will need this pointer to create a user-
      // defined block that uses the received data
      inputSampleData = reinterpret_cast<float *>(
            receivedData.psat_hdr.sample_start_address);
   }


   void SP_DataSub_listener_exec_i::prepare_output_buffer()
   {

     dataPubWriter = ciao_context_->get_connection_SP_DataPub_data();

     if (CORBA::is_nil(dataPubWriter.in()))
     {
        LOG4CXX_ERROR(boilerplate_.getLogger(),
              "The writer receptacle is null");

        return;
     }

     // Instantiate the actual buffer memory that will be published via PSAT
     try {
        dataPubWriter->create_data(publishData);
     } catch (const CORBA::Exception & ex)
     {
          LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
     }

     // Get a pointer to the beginning of the sample to be published

     // VSIPL++ will need this pointer to create a user-
     // defined block that uses the memory registered with PSAT
     outputSampleData =
         reinterpret_cast<float *> (publishData.psat_hdr.sample_start_address);
   }

   void
   SP_DataSub_listener_exec_i::create_data_views(
         const ::SNA_Examples::SPOC_Data_msg & receivedData)
   {
      // Convert the received metadata descriptor from IDL to CPP
      vsip::serialization::Descriptor inputInfo;
      SNA::DataViewTranslator::idl_to_cpp(  receivedData.vsiplMetaData,
                                       inputInfo);

     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     //                            Swap data
     //
     //        Unlike regular DDS, PSAT requires the application developer
     //        to manually swap the contents of the attachment.  SNA provides
     //        the capability to endian swap raw data in a VSIPL++ view, but
     //        any custom structures or fields will need to be handled
     //        separately.
     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

     if (receivedData.psat_hdr.source_endian !=
           receivedData.psat_hdr.sub_side_info.destination_endian)
     {
        LOG4CXX_WARN(boilerplate_.getLogger(), "Endian swapping data");
        SNA::DataViewTranslator::EndianSwapViewData( inputInfo,
                                                inputSampleData);
     }

     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     //          Re-create the VSIPL++ object from the received data
     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

     // Get info about the data size we received - we're expecting a matrix
     short rows, cols;
     if (inputInfo.dimensions == 2) {
        rows = inputInfo.size[0];
        cols = inputInfo.size[1];
     }
     else {
        LOG4CXX_ERROR(boilerplate_.getLogger(), "Did not receive a matrix!");
        return;
     }

     // The total size of the data.  Note that this is the number of elements
     // in the data object, not the size in bytes, or the size of any additional
     // headers in the message.
     int size = rows * cols;

     LOG4CXX_DEBUG(boilerplate_.getLogger(),
                  "####  Received data, " << size << "elements");


     // Check to make sure we received complex_split data of type complex float
     if (inputInfo.storage_format ==
                       vsip::split_complex
           &&
           inputInfo.value_type ==
                       vsip::serialization::type_info<vsip::cscalar_f>::value)
     {

        // Calculate the pointer to the imaginary data,
        unsigned char * pImagIn = (unsigned char *)inputSampleData;
        pImagIn += sizeof(float) * size;

        // Check for compatibility
        bool valid = vsip::serialization::is_compatible<vsip::Dense<2, vsip::cscalar_f> >(inputInfo);

        // Transfer this Block to the View
        if (valid) {
           dataIn.block().rebind(inputSampleData, reinterpret_cast<float *>(pImagIn), vsip::Domain<2>(inputInfo.size[0], inputInfo.size[1]));
           dataIn.block().admit(true);
        }
        else {
           LOG4CXX_ERROR(boilerplate_.getLogger(),"Can't unmarshal data");
        }
     }
     else {
        LOG4CXX_ERROR(boilerplate_.getLogger(),
              "Data received has wrong complex format and/or type");
     }

     // Print data
     SNA_Examples::DataObjectPrinter::PrintComplexMatrix(
              dataIn,
              "VSIPL++ SPOC input data after admit:",
              boilerplate_.getLogger());


     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     //                       Create the output View
     // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

     // Rebind output View to its data
     dataOut.block().rebind( outputSampleData,
                             &outputSampleData[size],
                             vsip::Domain<2>(rows, cols));

     // Admit data to VSIPL++ control
     dataOut.block().admit(true);
   }

   void
   SP_DataSub_listener_exec_i::use_MKC()
   {
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //                 Prepare for MKC calls
      //
      //    Now that we've received the 'input' data and created a VSIPL++
      //    object linked to our output memory, we're ready to do some math!
      //    Typically, we want to pass all or parts of both the input and output
      //    data objects to the MKC.  In this example, we will simply pass the
      //    entire input and output objects to the MKC.
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      vsip::serialization::Descriptor mkcInputInfo;
      vsip::serialization::Descriptor mkcOutputInfo;

      std::pair<float *, float*> inputData;
      std::pair<float *, float*> outputData;

      dataIn.block().release(true, inputData);
      dataOut.block().release(true, outputData);

      vsip::serialization::describe_user_storage(dataIn.block(), mkcInputInfo);
      vsip::serialization::describe_user_storage(dataOut.block(), mkcOutputInfo);


      // ------------------------------------------------------------------------
      //                 MKC->init()
      // ------------------------------------------------------------------------

      //     Since this is a non-local (i.e., non-collocated) object
      //     reference, caching of the reference is not safe as the
      //     remote object could be moved, etc. This is the reason that
      //     the object reference is placed into a local variable that is
      //     recreated every time the reference is used.

      SNA_Examples::SP_Math_obj_var mathObj =
            ciao_context_->get_connection_SPMathRecept();

      if ( ! CORBA::is_nil(mathObj.in()))
      {
         mathObj->init();
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Error calling init() - mathObj is nill");
         return;
      }


      // ------------------------------------------------------------------------
      //                          MKC->compute function
      // ------------------------------------------------------------------------

      // Moving between SNA::SP_DataHdr structure and Descriptor structure.
      // This is required because the compute method is defined in IDL
      // to take SNA::SP_DataHdr arguments, which must be created from the
      // vsip::serialization::Descriptor structures.

      SNA::SP_DataHdr dataInHdr;
      SNA::DataViewTranslator::cpp_to_idl(mkcInputInfo, dataInHdr);

      SNA::SP_DataHdr dataOutHdr;
      SNA::DataViewTranslator::cpp_to_idl(mkcOutputInfo, dataOutHdr);

      unsigned int inputSize =   mkcInputInfo.size[0] *
                                 mkcInputInfo.size[1];

      // Regardless of what form (split or interleaved) the original user data
      // is in, VSIPL++ will copy it internally into whatever the native format
      // happens to be on the architecture the component is deployed on (split
      // for PowerPC/Cell, interleaved for x86).  If the data was initially in
      // interleaved format and was then copied to split, there is no guarantee
      // that the real and imaginary segments are contiguous in memory.  So,
      // it is necessary to use both real and imaginary data pointers as
      // determined by the Block_marshal object if the data is in fact in split
      // form.

      if (mkcInputInfo.storage_format !=
          vsip::split_complex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Invalid complex type - should be split");
      }

      // C++ -> IDL.  The compute method is defined in IDL to take CORBA
      //              sequences as arguments, and so these sequences must be
      //              created from the data pointers provided by the Marshal
      //              objects.

      // Create CORBA sequences from data

      SNA::ByteSequence pDataInSeqReal(
            (inputSize / 2) * sizeof(cmplx_type),
            (inputSize / 2) * sizeof(cmplx_type),
            (::CORBA::Octet *)inputData.first);

      SNA::ByteSequence pDataInSeqImag(
            (inputSize / 2) * sizeof(cmplx_type),
            (inputSize / 2) * sizeof(cmplx_type),
            (::CORBA::Octet *)inputData.second);


      unsigned int outputSize =  mkcOutputInfo.size[0] *
            mkcOutputInfo.size[1];

      SNA::ByteSequence pDataOutSeqReal(
            (outputSize / 2) * sizeof(cmplx_type),
            (outputSize / 2) * sizeof(cmplx_type),
            (::CORBA::Octet *)outputData.first );

      SNA::ByteSequence pDataOutSeqImag(
            (outputSize / 2) * sizeof(cmplx_type),
            (outputSize / 2) * sizeof(cmplx_type),
            (::CORBA::Octet *)outputData.second);


      if ( ! CORBA::is_nil(mathObj.in()))
      {
         mathObj->compute(dataInHdr,
                          dataOutHdr,
                          pDataInSeqReal,
                          pDataInSeqImag,
                          pDataOutSeqReal,
                          pDataOutSeqImag);
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                     "Error calling SPMathRecept_->compute() - mathObj is nil");
         return;
      }

      // ------------------------------------------------------------------------
      //                 MKC->cleanup()
      // ------------------------------------------------------------------------

      if ( ! CORBA::is_nil(mathObj.in()))
      {
         mathObj->cleanup();
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                      "Error calling SPMathRecept_->cleanup() - mathObj is nil");
         return;
      }


      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //                    Continue from MKC calls
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      // Rebind data back into VSIPL++
      SNA::DataViewTranslator::idl_to_cpp(dataOutHdr, mkcOutputInfo);

      if (vsip::serialization::is_compatible<vsip::Dense<2, vsip::cscalar_f> >(mkcOutputInfo))
      {
         dataOut.block().rebind( reinterpret_cast<float *>(&pDataOutSeqReal[0]),
                                 reinterpret_cast<float *>(&pDataOutSeqImag[0]),
                                 vsip::Domain<2>(mkcOutputInfo.size[0], mkcOutputInfo.size[1]));
         dataOut.block().admit(true);
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                        "Error unmarshaling CFLOAT split data in SPOC");
      }

      // Print output data
      SNA_Examples::DataObjectPrinter::PrintComplexMatrix(
               dataOut,
               "VSIPL++ Output data after compute():",
               boilerplate_.getLogger());
   }

   void
   SP_DataSub_listener_exec_i::publish_data()
   {
      // --------------------------------------------------------------------------
     //                 END Logic
     //
     //    At this point, we have:
     //       - received data from another component,
     //       - re-created the VSIPL++ object,
     //       - created a new VSIPL++ object using our publishing memory
     //             for its storage
     //       - called 3 functions in a Math Kernel Component, passing both
     //             the input and output VSIPL++ Views
     //       - re-created the input and output VSIPL++ objects in the MKC
     //       - Performed math using the input and output VSIPL++ objects
     //
     //       The next logical step would be to publish our output data.
     //       The steps for doing so are identical to those found in the
     //       SPOC_Starter component.
     //
     // ------------------------------------------------------------------------

      dataOut.block().release(true);

     LOG4CXX_INFO(boilerplate_.getLogger(),
                  "SIGNAL PROCESSING EXAMPLE COMPLETED");
   }

   /**
    * Facet Executor Implementation Class: SP_DataSubConnStatus_exec_i
    */

   SP_DataSubConnStatus_exec_i::SP_DataSubConnStatus_exec_i(
      ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   SP_DataSubConnStatus_exec_i::~SP_DataSubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   SP_DataSubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataSubConn: inconsistent topic");
   }

   void
   SP_DataSubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataSubConn: requested incompatible QoS");
   }

   void
   SP_DataSubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataSubConn: sample rejected");
   }

   void
   SP_DataSubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataSubConn: offered deadline missed");
   }

   void
   SP_DataSubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataSubConn: offered incompatible QoS");
   }

   void
   SP_DataSubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind status_kind)
   {
      /* Your code here. */
      LOG4CXX_DEBUG(boilerplate_.getLogger(),
            "on_unexpected_status called with status "
            << CIAO::DDS4CCM::translate_statuskind(status_kind));
   }

   /**
    * Component Executor Implementation Class: SPOC_comp_exec_i
    */

   SPOC_comp_exec_i::SPOC_comp_exec_i() :
         boilerplate_("SPOC_comp",
                      "SNA_Examples")
   {
   }

   SPOC_comp_exec_i::~SPOC_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   SPOC_comp_exec_i::reactor()
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

   ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
   SPOC_comp_exec_i::get_SP_DataPub_status()
   {
      if (::CORBA::is_nil(this->ciao_SP_DataPub_status_.in()))
      {
         SP_DataPub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            SP_DataPub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener::_nil());

         this->ciao_SP_DataPub_status_ = tmp;
      }

      return
         ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener::_duplicate(
            this->ciao_SP_DataPub_status_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   SPOC_comp_exec_i::get_SP_DataPubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_SP_DataPubConnStatus_.in()))
      {
         SP_DataPubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            SP_DataPubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_SP_DataPubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_SP_DataPubConnStatus_.in());
   }

   ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Reader_Status_Listener_ptr
   SPOC_comp_exec_i::get_SP_DataSub_status()
   {
      if (::CORBA::is_nil(this->ciao_SP_DataSub_status_.in()))
      {
         SP_DataSub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            SP_DataSub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Reader_Status_Listener::_nil());

         this->ciao_SP_DataSub_status_ = tmp;
      }

      return
         ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Reader_Status_Listener::_duplicate(
            this->ciao_SP_DataSub_status_.in());
   }

   ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Listener_ptr
   SPOC_comp_exec_i::get_SP_DataSub_listener()
   {
      if (::CORBA::is_nil(this->ciao_SP_DataSub_listener_.in()))
      {
         SP_DataSub_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            SP_DataSub_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Listener::_nil());

         this->ciao_SP_DataSub_listener_ = tmp;
      }

      return
         ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Listener::_duplicate(
            this->ciao_SP_DataSub_listener_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   SPOC_comp_exec_i::get_SP_DataSubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_SP_DataSubConnStatus_.in()))
      {
         SP_DataSubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            SP_DataSubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_SP_DataSubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_SP_DataSubConnStatus_.in());
   }

   // Operations from Components::SessionComponent.

   void
   SPOC_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_SPOC_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   SPOC_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void
   SPOC_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      CCM_PSAT::PSAT_Listener_Control_var listenControl =
            ciao_context_->get_connection_SP_DataSub_listener_control();

      if (CORBA::is_nil(listenControl.in()))
      {
         boilerplate_.failed_state_change(
               "The listener control receptacle is null");
         return;
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

   void
   SPOC_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();
   }

   void
   SPOC_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   extern "C"
   SNA_EXAMPLES_SPOC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_SPOC_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         SPOC_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================

