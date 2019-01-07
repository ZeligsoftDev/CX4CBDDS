/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Port;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Systemvue Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getHeaderFile <em>Header File</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemvueModelImpl extends EObjectImpl implements SystemvueModel {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final Object DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected Object description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Object name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected Object namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected Object typeName = TYPE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemvueModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemvueModelPackage.Literals.SYSTEMVUE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, SystemvueModelPackage.SYSTEMVUE_MODEL__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		return getGroup().list(SystemvueModelPackage.Literals.SYSTEMVUE_MODEL__PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HeaderFile> getHeaderFile() {
		return getGroup().list(SystemvueModelPackage.Literals.SYSTEMVUE_MODEL__HEADER_FILE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getPort() {
		return getGroup().list(SystemvueModelPackage.Literals.SYSTEMVUE_MODEL__PORT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(Object newDescription) {
		Object oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.SYSTEMVUE_MODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Object newName) {
		Object oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.SYSTEMVUE_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(Object newNamespace) {
		Object oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.SYSTEMVUE_MODEL__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(Object newTypeName) {
		Object oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.SYSTEMVUE_MODEL__TYPE_NAME, oldTypeName, typeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemvueModelPackage.SYSTEMVUE_MODEL__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case SystemvueModelPackage.SYSTEMVUE_MODEL__HEADER_FILE:
				return ((InternalEList<?>)getHeaderFile()).basicRemove(otherEnd, msgs);
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PORT:
				return ((InternalEList<?>)getPort()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemvueModelPackage.SYSTEMVUE_MODEL__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PARAMETER:
				return getParameter();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__HEADER_FILE:
				return getHeaderFile();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PORT:
				return getPort();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__DESCRIPTION:
				return getDescription();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAME:
				return getName();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAMESPACE:
				return getNamespace();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__TYPE_NAME:
				return getTypeName();
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
			case SystemvueModelPackage.SYSTEMVUE_MODEL__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__HEADER_FILE:
				getHeaderFile().clear();
				getHeaderFile().addAll((Collection<? extends HeaderFile>)newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends Port>)newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__DESCRIPTION:
				setDescription(newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAME:
				setName(newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAMESPACE:
				setNamespace(newValue);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__TYPE_NAME:
				setTypeName(newValue);
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
			case SystemvueModelPackage.SYSTEMVUE_MODEL__GROUP:
				getGroup().clear();
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PARAMETER:
				getParameter().clear();
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__HEADER_FILE:
				getHeaderFile().clear();
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PORT:
				getPort().clear();
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case SystemvueModelPackage.SYSTEMVUE_MODEL__TYPE_NAME:
				setTypeName(TYPE_NAME_EDEFAULT);
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
			case SystemvueModelPackage.SYSTEMVUE_MODEL__GROUP:
				return group != null && !group.isEmpty();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PARAMETER:
				return !getParameter().isEmpty();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__HEADER_FILE:
				return !getHeaderFile().isEmpty();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__PORT:
				return !getPort().isEmpty();
			case SystemvueModelPackage.SYSTEMVUE_MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SystemvueModelPackage.SYSTEMVUE_MODEL__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case SystemvueModelPackage.SYSTEMVUE_MODEL__TYPE_NAME:
				return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (group: ");
		result.append(group);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(", namespace: ");
		result.append(namespace);
		result.append(", typeName: ");
		result.append(typeName);
		result.append(')');
		return result.toString();
	}

} //SystemvueModelImpl
