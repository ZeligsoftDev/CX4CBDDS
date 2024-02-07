/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * External2AS defines the common behaviour of an external (e.g. Ecore or UML) system to AS con version.
 */
public interface External2AS
{
	void dispose();

	/**
	 * Return the AS model that results from this conversion.
	 *
	 * FIXME Only the asResource is a tually needed, and only by UML support.
	 */
	@NonNull Model getASModel() throws ParserException;

	/**
	 * Return the AS element of type requiredClass corresponding to the external eOBJect, or null if none available.
	 */
	@Nullable <T extends Element> T getCreated(@NonNull Class<T> requiredClass, @NonNull EObject eObject);

	/**
	 * Return the map of all external objects to all AS elements.
	 */
	@Nullable Map<@NonNull EObject, @NonNull Element> getCreatedMap();

	/**
	 * Return the external resource.
	 */
	@Nullable Resource getResource();

	/**
	 * Return the URI of the external resource.
	 */
	@NonNull URI getURI();
}