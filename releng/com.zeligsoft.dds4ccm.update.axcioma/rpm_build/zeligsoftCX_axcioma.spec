%define ifdef()      %if %{expand:%%{?%{1}:1}%%{!?%{1}:0}}
%define ver          2.0.1
%define _defaultRel  0.%(date "+%y%m%d%H%M")
%define _rpmdir      %{_projectdir}/rpm_build/
%define _targetdir   %{_projectdir}/target
%define feature_groups "com.zeligsoft.base_feature.feature.group, \
    com.zeligsoft.cx_feature.feature.group, \
    com.zeligsoft.domain.idl3plus_feature.feature.group, \
    com.zeligsoft.domain.ngc.ccm.axcioma_feature.feature.group, \
    com.zeligsoft.domain.omg.ccm_feature.feature.group, \
    org.eclipse.cdt.feature.group, \
    org.eclipse.cdt.gdb.feature.group, \
    org.eclipse.cdt.gnu.build.feature.group, \
    org.eclipse.cdt.gnu.debug.feature.group, \
    org.eclipse.cdt.gnu.dsf.feature.group, \
    org.eclipse.cdt.native.feature.group, \
    org.eclipse.cdt.platform.feature.group, \
    org.eclipse.cdt.sdk.feature.group, \
    org.eclipse.papyrus.compare.feature.feature.group, \
    org.eclipse.launchbar.feature.group, \
    org.eclipse.xtext.runtime.feature.group, \
    org.eclipse.xtext.ui.feature.group, \
    org.eclipse.xtext.xbase.lib.feature.group, \
    org.eclipse.xtend.feature.group, \
    org.eclipse.xtend.typesystem.uml2.feature.group, \
    org.eclipse.xtend.typesystem.xsd.feature.group, \
    org.eclipse.xtend.sdk.feature.group, \
    org.eclipse.xtext.xbase.feature.group, \
    org.eclipse.emf.compare.feature.group, \
    org.eclipse.emf.compare.diagram.gmf.feature.group, \
    org.eclipse.emf.compare.egit.feature.group, \
    org.eclipse.emf.compare.ide.ui.feature.group, \
    org.eclipse.emf.compare.rcp.ui.feature.group, \
    org.eclipse.emf.compare.uml2.feature.group, \
    org.eclipse.emf.mwe.ui/1.4.0, \
    com.google.inject/3.0.0.v201605172100, \
    org.eclipse.xpand/2.2.0.v201605260315, \
    org.eclipse.xtend.shared.ui/2.2.0.v201605260315, \
    org.eclipse.xtend.ide/2.18.0.v20190528-0610, \
    org.eclipse.xtend.typesystem.emf/2.2.0.v201605260315, \
    org.freemarker/2.3.22.v20160210-1233, \
    org.eclipse.tools.templates.freemarker/1.0.0.201812111206, \
    org.eclipse.tools.templates.core/1.1.0.201812111206, \
    org.eclipse.tools.templates.ui/1.1.1.201812111206, \
    org.eclipse.tm.terminal.control/4.5.100.201901312304, \
    javax.xml.stream/1.0.1.v201004272200, \
    com.sun.xml.bind/2.2.0.v201505121915, \
    com.google.guava, \
    org.eclipse.xtend.lib.source, \
    org.eclipse.xtend.lib.macro.source, \
    org.eclipse.xtend.core.source, \
    org.eclipse.xtend.ide.common.source, \
    org.eclipse.xtend.ide.source, \
    org.eclipse.xtend.m2e.source, \
    org.eclipse.xtend.standalone.source, \
    org.eclipse.xtext.junit4.source, \
    org.eclipse.xtext.testing.source, \
    org.eclipse.xtext.xbase.junit.source, \
    org.eclipse.xtext.xbase.testing.source, \
    org.eclipse.xtext.ui.testing.source, \
    org.eclipse.xtext.xbase.ui.testing.source"

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
   -uninstallIU %{feature_groups} \
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
   -uninstallIU %{feature_groups} \
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
   -installIU %{feature_groups}


%postun
if [ $1 == 0 ] ; then					# this is an uninstallation, not an upgrade
/opt/Papyrus/papyrus \
   -application org.eclipse.equinox.p2.director \
   -nosplash \
   -uninstallIU %{feature_groups} \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
fi
