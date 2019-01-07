/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.impl;

import com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings;
import com.prismtech.domain.sca.ppls.vpm.SettableAttribute;
import com.prismtech.domain.sca.ppls.vpm.VpmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Point With Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointWithSettingsImpl#getSettableAttributes <em>Settable Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationPointWithSettingsImpl extends ConfigurationPointImpl implements ConfigurationPointWithSettings {
	/**
	 * The cached value of the '{@link #getSettableAttributes() <em>Settable Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettableAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<SettableAttribute> settableAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationPointWithSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VpmPackage.Literals.CONFIGURATION_POINT_WITH_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SettableAttribute> getSettableAttributes() {
		if (settableAttributes == null) {
			settableAttributes = new EObjectContainmentEList<SettableAttribute>(SettableAttribute.class, this, VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES);
		}
		return settableAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES:
				return ((InternalEList<?>)getSettableAttributes()).basicRemove(otherEnd, msgs);
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
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES:
				return getSettableAttributes();
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
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES:
				getSettableAttributes().clear();
				getSettableAttributes().addAll((Collection<? extends SettableAttribute>)newValue);
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
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES:
				getSettableAttributes().clear();
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
			case VpmPackage.CONFIGURATION_POINT_WITH_SETTINGS__SETTABLE_ATTRIBUTES:
				return settableAttributes != null && !settableAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationPointWithSettingsImpl
