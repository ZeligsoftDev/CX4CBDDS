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

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


public class FileSelectionFilter extends ViewerFilter {

	/** Authorized file extensions */
	List<String> filetypes;

	/**
	 * If newFileTypes is null, any extension is accepted
	 *
	 * @param newFiletypes
	 *            authorized extensions for the file viewer filter
	 */
	public FileSelectionFilter(List<String> newFiletypes) {
		super();
		filetypes = newFiletypes;
	}

	@Override
	public boolean select(Viewer arg0, Object arg1, Object arg2) {

		if ((arg2 instanceof IContainer) || (arg2 instanceof IFile)) {

			// Filter files
			if (arg2 instanceof IFile) {
				IFile file = (IFile) arg2;
				String file_ext = file.getFileExtension();

				if ((filetypes != null) && (!filetypes.contains(file_ext))) {
					return false;
				}
			}

			// Filter folders
			if (arg2 instanceof IContainer) {
				IContainer container = (IContainer) arg2;
				String name = container.getName();

				// Mask hidden folder
				if (name.startsWith(".")) {
					return false;
				}
			}

			return true;
		}
		return false;
	}

}
