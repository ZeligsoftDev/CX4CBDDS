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
   -uninstallIU org.eclipse.papyrus.compare.feature.feature.group \
   -uninstallIU org.eclipse.launchbar.feature.group \
   -uninstallIU org.eclipse.xtext.runtime.feature.group \
   -uninstallIU org.eclipse.xtext.ui.feature.group \
   -uninstallIU org.eclipse.xtext.xbase.lib.feature.group \
   -uninstallIU org.eclipse.xtend.feature.group \
   -uninstallIU org.eclipse.xtend.typesystem.uml2.feature.group \
   -uninstallIU org.eclipse.xtend.typesystem.xsd.feature.group \
   -uninstallIU org.eclipse.xtend.sdk.feature.group \
   -uninstallIU org.eclipse.xtext.xbase.feature.group \
   -uninstallIU org.eclipse.emf.compare.feature.group \
   -uninstallIU org.eclipse.emf.compare.diagram.gmf.feature.group \
   -uninstallIU org.eclipse.emf.compare.egit.feature.group \
   -uninstallIU org.eclipse.emf.compare.ide.ui.feature.group \
   -uninstallIU org.eclipse.emf.compare.rcp.ui.feature.group \
   -uninstallIU org.eclipse.emf.compare.uml2.feature.group \
   -uninstallIU org.eclipse.emf.mwe.ui/1.4.0 \
   -uninstallIU com.google.inject/3.0.0.v201605172100 \
   -uninstallIU org.eclipse.xpand/2.2.0.v201605260315 \
   -uninstallIU org.eclipse.xtend.shared.ui/2.2.0.v201605260315 \
   -uninstallIU org.eclipse.xtend.ide/2.18.0.v20190528-0610 \
   -uninstallIU org.eclipse.xtend.typesystem.emf/2.2.0.v201605260315 \
   -uninstallIU org.freemarker/2.3.22.v20160210-1233 \
   -uninstallIU org.eclipse.tools.templates.freemarker/1.0.0.201812111206 \
   -uninstallIU org.eclipse.tools.templates.core/1.1.0.201812111206 \
   -uninstallIU org.eclipse.tools.templates.ui/1.1.1.201812111206 \
   -uninstallIU org.eclipse.tm.terminal.control/4.5.100.201901312304 \
   -uninstallIU javax.xml.stream/1.0.1.v201004272200 \
   -uninstallIU com.sun.xml.bind/2.2.0.v201505121915 \
   -uninstallIU com.google.guava \
   -uninstallIU org.eclipse.xtend.lib.source \
   -uninstallIU org.eclipse.xtend.lib.macro.source \
   -uninstallIU org.eclipse.xtend.core.source \
   -uninstallIU org.eclipse.xtend.ide.common.source \
   -uninstallIU org.eclipse.xtend.ide.source \
   -uninstallIU org.eclipse.xtend.m2e.source \
   -uninstallIU org.eclipse.xtend.standalone.source \
   -uninstallIU org.eclipse.xtext.junit4.source \
   -uninstallIU org.eclipse.xtext.testing.source \
   -uninstallIU org.eclipse.xtext.xbase.junit.source \
   -uninstallIU org.eclipse.xtext.xbase.testing.source \
   -uninstallIU org.eclipse.xtext.ui.testing.source \
   -uninstallIU org.eclipse.xtext.xbase.ui.testing.source \
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
   -uninstallIU org.eclipse.launchbar.feature.group \
   -uninstallIU org.eclipse.xtext.runtime.feature.group \
   -uninstallIU org.eclipse.xtext.ui.feature.group \
   -uninstallIU org.eclipse.xtext.xbase.lib.feature.group \
   -uninstallIU org.eclipse.xtend.feature.group \
   -uninstallIU org.eclipse.xtend.typesystem.uml2.feature.group \
   -uninstallIU org.eclipse.xtend.typesystem.xsd.feature.group \
   -uninstallIU org.eclipse.xtend.sdk.feature.group \
   -uninstallIU org.eclipse.xtext.xbase.feature.group \
   -uninstallIU org.eclipse.papyrus.compare.feature.feature.group \
   -uninstallIU org.eclipse.emf.compare.feature.group \
   -uninstallIU org.eclipse.emf.compare.diagram.gmf.feature.group \
   -uninstallIU org.eclipse.emf.compare.egit.feature.group \
   -uninstallIU org.eclipse.emf.compare.ide.ui.feature.group \
   -uninstallIU org.eclipse.emf.compare.rcp.ui.feature.group \
   -uninstallIU org.eclipse.emf.compare.uml2.feature.group \
   -uninstallIU org.eclipse.emf.mwe.ui/1.4.0 \
   -uninstallIU com.google.inject/3.0.0.v201605172100 \
   -uninstallIU org.eclipse.xpand/2.2.0.v201605260315 \
   -uninstallIU org.eclipse.xtend.shared.ui/2.2.0.v201605260315 \
   -uninstallIU org.eclipse.xtend.ide/2.18.0.v20190528-0610 \
   -uninstallIU org.eclipse.xtend.typesystem.emf/2.2.0.v201605260315 \
   -uninstallIU org.freemarker/2.3.22.v20160210-1233 \
   -uninstallIU org.eclipse.tools.templates.freemarker/1.0.0.201812111206 \
   -uninstallIU org.eclipse.tools.templates.core/1.1.0.201812111206 \
   -uninstallIU org.eclipse.tools.templates.ui/1.1.1.201812111206 \
   -uninstallIU org.eclipse.tm.terminal.control/4.5.100.201901312304 \
   -uninstallIU javax.xml.stream/1.0.1.v201004272200 \
   -uninstallIU com.sun.xml.bind/2.2.0.v201505121915 \
   -uninstallIU com.google.guava \
   -uninstallIU org.eclipse.xtend.lib.source \
   -uninstallIU org.eclipse.xtend.lib.macro.source \
   -uninstallIU org.eclipse.xtend.core.source \
   -uninstallIU org.eclipse.xtend.ide.common.source \
   -uninstallIU org.eclipse.xtend.ide.source \
   -uninstallIU org.eclipse.xtend.m2e.source \
   -uninstallIU org.eclipse.xtend.standalone.source \
   -uninstallIU org.eclipse.xtext.junit4.source \
   -uninstallIU org.eclipse.xtext.testing.source \
   -uninstallIU org.eclipse.xtext.xbase.junit.source \
   -uninstallIU org.eclipse.xtext.xbase.testing.source \
   -uninstallIU org.eclipse.xtext.ui.testing.source \
   -uninstallIU org.eclipse.xtext.xbase.ui.testing.source \
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
   -installIU org.eclipse.launchbar.feature.group \
   -installIU org.eclipse.xtext.runtime.feature.group \
   -installIU org.eclipse.xtext.ui.feature.group \
   -installIU org.eclipse.xtext.xbase.lib.feature.group \
   -installIU org.eclipse.xtend.feature.group \
   -installIU org.eclipse.xtend.typesystem.uml2.feature.group \
   -installIU org.eclipse.xtend.typesystem.xsd.feature.group \
   -installIU org.eclipse.xtend.sdk.feature.group \
   -installIU org.eclipse.xtext.xbase.feature.group \
   -installIU org.eclipse.papyrus.compare.feature.feature.group \
   -installIU org.eclipse.emf.compare.feature.group \
   -installIU org.eclipse.emf.compare.diagram.gmf.feature.group \
   -installIU org.eclipse.emf.compare.egit.feature.group \
   -installIU org.eclipse.emf.compare.ide.ui.feature.group \
   -installIU org.eclipse.emf.compare.rcp.ui.feature.group \
   -installIU org.eclipse.emf.compare.uml2.feature.group \
   -installIU org.eclipse.emf.mwe.ui/1.4.0 \
   -installIU com.google.inject/3.0.0.v201605172100 \
   -installIU org.eclipse.xpand/2.2.0.v201605260315 \
   -installIU org.eclipse.xtend.shared.ui/2.2.0.v201605260315 \
   -installIU org.eclipse.xtend.ide/2.18.0.v20190528-0610 \
   -installIU org.eclipse.xtend.typesystem.emf/2.2.0.v201605260315 \
   -installIU org.freemarker/2.3.22.v20160210-1233 \
   -installIU org.eclipse.tools.templates.freemarker/1.0.0.201812111206 \
   -installIU org.eclipse.tools.templates.core/1.1.0.201812111206 \
   -installIU org.eclipse.tools.templates.ui/1.1.1.201812111206 \
   -installIU org.eclipse.tm.terminal.control/4.5.100.201901312304 \
   -installIU javax.xml.stream/1.0.1.v201004272200 \
   -installIU com.sun.xml.bind/2.2.0.v201505121915 \
   -installIU com.google.guava \
   -installIU org.eclipse.xtend.lib.source \
   -installIU org.eclipse.xtend.lib.macro.source \
   -installIU org.eclipse.xtend.core.source \
   -installIU org.eclipse.xtend.ide.common.source \
   -installIU org.eclipse.xtend.ide.source \
   -installIU org.eclipse.xtend.m2e.source \
   -installIU org.eclipse.xtend.standalone.source \
   -installIU org.eclipse.xtext.junit4.source \
   -installIU org.eclipse.xtext.testing.source \
   -installIU org.eclipse.xtext.xbase.junit.source \
   -installIU org.eclipse.xtext.xbase.testing.source \
   -installIU org.eclipse.xtext.ui.testing.source \
   -installIU org.eclipse.xtext.xbase.ui.testing.source 


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
   -uninstallIU org.eclipse.launchbar.feature.group \
   -uninstallIU org.eclipse.xtext.runtime.feature.group \
   -uninstallIU org.eclipse.xtext.ui.feature.group \
   -uninstallIU org.eclipse.xtext.xbase.lib.feature.group \
   -uninstallIU org.eclipse.xtend.feature.group \
   -uninstallIU org.eclipse.xtend.typesystem.uml2.feature.group \
   -uninstallIU org.eclipse.xtend.typesystem.xsd.feature.group \
   -uninstallIU org.eclipse.xtend.sdk.feature.group \
   -uninstallIU org.eclipse.xtext.xbase.feature.group \
   -uninstallIU org.eclipse.papyrus.compare.feature.feature.group \
   -uninstallIU org.eclipse.emf.compare.feature.group \
   -uninstallIU org.eclipse.emf.compare.diagram.gmf.feature.group \
   -uninstallIU org.eclipse.emf.compare.egit.feature.group \
   -uninstallIU org.eclipse.emf.compare.ide.ui.feature.group \
   -uninstallIU org.eclipse.emf.compare.rcp.ui.feature.group \
   -uninstallIU org.eclipse.emf.compare.uml2.feature.group \
   -uninstallIU org.eclipse.emf.mwe.ui/1.4.0 \
   -uninstallIU com.google.inject/3.0.0.v201605172100 \
   -uninstallIU org.eclipse.xpand/2.2.0.v201605260315 \
   -uninstallIU org.eclipse.xtend.shared.ui/2.2.0.v201605260315 \
   -uninstallIU org.eclipse.xtend.ide/2.18.0.v20190528-0610 \
   -uninstallIU org.eclipse.xtend.typesystem.emf/2.2.0.v201605260315 \
   -uninstallIU org.freemarker/2.3.22.v20160210-1233 \
   -uninstallIU org.eclipse.tools.templates.freemarker/1.0.0.201812111206 \
   -uninstallIU org.eclipse.tools.templates.core/1.1.0.201812111206 \
   -uninstallIU org.eclipse.tools.templates.ui/1.1.1.201812111206 \
   -uninstallIU org.eclipse.tm.terminal.control/4.5.100.201901312304 \
   -uninstallIU javax.xml.stream/1.0.1.v201004272200 \
   -uninstallIU com.sun.xml.bind/2.2.0.v201505121915 \
   -uninstallIU com.google.guava \
   -uninstallIU org.eclipse.xtend.lib.source \
   -uninstallIU org.eclipse.xtend.lib.macro.source \
   -uninstallIU org.eclipse.xtend.core.source \
   -uninstallIU org.eclipse.xtend.ide.common.source \
   -uninstallIU org.eclipse.xtend.ide.source \
   -uninstallIU org.eclipse.xtend.m2e.source \
   -uninstallIU org.eclipse.xtend.standalone.source \
   -uninstallIU org.eclipse.xtext.junit4.source \
   -uninstallIU org.eclipse.xtext.testing.source \
   -uninstallIU org.eclipse.xtext.xbase.junit.source \
   -uninstallIU org.eclipse.xtext.xbase.testing.source \
   -uninstallIU org.eclipse.xtext.ui.testing.source \
   -uninstallIU org.eclipse.xtext.xbase.ui.testing.source \
   -vmargs \
   -Xms512m \
   -Xmx1024m \
   -XX:+UseParallelGC \
   -XX:PermSize=256M \
   -XX:MaxPermSize=512M
fi
