//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 - 2011 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup WeatherStation_comp
/// @{
/// @file   SNA_Examples_WeatherStation_comp_exec.cpp
/// @brief  Implementation of executor classes for the WeatherStation_comp
///         component and its facets.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_Examples_WeatherStation_comp_exec.h"

#include "SNA_Tracer.h"
#include "tao/ORB_Core.h"
#include "ace/Reactor.h"

namespace CIAO_SNA_Examples_WeatherStation_comp_Impl
{

   /**
    * Facet Executor Implementation Class: temperatureReadingSub_data_listener_exec_i
    */

   temperatureReadingSub_data_listener_exec_i::
   temperatureReadingSub_data_listener_exec_i(
      ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_WeatherStation_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   temperatureReadingSub_data_listener_exec_i::
   ~temperatureReadingSub_data_listener_exec_i()
   {
   }

   // Operations from ::SNA_Examples::TemperatureReading_conn::StateListener

   void temperatureReadingSub_data_listener_exec_i::on_creation(
      const ::SNA_Examples::TemperatureReading_msg & datum,
      const ::CCM_DDS::ReadInfo & /* info */)
   {
      LOG4CXX_INFO(boilerplate_.getLogger(),
                   "Sensor with ID = " << datum.sensorId << " has started up");
   }

   void temperatureReadingSub_data_listener_exec_i::on_one_update(
      const ::SNA_Examples::TemperatureReading_msg & datum,
      const ::CCM_DDS::ReadInfo & /* info */)
   {
      LOG4CXX_INFO(boilerplate_.getLogger(),
         "Received updated reading from sensor with ID = " << datum.sensorId);

      // EXAMPLE: Use the "getCompExecPtr()" to share state between the
      // component executer and the data listener executer.
      boilerplate_.getCompExecPtr()->setTemperatureReading(datum.temperature);
   }

   void temperatureReadingSub_data_listener_exec_i::on_many_updates(
      const ::SNA_Examples::TemperatureReading_msgSeq & /* data */,
      const ::CCM_DDS::ReadInfoSeq & /* infos */)
   {
   }

   void temperatureReadingSub_data_listener_exec_i::on_deletion(
      const ::SNA_Examples::TemperatureReading_msg & datum,
      const ::CCM_DDS::ReadInfo & /* info */)
   {
      LOG4CXX_INFO(boilerplate_.getLogger(),
                   "Sensor with ID = " << datum.sensorId << " has shut down");
   }

   /**
    * Facet Executor Implementation Class: temperatureReadingSub_status_exec_i
    */

   temperatureReadingSub_status_exec_i::temperatureReadingSub_status_exec_i(
      ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_WeatherStation_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   temperatureReadingSub_status_exec_i::~temperatureReadingSub_status_exec_i()
   {
   }

   // Operations from ::CCM_DDS::PortStatusListener

   void temperatureReadingSub_status_exec_i::on_requested_deadline_missed(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::RequestedDeadlineMissedStatus & /* status */)
   {
   }

   void temperatureReadingSub_status_exec_i::on_sample_lost(
      ::DDS::DataReader_ptr /* the_reader */,
      const ::DDS::SampleLostStatus & /* status */)
   {
   }

   /**
    * Facet Executor Implementation Class: temperatureReadingConnStatus_exec_i
    */

   temperatureReadingConnStatus_exec_i::temperatureReadingConnStatus_exec_i(
      ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_WeatherStation_comp_Context::_duplicate(ctx)),
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
    * Facet Executor Implementation Class: weatherInformationFacet_exec_i
    */

   weatherInformationFacet_exec_i::weatherInformationFacet_exec_i(
      ::SNA_Examples::CCM_WeatherStation_comp_Context_ptr ctx,
      SNA_CompBoilerplate_t & boilerplate) :
         ciao_context_(
            ::SNA_Examples::CCM_WeatherStation_comp_Context::_duplicate(ctx)),
         boilerplate_(boilerplate)
   {
   }

   weatherInformationFacet_exec_i::~weatherInformationFacet_exec_i()
   {
   }

   // Operations from ::SNA_Examples::WeatherInformation_obj

   ::CORBA::Boolean weatherInformationFacet_exec_i::getWeatherInformation(
      ::SNA_Examples::WeatherInformation_out info)
   {
      // EXAMPLE: Use the "getCompExecPtr()" to share state between the
      // component executer and the data listener executer.
      bool valid1 = boilerplate_.getCompExecPtr()->getLastTemperatureReading(
         info.lastTemperature);

      bool valid2 =
         boilerplate_.getCompExecPtr()->getAverageTemperatureReading(
            info.averageTemperature);

      return (valid1 && valid2);
   }

   /**
    * Component Executor Implementation Class: WeatherStation_comp_exec_i
    */

   WeatherStation_comp_exec_i::WeatherStation_comp_exec_i() :
      boilerplate_("WeatherStation_comp", "SNA_Examples")
   {
      lastHundredReadings_.reserve(100);
   }

   WeatherStation_comp_exec_i::~WeatherStation_comp_exec_i()
   {
   }

   // Supported operations and attributes.
   ACE_Reactor*
   WeatherStation_comp_exec_i::reactor()
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

   ::SNA_Examples::TemperatureReading_conn::CCM_StateListener_ptr
   WeatherStation_comp_exec_i::get_temperatureReadingSub_data_listener()
   {
      if (::CORBA::is_nil(this->ciao_temperatureReadingSub_data_listener_.in()))
      {
         temperatureReadingSub_data_listener_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            temperatureReadingSub_data_listener_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::TemperatureReading_conn::CCM_StateListener::_nil());

         this->ciao_temperatureReadingSub_data_listener_ = tmp;
      }

      return ::SNA_Examples::TemperatureReading_conn::CCM_StateListener::_duplicate(
         this->ciao_temperatureReadingSub_data_listener_.in());
   }

   ::CCM_DDS::CCM_PortStatusListener_ptr
   WeatherStation_comp_exec_i::get_temperatureReadingSub_status()
   {
      if (::CORBA::is_nil(this->ciao_temperatureReadingSub_status_.in()))
      {
         temperatureReadingSub_status_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            temperatureReadingSub_status_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::CCM_DDS::CCM_PortStatusListener::_nil());

         this->ciao_temperatureReadingSub_status_ = tmp;
      }

      return ::CCM_DDS::CCM_PortStatusListener::_duplicate(
         this->ciao_temperatureReadingSub_status_.in());
   }

