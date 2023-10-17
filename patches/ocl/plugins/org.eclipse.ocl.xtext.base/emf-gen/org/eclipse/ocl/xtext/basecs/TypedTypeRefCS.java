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

import org.eclipse.ocl.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#isIsTypeof <em>Is Typeof</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedBinding <em>Owned Binding</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedTypeRefCS()
 * @model
 * @generated
 */
public interface TypedTypeRefCS extends TypedRefCS {
	/**
	 * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #setOwnedPathName(PathNameCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedTypeRefCS_OwnedPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #getOwnedPathName()
	 * @generated
	 */
	void setOwnedPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Type</em>' reference.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedTypeRefCS_ReferredType()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getReferredType();

	/**
	 * Returns the value of the '<em><b>Owned Binding</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Template Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Binding</em>' containment reference.
	 * @see #setOwnedBinding(TemplateBindingCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedTypeRefCS_OwnedBinding()
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwningElement
	 * @model opposite="owningElement" containment="true"
	 * @generated
	 */
	TemplateBindingCS getOwnedBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedBinding <em>Owned Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Binding</em>' containment reference.
	 * @see #getOwnedBinding()
	 * @generated
	 */
	void setOwnedBinding(TemplateBindingCS value);

	/**
	 * Returns the value of the '<em><b>Is Typeof</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Typeof</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Typeof</em>' attribute.
	 * @see #setIsTypeof(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedTypeRefCS_IsTypeof()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean" required="true"
	 * @generated
	 */
	boolean isIsTypeof();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#isIsTypeof <em>Is Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Typeof</em>' attribute.
	 * @see #isIsTypeof()
	 * @generated
	 */
	void setIsTypeof(boolean value);

} // TypedTypeRefCS
