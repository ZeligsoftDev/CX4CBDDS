/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preproc If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#isNegation <em>Negation</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_If()
 * @model
 * @generated
 */
public interface Preproc_If extends Preproc
{
  /**
   * Returns the value of the '<em><b>Negation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negation</em>' attribute.
   * @see #setNegation(boolean)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_If_Negation()
   * @model
   * @generated
   */
  boolean isNegation();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#isNegation <em>Negation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Negation</em>' attribute.
   * @see #isNegation()
   * @generated
   */
  void setNegation(boolean value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getPreproc_If_Value()
   * @model containment="true"
   * @generated
   */
  EList<Preproc_If_Compare> getValue();

} // Preproc_If
