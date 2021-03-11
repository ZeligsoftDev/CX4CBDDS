/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.rlQosPolicy;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>rl Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.rlQosPolicyImpl#getMax_instances <em>Max instances</em>}</li>
 *   <li>{@link dds4ccm.impl.rlQosPolicyImpl#getMax_samples <em>Max samples</em>}</li>
 *   <li>{@link dds4ccm.impl.rlQosPolicyImpl#getMax_samples_per_instance <em>Max samples per instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class rlQosPolicyImpl extends qosPolicyImpl implements rlQosPolicy {
	/**
	 * The default value of the '{@link #getMax_instances() <em>Max instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_instances()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_INSTANCES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMax_instances() <em>Max instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_instances()
	 * @generated
	 * @ordered
	 */
	protected int max_instances = MAX_INSTANCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax_samples() <em>Max samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_samples()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_SAMPLES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMax_samples() <em>Max samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_samples()
	 * @generated
	 * @ordered
	 */
	protected int max_samples = MAX_SAMPLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax_samples_per_instance() <em>Max samples per instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_samples_per_instance()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_SAMPLES_PER_INSTANCE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMax_samples_per_instance() <em>Max samples per instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_samples_per_instance()
	 * @generated
	 * @ordered
	 */
	protected int max_samples_per_instance = MAX_SAMPLES_PER_INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected rlQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getrlQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMax_instances() {
		return max_instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMax_instances(int newMax_instances) {
		int oldMax_instances = max_instances;
		max_instances = newMax_instances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RL_QOS_POLICY__MAX_INSTANCES, oldMax_instances, max_instances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMax_samples() {
		return max_samples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMax_samples(int newMax_samples) {
		int oldMax_samples = max_samples;
		max_samples = newMax_samples;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES, oldMax_samples, max_samples));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMax_samples_per_instance() {
		return max_samples_per_instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMax_samples_per_instance(int newMax_samples_per_instance) {
		int oldMax_samples_per_instance = max_samples_per_instance;
		max_samples_per_instance = newMax_samples_per_instance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE, oldMax_samples_per_instance, max_samples_per_instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_INSTANCES:
				return getMax_instances();
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES:
				return getMax_samples();
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				return getMax_samples_per_instance();
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
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_INSTANCES:
				setMax_instances((Integer)newValue);
				return;
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES:
				setMax_samples((Integer)newValue);
				return;
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				setMax_samples_per_instance((Integer)newValue);
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
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_INSTANCES:
				setMax_instances(MAX_INSTANCES_EDEFAULT);
				return;
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES:
				setMax_samples(MAX_SAMPLES_EDEFAULT);
				return;
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				setMax_samples_per_instance(MAX_SAMPLES_PER_INSTANCE_EDEFAULT);
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
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_INSTANCES:
				return max_instances != MAX_INSTANCES_EDEFAULT;
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES:
				return max_samples != MAX_SAMPLES_EDEFAULT;
			case DDS4CCMPackage.RL_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				return max_samples_per_instance != MAX_SAMPLES_PER_INSTANCE_EDEFAULT;
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
		result.append(" (max_instances: ");
		result.append(max_instances);
		result.append(", max_samples: ");
		result.append(max_samples);
		result.append(", max_samples_per_instance: ");
		result.append(max_samples_per_instance);
		result.append(')');
		return result.toString();
	}

} //rlQosPolicyImpl
