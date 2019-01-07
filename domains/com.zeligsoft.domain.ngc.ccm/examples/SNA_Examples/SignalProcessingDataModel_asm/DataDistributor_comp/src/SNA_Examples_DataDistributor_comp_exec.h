//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup DataDistributor_comp
/// @{
/// @file   SNA_Examples_DataDistributor_comp_exec.h
/// @brief  Definition of executor classes for the DataDistributor_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_DATADISTRIBUTOR_COMP_EXEC_91GM8Q_H_
#define CIAO_BS_SNA_EXAMPLES_DATADISTRIBUTOR_COMP_EXEC_91GM8Q_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_DataDistributor_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_DataDistributor_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

// EXAMPLE: This include file was added by hand in order to be able to use the
//          SNA extensions to the SNA Config Parameter Access API.
#include "SNA_ConfigParams.h"

//VSIPL++ headers
#include <vsip/initfin.hpp>
#include <vsip/math.hpp>

/// Auto-generated namespace for SNA_Examples_DataDistributor_comp
namespace CIAO_SNA_Examples_DataDistributor_comp_Impl
{
   /// Forward declaration of component executor class
   class DataDistributor_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_DataDistributor_comp_Context,
      DataDistributor_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: dataMapPub_status_exec_i
    */

   class dataMapPub_status_exec_i
      : public virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapPub_status_exec_i(
         ::SNA_Examples::CCM_DataDistributor_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapPub_status_exec_i();

      //@{
      /** Operations and attributes from ::CCM_PSAT::PSAT_Writer_Status_Listener. */

      virtual
      void on_buffer_available();

      virtual
      void on_buffer_wait_timeout();
      //@}

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataDistributor_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: dataMapPubConnStatus_exec_i
    */

   class dataMapPubConnStatus_exec_i
      : public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      dataMapPubConnStatus_exec_i(
         ::SNA_Examples::CCM_DataDistributor_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~dataMapPubConnStatus_exec_i();

      //@{
      /** Operations and attributes from ::CCM_DDS::ConnectorStatusListener. */

      virtual
      void on_inconsistent_topic(::DDS::Topic_ptr the_topic,
                                 const ::DDS::InconsistentTopicStatus & status);

      virtual
      void on_requested_incompatible_qos(::DDS::DataReader_ptr the_reader,
                                         const ::DDS::RequestedIncompatibleQosStatus & status);

      virtual
      void on_sample_rejected(::DDS::DataReader_ptr the_reader,
                              const ::DDS::SampleRejectedStatus & status);

      virtual
      void on_offered_deadline_missed(::DDS::DataWriter_ptr the_writer,
                                      const ::DDS::OfferedDeadlineMissedStatus & status);

      virtual
      void on_offered_incompatible_qos(::DDS::DataWriter_ptr the_writer,
                                       const ::DDS::OfferedIncompatibleQosStatus & status);

      virtual
      void on_unexpected_status(::DDS::Entity_ptr the_entity,
                                ::DDS::StatusKind status_kind);
      //@}

   private:
      
      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataDistributor_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: DataDistributor_comp_exec_i
    */

   class DataDistributor_comp_exec_i
      : public virtual DataDistributor_comp_Exec,
     public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      DataDistributor_comp_exec_i();

      /// Destructor
      virtual ~DataDistributor_comp_exec_i();

      //@{
      /** Component attributes and port operations. */

      virtual ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_ptr
      get_dataMapPub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_dataMapPubConnStatus();
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
       * It works by applying the send message logging modulo read from the
       * example's configuration file as a modulo on the msgCnt parameter such
       * that only every "nth" message will cause it to return true.  This is
       * to help control the flood of logging output when sending messages
       * close together in time.
       *
       * @param[in] msgCnt - count of how many messages have been sent so far.
       *
       * @return Boolean indication of whether it is okay to log the current
       *         message or not.
       */
      bool isOkayToLogMsg(int msgCnt);

      /**
       * This method will publish 4 sub-samples (making up one complete sample),
       * it is a callback registered with SNA_GENERAL_TIMER.
       *
       * @return -1 to cancel the timer, 0 to continue. The SNA_GENERAL_TIMER
       * expects one of these return codes. The timer will only be canceled if
       * an exception occurs.
       */
      int sendData();

      /**
       * This method starts a repeating timer that will invoke the sendData
       * method every time it fires.
       *
       * @param[in] delay  - This is the amount of time that needs to elapse
       *                     after setting the timer before it will fire off
       *                     for the first time.
       *
       * @return Boolean indication of whether it was successful in starting
       *         the timer.
       *           true:  Timer was started
       *           false: Timer could not be started.
       *
       * @par Note:
       *   The repeat time is fixed and cannot be set by the caller.
       */
      bool startSendTimer(const ACE_Time_Value & delay);

   private:

      /**
       * This function reads a time value in ACE_Time_Value format (separate
       * fields for secs and microsecs) from a configuration file
       *
       * @param[in] configTagName - string containing the path to the time
       *                            value in the config file.  Note: At this
       *                            path there should be sub-entries named
       *                            "secs" and "microsecs."
       * @param[in] configParams  - object used to parse the configuration file.
       * @param[out] timeValue    - actual time value read from the
       *                            configuration file.  If there were any
       *                            errors reading the value from the config
       *                            file, this parameter will not be changed.
       *
       * @return boolean indication of whether or not a value was successfully
       *         read from the configuration file.
       */
      bool read_config_ace_time_value(const std::string & configTagName,
                                      SNA::ConfigParams & configParams,
                                      ACE_Time_Value    & timeValue);

      // -----------------------------

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_DataDistributor_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      //@{
      /** Component attributes. */
      ::CCM_PSAT::CCM_PSAT_Writer_Status_Listener_var ciao_dataMapPub_status_;
      ::CCM_DDS::CCM_ConnectorStatusListener_var ciao_dataMapPubConnStatus_;
      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();

      /**
       * Send Data timer unique IDentifier number.
       */
      long             sendTimerId_;

      /**
       * Initial delay before the send Data timer fires.
       */
      ACE_Time_Value   sendTimerInitialDelay_;

      /**
       * The send Data timer is a repeating timer.  After the timer fires
       * for the first time, this is the delay between all subsequent firings.
       */
      ACE_Time_Value   sendTimerRepeat_;

      /**
       * In order to control the flood of logging output when sending messages
       * closely together, this value will be applied using the modulo operator
       * and only every "nth" complete sample sent will be logged.
       *
       * i.e., if ((msgCnt % sendDataLoggingModulo_) == 1)
       */
      unsigned int     sendDataLoggingModulo_;

      /**
       * Count of how many complete samples have been sent.
       */
      int              sendDataCount_;

      /**
       * Time Manager used to schedule send Data timer.
       */
      SNA::TimeManager timeManager_;

      /**
       * Used to initialize VSIPL++ library in the constructor
       */
      vsip::vsipl      lib_;
   };

   /// Factor method and library entry point used by the middleware
   extern "C"
   SNA_EXAMPLES_DATADISTRIBUTOR_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_DataDistributor_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
