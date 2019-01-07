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

import java.util.Iterator;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.cx.ui.properties.CXPropertyDescriptor;

/**
 * Editing support for collection page
 * 
 * @author ysroh
 * 
 */
public class CXPropertyEditingSupport
		extends EditingSupport {

	private CXPropertyDescriptor descriptor;

	public CXPropertyEditingSupport(ColumnViewer viewer,
			CXPropertyDescriptor descriptor) {
		super(viewer);
		this.descriptor = descriptor;
	}

	@Override
	protected boolean canEdit(Object element) {

		if (element instanceof Integer || element instanceof String) {
			return true;
		}
		if (element instanceof EnumerationLiteral) {
			return true;
		}
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		CellEditor editor = null;

		if (element instanceof EnumerationLiteral) {
			Enumeration enumeration = ((EnumerationLiteral) element)
				.getEnumeration();
			Iterator<EnumerationLiteral> itor = enumeration.getOwnedLiterals()
				.iterator();
			String[] items = new String[enumeration.getOwnedLiterals().size()];
			int i = 0;
			while (itor.hasNext()) {
				items[i] = itor.next().getLabel();
				i++;
			}

			editor = new ComboBoxCellEditor((Table) getViewer().getControl(),
				items);
		} else if (element instanceof Integer || element instanceof String) {
			editor = new TextCellEditor((Table) getViewer().getControl());
		}

		return editor;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof String || element instanceof Integer) {
			return element.toString();
		}
		if (element instanceof EnumerationLiteral) {
			String literal = ((EnumerationLiteral) element).getName();
			Enumeration enumeration = ((EnumerationLiteral) element)
				.getEnumeration();

			int i = 0;
			for (Iterator<EnumerationLiteral> itor = enumeration
				.getOwnedLiterals().iterator(); itor.hasNext(); i++) {
				if (itor.next().getName().equals(literal)) {
					return i;
				}
			}

			return 0;
		}

		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof String || element instanceof Integer) {
			Type type = descriptor.getProperty().getType();
			if (type instanceof PrimitiveType) {
				Object newValue;
				if (type.getName()
					.equals(UMLPackage.Literals.INTEGER.getName())) {
					newValue = new Integer((String) value);
				} else {
					newValue = value;
				}
				descriptor.replaceValue(element, newValue);
			}

		} else if (element instanceof EnumerationLiteral) {
			EnumerationLiteral literal = (EnumerationLiteral) element;
			Enumeration enumeration = literal.getEnumeration();
			Iterator<EnumerationLiteral> itor = enumeration.getOwnedLiterals()
				.iterator();
			int index = 0;
			while (itor.hasNext()) {
				EnumerationLiteral temp = itor.next();
				if (index == (Integer) value) {
					descriptor.replaceValue(element, temp);
					break;
				}
				index++;
			}
		}

		getViewer().refresh();

	}

}
