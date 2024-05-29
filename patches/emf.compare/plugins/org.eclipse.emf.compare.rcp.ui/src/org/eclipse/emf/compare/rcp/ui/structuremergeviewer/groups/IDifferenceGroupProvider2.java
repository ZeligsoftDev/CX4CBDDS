/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups;

/**
 * Extended interface of {@link IDifferenceGroupProvider} that gives information on the building status of its
 * groups.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 * @since 4.1
 */
public interface IDifferenceGroupProvider2 extends IDifferenceGroupProvider {

	/**
	 * Tells if the groups of this provider have been already built for a comparison.
	 * 
	 * @return <code>true</code> if the groups has been built for this comparison or <code>false</code>
	 *         otherwise.
	 */
	boolean groupsAreBuilt();
}
