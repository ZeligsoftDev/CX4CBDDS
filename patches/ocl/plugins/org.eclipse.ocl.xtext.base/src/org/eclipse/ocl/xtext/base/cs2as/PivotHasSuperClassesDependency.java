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
package org.eclipse.ocl.xtext.base.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;

public class PivotHasSuperClassesDependency extends AbstractDependency<@NonNull TypedTypeRefCS>
{
	public PivotHasSuperClassesDependency(@NonNull TypedTypeRefCS csElement) {
		super(csElement);
	}

	@Override
	public boolean canExecute() {
		Type pivot = element.getReferredType();
		if (pivot == null) {
			return false;
		}
		Type type = pivot instanceof org.eclipse.ocl.pivot.Class ? PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.pivot.Class)pivot) : pivot;
		assert type == pivot;		// WIP
		if (type instanceof AnyType) {
			return true;
		}
		if ((type instanceof DataType) && !(type instanceof CollectionType)) {
			return true;
		}
		if (type instanceof InvalidType) {
			return true;
		}
		if (type instanceof VoidType) {
			return true;
		}
		if (type instanceof org.eclipse.ocl.pivot.Class) {
			List<org.eclipse.ocl.pivot.Class> superClasses = ((org.eclipse.ocl.pivot.Class)type).getSuperClasses();
			return !superClasses.isEmpty();
		}
		return false;
	}
}