
# This script generated MPC files from the script calls below.
# To add dependencies, add flags and arguments to the calls.
# The available flags can be seen by typing "sna_generate_mpc.py --help"
# without the quotes at the command line.

sna_generate_mpc.py \
   SNA_Examples_EchoAssert_obj.idl


if [ $? -ne 0 ]; then
   exit 1
fi

sna_generate_mpc.py \
   SNA_Examples_NumAssert_conn.idl


if [ $? -ne 0 ]; then
   exit 1
fi

sna_generate_mpc.py \
   SNA_Examples_NumAssert_msg.idl


if [ $? -ne 0 ]; then
   exit 1
fi

