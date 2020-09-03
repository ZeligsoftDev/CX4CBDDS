/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FileName#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFileName()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface FileName extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFileName_Name()
   * @model unique="false"
   * @generated
   */
  EList<String> getName();

} // FileName
