/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import org.eclipse.emf.compare.Diff;

/**
 * A Diff handler performs some treatment on a given {@link Diff}.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public interface IDiffHandler {

	/**
	 * Handles the given diff.
	 * 
	 * @param diff
	 *            The diff ta handle.
	 */
	void handle(Diff diff);
}
