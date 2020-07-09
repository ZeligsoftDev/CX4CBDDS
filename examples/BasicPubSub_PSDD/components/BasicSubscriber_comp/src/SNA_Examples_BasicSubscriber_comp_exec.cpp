// Add file header between tags below
/* BEGIN TAG */
/* END TAG */

#include "SNA_Examples_BasicSubscriber_comp_exec.h"

#include "SNA_Tracer.h"

// Add includes between tags below
/* BEGIN TAG */
/* END TAG */

namespace SNA_Examples_BasicSubscriber_comp_Impl
{
SNA_WARN_UNUSED_PARAMS

   testDataSub_data_listener_exec_i::testDataSub_data_listener_exec_i(
      IDL::traits< ::SNA_Examples::CCM_BasicSubscriber_comp_Context>::ref_type ctx,
      SNA_CompBoilerplate_t & boilerplate) :
        context_(ctx),
          
         // Add initializer list items between tags below
         /* BEGIN TAG */
         boilerplate_(boilerplate)
         /* END TAG */

   {
      // Add constructor implementation between tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   testDataSub_data_listener_exec_i::~testDataSub_data_listener_exec_i()
   {
      // Add destructor implementation between tags below
      /* BEGIN TAG */
      /* END TAG */
   }

SNA_IGNORE_UNUSED_PARAMS

   void
   testDataSub_data_listener_exec_i::on_data(
      SNA_Examples::TestData_msgSeq& data)
   {
      // Add all code between begin and end tags below
      /* BEGIN TAG */
         // EXAMPLE: The is the data receive callback for the testDataSub DDS4CCM
      //          listen port. This method simply logs the content of the test
      //          data structure.
      for(SNA_Examples::TestData_msg msg : data)
      {
         LOG4CXX_INFO(boilerplate_.getLogger(),
                            "Event has been received with contents\n"
                            << "myInt32  = " << msg.myInt32()  << "\n"
                            << "myInt64  = " << msg.myInt64()  << "\n"
                            << "myDouble = " << msg.myDouble() << "\n"
                            << "myString = " << msg.myString() << "\n"
                            << "myState  = " << msg.myState()  << "\n"
                            << "myColor  = " << msg.myColor()  << "\n");   
      }
      
      /* END TAG */
   }

   CCM_PSDD::ListenerMode
   testDataSub_data_listener_exec_i::listen_mode()
   {
      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   void
   testDataSub_data_listener_exec_i::listen_mode(
      CCM_PSDD::ListenerMode listen_mode)
   {
      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   CCM_PSDD::DataCount_t
   testDataSub_data_listener_exec_i::max_data()
   {
      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   void
   testDataSub_data_listener_exec_i::max_data(
      CCM_PSDD::DataCount_t max_data)
   {
      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

SNA_WARN_UNUSED_PARAMS

   // Add public method implementations between tags below
   /* BEGIN TAG */
   /* END TAG */

   // Add private method implementations between tags below
   /* BEGIN TAG */
   /* END TAG */

SNA_WARN_UNUSED_PARAMS

   BasicSubscriber_comp_exec_i::BasicSubscriber_comp_exec_i() :
         // Add initializer list items between tags below
         /* BEGIN TAG */
         boilerplate_("BasicSubscriber_comp")
         /* END TAG */
   {
      // Add constructor implementation between tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   BasicSubscriber_comp_exec_i::~BasicSubscriber_comp_exec_i()
   {
      // Add destructor implementation between tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   IDL::traits<::SNA_Examples::TestData_conn::CCM_Listener >::ref_type
   BasicSubscriber_comp_exec_i::get_testDataSub_data_listener()
   {
      if (!this->testDataSub_data_listener_)
     {
        this->testDataSub_data_listener_ = taox11::CORBA::make_reference<testDataSub_data_listener_exec_i>(
              this->context_,this->boilerplate_);
     }
     return this->testDataSub_data_listener_;
   }

   void
   BasicSubscriber_comp_exec_i::set_session_context(
      IDL::traits<Components::SessionContext>::ref_type ctx)
   {
      this->context_ = 
          IDL::traits<:: SNA_Examples::CCM_BasicSubscriber_comp_Context >::narrow (ctx);

      this->boilerplate_.set_session_context(this->context_, this);
      
   }

   void
   BasicSubscriber_comp_exec_i::configuration_complete()
   {
      SNA::Tracer tracer(
         this->boilerplate_.getLogger(), "configuration_complete");
      boilerplate_.configuration_complete();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   void
   BasicSubscriber_comp_exec_i::ccm_activate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_activate");
      boilerplate_.ccm_activate();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      // EXAMPLE: Gets a reference to the listener control interface for the
      //          testdataSub DDS4CCM listen port. This is usually needed by
      //          all components which have listen ports as by default the
      //          data listener mode is set to NOT_ENABLED so NO data will be
      //          received.
      //
      //          This listener mode can be changed at any time but is usually
      //          set in ccm_activate.
      IDL::traits< SNA_Examples::TestData_conn::Subscriber>::ref_type subCtrl =
      context_->get_connection_testDataSub_data_subscriber();

      if (subCtrl != nullptr)
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
            
            subCtrl->subscribe_any();
         }
         catch (const CORBA::Exception & ex)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(), "CORBA Exception: " << ex.what());
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
      /* END TAG */
   }

   void
   BasicSubscriber_comp_exec_i::ccm_passivate()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_passivate");
      boilerplate_.ccm_passivate();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   void
   BasicSubscriber_comp_exec_i::ccm_remove()
   {
      SNA::Tracer tracer(this->boilerplate_.getLogger(), "ccm_remove");
      boilerplate_.ccm_remove();

      // Add all code between begin and end tags below
      /* BEGIN TAG */
      /* END TAG */
   }

   ACE_Reactor *
   BasicSubscriber_comp_exec_i::reactor()
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
   /* END TAG */

   // Add private method implementations between tags below
   /* BEGIN TAG */
   /* END TAG */

 extern "C" void
   create_SNA_Examples_BasicSubscriber_comp_Impl(
      IDL::traits<Components::EnterpriseComponent>::ref_type& component)
   {
    component = taox11::CORBA::make_reference <BasicSubscriber_comp_exec_i> ();
   }
   

}

// Add file footer between tags below
/* BEGIN TAG */
/* END TAG */
