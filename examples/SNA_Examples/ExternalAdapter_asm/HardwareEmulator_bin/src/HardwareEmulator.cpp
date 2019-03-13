//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup HardwareEmulator_bin
/// @{
/// @file   HardwareEmulator.cpp
/// @brief  Implementation of the HardwareEmulator which is used to interface
///         with the CCM system in the Adapter example. This is intended to be
///         an executable which the user starts before starting the CCM example.
///         The hardware emulator will perform the following steps:
///             1. Read the config file to find the host and port information.
///             2. Create the socket server with the specified host and port
///                information, wait/block for the incoming connection request
///                from the adapter component.
///             3. After establishing a connection, the emulator will block and
///                wait for a command to begin writing data events.
///             4. The emulator will then write an event number to the adapter
///                component and sleep for 5 seconds. It will continue to do
///                this until the connection has been broken.
//==============================================================================
// *** NOTE TO USERS: You should compile this code from within Eclipse. By doing
// this your code will be indexed so that you can trace the origin of methods,
// functions, variables, etc. Hold ctrl and click on the method or variable to
// trace it's origin.
//

#include "SNA_ConfigParams.h"
#include "SNA_LoggingObject.h"

//Required Includes for ACE
#include "ace/INET_Addr.h"
#include "ace/SOCK_Stream.h"
#include "ace/SOCK_Connector.h"
#include "ace/SOCK_Acceptor.h"
#include "ace/Reactor.h"
#include "ace/Signal.h"

#include <string>
#include <unistd.h>

#include <iostream>

#include <endian.h>
#include <byteswap.h>

/**
 * Main function for a simple task that will emulate a hardware device that an
 * adaptor is translating to/from the SNA component architecture.
 *
 * @param argc The number of arguments that the program takes in
 * @param argv The program's arguments - the program name and a config file.
 *
 * @return - 0 if program executed successfully.
 */
int main(int argc, char * argv[])
{
   // Check for Config file argument presence
   if(argc != 2)
   {
      std::cerr << "Usage: " << argv[0] << "<config file>" << std::endl;
      return -1;
   }
   // ********************************************
   // Step 1: Setup logger and signal handlers
   // ********************************************

   // Create/get a logger with the specified name
   SNA::LoggingObject logging("SNA_Examples.ExternalAdapter.HardwareEmulator");

   // The SIGPIPE signal can be sent by the OS if a send or receive is occurring
   // on a socket when the other side goes down. This is not an error condition
   // and for this example can be safely ignored as this emulator will clean up
   // properly regardless.
   //
   // These lines create a signal handler which ignores the signal and this
   // registers with the OS to use that signal handler with the SIGPIPE signal.
   ACE_Sig_Action sigAction(SIG_IGN);
   sigAction.register_action(SIGPIPE);

   // ********************************************
   // Step 2: Read config file for host and port
   // ********************************************

   SNA::ConfigParams hostPortCfg;

   std::string host;
   int         port;

   ACE_INET_Addr     srvr;
   ACE_SOCK_Stream   stream;
   ACE_SOCK_Acceptor acceptor;

   // look up the host and port information
   if (hostPortCfg.init(argv[1]))
   {
      // lookup the host and port for the emulator
      hostPortCfg.lookupValue("HardwareEmulator_bin.host", host);
      hostPortCfg.lookupValue("HardwareEmulator_bin.port", port);

      LOG4CXX_INFO(logging.getLogger(), "Found Emulator.host " << host);
      LOG4CXX_INFO(logging.getLogger(), "Found Emulator.port " << port);
   }
   else
   {
      LOG4CXX_WARN(logging.getLogger(),
                   "Error in lookup of HW Emulator socket host/post information"
                   ". Using default settings. " << host << ":" << port);
   }

   // ********************************************
   // Step 3: Start the tcp server
   // ********************************************

   LOG4CXX_INFO(logging.getLogger(), "Waiting for connection...");

   // create the TCP socket connection
   srvr.set(port, host.c_str());

   if (acceptor.open(srvr) == -1)
   {
      LOG4CXX_INFO(logging.getLogger(), "Failed to open socket...");
      return -1;
   }
   else
   {
      LOG4CXX_INFO(logging.getLogger(), "Successfully opened socket...");
   }

   if (acceptor.accept(stream) == -1)
   {
      LOG4CXX_INFO(logging.getLogger(), "Failed accepting socket...");
      return -1;
   }
   else
   {
      LOG4CXX_INFO(logging.getLogger(), "Success accepting socket...");
   }

   // ********************************************
   // Step 4: Wait for the start command...
   // ********************************************

   LOG4CXX_INFO(logging.getLogger(), "Waiting for start command...");

   bool done = false;

   char buf[6];

   while ( ! done)
   {
      if (stream.recv_n(buf, sizeof(buf)) == -1)
      {
         LOG4CXX_INFO(logging.getLogger(),
                      "Error receiving message from adapter");
      }
      else
      {
         LOG4CXX_INFO(logging.getLogger(),
                      "Received message from adapter: " << buf);
         done = true;
      }
   }

   // ********************************************
   // Step 5: Send socket events until the connection is broken
   // ********************************************

   LOG4CXX_INFO(logging.getLogger(), "Sending events... ");

   unsigned long eventNumber = 1;

   while (true)
   {
      // Byte swap. Allows the Emulator to run on a different
      // architecture than the receiving Adapter.
      unsigned long eventNumberSwapped = eventNumber;

      #ifdef __LITTLE_ENDIAN
         #if __BYTE_ORDER == LITTLE_ENDIAN
            eventNumberSwapped = bswap_64(eventNumber);
         #endif
      #endif
      // ********************************************
      // Send the event number every 3 seconds...
      // ********************************************

      LOG4CXX_INFO(logging.getLogger(), "Sending event number " << eventNumber);

      if (stream.send_n((void*) &eventNumberSwapped, sizeof(eventNumberSwapped))
            != sizeof(eventNumberSwapped))
      {
         LOG4CXX_INFO(logging.getLogger(),
                      "Error sending; shutting HW emulator down...");

         break;
      }
      eventNumber++;

      sleep(3);
   }

   LOG4CXX_INFO(logging.getLogger(),
                "Finished Sending Socket Events... Emulator Exiting...");

   stream.close();

   return 0;
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
