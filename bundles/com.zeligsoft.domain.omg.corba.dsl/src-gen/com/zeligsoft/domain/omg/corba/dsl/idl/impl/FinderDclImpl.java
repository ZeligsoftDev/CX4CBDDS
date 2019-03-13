/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls;

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
 * An implementation of the model object '<em><b>Finder Dcl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl#getParams <em>Params</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl#getRaises <em>Raises</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinderDclImpl extends HomeExportImpl implements FinderDcl {
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
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected ParameterDecls params;

	/**
	 * The cached value of the '{@link #getRaises() <em>Raises</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaises()
	 * @generated
	 * @ordered
	 */
	protected ExceptionList raises;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinderDclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IdlPackage.Literals.FINDER_DCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDLComment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentEList<IDLComment>(IDLComment.class, this, IdlPackage.FINDER_DCL__COMMENTS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.FINDER_DCL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDecls getParams() {
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParams(ParameterDecls newParams, NotificationChain msgs) {
		ParameterDecls oldParams = params;
		params = newParams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.FINDER_DCL__PARAMS, oldParams, newParams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParams(ParameterDecls newParams) {
		if (newParams != params) {
			NotificationChain msgs = null;
			if (params != null)
				msgs = ((InternalEObject)params).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FINDER_DCL__PARAMS, null, msgs);
			if (newParams != null)
				msgs = ((InternalEObject)newParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FINDER_DCL__PARAMS, null, msgs);
			msgs = basicSetParams(newParams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.FINDER_DCL__PARAMS, newParams, newParams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionList getRaises() {
		return raises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRaises(ExceptionList newRaises, NotificationChain msgs) {
		ExceptionList oldRaises = raises;
		raises = newRaises;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.FINDER_DCL__RAISES, oldRaises, newRaises);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaises(ExceptionList newRaises) {
		if (newRaises != raises) {
			NotificationChain msgs = null;
			if (raises != null)
				msgs = ((InternalEObject)raises).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FINDER_DCL__RAISES, null, msgs);
			if (newRaises != null)
				msgs = ((InternalEObject)newRaises).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.FINDER_DCL__RAISES, null, msgs);
			msgs = basicSetRaises(newRaises, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.FINDER_DCL__RAISES, newRaises, newRaises));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IdlPackage.FINDER_DCL__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case IdlPackage.FINDER_DCL__PARAMS:
				return basicSetParams(null, msgs);
			case IdlPackage.FINDER_DCL__RAISES:
				return basicSetRaises(null, msgs);
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
			case IdlPackage.FINDER_DCL__COMMENTS:
				return getComments();
			case IdlPackage.FINDER_DCL__NAME:
				return getName();
			case IdlPackage.FINDER_DCL__PARAMS:
				return getParams();
			case IdlPackage.FINDER_DCL__RAISES:
				return getRaises();
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
			case IdlPackage.FINDER_DCL__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends IDLComment>)newValue);
				return;
			case IdlPackage.FINDER_DCL__NAME:
				setName((String)newValue);
				return;
			case IdlPackage.FINDER_DCL__PARAMS:
				setParams((ParameterDecls)newValue);
				return;
			case IdlPackage.FINDER_DCL__RAISES:
				setRaises((ExceptionList)newValue);
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
			case IdlPackage.FINDER_DCL__COMMENTS:
				getComments().clear();
				return;
			case IdlPackage.FINDER_DCL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IdlPackage.FINDER_DCL__PARAMS:
				setParams((ParameterDecls)null);
				return;
			case IdlPackage.FINDER_DCL__RAISES:
				setRaises((ExceptionList)null);
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
			case IdlPackage.FINDER_DCL__COMMENTS:
				return comments != null && !comments.isEmpty();
			case IdlPackage.FINDER_DCL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IdlPackage.FINDER_DCL__PARAMS:
				return params != null;
			case IdlPackage.FINDER_DCL__RAISES:
				return raises != null;
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

} //FinderDclImpl
