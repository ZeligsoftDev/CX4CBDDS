//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Echo_comp
/// @{
/// @file   SNA_Examples_Echo_comp_exec.h
/// @brief  Definition of executor classes for the Echo_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_ECHO_COMP_EXEC_PFER9M_H_
#define CIAO_BS_SNA_EXAMPLES_ECHO_COMP_EXEC_PFER9M_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_Echo_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_Echo_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

/// Auto-generated namespace for SNA_Examples_Echo_comp
namespace CIAO_SNA_Examples_Echo_comp_Impl
{
   /// Forward declaration of component executor class
   class Echo_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_Echo_comp_Context,
      Echo_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: echoAssertFacet_exec_i
    */

   class echoAssertFacet_exec_i :
      public virtual ::SNA_Examples::CCM_EchoAssert_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      echoAssertFacet_exec_i(
         ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~echoAssertFacet_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::EchoAssert_obj. */

      virtual ::CORBA::Boolean getNumAssert();
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Echo_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: currentNumSub_data_listener_exec_i
    */

   class currentNumSub_data_listener_exec_i :
      public virtual ::SNA_Examples::CurrentNum_conn::CCM_Listener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      currentNumSub_data_listener_exec_i(
         ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~currentNumSub_data_listener_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::CurrentNum_conn::Listener. */

      virtual
      void on_one_data(
         const ::SNA_Examples::CurrentNum_msg & datum,
         const ::CCM_DDS::ReadInfo & info);

      virtual
      void on_many_data(
         const ::SNA_Examples::CurrentNum_msgSeq & data,
         const ::CCM_DDS::ReadInfoSeq & infos);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Echo_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: currentNumSub_status_exec_i
    */

   class currentNumSub_status_exec_i :
      public virtual ::CCM_DDS::CCM_PortStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      currentNumSub_status_exec_i(
         ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~currentNumSub_status_exec_i();

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
      ::SNA_Examples::CCM_Echo_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: numAssertPubConnStatus_exec_i
    */

   class numAssertPubConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      numAssertPubConnStatus_exec_i(
         ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~numAssertPubConnStatus_exec_i();

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
      ::SNA_Examples::CCM_Echo_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: currentNumSubConnStatus_exec_i
    */

   class currentNumSubConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      currentNumSubConnStatus_exec_i(
         ::SNA_Examples::CCM_Echo_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~currentNumSubConnStatus_exec_i();

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
      ::SNA_Examples::CCM_Echo_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: Echo_comp_exec_i
    */

   class Echo_comp_exec_i :
      public virtual Echo_comp_Exec, public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      Echo_comp_exec_i();

      /// Destructor
      virtual ~Echo_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_EchoAssert_obj_ptr
      get_echoAssertFacet();

      virtual ::SNA_Examples::CurrentNum_conn::CCM_Listener_ptr
      get_currentNumSub_data_listener();

      virtual ::CCM_DDS::CCM_PortStatusListener_ptr
      get_currentNumSub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_numAssertPubConnStatus();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_currentNumSubConnStatus();
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
       * Getter for current number for the loop.
       *
       * @return current value
       */
      long getCurrentNum() const;

      /**
       * Setter for current number for the loop.
       *
       * @param[in] value - new value to use
       */
      void setCurrentNum(long value);

      /**
       * Getter for current assertion for the loop.
       *
       * @return current value
       */
      bool getCurrentAssert() const;

      /**
       * Setter for current assertion for the loop.
       *
       * @param[in] value - new value to use
       */
      void setCurrentAssert(bool value);

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Echo_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_EchoAssert_obj_var ciao_echoAssertFacet_;
      ::SNA_Examples::CurrentNum_conn::CCM_Listener_var
         ciao_currentNumSub_data_listener_;
      ::CCM_DDS::CCM_PortStatusListener_var ciao_currentNumSub_status_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_numAssertPubConnStatus_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_currentNumSubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: The members in this class below this line were added by hand.
      //          The ones above were generated.
      //////////////////////////////////////////////////////////////////////////

      /**
       * Number for this loop.
       */
      long currentNumber_;

      /**
       * Number assertion for this loop.
       */
      bool currentAssertion_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_ECHO_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Echo_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
