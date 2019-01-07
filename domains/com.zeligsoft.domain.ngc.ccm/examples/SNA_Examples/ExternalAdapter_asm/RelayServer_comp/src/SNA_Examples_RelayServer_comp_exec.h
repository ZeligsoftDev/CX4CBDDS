//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup RelayServer_comp
/// @{
/// @file   SNA_Examples_RelayServer_comp_exec.h
/// @brief  Definition of executor classes for the RelayServer_comp component
///         and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#ifndef CIAO_BS_SNA_EXAMPLES_RELAYSERVER_COMP_EXEC_HJ3GTQ_H_
#define CIAO_BS_SNA_EXAMPLES_RELAYSERVER_COMP_EXEC_HJ3GTQ_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_RelayServer_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_RelayServer_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

/// Auto-generated namespace for SNA_Examples_RelayServer_comp
namespace CIAO_SNA_Examples_RelayServer_comp_Impl
{
   /// Forward declaration of component executor class
   class RelayServer_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_RelayServer_comp_Context,
      RelayServer_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: relayServerFacet_exec_i
    */

   class relayServerFacet_exec_i :
      public virtual ::SNA_Examples::CCM_RelayServer_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      relayServerFacet_exec_i(
         ::SNA_Examples::CCM_RelayServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~relayServerFacet_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::RelayServer_obj. */

      virtual
      void echoText(
         const char * msg);

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_RelayServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: RelayServer_comp_exec_i
    */

   class RelayServer_comp_exec_i :
      public virtual RelayServer_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      RelayServer_comp_exec_i();

      /// Destructor
      virtual ~RelayServer_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_RelayServer_obj_ptr
      get_relayServerFacet();
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
      ::SNA_Examples::CCM_RelayServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_RelayServer_obj_var ciao_relayServerFacet_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_RELAYSERVER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_RelayServer_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
