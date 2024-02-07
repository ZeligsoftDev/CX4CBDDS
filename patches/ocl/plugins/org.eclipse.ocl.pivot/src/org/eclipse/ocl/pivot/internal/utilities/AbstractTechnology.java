/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.library.BaseProperty;
import org.eclipse.ocl.pivot.internal.library.ExplicitNavigationProperty;
import org.eclipse.ocl.pivot.internal.library.ExtensionProperty;
import org.eclipse.ocl.pivot.internal.library.StereotypeProperty;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;

public abstract class AbstractTechnology implements Technology
{
	@Override
	public @NonNull LibraryProperty createBasePropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property) {
		return new BaseProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createExplicitNavigationPropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory,
			@Nullable Element asNavigationExp, @Nullable Object sourceValue, @NonNull Property property) {
		return new ExplicitNavigationProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createExtensionPropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property) {
		return new ExtensionProperty(property);
	}

	@Override
	public @NonNull LibraryProperty createStereotypePropertyImplementation(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Property property) {
		return new StereotypeProperty(property);
	}

	@Override
	public String getExtensionName(@NonNull Element asStereotypedElement) {
		String name = "????";
		if (asStereotypedElement instanceof NamedElement) {
			name = ((NamedElement)asStereotypedElement).getName();
		}
		return name;
	}

	@Override
	public @Nullable String getOriginalName(@NonNull ENamedElement eNamedElement) {
		return NameUtil.getOriginalName(eNamedElement);
	}

	@Override
	public @Nullable Element getParseableElement(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EObject eObject) throws ParserException {
		if (eObject instanceof Element) {
			return (Element) eObject;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean isValidatable(@NonNull EClass eClass) {
		return true;
	}
}
