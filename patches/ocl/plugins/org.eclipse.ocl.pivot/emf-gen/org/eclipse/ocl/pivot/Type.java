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
package org.eclipse.ocl.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * @extends org.eclipse.ocl.pivot.values.OCLValue
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Type constrains the values represented by a TypedElement.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getType()
 * @generated
 */
public interface Type extends NamedElement, org.eclipse.ocl.pivot.values.OCLValue {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the type to be used as the element type when this is flattened. For most types this is self.
	 * For a CollectionType, it is the transitive element type.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	Type flattenedType();

	org.eclipse.ocl.pivot.@Nullable Class isClass();

	@Nullable TemplateParameter isTemplateParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Type specializeIn(CallExp expr, Type selfType);

	/**
	 * Return true if this type conform to thatType within standardLibrary.
	 */
	boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType);

	/**
	 * Return the most derived type common to this type and thatType within standardLibrary.
	 */
	@NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type thatType);

	/**
	 * Return the inheritance description for this type within standardLibrary.
	 */
	@NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary);

	/**
	 * Return the unique executable form of this type within standardLibrary.
	 */
	org.eclipse.ocl.pivot.@NonNull Class getNormalizedType(@NonNull StandardLibrary standardLibrary);

	/**
	 * Return a unique StandardLibrary-independent TemplateParameter-independent identifier for this type.
	 *
	 * @since 1.18
	 */
	default @NonNull TypeId getNormalizedTypeId() { return getTypeId(); }

	/**
	 * Return a unique StandardLibrary-independent identifier for this type.
	 */
	@NonNull TypeId getTypeId();

	/**
	 * Return true if this is the same type as thatType within standardLibrary.
	 */
	boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType);
	boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type);

	/**
	 * Return true if this is an invalid type (with an associated error message).
	 */
//	boolean isInvalid();

//	@NonNull Type specializeIn(@NonNull CallExp expr, @Nullable Type selfType);
} // Type
