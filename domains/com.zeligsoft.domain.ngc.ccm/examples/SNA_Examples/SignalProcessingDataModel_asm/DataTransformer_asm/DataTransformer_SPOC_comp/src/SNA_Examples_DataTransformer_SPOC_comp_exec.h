//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataTransformer_SPOC_comp
/// @{
/// @file   SNA_Examples_DataTransformer_SPOC_comp_exec.h
/// @brief  Definition of executor classes for the DataTransformer_SPOC_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_DATATRANSFORMER_SPOC_COMP_EXEC_X11ZV5_H_
#define CIAO_BS_SNA_EXAMPLES_DATATRANSFORMER_SPOC_COMP_EXEC_X11ZV5_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_DataTransformer_SPOC_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_DataTransformer_SPOC_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

//VSIPL++ headers
#include <vsip/initfin.hpp>
#include <vsip/math.hpp>

/// Auto-generated namespace for SNA_Examples_DataTransformer_SPOC_comp
namespace CIAO_SNA_Examples_DataTransformer_SPOC_comp_Impl
{
   /// Forward declaration of component executor class
   class DataTransformer_SPOC_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context,
      DataTransformer_SPOC_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: dataMapPub_status_exec_i
    */

   class dataMapPub_status_exec_i
      : public virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapPub_status_exec_i(
         ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapPub_status_exec_i();

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
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: dataMapSub_status_exec_i
    */

   class dataMapSub_status_exec_i
      : public virtual ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapSub_status_exec_i(
         ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapSub_status_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Reader_Status_Listener. */

      virtual
      void on_requested_deadline_missed(::DDS::DataReader_ptr the_reader,
                                        const ::DDS::RequestedDeadlineMissedStatus & status);

      virtual
      void on_sample_lost(::DDS::DataReader_ptr the_reader,
                          const ::DDS::SampleLostStatus & status);

      virtual
      void on_copy_unsupported(const ::SNA_Examples::DataMap_UDM_msg & datum,
                               const ::CCM_PSAT::Error_Callback_Info & info);

      virtual
      void on_buffer_invalidation(const ::SNA_Examples::DataMap_UDM_msg & datum,
                                  const ::CCM_PSAT::Error_Callback_Info & info);

      virtual
      void on_incomplete_transfer(const ::SNA_Examples::DataMap_UDM_msg & datum,
                                  const ::CCM_PSAT::Error_Callback_Info & info);

      virtual
      void on_invalid_udm_psat_header(const ::SNA_Examples::DataMap_UDM_msg & datum,
                                      const ::CCM_PSAT::Error_Callback_Info & info);
      //@}

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: dataMapSub_listener_exec_i
    */

   class dataMapSub_listener_exec_i
      : public virtual ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Listener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapSub_listener_exec_i(
         ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapSub_listener_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::PSAT_Listener. */

      virtual
      void on_one_data(const ::SNA_Examples::DataMap_UDM_msg & datum,
                       const ::CCM_DDS::ReadInfo & read_info);

      virtual
      void on_metadata_intercept(::SNA_Examples::DataMap_UDM_msg & datum);
      //@}

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;

      /**
       * Count of how many samples (messages) have been received.
       */
      int         recvMsgCount_;

      /**
       * Used to initialize VSIPL++ library in the constructor
       */
      vsip::vsipl lib_;
   };

   /**
    * Provider Executor Implementation Class: dataMapPubConnStatus_exec_i
    */

   class dataMapPubConnStatus_exec_i
      : public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapPubConnStatus_exec_i(
         ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapPubConnStatus_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::ConnectorStatusListener. */

      virtual
      void on_inconsistent_topic(::DDS::Topic_ptr the_topic,
                                 const ::DDS::InconsistentTopicStatus & status);

      virtual
      void on_requested_incompatible_qos(::DDS::DataReader_ptr the_reader,
                                         const ::DDS::RequestedIncompatibleQosStatus & status);

      virtual
      void on_sample_rejected(::DDS::DataReader_ptr the_reader,
                              const ::DDS::SampleRejectedStatus & status);

      virtual
      void on_offered_deadline_missed(::DDS::DataWriter_ptr the_writer,
                                      const ::DDS::OfferedDeadlineMissedStatus & status);

      virtual
      void on_offered_incompatible_qos(::DDS::DataWriter_ptr the_writer,
                                       const ::DDS::OfferedIncompatibleQosStatus & status);

      virtual
      void on_unexpected_status(::DDS::Entity_ptr the_entity,
                                ::DDS::StatusKind status_kind);
      //@}

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: dataMapPubConnStatus_exec_i
    */

   class dataMapSubConnStatus_exec_i
      : public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapSubConnStatus_exec_i(
         ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapSubConnStatus_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::ConnectorStatusListener. */

      virtual
      void on_inconsistent_topic(::DDS::Topic_ptr the_topic,
                                 const ::DDS::InconsistentTopicStatus & status);

      virtual
      void on_requested_incompatible_qos(::DDS::DataReader_ptr the_reader,
                                         const ::DDS::RequestedIncompatibleQosStatus & status);

      virtual
      void on_sample_rejected(::DDS::DataReader_ptr the_reader,
                              const ::DDS::SampleRejectedStatus & status);

      virtual
      void on_offered_deadline_missed(::DDS::DataWriter_ptr the_writer,
                                      const ::DDS::OfferedDeadlineMissedStatus & status);

      virtual
      void on_offered_incompatible_qos(::DDS::DataWriter_ptr the_writer,
                                       const ::DDS::OfferedIncompatibleQosStatus & status);

      virtual
      void on_unexpected_status(::DDS::Entity_ptr the_entity,
                                ::DDS::StatusKind status_kind);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: DataTransformer_SPOC_comp_exec_i
    */

   class DataTransformer_SPOC_comp_exec_i
      : public virtual DataTransformer_SPOC_comp_Exec,
     public virtual ::CORBA::LocalObject
   {
   public:


      /// Constructor
      DataTransformer_SPOC_comp_exec_i();

      /// Destructor
      virtual ~DataTransformer_SPOC_comp_exec_i();

      //@{
      /** Component attributes and port operations. */
      virtual ::CORBA::Long messageNumber();

      virtual void messageNumber(::CORBA::Long);

      virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
      get_dataMapPub_status();

      virtual ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener_ptr
      get_dataMapSub_status();

      virtual ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Listener_ptr
      get_dataMapSub_listener();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_dataMapPubConnStatus();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_dataMapSubConnStatus();
      //@}

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      /**
       * This method returns a boolean indication of whether or not to log
       * information about the current message.
       *
       * It works by applying the receive message logging modulo read from the
       * example's configuration file as a modulo on the msgCnt parameter such
       * that only every "nth" message will cause it to return true.  This is
       * to help control the flood of logging output when receiving messages
       * that have been sent close together in time.
       *
       * @param[in] msgCnt - count of how many messages have been received so
       *                     far.
       *
       * @return Boolean indication of whether it is okay to log the current
       *         message or not.
       */
      bool isOkayToLogMsg(int msgCnt);

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_SPOC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_var ciao_dataMapPub_status_;
      ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Reader_Status_Listener_var ciao_dataMapSub_status_;
      ::SNA_Examples::DataMap_UDM_conn::PSAT_Base::CCM_PSAT_Listener_var ciao_dataMapSub_listener_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_dataMapPubConnStatus_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_dataMapSubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      /**
       * The message number configured for this transformer
       */
      ::CORBA::Long messageNumber_;

      /**
       * In order to control the flood of logging output when receiving messages
       * that have been sent close together in time, this value will be applied
       * using the modulo operator and only every "nth" message received will be
       * logged.
       *
       * i.e., if ((msgCnt % receiveMsgLoggingModulo_) == 1)
       */
      unsigned int  receiveMsgLoggingModulo_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C"
   SNA_EXAMPLES_DATATRANSFORMER_SPOC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataTransformer_SPOC_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
