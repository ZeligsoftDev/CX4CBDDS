/**
 */
package dds4ccm.impl;

import dds4ccm.CXAttribute;
import dds4ccm.CXException;
import dds4ccm.CXTyped;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.WorkerFunctionIdentifiable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CX Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.CXAttributeImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link dds4ccm.impl.CXAttributeImpl#getSetraises <em>Setraises</em>}</li>
 *   <li>{@link dds4ccm.impl.CXAttributeImpl#getGetraises <em>Getraises</em>}</li>
 *   <li>{@link dds4ccm.impl.CXAttributeImpl#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CXAttributeImpl extends CXNamedElementImpl implements CXAttribute {
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
	 * The cached value of the '{@link #getSetraises() <em>Setraises</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetraises()
	 * @generated
	 * @ordered
	 */
	protected EList<CXException> setraises;

	/**
	 * The cached value of the '{@link #getGetraises() <em>Getraises</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetraises()
	 * @generated
	 * @ordered
	 */
	protected EList<CXException> getraises;

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CXAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getCXAttribute();
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_ATTRIBUTE__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CXException> getSetraises() {
		if (setraises == null) {
			setraises = new EObjectResolvingEList<CXException>(CXException.class, this, DDS4CCMPackage.CX_ATTRIBUTE__SETRAISES);
		}
		return setraises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CXException> getGetraises() {
		if (getraises == null) {
			getraises = new EObjectResolvingEList<CXException>(CXException.class, this, DDS4CCMPackage.CX_ATTRIBUTE__GETRAISES);
		}
		return getraises;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CX_ATTRIBUTE__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_ATTRIBUTE__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CX_ATTRIBUTE__UUID:
				return getUuid();
			case DDS4CCMPackage.CX_ATTRIBUTE__SETRAISES:
				return getSetraises();
			case DDS4CCMPackage.CX_ATTRIBUTE__GETRAISES:
				return getGetraises();
			case DDS4CCMPackage.CX_ATTRIBUTE__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DDS4CCMPackage.CX_ATTRIBUTE__UUID:
				setUuid((String)newValue);
				return;
			case DDS4CCMPackage.CX_ATTRIBUTE__SETRAISES:
				getSetraises().clear();
				getSetraises().addAll((Collection<? extends CXException>)newValue);
				return;
			case DDS4CCMPackage.CX_ATTRIBUTE__GETRAISES:
				getGetraises().clear();
				getGetraises().addAll((Collection<? extends CXException>)newValue);
				return;
			case DDS4CCMPackage.CX_ATTRIBUTE__BASE_PROPERTY:
				setBase_Property((Property)newValue);
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
			case DDS4CCMPackage.CX_ATTRIBUTE__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_ATTRIBUTE__SETRAISES:
				getSetraises().clear();
				return;
			case DDS4CCMPackage.CX_ATTRIBUTE__GETRAISES:
				getGetraises().clear();
				return;
			case DDS4CCMPackage.CX_ATTRIBUTE__BASE_PROPERTY:
				setBase_Property((Property)null);
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
			case DDS4CCMPackage.CX_ATTRIBUTE__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case DDS4CCMPackage.CX_ATTRIBUTE__SETRAISES:
				return setraises != null && !setraises.isEmpty();
			case DDS4CCMPackage.CX_ATTRIBUTE__GETRAISES:
				return getraises != null && !getraises.isEmpty();
			case DDS4CCMPackage.CX_ATTRIBUTE__BASE_PROPERTY:
				return base_Property != null;
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
				case DDS4CCMPackage.CX_ATTRIBUTE__UUID: return DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID;
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
				case DDS4CCMPackage.WORKER_FUNCTION_IDENTIFIABLE__UUID: return DDS4CCMPackage.CX_ATTRIBUTE__UUID;
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
		result.append(')');
		return result.toString();
	}

} //CXAttributeImpl
