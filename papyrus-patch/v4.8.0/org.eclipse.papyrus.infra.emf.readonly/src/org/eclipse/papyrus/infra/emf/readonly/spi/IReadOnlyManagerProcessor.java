/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.readonly.spi;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;

/**
 * <p>
 * An OSGi service interface for hooks to process a new {@link ReadOnlyManager}
 * upon its creation. There is no special provision for notification of when the
 * manager is no longer being used.
 * </p>
 * <p>
 * Any number of of implementations of this service may be registered; all will be
 * invoked for each read-only manager.
 * </p>
 * 
 * @since 2.0
 */
@FunctionalInterface
public interface IReadOnlyManagerProcessor {
	/**
	 * Process a newly instantiated read-only manager.
	 * 
	 * @param readOnlyManager
	 *            the new read-only manager
	 * @param editingDomain
	 *            the editing domain for which the manager provides read-only services
	 */
	void processReadOnlyManager(ReadOnlyManager readOnlyManager, EditingDomain editingDomain);
}
