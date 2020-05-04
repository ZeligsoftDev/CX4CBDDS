%define ifdef()      %if %{expand:%%{?%{1}:1}%%{!?%{1}:0}}
%define ver          2.0.0
%define _defaultRel  0.%(date "+%y%m%d%H%M")
%define _rpmdir      %{_projectdir}/rpm_build/
%define _targetdir   %{_projectdir}/target

# Set the release of the RPM according to the value of the 'parameterized' input
# variables, or use a string constant
%if 0%{?_git_tag:1}
	%define rel %{_defaultRel}_{_git_tag}
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
axciomaInstalledFeature=$(/opt/Papyrus/papyrus -application org.eclipse.equinox.p2.director -listInstalledRoots -nosplash | grep com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group)
atcdInstalledFeature=$(/opt/Papyrus/papyrus -application org.eclipse.equinox.p2.director -listInstalledRoots -nosplash | grep com.zeligsoft.domain.ngc.ccm_feature.feature.group)

if [[ ${axciomaInstalledFeature} != "" ]]; then 		# axcioma is already installed
/opt/Papyrus/papyrus \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base_feature.feature.group  \
   -uninstallIU com.zeligsoft.cx_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -uninstallIU org.eclipse.cdt.feature.group \
   -uninstallIU org.eclipse.cdt.gdb.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.build.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.debug.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.dsf.feature.group \
   -uninstallIU org.eclipse.cdt.native.feature.group \
   -uninstallIU org.eclipse.cdt.platform.feature.group \
   -uninstallIU org.eclipse.cdt.sdk.feature.group \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
elif [[ ${atcdInstalledFeature} != "" ]]; then 		# atcd is already installed
/opt/Papyrus/papyrus \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base_feature.feature.group  \
   -uninstallIU com.zeligsoft.cx_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.ngc.ccm_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -uninstallIU org.eclipse.cdt.feature.group \
   -uninstallIU org.eclipse.cdt.gdb.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.build.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.debug.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.dsf.feature.group \
   -uninstallIU org.eclipse.cdt.native.feature.group \
   -uninstallIU org.eclipse.cdt.platform.feature.group \
   -uninstallIU org.eclipse.cdt.sdk.feature.group \
   -uninstallIU org.eclipse.papyrus.compare.feature.feature.group \
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
/opt/Papyrus/papyrus \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -repository \
   jar:file:/opt/cx-axcioma/dds4ccm_axcioma_%{ver}.v${timestamp}.zip\!/ \
   -installIU org.eclipse.cdt.feature.group \
   -installIU org.eclipse.cdt.gdb.feature.group \
   -installIU org.eclipse.cdt.gnu.build.feature.group \
   -installIU org.eclipse.cdt.gnu.debug.feature.group \
   -installIU org.eclipse.cdt.gnu.dsf.feature.group \
   -installIU org.eclipse.cdt.native.feature.group \
   -installIU org.eclipse.cdt.platform.feature.group \
   -installIU org.eclipse.cdt.sdk.feature.group \
   -installIU com.zeligsoft.base_feature.feature.group  \
   -installIU com.zeligsoft.cx_feature.feature.group  \
   -installIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -installIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group  \
   -installIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -installIU org.eclipse.papyrus.compare.feature.feature.group

%postun
if [ $1 == 0 ] ; then					# this is an uninstallation, not an upgrade
/opt/Papyrus/papyrus \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU com.zeligsoft.base_feature.feature.group  \
   -uninstallIU com.zeligsoft.cx_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.idl3plus_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group  \
   -uninstallIU com.zeligsoft.domain.omg.ccm_feature.feature.group \
   -uninstallIU org.eclipse.cdt.feature.group \
   -uninstallIU org.eclipse.cdt.gdb.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.build.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.debug.feature.group \
   -uninstallIU org.eclipse.cdt.gnu.dsf.feature.group \
   -uninstallIU org.eclipse.cdt.native.feature.group \
   -uninstallIU org.eclipse.cdt.platform.feature.group \
   -uninstallIU org.eclipse.cdt.sdk.feature.group \
   -uninstallIU org.eclipse.papyrus.compare.feature.feature.group \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
fi
