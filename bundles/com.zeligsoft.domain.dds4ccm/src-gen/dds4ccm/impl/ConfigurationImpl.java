/**
 */
package dds4ccm.impl;

import dds4ccm.Configuration;
import dds4ccm.DDS4CCMPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ConfigurationImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link dds4ccm.impl.ConfigurationImpl#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getBase_InstanceSpecification() <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification base_InstanceSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CONFIGURATION__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONFIGURATION__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstanceSpecification getBase_InstanceSpecification() {
		if (base_InstanceSpecification != null && base_InstanceSpecification.eIsProxy()) {
			InternalEObject oldBase_InstanceSpecification = (InternalEObject)base_InstanceSpecification;
			base_InstanceSpecification = (InstanceSpecification)eResolveProxy(oldBase_InstanceSpecification);
			if (base_InstanceSpecification != oldBase_InstanceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CONFIGURATION__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
			}
		}
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification basicGetBase_InstanceSpecification() {
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_InstanceSpecification(InstanceSpecification newBase_InstanceSpecification) {
		InstanceSpecification oldBase_InstanceSpecification = base_InstanceSpecification;
		base_InstanceSpecification = newBase_InstanceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONFIGURATION__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CONFIGURATION__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case DDS4CCMPackage.CONFIGURATION__BASE_INSTANCE_SPECIFICATION:
				if (resolve) return getBase_InstanceSpecification();
				return basicGetBase_InstanceSpecification();
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
			case DDS4CCMPackage.CONFIGURATION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case DDS4CCMPackage.CONFIGURATION__BASE_INSTANCE_SPECIFICATION:
				setBase_InstanceSpecification((InstanceSpecification)newValue);
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
			case DDS4CCMPackage.CONFIGURATION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case DDS4CCMPackage.CONFIGURATION__BASE_INSTANCE_SPECIFICATION:
				setBase_InstanceSpecification((InstanceSpecification)null);
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
			case DDS4CCMPackage.CONFIGURATION__BASE_CLASS:
				return base_Class != null;
			case DDS4CCMPackage.CONFIGURATION__BASE_INSTANCE_SPECIFICATION:
				return base_InstanceSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