   ::CCM_DDS::CCM_ConnectorStatusListener_ptr
   WeatherStation_comp_exec_i::get_temperatureReadingConnStatus()
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

   ::SNA_Examples::CCM_WeatherInformation_obj_ptr
   WeatherStation_comp_exec_i::get_weatherInformationFacet()
   {
      if (::CORBA::is_nil(this->ciao_weatherInformationFacet_.in()))
      {
         weatherInformationFacet_exec_i * tmp = 0;
         ACE_NEW_RETURN(
            tmp,
            weatherInformationFacet_exec_i(
               this->ciao_context_.in(),
               this->boilerplate_),
            ::SNA_Examples::CCM_WeatherInformation_obj::_nil());

         this->ciao_weatherInformationFacet_ = tmp;
      }

      return ::SNA_Examples::CCM_WeatherInformation_obj::_duplicate(
         this->ciao_weatherInformationFacet_.in());
   }

   // Operations from Components::SessionComponent.

   void WeatherStation_comp_exec_i::set_session_context(
      ::Components::SessionContext_ptr ctx)
   {
      this->ciao_context_
         = ::SNA_Examples::CCM_WeatherStation_comp_Context::_narrow(ctx);

      if (::CORBA::is_nil(this->ciao_context_.in()))
      {
         throw ::CORBA::INTERNAL();
      }

      boilerplate_.set_session_context(this->ciao_context_.in(), this);
   }

   void WeatherStation_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "configuration_complete");

      boilerplate_.configuration_complete();
   }

   void WeatherStation_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_activate");

      boilerplate_.ccm_activate();

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: All code in this method below this is hand-written.
      //////////////////////////////////////////////////////////////////////////

      // EXAMPLE: Gets a reference to the listener control interface for the
      //          temperatureReadingSub DDS4CCM listen port. This is usually
      //          needed by all components which have listen ports as by
      //          default the data listener mode is set to NOT_ENABLED so NO
      //          data will be received.
      //
      //          This listener mode can be changed at any time but is usually
      //          set in ccm_activate.
      CCM_DDS::DataListenerControl_var listenerCtrl =
         ciao_context_->get_connection_temperatureReadingSub_data_control();

      if ( ! CORBA::is_nil(listenerCtrl.in()))
      {
         // EXAMPLE: Setting the listener mode to ONE_BY_ONE meaning the
         //          on_one_data callback is called for every sample received.
         //
         //          This setting is the recommended one as it is faster than
         //          MANY_BY_MANY (which calls the on_many_data callback with a
         //          sequences of samples) as the MANY_BY_MANY mode is harder to
         //          use and has data copies due to differences between CCM and
         //          DDS sequence types.
         try
         {
            listenerCtrl->mode(CCM_DDS::ONE_BY_ONE);
         }
         catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex);
         }
      }
      else
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a data
         //          listener.
         boilerplate_.failed_state_change(
               "The listener control receptacle is null");
      }
   }

   void WeatherStation_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_passivate");

      boilerplate_.ccm_passivate();
   }

   void WeatherStation_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(boilerplate_.getLogger(), "ccm_remove");

      boilerplate_.ccm_remove();
   }

   // EXAMPLE:
   // Getter / Setter methods for shared state between the port execs and
   // the component exec.

   void WeatherStation_comp_exec_i::setTemperatureReading(
      const double & reading)
   {
      LOG4CXX_INFO(boilerplate_.getLogger(),
         "Got temperature reading from sensor : " << reading);

      if (lastHundredReadings_.size() >= 100)
      {
         lastHundredReadings_.erase(lastHundredReadings_.begin());
      }

      lastHundredReadings_.push_back(reading);
   }

   bool WeatherStation_comp_exec_i::getLastTemperatureReading(
      double & reading)
   {
      if( ! lastHundredReadings_.empty())
      {
         reading = lastHundredReadings_.back();

         return true;
      }
      else
      {
         return false;
      }
   }

   bool WeatherStation_comp_exec_i::getAverageTemperatureReading(
      double & reading)
   {
      // EXAMPLE: Calculates the average temperature
      if ( ! lastHundredReadings_.empty())
      {
         double sum = 0;
         for (unsigned int i = 0; i < lastHundredReadings_.size(); ++i)
         {
            sum += lastHundredReadings_[i];
         }

         reading = sum / lastHundredReadings_.size();

         return true;
      }
      else
      {
         return false;
      }
   }

   extern "C" SNA_EXAMPLES_WEATHERSTATION_COMP_EXEC_Export
   ::Components::EnterpriseComponent_ptr
   create_SNA_Examples_WeatherStation_comp_Impl()
   {
      ::Components::EnterpriseComponent_ptr retval =
         ::Components::EnterpriseComponent::_nil();

      ACE_NEW_NORETURN(
         retval,
         WeatherStation_comp_exec_i);

      return retval;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
