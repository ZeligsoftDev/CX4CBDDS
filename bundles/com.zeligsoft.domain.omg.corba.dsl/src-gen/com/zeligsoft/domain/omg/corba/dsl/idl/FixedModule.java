/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFixedModule()
 * @model
 * @generated
 */
public interface FixedModule extends TemplateDefinition, FixedDefinition
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFixedModule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getFixedModule_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<FixedDefinition> getDefinitions();

} // FixedModule
