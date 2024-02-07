/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A TreeIterable supports use of the TreeIterator returned by Resource.getAllConrents() or EObject.eAllContents()
 * as a conventional Iterable.
 * The includeRoot option supports inclusion of the root object as is often more useful than the default
 * exclusion by a TreeIterator.
 * @since 1.3
 */
public class TreeIterable implements Iterable<@NonNull EObject>
{
	private static class Iterator implements java.util.Iterator<@NonNull EObject>
	{
		protected @Nullable EObject firstEObject;
		protected final @NonNull TreeIterator<@NonNull EObject> tit;

		public Iterator(@NonNull EObject rootEObject, boolean includeRoot) {
			this.firstEObject = includeRoot ? rootEObject : null;
			@SuppressWarnings("null")
			@NonNull TreeIterator<@NonNull EObject> eAllContents = (@NonNull TreeIterator<@NonNull EObject>)rootEObject.eAllContents();
			this.tit = eAllContents;
		}

		@Override
		public boolean hasNext() {
			return (firstEObject != null) || tit.hasNext();
		}

		@Override
		public @NonNull EObject next() {
			@NonNull EObject eObject;
			if (firstEObject != null) {
				eObject = firstEObject;
				firstEObject = null;
			}
			else {
				eObject = tit.next();
			}
			return eObject;
		}
	}

	protected final @Nullable Resource resource;
	protected final @Nullable EObject rootEObject;
	protected final boolean includeRoot;

	public TreeIterable(@NonNull EObject rootEObject, boolean includeRoot) {
		this.resource = null;
		this.rootEObject = rootEObject;
		this.includeRoot = includeRoot;
	}

	public TreeIterable(@NonNull Resource resource) {
		this.resource = resource;
		this.rootEObject = null;
		this.includeRoot = false;
	}

	@Override
	public java.util.@NonNull Iterator<@NonNull EObject> iterator() {
		if (resource != null) {
			@SuppressWarnings("null")
			@NonNull TreeIterator<@NonNull EObject> allContents = (@NonNull TreeIterator<@NonNull EObject>)resource.getAllContents();
			return allContents;
		}
		else {
			assert rootEObject != null;
			return new Iterator(rootEObject, includeRoot);
		}
	}
}