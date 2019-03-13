//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup BasicSubscriber_comp
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

#include "SNA_Examples_BasicSubscriber_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This include was added by hand so a stringstream could be used to
//          help format a logging message
#include <sstream>

namespace CIAO_SNA_Examples_BasicSubscriber_comp_Impl
{

   /**
    * Facet Executor Implementation Class: testDataSub_data_listener_exec_i
    */

   testDataSub_data_listener_exec_i::testDataSub_data_listener_exec_i(
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_BasicSubscriber_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   testDataSub_data_listener_exec_i::~testDataSub_data_listener_exec_i()
   {
   }

   // Operations from ::SNA_Examples::TestData_conn::Listener

   void
   testDataSub_data_listener_exec_i::on_one_data(
      const ::SNA_Examples::TestData_msg & datum,
      const ::CCM_DDS::ReadInfo & /* info */)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: The is the data receive callback for the testDataSub DDS4CCM
      //          listen port. This method simply logs the content of the test
      //          data structure.
      LOG4CXX_INFO(boilerplate_.getLogger(),
                   "Event has been received with contents\n"
                   << "myInt32  = " << datum.myInt32  << "\n"
                   << "myInt64  = " << datum.myInt64  << "\n"
                   << "myDouble = " << datum.myDouble << "\n"
                   << "myString = " << datum.myString << "\n"
                   << "myState  = " << datum.myState  << "\n"
                   << "myColor  = " << datum.myColor  << "\n");
   }

   void
   testDataSub_data_listener_exec_i::on_many_data(
      const ::SNA_Examples::TestData_msgSeq & /* data */,
      const ::CCM_DDS::ReadInfoSeq & /* infos */)
   {
      /* Your code here. */
   }

   /**
    * Facet Executor Implementation Class: testDataSub_status_exec_i
    */

   // EXAMPLE: When using the inherited implementation, make sure to initilize
   //          the SNA::LoggingObject base class
   testDataSub_status_exec_i::testDataSub_status_exec_i(
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         SNA::LoggingObject(boilerplate.getLoggerNameFull()),
         ciao_context_(
            ::SNA_Examples::CCM_BasicSubscriber_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   testDataSub_status_exec_i::~testDataSub_status_exec_i()
   {
   }

   // Operations from ::CCM_DDS::PortStatusListener

// These are defined out so that:
// 1. The inherited implementations will be used
// 2. The declarations are still available if the user decides to overload a
//    particular callback
// 3. Ease of merging/melding/diffing
#if 0
   void
   testDataSub_status_exec_i::on_requested_deadline_missed(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedDeadlineMissedStatus & status)
   {
      /* Your code here. */
   }

   void
   testDataSub_status_exec_i::on_sample_lost(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleLostStatus & status)
   {
      /* Your code here. */
   }
#endif

   //============================================================
   // Facet Executor Implementation Class: testDataSubConnStatus_exec_i
   //============================================================

   // EXAMPLE: When using the inherited implementation, make sure to initilize
   //          the SNA::LoggingObject base class
   testDataSubConnStatus_exec_i::testDataSubConnStatus_exec_i(
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         SNA::LoggingObject(boilerplate.getLoggerNameFull()),
         ciao_context_(
            ::SNA_Examples::CCM_BasicSubscriber_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   testDataSubConnStatus_exec_i::~testDataSubConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

// These are defined out so that:
// 1. The inherited implementations will be used
// 2. The declarations are still available if the user decides to overload a
//    particular callback
// 3. Ease of merging/melding/diffing
#if 0
   void
   testDataSubConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataSubConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & status)
   {
      /* Your code here. */
   }

   void
   testDataSubConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & status)
   {
      /* Your code here. */
   }

   void
   testDataSubConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataSubConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
      /* Your code here. */
   }

   void
   testDataSubConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
      /* Your code here. */
   }
#endif

   /**
    * Component Executor Implementation Class: BasicSubscriber_comp_exec_i
    */

   BasicSubscriber_comp_exec_i::BasicSubscriber_comp_exec_i() :
         boilerplate_("BasicSubscriber_comp",
                      "SNA_Examples")
   {
   }

   BasicSubscriber_comp_exec_i::~BasicSubscriber_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   BasicSubscriber_comp_exec_i::reactor()
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

   ::SNA_Examples::TestData_conn::CCM_Listener_ptr
   BasicSubscriber_comp_exec_i::get_testDataSub_data_listener()
   {
      if (::CORBA::is_nil(this->ciao_testDataSub_data_listener_.in()))
      {
         testDataSub_data_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            testDataSub_data_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::TestData_conn::CCM_Listener::_nil());

         this->ciao_testDataSub_data_listener_ = tmp;
      }

      return
         ::SNA_Examples::TestData_conn::CCM_Listener::_duplicate(
            this->ciao_testDataSub_data_listener_.in());
   }

   ::CCM_DDS::CCM_PortStatusListener_ptr
   BasicSubscriber_comp_exec_i::get_testDataSub_status()
   {
      if (::CORBA::is_nil(this->ciao_testDataSub_status_.in()))
      {
         testDataSub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            testDataSub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_PortStatusListener::_nil());

         this->ciao_testDataSub_status_ = tmp;
      }

      return
         ::CCM_DDS::CCM_PortStatusListener::_duplicate(
            this->ciao_testDataSub_status_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   BasicSubscriber_comp_exec_i::get_testDataSubConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_testDataSubConnStatus_.in()))
      {
         testDataSubConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            testDataSubConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_testDataSubConnStatus_ = tmp;
      }

      return
         ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
            this->ciao_testDataSubConnStatus_.in());
   }

   // Operations from Components::SessionComponent.

   void
   BasicSubscriber_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_BasicSubscriber_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   BasicSubscriber_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      /* Your code here. */
   }

   void
   BasicSubscriber_comp_exec_i::ccm_activate()
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
         ciao_context_->get_connection_testDataSub_data_control();

      if (! CORBA::is_nil(listenerCtrl.in()))
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
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a data
         //          listener.
         boilerplate_.failed_state_change(
               "The listener control receptacle is null");
      }
   }

   void
   BasicSubscriber_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      /* Your code here. */
   }

   void
   BasicSubscriber_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   extern "C"
   SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_BasicSubscriber_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         BasicSubscriber_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
