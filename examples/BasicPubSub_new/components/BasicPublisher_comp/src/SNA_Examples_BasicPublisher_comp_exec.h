// Add file header between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : f4b06414-18d3-4e60-be43-a6e22b01ecda
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010-2019 -- ALL RIGHTS RESERVED
//==============================================================================
//
//==============================================================================
// EXPORT REGULATIONS (EAR99)
//==============================================================================
// DISCLOSURE: 
//
// Warning - This data is subject to the Export Administration Act (Title 22 
// U.S.C. App. 2401 et seq.), as amended. The implementing regulation for 
// this statute is the Export Administration Regulations (EAR) (15 C.F.R.
// 730-774). It may not be transferred, either in its original form, derivative 
// documents, or after being incorporated into other data without first 
// obtaining approval from the U.S. government or as otherwise authorized by 
// U.S. law and regulations. 
//==============================================================================
/// @addtogroup SNA_Examples_BasicPublisher_comp
/// @{
/// @file   SNA_Examples_BasicPublisher_comp_exec.h
/// @brief  Definition of executor classes for the BasicPublisher_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//
//@@{__SNA_REGEN_MARKER__} - END : f4b06414-18d3-4e60-be43-a6e22b01ecda

#ifndef CIAO_SNA_EXAMPLES_BASICPUBLISHER_COMP_EXEC_H_
#define CIAO_SNA_EXAMPLES_BASICPUBLISHER_COMP_EXEC_H_

#include "SNA_Examples_BasicPublisher_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
#pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_BasicPublisher_comp_exec_export.h"
#include "ace/Reactor.h"

#include "SNA_TypedCompBoilerplate.h"

// Add includes and forward declarations between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 897daf35-b729-4d58-a643-d7817c3ffcaf
// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

// EXAMPLE: This is included in order to delegate implementation of the DDS4CCM
//          error and status callbacks
#include "SNA_ConnectorStatusListener.h"
#include "ace/Event_Handler_T.h"
//@@{__SNA_REGEN_MARKER__} - END : 897daf35-b729-4d58-a643-d7817c3ffcaf

/// Component implementation namespace
namespace SNA_Examples_BasicPublisher_comp_Impl
{
   /// Forward declaration of component executor class
   class BasicPublisher_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      SNA_Examples::CCM_BasicPublisher_comp_Context,
      BasicPublisher_comp_exec_i> SNA_CompBoilerplate_t;

   /// Facet executor implementation class
   class testDataPub_CSL_exec_i final :
      public virtual IDL::traits< ::CCM_DDS::CCM_ConnectorStatusListener>::base_type
   {
   public:

      /// Constructor
      /// @param[in] ctx         - Container context
      /// @param[in] boilerplate - Component-wide boilerplate object
      testDataPub_CSL_exec_i(
         IDL::traits<::SNA_Examples::CCM_BasicPublisher_comp_Context>::ref_type context,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataPub_CSL_exec_i();

      /// Callback from DDS DDS4CCM connector
      /// @param the_topic - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_inconsistent_topic(
         IDL::traits< DDS::Topic>::ref_type the_topic,
         const DDS::InconsistentTopicStatus& status);

      /// Callback from DDS DDS4CCM connector
      /// @param the_reader - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_requested_incompatible_qos(
         IDL::traits< DDS::DataReader>::ref_type the_reader,
         const DDS::RequestedIncompatibleQosStatus& status);

