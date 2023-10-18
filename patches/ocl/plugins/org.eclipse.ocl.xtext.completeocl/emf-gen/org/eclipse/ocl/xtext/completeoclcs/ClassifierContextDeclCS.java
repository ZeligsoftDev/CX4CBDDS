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

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ClassifierContextDeclCS supports a class context which provides additional or
 * complementary declarations such as invariants and definitions for the referred class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedDefinitions <em>Owned Definitions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getOwnedInvariants <em>Owned Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS()
 * @model
 * @generated
 */
public interface ClassifierContextDeclCS
		extends ContextDeclCS, TemplateableElementCS {

	/**
	 * Returns the value of the '<em><b>Self Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional alternative spelling of 'self'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Self Name</em>' attribute.
	 * @see #setSelfName(String)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_SelfName()
	 * @model
	 * @generated
	 */
	String getSelfName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Name</em>' attribute.
	 * @see #getSelfName()
	 * @generated
	 */
	void setSelfName(String value);

	/**
	 * Returns the value of the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class for which this context provides additional detail.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Class</em>' reference.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_ReferredClass()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getReferredClass();

	/**
	 * Returns the value of the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The additional class invariants.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Invariants</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_OwnedInvariants()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedInvariants();

	/**
	 * Returns the value of the '<em><b>Owned Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.completeoclcs.DefCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwningClassifierContextDecl <em>Owning Classifier Context Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The additional operations and property definitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Definitions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getClassifierContextDeclCS_OwnedDefinitions()
	 * @see org.eclipse.ocl.xtext.completeoclcs.DefCS#getOwningClassifierContextDecl
	 * @model opposite="owningClassifierContextDecl" containment="true"
	 * @generated
	 */
	EList<DefCS> getOwnedDefinitions();

} // ClassifierContextDeclCS
