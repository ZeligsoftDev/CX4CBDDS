#! /bin/bash

# This function gets called for shutting down the deployment and cleanup
function quit 
{
   ##
   ## Shuts down and removes components in the deployment plan (arg 2)
   ##
   
   $SNA_ROOT/tools/scripts/sna_shutdown_local_components.py \
                                          BasicPublisher_compNode.ior 
   

   $SNA_ROOT/tools/scripts/sna_shutdown_local_components.py \
                                          BasicSubscriber_compNode.ior 
   
   $SNA_ROOT/tools/scripts/sna_shutdown_logger_aggregator.sh
   
   popd > /dev/null
   exit
}

## establish current path so the script can be run from 
## directories other than its own

SCRIPT_FULL_PATH=$(cd ${0%/*} && echo $PWD/${0##*/})
SCRIPT_PATH=`dirname "$SCRIPT_FULL_PATH"`

echo "SCRIPT_FULL_PATH = $SCRIPT_FULL_PATH"
echo "SCRIPT_PATH      = $SCRIPT_PATH"

## as it turns out, we need to actually be in the same folder as the script
## Or rather, we must be in the same folder as NDDS_QOS_PROFILES.xml and this
## file is currently located in the same folder as the script. We could put them
## in different folders and pushd to that folder instead, in the future.
pushd $SCRIPT_PATH


## Quit and cleanup if ctrl-c and kill is invoked on this script or
## if a command below exits with a non-zero status

trap "quit" SIGINT SIGTERM ERR

## We start chainsaw only if there isn't already an instance running
## note that sna_launch_chainsaw.sh requires chainsaw to be installed
## in /opt/chainsaw (as it is in the VM release with the 0.2.0 SDK)
 
$SNA_ROOT/tools/scripts/sna_launch_chainsaw.sh &

##
## To clean up shared memory from previous runs and kill off the 
## execution manager, plan launcher, and any nodes that are still running
## we run sna_deployment_cleanup.sh
##

echo "Running sna_deployment_cleanup.sh to clean up from any previous runs..."
$SNA_ROOT/tools/scripts/sna_deployment_cleanup.sh

##
## Set SNA_CONFIG_PATH environment variable which tells SNA where to find its
## configuration files
##
export SNA_CONFIG_PATH=$SCRIPT_PATH/../config/:$SNA_CONFIG_PATH

echo "SNA_CONFIG_PATH = $SNA_CONFIG_PATH"
##
## Set DANCE_LOG_LEVEL environment variable so that DAnCE will log errors and
## warnings only. If the variable is already set it will use that existing
## value.
##
export DANCE_LOG_LEVEL=${DANCE_LOG_LEVEL:=6}

##
## Startup the LoggerAggregator_bin daemon if there isn't already an instance
## running. This daemon subscribes to log messages published over DDS and 
## forwards them over TCP/IP socket to a remote logging server like Apache
## chainsaw. Such messages are generated when the logging system is configured 
## to use the DDS_Appender. For more information take a look at Logging.cfg
## found in ../config. 
##
$SNA_ROOT/tools/scripts/sna_launch_logger_aggregator.sh &

echo "Starting the example..."

##
## This example is configured to run on a single machine.
## If there were multiple machines used, we would have to run 
## "sna_start_nodes.py" on each machine.
##

$SNA_ROOT/tools/scripts/sna_start_nodes.py ../descriptors/BasicPubSub_asm_VM.cdd  

##
## sna_start_components.py only needs to be run once, on a single machine,
## regardless of how many machines are being used to host the nodes.
##

$SNA_ROOT/tools/scripts/sna_start_local_components.py \
                                          BasicPublisher_compNode.ior \
                                          ../descriptors/BasicPublisher_compNodeBasicPubSub_asm.cdp.cdr

$SNA_ROOT/tools/scripts/sna_start_local_components.py \
                                          BasicSubscriber_compNode.ior \
                                          ../descriptors/BasicSubscriber_compNodeBasicPubSub_asm.cdp.cdr

echo "*******************************************************"
echo "***    PRESS ENTER OR CTRL-C TO TEARDOWN EXAMPLE    ***"
echo "*******************************************************"

# Wait for user input and then quit deployment
read
quit
