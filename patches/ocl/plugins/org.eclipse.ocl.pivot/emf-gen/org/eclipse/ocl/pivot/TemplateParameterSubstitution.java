/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A TemplateParameterSubstitution relates the actual parameter to a formal TemplateParameter as part of a template binding.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwnedWildcard <em>Owned Wildcard</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningBinding <em>Owning Binding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution()
 * @generated
 */
public interface TemplateParameterSubstitution
		extends Element {

	/**
	 * Returns the value of the '<em><b>Formal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal TemplateParameter that is associated with this TemplateParameterSubstitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Formal</em>' reference.
	 * @see #setFormal(TemplateParameter)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_Formal()
	 * @generated
	 */
	TemplateParameter getFormal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getFormal <em>Formal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formal</em>' reference.
	 * @see #getFormal()
	 * @generated
	 */
	void setFormal(TemplateParameter value);

	/**
	 * Returns the value of the '<em><b>Owned Wildcard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Wildcard</em>' containment reference.
	 * @see #setOwnedWildcard(WildcardType)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_OwnedWildcard()
	 * @generated
	 */
	WildcardType getOwnedWildcard();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwnedWildcard <em>Owned Wildcard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Wildcard</em>' containment reference.
	 * @see #getOwnedWildcard()
	 * @generated
	 */
	void setOwnedWildcard(WildcardType value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ParameterableElement that is the actual parameter for this TemplateParameterSubstitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actual</em>' reference.
	 * @see #setActual(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_Actual()
	 * @generated
	 */
	Type getActual();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getActual <em>Actual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' reference.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(Type value);

	/**
	 * Returns the value of the '<em><b>Owning Binding</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateBinding#getOwnedSubstitutions <em>Owned Substitutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TemplateBinding that owns this TemplateParameterSubstitution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Binding</em>' container reference.
	 * @see #setOwningBinding(TemplateBinding)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateParameterSubstitution_OwningBinding()
	 * @see org.eclipse.ocl.pivot.TemplateBinding#getOwnedSubstitutions
	 * @generated
	 */
	TemplateBinding getOwningBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningBinding <em>Owning Binding</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Binding</em>' container reference.
	 * @see #getOwningBinding()
	 * @generated
	 */
	void setOwningBinding(TemplateBinding value);

} // TemplateParameterSubstitution
