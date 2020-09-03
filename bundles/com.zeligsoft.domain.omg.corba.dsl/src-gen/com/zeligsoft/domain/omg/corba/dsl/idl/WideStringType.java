/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wide String Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getWideStringType()
 * @model
 * @generated
 */
public interface WideStringType extends ParamTypeSpec, TemplateTypeSpec, ConstType
{
  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference.
   * @see #setSize(PositiveIntConst)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getWideStringType_Size()
   * @model containment="true"
   * @generated
   */
  PositiveIntConst getSize();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType#getSize <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' containment reference.
   * @see #getSize()
   * @generated
   */
  void setSize(PositiveIntConst value);

} // WideStringType
