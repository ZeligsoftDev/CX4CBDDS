/**
 */
package dds4ccm.impl;

import dds4ccm.AssemblyConnector;
import dds4ccm.DDS4CCMPackage;
import dds4ccm.Port;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Connector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.AssemblyConnectorImpl#getPortEnd <em>Port End</em>}</li>
 *   <li>{@link dds4ccm.impl.AssemblyConnectorImpl#getBase_Connector <em>Base Connector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssemblyConnectorImpl extends MinimalEObjectImpl.Container implements AssemblyConnector {
	/**
	 * The cached value of the '{@link #getPortEnd() <em>Port End</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> portEnd;

	/**
	 * The cached value of the '{@link #getBase_Connector() <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Connector()
	 * @generated
	 * @ordered
	 */
	protected Connector base_Connector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getAssemblyConnector();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Port> getPortEnd() {
		if (portEnd == null) {
			portEnd = new EObjectResolvingEList<Port>(Port.class, this, DDS4CCMPackage.ASSEMBLY_CONNECTOR__PORT_END);
		}
		return portEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Connector getBase_Connector() {
		if (base_Connector != null && base_Connector.eIsProxy()) {
			InternalEObject oldBase_Connector = (InternalEObject)base_Connector;
			base_Connector = (Connector)eResolveProxy(oldBase_Connector);
			if (base_Connector != oldBase_Connector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.ASSEMBLY_CONNECTOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
			}
		}
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector basicGetBase_Connector() {
		return base_Connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Connector(Connector newBase_Connector) {
		Connector oldBase_Connector = base_Connector;
		base_Connector = newBase_Connector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.ASSEMBLY_CONNECTOR__BASE_CONNECTOR, oldBase_Connector, base_Connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__PORT_END:
				return getPortEnd();
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__BASE_CONNECTOR:
				if (resolve) return getBase_Connector();
				return basicGetBase_Connector();
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
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__PORT_END:
				getPortEnd().clear();
				getPortEnd().addAll((Collection<? extends Port>)newValue);
				return;
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__BASE_CONNECTOR:
				setBase_Connector((Connector)newValue);
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
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__PORT_END:
				getPortEnd().clear();
				return;
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__BASE_CONNECTOR:
				setBase_Connector((Connector)null);
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
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__PORT_END:
				return portEnd != null && !portEnd.isEmpty();
			case DDS4CCMPackage.ASSEMBLY_CONNECTOR__BASE_CONNECTOR:
				return base_Connector != null;
		}
		return super.eIsSet(featureID);
	}

} //AssemblyConnectorImpl
