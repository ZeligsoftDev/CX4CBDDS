/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A ScopeView identifies the context of the current lookup; which is the node in which a lookup is being performed,
 * the child node by which the lookup is requested and the EReference of the location where the result will be used.
 * <p>
 * Derived PivotScopeViews are created lazily to support lookups over the Pivot AST.
 * <p>
 * Derived BaseScopeView instances comply with the XText IScope protocol and support lookup over the CST. These must
 * be created eagerly altthough some aspects can be made lazy.
 * <p>
 * The stateless algorithmic lookup functionality is provided by Attribution instances.
 */
public interface ScopeView
{
	/**
	 * Return Attribution instance that defines the lookup algorithm for the target node.
	 */
	@NonNull Attribution getAttribution();

	/**
	 * Return the immediate child node for which a lookup is requested.
	 */
	@Nullable EObject getChild();

	/**
	 * Return the containment feature of the child within the target.
	 */
	@Nullable EStructuralFeature getContainmentFeature();

	/**
	 * Return the ScopeView that characterizes a lookup in the parent of the target node.
	 */
	@NonNull ScopeView getParent();

	/**
	 * Return the ScopeView that characterizes a lookup at the top level.
	 */
	@NonNull ScopeView getRoot();

	/**
	 * Return the target node at which this ScopeView characterizes a lookup.
	 */
	@Nullable EObject getTarget();

	/**
	 * Return true if the lookup is within a qualified name.
	 */
	boolean isQualified();
}