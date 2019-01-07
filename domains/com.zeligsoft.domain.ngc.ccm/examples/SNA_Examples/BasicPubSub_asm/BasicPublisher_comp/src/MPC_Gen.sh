sna_generate_mpc.py \
--all_sources \
--base sna_time_management \
--base sna_config_parameters \
SNA_Examples_BasicPublisher_comp.idl

if [ $? -ne 0 ]; then
   exit 1
fi
