/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 440108
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;


public class NamedElementValidator extends AbstractUMLValidator {

	private EObject source;

	public NamedElementValidator() {
		// nothing

	}

	public NamedElementValidator(EObject source) {
		if (source != null) {
			this.source = source;
		} else {
			this.source = null;
		}
	}

	public IStatus validate(Object value) {
		boolean status = true;
		String string = null;
		if (value instanceof String) {
			string = (String) value;
		}

		if (string == null) {
			return Status.OK_STATUS;
		}

		if (this.source instanceof NamedElement) {
			final NamedElement self = (NamedElement) this.source;
			final Namespace ns = self.getNamespace();

			if (ns != null) {
				final boolean deliver = self.eDeliver();
				final boolean wasSet = self.isSetName();
				final String oldName = self.getName();

				try {
					// Set up the prospective name
					self.eSetDeliver(false);
					self.setName(string);

					EList<NamedElement> listElement = ns.getMembers();
					for (NamedElement namedElement : listElement) {
						if ((self != namedElement) && !self.isDistinguishableFrom(namedElement, ns)) {
							return warning("Name is indistinguishable from another element in the Namespace"); //$NON-NLS-1$
						}
					}
				} finally {
					// Restore the current name
					if (wasSet) {
						self.setName(oldName);
					} else {
						self.unsetName();
					}
					self.eSetDeliver(deliver);
				}
			}

			if (status) {
				return Status.OK_STATUS;
			}
		}
		return Status.CANCEL_STATUS;
	}
}
