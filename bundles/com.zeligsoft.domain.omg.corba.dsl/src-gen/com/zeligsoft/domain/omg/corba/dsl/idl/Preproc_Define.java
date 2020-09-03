/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preproc Define</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getValue <em>Value</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_Define()
 * @model
 * @generated
 */
public interface Preproc_Define extends Preproc
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_Define_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(ConstExp)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_Define_Exp()
   * @model containment="true"
   * @generated
   */
  ConstExp getExp();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(ConstExp value);

} // Preproc_Define
