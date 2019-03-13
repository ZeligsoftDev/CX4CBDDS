/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.zeligsoft.cx.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Creates content for Zeligsoft project and model wizard
 * 
 * @author ysroh
 * 
 */
public class ZeligsoftModelWizardContentCreator {

	// SCA build environment class name
	private final static String MODEL_CONFIGURATION_QUALIFIED_NAME = "ZML C Build::ModelConfiguration"; //$NON-NLS-1$

	private static final URI MODEL_CONFIGURATION_URI = URI.createURI(
		"pathmap://ZML_LIBRARIES/ZML_C_Build.library.uml", true); //$NON-NLS-1$

	/**
	 * Create a model using given template path and save it under given project
	 * name. Project will be created if necessary
	 * 
	 * @param projectName
	 *            Name of the project that the model will be created under.
	 * @param destFolder
	 *            The full path of the destination folder of the new model. If destFolder is null, it means we create
	 *            the project in the workspace, otherwise we are creating outside of the workspace
	 * @param modelFolder
	 *            Model folder that is relative to the project folder path
	 * @param modelName
	 *            Name of the new model.
	 * @param templatePath
	 *            The URI to the template file.
	 * @param templateFileName
	 *            The Filename of the template model.
	 * @return
	 */
	public static boolean createContent(String projectName, 
			
			String destFolder,
			String modelFolder,
			String modelName,
			String modelConcept,
			String cdtProjectName, 
			URI templateURI,
			String templateFileName,
			String perspectiveID) {
		return createContent(projectName, destFolder, modelFolder, modelName, modelConcept, cdtProjectName, templateURI, 
				templateFileName, perspectiveID, MODEL_CONFIGURATION_URI, MODEL_CONFIGURATION_QUALIFIED_NAME, 
				new HashMap<String, String>());
	}
	
