// Add file header between tags below
/* BEGIN TAG */
/* END TAG */

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
/* BEGIN TAG */
/* END TAG */

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
         IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~testDataSub_data_listener_exec_i();

      /// Callback from DDS4CCM connector
      /// @param data - See DDS4CCM for information
      virtual
      void on_data(
         SNA_Examples::TestData_msgSeq& data);

      /// Callback from DDS4CCM connector
      /// @return See DDS4CCM for information
      virtual
      CCM_PSDD::ListenerMode listen_mode();

      /// Callback from DDS4CCM connector
      /// @param listen_mode - See DDS4CCM for information
      virtual
      void listen_mode(
         CCM_PSDD::ListenerMode listen_mode);

      /// Callback from DDS4CCM connector
      /// @return See DDS4CCM for information
      virtual
      CCM_PSDD::DataCount_t max_data();

      /// Callback from DDS4CCM connector
      /// @param max_data - See DDS4CCM for information
      virtual
      void max_data(
         CCM_PSDD::DataCount_t max_data);

      // Add public method declarations between tags below
      /* BEGIN TAG */
      /* END TAG */

   private:

      // Add private method declarations between tags below
      /* BEGIN TAG */
      /* END TAG */

      /// Container context used for all middleware communication
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context >::ref_type context_;
      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t & boilerplate_;

      // Add private members between tags below
      /* BEGIN TAG */
      /* END TAG */
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
      /* BEGIN TAG */
      /* END TAG */

   private:

      /// Get the ACE_Reactor
      /// @return non-owning pointer to reactor
      ACE_Reactor * reactor();

      // Add private method declarations between tags below
      /* BEGIN TAG */
      /* END TAG */

      /// Container context used for all middleware communication
     IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type context_;

     
      /// Object reference to testDataSub_data_listener facet
      IDL::traits<::SNA_Examples::TestData_conn::CCM_Listener>::ref_type testDataSub_data_listener_;

      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t boilerplate_;

      // Add private members between tags below
      /* BEGIN TAG */
      /* END TAG */
   };

  
   /// Factory method and library entry point used by the middleware
   /// @return new component instance
   extern "C" SNA_EXAMPLES_BASICSUBSCRIBER_COMP_EXEC_Export void
   create_SNA_Examples_BasicSubscriber_comp_Impl(
        IDL::traits<Components::EnterpriseComponent>::ref_type& component);
}

#endif /* ifndef */

// Add file footer between tags below
/* BEGIN TAG */
/* END TAG */
