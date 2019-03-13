# Building DDS4CCM

DDS4CCM is a Rational Software Architect (RSA) add-in for modeling component based systems
according to the OMG CCM standard.

## Build requirements

The build requires:

- a Java 8 or later JRE
- Maven 3.6.0 or later.

## Building

* Clone the DDS4CCM git repository.
* Start a shell, and change directory to the repository root.
* To run the build, execute the following commands

<pre>
	\# increase Maven memory
	export MAVEN_OPTS="-Xmx1024m"
	\# build
	mvn -D "dds4ccm.root=\`pwd\`" clean verify
</pre>

In Windows environments, you can use the fully qualified path name of the current
directory rather than using the result of the embedded `pwd` command.

On macOS, it was is necessary to increase the shell's maximum number of open files.
The following was found to be acceptable:

	ulimit -Sn 1024
	
The p2 repository produced by the build will be found in `releng/com.zeligsoft.dds4ccm.update/target`:

* The sub directory `repository` is the created p2 repository. 
* The file `com.zeligsoft.dds4cmm.update-<version>-SNAPSHOT.zip` is zip of this repository.
* The build also creates a ZIP file with a date, in place of SNAPSHOT. The files are identical.
The later file is useful for distributing regular builds to a file server, allowing you
to distinguish build between results of successive builds.
