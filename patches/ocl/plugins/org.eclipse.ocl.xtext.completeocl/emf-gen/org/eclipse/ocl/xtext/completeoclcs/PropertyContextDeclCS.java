/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getOwnedDefaultExpressions <em>Owned Default Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getOwnedDerivedInvariants <em>Owned Derived Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getPropertyContextDeclCS()
 * @model
 * @generated
 */
public interface PropertyContextDeclCS
extends FeatureContextDeclCS {

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getPropertyContextDeclCS_ReferredProperty()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Returns the value of the '<em><b>Owned Default Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Default Expressions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getPropertyContextDeclCS_OwnedDefaultExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpSpecificationCS> getOwnedDefaultExpressions();

	/**
	 * Returns the value of the '<em><b>Owned Derived Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Derived Invariants</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getPropertyContextDeclCS_OwnedDerivedInvariants()
	 * @model containment="true"
	 * @generated
	 */
	@Deprecated /* @deprecated See Bug 543608; there are no Propoerty invariants */
	EList<ConstraintCS> getOwnedDerivedInvariants();

} // PropertyContextDeclCS
