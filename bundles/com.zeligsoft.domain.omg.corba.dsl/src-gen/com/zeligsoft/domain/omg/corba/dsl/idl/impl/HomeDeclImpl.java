/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec;
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
 * An implementation of the model object '<em><b>Home Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getBase <em>Base</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getSupports <em>Supports</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getManages <em>Manages</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getPrimary_key <em>Primary key</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl#getExport <em>Export</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HomeDeclImpl extends DefinitionImpl implements HomeDecl {
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
	 * The cached value of the '{@link #getManages() <em>Manages</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManages()
	 * @generated
	 * @ordered
	 */
	protected ScopedName manages;

	/**
	 * The cached value of the '{@link #getPrimary_key() <em>Primary key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimary_key()
	 * @generated
	 * @ordered
	 */
	protected PrimaryKeySpec primary_key;

	/**
	 * The cached value of the '{@link #getExport() <em>Export</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExport()
	 * @generated
	 * @ordered
	 */
	protected EList<HomeExport> export;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HomeDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IdlPackage.Literals.HOME_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDLComment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentEList<IDLComment>(IDLComment.class, this, IdlPackage.HOME_DECL__COMMENTS);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopedName getBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBase(ScopedName newBase, NotificationChain msgs) {
		ScopedName oldBase = base;
		base = newBase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__BASE, oldBase, newBase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(ScopedName newBase) {
		if (newBase != base) {
			NotificationChain msgs = null;
			if (base != null)
				msgs = ((InternalEObject)base).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.HOME_DECL__BASE, null, msgs);
			if (newBase != null)
				msgs = ((InternalEObject)newBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.HOME_DECL__BASE, null, msgs);
			msgs = basicSetBase(newBase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__BASE, newBase, newBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScopedName> getSupports() {
		if (supports == null) {
			supports = new EObjectContainmentEList<ScopedName>(ScopedName.class, this, IdlPackage.HOME_DECL__SUPPORTS);
		}
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopedName getManages() {
		return manages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManages(ScopedName newManages, NotificationChain msgs) {
		ScopedName oldManages = manages;
		manages = newManages;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__MANAGES, oldManages, newManages);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManages(ScopedName newManages) {
		if (newManages != manages) {
			NotificationChain msgs = null;
			if (manages != null)
				msgs = ((InternalEObject)manages).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.HOME_DECL__MANAGES, null, msgs);
			if (newManages != null)
				msgs = ((InternalEObject)newManages).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.HOME_DECL__MANAGES, null, msgs);
			msgs = basicSetManages(newManages, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__MANAGES, newManages, newManages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryKeySpec getPrimary_key() {
		return primary_key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimary_key(PrimaryKeySpec newPrimary_key, NotificationChain msgs) {
		PrimaryKeySpec oldPrimary_key = primary_key;
		primary_key = newPrimary_key;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__PRIMARY_KEY, oldPrimary_key, newPrimary_key);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary_key(PrimaryKeySpec newPrimary_key) {
		if (newPrimary_key != primary_key) {
			NotificationChain msgs = null;
			if (primary_key != null)
				msgs = ((InternalEObject)primary_key).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.HOME_DECL__PRIMARY_KEY, null, msgs);
			if (newPrimary_key != null)
				msgs = ((InternalEObject)newPrimary_key).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.HOME_DECL__PRIMARY_KEY, null, msgs);
			msgs = basicSetPrimary_key(newPrimary_key, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.HOME_DECL__PRIMARY_KEY, newPrimary_key, newPrimary_key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HomeExport> getExport() {
		if (export == null) {
			export = new EObjectContainmentEList<HomeExport>(HomeExport.class, this, IdlPackage.HOME_DECL__EXPORT);
		}
		return export;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IdlPackage.HOME_DECL__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case IdlPackage.HOME_DECL__BASE:
				return basicSetBase(null, msgs);
			case IdlPackage.HOME_DECL__SUPPORTS:
				return ((InternalEList<?>)getSupports()).basicRemove(otherEnd, msgs);
			case IdlPackage.HOME_DECL__MANAGES:
				return basicSetManages(null, msgs);
			case IdlPackage.HOME_DECL__PRIMARY_KEY:
				return basicSetPrimary_key(null, msgs);
			case IdlPackage.HOME_DECL__EXPORT:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IdlPackage.HOME_DECL__COMMENTS:
				return getComments();
			case IdlPackage.HOME_DECL__NAME:
				return getName();
			case IdlPackage.HOME_DECL__BASE:
				return getBase();
			case IdlPackage.HOME_DECL__SUPPORTS:
				return getSupports();
			case IdlPackage.HOME_DECL__MANAGES:
				return getManages();
			case IdlPackage.HOME_DECL__PRIMARY_KEY:
				return getPrimary_key();
			case IdlPackage.HOME_DECL__EXPORT:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IdlPackage.HOME_DECL__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends IDLComment>)newValue);
				return;
			case IdlPackage.HOME_DECL__NAME:
				setName((String)newValue);
				return;
			case IdlPackage.HOME_DECL__BASE:
				setBase((ScopedName)newValue);
				return;
			case IdlPackage.HOME_DECL__SUPPORTS:
				getSupports().clear();
				getSupports().addAll((Collection<? extends ScopedName>)newValue);
				return;
			case IdlPackage.HOME_DECL__MANAGES:
				setManages((ScopedName)newValue);
				return;
			case IdlPackage.HOME_DECL__PRIMARY_KEY:
				setPrimary_key((PrimaryKeySpec)newValue);
				return;
			case IdlPackage.HOME_DECL__EXPORT:
				getExport().clear();
				getExport().addAll((Collection<? extends HomeExport>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case IdlPackage.HOME_DECL__COMMENTS:
				getComments().clear();
				return;
			case IdlPackage.HOME_DECL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IdlPackage.HOME_DECL__BASE:
				setBase((ScopedName)null);
				return;
			case IdlPackage.HOME_DECL__SUPPORTS:
				getSupports().clear();
				return;
			case IdlPackage.HOME_DECL__MANAGES:
				setManages((ScopedName)null);
				return;
			case IdlPackage.HOME_DECL__PRIMARY_KEY:
				setPrimary_key((PrimaryKeySpec)null);
				return;
			case IdlPackage.HOME_DECL__EXPORT:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IdlPackage.HOME_DECL__COMMENTS:
				return comments != null && !comments.isEmpty();
			case IdlPackage.HOME_DECL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IdlPackage.HOME_DECL__BASE:
				return base != null;
			case IdlPackage.HOME_DECL__SUPPORTS:
				return supports != null && !supports.isEmpty();
			case IdlPackage.HOME_DECL__MANAGES:
				return manages != null;
			case IdlPackage.HOME_DECL__PRIMARY_KEY:
				return primary_key != null;
			case IdlPackage.HOME_DECL__EXPORT:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //HomeDeclImpl
