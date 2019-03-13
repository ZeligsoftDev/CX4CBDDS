/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsLocal <em>Is Local</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getSpecializes <em>Specializes</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_header()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface Interface_header extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_header_IsAbstract()
	 * @model
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Local</em>' attribute.
	 * @see #setIsLocal(boolean)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_header_IsLocal()
	 * @model
	 * @generated
	 */
	boolean isIsLocal();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsLocal <em>Is Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Local</em>' attribute.
	 * @see #isIsLocal()
	 * @generated
	 */
	void setIsLocal(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_header_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Specializes</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializes</em>' containment reference list.
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_header_Specializes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ScopedName> getSpecializes();

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
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterface_header_Comments()
	 * @model containment="true"
	 * @generated
	 */
	EList<IDLComment> getComments();

} // Interface_header
