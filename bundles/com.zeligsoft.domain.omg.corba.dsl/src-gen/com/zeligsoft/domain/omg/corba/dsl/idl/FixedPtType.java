/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Pt Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getLower <em>Lower</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFixedPtType()
 * @model
 * @generated
 */
public interface FixedPtType extends TemplateTypeSpec
{
  /**
   * Returns the value of the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' containment reference.
   * @see #setLower(PositiveIntConst)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFixedPtType_Lower()
   * @model containment="true"
   * @generated
   */
  PositiveIntConst getLower();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getLower <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' containment reference.
   * @see #getLower()
   * @generated
   */
  void setLower(PositiveIntConst value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' containment reference.
   * @see #setUpper(PositiveIntConst)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFixedPtType_Upper()
   * @model containment="true"
   * @generated
   */
  PositiveIntConst getUpper();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getUpper <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' containment reference.
   * @see #getUpper()
   * @generated
   */
  void setUpper(PositiveIntConst value);

} // FixedPtType