	public static boolean createContent(String projectName, 
			
			String destFolder,
			String modelFolder,
			String modelName,
			String modelConcept,
			String cdtProjectName, 
			URI templateURI,
			String templateFileName,
			String perspectiveID,
			URI modelConfigurationUri,
			String modelConfigurationName,
			HashMap<String, String> modelConfigurationAttributes) {
		
		if (perspectiveID == null){
			perspectiveID = "com.zeligsoft.cx.ui.CXPerspective"; //$NON-NLS-1$
		}

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (UML2Util.isEmpty(projectName)) {
			projectName = getAvailableProjectName();
		}
		IProject project = root.getProject(projectName);
		boolean isModelWizard = true;
		if (!project.exists()) {
			isModelWizard = false;
			try {
				if (UML2Util.isEmpty(destFolder)){
					project.create(null);
				} else {
					IProjectDescription projDesc = root.getWorkspace().newProjectDescription(projectName);
					projDesc.setLocation(new Path(destFolder));
					project.create(projDesc, null);
				}
				project.open(null);
			} catch (CoreException e) {
				ZeligsoftCXUIPlugin
					.getDefault()
					.error(
						Messages.ZeligsoftModelWizardContentCreator_ProjectCreationFailedLog,
						e);
				return false;
			}
		}

		String newFileName;
		newFileName = modelName + ".emx"; //$NON-NLS-1$

		if (!UML2Util.isEmpty(modelFolder)) {
			IFolder dest = project.getFolder(modelFolder);
			if (!dest.exists()) {
				try {
					dest.create(true, true, null);
					project.refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (CoreException e) {
					ZeligsoftCXUIPlugin
							.getDefault()
							.error(Messages.ZeligsoftModelWizardContentCreator_ModelFolderCreationFailed,
									e);
				}
			}
		}
		// Get template to copy
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource template = resourceSet.getResource(templateURI, true);

		// Save template on current project
		String modelPath;
		if (UML2Util.isEmpty(destFolder)) {
			modelPath = projectName + System.getProperty("file.separator"); //$NON-NLS-1$
		} else {
			modelPath = destFolder + System.getProperty("file.separator"); //$NON-NLS-1$
		}
		if (!UML2Util.isEmpty(modelFolder)) {
			modelPath = modelPath + modelFolder
					+ System.getProperty("file.separator"); //$NON-NLS-1$
		}
		modelPath = modelPath + newFileName;

		URI modelURI;
		if (UML2Util.isEmpty(destFolder) || isModelWizard) {
			modelURI = URI.createPlatformResourceURI(modelPath, true);
		} else {
			modelURI = URI.createFileURI(modelPath);
		}
		Resource modelResource = resourceSet.createResource(modelURI);
		modelResource.getContents().add(template.getContents().get(0));
		Package model = (Package) (modelResource.getContents().get(0));
		model.setName(modelName);
		if( modelConcept != null) {
			ZDLUtil.addZDLConcept(model, modelConcept);
		}

		// Create Instance Specification of the model configuration and set the
		// CDT project name
		Class modelConfigurationClassifier = getModelConfiguration(resourceSet, modelConfigurationUri, modelConfigurationName);
		InstanceSpecification instance = (InstanceSpecification) model
			.createPackagedElement(
				Messages.ZeligsoftModelWizardContentCreator_modelConfigurationInstanceName,
				UMLPackage.Literals.INSTANCE_SPECIFICATION);

		instance.getClassifiers().add(modelConfigurationClassifier);
		
		String defaultCdtProjectName = UML2Util.isEmpty(cdtProjectName) ? "" //$NON-NLS-1$
				: cdtProjectName;
		modelConfigurationAttributes.put(ZMLMMNames.MODEL_CONFIGURATION__GENERATED_PROJECT_NAME, defaultCdtProjectName); //$NON-NLS-1$
		
		for ( Property p : modelConfigurationClassifier.getAllAttributes() ){
			if (modelConfigurationAttributes.containsKey(p.getName())){
				Slot slot = instance.createSlot();
				slot.setDefiningFeature(p);
				LiteralString value = (LiteralString) slot.createValue(
						null, p.getType(), UMLPackage.Literals.LITERAL_STRING);
				
				value.setValue(modelConfigurationAttributes.get(p.getName()));
			}
		}

		// Save the model
		try {
			modelResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			ZeligsoftCXUIPlugin
				.getDefault()
				.error(
					Messages.ZeligsoftModelWizardContentCreator_ResourceSaveFailedLog,
					e);
			return false;
		}

		// Open model using default editor
		if (UML2Util.isEmpty(destFolder)) {
			final IFile targetFile = root.getFile(new Path(modelPath));
			
			IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
			IEditorRegistry reg = page.getWorkbenchWindow().getWorkbench()
				.getEditorRegistry();
			String editorID = reg.getDefaultEditor(targetFile.toString()).getId();
	
			try {
				page.openEditor(new FileEditorInput(targetFile), editorID);
				IPerspectiveDescriptor perspective = PlatformUI.getWorkbench()
					.getPerspectiveRegistry().findPerspectiveWithId(
						perspectiveID);
				if(perspective != null){
					page.setPerspective(perspective);
				}
			} catch (PartInitException e) {
				ZeligsoftCXUIPlugin.getDefault().error(
					Messages.ZeligsoftModelWizardContentCreator_ModelOpenFailedLog,
					e);
				return false;
			}
		} else {
			File targetFile = new File(modelPath);
			if ( targetFile.exists() && targetFile.isFile() ) {
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(targetFile.toURI());
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				
				try {
					IDE.openEditorOnFileStore(page, fileStore);
				} catch ( PartInitException e) {
					ZeligsoftCXUIPlugin.getDefault().error(
							Messages.ZeligsoftModelWizardContentCreator_ModelOpenFailedLog,
							e);
					return false;
				}
			}
		}

		return true;
	}

	public static Class getModelConfiguration(ResourceSet context, URI uri, String qualifiedName) {

		if (qualifiedName == null || qualifiedName.isEmpty()){
			qualifiedName = MODEL_CONFIGURATION_QUALIFIED_NAME;
		}
		if (uri == null || uri.isEmpty()){
			uri = MODEL_CONFIGURATION_URI;
		}
		
		Resource resource = context.getResource(uri, true);
		Collection<NamedElement> elements = UMLUtil.findNamedElements(resource,
			qualifiedName);

		Iterator<NamedElement> itor = elements.iterator();
		if (itor.hasNext()) {
			NamedElement e = itor.next();
			if (e instanceof Class) {
				return (Class) e;
			}
		}
		Assert
			.isNotNull(
				null,
				Messages.ZeligsoftModelWizardContentCreator_ModelConfigurationClassNotFoundErrorMessage);
		return null;

	}

	/**
	 * Find available project name
	 * 
	 * @return project name
	 */
	private static String getAvailableProjectName() {

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String projectName = Messages.ZeligsoftModelWizardContentCreator_ZeligsoftDefaultProjectName;
		if (!root.getProject(projectName).exists()) {
			return projectName;
		}
		int i = 1;
		while (true) {
			if (!root.getProject(projectName + i).exists()) {
				return (projectName + i);
			}
			i++;
		}
	}

	/**
	 * Find the first available filename of the pattern filename1, filename2...
	 * 
	 * @param project
	 *            project
	 * @param filename
	 *            default file name. e.g., SCAModel
	 * @param extension
	 *            file extension. e.g., emx
	 * @return first available filename
	 */
	public static String getAvailableModelFileName(IProject project,
			String filename, String extension) {

		if (!project.getFile(filename + "." + extension).exists()) { //$NON-NLS-1$
			return filename;
		}

		int i = 1;
		while (true) {
			StringBuilder newFileName = new StringBuilder(filename).append(i)
				.append(".").append(extension); //$NON-NLS-1$
			if (!project.getFile(newFileName.toString()).exists()) {
				return filename + i;
			}
			i++;
		}
	}

}
