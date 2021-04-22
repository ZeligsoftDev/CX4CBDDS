/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.WorkerFunctionImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Worker Function Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.WorkerFunctionImplImpl#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkerFunctionImplImpl extends MinimalEObjectImpl.Container implements WorkerFunctionImpl {
	/**
	 * The cached value of the '{@link #getBase_OpaqueBehavior() <em>Base Opaque Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_OpaqueBehavior()
	 * @generated
	 * @ordered
	 */
	protected OpaqueBehavior base_OpaqueBehavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkerFunctionImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getWorkerFunctionImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpaqueBehavior getBase_OpaqueBehavior() {
		if (base_OpaqueBehavior != null && base_OpaqueBehavior.eIsProxy()) {
			InternalEObject oldBase_OpaqueBehavior = (InternalEObject)base_OpaqueBehavior;
			base_OpaqueBehavior = (OpaqueBehavior)eResolveProxy(oldBase_OpaqueBehavior);
			if (base_OpaqueBehavior != oldBase_OpaqueBehavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR, oldBase_OpaqueBehavior, base_OpaqueBehavior));
			}
		}
		return base_OpaqueBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehavior basicGetBase_OpaqueBehavior() {
		return base_OpaqueBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_OpaqueBehavior(OpaqueBehavior newBase_OpaqueBehavior) {
		OpaqueBehavior oldBase_OpaqueBehavior = base_OpaqueBehavior;
		base_OpaqueBehavior = newBase_OpaqueBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR, oldBase_OpaqueBehavior, base_OpaqueBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR:
				if (resolve) return getBase_OpaqueBehavior();
				return basicGetBase_OpaqueBehavior();
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
			case DDS4CCMPackage.WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR:
				setBase_OpaqueBehavior((OpaqueBehavior)newValue);
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
			case DDS4CCMPackage.WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR:
				setBase_OpaqueBehavior((OpaqueBehavior)null);
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
			case DDS4CCMPackage.WORKER_FUNCTION_IMPL__BASE_OPAQUE_BEHAVIOR:
				return base_OpaqueBehavior != null;
		}
		return super.eIsSet(featureID);
	}

} //WorkerFunctionImplImpl
