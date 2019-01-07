//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup PubSubClientServer_comp
/// @{
/// @file   SNA_Examples_CurrentNumPublishingLogic.h
/// @brief  Declaration of example showing how to publish from a non-executor
///         class
//==============================================================================

#ifndef SNA_EXAMPLES_CURRENTNUMPUBLISHINGLOGIC_H_
#define SNA_EXAMPLES_CURRENTNUMPUBLISHINGLOGIC_H_

// EXAMPLE: Included in order for this object to have a logger
#include "SNA_LoggingObject.h"

// EXAMPLE: Include needed to get definitions of the Writer interface
#include "SNA_Examples_CurrentNum_connC.h"

#include <string>

namespace SNA_Examples
{
   /**
    * Example showing how to publish from a non-executor class
    */
   class CurrentNumPublishingLogic :
      public virtual SNA::LoggingObject
   {
   public:

      /// Constructor
      CurrentNumPublishingLogic();

      /// Destructor
      ~CurrentNumPublishingLogic();

      /**
       * Initializes this class with an object reference to a Writer interface
       * on a CurrentNum connector
       *
       * @param[in] compLoggerName - Name of logger of the owning component
       * @param[in] writerPtr      - Object ref. to a Writer interface
       */
      void init(
            const std::string                         & compLoggerName,
            SNA_Examples::CurrentNum_conn::Writer_ptr   writerPtr);

      /**
       * Publishes a CurrentNum_msg sample with the current number field set to
       * @a currentNum
       *
       * @param[in] currentNum - current number to publish
       */
      void publish(CORBA::ULong currentNum);

   private:

      /**
       * Object reference to Writer interface on the connector
       */
      SNA_Examples::CurrentNum_conn::Writer_var writer_;
   };
}

#endif /* SNA_EXAMPLES_CURRENTNUMPUBLISHINGLOGIC_H_ */

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
