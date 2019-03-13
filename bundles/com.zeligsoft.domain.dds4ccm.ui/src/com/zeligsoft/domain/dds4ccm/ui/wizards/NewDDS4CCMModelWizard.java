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
package com.zeligsoft.domain.dds4ccm.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.uml2.common.util.UML2Util;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.wizard.ZeligsoftModelWizardContentCreator;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.ui.perspectives.DDS4CCMPerspective;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "emx". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 * 
 * 	Toby McClean (tmcclean)
 */

public class NewDDS4CCMModelWizard extends Wizard implements INewWizard {
	private String projectName = null;
	
	private DDS4CCMModelWizardPage modelPage;
	private WizardNewProjectCreationPage projectPage;
	
	private IResource resource;

	/**
	 * Constructor for NewCCMModelWizard.
	 */
	public NewDDS4CCMModelWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final URI templateURI = URI.createPlatformPluginURI(
				"/" + Activator.PLUGIN_ID + DDS4CCMWizardPageCreator.TEMPLATE_FILE_PATH, true); //$NON-NLS-1$
		
		String modelName = modelPage.getModelName();
		if(UML2Util.isEmpty(modelName)) {
			modelName = DDS4CCMWizardPageCreator.MODEL_NAME;
		}
		
		String destFolder = null;
		
		if(resource == null) {
			projectName = projectPage.getProjectName();
			destFolder = null;
		} else {
			destFolder = modelPage.getFolderPath();
		}
		
		return ZeligsoftModelWizardContentCreator.createContent(projectName, 
				destFolder, "ModelFiles", modelName, DDS4CCMNames.DDS4_CCMMODEL, //$NON-NLS-1$
				modelPage.getCdtProjectName(), templateURI, 
				DDS4CCMWizardPageCreator.MODEL_FILE_NAME, DDS4CCMPerspective.ID);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		resource = BaseUIUtil.getIResourceFromSelection(selection);
		
		if(resource == null) {
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
									.getProjects();
			if(projects.length == 0) {
				setWindowTitle(Messages.Wizard__NewProjectPage_title);
				projectPage = DDS4CCMWizardPageCreator.INSTANCE.createProjectPage();
				addPage(projectPage);
				
				modelPage = DDS4CCMWizardPageCreator.INSTANCE.createModelPage();
				addPage(modelPage);
				return;
			}
			resource = projects[0];
		}
		
		projectName = resource.getProject().getName();
		setWindowTitle(Messages.Wizard__NewModelPage_title);
		String imagePath = "icons/wizban/ccm-wizard.png"; //$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			setDefaultPageImageDescriptor(imageDescriptor);
		} catch(Exception e) {
			// ignore
		}
		String modelName = ZeligsoftModelWizardContentCreator
			.getAvailableModelFileName(resource.getProject(), 
				DDS4CCMWizardPageCreator.MODEL_NAME, DDS4CCMWizardPageCreator.MODEL_NAME_EXTENSION);
		modelPage = DDS4CCMWizardPageCreator.INSTANCE.createModelPage(modelName);
		addPage(modelPage);
	}
}