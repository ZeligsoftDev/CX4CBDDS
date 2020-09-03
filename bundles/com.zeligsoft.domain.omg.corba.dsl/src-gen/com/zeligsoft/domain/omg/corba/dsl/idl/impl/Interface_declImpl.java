/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_declImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_declImpl#getInterfaceBody <em>Interface Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Interface_declImpl extends Interface_or_Forward_DeclImpl implements Interface_decl
{
  /**
   * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeader()
   * @generated
   * @ordered
   */
  protected Interface_header header;

  /**
   * The cached value of the '{@link #getInterfaceBody() <em>Interface Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaceBody()
   * @generated
   * @ordered
   */
  protected InterfaceBody interfaceBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Interface_declImpl()
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
    return IdlPackage.Literals.INTERFACE_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface_header getHeader()
  {
    return header;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHeader(Interface_header newHeader, NotificationChain msgs)
  {
    Interface_header oldHeader = header;
    header = newHeader;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.INTERFACE_DECL__HEADER, oldHeader, newHeader);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeader(Interface_header newHeader)
  {
    if (newHeader != header)
    {
      NotificationChain msgs = null;
      if (header != null)
        msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.INTERFACE_DECL__HEADER, null, msgs);
      if (newHeader != null)
        msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.INTERFACE_DECL__HEADER, null, msgs);
      msgs = basicSetHeader(newHeader, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.INTERFACE_DECL__HEADER, newHeader, newHeader));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceBody getInterfaceBody()
  {
    return interfaceBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInterfaceBody(InterfaceBody newInterfaceBody, NotificationChain msgs)
  {
    InterfaceBody oldInterfaceBody = interfaceBody;
    interfaceBody = newInterfaceBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.INTERFACE_DECL__INTERFACE_BODY, oldInterfaceBody, newInterfaceBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterfaceBody(InterfaceBody newInterfaceBody)
  {
    if (newInterfaceBody != interfaceBody)
    {
      NotificationChain msgs = null;
      if (interfaceBody != null)
        msgs = ((InternalEObject)interfaceBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.INTERFACE_DECL__INTERFACE_BODY, null, msgs);
      if (newInterfaceBody != null)
        msgs = ((InternalEObject)newInterfaceBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.INTERFACE_DECL__INTERFACE_BODY, null, msgs);
      msgs = basicSetInterfaceBody(newInterfaceBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.INTERFACE_DECL__INTERFACE_BODY, newInterfaceBody, newInterfaceBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case IdlPackage.INTERFACE_DECL__HEADER:
        return basicSetHeader(null, msgs);
      case IdlPackage.INTERFACE_DECL__INTERFACE_BODY:
        return basicSetInterfaceBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case IdlPackage.INTERFACE_DECL__HEADER:
        return getHeader();
      case IdlPackage.INTERFACE_DECL__INTERFACE_BODY:
        return getInterfaceBody();
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
      case IdlPackage.INTERFACE_DECL__HEADER:
        setHeader((Interface_header)newValue);
        return;
      case IdlPackage.INTERFACE_DECL__INTERFACE_BODY:
        setInterfaceBody((InterfaceBody)newValue);
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
      case IdlPackage.INTERFACE_DECL__HEADER:
        setHeader((Interface_header)null);
        return;
      case IdlPackage.INTERFACE_DECL__INTERFACE_BODY:
        setInterfaceBody((InterfaceBody)null);
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
      case IdlPackage.INTERFACE_DECL__HEADER:
        return header != null;
      case IdlPackage.INTERFACE_DECL__INTERFACE_BODY:
        return interfaceBody != null;
    }
    return super.eIsSet(featureID);
  }

} //Interface_declImpl
