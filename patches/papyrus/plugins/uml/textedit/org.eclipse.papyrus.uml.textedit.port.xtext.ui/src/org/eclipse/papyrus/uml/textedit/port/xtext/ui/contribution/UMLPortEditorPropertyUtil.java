/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contribution;

import org.eclipse.papyrus.uml.alf.naming.ALFIDConverter;
import org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PortUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.papyrus.uml.xtext.integration.CompletionProposalUtils;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UMLPortEditorPropertyUtil extends PortUtil {

	public static String getLabel(Port port) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(NamedElementUtil.getVisibilityAsSign(port));
		buffer.append(" ");

		// derived property
		buffer.append(getDerived(port));

		// name
		buffer.append(ALFIDConverter.nameToID(getName(port)));

		// is conjugated
		if (port.isConjugated()) {
			buffer.append(" : ~");
		} else {
			buffer.append(" : ");
		}
		// type
		if (port.getType() != null) {

			buffer.append(CompletionProposalUtils.getQualifiedNameLabelWithSufficientDepth(port.getType(),
					port.getNamespace()));
		} else {
			buffer.append(TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(port, true);
		if (!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}
		buffer.append(" ");

		// property modifiers
		String modifiers = PropertyUtil.getModifiersAsString(port, false);
		if (!"".equals(modifiers)) {
			buffer.append(modifiers);
			buffer.append(" ");
		}

		// default value
		if (port.getDefaultValue() != null) {
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

			}.doSwitch(port.getDefaultValue());

			if (defaultValue != null) {
				buffer.append("= ");
				buffer.append(defaultValue);
			}
		}

		return buffer.toString();
	}

}
