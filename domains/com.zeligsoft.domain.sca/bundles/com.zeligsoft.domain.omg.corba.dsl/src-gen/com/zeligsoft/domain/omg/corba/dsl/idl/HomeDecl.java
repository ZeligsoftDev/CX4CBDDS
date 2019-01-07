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
 * A representation of the model object '<em><b>Home Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getBase <em>Base</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getSupports <em>Supports</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getManages <em>Manages</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getPrimary_key <em>Primary key</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getExport <em>Export</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl()
 * @model
 * @generated
 */
public interface HomeDecl extends Definition, TemplateDefinition, FixedDefinition {
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
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Comments()
	 * @model containment="true"
	 * @generated
	 */
	EList<IDLComment> getComments();

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
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' containment reference.
	 * @see #setBase(ScopedName)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Base()
	 * @model containment="true"
	 * @generated
	 */
	ScopedName getBase();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getBase <em>Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' containment reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(ScopedName value);

	/**
	 * Returns the value of the '<em><b>Supports</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supports</em>' containment reference list.
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Supports()
	 * @model containment="true"
	 * @generated
	 */
	EList<ScopedName> getSupports();

	/**
	 * Returns the value of the '<em><b>Manages</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manages</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manages</em>' containment reference.
	 * @see #setManages(ScopedName)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Manages()
	 * @model containment="true"
	 * @generated
	 */
	ScopedName getManages();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getManages <em>Manages</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manages</em>' containment reference.
	 * @see #getManages()
	 * @generated
	 */
	void setManages(ScopedName value);

	/**
	 * Returns the value of the '<em><b>Primary key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary key</em>' containment reference.
	 * @see #setPrimary_key(PrimaryKeySpec)
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Primary_key()
	 * @model containment="true"
	 * @generated
	 */
	PrimaryKeySpec getPrimary_key();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getPrimary_key <em>Primary key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary key</em>' containment reference.
	 * @see #getPrimary_key()
	 * @generated
	 */
	void setPrimary_key(PrimaryKeySpec value);

	/**
	 * Returns the value of the '<em><b>Export</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export</em>' containment reference list.
	 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getHomeDecl_Export()
	 * @model containment="true"
	 * @generated
	 */
	EList<HomeExport> getExport();

} // HomeDecl
