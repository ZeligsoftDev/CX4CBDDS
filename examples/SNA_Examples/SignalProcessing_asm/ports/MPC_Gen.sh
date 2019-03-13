sna_generate_mpc.py \
--all_sources \
--header_only \
DataObjectPrinter

if [ $? -ne 0 ]; then
   exit 1
fi
