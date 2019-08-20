/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.util;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * An EMF Notification Broker for flexible and targeted attachment of listeners
 * to elements in the Zeligsoft resource set, rather than the resource set as a
 * whole, but benefitting still from the post-commit listener semantics.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EMFNotificationBroker
		extends ResourceSetListenerImpl {

	private static EMFNotificationBroker instance;

	private boolean notInitialized = true;

	/**
	 * Initializes me.
	 */
	public EMFNotificationBroker() {
		super();

		instance = this;

	}

	/**
	 * Obtains the shared instance of the notification broker.
	 * 
	 * @return the shared instance
	 */
	public static EMFNotificationBroker getInstance() {
		return instance;
	}

	private void initialize(TransactionalEditingDomain domain) {
		// install the URI-resolution-fixing adapter
		ZeligsoftURIConverter.install(domain.getResourceSet());
	}

	/**
	 * I am a post-commit listener.
	 */
	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		if (notInitialized) {
			notInitialized = false;

			initialize(event.getEditingDomain());
		}

		// TODO call out to registered listeners
	}
}
