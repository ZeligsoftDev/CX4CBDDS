/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Interface for creation command context holder.
 */
public interface ICommandContext {

	/**
	 * Get the container of the created element.
	 *
	 * @return the container.
	 */
	public EObject getContainer();

	/**
	 * Get the reference the created element relates.
	 *
	 * @return the EReference.
	 */
	public EReference getReference();
}
