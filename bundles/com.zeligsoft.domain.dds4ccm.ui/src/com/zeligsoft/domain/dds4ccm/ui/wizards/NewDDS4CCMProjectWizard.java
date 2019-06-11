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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.wizard.INewModelCustomizer;
import com.zeligsoft.cx.ui.wizard.ZeligsoftModelWizardContentCreator;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.ui.perspectives.DDS4CCMPerspective;

/**
 * Creates an CCM domain project.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class NewDDS4CCMProjectWizard
		extends Wizard
		implements INewWizard {

	private WizardNewProjectCreationPage projectPage;

	private DDS4CCMModelWizardPage modelPage;

	@Override
	public boolean performFinish() {

		INewModelCustomizer modelCustomizer = null;
		
		if(modelPage.getTargetModelType().equals(ModelTypeEnum.AXCIOMA)){
			modelCustomizer = new INewModelCustomizer() {
				
				@Override
				public void customizeModel(Package newModel) {
					// TODO Auto-generated method stub
					if(ZDLUtil.isZDLConcept(newModel, DDS4CCMNames.DDS4_CCMMODEL)){
						DDS4CCMModel dds4ccmModel = ZDLFactoryRegistry.INSTANCE.create(newModel, DDS4CCMModel.class);
						dds4ccmModel.setModelType(ModelTypeEnum.AXCIOMA);						
					}
				}
			};		
		} 
		
		URI templateURI = URI.createPlatformPluginURI(
			"/" + Activator.PLUGIN_ID + DDS4CCMWizardPageCreator.TEMPLATE_FILE_PATH, true); //$NON-NLS-1$

		String modelName = modelPage.getModelName();
		if (UML2Util.isEmpty(modelName)) {
			modelName = DDS4CCMWizardPageCreator.MODEL_NAME;
		}
				
		DDS4CCMModelWizardPage.updateDefaultTargetPSM(modelPage.getTargetModelType());
		
		return ZeligsoftModelWizardContentCreator.createContent(projectPage
			.getProjectName(), projectPage.useDefaults() ? null : projectPage.getLocationPath().toString(), 
					"ModelFiles", modelName, DDS4CCMNames.DDS4_CCMMODEL, modelPage.getCdtProjectName(), //$NON-NLS-1$
					templateURI, DDS4CCMWizardPageCreator.MODEL_FILE_NAME, DDS4CCMPerspective.ID, modelCustomizer);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

		setWindowTitle(Messages.Wizard__NewProjectPage_title);
		String imagePath = "icons/wizban/ccm-wizard.png";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}

		projectPage = DDS4CCMWizardPageCreator.INSTANCE.createProjectPage();
		addPage(projectPage);

		modelPage = DDS4CCMWizardPageCreator.INSTANCE.createModelPage();
		addPage(modelPage);
	}

}
