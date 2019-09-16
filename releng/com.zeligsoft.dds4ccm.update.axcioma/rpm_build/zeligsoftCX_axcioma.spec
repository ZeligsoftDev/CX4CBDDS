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

Name:          cx-axcioma
Version:       %{ver}
Release:       %{rel}
Summary:       A Rational Software Architect (RSA) add-in for modeling on AXCIOMA
License:       Apache License, Version 2.0
BuildArch:     noarch
URL:           https://github.com/ZeligsoftDev/CX4CBDDS
AutoReqProv:   no

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Describe packages
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

%description -n cx-axcioma
DDS4CCM is a Rational Software Architect (RSA) add-in for modeling component
based systems built on AXCIOMA according to the OMG CCM standard.

%install
%{__mkdir_p} %{buildroot}/opt/cx-axcioma
cp %{_targetdir}/dds4ccm_*.v*.zip %{buildroot}/opt/cx-axcioma/

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Allocate files
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

%files
/opt/cx-axcioma/

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Define RPM scripts (%%pre and %%post sections)
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
%pre
axciomaInstalledFeature=$(/opt/IBM/SDP/eclipse -application org.eclipse.equinox.p2.director -listInstalledRoots -nosplash | grep com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group)
atcdInstalledFeature=$(/opt/IBM/SDP/eclipse -application org.eclipse.equinox.p2.director -listInstalledRoots -nosplash | grep com.zeligsoft.domain.ngc.ccm_feature.feature.group)

if [[ ${axciomaInstalledFeature} != "" ]]; then 		# axcioma is already installed
/opt/IBM/SDP/eclipse \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base.feature.group  \
   -uninstallIU com.zeligsoft.cx.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
elif [[ ${atcdInstalledFeature} != "" ]]; then 		# atcd is already installed
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
fi

%post
# Get timestamp of CX zip file
timestamp=$(echo /opt/cx-axcioma/*.zip | sed -rn 's/.*\.v([0-9]*)\.zip/\1/p')
/opt/IBM/SDP/eclipse \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -repository \
   jar:file:/opt/cx-axcioma/dds4ccm_axcioma_%{ver}.v${timestamp}.zip\!/ \
   -installIU com.zeligsoft.base.feature.group  \
   -installIU com.zeligsoft.cx.feature.group  \
   -installIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -installIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group  \
   -installIU com.zeligsoft.domain.omg.ccm_feature.feature.group

%postun
if [ $1 == 0 ] ; then					# this is an uninstallation, not an upgrade
/opt/IBM/SDP/eclipse \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base.feature.group  \
   -uninstallIU com.zeligsoft.cx.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
fi
#===============================================================================
#                            U N C L A S S I F I E D
#===============================================================================
