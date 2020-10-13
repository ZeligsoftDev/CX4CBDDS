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

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
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

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Properties dialog for packaged elements. Users will be able to modify item
 * order by using up or down button.
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ListTableViewerPage extends PreferencePage {

	private List list;

	private TableViewer viewer;

	private Button upButton;

	private Button downButton;

	private LabelProvider labelProvider = null;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Constructor
	 * 
	 * @param propertyDescriptor
	 */
	public ListTableViewerPage(List list, String label, TransactionalEditingDomain domain) {
		this(list, label, null, domain);
	}

	public ListTableViewerPage(List list, String label, LabelProvider labelProvider,
			TransactionalEditingDomain domain) {
		super(label);
		this.list = list;
		this.labelProvider = labelProvider;
		this.editingDomain = domain;
	}

	@Override
	protected Control createContents(Composite parent) {

		noDefaultAndApplyButton();

		Composite composite = CXWidgetFactory.createGridComposite(parent, 2, GridData.FILL_BOTH);

		createTableViewer(composite);

		createButtonArea(composite);

		return composite;
	}

	/**
	 * Creates button area
	 * 
	 * @param parent
	 */
	private void createButtonArea(Composite parent) {
		Composite composite = CXWidgetFactory.createGridComposite(parent, 1, GridData.VERTICAL_ALIGN_BEGINNING);

		GridData data = new GridData();

		upButton = CXWidgetFactory.createImageButton(composite, CXWidgetFactory.UP_NAV_IMAGE);
		upButton.setLayoutData(data);
		upButton.setEnabled(false);
		upButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					final StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {

						final int index = list.indexOf(selection.getFirstElement());

						Command command = new RecordingCommand(editingDomain,
								Messages.ListTableViewerPage_MoveUpCmdLabel) {

							@Override
							protected void doExecute() {
								list.remove(selection.getFirstElement());
								list.add(index - 1, selection.getFirstElement());
							}
						};
						if (command.canExecute()) {
							editingDomain.getCommandStack().execute(command);
						} else {
							ZeligsoftCXUIPlugin.getDefault().warning(Messages.ListTableViewerPage_FailedMsg);
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

		downButton = CXWidgetFactory.createImageButton(composite, CXWidgetFactory.DOWN_NAV_IMAGE);
		downButton.setLayoutData(data);
		downButton.setEnabled(false);
		downButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					final StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {

						final int index = list.indexOf(selection.getFirstElement());
						Command command = new RecordingCommand(editingDomain,
								Messages.ListTableViewerPage_MoveDownCmdMsg) {

							@Override
							protected void doExecute() {
								list.remove(selection.getFirstElement());
								list.add(index + 1, selection.getFirstElement());							}
						};
						if (command.canExecute()) {
							editingDomain.getCommandStack().execute(command);
						} else {
							ZeligsoftCXUIPlugin.getDefault().warning(Messages.ListTableViewerPage_FailedMsg);
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
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		data.heightHint = 400;
		table.setLayoutData(data);

		TableViewerColumn valueColumn = new TableViewerColumn(viewer, 1);
		valueColumn.getColumn().setWidth(300);
		valueColumn.getColumn().setText(Messages.ListTableViewerPage_ColumnLabel);

		viewer.setContentProvider(new ListContentProvider());
		viewer.setLabelProvider(labelProvider == null ? new EObjectLabelProvider() : labelProvider);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					if (!((StructuredSelection) o).isEmpty()) {
						Object selectedObject = ((StructuredSelection) o).getFirstElement();
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
				}
			}
		});
		viewer.setInput(new Object());
	}

	/**
	 * Label provider class
	 * 
	 * @author ysroh
	 * 
	 */
	private class EObjectLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return BaseUIUtil.getIcon((EObject) element);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof EObject) {
				return EMFCoreUtil.getName((EObject) element);
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
	private class ListContentProvider implements IStructuredContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			return list.toArray();

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
