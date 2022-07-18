# Building DDS4CCM

DDS4CCM is a Papyrus add-in for modeling component based systems
according to the OMG CCM standard.

DDS4CCM has support for the following CCM implementations:
- [AXCIOMA](https://www.axcioma.org)

## Build requirements

The build requires:

- a Java 11 or later JRE
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
	# build the Papyrus 4.8 patch
	cd papyrus-patch/v4.8.0
	../../mvnw clean verify
	cd ../..
	# build papyrus-cx
	./mvnw clean verify
</pre>

In Windows environments:

<pre>
        REM increase Maven memory
        set MAVEN_OPTS="-Xmx1024m"
        REM build the papyrus patch
        cd papyrus-patch\v4.8.0
        ..\..\mvnw.cmd clean verify
        cd ..\..
        REM set build directory variable
        mvnw.cmd clean verify
</pre>

On macOS, it was is necessary to increase the shell's maximum number of open files.
The following was found to be acceptable:

<pre>
	ulimit -Sn 1024
</pre>

The build creates an Eclipse 'product' and more traditional P2 repositories.
The 'product' builds are easier to install; they contain a complete eclipse environment.
Built products are found under `releng/com.zeligsoft.papyrus-cx.axcioma.rcp.product/target/products/`.
They are either `zip` or `tar.gz` files, depending on the target platform.

The folders `releng/com.zeligsoft.papyrus-cx.axcioma.rcp.product/target/products/com.zeligsoft.papyrus-cx.axcioma.rcp.product/<os>/<ui>/<arch>/papyrus-cx-axcioma/`
contain the images used to create the above archives.
You can execute the `papyrus-cx` executable located in these folders to start Papyrus.


The following p2 repositories are created by the build:
* Papyrus 4.8.0 patch: `papyrus-patch/v4.8.0/site-papyrus-patch/target/papyrus_v480_patch_<version>.zip`
* Axcioma release: `releng/com.zeligsoft.dds4ccm.update.axcioma/target\dds4ccm_axcioma_<version>.zip`
* ATCD release: `releng/com.zeligsoft.dds4ccm.update.atcd/target\dds4ccm_atcd_<version>.zip`

The build also creates a ZIP ending with `SNAPSHOT.zip`. The files are identical to the above.
The dated ZIP files are useful for distributing regular builds to a file server, allowing you
to distinguish build between results of successive builds.

## Installing from p2 repositories

DDS4CCM can be installed in Eclipse Papyrus 2020-06 release (4.8.0).
The release can be downloaded from `https://www.eclipse.org/downloads/download.php?file=/modeling/mdt/papyrus/rcp/2020-06/4.8.0/papyrus-2020-06-4.8.0-linux64.tar.gz`.
A default installation should be sufficient. To install:


### Install CX

1. Start Papyrus as a super user. **This is important.**
2. From the **Help** menu, choose **Install New Software** to start the **Install** wizard.
3. On the **Available Software** page, click the **Add** button, to add a new software site.
4. In the **Add Repository** dialog, click the **Archive** button, and in the dialog, browse for
the `dds4ccm_axcioma_<version>.zip` file. Click **OK**.
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

