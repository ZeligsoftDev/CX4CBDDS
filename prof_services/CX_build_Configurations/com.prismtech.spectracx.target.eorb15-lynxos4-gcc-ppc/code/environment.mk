
#
# Setup environment for e*ORB
#
ifeq ($(EORBHOME),)
   $(error EORBHOME Not Set)
endif
ifeq ($(EORBTARGETENV),)
   $(error EORBTARGETENV Not Set)
endif

ifeq ($(LOCAL_OS),win32)
   export EORBHOSTENV=win32-msdev-x86
   export PATH:=$(EORBHOME)/lib/$(EORBHOSTENV):$(PATH)
else
   export EORBHOSTENV=linux-gcc-x86
   export LD_LIBRARY_PATH:=$(EORBHOME)/lib/$(EORBHOSTENV):$(LD_LIBRARY_PATH)
endif

#
# Check that the user has setup their environment for LynxOS development.
# If they have run either of the SETUP.bash or SETUP.csh scripts then they
# will have ENV_PREFIX=<path>, LYNXTARGET=ppc & OBJSFORMAT=ejf set in their
# environment.
#
RUN_SETUP_MSG:=Please configure your environment with the appropriate LynxOS SETUP.bash or SETUP.csh script before running Spectra CX.

ifeq ($(ENV_PREFIX),)
   $(error ENV_PREFIX Not Set. $(RUN_SETUP_MSG))
endif
ifeq ($(LYNXTARGET),)
   $(error LYNXTARGET Not Set. $(RUN_SETUP_MSG))
endif
ifneq ($(LYNXTARGET),ppc)
   $(error Expecting LYNXTARGET=ppc but got LYNXTARGET=$(LYNXTARGET). $(RUN_SETUP_MSG))
endif
ifeq ($(OBJSFORMAT),)
   $(error OBJSFORMAT Not Set. $(RUN_SETUP_MSG))
endif
ifneq ($(OBJSFORMAT),elf)
   $(error Expecting OBJSFORMAT=elf but got OBJSFORMAT=$(OBJSFORMAT). $(RUN_SETUP_MSG))
endif
