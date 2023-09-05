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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.uml2.uml.ExtensionEnd;

/**
 * An IObservableValue for handling the UML ExtensionEnd#multiplicity
 * The multiplicity can only be either 1 or 0..1
 *
 * @author Camille Letavernier
 * @since 3.3
 *
 */
public class ExtensionEndMultiplicityObservableValue extends MultiplicityObservableValue {

	public ExtensionEndMultiplicityObservableValue(ExtensionEnd source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public Command getCommand(Object value) {
		if (MultiplicityParser.ONE.equals(value) || MultiplicityParser.OPTIONAL.equals(value)) {
			return super.getCommand(value);
		}

		Activator.log.warn(String.format("The multiplicity %s is not valid for an ExtensionEnd", value)); //$NON-NLS-1$
		return UnexecutableCommand.INSTANCE;
	}
}
