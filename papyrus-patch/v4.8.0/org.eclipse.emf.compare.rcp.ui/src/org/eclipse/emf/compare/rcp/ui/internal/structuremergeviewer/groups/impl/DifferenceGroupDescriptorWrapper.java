/******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.compare.rcp.internal.extension.impl.AbstractItemDescriptor;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.ComparisonType;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor;

/**
 * Implementation of {@link IDifferenceGroupProvider.Descriptor}.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class DifferenceGroupDescriptorWrapper extends AbstractItemDescriptor<IDifferenceGroupProvider.Descriptor> implements IDifferenceGroupProvider.Descriptor {

	/** {@link IConfigurationElement} used to instantiate the {@link IDifferenceGroupProvider}. */
	private final IConfigurationElement element;

	/** Type of comparison the {@link IDifferenceGroupProvider} can handle. */
	private final ComparisonType type;

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            Human-readable label of the underlying group provider.
	 * @param description
	 *            A more detailed description that can be displayed to the user for this group.
	 * @param elem
	 *            {@link IConfigurationElement} used to instantiate the {@link IDifferenceGroupProvider}
	 * @param rank
	 *            Rank of the descriptor
	 * @param comparisonType
	 *            Type of comparison the wrapped {@link IDifferenceGroupProvider} can handle.
	 */
	public DifferenceGroupDescriptorWrapper(String label, String description, IConfigurationElement elem,
			int rank, ComparisonType comparisonType) {
		super(label, description, rank,
				elem.getAttribute(DifferenceGroupProviderExtensionRegistryListener.ATT_CLASS));
		this.element = elem;
		this.type = comparisonType;
	}

	/**
	 * {@inheritDoc}
	 */
	public Descriptor getItem() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public ComparisonType getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	public IDifferenceGroupProvider createGroupProvider() {
		Object instance;
		try {
			instance = element
					.createExecutableExtension(DifferenceGroupProviderExtensionRegistryListener.ATT_CLASS);
			if (instance instanceof IDifferenceGroupProvider) {
				IDifferenceGroupProvider groupProvider = (IDifferenceGroupProvider)instance;
				return groupProvider;
			}
		} catch (CoreException e) {
			EMFCompareRCPUIPlugin.getDefault().log(e);
		}
		return null;
	}

}
