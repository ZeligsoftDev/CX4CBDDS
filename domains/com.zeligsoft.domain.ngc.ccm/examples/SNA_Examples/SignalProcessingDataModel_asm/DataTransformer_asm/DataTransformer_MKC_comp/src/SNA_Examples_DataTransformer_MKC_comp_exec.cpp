//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataTransformer_MKC_comp
/// @{
/// @file   SNA_Examples_DataTransformer_MKC_comp_exec.cpp
/// @brief  Implementation of executor classes for the DataTransformer_MKC_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_DataTransformer_MKC_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This include file was added by hand in order to be able to use the
//          SNA extensions to the SNA Config Parameter Access API.
#include "SNA_ConfigParams.h"

#include "SNA_DataViewTranslator.h"

// Serialization API
#include <vsip/serialization.hpp>
#include <vsip/matrix.hpp>

namespace CIAO_SNA_Examples_DataTransformer_MKC_comp_Impl
{

   /**
    * Facet Executor Implementation Class: mathRecept_exec_i
    */

   mathRecept_exec_i::mathRecept_exec_i(
      ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate),
         recvMsgCount_(0)
   {
   }

   // --------------------------------------------------------------------------

   mathRecept_exec_i::~mathRecept_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Operations from ::SNA_Examples::DataTransformerMath_obj

