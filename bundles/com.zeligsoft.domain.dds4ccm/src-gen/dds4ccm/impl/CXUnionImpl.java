/**
 */
package dds4ccm.impl;

import dds4ccm.CXClassifierContained;
import dds4ccm.CXModuleContained;
import dds4ccm.CXType;
import dds4ccm.CXUnion;
import dds4ccm.Contained;
import dds4ccm.DDS4CCMPackage;

import dds4ccm.ExtensibilityKind;
import dds4ccm.Extensible;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CX Union</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.CXUnionImpl#getExtensibility <em>Extensibility</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CXUnionImpl extends CXConstructedImpl implements CXUnion {
	/**
	 * The default value of the '{@link #getExtensibility() <em>Extensibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensibility()
	 * @generated
	 * @ordered
	 */
	protected static final ExtensibilityKind EXTENSIBILITY_EDEFAULT = ExtensibilityKind.FINAL;
	/**
	 * The cached value of the '{@link #getExtensibility() <em>Extensibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensibility()
	 * @generated
	 * @ordered
	 */
	protected ExtensibilityKind extensibility = EXTENSIBILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CXUnionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getCXUnion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtensibilityKind getExtensibility() {
		return extensibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtensibility(ExtensibilityKind newExtensibility) {
		ExtensibilityKind oldExtensibility = extensibility;
		extensibility = newExtensibility == null ? EXTENSIBILITY_EDEFAULT : newExtensibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_UNION__EXTENSIBILITY, oldExtensibility, extensibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CX_UNION__EXTENSIBILITY:
				return getExtensibility();
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
			case DDS4CCMPackage.CX_UNION__EXTENSIBILITY:
				setExtensibility((ExtensibilityKind)newValue);
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
			case DDS4CCMPackage.CX_UNION__EXTENSIBILITY:
				setExtensibility(EXTENSIBILITY_EDEFAULT);
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
			case DDS4CCMPackage.CX_UNION__EXTENSIBILITY:
				return extensibility != EXTENSIBILITY_EDEFAULT;
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
		if (baseClass == Extensible.class) {
			switch (derivedFeatureID) {
				case DDS4CCMPackage.CX_UNION__EXTENSIBILITY: return DDS4CCMPackage.EXTENSIBLE__EXTENSIBILITY;
				default: return -1;
			}
		}
		if (baseClass == Contained.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXClassifierContained.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXModuleContained.class) {
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
		if (baseClass == Extensible.class) {
			switch (baseFeatureID) {
				case DDS4CCMPackage.EXTENSIBLE__EXTENSIBILITY: return DDS4CCMPackage.CX_UNION__EXTENSIBILITY;
				default: return -1;
			}
		}
		if (baseClass == Contained.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXClassifierContained.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == CXModuleContained.class) {
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
		result.append(" (extensibility: ");
		result.append(extensibility);
		result.append(')');
		return result.toString();
	}

} //CXUnionImpl
