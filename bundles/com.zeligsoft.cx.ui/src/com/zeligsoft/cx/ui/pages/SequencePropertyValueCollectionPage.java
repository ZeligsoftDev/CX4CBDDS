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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
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
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.cx.ui.utils.CXWidgetFactory;

/**
 * Abstract property collection page for sequence type property. Each domain
 * need to extend this class to provide domain specific sequence property
 * collection page
 * 
 * @author ysroh
 * 
 */
public abstract class SequencePropertyValueCollectionPage extends
		PreferencePage {

	protected IPropertyEntry entry;

	protected Property memberAttribute;

	protected ArrayList<IPropertyEntry> valueEntries;

	private TableViewer viewer;

	private Composite composite;

	private Button removeButton;

	private Button upButton;

	private Button downButton;

	private static final String VALUE_DELIMITER = ","; //$NON-NLS-1$

	/**
	 * Constructor
	 * 
	 * @param propertyDescriptor
	 */
	public SequencePropertyValueCollectionPage(IPropertyEntry entry) {
		super(entry.getModelObjectName());
		this.entry = entry;
		memberAttribute = getMemberAttribute();
		valueEntries = getPropertyValueEntries();
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
				.setToolTipText(Messages.SequencePropertyValueCollectionPage_AddNewElementButtonLabel);
		addButton.setLayoutData(data);
		addButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = valueEntries.size();
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {
						index = valueEntries.indexOf(selection
								.getFirstElement()) + 1;
					}
				}
				valueEntries.add(index, getNewPropertyValueEntry());
				viewer.refresh();
			}
		});

		removeButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.DELETE_OBJECT_IMAGE);
		removeButton
				.setToolTipText(Messages.SequencePropertyValueCollectionPage_RemoveElementButtonLabel);
		removeButton.setLayoutData(data);
		removeButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {
						valueEntries.remove(selection.getFirstElement());
						viewer.refresh();
					}
				}
			}
		});

		upButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.UP_NAV_IMAGE);
		upButton.setToolTipText(Messages.SequencePropertyValueCollectionPage_MoveUpButtonLabel);
		upButton.setLayoutData(data);
		upButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {

						int index = valueEntries.indexOf(selection
								.getFirstElement());
						valueEntries.remove(selection.getFirstElement());
						valueEntries.add(index - 1,
								(IPropertyEntry) selection.getFirstElement());
						upButton.setEnabled(false);
						downButton.setEnabled(false);
						if ((index - 1) < valueEntries.size() - 1) {
							downButton.setEnabled(true);
						}
						if ((index - 1) > 0) {
							upButton.setEnabled(true);
						}
						viewer.refresh();

					}
				}
			}
		});

		downButton = CXWidgetFactory.createImageButton(composite,
				CXWidgetFactory.DOWN_NAV_IMAGE);
		downButton
				.setToolTipText(Messages.SequencePropertyValueCollectionPage_MoveDownButtonLabel);
		downButton.setLayoutData(data);
		downButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Object o = viewer.getSelection();
				if (o != null && o instanceof StructuredSelection) {
					StructuredSelection selection = (StructuredSelection) o;
					if (!selection.isEmpty()) {

						int index = valueEntries.indexOf(selection
								.getFirstElement());
						valueEntries.remove(selection.getFirstElement());
						valueEntries.add(index + 1,
								(IPropertyEntry) selection.getFirstElement());
						upButton.setEnabled(false);
						downButton.setEnabled(false);
						if ((index + 1) < valueEntries.size() - 1) {
							downButton.setEnabled(true);
						}
						if ((index + 1) > 0) {
							upButton.setEnabled(true);
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
		TableViewerColumn indexColumn = new TableViewerColumn(viewer, 0);
		indexColumn.getColumn().setWidth(100);
		indexColumn.getColumn().setText(
				Messages.SequencePropertyValueCollectionPage_IndexColumnLabel);

		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData data = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		data.heightHint = 400;
		table.setLayoutData(data);

		TableViewerColumn valueColumn = new TableViewerColumn(viewer, 1);
		valueColumn.getColumn().setWidth(250);
		valueColumn.getColumn().setText(
				Messages.SequencePropertyValueCollectionPage_ValueColumnLabel);
		valueColumn
				.setEditingSupport(getEditingSupport(valueColumn.getViewer()));

		viewer.setContentProvider(new CollectionPageContentProvider(
				valueEntries));
		viewer.setLabelProvider(new SequencePropertyCollectionPageLabelProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object o = viewer.getSelection();
				removeButton.setEnabled(false);
				upButton.setEnabled(false);
				downButton.setEnabled(false);
				if (o != null && o instanceof StructuredSelection) {
					if (!((StructuredSelection) o).isEmpty()) {
						removeButton.setEnabled(true);
						Object selectedObject = ((StructuredSelection) o)
								.getFirstElement();
						if (valueEntries.indexOf(selectedObject) < valueEntries
								.size() - 1) {
							downButton.setEnabled(true);
						}
						if (valueEntries.indexOf(selectedObject) > 0) {
							upButton.setEnabled(true);
						}
					}
				}
			}
		});
		viewer.setInput(new Object());

	}

	protected ArrayList<IPropertyEntry> getPropertyValueEntries() {
		ArrayList<IPropertyEntry> valueEntries = new ArrayList<IPropertyEntry>();

		String value = entry.getValue();
		if (value != null && value.length() > 0) {
			String[] split;
			if (value.matches("^\".*\"$")) { //$NON-NLS-1$
				value = value.substring(1, value.length() - 1);
				split = value.split("\" *, *\""); //$NON-NLS-1$
			} else {
				split = value.split(","); //$NON-NLS-1$
			}

			for (String val : split) {
				IPropertyEntry subEntry = getNewPropertyValueEntry();
				subEntry.setValue(val);
				valueEntries.add(subEntry);
			}
		}
		return valueEntries;
	}

	/**
	 * Return string value separated by comma
	 * 
	 * @return
	 */
	public String getValue() {
		StringBuilder value = new StringBuilder();
		for (IPropertyEntry entry : valueEntries) {
			if (entry.getValue() != null && entry.getValue().length() != 0) {
				value.append("\"" + entry.getValue() + "\""); //$NON-NLS-1$//$NON-NLS-2$
				value.append(VALUE_DELIMITER);
			}
		}
		String result = value.toString();
		if (result.endsWith(VALUE_DELIMITER)) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	/**
	 * Label provider
	 * 
	 * @author ysroh
	 * 
	 */
	private class SequencePropertyCollectionPageLabelProvider extends
			LabelProvider implements ITableLabelProvider {

		@Override
		public String getColumnText(Object object, int index) {
			if (!(object instanceof IPropertyEntry)) {
				return ""; //$NON-NLS-1$
			}
			IPropertyEntry entry = (IPropertyEntry) object;
			if (index == 1) {
				return entry.getPropertyColumnLabel(index);
			} else if (index == 0) {
				return String.valueOf(valueEntries.indexOf(object));
			}
			return UML2Util.EMPTY_STRING;
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

	}

	/**
	 * Content provider
	 * 
	 * @author ysroh
	 * 
	 */
	private class CollectionPageContentProvider implements
			IStructuredContentProvider {

		private List<IPropertyEntry> entries;

		public CollectionPageContentProvider(List<IPropertyEntry> entries) {
			this.entries = entries;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object[] getElements(Object inputElement) {
			return entries.toArray();
		}

	}

	abstract protected Property getMemberAttribute();

	/**
	 * Subclass must implement this function to return new domain specific
	 * property entry for the element type
	 * 
	 * @return
	 */
	abstract protected IPropertyEntry getNewPropertyValueEntry();

	/**
	 * Subclass must provide domain specific editing support
	 * 
	 * @return
	 */
	abstract protected EditingSupport getEditingSupport(ColumnViewer viewer);

}
