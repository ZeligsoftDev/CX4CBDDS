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
package com.zeligsoft.cx.ui.properties.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.dialogs.PropertiesDialog;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.filters.ElementSelectionFilter;
import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;
import com.zeligsoft.cx.ui.properties.l10n.Messages;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Property collection page for multiple value properties
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CXPropertyCollectionPage extends PreferencePage {

	private CXPropertyDescriptor descriptor;

	private TableViewer viewer;

	private Composite composite;

	private Button modifyButton;

	private Button removeButton;

	private Button upButton;

	private Button downButton;

	private List list;

	/**
	 * Constructor
	 * 
	 * @param propertyDescriptor
	 */
	public CXPropertyCollectionPage(CXPropertyDescriptor propertyDescriptor) {
		super(propertyDescriptor.getProperty().getLabel());
		this.descriptor = propertyDescriptor;
	}

	@Override
	protected Control createContents(Composite parent) {

		noDefaultAndApplyButton();

		composite = CXWidgetFactory.createGridComposite(parent, 2,
				GridData.FILL_BOTH);

		createTableViewer(composite);

		createButtonArea(composite);

		return composite;
	}

	/**
	 * Creates properties dialog
	 * 
	 * @param descriptor
	 * @return
	 */
	private PropertiesDialog createPropertiesDialog(
			CXPropertyDescriptor descriptor) {
		PropertiesDialog creationDialog = new PropertiesDialog(getShell(),
				new PreferenceManager());
		CXElementCreationPage page = new CXElementCreationPage(descriptor);
		creationDialog.getPreferenceManager().addToRoot(
				new PreferenceNode(StringStatics.BLANK, page));
		return creationDialog;
	}

	/**
	 * Creates button area
	 * 
	 * @param parent
	 */
	private void createButtonArea(Composite parent) {
		Composite composite = CXWidgetFactory.createGridComposite(parent, 1,
				GridData.VERTICAL_ALIGN_BEGINNING);

		GridData data = new GridData();

		final Button addButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.ADD_OBJECT_IMAGE);
		addButton
				.setToolTipText(Messages.CXPropertyCollectionPage_AddButtonTooltip
						+ descriptor.getProperty().getLabel());
		addButton.setLayoutData(data);
		addButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Property property = descriptor.getProperty();
				if (!property.isMultivalued()) {
					return;
				}
				if (descriptor.getProperty().isComposite()) {

					Class concept = (Class) descriptor.getProperty().getType();
					Object o = descriptor.createConcept(concept);
					if (o instanceof EObject) {
						CXPropertyDescriptor newDescriptor = new CXPropertyDescriptor(
								(EObject) o, concept, null, null);
						PropertiesDialog creationDialog = createPropertiesDialog(newDescriptor);
						creationDialog.open();
					} else {
						addButton.setEnabled(false);
					}
					viewer.refresh();
					return;
				}

				if (property.getType() instanceof PrimitiveType) {
					String type = property.getType().getName();

					if (type.equals(UMLPackage.Literals.INTEGER.getName())) {
						descriptor.addValue(new Integer(0));
					} else if (type.equals(UMLPackage.Literals.STRING.getName())) {
						descriptor.addValue(""); //$NON-NLS-1$
					}

				} else if (property.getType() instanceof Enumeration) {
					List<EnumerationLiteral> literals = ((Enumeration) property
							.getType()).getOwnedLiterals();
					List values = (List) descriptor.getValue();
					ArrayList<String> valueStrings = new ArrayList<String>();
					for (Iterator it = values.iterator(); it.hasNext();) {
						Object value = it.next();
						if (value instanceof InstanceSpecification) {
							valueStrings.add(((InstanceSpecification) value)
									.getName());
						}
					}
					Iterator<EnumerationLiteral> it = literals.iterator();
					while (it.hasNext()) {
						EnumerationLiteral literal = it.next();

						if (!valueStrings.contains(literal.getName())) {
							descriptor.addValue(literal);
							break;
						}
					}

				} else {
					final ZDLElementSelectionDialog selectionDialog = new ZDLElementSelectionDialog(
							getShell(),
							Messages.CXWidgetFactory_ElementSelectionDialogTitle,
							descriptor.getContext(), Collections.EMPTY_LIST,
							true, true);
					selectionDialog
							.setElementFilter(new ElementSelectionFilter(
									descriptor.getConcept().getQualifiedName(),
									descriptor.getProperty().getName()));

					int result = selectionDialog.open();
					if (result == Window.OK) {
						if (!selectionDialog.getSelectedElements().isEmpty()) {
							EObject selectedElement = (EObject) selectionDialog
									.getSelectedElements().getFirstElement();
							if (selectedElement != null) {
								descriptor.addValue(selectedElement);
							}
						}
					}
				}
				viewer.refresh();
			}
		});

		removeButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.DELETE_OBJECT_IMAGE);
		removeButton
				.setToolTipText(Messages.CXPropertyCollectionPage_RemoveButtonTooltip);
		removeButton.setLayoutData(data);
		removeButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {
						Object object = selection.getFirstElement();
						descriptor.removeValue(object);
						viewer.refresh();
					}
				}
			}
		});

		if (descriptor.getProperty().isReadOnly()) {
			addButton.setEnabled(false);
		}
		removeButton.setEnabled(false);

		if (descriptor.getProperty().isComposite()) {
			modifyButton = CXWidgetFactory.createImageButton(composite,
					CXWidgetFactory.EDIT_OBJECT_IMAGE);
			modifyButton
					.setToolTipText(Messages.CXPropertyCollectionPage_EditButtonTooltip);
			modifyButton.setLayoutData(data);
			modifyButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					doModify();
				}
			});
			modifyButton.setEnabled(false);
		}

		upButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.UP_NAV_IMAGE);
		upButton.setLayoutData(data);
		upButton.setEnabled(false);
		upButton.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					final StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {
						final int index = list.indexOf(selection
								.getFirstElement());
						ICommand command = new AbstractTransactionalCommand(
								TransactionUtil.getEditingDomain(descriptor.getProperty()),
								Messages.CXPropertyCollectionPage_MoveUpCmdLabel,
								Collections.EMPTY_MAP, null) {

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								Object sel = selection.getFirstElement();
									Object ano = list.get(index - 1);
									list.remove(sel);
									list.set(index -1, sel);
									list.add(index, ano);
								return CommandResult.newOKCommandResult();
							}
						};
						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(command, null, null);
						} catch (ExecutionException e1) {
							ZeligsoftCXUIPlugin.getDefault().error(
									Messages.CXPropertyCollectionPage_FailedMsg, e1);
							return;
						}

						upButton.setEnabled(false);
						downButton.setEnabled(false);
						if ((index - 1) < list.size() - 1) {
							downButton.setEnabled(true);
						} else {
							downButton.setEnabled(false);
						}
						if ((index - 1) > 0) {
							upButton.setEnabled(true);
						} else {
							upButton.setEnabled(false);
						}
						viewer.refresh();
					}
				}
			}
		});

		downButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.DOWN_NAV_IMAGE);
		downButton.setLayoutData(data);
		downButton.setEnabled(false);
		downButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					final StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {

						final int index = list.indexOf(selection
								.getFirstElement());

						ICommand command = new AbstractTransactionalCommand(
								TransactionUtil.getEditingDomain(descriptor.getProperty()),
								Messages.CXPropertyCollectionPage_MoveDownCmdMsg,
								Collections.EMPTY_MAP, null) {

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								Object sel = selection.getFirstElement();
								Object ano = list.get(index + 1);		
								list.remove(ano);
								list.set(index, ano);
								list.add(index + 1, sel);				
								return CommandResult.newOKCommandResult();
							}
						};
						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(command, null, null);
						} catch (ExecutionException e1) {
							ZeligsoftCXUIPlugin.getDefault().error(
									Messages.CXPropertyCollectionPage_FailedMsg, e1);
							return;
						}

						if ((index + 1) < list.size() - 1) {
							downButton.setEnabled(true);
						} else {
							downButton.setEnabled(false);
						}
						if ((index + 1) > 0) {
							upButton.setEnabled(true);
						} else {
							downButton.setEnabled(false);
						}
						descriptor.getValue();
						viewer.refresh();
					}
				}
			}
		});

	}

	/**
	 * Creates table viewer area
	 * 
	 * @param composite
	 */
	private void createTableViewer(Composite composite) {
		viewer = new TableViewer(composite, SWT.FULL_SELECTION | SWT.BORDER);
		viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		TableViewerColumn indexColumn = new TableViewerColumn(viewer, 0);
		indexColumn.getColumn().setWidth(50);
		indexColumn.getColumn().setText(
				Messages.CXPropertyCollectionPage_IndexColumnLabel);

		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData data = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		data.heightHint = 400;
		table.setLayoutData(data);

		TableViewerColumn valueColumn = new TableViewerColumn(viewer, 1);
		valueColumn.getColumn().setWidth(200);
		valueColumn.getColumn().setText(
				Messages.CXPropertyCollectionPage_ValueColumnLabel);
		valueColumn.setEditingSupport(new CXPropertyEditingSupport(viewer,
				descriptor));

		viewer.setContentProvider(new PropertyCollectionContentProvider(
				descriptor));
		viewer.setLabelProvider(new PropertyCollectionLabelProvider(descriptor));

		viewer.setInput(new Object());

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				doModify();
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (descriptor.isReadOnly()) {
					return;
				}
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					if (!((StructuredSelection) o).isEmpty()) {
						if (descriptor.getProperty().isComposite()) {
							modifyButton.setEnabled(true);
						}
						removeButton.setEnabled(true);
						
						if (descriptor.getProperty().isMultivalued()) {
							list = (List) descriptor.getValue();
						}
						Object selectedObject = ((StructuredSelection) o)
								.getFirstElement();
						if (list != null) {
							if (list.indexOf(selectedObject) < list.size() - 1) {
								downButton.setEnabled(true);
							} else {
								downButton.setEnabled(false);
							}
							if (list.indexOf(selectedObject) > 0) {
								upButton.setEnabled(true);
							} else {
								upButton.setEnabled(false);
							}
						}
						return;
					}
					if (descriptor.getProperty().isComposite()) {
						modifyButton.setEnabled(false);
					}
					removeButton.setEnabled(false);
				}
			}
		});
	}

	private void doModify() {
		Object o = viewer.getSelection();
		if (o != null && o instanceof StructuredSelection) {
			StructuredSelection selection = (StructuredSelection) o;
			if (!selection.isEmpty()) {
				if (descriptor.getProperty().isComposite()) {
					if (selection.getFirstElement() instanceof EObject) {
						EObject element = (EObject) selection.getFirstElement();
						Class concept = ZDLUtil.getZDLConcept(element);
						CXPropertyDescriptor newDescriptor = new CXPropertyDescriptor(
								element, concept, null, null);
						createPropertiesDialog(newDescriptor).open();
					}
				}
				viewer.refresh();
			}
		}
	}

	/**
	 * Label provider class
	 * 
	 * @author ysroh
	 * 
	 */
	private class PropertyCollectionLabelProvider extends LabelProvider
			implements ITableLabelProvider {

		private CXPropertyDescriptor descriptor;

		public PropertyCollectionLabelProvider(CXPropertyDescriptor descriptor) {
			this.descriptor = descriptor;
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 1) {
				if (!(element instanceof EObject)) {
					return null;
				}

				return BaseUIUtil.getIcon((EObject) element);
			}
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (columnIndex == 0) {
				List values = (List) descriptor.getValue();
				return values.indexOf(element) + ""; //$NON-NLS-1$

			} else if (columnIndex == 1) {
				if (element instanceof NamedElement) {
					String name = ((NamedElement) element).getLabel();
					if (UML2Util.isEmpty(name)) {
						if (element instanceof Dependency) {
							EList<NamedElement> suppliers = ((Dependency) element)
									.getSuppliers();
							if (!suppliers.isEmpty()) {
								name = NLS
										.bind(Messages.CXPropertyCollectionPage_DependencyLabelEnclosure,
												suppliers.get(0).getLabel());
							}
						}
					}
					return name;
				} else if (element instanceof EObject) {
					if (element instanceof Element) {
						return EMFCoreUtil.getName((EObject) element);
					}
					Class concept = ZDLUtil.getZDLConcept((EObject) element);
					if (concept == null) {
						return UML2Util.EMPTY_STRING;
					}
					if (!concept.getAttributes().isEmpty()) {
						for (Property attribute : concept.getAttributes()) {
							Object value = ZDLUtil.getValue((EObject) element,
									concept, attribute.getName());
							if (value instanceof List) {
								List valueList = (List) value;
								if (!valueList.isEmpty()) {
									value = valueList.get(0);
								}
							}
							if (value instanceof String
									&& !UML2Util.isEmpty((String) value)) {
								return (String) value;
							} else if (value instanceof EObject) {
								return EMFCoreUtil.getName((EObject) value);
							}
						}
					}
					return "[ " + concept.getLabel() + " ]"; //$NON-NLS-1$//$NON-NLS-2$
				}
				return element.toString();
			}
			return UML2Util.EMPTY_STRING;
		}
	}

	/**
	 * Content provider class
	 * 
	 * @author ysroh
	 * 
	 */
	private class PropertyCollectionContentProvider implements
			IStructuredContentProvider {

		private CXPropertyDescriptor descriptor;

		public PropertyCollectionContentProvider(CXPropertyDescriptor descriptor) {
			this.descriptor = descriptor;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			Object value = descriptor.getValue();
			if (!(value instanceof List)) {
				return new Object[] {};
			}

			return ((List) value).toArray();

		}

		@Override
		public void dispose() {
			// do nothing

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing

		}

	}

}
