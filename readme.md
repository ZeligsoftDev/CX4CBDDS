# Building DDS4CCM

DDS4CCM is a Papyrus add-in for modeling component based systems
according to the OMG CCM standard.

DDS4CCM has support for the following CCM implementations:
- [AXCIOMA](https://www.axcioma.org)

## Build requirements

The build requires:

- a Java 8 or later JRE
- The build will automatically install an appropriate Maven version

## Building

A github action automatically builds master and papyrus branches as well as all pull requests. 

To build manually;

1. Clone the DDS4CCM git repository.
2. Start a shell, and change directory to the repository root.
3. Checkout the `papyrus` branch.
4. To run the build, execute the following commands

<pre>
	# increase Maven memory
	export MAVEN_OPTS="-Xmx1024m"
	# build
	./mvnw -D "dds4ccm.root=`pwd`" clean verify
</pre>

In Windows environments, you can use the fully qualified path name of the current
directory rather than using the result of the embedded `pwd` command, or set the
DDS4CCM_ROOT environment variable before running:

<pre>
        REM increase Maven memory
        set MAVEN_OPTS="-Xmx1024m"
        REM set build directory variable
        set DDS4CMM_ROOT=<fully qualified build path>
        mvnw.cmd clean verify
</pre>

On macOS, it was is necessary to increase the shell's maximum number of open files.
The following was found to be acceptable:

<pre>
	ulimit -Sn 1024
</pre>

The p2 repositories produced by the build will be found in `releng/com.zeligsoft.dds4ccm.update.atcd/target` 
and `releng/com.zeligsoft.dds4ccm.update.axcioma/target`:

* The sub directory `repository` is the created p2 repository. 
* The files `com.zeligsoft.dds4cmm.update.atcd-<version>-SNAPSHOT.zip` and `com.zeligsoft.dds4cmm.update.axcioma-<version>-SNAPSHOT.zip` 
are zip archives of these repositories.
* The build also creates a ZIP file with a date, in place of SNAPSHOT. The files are identical.
The later file is useful for distributing regular builds to a file server, allowing you
to distinguish build between results of successive builds.

## Installing

DDS4CCM can be installed in Eclipse Papyrus 2019-06 release (4.4.0). 
The release can be downloaded from `https://www.eclipse.org/papyrus/download.html`.
A default installation should be sufficient. To install:

1. Start Papyrus as a super user. **This is important.**
2. From the **Help** menu, choose **Install New Software** to start the **Install** wizard.
3. On the **Available Software** page, click the **Add** button, to add a new software site.
4. In the **Add Repository** dialog, click the **Archive** button, and in the dialog, browse for
the `com.zeligsoft.dds4ccm.update.atcd-*.zip` or `com.zeligsoft.dd44ccm.update.axcioma-*.zip` file. Click **OK**.
5. Click **OK** to close the **Add Repository** dialog.
6. On returning to the **Install** dialog, check the checkbox beside **CX CBDDS**.
Optionally, you may check **CDT** to install the C/C++ development tools.
The **CX CBDDS Runtime Dependencies** features are always installed if you select
**CX CBDDS**. They are listed primarily for developers.
7. With the installation features selected, press **Next**.
8. On the **Install Details** page, you should see additional information on features to
be installed.
If error messages are reported, please contact us. Click **Next** to continue.
9. On the **Review Licenses** page, click the **I accept...** radio button, then click **Finish**.
10. During the execution of the wizard, your may be prompted to approve the installation
of unsigned features. This will all have `com.zeligsoft` as a prefix to their names. Approve them.
11. Once the install has completed, you will be prompted to restart Papyrus. Do this.
12. Once restarted, you may exit Papyrus (which you started as a super user in step 1).

## Using CX CBDDS (aka DDS4CCM)

To use CX CBDDS:
1. start Papyrus as a regular user.
2. Choose a 'workspace' location, if prompted. This will be the disk location where your
DDS4CCM projects will be stored.
3. From the **File** menu, click on **New > Papyrus Project**. 
This will open up the **New Papyrus Project** wizard.
4. In the **Architecture Contexts** section of the **New Papyrus Project** page, 
there should be options for selecting **ATCD** or **AXCIOMA** under **Software Engineering** context.
Selecting one of these options will show up respective viewpoints in the **Architecture Viewpoints** section.
5. Select an architecture context and click **Next**.
6. Enter a project name and click **Next** to continue.
7. In the **Initialization Information** page, enter a root model element name and click **Finish**.
8. This should create a Papyrus model with appropriate profile and stereotype application. 
Clicking on the model in the **Model Explorer** view shows the relevant information in the **Properties** tab.     

Further tutorial information is not currently stored in this project.

