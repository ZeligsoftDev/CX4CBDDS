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
package com.zeligsoft.domain.omg.ccm.ui.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.services.properties.extended.IPropertyAction;
import org.eclipse.gmf.runtime.common.ui.services.properties.extended.MultiButtonCellEditor;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pages.ListTableViewerPage;
import com.zeligsoft.cx.ui.properties.sections.AbstractDeploymentPropertiesCustomSection;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;

/**
 * Editing support for CCM properties dialog.
 * 
 * @author ysroh
 * 
 */
public class CCMPropertyEditingSupport extends EditingSupport {

	private CellEditor editor = null;

	private String propertyType;

	private int currentValueIndex = 0;

	private int defaultValueIndex = -1;

	/**
	 * Cell editor validator to prevent users from entering invalid format
	 */
	private ICellEditorValidator cellValidator = new ICellEditorValidator() {

		@Override
		public String isValid(Object value) {
			if (value instanceof Integer && ((Integer) value).intValue() == 1) {
				return null;
			}
			String text = ((CCombo) editor.getControl()).getText();
			if (propertyType
					.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAUNSIGNED_LONG)
					|| propertyType
							.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAUNSIGNED_LONG_LONG)
					|| propertyType
							.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAUNSIGNED_SHORT)) {

				if (!text.matches("[0-9]*")) { //$NON-NLS-1$
					return Messages.CCMPropertyEditingSupport_CellValidationError;
				}
			} else if (propertyType
					.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBADOUBLE)
					|| propertyType
							.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAFLOAT)
					|| propertyType
							.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBALONG_DOUBLE)) {

				if (!text.matches("-? *[0-9]*\\.?[0-9]*")) { //$NON-NLS-1$
					return Messages.CCMPropertyEditingSupport_CellValidationError;
				}
			} else if (propertyType
					.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBALONG)
					|| propertyType
							.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBALONG_LONG)
					|| propertyType
							.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBASHORT)) {

				if (!text.matches("-? *[0-9]*")) { //$NON-NLS-1$
					return Messages.CCMPropertyEditingSupport_CellValidationError;
				}
			}
			return null;
		}
	};

	public CCMPropertyEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected boolean canEdit(Object element) {
		EObject modelObject = ((IPropertyEntry) element).getModelObject();
		if (modelObject instanceof ValueSpecification) {
			StructuralFeature feature = ((Slot) modelObject.eContainer())
					.getDefiningFeature();
			if (feature.getType() != null
					&& !ZDLUtil.isZDLConcept(feature.getType(),
							CORBADomainNames.CORBASTRUCT)) {
				return true;
			}
			return false;
		}
		if (!(modelObject instanceof Property)) {
			return false;
		}
		EObject type = ((Property) modelObject).getType();

		if (type == null) {
			return false;
		}

		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBATYPE_DEF)) {
			type = CORBAUtil.getTypeDefType(type);
		}

		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAPRIMITIVE)
				|| ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAENUM)) {
			return true;
		}
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASTRUCT)) {
			return false;
		}
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASEQUENCE)
				|| ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAARRAY)) {
			DataType sequence = (DataType) type;
			Property attr = CCMUtil.getMembersAttribute(sequence);
			if (attr == null) {
				return false;
			}
			return attr.getType() != null;
		}
		return ZDLUtil.isZDLConcept(modelObject,
				CORBADomainNames.CORBAATTRIBUTE)
				|| ZDLUtil.isZDLConcept(modelObject,
						CORBADomainNames.CORBAFIELD)
				|| ZDLUtil.isZDLConcept(modelObject,
						CCMNames.SATISFIER_PROPERTY)
				|| ZDLUtil.isZDLConcept(modelObject, CCMNames.PROPERTY);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		propertyType = CORBADomainNames.CORBASTRING;

		EObject modelObject = ((IPropertyEntry) element).getModelObject();
		EObject type;
		if (modelObject instanceof ValueSpecification) {
			StructuralFeature feature = ((Slot) ((IPropertyEntry) element)
					.getModelObject().eContainer()).getDefiningFeature();
			type = feature.getType();
		} else {
			type = ((Property) modelObject).getType();
		}

		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBATYPE_DEF)) {
			type = CORBAUtil.getTypeDefType(type);
		}

		// return editor for sequence type
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASEQUENCE)) {
			propertyType = CORBADomainNames.CORBASEQUENCE;
			return getCellEditorForSequence((IPropertyEntry) element,
					(DataType) type);

		}

		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAARRAY)) {
			propertyType = CORBADomainNames.CORBAARRAY;
			return getCellEditorForArray((IPropertyEntry) element,
					(DataType) type);

		}

		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAENUM)) {
			propertyType = CORBADomainNames.CORBAENUM;
			return getCellEditorForEnumeration((IPropertyEntry) element,
					(Enumeration) type);

		}

		// Return editor for boolean type
		if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAPRIMITIVE)) {
			EnumerationLiteral primitiveType = (EnumerationLiteral) ZDLUtil
					.getValue(type, CORBADomainNames.CORBAPRIMITIVE,
							CORBADomainNames.CORBAPRIMITIVE__TYPE);
			propertyType = primitiveType.getName();
			if (propertyType
					.equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBABOOLEAN)) {
				return getCellEditorForBoolean((IPropertyEntry) element);
			}
		}

		// return text cell editor for all other type
		String[] items = new String[2];
		items[0] = ((IPropertyEntry) element).getValue();
		items[1] = UML2Util.EMPTY_STRING;
		IPropertyEntry rootEntry = ((IPropertyEntry) element).getRootEntry();
		if (rootEntry.getModelObject() instanceof Property
				&& rootEntry != element
				&& !((IPropertyEntry) element).isMultiValue()) {
			items[1] = ((IPropertyEntry) element).getDefaultValue()
					+ Messages.CCMPropertyEditingSupport_defaultValueLabel;
		}
		editor = new ComboBoxCellEditor((Composite) getViewer().getControl(),
				items);
		editor.setValidator(cellValidator);
		return editor;

	}

	private CellEditor getCellEditorForEnumeration(IPropertyEntry element,
			Enumeration enumeration) {

		String[] items = new String[enumeration.getOwnedLiterals().size() + 1];
		String value = (String) element.getValue();
		currentValueIndex = 0;
		int index = 0;
		for (EnumerationLiteral literal : enumeration.getOwnedLiterals()) {
			if (element.getDefaultValue() != null
					&& literal.getName().equals(element.getDefaultValue())) {
				defaultValueIndex = index;
				items[index] = literal.getName()
						+ Messages.CCMPropertyEditingSupport_defaultValueLabel;
			} else {
				items[index] = literal.getName();
			}
			if (literal.getName().equals(value)) {
				currentValueIndex = index;
			}
			index++;
		}
		items[index] = UML2Util.EMPTY_STRING;

		editor = new ComboBoxCellEditor((Composite) getViewer().getControl(),
				items, SWT.READ_ONLY);
		return editor;
	}

	private CellEditor getCellEditorForBoolean(IPropertyEntry element) {
		// text cell editor for the primitive data type
		currentValueIndex = 0;
		String[] items = new String[3];
		if (element.getDefaultValue() != null
				&& element.getDefaultValue().length() != 0) {
			if (Boolean.toString(true).equals(element.getDefaultValue())) {
				items[0] = Boolean.toString(true)
						+ Messages.CCMPropertyEditingSupport_defaultValueLabel;
				items[1] = Boolean.toString(false);
				defaultValueIndex = 0;
			} else if (Boolean.toString(false)
					.equals(element.getDefaultValue())) {
				items[0] = Boolean.toString(true);
				items[1] = Boolean.toString(false)
						+ Messages.CCMPropertyEditingSupport_defaultValueLabel;
				defaultValueIndex = 1;
			}
		} else {
			items[0] = Boolean.toString(true);
			items[1] = Boolean.toString(false);
			items[2] = UML2Util.EMPTY_STRING;

		}
		Object value = ((IPropertyEntry) element).getValue();
		if (value != null && ((String) value).length() != 0) {
			if (Boolean.toString(false).equals(value)) {
				currentValueIndex = 1;
			}
		}
		editor = new ComboBoxCellEditor((Tree) getViewer().getControl(), items,
				SWT.READ_ONLY);
		return editor;
	}

	private CellEditor getCellEditorForArray(final IPropertyEntry element,
			DataType sequence) {

		return new MultiButtonCellEditor((Tree) getViewer().getControl(),
				SWT.NONE) {

			private CCMPropertyEntry entry = (CCMPropertyEntry) element;

			@Override
			protected void initButtons() {
				addButton("o", new IPropertyAction() { //$NON-NLS-1$

							@Override
							public Object execute(Control owner) {
								entry.addSequenceMemberInstance();
								refreshTreeViewer(element);
								return null;
							}
						});

				addButton("x", new IPropertyAction() { //$NON-NLS-1$

							@Override
							public Object execute(Control owner) {
								entry.removeSequenceMemberInstance();
								refreshTreeViewer(element);
								return null;
							}
						});

				addButton("...", new IPropertyAction() { //$NON-NLS-1$

							@Override
							public Object execute(Control owner) {
								PreferenceDialog dialog = new PreferenceDialog(
										Display.getCurrent().getActiveShell(),
										new PreferenceManager()) {
									@Override
									protected Control createDialogArea(
											Composite parent) {
										Control control = super
												.createDialogArea(parent);
										getShell()
												.setText(
														Messages.CCMPropertiesDialog_Title);
										return control;
									}
								};
								Slot slot = entry.getSequenceMemberSlot();

								ListTableViewerPage page = new ListTableViewerPage(
										slot == null ? Collections.EMPTY_LIST
												: slot.getValues(),
										((Property) entry.getModelObject())
												.getType().getName(),
										new SequenceValueLabelProvider());
								dialog.getPreferenceManager().addToRoot(
										new PreferenceNode(StringStatics.BLANK,
												page));
								dialog.open();
								if (dialog.getReturnCode() == Window.OK) {
									refreshTreeViewer(element);
									return UML2Util.EMPTY_STRING;
								}
								return null;
							}
						});
			}
		};
	}

	private CellEditor getCellEditorForSequence(final IPropertyEntry element,
			DataType sequence) {

		return new MultiButtonCellEditor((Tree) getViewer().getControl(),
				SWT.NONE) {

			private CCMPropertyEntry entry = (CCMPropertyEntry) element;

			@Override
			protected void initButtons() {
				addButton("+", new IPropertyAction() { //$NON-NLS-1$

							@Override
							public Object execute(Control owner) {
								entry.addSequenceMemberInstance();
								refreshTreeViewer(element);
								return null;
							}
						});

				addButton("-", new IPropertyAction() { //$NON-NLS-1$

							@Override
							public Object execute(Control owner) {
								entry.removeSequenceMemberInstance();
								refreshTreeViewer(element);
								return null;
							}
						});

				addButton("...", new IPropertyAction() { //$NON-NLS-1$

							@Override
							public Object execute(Control owner) {
								PreferenceDialog dialog = new PreferenceDialog(
										Display.getCurrent().getActiveShell(),
										new PreferenceManager()) {
									@Override
									protected Control createDialogArea(
											Composite parent) {
										Control control = super
												.createDialogArea(parent);
										getShell()
												.setText(
														Messages.CCMPropertiesDialog_Title);
										return control;
									}
								};
								Slot slot = entry.getSequenceMemberSlot();

								ListTableViewerPage page = new ListTableViewerPage(
										slot == null ? Collections.EMPTY_LIST
												: slot.getValues(),
										((Property) entry.getModelObject())
												.getType().getName(),
										new SequenceValueLabelProvider());
								dialog.getPreferenceManager().addToRoot(
										new PreferenceNode(StringStatics.BLANK,
												page));
								dialog.open();
								if (dialog.getReturnCode() == Window.OK) {
									refreshTreeViewer(element);
									return UML2Util.EMPTY_STRING;
								}
								return null;
							}
						});
			}
		};
	}

	private void refreshTreeViewer(Object element) {
		List<IPropertyEntry> entries = new ArrayList<IPropertyEntry>();
		entries.add(((IPropertyEntry) element)
				.createNewEntry(((IPropertyEntry) element).getRootEntry()
						.getModelObject()));
		getViewer().setInput(entries);
		getViewer().refresh();
		((TreeViewer) getViewer())
				.expandToLevel(AbstractDeploymentPropertiesCustomSection.EXPAND_LEVEL);
	}

	/**
	 * Sequence value list label provider
	 * 
	 * @author ysroh
	 * 
	 */
	private class SequenceValueLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			StructuralFeature feature = ((Slot) ((EObject) element)
					.eContainer()).getDefiningFeature();
			return feature.getType() == null ? null : BaseUIUtil
					.getIcon(feature.getType());
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			StructuralFeature feature = ((Slot) ((EObject) element)
					.eContainer()).getDefiningFeature();
			return feature.getType() == null ? UML2Util.EMPTY_STRING : feature
					.getType().getName();
		}
	}

	@Override
	protected Object getValue(Object element) {
		if (((IPropertyEntry) element).isMultiValue()) {
			return ((IPropertyEntry) element).getPropertyColumnLabel(1);
		}
		return currentValueIndex;
	}

	@Override
	protected void setValue(Object element, Object value) {
		IPropertyEntry entry = (IPropertyEntry) element;
		if (CORBADomainNames.CORBAPRIMITIVE_KIND___CORBABOOLEAN
				.equals(propertyType)
				|| CORBADomainNames.CORBAENUM.equals(propertyType)) {
			String itemValue = ((ComboBoxCellEditor) editor).getItems()[(Integer) value];
			if (((Integer) value).equals(defaultValueIndex)) {
				itemValue = entry.getDefaultValue();
			}
			entry.setValue(itemValue);
		} else if (entry.isMultiValue()) {
			// do nothing
		} else {
			if (value == null) {
				return;
			}
			// set value for string type
			if ((Integer) value == 1) {
				entry.setValue(entry.getDefaultValue());
			} else {
				if (!editor.getControl().isDisposed()) {
					entry.setValue(((CCombo) editor.getControl()).getText());
				}
			}
		}
		getViewer().update(element, null);
	}
}
