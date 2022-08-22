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
import java.util.stream.Collectors;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.common.util.UML2Util;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.pathmap.DynamicPathmapRegistry;
import com.zeligsoft.base.pathmap.PathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.PreferenceConstants;

/**
 * Suppress warning editing support
 * 
 * @author Young-Soo Roh
 *
 */
public class SuppressWarningEditingSupport extends EditingSupport {

	private IEclipsePreferences store;
	private String[] items = new String[] { "yes", "no" }; //$NON-NLS-1$//$NON-NLS-2$

	public SuppressWarningEditingSupport(ColumnViewer viewer) {
		super(viewer);
		store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
	}

	@Override
	protected Object getValue(Object element) {
		URI pathmap = (URI) element;
		String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap.toString();
		String suppressed = store.get(prefConstant, PreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
		List<String> items = new ArrayList<String>(Arrays.asList(suppressed.split("\\s*,\\s*"))); //$NON-NLS-1$
		items = items.stream().filter(i -> !UML2Util.isEmpty(i)).collect(Collectors.toList());
		if (!items.isEmpty()) {
			return 0;
		}
		return 1;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		return new ComboBoxCellEditor((Table) getViewer().getControl(), items);
	}

	@Override
	protected boolean canEdit(Object element) {
		return DynamicPathmapRegistry.INSTANCE.getPathmapDescriptors((URI) element).size() > 1;
	}

	@Override
	protected void setValue(Object element, Object value) {
		URI pathmap = (URI) element;

		if (getValue(pathmap) != value) {
			// change suppress warning value
			String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap.toString();
			if ((int) value == 0) {
				// suppress future warnings for the pathmap state
				String suppressedMappings = store.get(prefConstant,
						PreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
				List<String> mappings = new ArrayList<String>();
				mappings.addAll(Arrays.asList(suppressedMappings.split("\\s*,\\s*"))); //$NON-NLS-1$

				List<PathmapDescriptor> descs = DynamicPathmapRegistry.INSTANCE.getPathmapDescriptors(pathmap);
				for (PathmapDescriptor d : descs) {
					if (!mappings.contains(d.getMapping().toString())) {
						mappings.add(d.getMapping().toString());
					}
				}
				store.put(prefConstant, String.join(",", mappings)); //$NON-NLS-1$

			} else {
				store.remove(prefConstant);
			}

			try {
				store.flush();
			} catch (BackingStoreException e1) {
				// pass
			}

			// refresh the table
			CheckboxTableViewer viewer = (CheckboxTableViewer) getViewer();
			Object[] checked = viewer.getCheckedElements();
			viewer.setInput(viewer.getInput());
			viewer.setCheckedElements(checked);
		}

	}
}
