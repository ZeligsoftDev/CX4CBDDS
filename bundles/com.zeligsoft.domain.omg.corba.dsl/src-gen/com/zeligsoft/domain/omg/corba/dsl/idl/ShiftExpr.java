/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shift Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getLhs <em>Lhs</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getOp <em>Op</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getShiftExpr()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface ShiftExpr extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(AddExpr)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getShiftExpr_Lhs()
   * @model containment="true"
   * @generated
   */
  AddExpr getLhs();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(AddExpr value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getShiftExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(ShiftExpr)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getShiftExpr_Rhs()
   * @model containment="true"
   * @generated
   */
  ShiftExpr getRhs();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(ShiftExpr value);

} // ShiftExpr
