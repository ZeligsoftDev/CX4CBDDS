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

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Template Signature bundles the set of formal TemplateParameters for a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateSignature#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.TemplateSignature#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateSignature()
 * @generated
 */
public interface TemplateSignature
		extends Element {

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.TemplateParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateParameter#getOwningSignature <em>Owning Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal parameters that are owned by this TemplateSignature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateSignature_OwnedParameters()
	 * @see org.eclipse.ocl.pivot.TemplateParameter#getOwningSignature
	 * @generated
	 */
	@NonNull List<TemplateParameter> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.TemplateableElement#getOwnedSignature <em>Owned Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TemplateableElement that owns this TemplateSignature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(TemplateableElement)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTemplateSignature_OwningElement()
	 * @see org.eclipse.ocl.pivot.TemplateableElement#getOwnedSignature
	 * @generated
	 */
	TemplateableElement getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.TemplateSignature#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(TemplateableElement value);

} // TemplateSignature
