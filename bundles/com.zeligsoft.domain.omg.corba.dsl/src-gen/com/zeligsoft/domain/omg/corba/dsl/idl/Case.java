/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getLabel <em>Label</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getSpec <em>Spec</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCase()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface Case extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comments</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCase_Comments()
   * @model containment="true"
   * @generated
   */
  EList<IDLComment> getComments();

  /**
   * Returns the value of the '<em><b>Label</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCase_Label()
   * @model containment="true"
   * @generated
   */
  EList<CaseLabel> getLabel();

  /**
   * Returns the value of the '<em><b>Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spec</em>' containment reference.
   * @see #setSpec(ElementSpec)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getCase_Spec()
   * @model containment="true"
   * @generated
   */
  ElementSpec getSpec();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getSpec <em>Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Spec</em>' containment reference.
   * @see #getSpec()
   * @generated
   */
  void setSpec(ElementSpec value);

} // Case
