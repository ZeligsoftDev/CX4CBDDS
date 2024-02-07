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

import org.eclipse.emf.common.notify.Notification;

/**
 * An adapter that is installed in DI models to listen to architecture description changes
 *
 * @since 1.0
 */
public class ArchitectureDescriptionAdapter extends AbstractArchitectureDescriptionAdapter {

	/**
	 * @see org.eclipse.papyrus.infra.architecture.listeners.AbstractArchitectureDescriptionAdapter#fireArchitectureContextChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void fireArchitectureContextChanged(Notification notification) {
		ArchitectureDescriptionNotifier.getInstance().fireArchitectureContextChanged(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.architecture.listeners.AbstractArchitectureDescriptionAdapter#fireArchitectureViewpointsChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void fireArchitectureViewpointsChanged(Notification notification) {
		ArchitectureDescriptionNotifier.getInstance().fireArchitectureViewpointsChanged(notification);
	}

}
