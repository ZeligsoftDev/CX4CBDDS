/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mult Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getLhs <em>Lhs</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getOp <em>Op</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getMultExpr()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface MultExpr extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(UnaryExpr)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getMultExpr_Lhs()
   * @model containment="true"
   * @generated
   */
  UnaryExpr getLhs();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(UnaryExpr value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getMultExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getOp <em>Op</em>}' attribute.
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
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(MultExpr)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getMultExpr_Rhs()
   * @model containment="true"
   * @generated
   */
  MultExpr getRhs();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(MultExpr value);

} // MultExpr
