/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * Technology instances encapsulate behaviour that varies according to the metamodel technologies in use.
 * At present this means just-Ecore supported by an EcoreTechnology or Ecore-and-UML supported
 * by a UMLEcoreTechnology.
 *
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Technology
{
	@NonNull LibraryProperty createBasePropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property);

	// See Bug 458394 for the need for the asNavigationExp argument.
	@NonNull LibraryProperty createExplicitNavigationPropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory,
			@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property);

	@NonNull LibraryProperty createExtensionPropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property);

	@NonNull IdResolver createIdResolver(@NonNull EnvironmentFactoryInternal environmentFactory);

	@NonNull LibraryProperty createStereotypePropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property);

	String getExtensionName(@NonNull Element asStereotypedElement);

	RootPackageId getMetamodelId(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EPackage eObject2);

	@NonNull PackageId getMetapackageId(@NonNull EnvironmentFactoryInternal environmentFactory, org.eclipse.ocl.pivot.@NonNull Package asPackage);

	@Nullable String getOriginalName(@NonNull ENamedElement eNamedElement);

	@Nullable Element getParseableElement(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EObject eObject) throws ParserException;

	boolean isStereotype(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EClass eClass);

	boolean isValidatable(@NonNull EClass eClass);
}
