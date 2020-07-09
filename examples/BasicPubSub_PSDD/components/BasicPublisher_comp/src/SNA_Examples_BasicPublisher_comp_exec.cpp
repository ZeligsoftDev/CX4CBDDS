// Add file header between tags below
/* BEGIN TAG */
/* END TAG */

#include "SNA_Examples_BasicPublisher_comp_exec.h"

#include "SNA_Tracer.h"

// Add includes between tags below
/* BEGIN TAG */
#include "ace/Event_Handler_T.h"
#include "SNA_ConfigParams.h"
/* END TAG */

namespace SNA_Examples_BasicPublisher_comp_Impl
{

SNA_WARN_UNUSED_PARAMS

   BasicPublisher_comp_exec_i::BasicPublisher_comp_exec_i() :
         // Add initializer list items between tags below
         /* BEGIN TAG */
         boilerplate_("BasicPublisher_comp"),
         timerId_(-1),
         numSamplesToPublishEachTime_(1),
         sendTimer_(this,0)
         /* END TAG */
   {
      // Add constructor implementation between tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   BasicPublisher_comp_exec_i::~BasicPublisher_comp_exec_i()
   {
      // Add destructor implementation between tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   std::string
   BasicPublisher_comp_exec_i::BasicPublisher_config()
   {
      return this->BasicPublisher_config_;
   }

   void
   BasicPublisher_comp_exec_i::BasicPublisher_config(
      const std::string& BasicPublisher_config)
   {
      this->BasicPublisher_config_ = BasicPublisher_config;
   }

   void
   BasicPublisher_comp_exec_i::set_session_context(
      IDL::traits<Components::SessionContext>::ref_type ctx)
   {
      this->context_ = 
          IDL::traits<:: SNA_Examples::CCM_BasicPublisher_comp_Context >::narrow (ctx);

      this->boilerplate_.set_session_context(this->context_, this);
      
   }

   void
   BasicPublisher_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(
         this->boilerplate_.getLogger(), "configuration_complete");
      boilerplate_.configuration_complete();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   void
   BasicPublisher_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_activate");
      boilerplate_.ccm_activate();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      // EXAMPLE: There is a configuration file that was created just for this
      //          basic publisher component.  We want to read from it the number
      //          of samples to publish each time the timer we are also setting
      //          below fires off.
      SNA::ConfigParams basicPubParams;

      // EXAMPLE: log4cxx statements contained in the SNA::ConfigParams class
      //          should contain a log4cxx prefix which is consistent with the
      //          object hierarchy. This will allow users to determine where
      //          each log statement originates from.
      basicPubParams.setLoggerNamePrefix(boilerplate_.getLoggerNameFull());

      if(BasicPublisher_config_.empty())
      {
         boilerplate_.failed_state_change("BasicPublisher expected "
               "configuration file, none received.");
      }

      if (basicPubParams.init(BasicPublisher_config_))
      {
         basicPubParams.lookupValue(
            "BasicPublisher.numSamplesToPublishEachTime",
            numSamplesToPublishEachTime_);
      }

      //////////////////////////////////////////////////////////////////////////
      // EXAMPLE: Hand written code to setup an ACE Timer
      //////////////////////////////////////////////////////////////////////////

      /*
       * Schedule a timer using ACE_Event_Handler_T
       */
      sendTimer_.to_handler(&BasicPublisher_comp_exec_i::sendSample);
      
      ACE_Time_Value delay(5, 0);  // timer = 5 seconds + 0 usec = 5 sec
      ACE_Time_Value repeat(5, 0); // timer = 5 seconds + 0 usec = 5 sec
      /*
      timerId_ = this->reactor()->schedule_timer(&sendTimer_,
                                             0,
                                             delay,
                                             repeat);
   
      */
      timerId_ = timeManager_.schedule_timer(this->reactor(), &sendTimer_,
                                             0,
                                             delay,
                                             repeat);
      
      
      if (timerId_ < 0)
      {
         // EXAMPLE: This call causes the component to fail, logs it, and
         //          notifies DAnCE as it cannot do its job without a timer.
         boilerplate_.failed_state_change("Could not schedule startup timer");
      }
      /* END TAG */
   }

   void
   BasicPublisher_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_passivate");
      boilerplate_.ccm_passivate();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      // EXAMPLE: This will cancel the event timer through the ACE reactor. This
      //          will also destroy the general timer class constructed in
      //          ccm_activate.
      timeManager_.cancel_timer(this->reactor(), timerId_);
      /* END TAG */
   }

