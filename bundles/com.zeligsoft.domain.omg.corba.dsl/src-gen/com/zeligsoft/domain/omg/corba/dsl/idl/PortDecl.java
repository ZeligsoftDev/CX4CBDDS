/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#isIsMirror <em>Is Mirror</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPortDecl()
 * @model
 * @generated
 */
public interface PortDecl extends ComponentExport, ConnectorExport
{
  /**
   * Returns the value of the '<em><b>Is Mirror</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Mirror</em>' attribute.
   * @see #setIsMirror(boolean)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPortDecl_IsMirror()
   * @model
   * @generated
   */
  boolean isIsMirror();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#isIsMirror <em>Is Mirror</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Mirror</em>' attribute.
   * @see #isIsMirror()
   * @generated
   */
  void setIsMirror(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(ScopedName)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPortDecl_Type()
   * @model containment="true"
   * @generated
   */
  ScopedName getType();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(ScopedName value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPortDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comments</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPortDecl_Comments()
   * @model containment="true"
   * @generated
   */
  EList<IDLComment> getComments();

} // PortDecl
