/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attr Raises Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrRaisesExprImpl#getExceptions <em>Exceptions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttrRaisesExprImpl extends EModelElementImpl implements AttrRaisesExpr
{
  /**
   * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExceptions()
   * @generated
   * @ordered
   */
  protected ExceptionList exceptions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttrRaisesExprImpl()
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
    return IdlPackage.Literals.ATTR_RAISES_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExceptionList getExceptions()
  {
    return exceptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExceptions(ExceptionList newExceptions, NotificationChain msgs)
  {
    ExceptionList oldExceptions = exceptions;
    exceptions = newExceptions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS, oldExceptions, newExceptions);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceptions(ExceptionList newExceptions)
  {
    if (newExceptions != exceptions)
    {
      NotificationChain msgs = null;
      if (exceptions != null)
        msgs = ((InternalEObject)exceptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS, null, msgs);
      if (newExceptions != null)
        msgs = ((InternalEObject)newExceptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS, null, msgs);
      msgs = basicSetExceptions(newExceptions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS, newExceptions, newExceptions));
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
      case IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS:
        return basicSetExceptions(null, msgs);
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
      case IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS:
        return getExceptions();
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
      case IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS:
        setExceptions((ExceptionList)newValue);
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
      case IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS:
        setExceptions((ExceptionList)null);
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
      case IdlPackage.ATTR_RAISES_EXPR__EXCEPTIONS:
        return exceptions != null;
    }
    return super.eIsSet(featureID);
  }

} //AttrRaisesExprImpl
