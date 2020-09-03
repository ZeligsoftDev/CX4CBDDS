/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl#isIsCase <em>Is Case</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl#getConstExp <em>Const Exp</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl#isIsDefault <em>Is Default</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CaseLabelImpl extends EModelElementImpl implements CaseLabel
{
  /**
   * The default value of the '{@link #isIsCase() <em>Is Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsCase()
   * @generated
   * @ordered
   */
  protected static final boolean IS_CASE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsCase() <em>Is Case</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsCase()
   * @generated
   * @ordered
   */
  protected boolean isCase = IS_CASE_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstExp() <em>Const Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstExp()
   * @generated
   * @ordered
   */
  protected ConstExp constExp;

  /**
   * The default value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDefault()
   * @generated
   * @ordered
   */
  protected static final boolean IS_DEFAULT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDefault()
   * @generated
   * @ordered
   */
  protected boolean isDefault = IS_DEFAULT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CaseLabelImpl()
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
    return IdlPackage.Literals.CASE_LABEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsCase()
  {
    return isCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsCase(boolean newIsCase)
  {
    boolean oldIsCase = isCase;
    isCase = newIsCase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.CASE_LABEL__IS_CASE, oldIsCase, isCase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstExp getConstExp()
  {
    return constExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstExp(ConstExp newConstExp, NotificationChain msgs)
  {
    ConstExp oldConstExp = constExp;
    constExp = newConstExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.CASE_LABEL__CONST_EXP, oldConstExp, newConstExp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstExp(ConstExp newConstExp)
  {
    if (newConstExp != constExp)
    {
      NotificationChain msgs = null;
      if (constExp != null)
        msgs = ((InternalEObject)constExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.CASE_LABEL__CONST_EXP, null, msgs);
      if (newConstExp != null)
        msgs = ((InternalEObject)newConstExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.CASE_LABEL__CONST_EXP, null, msgs);
      msgs = basicSetConstExp(newConstExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.CASE_LABEL__CONST_EXP, newConstExp, newConstExp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsDefault()
  {
    return isDefault;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsDefault(boolean newIsDefault)
  {
    boolean oldIsDefault = isDefault;
    isDefault = newIsDefault;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.CASE_LABEL__IS_DEFAULT, oldIsDefault, isDefault));
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
      case IdlPackage.CASE_LABEL__CONST_EXP:
        return basicSetConstExp(null, msgs);
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
      case IdlPackage.CASE_LABEL__IS_CASE:
        return isIsCase();
      case IdlPackage.CASE_LABEL__CONST_EXP:
        return getConstExp();
      case IdlPackage.CASE_LABEL__IS_DEFAULT:
        return isIsDefault();
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
      case IdlPackage.CASE_LABEL__IS_CASE:
        setIsCase((Boolean)newValue);
        return;
      case IdlPackage.CASE_LABEL__CONST_EXP:
        setConstExp((ConstExp)newValue);
        return;
      case IdlPackage.CASE_LABEL__IS_DEFAULT:
        setIsDefault((Boolean)newValue);
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
      case IdlPackage.CASE_LABEL__IS_CASE:
        setIsCase(IS_CASE_EDEFAULT);
        return;
      case IdlPackage.CASE_LABEL__CONST_EXP:
        setConstExp((ConstExp)null);
        return;
      case IdlPackage.CASE_LABEL__IS_DEFAULT:
        setIsDefault(IS_DEFAULT_EDEFAULT);
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
      case IdlPackage.CASE_LABEL__IS_CASE:
        return isCase != IS_CASE_EDEFAULT;
      case IdlPackage.CASE_LABEL__CONST_EXP:
        return constExp != null;
      case IdlPackage.CASE_LABEL__IS_DEFAULT:
        return isDefault != IS_DEFAULT_EDEFAULT;
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
    result.append(" (isCase: ");
    result.append(isCase);
    result.append(", isDefault: ");
    result.append(isDefault);
    result.append(')');
    return result.toString();
  }

} //CaseLabelImpl
