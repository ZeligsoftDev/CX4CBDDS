/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getSequenceType()
 * @model
 * @generated
 */
public interface SequenceType extends TemplateTypeSpec, FormalParameterType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(SimpleTypeSpec)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getSequenceType_Type()
	 * @model containment="true"
	 * @generated
	 */
	SimpleTypeSpec getType();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SimpleTypeSpec value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(PositiveIntConst)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getSequenceType_Size()
	 * @model containment="true"
	 * @generated
	 */
	PositiveIntConst getSize();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(PositiveIntConst value);

} // SequenceType
