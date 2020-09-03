/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attr Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrSpecImpl#getGetRaises <em>Get Raises</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrSpecImpl#getSetRaises <em>Set Raises</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttrSpecImpl extends AttrDeclImpl implements AttrSpec
{
  /**
   * The cached value of the '{@link #getGetRaises() <em>Get Raises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGetRaises()
   * @generated
   * @ordered
   */
  protected AttrRaisesExpr getRaises;

  /**
   * The cached value of the '{@link #getSetRaises() <em>Set Raises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetRaises()
   * @generated
   * @ordered
   */
  protected AttrRaisesExpr setRaises;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttrSpecImpl()
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
    return IdlPackage.Literals.ATTR_SPEC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttrRaisesExpr getGetRaises()
  {
    return getRaises;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGetRaises(AttrRaisesExpr newGetRaises, NotificationChain msgs)
  {
    AttrRaisesExpr oldGetRaises = getRaises;
    getRaises = newGetRaises;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.ATTR_SPEC__GET_RAISES, oldGetRaises, newGetRaises);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGetRaises(AttrRaisesExpr newGetRaises)
  {
    if (newGetRaises != getRaises)
    {
      NotificationChain msgs = null;
      if (getRaises != null)
        msgs = ((InternalEObject)getRaises).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.ATTR_SPEC__GET_RAISES, null, msgs);
      if (newGetRaises != null)
        msgs = ((InternalEObject)newGetRaises).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.ATTR_SPEC__GET_RAISES, null, msgs);
      msgs = basicSetGetRaises(newGetRaises, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.ATTR_SPEC__GET_RAISES, newGetRaises, newGetRaises));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttrRaisesExpr getSetRaises()
  {
    return setRaises;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSetRaises(AttrRaisesExpr newSetRaises, NotificationChain msgs)
  {
    AttrRaisesExpr oldSetRaises = setRaises;
    setRaises = newSetRaises;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.ATTR_SPEC__SET_RAISES, oldSetRaises, newSetRaises);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSetRaises(AttrRaisesExpr newSetRaises)
  {
    if (newSetRaises != setRaises)
    {
      NotificationChain msgs = null;
      if (setRaises != null)
        msgs = ((InternalEObject)setRaises).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.ATTR_SPEC__SET_RAISES, null, msgs);
      if (newSetRaises != null)
        msgs = ((InternalEObject)newSetRaises).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.ATTR_SPEC__SET_RAISES, null, msgs);
      msgs = basicSetSetRaises(newSetRaises, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.ATTR_SPEC__SET_RAISES, newSetRaises, newSetRaises));
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
      case IdlPackage.ATTR_SPEC__GET_RAISES:
        return basicSetGetRaises(null, msgs);
      case IdlPackage.ATTR_SPEC__SET_RAISES:
        return basicSetSetRaises(null, msgs);
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
      case IdlPackage.ATTR_SPEC__GET_RAISES:
        return getGetRaises();
      case IdlPackage.ATTR_SPEC__SET_RAISES:
        return getSetRaises();
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
      case IdlPackage.ATTR_SPEC__GET_RAISES:
        setGetRaises((AttrRaisesExpr)newValue);
        return;
      case IdlPackage.ATTR_SPEC__SET_RAISES:
        setSetRaises((AttrRaisesExpr)newValue);
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
      case IdlPackage.ATTR_SPEC__GET_RAISES:
        setGetRaises((AttrRaisesExpr)null);
        return;
      case IdlPackage.ATTR_SPEC__SET_RAISES:
        setSetRaises((AttrRaisesExpr)null);
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
      case IdlPackage.ATTR_SPEC__GET_RAISES:
        return getRaises != null;
      case IdlPackage.ATTR_SPEC__SET_RAISES:
        return setRaises != null;
    }
    return super.eIsSet(featureID);
  }

} //AttrSpecImpl
