// Add file header between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 4f88253f-aa4c-43ad-bf29-4a2335415e77
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
/// @addtogroup SNA_Examples_BasicSubscriber_comp
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
//@@{__SNA_REGEN_MARKER__} - END : 4f88253f-aa4c-43ad-bf29-4a2335415e77

#ifndef CIAO_SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_H_
#define CIAO_SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_H_

#include "SNA_Examples_BasicSubscriber_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
#pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_BasicSubscriber_comp_exec_export.h"
#include "ace/Reactor.h"

#include "SNA_TypedCompBoilerplate.h"

// Add includes and forward declarations between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : c0b579cb-bf8a-4204-a49a-2b7a72e9be73
// EXAMPLE: These are included in order to delegate implementations of the
//          DDS4CCM error and status callbacks
#include "SNA_PortStatusListener.h"
#include "SNA_ConnectorStatusListener.h"
//@@{__SNA_REGEN_MARKER__} - END : c0b579cb-bf8a-4204-a49a-2b7a72e9be73

/// Component implementation namespace
namespace SNA_Examples_BasicSubscriber_comp_Impl
{
   /// Forward declaration of component executor class
   class BasicSubscriber_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      SNA_Examples::CCM_BasicSubscriber_comp_Context,
      BasicSubscriber_comp_exec_i> SNA_CompBoilerplate_t;

