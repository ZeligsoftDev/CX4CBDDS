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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.pages.ZeligsoftModelWizardPage;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;

import org.eclipse.swt.widgets.Button;

/**
 * DDS4CCM Model Wizard Page
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMModelWizardPage extends ZeligsoftModelWizardPage {
	
	protected Button atcdSelectionButton;
	protected Button axciomaSelectionButton;
	private static ModelTypeEnum DEFAULT_Target_PSM = ModelTypeEnum.ATCD;

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

	public static void updateDefaultTargetPSM(ModelTypeEnum value){
		DEFAULT_Target_PSM = value;
	}
	@Override
	protected String getDefaultCdtProjectName() {
		return defaultCdtProjectName;
	}
	
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		super.createControl(parent);
		
		if(isAxciomaSupported()){
			final Composite composite = (Composite) getControl();
			// create a Group and two Radio buttons (Button) within it.
			createModelTypeGroup(composite);
		}
	}
	
	public boolean isAxciomaSupported(){
		boolean isAxciomaSupported = true;
		try {
			Class axciomaClass = Class.forName("com.zeligsoft.domain.dds4ccm.ui.axcioma.AxciomaSupport");
			if(axciomaClass == null){
				isAxciomaSupported = false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			isAxciomaSupported = false;
		}
		return isAxciomaSupported;
	}
	
	protected void createModelTypeGroup(Composite composite){
		{
			Label modelTypeSelectionLabel = new Label(composite, SWT.NULL);
			modelTypeSelectionLabel.setText("Target Runtime PSM: ");
			modelTypeSelectionLabel.setLayoutData(new GridData());
			
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 1;
			
			GridLayout modelTypeSelectionLayout = new GridLayout(2, true);
			
			Group modelTypeSelectionGroup = new Group(composite, SWT.NONE);
			modelTypeSelectionGroup.setLayout(modelTypeSelectionLayout);
			modelTypeSelectionGroup.setLayoutData(data);			
						
			atcdSelectionButton = new Button(modelTypeSelectionGroup, SWT.RADIO);
			atcdSelectionButton.setText(ModelTypeEnum.ATCD.name());
			
			axciomaSelectionButton = new Button(modelTypeSelectionGroup, SWT.RADIO);
			axciomaSelectionButton.setText(ModelTypeEnum.AXCIOMA.name());
			
			if(DEFAULT_Target_PSM.equals(ModelTypeEnum.ATCD)){
				atcdSelectionButton.setSelection(true);
			}else if(DEFAULT_Target_PSM.equals(ModelTypeEnum.AXCIOMA)){
				axciomaSelectionButton.setSelection(true);
			}
		}
	} 
	
	public ModelTypeEnum getTargetModelType(){
		if(atcdSelectionButton == null){
			// this will be entered for atcd-only version as the 'createModelTypeGroup' method will not be executed
			return ModelTypeEnum.ATCD;
		}
		return atcdSelectionButton.getSelection()? ModelTypeEnum.ATCD : ModelTypeEnum.AXCIOMA;
	}
}
