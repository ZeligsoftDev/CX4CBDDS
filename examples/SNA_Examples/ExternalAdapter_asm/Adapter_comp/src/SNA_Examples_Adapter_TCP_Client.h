//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Adapter_comp
/// @{
/// @file   SNA_Examples_Adapter_TCP_Client.h
/// @brief  Declaration of of Adapter_TCP_Client and its functions and data
///         members. This class exists to allow the creation of multiple sockets
///         in the Adapter component. Previously the Adapter component itself
///         handled its socket connection.
//==============================================================================

#ifndef SNA_EXAMPLES_ADAPTER_TCP_CLIENT_H_
#define SNA_EXAMPLES_ADAPTER_TCP_CLIENT_H_
#include <ace/INET_Addr.h>
#include <ace/SOCK_Stream.h>
#include <ace/SOCK_Connector.h>
#include <ace/SOCK_Acceptor.h>
#include <ace/Reactor.h>
#include "SNA_Examples_Adapter_AdapterIPEventHandler.h"
#include "SNA_TypedCompBoilerplate.h"
#include "SNA_Examples_Adapter_comp_exec.h"

namespace SNA_Examples
{
   /// Typedef of the typed boilerplate used for logging and state
   typedef SNA::TypedCompBoilerplate<
           ::SNA_Examples::CCM_Adapter_comp_Context,
           CIAO_SNA_Examples_Adapter_comp_Impl::Adapter_comp_exec_i>
           SNA_CompBoilerplate_t;

   /**
    * The Adapter_TCP_Client object handles the client side connection to the
    * server for the Adapter component. This class allows multiple sockets.
    */
   class Adapter_TCP_Client
   {

   public:

      /**
       * Adapter_TCP_Client constructor
       *
       * @param[in,out] boilerplate Reference to Adapter component's boilerplate
       *                            used to access ciao_context and logger.
       *
       * @param[in]     configFile  Name of the configuration file containing
       *                            the host and port information of the server
       *                            to connect to.
       *
       * @param[in,out] reactor     Reference to Adapter component's reactor
       *                            used to register and remove event handlers
       *                            to the Adapter_TCP_Client connection.
       */
      Adapter_TCP_Client(SNA_CompBoilerplate_t    &boilerplate,
                         std::string              configFile,
                         ACE_Reactor              &reactor);

      /**
       * Adapter_TCP_Client default destructor
       */
      virtual ~Adapter_TCP_Client();

      /**
       * Connects the Adapter_TCP_Client to the server and registers an event
       * handler to the reactor to be associated with the connection.
       */
      int connect();

   private:
      /**
       * Socket host name
       */
      std::string      host_;

      /**
       * Socket port name
       */
      unsigned int     port_;

      /**
       * Socket connection status
       */
      bool             connected_;

      /**
       * Portable socket class from ACE library
       */
      ACE_SOCK_Stream  peer_;

      /**
       * Logger prefix to be used with Adapter_TCP_Client's event handler
       */
      std::string      loggerPrefix_;

      /**
       * Adapter IP Event Handler
       */
      ::SNA_Examples::AdapterIPEventHandler * aIpEventHandler_;

      /**
       * SNA boilerplate used to access logger, executor class pointer, etc.
       */
      SNA_CompBoilerplate_t & boilerplate_;

      /**
       * A reference to the Component's reactor
       */
      ACE_Reactor & reactor_;
   };
}
#endif /* SNA_EXAMPLES_ADAPTER_TCP_CLIENT_H_ */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
