/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.tools.ui.internal.preferences;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
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

import com.zeligsoft.ddk.tools.internal.emf.URIMapHandler;
import com.zeligsoft.ddk.tools.internal.emf.URIMapHandler.PathmapDescriptor;

/**
 * Preference page for Zeligsoft mappings.
 *
 * @author Christian W. Damus (cdamus)
 */
public class URIMappingsPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	
	private CheckboxTableViewer table;

	/**
	 * Initializes me.
	 */
	public URIMappingsPreferencePage() {
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
		label
			.setText("Select pathmap URIs to re-direct into the local workspace");
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
		List<PathmapDescriptor> pathmaps = getPathmaps();

		table = new CheckboxTableViewer(swtTable);
		table.getTable().setLinesVisible(true);
		table.getTable().setLayoutData(
				new GridData(GridData.FILL, GridData.FILL, true, true));

		TableViewerColumn column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Pathmap");
		column.getColumn().setWidth(200);
		column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Value");
		column.getColumn().setWidth(200);
		column = new TableViewerColumn(table, SWT.NONE);
		column.getColumn().setText("Project");
		column.getColumn().setWidth(200);

		table.setLabelProvider(new URIMappingLabelProvider());
		table.setContentProvider(contents);
		table.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				PathmapDescriptor pathmap = (PathmapDescriptor) event
					.getElement();

				pathmap.setEnabled(event.getChecked());
				pathmap.apply();
			}

		});

		table.setInput(pathmaps);
		List<PathmapDescriptor> selected = getEnabledPathmaps(pathmaps);
		table.setCheckedElements(selected.toArray());

		noDefaultAndApplyButton();

		return result;
	}

	private List<PathmapDescriptor> getPathmaps() {
		List<PathmapDescriptor> result = new java.util.ArrayList<PathmapDescriptor>();

		for (Map.Entry<IProject, Map<URI, PathmapDescriptor>> entry 
				: URIMapHandler.getPathmaps().entrySet()) {
			result.addAll(entry.getValue().values());
		}

		return result;
	}

	private List<PathmapDescriptor> getEnabledPathmaps(
			List<PathmapDescriptor> pathmaps) {
		List<PathmapDescriptor> result = 
			new java.util.ArrayList<PathmapDescriptor>(
			pathmaps.size());

		for (PathmapDescriptor next : pathmaps) {
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

	private static class URIMappingLabelProvider
			implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
	}

	@Override
		public String getColumnText(Object element, int columnIndex) {
			PathmapDescriptor pathmap = (PathmapDescriptor) element;

			switch (columnIndex) {
				case 0 :
					return pathmap.getPathmap().toString();
				case 1 :
					return pathmap.getOriginalMapping().toString();
				case 2 :
					return pathmap.getProject().getName();
				default :
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
