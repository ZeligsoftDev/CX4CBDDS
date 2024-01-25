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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.architecture.Activator;

/**
 * A notifier for registered listeners on events affecting architecture descriptions in models
 * 
 * @since 1.0
 */
public class ArchitectureDescriptionNotifier {

	/**
	 * The name of the extension point
	 */
	private static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".listeners";

	/**
	 * The class property name
	 */
	private static final String LISTENER_CLASS = "class";

	/**
	 * The singleton instance of this class
	 */
	private static ArchitectureDescriptionNotifier notifier;

	/**
	 * The collection of registered listeners in extensions 
	 */
	private static Collection<IArchitectureDescriptionListener> listeners;

	/**
	 * Gets the singleton instance of this class
	 * 
	 * @return the singleton instance
	 */
	public static synchronized ArchitectureDescriptionNotifier getInstance() {
		if (notifier == null) {
			notifier = new ArchitectureDescriptionNotifier();
			listeners = new ArrayList<>();
			notifier.init();
		}
		return notifier;
	}

	/**
	 * Fires architecture context change events for registered listeners
	 * 
	 * @param notification the change event
	 */
	public void fireArchitectureContextChanged(Notification notification) {
		for (IArchitectureDescriptionListener listener : listeners) {
			listener.architectureContextChanged(notification);
		}
	}

	/**
	 * Fires architecture viewpoint change events for registered listeners
	 * 
	 * @param notification the change event
	 */
	public void fireArchitectureViewpointsChanged(Notification notification) {
		for (IArchitectureDescriptionListener listener : listeners) {
			listener.architectureViewpointsChanged(notification);
		}
	}

	/*
	 * initializes the collection of listeners from the extensions
	 */
	private void init() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			try {
				Object listenerClass = configurationElement.createExecutableExtension(LISTENER_CLASS);
				if (listenerClass instanceof IArchitectureDescriptionListener) {
					listeners.add((IArchitectureDescriptionListener) listenerClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
	}
}
