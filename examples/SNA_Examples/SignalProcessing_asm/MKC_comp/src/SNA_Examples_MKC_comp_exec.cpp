//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup MKC_comp
/// @{
/// @file   SNA_Examples_MKC_comp_exec.cpp
/// @brief  Implementation of executor classes for the MKC_comp component and
///         its facets.  The Math Kernel Component (MKC) provides mathematical
///         capabilities to SPOCs by exposing an interface that contains
///         serialized VSIPL++ data objects.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_MKC_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                   Business logic: includes and namespaces
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

// C++ -> IDL conversions
#include "SNA_DataViewTranslator.h"

// Print VSIPL++ objects
#include "SNA_Examples_DataObjectPrinter.h"

// Serialization API
#include <vsip/serialization.hpp>


namespace CIAO_SNA_Examples_MKC_comp_Impl
{

   /**
    * Facet Executor Implementation Class: SPMathFacet__exec_i
    */

   SPMathFacet__exec_i::SPMathFacet__exec_i(
      ::SNA_Examples::CCM_MKC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_MKC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate),
         lib(),
         denseMatrixMKCIn(vsip::Domain<2>(0,0),(float *)0, (float *)0),
         MatIn(denseMatrixMKCIn),
         denseMatrixMKCOut(vsip::Domain<2>(0,0),(float *)0, (float *)0),
         MatOut(denseMatrixMKCOut)
   {
   }

   SPMathFacet__exec_i::~SPMathFacet__exec_i()
   {
   }

   // Operations from ::SNA_Examples::SP_Math_obj

   void
   SPMathFacet__exec_i::init()
   {
      LOG4CXX_INFO(boilerplate_.getLogger(), "init() \n");
   }

   void
   SPMathFacet__exec_i::compute(
         const ::SNA::SP_DataHdr &  dataInDescriptor,
         ::SNA::SP_DataHdr & dataOutDescriptor,
         const ::SNA::ByteSequence & dataInReal,
         const ::SNA::ByteSequence & dataInImag,
         ::SNA::ByteSequence & dataOutReal,
         ::SNA::ByteSequence & dataOutImag)
   {
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //             Reconstruct input data view from message
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      vsip::serialization::Descriptor inputInfo;

      // IDL -> C++ - get Descriptor from message
      SNA::DataViewTranslator::idl_to_cpp(dataInDescriptor, inputInfo);

      // IDL -> C++ - get data from message
      const float * const pDataSeqInReal = reinterpret_cast<const float *>(&dataInReal[0]);
      const float * const pDataSeqInImag = reinterpret_cast<const float *>(&dataInImag[0]);

      // Unmarshal the data
      bool valid = vsip::serialization::is_compatible<vsip::Dense<2, vsip::cscalar_f> >(inputInfo);
      if (valid)
      {
         MatIn.block().rebind(const_cast<float *>(pDataSeqInReal),
                              const_cast<float *>(pDataSeqInImag),
                              vsip::Domain<2>(inputInfo.size[0], inputInfo.size[1]));


         MatIn.block().admit(true);
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Failed to unmarshal input data in MKC!");
         return;
      }

      SNA_Examples::DataObjectPrinter::PrintComplexMatrix(
            MatIn,
            "VSIPL++ MKC input data after admit:",
            boilerplate_.getLogger());


      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //             Reconstruct output data view from message
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      vsip::serialization::Descriptor outputInfo;

      // IDL -> C++ - get Descriptor from message
      SNA::DataViewTranslator::idl_to_cpp(  dataOutDescriptor,
                                       outputInfo);

      // IDL -> C++ - get data from message
      const float * const pDataSeqOutReal = reinterpret_cast<const float *>(&dataOutReal[0]);
      const float * const pDataSeqOutImag = reinterpret_cast<const float *>(&dataOutImag[0]);

      // Unmarshal the data
      bool validOut = vsip::serialization::is_compatible<vsip::Dense<2, vsip::cscalar_f> >(outputInfo);
      if (validOut)
      {
         MatOut.block().rebind(  const_cast<float *>(pDataSeqOutReal),
                                 const_cast<float *>(pDataSeqOutImag),
                                 vsip::Domain<2>(outputInfo.size[0], outputInfo.size[1]));


         MatOut.block().admit(true);
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Failed to unmarshal output data in MKC!");
      }

      // Now that the data Views have been reconstructed, we're ready to do
      // the actual math
      do_math(MatIn, MatOut);

      // Release the data from VSIPL++ and set the output Descriptor to reflect
      // the new view
      MatOut.block().release(true);

      vsip::serialization::describe_user_storage(MatOut.block(), outputInfo);
      SNA::DataViewTranslator::cpp_to_idl(  outputInfo,
                                       dataOutDescriptor);

      // Release the input block as well - note that we don't care about
      // it's data from here on out, so we use the 'false' parameter
      MatIn.block().release(false);
   }

   void
   SPMathFacet__exec_i::cleanup()
   {
      LOG4CXX_INFO(boilerplate_.getLogger(), "cleanup()");
   }

   void
   SPMathFacet__exec_i::do_math(const vsip::Matrix<vsip::cscalar_f> & MatIn,
         vsip::Matrix<vsip::cscalar_f> & MatOut)
   {
      // just increment the input by (+10,-10)
      MatOut = MatIn + vsip::cscalar_f(10.f, -10.f);
   }

   /**
    * Component Executor Implementation Class: MKC_comp_exec_i
    */

   MKC_comp_exec_i::MKC_comp_exec_i() :
         boilerplate_("MKC_comp",
                      "SNA_Examples")
   {
   }

   MKC_comp_exec_i::~MKC_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   MKC_comp_exec_i::reactor()
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

   ::SNA_Examples::CCM_SP_Math_obj_ptr
   MKC_comp_exec_i::get_SPMathFacet_()
   {
      if (::CORBA::is_nil(this->ciao_SPMathFacet__.in()))
      {
         SPMathFacet__exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            SPMathFacet__exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_SP_Math_obj::_nil());

         this->ciao_SPMathFacet__ = tmp;
      }

      return
         ::SNA_Examples::CCM_SP_Math_obj::_duplicate(
            this->ciao_SPMathFacet__.in());
   }

   // Operations from Components::SessionComponent.

   void
   MKC_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_MKC_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void
   MKC_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      /* Your code here. */
   }

   void
   MKC_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      /* Your code here. */
   }

   void
   MKC_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      /* Your code here. */
   }

   void
   MKC_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   extern "C"
   SNA_EXAMPLES_MKC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_MKC_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         MKC_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================

