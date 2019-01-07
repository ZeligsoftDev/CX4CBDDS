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

package com.zeligsoft.domain.thalessdr.ui.wizards;

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
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.uml2.common.util.UML2Util;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.utils.BaseUtil;
import com.zeligsoft.cx.ui.pages.ZeligsoftModelWizardPage;
import com.zeligsoft.cx.ui.wizard.ZeligsoftModelWizardContentCreator;
import com.zeligsoft.domain.thalessdr.ui.ThalesUIPlugin;
import com.zeligsoft.domain.thalessdr.ui.li0n.ThalesMessages;
import com.zeligsoft.domain.thalessdr.ui.perspectives.ThalesPerspective;

/**
 * Creates an Thales domain project.
 * 
 * @author smcfee
 * 
 */
public class ThalesModelWizard
		extends Wizard
		implements INewWizard {

	private static String MODEL_NAME = ThalesMessages.ThalesProjectWizard_DefaultModelName;

	private static String MODEL_NAME_EXTENSION = "emx"; //$NON-NLS-1$

	private String projectName = null;

	private WizardNewProjectCreationPage projectPage;

	private ZeligsoftModelWizardPage modelPage;

	private IResource resource;

	private static String MODEL_FILE_NAME = MODEL_NAME + "." //$NON-NLS-1$
		+ MODEL_NAME_EXTENSION;

	private static final String TEMPLATE_FILE_PATH = "/templates/" + MODEL_FILE_NAME; //$NON-NLS-1$

	@Override
	public boolean performFinish() {

		URI templateURI = URI.createPlatformPluginURI(
			"/" + ThalesUIPlugin.ID + TEMPLATE_FILE_PATH, true); //$NON-NLS-1$

		String modelName = modelPage.getModelName();
		if (UML2Util.isEmpty(modelName)) {
			modelName = MODEL_NAME;
		}

		if (resource == null) {
			// This is project wizard
			return ZeligsoftModelWizardContentCreator.createContent(projectPage
				.getProjectName(), null, modelName, null, modelPage
				.getCdtProjectName(), templateURI, MODEL_FILE_NAME,
				ThalesPerspective.perspectiveID);
		}

		return ZeligsoftModelWizardContentCreator.createContent(projectName,
			modelPage.getFolderPath(), modelName, null,
			modelPage.getCdtProjectName(), templateURI, MODEL_FILE_NAME,
			ThalesPerspective.perspectiveID);

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		resource = BaseUtil.getIResourceFromSelection(selection);
		if (resource == null) {
			// if no selection is given then choose first project available
			// user will be able to select the target folder from the dialog
			// anyways.
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
			if (projects.length == 0) {
				// no project so perform project wizard instead of model wizard
				setWindowTitle(ThalesMessages.ThalesProjectWizard_ProjectTitle);
				projectPage = new WizardNewProjectCreationPage("ProjectPage"); //$NON-NLS-1$
				projectPage.setTitle(ThalesMessages.ThalesProjectWizard_ProjectTitle);
				projectPage
					.setDescription(ThalesMessages.ThalesProjectWizard_ProjectPageDescription);

				addPage(projectPage);

				modelPage = new ZeligsoftModelWizardPage("ModelPage"); //$NON-NLS-1$
				modelPage
					.setTitle(ThalesMessages.ThalesProjectWizard_ModelWizardWindowTitle);
				modelPage.setDefaultModelName(MODEL_NAME);
				modelPage
					.setDescription(ThalesMessages.ThalesProjectWizard_ModelWizardPageDescription);
				addPage(modelPage);
				return;
			}
			resource = projects[0];

		}

		projectName = resource.getProject().getName();

		setWindowTitle(ThalesMessages.ThalesModelWizard_ModelWizardPageTitle);
		String imagePath = "icons/wizban/thales-100.jpg";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(ThalesUIPlugin.ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}		
		
		modelPage = new ZeligsoftModelWizardPage("ModelPage", resource); //$NON-NLS-1$
		modelPage.setTitle(ThalesMessages.ThalesProjectWizard_ModelWizardWindowTitle);

		String modelName = ZeligsoftModelWizardContentCreator
			.getAvailableModelFileName(resource.getProject(), MODEL_NAME,
				MODEL_NAME_EXTENSION);
		modelPage.setDefaultModelName(modelName);
		modelPage
			.setDescription(ThalesMessages.ThalesProjectWizard_ModelWizardPageDescription);
		addPage(modelPage);
	}
}
