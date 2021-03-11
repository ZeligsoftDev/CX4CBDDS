/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.ParameterBinding;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.TemplateParameterSubstitution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ParameterBindingImpl#getBase_TemplateParameterSubstitution <em>Base Template Parameter Substitution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterBindingImpl extends MinimalEObjectImpl.Container implements ParameterBinding {
	/**
	 * The cached value of the '{@link #getBase_TemplateParameterSubstitution() <em>Base Template Parameter Substitution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TemplateParameterSubstitution()
	 * @generated
	 * @ordered
	 */
	protected TemplateParameterSubstitution base_TemplateParameterSubstitution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getParameterBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateParameterSubstitution getBase_TemplateParameterSubstitution() {
		if (base_TemplateParameterSubstitution != null && base_TemplateParameterSubstitution.eIsProxy()) {
			InternalEObject oldBase_TemplateParameterSubstitution = (InternalEObject)base_TemplateParameterSubstitution;
			base_TemplateParameterSubstitution = (TemplateParameterSubstitution)eResolveProxy(oldBase_TemplateParameterSubstitution);
			if (base_TemplateParameterSubstitution != oldBase_TemplateParameterSubstitution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION, oldBase_TemplateParameterSubstitution, base_TemplateParameterSubstitution));
			}
		}
		return base_TemplateParameterSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameterSubstitution basicGetBase_TemplateParameterSubstitution() {
		return base_TemplateParameterSubstitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_TemplateParameterSubstitution(TemplateParameterSubstitution newBase_TemplateParameterSubstitution) {
		TemplateParameterSubstitution oldBase_TemplateParameterSubstitution = base_TemplateParameterSubstitution;
		base_TemplateParameterSubstitution = newBase_TemplateParameterSubstitution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION, oldBase_TemplateParameterSubstitution, base_TemplateParameterSubstitution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION:
				if (resolve) return getBase_TemplateParameterSubstitution();
				return basicGetBase_TemplateParameterSubstitution();
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
			case DDS4CCMPackage.PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION:
				setBase_TemplateParameterSubstitution((TemplateParameterSubstitution)newValue);
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
			case DDS4CCMPackage.PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION:
				setBase_TemplateParameterSubstitution((TemplateParameterSubstitution)null);
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
			case DDS4CCMPackage.PARAMETER_BINDING__BASE_TEMPLATE_PARAMETER_SUBSTITUTION:
				return base_TemplateParameterSubstitution != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterBindingImpl
