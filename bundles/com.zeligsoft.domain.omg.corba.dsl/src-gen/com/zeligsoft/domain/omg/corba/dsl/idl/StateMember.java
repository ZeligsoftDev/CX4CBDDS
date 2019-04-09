/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#isIsPublic <em>Is Public</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getStateMember()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface StateMember extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Is Public</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Public</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Public</em>' attribute.
   * @see #setIsPublic(boolean)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getStateMember_IsPublic()
   * @model
   * @generated
   */
  boolean isIsPublic();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#isIsPublic <em>Is Public</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Public</em>' attribute.
   * @see #isIsPublic()
   * @generated
   */
  void setIsPublic(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(ParamTypeSpec)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getStateMember_Type()
   * @model containment="true"
   * @generated
   */
  ParamTypeSpec getType();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(ParamTypeSpec value);

  /**
   * Returns the value of the '<em><b>Names</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' attribute list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getStateMember_Names()
   * @model unique="false"
   * @generated
   */
  EList<String> getNames();

} // StateMember
