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

package com.zeligsoft.domain.omg.corba.ui.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.sections.ICXCustomPropertySection;
import com.zeligsoft.cx.ui.properties.utils.CXPropertiesWidgetFactory;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.ui.Activator;
import com.zeligsoft.domain.omg.corba.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Custom property section provider for CORBADomain
 * 
 * @author ysroh
 * 
 */
public class CORBACustomPropertySection implements ICXCustomPropertySection {

	private static final String CORBA_OPERATION_TYPE_LABEL = "Return Type"; //$NON-NLS-1$

	@Override
	public Map<String, Control> createSection(Composite parent,
			CXPropertyDescriptor descriptor, Property property) {

		if (property.getName().equals(
				CORBADomainNames.CORBAPARAMETER__DIRECTION)) {
			return createSectionForDirection(parent, descriptor, property);
		}

		if (property.getName().equals(CORBADomainNames.CORBATYPED__IDL_TYPE)) {
			return CXPropertiesWidgetFactory.createSectionForReferenceType(
					parent, descriptor, CORBA_OPERATION_TYPE_LABEL);
		}

		if (ZDLUtil.isZDLConcept(descriptor.getContext(),
				CORBADomainNames.CORBACONSTANT)
				&& property.getName().equals(
						CORBADomainNames.CORBACONSTANT__DEFAULT)) {
			return createSectionForConstantDefault(parent, descriptor);
		}

		if (property.getName().equals(ZMLMMNames.NAMED_ELEMENT__NAME)) {

			Map<String, Control> map = new HashMap<String, Control>();
			createTypeSectionForMember(parent, descriptor, map);

			return map;
		}
		return new HashMap<String, Control>();
	}

