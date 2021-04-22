/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.efQosPolicy;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ef Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.efQosPolicyImpl#isAutoenable_created_entities <em>Autoenable created entities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class efQosPolicyImpl extends qosPolicyImpl implements efQosPolicy {
	/**
	 * The default value of the '{@link #isAutoenable_created_entities() <em>Autoenable created entities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoenable_created_entities()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOENABLE_CREATED_ENTITIES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAutoenable_created_entities() <em>Autoenable created entities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoenable_created_entities()
	 * @generated
	 * @ordered
	 */
	protected boolean autoenable_created_entities = AUTOENABLE_CREATED_ENTITIES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected efQosPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getefQosPolicy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAutoenable_created_entities() {
		return autoenable_created_entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAutoenable_created_entities(boolean newAutoenable_created_entities) {
		boolean oldAutoenable_created_entities = autoenable_created_entities;
		autoenable_created_entities = newAutoenable_created_entities;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.EF_QOS_POLICY__AUTOENABLE_CREATED_ENTITIES, oldAutoenable_created_entities, autoenable_created_entities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.EF_QOS_POLICY__AUTOENABLE_CREATED_ENTITIES:
				return isAutoenable_created_entities();
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
			case DDS4CCMPackage.EF_QOS_POLICY__AUTOENABLE_CREATED_ENTITIES:
				setAutoenable_created_entities((Boolean)newValue);
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
			case DDS4CCMPackage.EF_QOS_POLICY__AUTOENABLE_CREATED_ENTITIES:
				setAutoenable_created_entities(AUTOENABLE_CREATED_ENTITIES_EDEFAULT);
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
			case DDS4CCMPackage.EF_QOS_POLICY__AUTOENABLE_CREATED_ENTITIES:
				return autoenable_created_entities != AUTOENABLE_CREATED_ENTITIES_EDEFAULT;
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
		result.append(" (autoenable_created_entities: ");
		result.append(autoenable_created_entities);
		result.append(')');
		return result.toString();
	}

} //efQosPolicyImpl
