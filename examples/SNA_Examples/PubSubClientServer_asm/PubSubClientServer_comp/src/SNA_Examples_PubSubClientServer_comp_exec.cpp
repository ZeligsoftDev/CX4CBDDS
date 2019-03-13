//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup PubSubClientServer_comp
/// @{
/// @file   SNA_Examples_PubSubClientServer_comp_exec.cpp
/// @brief  Implementation of executor classes for the PubSubClientServer_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_PubSubClientServer_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: These includes were added by hand in order to create a timer and to
//          to read a configuration file.
#include "SNA_GeneralTimer.h"
#include "SNA_ConfigParams.h"

#include <unistd.h>  // for sleep (to make output readable)

// This is needed to translate DDS4CCM return codes into readable strings.
#include "Utils.h"

namespace CIAO_SNA_Examples_PubSubClientServer_comp_Impl
{

   /**
    * Facet Executor Implementation Class: echoNumberFacet_exec_i
    */

   echoNumberFacet_exec_i::echoNumberFacet_exec_i(
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PubSubClientServer_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   echoNumberFacet_exec_i::~echoNumberFacet_exec_i()
   {
   }

   // Operations from ::SNA_Examples::EchoNumber_obj

   ::CORBA::Long
   echoNumberFacet_exec_i::getCurrentNum()
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////
      return boilerplate_.getCompExecPtr()->getCurrentNum();
   }

   /**
    * Facet Executor Implementation Class: numAssertSub_data_listener_exec_i
    */

   numAssertSub_data_listener_exec_i::numAssertSub_data_listener_exec_i(
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PubSubClientServer_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   numAssertSub_data_listener_exec_i::~numAssertSub_data_listener_exec_i()
   {
   }

   // Operations from ::SNA_Examples::NumAssert_conn::Listener

   void
   numAssertSub_data_listener_exec_i::on_one_data(
      const ::SNA_Examples::NumAssert_msg & datum,
      const ::CCM_DDS::ReadInfo & /* info */)
   {

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: get the assertion value from the sample parameter. This is the
      // sample that we are subscribed to. It is the report from the Echo
      // component that the number we previously published matches the counter
      // value from the Echo component.
      bool assertFromSample = datum.numValid;
      bool assertFromReqRep = false;

      // EXAMPLE: This gets a reference to the echoAssert facet.
      SNA_Examples::EchoAssert_obj_var echoAssert =
            ciao_context_->get_connection_echoAssertRecept();

      // EXAMPLE: Check that we have a connection to the echoAssert facet.
      // Then call this method to return the boolean assertion value from the
      // Echo_comp. This method will return true if the previous message counted
      // by the echo component matches the value published by this component.
      if ( ! CORBA::is_nil(echoAssert.in()))
      {
         try {
            assertFromReqRep = echoAssert->getNumAssert();
         } catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
         }
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Error calling getNumAssert()");
         return;
      }

      // EXAMPLE: Both of these assertion values should read true meaning that
      // the counter value was successfully published and queried by this
      // component.
      if (assertFromSample && assertFromReqRep)
      {
         LOG4CXX_DEBUG(boilerplate_.getLogger(),
               "Example counter loop succeeded.");
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Example counter loop failed.");
      }

      // EXAMPLE: Increment the counter value
      CORBA::ULong curNum = boilerplate_.getCompExecPtr()->getCurrentNum();
      curNum++;
      boilerplate_.getCompExecPtr()->setCurrentNum(curNum);

      sleep(2);

      boilerplate_.getCompExecPtr()->publishCurrentNum();
   }

