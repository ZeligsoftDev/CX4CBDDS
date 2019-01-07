//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2010 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup BasicPubSubExample
/// @{
/// @file   SNA_Examples_CurrentNumPublishingLogic.cpp
/// @brief  Implementation of example showing how to publish from a non-executor
///         class
//==============================================================================

#include "SNA_Examples_CurrentNumPublishingLogic.h"

#include <stdexcept>
#include <Utils.h>

SNA_Examples::CurrentNumPublishingLogic::CurrentNumPublishingLogic() :
   SNA::LoggingObject("CurrentNumPublishingLogic")
{
}

SNA_Examples::CurrentNumPublishingLogic::~CurrentNumPublishingLogic()
{
}

// EXAMPLE: If using this pattern with PSAT or SPDM, the type would be
//          PSAT_Writer_ptr instead of Writer_ptr and the associated interface
//          calls would change accordingly.
void SNA_Examples::CurrentNumPublishingLogic::init(
      const std::string                         & compLoggerName,
      SNA_Examples::CurrentNum_conn::Writer_ptr   writerPtr)
{
   setLoggerNamePrefix(compLoggerName);

   writer_ = SNA_Examples::CurrentNum_conn::Writer::_duplicate(writerPtr);

   if (CORBA::is_nil(writer_.in()))
   {
      LOG4CXX_ERROR(logger_, "Writer pointer is nil. Throwing...");
      throw std::invalid_argument("Writer pointer is nil");
   }
}

void SNA_Examples::CurrentNumPublishingLogic::publish(CORBA::ULong currentNum)
{
   // EXAMPLE: This is the generated C++ structure given by the IDL
   //          definition from the ports directory. This structure has no
   //          meaning and is shown only for example. The fields of this
   //          structure provide examples of using the various IDL to C++
   //          data types.
   SNA_Examples::CurrentNum_msg sample;
   sample.theCurrNum = currentNum;

   try
   {
      writer_->write_one(sample, DDS::HANDLE_NIL);
      LOG4CXX_INFO(logger_, "Successfully published from non-executor class");
   }
   catch (CCM_DDS::InternalError & ex) // catch "normal" exception
   {
      LOG4CXX_ERROR(logger_,
                    "Caught InternalError exception from write_one call. "
                    "Contained DDS error code is "
                    << ::CIAO::DDS4CCM::translate_retcode(ex.error_code));

      throw;
   }
   catch (const CORBA::Exception & ex)
   {
      LOG4CXX_ERROR(logger_, "Caught CORBA Exception: " << ex);

      throw;
   }
   catch (...) // catch everything else. If this is called something is wrong
   {
      LOG4CXX_ERROR(logger_, "Caught unknown exception from write_one call.");

      throw;
   }
}

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
