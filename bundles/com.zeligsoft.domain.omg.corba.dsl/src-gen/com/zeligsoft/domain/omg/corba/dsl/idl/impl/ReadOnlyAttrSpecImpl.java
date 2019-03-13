/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Read Only Attr Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ReadOnlyAttrSpecImpl#getRaises <em>Raises</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReadOnlyAttrSpecImpl extends AttrDeclImpl implements ReadOnlyAttrSpec {
	/**
	 * The cached value of the '{@link #getRaises() <em>Raises</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaises()
	 * @generated
	 * @ordered
	 */
	protected AttrRaisesExpr raises;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadOnlyAttrSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IdlPackage.Literals.READ_ONLY_ATTR_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttrRaisesExpr getRaises() {
		return raises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRaises(AttrRaisesExpr newRaises, NotificationChain msgs) {
		AttrRaisesExpr oldRaises = raises;
		raises = newRaises;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.READ_ONLY_ATTR_SPEC__RAISES, oldRaises, newRaises);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaises(AttrRaisesExpr newRaises) {
		if (newRaises != raises) {
			NotificationChain msgs = null;
			if (raises != null)
				msgs = ((InternalEObject)raises).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.READ_ONLY_ATTR_SPEC__RAISES, null, msgs);
			if (newRaises != null)
				msgs = ((InternalEObject)newRaises).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.READ_ONLY_ATTR_SPEC__RAISES, null, msgs);
			msgs = basicSetRaises(newRaises, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.READ_ONLY_ATTR_SPEC__RAISES, newRaises, newRaises));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IdlPackage.READ_ONLY_ATTR_SPEC__RAISES:
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
			case IdlPackage.READ_ONLY_ATTR_SPEC__RAISES:
				return getRaises();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IdlPackage.READ_ONLY_ATTR_SPEC__RAISES:
				setRaises((AttrRaisesExpr)newValue);
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
			case IdlPackage.READ_ONLY_ATTR_SPEC__RAISES:
				setRaises((AttrRaisesExpr)null);
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
			case IdlPackage.READ_ONLY_ATTR_SPEC__RAISES:
				return raises != null;
		}
		return super.eIsSet(featureID);
	}

} //ReadOnlyAttrSpecImpl
