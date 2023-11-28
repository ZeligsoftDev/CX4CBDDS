/*******************************************************************************
 * Copyright (c) 2015 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.papyrus.compare.diagram.ide.ui.util.ModelExtensionUtil;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;

/**
 * Hook into the EMF Compare {@link org.eclipse.emf.ecore.resource.ResourceSet} in order to adjust the default
 * save parameters.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 2.4
 */
public class SaveParameterHook extends AbstractPapyrusResourceSetHook {

	/**
	 * Adjust the default save parameters of Papyrus resources. The {@link ResourceSet} is checked if it
	 * "really" contains Papyrus resources by looking for either a {@code .di} or {@code .notation} file since
	 * they are pretty unique to Papyrus. If either one is found all default save parameters of files with
	 * file extensions registered in Papyrus are checked for additional save parameters. {@inheritDoc}
	 */
	@Override
	public void postLoadingHook(final ResourceSet resourceSet, final Collection<? extends URI> uris) {
		if (containsPapyrusResources(resourceSet)) {
			for (final Resource resource : resourceSet.getResources()) {
				if (resource instanceof XMLResource && resource.getURI() != null) {
					final String resourceExtension = resource.getURI().fileExtension();
					if (fileExtensions.contains(resourceExtension)) {
						final Map<?, ?> saveParameters = ModelExtensionUtil
								.getSaveParameters(resourceExtension);
						final XMLResource xmlResource = (XMLResource)resource;
						xmlResource.getDefaultSaveOptions().putAll(saveParameters);
					}
				}
			}
		}
	}

	/**
	 * Walks through the {@link Resource}s of the {@link ResourceSet} to determine if it contains Papyrus
	 * resources.
	 * 
	 * @param resourceSet
	 *            The checked {@link ResourceSet}.
	 * @return {@code true} if the given {@code resourceSet} contains either a {@code .di} or
	 *         {@code .notation} file, {@code false} otherwise.
	 */
	private boolean containsPapyrusResources(final ResourceSet resourceSet) {
		for (final Resource resource : resourceSet.getResources()) {
			if (resource.getURI() != null) {
				final String resourceExtension = resource.getURI().fileExtension();
				if (DiModel.DI_FILE_EXTENSION.equals(resourceExtension)
						|| NotationModel.NOTATION_FILE_EXTENSION.equals(resourceExtension)) {
					return true;
				}
			}
		}
		return false;
	}
}
