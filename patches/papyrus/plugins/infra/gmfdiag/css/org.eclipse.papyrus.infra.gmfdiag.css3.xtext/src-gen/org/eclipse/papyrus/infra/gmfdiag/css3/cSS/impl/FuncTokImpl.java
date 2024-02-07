/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Func Tok</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.FuncTokImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.FuncTokImpl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FuncTokImpl extends CssTokImpl implements FuncTok {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected IdentifierTok name;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<CssTok> params;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected FuncTokImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSSPackage.Literals.FUNC_TOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public IdentifierTok getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetName(IdentifierTok newName, NotificationChain msgs) {
		IdentifierTok oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSSPackage.FUNC_TOK__NAME, oldName, newName);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(IdentifierTok newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null) {
				msgs = ((InternalEObject) name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSSPackage.FUNC_TOK__NAME, null, msgs);
			}
			if (newName != null) {
				msgs = ((InternalEObject) newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSSPackage.FUNC_TOK__NAME, null, msgs);
			}
			msgs = basicSetName(newName, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CSSPackage.FUNC_TOK__NAME, newName, newName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<CssTok> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<>(CssTok.class, this, CSSPackage.FUNC_TOK__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CSSPackage.FUNC_TOK__NAME:
			return basicSetName(null, msgs);
		case CSSPackage.FUNC_TOK__PARAMS:
			return ((InternalEList<?>) getParams()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CSSPackage.FUNC_TOK__NAME:
			return getName();
		case CSSPackage.FUNC_TOK__PARAMS:
			return getParams();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CSSPackage.FUNC_TOK__NAME:
			setName((IdentifierTok) newValue);
			return;
		case CSSPackage.FUNC_TOK__PARAMS:
			getParams().clear();
			getParams().addAll((Collection<? extends CssTok>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CSSPackage.FUNC_TOK__NAME:
			setName((IdentifierTok) null);
			return;
		case CSSPackage.FUNC_TOK__PARAMS:
			getParams().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CSSPackage.FUNC_TOK__NAME:
			return name != null;
		case CSSPackage.FUNC_TOK__PARAMS:
			return params != null && !params.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // FuncTokImpl
