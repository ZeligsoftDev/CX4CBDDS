/**
 */
package dds4ccm.impl;

import dds4ccm.CXOperation;
import dds4ccm.CXType;
import dds4ccm.CXTyped;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.WorkerFunctionIdentifiable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CX Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.CXOperationImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link dds4ccm.impl.CXOperationImpl#getIdlType <em>Idl Type</em>}</li>
 *   <li>{@link dds4ccm.impl.CXOperationImpl#isOneWay <em>Is One Way</em>}</li>
 *   <li>{@link dds4ccm.impl.CXOperationImpl#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CXOperationImpl extends CXNamedElementImpl implements CXOperation {
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
	 * The cached value of the '{@link #getIdlType() <em>Idl Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdlType()
	 * @generated
	 * @ordered
	 */
	protected CXType idlType;

	/**
	 * The default value of the '{@link #isOneWay() <em>Is One Way</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOneWay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ONE_WAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOneWay() <em>Is One Way</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOneWay()
	 * @generated
	 * @ordered
	 */
	protected boolean isOneWay = IS_ONE_WAY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CXOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getCXOperation();
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_OPERATION__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CXType getIdlType() {
		if (idlType != null && idlType.eIsProxy()) {
			InternalEObject oldIdlType = (InternalEObject)idlType;
			idlType = (CXType)eResolveProxy(oldIdlType);
			if (idlType != oldIdlType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CX_OPERATION__IDL_TYPE, oldIdlType, idlType));
			}
		}
		return idlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CXType basicGetIdlType() {
		return idlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdlType(CXType newIdlType) {
		CXType oldIdlType = idlType;
		idlType = newIdlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_OPERATION__IDL_TYPE, oldIdlType, idlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOneWay() {
		return isOneWay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOneWay(boolean newIsOneWay) {
		boolean oldIsOneWay = isOneWay;
		isOneWay = newIsOneWay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_OPERATION__IS_ONE_WAY, oldIsOneWay, isOneWay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getBase_Operation() {
		if (base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if (base_Operation != oldBase_Operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CX_OPERATION__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_OPERATION__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CX_OPERATION__UUID:
				return getUuid();
			case DDS4CCMPackage.CX_OPERATION__IDL_TYPE:
				if (resolve) return getIdlType();
				return basicGetIdlType();
			case DDS4CCMPackage.CX_OPERATION__IS_ONE_WAY:
				return isOneWay();
			case DDS4CCMPackage.CX_OPERATION__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
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
			case DDS4CCMPackage.CX_OPERATION__UUID:
				setUuid((String)newValue);
				return;
			case DDS4CCMPackage.CX_OPERATION__IDL_TYPE:
				setIdlType((CXType)newValue);
				return;
			case DDS4CCMPackage.CX_OPERATION__IS_ONE_WAY:
				setIsOneWay((Boolean)newValue);
				return;
			case DDS4CCMPackage.CX_OPERATION__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
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
			case DDS4CCMPackage.CX_OPERATION__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_OPERATION__IDL_TYPE:
				setIdlType((CXType)null);
				return;
			case DDS4CCMPackage.CX_OPERATION__IS_ONE_WAY:
				setIsOneWay(IS_ONE_WAY_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_OPERATION__BASE_OPERATION:
				setBase_Operation((Operation)null);
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
			case DDS4CCMPackage.CX_OPERATION__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case DDS4CCMPackage.CX_OPERATION__IDL_TYPE:
				return idlType != null;
			case DDS4CCMPackage.CX_OPERATION__IS_ONE_WAY:
				return isOneWay != IS_ONE_WAY_EDEFAULT;
			case DDS4CCMPackage.CX_OPERATION__BASE_OPERATION:
				return base_Operation != null;
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
		if (baseClass == WorkerFunctionIdentifiable.class) {
			switch (derivedFeatureID) {
				case DDS4CCMPackage.CX_OPERATION__UUID: return DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID;
				default: return -1;
			}
		}
		if (baseClass == CXTyped.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == WorkerFunctionIdentifiable.class) {
			switch (baseFeatureID) {
				case DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID: return DDS4CCMPackage.CX_OPERATION__UUID;
				default: return -1;
			}
		}
		if (baseClass == CXTyped.class) {
			switch (baseFeatureID) {
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
		result.append(" (uuid: ");
		result.append(uuid);
		result.append(", isOneWay: ");
		result.append(isOneWay);
		result.append(')');
		return result.toString();
	}

} //CXOperationImpl
