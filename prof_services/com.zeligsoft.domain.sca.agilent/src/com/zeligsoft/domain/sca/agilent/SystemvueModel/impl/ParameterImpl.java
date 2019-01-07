/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel.impl;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl#getMemberName <em>Member Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl#getSizeName <em>Size Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends EObjectImpl implements Parameter {
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
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final Implementation IMPLEMENTATION_EDEFAULT = Implementation.SCALAR;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected Implementation implementation = IMPLEMENTATION_EDEFAULT;

	/**
	 * This is true if the Implementation attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean implementationESet;

	/**
	 * The default value of the '{@link #getMemberName() <em>Member Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberName()
	 * @generated
	 * @ordered
	 */
	protected static final Object MEMBER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemberName() <em>Member Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberName()
	 * @generated
	 * @ordered
	 */
	protected Object memberName = MEMBER_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getSizeName() <em>Size Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeName()
	 * @generated
	 * @ordered
	 */
	protected static final Object SIZE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSizeName() <em>Size Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeName()
	 * @generated
	 * @ordered
	 */
	protected Object sizeName = SIZE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final TypeName TYPE_NAME_EDEFAULT = TypeName.INT;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected TypeName typeName = TYPE_NAME_EDEFAULT;

	/**
	 * This is true if the Type Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeNameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemvueModelPackage.Literals.PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PARAMETER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(Implementation newImplementation) {
		Implementation oldImplementation = implementation;
		implementation = newImplementation == null ? IMPLEMENTATION_EDEFAULT : newImplementation;
		boolean oldImplementationESet = implementationESet;
		implementationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PARAMETER__IMPLEMENTATION, oldImplementation, implementation, !oldImplementationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImplementation() {
		Implementation oldImplementation = implementation;
		boolean oldImplementationESet = implementationESet;
		implementation = IMPLEMENTATION_EDEFAULT;
		implementationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystemvueModelPackage.PARAMETER__IMPLEMENTATION, oldImplementation, IMPLEMENTATION_EDEFAULT, oldImplementationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImplementation() {
		return implementationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMemberName() {
		return memberName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberName(Object newMemberName) {
		Object oldMemberName = memberName;
		memberName = newMemberName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PARAMETER__MEMBER_NAME, oldMemberName, memberName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSizeName() {
		return sizeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeName(Object newSizeName) {
		Object oldSizeName = sizeName;
		sizeName = newSizeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PARAMETER__SIZE_NAME, oldSizeName, sizeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(TypeName newTypeName) {
		TypeName oldTypeName = typeName;
		typeName = newTypeName == null ? TYPE_NAME_EDEFAULT : newTypeName;
		boolean oldTypeNameESet = typeNameESet;
		typeNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PARAMETER__TYPE_NAME, oldTypeName, typeName, !oldTypeNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTypeName() {
		TypeName oldTypeName = typeName;
		boolean oldTypeNameESet = typeNameESet;
		typeName = TYPE_NAME_EDEFAULT;
		typeNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystemvueModelPackage.PARAMETER__TYPE_NAME, oldTypeName, TYPE_NAME_EDEFAULT, oldTypeNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTypeName() {
		return typeNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SystemvueModelPackage.PARAMETER__DESCRIPTION:
				return getDescription();
			case SystemvueModelPackage.PARAMETER__IMPLEMENTATION:
				return getImplementation();
			case SystemvueModelPackage.PARAMETER__MEMBER_NAME:
				return getMemberName();
			case SystemvueModelPackage.PARAMETER__NAME:
				return getName();
			case SystemvueModelPackage.PARAMETER__SIZE_NAME:
				return getSizeName();
			case SystemvueModelPackage.PARAMETER__TYPE_NAME:
				return getTypeName();
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
			case SystemvueModelPackage.PARAMETER__DESCRIPTION:
				setDescription(newValue);
				return;
			case SystemvueModelPackage.PARAMETER__IMPLEMENTATION:
				setImplementation((Implementation)newValue);
				return;
			case SystemvueModelPackage.PARAMETER__MEMBER_NAME:
				setMemberName(newValue);
				return;
			case SystemvueModelPackage.PARAMETER__NAME:
				setName(newValue);
				return;
			case SystemvueModelPackage.PARAMETER__SIZE_NAME:
				setSizeName(newValue);
				return;
			case SystemvueModelPackage.PARAMETER__TYPE_NAME:
				setTypeName((TypeName)newValue);
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
			case SystemvueModelPackage.PARAMETER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SystemvueModelPackage.PARAMETER__IMPLEMENTATION:
				unsetImplementation();
				return;
			case SystemvueModelPackage.PARAMETER__MEMBER_NAME:
				setMemberName(MEMBER_NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.PARAMETER__SIZE_NAME:
				setSizeName(SIZE_NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.PARAMETER__TYPE_NAME:
				unsetTypeName();
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
			case SystemvueModelPackage.PARAMETER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SystemvueModelPackage.PARAMETER__IMPLEMENTATION:
				return isSetImplementation();
			case SystemvueModelPackage.PARAMETER__MEMBER_NAME:
				return MEMBER_NAME_EDEFAULT == null ? memberName != null : !MEMBER_NAME_EDEFAULT.equals(memberName);
			case SystemvueModelPackage.PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SystemvueModelPackage.PARAMETER__SIZE_NAME:
				return SIZE_NAME_EDEFAULT == null ? sizeName != null : !SIZE_NAME_EDEFAULT.equals(sizeName);
			case SystemvueModelPackage.PARAMETER__TYPE_NAME:
				return isSetTypeName();
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
		result.append(" (description: ");
		result.append(description);
		result.append(", implementation: ");
		if (implementationESet) result.append(implementation); else result.append("<unset>");
		result.append(", memberName: ");
		result.append(memberName);
		result.append(", name: ");
		result.append(name);
		result.append(", sizeName: ");
		result.append(sizeName);
		result.append(", typeName: ");
		if (typeNameESet) result.append(typeName); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
