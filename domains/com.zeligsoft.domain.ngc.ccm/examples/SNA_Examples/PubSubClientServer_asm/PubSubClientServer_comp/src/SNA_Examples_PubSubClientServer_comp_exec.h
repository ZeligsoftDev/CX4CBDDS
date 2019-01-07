//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup PubSubClientServer_comp
/// @{
/// @file   SNA_Examples_PubSubClientServer_comp_exec.h
/// @brief  Definition of executor classes for the PubSubClientServer_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_PUBSUBCLIENTSERVER_COMP_EXEC_O8WFAH_H_
#define CIAO_BS_SNA_EXAMPLES_PUBSUBCLIENTSERVER_COMP_EXEC_O8WFAH_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_PubSubClientServer_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_PubSubClientServer_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

// EXAMPLE: This include was added by hand in order to use a custom-made class
//          which publishes a CurrentNum_msg type
#include "SNA_Examples_CurrentNumPublishingLogic.h"

/// Auto-generated namespace for SNA_Examples_PubSubClientServer_comp
namespace CIAO_SNA_Examples_PubSubClientServer_comp_Impl
{
   /// Forward declaration of component executor class
   class PubSubClientServer_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context,
      PubSubClientServer_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: echoNumberFacet_exec_i
    */

   class echoNumberFacet_exec_i :
      public virtual ::SNA_Examples::CCM_EchoNumber_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      echoNumberFacet_exec_i(
         ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~echoNumberFacet_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::EchoNumber_obj. */

      virtual ::CORBA::Long getCurrentNum();
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: numAssertSub_data_listener_exec_i
    */

   class numAssertSub_data_listener_exec_i :
      public virtual ::SNA_Examples::NumAssert_conn::CCM_Listener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      numAssertSub_data_listener_exec_i(
         ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~numAssertSub_data_listener_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::NumAssert_conn::Listener. */

      virtual
      void on_one_data(
         const ::SNA_Examples::NumAssert_msg & datum,
         const ::CCM_DDS::ReadInfo & info);

      virtual
      void on_many_data(
         const ::SNA_Examples::NumAssert_msgSeq & data,
         const ::CCM_DDS::ReadInfoSeq & infos);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: numAssertSub_status_exec_i
    */

   class numAssertSub_status_exec_i :
      public virtual ::CCM_DDS::CCM_PortStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      numAssertSub_status_exec_i(
         ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~numAssertSub_status_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::PortStatusListener. */

      virtual
      void on_requested_deadline_missed(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedDeadlineMissedStatus & status);

      virtual
      void on_sample_lost(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleLostStatus & status);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: currentNumPubConnStatus_exec_i
    */

   class currentNumPubConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      currentNumPubConnStatus_exec_i(
         ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~currentNumPubConnStatus_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::ConnectorStatusListener. */

      virtual
      void on_inconsistent_topic(
         ::DDS::Topic_ptr the_topic,
         const ::DDS::InconsistentTopicStatus & status);

      virtual
      void on_requested_incompatible_qos(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedIncompatibleQosStatus & status);

      virtual
      void on_sample_rejected(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleRejectedStatus & status);

      virtual
      void on_offered_deadline_missed(
         ::DDS::DataWriter_ptr the_writer,
         const ::DDS::OfferedDeadlineMissedStatus & status);

      virtual
      void on_offered_incompatible_qos(
         ::DDS::DataWriter_ptr the_writer,
         const ::DDS::OfferedIncompatibleQosStatus & status);

      virtual
      void on_unexpected_status(
         ::DDS::Entity_ptr the_entity,
         ::DDS::StatusKind status_kind);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: numAssertSubConnStatus_exec_i
    */

   class numAssertSubConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      numAssertSubConnStatus_exec_i(
         ::SNA_Examples::CCM_PubSubClientServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~numAssertSubConnStatus_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::ConnectorStatusListener. */

      virtual
      void on_inconsistent_topic(
         ::DDS::Topic_ptr the_topic,
         const ::DDS::InconsistentTopicStatus & status);

      virtual
      void on_requested_incompatible_qos(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedIncompatibleQosStatus & status);

      virtual
      void on_sample_rejected(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleRejectedStatus & status);

      virtual
      void on_offered_deadline_missed(
         ::DDS::DataWriter_ptr the_writer,
         const ::DDS::OfferedDeadlineMissedStatus & status);

      virtual
      void on_offered_incompatible_qos(
         ::DDS::DataWriter_ptr the_writer,
         const ::DDS::OfferedIncompatibleQosStatus & status);

      virtual
      void on_unexpected_status(
         ::DDS::Entity_ptr the_entity,
         ::DDS::StatusKind status_kind);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: PubSubClientServer_comp_exec_i
    */

   class PubSubClientServer_comp_exec_i :
      public virtual PubSubClientServer_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      PubSubClientServer_comp_exec_i();

      /// Destructor
      virtual ~PubSubClientServer_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_EchoNumber_obj_ptr
      get_echoNumberFacet();

      virtual ::SNA_Examples::NumAssert_conn::CCM_Listener_ptr
      get_numAssertSub_data_listener();

      virtual ::CCM_DDS::CCM_PortStatusListener_ptr
      get_numAssertSub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_currentNumPubConnStatus();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_numAssertSubConnStatus();
      //@}

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: The methods in this class below this line were added by hand.
      //          The ones above were generated.
      //////////////////////////////////////////////////////////////////////////

      /**
       * Callback for startup timer.
       */
      int startupTimeout();

      /**
       * Returns current number used for processing.
       *
       * @return current number
       */
      CORBA::ULong getCurrentNum() const;

      /**
       * Sets current number used for processing.
       *
       * @param[in] num - new number to use
       */
      void setCurrentNum(CORBA::ULong num);

      /**
       * Publishes a CurrentNum_msg using the current number
       */
      void publishCurrentNum();

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_PubSubClientServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_EchoNumber_obj_var ciao_echoNumberFacet_;
      ::SNA_Examples::NumAssert_conn::CCM_Listener_var
         ciao_numAssertSub_data_listener_;
      ::CCM_DDS::CCM_PortStatusListener_var ciao_numAssertSub_status_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_currentNumPubConnStatus_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_numAssertSubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: The members in this class below this line were added by hand.
      //          The ones above were generated.
      //////////////////////////////////////////////////////////////////////////

      /**
       * Current number used for processing.
       */
      CORBA::ULong     theCurrNum_;

      /**
       * Startup timer ID number.
       */
      long             timerId_;

      /**
       * Time Manager used to schedule startup timer.
       */
      SNA::TimeManager timeManager_;

      /**
       * Class instance showing how to publish from a non-executor class
       */
      SNA_Examples::CurrentNumPublishingLogic currentNumPubLogic_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_PUBSUBCLIENTSERVER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_PubSubClientServer_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
