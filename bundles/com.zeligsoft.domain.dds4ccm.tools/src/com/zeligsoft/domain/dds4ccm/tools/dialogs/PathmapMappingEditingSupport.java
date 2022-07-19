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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Editing support for pathmap selection page
 * 
 * @author ysroh
 * 
 */
public class PathmapMappingEditingSupport extends EditingSupport {

	private static boolean warned = false;
	
	private boolean conflictOnly;

	public PathmapMappingEditingSupport(CheckboxTableViewer viewer) {
		this(viewer, false);
	}

	public PathmapMappingEditingSupport(CheckboxTableViewer viewer, boolean conflictOnly) {
		super(viewer);
		this.conflictOnly = conflictOnly;
	}

	
	@Override
	protected boolean canEdit(Object element) {
		CXPathmapDescriptor desc = (CXPathmapDescriptor) element;
		return CXDynamicURIConverter.getPathmapDescriptors(desc.getPathmap()).size() > 1;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		CellEditor editor = null;

		if (element instanceof CXPathmapDescriptor) {
			CXPathmapDescriptor desc = (CXPathmapDescriptor) element;
			List<CXPathmapDescriptor> mappings = CXDynamicURIConverter.getPathmapDescriptors(desc.getPathmap());
			String[] items = new String[mappings.size()];
			int i = 0;
			for (CXPathmapDescriptor d : mappings) {
				items[i++] = d.getMapping().toString();
			}

			editor = new ComboBoxCellEditor((Table) getViewer().getControl(), items);
		}

		return editor;
	}

	@Override
	protected Object getValue(Object element) {
		CXPathmapDescriptor desc = (CXPathmapDescriptor) element;
		List<CXPathmapDescriptor> mappings = CXDynamicURIConverter.getPathmapDescriptors(desc.getPathmap());
		return mappings.indexOf(element);
	}

	@Override
	protected void setValue(Object element, Object value) {

		CXPathmapDescriptor desc = (CXPathmapDescriptor) element;
		List<CXPathmapDescriptor> mappings = CXDynamicURIConverter.getPathmapDescriptors(desc.getPathmap());
		
		// enable selected mapping
		CXDynamicURIConverter.enablePathmapMapping(mappings.get((int) value));

		List<CXPathmapDescriptor> input;
		if(conflictOnly) {
			input = new ArrayList<CXPathmapDescriptor>();
			Set<URI> conflicts = CXDynamicURIConverter.getNewConflictPathmaps();
			for(URI uri: conflicts) {
				input.add(CXDynamicURIConverter.getPathmapDescriptor(uri));
			}
		}else {
			input = CXDynamicURIConverter.getEnabledPathmaps();
		}
		
		getViewer().setInput(input);
		((CheckboxTableViewer) getViewer()).setCheckedElements(CXDynamicURIConverter.getEnabledPathmaps().toArray());
		if (!warned) {
			warned = true;
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
							Messages.PathmapMappingEditingSupport_WarningTitle,
							Messages.PathmapMappingEditingSupport_WarningMsg);
				}
			});
		}
	}

}
