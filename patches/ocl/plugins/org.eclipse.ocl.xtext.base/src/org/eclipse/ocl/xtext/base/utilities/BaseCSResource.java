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
package org.eclipse.ocl.xtext.base.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;

/**
 * BaseResource defines the Xtext-dependent extended interface for a Concrete Syntax resource.
 */
public interface BaseCSResource extends CSResource.CSResourceExtension2
{
	/**
	 * Add the unresolved reference message for EReference in EObject at INode.
	 */
	void createAndAddDiagnostic(Triple<EObject, EReference, INode> triple);

	/**
	 * Create the AS2CS converter for the cs2asResourceMap conversions using metamodelManager.
	 */
	@NonNull AS2CS createAS2CS(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap, @NonNull EnvironmentFactoryInternal environmentFactory);

	/**
	 * Create the CS2AS converter for the cs2asResourceMap conversions using metamodelManager.
	 */
	@NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource);

	/**
	 * Return the CS2AS adapter for this resource, or null if none in use.
	 */

	@Nullable CS2AS findCS2AS();

	/**
	 * Return the eContentType to be used when creating an AS resource.
	 */
	@NonNull String getASContentType();

	/**
	 * Return the Abstract Syntax URI for the given Concrete Syntax URI.
	 */
	@NonNull URI getASURI(@NonNull URI csURI);

	@NonNull CS2AS getCS2AS();

	/**
	 * Return the CS2AS adapter for this resource.
	 * If no CS2AS adapter installed, one is created and installed using the provided metamodelManager,
	 * which if null is also created.
	 */
	@NonNull CS2AS getCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource);

	/**
	 * Return the name of the editor for use in diagnostics.
	 */
	@NonNull String getEditorName();

	/**
	 * Return a non-null NamedElement if element is able to be accessed by a qualified path; Other elements must use a quoted URI.
	 */
	@Nullable NamedElement isPathable(@NonNull EObject element);

	/**
	 * Return a uri against the URI of this CS resource.
	 */
	@NonNull URI resolve(@NonNull URI uri);

	void update(@NonNull IDiagnosticConsumer diagnosticsConsumer);
}
