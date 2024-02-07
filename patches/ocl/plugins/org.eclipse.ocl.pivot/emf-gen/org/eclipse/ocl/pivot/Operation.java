/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Operation is a BehavioralFeature of a Classifier that specifies the name, type, parameters, and constraints for invoking an associated Behavior. An Operation may invoke both the execution of method behaviors as well as other behavioral responses. Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#isIsInvalidating <em>Is Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#isIsTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#isIsTypeof <em>Is Typeof</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#isIsValidating <em>Is Validating</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getOwnedPostconditions <em>Owned Postconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getOwnedPreconditions <em>Owned Preconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getRaisedExceptions <em>Raised Exceptions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Operation#getRedefinedOperations <em>Redefined Operations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation()
 * @generated
 */
public interface Operation extends Feature, Namespace, TemplateableElement {

	/**
	 * Returns the value of the '<em><b>Raised Exceptions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Types representing exceptions that may be raised during an invocation of this BehavioralFeature.
	 *
	 * The Types representing exceptions that may be raised during an invocation of this operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Raised Exceptions</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_RaisedExceptions()
	 * @generated
	 */
	@NonNull List<Type> getRaisedExceptions();

	/**
	 * Returns the value of the '<em><b>Redefined Operations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Operations that are redefined by this Operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined Operations</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_RedefinedOperations()
	 * @generated
	 */
	@NonNull List<Operation> getRedefinedOperations();

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Parameter#getOwningOperation <em>Owning Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered set of formal Parameters of this BehavioralFeature.
	 *
	 * The parameters owned by this Operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_OwnedParameters()
	 * @see org.eclipse.ocl.pivot.Parameter#getOwningOperation
	 * @generated
	 */
	@NonNull List<Parameter> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owned Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Constraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Constraint#getOwningPostContext <em>Owning Post Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints specifying the state of the system when the Operation is completed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Postconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_OwnedPostconditions()
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningPostContext
	 * @generated
	 */
	@NonNull List<Constraint> getOwnedPostconditions();

	/**
	 * Returns the value of the '<em><b>Owned Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Constraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Constraint#getOwningPreContext <em>Owning Pre Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional set of Constraints on the state of the system when the Operation is invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Preconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_OwnedPreconditions()
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningPreContext
	 * @generated
	 */
	@NonNull List<Constraint> getOwnedPreconditions();

	/**
	 * Returns the value of the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence</em>' reference.
	 * @see #setPrecedence(Precedence)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_Precedence()
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Precedence value);

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(LanguageExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_BodyExpression()
	 * @generated
	 */
	LanguageExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(LanguageExpression value);

	/**
	 * Returns the value of the '<em><b>Is Invalidating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Invalidating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this operation may return an invalid result for non-invalid (or invalid if also validating) inputs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Invalidating</em>' attribute.
	 * @see #setIsInvalidating(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_IsInvalidating()
	 * @generated
	 */
	boolean isIsInvalidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#isIsInvalidating <em>Is Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Invalidating</em>' attribute.
	 * @see #isIsInvalidating()
	 * @generated
	 */
	void setIsInvalidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_IsTransient()
	 * @generated
	 */
	boolean isIsTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#isIsTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isIsTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_IsTypeof()
	 * @generated
	 */
	boolean isIsTypeof();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#isIsTypeof <em>Is Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Typeof</em>' attribute.
	 * @see #isIsTypeof()
	 * @generated
	 */
	void setIsTypeof(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Validating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Validating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this operation may return a non-invalid result for invalid inputs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Validating</em>' attribute.
	 * @see #setIsValidating(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_IsValidating()
	 * @generated
	 */
	boolean isIsValidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#isIsValidating <em>Is Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Validating</em>' attribute.
	 * @see #isIsValidating()
	 * @generated
	 */
	void setIsValidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Class that owns this operation, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getOperation_OwningClass()
	 * @see org.eclipse.ocl.pivot.Class#getOwnedOperations
	 * @generated
	 */
	@Override
	org.eclipse.ocl.pivot.Class getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Operation#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(org.eclipse.ocl.pivot.Class value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleReturn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateLoadableImplementation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniquePreconditionName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniquePostconditionName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Return the index of this operation in the operation dispatch table.
	 */
	int getIndex();

	/**
	 * Return the Inheritance dispatch table for the owning type, or null for am orphan property owned by an Annotation.
	 */
	@Nullable CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary);

	@NonNull OperationId getOperationId();

	/**
	 * Return the unique identity of the ordered list of parameters of this operation.
	 */
	@NonNull ParametersId getParametersId();

	/**
	 * Return the ordered list of parameters of this operation.
	 */
	@NonNull ParameterTypes getParameterTypes();

	/**
	 * Return the ordered list of type parameters of this operation.
	 */
	@NonNull TemplateParameters getTypeParameters();
} // Operation
