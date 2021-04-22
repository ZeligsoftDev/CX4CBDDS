/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.TemplateSignature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.TemplateSignatureImpl#getBase_TemplateSignature <em>Base Template Signature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateSignatureImpl extends MinimalEObjectImpl.Container implements TemplateSignature {
	/**
	 * The cached value of the '{@link #getBase_TemplateSignature() <em>Base Template Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TemplateSignature()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.TemplateSignature base_TemplateSignature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateSignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getTemplateSignature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.TemplateSignature getBase_TemplateSignature() {
		if (base_TemplateSignature != null && base_TemplateSignature.eIsProxy()) {
			InternalEObject oldBase_TemplateSignature = (InternalEObject)base_TemplateSignature;
			base_TemplateSignature = (org.eclipse.uml2.uml.TemplateSignature)eResolveProxy(oldBase_TemplateSignature);
			if (base_TemplateSignature != oldBase_TemplateSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE, oldBase_TemplateSignature, base_TemplateSignature));
			}
		}
		return base_TemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.TemplateSignature basicGetBase_TemplateSignature() {
		return base_TemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_TemplateSignature(org.eclipse.uml2.uml.TemplateSignature newBase_TemplateSignature) {
		org.eclipse.uml2.uml.TemplateSignature oldBase_TemplateSignature = base_TemplateSignature;
		base_TemplateSignature = newBase_TemplateSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE, oldBase_TemplateSignature, base_TemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				if (resolve) return getBase_TemplateSignature();
				return basicGetBase_TemplateSignature();
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
			case DDS4CCMPackage.TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				setBase_TemplateSignature((org.eclipse.uml2.uml.TemplateSignature)newValue);
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
			case DDS4CCMPackage.TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				setBase_TemplateSignature((org.eclipse.uml2.uml.TemplateSignature)null);
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
			case DDS4CCMPackage.TEMPLATE_SIGNATURE__BASE_TEMPLATE_SIGNATURE:
				return base_TemplateSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //TemplateSignatureImpl
