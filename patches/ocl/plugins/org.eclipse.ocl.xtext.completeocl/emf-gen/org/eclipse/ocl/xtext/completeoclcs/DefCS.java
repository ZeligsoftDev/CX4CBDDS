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
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Def CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract DefCS identifies the common functionality of additional Operation or Property
 * definitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwnedSpecification <em>Owned Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwningClassifierContextDecl <em>Owning Classifier Context Decl</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getDefCS()
 * @model abstract="true"
 * @generated
 */
public interface DefCS
		extends TypedElementCS {

	/**
	 * Returns the value of the '<em><b>Owning Classifier Context Decl</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedDefinitions <em>Owned Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier Context Decl</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class context identifying the class for this additional definition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Classifier Context Decl</em>' container reference.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getDefCS_OwningClassifierContextDecl()
	 * @see org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedDefinitions
	 * @model opposite="ownedDefinitions" transient="false" changeable="false"
	 * @generated
	 */
	ClassifierContextDeclCS getOwningClassifierContextDecl();

	/**
	 * Returns the value of the '<em><b>Owned Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OCL specification for the Operation body of Property default value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Specification</em>' containment reference.
	 * @see #setOwnedSpecification(ExpSpecificationCS)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getDefCS_OwnedSpecification()
	 * @model containment="true"
	 * @generated
	 */
	ExpSpecificationCS getOwnedSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwnedSpecification <em>Owned Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Specification</em>' containment reference.
	 * @see #getOwnedSpecification()
	 * @generated
	 */
	void setOwnedSpecification(ExpSpecificationCS value);

	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this Oeration or Property definition is for a static feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getDefCS_IsStatic()
	 * @model
	 * @generated
	 */
	boolean isIsStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#isIsStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isIsStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

} // DefCS
