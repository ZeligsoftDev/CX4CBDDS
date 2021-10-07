/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getExtensibility <em>Extensibility</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getSwitch <em>Switch</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getUnionType()
 * @model
 * @generated
 */
public interface UnionType extends TypeDecl, ConstrTypeSpec
{
  /**
   * Returns the value of the '<em><b>Extensibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extensibility</em>' attribute.
   * @see #setExtensibility(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getUnionType_Extensibility()
   * @model
   * @generated
   */
  String getExtensibility();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getExtensibility <em>Extensibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extensibility</em>' attribute.
   * @see #getExtensibility()
   * @generated
   */
  void setExtensibility(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getUnionType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getName <em>Name</em>}' attribute.
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
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getUnionType_Comments()
   * @model containment="true"
   * @generated
   */
  EList<IDLComment> getComments();

  /**
   * Returns the value of the '<em><b>Switch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Switch</em>' containment reference.
   * @see #setSwitch(SwitchTypeSpec)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getUnionType_Switch()
   * @model containment="true"
   * @generated
   */
  SwitchTypeSpec getSwitch();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getSwitch <em>Switch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Switch</em>' containment reference.
   * @see #getSwitch()
   * @generated
   */
  void setSwitch(SwitchTypeSpec value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(SwitchBody)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getUnionType_Body()
   * @model containment="true"
   * @generated
   */
  SwitchBody getBody();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(SwitchBody value);

} // UnionType
