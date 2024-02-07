/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Named Element Ref CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Pivotable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getOwningPathName <em>Owning Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getReferredElement <em>Referred Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPathElementCS()
 * @model
 * @generated
 */
public interface PathElementCS extends ElementCS, org.eclipse.ocl.pivot.utilities.Pivotable
{
	/**
	 * Returns the value of the '<em><b>Owning Path Name</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.PathNameCS#getOwnedPathElements <em>Owned Path Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Path Name</em>' container reference.
	 * @see #setOwningPathName(PathNameCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPathElementCS_OwningPathName()
	 * @see org.eclipse.ocl.xtext.basecs.PathNameCS#getOwnedPathElements
	 * @model opposite="ownedPathElements" required="true" transient="false"
	 * @generated
	 */
	PathNameCS getOwningPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getOwningPathName <em>Owning Path Name</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Path Name</em>' container reference.
	 * @see #getOwningPathName()
	 * @generated
	 */
	void setOwningPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Referred Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Element</em>' reference.
	 * @see #setReferredElement(Element)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPathElementCS_ReferredElement()
	 * @model required="true"
	 * @generated
	 */
	Element getReferredElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getReferredElement <em>Referred Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Element</em>' reference.
	 * @see #getReferredElement()
	 * @generated
	 */
	void setReferredElement(Element value);

	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(EClassifier)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getPathElementCS_ElementType()
	 * @model transient="true"
	 * @generated
	 */
	EClassifier getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.PathElementCS#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(EClassifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	Element basicGetReferredElement();

	boolean isType();

} // SimpleNamedElementRefCS
