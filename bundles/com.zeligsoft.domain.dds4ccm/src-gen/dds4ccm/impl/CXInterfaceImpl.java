/**
 */
package dds4ccm.impl;

import dds4ccm.CXClassifier;
import dds4ccm.CXInterface;
import dds4ccm.CXModuleContained;
import dds4ccm.CXType;
import dds4ccm.Contained;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.PortTypeable;
import dds4ccm.WorkerFunctionIdentifiable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CX Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.CXInterfaceImpl#getBase_Interface <em>Base Interface</em>}</li>
 *   <li>{@link dds4ccm.impl.CXInterfaceImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link dds4ccm.impl.CXInterfaceImpl#isLocal <em>Is Local</em>}</li>
 *   <li>{@link dds4ccm.impl.CXInterfaceImpl#isAsynchronous <em>Is Asynchronous</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CXInterfaceImpl extends CXNamedElementImpl implements CXInterface {
	/**
	 * The cached value of the '{@link #getBase_Interface() <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Interface()
	 * @generated
	 * @ordered
	 */
	protected Interface base_Interface;

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
	 * The default value of the '{@link #isLocal() <em>Is Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LOCAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocal() <em>Is Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocal()
	 * @generated
	 * @ordered
	 */
	protected boolean isLocal = IS_LOCAL_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CXInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getCXInterface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interface getBase_Interface() {
		if (base_Interface != null && base_Interface.eIsProxy()) {
			InternalEObject oldBase_Interface = (InternalEObject)base_Interface;
			base_Interface = (Interface)eResolveProxy(oldBase_Interface);
			if (base_Interface != oldBase_Interface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE, oldBase_Interface, base_Interface));
			}
		}
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetBase_Interface() {
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Interface(Interface newBase_Interface) {
		Interface oldBase_Interface = base_Interface;
		base_Interface = newBase_Interface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE, oldBase_Interface, base_Interface));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_INTERFACE__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLocal() {
		return isLocal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsLocal(boolean newIsLocal) {
		boolean oldIsLocal = isLocal;
		isLocal = newIsLocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_INTERFACE__IS_LOCAL, oldIsLocal, isLocal));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_INTERFACE__IS_ASYNCHRONOUS, oldIsAsynchronous, isAsynchronous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE:
				if (resolve) return getBase_Interface();
				return basicGetBase_Interface();
			case DDS4CCMPackage.CX_INTERFACE__UUID:
				return getUuid();
			case DDS4CCMPackage.CX_INTERFACE__IS_LOCAL:
				return isLocal();
			case DDS4CCMPackage.CX_INTERFACE__IS_ASYNCHRONOUS:
				return isAsynchronous();
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
			case DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE:
				setBase_Interface((Interface)newValue);
				return;
			case DDS4CCMPackage.CX_INTERFACE__UUID:
				setUuid((String)newValue);
				return;
			case DDS4CCMPackage.CX_INTERFACE__IS_LOCAL:
				setIsLocal((Boolean)newValue);
				return;
			case DDS4CCMPackage.CX_INTERFACE__IS_ASYNCHRONOUS:
				setIsAsynchronous((Boolean)newValue);
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
			case DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE:
				setBase_Interface((Interface)null);
				return;
			case DDS4CCMPackage.CX_INTERFACE__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_INTERFACE__IS_LOCAL:
				setIsLocal(IS_LOCAL_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_INTERFACE__IS_ASYNCHRONOUS:
				setIsAsynchronous(IS_ASYNCHRONOUS_EDEFAULT);
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
			case DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE:
				return base_Interface != null;
			case DDS4CCMPackage.CX_INTERFACE__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case DDS4CCMPackage.CX_INTERFACE__IS_LOCAL:
				return isLocal != IS_LOCAL_EDEFAULT;
			case DDS4CCMPackage.CX_INTERFACE__IS_ASYNCHRONOUS:
				return isAsynchronous != IS_ASYNCHRONOUS_EDEFAULT;
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
		if (baseClass == PortTypeable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == dds4ccm.Interface.class) {
			switch (derivedFeatureID) {
				case DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE: return DDS4CCMPackage.INTERFACE__BASE_INTERFACE;
				default: return -1;
			}
		}
		if (baseClass == WorkerFunctionIdentifiable.class) {
			switch (derivedFeatureID) {
				case DDS4CCMPackage.CX_INTERFACE__UUID: return DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID;
				default: return -1;
			}
		}
		if (baseClass == Contained.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXModuleContained.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXClassifier.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXType.class) {
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
		if (baseClass == PortTypeable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == dds4ccm.Interface.class) {
			switch (baseFeatureID) {
				case DDS4CCMPackage.INTERFACE__BASE_INTERFACE: return DDS4CCMPackage.CX_INTERFACE__BASE_INTERFACE;
				default: return -1;
			}
		}
		if (baseClass == WorkerFunctionIdentifiable.class) {
			switch (baseFeatureID) {
				case DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID: return DDS4CCMPackage.CX_INTERFACE__UUID;
				default: return -1;
			}
		}
		if (baseClass == Contained.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXModuleContained.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXClassifier.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXType.class) {
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
		result.append(", isLocal: ");
		result.append(isLocal);
		result.append(", isAsynchronous: ");
		result.append(isAsynchronous);
		result.append(')');
		return result.toString();
	}

} //CXInterfaceImpl
