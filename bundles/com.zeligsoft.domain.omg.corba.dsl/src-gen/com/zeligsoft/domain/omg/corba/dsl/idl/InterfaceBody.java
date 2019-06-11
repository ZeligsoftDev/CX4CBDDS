/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody#getExport <em>Export</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterfaceBody()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface InterfaceBody extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Export</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.Export}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getInterfaceBody_Export()
   * @model containment="true"
   * @generated
   */
  EList<Export> getExport();

} // InterfaceBody
