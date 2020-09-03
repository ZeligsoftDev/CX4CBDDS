/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getContextExpr()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface ContextExpr extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Literal</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' attribute list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getContextExpr_Literal()
   * @model unique="false"
   * @generated
   */
  EList<String> getLiteral();

} // ContextExpr
