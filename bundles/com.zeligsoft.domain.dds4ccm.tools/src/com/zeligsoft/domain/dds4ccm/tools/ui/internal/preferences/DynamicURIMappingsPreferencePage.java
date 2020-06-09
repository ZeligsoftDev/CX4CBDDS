/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.ui.internal.preferences;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.PreferencePage;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;

/**
 * Dynamic URI mapping preference page.
 * 
 * @author Young-Soo Roh
 *
 */
public class DynamicURIMappingsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private CheckboxTableViewer table;

	/**
	 * Initializes me.
	 */
	public DynamicURIMappingsPreferencePage() {
		super();
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		grid.verticalSpacing = 15;
		result.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		result.setLayoutData(data);

		Label label = new Label(result, SWT.NONE);
		label.setText("Select dynamic pathmap URIs to re-direct");
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		label.setLayoutData(data);

		Table swtTable = new Table(result, SWT.CHECK | SWT.BORDER);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		swtTable.setLayoutData(data);

		swtTable.setHeaderVisible(true);

		ArrayContentProvider contents = new ArrayContentProvider();
		List<CXPathmapDescriptor> pathmaps = getPathmaps();

		table = new CheckboxTableViewer(swtTable);
		table.getTable().setLinesVisible(true);
		table.getTable().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		TableViewerColumn column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Pathmap");
		column.getColumn().setWidth(300);
		column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("New Mapping");
		column.getColumn().setWidth(400);
		column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Original Mapping");
		column.getColumn().setWidth(200);

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

		table.setInput(pathmaps);
		List<CXPathmapDescriptor> selected = getEnabledPathmaps(pathmaps);
		table.setCheckedElements(selected.toArray());

		noDefaultAndApplyButton();

		return result;
	}

	private List<CXPathmapDescriptor> getPathmaps() {

		List<CXPathmapDescriptor> result = new java.util.ArrayList<CXPathmapDescriptor>();
		result.addAll(CXDynamicURIConverter.PATHMAPS.values());
		return result;
	}

	private List<CXPathmapDescriptor> getEnabledPathmaps(List<CXPathmapDescriptor> pathmaps) {
		List<CXPathmapDescriptor> result = new java.util.ArrayList<CXPathmapDescriptor>(pathmaps.size());

		for (CXPathmapDescriptor next : pathmaps) {
			if (next.isEnabled()) {
				result.add(next);
			}
		}

		return result;
	}

	@Override
	public void init(IWorkbench workbench) {
		// no-op
	}

	//
	// Nested classes
	//

	private static class URIMappingLabelProvider implements ITableLabelProvider {

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
			case 2: {
				URI uri = pathmap.getOriginalMapping();
				return uri == null ? "" : uri.toString();
			}
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
