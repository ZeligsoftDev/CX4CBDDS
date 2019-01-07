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

package com.zeligsoft.ce.rsm.ui.wizard.pages;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;

import com.ibm.xtools.common.ui.wizards.config.TemplateConfiguration;
import com.ibm.xtools.common.ui.wizards.pagegroups.ITemplateConfigurationPage;
import com.ibm.xtools.common.ui.wizards.pagegroups.LinearTemplateConfigurationPageGroup;
import com.zeligsoft.ce.domainregistration.DomainSpecialization;
import com.zeligsoft.ce.rsm.ui.wizard.contentcreators.DomainSpecializationContentCreator;

/**
 * 
 * @author jcorchis
 * 
 */
public class ZeligsoftTemplateConfigPageGroup extends LinearTemplateConfigurationPageGroup
{
	private TemplateConfiguration templateConfiguration = null;
	private DomainSpecializationWizardPage domainSpecializationWizardPage = null;

	public boolean finish(IProgressMonitor arg0) 
	{		
		final DomainSpecialization[] selectedDomains = domainSpecializationWizardPage.getSelectedDomains();
			
		TemplateConfiguration tc = this.getTemplateConfiguration();
		
		DomainSpecializationContentCreator contentCreator = new DomainSpecializationContentCreator(selectedDomains);
		tc.addContentCreator("com.zeligsoft.ce.rsm.ui.wizard.contentcreators",	contentCreator);//$NON-NLS-1$

		return true;
		
	}

	public boolean canFinish() {
		return true;
	}

	public ITemplateConfigurationPage getNextPage(IWizardPage arg0) {
		return domainSpecializationWizardPage;
	}

	public ITemplateConfigurationPage getPreviousPage(IWizardPage arg0) {
		return null;
	}

	public TemplateConfiguration getTemplateConfiguration() {
		return this.templateConfiguration;
	}

	public void initPages(IWizard arg0) {
		domainSpecializationWizardPage = new DomainSpecializationWizardPage();
		domainSpecializationWizardPage.setWizard(arg0);
	}

	public void setTemplateConfiguration(TemplateConfiguration arg0) {
		this.templateConfiguration = arg0;
	}

}
