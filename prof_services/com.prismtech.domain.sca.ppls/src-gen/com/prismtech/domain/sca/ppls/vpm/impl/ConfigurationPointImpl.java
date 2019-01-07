/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.impl;

import com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint;
import com.prismtech.domain.sca.ppls.vpm.VariationPoint;
import com.prismtech.domain.sca.ppls.vpm.VpmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl#isGenerate <em>Generate</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.impl.ConfigurationPointImpl#getVariationPoint <em>Variation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationPointImpl extends EObjectImpl implements ConfigurationPoint {
	/**
	 * The default value of the '{@link #isGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerate()
	 * @generated
	 * @ordered
	 */
	protected boolean generate = GENERATE_EDEFAULT;

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
	 * The cached value of the '{@link #getVariationPoint() <em>Variation Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariationPoint()
	 * @generated
	 * @ordered
	 */
	protected VariationPoint variationPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VpmPackage.Literals.CONFIGURATION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerate() {
		return generate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerate(boolean newGenerate) {
		boolean oldGenerate = generate;
		generate = newGenerate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VpmPackage.CONFIGURATION_POINT__GENERATE, oldGenerate, generate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VpmPackage.CONFIGURATION_POINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint getVariationPoint() {
		if (variationPoint != null && variationPoint.eIsProxy()) {
			InternalEObject oldVariationPoint = (InternalEObject)variationPoint;
			variationPoint = (VariationPoint)eResolveProxy(oldVariationPoint);
			if (variationPoint != oldVariationPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VpmPackage.CONFIGURATION_POINT__VARIATION_POINT, oldVariationPoint, variationPoint));
			}
		}
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariationPoint basicGetVariationPoint() {
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariationPoint(VariationPoint newVariationPoint) {
		VariationPoint oldVariationPoint = variationPoint;
		variationPoint = newVariationPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VpmPackage.CONFIGURATION_POINT__VARIATION_POINT, oldVariationPoint, variationPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VpmPackage.CONFIGURATION_POINT__GENERATE:
				return isGenerate();
			case VpmPackage.CONFIGURATION_POINT__NAME:
				return getName();
			case VpmPackage.CONFIGURATION_POINT__VARIATION_POINT:
				if (resolve) return getVariationPoint();
				return basicGetVariationPoint();
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
			case VpmPackage.CONFIGURATION_POINT__GENERATE:
				setGenerate((Boolean)newValue);
				return;
			case VpmPackage.CONFIGURATION_POINT__NAME:
				setName((String)newValue);
				return;
			case VpmPackage.CONFIGURATION_POINT__VARIATION_POINT:
				setVariationPoint((VariationPoint)newValue);
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
			case VpmPackage.CONFIGURATION_POINT__GENERATE:
				setGenerate(GENERATE_EDEFAULT);
				return;
			case VpmPackage.CONFIGURATION_POINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VpmPackage.CONFIGURATION_POINT__VARIATION_POINT:
				setVariationPoint((VariationPoint)null);
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
			case VpmPackage.CONFIGURATION_POINT__GENERATE:
				return generate != GENERATE_EDEFAULT;
			case VpmPackage.CONFIGURATION_POINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VpmPackage.CONFIGURATION_POINT__VARIATION_POINT:
				return variationPoint != null;
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
		result.append(" (generate: ");
		result.append(generate);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ConfigurationPointImpl
