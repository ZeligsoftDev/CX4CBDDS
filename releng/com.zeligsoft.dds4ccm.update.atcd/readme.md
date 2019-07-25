# Adding plug-ins and features to category.xml

This document is a quick tutorial on how to get a working category.xml file working.
You will find yourself editing it in one of the following circumstances:

- DDS4CCM is upgrade to a new Eclipse base version
- A new dependency is added to DDS4CCM

In other case, you will likely encounter problems when trying to install DDS4CCM in a clean RSA
environment. The Eclipse Install New Software wizard may report a failure such as the following:

> Cannot complete the install because one or more required items could not be found.
>>  Software being installed: CX Base Components 3.6.6.201903081520 (com.zeligsoft.base.feature.group 3.6.6.201903081520)  

>> Missing requirement: Zeligsoft Domain Language Core 3.5.1.201903081520 (com.zeligsoft.base.zdl 3.5.1.201903081520) requires 'bundle org.eclipse.xtend.shared.ui [1.0.1,2.1.0)' but it could not be found

>> Cannot satisfy dependency:  
>>>    From: CX Base Components 3.6.6.201903081520 (com.zeligsoft.base.feature.group 3.6.6.201903081520)  

>>>   To: com.zeligsoft.base.zdl [3.5.1.201903081520]
In the case, the error is telling you that the bundle `org.eclipse.xtend.shared.ui` is not part
of the p2 repository created by our build.

To fix this, your goals are:

1. Identify a p2 repository that contains the required bundle.
2. Identify an appropriate feature that includes the bundle.
3. Update the category.xml file to include that feature.

## Identifying an appropriate p2 repository as the source of a missing bundle

DDS4CCM already assembles plug-ins from the following p2 repositories:

- Eclipse Luna (4.4) release: `http://download.eclipse.org/releases/luna/`
- Eclipse CDT 8.6 release: `http://download.eclipse.org/tools/cdt/releases/8.6`

The repositories are encoded in `releng/com.zelgisoft.dds4ccm.configuration/pom.xml`.
If you need to change or add repositories, you do it in that POM file.

For the most part, you will find the missing bundle in the Luna repository.
If you are adding a completely new feature, you may have to add another repository.

If adding a new repository, be aware of its durability. Release repositories from Eclipse
a generally published forever. If you doubt the repository you are using will last that
long, consider copying it to the `deps` folder, and using a `file:` protocol in the POM file.
This is the case for the RSA 9.5 repository.

## Finding a feature contining the missing bundle

This requires some p2 wizard work. Much of what is found below is a summary of this
[Paul Webster StackOverflow article](https://stackoverflow.com/questions/10025599/how-to-find-out-which-feature-contains-a-needed-plug-in-on-an-eclipse-download-s).

Steps:

- Start RSA, or any modern Eclipse IDE.
- Open the Console view.
- From the Open Console tool button, choose 'Host OSGi Console'
- Type the following text to find the bundle number of the 'P2 Console':

	> ss p2.console
	
- You will receive an response such as:

	 id	State	Bundle
	 
	 858	ACTIVE	org.eclipse.equinox.p2.console_1.0.300.v20131113-1212
- Start the bundle with the following command:

	> start 858
- Query the p2 repository for your missing bundle with the following command:

	> provlquery http://download.eclipse.org/releases/luna "select(parent | parent.properties['org.eclipse.equinox.p2.type.group'] == true && parent.requirements.exists(rc | everything.exists(iu | iu.id == 'org.eclipse.xtend.shared.ui' && iu ~= rc)))" true
- (Note you have to use your p2 repo URL (near the start) and your missing bundle id (near the end).
- The search can take several minutes. Get yourself a coffee. Eventually, the output will look like:

	org.eclipse.xpand.ui.feature.group 2.0.0.v201406030414
	org.eclipse.xtend.typesystem.emf.feature.group 2.0.0.v201406030414
	org.eclipse.xtend.typesystem.uml2.feature.group 2.0.0.v201406030414
	org.eclipse.xtend.typesystem.xsd.feature.group 2.0.0.v201406030414
	org.eclipse.xtend.ui.feature.group 2.0.0.v201406030414
	
- Use the dds4ccm.aggr file (with CBI Aggregator Editor and Engine installed) to browse your
source repository for the listed features. (They will not include the `.feature.group` suffix.)
- As you find a feature, expand its 'Requirements' subfolder, and ensure your bundle appears with 
a full version number. If not, this feature will not aggregate your bundle.
- Choose the feature that aggregates your bundle version. Record it's id (again, without the `.feature.group` suffix), and its version.
- Edit category.xml to include new set of lines like the following:

	<feature
		url="features/org.eclipse.xtend.ui_2.0.0.v201406030414.jar"
		id="org.eclipse.xtend.ui"
		version="2.0.0.v201406030414">
		<category name="com.zelgisoft.dds4ccm.deps.category" />
	</feature>

- If you cannot find an acceptable feature (either, there is not, or the one you found is 'too big'), you can add a bundle definition to category.xml, instead:

	<bundle id="com.google.guava" version="15.0.0.v201403281430">
		<category name="com.zelgisoft.dds4ccm.deps.category"/>
	</bundle>
	
- Include the feature in the correct category (or categories), as specified by the `category-def` elements.
- Build dds4ccm again.
- Attempt to install it, again. Rinse and repeat until all your dependencies are resolved.