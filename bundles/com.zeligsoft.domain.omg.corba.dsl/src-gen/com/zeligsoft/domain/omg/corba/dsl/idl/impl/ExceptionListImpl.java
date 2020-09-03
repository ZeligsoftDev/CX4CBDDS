/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionListImpl#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExceptionListImpl extends EModelElementImpl implements ExceptionList
{
  /**
   * The cached value of the '{@link #getException() <em>Exception</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getException()
   * @generated
   * @ordered
   */
  protected EList<ScopedName> exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExceptionListImpl()
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
    return IdlPackage.Literals.EXCEPTION_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScopedName> getException()
  {
    if (exception == null)
    {
      exception = new EObjectContainmentEList<ScopedName>(ScopedName.class, this, IdlPackage.EXCEPTION_LIST__EXCEPTION);
    }
    return exception;
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
      case IdlPackage.EXCEPTION_LIST__EXCEPTION:
        return ((InternalEList<?>)getException()).basicRemove(otherEnd, msgs);
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
      case IdlPackage.EXCEPTION_LIST__EXCEPTION:
        return getException();
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
      case IdlPackage.EXCEPTION_LIST__EXCEPTION:
        getException().clear();
        getException().addAll((Collection<? extends ScopedName>)newValue);
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
      case IdlPackage.EXCEPTION_LIST__EXCEPTION:
        getException().clear();
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
      case IdlPackage.EXCEPTION_LIST__EXCEPTION:
        return exception != null && !exception.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExceptionListImpl
