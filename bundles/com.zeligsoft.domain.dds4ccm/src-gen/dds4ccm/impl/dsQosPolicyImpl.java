/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.Duration;
import dds4ccm.HistoryQosPolicyKind;
import dds4ccm.dsQosPolicy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ds Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.dsQosPolicyImpl#getService_cleanup_delay <em>Service cleanup delay</em>}</li>
 *   <li>{@link dds4ccm.impl.dsQosPolicyImpl#getHistory_kind <em>History kind</em>}</li>
 *   <li>{@link dds4ccm.impl.dsQosPolicyImpl#getMax_instances <em>Max instances</em>}</li>
 *   <li>{@link dds4ccm.impl.dsQosPolicyImpl#getMax_samples <em>Max samples</em>}</li>
 *   <li>{@link dds4ccm.impl.dsQosPolicyImpl#getMax_samples_per_instance <em>Max samples per instance</em>}</li>
 *   <li>{@link dds4ccm.impl.dsQosPolicyImpl#getHistory_depth <em>History depth</em>}</li>
 * </ul>
 *
 * @generated
 */
public class dsQosPolicyImpl extends qosPolicyImpl implements dsQosPolicy {
	/**
	 * The cached value of the '{@link #getService_cleanup_delay() <em>Service cleanup delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService_cleanup_delay()
	 * @generated
	 * @ordered
	 */
	protected Duration service_cleanup_delay;

	/**
	 * The default value of the '{@link #getHistory_kind() <em>History kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistory_kind()
	 * @generated
	 * @ordered
	 */
	protected static final HistoryQosPolicyKind HISTORY_KIND_EDEFAULT = HistoryQosPolicyKind.KEEP_LAST;

	/**
	 * The cached value of the '{@link #getHistory_kind() <em>History kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistory_kind()
	 * @generated
	 * @ordered
	 */
	protected HistoryQosPolicyKind history_kind = HISTORY_KIND_EDEFAULT;

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
	 * The default value of the '{@link #getHistory_depth() <em>History depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistory_depth()
	 * @generated
	 * @ordered
	 */
	protected static final int HISTORY_DEPTH_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getHistory_depth() <em>History depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistory_depth()
	 * @generated
	 * @ordered
	 */
	protected int history_depth = HISTORY_DEPTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected dsQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getdsQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Duration getService_cleanup_delay() {
		return service_cleanup_delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService_cleanup_delay(Duration newService_cleanup_delay, NotificationChain msgs) {
		Duration oldService_cleanup_delay = service_cleanup_delay;
		service_cleanup_delay = newService_cleanup_delay;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY, oldService_cleanup_delay, newService_cleanup_delay);
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
	public void setService_cleanup_delay(Duration newService_cleanup_delay) {
		if (newService_cleanup_delay != service_cleanup_delay) {
			NotificationChain msgs = null;
			if (service_cleanup_delay != null)
				msgs = ((InternalEObject)service_cleanup_delay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY, null, msgs);
			if (newService_cleanup_delay != null)
				msgs = ((InternalEObject)newService_cleanup_delay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY, null, msgs);
			msgs = basicSetService_cleanup_delay(newService_cleanup_delay, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY, newService_cleanup_delay, newService_cleanup_delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HistoryQosPolicyKind getHistory_kind() {
		return history_kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHistory_kind(HistoryQosPolicyKind newHistory_kind) {
		HistoryQosPolicyKind oldHistory_kind = history_kind;
		history_kind = newHistory_kind == null ? HISTORY_KIND_EDEFAULT : newHistory_kind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__HISTORY_KIND, oldHistory_kind, history_kind));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__MAX_INSTANCES, oldMax_instances, max_instances));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES, oldMax_samples, max_samples));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE, oldMax_samples_per_instance, max_samples_per_instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHistory_depth() {
		return history_depth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHistory_depth(int newHistory_depth) {
		int oldHistory_depth = history_depth;
		history_depth = newHistory_depth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DS_QOS_POLICY__HISTORY_DEPTH, oldHistory_depth, history_depth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY:
				return basicSetService_cleanup_delay(null, msgs);
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
			case DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY:
				return getService_cleanup_delay();
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_KIND:
				return getHistory_kind();
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_INSTANCES:
				return getMax_instances();
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES:
				return getMax_samples();
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				return getMax_samples_per_instance();
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_DEPTH:
				return getHistory_depth();
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
			case DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY:
				setService_cleanup_delay((Duration)newValue);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_KIND:
				setHistory_kind((HistoryQosPolicyKind)newValue);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_INSTANCES:
				setMax_instances((Integer)newValue);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES:
				setMax_samples((Integer)newValue);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				setMax_samples_per_instance((Integer)newValue);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_DEPTH:
				setHistory_depth((Integer)newValue);
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
			case DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY:
				setService_cleanup_delay((Duration)null);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_KIND:
				setHistory_kind(HISTORY_KIND_EDEFAULT);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_INSTANCES:
				setMax_instances(MAX_INSTANCES_EDEFAULT);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES:
				setMax_samples(MAX_SAMPLES_EDEFAULT);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				setMax_samples_per_instance(MAX_SAMPLES_PER_INSTANCE_EDEFAULT);
				return;
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_DEPTH:
				setHistory_depth(HISTORY_DEPTH_EDEFAULT);
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
			case DDS4CCMPackage.DS_QOS_POLICY__SERVICE_CLEANUP_DELAY:
				return service_cleanup_delay != null;
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_KIND:
				return history_kind != HISTORY_KIND_EDEFAULT;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_INSTANCES:
				return max_instances != MAX_INSTANCES_EDEFAULT;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES:
				return max_samples != MAX_SAMPLES_EDEFAULT;
			case DDS4CCMPackage.DS_QOS_POLICY__MAX_SAMPLES_PER_INSTANCE:
				return max_samples_per_instance != MAX_SAMPLES_PER_INSTANCE_EDEFAULT;
			case DDS4CCMPackage.DS_QOS_POLICY__HISTORY_DEPTH:
				return history_depth != HISTORY_DEPTH_EDEFAULT;
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
		result.append(" (history_kind: ");
		result.append(history_kind);
		result.append(", max_instances: ");
		result.append(max_instances);
		result.append(", max_samples: ");
		result.append(max_samples);
		result.append(", max_samples_per_instance: ");
		result.append(max_samples_per_instance);
		result.append(", history_depth: ");
		result.append(history_depth);
		result.append(')');
		return result.toString();
	}

} //dsQosPolicyImpl
