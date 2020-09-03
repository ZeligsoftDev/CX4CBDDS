/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getArrayDeclarator()
 * @model
 * @generated
 */
public interface ArrayDeclarator extends Declarator, ComplexDeclarator
{
  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getArrayDeclarator_Size()
   * @model containment="true"
   * @generated
   */
  EList<ConstExp> getSize();

} // ArrayDeclarator
