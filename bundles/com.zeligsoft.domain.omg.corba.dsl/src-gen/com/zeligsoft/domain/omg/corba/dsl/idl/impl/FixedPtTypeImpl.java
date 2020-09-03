/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Pt Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtTypeImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtTypeImpl#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedPtTypeImpl extends TemplateTypeSpecImpl implements FixedPtType
{
  /**
   * The cached value of the '{@link #getLower() <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected PositiveIntConst lower;

  /**
   * The cached value of the '{@link #getUpper() <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected PositiveIntConst upper;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FixedPtTypeImpl()
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
    return IdlPackage.Literals.FIXED_PT_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositiveIntConst getLower()
  {
    return lower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLower(PositiveIntConst newLower, NotificationChain msgs)
  {
    PositiveIntConst oldLower = lower;
    lower = newLower;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.FIXED_PT_TYPE__LOWER, oldLower, newLower);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLower(PositiveIntConst newLower)
  {
    if (newLower != lower)
    {
      NotificationChain msgs = null;
      if (lower != null)
        msgs = ((InternalEObject)lower).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FIXED_PT_TYPE__LOWER, null, msgs);
      if (newLower != null)
        msgs = ((InternalEObject)newLower).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FIXED_PT_TYPE__LOWER, null, msgs);
      msgs = basicSetLower(newLower, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.FIXED_PT_TYPE__LOWER, newLower, newLower));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositiveIntConst getUpper()
  {
    return upper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpper(PositiveIntConst newUpper, NotificationChain msgs)
  {
    PositiveIntConst oldUpper = upper;
    upper = newUpper;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.FIXED_PT_TYPE__UPPER, oldUpper, newUpper);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpper(PositiveIntConst newUpper)
  {
    if (newUpper != upper)
    {
      NotificationChain msgs = null;
      if (upper != null)
        msgs = ((InternalEObject)upper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FIXED_PT_TYPE__UPPER, null, msgs);
      if (newUpper != null)
        msgs = ((InternalEObject)newUpper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FIXED_PT_TYPE__UPPER, null, msgs);
      msgs = basicSetUpper(newUpper, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.FIXED_PT_TYPE__UPPER, newUpper, newUpper));
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
      case IdlPackage.FIXED_PT_TYPE__LOWER:
        return basicSetLower(null, msgs);
      case IdlPackage.FIXED_PT_TYPE__UPPER:
        return basicSetUpper(null, msgs);
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
      case IdlPackage.FIXED_PT_TYPE__LOWER:
        return getLower();
      case IdlPackage.FIXED_PT_TYPE__UPPER:
        return getUpper();
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
      case IdlPackage.FIXED_PT_TYPE__LOWER:
        setLower((PositiveIntConst)newValue);
        return;
      case IdlPackage.FIXED_PT_TYPE__UPPER:
        setUpper((PositiveIntConst)newValue);
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
      case IdlPackage.FIXED_PT_TYPE__LOWER:
        setLower((PositiveIntConst)null);
        return;
      case IdlPackage.FIXED_PT_TYPE__UPPER:
        setUpper((PositiveIntConst)null);
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
      case IdlPackage.FIXED_PT_TYPE__LOWER:
        return lower != null;
      case IdlPackage.FIXED_PT_TYPE__UPPER:
        return upper != null;
    }
    return super.eIsSet(featureID);
  }

} //FixedPtTypeImpl
