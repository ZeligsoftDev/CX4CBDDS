Updating the meta-model
=======================

This documents describes the steps to follow when updating one of the Papyrus CX meta-models, either adding new concepts or modifying existing ones.


1. Select the appropriate Papyrus model with the meta-model to update. Possibilities include (from more general to more specific):
    a) Base ZDL
    b) ZMLMM
    c) (OMG) CCM
    d) DDS4CCM
    Other alternatives are possible, such as the various "connectors" for AXCIOMA

2. Setup the environment:
    * In a runtime instance, import the plugin containing the required meta-model(s) as well as the "bundles/com.zeligsoft.domain.cbdds.architecture" plugin. (For example, for DDS4CCM, import bundles/com.zeligsoft.domain.dds4ccm)

3. Make changes to the meta-model:
    * In the runtime instance, open and modify the Papyrus (meta)-model with the changes, adding/editing the relevant concept(s) save. (For example edit the file bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM(.di/.uml/.notation). Find the package containing the relevant element(s) and add elements by right-clicking the in the Model Explorer and use the "Add ZDL" menu to add Domain elements.

4. (Re)generate the corresponding profile:
    1. Open the ZDL model: In the Project Explorer, unfold the Papyrus item of the (meta)-model, and open its zdlgen file with the ZDLGen Model Editor. (For example bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.zdlgen).
    2. Reload the ZDL model:
        1. Select the top model element (ZDL Generator Model)
        2. In the ZDLGenEditor menu, select "Reload..."
        3. In the dialog, ensure that the file under "ZDL model selection" is the UML file for the meta-model (e.g. bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.uml)
        4. Click Next
        5. Ensure that under "Generator models to reference" all the relevant models are selected.
        6. Click Finish
        7. Verify that the new/updated concepts appear in the reloaded ZDL model
        8. Select the new or edited model element and in the Properties view, navigate to "Profile Mapping -> UML Metaclass" and if it is not set, set it to the relevant UML meta-class.
        9. Save
        This will update the zdlgen file (e.g. bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.zdlgen)
    3. Generate the profile:
        1. Select and right-click the ZDL domain element (e.g. "DDS4CCM domain"; usually found after "Block" elements and before the "Palette" and "Menu" elements; note that this is *neither* the top element *nor* the immediate child of the top element.)
        2. Select "DDK -> Papyrus -> Generate Profile"
        3. When asked "The selected profile already exists. Merge changes into it?" answer "Yes"/"OK".

    This will run an xtend transformation so it may take a bit.

    The result should modify the following files:
        a) The profile itself: <name>.profile.uml (e.g. bundles/com.zeligsoft.domain.dds4ccm/profiles/dds4ccm.profile.uml)
        b) The element-types configurations of the domain architecture: <name>.elementtypesconfigurations (bundles/com.zeligsoft.domain.cbdds.architecture/elementtypes/cxDDS4CCM.elementtypesconfigurations)

    Additionally, for some models such as DDS4CCM, it may touch the following:
        c) The IDL primitives: bundles/com.zeligsoft.domain.dds4ccm/libraries/IDLPrimitives.uml
    These changes should be discarded and not committed to the git repository.

    Note about the element-types configuration: it is worth checking that the element types for the new or updated elements have the correct values set. In particular, check that the "Specialized Types" of the element type include the most relevant type first in the list. For example, if the list includes "UML::NamedElement" and "UML::Property" in that order, then Papyrus will consider this element as a UML::NamedElement, even if you intended it to be a Property, and this may cause problems, for example, menu actions to create the element will fail to create it in a context that expects a Property (such as a Component or Class) rather than a plain NamedElement.

5. (Re)generate the ZDL model API:
    1. Open the ZDL model: In the Project Explorer, unfold the Papyrus it   em of the (meta)-model, and open its zdlgen file with the ZDLGen Model Editor. (For example bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.zdlgen).
    2. Generate the API:
        1. Unfold the top element and right-click on its immediate child, the "Domain Model" element (e.g. "Domain Model DDS4CCM")
        2. Select "DDK -> Papyrus -> Generate API"
    3. If the workspace doesn't link to the relevant API project in the git repository (e.g. bundles/com.zeligsoft.domain.dds4ccm.api) then you may have to manually copy the generated code to the git repository.

6. (Re)generate the profile API (for static profiles such as DDS4CCM) from the genmodel:
    1. Open the genmodel: In the Project Explorer, unfold the Papyrus item of the profile, and open its genmodel file with the EMF Generator editor. (For example bundles/com.zeligsoft.domain.dds4ccm/profiles/dds4ccm.profile.genmodel).
    2. Reload the genmodel:
        1. Select the top model element
        2. In the Generator menu, select "Reload..."
        3. In the dialog, under "Select Model Importer", choose "UML model" and click "Next"
        4. A pop-up will get show a Warning message. Click "OK"
        5. In the UML Import dialog, under "Model URIs" ensure that the URI is the UML file for the profile (e.g. bundles/com.zeligsoft.domain.dds4ccm/profiles/dds4ccm.profile.uml)
        4. Click Next
        5. Ensure that under "Referenced generator models" all the relevant models are selected. This should normally include:
            a) Ecore: org.eclipse.emf.ecore
            b) UML2 Types: org.eclipse.uml2.types
            c) UML2: org.eclipse.uml2.uml
        6. Click Finish
        7. Verify that the new/updated concepts appear in the reloaded ZDL model
        8. Save
        This will update both the genmodel file and the corresponding ecore file (e.g. bundles/com.zeligsoft.domain.dds4ccm/profiles/dds4ccm.profile.genmodel and bundles/com.zeligsoft.domain.dds4ccm/profiles/dds4ccm.ecore)
    3. Generate code: right-click the top-element of the genmodel and select "Generate Model code".

    This should add new classes for new elements, modify classes for existing elements that were modified and update some utility and factory classes, but it should not modify any unrelated classes.

7. Add menu items:
    1. Open the ZDL model: In the Project Explorer, unfold the Papyrus item of the (meta)-model, and open its zdlgen file with the ZDLGen Model Editor. (For example bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.zdlgen).
    2. Add a new menu item:
        1. Unfold the model and unfold the "Menu Model"
        2. Right-click the "Menu Model" and select "New Child -> Menu Create Action" (or any other relevant element)
        3. If a new Create Action was created, select it and in the Properties view, unfold "Domain Menu" and click on the "Create Concept" field and select the Domain Concept to create.
        4. Select a relevant (Menu) item (e.g. DDS4CCMModuleMenu), unfold "Domain Menu" and double-click in the "Item" field. In the dialog, select the new (Create) action on the left pane and add it to the right pane. Edit the order as desired. Click "OK".
    3. (Re)generate the Menu model:
        1. Select and right-click the ZDL domain element (e.g. "DDS4CCM domain"; usually found after "Block" elements and before the "Palette" and "Menu" elements; note that this is *neither* the top element *nor* the immediate child of the top element.)
        2. Select "DDK -> Papyrus -> Generate Menu Model"
        3. When asked "The selected menu model already exists. Merge changes into it?" answer "Yes"/"OK".

    This should modify the "toolingmodel" file (e.g. bundles/com.zeligsoft.domain.dds4ccm/models/DDS4CCM.toolingmodel)