   void
   numAssertSub_data_listener_exec_i::on_many_data(
      const ::SNA_Examples::NumAssert_msgSeq & /* data */,
      const ::CCM_DDS::ReadInfoSeq & /* infos */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: numAssertSub_status_exec_i
    */

   numAssertSub_status_exec_i::numAssertSub_status_exec_i(
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PubSubClientServer_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   numAssertSub_status_exec_i::~numAssertSub_status_exec_i()
   {
   }

   // Operations from ::CCM_DDS::PortStatusListener

   void
   numAssertSub_status_exec_i::on_requested_deadline_missed(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertSub_status_exec_i::on_sample_lost(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleLostStatus & /* status */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: currentNumPubConnStatus_exec_i
    */

   currentNumPubConnStatus_exec_i::currentNumPubConnStatus_exec_i(
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PubSubClientServer_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   currentNumPubConnStatus_exec_i::~currentNumPubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   currentNumPubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumPubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumPubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumPubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumPubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   currentNumPubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: numAssertSubConnStatus_exec_i
    */

   numAssertSubConnStatus_exec_i::numAssertSubConnStatus_exec_i(
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_PubSubClientServer_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   numAssertSubConnStatus_exec_i::~numAssertSubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void
   numAssertSubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertSubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertSubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertSubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertSubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   numAssertSubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
      /* Your code here. */
   }

   /**
    * Component Executor Implementation Class: PubSubClientServer_comp_exec_i
    */

   PubSubClientServer_comp_exec_i::PubSubClientServer_comp_exec_i() :
         boilerplate_("PubSubClientServer_comp",
                      "SNA_Examples")
   {
   }

   PubSubClientServer_comp_exec_i::~PubSubClientServer_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   PubSubClientServer_comp_exec_i::reactor()
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

   ::SNA_Examples::CCM_EchoNumber_obj_ptr
   PubSubClientServer_comp_exec_i::get_echoNumberFacet()
   {
      if (::CORBA::is_nil(this->ciao_echoNumberFacet_.in()))
      {
         echoNumberFacet_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            echoNumberFacet_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_EchoNumber_obj::_nil());

         this->ciao_echoNumberFacet_ = tmp;
      }

      return
         ::SNA_Examples::CCM_EchoNumber_obj::_duplicate(
            this->ciao_echoNumberFacet_.in());
   }

   ::SNA_Examples::NumAssert_conn::CCM_Listener_ptr
   PubSubClientServer_comp_exec_i::get_numAssertSub_data_listener()
   {
      if (::CORBA::is_nil(this->ciao_numAssertSub_data_listener_.in()))
      {
         numAssertSub_data_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numAssertSub_data_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::NumAssert_conn::CCM_Listener::_nil());

         this->ciao_numAssertSub_data_listener_ = tmp;
      }

      return
         ::SNA_Examples::NumAssert_conn::CCM_Listener::_duplicate(
            this->ciao_numAssertSub_data_listener_.in());
   }

   ::CCM_DDS::CCM_PortStatusListener_ptr
   PubSubClientServer_comp_exec_i::get_numAssertSub_status()
   {
      if (::CORBA::is_nil(this->ciao_numAssertSub_status_.in()))
      {
         numAssertSub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numAssertSub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_PortStatusListener::_nil());

         this->ciao_numAssertSub_status_ = tmp;
      }

      return
         ::CCM_DDS::CCM_PortStatusListener::_duplicate(
            this->ciao_numAssertSub_status_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   PubSubClientServer_comp_exec_i::get_currentNumPubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_currentNumPubConnStatus_.in()))
      {
         currentNumPubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            currentNumPubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_currentNumPubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_currentNumPubConnStatus_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   PubSubClientServer_comp_exec_i::get_numAssertSubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_numAssertSubConnStatus_.in()))
      {
         numAssertSubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            numAssertSubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_numAssertSubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_numAssertSubConnStatus_.in());
   }

   // Operations from Components::SessionComponent.

   void
   PubSubClientServer_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_PubSubClientServer_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   PubSubClientServer_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      /* Your code here. */
   }

   void
   PubSubClientServer_comp_exec_i::ccm_activate()
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
         ciao_context_->get_connection_numAssertSub_data_control();

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
         try
         {
            listenerCtrl->mode(CCM_DDS::ONE_BY_ONE);
         }
         catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
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

      //////////////////////////////////////////////////////////////////////////
      // Handwritten user code initializes the number counter and the ACE timer
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: look up initial number used from the config file
      //          InitNum.cfg in the $SNA_CONFIG_PATH
      unsigned int initNum = 0;

      SNA::ConfigParams myInitNumCfg;

      if ( myInitNumCfg.init("InitNum.cfg") )
      {
         myInitNumCfg.lookupValue("InitNum.InitNumber", initNum);
      }

      theCurrNum_ = initNum;

      //////////////////////////////////////////////////////////////////////////
      // Handwritten user code initializes publishing logic class instance
      //////////////////////////////////////////////////////////////////////////

      SNA_Examples::CurrentNum_conn::Writer_var currentNumWriter_ =
            ciao_context_->get_connection_currentNumPub_data();

      // Pass this component's logging name and writer object reference
      currentNumPubLogic_.init(boilerplate_.getLoggerNameFull(),
                               currentNumWriter_.in());

      // EXAMPLE: Call to publish the first message.  Note: we can publish
      //          immediately because we are using the historicalSamples helper
      //          class to receive the message.
      startupTimeout();
   }

   void
   PubSubClientServer_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      //          will also destroy the general timer class constructed in
      //          ccm_activate.
      timeManager_.cancel_timer(timerId_);
   }

   void
   PubSubClientServer_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   //////////////////////////////////////////////////////////////////////////////
   // "HELPER" FUNCTIONS GO HERE
   //////////////////////////////////////////////////////////////////////////////

   int
   PubSubClientServer_comp_exec_i::startupTimeout()
   {
      publishCurrentNum();
      return 0;
   }

   CORBA::ULong
   PubSubClientServer_comp_exec_i::getCurrentNum() const
   {
      return theCurrNum_;
   }

   void
   PubSubClientServer_comp_exec_i::setCurrentNum(
         CORBA::ULong num)
   {
      theCurrNum_ = num;
   }

   void PubSubClientServer_comp_exec_i::publishCurrentNum()
   {
      try
      {
         currentNumPubLogic_.publish(theCurrNum_);
      }
      catch (...)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught exception from timeout");
      }
   }

   extern "C"
   SNA_EXAMPLES_PUBSUBCLIENTSERVER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_PubSubClientServer_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         PubSubClientServer_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
