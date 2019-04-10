/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.StringType#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getStringType()
 * @model
 * @generated
 */
public interface StringType extends ParamTypeSpec, TemplateTypeSpec, ConstType
{
  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference.
   * @see #setSize(PositiveIntConst)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getStringType_Size()
   * @model containment="true"
   * @generated
   */
  PositiveIntConst getSize();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StringType#getSize <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' containment reference.
   * @see #getSize()
   * @generated
   */
  void setSize(PositiveIntConst value);

} // StringType
