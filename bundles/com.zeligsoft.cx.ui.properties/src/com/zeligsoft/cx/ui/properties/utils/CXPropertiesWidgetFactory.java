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
package com.zeligsoft.cx.ui.properties.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.dialogs.PropertiesDialog;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.UMLPackage;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.TextualDefinition;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.filters.ElementSelectionFilter;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.l10n.Messages;
import com.zeligsoft.cx.ui.properties.pages.CXElementCreationPage;
import com.zeligsoft.cx.ui.properties.pages.CXPropertyCollectionPage;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Widget factory for CX Property Pages
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CXPropertiesWidgetFactory extends CXWidgetFactory{

	public static final String PROPERTY_LABEL = "label"; //$NON-NLS-1$

	public static final String PROPERTY_VALUE = "value"; //$NON-NLS-1$

	public static final String PROPERTY_VALUE_ICON = "icon"; //$NON-NLS-1$

	public static final String PROPERTY_EDIT_BUTTON = "edit_button"; //$NON-NLS-1$

	public static final String PROPERTY_DELETE_BUTTON = "delete_button"; //$NON-NLS-1$

	public static final String PROPERTY_CHECKBOX_BUTTON = "checkbox_button"; //$NON-NLS-1$

	/**
	 * Queries the workbench image
	 * 
	 * @param imagePath
	 * @return
	 */
	public static Image getWorkbenchImage(String bundleId, String imagePath) {
		Bundle pluginBundle = Platform.getBundle(bundleId);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			Image image = imageDescriptor.createImage();
			return image;
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * Creates section for composite type property
	 * 
	 * @param parent
	 * @param descriptor
	 * @return
	 */
	public static Map<String, Control> createSectionCompositeType(
			Composite parent, final CXPropertyDescriptor descriptor) {

		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(PROPERTY_LABEL,
			CXWidgetFactory.createLabel(parent, descriptor.getProperty()
				.getLabel()
				+ " : ", parent.getBackground())); //$NON-NLS-1$

		final Composite composite = CXWidgetFactory.createFlatGridComposite(
			parent, 3, GridData.HORIZONTAL_ALIGN_BEGINNING);
		composite.setBackground(parent.getBackground());

		final Label imageLabel = new Label(composite, SWT.ICON);
		imageLabel.setLayoutData(new GridData());
		imageLabel.setBackground(parent.getBackground());
		final Label textLabel = new Label(composite, SWT.NULL);
		textLabel.setLayoutData(new GridData());
		textLabel.setBackground(parent.getBackground());

		widgetMap.put(PROPERTY_VALUE_ICON, imageLabel);
		widgetMap.put(PROPERTY_VALUE, textLabel);

		final PropertiesDialog dialog = new PropertiesDialog(getShell(),
			new PreferenceManager());

		final Object value = descriptor.getValue();

		if (descriptor.getProperty().isMultivalued()) {
			List list = (List) value;
			textLabel.setText(Messages.CXWidgetFactory_MultivalueEntriesLabel
				+ list.size());
			dialog.getPreferenceManager().addToRoot(
				new PreferenceNode(StringStatics.BLANK,
					new CXPropertyCollectionPage(descriptor)));
		} else {

			CXPropertyDescriptor newDescriptor;
			if (value != null) {

				if (value instanceof EObject) {
					EObject eObject = (EObject) value;
					Class concept = ZDLUtil.getZDLConcept(eObject);
					newDescriptor = new CXPropertyDescriptor(eObject, concept,
						null, null);

					Image icon = BaseUIUtil.getIcon(eObject);
					if (icon != null) {
						imageLabel.setImage(icon);
					}
					textLabel.setText(concept.getName());

					dialog.getPreferenceManager().addToRoot(
						new PreferenceNode(StringStatics.BLANK,
							new CXElementCreationPage(newDescriptor)));

				} else {
					return null;
				}
			} else {
				textLabel.setText(Messages.CXWidgetFactory_NullValueString);
			}
		}

		Composite buttonComposite = createNoMarginGridComposite(composite, 1,
			GridData.HORIZONTAL_ALIGN_BEGINNING);
		buttonComposite.setBackground(composite.getBackground());
		if (value != null && !descriptor.getProperty().isMultivalued()
			&& !descriptor.isReadOnly()) {
			((GridLayout) buttonComposite.getLayout()).numColumns++;
			final ToolBar deleteToolBar = CXWidgetFactory.createToolbarButton(
				buttonComposite, DELETE_OBJECT_IMAGE);
			deleteToolBar.getItem(0).setToolTipText(
				Messages.CXWidgetFactory_DeleteButtonTooltip);
			deleteToolBar.getItem(0).addSelectionListener(
				new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						descriptor.setValue(null);
					}
				});
			widgetMap.put(PROPERTY_DELETE_BUTTON, deleteToolBar);

		}
		final ToolBar addToolBar = CXWidgetFactory.createToolbarButton(
			buttonComposite, EDIT_OBJECT_IMAGE);
		addToolBar.getItem(0).setToolTipText(
			Messages.CXWidgetFactory_EditButtonTooltip
				+ descriptor.getProperty().getLabel());
		addToolBar.getItem(0).addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!descriptor.getProperty().isMultivalued() && value == null) {
					Object newObject = descriptor
						.createConcept((Class) descriptor.getProperty()
							.getType());
					if (newObject instanceof EObject) {
						CXPropertyDescriptor newDescriptor = new CXPropertyDescriptor(
							(EObject) newObject, ZDLUtil
								.getZDLConcept((EObject) newObject), null, null);
						dialog.getPreferenceManager().addToRoot(
							new PreferenceNode(StringStatics.BLANK,
								new CXElementCreationPage(newDescriptor)));
					} else {
						return;
					}
				}
				dialog.open();
			}
		});

		widgetMap.put(PROPERTY_EDIT_BUTTON, addToolBar);

		if (descriptor.isReadOnly()) {
			addToolBar.getItem(0).setEnabled(false);
		}
		return widgetMap;
	}

	/**
	 * Create section for the reference property type
	 * 
	 * @param parent
	 * @param descriptor
	 */
	public static Map<String, Control> createSectionForReferenceType(
			final Composite parent, final CXPropertyDescriptor descriptor) {

		return createSectionForReferenceType(parent, descriptor, null, null,
				null);
	}

	/**
	 * Create reference section with custom property label
	 * @param parent
	 * @param descriptor
	 * @param propertyLabel
	 * @return
	 */
	public static Map<String, Control> createSectionForReferenceType(
			final Composite parent, final CXPropertyDescriptor descriptor,
			String propertyLabel) {

		return createSectionForReferenceType(parent, descriptor, null, null,
				propertyLabel);
	}
	
	/**
	 * Create reference section with custom filter
	 * 
	 * @param parent
	 * @param descriptor
	 * @param conceptsToFilter
	 * @return
	 */
	public static Map<String, Control> createSectionForReferenceType(
			final Composite parent, final CXPropertyDescriptor descriptor,
			List<String> conceptsToFilter) {

		return createSectionForReferenceType(parent, descriptor,
				conceptsToFilter, null, null);
	}

	/**
	 * Create reference section with custom filter
	 * 
	 * @param parent
	 * @param descriptor
	 * @param filter
	 * @return
	 */
	public static Map<String, Control> createSectionForReferenceType(
			final Composite parent, final CXPropertyDescriptor descriptor,
			IFilter filter) {

		return createSectionForReferenceType(parent, descriptor, null,
				filter, null);
	}

	/**
	 * Create reference section that will bring up element selection dialog with
	 * the given filter concepts
	 * 
	 * @param parent
	 * @param descriptor
	 * @param conceptsToFilter
	 * @param filter
	 * @param propertyLabel
	 * @return
	 */
	private static Map<String, Control> createSectionForReferenceType(
			Composite parent, final CXPropertyDescriptor descriptor,
			List<String> conceptsToFilter, IFilter filter, String propertyLabel) {
		return createSectionForReferenceType(parent, descriptor,
				conceptsToFilter, filter, propertyLabel, null);
	}

	/**
	 * Create reference section that will bring up element selection dialog with
	 * the given filter concepts
	 * 
	 * @param parent
	 * @param descriptor
	 * @param conceptsToFilter
	 * @param filter
	 * @param propertyLabel
	 * @param additionalCommand
	 * @return
	 */
	public static Map<String, Control> createSectionForReferenceType(
			Composite parent, final CXPropertyDescriptor descriptor,
			List<String> conceptsToFilter, IFilter filter,
			String propertyLabel,
			final AbstractTransactionalCommand additionalCommand) {

		Map<String, Control> widgetMap = new HashMap<String, Control>();

		String label = descriptor.getProperty().getLabel();
		if (propertyLabel != null && propertyLabel.length() != 0) {
			label = propertyLabel;
		}

		widgetMap.put(
				PROPERTY_LABEL,
				CXWidgetFactory.createLabel(parent,
						label + " : ", parent.getBackground())); //$NON-NLS-1$

		final Composite composite = CXWidgetFactory.createFlatGridComposite(
			parent, 3, GridData.HORIZONTAL_ALIGN_BEGINNING);
		composite.setBackground(parent.getBackground());

		final Label imageLabel = new Label(composite, SWT.ICON);
		imageLabel.setLayoutData(new GridData());
		imageLabel.setBackground(parent.getBackground());
		final Label textLabel = new Label(composite, SWT.NULL);
		textLabel.setLayoutData(new GridData());
		textLabel.setBackground(parent.getBackground());

		widgetMap.put(PROPERTY_VALUE_ICON, imageLabel);
		widgetMap.put(PROPERTY_VALUE, textLabel);

		final org.eclipse.jface.dialogs.Dialog dialog;

		final Object value = descriptor.getValue();

		if (descriptor.getProperty().isMultivalued()) {
			if (!(value instanceof List)) {
				return null;
			}
			List list = (List) value;
			textLabel.setText(Messages.CXWidgetFactory_MultivalueEntriesLabel
				+ list.size());

			PropertiesDialog collectionDialog = new PropertiesDialog(
				getShell(), new PreferenceManager());
			collectionDialog.getPreferenceManager().addToRoot(
				new PreferenceNode(StringStatics.BLANK,
					new CXPropertyCollectionPage(descriptor)));
			dialog = collectionDialog;
		} else {
			ZDLElementSelectionDialog selectionDialog;
			if (conceptsToFilter == null || conceptsToFilter.isEmpty() || filter != null) {
				selectionDialog = new ZDLElementSelectionDialog(getShell(),
						Messages.CXWidgetFactory_ElementSelectionDialogTitle, descriptor
								.getContext(), Collections.EMPTY_LIST, true, true);
				if (filter != null) {
					selectionDialog.setElementFilter(filter);
				} else {
					selectionDialog
							.setElementFilter(new ElementSelectionFilter(
									descriptor.getConcept().getQualifiedName(),
									descriptor.getProperty().getName()));
				}

			} else {
				selectionDialog = new ZDLElementSelectionDialog(getShell(),
						Messages.CXWidgetFactory_ElementSelectionDialogTitle, descriptor
								.getContext(), conceptsToFilter, true, true);
			}

			dialog = selectionDialog;

			if (value != null) {
				if (value instanceof EObject) {

					Image icon = BaseUIUtil.getIcon((EObject) value);
					if (icon != null) {
						imageLabel.setImage(icon);
					}
					textLabel.setText(EMFCoreUtil.getQualifiedName(
							(EObject) value, true));
				} else {
					return widgetMap;
				}
			} else {
				textLabel.setText(Messages.CXWidgetFactory_NullValueString);
			}
		}

		Composite buttonComposite = createNoMarginGridComposite(composite, 2,
			GridData.HORIZONTAL_ALIGN_BEGINNING);
		buttonComposite.setBackground(composite.getBackground());

		if (value != null && !descriptor.getProperty().isMultivalued()
			&& !descriptor.isReadOnly()) {
			((GridLayout) buttonComposite.getLayout()).numColumns++;
			final ToolBar deleteToolBar = CXWidgetFactory.createToolbarButton(
				buttonComposite, DELETE_OBJECT_IMAGE);
			deleteToolBar.getItem(0).setToolTipText(
				Messages.CXWidgetFactory_DeleteButtonTooltip);
			deleteToolBar.getItem(0).addSelectionListener(
				new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
							if (additionalCommand == null) {
								descriptor.setValue(null);
							} else {
								descriptor.setValue(null, additionalCommand);
							}
					}
				});
			widgetMap.put(PROPERTY_DELETE_BUTTON, deleteToolBar);

		}

		final ToolBar addToolBar = CXWidgetFactory.createToolbarButton(
			buttonComposite, EDIT_OBJECT_IMAGE);
		addToolBar.getItem(0).setToolTipText(
			Messages.CXWidgetFactory_EditButtonTooltip
				+ descriptor.getProperty().getLabel());
		addToolBar.getItem(0).addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int result = dialog.open();
				if (result == org.eclipse.jface.window.Window.OK) {
					if (dialog instanceof ZDLElementSelectionDialog) {
						if (!((ZDLElementSelectionDialog) dialog).getSelectedElements()
								.isEmpty()) {
							EObject selectedElement = (EObject) ((ZDLElementSelectionDialog) dialog)
									.getSelectedElements().iterator().next();
							if (selectedElement != null) {
								if (additionalCommand == null) {
									descriptor.setValue(selectedElement);
								} else {
									descriptor.setValue(selectedElement, additionalCommand);
								}								
							}
						}
					}
				}
			}
		});
		widgetMap.put(PROPERTY_EDIT_BUTTON, addToolBar);

		if (descriptor.isReadOnly()) {
			addToolBar.getItem(0).setEnabled(false);
		}
		
		// If the property is reference type, then add button to view its
		// properties view
		if (!descriptor.getProperty().isMultivalued()) {
			final EObject object = (EObject) descriptor.getValue();

			final ToolBar viewToolBar = CXWidgetFactory.createToolbarButton(
					buttonComposite, FORWARD_NAV_IMAGE);
			viewToolBar.getItem(0).setToolTipText(
					Messages.CXWidgetFactory_ShowPropertiesToolTip);
			if (object == null) {
				viewToolBar.getItem(0).setEnabled(false);
			}
			viewToolBar.getItem(0).addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (object != null) {
						BaseUIUtil.showInProjectExplorer(object);
					}
				}
			});
		}
		
		return widgetMap;
	}

	/**
	 * Creates section for enumeration type
	 * 
	 * @param parent
	 * @param descriptor
	 * @return
	 */
	public static Map<String, Control> createSectionForEnumerationType(
			Composite parent, final CXPropertyDescriptor descriptor) {
		return createSectionForEnumerationType(parent, descriptor, false, false);
	}
	
	/**
	 * Creates section for enumeration type
	 * 
	 * @param parent
	 * @param descriptor
	 * @return
	 */
	public static Map<String, Control> createSectionForEnumerationType(
			Composite parent, final CXPropertyDescriptor descriptor, boolean alwaysCombo) {
		return createSectionForEnumerationType(parent, descriptor, alwaysCombo, false);
	}

	/**
	 * Creates section for enumeration type with a boolean to create combo box
	 * always
	 * 
	 * @param parent
	 * @param descriptor
	 */
	public static Map<String, Control> createSectionForEnumerationType(
			Composite parent, final CXPropertyDescriptor descriptor,
			boolean alwaysCombo, boolean isReadOnly) {
		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(PROPERTY_LABEL,
			CXWidgetFactory.createLabel(parent, descriptor.getProperty()
				.getLabel()
				+ " : ", parent.getBackground())); //$NON-NLS-1$

		final Composite composite = CXWidgetFactory.createFlatGridComposite(
			parent, 2, GridData.HORIZONTAL_ALIGN_BEGINNING);
		composite.setBackground(parent.getBackground());

		if (descriptor.getProperty().isMultivalued()) {
			((GridLayout) composite.getLayout()).numColumns++;
			new Label(composite, SWT.NULL);
			// Use collection dialog
			final PropertiesDialog dialog = new PropertiesDialog(getShell(),
				new PreferenceManager());
			dialog.getPreferenceManager().addToRoot(
				new PreferenceNode(StringStatics.BLANK,
					new CXPropertyCollectionPage(descriptor)));

			Label label = new Label(composite, SWT.NULL);
			label.setText(Messages.CXWidgetFactory_MultivalueEntriesLabel
				+ ((List) descriptor.getValue()).size());
			label.setBackground(parent.getBackground());

			final ToolBar addToolBar = CXWidgetFactory.createToolbarButton(
				composite, EDIT_OBJECT_IMAGE);
			addToolBar.getItem(0).setToolTipText(
				Messages.CXWidgetFactory_EditButtonTooltip
					+ descriptor.getProperty().getLabel());
			addToolBar.getItem(0).addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					dialog.open();
				}
			});

			widgetMap.put(PROPERTY_EDIT_BUTTON, addToolBar);
			return widgetMap;

		}
		final Enumeration ownedEnum = (Enumeration) descriptor.getProperty()
			.getType();
		EList<EnumerationLiteral> literals = ownedEnum.getOwnedLiterals();
		
		if (alwaysCombo || literals.size() > 5){
			createComboSectionForEnumerationType(composite, descriptor, isReadOnly);
		}else {
			createRadioSectionForEnumerationType(composite, descriptor, isReadOnly);
		} 

		return widgetMap;
	}

	/**
	 * creates combo section for enum type
	 * 
	 * @param parent
	 * @param descriptor
	 */
	private static void createComboSectionForEnumerationType(
			final Composite parent, final CXPropertyDescriptor descriptor, boolean isReadOnly) {

		final Enumeration ownedEnum = (Enumeration) descriptor.getProperty()
			.getType();
		EList<EnumerationLiteral> literals = ownedEnum.getOwnedLiterals();

		EnumerationLiteral value = (EnumerationLiteral) descriptor.getValue();

		Composite composite = CXWidgetFactory.createNoMarginGridComposite(
			parent, 1, GridData.HORIZONTAL_ALIGN_BEGINNING);
		composite.setBackground(parent.getBackground());

		final String[] comboItems = new String[literals.size()];
		final Map<String, EnumerationLiteral> enumLiteralMap = new HashMap<String, EnumerationLiteral>();
		Iterator<EnumerationLiteral> itor = literals.iterator();
		int index = 0;
		int selectedIndex = -1;
		while (itor.hasNext()) {
			EnumerationLiteral e = itor.next();
			enumLiteralMap.put(e.getLabel(), e);
			comboItems[index] = e.getLabel();
			if (comboItems[index].equals(value.getLabel())) {
				selectedIndex = index;
			}
			index++;
		}

		final Combo combo = new Combo(composite, SWT.SINGLE | SWT.READ_ONLY);
		combo.setItems(comboItems);
		combo.select(selectedIndex);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_BEGINNING));
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (combo.getSelectionIndex() != -1) {
					EnumerationLiteral newValue = enumLiteralMap
						.get(comboItems[combo.getSelectionIndex()]);
					descriptor.setValue(newValue);
				}
			}
		});

		if (descriptor.isReadOnly() || isReadOnly) {
			combo.setEnabled(false);
		}
	}

	/**
	 * creates radio section for enum type
	 * 
	 * @param parent
	 * @param descriptor
	 */
	private static void createRadioSectionForEnumerationType(
			final Composite parent, final CXPropertyDescriptor descriptor, boolean isReadOnly) {

		final Enumeration ownedEnum = (Enumeration) descriptor.getProperty()
			.getType();
		EList<EnumerationLiteral> literals = ownedEnum.getOwnedLiterals();

		descriptor.getProperty().isMultivalued();
		EnumerationLiteral value = (EnumerationLiteral) descriptor.getValue();

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent,
			literals.size(), GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		final Map<String, EnumerationLiteral> enumLiteralMap = new HashMap<String, EnumerationLiteral>();
		final EList<Button> buttons = new BasicEList<Button>();
		Iterator<EnumerationLiteral> itor = literals.iterator();
		while (itor.hasNext()) {
			EnumerationLiteral e = itor.next();
			String label = e.getLabel();
			enumLiteralMap.put(label, e);
			final Button button = CXWidgetFactory.createRadioButton(composite,
				label, new GridData());
			button.setBackground(parent.getBackground());
			buttons.add(button);
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					Iterator<Button> itor = buttons.iterator();

					button.setSelection(true);

					while (itor.hasNext()) {
						Button b = itor.next();
						if (b != button && b.getSelection()) {
							b.setSelection(false);
						}
					}

					if (button.getSelection()) {
						if (!button.isDisposed()) {
							descriptor.setValue(enumLiteralMap.get(button
								.getText()));
						}
					}
				}
			});

			if (e.getLabel().equals(value.getLabel())) {
				button.setSelection(true);
			}
		}
		if (descriptor.isReadOnly() || isReadOnly) {
			for( Button button : buttons) {
				button.setEnabled(false);
			}
		}
	}

	/**
	 * Creates section for boolean type
	 * 
	 * @param parent
	 * @param descriptor
	 */
	public static Map<String, Control> createSectionForBooleanType(
			Composite parent, final CXPropertyDescriptor descriptor) {

		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(PROPERTY_LABEL,
			CXWidgetFactory.createLabel(parent, descriptor.getProperty()
				.getLabel()
				+ " : ", parent.getBackground())); //$NON-NLS-1$

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent,
			1, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		final Button checkbox = CXWidgetFactory.createCheckButton(composite,
			UML2Util.EMPTY_STRING, new GridData());
		widgetMap.put(PROPERTY_CHECKBOX_BUTTON, checkbox);
		checkbox.setBackground(parent.getBackground());

		if ((Boolean) descriptor.getValue() == true) {
			checkbox.setSelection(true);
		}

		checkbox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Boolean value;

				if (checkbox.getSelection()) {
					value = Boolean.valueOf(true);
				} else {
					value = Boolean.valueOf(false);
				}
				descriptor.setValue(value);
			}

		});

		if (descriptor.isReadOnly()) {
			checkbox.setEnabled(false);
		}

		return widgetMap;
	}

	public static Map<String, Control> createSectionForStringType(
			final Composite parent, final CXPropertyDescriptor descriptor) {
		return createSectionForStringType(parent, descriptor, false, null);
	}
	
	public static Map<String, Control> createSectionForStringType(
			final Composite parent, final CXPropertyDescriptor descriptor,
			final boolean multiLine) {
		return createSectionForStringType(parent, descriptor, multiLine, null);
	}

	/**
	 * creates section for string type
	 * 
	 * @param parent
	 * @param descriptor
	 */
	public static Map<String, Control> createSectionForStringType(
			final Composite parent, final CXPropertyDescriptor descriptor,
			final boolean multiLine, String valueToSet) {

		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(PROPERTY_LABEL,
			CXWidgetFactory.createLabel(parent, descriptor.getProperty()
				.getLabel()
				+ " : ", parent.getBackground())); //$NON-NLS-1$

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent,
			2, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		final boolean isIntegerType;

		if (descriptor.getProperty().getType().getLabel().equals(
			UMLPackage.Literals.INTEGER.getName())) {
			isIntegerType = true;
		} else {
			isIntegerType = false;
		}
		
		Object setValue = null;
		if(UML2Util.isEmpty(valueToSet)) {
			setValue = descriptor.getValue();
		} else {
			setValue = valueToSet;
		} 
		final Object value = setValue;

		if (descriptor.getProperty().isMultivalued()) {
			final PropertiesDialog dialog = new PropertiesDialog(getShell(),
				new PreferenceManager());
			dialog.getPreferenceManager().addToRoot(
				new PreferenceNode(StringStatics.BLANK,
					new CXPropertyCollectionPage(descriptor)));
			Label label = new Label(composite, SWT.NULL);
			label.setText(Messages.CXWidgetFactory_MultivalueEntriesLabel
				+ ((List) value).size());
			final ToolBar collectionButton = CXWidgetFactory
				.createToolbarButton(composite, EDIT_OBJECT_IMAGE);
			collectionButton.getItem(0).setToolTipText(
				Messages.CXWidgetFactory_EditButtonTooltip
					+ descriptor.getProperty().getLabel());
			collectionButton.getItem(0).addSelectionListener(
				new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						dialog.open();
					}
				});

			widgetMap.put(PROPERTY_EDIT_BUTTON, collectionButton);
			return widgetMap;
		}

		int style = SWT.BORDER;
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		if (multiLine) {
			style = style | SWT.MULTI;
			data.heightHint = 50;
		}
		final Text text = new Text(composite, style);
		text.setLayoutData(data);
		widgetMap.put(PROPERTY_VALUE, text);

		String textValue;

		if (value != null) {
			if (isIntegerType) {
				textValue = value.toString();
			} else {
				String[] valueArray = ((String) value).split(System
						.getProperty("line.separator")); //$NON-NLS-1$

				if (valueArray.length < 1) {
					textValue = "";//$NON-NLS-1$
				} else {
					if (multiLine) {
						textValue = (String) value;
					} else {
						textValue = valueArray[0];
						if (valueArray.length > 1) {
							textValue += " " //$NON-NLS-1$
									+ Messages.CXWidgetFactory_CollectionButtonLabel;
							text.setEditable(false);
						}
					}
				}
			}
		} else {
			textValue = ""; //$NON-NLS-1$
		}
		text.setText(textValue);

		if (!multiLine) {
			text.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (!text.getEditable()) {
						return;
					}
					if (e.character == SWT.CR) {
						if (!text.isDisposed()) {
							Object newValue;
							if (value instanceof Integer) {
								try {
									newValue = new Integer(text.getText());
								} catch (NumberFormatException nfe) {
									Object currentValue = descriptor.getValue();
									if (currentValue != null) {
										text.setText(currentValue.toString());
									} else {
										text.setText(""); //$NON-NLS-1$
									}
									return;
								}
							} else {
								newValue = text.getText();
							}
							descriptor.setValue(newValue);
						}
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
		text.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// do nothing
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!text.getEditable()) {
					return;
				}
				if (!text.isDisposed()) {
					String input = text.getText();

					if (value == null && UML2Util.isEmpty(input)) {
						return;
					}

					if (isIntegerType) {
						if (!UML2Util.isEmpty(input)) {
							Object newValue;
							try {
								newValue = new Integer(input);
							} catch (NumberFormatException nfe) {
								Object currentValue = descriptor.getValue();
								if (currentValue != null) {
									text.setText(currentValue.toString());
								} else {
									text.setText(""); //$NON-NLS-1$
								}
								return;
							}
							if (!newValue.equals(descriptor.getValue())) {
								descriptor.setValue(newValue);
							}
						}
						return;
					}
					if (!input.equals(descriptor.getValue())) {
						descriptor.setValue(input);
					}
				}
			}
		});

		if (descriptor.isReadOnly()) {
			text.setEditable(false);
		}
		
		if (value instanceof Integer || descriptor.isReadOnly()) {
			((GridLayout) composite.getLayout()).numColumns--;
			return widgetMap;
		}

		PropertyDefinition pd = descriptor.getPropertyDefinition();
		if (pd instanceof TextualDefinition && !descriptor.isWorkerCode()) {
			if (((TextualDefinition) pd).getNumRows() == 1) {
				((GridLayout) composite.getLayout()).numColumns--;
				return widgetMap;
			}
		}

		return widgetMap;

	}

	public static void createErrorSection(Composite parent,
			final CXPropertyDescriptor descriptor) {

		CXWidgetFactory.createLabel(parent, descriptor.getProperty().getLabel()
			+ " : ", parent.getBackground()); //$NON-NLS-1$

		Composite composite = CXWidgetFactory.createFlatGridComposite(parent,
			1, GridData.FILL_HORIZONTAL);
		composite.setBackground(parent.getBackground());

		Label label = new Label(composite, SWT.NULL);
		label.setForeground(redColor);
		label.setBackground(parent.getBackground());
		label.setLayoutData(new GridData());
		label.setText(Messages.CXWidgetFactory_InvalidPropertyMessageLabel);
	}
}
