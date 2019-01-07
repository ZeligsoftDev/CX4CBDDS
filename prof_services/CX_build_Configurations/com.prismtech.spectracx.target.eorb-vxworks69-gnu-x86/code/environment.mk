ifeq ($(EORBHOME),)
   $(error EORBHOME not set)
endif

ifeq ($(EORBTARGETENV),)
   $(error EORBTARGETENV not set)
endif

ifeq ($(WIND_BASE),)
   $(error WIND_BASE not set)
endif

ifeq ($(LOCAL_OS),win32)
   export EORBHOSTENV=win64-msdev-x64
   export WIND_HOST_TYPE=x86-win32
   export PATH:=$(WIND_BASE)\host\$(WIND_HOST_TYPE)\bin:$(EORBHOME)\bin\$(EORBHOSTENV):$(EORBHOME)\lib\$(EORBHOSTENV):$(PATH)
else
   $(error Unsupported Host OS)
endif
