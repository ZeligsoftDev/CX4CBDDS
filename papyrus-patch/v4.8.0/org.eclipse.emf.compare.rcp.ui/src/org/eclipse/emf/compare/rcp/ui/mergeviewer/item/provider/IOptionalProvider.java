/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider;

/**
 * A contract for a provider which can indicate whether it wants to handle a certain object.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 4.4
 */
public interface IOptionalProvider {
	/**
	 * Indicates whether this provider wants to handle the given {@code object}.
	 * 
	 * @param object
	 *            the {@link Object}.
	 * @return {@code true} if the provider wants to handle the given {@code object}, {@code false} otherwise.
	 */
	boolean canHandle(Object object);
}
