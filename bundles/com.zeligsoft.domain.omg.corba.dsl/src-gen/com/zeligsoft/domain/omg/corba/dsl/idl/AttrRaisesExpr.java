/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Raises Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr#getExceptions <em>Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getAttrRaisesExpr()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface AttrRaisesExpr extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Exceptions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exceptions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exceptions</em>' containment reference.
   * @see #setExceptions(ExceptionList)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getAttrRaisesExpr_Exceptions()
   * @model containment="true"
   * @generated
   */
  ExceptionList getExceptions();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr#getExceptions <em>Exceptions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exceptions</em>' containment reference.
   * @see #getExceptions()
   * @generated
   */
  void setExceptions(ExceptionList value);

} // AttrRaisesExpr