   void
   BasicPublisher_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_remove");
      boilerplate_.ccm_remove();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   ACE_Reactor *
   BasicPublisher_comp_exec_i::reactor()
   {
     IDL::traits<taox11::CORBA::Object>::ref_type orb_object =
      this->context_->the_service_registry()->resolve_service (
        CIAOX11::SVCID_ORB);
    IDL::traits<taox11::CORBA::ORB>::ref_type orb =
      IDL::traits<taox11::CORBA::ORB>::narrow (orb_object);
    return orb->reactor ();
   }

   // Add public method implementations between tags below
   /* BEGIN TAG */
   int
   BasicPublisher_comp_exec_i::sendSample(const ACE_Time_Value &, const void *)
   {
      // EXAMPLE: This is the generated C++ structure given by the IDL
      //          definition from the ports directory. This structure has no
      //          meaning and is shown only for example. The fields of this
      //          structure provide examples of using the various IDL to C++
      //          data types.
      SNA_Examples::TestData_msg sample;

      sample.myInt32(10);
      sample.myInt64(5824169525);
      sample.myDouble(3.5);
      sample.myString("Hello, World!");
      sample.myState(SNA_Examples::State::STATE_PASS);
      sample.myColor(SNA_Examples::Color::COLOR_RED);

      /**
       * Reference to the writer interface to the DDS4CCM connector for the
       * SNA_Examples::TestData type
       */
      SNA_Examples::TestData_conn::Publisher::_ref_type testDataPubWriter;

      testDataPubWriter = context_->get_connection_testDataPub_data();

      if (testDataPubWriter == nullptr)
      {
         LOG4CXX_FATAL(boilerplate_.getLogger(),
                       "The writer receptacle is null");

         return -1; // Don't reschedule timer
      }

      // EXAMPLE: This will write the sample constructed above for the number of
      //          times previously configured in the ccm_activate method. The
      //          testDataPubWriter is a data member created by hand above.
      try
      {
         for (unsigned int cnt = 0; cnt < numSamplesToPublishEachTime_; ++cnt)
         {
            testDataPubWriter->write_one(sample);
         }
      }
      catch (CCM_DDS::InternalError & ex) // catch "normal" exception
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught InternalError exception from write_one call. "
                       "Contained DDS error code is "
                       << translate_retcode(ex.error_code()));

         return -1; // Don't reschedule timer
      }
      catch (const CORBA::Exception & ex)
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught CORBA Exception: " << ex.what());

         return -1; // Don't reschedule timer
      }
      catch (...) // catch everything else. If this is called something is wrong
      {
         LOG4CXX_ERROR(boilerplate_.getLogger(),
                       "Caught unknown exception from write_one call.");

         return -1; // Don't reschedule timer
      }

      // EXAMPLE: Logs a message displaying the number of samples that were sent
      LOG4CXX_INFO(boilerplate_.getLogger(),
                   "Sent "<< numSamplesToPublishEachTime_ << " test sample(s)");

      return 0;
   }
   /* END TAG */

   // Add private method implementations between tags below
   /* BEGIN TAG */
   /* END TAG */

 extern "C" void
   create_SNA_Examples_BasicPublisher_comp_Impl(
      IDL::traits<Components::EnterpriseComponent>::ref_type& component)
   {
    component = taox11::CORBA::make_reference <BasicPublisher_comp_exec_i> ();
   }
   

}

// Add file footer between tags below
/* BEGIN TAG */
/* END TAG */
