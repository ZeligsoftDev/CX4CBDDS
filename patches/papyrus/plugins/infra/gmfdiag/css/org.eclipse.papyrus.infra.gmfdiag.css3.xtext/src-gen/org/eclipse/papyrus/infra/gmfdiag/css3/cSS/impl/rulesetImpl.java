/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ruleset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.rulesetImpl#getSelectors <em>Selectors</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.rulesetImpl#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class rulesetImpl extends MinimalEObjectImpl.Container implements ruleset {
	/**
	 * The cached value of the '{@link #getSelectors() <em>Selectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSelectors()
	 * @generated
	 * @ordered
	 */
	protected EList<selector> selectors;

	/**
	 * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<css_declaration> declarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected rulesetImpl() {
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
		return CSSPackage.Literals.RULESET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<selector> getSelectors() {
		if (selectors == null) {
			selectors = new EObjectContainmentEList<>(selector.class, this, CSSPackage.RULESET__SELECTORS);
		}
		return selectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<css_declaration> getDeclarations() {
		if (declarations == null) {
			declarations = new EObjectContainmentEList<>(css_declaration.class, this, CSSPackage.RULESET__DECLARATIONS);
		}
		return declarations;
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
		case CSSPackage.RULESET__SELECTORS:
			return ((InternalEList<?>) getSelectors()).basicRemove(otherEnd, msgs);
		case CSSPackage.RULESET__DECLARATIONS:
			return ((InternalEList<?>) getDeclarations()).basicRemove(otherEnd, msgs);
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
		case CSSPackage.RULESET__SELECTORS:
			return getSelectors();
		case CSSPackage.RULESET__DECLARATIONS:
			return getDeclarations();
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
		case CSSPackage.RULESET__SELECTORS:
			getSelectors().clear();
			getSelectors().addAll((Collection<? extends selector>) newValue);
			return;
		case CSSPackage.RULESET__DECLARATIONS:
			getDeclarations().clear();
			getDeclarations().addAll((Collection<? extends css_declaration>) newValue);
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
		case CSSPackage.RULESET__SELECTORS:
			getSelectors().clear();
			return;
		case CSSPackage.RULESET__DECLARATIONS:
			getDeclarations().clear();
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
		case CSSPackage.RULESET__SELECTORS:
			return selectors != null && !selectors.isEmpty();
		case CSSPackage.RULESET__DECLARATIONS:
			return declarations != null && !declarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // rulesetImpl
