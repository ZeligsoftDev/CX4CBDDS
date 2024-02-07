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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ExtensionProperty;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclElementOclExtensionOperation realises the OclElement::oclExtension(stereotype) library operation.
 *
 * @since 1.18
 */
public class OclElementOclExtensionOperation extends AbstractBinaryOperation
{
	public static final @NonNull OclElementOclExtensionOperation INSTANCE = new OclElementOclExtensionOperation();

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object stereotypeValue) {
		assert sourceValue != null;
		Element asSource = ValueUtil.getASorASofES(executor, Element.class, sourceValue);
		Stereotype asStereotype = stereotypeValue != null ? ValueUtil.getASorASofES(executor, Stereotype.class, stereotypeValue) : null;
		List<@NonNull ElementExtension> selectedExtensions = ExtensionProperty.selectExtensions(executor, asStereotype, asSource);
		if (selectedExtensions == null) {
			return null;
		}
		int size = selectedExtensions.size();
		if (size == 0) {
			return null;
		}
		if (size > 1) {
			throw new InvalidValueException("More than one Stereotype applied");
		}
		ElementExtension asExtension = selectedExtensions.get(0);
		if (asSource == sourceValue) {
			return asExtension;
		}
		else {
			return asExtension.getESObject();
		}
	}
}
