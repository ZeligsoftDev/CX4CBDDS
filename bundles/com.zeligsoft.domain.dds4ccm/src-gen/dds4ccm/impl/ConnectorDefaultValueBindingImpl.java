/**
 */
package dds4ccm.impl;

import dds4ccm.ConnectorDef;
import dds4ccm.ConnectorDefaultValueBinding;
import dds4ccm.DDS4CCMPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Default Value Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.ConnectorDefaultValueBindingImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link dds4ccm.impl.ConnectorDefaultValueBindingImpl#getConnectorInstance <em>Connector Instance</em>}</li>
 *   <li>{@link dds4ccm.impl.ConnectorDefaultValueBindingImpl#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectorDefaultValueBindingImpl extends MinimalEObjectImpl.Container implements ConnectorDefaultValueBinding {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected ConnectorDef definition;

	/**
	 * The cached value of the '{@link #getConnectorInstance() <em>Connector Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstance()
	 * @generated
	 * @ordered
	 */
	protected NamedElement connectorInstance;

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorDefaultValueBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getConnectorDefaultValueBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectorDef getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (ConnectorDef)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorDef basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefinition(ConnectorDef newDefinition) {
		ConnectorDef oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getConnectorInstance() {
		if (connectorInstance != null && connectorInstance.eIsProxy()) {
			InternalEObject oldConnectorInstance = (InternalEObject)connectorInstance;
			connectorInstance = (NamedElement)eResolveProxy(oldConnectorInstance);
			if (connectorInstance != oldConnectorInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE, oldConnectorInstance, connectorInstance));
			}
		}
		return connectorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetConnectorInstance() {
		return connectorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectorInstance(NamedElement newConnectorInstance) {
		NamedElement oldConnectorInstance = connectorInstance;
		connectorInstance = newConnectorInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE, oldConnectorInstance, connectorInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE:
				if (resolve) return getConnectorInstance();
				return basicGetConnectorInstance();
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
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
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION:
				setDefinition((ConnectorDef)newValue);
				return;
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE:
				setConnectorInstance((NamedElement)newValue);
				return;
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
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
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION:
				setDefinition((ConnectorDef)null);
				return;
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE:
				setConnectorInstance((NamedElement)null);
				return;
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
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
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION:
				return definition != null;
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE:
				return connectorInstance != null;
			case DDS4CCMPackage.CONNECTOR_DEFAULT_VALUE_BINDING__BASE_PACKAGE:
				return base_Package != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectorDefaultValueBindingImpl
