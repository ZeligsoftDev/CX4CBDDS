/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scoped Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getScopedName()
 * @model
 * @generated
 */
public interface ScopedName extends ParamTypeSpec, SimpleTypeSpec, SwitchTypeSpec, ConstType, PrimaryExpr
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getScopedName_Name()
   * @model unique="false"
   * @generated
   */
  EList<String> getName();

} // ScopedName
