/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.uml.tools.profile.index;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Profile;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * <p>
 * An index service that provides the profiles applied to resources in the workspace.
 * It is expected that the index can provide the URIs of {@link Profile}s that are applied
 * to some {@link org.eclipse.uml2.uml.Package Package} stored in a resource without the
 * resource being loaded in the context of any particular resource set. The mechanism
 * by which this is accomplished is not specified.
 * </p>
 * <p>
 * A suitable implementation of this interface should be registered in the Papyrus Service Registry.
 * </p>
 */
public interface IProfileIndex {
	/**
	 * Queries whether the index covers the specified URI. For example, the index may cover
	 * only the workspace and not remote (e.g., HTTP) or filesystem (outside of the workspace)
	 * resources.
	 * 
	 * @param umlResource
	 *            the URI of a UML resource
	 * 
	 * @return whether the index covers it
	 */
	boolean indexes(URI umlResource);

	/**
	 * Asynchronously obtains the profiles applied to packages in the specified UML resource.
	 * 
	 * @param umlResource
	 *            a resource storing UML model content
	 * 
	 * @return a future set of URIs of the {@link Profile}s applied to packages within the UML resource.
	 *         These are the URIs of the profile elements, themselves, not of the containing resource, because
	 *         there may be any number of distinct profiles in a resource
	 */
	ListenableFuture<Set<URI>> getAppliedProfiles(URI umlResource);

	/**
	 * Synchronously computes the profiles applied intrinsically (in the usual UML way) by packages
	 * in a resource by scanning it on the spot, if necessary. This is as efficient as it can be (not using any
	 * EMF mechanisms to load resources etc.) but still can be expensive for large resources. It is
	 * recommended, if at all possible, to use the {@linkplain #getAppliedProfiles(URI) asynchronous API}
	 * instead.
	 * 
	 * @param umlResource
	 *            a resource storing UML model content
	 * 
	 * @return object URIs of profiles applied to packages in the resource, determined immediately by a scan if necessary
	 * 
	 * @see #getAppliedProfiles(URI)
	 */
	Set<URI> getIntrinsicAppliedProfiles(URI umlResource);
}
