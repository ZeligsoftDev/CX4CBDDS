//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup StateManager_comp
/// @{
/// @file   SNA_Examples_StateManager_comp_exec.h
/// @brief  Definition of executor classes for the StateManager_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#ifndef CIAO_BS_SNA_EXAMPLES_STATEMANAGER_COMP_EXEC_VH1QAH_H_
#define CIAO_BS_SNA_EXAMPLES_STATEMANAGER_COMP_EXEC_VH1QAH_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_StateManager_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_StateManager_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

/// Auto-generated namespace for SNA_Examples_StateManager_comp
namespace CIAO_SNA_Examples_StateManager_comp_Impl
{
   /// Forward declaration of component executor class
   class StateManager_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_StateManager_comp_Context,
      StateManager_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Component Executor Implementation Class: StateManager_comp_exec_i
    */

   class StateManager_comp_exec_i :
      public virtual StateManager_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      StateManager_comp_exec_i();

      /// Destructor
      virtual ~StateManager_comp_exec_i();

      //@{
      /** Operations from Components::SessionComponent. */
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      /**
       * Schedule a new one-time timer and cancel any previous timer
       *
       * @param[in] sec  - seconds for timer delay
       * @param[in] usec - microseconds for timer delay
       */
      void scheduleNewTimer(time_t sec, suseconds_t usec = 0);

      /**
       * Callback for timer which changes state for components managed by this
       * StateManager.
       */
      int changeState();

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_StateManager_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: The members in this class below this line were added by hand.
      //          The ones above were generated.
      //////////////////////////////////////////////////////////////////////////

      /**
       * Get new state to which to command transition
       *
       * @return new state to command
       */
      SNA_Examples::SystemState getNextState();

      /**
       * Last state commanded to the slaves.
       */
      SNA_Examples::SystemState lastStateCommanded_;

      /**
       * How many times the timer has been called
       */
      int                       timerCount_;

      /**
       * Timer ID number.
       */
      long                      timerId_;

      /**
       * Time Manager used to schedule timer.
       */
      SNA::TimeManager          timeManager_;
   };

   /**
    * AMI4CCM reply handler
    */

   class AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i
      : public ::SNA_Examples::CCM_AMI4CCM_StateControl_objReplyHandler,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i(
         ::SNA_Examples::CCM_StateManager_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate,
         unsigned int numResponsesExpected);

      /// Destructor
      virtual ~AMI4CCM_StateControl_objReplyHandler_stateControlRecept_i();

      //@{
      /** AMI4CCM callback operations */
      virtual void
      changeState(
         ::SNA_Examples::ReturnStatus ami_return_val);

      virtual void
      changeState_excep(
         ::CCM_AMI::ExceptionHolder_ptr excep_holder);

      virtual void
      getState(
         ::SNA_Examples::SystemState ami_return_val);

      virtual void
      getState_excep(
         ::CCM_AMI::ExceptionHolder_ptr excep_holder);
      //@}
   
   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_StateManager_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;

      /**
       * Number of responses expected for a AMI4CCM call
       */
      unsigned int numResponsesExpected_;

      /**
       * Number of state change successes
       */
      unsigned int numSuccess_;

      /**
       * Number of state change failures
       */
      unsigned int numFail_;
   };

   /// Factory method and library entry point used by the middleware
   extern "C"
   SNA_EXAMPLES_STATEMANAGER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_StateManager_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                            U N C L A S S I F I E D
//==============================================================================
