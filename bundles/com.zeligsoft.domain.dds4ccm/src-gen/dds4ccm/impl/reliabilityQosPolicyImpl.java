/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.Duration;
import dds4ccm.RealiabilityQosPolicyKind;
import dds4ccm.reliabilityQosPolicy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>reliability Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.reliabilityQosPolicyImpl#getMax_blocking_time <em>Max blocking time</em>}</li>
 *   <li>{@link dds4ccm.impl.reliabilityQosPolicyImpl#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class reliabilityQosPolicyImpl extends qosPolicyImpl implements reliabilityQosPolicy {
	/**
	 * The cached value of the '{@link #getMax_blocking_time() <em>Max blocking time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_blocking_time()
	 * @generated
	 * @ordered
	 */
	protected Duration max_blocking_time;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final RealiabilityQosPolicyKind KIND_EDEFAULT = RealiabilityQosPolicyKind.BEST_EFFORT;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected RealiabilityQosPolicyKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected reliabilityQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getreliabilityQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration getMax_blocking_time() {
		return max_blocking_time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMax_blocking_time(Duration newMax_blocking_time, NotificationChain msgs) {
		Duration oldMax_blocking_time = max_blocking_time;
		max_blocking_time = newMax_blocking_time;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME, oldMax_blocking_time, newMax_blocking_time);
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
	public void setMax_blocking_time(Duration newMax_blocking_time) {
		if (newMax_blocking_time != max_blocking_time) {
			NotificationChain msgs = null;
			if (max_blocking_time != null)
				msgs = ((InternalEObject)max_blocking_time).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME, null, msgs);
			if (newMax_blocking_time != null)
				msgs = ((InternalEObject)newMax_blocking_time).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME, null, msgs);
			msgs = basicSetMax_blocking_time(newMax_blocking_time, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME, newMax_blocking_time, newMax_blocking_time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealiabilityQosPolicyKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(RealiabilityQosPolicyKind newKind) {
		RealiabilityQosPolicyKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RELIABILITY_QOS_POLICY__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME:
				return basicSetMax_blocking_time(null, msgs);
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
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME:
				return getMax_blocking_time();
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__KIND:
				return getKind();
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
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME:
				setMax_blocking_time((Duration)newValue);
				return;
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__KIND:
				setKind((RealiabilityQosPolicyKind)newValue);
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
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME:
				setMax_blocking_time((Duration)null);
				return;
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__KIND:
				setKind(KIND_EDEFAULT);
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
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__MAX_BLOCKING_TIME:
				return max_blocking_time != null;
			case DDS4CCMPackage.RELIABILITY_QOS_POLICY__KIND:
				return kind != KIND_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //reliabilityQosPolicyImpl
