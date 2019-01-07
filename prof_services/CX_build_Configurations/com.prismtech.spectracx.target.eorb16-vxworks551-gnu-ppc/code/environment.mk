ifeq ($(EORBHOME),)
	$(error EORBHOME not set)
endif

ifeq ($(EORBTARGETENV),)
	$(error EORBTARGETENV not set)
endif

ifeq ($(VXWORKS_CHIPSET),)
	$(error VXWORKS_CHIPSET not set)
else
    ifneq (,$(findstring $(VXWORKS_CHIPSET),"8572"))
       $(warn Changing VXWORKS_CHIPSET to 8540)
       export VXWORKS_CHIPSET:=8540
    endif

    ifneq (,$(findstring $(VXWORKS_CHIPSET),"8540"))
       export VXWORKS_CHIPSET_FAMILY:=85XX
       export PATH:=$(WIND_BASE)/host/gnu/3.3/$(WIND_HOST_TYPE)/bin:$(WIND_BASE)/host/$(WIND_HOST_TYPE)/bin:$PATH
    else
       export VXWORKS_CHIPSET_FAMILY:=$(VXWORKS_CHIPSET)
       export PATH:=$(WIND_BASE)/host/$(WIND_HOST_TYPE)/bin:$PATH
    endif
endif

ifeq ($(WIND_BASE),)
	$(error WIND_BASE not set)
endif

ifeq ($(LOCAL_OS),win32)
   ifeq ($(PTECH_LICENSE_FILE),)
      $(error PTECH_LICENSE_FILE Not Set)
   endif
   
   export EORBHOSTENV=win32-msdev-x86
   export WIND_HOST_TYPE=x86-win32
   export PATH:=$(EORBHOME)/bin/$(EORBHOSTENV):$(EORBHOME)/lib/$(EORBHOSTENV):$(PATH)
   export SEPARATOR:=\\
else
   $(error Unsupported Host OS)
endif
