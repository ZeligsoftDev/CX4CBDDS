//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SPOC_comp
/// @{
/// @file   SNA_Examples_SPOC_comp_exec.h
/// @brief  Definition of executor classes for the SPOC_comp component and its
///         facets.  The SPOC component subscribes to data from the
///         SPOC_Starter and upon receiving it invokes a math function
///         on the data through a facet provided by the Math Kernel Component
///         (MKC).
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_SPOC_COMP_EXEC_R4A1I7_H_
#define CIAO_BS_SNA_EXAMPLES_SPOC_COMP_EXEC_R4A1I7_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_SPOC_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_SPOC_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                   Business logic: includes and typedefs
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

//VSIPL++ headers
#include <vsip/initfin.hpp>
#include <vsip/math.hpp>

/// Typedef for type of the raw sample data that is fed into the signal
/// processing algorithms.
typedef std::complex<float> cmplx_type;

/// Typedef for a two-dimensional dense block. This is the type of the actual
/// memory allocation of the VSIPL view.
typedef vsip::Dense<2, cmplx_type > dense_type2;

/// Auto-generated namespace for SNA_Examples_SPOC_comp
namespace CIAO_SNA_Examples_SPOC_comp_Impl
{
   /// Forward declaration of component executor class
   class SPOC_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_SPOC_comp_Context,
      SPOC_comp_exec_i> SNA_CompBoilerplate_t;

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
         ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
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
      ::SNA_Examples::CCM_SPOC_comp_Context_var ciao_context_;

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
         ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
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
      ::SNA_Examples::CCM_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: SP_DataSub_status_exec_i
    */

   class SP_DataSub_status_exec_i :
      public virtual ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Reader_Status_Listener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SP_DataSub_status_exec_i(
         ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~SP_DataSub_status_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::SPOC_Data_conn::PSAT_Reader_Status_Listener. */

      virtual
      void on_requested_deadline_missed(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedDeadlineMissedStatus & status);

      virtual
      void on_sample_lost(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleLostStatus & status);

      virtual
      void on_copy_unsupported(
         const ::SNA_Examples::SPOC_Data_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info);

      virtual
      void on_buffer_invalidation(
         const ::SNA_Examples::SPOC_Data_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info);

      virtual
      void on_incomplete_transfer(
         const ::SNA_Examples::SPOC_Data_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info);

      virtual
      void on_invalid_udm_psat_header(
         const ::SNA_Examples::SPOC_Data_msg & datum,
         const ::CCM_PSAT::Error_Callback_Info & info);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: SP_DataSub_listener_exec_i
    */

   class SP_DataSub_listener_exec_i :
      public virtual ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Listener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SP_DataSub_listener_exec_i(
         ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~SP_DataSub_listener_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::SPOC_Data_conn::PSAT_Listener. */

      virtual
      void on_one_data(
         const ::SNA_Examples::SPOC_Data_msg & datum,
         const ::CCM_DDS::ReadInfo & read_info);

      virtual
      void on_metadata_intercept(::SNA_Examples::SPOC_Data_msg & datum);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //                Business logic members
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      /**
       * Used to initialize VSIPL++ library in the contructor
       */
      vsip::vsipl lib_;

      /**
       * VSIPL++ input Block
       */
      dense_type2    denseMatIn;

      /**
       * VSIPL++ input View
       */
      vsip::Matrix<cmplx_type>   dataIn;

      /**
       * VSIPL++ output Block
       */
      dense_type2    denseMatOut;

      /**
       * VSIPL++ output View
       */
      vsip::Matrix<cmplx_type>   dataOut;

      /**
       * pointer to received data
       */
      float * inputSampleData;

      /**
       * pointer to the output data
       */
      float *outputSampleData;

      /**
       *'header' for the PSAT message data
       */
      SNA_Examples::SPOC_Data_msg publishData;

      /**
       * Buffer control object
       */
      SNA_Examples::SPOC_Data_conn::PSAT_Attachment_Control_var bufferControlObj;

      /**
       * Reference to the writer interface to the DDS4CCM connector for the
       * SNA_Examples::SPOC_Data_conn type
       */
     SNA_Examples::SPOC_Data_conn::PSAT_Writer_var dataPubWriter;

      /**
       * Grab a pointer to the attachment portion of the PSAT message
       * @param receivedData pointer to the PSAT attachment
       */
      void get_attachment_pointer(
            const ::SNA_Examples::SPOC_Data_msg & receivedData);

      /**
       * Create the output buffer for the PSAT message that will be published
       * and set a pointer to the attachment portion of that message
       */
      void prepare_output_buffer();

      /**
       * Using the two data pointers to both the received and publishing
       * attachment memories, instantiate actual VSIPL++ data View objects such
       * that their data will not need to be copied
       * @param receivedData pointer to the SPOC data message
       */
      void create_data_views(const ::SNA_Examples::SPOC_Data_msg & receivedData);

      /**
       * Invoke the facets provided by the MKC
       */
      void use_MKC();

      /**
       * Publish the data
       */
      void publish_data();
   };

   /**
    * Provider Executor Implementation Class: SP_DataSubConnStatus_exec_i
    */

   class SP_DataSubConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SP_DataSubConnStatus_exec_i(
         ::SNA_Examples::CCM_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~SP_DataSubConnStatus_exec_i();

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
      ::SNA_Examples::CCM_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: SPOC_comp_exec_i
    */

   class SPOC_comp_exec_i :
      public virtual SPOC_comp_Exec, public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SPOC_comp_exec_i();

      /// Destructor
      virtual ~SPOC_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
      get_SP_DataPub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_SP_DataPubConnStatus();

      virtual ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Reader_Status_Listener_ptr
      get_SP_DataSub_status();

      virtual ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Listener_ptr
      get_SP_DataSub_listener();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_SP_DataSubConnStatus();
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
      ::SNA_Examples::CCM_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_var ciao_SP_DataPub_status_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_SP_DataPubConnStatus_;
      ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Reader_Status_Listener_var
         ciao_SP_DataSub_status_;
      ::SNA_Examples::SPOC_Data_conn::CCM_PSAT_Listener_var
         ciao_SP_DataSub_listener_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_SP_DataSubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_SPOC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_SPOC_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
