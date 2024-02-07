/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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
 * A representation of the model object '<em><b>Applied Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.ElementExtension#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ElementExtension#isIsApplied <em>Is Applied</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ElementExtension#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ElementExtension#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getElementExtension()
 * @generated
 */
public interface ElementExtension extends org.eclipse.ocl.pivot.Class
{
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' reference.
	 * @see #setStereotype(Stereotype)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElementExtension_Stereotype()
	 * @generated
	 */
	Stereotype getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ElementExtension#getStereotype <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Base</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Element#getOwnedExtensions <em>Owned Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' container reference.
	 * @see #setBase(Element)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElementExtension_Base()
	 * @see org.eclipse.ocl.pivot.Element#getOwnedExtensions
	 * @generated
	 */
	Element getBase();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ElementExtension#getBase <em>Base</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' container reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(Element value);

	/**
	 * Returns the value of the '<em><b>Is Applied</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Applied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Applied</em>' attribute.
	 * @see #setIsApplied(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElementExtension_IsApplied()
	 * @generated
	 */
	boolean isIsApplied();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ElementExtension#isIsApplied <em>Is Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Applied</em>' attribute.
	 * @see #isIsApplied()
	 * @generated
	 */
	void setIsApplied(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Required</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Required</em>' attribute.
	 * @see #setIsRequired(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getElementExtension_IsRequired()
	 * @generated
	 */
	boolean isIsRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ElementExtension#isIsRequired <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Required</em>' attribute.
	 * @see #isIsRequired()
	 * @generated
	 */
	void setIsRequired(boolean value);

} // ElementExtension
