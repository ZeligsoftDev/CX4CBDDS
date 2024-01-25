/*****************************************************************************
 * Copyright (c) 2021 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) <vincent.lorenzo@cea.fr> - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.architecture.listeners;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;

/**
 * This class is in charge to register adapter on the architecture, in order to be notified when the Architecture context of the architecture viewpoint changed
 *
 * @since 3.2
 */
public final class ArchitectureDescriptionAdapterUtils {


	private ArchitectureDescriptionAdapterUtils() {
		// to prevent instantiation
	}

	/**
	 *
	 * @param modelSet
	 *            the current modelSet
	 * @param adapter
	 *            the adapter to register on the architecture context
	 */
	public static final void registerListener(final ModelSet modelSet, final AbstractArchitectureDescriptionAdapter adapter) {
		DiModel diModel = (DiModel) modelSet.getModel(DiModel.DI_MODEL_ID);
		if (diModel != null) {
			diModel.getResource().eAdapters().add(adapter);
		}
		SashModel sashModel = (SashModel) modelSet.getModel(SashModel.MODEL_ID);
		if (sashModel != null) {
			sashModel.getResource().eAdapters().add(adapter);
		}
	}

	/**
	 *
	 * @param modelSet
	 *            the current modelSet
	 * @param adapter
	 *            the adapter to unregister
	 */
	public static final void unregisterListener(final ModelSet modelSet, final AbstractArchitectureDescriptionAdapter adapter) {
		DiModel diModel = (DiModel) modelSet.getModel(DiModel.DI_MODEL_ID);
		if (diModel != null && diModel.getResource() != null) {
			diModel.getResource().eAdapters().remove(adapter);
		}
		SashModel sashModel = (SashModel) modelSet.getModel(SashModel.MODEL_ID);
		if (sashModel != null && sashModel.getResource() != null) {
			if (sashModel.getResource() != null) {
				sashModel.getResource().eAdapters().remove(adapter);
			}
		}
	}
}
