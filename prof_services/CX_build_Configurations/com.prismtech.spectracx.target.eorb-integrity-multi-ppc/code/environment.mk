
ifeq ($(EORBHOME),)
   $(error EORBHOME Not Set)
endif
ifeq ($(EORBTARGETENV),)
   $(error EORBTARGETENV Not Set)
endif
ifeq ($(INTEGRITY_BSP),)
   $(error INTEGRITY_BSP Not Set)
endif
ifeq ($(INTEGRITY_BASE),)
   $(error INTEGRITY_BASE Not Set)
endif
ifeq ($(INTEGRITY_COMP_DIR),)
   $(error INTEGRITY_COMP_DIR Not Set)
endif

ifeq ($(LOCAL_OS),win32)
   ifeq ($(PROCESSOR_ARCHITECTURE),AMD64)
      export EORBHOSTENV=win64-msdev-x64
   else
      ifeq ($(PROCESSOR_ARCHITEW6432),AMD64)
         export EORBHOSTENV=win64-msdev-x64
      else
         export EORBHOSTENV=win32-msdev-x86
      endif
   endif
   export PATH:=$(INTEGRITY_COMP_DIR):$(EORBHOME)/bin/$(EORBHOSTENV):$(EORBHOME)/lib/$(EORBHOSTENV):$(PATH)
   export SEPARATOR:=\\
else
   export EORBHOSTENV=linux-gcc-x86
   export PATH:=$(INTEGRITY_COMP_DIR):$(EORBHOME)/bin/$(EORBHOSTENV):$(PATH)
   export LD_LIBRARY_PATH:=$(EORBHOME)/lib/$(EORBHOSTENV):$(LD_LIBRARY_PATH)
   export SEPARATOR:=/
endif
