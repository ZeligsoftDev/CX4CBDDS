//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup BasicSubscriber_comp
/// @{
/// @file   SNA_Examples_BasicSubscriber_comp_exec.h
/// @brief  Definition of executor classes for the BasicSubscriber_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_FPY0UQ_H_
#define CIAO_BS_SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_FPY0UQ_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_BasicSubscriber_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_BasicSubscriber_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: These are included in order to inherit implementation of the DDS4CCM
//          error and status callbacks
#include "SNA_PortStatusListener.h"
#include "SNA_ConnectorStatusListener.h"

/// Auto-generated namespace for SNA_Examples_BasicSubscriber_comp
namespace CIAO_SNA_Examples_BasicSubscriber_comp_Impl
{
   /// Forward declaration of component executor class
   class BasicSubscriber_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context,
      BasicSubscriber_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: testDataSub_data_listener_exec_i
    */

   class testDataSub_data_listener_exec_i :
      public virtual ::SNA_Examples::TestData_conn::CCM_Listener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      testDataSub_data_listener_exec_i(
         ::SNA_Examples::CCM_BasicSubscriber_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSub_data_listener_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::TestData_conn::Listener. */

      virtual
      void on_one_data(
         const ::SNA_Examples::TestData_msg & datum,
         const ::CCM_DDS::ReadInfo & info);

      virtual
      void on_many_data(
         const ::SNA_Examples::TestData_msgSeq & data,
         const ::CCM_DDS::ReadInfoSeq & infos);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: testDataSub_status_exec_i
    */

   class testDataSub_status_exec_i :
      public virtual SNA::PortStatusListener, // EXAMPLE: inherit implementation
      public virtual ::CCM_DDS::CCM_PortStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      testDataSub_status_exec_i(
         ::SNA_Examples::CCM_BasicSubscriber_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSub_status_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::PortStatusListener. */

// These are defined out so that:
// 1. The inherited implementations will be used
// 2. The declarations are still available if the user decides to overload a
//    particular callback
// 3. Ease of merging/melding/diffing
#if 0
      virtual
      void on_requested_deadline_missed(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedDeadlineMissedStatus & status);

      virtual
      void on_sample_lost(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleLostStatus & status);
#endif
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: testDataSubConnStatus_exec_i
    */

   class testDataSubConnStatus_exec_i :
      public virtual SNA::ConnectorStatusListener, // EXAMPLE: inherit impl
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      testDataSubConnStatus_exec_i(
         ::SNA_Examples::CCM_BasicSubscriber_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSubConnStatus_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::ConnectorStatusListener. */

// These are defined out so that:
// 1. The inherited implementations will be used
// 2. The declarations are still available if the user decides to overload a
//    particular callback
// 3. Ease of merging/melding/diffing
#if 0
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
#endif
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: BasicSubscriber_comp_exec_i
    */

   class BasicSubscriber_comp_exec_i :
      public virtual BasicSubscriber_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      BasicSubscriber_comp_exec_i();

      /// Destructor
      virtual ~BasicSubscriber_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::TestData_conn::CCM_Listener_ptr
      get_testDataSub_data_listener();

      virtual ::CCM_DDS::CCM_PortStatusListener_ptr
      get_testDataSub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_testDataSubConnStatus();
      //@}

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_BasicSubscriber_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::TestData_conn::CCM_Listener_var
         ciao_testDataSub_data_listener_;
      ::CCM_DDS::CCM_PortStatusListener_var ciao_testDataSub_status_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_testDataSubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_BasicSubscriber_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
