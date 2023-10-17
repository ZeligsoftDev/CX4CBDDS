/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.MapTypeParameters;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CompleteClass#getPartialClasses <em>Partial Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteClass()
 * @generated
 */
public interface CompleteClass extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Owning Complete Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClasses <em>Owned Complete Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #setOwningCompletePackage(CompletePackage)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteClass_OwningCompletePackage()
	 * @see org.eclipse.ocl.pivot.CompletePackage#getOwnedCompleteClasses
	 * @generated
	 */
	CompletePackage getOwningCompletePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #getOwningCompletePackage()
	 * @generated
	 */
	void setOwningCompletePackage(CompletePackage value);

	/**
	 * Returns the value of the '<em><b>Partial Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Classes</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCompleteClass_PartialClasses()
	 * @generated
	 */
	@NonNull List<org.eclipse.ocl.pivot.Class> getPartialClasses();

	boolean conformsTo(@NonNull Type elementType);
	boolean conformsTo(@NonNull CompleteClass thatCompleteClass);

	org.eclipse.ocl.pivot.@NonNull Class getPrimaryClass();

	@Nullable CollectionType findCollectionType(@NonNull CollectionTypeParameters<@NonNull Type> typeParameters);
	@Nullable MapType findMapType(@NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters);
	@NonNull CollectionType getCollectionType(@NonNull CollectionTypeParameters<@NonNull Type> typeParameters);
	org.eclipse.ocl.pivot.@Nullable Class getBehavioralClass();
	@NonNull CompleteInheritance getCompleteInheritance();
	@NonNull MapType getMapType(@NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters);
	@Nullable Operation getOperation(@NonNull OperationId operationId);
	@Nullable Operation getOperation(@NonNull Operation operationId);
	@Nullable Iterable<@NonNull Operation> getOperationOverloads(@NonNull Operation pivotOperation);
	@NonNull Iterable<@NonNull Operation> getOperations(final @Nullable FeatureFilter featureFilter);
	@NonNull Iterable<@NonNull Operation> getOperations(final @Nullable FeatureFilter featureFilter, @Nullable String name);
	@NonNull Iterable<@NonNull CompleteClass> getProperSuperCompleteClasses();
	@Nullable Iterable<@NonNull Property> getProperties(@NonNull Property pivotProperty);
	@Nullable Iterable<@NonNull Property> getProperties(@Nullable String propertyName);
	@NonNull Iterable<@NonNull Property> getProperties(final @Nullable FeatureFilter featureFilter);
	@NonNull Iterable<@NonNull Property> getProperties(final @Nullable FeatureFilter featureFilter, @Nullable String name);
	@Nullable Property getProperty(@Nullable String propertyName);
	@NonNull Iterable<@NonNull State>  getStates();
	@NonNull Iterable<@NonNull State>  getStates(@Nullable String name);
	@NonNull Iterable<@NonNull CompleteClass> getSuperCompleteClasses();
} // CompleteClass
