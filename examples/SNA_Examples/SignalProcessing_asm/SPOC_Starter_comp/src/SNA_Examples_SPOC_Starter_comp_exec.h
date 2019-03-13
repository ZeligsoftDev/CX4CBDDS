//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SPOC_Starter_comp
/// @{
/// @file   SNA_Examples_SPOC_Starter_comp_exec.h
/// @brief  Definition of executor classes for the SPOC_Starter_comp component
///         and its facets.  The SPOC_Starter component creates
///         some data using VSIPL++ and then publishes it to another component.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_SPOC_STARTER_COMP_EXEC_EBR0Z4_H_
#define CIAO_BS_SNA_EXAMPLES_SPOC_STARTER_COMP_EXEC_EBR0Z4_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_SPOC_Starter_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_SPOC_Starter_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

#include "SNA_TimeManager.h"

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                   Business logic: includes and typedefs
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

//VSIPL++ headers
#include <vsip/initfin.hpp>
#include <vsip/math.hpp>


/// Auto-generated namespace for SNA_Examples_SPOC_Starter_comp
namespace CIAO_SNA_Examples_SPOC_Starter_comp_Impl
{
   /// Forward declaration of component executor class
   class SPOC_Starter_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_SPOC_Starter_comp_Context,
       SPOC_Starter_comp_exec_i>
      SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: SP_DataPub_status_exec_i
    */

   class SP_DataPub_status_exec_i :
      public virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SP_DataPub_status_exec_i(
         ::SNA_Examples::CCM_SPOC_Starter_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~SP_DataPub_status_exec_i();

      //@{
      /** Operations and attributes from ::CCM_PSAT::PSAT_Writer_Status_Listener. */

      virtual
      void on_buffer_available();

      virtual
      void on_buffer_wait_timeout();
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_SPOC_Starter_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: SP_DataPubConnStatus_exec_i
    */

   class SP_DataPubConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SP_DataPubConnStatus_exec_i(
         ::SNA_Examples::CCM_SPOC_Starter_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~SP_DataPubConnStatus_exec_i();

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
      ::SNA_Examples::CCM_SPOC_Starter_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: SPOC_Starter_comp_exec_i
    */

   class SPOC_Starter_comp_exec_i :
      public virtual SPOC_Starter_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SPOC_Starter_comp_exec_i();

      /// Destructor
      virtual ~SPOC_Starter_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
      get_SP_DataPub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_SP_DataPubConnStatus();
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
      ::SNA_Examples::CCM_SPOC_Starter_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_var ciao_SP_DataPub_status_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_SP_DataPubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //                      Business logic members
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      /**
       * Callback for timer
       * Create the output buffer for the PSAT message that will be published
       * and set a pointer to the attachment portion of that message
       */
      int prepare_output_buffer();

      /**
       * Initialize the data in VSIPL++, binding the pointer that references
       * the PSAT attachment memory space to a VSIPL++ block
       *
       * This function should not be called until outputSampleData is set
       * to point to the PSAT attachment memory space
       */
      void initialize_data();

      /**
       * Publish the data
       * @param data data matrix
       */
      void publish_data(vsip::Matrix<vsip::cscalar_f> & data);

      /**
       * Used to initialize the VSIPL++ library in the constructor
       */
      vsip::vsipl                                   lib_;

      /**
       * pointer to memory segment to be published
       */
      float *                                       outputSampleData;

      /**
       * Send timer ID number.
       */
      long                                          timerId_;

      /**
       * Time Manager used to schedule send timer.
       */
      SNA::TimeManager                              timeManager_;

      /**
       * Reference to the writer interface to the DDS4CCM connector for the
       * SNA_Examples::SPOC_Data_conn type
       */
      SNA_Examples::SPOC_Data_conn::PSAT_Writer_var dataPubWriter_;

      /**
       * 'header' for the PSAT message - this is the part of the
       * message that will be transfered via 'normal' DDS.  The first part
       * of the message must always be the psat header (CCM_PSAT::PSAT_Header).
       * Any number of user-defined structures may follow, but one of them must
       * be the SP_DataHdr - the metadata for a VSIPL++ object.
       */
      SNA_Examples::SPOC_Data_msg                   dataMsg_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_SPOC_STARTER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_SPOC_Starter_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
