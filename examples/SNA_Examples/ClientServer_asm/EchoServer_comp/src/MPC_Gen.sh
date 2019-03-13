sna_generate_mpc.py \
--all_sources \
SNA_Examples_EchoServer_comp.idl

if [ $? -ne 0 ]; then
   exit 1
fi
