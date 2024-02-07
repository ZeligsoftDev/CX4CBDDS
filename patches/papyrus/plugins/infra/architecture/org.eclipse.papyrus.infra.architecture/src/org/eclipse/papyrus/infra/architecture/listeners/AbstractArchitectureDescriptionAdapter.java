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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences;

/**
 * An adapter that is installed in DI models to listen to architecture description changes
 *
 * @since 3.2
 *
 */
public abstract class AbstractArchitectureDescriptionAdapter extends EContentAdapter {

	/**
	 * Listens to changes on ArchitectureDescription* objects
	 */
	@Override
	public void notifyChanged(final Notification notification) {
		if (notification.getNotifier() instanceof ArchitectureDescription ||
				notification.getNewValue() instanceof ArchitectureDescription ||
				notification.getOldValue() instanceof ArchitectureDescription) {
			fireArchitectureContextChanged(notification);
		} else if (notification.getNotifier() instanceof ArchitectureDescriptionPreferences ||
				notification.getNewValue() instanceof ArchitectureDescriptionPreferences ||
				notification.getOldValue() instanceof ArchitectureDescriptionPreferences) {
			fireArchitectureViewpointsChanged(notification);
		}
	}

	/**
	 * This method notifies that the Architecture context changed
	 *
	 * @param notification
	 *            a notification
	 */
	public abstract void fireArchitectureContextChanged(final Notification notification);

	/**
	 * This method notifies that the Architecture viewpoint changed
	 *
	 * @param notification
	 *            a notification
	 */
	public abstract void fireArchitectureViewpointsChanged(final Notification notification);


}