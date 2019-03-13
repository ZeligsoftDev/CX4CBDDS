//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Echo_comp
/// @{
/// @file   SNA_Examples_Echo_comp_exec.cpp
/// @brief  Implementation of executor classes for the Echo_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_Echo_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// This is needed to translate DDS4CCM return codes into readable strings.
#include "Utils.h"

// EXAMPLE: Added this include to get SNA::HistoricalSamplesSupport definition
#include "SNA_HistoricalSamplesSupport.h"

#include "SNA_Examples_CurrentNum_conn_conn.h"

namespace CIAO_SNA_Examples_Echo_comp_Impl
{

   /**
    * Facet Executor Implementation Class: echoAssertFacet_exec_i
    */

   echoAssertFacet_exec_i::echoAssertFacet_exec_i(
      ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_Echo_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   echoAssertFacet_exec_i::~echoAssertFacet_exec_i()
   {
   }

   // Operations from ::SNA_Examples::EchoAssert_obj

   ::CORBA::Boolean
   echoAssertFacet_exec_i::getNumAssert()
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      return boilerplate_.getCompExecPtr()->getCurrentAssert();
   }

   /**
    * Facet Executor Implementation Class: currentNumSub_data_listener_exec_i
    */

   currentNumSub_data_listener_exec_i::currentNumSub_data_listener_exec_i(
      ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_Echo_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   currentNumSub_data_listener_exec_i::~currentNumSub_data_listener_exec_i()
   {
   }

   // Operations from ::SNA_Examples::CurrentNum_conn::Listener

   void
   currentNumSub_data_listener_exec_i::on_one_data(
      const ::SNA_Examples::CurrentNum_msg & datum,
      const ::CCM_DDS::ReadInfo & /* info */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      LOG4CXX_INFO(boilerplate_.getLogger(),
               "Process Current Number event: " << datum.theCurrNum);

      boilerplate_.getCompExecPtr()->setCurrentNum(datum.theCurrNum);

      // Output which number was received, and each step in the process
      LOG4CXX_INFO(boilerplate_.getLogger(),
            "1.) Start The Loop! Got Number: " << datum.theCurrNum);

      LOG4CXX_INFO(boilerplate_.getLogger(),
            "2.) Checking If Number Received Is Valid...");

      long serverNum = 0;

      // Get the number at the server to make an assertion if we are valid
      SNA_Examples::EchoNumber_obj_var echoNum =
            ciao_context_->get_connection_echoNumberRecept();

      if ( ! CORBA::is_nil(echoNum.in()))
      {
         try
         {
            serverNum = echoNum->getCurrentNum();
         }
         catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
         }
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Error calling getCurrentNum()");
         return;
      }

      // Log whether the communication happened correctly check for validity
      if (serverNum != datum.theCurrNum)
      {
         // Output results and publish status
         LOG4CXX_INFO(boilerplate_.getLogger(),
               "3.) Number Received Is Invalid!" << "Expected: "
               << datum.theCurrNum << "Got: " << serverNum);

         boilerplate_.getCompExecPtr()->setCurrentAssert(false);
      }
      else
      {
         // Output results and publish status
         LOG4CXX_INFO(boilerplate_.getLogger(),
               "3.) Number Received Is Valid!");

         boilerplate_.getCompExecPtr()->setCurrentAssert(true);
      }

      // Create new assertion sample and send it
      SNA_Examples::NumAssert_msg assertion;
      assertion.numValid = boilerplate_.getCompExecPtr()->getCurrentAssert();

      /**
       * Reference to the writer interface to the DDS4CCM connector for the
       * SNA_Examples::numAssert type
       */
      ::SNA_Examples::NumAssert_conn::Writer_var numAssertPubWriter =
            ciao_context_->get_connection_numAssertPub_data();

      if (CORBA::is_nil(numAssertPubWriter.in()))
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "The writer receptacle is null");
      }

      try
      {
         numAssertPubWriter->write_one(assertion, DDS::HANDLE_NIL);

      }
      catch (CCM_DDS::InternalError & ex) // catch "normal" exception
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught InternalError exception from write_one call. "
                       "Contained DDS error code is "
                       << ::CIAO::DDS4CCM::translate_retcode(ex.error_code));

         return;
      }
      catch ( const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR( boilerplate_.getLogger(),
                        "Caught CORBA Exception: " << ex );
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         return;
      }
   }

   void
   currentNumSub_data_listener_exec_i::on_many_data(
      const ::SNA_Examples::CurrentNum_msgSeq & /* data */,
      const ::CCM_DDS::ReadInfoSeq & /* infos */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: currentNumSub_status_exec_i
    */

   currentNumSub_status_exec_i::currentNumSub_status_exec_i(
      ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_Echo_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   currentNumSub_status_exec_i::~currentNumSub_status_exec_i()
   {
   }

   // Operations from ::CCM_DDS::PortStatusListener

   void
   currentNumSub_status_exec_i::on_requested_deadline_missed(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumSub_status_exec_i::on_sample_lost(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleLostStatus & /* status */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: numAssertPubConnStatus_exec_i
    */

   numAssertPubConnStatus_exec_i::numAssertPubConnStatus_exec_i(
      ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_Echo_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   numAssertPubConnStatus_exec_i::~numAssertPubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   numAssertPubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertPubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertPubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertPubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertPubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertPubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: currentNumSubConnStatus_exec_i
    */

   currentNumSubConnStatus_exec_i::currentNumSubConnStatus_exec_i(
      ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_Echo_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   currentNumSubConnStatus_exec_i::~currentNumSubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   currentNumSubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumSubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumSubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumSubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumSubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumSubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
      /* Your code here. */
   }

   /**
    * Component Executor Implementation Class: Echo_comp_exec_i
    */

   Echo_comp_exec_i::Echo_comp_exec_i() :
         boilerplate_("Echo_comp",
                      "SNA_Examples"),
         currentNumber_(0),
         currentAssertion_(0)
   {
   }

   Echo_comp_exec_i::~Echo_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   Echo_comp_exec_i::reactor()
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

   ::SNA_Examples::CCM_EchoAssert_obj_ptr
   Echo_comp_exec_i::get_echoAssertFacet()
   {
      if (::CORBA::is_nil(this->ciao_echoAssertFacet_.in()))
      {
         echoAssertFacet_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            echoAssertFacet_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_EchoAssert_obj::_nil());

         this->ciao_echoAssertFacet_ = tmp;
      }

      return
         ::SNA_Examples::CCM_EchoAssert_obj::_duplicate(
            this->ciao_echoAssertFacet_.in());
   }

   ::SNA_Examples::CurrentNum_conn::CCM_Listener_ptr
   Echo_comp_exec_i::get_currentNumSub_data_listener()
   {
      if (::CORBA::is_nil(this->ciao_currentNumSub_data_listener_.in()))
      {
         currentNumSub_data_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            currentNumSub_data_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CurrentNum_conn::CCM_Listener::_nil());

         this->ciao_currentNumSub_data_listener_ = tmp;
      }

      return
         ::SNA_Examples::CurrentNum_conn::CCM_Listener::_duplicate(
            this->ciao_currentNumSub_data_listener_.in());
   }

   ::CCM_DDS::CCM_PortStatusListener_ptr
   Echo_comp_exec_i::get_currentNumSub_status()
   {
      if (::CORBA::is_nil(this->ciao_currentNumSub_status_.in()))
      {
         currentNumSub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            currentNumSub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_PortStatusListener::_nil());

         this->ciao_currentNumSub_status_ = tmp;
      }

      return
         ::CCM_DDS::CCM_PortStatusListener::_duplicate(
            this->ciao_currentNumSub_status_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   Echo_comp_exec_i::get_numAssertPubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_numAssertPubConnStatus_.in()))
      {
         numAssertPubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numAssertPubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_numAssertPubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_numAssertPubConnStatus_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   Echo_comp_exec_i::get_currentNumSubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_currentNumSubConnStatus_.in()))
      {
         currentNumSubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            currentNumSubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_currentNumSubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_currentNumSubConnStatus_.in());
   }

   // Operations from Components::SessionComponent.

   void
   Echo_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_Echo_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   Echo_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      /* Your code here. */
   }

   void
   Echo_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: Gets a reference to the listener control interface for the
      //          testdataSub DDS4CCM listen port. This is usually needed by
      //          all components which have listen ports as by default the
      //          data listener mode is set to NOT_ENABLED so NO data will be
      //          received.
      //
      //          This listener mode can be changed at any time but is usually
      //          set in ccm_activate.
      CCM_DDS::DataListenerControl_var listenerCtrl =
         ciao_context_->get_connection_currentNumSub_data_control();

      if ( ! CORBA::is_nil(listenerCtrl.in()))
      {
         // EXAMPLE: Setting the listener mode to ONE_BY_ONE meaning the
         //          on_one_data callback is called for every sample received.
         //
         //          This setting is the recommended one as it is faster than
         //          MANY_BY_MANY (which calls the on_many_data callback with a
         //          sequences of samples) as the MANY_BY_MANY mode is harder to
         //          use and has data copies due to differences between CCM and
         //          DDS sequence types.
         try {
            listenerCtrl->mode(CCM_DDS::ONE_BY_ONE);
         } catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
         }
      }
      else
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "The listener control receptacle is null");
      }

      try
      {
         // EXAMPLE: Typedef of an HistoricalSamplesSupport template
         //          instantiation that would work with all DDS_Event connectors
         //          for the SNA_Examples::TestData_msg type.
         //          These template param names are always of the form:
         //      ::<fully scoped connector name>::CCM_Listener,
         //      ::CIAO_<fully scoped connector name>_<connector type>_Impl::
         //         <fully scoped message type>_DDS_Traits,
         //      ::<fully scoped message type>Seq
         typedef SNA::HistoricalSamplesSupport<
               ::SNA_Examples::CurrentNum_conn::CCM_Listener,
               ::CIAO_SNA_Examples_CurrentNum_conn_DDS_Event_Impl::
                  SNA_Examples_CurrentNum_msg_DDS_Traits,
               ::SNA_Examples::CurrentNum_msgSeq> HistSamplesType;

         // EXAMPLE: Instance of the above typedef that will work with whatever
         //          topic is connected to testDataSub. This parameters are
         //          always of the form:
         //            ciao_context_->get_connection_<port name>_dds_entity()
         //            ciao_<port name>_data_listener_
         //            boilerplate_
         //
         // NOTE: The first parameter MUST be put into a _var type first
         //       otherwise a memory leak will result
         DDS::DataReader_var currentNumSub_reader =
               ciao_context_->get_connection_currentNumSub_dds_entity();

         HistSamplesType histSamples(
               currentNumSub_reader.in(),
               ciao_currentNumSub_data_listener_.in(),
               boilerplate_);

         // EXAMPLE: call to get historical samples (samples published before
         //          this component was activated)
         histSamples.getHistoricalSamples();
      }
      catch (CCM_DDS::InternalError & excep)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Could not get historical samples. Info = " <<
                       ::CIAO::DDS4CCM::translate_retcode(excep.error_code));
      }
      catch (CORBA::Exception & excep)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << excep);
      }
      catch (...)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from getHistoricalSamples "
                       "call. ");
      }

   }

   void
   Echo_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      /* Your code here. */
   }

   void
   Echo_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   long
   Echo_comp_exec_i::getCurrentNum() const
   {
      return currentNumber_;
   }

   void
   Echo_comp_exec_i::setCurrentNum(
         long value)
   {
      currentNumber_ = value;
   }

   bool
   Echo_comp_exec_i::getCurrentAssert() const
   {
      return currentAssertion_;
   }

   void
   Echo_comp_exec_i::setCurrentAssert(
         bool value)
   {
      currentAssertion_ = value;
   }

   extern "C"
   SNA_EXAMPLES_ECHO_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Echo_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         Echo_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
