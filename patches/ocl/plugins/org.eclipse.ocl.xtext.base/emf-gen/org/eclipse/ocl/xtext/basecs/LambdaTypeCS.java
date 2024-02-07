/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lambda Type CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedContextType <em>Owned Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedParameterTypes <em>Owned Parameter Types</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedResultType <em>Owned Result Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLambdaTypeCS()
 * @model
 * @generated
 */
public interface LambdaTypeCS extends TypedRefCS, TemplateableElementCS, org.eclipse.ocl.pivot.utilities.Nameable
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLambdaTypeCS_Name()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Context Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Context Type</em>' containment reference.
	 * @see #setOwnedContextType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLambdaTypeCS_OwnedContextType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedContextType <em>Owned Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Context Type</em>' containment reference.
	 * @see #getOwnedContextType()
	 * @generated
	 */
	void setOwnedContextType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter Types</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLambdaTypeCS_OwnedParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedParameterTypes();

	/**
	 * Returns the value of the '<em><b>Owned Result Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Result Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Result Type</em>' containment reference.
	 * @see #setOwnedResultType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLambdaTypeCS_OwnedResultType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedResultType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.LambdaTypeCS#getOwnedResultType <em>Owned Result Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Result Type</em>' containment reference.
	 * @see #getOwnedResultType()
	 * @generated
	 */
	void setOwnedResultType(TypedRefCS value);

} // LambdaTypeCS
