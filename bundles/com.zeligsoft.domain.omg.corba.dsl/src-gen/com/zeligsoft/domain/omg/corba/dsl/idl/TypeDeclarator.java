/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getDeclarators <em>Declarators</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getTypeDeclarator()
 * @model
 * @generated
 */
public interface TypeDeclarator extends TypeDecl {
	/**
	 * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' containment reference list.
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getTypeDeclarator_Comments()
	 * @model containment="true"
	 * @generated
	 */
	EList<IDLComment> getComments();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeSpec)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getTypeDeclarator_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpec getType();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeSpec value);

	/**
	 * Returns the value of the '<em><b>Declarators</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.Declarator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarators</em>' containment reference list.
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getTypeDeclarator_Declarators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declarator> getDeclarators();

} // TypeDeclarator
