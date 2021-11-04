/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.importsources;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.widgets.providers.DelegatingLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * This is the WorkspacePackageImportSource type. Enjoy.
 */
public class WorkspacePackageImportSource extends AbstractPackageImportSource {

	public WorkspacePackageImportSource() {
		super();
	}

	@Override
	protected IStaticContentProvider createModelHierarchyContentProvider(Map<String, String> extensionFilters) {
		WorkspaceContentProvider contentProvider = new WorkspaceContentProvider();
		if (extensionFilters != null) {
			contentProvider.setExtensionFilters(extensionFilters);
		}
		return contentProvider;
	}

	@Override
	protected ILabelProvider createModelHierarchyLabelProvider() {
		return new DelegatingLabelProvider(super.createModelHierarchyLabelProvider()) {

			@Override
			protected Image customGetImage(Object element) {
				Image result = null;

				if (element == WorkspacePackageImportSource.this) {
					result = delegatedGetImage(ResourcesPlugin.getWorkspace().getRoot());
				}

				return result;
			}

			@Override
			protected String customGetText(Object element) {
				String result = null;

				if (element == WorkspacePackageImportSource.this) {
					result = delegatedGetText(ResourcesPlugin.getWorkspace().getRoot());
				}

				return result;
			}

		};
	}

	@Override
	protected void validateSelection(Object model) throws CoreException {

		if (!(model instanceof IFile)) {
			throw new CoreException(new Status(IStatus.WARNING, Activator.PLUGIN_ID, NLS.bind("Selection is not a file: \"{0}\".", getText(model))));
		}
	}

}
