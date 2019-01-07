//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================
// Copyright (c) Northrop Grumman Corporation 2009 -- ALL RIGHTS RESERVED
//==============================================================================
/// @addtogroup SignalProcessingExample
/// @{
/// @file   SNA_Examples_DataObjectPrinter.h
/// @brief  Helper functions for printing VSIPL++ data objects
//==============================================================================

#ifndef DATA_OBJECT_PRINTER_H_
#define DATA_OBJECT_PRINTER_H_

#include <complex>
#include <sstream>

//VSIPL++ headers
#include <vsip/initfin.hpp>
#include <vsip/math.hpp>

#include "SNA_Logging.h"

namespace SNA_Examples
{
   /**
    * Namespace containing helper functions for printing VSIPL++ Views to the
    * logger.
    */
   namespace DataObjectPrinter
   {

      /**
       * Prints a VSIPL++ Vector that has complex data
       *
       * @param[in,out]  data  - The VSIPL++ Vector that will be output to the
       *                         logger. This Vector must contain data of
       *                         complex format.
       * @param[in,out]  msg   - The message that will be output before the data
       *                         Vector.
       * @param[in,out]  baseLogger -  Logger that will be used to output the
       *                               VSIPL++ data objects
       */
      template <class DataType>
      void PrintCmplxVector(  vsip::Vector<DataType> data,
                              std::string msg,
                              log4cxx::LoggerPtr baseLogger)
      {
         std::stringstream strm;
         strm.unsetf(ios::floatfield);

         std::string dashSep = "--------------------";

         strm << std::endl;
         strm << dashSep << std::endl;
         strm << msg << std::endl;
         strm << dashSep << std::endl;

         for (unsigned int i = 0; i < data.size(0); ++i)
         {
            strm << setw(3) << data.get(i).real() << " "
                 << setw(3) << data.get(i).imag() << "  ";

            strm << std::endl;
         }

         strm << dashSep << std::endl;
         strm << std::endl;

         LOG4CXX_INFO(baseLogger, strm.str());
         strm.str("");

      }

      /**
       * Prints a VSIPL++ Vector that has real data
       *
       * @param[in,out]  data  - The VSIPL++ Vector that will be output to the
       *                         logger. This Vector must contain data of real
       *                         format.
       * @param[in,out]  msg   - The message that will be output before the data
       *                         Vector.
       * @param[in,out]  baseLogger -  Logger that will be used to output the
       *                               VSIPL++ data objects
       */
      template <class DataType>
      void PrintRealVector(vsip::Vector<DataType> data,
                           std::string msg,
                           log4cxx::LoggerPtr baseLogger)
      {
         std::stringstream strm;
         strm.unsetf(ios::floatfield);

         std::string dashSep = "--------------------";

         strm << std::endl;
         strm << dashSep << std::endl;
         strm << msg << std::endl;
         strm << dashSep << std::endl;

         for (unsigned int i = 0; i < data.size(0); ++i)
         {
            strm << setw(3) << data.get(i) << " ";

            strm << std::endl;
         }

         strm << dashSep << std::endl;
         strm << std::endl;

         LOG4CXX_INFO(baseLogger, strm.str());
         strm.str("");
      }

      /**
       * Prints a VSIPL++ Matrix that has complex data
       *
       * @param[in,out]  data  - The VSIPL++ Matrix that will be output to the
       *                         logger. This Matrix must contain data of
       *                         complex format.
       * @param[in,out]  msg   - The message that will be output before the data
       *                         Matrix.
       * @param[in,out]  baseLogger -  Logger that will be used to output the
       *                               VSIPL++ data objects
       */
      template <class DataType>
      void PrintComplexMatrix(vsip::Matrix<DataType> data,
                              std::string msg,
                              log4cxx::LoggerPtr baseLogger)
      {
         std::stringstream strm;
         strm.unsetf(ios::floatfield);

         std::string dashSep = "--------------------";

         strm << std::endl;
         strm << dashSep << std::endl;
         strm << msg << std::endl;
         strm << dashSep << std::endl;

         for (unsigned int i = 0; i < data.size(0); ++i)
         {
            for (unsigned int j=0; j < data.size(1); ++j)
            {
               strm << setw(3) << data.get(i,j).real() << " "
                             << setw(3) << data.get(i,j).imag() << "  ";
            }

            strm << std::endl;
         }

         strm << dashSep << std::endl;
         strm << std::endl;

         LOG4CXX_INFO(baseLogger, strm.str());
         strm.str("");
      }

   };  // DataObjectPrinter

};    // SNA_Examples
#endif   //DATA_OBJECT_PRINTER_H_

/// @}
//==============================================================================
//                         U N C L A S S I F I E D
//==============================================================================

