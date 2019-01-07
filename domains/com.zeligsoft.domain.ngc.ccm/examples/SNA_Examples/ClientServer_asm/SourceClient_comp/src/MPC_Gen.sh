sna_generate_mpc.py \
--all_sources \
--base sna_time_management \
SNA_Examples_SourceClient_comp.idl

if [ $? -ne 0 ]; then
   exit 1
fi
