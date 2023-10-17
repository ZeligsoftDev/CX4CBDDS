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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ExtensionProperty;
import org.eclipse.ocl.pivot.library.AbstractPolyOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * OclElementOclExtensionsOperation realises the OclElement::oclExtensions()
 * and OclElement::oclExtensions(stereotype) library operation.
 *
 * @since 1.18
 */
public class OclElementOclExtensionsOperation extends AbstractPolyOperation
{
	public static final @NonNull OclElementOclExtensionsOperation INSTANCE = new OclElementOclExtensionsOperation();

	protected @NonNull SetValue createASorESvalues(@Nullable List<@NonNull ElementExtension> selectedExtensions, @NonNull CollectionTypeId collectionTypeId, boolean isAS) {
		if (selectedExtensions == null) {
			return ValueUtil.createSetOfEach(collectionTypeId);
		}
		else if (isAS) {
			return ValueUtil.createSetValue(collectionTypeId, selectedExtensions);
		}
		else {
			List<@NonNull EObject> esExtensions = new ArrayList<>(selectedExtensions.size());
			for (@NonNull ElementExtension selectedExtension : selectedExtensions) {
				EObject esObject = selectedExtension.getESObject();
				assert esObject != null;
				esExtensions.add(esObject);
			}
			return ValueUtil.createSetValue(collectionTypeId, esExtensions);
		}
	}

	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		assert sourceValue != null;
		Element asSource = ValueUtil.getASorASofES(executor, Element.class, sourceValue);
		List<@NonNull ElementExtension> selectedExtensions = ExtensionProperty.selectExtensions(executor, null, asSource);
		return createASorESvalues(selectedExtensions, (CollectionTypeId)returnTypeId, asSource == sourceValue);
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object stereotypeValue) {
		assert sourceValue != null;
		Element asSource = ValueUtil.getASorASofES(executor, Element.class, sourceValue);
		Stereotype asStereotype = stereotypeValue != null ? ValueUtil.getASorASofES(executor, Stereotype.class, stereotypeValue) : null;
		List<@NonNull ElementExtension> selectedExtensions = ExtensionProperty.selectExtensions(executor, asStereotype, asSource);
		return createASorESvalues(selectedExtensions, (CollectionTypeId)returnTypeId, asSource == sourceValue);
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		throw new InvalidValueException("too many arguments for oclExtensions()");
	}
}
