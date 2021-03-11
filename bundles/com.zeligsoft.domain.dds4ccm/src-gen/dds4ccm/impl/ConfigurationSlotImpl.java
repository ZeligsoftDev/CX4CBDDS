/**
 */
package dds4ccm.impl;

import dds4ccm.ConfigurationSlot;
import dds4ccm.ConfigurationSlotKind;
import dds4ccm.DDS4CCMPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ConfigurationSlotImpl#getSlotKind <em>Slot Kind</em>}</li>
 *   <li>{@link dds4ccm.impl.ConfigurationSlotImpl#getBase_Slot <em>Base Slot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationSlotImpl extends MinimalEObjectImpl.Container implements ConfigurationSlot {
	/**
	 * The default value of the '{@link #getSlotKind() <em>Slot Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotKind()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigurationSlotKind SLOT_KIND_EDEFAULT = ConfigurationSlotKind.ADDITIVE;

	/**
	 * The cached value of the '{@link #getSlotKind() <em>Slot Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotKind()
	 * @generated
	 * @ordered
	 */
	protected ConfigurationSlotKind slotKind = SLOT_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Slot() <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Slot()
	 * @generated
	 * @ordered
	 */
	protected Slot base_Slot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getConfigurationSlot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurationSlotKind getSlotKind() {
		return slotKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSlotKind(ConfigurationSlotKind newSlotKind) {
		ConfigurationSlotKind oldSlotKind = slotKind;
		slotKind = newSlotKind == null ? SLOT_KIND_EDEFAULT : newSlotKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONFIGURATION_SLOT__SLOT_KIND, oldSlotKind, slotKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Slot getBase_Slot() {
		if (base_Slot != null && base_Slot.eIsProxy()) {
			InternalEObject oldBase_Slot = (InternalEObject)base_Slot;
			base_Slot = (Slot)eResolveProxy(oldBase_Slot);
			if (base_Slot != oldBase_Slot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CONFIGURATION_SLOT__BASE_SLOT, oldBase_Slot, base_Slot));
			}
		}
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot basicGetBase_Slot() {
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Slot(Slot newBase_Slot) {
		Slot oldBase_Slot = base_Slot;
		base_Slot = newBase_Slot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONFIGURATION_SLOT__BASE_SLOT, oldBase_Slot, base_Slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CONFIGURATION_SLOT__SLOT_KIND:
				return getSlotKind();
			case DDS4CCMPackage.CONFIGURATION_SLOT__BASE_SLOT:
				if (resolve) return getBase_Slot();
				return basicGetBase_Slot();
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
			case DDS4CCMPackage.CONFIGURATION_SLOT__SLOT_KIND:
				setSlotKind((ConfigurationSlotKind)newValue);
				return;
			case DDS4CCMPackage.CONFIGURATION_SLOT__BASE_SLOT:
				setBase_Slot((Slot)newValue);
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
			case DDS4CCMPackage.CONFIGURATION_SLOT__SLOT_KIND:
				setSlotKind(SLOT_KIND_EDEFAULT);
				return;
			case DDS4CCMPackage.CONFIGURATION_SLOT__BASE_SLOT:
				setBase_Slot((Slot)null);
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
			case DDS4CCMPackage.CONFIGURATION_SLOT__SLOT_KIND:
				return slotKind != SLOT_KIND_EDEFAULT;
			case DDS4CCMPackage.CONFIGURATION_SLOT__BASE_SLOT:
				return base_Slot != null;
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
		result.append(" (slotKind: ");
		result.append(slotKind);
		result.append(')');
		return result.toString();
	}

} //ConfigurationSlotImpl
