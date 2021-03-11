/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.wdlQosPolicy;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>wdl Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.wdlQosPolicyImpl#isAutodispose_unregistered_instances <em>Autodispose unregistered instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class wdlQosPolicyImpl extends qosPolicyImpl implements wdlQosPolicy {
	/**
	 * The default value of the '{@link #isAutodispose_unregistered_instances() <em>Autodispose unregistered instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutodispose_unregistered_instances()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTODISPOSE_UNREGISTERED_INSTANCES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAutodispose_unregistered_instances() <em>Autodispose unregistered instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutodispose_unregistered_instances()
	 * @generated
	 * @ordered
	 */
	protected boolean autodispose_unregistered_instances = AUTODISPOSE_UNREGISTERED_INSTANCES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected wdlQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getwdlQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAutodispose_unregistered_instances() {
		return autodispose_unregistered_instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAutodispose_unregistered_instances(boolean newAutodispose_unregistered_instances) {
		boolean oldAutodispose_unregistered_instances = autodispose_unregistered_instances;
		autodispose_unregistered_instances = newAutodispose_unregistered_instances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WDL_QOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES, oldAutodispose_unregistered_instances, autodispose_unregistered_instances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.WDL_QOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES:
				return isAutodispose_unregistered_instances();
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
			case DDS4CCMPackage.WDL_QOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES:
				setAutodispose_unregistered_instances((Boolean)newValue);
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
			case DDS4CCMPackage.WDL_QOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES:
				setAutodispose_unregistered_instances(AUTODISPOSE_UNREGISTERED_INSTANCES_EDEFAULT);
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
			case DDS4CCMPackage.WDL_QOS_POLICY__AUTODISPOSE_UNREGISTERED_INSTANCES:
				return autodispose_unregistered_instances != AUTODISPOSE_UNREGISTERED_INSTANCES_EDEFAULT;
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
		result.append(" (autodispose_unregistered_instances: ");
		result.append(autodispose_unregistered_instances);
		result.append(')');
		return result.toString();
	}

} //wdlQosPolicyImpl
