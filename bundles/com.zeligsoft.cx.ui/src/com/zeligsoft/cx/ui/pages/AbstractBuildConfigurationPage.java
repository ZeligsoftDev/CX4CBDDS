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
package com.zeligsoft.cx.ui.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.MultilineInputDialog;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Abstract class for build configuration page. Domain specific build
 * configuration pages must extend this class.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public abstract class AbstractBuildConfigurationPage
		extends PreferencePage
		implements IWorkbenchPreferencePage {

	// page ID
	private String Id;

	private static String SLOT_KIND_ADDITIVE = "additive"; //$NON-NLS-1$

	private static String SLOT_KIND_OVERRIDE = "override"; //$NON-NLS-1$

	protected InstanceSpecification selectedBaseBuildConfiguration;

	// build configuration will be set if this is modify operation.
	// set to null when creating a new instance of the build environment.
	protected InstanceSpecification buildConfiguration;

	protected InstanceSpecification baseBuildConfiguration;

	// build environment
	protected Class buildConfigurationClassifier;

	// Map containing all attribute from the build environment.
	// This will be set when setBuildEnvironment call is made.
	protected Map<String, Property> buildEnvironmentPropertyMap = new HashMap<String, Property>();

	protected Map<String, Property> propertyMap = new HashMap<String, Property>();

	protected static String INPUT_CONTROL_KEY = "input"; //$NON-NLS-1$

	protected static String OVERRIDE_CONTROL_KEY = "override"; //$NON-NLS-1$

	/**
	 * Constructor
	 * 
	 * @param pageTitle
	 *            The title of the current preference page.
	 */
	public AbstractBuildConfigurationPage(String Id, String pageTitle) {
		super();
		this.Id = Id;
		setTitle(pageTitle);
	}

	@Override
	public void createControl(Composite parent) {
		noDefaultAndApplyButton();
		super.createControl(parent);
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(data);

		createPageContents(composite);

		addRestoreDefaultButton(parent);

		return composite;
	}

	/**
	 * Creates map for the slots from the given build configuration
	 * 
	 * @return
	 */
	protected Map<String, Slot> getSlotMap(InstanceSpecification instance) {

		return BaseUIUtil.getSlotMap(instance);
	}

	/**
	 * Restore default values for local build configuration field.
	 * 
	 * @param inputControlMap
	 *            input control map for local values.
	 */
	protected void restoreDefaults(
			Map<String, Map<String, Control>> inputControlMap) {

		restoreDefaultsWith(buildConfiguration, inputControlMap);
	}

	/**
	 * Restore default values for base build configuration field.
	 * 
	 * @param inputControlMap
	 *            input control map for base values.
	 */
	protected void restoreBaseDefaults(
			Map<String, Map<String, Control>> inputControlMap) {

		restoreDefaultsWith(baseBuildConfiguration, inputControlMap);
	}

	/**
	 * Restores default values for the given input fields.
	 * 
	 * @param inputControlMap
	 */
	protected void restoreDefaultsWith(
			InstanceSpecification buildConfiguration,
			Map<String, Map<String, Control>> inputControlMap) {

		if (buildConfiguration == null) {
			Iterator<Map<String, Control>> itor = inputControlMap.values()
				.iterator();

			while (itor.hasNext()) {
				Map<String, Control> map = itor.next();
				Control inputField = map.get(INPUT_CONTROL_KEY);
				Control override = map.get(OVERRIDE_CONTROL_KEY);

				// Handle Primitive String type only for now
				if (inputField instanceof Text) {
					((Text) inputField).setText(""); //$NON-NLS-1$
				}
				if (override != null) {
					((Button) override).setSelection(false);
				}
			}
			return;
		}

		Iterator<String> itor = inputControlMap.keySet().iterator();

		Map<String, Slot> slotMap = getSlotMap(buildConfiguration);

		while (itor.hasNext()) {
			String key = itor.next();
			Slot slot = slotMap.get(key);

			Map<String, Control> inputMap = inputControlMap.get(key);

			// Handle Primitive String type only for now
			if (inputMap.get(INPUT_CONTROL_KEY) instanceof Text) {

				// TODO Add handling for types other than text
				Text text = (Text) inputMap.get(INPUT_CONTROL_KEY);
				Object o = getSlotValue(slot);
				if (o != null) {
					text.setText((String) o);
				} else {
					text.setText(""); //$NON-NLS-1$
				}
			}

			if (slot != null) {
				if (inputMap.get(OVERRIDE_CONTROL_KEY) != null) {
					Button override = (Button) inputMap
						.get(OVERRIDE_CONTROL_KEY);

					if (ZDLUtil.isZDLConcept(slot,
						ZMLMMNames.CONFIGURATION_SLOT)) {
						EnumerationLiteral slotKind = (EnumerationLiteral) ZDLUtil
							.getValue(slot, ZMLMMNames.CONFIGURATION_SLOT,
								ZMLMMNames.CONFIGURATION_SLOT__SLOT_KIND);
						if (slotKind.getName().equals(SLOT_KIND_OVERRIDE)) {
							override.setSelection(true);
						} else if (slotKind.getName()
							.equals(SLOT_KIND_ADDITIVE)) {
							override.setSelection(false);
						}
					}
				}
			} else {
				Button override = (Button) inputMap
						.get(OVERRIDE_CONTROL_KEY);
				if(override != null) {
					override.setSelection(false);
				}
			}
		}
	}

	/**
	 * Queries the slot value.
	 * 
	 * @param slot
	 * @return slot value.
	 */
	protected Object getSlotValue(Slot slot) {

		return BaseUIUtil.getSlotValue(slot);
	}

	/**
	 * Build input fields for local build configurations.
	 * 
	 * @param parent
	 * @param properties
	 * @return
	 */
	protected Map<String, Map<String, Control>> buildWidgetFromPropertyList(
			Composite parent, EList<Property> properties) {

		return buildWidgetFromPropertyList(parent, properties, SWT.BORDER, true);
	}

	/**
	 * Build input fields for base build configurations.
	 * 
	 * @param parent
	 * @param properties
	 * @return
	 */
	protected Map<String, Map<String, Control>> buildBaseWidgetFromPropertyList(
			Composite parent, EList<Property> properties) {

		return buildWidgetFromPropertyList(parent, properties, SWT.READ_ONLY,
			false);
	}

	/**
	 * Creates label and input control fields for the given properties.
	 * 
	 * @param parent
	 * @param properties
	 * @param style
	 * @param addOverride
	 * @return Map&lt;String, Map&lt;String, Control&gt;&gt;
	 */
	private Map<String, Map<String, Control>> buildWidgetFromPropertyList(
			Composite parent, EList<Property> properties, int style,
			boolean addOverride) {

		Composite composite = new Composite(parent, SWT.NONE);
		int column;
		if (addOverride) {
			column = 3;
		} else {
			column = 2;
		}
		GridLayout grid = new GridLayout(column, false);

		composite.setLayout(grid);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Map<String, Map<String, Control>> inputControlMap = new HashMap<String, Map<String, Control>>();
		Iterator<Property> itor = properties.iterator();
		while (itor.hasNext()) {

			final Property property = itor.next();
			if (property == null) {
				continue;
			}

			// Handles only String type for now
			if (property.getType() instanceof PrimitiveType) {
				Label label = new Label(composite, SWT.NONE);
				label.setText(property.getLabel(true) + ":"); //$NON-NLS-1$
				GridData data = new GridData();
				data.verticalAlignment = SWT.TOP;
				label.setLayoutData(data);

				final Text input;
				GridData inputData = new GridData(GridData.FILL_HORIZONTAL);

				if (property.isMultivalued()) {
					input = new Text(composite, SWT.BORDER | SWT.MULTI
						| SWT.V_SCROLL | style);
					inputData.heightHint = 45;
				} else {
					input = new Text(composite, SWT.BORDER | style);
				}
				input.setLayoutData(inputData);
				if (property.isReadOnly()) {
					input.setEditable(false);
				}

				Map<String, Control> itemMap = new HashMap<String, Control>();
				itemMap.put(INPUT_CONTROL_KEY, input);

				if (addOverride) {
					Composite overrideComposite = new Composite(composite,
							SWT.NULL);
					GridLayout layout = new GridLayout(1, false);
					layout.verticalSpacing = 0;
					layout.marginHeight = 0;
					overrideComposite.setLayout(layout);
					overrideComposite.setLayoutData(new GridData());
					
					final Button inputButton = new Button(overrideComposite,
							SWT.PUSH);
					GridData buttonData = new GridData(GridData.VERTICAL_ALIGN_END);
					buttonData.widthHint = 40;
					buttonData.heightHint = 20;
					inputButton.setText("..."); //$NON-NLS-1$
					inputButton.setLayoutData(buttonData);
					inputButton.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							MultilineInputDialog dialog = new MultilineInputDialog(
									getShell(),
									Messages.AbstractBuildConfigurationPage_TextDialogTitle,
									input.getText());
							int result = dialog.open();
							if (result == Window.OK) {
								input.setText(dialog.getText());
							}
						}
					});

					final Button override = new Button(overrideComposite,
							SWT.CHECK);
					override.setText(Messages.AbstractBuildConfigurationPage_OverrideButtonLabel);
					override.setLayoutData(new GridData(
							GridData.VERTICAL_ALIGN_END));
					override.addSelectionListener(new SelectionAdapter() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							overrideSelected(property.getName());
						}
					});
					itemMap.put(OVERRIDE_CONTROL_KEY, override);
				}
				inputControlMap.put(property.getName(), itemMap);
			}
		}
		return inputControlMap;
	}

	/**
	 * Get the base configuration value and fill in local configuration field
	 * 
	 * with the base value when override is selected.
	 * 
	 * @param propertyName
	 */
	protected void overrideSelected(String propertyName) {

		Map<String, Slot> slotMap = getSlotMap(getSelectedBaseBuildConfiguration());
		Slot slot = slotMap.get(propertyName);
		Control input = getInputControlMap().get(propertyName).get(
			INPUT_CONTROL_KEY);
		Button override = (Button) getInputControlMap().get(propertyName).get(
			OVERRIDE_CONTROL_KEY);

		if (input instanceof Text) {
			((Text) input).setText(""); //$NON-NLS-1$
		}
		if (override.getSelection()) {
			if (input instanceof Text) {
				Object o = getSlotValue(slot);
				if (o != null) {
					((Text) input).setText((String) o);
				}
			}
		}
	}

	/**
	 * Creates a group with given text
	 * 
	 * @param parent
	 *            Parent composite
	 * @param text
	 *            description text
	 * @return Group
	 */
	protected Group createGroup(Composite parent, String text) {

		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setText(text);

		return group;
	}

	/**
	 * Subclass must extend this method to provide page specific contents.
	 * 
	 * @param parent
	 * @return
	 */
	protected abstract Control createPageContents(Composite parent);

	/**
	 * This method adds restore defaults button
	 * 
	 * @param parent
	 */
	protected void addRestoreDefaultButton(Composite composite) {

		Composite buttonComposite = new Composite(composite, SWT.NULL);
		buttonComposite.setLayout(new GridLayout(1, false));
		buttonComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END));
		Button restoreButton = new Button(buttonComposite, SWT.PUSH);
		restoreButton.setLayoutData(new GridData());
		if (buildConfiguration != null) {
			restoreButton
					.setText(Messages.AbstractBuildConfigurationPage_RestoreDefaultsButtonLabel);
		} else {
			restoreButton
					.setText(Messages.AbstractBuildConfigurationPage_ResetButtonLabel);
		}
		restoreButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				restoreDefaults();
			}
		});
	}

	/**
	 * Restore default values for the input fields.
	 */
	protected void restoreDefaults() {
		restoreDefaults(getInputControlMap());
		if (baseBuildConfiguration != null) {
			restoreBaseDefaults(getBaseInputControlMap());
		} else {
			restoreDefaultsWith(getSelectedBaseBuildConfiguration(),
				getBaseInputControlMap());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		// do nothing
	}

	/**
	 * Subclass must override this method to add necessary properties to the
	 * given build configuration.
	 * 
	 * @param instance
	 * @return
	 */
	public boolean performOk(InstanceSpecification instance) {
		return addValuesToInstance(instance, getInputControlMap());
	}

	/**
	 * Users are discouraged to use this method to set the build configuration
	 * instance. This will be called from the
	 * {@link AbstractBuildConfigurationDialog}.
	 * 
	 * @param instance
	 */
	public void setBuildConfigurationInstance(InstanceSpecification instance) {

		this.buildConfiguration = instance;

		if (instance != null) {
			Map<String, Slot> slotMap = getSlotMap(instance);
			Object o = getSlotValue(slotMap.get("buildconfiguration")); //$NON-NLS-1$
			this.baseBuildConfiguration = (InstanceSpecification) o;
			this.selectedBaseBuildConfiguration = baseBuildConfiguration;
		}

	}

	/**
	 * Queries currently selected base build configuration.
	 * 
	 * @return
	 */
	public InstanceSpecification getSelectedBaseBuildConfiguration() {
		return selectedBaseBuildConfiguration;
	}

	/**
	 * Set user selected base configuration.
	 * 
	 * @param instance
	 */
	public void setSelectedBaseBuildConfiguration(InstanceSpecification instance) {
		setSelectedBaseBuildConfiguration(instance, false);
	}
	
	/**
	 * Listen base build configuration selection change
	 * 
	 * @param instance
	 *            selected build configuration
	 * @param resetLocalValues
	 *            restore local values if this value is set to
	 *            <strong>true</strong>
	 */
	public void setSelectedBaseBuildConfiguration(InstanceSpecification instance, boolean resetLocalValues) {
		// If no base build configuration change then do nothing.
		if(selectedBaseBuildConfiguration == instance){
			return;
		}
		selectedBaseBuildConfiguration = instance;
		// Display values for new selected base build configuration
		restoreDefaultsWith(getSelectedBaseBuildConfiguration(),
			getBaseInputControlMap());
		if (resetLocalValues) {
			// reset local values
			restoreDefaultsWith(null, getInputControlMap());
		}
	}

	/**
	 * Users are discouraged to use this method to set the build environment
	 * class. This will be called from the
	 * {@link AbstractBuildConfigurationDialog}.
	 * 
	 * @param instance
	 */
	public void setBuildConfigurationClassifier(Class classifier) {

		Assert
			.isNotNull(
				classifier,
				Messages.AbstractBuildConfigurationPage_InvalidBuildConfigurationClassLog);

		if (classifier != null) {
			this.buildConfigurationClassifier = classifier;

			EList<Property> properties = classifier.getAllAttributes();
			Iterator<Property> itor = properties.iterator();
			while (itor.hasNext()) {
				Property property = itor.next();
				buildEnvironmentPropertyMap.put(property.getName(), property);
			}
			propertyMap.putAll(buildEnvironmentPropertyMap);
		}
	}

	/**
	 * Save values to the given instance. Slots will be created if not already
	 * exist.
	 * 
	 * @param instance
	 * @param textFieldMap
	 */
	private boolean addValuesToInstance(InstanceSpecification instance,
			Map<String, Map<String, Control>> inputControlMap) {

		if (inputControlMap == null) {
			return false;
		}
		Iterator<Slot> slotItor = instance.getSlots().iterator();
		Map<String, Slot> slotMap = new HashMap<String, Slot>();
		while (slotItor.hasNext()) {
			Slot slot = slotItor.next();
			if (slot.getDefiningFeature() != null) {
				slotMap.put(slot.getDefiningFeature().getName(), slot);
			}
		}

		Iterator<String> propertyItor = inputControlMap.keySet().iterator();

		while (propertyItor.hasNext()) {

			String key = propertyItor.next();
			Property property = propertyMap.get(key);

			Slot destSlot = slotMap.get(key);
			if (destSlot != null) {
				destroySlotValue(destSlot);
			} else {
				Class container = (Class) property.eContainer();
				StructuralFeature feature = (StructuralFeature) container.getFeature(key);
				destSlot = instance.createSlot();
				destSlot.setDefiningFeature(feature);
				ZDLUtil.addZDLConcept(destSlot, ZMLMMNames.CONFIGURATION_SLOT);
			}
			Map<String, Control> inputMap = inputControlMap.get(key);
			Button override = (Button) inputMap.get(OVERRIDE_CONTROL_KEY);

			if (key.equals("buildconfiguration")) { //$NON-NLS-1$
				if (getSelectedBaseBuildConfiguration() == null) {
					destSlot.destroy();
				} else {
					InstanceValue value = (InstanceValue) destSlot.createValue(null,
							destSlot.getDefiningFeature().getType(),
							UMLPackage.Literals.INSTANCE_VALUE);

					value.setInstance(getSelectedBaseBuildConfiguration());
				}
			} else if (inputMap.get(INPUT_CONTROL_KEY) instanceof Text) {
				Text text = (Text) inputMap.get(INPUT_CONTROL_KEY);
				String newText = text.getText();
				String[] newValues = newText.split(text.getLineDelimiter());
				StructuralFeature feature = destSlot.getDefiningFeature();

				/***************************************************************
				 * Currently only handles Literal String type Other types such
				 * as Enumeration must be supported in the future.
				 **************************************************************/
				if (feature.getType() instanceof PrimitiveType) {

					if (feature.isMultivalued()) {
						for (int i = 0; i < newValues.length; i++) {
							LiteralString value = (LiteralString) destSlot
								.createValue(null, destSlot
									.getDefiningFeature().getType(),
									UMLPackage.Literals.LITERAL_STRING);
							value.setValue(newValues[i]);
						}
					} else {
						LiteralString value = (LiteralString) destSlot
							.createValue(null, destSlot.getDefiningFeature()
								.getType(), UMLPackage.Literals.LITERAL_STRING);
						value.setValue(newValues[0]);
					}
				}

				if (override == null){
					continue;
				}
				EnumerationLiteral slotKind = (EnumerationLiteral) ZDLUtil
					.getValue(destSlot, ZMLMMNames.CONFIGURATION_SLOT,
						ZMLMMNames.CONFIGURATION_SLOT__SLOT_KIND);
				EnumerationLiteral newValue;
				if (override.getSelection()) {
					newValue = slotKind.getEnumeration().getOwnedLiteral(
						"override"); //$NON-NLS-1$
				} else {
					newValue = slotKind.getEnumeration().getOwnedLiteral(
						"additive"); //$NON-NLS-1$
				}
				ZDLUtil.setValue(destSlot, ZMLMMNames.CONFIGURATION_SLOT,
					ZMLMMNames.CONFIGURATION_SLOT__SLOT_KIND, newValue);

			} else if (inputMap.get(INPUT_CONTROL_KEY) instanceof Button) {
				Button button = (Button) inputMap.get(INPUT_CONTROL_KEY);
				StructuralFeature feature = destSlot.getDefiningFeature();

				if (feature.getType() instanceof PrimitiveType) {
					LiteralBoolean value = (LiteralBoolean) destSlot.createValue(null,
							destSlot.getDefiningFeature().getType(),
							UMLPackage.Literals.LITERAL_BOOLEAN);
					value.setValue(button.getSelection());
				}
			}
			
			// Remove any empty build property slot if it is additive. We need to
			// leave overridden properties even if it is empty
			if (destSlot != null && override != null) {
				if (!override.getSelection() && getSlotValue(destSlot) == null) {
					destSlot.destroy();
				}
			}
		}
		return true;
	}

	/**
	 * Destroy slot values
	 * 
	 * @param slot
	 */
	private void destroySlotValue(Slot slot) {
		if (slot == null)
			return;
		Object[] valueArray = slot.getValues().toArray();
		for (int i = 0; i < valueArray.length; i++) {
			((ValueSpecification) valueArray[i]).destroy();
		}
	}
	/**
	 * Return page Id.
	 * 
	 * @return Page Id.
	 */
	public String getId() {
		return Id;
	}

	/**
	 * Subclass must override this method to provide input field map of type
	 * Map&lt;String, Control&gt;.
	 */
	protected abstract Map<String, Map<String, Control>> getInputControlMap();

	/**
	 * Subclass must override this method to provide input field map of type
	 * Map&lt;String, Control&gt;.
	 */
	protected abstract Map<String, Map<String, Control>> getBaseInputControlMap();
}