   void
   mathRecept_exec_i::init()
   {
      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   mathRecept_exec_i::compute(
         const ::SNA::SP_DataHdr                & dataInDescriptor,
         const ::SNA::ByteSequence              & dataInReal,
         ::SNA::ByteSequence                    & dataOutReal)
   {
      recvMsgCount_++;

      bool okayToLog =
            this->boilerplate_.getCompExecPtr()->isOkayToLogMsg(recvMsgCount_);

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //             Reconstruct input data view from message
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      vsip::serialization::Descriptor dataDescription;

      // IDL -> C++ - get Descriptor from message
      SNA::DataViewTranslator::idl_to_cpp(dataInDescriptor, dataDescription);

      // IDL -> C++ - get data from message
      const int * const pDataSeqInReal =
            reinterpret_cast<const int *>(&dataInReal[0]);

      // Create an empty data block
      vsip::Dense<2, int> dataInBlock(vsip::Domain<2>(0,0),static_cast<int*>(0));

      // VSIPL++ View of the data
      vsip::Matrix<int> inputMatrix(dataInBlock);

      // Bind the data to the view
      bool valid =
           vsip::serialization::is_compatible<vsip::Dense<2, int> >(dataDescription);
      if (valid)
      {
         inputMatrix.block().rebind(const_cast<int *>(pDataSeqInReal),
                                      vsip::Domain<2>(dataDescription.size[0],
                                                      dataDescription.size[1]));

         inputMatrix.block().admit(true);
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << recvMsgCount_ << "] .. " <<
                       "Failed to bind input data in MKC!");
         return;
      }

      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      //             Reconstruct output data view from message
      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

      // IDL -> C++ - get data from message
      int * pDataSeqOutReal = reinterpret_cast<int *>(&dataOutReal[0]);

      // Create an empty data block
      vsip::Dense<2, int> dataOutBlock(vsip::Domain<2>(0,0),static_cast<int*>(0));

      // VSIPL++ View of the data
      vsip::Matrix<int> outputMatrix(dataOutBlock);

      // Bind the data to the view
      bool validOut =
          vsip::serialization::is_compatible<vsip::Dense<2, int> >(dataDescription);

      if (validOut)
      {
         outputMatrix.block().rebind(pDataSeqOutReal,
                                     vsip::Domain<2>(dataDescription.size[0],
                                                     dataDescription.size[1]));


         outputMatrix.block().admit(true);
      }
      else
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "MSG[" << recvMsgCount_ << "] .. " <<
                       "Failed to unmarshal output data in MKC!");
      }

      // ------------------

      // This MKC will simply scale the input by the scaleFactor.
      int scaleFactor = 10;

      if (okayToLog)
      {
         this->printMatrix("Matrix received from DataDistributor_comp:",
                           inputMatrix);

         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "MSG[" << recvMsgCount_ << "] .. " <<
                      "Scaling received matrix by " << scaleFactor);
      }

      outputMatrix = inputMatrix * scaleFactor;

      // Release the data from VSIPL++ and set the output Descriptor to reflect
      // the new view
      outputMatrix.block().release(true);

      // Release the input block as well - note that we don't care about
      // it's data from here on out, so we use the 'false' parameter
      inputMatrix.block().release(false);

   }

   // --------------------------------------------------------------------------

   void
   mathRecept_exec_i::cleanup()
   {
      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   mathRecept_exec_i::printMatrix(const std::string &msg,
                                  const vsip::Matrix<int>& data)
   {
      std::stringstream strm;
      strm.unsetf(ios::floatfield);

      std::string dashSep = "--------------------";

      strm << "MSG[" << recvMsgCount_ << "] .. " << std::endl;
      strm << dashSep << std::endl;
      strm << msg << std::endl;
      strm << dashSep << std::endl;

      for (unsigned int i = 0; i < data.size(0); ++i)
      {
         for (unsigned int j=0; j < data.size(1); ++j)
         {
            strm << setw(3) << data.get(i,j) << " ";
         }

         strm << std::endl;
      }

      strm << dashSep << std::endl;
      strm << std::endl;

      LOG4CXX_INFO(boilerplate_.getLogger(), strm.str());
      strm.str("");
   }

   // ==========================================================================
   // ==========================================================================
   // ==========================================================================

   /**
    * Component Executor Implementation Class: DataTransformer_MKC_comp_exec_i
    */

   DataTransformer_MKC_comp_exec_i::DataTransformer_MKC_comp_exec_i() :
         boilerplate_("DataTransformer_MKC_comp",
                      "SNA_Examples"),
         receiveMsgLoggingModulo_(1)
   {
   }

   // --------------------------------------------------------------------------

   DataTransformer_MKC_comp_exec_i::~DataTransformer_MKC_comp_exec_i()
   {
   }

   // --------------------------------------------------------------------------

   // Supported operations and attributes.
   ACE_Reactor*
   DataTransformer_MKC_comp_exec_i::reactor()
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

   // --------------------------------------------------------------------------

   // Component attributes and port operations.

   ::SNA_Examples::CCM_DataTransformerMath_obj_ptr
   DataTransformer_MKC_comp_exec_i::get_mathRecept()
   {
      if (::CORBA::is_nil(this->ciao_mathRecept_.in()))
      {
         mathRecept_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            mathRecept_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_DataTransformerMath_obj::_nil());

         this->ciao_mathRecept_ = tmp;
      }

      return
         ::SNA_Examples::CCM_DataTransformerMath_obj::_duplicate(
            this->ciao_mathRecept_.in());
   }

   // --------------------------------------------------------------------------

   // Operations from Components::SessionComponent.

   void
   DataTransformer_MKC_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_ =
         ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_MKC_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "configuration_complete");

      boilerplate_.configuration_complete();

      //////////////////////////////////////////////////////////////////////////
      // Handwritten code to read values from an example configuration file
      //////////////////////////////////////////////////////////////////////////

      SNA::ConfigParams spdm_example_cfg;
      const std::string SPDM_ExampleConfigFilename = "SPDM_Example.cfg";

      if ( spdm_example_cfg.init(SPDM_ExampleConfigFilename) )
      {
         spdm_example_cfg.lookupValue
            ("SPDM_Example.dataTransformer.receiveMsgLoggingModulo",
                  receiveMsgLoggingModulo_);
      }
      else
      {
         LOG4CXX_WARN(boilerplate_.getLogger(),
                      "Could not open config file '" <<
                      SPDM_ExampleConfigFilename <<
                      "' for the SPDM example.  Using defaults");
      }

      LOG4CXX_DEBUG(boilerplate_.getLogger(),
         "================== RUN PARAMETERS ==================\n" <<
         "receiveMsgLoggingModulo_  : Log every "         <<
            receiveMsgLoggingModulo_  << "th received message\n"   <<
         "====================================================");

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_MKC_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_activate");

      boilerplate_.ccm_activate();

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_MKC_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_passivate");

      boilerplate_.ccm_passivate();

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   void
   DataTransformer_MKC_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(),
                         "ccm_remove");

      boilerplate_.ccm_remove();

      /* Your code here. */
   }

   // --------------------------------------------------------------------------

   bool DataTransformer_MKC_comp_exec_i::isOkayToLogMsg(int msgCnt)
   {
      return ((msgCnt - 1) % receiveMsgLoggingModulo_) == 0;
   }

   // --------------------------------------------------------------------------

   extern "C"
   SNA_EXAMPLES_DATATRANSFORMER_MKC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataTransformer_MKC_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         DataTransformer_MKC_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
