/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;

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
 * An implementation of the model object '<em><b>Port Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl#isIsMirror <em>Is Mirror</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl#getComments <em>Comments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortDeclImpl extends ComponentExportImpl implements PortDecl
{
  /**
   * The default value of the '{@link #isIsMirror() <em>Is Mirror</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsMirror()
   * @generated
   * @ordered
   */
  protected static final boolean IS_MIRROR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsMirror() <em>Is Mirror</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsMirror()
   * @generated
   * @ordered
   */
  protected boolean isMirror = IS_MIRROR_EDEFAULT;

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
  protected PortDeclImpl()
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
    return IdlPackage.Literals.PORT_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsMirror()
  {
    return isMirror;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsMirror(boolean newIsMirror)
  {
    boolean oldIsMirror = isMirror;
    isMirror = newIsMirror;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.PORT_DECL__IS_MIRROR, oldIsMirror, isMirror));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.PORT_DECL__TYPE, oldType, newType);
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
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.PORT_DECL__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.PORT_DECL__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.PORT_DECL__TYPE, newType, newType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.PORT_DECL__NAME, oldName, name));
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
      comments = new EObjectContainmentEList<IDLComment>(IDLComment.class, this, IdlPackage.PORT_DECL__COMMENTS);
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
      case IdlPackage.PORT_DECL__TYPE:
        return basicSetType(null, msgs);
      case IdlPackage.PORT_DECL__COMMENTS:
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
      case IdlPackage.PORT_DECL__IS_MIRROR:
        return isIsMirror();
      case IdlPackage.PORT_DECL__TYPE:
        return getType();
      case IdlPackage.PORT_DECL__NAME:
        return getName();
      case IdlPackage.PORT_DECL__COMMENTS:
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
      case IdlPackage.PORT_DECL__IS_MIRROR:
        setIsMirror((Boolean)newValue);
        return;
      case IdlPackage.PORT_DECL__TYPE:
        setType((ScopedName)newValue);
        return;
      case IdlPackage.PORT_DECL__NAME:
        setName((String)newValue);
        return;
      case IdlPackage.PORT_DECL__COMMENTS:
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
      case IdlPackage.PORT_DECL__IS_MIRROR:
        setIsMirror(IS_MIRROR_EDEFAULT);
        return;
      case IdlPackage.PORT_DECL__TYPE:
        setType((ScopedName)null);
        return;
      case IdlPackage.PORT_DECL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IdlPackage.PORT_DECL__COMMENTS:
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
      case IdlPackage.PORT_DECL__IS_MIRROR:
        return isMirror != IS_MIRROR_EDEFAULT;
      case IdlPackage.PORT_DECL__TYPE:
        return type != null;
      case IdlPackage.PORT_DECL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IdlPackage.PORT_DECL__COMMENTS:
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
    result.append(" (isMirror: ");
    result.append(isMirror);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PortDeclImpl
