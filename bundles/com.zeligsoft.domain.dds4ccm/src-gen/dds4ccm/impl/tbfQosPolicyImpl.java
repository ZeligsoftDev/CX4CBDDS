/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.Duration;
import dds4ccm.tbfQosPolicy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>tbf Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.tbfQosPolicyImpl#getMinimum_separation <em>Minimum separation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class tbfQosPolicyImpl extends qosPolicyImpl implements tbfQosPolicy {
	/**
	 * The cached value of the '{@link #getMinimum_separation() <em>Minimum separation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum_separation()
	 * @generated
	 * @ordered
	 */
	protected Duration minimum_separation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected tbfQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.gettbfQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration getMinimum_separation() {
		return minimum_separation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinimum_separation(Duration newMinimum_separation, NotificationChain msgs) {
		Duration oldMinimum_separation = minimum_separation;
		minimum_separation = newMinimum_separation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION, oldMinimum_separation, newMinimum_separation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimum_separation(Duration newMinimum_separation) {
		if (newMinimum_separation != minimum_separation) {
			NotificationChain msgs = null;
			if (minimum_separation != null)
				msgs = ((InternalEObject)minimum_separation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION, null, msgs);
			if (newMinimum_separation != null)
				msgs = ((InternalEObject)newMinimum_separation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION, null, msgs);
			msgs = basicSetMinimum_separation(newMinimum_separation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION, newMinimum_separation, newMinimum_separation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION:
				return basicSetMinimum_separation(null, msgs);
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
			case DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION:
				return getMinimum_separation();
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
			case DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION:
				setMinimum_separation((Duration)newValue);
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
			case DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION:
				setMinimum_separation((Duration)null);
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
			case DDS4CCMPackage.TBF_QOS_POLICY__MINIMUM_SEPARATION:
				return minimum_separation != null;
		}
		return super.eIsSet(featureID);
	}

} //tbfQosPolicyImpl
