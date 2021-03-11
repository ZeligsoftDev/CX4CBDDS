/**
 */
package dds4ccm.impl;

import dds4ccm.ComponentImplementation;
import dds4ccm.DDS4CCMPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Manifestation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ComponentImplementationImpl#getBase_Manifestation <em>Base Manifestation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImplementationImpl extends MinimalEObjectImpl.Container implements ComponentImplementation {
	/**
	 * The cached value of the '{@link #getBase_Manifestation() <em>Base Manifestation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Manifestation()
	 * @generated
	 * @ordered
	 */
	protected Manifestation base_Manifestation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getComponentImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Manifestation getBase_Manifestation() {
		if (base_Manifestation != null && base_Manifestation.eIsProxy()) {
			InternalEObject oldBase_Manifestation = (InternalEObject)base_Manifestation;
			base_Manifestation = (Manifestation)eResolveProxy(oldBase_Manifestation);
			if (base_Manifestation != oldBase_Manifestation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION, oldBase_Manifestation, base_Manifestation));
			}
		}
		return base_Manifestation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manifestation basicGetBase_Manifestation() {
		return base_Manifestation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Manifestation(Manifestation newBase_Manifestation) {
		Manifestation oldBase_Manifestation = base_Manifestation;
		base_Manifestation = newBase_Manifestation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION, oldBase_Manifestation, base_Manifestation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION:
				if (resolve) return getBase_Manifestation();
				return basicGetBase_Manifestation();
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
			case DDS4CCMPackage.COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION:
				setBase_Manifestation((Manifestation)newValue);
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
			case DDS4CCMPackage.COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION:
				setBase_Manifestation((Manifestation)null);
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
			case DDS4CCMPackage.COMPONENT_IMPLEMENTATION__BASE_MANIFESTATION:
				return base_Manifestation != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentImplementationImpl
