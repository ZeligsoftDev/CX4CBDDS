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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS#getOwningSignature <em>Owning Signature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateParameterCS()
 * @model abstract="true"
 * @generated
 */
public interface TemplateParameterCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Signature</em>' container reference.
	 * @see #setOwningSignature(TemplateSignatureCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateParameterCS_OwningSignature()
	 * @see org.eclipse.ocl.xtext.basecs.TemplateSignatureCS#getOwnedParameters
	 * @model opposite="ownedParameters" required="true" transient="false"
	 * @generated
	 */
	TemplateSignatureCS getOwningSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterCS#getOwningSignature <em>Owning Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Signature</em>' container reference.
	 * @see #getOwningSignature()
	 * @generated
	 */
	void setOwningSignature(TemplateSignatureCS value);

} // TemplateParameterCS
