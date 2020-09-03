/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getBase <em>Base</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getSupports <em>Supports</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getExport <em>Export</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getComponentDecl()
 * @model
 * @generated
 */
public interface ComponentDecl extends Definition, TemplateDefinition, FixedDefinition
{
  /**
   * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comments</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getComponentDecl_Comments()
   * @model containment="true"
   * @generated
   */
  EList<IDLComment> getComments();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getComponentDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(ScopedName)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getComponentDecl_Base()
   * @model containment="true"
   * @generated
   */
  ScopedName getBase();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(ScopedName value);

  /**
   * Returns the value of the '<em><b>Supports</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supports</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getComponentDecl_Supports()
   * @model containment="true"
   * @generated
   */
  EList<ScopedName> getSupports();

  /**
   * Returns the value of the '<em><b>Export</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getComponentDecl_Export()
   * @model containment="true"
   * @generated
   */
  EList<ComponentExport> getExport();

} // ComponentDecl
