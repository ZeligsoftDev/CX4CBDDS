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
package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedMultiplicity <em>Owned Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedSubstitutions <em>Owned Substitutions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateBindingCS()
 * @model
 * @generated
 */
public interface TemplateBindingCS extends ElementRefCS {
	/**
	 * Returns the value of the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Multiplicity</em>' containment reference.
	 * @see #setOwnedMultiplicity(MultiplicityCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateBindingCS_OwnedMultiplicity()
	 * @model containment="true"
	 * @generated
	 */
	MultiplicityCS getOwnedMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedMultiplicity <em>Owned Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Multiplicity</em>' containment reference.
	 * @see #getOwnedMultiplicity()
	 * @generated
	 */
	void setOwnedMultiplicity(MultiplicityCS value);

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedBinding <em>Owned Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Bindable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(TypedTypeRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateBindingCS_OwningElement()
	 * @see org.eclipse.ocl.xtext.basecs.TypedTypeRefCS#getOwnedBinding
	 * @model opposite="ownedBinding" transient="false"
	 * @generated
	 */
	TypedTypeRefCS getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(TypedTypeRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Substitutions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwningBinding <em>Owning Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter Substitution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Substitutions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateBindingCS_OwnedSubstitutions()
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwningBinding
	 * @model opposite="owningBinding" containment="true"
	 * @generated
	 */
	EList<TemplateParameterSubstitutionCS> getOwnedSubstitutions();

} // TemplateBindingCS
