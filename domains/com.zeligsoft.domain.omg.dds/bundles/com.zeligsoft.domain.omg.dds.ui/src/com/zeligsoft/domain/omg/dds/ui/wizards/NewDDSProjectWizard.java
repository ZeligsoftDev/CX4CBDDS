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

package com.zeligsoft.domain.omg.dds.ui.wizards;

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
import com.zeligsoft.domain.omg.dds.ui.Activator;
import com.zeligsoft.domain.omg.dds.ui.internal.wizards.DDSWizardPageCreator;
import com.zeligsoft.domain.omg.dds.ui.l10n.Messages;
import com.zeligsoft.domain.omg.dds.ui.perspectives.DDSPerspective;

/**
 * Creates an DDS domain project.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class NewDDSProjectWizard
		extends Wizard
		implements INewWizard {

	private WizardNewProjectCreationPage projectPage;

	private ZeligsoftModelWizardPage modelPage;

	@Override
	public boolean performFinish() {

		URI templateURI = URI.createPlatformPluginURI(
			"/" + Activator.PLUGIN_ID + DDSWizardPageCreator.TEMPLATE_FILE_PATH, true); //$NON-NLS-1$

		String modelName = modelPage.getModelName();
		if (UML2Util.isEmpty(modelName)) {
			modelName = DDSWizardPageCreator.MODEL_NAME;
		}
		return ZeligsoftModelWizardContentCreator.createContent(projectPage
			.getProjectName(), null, modelName, null, modelPage.getCdtProjectName(),
			templateURI, DDSWizardPageCreator.MODEL_FILE_NAME, DDSPerspective.ID);

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

		setWindowTitle(Messages.Wizard__NewProjectPage_title);
		String imagePath = "icons/wizban/dds-wizard.png";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}

		projectPage = DDSWizardPageCreator.INSTANCE.createProjectPage();
		addPage(projectPage);

		modelPage = DDSWizardPageCreator.INSTANCE.createModelPage();
		addPage(modelPage);
	}

}
