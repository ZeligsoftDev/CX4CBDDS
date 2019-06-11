/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preproc Include</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getValue <em>Value</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getStrValue <em>Str Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_Include()
 * @model
 * @generated
 */
public interface Preproc_Include extends Preproc
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(FileName)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_Include_Value()
   * @model containment="true"
   * @generated
   */
  FileName getValue();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(FileName value);

  /**
   * Returns the value of the '<em><b>Str Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Str Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Str Value</em>' attribute.
   * @see #setStrValue(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_Include_StrValue()
   * @model
   * @generated
   */
  String getStrValue();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getStrValue <em>Str Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Str Value</em>' attribute.
   * @see #getStrValue()
   * @generated
   */
  void setStrValue(String value);

} // Preproc_Include
