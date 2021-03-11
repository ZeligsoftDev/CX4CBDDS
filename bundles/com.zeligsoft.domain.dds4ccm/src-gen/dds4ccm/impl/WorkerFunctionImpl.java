/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.Port;
import dds4ccm.WorkerFunction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Worker Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImpl#getReceivingPort <em>Receiving Port</em>}</li>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImpl#getPortOperation <em>Port Operation</em>}</li>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImpl#isDelegate <em>Delegate</em>}</li>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImpl#getBase_Operation <em>Base Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkerFunctionImpl extends MinimalEObjectImpl.Container implements WorkerFunction {
	/**
	 * The cached value of the '{@link #getReceivingPort() <em>Receiving Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceivingPort()
	 * @generated
	 * @ordered
	 */
	protected Port receivingPort;

	/**
	 * The cached value of the '{@link #getPortOperation() <em>Port Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation portOperation;

	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected String body = BODY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The default value of the '{@link #isDelegate() <em>Delegate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDelegate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELEGATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDelegate() <em>Delegate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDelegate()
	 * @generated
	 * @ordered
	 */
	protected boolean delegate = DELEGATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkerFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getWorkerFunction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Port getReceivingPort() {
		if (receivingPort != null && receivingPort.eIsProxy()) {
			InternalEObject oldReceivingPort = (InternalEObject)receivingPort;
			receivingPort = (Port)eResolveProxy(oldReceivingPort);
			if (receivingPort != oldReceivingPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.WORKER_FUNCTION__RECEIVING_PORT, oldReceivingPort, receivingPort));
			}
		}
		return receivingPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetReceivingPort() {
		return receivingPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReceivingPort(Port newReceivingPort) {
		Port oldReceivingPort = receivingPort;
		receivingPort = newReceivingPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION__RECEIVING_PORT, oldReceivingPort, receivingPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getPortOperation() {
		if (portOperation != null && portOperation.eIsProxy()) {
			InternalEObject oldPortOperation = (InternalEObject)portOperation;
			portOperation = (Operation)eResolveProxy(oldPortOperation);
			if (portOperation != oldPortOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.WORKER_FUNCTION__PORT_OPERATION, oldPortOperation, portOperation));
			}
		}
		return portOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetPortOperation() {
		return portOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPortOperation(Operation newPortOperation) {
		Operation oldPortOperation = portOperation;
		portOperation = newPortOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION__PORT_OPERATION, oldPortOperation, portOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBody(String newBody) {
		String oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDelegate() {
		return delegate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDelegate(boolean newDelegate) {
		boolean oldDelegate = delegate;
		delegate = newDelegate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION__DELEGATE, oldDelegate, delegate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getBase_Operation() {
		if (base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if (base_Operation != oldBase_Operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.WORKER_FUNCTION__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.WORKER_FUNCTION__RECEIVING_PORT:
				if (resolve) return getReceivingPort();
				return basicGetReceivingPort();
			case DDS4CCMPackage.WORKER_FUNCTION__PORT_OPERATION:
				if (resolve) return getPortOperation();
				return basicGetPortOperation();
			case DDS4CCMPackage.WORKER_FUNCTION__BODY:
				return getBody();
			case DDS4CCMPackage.WORKER_FUNCTION__UUID:
				return getUuid();
			case DDS4CCMPackage.WORKER_FUNCTION__DELEGATE:
				return isDelegate();
			case DDS4CCMPackage.WORKER_FUNCTION__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
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
			case DDS4CCMPackage.WORKER_FUNCTION__RECEIVING_PORT:
				setReceivingPort((Port)newValue);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__PORT_OPERATION:
				setPortOperation((Operation)newValue);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__BODY:
				setBody((String)newValue);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__UUID:
				setUuid((String)newValue);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__DELEGATE:
				setDelegate((Boolean)newValue);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
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
			case DDS4CCMPackage.WORKER_FUNCTION__RECEIVING_PORT:
				setReceivingPort((Port)null);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__PORT_OPERATION:
				setPortOperation((Operation)null);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__BODY:
				setBody(BODY_EDEFAULT);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__DELEGATE:
				setDelegate(DELEGATE_EDEFAULT);
				return;
			case DDS4CCMPackage.WORKER_FUNCTION__BASE_OPERATION:
				setBase_Operation((Operation)null);
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
			case DDS4CCMPackage.WORKER_FUNCTION__RECEIVING_PORT:
				return receivingPort != null;
			case DDS4CCMPackage.WORKER_FUNCTION__PORT_OPERATION:
				return portOperation != null;
			case DDS4CCMPackage.WORKER_FUNCTION__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case DDS4CCMPackage.WORKER_FUNCTION__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case DDS4CCMPackage.WORKER_FUNCTION__DELEGATE:
				return delegate != DELEGATE_EDEFAULT;
			case DDS4CCMPackage.WORKER_FUNCTION__BASE_OPERATION:
				return base_Operation != null;
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
		result.append(" (body: ");
		result.append(body);
		result.append(", uuid: ");
		result.append(uuid);
		result.append(", delegate: ");
		result.append(delegate);
		result.append(')');
		return result.toString();
	}

} //WorkerFunctionImpl
