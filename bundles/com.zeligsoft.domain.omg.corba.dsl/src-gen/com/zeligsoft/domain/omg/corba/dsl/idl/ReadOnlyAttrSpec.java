/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Read Only Attr Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec#getRaises <em>Raises</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getReadOnlyAttrSpec()
 * @model
 * @generated
 */
public interface ReadOnlyAttrSpec extends AttrDecl {
	/**
	 * Returns the value of the '<em><b>Raises</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raises</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raises</em>' containment reference.
	 * @see #setRaises(AttrRaisesExpr)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getReadOnlyAttrSpec_Raises()
	 * @model containment="true"
	 * @generated
	 */
	AttrRaisesExpr getRaises();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec#getRaises <em>Raises</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raises</em>' containment reference.
	 * @see #getRaises()
	 * @generated
	 */
	void setRaises(AttrRaisesExpr value);

} // ReadOnlyAttrSpec
