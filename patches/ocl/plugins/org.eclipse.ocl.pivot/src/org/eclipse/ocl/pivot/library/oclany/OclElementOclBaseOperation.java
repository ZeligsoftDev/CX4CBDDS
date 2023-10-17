/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractPolyOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclElementOclBaseOperation realises the OclElement::oclBase()  and OclElement::oclBase(stereotype) library operations.
 *
 * @since 1.18
 */
public class OclElementOclBaseOperation extends AbstractPolyOperation
{
	public static final @NonNull OclElementOclBaseOperation INSTANCE = new OclElementOclBaseOperation();

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object typeValue) {
		assert sourceValue != null;
		assert typeValue != null;
		ElementExtension asElementExtension = ValueUtil.getASorASofES(executor, ElementExtension.class, sourceValue);
		Type asType = ValueUtil.getASorASofES(executor, Type.class, typeValue);
		Element asBase = asElementExtension.getBase();
		StandardLibrary standardLibrary = executor.getStandardLibrary();
		Type baseType = (Type)asBase; //executor.getIdResolver().getDynamicTypeOf(asBase);
		boolean result = baseType.conformsTo(standardLibrary, asType);	// FIXME this can fail because ExecutableStandardLibrary.getMetaclass is bad
		if (!result) {
			return null;
		}
		else if (asElementExtension == sourceValue) {
			return asBase;
		}
		else {
			return asBase.getESObject();
		}
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		assert sourceValue != null;
		ElementExtension asElementExtension = ValueUtil.getASorASofES(executor, ElementExtension.class, sourceValue);
		Element asBase = asElementExtension.getBase();
		if (asElementExtension == sourceValue) {
			return asBase;
		}
		else {
			return asBase.getESObject();
		}
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		throw new InvalidValueException("too many arguments for oclBase()");
	}
}
