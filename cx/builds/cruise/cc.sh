#!/bin/sh

DISPLAY=127.0.0.1:1.0
export DISPLAY

nohup sh $CC_HOME/cruisecontrol.sh $BUILD_HOME/build/cruise/config.xml > cruise.out &
