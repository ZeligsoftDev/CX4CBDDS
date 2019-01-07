/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.impl;

import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.VpmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl#getConfigurationPoints <em>Configuration Points</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationImpl#isGenerateDescriptors <em>Generate Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getConfigurationPoints() <em>Configuration Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigurationPoint> configurationPoints;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "VPModelConfig_";

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
	 * The default value of the '{@link #isGenerateDescriptors() <em>Generate Descriptors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateDescriptors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_DESCRIPTORS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGenerateDescriptors() <em>Generate Descriptors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateDescriptors()
	 * @generated
	 * @ordered
	 */
	protected boolean generateDescriptors = GENERATE_DESCRIPTORS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VpmPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigurationPoint> getConfigurationPoints() {
		if (configurationPoints == null) {
			configurationPoints = new EObjectContainmentEList<ConfigurationPoint>(ConfigurationPoint.class, this, VpmPackage.CONFIGURATION__CONFIGURATION_POINTS);
		}
		return configurationPoints;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VpmPackage.CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateDescriptors() {
		return generateDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateDescriptors(boolean newGenerateDescriptors) {
		boolean oldGenerateDescriptors = generateDescriptors;
		generateDescriptors = newGenerateDescriptors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VpmPackage.CONFIGURATION__GENERATE_DESCRIPTORS, oldGenerateDescriptors, generateDescriptors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VpmPackage.CONFIGURATION__CONFIGURATION_POINTS:
				return ((InternalEList<?>)getConfigurationPoints()).basicRemove(otherEnd, msgs);
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
			case VpmPackage.CONFIGURATION__CONFIGURATION_POINTS:
				return getConfigurationPoints();
			case VpmPackage.CONFIGURATION__NAME:
				return getName();
			case VpmPackage.CONFIGURATION__GENERATE_DESCRIPTORS:
				return isGenerateDescriptors();
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
			case VpmPackage.CONFIGURATION__CONFIGURATION_POINTS:
				getConfigurationPoints().clear();
				getConfigurationPoints().addAll((Collection<? extends ConfigurationPoint>)newValue);
				return;
			case VpmPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case VpmPackage.CONFIGURATION__GENERATE_DESCRIPTORS:
				setGenerateDescriptors((Boolean)newValue);
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
			case VpmPackage.CONFIGURATION__CONFIGURATION_POINTS:
				getConfigurationPoints().clear();
				return;
			case VpmPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VpmPackage.CONFIGURATION__GENERATE_DESCRIPTORS:
				setGenerateDescriptors(GENERATE_DESCRIPTORS_EDEFAULT);
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
			case VpmPackage.CONFIGURATION__CONFIGURATION_POINTS:
				return configurationPoints != null && !configurationPoints.isEmpty();
			case VpmPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VpmPackage.CONFIGURATION__GENERATE_DESCRIPTORS:
				return generateDescriptors != GENERATE_DESCRIPTORS_EDEFAULT;
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
		result.append(", generateDescriptors: ");
		result.append(generateDescriptors);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
