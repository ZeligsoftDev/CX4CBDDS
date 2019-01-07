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
package com.zeligsoft.cx.ui.wizard;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Default CX Component creation wizard page.
 * 
 * @author jcorchis
 * @author Young-Soo Roh (ysroh)
 * 
 */
@SuppressWarnings("deprecation")
public class ComponentCreationWizardPage
		extends WizardPage {

	private Preferences store = CXActivator.getDefault()
		.getPluginPreferences();

	// Input field
	protected Text componentNameInput;

	protected Text cINameInput;

	protected Text implementationNameInput;

	protected Text packageNameInput;

	protected Text diagramNameInput;

	// create buttons
	protected Button autoCIButton;

	protected Button autoImplButton;

	protected Button autoPkgButton;

	protected Button autoDiagButton;

	// use default buttons
	protected Button useDefaultCIButton;

	protected Button useDefaultImplButton;

	protected Button useDefaultPkgButton;

	protected Button useDefaultDiagButton;

	/**
	 * Depending on the defaults of the component wizard the actual dialog page
	 * might not be valid. Best practices dictate that no error messages appear
	 * until the user performs some action that cause validation to be run.
	 */
	protected boolean validateEnabled = false;

	protected static int NAME_INPUT_FIELD_WIDTH = 300;

	protected static int MAX_LABEL_STRING_LENGTH = 18;

	protected int defaultLabelWidth = 90;

	/**
	 * Creates a new WizardPage.
	 * 
	 * @param pageName
	 */
	public ComponentCreationWizardPage(String pageName) {
		super(pageName);
	}

	/**
	 * Creates the basic component wizard page.
	 */
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.marginWidth = 0;
		compositeLayout.marginHeight = 0;
		compositeLayout.verticalSpacing = 0;
		compositeLayout.horizontalSpacing = 0;
		compositeLayout.numColumns = 1;
		GridData compositeLData = new GridData(GridData.FILL_BOTH);
		compositeLData.grabExcessHorizontalSpace = true;
		compositeLData.grabExcessVerticalSpace = true;
		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);

		defaultLabelWidth = calculateDefaultLabelWidth(composite);

		createNameArea(composite);

		addSeparator(composite);

		createOptionArea(composite);

		setControl(composite);

		initData();

		setPageComplete(false);

		validateEnabled = true;
	}

	/**
	 * Initializes this page with the data from the PreferenceStore.
	 */
	protected void initData() {

		// Initialize Component Interface data
		Boolean useDefaultCI = store
			.getBoolean(CXPreferenceConstants.USE_DEFAULT_CI_SUFFIX);
		useDefaultCIButton.setSelection(useDefaultCI);
		if (useDefaultCI) {
			cINameInput.setText(store
				.getString(CXPreferenceConstants.COMPONENT_INTERFACE_SUFFIX));

		}
		Boolean autoCreateCI = store
			.getBoolean(CXPreferenceConstants.AUTO_CREATE_COMPONENT_INTERFACE);
		autoCIButton.setSelection(autoCreateCI);

		// Shouldn't have to do this, but the event loop is not running yet
		useDefaultCIButton.setEnabled(autoCIButton.getSelection());
		cINameInput.setEditable(autoCIButton.getSelection()
			&& !useDefaultCIButton.getSelection());

		// Initialize Implementation data
		Boolean useDefaultImpl = store
			.getBoolean(CXPreferenceConstants.USE_DEFAULT_IMPL_SUFFIX);
		useDefaultImplButton.setSelection(useDefaultImpl);

		if (useDefaultImpl) {
			implementationNameInput.setText(store
				.getString(CXPreferenceConstants.IMPLEMENTATION_SUFFIX));
		}
		Boolean autoCreateImpl = store
			.getBoolean(CXPreferenceConstants.AUTO_CREATE_IMPLEMENTATION);
		autoImplButton.setSelection(autoCreateImpl);

		// Shouldn't have to do this, but the event loop is not running yet
		useDefaultImplButton.setEnabled(autoImplButton.getSelection());
		implementationNameInput.setEditable(autoImplButton.getSelection()
			&& !useDefaultImplButton.getSelection());

		// Initialize Package data
		Boolean useDefaultPkg = store
			.getBoolean(CXPreferenceConstants.USE_DEFAULT_PKG_SUFFIX);
		useDefaultPkgButton.setSelection(useDefaultPkg);

		if (useDefaultPkg) {
			packageNameInput.setText(store
				.getString(CXPreferenceConstants.PACKAGE_SUFFIX));
		}
		Boolean autoCreatePackage = store
			.getBoolean(CXPreferenceConstants.AUTO_CREATE_PACKAGE);
		autoPkgButton.setSelection(autoCreatePackage);

		// Shouldn't have to do this, but the event loop is not running yet
		useDefaultPkgButton.setEnabled(autoPkgButton.getSelection());
		packageNameInput.setEditable(autoPkgButton.getSelection()
			&& !useDefaultPkgButton.getSelection());

		// Initialize Diagram data
		Boolean useDefaultDiag = store
			.getBoolean(CXPreferenceConstants.USE_DEFAULT_DIAG_SUFFIX);
		useDefaultDiagButton.setSelection(useDefaultDiag);
		if (useDefaultDiag) {
			diagramNameInput.setText(store
				.getString(CXPreferenceConstants.DIAGRAM_SUFFIX));
		}
		Boolean autoCreateDiagram = store
			.getBoolean(CXPreferenceConstants.AUTO_CREATE_DIAGRAM);
		autoDiagButton.setSelection(autoCreateDiagram);

		// Shouldn't have to do this, but the event loop is not running yet
		useDefaultDiagButton.setEnabled(autoDiagButton.getSelection());
		diagramNameInput.setEditable(autoDiagButton.getSelection()
			&& !useDefaultDiagButton.getSelection());

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

	/**
	 * Creates the controls for the ComponentInterfaces on this page.
	 * 
	 * @param parent
	 */
	private void createComponentInterfaceArea(Composite parent) {
		// Component interface options
		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(3, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));
		group.setText(Messages.ComponentCreationWizardPage_CIGroupLabel);

		{
			// create button
			autoCIButton = new Button(group, SWT.CHECK);

			autoCIButton
				.setText(Messages.ComponentCreationWizardPage_AutoCreateCILabel);

			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 5;
			autoCIButton.setLayoutData(data);

			autoCIButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					useDefaultCIButton.setEnabled(autoCIButton.getSelection());
					cINameInput.setEditable(autoCIButton.getSelection()
						&& !useDefaultCIButton.getSelection());
					validatePage();
				}
			});
		}

		{
			// create input label
			GridData data = new GridData();
			data.widthHint = defaultLabelWidth;
			Label itemLabel = new Label(group, SWT.NULL);
			itemLabel.setLayoutData(data);
			itemLabel.setText(Messages.ComponentCreationWizardPage_NameLabel);
		}

		{
			// create input field
			cINameInput = new Text(group, SWT.BORDER);
			GridData data = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
			cINameInput.setLayoutData(data);
			cINameInput.addListener(SWT.Modify, new Listener() {

				@Override
				public void handleEvent(Event e) {
					validatePage();
				}
			});
		}

		{
			// create auto button
			useDefaultCIButton = new Button(group, SWT.CHECK);
			useDefaultCIButton.setLayoutData(new GridData());
			useDefaultCIButton
				.setText(Messages.ComponentCreationWizardPage_UseDefaultLabel);

			useDefaultCIButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					if (useDefaultCIButton.getSelection()) {
						cINameInput
							.setText(componentNameInput.getText()
								+ store
									.getString(CXPreferenceConstants.COMPONENT_INTERFACE_SUFFIX));
					}
					cINameInput.setEditable(autoCIButton.getSelection()
						&& !useDefaultCIButton.getSelection());

					validatePage();

				}

			});
		}

		createAdditionalInterface(group);

	}

	/**
	 * Append additional options to the Component Interface group in the wizard.
	 * The default implementation does not contribute additions.
	 * 
	 * @param group
	 */
	protected void createAdditionalInterface(Group group) {
		// do nothing
	}

	/**
	 * Creates the component implementation group controls.
	 * 
	 * @param parent
	 */
	private void createImplementationArea(Composite parent) {
		// implementation options
		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(3, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));
		group
			.setText(Messages.ComponentCreationWizardPage_ImplementationGroupLabel);

		autoImplButton = new Button(group, SWT.CHECK);
		autoImplButton
			.setText(Messages.ComponentCreationWizardPage_AutoCreateImplementationLabel);
		GridData data = new GridData();
		data.horizontalSpan = 3;
		data.verticalIndent = 5;
		autoImplButton.setLayoutData(data);

		autoImplButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				useDefaultImplButton.setEnabled(autoImplButton.getSelection());

				implementationNameInput.setEditable(autoImplButton
					.getSelection()
					&& !useDefaultImplButton.getSelection());
				validatePage();
			}
		});

		data = new GridData();
		data.widthHint = defaultLabelWidth;
		Label itemLabel = new Label(group, SWT.NULL);
		itemLabel.setText(Messages.ComponentCreationWizardPage_NameLabel);
		itemLabel.setLayoutData(data);

		implementationNameInput = new Text(group, SWT.BORDER);
		implementationNameInput.setLayoutData(new GridData(
			GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		implementationNameInput.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				validatePage();
			}
		});

		useDefaultImplButton = new Button(group, SWT.CHECK);
		useDefaultImplButton.setLayoutData(new GridData());
		useDefaultImplButton
			.setText(Messages.ComponentCreationWizardPage_UseDefaultLabel);
		useDefaultImplButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if (useDefaultImplButton.getSelection()) {
					implementationNameInput
						.setText(componentNameInput.getText()
							+ store
								.getString(CXPreferenceConstants.IMPLEMENTATION_SUFFIX));
				}
				implementationNameInput.setEditable(autoImplButton
					.getSelection()
					&& !useDefaultImplButton.getSelection());
				validatePage();

			}
		});

		createAdditionalImplementation(group);

	}

	/**
	 * Append additional options to the Component Implementation group in the
	 * wizard. The default implementation does not contribute additions.
	 * 
	 * @param group
	 */
	protected void createAdditionalImplementation(Group group) {
		// do nothing
	}

	private void createCreateOptionArea(Composite parent) {
		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(3, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));
		group.setText(Messages.ComponentCreationWizardPage_LocationGroupLabel);

		{
			// create auto package button
			autoPkgButton = new Button(group, SWT.CHECK);
			autoPkgButton
				.setText(Messages.ComponentCreationWizardPage_AutoCreatePacakgeLabel);
			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 5;
			autoPkgButton.setLayoutData(data);
			autoPkgButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					useDefaultPkgButton
						.setEnabled(autoPkgButton.getSelection());

					packageNameInput.setEditable(autoPkgButton.getSelection()
						&& !useDefaultPkgButton.getSelection());
					validatePage();
				}
			});

			// create label
			data = new GridData();
			data.widthHint = defaultLabelWidth;
			Label itemLabel = new Label(group, SWT.NULL);
			itemLabel.setLayoutData(data);
			itemLabel
				.setText(Messages.ComponentCreationWizardPage_PackageNameLabel);

			// create input field
			packageNameInput = new Text(group, SWT.BORDER);
			packageNameInput.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
			packageNameInput.addListener(SWT.Modify, new Listener() {

				@Override
				public void handleEvent(Event e) {
					validatePage();
				}
			});

			// create use default button
			useDefaultPkgButton = new Button(group, SWT.CHECK);
			useDefaultPkgButton.setLayoutData(new GridData());
			useDefaultPkgButton
				.setText(Messages.ComponentCreationWizardPage_UseDefaultLabel);
			useDefaultPkgButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					if (useDefaultPkgButton.getSelection()) {
						packageNameInput
							.setText(componentNameInput.getText()
								+ store
									.getString(CXPreferenceConstants.PACKAGE_SUFFIX));
					}
					packageNameInput.setEditable(autoPkgButton.getSelection()
						&& !useDefaultPkgButton.getSelection());
					validatePage();
				}
			});
		}

		{
			// diagram options
			autoDiagButton = new Button(group, SWT.CHECK);
			autoDiagButton
				.setText(Messages.ComponentCreationWizardPage_AutoCreateDiagramLabel);
			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 0;
			autoDiagButton.setLayoutData(data);
			autoDiagButton.setSelection(store
				.getBoolean(CXPreferenceConstants.AUTO_CREATE_DIAGRAM));
			autoDiagButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					useDefaultDiagButton.setEnabled(autoDiagButton
						.getSelection());
					diagramNameInput.setEditable(autoDiagButton.getSelection()
						&& !useDefaultDiagButton.getSelection());
					validatePage();
				}
			});

			data = new GridData();
			data.widthHint = defaultLabelWidth;
			Label itemLabel = new Label(group, SWT.NULL);
			itemLabel.setLayoutData(data);
			itemLabel
				.setText(Messages.ComponentCreationWizardPage_DiagramNameLabel);

			diagramNameInput = new Text(group, SWT.BORDER);
			diagramNameInput.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
			diagramNameInput.addListener(SWT.Modify, new Listener() {

				@Override
				public void handleEvent(Event e) {
					validatePage();
				}
			});

			useDefaultDiagButton = new Button(group, SWT.CHECK);
			useDefaultDiagButton.setLayoutData(new GridData());
			useDefaultDiagButton
				.setText(Messages.ComponentCreationWizardPage_UseDefaultLabel);
			useDefaultDiagButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (useDefaultDiagButton.getSelection()) {
						diagramNameInput
							.setText(componentNameInput.getText()
								+ store
									.getString(CXPreferenceConstants.DIAGRAM_SUFFIX));
					}
					diagramNameInput.setEditable(autoDiagButton.getSelection()
						&& !useDefaultDiagButton.getSelection());
					validatePage();
				}
			});
		}
		
		createAdditionalCreateOptionArea(group);

	}

	/**
	 * Override this function to add additional create options after the default
	 * create options
	 * 
	 * @param group
	 */
	protected void createAdditionalCreateOptionArea(Group group) {
		// TODO Auto-generated method stub
	}

	/**
	 * Create an option area for non-component related items.
	 * 
	 * @param composite
	 */
	private void createOptionArea(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.marginWidth = 10;
		compositeLayout.marginHeight = 10;
		compositeLayout.numColumns = 1;
		GridData compositeLData = new GridData(GridData.FILL_HORIZONTAL);
		compositeLData.grabExcessHorizontalSpace = true;
		compositeLData.grabExcessVerticalSpace = true;
		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);

		createComponentInterfaceArea(composite);

		createImplementationArea(composite);

		createCreateOptionArea(composite);

	}

	/**
	 * Create a name input area for StructuralRealization.
	 * 
	 * @param parent
	 */
	private void createNameArea(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.numColumns = 2;
		compositeLayout.marginHeight = 10;
		compositeLayout.marginWidth = 10;

		GridData compositeLData = new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL);
		compositeLData.horizontalIndent = 2;

		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);

		Label nameLabel = new Label(composite, SWT.NULL);
		nameLabel
			.setText(Messages.ComponentCreationWizardPage_ComponentNameLabel);
		GridData data = new GridData();
		data.widthHint = defaultLabelWidth;
		nameLabel.setLayoutData(data);

		componentNameInput = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = NAME_INPUT_FIELD_WIDTH;
		componentNameInput.setLayoutData(data);
		componentNameInput.addListener(SWT.Modify, new Listener() {

			@Override
			public void handleEvent(Event e) {
				String name = componentNameInput.getText();

				if (useDefaultCIButton.getSelection()) {
					cINameInput
						.setText(name
							+ store
								.getString(CXPreferenceConstants.COMPONENT_INTERFACE_SUFFIX));
				}
				if (useDefaultImplButton.getSelection()) {
					implementationNameInput
						.setText(name
							+ store
								.getString(CXPreferenceConstants.IMPLEMENTATION_SUFFIX));
				}
				if (useDefaultPkgButton.getSelection()) {
					packageNameInput.setText(name
						+ store.getString(CXPreferenceConstants.PACKAGE_SUFFIX));
				}
				if (useDefaultDiagButton.getSelection()) {
					diagramNameInput.setText(name
						+ store.getString(CXPreferenceConstants.DIAGRAM_SUFFIX));
				}
				validatePage();
			}
		});

	}

	/**
	 * Calculate the label width
	 * 
	 * @param composite
	 * @return
	 */
	private int calculateDefaultLabelWidth(Composite composite) {
		GC gc = new GC(composite);
		gc.setFont(JFaceResources.getDefaultFont());
		FontMetrics fontMetrics = gc.getFontMetrics();
		gc.dispose();

		int buffer = 10;
		return Dialog.convertWidthInCharsToPixels(fontMetrics,
			MAX_LABEL_STRING_LENGTH)
			+ buffer;
	}

	/**
	 * Validates the page for a fully specified Component based on what is being
	 * created. The validation works from the top of the page to the bottom
	 * since wizard pages only display one error at a time.
	 */
	protected void validatePage() {

		if (!validateEnabled) {
			return;
		}

		if (UML2Util.isEmpty(componentNameInput.getText())) {
			this
				.setErrorMessage(Messages.ComponentCreationWizard_EmptyComponentNameField);
			setPageComplete(false);
			return;
		}
		if (componentNameInput.getText().indexOf(" ") != -1) { //$NON-NLS-1$
			this
				.setErrorMessage(Messages.ComponentCreationWizard_SpacesInComponentNameField);
			setPageComplete(false);
			return;
		}
		if (autoCIButton.getSelection()) {
			if (UML2Util.isEmpty(cINameInput.getText())) {
				this
					.setErrorMessage(Messages.ComponentCreationWizard_EmptyComponentInterfaceNameField);
				setPageComplete(false);
				return;
			}
		}
		if (autoImplButton.getSelection()) {
			if (UML2Util.isEmpty(implementationNameInput.getText())) {
				setErrorMessage(Messages.ComponentCreationWizard_EmptyImplementationNameField);
				setPageComplete(false);
				return;
			}
		}
		if (autoPkgButton.getSelection()) {
			if (UML2Util.isEmpty(packageNameInput.getText())) {
				this
					.setErrorMessage(Messages.ComponentCreationWizard_EmptyPackageNameField);
				setPageComplete(false);
				return;
			}
		}
		if (autoDiagButton.getSelection()) {
			if (UML2Util.isEmpty(diagramNameInput.getText())) {
				this
					.setErrorMessage(Messages.ComponentCreationWizard_EmptyDiagramNameField);
				setPageComplete(false);
				return;
			}
		}

		setErrorMessage(null);
		setPageComplete(true);
	}

	// Simple getters for page widget values.
	public String getComponentName() {
		return componentNameInput.getText();
	}

	public String getComponentInterfaceName() {
		return cINameInput.getText();
	}

	public String getImplementationName() {
		return implementationNameInput.getText();
	}

	public String getPackageName() {
		return packageNameInput.getText();
	}

	public String getDiagramName() {
		return diagramNameInput.getText();
	}

	public Boolean getCreateComponentInterface() {
		return autoCIButton.getSelection();
	}

	public Boolean getCreateImplementation() {
		return autoImplButton.getSelection();
	}

	public Boolean getCreatePackage() {
		return autoPkgButton.getSelection();
	}

	public Boolean getCreateDiagram() {
		return autoDiagButton.getSelection();
	}
	// End simple getters
}
