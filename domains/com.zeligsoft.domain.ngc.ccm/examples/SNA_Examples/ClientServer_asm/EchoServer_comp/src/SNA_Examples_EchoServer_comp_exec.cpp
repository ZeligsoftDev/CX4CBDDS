//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup EchoServer_comp
/// @{
/// @file   SNA_Examples_EchoServer_comp_exec.cpp
/// @brief  Implementation of executor classes for the SourceClient_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.

#include "SNA_Examples_EchoServer_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

namespace CIAO_SNA_Examples_EchoServer_comp_Impl
{

   /**
    * Facet Executor Implementation Class: echoConnectFacet_exec_i
    */

   echoConnectFacet_exec_i::echoConnectFacet_exec_i(
      ::SNA_Examples::CCM_EchoServer_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_EchoServer_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   echoConnectFacet_exec_i::~echoConnectFacet_exec_i()
   {
   }

   // Operations from ::SNA_Examples::EchoConnect_obj

   void
   echoConnectFacet_exec_i::echoText(
      const char * msg)
   {
      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: This is the implementation of the echoText method provided by
      //          this component. This method is invoked by the
      //          SourceClient_comp and simply logs the message string.
      LOG4CXX_INFO(boilerplate_.getLogger(), msg);
   }

   /**
    * Component Executor Implementation Class: EchoServer_comp_exec_i
    */

   EchoServer_comp_exec_i::EchoServer_comp_exec_i() :
         boilerplate_("EchoServer_comp",
                      "SNA_Examples")
   {
   }

   EchoServer_comp_exec_i::~EchoServer_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   EchoServer_comp_exec_i::reactor()
   {
      ACE_Reactor * reactor = 0;
      ::CORBA::Object_var ccm_object =
         this->ciao_context_->get_CCM_object();

      if (! ::CORBA::is_nil(ccm_object.in()))
      {
         ::CORBA::ORB_var orb = ccm_object->_get_orb();

         if (! ::CORBA::is_nil(orb.in()))
         {
            reactor = orb->orb_core()->reactor();
         }
      }

      if (reactor == 0)
      {
         throw ::CORBA::INTERNAL();
      }

      return reactor;
   }

   // Component attributes and port operations.

   ::SNA_Examples::CCM_EchoConnect_obj_ptr
   EchoServer_comp_exec_i::get_echoConnectFacet()
   {
      if (::CORBA::is_nil(this->ciao_echoConnectFacet_.in()))
      {
         echoConnectFacet_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            echoConnectFacet_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_EchoConnect_obj::_nil());

         this->ciao_echoConnectFacet_ = tmp;
      }

      return
         ::SNA_Examples::CCM_EchoConnect_obj::_duplicate(
            this->ciao_echoConnectFacet_.in());
   }

   // Operations from Components::SessionComponent.

   void
   EchoServer_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_EchoServer_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   EchoServer_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      /* Your code here. */
   }

   void
   EchoServer_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      /* Your code here. */
   }

   void
   EchoServer_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      /* Your code here. */
   }

   void
   EchoServer_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   extern "C"
   SNA_EXAMPLES_ECHOSERVER_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_EchoServer_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         EchoServer_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                            U N C L A S S I F I E D                            
//==============================================================================