	private Map<String, Control> createSectionForConstantDefault(
			Composite parent, final CXPropertyDescriptor descriptor) {
		EObject type = ZDLUtil.getEValue(descriptor.getContext(),
				CORBADomainNames.CORBACONSTANT,
				CORBADomainNames.CORBATYPED__IDL_TYPE);

		if (type != null
				&& ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBATYPE_DEF)) {
			type = ZDLUtil.getEValue(type, CORBADomainNames.CORBATYPE_DEF,
					CORBADomainNames.CORBATYPE_DEF__TYPE);
		}
		if (type == null
				|| !ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAENUM)) {
			return CXPropertiesWidgetFactory.createSectionForStringType(parent,
					descriptor);
		}

		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(
				CXPropertiesWidgetFactory.PROPERTY_LABEL,
				CXWidgetFactory.createLabel(parent, descriptor.getProperty()
						.getLabel() + " : ", parent.getBackground())); //$NON-NLS-1$

		final Enumeration ownedEnum = (Enumeration) type;
		EList<EnumerationLiteral> literals = ownedEnum.getOwnedLiterals();

		String value = (String) descriptor.getValue();

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
			if (comboItems[index].equals(value)) {
				selectedIndex = index;
			}
			index++;
		}

		final Combo combo = new Combo(composite, SWT.SINGLE | SWT.READ_ONLY);
		combo.setItems(comboItems);
		combo.select(selectedIndex);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_BEGINNING));
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (combo.getSelectionIndex() != -1) {
					descriptor.setValue(comboItems[combo.getSelectionIndex()]);
				}
			}
		});

		if (descriptor.isReadOnly()) {
			combo.setEnabled(false);
		}

		return null;
	}

	public static void createTypeSectionForMember(Composite parent,
			CXPropertyDescriptor descriptor, Map<String, Control> map) {
		// Check to see if the property is the "members" attribute that we
		// need to add type selection dialog to. If there is no domain
		// concept on the property then it should have ZML NamedElement
		// concept.
		Class concept = ZDLUtil.getZDLConcept(descriptor.getContext());
		if (ZMLMMNames.NAMED_ELEMENT.equals(concept.getQualifiedName())
				&& descriptor.getContext() instanceof Property
				&& (((NamedElement) descriptor.getContext()).getName()
						.equals(CORBADomainNames.CORBASTRUCT__MEMBERS)
						|| ((NamedElement) descriptor.getContext())
								.getName().equals("member") || ((NamedElement) descriptor //$NON-NLS-1$
						.getContext()).getName().equals("switchType"))) { //$NON-NLS-1$
			map.putAll(createSectionForMembersType(parent,
					(Property) descriptor.getContext()));
		}
	}

	private static Map<String, Control> createSectionForMembersType(Composite parent,
			final Property property) {
		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap
				.put(CXPropertiesWidgetFactory.PROPERTY_LABEL,
						CXWidgetFactory.createLabel(
								parent,
								Messages.getString("CORBACustomPropertySection.TypeLabel"), parent.getBackground())); //$NON-NLS-1$

		final Composite composite = CXWidgetFactory.createFlatGridComposite(
				parent, 3, GridData.HORIZONTAL_ALIGN_BEGINNING);
		composite.setBackground(parent.getBackground());

		final Label imageLabel = new Label(composite, SWT.ICON);
		imageLabel.setLayoutData(new GridData());
		imageLabel.setBackground(parent.getBackground());
		final Label textLabel = new Label(composite, SWT.NULL);
		textLabel.setLayoutData(new GridData());
		textLabel.setBackground(parent.getBackground());

		widgetMap
				.put(CXPropertiesWidgetFactory.PROPERTY_VALUE_ICON, imageLabel);
		widgetMap.put(CXPropertiesWidgetFactory.PROPERTY_VALUE, textLabel);

		final org.eclipse.jface.dialogs.Dialog dialog;

		final Object value = property.getType();

		ZDLElementSelectionDialog selectionDialog;
		selectionDialog = new ZDLElementSelectionDialog(Display.getCurrent()
				.getActiveShell(), property,
				Collections.singletonList(CORBADomainNames.CORBATYPE), true,
				true);

		dialog = selectionDialog;

		if (value != null) {
			if (value instanceof EObject) {

				Image icon = BaseUIUtil.getIcon((EObject) value);
				if (icon != null) {
					imageLabel.setImage(icon);
				}
				textLabel.setText((char) 171 + property.getType().getLabel()
						+ (char) 187
						+ EMFCoreUtil.getQualifiedName((EObject) value, true));
			} else {
				return widgetMap;
			}
		} else {
			textLabel.setText(Messages
					.getString("CORBACustomPropertySection_NullString")); //$NON-NLS-1$
		}

		Composite buttonComposite = CXWidgetFactory
				.createNoMarginGridComposite(composite, 2,
						GridData.HORIZONTAL_ALIGN_BEGINNING);
		buttonComposite.setBackground(composite.getBackground());

		if (value != null) {
			((GridLayout) buttonComposite.getLayout()).numColumns++;
			final ToolBar deleteToolBar = CXWidgetFactory.createToolbarButton(
					buttonComposite, CXWidgetFactory.DELETE_OBJECT_IMAGE);
			deleteToolBar.getItem(0).addSelectionListener(
					new SelectionAdapter() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							setPropertyType(property, null);
						}
					});
			widgetMap.put(CXPropertiesWidgetFactory.PROPERTY_DELETE_BUTTON,
					deleteToolBar);

		}

		final ToolBar addToolBar = CXWidgetFactory.createToolbarButton(
				buttonComposite, CXWidgetFactory.EDIT_OBJECT_IMAGE);
		addToolBar.getItem(0).addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int result = dialog.open();
				if (result == org.eclipse.jface.window.Window.OK) {
					if (dialog instanceof ZDLElementSelectionDialog) {
						if (!((ZDLElementSelectionDialog) dialog)
								.getSelectedElements().isEmpty()) {
							EObject selectedElement = (EObject) ((ZDLElementSelectionDialog) dialog)
									.getSelectedElements().iterator().next();
							if (selectedElement != null) {
								setPropertyType(property,
										(Type) selectedElement);
							}
						}
					}
				}
			}
		});
		widgetMap.put(CXPropertiesWidgetFactory.PROPERTY_EDIT_BUTTON,
				addToolBar);

		// If the property is reference type, then add button to view its
		// properties view
		final EObject object = property.getType();

		final ToolBar viewToolBar = CXWidgetFactory.createToolbarButton(
				buttonComposite, CXWidgetFactory.FORWARD_NAV_IMAGE);
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

		return widgetMap;

	}

	/**
	 * Create property section for parameter dirction
	 * 
	 * @param parent
	 * @param descriptor
	 * @param property
	 * @return
	 */
	private static Map<String, Control> createSectionForDirection(Composite parent,
			final CXPropertyDescriptor descriptor, Property property) {

		Map<String, Control> widgetMap = new HashMap<String, Control>();

		widgetMap.put(
				CXPropertiesWidgetFactory.PROPERTY_LABEL,
				CXWidgetFactory.createLabel(parent, descriptor.getProperty()
						.getLabel() + " : ", parent.getBackground())); //$NON-NLS-1$

		final Composite sectionComposite = CXWidgetFactory
				.createFlatGridComposite(parent, 2,
						GridData.HORIZONTAL_ALIGN_BEGINNING);
		sectionComposite.setBackground(parent.getBackground());

		ParameterDirectionKind direction = ((Parameter) descriptor.getContext())
				.getDirection();
		ParameterDirectionKind[] values = ParameterDirectionKind.values();

		Composite composite = CXWidgetFactory.createFlatGridComposite(
				sectionComposite, values.length, GridData.FILL_HORIZONTAL);
		composite.setBackground(sectionComposite.getBackground());

		final List<Button> buttons = new ArrayList<Button>();
		for (ParameterDirectionKind kind : values) {
			if(kind.equals(ParameterDirectionKind.RETURN_LITERAL)){
				// ignore return direction since return direction is not allowed
				// for CORBAParameter
				continue;
			}
			final Button button = CXWidgetFactory.createRadioButton(composite,
					kind.getName(), new GridData());
			button.setBackground(parent.getBackground());
			buttons.add(button);
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					button.setSelection(true);

					for (Button b : buttons) {
						if (b != button && b.getSelection()) {
							b.setSelection(false);
						}
					}

					if (button.getSelection()) {

						AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
								TransactionUtil.getEditingDomain(descriptor
										.getContext()),
								"Set Parameter Direction", //$NON-NLS-1$
								Collections.EMPTY_MAP, null) {

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor arg0, IAdaptable arg1)
									throws ExecutionException {

								((Parameter) descriptor.getContext())
										.setDirection(ParameterDirectionKind
												.get(button.getText()));
								return CommandResult.newOKCommandResult();
							}

						};
						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(editCommand, null, null);
						} catch (ExecutionException ex) {
							com.zeligsoft.domain.omg.corba.ui.Activator
									.getDefault()
									.error("Set parameter direction failed", ex); //$NON-NLS-1$
							return;
						}

					}
				}
			});

			if (direction.getLiteral().equals(kind.getLiteral())) {
				button.setSelection(true);
			}
		}
		if (descriptor.isReadOnly()) {
			for (Button b : buttons) {
				b.setEnabled(false);
			}
		}
		return widgetMap;
	}

	private static void setPropertyType(final Property property, final Type type) {

		ICommand command = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(property), "Set Type", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				property.setType(type);
				return null;
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error("Failed to set type", e); //$NON-NLS-1$
		}
	}
}
