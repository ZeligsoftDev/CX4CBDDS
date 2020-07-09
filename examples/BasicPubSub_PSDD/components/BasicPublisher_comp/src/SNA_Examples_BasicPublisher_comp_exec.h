// Add file header between tags below
/* BEGIN TAG */
/* END TAG */

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
/* BEGIN TAG */
// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

// EXAMPLE: This is included in order to delegate implementation of the DDS4CCM
//          error and status callbacks
#include "SNA_ConnectorStatusListener.h"
#include "ace/Event_Handler_T.h"
/* END TAG */

/// Component implementation namespace
namespace SNA_Examples_BasicPublisher_comp_Impl
{
   /// Forward declaration of component executor class
   class BasicPublisher_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      SNA_Examples::CCM_BasicPublisher_comp_Context,
      BasicPublisher_comp_exec_i> SNA_CompBoilerplate_t;

   /// Component executor implementation class
   class BasicPublisher_comp_exec_i final:
      public virtual IDL::traits< ::SNA_Examples::CCM_BasicPublisher_comp>::base_type
   {
   public:

      /// Constructor
      BasicPublisher_comp_exec_i();

      /// Destructor
      virtual ~BasicPublisher_comp_exec_i();

      /// Getter for BasicPublisher_config attribute
      /// @return value of BasicPublisher_config attribute
      std::string BasicPublisher_config() override;

      /// Setter for BasicPublisher_config attribute
      /// @param[in] BasicPublisher_config - New value for BasicPublisher_config attribute
      void BasicPublisher_config(const std::string& BasicPublisher_config) override;

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
      /// Callback for publish timer
      /// @return 0 on success, -1 on failure
      int sendSample(const ACE_Time_Value &, const void *);
      /* END TAG */

   private:

      /// Get the ACE_Reactor
      /// @return non-owning pointer to reactor
      ACE_Reactor * reactor();

      // Add private method declarations between tags below
      /* BEGIN TAG */
      /* END TAG */

      /// Container context used for all middleware communication
     IDL::traits< ::SNA_Examples::CCM_BasicPublisher_comp_Context>::ref_type context_;

     

      /// SNA boilerplate used to access logger, executor class pointer, etc.
      SNA_CompBoilerplate_t boilerplate_;

      /// Member storing value of the BasicPublisher_config attribute
      std::string BasicPublisher_config_ {};

      // Add private members between tags below
      /* BEGIN TAG */
      /// Send timer ID number.
      long             timerId_;

      /// Number of samples to publish each time the timer fires.  Default to 1.
      unsigned int     numSamplesToPublishEachTime_;

      /// Time Manager used to schedule send timer.
      SNA::TimeManager timeManager_;
      
      /// Event handler for timer
      ACE_Event_Handler_T<BasicPublisher_comp_exec_i> sendTimer_;
      /* END TAG */
   };

  
   /// Factory method and library entry point used by the middleware
   /// @return new component instance
   extern "C" SNA_EXAMPLES_BASICPUBLISHER_COMP_EXEC_Export void
   create_SNA_Examples_BasicPublisher_comp_Impl(
        IDL::traits<Components::EnterpriseComponent>::ref_type& component);
}

#endif /* ifndef */

// Add file footer between tags below
/* BEGIN TAG */
/* END TAG */
