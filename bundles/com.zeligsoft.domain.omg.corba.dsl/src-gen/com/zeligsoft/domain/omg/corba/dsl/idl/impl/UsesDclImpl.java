/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl;

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
 * An implementation of the model object '<em><b>Uses Dcl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl#isIsMultiple <em>Is Multiple</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsesDclImpl extends ComponentExportImpl implements UsesDcl
{
  /**
   * The default value of the '{@link #isIsMultiple() <em>Is Multiple</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsMultiple()
   * @generated
   * @ordered
   */
  protected static final boolean IS_MULTIPLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsMultiple() <em>Is Multiple</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsMultiple()
   * @generated
   * @ordered
   */
  protected boolean isMultiple = IS_MULTIPLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ScopedName type;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComments()
   * @generated
   * @ordered
   */
  protected EList<IDLComment> comments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UsesDclImpl()
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
    return IdlPackage.Literals.USES_DCL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsMultiple()
  {
    return isMultiple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsMultiple(boolean newIsMultiple)
  {
    boolean oldIsMultiple = isMultiple;
    isMultiple = newIsMultiple;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.USES_DCL__IS_MULTIPLE, oldIsMultiple, isMultiple));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScopedName getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(ScopedName newType, NotificationChain msgs)
  {
    ScopedName oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.USES_DCL__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(ScopedName newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.USES_DCL__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.USES_DCL__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.USES_DCL__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.USES_DCL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IDLComment> getComments()
  {
    if (comments == null)
    {
      comments = new EObjectContainmentEList<IDLComment>(IDLComment.class, this, IdlPackage.USES_DCL__COMMENTS);
    }
    return comments;
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
      case IdlPackage.USES_DCL__TYPE:
        return basicSetType(null, msgs);
      case IdlPackage.USES_DCL__COMMENTS:
        return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
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
      case IdlPackage.USES_DCL__IS_MULTIPLE:
        return isIsMultiple();
      case IdlPackage.USES_DCL__TYPE:
        return getType();
      case IdlPackage.USES_DCL__NAME:
        return getName();
      case IdlPackage.USES_DCL__COMMENTS:
        return getComments();
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
      case IdlPackage.USES_DCL__IS_MULTIPLE:
        setIsMultiple((Boolean)newValue);
        return;
      case IdlPackage.USES_DCL__TYPE:
        setType((ScopedName)newValue);
        return;
      case IdlPackage.USES_DCL__NAME:
        setName((String)newValue);
        return;
      case IdlPackage.USES_DCL__COMMENTS:
        getComments().clear();
        getComments().addAll((Collection<? extends IDLComment>)newValue);
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
      case IdlPackage.USES_DCL__IS_MULTIPLE:
        setIsMultiple(IS_MULTIPLE_EDEFAULT);
        return;
      case IdlPackage.USES_DCL__TYPE:
        setType((ScopedName)null);
        return;
      case IdlPackage.USES_DCL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IdlPackage.USES_DCL__COMMENTS:
        getComments().clear();
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
      case IdlPackage.USES_DCL__IS_MULTIPLE:
        return isMultiple != IS_MULTIPLE_EDEFAULT;
      case IdlPackage.USES_DCL__TYPE:
        return type != null;
      case IdlPackage.USES_DCL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IdlPackage.USES_DCL__COMMENTS:
        return comments != null && !comments.isEmpty();
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
    result.append(" (isMultiple: ");
    result.append(isMultiple);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //UsesDclImpl
