/**
 */
package dds4ccm.impl;

import dds4ccm.ComponentInterface;
import dds4ccm.ConjugatedPort;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.InterfacePort;
import dds4ccm.WorkerFunctionIdentifiable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.InterfacePortImpl#isConjugated <em>Is Conjugated</em>}</li>
 *   <li>{@link dds4ccm.impl.InterfacePortImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link dds4ccm.impl.InterfacePortImpl#getConnectorType <em>Connector Type</em>}</li>
 *   <li>{@link dds4ccm.impl.InterfacePortImpl#isAsynchronous <em>Is Asynchronous</em>}</li>
 *   <li>{@link dds4ccm.impl.InterfacePortImpl#isHasCSL <em>Has CSL</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfacePortImpl extends MessagePortImpl implements InterfacePort {
	/**
	 * The default value of the '{@link #isConjugated() <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConjugated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONJUGATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConjugated() <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConjugated()
	 * @generated
	 * @ordered
	 */
	protected boolean isConjugated = IS_CONJUGATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectorType() <em>Connector Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorType()
	 * @generated
	 * @ordered
	 */
	protected ComponentInterface connectorType;

	/**
	 * The default value of the '{@link #isAsynchronous() <em>Is Asynchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsynchronous()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ASYNCHRONOUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAsynchronous() <em>Is Asynchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsynchronous()
	 * @generated
	 * @ordered
	 */
	protected boolean isAsynchronous = IS_ASYNCHRONOUS_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasCSL() <em>Has CSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCSL()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_CSL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasCSL() <em>Has CSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCSL()
	 * @generated
	 * @ordered
	 */
	protected boolean hasCSL = HAS_CSL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfacePortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getInterfacePort();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConjugated() {
		return isConjugated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsConjugated(boolean newIsConjugated) {
		boolean oldIsConjugated = isConjugated;
		isConjugated = newIsConjugated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED, oldIsConjugated, isConjugated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.INTERFACE_PORT__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInterface getConnectorType() {
		if (connectorType != null && connectorType.eIsProxy()) {
			InternalEObject oldConnectorType = (InternalEObject)connectorType;
			connectorType = (ComponentInterface)eResolveProxy(oldConnectorType);
			if (connectorType != oldConnectorType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.INTERFACE_PORT__CONNECTOR_TYPE, oldConnectorType, connectorType));
			}
		}
		return connectorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInterface basicGetConnectorType() {
		return connectorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectorType(ComponentInterface newConnectorType) {
		ComponentInterface oldConnectorType = connectorType;
		connectorType = newConnectorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.INTERFACE_PORT__CONNECTOR_TYPE, oldConnectorType, connectorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAsynchronous() {
		return isAsynchronous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAsynchronous(boolean newIsAsynchronous) {
		boolean oldIsAsynchronous = isAsynchronous;
		isAsynchronous = newIsAsynchronous;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.INTERFACE_PORT__IS_ASYNCHRONOUS, oldIsAsynchronous, isAsynchronous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasCSL() {
		return hasCSL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasCSL(boolean newHasCSL) {
		boolean oldHasCSL = hasCSL;
		hasCSL = newHasCSL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.INTERFACE_PORT__HAS_CSL, oldHasCSL, hasCSL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED:
				return isConjugated();
			case DDS4CCMPackage.INTERFACE_PORT__UUID:
				return getUuid();
			case DDS4CCMPackage.INTERFACE_PORT__CONNECTOR_TYPE:
				if (resolve) return getConnectorType();
				return basicGetConnectorType();
			case DDS4CCMPackage.INTERFACE_PORT__IS_ASYNCHRONOUS:
				return isAsynchronous();
			case DDS4CCMPackage.INTERFACE_PORT__HAS_CSL:
				return isHasCSL();
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
			case DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED:
				setIsConjugated((Boolean)newValue);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__UUID:
				setUuid((String)newValue);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__CONNECTOR_TYPE:
				setConnectorType((ComponentInterface)newValue);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__IS_ASYNCHRONOUS:
				setIsAsynchronous((Boolean)newValue);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__HAS_CSL:
				setHasCSL((Boolean)newValue);
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
			case DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED:
				setIsConjugated(IS_CONJUGATED_EDEFAULT);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__CONNECTOR_TYPE:
				setConnectorType((ComponentInterface)null);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__IS_ASYNCHRONOUS:
				setIsAsynchronous(IS_ASYNCHRONOUS_EDEFAULT);
				return;
			case DDS4CCMPackage.INTERFACE_PORT__HAS_CSL:
				setHasCSL(HAS_CSL_EDEFAULT);
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
			case DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED:
				return isConjugated != IS_CONJUGATED_EDEFAULT;
			case DDS4CCMPackage.INTERFACE_PORT__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case DDS4CCMPackage.INTERFACE_PORT__CONNECTOR_TYPE:
				return connectorType != null;
			case DDS4CCMPackage.INTERFACE_PORT__IS_ASYNCHRONOUS:
				return isAsynchronous != IS_ASYNCHRONOUS_EDEFAULT;
			case DDS4CCMPackage.INTERFACE_PORT__HAS_CSL:
				return hasCSL != HAS_CSL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ConjugatedPort.class) {
			switch (derivedFeatureID) {
				case DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED: return DDS4CCMPackage.CONJUGATED_PORT__IS_CONJUGATED;
				default: return -1;
			}
		}
		if (baseClass == WorkerFunctionIdentifiable.class) {
			switch (derivedFeatureID) {
				case DDS4CCMPackage.INTERFACE_PORT__UUID: return DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ConjugatedPort.class) {
			switch (baseFeatureID) {
				case DDS4CCMPackage.CONJUGATED_PORT__IS_CONJUGATED: return DDS4CCMPackage.INTERFACE_PORT__IS_CONJUGATED;
				default: return -1;
			}
		}
		if (baseClass == WorkerFunctionIdentifiable.class) {
			switch (baseFeatureID) {
				case DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID: return DDS4CCMPackage.INTERFACE_PORT__UUID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (isConjugated: ");
		result.append(isConjugated);
		result.append(", uuid: ");
		result.append(uuid);
		result.append(", isAsynchronous: ");
		result.append(isAsynchronous);
		result.append(", hasCSL: ");
		result.append(hasCSL);
		result.append(')');
		return result.toString();
	}

} //InterfacePortImpl
