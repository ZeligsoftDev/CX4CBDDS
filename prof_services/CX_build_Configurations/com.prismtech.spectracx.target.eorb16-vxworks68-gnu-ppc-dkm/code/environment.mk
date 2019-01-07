ifeq ($(EORBHOME),)
   $(error EORBHOME not set)
endif

ifeq ($(EORBTARGETENV),)
   $(error EORBTARGETENV not set)
endif

ifeq ($(WIND_BASE),)
   $(error WIND_BASE not set)
endif

ifeq ($(CX_TARGET),)
   $(error CX_TARGET not set)
endif

ifeq ($(CX_TARGET),SBC8548)
CX_TARGET_CC_FLAGS := -mcpu=8548
CX_TARGET_CC_DEFINES := CPU=PPC32
endif
ifeq ($(CX_TARGET),MPC8572)
CX_TARGET_CC_FLAGS := -mcpu=8540
CX_TARGET_CC_DEFINES := CPU=PPC85XX CPU_VARIANT=_e500v2
endif

ifeq ($(LOCAL_OS),win32)
   export EORBHOSTENV=win32-msdev-x86
   export WIND_HOST_TYPE=x86-win32
   export PATH:=$(EORBHOME)\bin\$(EORBHOSTENV):$(EORBHOME)\lib\$(EORBHOSTENV):$(PATH)
else
   export EORBHOSTENV=linux-gcc-x86
   export WIND_HOST_TYPE=x86-linux
   export PATH:=$(EORBHOME)/bin/$(EORBHOSTENV):$(PATH)
   export LD_LIBRARY_PATH:=$(EORBHOME)/lib/$(EORBHOSTENV):$(LD_LIBRARY_PATH)
endif
