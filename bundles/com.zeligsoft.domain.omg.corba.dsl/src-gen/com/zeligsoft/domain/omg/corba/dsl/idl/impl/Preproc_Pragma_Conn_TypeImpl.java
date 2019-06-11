/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preproc Pragma Conn Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Conn_TypeImpl#getValuePort <em>Value Port</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Conn_TypeImpl#getValueConnType <em>Value Conn Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Preproc_Pragma_Conn_TypeImpl extends Preproc_PragmaImpl implements Preproc_Pragma_Conn_Type
{
  /**
   * The default value of the '{@link #getValuePort() <em>Value Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValuePort()
   * @generated
   * @ordered
   */
  protected static final String VALUE_PORT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValuePort() <em>Value Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValuePort()
   * @generated
   * @ordered
   */
  protected String valuePort = VALUE_PORT_EDEFAULT;

  /**
   * The default value of the '{@link #getValueConnType() <em>Value Conn Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueConnType()
   * @generated
   * @ordered
   */
  protected static final String VALUE_CONN_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValueConnType() <em>Value Conn Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueConnType()
   * @generated
   * @ordered
   */
  protected String valueConnType = VALUE_CONN_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Preproc_Pragma_Conn_TypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return IdlPackage.Literals.PREPROC_PRAGMA_CONN_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValuePort()
  {
    return valuePort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValuePort(String newValuePort)
  {
    String oldValuePort = valuePort;
    valuePort = newValuePort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT, oldValuePort, valuePort));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValueConnType()
  {
    return valueConnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueConnType(String newValueConnType)
  {
    String oldValueConnType = valueConnType;
    valueConnType = newValueConnType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE, oldValueConnType, valueConnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT:
        return getValuePort();
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE:
        return getValueConnType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT:
        setValuePort((String)newValue);
        return;
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE:
        setValueConnType((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT:
        setValuePort(VALUE_PORT_EDEFAULT);
        return;
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE:
        setValueConnType(VALUE_CONN_TYPE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT:
        return VALUE_PORT_EDEFAULT == null ? valuePort != null : !VALUE_PORT_EDEFAULT.equals(valuePort);
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE:
        return VALUE_CONN_TYPE_EDEFAULT == null ? valueConnType != null : !VALUE_CONN_TYPE_EDEFAULT.equals(valueConnType);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (valuePort: ");
    result.append(valuePort);
    result.append(", valueConnType: ");
    result.append(valueConnType);
    result.append(')');
    return result.toString();
  }

} //Preproc_Pragma_Conn_TypeImpl
