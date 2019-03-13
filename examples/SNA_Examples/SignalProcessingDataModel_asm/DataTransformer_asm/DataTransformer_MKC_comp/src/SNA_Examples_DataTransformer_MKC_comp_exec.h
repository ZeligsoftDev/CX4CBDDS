//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataTransformer_MKC_comp
/// @{
/// @file   SNA_Examples_DataTransformer_MKC_comp_exec.h
/// @brief  Definition of executor classes for the DataTransformer_MKC_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_DATATRANSFORMER_MKC_COMP_EXEC_QHBU8W_H_
#define CIAO_BS_SNA_EXAMPLES_DATATRANSFORMER_MKC_COMP_EXEC_QHBU8W_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_DataTransformer_MKC_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_DataTransformer_MKC_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

#include <vsip/matrix.hpp>

/// Auto-generated namespace for SNA_Examples_DataTransformer_MKC_comp
namespace CIAO_SNA_Examples_DataTransformer_MKC_comp_Impl
{
   /// Forward declaration of component executor class
   class DataTransformer_MKC_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context,
      DataTransformer_MKC_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: mathRecept_exec_i
    */

   class mathRecept_exec_i
      : public virtual ::SNA_Examples::CCM_DataTransformerMath_obj,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      mathRecept_exec_i(
         ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~mathRecept_exec_i();

      //@{
      /** Operations and attributes from ::SNA_Examples::DataTransformerMath_obj. */

      virtual
      void init();

      virtual
      void compute(const ::SNA::SP_DataHdr   & dataInDescriptor,
                   const ::SNA::ByteSequence & dataInReal,
                   ::SNA::ByteSequence       & dataOutReal);

      virtual
      void cleanup();
      //@}

      /**
       * Prints a VSIPL++ matrix to log4cxx
       *
       * @param[in] msg - Custom message to add to the beginning of the print.
       * @param[in] data - the matrix to print
       */
      void printMatrix(const std::string &msg,const vsip::Matrix<int>& data);
   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;

      /**
       * Count of how many samples (messages) have been received.
       */
      int                     recvMsgCount_;
   };

   /**
    * Component Executor Implementation Class: DataTransformer_MKC_comp_exec_i
    */

   class DataTransformer_MKC_comp_exec_i
      : public virtual DataTransformer_MKC_comp_Exec,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      DataTransformer_MKC_comp_exec_i();

      /// Destructor
      virtual ~DataTransformer_MKC_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::SNA_Examples::CCM_DataTransformerMath_obj_ptr
      get_mathRecept();
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
       * This method returns a boolean indication of whether or not to log
       * information about the current message.
       *
       * It works by applying the receive message logging modulo read from the
       * example's configuration file as a modulo on the msgCnt parameter such
       * that only every "nth" message will cause it to return true.  This is
       * to help control the flood of logging output when receiving messages
       * that have been sent close together in time.
       *
       * @param[in] msgCnt - count of how many messages have been received so
       *                     far.
       *
       * @return Boolean indication of whether it is okay to log the current
       *         message or not.
       */
      bool isOkayToLogMsg(int msgCnt);

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataTransformer_MKC_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::SNA_Examples::CCM_DataTransformerMath_obj_var ciao_mathRecept_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      /**
       * In order to control the flood of logging output when receiving messages
       * that have been sent close together in time, this value will be applied
       * using the modulo operator and only every "nth" message received will be
       * logged.
       *
       * i.e., if ((msgCnt % receiveMsgLoggingModulo_) == 1)
       */
      unsigned int  receiveMsgLoggingModulo_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C"
   SNA_EXAMPLES_DATATRANSFORMER_MKC_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataTransformer_MKC_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
