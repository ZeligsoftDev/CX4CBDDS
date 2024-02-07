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
 * A representation of the model object '<em><b>Template Signature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateSignatureCS()
 * @model
 * @generated
 */
public interface TemplateSignatureCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TemplateableElementCS#getOwnedSignature <em>Owned Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see #setOwningElement(TemplateableElementCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateSignatureCS_OwningElement()
	 * @see org.eclipse.ocl.xtext.basecs.TemplateableElementCS#getOwnedSignature
	 * @model opposite="ownedSignature" transient="false"
	 * @generated
	 */
	TemplateableElementCS getOwningElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwningElement <em>Owning Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Element</em>' container reference.
	 * @see #getOwningElement()
	 * @generated
	 */
	void setOwningElement(TemplateableElementCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS#getOwningSignature <em>Owning Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Template Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateSignatureCS_OwnedParameters()
	 * @see org.eclipse.ocl.xtext.basecs.TemplateParameterCS#getOwningSignature
	 * @model opposite="owningSignature" containment="true"
	 * @generated
	 */
	EList<TemplateParameterCS> getOwnedParameters();

} // TemplateSignatureCS
