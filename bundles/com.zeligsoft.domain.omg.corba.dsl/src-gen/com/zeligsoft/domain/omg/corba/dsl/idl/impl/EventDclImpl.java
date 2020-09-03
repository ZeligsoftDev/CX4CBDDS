/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Export;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.StateMember;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Dcl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl#isIsCustom <em>Is Custom</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl#isIsTruncatable <em>Is Truncatable</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl#getBase <em>Base</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl#getSupports <em>Supports</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl#getExport <em>Export</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventDclImpl extends EventImpl implements EventDcl
{
  /**
   * The default value of the '{@link #isIsCustom() <em>Is Custom</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsCustom()
   * @generated
   * @ordered
   */
  protected static final boolean IS_CUSTOM_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsCustom() <em>Is Custom</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsCustom()
   * @generated
   * @ordered
   */
  protected boolean isCustom = IS_CUSTOM_EDEFAULT;

  /**
   * The default value of the '{@link #isIsTruncatable() <em>Is Truncatable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsTruncatable()
   * @generated
   * @ordered
   */
  protected static final boolean IS_TRUNCATABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsTruncatable() <em>Is Truncatable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsTruncatable()
   * @generated
   * @ordered
   */
  protected boolean isTruncatable = IS_TRUNCATABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected EList<ScopedName> base;

  /**
   * The cached value of the '{@link #getSupports() <em>Supports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupports()
   * @generated
   * @ordered
   */
  protected EList<ScopedName> supports;

  /**
   * The cached value of the '{@link #getExport() <em>Export</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExport()
   * @generated
   * @ordered
   */
  protected EList<Export> export;

  /**
   * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMember()
   * @generated
   * @ordered
   */
  protected EList<StateMember> member;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventDclImpl()
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
    return IdlPackage.Literals.EVENT_DCL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsCustom()
  {
    return isCustom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsCustom(boolean newIsCustom)
  {
    boolean oldIsCustom = isCustom;
    isCustom = newIsCustom;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.EVENT_DCL__IS_CUSTOM, oldIsCustom, isCustom));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsTruncatable()
  {
    return isTruncatable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsTruncatable(boolean newIsTruncatable)
  {
    boolean oldIsTruncatable = isTruncatable;
    isTruncatable = newIsTruncatable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.EVENT_DCL__IS_TRUNCATABLE, oldIsTruncatable, isTruncatable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScopedName> getBase()
  {
    if (base == null)
    {
      base = new EObjectContainmentEList<ScopedName>(ScopedName.class, this, IdlPackage.EVENT_DCL__BASE);
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScopedName> getSupports()
  {
    if (supports == null)
    {
      supports = new EObjectContainmentEList<ScopedName>(ScopedName.class, this, IdlPackage.EVENT_DCL__SUPPORTS);
    }
    return supports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Export> getExport()
  {
    if (export == null)
    {
      export = new EObjectContainmentEList<Export>(Export.class, this, IdlPackage.EVENT_DCL__EXPORT);
    }
    return export;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateMember> getMember()
  {
    if (member == null)
    {
      member = new EObjectContainmentEList<StateMember>(StateMember.class, this, IdlPackage.EVENT_DCL__MEMBER);
    }
    return member;
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
      case IdlPackage.EVENT_DCL__BASE:
        return ((InternalEList<?>)getBase()).basicRemove(otherEnd, msgs);
      case IdlPackage.EVENT_DCL__SUPPORTS:
        return ((InternalEList<?>)getSupports()).basicRemove(otherEnd, msgs);
      case IdlPackage.EVENT_DCL__EXPORT:
        return ((InternalEList<?>)getExport()).basicRemove(otherEnd, msgs);
      case IdlPackage.EVENT_DCL__MEMBER:
        return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
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
      case IdlPackage.EVENT_DCL__IS_CUSTOM:
        return isIsCustom();
      case IdlPackage.EVENT_DCL__IS_TRUNCATABLE:
        return isIsTruncatable();
      case IdlPackage.EVENT_DCL__BASE:
        return getBase();
      case IdlPackage.EVENT_DCL__SUPPORTS:
        return getSupports();
      case IdlPackage.EVENT_DCL__EXPORT:
        return getExport();
      case IdlPackage.EVENT_DCL__MEMBER:
        return getMember();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IdlPackage.EVENT_DCL__IS_CUSTOM:
        setIsCustom((Boolean)newValue);
        return;
      case IdlPackage.EVENT_DCL__IS_TRUNCATABLE:
        setIsTruncatable((Boolean)newValue);
        return;
      case IdlPackage.EVENT_DCL__BASE:
        getBase().clear();
        getBase().addAll((Collection<? extends ScopedName>)newValue);
        return;
      case IdlPackage.EVENT_DCL__SUPPORTS:
        getSupports().clear();
        getSupports().addAll((Collection<? extends ScopedName>)newValue);
        return;
      case IdlPackage.EVENT_DCL__EXPORT:
        getExport().clear();
        getExport().addAll((Collection<? extends Export>)newValue);
        return;
      case IdlPackage.EVENT_DCL__MEMBER:
        getMember().clear();
        getMember().addAll((Collection<? extends StateMember>)newValue);
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
      case IdlPackage.EVENT_DCL__IS_CUSTOM:
        setIsCustom(IS_CUSTOM_EDEFAULT);
        return;
      case IdlPackage.EVENT_DCL__IS_TRUNCATABLE:
        setIsTruncatable(IS_TRUNCATABLE_EDEFAULT);
        return;
      case IdlPackage.EVENT_DCL__BASE:
        getBase().clear();
        return;
      case IdlPackage.EVENT_DCL__SUPPORTS:
        getSupports().clear();
        return;
      case IdlPackage.EVENT_DCL__EXPORT:
        getExport().clear();
        return;
      case IdlPackage.EVENT_DCL__MEMBER:
        getMember().clear();
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
      case IdlPackage.EVENT_DCL__IS_CUSTOM:
        return isCustom != IS_CUSTOM_EDEFAULT;
      case IdlPackage.EVENT_DCL__IS_TRUNCATABLE:
        return isTruncatable != IS_TRUNCATABLE_EDEFAULT;
      case IdlPackage.EVENT_DCL__BASE:
        return base != null && !base.isEmpty();
      case IdlPackage.EVENT_DCL__SUPPORTS:
        return supports != null && !supports.isEmpty();
      case IdlPackage.EVENT_DCL__EXPORT:
        return export != null && !export.isEmpty();
      case IdlPackage.EVENT_DCL__MEMBER:
        return member != null && !member.isEmpty();
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (isCustom: ");
    result.append(isCustom);
    result.append(", isTruncatable: ");
    result.append(isTruncatable);
    result.append(')');
    return result.toString();
  }

} //EventDclImpl
