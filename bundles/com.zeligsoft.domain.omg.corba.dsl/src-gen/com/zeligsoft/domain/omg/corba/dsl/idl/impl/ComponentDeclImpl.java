/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
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
 * An implementation of the model object '<em><b>Component Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl#getBase <em>Base</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl#getSupports <em>Supports</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl#getExport <em>Export</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentDeclImpl extends DefinitionImpl implements ComponentDecl
{
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
   * The cached value of the '{@link #getBase() <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected ScopedName base;

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
  protected EList<ComponentExport> export;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentDeclImpl()
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
    return IdlPackage.Literals.COMPONENT_DECL;
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
      comments = new EObjectContainmentEList<IDLComment>(IDLComment.class, this, IdlPackage.COMPONENT_DECL__COMMENTS);
    }
    return comments;
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
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.COMPONENT_DECL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScopedName getBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBase(ScopedName newBase, NotificationChain msgs)
  {
    ScopedName oldBase = base;
    base = newBase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.COMPONENT_DECL__BASE, oldBase, newBase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(ScopedName newBase)
  {
    if (newBase != base)
    {
      NotificationChain msgs = null;
      if (base != null)
        msgs = ((InternalEObject)base).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.COMPONENT_DECL__BASE, null, msgs);
      if (newBase != null)
        msgs = ((InternalEObject)newBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.COMPONENT_DECL__BASE, null, msgs);
      msgs = basicSetBase(newBase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.COMPONENT_DECL__BASE, newBase, newBase));
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
      supports = new EObjectContainmentEList<ScopedName>(ScopedName.class, this, IdlPackage.COMPONENT_DECL__SUPPORTS);
    }
    return supports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentExport> getExport()
  {
    if (export == null)
    {
      export = new EObjectContainmentEList<ComponentExport>(ComponentExport.class, this, IdlPackage.COMPONENT_DECL__EXPORT);
    }
    return export;
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
      case IdlPackage.COMPONENT_DECL__COMMENTS:
        return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
      case IdlPackage.COMPONENT_DECL__BASE:
        return basicSetBase(null, msgs);
      case IdlPackage.COMPONENT_DECL__SUPPORTS:
        return ((InternalEList<?>)getSupports()).basicRemove(otherEnd, msgs);
      case IdlPackage.COMPONENT_DECL__EXPORT:
        return ((InternalEList<?>)getExport()).basicRemove(otherEnd, msgs);
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
      case IdlPackage.COMPONENT_DECL__COMMENTS:
        return getComments();
      case IdlPackage.COMPONENT_DECL__NAME:
        return getName();
      case IdlPackage.COMPONENT_DECL__BASE:
        return getBase();
      case IdlPackage.COMPONENT_DECL__SUPPORTS:
        return getSupports();
      case IdlPackage.COMPONENT_DECL__EXPORT:
        return getExport();
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
      case IdlPackage.COMPONENT_DECL__COMMENTS:
        getComments().clear();
        getComments().addAll((Collection<? extends IDLComment>)newValue);
        return;
      case IdlPackage.COMPONENT_DECL__NAME:
        setName((String)newValue);
        return;
      case IdlPackage.COMPONENT_DECL__BASE:
        setBase((ScopedName)newValue);
        return;
      case IdlPackage.COMPONENT_DECL__SUPPORTS:
        getSupports().clear();
        getSupports().addAll((Collection<? extends ScopedName>)newValue);
        return;
      case IdlPackage.COMPONENT_DECL__EXPORT:
        getExport().clear();
        getExport().addAll((Collection<? extends ComponentExport>)newValue);
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
      case IdlPackage.COMPONENT_DECL__COMMENTS:
        getComments().clear();
        return;
      case IdlPackage.COMPONENT_DECL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IdlPackage.COMPONENT_DECL__BASE:
        setBase((ScopedName)null);
        return;
      case IdlPackage.COMPONENT_DECL__SUPPORTS:
        getSupports().clear();
        return;
      case IdlPackage.COMPONENT_DECL__EXPORT:
        getExport().clear();
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
      case IdlPackage.COMPONENT_DECL__COMMENTS:
        return comments != null && !comments.isEmpty();
      case IdlPackage.COMPONENT_DECL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IdlPackage.COMPONENT_DECL__BASE:
        return base != null;
      case IdlPackage.COMPONENT_DECL__SUPPORTS:
        return supports != null && !supports.isEmpty();
      case IdlPackage.COMPONENT_DECL__EXPORT:
        return export != null && !export.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ComponentDeclImpl
