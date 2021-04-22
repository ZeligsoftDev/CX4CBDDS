/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.ModuleBinding;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.TemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ModuleBindingImpl#getBase_TemplateBinding <em>Base Template Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleBindingImpl extends MinimalEObjectImpl.Container implements ModuleBinding {
	/**
	 * The cached value of the '{@link #getBase_TemplateBinding() <em>Base Template Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TemplateBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBinding base_TemplateBinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getModuleBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateBinding getBase_TemplateBinding() {
		if (base_TemplateBinding != null && base_TemplateBinding.eIsProxy()) {
			InternalEObject oldBase_TemplateBinding = (InternalEObject)base_TemplateBinding;
			base_TemplateBinding = (TemplateBinding)eResolveProxy(oldBase_TemplateBinding);
			if (base_TemplateBinding != oldBase_TemplateBinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.MODULE_BINDING__BASE_TEMPLATE_BINDING, oldBase_TemplateBinding, base_TemplateBinding));
			}
		}
		return base_TemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBinding basicGetBase_TemplateBinding() {
		return base_TemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_TemplateBinding(TemplateBinding newBase_TemplateBinding) {
		TemplateBinding oldBase_TemplateBinding = base_TemplateBinding;
		base_TemplateBinding = newBase_TemplateBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.MODULE_BINDING__BASE_TEMPLATE_BINDING, oldBase_TemplateBinding, base_TemplateBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.MODULE_BINDING__BASE_TEMPLATE_BINDING:
				if (resolve) return getBase_TemplateBinding();
				return basicGetBase_TemplateBinding();
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
			case DDS4CCMPackage.MODULE_BINDING__BASE_TEMPLATE_BINDING:
				setBase_TemplateBinding((TemplateBinding)newValue);
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
			case DDS4CCMPackage.MODULE_BINDING__BASE_TEMPLATE_BINDING:
				setBase_TemplateBinding((TemplateBinding)null);
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
			case DDS4CCMPackage.MODULE_BINDING__BASE_TEMPLATE_BINDING:
				return base_TemplateBinding != null;
		}
		return super.eIsSet(featureID);
	}

} //ModuleBindingImpl
