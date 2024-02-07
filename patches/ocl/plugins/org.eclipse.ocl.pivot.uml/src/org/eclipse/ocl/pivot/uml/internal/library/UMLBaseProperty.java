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
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.BaseProperty;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class UMLBaseProperty extends BaseProperty
{
	public UMLBaseProperty(@NonNull Property property) {
		super(property);
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		if (sourceValue instanceof ElementExtension) {
			return ((ElementExtension)sourceValue).eContainer(); 
		}
		if (sourceValue instanceof UMLElementExtension) {
			return ((UMLElementExtension)sourceValue).getTarget(); 
		}
		return super.evaluate(executor, returnTypeId, sourceValue);
	}
}