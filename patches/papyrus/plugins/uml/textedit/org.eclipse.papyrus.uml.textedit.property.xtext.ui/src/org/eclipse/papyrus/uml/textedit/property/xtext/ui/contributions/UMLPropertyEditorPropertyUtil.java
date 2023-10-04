/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.property.xtext.ui.contributions;

import org.eclipse.papyrus.uml.alf.naming.ALFIDConverter;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.papyrus.uml.xtext.integration.CompletionProposalUtils;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UMLPropertyEditorPropertyUtil extends PropertyUtil {

	@SuppressWarnings("nls")
	public static String getLabel(Property property) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(NamedElementUtil.getVisibilityAsSign(property));
		buffer.append(" ");

		// derived property
		buffer.append(getDerived(property));

		// name
		buffer.append(ALFIDConverter.nameToID(getName(property)));

		// type
		if (property.getType() != null) {
			buffer.append(" : "
					+ CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(property.getType(),
							property.getNamespace()));
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property, true);
		if (!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}
		buffer.append(" ");

		// property modifiers
		String modifiers = PropertyUtil.getModifiersAsString(property, false);
		if (!"".equals(modifiers)) {
			buffer.append(modifiers);
			buffer.append(" ");
		}

		// default value
		if (property.getDefault() != null) {
			buffer.append("= ");
			String defaultValue = new UMLSwitch<String>() {
				@Override
				public String caseLiteralBoolean(org.eclipse.uml2.uml.LiteralBoolean object) {
					return Boolean.toString(object.booleanValue());
				}

				@Override
				public String caseLiteralInteger(org.eclipse.uml2.uml.LiteralInteger object) {
					return Integer.toString(object.integerValue());
				}

				@Override
				public String caseLiteralNull(org.eclipse.uml2.uml.LiteralNull object) {
					return "null"; //$NON-NLS-1$
				}

				@Override
				public String caseLiteralString(org.eclipse.uml2.uml.LiteralString object) {
					return "\"" + object.stringValue() + "\"";
				}

				@Override
				public String caseLiteralReal(org.eclipse.uml2.uml.LiteralReal object) {
					return Double.toString(object.getValue());
				}

				@Override
				public String caseLiteralUnlimitedNatural(org.eclipse.uml2.uml.LiteralUnlimitedNatural object) {
					return object.getValue() < 0 ? "*" : Integer.toString(object.getValue());
				}

			}.doSwitch(property.getDefaultValue());

			buffer.append(defaultValue);
		}

		return buffer.toString();
	}

}
