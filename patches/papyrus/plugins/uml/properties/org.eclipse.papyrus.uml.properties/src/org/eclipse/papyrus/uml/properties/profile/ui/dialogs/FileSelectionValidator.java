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
package org.eclipse.papyrus.uml.properties.profile.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;



public class FileSelectionValidator implements ISelectionStatusValidator {

	public IStatus validate(Object[] arg0) {

		if ((arg0 == null) || (arg0.length < 1)) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No selection.");
		}

		Object selection = arg0[0];
		if (!(selection instanceof IFile)) {

			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selection should be a file.");
		}

		return new Status(
				IStatus.OK
				, Activator.PLUGIN_ID
				, "Selection is valid");
	}
}
