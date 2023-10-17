/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.LanguageExpression#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LanguageExpression#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LanguageExpression#getOwningConstraint <em>Owning Constraint</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getLanguageExpression()
 * @generated
 */
public interface LanguageExpression extends ValueSpecification
{
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLanguageExpression_Body()
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LanguageExpression#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLanguageExpression_Language()
	 * @generated
	 */
	String getLanguage();

	/**
	 * Returns the value of the '<em><b>Owning Constraint</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Constraint#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Constraint</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Constraint</em>' container reference.
	 * @see #setOwningConstraint(Constraint)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLanguageExpression_OwningConstraint()
	 * @see org.eclipse.ocl.pivot.Constraint#getOwnedSpecification
	 * @generated
	 */
	Constraint getOwningConstraint();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LanguageExpression#getOwningConstraint <em>Owning Constraint</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Constraint</em>' container reference.
	 * @see #getOwningConstraint()
	 * @generated
	 */
	void setOwningConstraint(Constraint value);

} // LanguageExpression
