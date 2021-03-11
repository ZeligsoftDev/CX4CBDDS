/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.Duration;
import dds4ccm.rdlQosPolicy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>rdl Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.rdlQosPolicyImpl#getAutopurge_nowriter_samples_delay <em>Autopurge nowriter samples delay</em>}</li>
 *   <li>{@link dds4ccm.impl.rdlQosPolicyImpl#getAutopurge_disposed_samples_delay <em>Autopurge disposed samples delay</em>}</li>
 * </ul>
 *
 * @generated
 */
public class rdlQosPolicyImpl extends qosPolicyImpl implements rdlQosPolicy {
	/**
	 * The cached value of the '{@link #getAutopurge_nowriter_samples_delay() <em>Autopurge nowriter samples delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutopurge_nowriter_samples_delay()
	 * @generated
	 * @ordered
	 */
	protected Duration autopurge_nowriter_samples_delay;

	/**
	 * The cached value of the '{@link #getAutopurge_disposed_samples_delay() <em>Autopurge disposed samples delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutopurge_disposed_samples_delay()
	 * @generated
	 * @ordered
	 */
	protected Duration autopurge_disposed_samples_delay;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected rdlQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getrdlQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration getAutopurge_nowriter_samples_delay() {
		return autopurge_nowriter_samples_delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAutopurge_nowriter_samples_delay(Duration newAutopurge_nowriter_samples_delay, NotificationChain msgs) {
		Duration oldAutopurge_nowriter_samples_delay = autopurge_nowriter_samples_delay;
		autopurge_nowriter_samples_delay = newAutopurge_nowriter_samples_delay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY, oldAutopurge_nowriter_samples_delay, newAutopurge_nowriter_samples_delay);
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
	public void setAutopurge_nowriter_samples_delay(Duration newAutopurge_nowriter_samples_delay) {
		if (newAutopurge_nowriter_samples_delay != autopurge_nowriter_samples_delay) {
			NotificationChain msgs = null;
			if (autopurge_nowriter_samples_delay != null)
				msgs = ((InternalEObject)autopurge_nowriter_samples_delay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY, null, msgs);
			if (newAutopurge_nowriter_samples_delay != null)
				msgs = ((InternalEObject)newAutopurge_nowriter_samples_delay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY, null, msgs);
			msgs = basicSetAutopurge_nowriter_samples_delay(newAutopurge_nowriter_samples_delay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY, newAutopurge_nowriter_samples_delay, newAutopurge_nowriter_samples_delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration getAutopurge_disposed_samples_delay() {
		return autopurge_disposed_samples_delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAutopurge_disposed_samples_delay(Duration newAutopurge_disposed_samples_delay, NotificationChain msgs) {
		Duration oldAutopurge_disposed_samples_delay = autopurge_disposed_samples_delay;
		autopurge_disposed_samples_delay = newAutopurge_disposed_samples_delay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY, oldAutopurge_disposed_samples_delay, newAutopurge_disposed_samples_delay);
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
	public void setAutopurge_disposed_samples_delay(Duration newAutopurge_disposed_samples_delay) {
		if (newAutopurge_disposed_samples_delay != autopurge_disposed_samples_delay) {
			NotificationChain msgs = null;
			if (autopurge_disposed_samples_delay != null)
				msgs = ((InternalEObject)autopurge_disposed_samples_delay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY, null, msgs);
			if (newAutopurge_disposed_samples_delay != null)
				msgs = ((InternalEObject)newAutopurge_disposed_samples_delay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY, null, msgs);
			msgs = basicSetAutopurge_disposed_samples_delay(newAutopurge_disposed_samples_delay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY, newAutopurge_disposed_samples_delay, newAutopurge_disposed_samples_delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY:
				return basicSetAutopurge_nowriter_samples_delay(null, msgs);
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY:
				return basicSetAutopurge_disposed_samples_delay(null, msgs);
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
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY:
				return getAutopurge_nowriter_samples_delay();
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY:
				return getAutopurge_disposed_samples_delay();
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
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY:
				setAutopurge_nowriter_samples_delay((Duration)newValue);
				return;
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY:
				setAutopurge_disposed_samples_delay((Duration)newValue);
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
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY:
				setAutopurge_nowriter_samples_delay((Duration)null);
				return;
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY:
				setAutopurge_disposed_samples_delay((Duration)null);
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
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_NOWRITER_SAMPLES_DELAY:
				return autopurge_nowriter_samples_delay != null;
			case DDS4CCMPackage.RDL_QOS_POLICY__AUTOPURGE_DISPOSED_SAMPLES_DELAY:
				return autopurge_disposed_samples_delay != null;
		}
		return super.eIsSet(featureID);
	}

} //rdlQosPolicyImpl
