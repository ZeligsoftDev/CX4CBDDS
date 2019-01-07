ifeq ($(EORBHOME),)
   $(error EORBHOME not set)
endif

ifeq ($(EORBTARGETENV),)
   $(error EORBTARGETENV not set)
endif

ifeq ($(WIND_BASE),)
   $(error WIND_BASE not set)
endif

ifeq ($(LOCAL_OS),linux)
   export EORBHOSTENV=linux-gcc-x86
   export WIND_HOST_TYPE=x86-linux
   export PATH:=$(WIND_BASE)/host/$(WIND_HOST_TYPE)/bin:$(EORBHOME)/bin/$(EORBHOSTENV):$(PATH)
   export LD_LIBRARY_PATH:=$(EORBHOME)/lib/$(EORBHOSTENV):$(LD_LIBRARY_PATH)
else
ifeq ($(LOCAL_OS),win32)
   export EORBHOSTENV=win32-msdev-x86
   export WIND_HOST_TYPE=x86-win32
   export PATH:=$(WIND_BASE)\host\$(WIND_HOST_TYPE)\bin:$(EORBHOME)\bin\$(EORBHOSTENV):$(EORBHOME)\lib\$(EORBHOSTENV):$(PATH)
else
   $(error Unsupported Host OS)
endif
endif
