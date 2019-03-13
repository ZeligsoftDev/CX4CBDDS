//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 - 2011 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup WeatherStation_comp
/// @{
/// @file   SNA_Examples_WeatherStation_comp_exec.h
/// @brief  Definition of executor classes for the WeatherStation_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#ifndef CIAO_BS_SNA_EXAMPLES_WEATHERSTATION_COMP_EXEC_LMQN4K_H_
#define CIAO_BS_SNA_EXAMPLES_WEATHERSTATION_COMP_EXEC_LMQN4K_H_

#include /**/ "ace/pre.h"

#include "SNA_Examples_WeatherStation_compEC.h"

#if !defined (ACE_LACKS_PRAGMA_ONCE)
# pragma once
#endif /* ACE_LACKS_PRAGMA_ONCE */

#include /**/ "SNA_Examples_WeatherStation_comp_exec_export.h"
#include "tao/LocalObject.h"

#include "SNA_TypedCompBoilerplate.h"

// EXAMPLE: Added to store past readings
#include <vector>

/// Auto-generated namespace for SNA_Examples_WeatherStation_comp
namespace CIAO_SNA_Examples_WeatherStation_comp_Impl
{
   /// Forward declaration of component executor class
   class WeatherStation_comp_exec_i;

   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
      ::SNA_Examples::CCM_WeatherStation_comp_Context,
      WeatherStation_comp_exec_i> SNA_CompBoilerplate_t;

   /**
    * Provider Executor Implementation Class: temperatureReadingSub_data_listener_exec_i
    */

   class temperatureReadingSub_data_listener_exec_i :
      public virtual ::SNA_Examples::TemperatureReading_conn::CCM_StateListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      temperatureReadingSub_data_listener_exec_i(
         ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~temperatureReadingSub_data_listener_exec_i();

      /** @name Operations and attributes from SNA_Examples::TemperatureReading_conn::StateListener */
      //@{

      virtual
      void on_creation(
         const ::SNA_Examples::TemperatureReading_msg & datum,
         const ::CCM_DDS::ReadInfo & info);

      virtual
      void on_one_update(
         const ::SNA_Examples::TemperatureReading_msg & datum,
         const ::CCM_DDS::ReadInfo & info);

      virtual
      void on_many_updates(
         const ::SNA_Examples::TemperatureReading_msgSeq & data,
         const ::CCM_DDS::ReadInfoSeq & infos);

      virtual
      void on_deletion(
         const ::SNA_Examples::TemperatureReading_msg & datum,
         const ::CCM_DDS::ReadInfo & info);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_WeatherStation_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: temperatureReadingSub_status_exec_i
    */

   class temperatureReadingSub_status_exec_i :
      public virtual ::CCM_DDS::CCM_PortStatusListener,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      temperatureReadingSub_status_exec_i(
         ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~temperatureReadingSub_status_exec_i();

      /** @name Operations and attributes from CCM_DDS::PortStatusListener */
      //@{

      virtual
      void on_requested_deadline_missed(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::RequestedDeadlineMissedStatus & status);

      virtual
      void on_sample_lost(
         ::DDS::DataReader_ptr the_reader,
         const ::DDS::SampleLostStatus & status);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_WeatherStation_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

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
         ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
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
      ::SNA_Examples::CCM_WeatherStation_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Provider Executor Implementation Class: weatherInformationFacet_exec_i
    */

   class weatherInformationFacet_exec_i :
      public virtual ::SNA_Examples::CCM_WeatherInformation_obj,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      weatherInformationFacet_exec_i(
         ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
         SNA_CompBoilerplate_t & boilerplate);

      /// Destructor
      virtual ~weatherInformationFacet_exec_i();

      /** @name Operations and attributes from SNA_Examples::WeatherInformation_obj */
      //@{

      virtual ::CORBA::Boolean getWeatherInformation(
         ::SNA_Examples::WeatherInformation_out info);
      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_WeatherStation_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;
   };

   /**
    * Component Executor Implementation Class: WeatherStation_comp_exec_i
    */

   class WeatherStation_comp_exec_i :
      public virtual WeatherStation_comp_Exec,
      public virtual ::CORBA::LocalObject
   {
   public:

      /// Constructor
      WeatherStation_comp_exec_i();

      /// Destructor
      virtual ~WeatherStation_comp_exec_i();

      /** @name Supported operations and attributes. */
      //@{

      //@}

      /** @name Component attributes and port operations. */
      //@{

      virtual ::SNA_Examples::TemperatureReading_conn::CCM_StateListener_ptr
      get_temperatureReadingSub_data_listener();

      virtual ::CCM_DDS::CCM_PortStatusListener_ptr
      get_temperatureReadingSub_status();

      virtual ::CCM_DDS::CCM_ConnectorStatusListener_ptr
      get_temperatureReadingConnStatus();

      virtual ::SNA_Examples::CCM_WeatherInformation_obj_ptr
      get_weatherInformationFacet();
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

      // EXAMPLE: Getter / Setter methods for shared state

      /**
       * Sets temperature reading
       * @param[in] reading new temperature reading
       */
      void setTemperatureReading(const double & reading);

      /**
       * Returns temperature reading
       * @param[out] reading last known temperature reading
       * @return true if successful, false otherwise
       */
      bool getLastTemperatureReading(double & reading);

      /**
       * Returns average temperature reading
       * @param[out] reading running average temperature reading
       * @return true if successful, false otherwise
       */
      bool getAverageTemperatureReading(double & reading);

      //@}

   private:

      /**
       * Context for component instance. Used for all middleware communication.
       */
      ::SNA_Examples::CCM_WeatherStation_comp_Context_var ciao_context_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t boilerplate_;

      /** @name Component attributes. */
      //@{
      ::SNA_Examples::TemperatureReading_conn::CCM_StateListener_var
         ciao_temperatureReadingSub_data_listener_;

      ::CCM_DDS::CCM_PortStatusListener_var ciao_temperatureReadingSub_status_;

      ::CCM_DDS::CCM_ConnectorStatusListener_var
         ciao_temperatureReadingConnStatus_;

      ::SNA_Examples::CCM_WeatherInformation_obj_var
         ciao_weatherInformationFacet_;
      //@}

      /** @name User defined members. */
      //@{

      /// shared state between the component and port executers
      std::vector<double> lastHundredReadings_;

      //@}

      /** @name User defined private operations. */
      //@{

      //@}

      /// Get the ACE_Reactor
      ACE_Reactor * reactor();
   };

   /// Factory method and library entry point used by the middleware
   extern "C" SNA_EXAMPLES_WEATHERSTATION_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_WeatherStation_comp_Impl();
}

#include /**/ "ace/post.h"

#endif /* ifndef */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
