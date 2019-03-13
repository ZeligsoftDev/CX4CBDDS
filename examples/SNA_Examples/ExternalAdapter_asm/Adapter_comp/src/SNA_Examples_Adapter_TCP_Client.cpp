//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Adapter_comp
/// @{
/// @file   SNA_Examples_Adapter_TCP_Client.cpp
/// @brief  Implementation of Adapter_TCP_Client class
//==============================================================================
#include "SNA_Examples_Adapter_TCP_Client.h"
#include "SNA_ConfigParams.h"

namespace SNA_Examples
{
   //Constructor
   Adapter_TCP_Client::Adapter_TCP_Client(
         SNA_CompBoilerplate_t    & boilerplate,
         std::string                configFile,
         ACE_Reactor              & reactor) :

         connected_(false),
         aIpEventHandler_(0),
         boilerplate_(boilerplate),
         reactor_(reactor)
   {
      SNA::ConfigParams hostPortCfg;
      if (hostPortCfg.init(configFile))
      {
         hostPortCfg.lookupValue("HardwareEmulator_bin.host", host_);
         hostPortCfg.lookupValue("HardwareEmulator_bin.port", port_);
      }
      else
      {
         LOG4CXX_WARN(boilerplate_.getLogger(),
                      "Error in lookup of HardwareEmulator_bin socket host "
                      "information. Using host " << host_ <<
                      " and default port " << port_);
      }
   }

   //Destructor
   Adapter_TCP_Client::~Adapter_TCP_Client()
   {

      if ( aIpEventHandler_ )
      {
         reactor_.remove_handler(
                aIpEventHandler_,
                ACE_Event_Handler::READ_MASK);
         delete(aIpEventHandler_);
      }
   }

   int Adapter_TCP_Client::connect()
   {
      if ( ! connected_)
      {
         // create the TCP socket connection

         ACE_INET_Addr      srvr;      // contains address information
         ACE_SOCK_Connector connector; // connects socket endpoints

         srvr.set(port_, host_.c_str());

         if (connector.connect(peer_, srvr) == -1)
         {
            LOG4CXX_ERROR(boilerplate_.getLogger(),
                  "SNA Server failed to accept");
         }
         else
         {
            //External event handler object is registered to the adapter
            //component's reactor.
            aIpEventHandler_ = new
                        ::SNA_Examples::AdapterIPEventHandler(
                        boilerplate_.getContext(),
                        boilerplate_.getLoggerNamePrefix(), peer_);

            reactor_.register_handler
                        (aIpEventHandler_,ACE_Event_Handler::READ_MASK);

            connected_ = true;

            // write a message with the number of read bytes
            peer_.send_n("Hello", 6);

            // Do not reschedule timer
            return -1;
         }
      }

      // Reschedule timer to try connecting again
      return 0;
   }
}
/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
