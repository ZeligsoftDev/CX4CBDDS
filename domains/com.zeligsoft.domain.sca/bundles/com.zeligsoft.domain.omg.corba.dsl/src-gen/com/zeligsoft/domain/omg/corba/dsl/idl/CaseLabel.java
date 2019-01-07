/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsCase <em>Is Case</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#getConstExp <em>Const Exp</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsDefault <em>Is Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCaseLabel()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface CaseLabel extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Is Case</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Case</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Case</em>' attribute.
	 * @see #setIsCase(boolean)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCaseLabel_IsCase()
	 * @model
	 * @generated
	 */
	boolean isIsCase();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsCase <em>Is Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Case</em>' attribute.
	 * @see #isIsCase()
	 * @generated
	 */
	void setIsCase(boolean value);

	/**
	 * Returns the value of the '<em><b>Const Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const Exp</em>' containment reference.
	 * @see #setConstExp(ConstExp)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCaseLabel_ConstExp()
	 * @model containment="true"
	 * @generated
	 */
	ConstExp getConstExp();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#getConstExp <em>Const Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const Exp</em>' containment reference.
	 * @see #getConstExp()
	 * @generated
	 */
	void setConstExp(ConstExp value);

	/**
	 * Returns the value of the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Default</em>' attribute.
	 * @see #setIsDefault(boolean)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCaseLabel_IsDefault()
	 * @model
	 * @generated
	 */
	boolean isIsDefault();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsDefault <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Default</em>' attribute.
	 * @see #isIsDefault()
	 * @generated
	 */
	void setIsDefault(boolean value);

} // CaseLabel
