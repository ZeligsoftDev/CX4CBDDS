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
package com.zeligsoft.domain.idl3plus.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Template instantiation dialog
 * 
 * @author ysroh
 * 
 */
public class InstantiateTemplateModuleDialog extends ZDLElementSelectionDialog {

	protected TableViewer tableViewer;

	private List<Object> instantiationList = new ArrayList<Object>();

	private EObject context;

	public InstantiateTemplateModuleDialog(Shell shell, EObject context) {
		super(shell, Messages.InstantiateTemplateModuleDialog_DialogTitle, context,
				Collections.singletonList(IDL3PlusNames.TEMPLATE_MODULE), true);
		this.context = context;
	}

	/**
	 * Queries the instantiation map
	 * 
	 * @return
	 */
	public Map<ClassifierTemplateParameter, EObject> getInstantiationMap() {
		Map<ClassifierTemplateParameter, EObject> map = new HashMap<ClassifierTemplateParameter, EObject>();
		for (Object o : instantiationList) {
			TemplateInstantiationDescriptor descriptor = (TemplateInstantiationDescriptor) o;
			if (descriptor.getSelectedInstantiableObject() == null) {
				continue;
			}
			map
					.put(descriptor.getParameter(), descriptor
							.getSelectedInstantiableObject());
		}
		return map;
	}

	@Override
	protected void createAdditions(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.marginWidth = 0;
		compositeLayout.marginHeight = 0;
		compositeLayout.verticalSpacing = 0;
		compositeLayout.horizontalSpacing = 0;
		GridData compositeLData = new GridData(GridData.FILL_BOTH);
		compositeLData.grabExcessHorizontalSpace = true;
		compositeLData.grabExcessVerticalSpace = true;
		compositeLData.heightHint = 180;
		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);

		createTreeArea(composite);

		getTableViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				EObject templateModule = (EObject) getSelectedElements()
						.getFirstElement();
				tableViewer.setInput(templateModule);
				tableViewer.refresh();
			}
		});
	}

	/**
	 * Create a tree area
	 * 
	 * @param parent
	 */
	private void createTreeArea(Composite parent) {

		GridData treeViewerData = new GridData(GridData.FILL_BOTH);
		tableViewer = new TableViewer(parent, SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tableViewer.getControl().setLayoutData(treeViewerData);

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NULL, 0);
		viewerColumn.getColumn().setText(
				Messages.InstantiateTemplateModuleDialog_ParameterColumnLabel);
		viewerColumn.getColumn().setWidth(200);
		viewerColumn = new TableViewerColumn(tableViewer, SWT.NULL, 1);
		viewerColumn.getColumn().setText(
				Messages.InstantiateTemplateModuleDialog_NameColumnLabel);
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.setEditingSupport(new TemplateInitiationEditingSupport(tableViewer));

		tableViewer.setContentProvider(new TemplateModuleContentProvider());
		tableViewer.setLabelProvider(new TemplateParameterLabelProvider());

		tableViewer.setInput(new Object());

	}

	/**
	 * Template instantiation dialog editing support
	 * 
	 * @author ysroh
	 * 
	 */
	private class TemplateInitiationEditingSupport extends EditingSupport {

		private CellEditor editor = null;

		public TemplateInitiationEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected boolean canEdit(Object element) {
			return element instanceof TemplateInstantiationDescriptor;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {

			if (element instanceof TemplateInstantiationDescriptor) {
				final TemplateInstantiationDescriptor descriptor = (TemplateInstantiationDescriptor) element;
				editor = new DialogCellEditor((Table) getViewer().getControl(), SWT.NONE) {

					@Override
					protected Object openDialogBox(Control cellEditorWindow) {
						ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(
								getShell(),
								Messages.InstantiateTemplateModuleDialog_ParameterTypeSelectionDialogTitle,
								context, new ArrayList<String>(), true);
						dialog.setElementFilter(new IFilter() {

							private EnumerationLiteral object = (EnumerationLiteral) ZDLUtil
							.getValue(descriptor.getParameter(),
									IDL3PlusNames.TYPE_PARAMETER,
									IDL3PlusNames.TYPE_PARAMETER__CONSTRAINT);
							
							//Select only elements that is of type matching the constraint of the parameter
							@Override
							public boolean select(Object toTest) {
								EObject eObject = null;
								if (toTest instanceof EObject) {
									eObject = (EObject) toTest;
								} else if (toTest instanceof IAdaptable) {
									eObject = (EObject) ((IAdaptable) toTest)
											.getAdapter(EObject.class);
								} else if (toTest instanceof StructuredSelection) {
									eObject = BaseUIUtil
											.getEObjectFromSelection((StructuredSelection) toTest);
								}

								if (eObject == null
										|| !(eObject instanceof NamedElement)) {
									return false;
								}

								String constraint = (String) object.getLabel();
								if (constraint.equals("array")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBAARRAY)) {
										return true;
									}
								} else if (constraint.equals("enum")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBAENUM)) {
										return true;
									}
								} else if (constraint.equals("eventtype")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject, CCMNames.EVENT)) {
										return true;
									}
								} else if (constraint.equals("interface")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBAINTERFACE)) {
										return true;
									}
								} else if (constraint.equals("sequence")) { //$NON-NLS-1$
									if (eObject.eContainer() != null
											&& ZDLUtil.isZDLConcept(
													eObject.eContainer(),
													IDL3PlusNames.TYPE_PARAMETER)) {
										EnumerationLiteral constraintEnum = (EnumerationLiteral) ZDLUtil.getValue(
												eObject.eContainer(),
												IDL3PlusNames.TYPE_PARAMETER,
												IDL3PlusNames.TYPE_PARAMETER__CONSTRAINT);
										if (constraintEnum.getLabel().equals(
												"sequence")) { //$NON-NLS-1$
											return true;
										}
										return false;
									}
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBASEQUENCE)) {
										return true;
									}
								} else if (constraint.equals("struct")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBASTRUCT)) {
										return true;
									}

								} else if (constraint.equals("union")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBAUNION)) {
										return true;
									}
								} else if (constraint.equals("typename")) { //$NON-NLS-1$
									if (ZDLUtil.isZDLConcept(eObject,
											CORBADomainNames.CORBATYPE)) {
										return true;
									}
								}
								return false;
							}
						});
						int result = dialog.open();
						if (result == Window.OK) {
							if (!dialog.getSelectedElements().isEmpty()) {
								return (EObject) dialog.getSelectedElements()
										.getFirstElement();
							}
						}

						return null;
					}
				};
			}

			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			if (element instanceof TemplateInstantiationDescriptor) {
				TemplateInstantiationDescriptor descriptor = (TemplateInstantiationDescriptor) element;
				return descriptor.getSelectionLabel();
			}
			return UML2Util.EMPTY_STRING;
		}

		@Override
		protected void setValue(Object element, Object value) {

			if (value == null || value instanceof String) {
				return;
			}
			if (element instanceof TemplateInstantiationDescriptor) {
				TemplateInstantiationDescriptor descriptor = (TemplateInstantiationDescriptor) element;
				descriptor.setSelection((EObject) value);
				getViewer().refresh();
			}
		}
	}

	/**
	 * Content provider
	 * 
	 * @author ysroh
	 * 
	 */
	private class TemplateModuleContentProvider implements ITreeContentProvider {

		private EObject currentModuleSelection = null;

		@Override
		public Object[] getChildren(Object parentElement) {
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof EObject) {
				if (ZDLUtil.isZDLConcept((EObject) inputElement,
						IDL3PlusNames.TEMPLATE_MODULE)) {

					if (!(currentModuleSelection == (EObject) inputElement)) {
						instantiationList.clear();
						List<EObject> list = IDL3PlusUtil.INSTANCE
								.getTemplateParameters((EObject) inputElement);

						for (EObject eo : list) {
							instantiationList.add(new TemplateInstantiationDescriptor(
									(ClassifierTemplateParameter) eo));
						}
					}
					currentModuleSelection = (EObject) inputElement;
					return instantiationList.toArray();
				}
			}
			return Collections.EMPTY_LIST.toArray();
		}

		@Override
		public void dispose() {

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Label provider
	 * 
	 * @author ysroh
	 * 
	 */
	private class TemplateParameterLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof TemplateInstantiationDescriptor) {
				TemplateInstantiationDescriptor descriptor = (TemplateInstantiationDescriptor) element;
				if (columnIndex == 0) {
					if (descriptor.getParameter() != null) {
						return BaseUIUtil.getIcon(descriptor.getParameter());
					}
				} else {
					if (descriptor.getSelection() != null) {
						return BaseUIUtil.getIcon(descriptor.getSelection());
					}
				}
			}
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof TemplateInstantiationDescriptor) {
				TemplateInstantiationDescriptor descriptor = (TemplateInstantiationDescriptor) element;
				if (columnIndex == 0) {
					return descriptor.getParameterLabel();
				} else if (columnIndex == 1) {
					return descriptor.getSelectionLabel();
				}
			}
			return UMLUtil.EMPTY_STRING;
		}

	}

	/**
	 * Template instantiation descriptor
	 * 
	 * @author ysroh
	 * 
	 */
	private class TemplateInstantiationDescriptor {

		private ClassifierTemplateParameter parameter;

		private EObject selection = null;

		public TemplateInstantiationDescriptor(ClassifierTemplateParameter parameter) {
			this.parameter = parameter;
		}

		public void setSelection(EObject object) {
			selection = object;
		}

		public EObject getSelection() {
			return selection;
		}

		public EObject getSelectedInstantiableObject() {
			return getSelection();
		}

		public String getSelectionLabel() {
			if (selection != null) {
				return EMFCoreUtil.getName(selection) + " - " //$NON-NLS-1$
						+ EMFCoreUtil.getQualifiedName(selection, true);
			}
			return UML2Util.EMPTY_STRING;
		}

		public String getParameterLabel() {
			EObject eo = parameter.getOwnedParameteredElement();
			if (eo != null) {
				return EMFCoreUtil.getName(eo);
			}
			return UMLUtil.EMPTY_STRING;
		}

		public ClassifierTemplateParameter getParameter() {
			return parameter;
		}
	}
}
