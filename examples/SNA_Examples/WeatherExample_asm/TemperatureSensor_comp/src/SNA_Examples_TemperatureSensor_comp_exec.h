//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 - 2011 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup TemperatureSensor_comp
/// @{
/// @file   SNA_Examples_TemperatureSensor_comp_exec.h
/// @brief  Definition of executor classes for the TemperatureSensor_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_TEMPERATURESENSOR_COMP_EXEC_41ERE2_H_
#define CIAO_BS_SNA_EXAMPLES_TEMPERATURESENSOR_COMP_EXEC_41ERE2_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_TemperatureSensor_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_TemperatureSensor_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: This include was added by hand in order to use an SNA::TimerManager
//          to register a timer.
#include "SNA_TimeManager.h"

/// Auto-generated namespace for SNA_Examples_TemperatureSensor_comp
namespace CIAO_SNA_Examples_TemperatureSensor_comp_Impl
{
   /// Forward declaration of component executor class
   class TemperatureSensor_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_TemperatureSensor_comp_Context,
      TemperatureSensor_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: temperatureReadingConnStatus_exec_i
    */

   class temperatureReadingConnStatus_exec_i :
      public virtual ::CCM_DDS::CCM_ConnectorStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      temperatureReadingConnStatus_exec_i(
         ::SNA_Examples::CCM_TemperatureSensor_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~temperatureReadingConnStatus_exec_i();

      /** @name Operations and attributes from CCM_DDS::ConnectorStatusListener */
      //@{

      virtual
      void on_inconsistent_topic(
         ::DDS::Topic_ptr the_topic,
         const ::DDS::InconsistentTopicStatus & status);

      virtual
      void on_requested_incompatible_qos(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedIncompatibleQosStatus & status);

      virtual
      void on_sample_rejected(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleRejectedStatus & status);

      virtual
      void on_offered_deadline_missed(
         ::DDS::DataWriter_ptr the_writer,
         const ::DDS::OfferedDeadlineMissedStatus & status);

      virtual
      void on_offered_incompatible_qos(
         ::DDS::DataWriter_ptr the_writer,
         const ::DDS::OfferedIncompatibleQosStatus & status);

      virtual
      void on_unexpected_status(
         ::DDS::Entity_ptr the_entity,
         ::DDS::StatusKind status_kind);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_TemperatureSensor_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: TemperatureSensor_comp_exec_i
    */

   class TemperatureSensor_comp_exec_i :
      public virtual TemperatureSensor_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      TemperatureSensor_comp_exec_i();

      /// Destructor
      virtual ~TemperatureSensor_comp_exec_i();

      /** @name Supported operations and attributes. */
      //@{

      //@}

      /** @name Component attributes and port operations. */
      //@{

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_temperatureReadingConnStatus();

      virtual ::CORBA::Double averageTemperature();

      virtual void averageTemperature(::CORBA::Double averageTemperature);

      virtual ::CORBA::Long stdDeviation();

      virtual void stdDeviation(::CORBA::Long stdDeviation);
      //@}

      /** @name Operations from Components::SessionComponent. */
      //@{
      virtual void set_session_context(::Components::SessionContext_ptr ctx);
      virtual void configuration_complete();
      virtual void ccm_activate();
      virtual void ccm_passivate();
      virtual void ccm_remove();
      //@}

      /** @name User defined public operations. */
      //@{

      /**
       * Callback for the send timer.
       */
      int sendTemperature();

      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_TemperatureSensor_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      /** @name Component attributes. */
      //@{
      ::CCM_DDS::CCM_ConnectorStatusListener_var
         ciao_temperatureReadingConnStatus_;

      ::CORBA::Double averageTemperature_;

      ::CORBA::Long stdDeviation_;
      //@}

      /** @name User defined members. */
      //@{

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: The members in this class below this line were added by hand.
      //          The ones above were generated.
      //////////////////////////////////////////////////////////////////////////

      /**
       * Id given when registering the timer with the reactor
       */
      int timerId_;

      /**
       * Time Manager used to schedule send timer.
       */
      SNA::TimeManager timeManager_;

      /**
       * ID of this temperature sensor
       */
      int sensorId_;

      /**
       * DDS instance handle from register_instance call. This can be optionally
       * passed in to update_one, etc. so that the DDS middleware doesn't need
       * to perform a lookup of the instance on every write.
       */
      DDS::InstanceHandle_t_var instanceHandle_;

      //@}

      /** @name User defined private operations. */
      //@{

      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factory method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_TEMPERATURESENSOR_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_TemperatureSensor_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
