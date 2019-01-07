ifeq ($(EORBHOME),)
$(error EORBHOME not set)
endif
	
ifeq ($(EORBTARGETENV),)
$(error EORBTARGETENV not set)
endif
	
ifeq ($(WIND_BASE),)
$(error WIND_BASE not set)
endif
	
ifeq ($(WIND_USR),)
$(error WIND_USR not set)
endif
	
ifeq ($(WIND_HOME),)
$(error WIND_HOME not set)
endif
	
ifeq ($(WIND_GNU_PATH),)
$(error WIND_GNU_PATH not set)
endif
	
ifeq ($(WIND_HOST_TYPE),)
$(error WIND_HOST_TYPE not set)
endif
	
export EORBHOSTENV=linux-gcc-x86
export PATH:=$(WIND_GNU_PATH)/$(WIND_HOST_TYPE)/bin:$(EORBHOME)/bin/$(EORBHOSTENV):$(PATH)
export LD_LIBRARY_PATH:=$(EORBHOME)/lib/$(EORBHOSTENV):$(LD_LIBRARY_PATH)

