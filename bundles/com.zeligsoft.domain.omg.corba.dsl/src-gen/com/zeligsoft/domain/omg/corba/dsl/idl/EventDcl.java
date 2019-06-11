/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Dcl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsCustom <em>Is Custom</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsTruncatable <em>Is Truncatable</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getBase <em>Base</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getSupports <em>Supports</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getExport <em>Export</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl()
 * @model
 * @generated
 */
public interface EventDcl extends Event
{
  /**
   * Returns the value of the '<em><b>Is Custom</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Custom</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Custom</em>' attribute.
   * @see #setIsCustom(boolean)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl_IsCustom()
   * @model
   * @generated
   */
  boolean isIsCustom();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsCustom <em>Is Custom</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Custom</em>' attribute.
   * @see #isIsCustom()
   * @generated
   */
  void setIsCustom(boolean value);

  /**
   * Returns the value of the '<em><b>Is Truncatable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Truncatable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Truncatable</em>' attribute.
   * @see #setIsTruncatable(boolean)
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl_IsTruncatable()
   * @model
   * @generated
   */
  boolean isIsTruncatable();

  /**
   * Sets the value of the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsTruncatable <em>Is Truncatable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Truncatable</em>' attribute.
   * @see #isIsTruncatable()
   * @generated
   */
  void setIsTruncatable(boolean value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl_Base()
   * @model containment="true"
   * @generated
   */
  EList<ScopedName> getBase();

  /**
   * Returns the value of the '<em><b>Supports</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supports</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl_Supports()
   * @model containment="true"
   * @generated
   */
  EList<ScopedName> getSupports();

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
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl_Export()
   * @model containment="true"
   * @generated
   */
  EList<Export> getExport();

  /**
   * Returns the value of the '<em><b>Member</b></em>' containment reference list.
   * The list contents are of type {@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Member</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Member</em>' containment reference list.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#getEventDcl_Member()
   * @model containment="true"
   * @generated
   */
  EList<StateMember> getMember();

} // EventDcl
