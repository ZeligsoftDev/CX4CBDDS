/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an Element or set of Elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getConstrainedElements <em>Constrained Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#isIsCallable <em>Is Callable</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getOwnedSpecification <em>Owned Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getOwningPostContext <em>Owning Post Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getOwningPreContext <em>Owning Pre Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getOwningState <em>Owning State</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getOwningTransition <em>Owning Transition</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Constraint#getRedefinedConstraints <em>Redefined Constraints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint()
 * @generated
 */
public interface Constraint
extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Constrained Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered set of Elements referenced by this Constraint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constrained Elements</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_ConstrainedElements()
	 * @generated
	 */
	@NonNull List<Element> getConstrainedElements();

	/**
	 * Returns the value of the '<em><b>Owned Specification</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.LanguageExpression#getOwningConstraint <em>Owning Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A condition that must be true when evaluated in order for the Constraint to be satisfied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Specification</em>' containment reference.
	 * @see #setOwnedSpecification(LanguageExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_OwnedSpecification()
	 * @see org.eclipse.ocl.pivot.LanguageExpression#getOwningConstraint
	 * @generated
	 */
	LanguageExpression getOwnedSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Constraint#getOwnedSpecification <em>Owned Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Specification</em>' containment reference.
	 * @see #getOwnedSpecification()
	 * @generated
	 */
	void setOwnedSpecification(LanguageExpression value);

	/**
	 * Returns the value of the '<em><b>Owning Post Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Operation#getOwnedPostconditions <em>Owned Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Post Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Post Context</em>' container reference.
	 * @see #setOwningPostContext(Operation)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_OwningPostContext()
	 * @see org.eclipse.ocl.pivot.Operation#getOwnedPostconditions
	 * @generated
	 */
	Operation getOwningPostContext();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Constraint#getOwningPostContext <em>Owning Post Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Post Context</em>' container reference.
	 * @see #getOwningPostContext()
	 * @generated
	 */
	void setOwningPostContext(Operation value);

	/**
	 * Returns the value of the '<em><b>Owning Pre Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Operation#getOwnedPreconditions <em>Owned Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Pre Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Pre Context</em>' container reference.
	 * @see #setOwningPreContext(Operation)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_OwningPreContext()
	 * @see org.eclipse.ocl.pivot.Operation#getOwnedPreconditions
	 * @generated
	 */
	Operation getOwningPreContext();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Constraint#getOwningPreContext <em>Owning Pre Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Pre Context</em>' container reference.
	 * @see #getOwningPreContext()
	 * @generated
	 */
	void setOwningPreContext(Operation value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_Context()
	 * @generated
	 */
	Namespace getContext();

	/**
	 * Returns the value of the '<em><b>Is Callable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Callable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Callable</em>' attribute.
	 * @see #setIsCallable(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_IsCallable()
	 * @generated
	 */
	boolean isIsCallable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Constraint#isIsCallable <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Callable</em>' attribute.
	 * @see #isIsCallable()
	 * @generated
	 */
	void setIsCallable(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.State#getOwnedStateInvariant <em>Owned State Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning State</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning State</em>' container reference.
	 * @see #setOwningState(State)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_OwningState()
	 * @see org.eclipse.ocl.pivot.State#getOwnedStateInvariant
	 * @generated
	 */
	State getOwningState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Constraint#getOwningState <em>Owning State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning State</em>' container reference.
	 * @see #getOwningState()
	 * @generated
	 */
	void setOwningState(State value);

	/**
	 * Returns the value of the '<em><b>Owning Transition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Transition#getOwnedGuard <em>Owned Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transition</em>' container reference.
	 * @see #setOwningTransition(Transition)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_OwningTransition()
	 * @see org.eclipse.ocl.pivot.Transition#getOwnedGuard
	 * @generated
	 */
	Transition getOwningTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Constraint#getOwningTransition <em>Owning Transition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transition</em>' container reference.
	 * @see #getOwningTransition()
	 * @generated
	 */
	void setOwningTransition(Transition value);

	/**
	 * Returns the value of the '<em><b>Redefined Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefined Constraints</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConstraint_RedefinedConstraints()
	 * @generated
	 */
	List<Constraint> getRedefinedConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.7
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateBooleanValued(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Constraint
