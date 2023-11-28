/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.comparesource;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.compare.ide.ui.source.IEMFComparisonSource;
import org.eclipse.emf.compare.ide.utils.StorageTraversal;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;

/**
 * The {@link IEMFComparisonSource} adapter for {@link IPapyrusFile}s.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 2.5
 */
public class PapyrusFileEMFCompareSourceAdapter implements IEMFComparisonSource {

	/**
	 * The {@link IPapyrusFile} which is adapted.
	 */
	private final IPapyrusFile papyrusFile;

	/**
	 * Constructor.
	 * 
	 * @param papyrusFile
	 *            The {@link IPapyrusFile} which is adapted. Passing {@code null} is not allowed.
	 */
	public PapyrusFileEMFCompareSourceAdapter(IPapyrusFile papyrusFile) {
		Assert.isNotNull(papyrusFile);
		this.papyrusFile = papyrusFile;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return papyrusFile.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public StorageTraversal getStorageTraversal() {
		IResource[] resources = papyrusFile.getAssociatedResources();
		Set<IStorage> storages = getStorages(resources);
		return new StorageTraversal(storages);
	}

	/**
	 * Adapts the given {@code resources} to {@link IStorage}.
	 * 
	 * @param resources
	 *            The array of resources which are to be adapted.
	 * @return A set of all adapted {@link IStorage}s. If resources can not be adapted the set will be empty.
	 */
	private Set<IStorage> getStorages(IResource[] resources) {
		final Set<IStorage> storages = new LinkedHashSet<IStorage>();
		if (resources == null) {
			return storages;
		}

		final IAdapterManager adapterManager = Platform.getAdapterManager();
		for (IResource resource : resources) {
			final IStorage storage = (IStorage)adapterManager.getAdapter(resource, IStorage.class);
			if (storage != null) {
				storages.add(storage);
			}
		}
		return storages;
	}

}
