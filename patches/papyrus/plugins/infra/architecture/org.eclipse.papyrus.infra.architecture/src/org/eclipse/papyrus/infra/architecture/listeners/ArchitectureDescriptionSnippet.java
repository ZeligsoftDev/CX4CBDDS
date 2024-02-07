/*****************************************************************************
 * Copyright (c) 2017, 2021 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) <vincent.lorenzo@cea.fr> - Bug 576004
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.architecture.listeners;

import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * A model snippet to install the architecture description adapter in the DI model
 *
 * @since 1.0
 */
public class ArchitectureDescriptionSnippet implements IModelSetSnippet {

	/**
	 * The installed adapter
	 */
	private ArchitectureDescriptionAdapter adapter = new ArchitectureDescriptionAdapter();

	/**
	 * Installs the architecture adapter model snippet on the given model set
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSetSnippet#start(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 *
	 * @param modelSet
	 *            the given model set
	 */
	@Override
	public void start(ModelSet modelSet) {
		ArchitectureDescriptionAdapterUtils.registerListener(modelSet, this.adapter);
	}

	/**
	 * Removes the architecture adapter model snippet from the given model set
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 *
	 * @param modelSet
	 *            the given model set
	 */
	@Override
	public void dispose(ModelSet modelSet) {
		ArchitectureDescriptionAdapterUtils.unregisterListener(modelSet, this.adapter);
	}
}
