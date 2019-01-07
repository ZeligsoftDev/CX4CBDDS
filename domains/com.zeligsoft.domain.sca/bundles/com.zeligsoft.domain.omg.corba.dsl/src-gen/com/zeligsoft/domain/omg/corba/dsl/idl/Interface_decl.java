/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getHeader <em>Header</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getInterfaceBody <em>Interface Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_decl()
 * @model
 * @generated
 */
public interface Interface_decl extends Interface_or_Forward_Decl, TemplateDefinition, FixedDefinition {
	/**
	 * Returns the value of the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' containment reference.
	 * @see #setHeader(Interface_header)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_decl_Header()
	 * @model containment="true"
	 * @generated
	 */
	Interface_header getHeader();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getHeader <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' containment reference.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(Interface_header value);

	/**
	 * Returns the value of the '<em><b>Interface Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Body</em>' containment reference.
	 * @see #setInterfaceBody(InterfaceBody)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_decl_InterfaceBody()
	 * @model containment="true"
	 * @generated
	 */
	InterfaceBody getInterfaceBody();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getInterfaceBody <em>Interface Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Body</em>' containment reference.
	 * @see #getInterfaceBody()
	 * @generated
	 */
	void setInterfaceBody(InterfaceBody value);

} // Interface_decl
