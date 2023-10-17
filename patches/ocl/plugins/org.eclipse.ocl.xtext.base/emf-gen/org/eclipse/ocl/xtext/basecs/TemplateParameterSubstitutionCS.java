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
 * A representation of the model object '<em><b>Template Parameter Substitution CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwningBinding <em>Owning Binding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateParameterSubstitutionCS()
 * @model
 * @generated
 */
public interface TemplateParameterSubstitutionCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Binding</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedSubstitutions <em>Owned Substitutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Binding</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Binding</em>' container reference.
	 * @see #setOwningBinding(TemplateBindingCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateParameterSubstitutionCS_OwningBinding()
	 * @see org.eclipse.ocl.xtext.basecs.TemplateBindingCS#getOwnedSubstitutions
	 * @model opposite="ownedSubstitutions" transient="false"
	 * @generated
	 */
	TemplateBindingCS getOwningBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwningBinding <em>Owning Binding</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Binding</em>' container reference.
	 * @see #getOwningBinding()
	 * @generated
	 */
	void setOwningBinding(TemplateBindingCS value);

	/**
	 * Returns the value of the '<em><b>Formal Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Template Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formal Template Parameter</em>' reference.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateParameterSubstitutionCS_FormalTemplateParameter()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
//	TemplateParameterCS getFormalTemplateParameter();

	/**
	 * Returns the value of the '<em><b>Owned Actual Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Actual Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Actual Parameter</em>' containment reference.
	 * @see #setOwnedActualParameter(TypeRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTemplateParameterSubstitutionCS_OwnedActualParameter()
	 * @model containment="true"
	 * @generated
	 */
	TypeRefCS getOwnedActualParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Actual Parameter</em>' containment reference.
	 * @see #getOwnedActualParameter()
	 * @generated
	 */
	void setOwnedActualParameter(TypeRefCS value);

} // TemplateParameterSubstitutionCS