      /// Callback from DDS DDS4CCM connector
      /// @param the_reader - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_sample_rejected(
         IDL::traits< DDS::DataReader>::ref_type the_reader,
         const DDS::SampleRejectedStatus& status);

      /// Callback from DDS DDS4CCM connector
      /// @param the_writer - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_offered_deadline_missed(
         IDL::traits< DDS::DataWriter>::ref_type the_writer,
         const DDS::OfferedDeadlineMissedStatus& status);

      /// Callback from DDS DDS4CCM connector
      /// @param the_writer - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_offered_incompatible_qos(
         IDL::traits< DDS::DataWriter>::ref_type the_writer,
         const DDS::OfferedIncompatibleQosStatus& status);

      /// Callback from DDS DDS4CCM connector
      /// @param the_entity - See DDS for information
      /// @param status_kind - See DDS for information
      virtual
      void on_unexpected_status(
         IDL::traits< DDS::Entity>::ref_type the_entity,
         DDS::StatusKind status_kind);

      // Add public method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 1e9a4ed4-8fd1-46df-9a59-0e4e93fcd2cf
      //@@{__SNA_REGEN_MARKER__} - END : 1e9a4ed4-8fd1-46df-9a59-0e4e93fcd2cf

   private:

      // Add private method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 790af0f3-ac17-4d7a-b451-3ef4c745017c
      //@@{__SNA_REGEN_MARKER__} - END : 790af0f3-ac17-4d7a-b451-3ef4c745017c

      /// Container context used for all middleware communication
      IDL::traits< ::SNA_Examples::CCM_BasicPublisher_comp_Context >::ref_type context_;
      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t & boilerplate_;

      // Add private members between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 05425637-f8f1-42e1-be03-28fd4ea3c1b5
      /// Implementation of the CSL that logs errors and status changes
      SNA::ConnectorStatusListener impl_;
      //@@{__SNA_REGEN_MARKER__} - END : 05425637-f8f1-42e1-be03-28fd4ea3c1b5
   };

   /// Component executor implementation class
   class BasicPublisher_comp_exec_i final:
      public virtual IDL::traits< ::SNA_Examples::CCM_BasicPublisher_comp>::base_type
   {
   public:

      /// Constructor
      BasicPublisher_comp_exec_i();

      /// Destructor
      virtual ~BasicPublisher_comp_exec_i();

      /// Factory method and getter for facet
      /// @return Existing instance of facet if one exists, else new one
     virtual IDL::traits< ::CCM_DDS::CCM_ConnectorStatusListener>::ref_type get_testDataPub_CSL();

      /// Getter for BasicPublisher_config attribute
      /// @return value of BasicPublisher_config attribute
      virtual std::string BasicPublisher_config();

      /// Setter for BasicPublisher_config attribute
      /// @param[in] BasicPublisher_config - New value for BasicPublisher_config attribute
      virtual void BasicPublisher_config(const std::string& BasicPublisher_config);

      /// Setter for container context for this component
      /// @param[in] ctx - Container context
      virtual void set_session_context(
        IDL::traits<Components::SessionContext>::ref_type ctx);

      /// Component state change method to configuration_complete state
      virtual void configuration_complete();

      /// Component state change method to activated state
      virtual void ccm_activate();

      /// Component state change method to passivated state
      virtual void ccm_passivate();

      /// Component state change method to removed state
      virtual void ccm_remove();

      // Add public method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 0a4d2063-d217-4916-8552-9d408a55e5d1
      /// Callback for publish timer
      /// @return 0 on success, -1 on failure
      int sendSample(const ACE_Time_Value &, const void *);
      //@@{__SNA_REGEN_MARKER__} - END : 0a4d2063-d217-4916-8552-9d408a55e5d1

   private:

      /// Get the ACE_Reactor
      /// @return non-owning pointer to reactor
      ACE_Reactor * reactor();

      // Add private method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 7a5cf208-7c34-44c7-8844-04de6607e6a3
      //@@{__SNA_REGEN_MARKER__} - END : 7a5cf208-7c34-44c7-8844-04de6607e6a3

      /// Container context used for all middleware communication
     IDL::traits< ::SNA_Examples::CCM_BasicPublisher_comp_Context>::ref_type context_;

     
      /// Object reference to testDataPub_CSL facet
      IDL::traits<::CCM_DDS::CCM_ConnectorStatusListener>::ref_type testDataPub_CSL_;

      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t boilerplate_;

      /// Member storing value of the BasicPublisher_config attribute
      std::string BasicPublisher_config_ {};

      // Add private members between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : a43d32ec-6713-4be5-81ba-5ff9b2a05f9b
      /// Send timer ID number.
      long             timerId_;

      /// Number of samples to publish each time the timer fires.  Default to 1.
      unsigned int     numSamplesToPublishEachTime_;

      /// Time Manager used to schedule send timer.
      SNA::TimeManager timeManager_;
      
      /// Event handler for timer
      ACE_Event_Handler_T<BasicPublisher_comp_exec_i> sendTimer_;
      //@@{__SNA_REGEN_MARKER__} - END : a43d32ec-6713-4be5-81ba-5ff9b2a05f9b
   };

  
   /// Factory method and library entry point used by the middleware
   /// @return new component instance
   extern "C" SNA_EXAMPLES_BASICPUBLISHER_COMP_EXEC_Export void
   create_SNA_Examples_BasicPublisher_comp_Impl(
        IDL::traits<Components::EnterpriseComponent>::ref_type& component);
}

#endif /* ifndef */

// Add file footer between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : cf4be43e-3986-411c-9330-6e2879bcba6d
/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
//@@{__SNA_REGEN_MARKER__} - END : cf4be43e-3986-411c-9330-6e2879bcba6d
