/*******************************************************************************
 * Copyright (c) 2015, 2017 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.dependency;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ide.ui.dependency.IDependencyProvider;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.compare.diagram.ide.ui.util.ModelExtensionUtil;

/**
 * A client of the EMF Compare Dependency extension point providing a lightweight integration of the Papyrus
 * ModelSet approach with the EMF Model Resolution Strategy.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class PapyrusDependencyProvider implements IDependencyProvider {

	/**
	 * File extensions registered in Papyrus.
	 */
	private List<String> fileExtensions;

	/**
	 * Constructs and initializes the PapyrusDependencyIdentifier.
	 */
	public PapyrusDependencyProvider() {
		fileExtensions = new ArrayList<String>(ModelExtensionUtil.getRegisteredFileExtensions());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(URI uri) {
		return fileExtensions.contains(uri.fileExtension());
	}

	/**
	 * {@inheritDoc} Checks the Papyrus model extension point and tries to determine all dependencies from the
	 * registered information.
	 */
	public Set<URI> getDependencies(URI uri, URIConverter uriConverter) {
		final Set<URI> dependencies = new LinkedHashSet<URI>();
		final URI baseURI = uri.trimFileExtension();
		for (String fileExtension : fileExtensions) {
			final URI dependencyURI = baseURI.appendFileExtension(fileExtension);
			if (uriConverter.exists(dependencyURI, null)) {
				dependencies.add(dependencyURI);
			}
		}
		return dependencies;
	}
}
