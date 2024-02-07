/**
 * Copyright (c) 2017 CEA LIST.
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
 *  
 * 
 */
package org.eclipse.papyrus.infra.architecture.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences;

/**
 * An interface for listening to architecture description change events in models
 * Listeners are expected to update UI in response
 * 
 * @since 1.0
 */
public interface IArchitectureDescriptionListener {

	/**
	 * Responds to an architecture context id change event
	 * 
	 * The event's notifier is of type {@link ArchitectureDescription}
	 * 
	 * @param notification the change event
	 */
	void architectureContextChanged(Notification notification);

	/**
	 * Responds to an architecture viewpoint id change events
	 * 
	 * The event's notifier is of type {@link ArchitectureDescriptionPreferences}
	 * 
	 * @param notification the change event
	 */
	void architectureViewpointsChanged(Notification notification);

}
