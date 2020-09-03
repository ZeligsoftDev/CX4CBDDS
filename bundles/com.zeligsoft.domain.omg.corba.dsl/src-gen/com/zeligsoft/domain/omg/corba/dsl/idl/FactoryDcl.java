/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory Dcl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getParams <em>Params</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getRaises <em>Raises</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFactoryDcl()
 * @model
 * @generated
 */
public interface FactoryDcl extends HomeExport
{
  /**
   * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comments</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFactoryDcl_Comments()
   * @model containment="true"
   * @generated
   */
  EList<IDLComment> getComments();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFactoryDcl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference.
   * @see #setParams(ParameterDecls)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFactoryDcl_Params()
   * @model containment="true"
   * @generated
   */
  ParameterDecls getParams();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getParams <em>Params</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Params</em>' containment reference.
   * @see #getParams()
   * @generated
   */
  void setParams(ParameterDecls value);

  /**
   * Returns the value of the '<em><b>Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Raises</em>' containment reference.
   * @see #setRaises(ExceptionList)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFactoryDcl_Raises()
   * @model containment="true"
   * @generated
   */
  ExceptionList getRaises();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getRaises <em>Raises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Raises</em>' containment reference.
   * @see #getRaises()
   * @generated
   */
  void setRaises(ExceptionList value);

} // FactoryDcl
