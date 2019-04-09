/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getGetRaises <em>Get Raises</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getSetRaises <em>Set Raises</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getAttrSpec()
 * @model
 * @generated
 */
public interface AttrSpec extends AttrDecl
{
  /**
   * Returns the value of the '<em><b>Get Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Get Raises</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Get Raises</em>' containment reference.
   * @see #setGetRaises(AttrRaisesExpr)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getAttrSpec_GetRaises()
   * @model containment="true"
   * @generated
   */
  AttrRaisesExpr getGetRaises();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getGetRaises <em>Get Raises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Get Raises</em>' containment reference.
   * @see #getGetRaises()
   * @generated
   */
  void setGetRaises(AttrRaisesExpr value);

  /**
   * Returns the value of the '<em><b>Set Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Set Raises</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set Raises</em>' containment reference.
   * @see #setSetRaises(AttrRaisesExpr)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getAttrSpec_SetRaises()
   * @model containment="true"
   * @generated
   */
  AttrRaisesExpr getSetRaises();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getSetRaises <em>Set Raises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set Raises</em>' containment reference.
   * @see #getSetRaises()
   * @generated
   */
  void setSetRaises(AttrRaisesExpr value);

} // AttrSpec
