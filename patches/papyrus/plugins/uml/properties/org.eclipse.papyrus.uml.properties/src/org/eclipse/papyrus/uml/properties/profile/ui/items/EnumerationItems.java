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

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.papyrus.uml.profile.Message;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;



/**
 * The Class EnumerationItems.
 */
public class EnumerationItems {

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
	public EnumerationItems(Table table, Property property, Object value) {


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

		EnumerationLiteral eLiteral = null;
		// Prepare Item data
		if (object instanceof EnumerationLiteral) {
			eLiteral = (EnumerationLiteral) object;

		} else if (object instanceof EEnumLiteral) {
			EEnumLiteral eEnumLiteral = (EEnumLiteral) object;
			Object tmp = Util.getValueObjectFromString(eEnumLiteral.getName(), property.getType());
			eLiteral = ((EnumerationLiteral) tmp);

		} else if (object instanceof String) {
			String literalString = (String) object;
			Object tmp = Util.getValueObjectFromString(literalString, property.getType());
			eLiteral = ((EnumerationLiteral) tmp);

		} else { // Error
			String err = "Value " + object.toString() + " of Property " + property.getName() + " is not an EnumerationLiteral.";
			Message.error(err);
		}

		if (eLiteral != null) {
			// Prepare Item label
			TableItem propValueItem = new TableItem(table, SWT.NONE);
			propValueItem.setText(eLiteral.getName());
			propValueItem.setData(eLiteral);
		}
	}
}
