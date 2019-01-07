ifeq ($(EORBHOME),)
   $(error EORBHOME Not Set)
endif

ifeq ($(BIOS_INSTALL_DIR),)
   $(error BIOS_INSTALL_DIR Not Set)
endif

ifeq ($(C6X_INSTALL_DIR),)
   $(error C6X_INSTALL_DIR Not Set)
endif

ifeq ($(XDCTOOLS_DIR),)
   $(error XDCTOOLS_DIR Not Set)
endif

ifeq ($(DSPLINK),)
   $(error DSPLINK Not Set)
endif

ifeq ($(LOCAL_OS),linux)
   export LD_LIBRARY_PATH:=$(EORBHOME)/lib/linux-gcc-x86:$(LD_LIBRARY_PATH)
else
   $(error Unsupported Host OS)
endif
