#!/bin/bash

echo "This script leads you through the creation of a Papyrus patch..."

read -p "Papyrus GIT repository url (default: https://git.eclipse.org/r/papyrus/org.eclipse.papyrus.git): " papyrus_git_url
read -p "Papyrus release tag (e.g. 4.8.0_RC2): " papyrus_tag
read -p "Git repository path of plug-in: " patch_plugin_gitpath
read -p "Plug-in being patched (e.g.: org.eclipse.papyrus.uml.properties): " patched_plugin
read -p "Feature containing patched plug-in (e.g.: org.eclipse.papyrus.uml.properties.feature): " patched_feature
read -p "Verion of feature being patched: " patched_feature_version
read -p "Project version (e.g. 2.2.0): " project_version

year=$(date +"%Y")

base_version="${papyrus_tag%_*}"
compressed_version="${base_version//./}"

function git_sparse_clone() (
  rurl="$1" tag="$2" localdir="$3" && shift 3

  mkdir -p "$localdir"
  cd "$localdir"

  git init
  git remote add -f origin "$rurl"

  git config core.sparseCheckout true

  # Loops over remaining args
  for i; do
    echo "$i" >> .git/info/sparse-checkout
  done

  git checkout tags/$tag
  #git pull origin master
)

base_dir=v$base_version
mkdir -p "${base_dir}"

cat <<EOF >$base_dir/pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.zeligsoft.dds4ccm</groupId>
	<artifactId>com.zeligsoft.dds4ccm.papyrus-patch-v${compressed_version}</artifactId>
	<version>${project_version}-SNAPSHOT</version>
	<packaging>pom</packaging>

	<parent>
		<groupId>com.zeligsoft.dds4ccm</groupId>
		<artifactId>com.zeligsoft.dds4ccm.root</artifactId>
		<version>${project_version}-SNAPSHOT</version>
		<relativePath>../..</relativePath>
	</parent>

	<modules>
	    <!--
	    The actual plug-in(s) we are patching.
	    -->
	    <module>${patched_plugin}</module>
	    <!--
	    The feature patch that bundles the patched plugins
	    -->
		<module>feature-com.zeligsoft.papyruspatch</module>

		<module>site-papyrus-patch</module>
    </modules>
</project>
EOF

# make patch dir
feature_dir=$base_dir/feature-com.zeligsoft.papyruspatch
mkdir -p $feature_dir

cat <<EOF >$feature_dir/feature.xml
<?xml version="1.0" encoding="UTF-8"?>
<feature
      id="com.zeligsoft.papyruspatch"
      label="CX4CBDDS Patch for Papyrus $tag"
      version="${project_version}.qualifier"
      provider-name="Zeligsoft">

   <description>
      CX4CBDDS patches for Papyrus $tag
   </description>

   <copyright>
      Copyright (c) ${year} Zeligsoft and others
   </copyright>

   <license url="http://www.apache.org/licenses/LICENSE-2.0">
      Apache 2.0

http://www.apache.org/licenses/LICENSE-2.0
   </license>

   <requires>
      <!-- The version number here is critical.
        It is the version Papyrus feature (org.eclipse.papyrus.uml.tools.feature) we are patching
        -->
      <import feature="$patched_feature" version="$patched_feature_version" patch="true"/>
   </requires>

   <!-- Here, we include all the plug-ins we are replacing -->
   <plugin
         id="$patched_plugin"
         download-size="0"
         install-size="0"
         version="0.0.0"
         unpack="false"/>

</feature>
EOF

cat <<EOF >$feature_dir/category.xml
<?xml version="1.0" encoding="UTF-8"?>
<site>
   <feature url="features/com.zeligsoft.papyrus.patch_${project_version}.qualifier.jar" id="com.zeligsoft.papyrus.patch" version="${project_version}.qualifier" patch="true">
      <category name="com.zeligsoft.papyrus.patch"/>
   </feature>
   <category-def name="com.zeligsoft.papyrus.patch" label="Dummy category for p2 bug $262009">
      <description>
         Dummy; please vote for https://bugs.eclipse.org/bugs/show_bug.cgi?id=262009 .
      </description>
   </category-def>
</site>
EOF

cat <<EOF >$feature_dir/build.properties
bin.includes = feature.xml
EOF

# make update site dir
update_site_dir=$base_dir/site-papyrus-patch
mkdir -p "$update_site_dir"

cat <<EOF >$update_site_dir/pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.zeligsoft.dds4ccm</groupId>
	<artifactId>com.zeligsoft.dds4ccm.papyrus-patch-site-v${compressed_version}</artifactId>
	<version>${base_version}-SNAPSHOT</version>
	<packaging>eclipse-update-site</packaging>

	<parent>
		<groupId>com.zeligsoft.dds4ccm</groupId>
		<artifactId>com.zeligsoft.dds4ccm.papyrus-patch-v${compressed_version}</artifactId>
		<version>${project_version}-SNAPSHOT</version>
	</parent>

	<build>
	    <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                        <configuration>
                            <appendAssemblyId>false</appendAssemblyId>
                            <descriptors>
                                <descriptor>zip.xml</descriptor>
                            </descriptors>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                    <groupId>com.coderplus.maven.plugins</groupId>
                    <artifactId>copy-rename-maven-plugin</artifactId>
                    <version>1.0</version>
                    <executions>
                        <execution>
                            <id>copy-site-zip</id>
                            <phase>package</phase>
                            <goals>
                                <goal>copy</goal>
                            </goals>
                            <configuration>
                                <sourceFile>target/com.zeligsoft.dds4ccm.papyrus-patch-site-v${compressed_version}-\${unqualifiedVersion}-SNAPSHOT.zip</sourceFile>
                                <destinationFile>target/papyrus_v${compressed_version}_patch_\${unqualifiedVersion}.v\${buildQualifier}.zip</destinationFile>
                            </configuration>
                        </execution>
                    </executions>
            </plugin>
        </plugins>
    </build>
</project>
EOF

cat <<EOF >$update_site_dir/site.xml
<?xml version="1.0" encoding="UTF-8"?>
<site>
   <category-def name="com.zeligsoft.cx.papyruspatch" label="Papyrus Patch (required)">
      <description>
         Provides Papyrus patches for CX4CBDDS.
      </description>
   </category-def>

   <feature id="com.zeligsoft.papyruspatch" url="features/com.zeligsoft.papyruspatch_${base_version}.qualifier.jar" version="${base_version}.qualifier">
      <category name="com.zeligsoft.cx.papyruspatch"/>
   </feature>

</site>
EOF

cat <<EOF >$update_site_dir/zip.xml
<assembly xmlns="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2 http://maven.apache.org/xsd/assembly-1.1.2.xsd">

    <!--
    Define the contents of the update-site archive ZIP
    -->
    <id>zip</id>
    <includeBaseDirectory>false</includeBaseDirectory>

    <formats>
        <format>zip</format>
    </formats>
    <fileSets>
        <fileSet>
            <directory>\${project.build.directory}/site</directory>
            <outputDirectory>/</outputDirectory>
        </fileSet>
    </fileSets>
</assembly>
EOF

git_sparse_clone "$papyrus_git_url" "$papyrus_tag" "./tmp" "$patch_plugin_gitpath"

mv ./tmp/$patch_plugin_gitpath $base_dir
rm -fr tmp
