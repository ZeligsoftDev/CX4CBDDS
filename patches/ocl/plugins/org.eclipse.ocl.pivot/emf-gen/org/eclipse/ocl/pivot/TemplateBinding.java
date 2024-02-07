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

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A TemplateBinding is a DirectedRelationship between a TemplateableElement and a template. A TemplateBinding specifies the TemplateParameterSubstitutions of actual parameters for the formal parameters of the template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateBinding#getOwnedSubstitutions <em>Owned Substitutions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateBinding#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateBinding#getTemplateSignature <em>Template Signature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateBinding()
 * @generated
 */
public interface TemplateBinding
		extends Element {

	/**
	 * Returns the value of the '<em><b>Owned Substitutions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.TemplateParameterSubstitution}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningBinding <em>Owning Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TemplateParameterSubstitutions owned by this TemplateBinding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Substitutions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateBinding_OwnedSubstitutions()
	 * @see org.eclipse.ocl.pivot.TemplateParameterSubstitution#getOwningBinding
	 * @generated
	 */
	List<TemplateParameterSubstitution> getOwnedSubstitutions();

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateableElement#getOwnedBindings <em>Owned Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TemplateableElement that is bound by this TemplateBinding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(TemplateableElement)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateBinding_OwningElement()
	 * @see org.eclipse.ocl.pivot.TemplateableElement#getOwnedBindings
	 * @generated
	 */
	TemplateableElement getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateBinding#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(TemplateableElement value);

	/**
	 * Returns the value of the '<em><b>Template Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TemplateSignature for the template that is the target of this TemplateBinding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template Signature</em>' reference.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateBinding_TemplateSignature()
	 * @generated
	 */
	TemplateSignature getTemplateSignature();

} // TemplateBinding
