/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Pathmap selection composite
 * 
 * @author Young-Soo Roh
 *
 */
public class PathmapSelectionComposite {

	private CheckboxTableViewer table;
	private boolean conflictOnly;

	public PathmapSelectionComposite() {
		this(false);
	}

	public PathmapSelectionComposite(boolean conflictOnly) {
		this.conflictOnly = conflictOnly;
	}

	public Composite createContents(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		grid.verticalSpacing = 15;
		result.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		result.setLayoutData(data);

		Label label = new Label(result, SWT.NONE);
		label.setText(Messages.DynamicURIMappingsPreferencePage_PreferencePageTitle);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		label.setLayoutData(data);

		Table swtTable = new Table(result, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		swtTable.setLayoutData(data);

		swtTable.setHeaderVisible(true);

		ArrayContentProvider contents = new ArrayContentProvider();

		table = new CheckboxTableViewer(swtTable);
		table.getTable().setLinesVisible(true);
		table.getTable().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		TableViewerColumn column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Pathmap"); //$NON-NLS-1$
		column.getColumn().setWidth(300);
		column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Mapping"); //$NON-NLS-1$
		column.getColumn().setWidth(600);
		column.setEditingSupport(new PathmapMappingEditingSupport(table, conflictOnly));
		column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Conflict"); //$NON-NLS-1$
		column.getColumn().setWidth(100);

		table.setLabelProvider(new URIMappingLabelProvider());
		table.setContentProvider(contents);
		table.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				CXPathmapDescriptor pathmap = (CXPathmapDescriptor) event.getElement();

				pathmap.setEnabled(event.getChecked());
				pathmap.apply();
			}

		});

		List<CXPathmapDescriptor> input;
		if(conflictOnly) {
			input = new ArrayList<CXPathmapDescriptor>();
			Set<URI> conflicts = CXDynamicURIConverter.getNewConflictPathmaps();
			for(URI uri: conflicts) {
				input.add(CXDynamicURIConverter.getPathmapDescriptor(uri));
			}
		}else {
			input = CXDynamicURIConverter.getPathmaps();
		}

		table.setInput(input);
		List<CXPathmapDescriptor> selected = CXDynamicURIConverter.getEnabledPathmaps();
		table.setCheckedElements(selected.toArray());

		return result;
	}

	public static class URIMappingLabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			CXPathmapDescriptor pathmap = (CXPathmapDescriptor) element;

			switch (columnIndex) {
			case 0:
				return pathmap.getPathmap().toString();
			case 1:
				return pathmap.getMapping().toString();
			case 2:
				if (CXDynamicURIConverter.getPathmapDescriptors(pathmap.getPathmap()).size() > 1) {
					return "yes"; //$NON-NLS-1$
				}
				return UML2Util.EMPTY_STRING;
			default:
				break;
			}

			return null;
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
			// no-op
		}

		@Override
		public void dispose() {
			// no-op
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// no-op
		}

	}
}
