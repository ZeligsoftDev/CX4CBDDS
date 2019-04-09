/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl#getImported_scope <em>Imported scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getImport_decl()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface Import_decl extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Imported scope</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imported scope</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imported scope</em>' attribute.
   * @see #setImported_scope(String)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getImport_decl_Imported_scope()
   * @model
   * @generated
   */
  String getImported_scope();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl#getImported_scope <em>Imported scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imported scope</em>' attribute.
   * @see #getImported_scope()
   * @generated
   */
  void setImported_scope(String value);

} // Import_decl
