//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 - 2011 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup TemperatureSensor_comp
/// @{
/// @file   SNA_Examples_TemperatureSensor_comp_exec.cpp
/// @brief  Implementation of executor classes for the TemperatureSensor_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_TemperatureSensor_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

// EXAMPLE: This include was added by hand in order to create a timer
#include "SNA_GeneralTimer.h"

namespace CIAO_SNA_Examples_TemperatureSensor_comp_Impl
{

   /**
    * Facet Executor Implementation Class: temperatureReadingConnStatus_exec_i
    */

   temperatureReadingConnStatus_exec_i::temperatureReadingConnStatus_exec_i(
      ::SNA_Examples::CCM_TemperatureSensor_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_TemperatureSensor_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   temperatureReadingConnStatus_exec_i::~temperatureReadingConnStatus_exec_i()
   {
   }

   // Operations from ::CCM_DDS::ConnectorStatusListener

   void temperatureReadingConnStatus_exec_i::on_inconsistent_topic(
      ::DDS::Topic_ptr /* the_topic */,
      const ::DDS::InconsistentTopicStatus & /* status */)
   {
   }

   void temperatureReadingConnStatus_exec_i::on_requested_incompatible_qos(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedIncompatibleQosStatus & /* status */)
   {
   }

   void temperatureReadingConnStatus_exec_i::on_sample_rejected(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleRejectedStatus & /* status */)
   {
   }

   void temperatureReadingConnStatus_exec_i::on_offered_deadline_missed(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedDeadlineMissedStatus & /* status */)
   {
   }

   void temperatureReadingConnStatus_exec_i::on_offered_incompatible_qos(
      ::DDS::DataWriter_ptr /* the_writer */,
      const ::DDS::OfferedIncompatibleQosStatus & /* status */)
   {
   }

   void temperatureReadingConnStatus_exec_i::on_unexpected_status(
      ::DDS::Entity_ptr /* the_entity */,
      ::DDS::StatusKind /* status_kind */)
   {
   }

   /**
    * Component Executor Implementation Class: TemperatureSensor_comp_exec_i
    */

   TemperatureSensor_comp_exec_i::TemperatureSensor_comp_exec_i() :
      boilerplate_("TemperatureSensor_comp", "SNA_Examples"),
      averageTemperature_(24.0),
      stdDeviation_(3),
      timerId_(-1),
      sensorId_(ACE_OS::rand() % 5)
   {
   }

   TemperatureSensor_comp_exec_i::~TemperatureSensor_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   TemperatureSensor_comp_exec_i::reactor()
   {
      ACE_Reactor * reactor = 0;
      ::CORBA::Object_var ccm_object = this->ciao_context_->get_CCM_object();

      if (!::CORBA::is_nil(ccm_object.in()))
      {
         ::CORBA::ORB_var orb = ccm_object->_get_orb();

         if (!::CORBA::is_nil(orb.in()))
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

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   TemperatureSensor_comp_exec_i::get_temperatureReadingConnStatus()
   {
      if (::CORBA::is_nil(this->ciao_temperatureReadingConnStatus_.in()))
      {
         temperatureReadingConnStatus_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            temperatureReadingConnStatus_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_ConnectorStatusListener::_nil());

         this->ciao_temperatureReadingConnStatus_ = tmp;
      }

      return ::CCM_DDS::CCM_ConnectorStatusListener::_duplicate(
         this->ciao_temperatureReadingConnStatus_.in());
   }

   ::CORBA::Double TemperatureSensor_comp_exec_i::averageTemperature()
   {
      return this->averageTemperature_;
   }

   void TemperatureSensor_comp_exec_i::averageTemperature(
      const ::CORBA::Double averageTemperature)
   {
      this->averageTemperature_ = averageTemperature;
   }

   ::CORBA::Long TemperatureSensor_comp_exec_i::stdDeviation()
   {
      return this->stdDeviation_;
   }

   void TemperatureSensor_comp_exec_i::stdDeviation(
      const ::CORBA::Long stdDeviation)
   {
      this->stdDeviation_ = stdDeviation;
   }

   // Operations from Components::SessionComponent.

   void TemperatureSensor_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_
         = ::SNA_Examples::CCM_TemperatureSensor_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void TemperatureSensor_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void TemperatureSensor_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      typedef SNA_GENERAL_TIMER_T(TemperatureSensor_comp_exec_i) TimerType;

      ACE_Event_Handler_var sendTimer =
         new TimerType(this,
                       &TemperatureSensor_comp_exec_i::sendTemperature,
                       boilerplate_.getLogger());

      ACE_Time_Value delay(5, 0);  // timer = 5 seconds + 0 usec = 5 sec
      ACE_Time_Value repeat(1, 0); // timer = 5 seconds + 0 usec = 5 sec

      timerId_ = timeManager_.schedule_timer(sendTimer.handler(),
                                             0,
                                             delay,
                                             repeat);

      if (timerId_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }

      // Reference to the updater interface to the DDS4CCM connector for the
      // SNA_Examples::TemperatureReading_msg type
      ::SNA_Examples::TemperatureReading_conn::Updater_var tempReadingUpdater =
            ciao_context_->get_connection_temperatureReadingPub_data();

      if (CORBA::is_nil(tempReadingUpdater.in()))
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("The updater receptacle is nil");
      }

      // EXAMPLE: Register new instance (value of key in message structure). In
      //          this example, the key is the sensor ID. When the registration
      //          occurs, active subscribers will get a callback on the
      //          on_creation method.
      try
      {
         // EXAMPLE: In this example, the creation is just be used to see if
         //          a sensor is up so just fill out the key since the actual
         //          reading won't be used.
         SNA_Examples::TemperatureReading_msg instanceToRegister;
         instanceToRegister.sensorId = sensorId_;

         // Register instance and save handle
         instanceHandle_ =
               tempReadingUpdater->register_instance(instanceToRegister);

         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Created new instance for sensor ID " << sensorId_);
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex);
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from register_instance call.");
      }
   }

   void TemperatureSensor_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_passivate");

      boilerplate_.ccm_passivate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      //          will also destroy the general timer class constructed in
      //          ccm_activate.
      timeManager_.cancel_timer(timerId_);

      // Reference to the updater interface to the DDS4CCM connector for the
      // SNA_Examples::TemperatureReading_msg type
      ::SNA_Examples::TemperatureReading_conn::Updater_var tempReadingUpdater =
            ciao_context_->get_connection_temperatureReadingPub_data();

      if (CORBA::is_nil(tempReadingUpdater.in()))
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("The updater receptacle is nil");
      }

      // EXAMPLE: Unregister instance (value of key in message structure). In
      //          this example, the key is the sensor ID. When the
      //          unregistration occurs, active subscribers will get a callback
      //          on the on_deletion method.
      try
      {
         // EXAMPLE: In this example, the deletion is just be used to see if
         //          a sensor has gone down so just fill out the key since the
         //          actual reading won't be used.
         SNA_Examples::TemperatureReading_msg instanceToUnregister;
         instanceToUnregister.sensorId = sensorId_;

         // Unregister/delete instance
         tempReadingUpdater->unregister_instance(instanceToUnregister,
                                                 instanceHandle_.in());

         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Unregistered instance for sensor ID " << sensorId_);
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex );
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
               "Caught unknown exception from unregister_instance call.");
      }
   }

   void TemperatureSensor_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_remove");

      boilerplate_.ccm_remove();
   }

   int
   TemperatureSensor_comp_exec_i::sendTemperature()
   {
      SNA_Examples::TemperatureReading_msg temperature;

      int lowest  = static_cast<int>(averageTemperature_ - stdDeviation_);
      int highest = static_cast<int>(averageTemperature_ + stdDeviation_);

      int temp = ACE_OS::rand() % (highest - lowest) + lowest;

      temperature.temperature = static_cast<double>(temp);
      temperature.sensorId    = sensorId_;

      LOG4CXX_INFO(boilerplate_.getLogger(),
         "Sensor " << sensorId_ << " Reads : " << temperature.temperature);

      // Reference to the updater interface to the DDS4CCM connector for the
      // SNA_Examples::TemperatureReading_msg type.
      // The Updater interface updates an already existing instance
      ::SNA_Examples::TemperatureReading_conn::Updater_var tempReadingUpdater =
            ciao_context_->get_connection_temperatureReadingPub_data();

      if (CORBA::is_nil(tempReadingUpdater.in()))
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "The updater receptacle is null");

         return -1; // Don't reschedule timer
      }

      try
      {
         // Updater interface has update_one instead of write one. This is also
         // passing in the instance handle from the register_instance call so
         // that the DDS middleware does not need to perform a lookup for which
         // instance to update.
         tempReadingUpdater->update_one(temperature, instanceHandle_.in());

         LOG4CXX_INFO(boilerplate_.getLogger(),
                      "Published temperature reading!");
      }
      catch (CCM_DDS::InternalError & ex) // catch "normal" exception
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught InternalError exception from update_one call. "
                       "Contained DDS error code is " << ex.error_code);

         return -1; // Don't reschedule timer
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex );
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from update_one call. ");

         return -1; // Don't reschedule timer
      }

      return 0;
   }

   extern "C" SNA_EXAMPLES_TEMPERATURESENSOR_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_TemperatureSensor_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         TemperatureSensor_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
