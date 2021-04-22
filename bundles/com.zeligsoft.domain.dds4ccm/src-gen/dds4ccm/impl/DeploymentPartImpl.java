/**
 */
package dds4ccm.impl;

import dds4ccm.Configuration;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.DeploymentPart;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.DeploymentPartImpl#getNestedPart <em>Nested Part</em>}</li>
 *   <li>{@link dds4ccm.impl.DeploymentPartImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link dds4ccm.impl.DeploymentPartImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link dds4ccm.impl.DeploymentPartImpl#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeploymentPartImpl extends MinimalEObjectImpl.Container implements DeploymentPart {
	/**
	 * The cached value of the '{@link #getNestedPart() <em>Nested Part</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPart()
	 * @generated
	 * @ordered
	 */
	protected EList<DeploymentPart> nestedPart;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration configuration;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement modelElement;

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
	protected DeploymentPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getDeploymentPart();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeploymentPart> getNestedPart() {
		if (nestedPart == null) {
			nestedPart = new EObjectResolvingEList<DeploymentPart>(DeploymentPart.class, this, DDS4CCMPackage.DEPLOYMENT_PART__NESTED_PART);
		}
		return nestedPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration getConfiguration() {
		if (configuration != null && configuration.eIsProxy()) {
			InternalEObject oldConfiguration = (InternalEObject)configuration;
			configuration = (Configuration)eResolveProxy(oldConfiguration);
			if (configuration != oldConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.DEPLOYMENT_PART__CONFIGURATION, oldConfiguration, configuration));
			}
		}
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration basicGetConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfiguration(Configuration newConfiguration) {
		Configuration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DEPLOYMENT_PART__CONFIGURATION, oldConfiguration, configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = (NamedElement)eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.DEPLOYMENT_PART__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelElement(NamedElement newModelElement) {
		NamedElement oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DEPLOYMENT_PART__MODEL_ELEMENT, oldModelElement, modelElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.DEPLOYMENT_PART__BASE_PROPERTY, oldBase_Property, base_Property));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.DEPLOYMENT_PART__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.DEPLOYMENT_PART__NESTED_PART:
				return getNestedPart();
			case DDS4CCMPackage.DEPLOYMENT_PART__CONFIGURATION:
				if (resolve) return getConfiguration();
				return basicGetConfiguration();
			case DDS4CCMPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
			case DDS4CCMPackage.DEPLOYMENT_PART__BASE_PROPERTY:
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
			case DDS4CCMPackage.DEPLOYMENT_PART__NESTED_PART:
				getNestedPart().clear();
				getNestedPart().addAll((Collection<? extends DeploymentPart>)newValue);
				return;
			case DDS4CCMPackage.DEPLOYMENT_PART__CONFIGURATION:
				setConfiguration((Configuration)newValue);
				return;
			case DDS4CCMPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				setModelElement((NamedElement)newValue);
				return;
			case DDS4CCMPackage.DEPLOYMENT_PART__BASE_PROPERTY:
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
			case DDS4CCMPackage.DEPLOYMENT_PART__NESTED_PART:
				getNestedPart().clear();
				return;
			case DDS4CCMPackage.DEPLOYMENT_PART__CONFIGURATION:
				setConfiguration((Configuration)null);
				return;
			case DDS4CCMPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				setModelElement((NamedElement)null);
				return;
			case DDS4CCMPackage.DEPLOYMENT_PART__BASE_PROPERTY:
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
			case DDS4CCMPackage.DEPLOYMENT_PART__NESTED_PART:
				return nestedPart != null && !nestedPart.isEmpty();
			case DDS4CCMPackage.DEPLOYMENT_PART__CONFIGURATION:
				return configuration != null;
			case DDS4CCMPackage.DEPLOYMENT_PART__MODEL_ELEMENT:
				return modelElement != null;
			case DDS4CCMPackage.DEPLOYMENT_PART__BASE_PROPERTY:
				return base_Property != null;
		}
		return super.eIsSet(featureID);
	}

} //DeploymentPartImpl
