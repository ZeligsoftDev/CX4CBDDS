/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.pr;

/**
 * A ProtectedRegionResolver is responsible for resolving Protected Regions from the generated sources. 
 */
public interface ProtectedRegionResolver {
	/**
	 * Retrieve a {@link ProtectedRegion} by its Id.
	 * @param id The Id of the {@link ProtectedRegion} searched for. 
	 * @return The Protected Region identified by <tt>id</tt>. Returns <code>null</code> if the Protected 
	 * Region is not known to the Resolver.
	 */
    ProtectedRegion getProtectedRegion(String id);

    /**
     * Creates a {@link ProtectedRegion} instance.
     * @param id The Protected Region's Id.
     * @param disabled The Protected Region's activation status ( <code>true</code>: disabled, <code>false</code>: enabled)
     * @return A new instance
     */
    ProtectedRegion createProtectedRegion(String id, boolean disabled);
}
