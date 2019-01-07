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
public class ThalesProjectWizard
		extends Wizard
		implements INewWizard {

	private static String MODEL_NAME = ThalesMessages.ThalesProjectWizard_DefaultModelName;

	private static String MODEL_FILE_NAME = "ThalesSDRModel.emx"; //$NON-NLS-1$

	private static final String TEMPLATE_FILE_PATH = "/templates/" + MODEL_FILE_NAME; //$NON-NLS-1$

	private WizardNewProjectCreationPage projectPage;

	private ZeligsoftModelWizardPage modelPage;

	@Override
	public boolean performFinish() {

		URI templateURI = URI.createPlatformPluginURI(
			"/" + ThalesUIPlugin.ID + TEMPLATE_FILE_PATH, true); //$NON-NLS-1$

		String modelName = modelPage.getModelName();
		if (UML2Util.isEmpty(modelName)) {
			modelName = MODEL_NAME;
		}
		return ZeligsoftModelWizardContentCreator.createContent(projectPage
			.getProjectName(), null, modelName, null, modelPage.getCdtProjectName(),
			templateURI, MODEL_FILE_NAME,
			ThalesPerspective.perspectiveID);

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

		setWindowTitle(ThalesMessages.ThalesProjectWizard_ProjectTitle);
		String imagePath = "icons/wizban/thales-100.jpg";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(ThalesUIPlugin.ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}
		projectPage = new WizardNewProjectCreationPage("ProjectPage"); //$NON-NLS-1$
		projectPage.setTitle(ThalesMessages.ThalesProjectWizard_ProjectTitle);
		projectPage
			.setDescription(ThalesMessages.ThalesProjectWizard_ProjectPageDescription);

		addPage(projectPage);

		modelPage = new ZeligsoftModelWizardPage("ModelPage"); //$NON-NLS-1$
		modelPage.setTitle(ThalesMessages.ThalesProjectWizard_ModelWizardWindowTitle);
		modelPage.setDefaultModelName(MODEL_NAME);
		modelPage
			.setDescription(ThalesMessages.ThalesProjectWizard_ModelWizardPageDescription);
		addPage(modelPage);
	}

}
