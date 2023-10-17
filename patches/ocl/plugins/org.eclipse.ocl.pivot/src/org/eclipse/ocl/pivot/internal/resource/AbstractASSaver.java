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
package org.eclipse.ocl.pivot.internal.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;

/**
 * ASSaver ensures that all references to synthesized types are terminated
 * by local copies of the synthesized types.
 *
 * @since 1.18
 */
public abstract class AbstractASSaver
{
	protected final @NonNull Resource resource;

	/**
	 * The appropriate normalization visitor for each Resource.
	 */
	private /*@LazyNonNull*/ Map<@NonNull Resource, @NonNull ASSaverNormalizeVisitor> resource2normalizeVisitor = null;

	protected AbstractASSaver(@NonNull Resource resource) {
		this.resource = resource;
	}

	protected @NonNull ASSaverNormalizeVisitor getNormalizeVisitor(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource == null) {
			throw new IllegalStateException("Cannot locate " + ASSaverNormalizeVisitor.class.getName() + " for resource-less " + eObject.eClass().getName());
		}
		if (resource2normalizeVisitor == null) {
			resource2normalizeVisitor = new HashMap<>();
		}
		ASSaverNormalizeVisitor visitor = resource2normalizeVisitor.get(resource);
		if (visitor != null) {
			return visitor;
		}
		if (resource instanceof ASResource) {
			ASResource asResource = (ASResource)resource;
			visitor = asResource.getASResourceFactory().createASSaverNormalizeVisitor(this);
			resource2normalizeVisitor.put(resource, visitor);
			return visitor;
		}
		else {
			throw new IllegalStateException("Cannot locate " + ASSaverNormalizeVisitor.class.getName() + " for non-OCL " + resource.getClass().getName());
		}
	}

	public void normalizeContents() {
		List<@NonNull EObject> allContents = new ArrayList<>();
		for (@NonNull TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Visitable) {
				allContents.add(eObject);
			}
		}
		Map<EClass, @NonNull ASSaverNormalizeVisitor> eClass2normalizeVisitor = new HashMap<>();
		for (@NonNull EObject eObject : allContents) {
			EClass eClass = eObject.eClass();
			ASSaverNormalizeVisitor normalizeVisitor = eClass2normalizeVisitor.get(eClass);
			if (normalizeVisitor == null) {
				normalizeVisitor = getNormalizeVisitor(eObject);
				eClass2normalizeVisitor.put(eClass, normalizeVisitor);
			}
			normalizeVisitor.safeVisit((Visitable) eObject);
		}
	}
}