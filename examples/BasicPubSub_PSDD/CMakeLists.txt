#===============================================================================
#                            U N C L A S S I F I E D
#===============================================================================
#   Copyright (c) Northrop Grumman Corporation 2012-2019 -- ALL RIGHTS RESERVED
#===============================================================================
#
#===============================================================================
# EXPORT REGULATIONS (EAR99)
#===============================================================================
# DISCLOSURE: 
#
# Warning - This data is subject to the Export Administration Act (Title 22 
# U.S.C. App. 2401 et seq.), as amended. The implementing regulation for 
# this statute is the Export Administration Regulations (EAR) (15 C.F.R.
# 730-774). It may not be transferred, either in its original form, derivative 
# documents, or after being incorporated into other data without first 
# obtaining approval from the U.S. government or as otherwise authorized by 
# U.S. law and regulations. 
#===============================================================================

cmake_minimum_required(VERSION 3.2 FATAL_ERROR)

set(CMAKE_MODULE_PATH
    ${CMAKE_MODULE_PATH}
    "$ENV{SNA_ROOT}/tools/build"
    "$ENV{SNA_APP_ROOT}/include/$ENV{SNA_TARGET_TYPE}"
    CACHE STRING "Paths to find CMake configuration files")

project(BasicPubSub)

include(SNA_HelperFunctions)
include(SNA_LoadEnvironmentVariables)
include(SNA_CommonOptions)

add_subdirectory(ports)
add_subdirectory(components)


#===============================================================================
#                            U N C L A S S I F I E D
#===============================================================================
