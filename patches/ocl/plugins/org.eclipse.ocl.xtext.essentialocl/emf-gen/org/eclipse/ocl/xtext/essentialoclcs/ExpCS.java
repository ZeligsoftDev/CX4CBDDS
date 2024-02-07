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
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Expression CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#isHasError <em>Has Error</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalLeft <em>Local Left</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalLeftmostDescendant <em>Local Leftmost Descendant</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalParent <em>Local Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalRight <em>Local Right</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getLocalRightmostDescendant <em>Local Rightmost Descendant</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedenceOrder <em>Precedence Order</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS()
 * @model
 * @generated
 */
public interface ExpCS
extends ModelElementCS {

	/**
	 * Returns the value of the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Parent</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_LocalParent()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@Nullable OperatorExpCS getLocalParent();

	/**
	 * Returns the value of the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Right</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_LocalRight()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@Nullable ExpCS getLocalRight();

	/**
	 * Returns the value of the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Rightmost Descendant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Rightmost Descendant</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_LocalRightmostDescendant()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@NonNull ExpCS getLocalRightmostDescendant();

	/**
	 * Returns the value of the '<em><b>Has Error</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Error</em>' attribute.
	 * @see #setHasError(boolean)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_HasError()
	 * @model default="false" transient="true"
	 * @generated
	 */
	boolean isHasError();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#isHasError <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Error</em>' attribute.
	 * @see #isHasError()
	 * @generated
	 */
	void setHasError(boolean value);

	/**
	 * Returns the value of the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Left</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_LocalLeft()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@Nullable ExpCS getLocalLeft();

	/**
	 * Returns the value of the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Leftmost Descendant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Leftmost Descendant</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_LocalLeftmostDescendant()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	@NonNull ExpCS getLocalLeftmostDescendant();

	/**
	 * Returns the value of the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_Precedence()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if csExp is a transitive child of this in the logical expression tree containing this and csExp and only OperatorExpCS nodes within the tree.
	 * <!-- end-model-doc -->
	 * @model required="true" csExpRequired="true"
	 * @generated NOT
	 */
	boolean isLocalLeftAncestorOf(@NonNull ExpCS csExp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if this is a transitive child of csExp in the logical expression tree containing this and csExp and only OperatorExpCS nodes within the tree.
	 * <!-- end-model-doc -->
	 * @model required="true" csExpRequired="true"
	 * @generated NOT
	 */
	boolean isLocalRightAncestorOf(@NonNull ExpCS csExp);

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @deprecated not used - use setPrecedence(Precedence, int, AssociativityKind)
	 */
	@Deprecated
	void setPrecedence(Precedence value);

	/**
	 * Returns the value of the '<em><b>Precedence Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence Order</em>' attribute.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpCS_PrecedenceOrder()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getPrecedenceOrder();

	@Nullable OperatorExpCS getLocalLeftContainer();
	@Nullable OperatorExpCS getLocalRightContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpCS#getPrecedence <em>Precedence</em>}' reference.
	 */
	void setPrecedence(@Nullable Precedence precedence, int precedenceOrder);
} // ExpCS
