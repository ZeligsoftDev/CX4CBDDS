/**
 */
package dds4ccm.impl;

import dds4ccm.ComponentDeploymentPart;
import dds4ccm.Configuration;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.Implementation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Deployment Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ComponentDeploymentPartImpl#getSelectedImplementation <em>Selected Implementation</em>}</li>
 *   <li>{@link dds4ccm.impl.ComponentDeploymentPartImpl#getImplementationConfiguration <em>Implementation Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentDeploymentPartImpl extends DeploymentPartImpl implements ComponentDeploymentPart {
	/**
	 * The cached value of the '{@link #getSelectedImplementation() <em>Selected Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedImplementation()
	 * @generated
	 * @ordered
	 */
	protected Implementation selectedImplementation;

	/**
	 * The cached value of the '{@link #getImplementationConfiguration() <em>Implementation Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration implementationConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentDeploymentPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getComponentDeploymentPart();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Implementation getSelectedImplementation() {
		if (selectedImplementation != null && selectedImplementation.eIsProxy()) {
			InternalEObject oldSelectedImplementation = (InternalEObject)selectedImplementation;
			selectedImplementation = (Implementation)eResolveProxy(oldSelectedImplementation);
			if (selectedImplementation != oldSelectedImplementation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION, oldSelectedImplementation, selectedImplementation));
			}
		}
		return selectedImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation basicGetSelectedImplementation() {
		return selectedImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelectedImplementation(Implementation newSelectedImplementation) {
		Implementation oldSelectedImplementation = selectedImplementation;
		selectedImplementation = newSelectedImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION, oldSelectedImplementation, selectedImplementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration getImplementationConfiguration() {
		if (implementationConfiguration != null && implementationConfiguration.eIsProxy()) {
			InternalEObject oldImplementationConfiguration = (InternalEObject)implementationConfiguration;
			implementationConfiguration = (Configuration)eResolveProxy(oldImplementationConfiguration);
			if (implementationConfiguration != oldImplementationConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION, oldImplementationConfiguration, implementationConfiguration));
			}
		}
		return implementationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration basicGetImplementationConfiguration() {
		return implementationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplementationConfiguration(Configuration newImplementationConfiguration) {
		Configuration oldImplementationConfiguration = implementationConfiguration;
		implementationConfiguration = newImplementationConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION, oldImplementationConfiguration, implementationConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION:
				if (resolve) return getSelectedImplementation();
				return basicGetSelectedImplementation();
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION:
				if (resolve) return getImplementationConfiguration();
				return basicGetImplementationConfiguration();
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
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION:
				setSelectedImplementation((Implementation)newValue);
				return;
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION:
				setImplementationConfiguration((Configuration)newValue);
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
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION:
				setSelectedImplementation((Implementation)null);
				return;
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION:
				setImplementationConfiguration((Configuration)null);
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
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION:
				return selectedImplementation != null;
			case DDS4CCMPackage.COMPONENT_DEPLOYMENT_PART__IMPLEMENTATION_CONFIGURATION:
				return implementationConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentDeploymentPartImpl
