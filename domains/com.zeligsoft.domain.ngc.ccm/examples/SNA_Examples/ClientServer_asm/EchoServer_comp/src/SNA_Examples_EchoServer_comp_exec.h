//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup EchoServer_comp
/// @{
/// @file   SNA_Examples_EchoServer_comp_exec.h
/// @brief  Definition of executor classes for the SourceClient_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#ifndef CIAO_BS_SNA_EXAMPLES_ECHOSERVER_COMP_EXEC_6X3CBW_H_
#define CIAO_BS_SNA_EXAMPLES_ECHOSERVER_COMP_EXEC_6X3CBW_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_EchoServer_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_EchoServer_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

/// Auto-generated namespace for SNA_Examples_EchoServer_comp
namespace CIAO_SNA_Examples_EchoServer_comp_Impl
{
   /// Forward declaration of component executor class
   class EchoServer_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_EchoServer_comp_Context, EchoServer_comp_exec_i>
      SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: echoConnectFacet_exec_i
    */

   class echoConnectFacet_exec_i :
      public virtual ::SNA_Examples::CCM_EchoConnect_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      echoConnectFacet_exec_i(
         ::SNA_Examples::CCM_EchoServer_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~echoConnectFacet_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::EchoConnect_obj. */

      virtual
      void echoText(
         const char * msg);

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_EchoServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: EchoServer_comp_exec_i
    */

   class EchoServer_comp_exec_i :
      public virtual EchoServer_comp_Exec, public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      EchoServer_comp_exec_i();

      /// Destructor
      virtual ~EchoServer_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_EchoConnect_obj_ptr
      get_echoConnectFacet();
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
      ::SNA_Examples::CCM_EchoServer_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_EchoConnect_obj_var ciao_echoConnectFacet_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_ECHOSERVER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_EchoServer_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */
/// @}
//==============================================================================
//                            U N C L A S S I F I E D                            
//==============================================================================
