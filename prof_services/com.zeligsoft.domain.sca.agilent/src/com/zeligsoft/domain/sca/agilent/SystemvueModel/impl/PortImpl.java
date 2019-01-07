/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.Port;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage;
import com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getBusSize <em>Bus Size</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getMemberName <em>Member Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getRate <em>Rate</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getRateVariableName <em>Rate Variable Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends EObjectImpl implements Port {
	/**
	 * The default value of the '{@link #getBusSize() <em>Bus Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusSize()
	 * @generated
	 * @ordered
	 */
	protected static final Object BUS_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusSize() <em>Bus Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusSize()
	 * @generated
	 * @ordered
	 */
	protected Object busSize = BUS_SIZE_EDEFAULT;

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
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionType DIRECTION_EDEFAULT = DirectionType.INPUT;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected DirectionType direction = DIRECTION_EDEFAULT;

	/**
	 * This is true if the Direction attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean directionESet;

	/**
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final ImplementationType IMPLEMENTATION_EDEFAULT = ImplementationType.SCALAR;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected ImplementationType implementation = IMPLEMENTATION_EDEFAULT;

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
	 * The default value of the '{@link #getRate() <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRate()
	 * @generated
	 * @ordered
	 */
	protected static final Object RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRate() <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRate()
	 * @generated
	 * @ordered
	 */
	protected Object rate = RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRateVariableName() <em>Rate Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final Object RATE_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRateVariableName() <em>Rate Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRateVariableName()
	 * @generated
	 * @ordered
	 */
	protected Object rateVariableName = RATE_VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final TypeNameType TYPE_NAME_EDEFAULT = TypeNameType.INT;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected TypeNameType typeName = TYPE_NAME_EDEFAULT;

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
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemvueModelPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBusSize() {
		return busSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusSize(Object newBusSize) {
		Object oldBusSize = busSize;
		busSize = newBusSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__BUS_SIZE, oldBusSize, busSize));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionType getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(DirectionType newDirection) {
		DirectionType oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		boolean oldDirectionESet = directionESet;
		directionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__DIRECTION, oldDirection, direction, !oldDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirection() {
		DirectionType oldDirection = direction;
		boolean oldDirectionESet = directionESet;
		direction = DIRECTION_EDEFAULT;
		directionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystemvueModelPackage.PORT__DIRECTION, oldDirection, DIRECTION_EDEFAULT, oldDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirection() {
		return directionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationType getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(ImplementationType newImplementation) {
		ImplementationType oldImplementation = implementation;
		implementation = newImplementation == null ? IMPLEMENTATION_EDEFAULT : newImplementation;
		boolean oldImplementationESet = implementationESet;
		implementationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__IMPLEMENTATION, oldImplementation, implementation, !oldImplementationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImplementation() {
		ImplementationType oldImplementation = implementation;
		boolean oldImplementationESet = implementationESet;
		implementation = IMPLEMENTATION_EDEFAULT;
		implementationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystemvueModelPackage.PORT__IMPLEMENTATION, oldImplementation, IMPLEMENTATION_EDEFAULT, oldImplementationESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__MEMBER_NAME, oldMemberName, memberName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRate() {
		return rate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRate(Object newRate) {
		Object oldRate = rate;
		rate = newRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__RATE, oldRate, rate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRateVariableName() {
		return rateVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRateVariableName(Object newRateVariableName) {
		Object oldRateVariableName = rateVariableName;
		rateVariableName = newRateVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__RATE_VARIABLE_NAME, oldRateVariableName, rateVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeNameType getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(TypeNameType newTypeName) {
		TypeNameType oldTypeName = typeName;
		typeName = newTypeName == null ? TYPE_NAME_EDEFAULT : newTypeName;
		boolean oldTypeNameESet = typeNameESet;
		typeNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemvueModelPackage.PORT__TYPE_NAME, oldTypeName, typeName, !oldTypeNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTypeName() {
		TypeNameType oldTypeName = typeName;
		boolean oldTypeNameESet = typeNameESet;
		typeName = TYPE_NAME_EDEFAULT;
		typeNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SystemvueModelPackage.PORT__TYPE_NAME, oldTypeName, TYPE_NAME_EDEFAULT, oldTypeNameESet));
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
			case SystemvueModelPackage.PORT__BUS_SIZE:
				return getBusSize();
			case SystemvueModelPackage.PORT__DESCRIPTION:
				return getDescription();
			case SystemvueModelPackage.PORT__DIRECTION:
				return getDirection();
			case SystemvueModelPackage.PORT__IMPLEMENTATION:
				return getImplementation();
			case SystemvueModelPackage.PORT__MEMBER_NAME:
				return getMemberName();
			case SystemvueModelPackage.PORT__NAME:
				return getName();
			case SystemvueModelPackage.PORT__RATE:
				return getRate();
			case SystemvueModelPackage.PORT__RATE_VARIABLE_NAME:
				return getRateVariableName();
			case SystemvueModelPackage.PORT__TYPE_NAME:
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
			case SystemvueModelPackage.PORT__BUS_SIZE:
				setBusSize(newValue);
				return;
			case SystemvueModelPackage.PORT__DESCRIPTION:
				setDescription(newValue);
				return;
			case SystemvueModelPackage.PORT__DIRECTION:
				setDirection((DirectionType)newValue);
				return;
			case SystemvueModelPackage.PORT__IMPLEMENTATION:
				setImplementation((ImplementationType)newValue);
				return;
			case SystemvueModelPackage.PORT__MEMBER_NAME:
				setMemberName(newValue);
				return;
			case SystemvueModelPackage.PORT__NAME:
				setName(newValue);
				return;
			case SystemvueModelPackage.PORT__RATE:
				setRate(newValue);
				return;
			case SystemvueModelPackage.PORT__RATE_VARIABLE_NAME:
				setRateVariableName(newValue);
				return;
			case SystemvueModelPackage.PORT__TYPE_NAME:
				setTypeName((TypeNameType)newValue);
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
			case SystemvueModelPackage.PORT__BUS_SIZE:
				setBusSize(BUS_SIZE_EDEFAULT);
				return;
			case SystemvueModelPackage.PORT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SystemvueModelPackage.PORT__DIRECTION:
				unsetDirection();
				return;
			case SystemvueModelPackage.PORT__IMPLEMENTATION:
				unsetImplementation();
				return;
			case SystemvueModelPackage.PORT__MEMBER_NAME:
				setMemberName(MEMBER_NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.PORT__RATE:
				setRate(RATE_EDEFAULT);
				return;
			case SystemvueModelPackage.PORT__RATE_VARIABLE_NAME:
				setRateVariableName(RATE_VARIABLE_NAME_EDEFAULT);
				return;
			case SystemvueModelPackage.PORT__TYPE_NAME:
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
			case SystemvueModelPackage.PORT__BUS_SIZE:
				return BUS_SIZE_EDEFAULT == null ? busSize != null : !BUS_SIZE_EDEFAULT.equals(busSize);
			case SystemvueModelPackage.PORT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SystemvueModelPackage.PORT__DIRECTION:
				return isSetDirection();
			case SystemvueModelPackage.PORT__IMPLEMENTATION:
				return isSetImplementation();
			case SystemvueModelPackage.PORT__MEMBER_NAME:
				return MEMBER_NAME_EDEFAULT == null ? memberName != null : !MEMBER_NAME_EDEFAULT.equals(memberName);
			case SystemvueModelPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SystemvueModelPackage.PORT__RATE:
				return RATE_EDEFAULT == null ? rate != null : !RATE_EDEFAULT.equals(rate);
			case SystemvueModelPackage.PORT__RATE_VARIABLE_NAME:
				return RATE_VARIABLE_NAME_EDEFAULT == null ? rateVariableName != null : !RATE_VARIABLE_NAME_EDEFAULT.equals(rateVariableName);
			case SystemvueModelPackage.PORT__TYPE_NAME:
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
		result.append(" (busSize: ");
		result.append(busSize);
		result.append(", description: ");
		result.append(description);
		result.append(", direction: ");
		if (directionESet) result.append(direction); else result.append("<unset>");
		result.append(", implementation: ");
		if (implementationESet) result.append(implementation); else result.append("<unset>");
		result.append(", memberName: ");
		result.append(memberName);
		result.append(", name: ");
		result.append(name);
		result.append(", rate: ");
		result.append(rate);
		result.append(", rateVariableName: ");
		result.append(rateVariableName);
		result.append(", typeName: ");
		if (typeNameESet) result.append(typeName); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //PortImpl
