/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Decls</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls#getDecls <em>Decls</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getParameterDecls()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface ParameterDecls extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comments</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getParameterDecls_Comments()
   * @model containment="true"
   * @generated
   */
  EList<IDLComment> getComments();

  /**
   * Returns the value of the '<em><b>Decls</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decls</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getParameterDecls_Decls()
   * @model containment="true"
   * @generated
   */
  EList<ParamDcl> getDecls();

} // ParameterDecls
