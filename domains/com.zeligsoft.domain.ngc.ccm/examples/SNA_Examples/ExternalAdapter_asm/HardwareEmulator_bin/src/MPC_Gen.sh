sna_generate_mpc.py \
--all_sources \
--base sna_config_parameters \
--base sna_logging \
--executable \
HardwareEmulator

if [ $? -ne 0 ]; then
   exit 1
fi
