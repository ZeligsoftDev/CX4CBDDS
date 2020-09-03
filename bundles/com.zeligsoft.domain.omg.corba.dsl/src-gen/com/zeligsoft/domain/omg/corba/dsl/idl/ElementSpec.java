/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getElementSpec()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface ElementSpec extends EModelElement
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeSpec)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getElementSpec_Type()
   * @model containment="true"
   * @generated
   */
  TypeSpec getType();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeSpec value);

  /**
   * Returns the value of the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarator</em>' containment reference.
   * @see #setDeclarator(Declarator)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getElementSpec_Declarator()
   * @model containment="true"
   * @generated
   */
  Declarator getDeclarator();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getDeclarator <em>Declarator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declarator</em>' containment reference.
   * @see #getDeclarator()
   * @generated
   */
  void setDeclarator(Declarator value);

} // ElementSpec
