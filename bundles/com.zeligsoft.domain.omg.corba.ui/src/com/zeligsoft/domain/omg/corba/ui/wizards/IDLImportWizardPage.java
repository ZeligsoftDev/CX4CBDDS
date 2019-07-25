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
package com.zeligsoft.domain.omg.corba.ui.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.cx.ui.wizard.ResourceImportWizardPage;
import com.zeligsoft.domain.omg.corba.ui.Activator;
import com.zeligsoft.domain.omg.corba.ui.l10n.Messages;

/**
 * IDL import wizard page
 * 
 * @author ysroh
 * 
 */
public class IDLImportWizardPage extends ResourceImportWizardPage {

	protected String includeDialogSettingKey = "IDLImportWizardInclude"; //$NON-NLS-1$

	protected String defineDialogSettingKey = "IDLImportWizardDefine"; //$NON-NLS-1$

	protected String excludeDialogSettingKey = "IDLImportWizardExclude"; //$NON-NLS-1$

	private Text includeInput = null;

	private Text defineInput = null;
	
	private Text excludeInput = null;

	private IDialogSettings dialogSettings = Activator.getDefault()
			.getDialogSettings();

	public IDLImportWizardPage(String name, IWorkbench workbench, String title,
			String description) {
		super(name, workbench, title, description);
	}
	
	public void setDefineDialogSettingKey(String key) {
		defineDialogSettingKey = key;
	}
	
	public void setIncludeDialogSettingKey(String key) {
		includeDialogSettingKey = key;
	}
	
	public void setExcludeDialogSettingKey(String key) {
		excludeDialogSettingKey = key;
	}

	@Override
	protected void doCreateControl(Composite composite) {
		super.doCreateControl(composite);
		createIncludeGroup(composite);
		createDefineGroup(composite);
		createExcludeGroup(composite);
	}

	private void createExcludeGroup(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		composite.setFont(parent.getFont());

		{
			// Set exclude label
			Label label = new Label(composite, SWT.NULL);
			label.setText(Messages.getString("IDLImportWizardPage.FilesToExcludeLabel")); //$NON-NLS-1$
			GridData data = new GridData();
			data.horizontalSpan = 2;
			label.setLayoutData(data);
		}
		excludeInput = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 55;
		excludeInput.setLayoutData(data);
		if (dialogSettings.get(excludeDialogSettingKey) != null) {
			excludeInput.setText(dialogSettings.get(excludeDialogSettingKey));
		}
		excludeInput.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				dialogSettings.put(excludeDialogSettingKey, excludeInput
						.getText());
			}
		});
		Button resetButton = new Button(composite, SWT.PUSH);
		resetButton.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING));
		resetButton.setText(Messages
				.getString("IDLImportWizardPage_ClearButtonLabel")); //$NON-NLS-1$
		resetButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				excludeInput.setText(UML2Util.EMPTY_STRING);
			}
		});
	}

	private void createDefineGroup(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		composite.setFont(parent.getFont());

		{
			// Set include label
			Label label = new Label(composite, SWT.NULL);
			label.setText(Messages
					.getString("IDLImportWizardPage_DefineTextLabel")); //$NON-NLS-1$
			GridData data = new GridData();
			data.horizontalSpan = 2;
			label.setLayoutData(data);
		}
		defineInput = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 55;
		defineInput.setLayoutData(data);
		if (dialogSettings.get(defineDialogSettingKey) != null) {
			defineInput.setText(dialogSettings.get(defineDialogSettingKey));
		}
		defineInput.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				dialogSettings.put(defineDialogSettingKey, defineInput
						.getText());
			}
		});
		Button resetButton = new Button(composite, SWT.PUSH);
		resetButton.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING));
		resetButton.setText(Messages
				.getString("IDLImportWizardPage_ClearButtonLabel")); //$NON-NLS-1$
		resetButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				defineInput.setText(UML2Util.EMPTY_STRING);
			}
		});

	}

	private void createIncludeGroup(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		composite.setFont(parent.getFont());

		{
			// Set include label
			Label label = new Label(composite, SWT.NULL);
			label.setText(Messages
					.getString("IDLImportWizardPage_IncludeTextLabel")); //$NON-NLS-1$
			GridData data = new GridData();
			data.horizontalSpan = 2;
			label.setLayoutData(data);
		}
		includeInput = new Text(composite, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 55;
		includeInput.setLayoutData(data);
		if (dialogSettings.get(includeDialogSettingKey) != null) {
			includeInput
					.setText(dialogSettings.get(includeDialogSettingKey));
		}
		includeInput.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				dialogSettings.put(includeDialogSettingKey, includeInput
						.getText());
				setPageComplete(determinePageCompletion());

			}
		});
		Button resetButton = new Button(composite, SWT.PUSH);
		resetButton.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING));
		resetButton.setText(Messages
				.getString("IDLImportWizardPage_ClearButtonLabel")); //$NON-NLS-1$
		resetButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				includeInput.setText(UML2Util.EMPTY_STRING);
			}
		});
	}
	
	/*
	 * Validate includes
	 */
	private boolean validateIncludes(){
		String[] includes = includeInput.getText().split(System.getProperty("line.separator")); //$NON-NLS-1$
		for(String include:includes){
			if(include.isEmpty()){
				continue;
			}
			File file = new File(include);
			if(!file.exists()){
				setErrorMessage(NLS
						.bind(Messages
								.getString("IDLImportWizardPage.InvalidIncludeErrorMsg"), //$NON-NLS-1$
								include));
				setPageComplete(false);
				return false;
			}
		}
		setErrorMessage(null);
		return true;
		
	}
	
	@Override
	protected boolean determinePageCompletion() {
		boolean flag =  super.determinePageCompletion();
		return (flag && validateIncludes());
		
	}

	public List<String> getDefineList() {

		List<String> list = new ArrayList<String>();
		if (defineInput != null) {
			String[] defines = defineInput.getText().split(
					System.getProperty("line.separator")); //$NON-NLS-1$
			for (String t : defines) {
				list.add(t);
			}
		}
		return list;
	}

	public List<String> getIncludeList() {

		List<String> list = new ArrayList<String>();
		if (includeInput != null) {
			String[] defines = includeInput.getText().split(
					System.getProperty("line.separator")); //$NON-NLS-1$
			for (String t : defines) {
				list.add(t);
			}
		}
		return list;
	}
	
	public List<String> getExcludeList() {

		List<String> list = new ArrayList<String>();
		if (excludeInput != null) {
			String[] defines = excludeInput.getText().split(
					System.getProperty("line.separator")); //$NON-NLS-1$
			for (String t : defines) {
				list.add(t);
			}
		}
		return list;
	}

}
