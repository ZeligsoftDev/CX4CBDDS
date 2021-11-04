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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Package;

/**
 * This is the IPackageImportSource type. Enjoy.
 */
public interface IPackageImportSource {

	boolean canImportInto(Collection<?> selection);

	void initialize(Collection<?> selection);

	/**
	 * Obtains a content provider for the model hierarchy content that I
	 * contribute.
	 *
	 * The ContentProvider is configured with the given extension
	 *
	 * @return my content provider
	 */
	IStaticContentProvider getModelHierarchyContentProvider(Map<String, String> extensionFilters);

	/**
	 * Obtains a label provider for the model hierarchy content that I
	 * contribute. As a special case, it may be asked for a label for the {@code IPackageImportSource}, itself. In this case, a label should be
	 * provided that suitably represents "my kind of content."
	 *
	 * @return my label provider
	 */
	ILabelProvider getModelHierarchyLabelProvider();

	List<Package> getPackages(ResourceSet resourceSet, Object model) throws CoreException;

	/**
	 * Clean up any resources that I allocated that are no longer required.
	 * Invoked after completion of the import interaction. This includes at
	 * least the {@linkplain #getModelHierarchyContentProvider() content
	 * provider} and {@linkplain #getModelHierarchyLabelProvider() label
	 * provider} that I create.
	 */
	void dispose();
}
