%define ifdef()   	%if %{expand:%%{?%{1}:1}%%{!?%{1}:0}}
%define ver       	2.2.1
%define _defaultRel	0.%(date "+%y%m%d%H%M")
%define _rpmdir   	%{_projectdir}/rpm_build/
%define _targetdir 	%{_projectdir}/target

# Set the release of the RPM according to the value of the 'parameterized' input
# variables, or use a string constant
%if 0%{?_git_tag:1}
	%define rel %{_defaultRel}_%{_git_tag}
%else
	%if 0%{?_git_commit_id:1}
		%define rel %{_defaultRel}_%{_git_commit_id}
	%else
		%define rel %{_defaultRel}
	%endif
%endif

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
%pre
axciomaInstalledFeature=$(/opt/IBM/SDP/eclipse -application org.eclipse.equinox.p2.director -listInstalledRoots -nosplash | grep com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group)
atcdInstalledFeature=$(/opt/IBM/SDP/eclipse -application org.eclipse.equinox.p2.director -listInstalledRoots -nosplash | grep com.zeligsoft.domain.ngc.ccm_feature.feature.group)

if [[ ${atcdInstalledFeature} != "" ]]; then 		# atcd is already installed
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
elif [[ ${axciomaInstalledFeature} != "" ]]; then 		# axcioma is already installed
/opt/IBM/SDP/eclipse \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base.feature.group  \
   -uninstallIU com.zeligsoft.cx.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group \
   -uninstallIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group \
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
if [ $1 == 0 ] ; then			# this is an uninstallation, not an upgrade
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
