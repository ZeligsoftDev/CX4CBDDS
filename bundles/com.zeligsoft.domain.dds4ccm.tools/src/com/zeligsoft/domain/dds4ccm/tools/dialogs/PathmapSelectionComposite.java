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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
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
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.PreferenceConstants;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Pathmap selection composite
 * 
 * @author Young-Soo Roh
 *
 */
public class PathmapSelectionComposite {

	private CheckboxTableViewer tableViewer;
	private Set<URI> pathmaps;

	public PathmapSelectionComposite() {
		this(CXDynamicURIConverter.PATHMAPS.keySet());
	}

	public PathmapSelectionComposite(Set<URI> pathmaps) {
		this.pathmaps = pathmaps;
	}

	public CheckboxTableViewer getViewer() {
		return tableViewer;
	}

	public Composite createContents(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		grid.verticalSpacing = 15;
		result.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		data.grabExcessVerticalSpace = true;
		result.setLayoutData(data);

		Label label = new Label(result, SWT.NONE);
		label.setText(Messages.DynamicURIMappingsPreferencePage_PreferencePageTitle);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		label.setLayoutData(data);

		Table swtTable = new Table(result, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		swtTable.setLayoutData(data);

		swtTable.setHeaderVisible(true);

		ArrayContentProvider contents = new ArrayContentProvider();

		tableViewer = new CheckboxTableViewer(swtTable);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Pathmap"); //$NON-NLS-1$
		column.getColumn().setWidth(300);
		column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Mapping"); //$NON-NLS-1$
		column.getColumn().setWidth(500);
		column.setEditingSupport(new PathmapMappingEditingSupport(tableViewer));
		column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Conflict"); //$NON-NLS-1$
		column.getColumn().setWidth(90);
		column = new TableViewerColumn(tableViewer, SWT.CHECK);
		column.getColumn().setText("Suppress Warning"); //$NON-NLS-1$
		column.getColumn().setWidth(180);
		column.setEditingSupport(new SuppressWarningEditingSupport(tableViewer));

		tableViewer.setLabelProvider(new URIMappingLabelProvider());
		tableViewer.setContentProvider(contents);
		tableViewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				URI pathmap = (URI) event.getElement();
				CXPathmapDescriptor desc = CXDynamicURIConverter.getPathmapDescriptor(pathmap);
				desc.setEnabled(event.getChecked());
				desc.apply();
			}

		});

		tableViewer.setInput(pathmaps);
		List<URI> selected = CXDynamicURIConverter.getEnabledPathmaps().stream().map(d -> d.getPathmap())
				.collect(Collectors.toList());
		tableViewer.setCheckedElements(selected.toArray());

		return result;
	}

	public static class URIMappingLabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			URI pathmap = (URI) element;

			switch (columnIndex) {
			case 0:
				return pathmap.toString();
			case 1:
				CXPathmapDescriptor desc = CXDynamicURIConverter.getPathmapDescriptor(pathmap);
				if(desc == null) {
					return UML2Util.EMPTY_STRING;
				}
				return desc.getMapping().toString();
			case 2:
				if (CXDynamicURIConverter.getPathmapDescriptors(pathmap).size() > 1) {
					return "yes"; //$NON-NLS-1$
				}
				return "no"; //$NON-NLS-1$
			case 3:
				IEclipsePreferences store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
				String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap.toString();
				String suppressed = store.get(prefConstant, PreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
				List<String> items = new ArrayList<String>(Arrays.asList(suppressed.split("\\s*,\\s*"))); //$NON-NLS-1$
				items = items.stream().filter(i -> !UML2Util.isEmpty(i)).collect(Collectors.toList());
				if (!items.isEmpty()) {
					return "yes"; //$NON-NLS-1$
				}
				return "no";//$NON-NLS-1$
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
