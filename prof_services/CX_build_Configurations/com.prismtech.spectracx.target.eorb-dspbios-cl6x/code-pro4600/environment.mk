ifeq ($(EORBHOME),)
   $(error EORBHOME Not Set)
endif

ifeq ($(BIOS_INSTALL_DIR),)
   $(error BIOS_INSTALL_DIR Not Set)
endif

ifeq ($(C6X_INSTALL_DIR),)
   $(error C6X_INSTALL_DIR Not Set)
endif

ifeq ($(CSL_INSTALL_DIR),)
   $(error CSL_INSTALL_DIR Not Set)
endif

ifeq ($(SSP_INSTALL_ROOT),)
   $(error SSP_INSTALL_ROOT Not Set)
endif

ifeq ($(LOCAL_OS),win32)
   export PATH:=$(EORBHOME)/lib/win32-msdev-x86:$(PATH)
   export SEPARATOR:=\\
else
   $(error Unsupported Host OS)
endif
