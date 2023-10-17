/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.oclany;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * OclElementOclContentsProperty realizes the OclElement::oclContents library property.
 * @since 1.1
 */
public class OclElementOclContentsProperty extends AbstractProperty
{
	public static final @NonNull OclElementOclContentsProperty INSTANCE = new OclElementOclContentsProperty();

	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject object = asNavigableObject(sourceValue, "oclContents()", executor); //$NON-NLS-1$
    	Set<Object> collection = new HashSet<Object>();
		for (Object eContent : object.eContents()) {
			if (eContent != null) {
				collection.add(executor.getIdResolver().boxedValueOf(eContent));
			}
    	}
    	return createSetValue((CollectionTypeId)returnTypeId, collection);
	}
}
