/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedMetaclass <em>Owned Metaclass</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedSuperTypes <em>Owned Super Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS()
 * @model
 * @generated
 */
public interface StructuredClassCS extends ClassCS, NamespaceCS {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS_IsAbstract()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Interface</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Interface</em>' attribute.
	 * @see #setIsInterface(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS_IsInterface()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#isIsInterface <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Interface</em>' attribute.
	 * @see #isIsInterface()
	 * @generated
	 */
	void setIsInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Super Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Super Types</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS_OwnedSuperTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedSuperTypes();

	/**
	 * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.OperationCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operations</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS_OwnedOperations()
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<OperationCS> getOwnedOperations();

	/**
	 * Returns the value of the '<em><b>Owned Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Properties</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS_OwnedProperties()
	 * @see org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<StructuralFeatureCS> getOwnedProperties();

	/**
	 * Returns the value of the '<em><b>Owned Metaclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Meta Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Metaclass</em>' containment reference.
	 * @see #setOwnedMetaclass(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuredClassCS_OwnedMetaclass()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedMetaclass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedMetaclass <em>Owned Metaclass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Metaclass</em>' containment reference.
	 * @see #getOwnedMetaclass()
	 * @generated
	 */
	void setOwnedMetaclass(TypedRefCS value);

} // ClassCS
