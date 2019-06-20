# Building DDS4CCM

DDS4CCM is a Rational Software Architect (RSA) add-in for modeling component based systems
according to the OMG CCM standard.

## Build requirements

The build requires:

- a Java 8 or later JRE
- Maven 3.6.0 or later.

## Building

Another trival change

1. Clone the DDS4CCM git repository.
2. Start a shell, and change directory to the repository root.
3. To run the build, execute the following commands

<pre>
	# increase Maven memory
	export MAVEN_OPTS="-Xmx1024m"
	# build
	mvn -D "dds4ccm.root=`pwd`" clean verify
</pre>

In Windows environments, you can use the fully qualified path name of the current
directory rather than using the result of the embedded `pwd` command.

On macOS, it was is necessary to increase the shell's maximum number of open files.
The following was found to be acceptable:

<pre>
	ulimit -Sn 1024
</pre>

The p2 repository produced by the build will be found in `releng/com.zeligsoft.dds4ccm.update/target`:

* The sub directory `repository` is the created p2 repository. 
* The file `com.zeligsoft.dds4cmm.update-<version>-SNAPSHOT.zip` is zip of this repository.
* The build also creates a ZIP file with a date, in place of SNAPSHOT. The files are identical.
The later file is useful for distributing regular builds to a file server, allowing you
to distinguish build between results of successive builds.

## Installing

DDS4CCM can be installed in Rational Software Architect (RSA), versions 9.5, 9.6 or 9.7.
A default RSA installation should be sufficient. To install:

1. Start RSA as a super user. **This is important.**
2. From the **Help** menu, choose **Install New Software** to start the **Install** wizard.
3. On the **Available Software** page, click the **Add** button, to add a new software site.
4. In the **Add Repository** dialog, click the **Archive** button, and in the dialog, browse for
the `com.zeligsoft.dds4ccm.update-*.zip` file. Click **OK**.
5. Click **OK** to close the **Add Repository** dialog.
6. On returning to the **Install** dialog, check the checkbox beside **CX CBDDS**.
Optionally, you may check **CDT** to install the C/C++ development tools.
The **CX CBDDS Runtime Dependencies** features are always installed if you select
**CX CBDDS**. They are listed primarily for developers.
7. With the your installation features selected, press **Next**.
8. On the **Install Details** page, you should see additional information on features to
be installed.
If error messages are reported, please contact us. Click **Next** to continue.
9. On the **Review Licenses** page, click the **I accept...** radio button, then click **Finish**.
10. During the execution of the wizard, your may be prompted to approve the installation
of unsigned features. This will all have `com.zeligsoft` as a prefix to their names. Approve them.
With RSA 9.6 and RSA 9.7, you may be prompted to approve the signing certificate for Eclipse.org.
Approve it.
11. Once the install has completed, you will be prompted to restart RSA. Do this.
12. Once restarted, you may exit RSA (which you started as a super user in step 1).

## Using CX CBDDS (aka DDS4CCM)

To use CX CBDDS:
1. start RSA as a regular user.
2. Choose a 'workspace' location, if prompted. This will be the disk location where your
DDS4CCM projects will be stored.
3. Ensure the DDS4CCM 'perspective' is open: Choose **Window** > **Open Perspective** >
**Other**, and choose **DDS4CCM**. Click **OK**.
4. The **File** menu will then have an option **New DDS4CCM Project**.

Further tutorial information is not currently stored in this project.