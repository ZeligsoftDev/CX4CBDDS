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
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.pages.ZeligsoftModelWizardPage;

/**
 * DDS4CCM Model Wizard Page
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMModelWizardPage extends ZeligsoftModelWizardPage {

	public DDS4CCMModelWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	protected boolean validateCdtProjectName() {
		if (!UML2Util.isEmpty(cdtProjectNameField.getText())) {
			if (cdtProjectNameField.getText().matches(
					".*[^A-Z,a-z,0-9,\\-,_].*")) { //$NON-NLS-1$
				setPageComplete(false);
				setErrorMessage(Messages.ZeligsoftModelWizardPage_InvalidCDTProjectNameErrorMsg);
				return false;
			}

			if (resource != null) {

				// check to see if CDT project already exists
				IProject project = resource.getWorkspace().getRoot()
						.getProject(cdtProjectNameField.getText());
				if (project.exists()) {
					setErrorMessage(Messages.ZeligsoftModelWizardPage_CDTProjectExistErrorMsg);
					setPageComplete(false);
					return false;
				}
			}
		}
		return true;
	}

	@Override
	protected String getDefaultCdtProjectName() {
		return defaultCdtProjectName;
	}
}