   /// Facet executor implementation class
   class testDataSub_data_listener_exec_i final :
      public virtual IDL::traits< ::SNA_Examples::TestData_conn::CCM_Listener>::base_type
   {
   public:

      /// Constructor
      /// @param[in] ctx         - Container context
      /// @param[in] boilerplate - Component-wide boilerplate object
      testDataSub_data_listener_exec_i(
         IDL::traits<::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSub_data_listener_exec_i();

      /// Callback from DDS4CCM connector
      /// @param datum - See DDS4CCM for information
      /// @param info - See DDS4CCM for information
      virtual
      void on_one_data(
         const SNA_Examples::TestData_msg& datum,
         const CCM_DDS::ReadInfo& info);

      /// Callback from DDS4CCM connector
      /// @param data - See DDS4CCM for information
      /// @param infos - See DDS4CCM for information
      virtual
      void on_many_data(
         const SNA_Examples::TestData_msgSeq& data,
         const CCM_DDS::ReadInfoSeq& infos);

      // Add public method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 89215097-081a-4748-89a0-9c7a12d99479
      //@@{__SNA_REGEN_MARKER__} - END : 89215097-081a-4748-89a0-9c7a12d99479

   private:

      // Add private method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 1013ec08-523f-4b35-b74d-7ccf06df0398
      //@@{__SNA_REGEN_MARKER__} - END : 1013ec08-523f-4b35-b74d-7ccf06df0398

      /// Container context used for all middleware communication
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context >::ref_type context_;
      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t & boilerplate_;

      // Add private members between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : b501e5f5-6755-4393-8ef1-089a228a8db4
      //@@{__SNA_REGEN_MARKER__} - END : b501e5f5-6755-4393-8ef1-089a228a8db4
   };

   /// Facet executor implementation class
   class testDataSub_status_exec_i final :
      public virtual IDL::traits< ::CCM_DDS::CCM_PortStatusListener>::base_type
   {
   public:

      /// Constructor
      /// @param[in] ctx         - Container context
      /// @param[in] boilerplate - Component-wide boilerplate object
      testDataSub_status_exec_i(
         IDL::traits<::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSub_status_exec_i();

      /// Callback from DDS DDS4CCM connector
      /// @param the_reader - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_requested_deadline_missed(
         IDL::traits< DDS::DataReader>::ref_type the_reader,
         const DDS::RequestedDeadlineMissedStatus& status);

      /// Callback from DDS DDS4CCM connector
      /// @param the_reader - See DDS for information
      /// @param status - See DDS for information
      virtual
      void on_sample_lost(
         IDL::traits< DDS::DataReader>::ref_type the_reader,
         const DDS::SampleLostStatus& status);

      // Add public method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 5d962b2b-1bb4-40aa-833d-4ccb2c29d618
      //@@{__SNA_REGEN_MARKER__} - END : 5d962b2b-1bb4-40aa-833d-4ccb2c29d618

   private:

      // Add private method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 81adabfa-b973-49fd-a598-d2dcb89f9c44
      //@@{__SNA_REGEN_MARKER__} - END : 81adabfa-b973-49fd-a598-d2dcb89f9c44

      /// Container context used for all middleware communication
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context >::ref_type context_;
      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t & boilerplate_;

      // Add private members between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 5728a2f8-4f5f-4591-ae8b-58d0d0d259de
      /// Implementation of the PSL that logs errors and status changes
      SNA::PortStatusListener impl_;
      //@@{__SNA_REGEN_MARKER__} - END : 5728a2f8-4f5f-4591-ae8b-58d0d0d259de
   };

   /// Facet executor implementation class
   class testDataSub_CSL_exec_i final :
      public virtual IDL::traits< ::CCM_DDS::CCM_ConnectorStatusListener>::base_type
   {
   public:

      /// Constructor
      /// @param[in] ctx         - Container context
      /// @param[in] boilerplate - Component-wide boilerplate object
      testDataSub_CSL_exec_i(
         IDL::traits<::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSub_CSL_exec_i();

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
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 11646bc2-f842-4041-a428-93aa61f9d771
      //@@{__SNA_REGEN_MARKER__} - END : 11646bc2-f842-4041-a428-93aa61f9d771

   private:

      // Add private method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 1f766784-1a1b-40d4-9d7a-d7746fb6733e
      //@@{__SNA_REGEN_MARKER__} - END : 1f766784-1a1b-40d4-9d7a-d7746fb6733e

      /// Container context used for all middleware communication
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context >::ref_type context_;
      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t & boilerplate_;

      // Add private members between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 3500f86b-fa21-4789-9f1a-9ea73fcd1dbb
      /// Implementation of the CSL that logs errors and status changes
      SNA::ConnectorStatusListener impl_;
      //@@{__SNA_REGEN_MARKER__} - END : 3500f86b-fa21-4789-9f1a-9ea73fcd1dbb
   };

   /// Component executor implementation class
   class BasicSubscriber_comp_exec_i final:
      public virtual IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp>::base_type
   {
   public:

      /// Constructor
      BasicSubscriber_comp_exec_i();

      /// Destructor
      virtual ~BasicSubscriber_comp_exec_i();

      /// Factory method and getter for facet
      /// @return Existing instance of facet if one exists, else new one
     virtual IDL::traits< ::SNA_Examples::TestData_conn::CCM_Listener>::ref_type get_testDataSub_data_listener();

      /// Factory method and getter for facet
      /// @return Existing instance of facet if one exists, else new one
     virtual IDL::traits< ::CCM_DDS::CCM_PortStatusListener>::ref_type get_testDataSub_status();

      /// Factory method and getter for facet
      /// @return Existing instance of facet if one exists, else new one
     virtual IDL::traits< ::CCM_DDS::CCM_ConnectorStatusListener>::ref_type get_testDataSub_CSL();

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
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 44709691-a532-4c5c-afb3-d7a5a8338cc5
      //@@{__SNA_REGEN_MARKER__} - END : 44709691-a532-4c5c-afb3-d7a5a8338cc5

   private:

      /// Get the ACE_Reactor
      /// @return non-owning pointer to reactor
      ACE_Reactor * reactor();

      // Add private method declarations between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 030a069e-dd65-4216-90d9-8569c7c5775c
      //@@{__SNA_REGEN_MARKER__} - END : 030a069e-dd65-4216-90d9-8569c7c5775c

      /// Container context used for all middleware communication
     IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context_;

     
      /// Object reference to testDataSub_data_listener facet
      IDL::traits<::SNA_Examples::TestData_conn::CCM_Listener>::ref_type testDataSub_data_listener_;

      /// Object reference to testDataSub_status facet
      IDL::traits<::CCM_DDS::CCM_PortStatusListener>::ref_type testDataSub_status_;

      /// Object reference to testDataSub_CSL facet
      IDL::traits<::CCM_DDS::CCM_ConnectorStatusListener>::ref_type testDataSub_CSL_;

      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t boilerplate_;

      // Add private members between tags below
      //@@{__SNA_REGEN_MARKER__} - BEGIN : 0d16bb96-76b4-43b2-be1d-f440d1b28a4a
      //@@{__SNA_REGEN_MARKER__} - END : 0d16bb96-76b4-43b2-be1d-f440d1b28a4a
   };

  
   /// Factory method and library entry point used by the middleware
   /// @return new component instance
   extern "C" SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_Export void
   create_SNA_Examples_BasicSubscriber_comp_Impl(
        IDL::traits<Components::EnterpriseComponent>::ref_type& component);
}

#endif /* ifndef */

// Add file footer between tags below
//@@{__SNA_REGEN_MARKER__} - BEGIN : 263e4eea-6afa-4f24-9c86-c2d8386cd814
/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
//@@{__SNA_REGEN_MARKER__} - END : 263e4eea-6afa-4f24-9c86-c2d8386cd814
