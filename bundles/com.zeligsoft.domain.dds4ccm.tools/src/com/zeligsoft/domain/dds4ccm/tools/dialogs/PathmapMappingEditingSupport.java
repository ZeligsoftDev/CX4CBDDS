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

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.widgets.Table;

import com.zeligsoft.base.pathmap.DynamicPathmapRegistry;
import com.zeligsoft.base.pathmap.PathmapDescriptor;
import com.zeligsoft.base.pathmap.PathmapChangeListener;

/**
 * Editing support for pathmap selection page
 * 
 * @author ysroh
 * 
 */
public class PathmapMappingEditingSupport extends EditingSupport {

	public PathmapMappingEditingSupport(CheckboxTableViewer viewer) {
		super(viewer);
	}

	@Override
	protected boolean canEdit(Object element) {
		return DynamicPathmapRegistry.INSTANCE.getPathmapDescriptors((URI) element).size() > 1;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		CellEditor editor = null;

		URI pathmap = (URI) element;
		List<PathmapDescriptor> mappings = DynamicPathmapRegistry.INSTANCE.getPathmapDescriptors(pathmap);
		String[] items = new String[mappings.size()];
		int i = 0;
		for (PathmapDescriptor d : mappings) {
			items[i++] = d.getMapping().toString();
		}

		editor = new ComboBoxCellEditor((Table) getViewer().getControl(), items);

		return editor;
	}

	@Override
	protected Object getValue(Object element) {
		PathmapDescriptor desc = DynamicPathmapRegistry.INSTANCE.getPathmapDescriptor((URI) element);
		List<PathmapDescriptor> mappings = DynamicPathmapRegistry.INSTANCE.getPathmapDescriptors((URI) element);
		return mappings.indexOf(desc);
	}

	@Override
	protected void setValue(Object element, Object value) {

		URI pathmap = (URI) element;
		List<PathmapDescriptor> mappings = DynamicPathmapRegistry.INSTANCE.getPathmapDescriptors(pathmap);

		// enable selected mapping
		DynamicPathmapRegistry.INSTANCE.enablePathmapMapping(mappings.get((int) value), PathmapChangeListener.CHANGE);

		// reset input to refresh the table
		CheckboxTableViewer viewer = (CheckboxTableViewer) getViewer();
		Object[] checked = viewer.getCheckedElements();
		viewer.setInput(viewer.getInput());
		viewer.setCheckedElements(checked);
	}
}
