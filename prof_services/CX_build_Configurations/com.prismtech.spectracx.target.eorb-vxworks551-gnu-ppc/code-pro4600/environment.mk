ifeq ($(EORBHOME),)
	$(error EORBHOME not set)
endif

ifeq ($(CFHOME),)
	$(error CFHOME not set)
endif

ifeq ($(WIND_BASE),)
	$(error WIND_BASE not set)
endif

ifeq ($(SSP_INSTALL_ROOT),)
	$(error SSP_INSTALL_ROOT not set)
endif

ifneq ($(LOCAL_OS),win32)
	$(error Unsupported Host OS)
endif

export PATH:=$(EORBHOME)/bin/win32-msdev-x86:$(EORBHOME)/lib/win32-msdev-x86:$(PATH)
export PATH:=$(WIND_BASE)/host/gnu/3.3/x86-win32/bin:$(WIND_BASE)/host/x86-win32/bin:$(PATH)

export SEPARATOR:=\\
