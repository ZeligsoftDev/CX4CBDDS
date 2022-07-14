/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.items;

import java.util.List;

import org.eclipse.papyrus.uml.profile.Message;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;



/**
 * The Class MetaclassItems.
 */
public class MetaclassItems {

	/**
	 * The Constructor.
	 *
	 * @param table
	 *            the table
	 * @param value
	 *            the value
	 * @param property
	 *            the property
	 */
	public MetaclassItems(Table table, Property property, Object value) {

		// Checking rule
		if (property.getLower() > 0) {
			// Lower must be != 0 because the value of the property is an element in the model
			// no default value may be entered in the profile
			Message.warning(
					"Property of type Metaclass and multiplicity lower value != 0.\n" +
							"The profile is ill formed !");
		}

		if (property.isMultivalued()) {
			// property is multivalued
			final List propValues = (List) value;
			for (int i = 0; i < propValues.size(); i++) {
				createItem(table, property, propValues.get(i));
			}

		} else { // property is not multivalued

			// if the property has a value
			if (value != null) {
				createItem(table, property, value);
			}
		}
	}

	/**
	 * Creates a new item for current objet int the table.
	 *
	 * @param table
	 *            the table
	 * @param object
	 *            the object
	 * @param property
	 *            the property
	 */
	private void createItem(Table table, Property property, Object object) {

		if (object != null) {
			// Prepare Item label
			TableItem propValueItem = new TableItem(table, SWT.NONE);
			String label = object.toString();
			if (object instanceof NamedElement) {
				NamedElement baseNamedElement = (NamedElement) object;
				if (baseNamedElement.isSetName()) {
					label = baseNamedElement.getQualifiedName();
				}
			}
			propValueItem.setText(label);
			propValueItem.setData(object);
		}
	}
}
