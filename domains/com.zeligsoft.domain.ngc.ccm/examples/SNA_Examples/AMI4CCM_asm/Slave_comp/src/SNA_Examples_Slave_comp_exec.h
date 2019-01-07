//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Slave_comp
/// @{
/// @file   SNA_Examples_Slave_comp_exec.cpp
/// @brief  Implementation of executor classes for the Slave_comp component and
///         its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#ifndef CIAO_BS_SNA_EXAMPLES_SLAVE_COMP_EXEC_HNC70V_H_
#define CIAO_BS_SNA_EXAMPLES_SLAVE_COMP_EXEC_HNC70V_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_Slave_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_Slave_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

/// Auto-generated namespace for SNA_Examples_Slave_comp
namespace CIAO_SNA_Examples_Slave_comp_Impl
{
   /// Forward declaration of component executor class
   class Slave_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_Slave_comp_Context,
      Slave_comp_exec_i > SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: stateControlFacet_exec_i
    */

   class stateControlFacet_exec_i :
      public virtual ::SNA_Examples::CCM_StateControl_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      stateControlFacet_exec_i(
         ::SNA_Examples::CCM_Slave_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~stateControlFacet_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::StateControl_obj. */

      virtual ::SNA_Examples::ReturnStatus changeState(
         ::SNA_Examples::SystemState newState);

      virtual ::SNA_Examples::SystemState getState();
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Slave_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: Slave_comp_exec_i
    */

   class Slave_comp_exec_i :
      public virtual Slave_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      Slave_comp_exec_i();

      /// Destructor
      virtual ~Slave_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_StateControl_obj_ptr
      get_stateControlFacet();
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
       * Accessor for the current state
       *
       * @return current state
       */
      SNA_Examples::SystemState getCurrentState();

      /**
       * Setter for the current current state
       *
       * @param[in] newState        - state to which to transition
       * @param[in] externalCommand - true if this transition was due to an
       *                              external command, false if an "automatic"
       *                              internal transition
       *
       * @return true on successful state transition, false otherwise
       */
      bool setCurrentState(
         SNA_Examples::SystemState newState,
         bool                      externalCommand);

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_Slave_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_StateControl_obj_var ciao_stateControlFacet_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      /**
       * Current state of this component
       */
      ::SNA_Examples::SystemState currentState_;
   };

   /// Factory method and library entry point used by the middleware
   extern "C"
   SNA_EXAMPLES_SLAVE_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_Slave_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                            U N C L A S S I F I E D
//==============================================================================
