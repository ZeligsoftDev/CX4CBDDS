%define ifdef()       %if %{expand:%%{?%{1}:1}%%{!?%{1}:0}}
%define ver           2.2.0
%define _defaultRel   0.%(date "+%y%m%d%H%M")
%define _rpmdir       %{_projectdir}/rpm_build/
%define _targetdir    %{_projectdir}/target/
%define _productdir   %{_targetdir}/products/
%define __jar_repack  %{nil}

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

Name:          papyrus-cx-axcioma
Version:       %{ver}
Release:       %{rel}
Summary:       An Eclipse Papyrus extension for modeling with AXCIOMA
License:       Apache License, Version 2.0
BuildArch:     x86_64
URL:           https://github.com/ZeligsoftDev/CX4CBDDS
AutoReqProv:   no
Requires:      java-11-openjdk

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Describe packages
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

%description -n papyrus-cx-axcioma
Papyrus CX for AXCIOMA is a modelling environment based on Eclipse Papyrus
for modeling component-based systems built on AXCIOMA according to the OMG CCM standard.

%install
%{__mkdir_p} %{buildroot}/opt/
cp %{_productdir}/com.zeligsoft.papyrus-cx.axcioma.rcp.product-linux.gtk.x86_64.zip %{buildroot}/opt/
cd %{buildroot}/opt/
unzip com.zeligsoft.papyrus-cx.axcioma.rcp.product-linux.gtk.x86_64.zip
rm com.zeligsoft.papyrus-cx.axcioma.rcp.product-linux.gtk.x86_64.zip
%{__mkdir_p} %{buildroot}/usr/share/applications/
echo "[Desktop Entry]
Encoding=UTF-8
Name=Papyrus CX for AXCIOMA
Comment=Papyrus CX for AXCIOMA
Exec=/opt/papyrus-cx-axcioma/papyrus-cx
Icon=/opt/papyrus-cx-axcioma/icon.xpm
Categories=Application;Development;Java;IDE
Version=1.0
Type=Application
Terminal=false
StartupNotify=true" > %{buildroot}/usr/share/applications/papyrus-cx-axcioma.desktop

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Allocate files
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

%files
/opt/%{name}/
/usr/share/applications/papyrus-cx-axcioma.desktop

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# Define RPM scripts (%%pre and %%post sections)
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
%pre

%post

%postun
