//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SPOC_Starter_comp
/// @{
/// @file   SNA_Examples_SPOC_Starter_comp_exec.cpp
/// @brief  Implementation of executor classes for the SPOC_Starter_comp
///         component and its facets.  The SPOC_Starter component creates
///         some data using VSIPL++ and then publishes it to another component.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_SPOC_Starter_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                      Business logic: includes and namespaces
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

// This is needed to translate DDS4CCM return codes and statuses into
// readable strings.
#include <Utils.h>

// Print VSIPL++ Views
#include "SNA_Examples_DataObjectPrinter.h"

// C++ -> IDL conversions for the Descriptor metadata used with VSIPL++ objects
#include "SNA_DataViewTranslator.h"

// Serialization API for VSIPL++
#include <vsip/serialization.hpp>

// SNA Timer used to initiate publish messages
#include "SNA_GeneralTimer.h"

namespace CIAO_SNA_Examples_SPOC_Starter_comp_Impl
{

   /**
    * Facet Executor Implementation Class: SP_DataPub_status_exec_i
    */

   SP_DataPub_status_exec_i::SP_DataPub_status_exec_i(
      ::SNA_Examples::CCM_SPOC_Starter_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_Starter_comp_Context::_duplicate(ctx)),
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

      // EXAMPLE: In real applications, a developer would usually call
      //          create_data here and then use the buffer which is now free.
   }

   void
   SP_DataPub_status_exec_i::on_buffer_wait_timeout()
   {
      /* Your code here. */
      LOG4CXX_DEBUG(boilerplate_.getLogger(),
                    "SP_DataPub: on buffer wait timeout");
   }

   /**
    * Facet Executor Implementation Class: SP_DataPubConnStatus_exec_i
    */

   SP_DataPubConnStatus_exec_i::SP_DataPubConnStatus_exec_i(
      ::SNA_Examples::CCM_SPOC_Starter_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_SPOC_Starter_comp_Context::_duplicate(ctx)),
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
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataPub: inconsistent topic");
   }

   void
   SP_DataPubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataPub: requested incompatible QoS");
   }

   void
   SP_DataPubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataPub: sample rejected");
   }

   void
   SP_DataPubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataPub: offered deadline missed");
   }

   void
   SP_DataPubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      LOG4CXX_ERROR(boilerplate_.getLogger(),
                    "SP_DataPub: offered incompatible QoS");
   }

   void
   SP_DataPubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /*status_kind*/)
   {
//      LOG4CXX_DEBUG(boilerplate_.getLogger(),
//            "on_unexpected_status called with status "
//            << CIAO::DDS4CCM::translate_statuskind(status_kind));
   }

   /**
    * Component Executor Implementation Class: SPOC_Starter_comp_exec_i
    */

   SPOC_Starter_comp_exec_i::SPOC_Starter_comp_exec_i() :
         boilerplate_("SPOC_Starter_comp",
                      "SNA_Examples"),
         timerId_(-1)
   {
   }

   SPOC_Starter_comp_exec_i::~SPOC_Starter_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   SPOC_Starter_comp_exec_i::reactor()
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
   SPOC_Starter_comp_exec_i::get_SP_DataPub_status()
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
   SPOC_Starter_comp_exec_i::get_SP_DataPubConnStatus()
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

   // Operations from Components::SessionComponent.

   void
   SPOC_Starter_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_SPOC_Starter_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   SPOC_Starter_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void
   SPOC_Starter_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      // Set up timer that will invoke the routine to publish a message

      // Wait for 10 seconds to start sending messages
      ACE_Time_Value delay(10, 0);  // timer = 10 seconds + 0 usec = 10 sec
      // Send a message every 5 seconds
      ACE_Time_Value repeat(5, 0);  // timer = 5 seconds + 0 usec = 5 sec

      typedef SNA_GENERAL_TIMER_T(SPOC_Starter_comp_exec_i) TimerType;

      // EXAMPLE: The first parameter of the SNA_GENERAL_TIMER class constructor
      // passes a reference to the component executor, used when registering the
      // callback handler. The second parameter of this constructor is the
      // method to callback on timer events. The third parameter of this
      // constructor passes the logger to the timer to provide context into
      // where the log messages are coming from within the timer class.
      ACE_Event_Handler_var sendTimer =
            new TimerType(this,
                          &SPOC_Starter_comp_exec_i::prepare_output_buffer,
                          boilerplate_.getLogger());

      // EXAMPLE: Using the time manager object, you can schedule the timer by
      // calling schedule_timer. The parameters to schedule timer are:
      //
      // sendTimer - The SNA_GENERAL_TIMER_T object constructed above, this
      //             provides an event handler that is registered with the ACE
      //             reactor.
      // 0         - In this example we do not provide arguments to the reactor.
      // delay     - The amount to delay the 1st timer event by.
      // repeat    - The amount of time between timer events.
      timerId_ = timeManager_.schedule_timer(sendTimer.handler(),
                                             0,
                                             delay,
                                             repeat);

      // EXAMPLE: If the timerId_ is less then 0, this indicates that we had
      // issues starting the timer. This means that the component has failed the
      // state change into ccm_activate and should fail.
      if (timerId_ < 0)
      {
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }
   }

   void
   SPOC_Starter_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      // EXAMPLE: Cancel timer on shutdown to prevent a state mismatch
      timeManager_.cancel_timer(timerId_);
   }

   void
   SPOC_Starter_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();
   }

   int
   SPOC_Starter_comp_exec_i::prepare_output_buffer()
   {
      // -----------------------------------------------------------------------
      //                      Set up publish memory
      // -----------------------------------------------------------------------

      dataPubWriter_ = ciao_context_->get_connection_SP_DataPub_data();

      if (CORBA::is_nil(dataPubWriter_.in()))
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "The writer receptacle is null");

         // don't reschedule the timer
         return -1;
      }

      // Instantiate the actual buffer memory that will be published via PSAT
      try
      {
         dataPubWriter_->create_data(dataMsg_);
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

         return -1;
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);

         // don't reschedule the timer
         return -1;
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         // don't reschedule the timer
         return -1;
      }

      // Get a pointer to the beginning of the sample to be published.  Note
      // that this pointer is to the beginning of the 'blob' that will be
      // transfered via PSAT, not to the 'psat header' that was defined above.

      // VSIPL++ will need this pointer to create a user-
      // defined block that uses the memory registered with PSAT.
      outputSampleData =
            reinterpret_cast<float *>(dataMsg_.psat_hdr.sample_start_address);

      if (0 == outputSampleData)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(), "Data pointer is null");

         // don't reschedule the timer
         return -1;
      }

      // Bind data to a VSIPL++ View and initialize it
      initialize_data();

      return 0;
   }

   void
   SPOC_Starter_comp_exec_i::initialize_data()
   {
      // -----------------------------------------------------------------------
      //          Establish publish data sizes (number of elements)
      // -----------------------------------------------------------------------

      unsigned int rows = 2;
      unsigned int cols = 8;
      unsigned int size = rows * cols;

      LOG4CXX_INFO(boilerplate_.getLogger(),
            "Starter creating data of size: " <<
            size * sizeof(vsip::cscalar_f) << " bytes");

      // -----------------------------------------------------------------------
      //         Initialize memory in straight C++.  This could also
      //         be done using the VSIPL++ object
      // -----------------------------------------------------------------------

      // EXAMPLE: put data in memory - complex-split format

      // Set real values
      for (unsigned int i = 0; i < size; ++i)
      {
         outputSampleData[i] = +(float)i;
      }

      // Set imaginary values
      for (unsigned int i = 0; i < size; ++i)
      {
         outputSampleData[size+i] = -(float)i;
      }

      // -----------------------------------------------------------------------
      //    Create a VSIPL++ vsip::Matrix and 'connect' it to the memory.
      //    Note that the pointer to the memory registered with PSAT
      //    is used to create the vsip::Dense block
      // -----------------------------------------------------------------------

      // Create a new vsip::Dense block with user-defined storage to our
      // complex-split data
      vsip::Dense<2,vsip::cscalar_f> dataBlock(
            vsip::Domain<2>(rows, cols),
            outputSampleData,
            &outputSampleData[size]);

      // Create a vsip::Matrix that uses the Block with our user data
      vsip::Matrix<vsip::cscalar_f> data(dataBlock);

      // Admit data to VSIPL++ control.  This must be done before the data is
      // accessed using VSIPL++ constructs.
      data.block().admit(true);

      // -----------------------------------------------------------------------
      //         Operate on the data using VSIPL++ calls
      // -----------------------------------------------------------------------

      // Print VSIPL++ data object
      SNA_Examples::DataObjectPrinter::PrintComplexMatrix(
            data,
            "VSIPL++ data after admit in SPOC_Starter:",
            boilerplate_.getLogger());

      // Other business logic could go here ...

      // Publish the data
      publish_data(data);
   }

   void
   SPOC_Starter_comp_exec_i::publish_data(vsip::Matrix<vsip::cscalar_f> & data)
   {
      // -----------------------------------------------------------------------
      //                  Prepare to publish data
      // -----------------------------------------------------------------------

      // Release the data from VSIPL++
      data.block().release(true);

      // Set the metadata info for this data object
      vsip::serialization::Descriptor info;
      vsip::serialization::describe_user_storage(data.block(), info);

      // Set the Descriptor object in our publish memory to the Descriptor that
      // describes our data
      SNA::DataViewTranslator::cpp_to_idl(info, dataMsg_.vsiplMetaData);

      // Calculate the payload size (in bytes)
      unsigned int size =
            dataMsg_.vsiplMetaData.size[0] * dataMsg_.vsiplMetaData.size[1];

      long long payloadSize = size * sizeof(vsip::cscalar_f);

      // Here, payloadSize is set to the size of the data only.
      // This is important, as without this call, the PSAT_Writer will
      // send the maximum size of the message
      dataMsg_.psat_hdr.psat_view.block_length = payloadSize;

      // Publish the sample
      try
      {
         LOG4CXX_INFO(boilerplate_.getLogger(), "SPOC_Starter Sending Data ");

         dataPubWriter_->write_one(dataMsg_);
         dataPubWriter_->release_buffer(dataMsg_);
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

         dataPubWriter_->release_buffer(dataMsg_);

         return;
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

         dataPubWriter_->release_buffer(dataMsg_);

         return;
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex);

         dataPubWriter_->release_buffer(dataMsg_);

         return;
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         dataPubWriter_->release_buffer(dataMsg_);

         return;
      }

      return;
   }

   extern "C"
   SNA_EXAMPLES_SPOC_STARTER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_SPOC_Starter_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         SPOC_Starter_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================

