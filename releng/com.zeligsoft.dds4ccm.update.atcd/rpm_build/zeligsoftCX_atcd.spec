#===============================================================================
#                            U N C L A S S I F I E D
#===============================================================================
# Copyright (c) Northrop Grumman Corporation 2019 -- ALL RIGHTS RESERVED
#===============================================================================

%define ifdef()   %if %{expand:%%{?%{1}:1}%%{!?%{1}:0}}
%define ver       1.6.0
%define rel       0.%(date "+%y%m%d%H%M")
%define _rpmdir   %{_projectdir}/rpm_build/
%define _targetdir %{_projectdir}/target

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Define packages
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Name:          cx-atcd
Version:       %{ver}
Release:       %{rel}
Summary:       A Rational Software Architect (RSA) add-in for modeling on ACE+TAO+CIAO+DAnCE
License:       Apache License, Version 2.0
BuildArch:     noarch
URL:           https://github.com/ZeligsoftDev/CX4CBDDS
AutoReqProv:   no

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Describe packages
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

%description
DDS4CCM is a Rational Software Architect (RSA) add-in for modeling component
based systems built on ACE+TAO+CIAO+DAnCE according to the OMG CCM standard.

%install
%{__mkdir_p} %{buildroot}/opt/cx-atcd
cp %{_targetdir}/dds4ccm_*.v*.zip %{buildroot}/opt/cx-atcd/
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Allocate files
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

%files
/opt/cx-atcd/

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Define RPM scripts (%%pre and %%post sections)
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
%post
# Get timestamp of CX zip file
timestamp=$(echo /opt/cx-atcd/*.zip | sed -rn 's/.*\.v([0-9]*)\.zip/\1/p')
/opt/IBM/SDP/eclipse \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -repository \
   jar:file:/opt/cx-atcd/dds4ccm_atcd_%{ver}.v${timestamp}.zip\!/ \
   -installIU com.zeligsoft.base.feature.group  \
   -installIU com.zeligsoft.cx.feature.group  \
   -installIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -installIU com.zeligsoft.domain.ngc.ccm_feature.feature.group  \
   -installIU com.zeligsoft.domain.omg.ccm_feature.feature.group

%postun
/opt/IBM/SDP/eclipse \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base.feature.group  \
   -uninstallIU com.zeligsoft.cx.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.ngc.ccm_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
#===============================================================================
#                            U N C L A S S I F I E D
#===============================================================================
