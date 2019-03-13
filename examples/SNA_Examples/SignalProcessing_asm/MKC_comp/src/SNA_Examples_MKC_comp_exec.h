//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup MKC_comp
/// @{
/// @file   SNA_Examples_MKC_comp_exec.h
/// @brief  Definition of executor classes for the MKC_comp component and its
///         facets.  The Math Kernel Component (MKC) provides mathematical
///         capabilities to SPOCs by exposing an interface that contains
///         serialized VSIPL++ data objects.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_MKC_COMP_EXEC_U2ULVE_H_
#define CIAO_BS_SNA_EXAMPLES_MKC_COMP_EXEC_U2ULVE_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_MKC_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_MKC_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                   Business logic: includes and namespaces
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

// VSIPL++ headers
#include <vsip/initfin.hpp>
#include <vsip/math.hpp>

/// Typedef for a two dimensional dense block. This is the type of the actual
/// memory allocation of the VSIPL view.
typedef vsip::Dense<2, vsip::cscalar_f> dense_type2;

/// Auto-generated namespace for SNA_Examples_MKC_comp
namespace CIAO_SNA_Examples_MKC_comp_Impl
{
   /// Forward declaration of component executor class
   class MKC_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_MKC_comp_Context,
      MKC_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: SPMathFacet__exec_i
    */

   class SPMathFacet__exec_i :
      public virtual ::SNA_Examples::CCM_SP_Math_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      SPMathFacet__exec_i(
         ::SNA_Examples::CCM_MKC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~SPMathFacet__exec_i();

      // These methods are created from a user-defined IDL file
      // (SNA_Examples_SP_Math_obj.idl, in this case).  Also note that the
      // three functions defined here are merely an example - they do not
      // constitute any kind of 'standard MKC-interface'.
      //
      // The only requirement for an MKC is that at least one function is
      // defined that uses the ::SNA::SP_DataHdr along with a sequence
      // (or suitable replacement) of data.  This itself is the mechanism by
      // which VSIPL++ data objects can be transfered between components.

      //@{
      /** Operations and attributes from ::SNA_Examples::SP_Math_obj. */

      virtual
      void init();

      virtual
      void compute(
         const ::SNA::SP_DataHdr & dataInDescriptor,
         ::SNA::SP_DataHdr & dataOutDescriptor,
         const ::SNA::ByteSequence & dataInReal,
         const ::SNA::ByteSequence & dataInImag,
         ::SNA::ByteSequence & dataOutReal,
         ::SNA::ByteSequence & dataOutImag);

      virtual
      void cleanup();
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_MKC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;

      /**
       * The actual math to perform on the data
       *
       * @param[in] in input matrix
       * @param[out] out output matrix
       */
      void do_math(const vsip::Matrix<vsip::cscalar_f> &in,
                   vsip::Matrix<vsip::cscalar_f> &out);

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //                   Business logic: members
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      /**
       * Used to initialize the VSIPL++ library in the constructor
       */
      vsip::vsipl              lib;

      /**
       * VSIPL++ Block for the input data
       */
      dense_type2              denseMatrixMKCIn;

      /**
       * VSIPL++ View for the input data
       */
      vsip::Matrix<vsip::cscalar_f> MatIn;

      /**
       * VSIPL++ Block for the output data
       */
      dense_type2              denseMatrixMKCOut;

      /**
       * VSIPL++ View for the output data
       */
      vsip::Matrix<vsip::cscalar_f> MatOut;
   };

   /**
    * Component Executor Implementation Class: MKC_comp_exec_i
    */

   class MKC_comp_exec_i :
      public virtual MKC_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      MKC_comp_exec_i();

      /// Destructor
      virtual ~MKC_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_SP_Math_obj_ptr
      get_SPMathFacet_();
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
      ::SNA_Examples::CCM_MKC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_SP_Math_obj_var ciao_SPMathFacet__;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factor method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_MKC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_MKC_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
