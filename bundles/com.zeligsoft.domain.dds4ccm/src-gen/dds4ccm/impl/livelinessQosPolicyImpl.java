/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.Duration;
import dds4ccm.LivelinessQosPolicyKind;
import dds4ccm.livelinessQosPolicy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>liveliness Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.livelinessQosPolicyImpl#getLease_duration <em>Lease duration</em>}</li>
 *   <li>{@link dds4ccm.impl.livelinessQosPolicyImpl#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class livelinessQosPolicyImpl extends qosPolicyImpl implements livelinessQosPolicy {
	/**
	 * The cached value of the '{@link #getLease_duration() <em>Lease duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLease_duration()
	 * @generated
	 * @ordered
	 */
	protected Duration lease_duration;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final LivelinessQosPolicyKind KIND_EDEFAULT = LivelinessQosPolicyKind.AUTOMATIC;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected LivelinessQosPolicyKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected livelinessQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getlivelinessQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration getLease_duration() {
		return lease_duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLease_duration(Duration newLease_duration, NotificationChain msgs) {
		Duration oldLease_duration = lease_duration;
		lease_duration = newLease_duration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION, oldLease_duration, newLease_duration);
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
	public void setLease_duration(Duration newLease_duration) {
		if (newLease_duration != lease_duration) {
			NotificationChain msgs = null;
			if (lease_duration != null)
				msgs = ((InternalEObject)lease_duration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION, null, msgs);
			if (newLease_duration != null)
				msgs = ((InternalEObject)newLease_duration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION, null, msgs);
			msgs = basicSetLease_duration(newLease_duration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION, newLease_duration, newLease_duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LivelinessQosPolicyKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(LivelinessQosPolicyKind newKind) {
		LivelinessQosPolicyKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.LIVELINESS_QOS_POLICY__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION:
				return basicSetLease_duration(null, msgs);
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
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION:
				return getLease_duration();
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__KIND:
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
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION:
				setLease_duration((Duration)newValue);
				return;
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__KIND:
				setKind((LivelinessQosPolicyKind)newValue);
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
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION:
				setLease_duration((Duration)null);
				return;
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__KIND:
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
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__LEASE_DURATION:
				return lease_duration != null;
			case DDS4CCMPackage.LIVELINESS_QOS_POLICY__KIND:
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

} //livelinessQosPolicyImpl
