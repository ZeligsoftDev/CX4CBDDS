/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ExtensionProperty;

/**
 * An instance of UMLExtensionProperty supports evaluation of an implicit (unnavigable opposite) property
 * using the UMLElementExtension associated with the source. This is used by UML dynamic profiles.
 */
public class UMLExtensionProperty extends ExtensionProperty
{
	public UMLExtensionProperty(@NonNull Property property) {
		super(property);
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		Type staticType = property.getType();
		if (staticType == null) {
			return null;
		}
		if (sourceValue instanceof org.eclipse.uml2.uml.Element) {
			if (staticType instanceof Stereotype) {
				return UMLElementExtension.getUMLElementExtension((Stereotype)staticType, (org.eclipse.uml2.uml.Element)sourceValue);
			}
		}
		return super.evaluate(executor, returnTypeId, sourceValue);
	}
}