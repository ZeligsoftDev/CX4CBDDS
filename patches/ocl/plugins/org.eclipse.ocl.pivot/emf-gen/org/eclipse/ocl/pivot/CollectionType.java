/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionType#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionType#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.CollectionType#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionType()
 * @generated
 */
public interface CollectionType extends IterableType {

	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionType_ElementType()
	 * @generated
	 */
	Type getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionType#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(Type value);

	/**
	 * Returns the value of the '<em><b>Is Null Free</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Null Free</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Null Free</em>' attribute.
	 * @see #setIsNullFree(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionType_IsNullFree()
	 * @generated
	 */
	boolean isIsNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionType#isIsNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Null Free</em>' attribute.
	 * @see #isIsNullFree()
	 * @generated
	 */
	void setIsNullFree(boolean value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(Number)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionType_Lower()
	 * @generated
	 */
	Number getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionType#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(Number value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The default value is <code>"*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(Number)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getCollectionType_Upper()
	 * @generated
	 */
	Number getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.CollectionType#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(Number value);

	void setLowerValue(@NonNull IntegerValue lower);
	void setUpperValue(@NonNull UnlimitedNaturalValue upper);

	org.eclipse.ocl.pivot.@NonNull Class getContainerType();
	@NonNull IntegerValue getLowerValue();
	@Override
	@NonNull CollectionTypeId getTypeId();
	@NonNull UnlimitedNaturalValue getUpperValue();
} // CollectionType
