ifeq ($(EORBHOME),)
   $(error EORBHOME Not Set)
endif

ifeq ($(LOCAL_OS),win32)
export PATH := $(EORBHOME)/lib/win32-msdev-x86;$(PATH)
endif
