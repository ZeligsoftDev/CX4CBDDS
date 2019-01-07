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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;

/**
 * DDS Connector Instance wizard page
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("unused")
public class DDSConnectorInstanceWizardPage extends WizardPage {

	private EObject context;

	private Text nameField;

	private Text seqNameField;

	private Button autoSeqNameButton;

	private Button autoInstantiationButton;

	private Text instantiatedTemplateModuleName;

	private Button autoTemplateModuleNameButton;

	private static String DEFAULT_SEQUENCE_SUFFIX = "Seq"; //$NON-NLS-1$

	private static String DEFAULT_INSTANTIATED_MODULE_SUFFIX = "_conn"; //$NON-NLS-1$

	public static String DDS_CONNECTOR_LIBRARY_NAME = "DDS_DCPS"; //$NON-NLS-1$

	public static String DDS_CONNECTOR_TEMPLATE_MODULE_QUALIFIED_NAME = DDS_CONNECTOR_LIBRARY_NAME
			+ "::CCM_DDS::Typed"; //$NON-NLS-1$

	private Package selectedTemplateModule = null;

	public Package getSelectedTemplateModule() {
		return selectedTemplateModule;
	}

	private Listener listener = new Listener() {

		public void handleEvent(Event e) {

			validate();
		}
	};

	protected DDSConnectorInstanceWizardPage(EObject context) {
		super("createDDSMessagePage"); //$NON-NLS-1$
		this.context = context;
		setTitle(Messages.DDSConnectorInstanceWizardPage_PageTitle);
		setDescription(NLS.bind(Messages.DDSConnectorInstanceWizardPage_PageDescription,
				System.getProperty("line.separator"))); //$NON-NLS-1$
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createNameControl(composite);

		addSeparator(composite);

		createInstantiationOptionControl(composite);

		setControl(composite);

		setPageComplete(false);

	}

	private void createInstantiationOptionControl(Composite parent) {
		Composite composite = createComposite(parent, 3);

		autoInstantiationButton = new Button(composite, SWT.CHECK);
		GridData data = new GridData();
		data.horizontalSpan = 3;
		autoInstantiationButton.setLayoutData(data);
		autoInstantiationButton
				.setText(Messages.DDSConnectorInstanceWizardPage_AutoTemplateInstantiationButtonLabel);
		autoInstantiationButton.setSelection(true);

		autoInstantiationButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if (autoInstantiationButton.getSelection()) {
					if (autoTemplateModuleNameButton.getSelection()) {
						instantiatedTemplateModuleName.setEnabled(false);
					} else {
						instantiatedTemplateModuleName.setEnabled(true);
					}
					autoTemplateModuleNameButton.setEnabled(true);
				} else {
					instantiatedTemplateModuleName.setEnabled(false);
					autoTemplateModuleNameButton.setEnabled(false);
				}

				validate();

			}

		});

		Label templateModuleLabel = new Label(composite, SWT.NULL);
		templateModuleLabel
				.setText(Messages.DDSConnectorInstanceWizardPage_TemplateModuleNameTextLabel);

		final Text templateModuleName = new Text(composite, SWT.READ_ONLY | SWT.BORDER);
		templateModuleName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectedTemplateModule = getCCMDDSTypedTemplateModule();
		if (selectedTemplateModule != null) {
			templateModuleName.setText(selectedTemplateModule.getQualifiedName());
		}
		final Button selectionButton = new Button(composite, SWT.PUSH);
		selectionButton
				.setText(Messages.DDSConnectorInstanceWizardPage_TemplateModuleSelectionButtonLabel);
		selectionButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(Display
						.getCurrent().getActiveShell(), context, Collections
						.singletonList(IDL3PlusNames.TEMPLATE_MODULE), true, false);
				int result = dialog.open();
				if (result == Window.OK) {
					if (!dialog.getSelectedElements().isEmpty()) {
						selectedTemplateModule = (Package) dialog.getSelectedElements()
								.getFirstElement();
						templateModuleName.setText(selectedTemplateModule
								.getQualifiedName());
					}
				}
			}
		});

		Label instantiatedTemplateModuleNameLabel = new Label(composite, SWT.NULL);
		instantiatedTemplateModuleNameLabel
				.setText(Messages.DDSConnectorInstanceWizardPage_InstantiatedTemplateModuleNameTextLabel);
		instantiatedTemplateModuleNameLabel.setLayoutData(new GridData());

		instantiatedTemplateModuleName = new Text(composite, SWT.BORDER);
		instantiatedTemplateModuleName.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		instantiatedTemplateModuleName.setEnabled(false);
		instantiatedTemplateModuleName.addListener(SWT.Modify, listener);

		// create auto button
		autoTemplateModuleNameButton = new Button(composite, SWT.CHECK);
		autoTemplateModuleNameButton.setLayoutData(new GridData());
		autoTemplateModuleNameButton
				.setText(Messages.DDSConnectorInstanceWizardPage_UseDefaultButtonLabel);
		autoTemplateModuleNameButton.setSelection(true);

		autoTemplateModuleNameButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if (autoTemplateModuleNameButton.getSelection()) {
					String name = UML2Util.EMPTY_STRING;
					if (nameField.getText() != null) {
						name = nameField.getText();
					}
					instantiatedTemplateModuleName
							.setText(getDefaultInstantiatedModuleName());
					instantiatedTemplateModuleName.setEnabled(false);
				} else {
					instantiatedTemplateModuleName.setEnabled(true);
				}
				validate();

			}

		});
	}

	@SuppressWarnings("rawtypes")
	private Package getCCMDDSTypedTemplateModule() {
		Package root = (Package) EcoreUtil.getRootContainer(context);
		Iterator<Package> itor = root.getImportedPackages().iterator();
		while (itor.hasNext()) {
			Package pkg = itor.next();
			if (pkg.getName().equals(DDS_CONNECTOR_LIBRARY_NAME)) {
				Collection list = UMLUtil.findNamedElements(pkg.eResource(),
						DDS_CONNECTOR_TEMPLATE_MODULE_QUALIFIED_NAME);
				return (Package) list.iterator().next();
			}
		}
		return null;
	}

	/**
	 * Calculate default instantiated module name
	 * 
	 * @return
	 */
	private String getDefaultInstantiatedModuleName() {
		String msgName = nameField.getText();
		if (msgName == null) {
			return UML2Util.EMPTY_STRING;
		}
		String moduleName;
		if (msgName.endsWith("_msg")) { //$NON-NLS-1$
			moduleName = msgName.replace("_msg", DEFAULT_INSTANTIATED_MODULE_SUFFIX); //$NON-NLS-1$
		} else {
			moduleName = msgName + DEFAULT_INSTANTIATED_MODULE_SUFFIX;
		}

		return moduleName;
	}

	private Composite createComposite(Composite parent, int numColumns) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.numColumns = numColumns;
		compositeLayout.marginHeight = 10;
		compositeLayout.marginWidth = 10;

		GridData compositeLData = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		compositeLData.horizontalIndent = 2;

		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);
		return composite;
	}

	/**
	 * Adds a separator to the given composite.
	 * 
	 * @param composite
	 */
	private void addSeparator(Composite composite) {

		Label label1 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData label1LData = new GridData(GridData.FILL_HORIZONTAL);
		label1LData.grabExcessHorizontalSpace = true;
		label1LData.verticalIndent = 0;
		label1.setLayoutData(label1LData);
	}

	private void createNameControl(Composite parent) {

		Composite composite = createComposite(parent, 3);

		Label nameLabel = new Label(composite, SWT.NULL);
		nameLabel.setText(Messages.DDSConnectorInstanceWizardPage_MessageNameLabel);
		nameLabel.setLayoutData(new GridData());

		nameField = new Text(composite, SWT.BORDER);
		nameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		nameField.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event e) {
				if (autoSeqNameButton.getSelection()) {
					seqNameField.setText(nameField.getText() + DEFAULT_SEQUENCE_SUFFIX);

				}
				if (autoTemplateModuleNameButton.getSelection()) {
					instantiatedTemplateModuleName
							.setText(getDefaultInstantiatedModuleName());

				}
				validate();
			}
		});
		new Label(composite, SWT.NULL);

		Label seqNameLabel = new Label(composite, SWT.NULL);
		seqNameLabel.setText(Messages.DDSConnectorInstanceWizardPage_SequenceNameLabel);
		seqNameLabel.setLayoutData(new GridData());

		seqNameField = new Text(composite, SWT.BORDER);
		seqNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		seqNameField.setEnabled(false);
		seqNameField.addListener(SWT.Modify, listener);

		// create auto button
		autoSeqNameButton = new Button(composite, SWT.CHECK);
		autoSeqNameButton.setLayoutData(new GridData());
		autoSeqNameButton
				.setText(Messages.DDSConnectorInstanceWizardPage_UseDefaultButtonLabel);
		autoSeqNameButton.setSelection(true);

		autoSeqNameButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if (autoSeqNameButton.getSelection()) {
					String name = UML2Util.EMPTY_STRING;
					if (nameField.getText() != null) {
						name = nameField.getText();
					}
					seqNameField.setText(name + DEFAULT_SEQUENCE_SUFFIX);
					seqNameField.setEnabled(false);
				} else {
					seqNameField.setEnabled(true);
				}
				validate();

			}

		});

	}

	private boolean validate() {

		if (nameField.getText().equals(UML2Util.EMPTY_STRING)) {
			this
					.setErrorMessage(Messages.DDSConnectorInstanceWizardPage_MessageNameEmptyErrorMessage);
			setPageComplete(false);
			return false;
		}

		if (seqNameField.getText().equals(UML2Util.EMPTY_STRING)) {
			this
					.setErrorMessage(Messages.DDSConnectorInstanceWizardPage_SequenceNameEmptyErrorMessage);
			setPageComplete(false);
			return false;
		}

		if (autoInstantiationButton.getSelection()
				&& instantiatedTemplateModuleName.getText().equals(UML2Util.EMPTY_STRING)) {
			this
					.setErrorMessage(Messages.DDSConnectorInstanceWizardPage_TemplateModuleNameEmptyErrorMessage);
			setPageComplete(false);
			return false;
		}

		setPageComplete(true);
		this.setErrorMessage(null);
		return true;
	}

	public String getMessageName() {
		return nameField.getText();
	}

	public String getSequenceName() {
		return seqNameField.getText();
	}

	public String getInstantiatedTemplateModuleName() {
		return instantiatedTemplateModuleName.getText();
	}

	public boolean isAutoInstantiateTemplateModule() {
		return autoInstantiationButton.getSelection();
	}

}
