//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup Adapter_comp
/// @{
/// @file   SNA_Examples_Adapter_AdapterIPEventHandler.cpp
/// @brief  Implementation of EmptyHandler and AdapterIPEventHandler classes.
//==============================================================================


#include "SNA_Examples_Adapter_AdapterIPEventHandler.h"
#include <endian.h>
#include <byteswap.h>

namespace SNA_Examples
{
   //Constructor
   EmptyHandler::EmptyHandler()
   {
   }
   //Destructor
   EmptyHandler::~EmptyHandler()
   {
   }

   //Constructor
   AdapterIPEventHandler::AdapterIPEventHandler(
         ::SNA_Examples::CCM_Adapter_comp_Context_ptr    ciao_context,
         const std::string                             & loggerPrefix,
         ACE_SOCK_Stream                               & peer) :

         SNA::LoggingObject("AdapterIPEventHandler", loggerPrefix),
         peer_(peer),
         ciao_context_(
             ::SNA_Examples::CCM_Adapter_comp_Context::_duplicate(ciao_context))
   {
   }

   //Destructor
   AdapterIPEventHandler::~AdapterIPEventHandler()
   {
   }

   //Handler Callback required by ACE
   int AdapterIPEventHandler::handle_input(ACE_HANDLE /* fd */)
   {
      unsigned long eventNumber = 0;
      // read the event number from the hardware
      if (peer_.recv_n(&eventNumber, sizeof(eventNumber))
            != sizeof(eventNumber))
      {
         LOG4CXX_ERROR(logger_,
                       "Error receiving from hardware");
         return -1;
      }

      // Byte swapping in case eventNumber is in a different
      // byte order than the architecture that the adapter component
      // is running on
      #ifdef __LITTLE_ENDIAN
         #if ( __BYTE_ORDER==LITTLE_ENDIAN )
             eventNumber = bswap_64(eventNumber);
         #endif
      #endif

      std::stringstream message;

      message << "* This is message #" << eventNumber
              << " from the AdapterBizLogic! *";

      // uses the ciao context to get the facet reference.
      SNA_Examples::RelayServer_obj_var relayRecept =
            ciao_context_->get_connection_relayServerRecept();

      // check for a valid object reference
      if ( ! CORBA::is_nil(relayRecept.in()))
      {
        try {
            // call the interface method here
            relayRecept->echoText(message.str().c_str());
        } catch (const CORBA::Exception & ex)
        {
             LOG4CXX_ERROR(logger_, "CORBA Exception: " << ex);
        }
      }
      else
      {
         LOG4CXX_ERROR(logger_, "Error calling echoText()");
         return -1;
      }

      return 0;
   }

   //Handler Callback required by ACE
   int AdapterIPEventHandler::handle_close(
         ACE_HANDLE       /* handle */,
         ACE_Reactor_Mask /* mask */)
   {
      peer_.close();

      LOG4CXX_DEBUG(logger_, "ACE handler close");

      return 0;
   }

   int AdapterIPEventHandler::handle_signal(int          /* signum */,
                                            siginfo_t  * /* info */,
                                            ucontext_t * /* context */)
   {
      return 0;
   }

   ACE_HANDLE AdapterIPEventHandler::get_handle(void) const
   {
      return peer_.get_handle();
   }
}
/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
