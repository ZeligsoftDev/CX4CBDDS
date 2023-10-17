/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionTypeImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionTypeImpl#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionTypeImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionTypeImpl#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTypeImpl
extends IterableTypeImpl
implements CollectionType {

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_TYPE_FEATURE_COUNT = IterableTypeImpl.ITERABLE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_TYPE_OPERATION_COUNT = IterableTypeImpl.ITERABLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NULL_FREE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_NULL_FREE_EFLAG = 1 << 12;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final Number LOWER_EDEFAULT = (Number)PivotFactory.eINSTANCE.createFromString(PivotPackage.eINSTANCE.getInteger(), "0"); //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected Number lower = LOWER_EDEFAULT;
	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final Number UPPER_EDEFAULT = (Number)PivotFactory.eINSTANCE.createFromString(PivotPackage.eINSTANCE.getUnlimitedNatural(), "*"); //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected Number upper = UPPER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected CollectionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsNullFree()
	{
		return (eFlags & IS_NULL_FREE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNullFree(boolean newIsNullFree)
	{
		boolean oldIsNullFree = (eFlags & IS_NULL_FREE_EFLAG) != 0;
		if (newIsNullFree) eFlags |= IS_NULL_FREE_EFLAG; else eFlags &= ~IS_NULL_FREE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 24, oldIsNullFree, newIsNullFree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number getLower()
	{
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLower(Number newLower)
	{
		Number oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 25, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number getUpper()
	{
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpper(Number newUpper)
	{
		Number oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 26, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case 0:
				return getAnnotatingComments();
			case 1:
				return getOwnedAnnotations();
			case 2:
				return getOwnedComments();
			case 3:
				return getOwnedExtensions();
			case 4:
				return getName();
			case 5:
				return getOwnedConstraints();
			case 6:
				return getOwnedBindings();
			case 7:
				return getOwnedSignature();
			case 8:
				return getUnspecializedElement();
			case 9:
				return getExtenders();
			case 10:
				return getInstanceClassName();
			case 11:
				return isIsAbstract();
			case 12:
				return isIsActive();
			case 13:
				return isIsInterface();
			case 14:
				return getOwnedBehaviors();
			case 15:
				return getOwnedInvariants();
			case 16:
				return getOwnedOperations();
			case 17:
				return getOwnedProperties();
			case 18:
				return getOwningPackage();
			case 19:
				return getSuperClasses();
			case 20:
				if (resolve) return getBehavioralClass();
				return basicGetBehavioralClass();
			case 21:
				return isIsSerializable();
			case 22:
				return getValue();
			case 23:
				return getElementType();
			case 24:
				return isIsNullFree();
			case 25:
				return getLower();
			case 26:
				return getUpper();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case 0:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 1:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case 2:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 3:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case 4:
				setName((String)newValue);
				return;
			case 5:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 6:
				getOwnedBindings().clear();
				getOwnedBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case 7:
				setOwnedSignature((TemplateSignature)newValue);
				return;
			case 8:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case 9:
				getExtenders().clear();
				getExtenders().addAll((Collection<? extends StereotypeExtender>)newValue);
				return;
			case 10:
				setInstanceClassName((String)newValue);
				return;
			case 11:
				setIsAbstract((Boolean)newValue);
				return;
			case 12:
				setIsActive((Boolean)newValue);
				return;
			case 13:
				setIsInterface((Boolean)newValue);
				return;
			case 14:
				getOwnedBehaviors().clear();
				getOwnedBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case 15:
				getOwnedInvariants().clear();
				getOwnedInvariants().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 16:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case 17:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case 18:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case 19:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case 20:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case 21:
				setIsSerializable((Boolean)newValue);
				return;
			case 23:
				setElementType((Type)newValue);
				return;
			case 24:
				setIsNullFree((Boolean)newValue);
				return;
			case 25:
				setLower((Number)newValue);
				return;
			case 26:
				setUpper((Number)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case 0:
				getAnnotatingComments().clear();
				return;
			case 1:
				getOwnedAnnotations().clear();
				return;
			case 2:
				getOwnedComments().clear();
				return;
			case 3:
				getOwnedExtensions().clear();
				return;
			case 4:
				setName(NAME_EDEFAULT);
				return;
			case 5:
				getOwnedConstraints().clear();
				return;
			case 6:
				getOwnedBindings().clear();
				return;
			case 7:
				setOwnedSignature((TemplateSignature)null);
				return;
			case 8:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case 9:
				getExtenders().clear();
				return;
			case 10:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case 11:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case 12:
				setIsActive(IS_ACTIVE_EDEFAULT);
				return;
			case 13:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case 14:
				getOwnedBehaviors().clear();
				return;
			case 15:
				getOwnedInvariants().clear();
				return;
			case 16:
				getOwnedOperations().clear();
				return;
			case 17:
				getOwnedProperties().clear();
				return;
			case 18:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
				return;
			case 19:
				getSuperClasses().clear();
				return;
			case 20:
				setBehavioralClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case 21:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case 23:
				setElementType((Type)null);
				return;
			case 24:
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
				return;
			case 25:
				setLower(LOWER_EDEFAULT);
				return;
			case 26:
				setUpper(UPPER_EDEFAULT);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case 0:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case 1:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case 2:
				return ownedComments != null && !ownedComments.isEmpty();
			case 3:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case 4:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 5:
				return ownedConstraints != null && !ownedConstraints.isEmpty();
			case 6:
				return ownedBindings != null && !ownedBindings.isEmpty();
			case 7:
				return ownedSignature != null;
			case 8:
				return unspecializedElement != null;
			case 9:
				return extenders != null && !extenders.isEmpty();
			case 10:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case 11:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case 12:
				return ((eFlags & IS_ACTIVE_EFLAG) != 0) != IS_ACTIVE_EDEFAULT;
			case 13:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case 14:
				return ownedBehaviors != null && !ownedBehaviors.isEmpty();
			case 15:
				return ownedInvariants != null && !ownedInvariants.isEmpty();
			case 16:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case 17:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case 18:
				return getOwningPackage() != null;
			case 19:
				return superClasses != null && !superClasses.isEmpty();
			case 20:
				return behavioralClass != null;
			case 21:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case 22:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
			case 23:
				return getElementType() != null;
			case 24:
				return ((eFlags & IS_NULL_FREE_EFLAG) != 0) != IS_NULL_FREE_EDEFAULT;
			case 25:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case 26:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCollectionType(this);
	}

	@Deprecated /* @deprecated no longer duplicates template binding */
	protected Type elementType = null;

	@Deprecated /* @deprecated no longer duplicates template binding */
	public Type basicGetElementType() {
		return getElementType();
	}

	@Override
	public @NonNull TypeId computeId() {
		TemplateableElement unspecializedElement2 = getUnspecializedElement();
		if (unspecializedElement2 == null) {
			if (TypeId.COLLECTION_NAME.equals(name)) {
				return TypeId.COLLECTION;
			}
			else if (TypeId.UNIQUE_COLLECTION_NAME.equals(name)) {
				return TypeId.UNIQUE_COLLECTION;
			}
			else {
				String name2 = name;
				assert name2 != null;
				return IdManager.getCollectionTypeId(name2);		// e.g. UniqueCollection
			}
		}
		else {
			CollectionTypeId collectionTypeId = ((CollectionType)unspecializedElement2).getTypeId();
			TypeId elementTypeId = getElementType().getTypeId();
			return collectionTypeId.getSpecializedId(elementTypeId, isIsNullFree(), getLowerValue(), getUpperValue());
		}
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TypeId computeNormalizedId() {
		TemplateableElement unspecializedElement2 = getUnspecializedElement();
		if (unspecializedElement2 == null) {
			if (TypeId.COLLECTION_NAME.equals(name)) {
				return TypeId.COLLECTION;
			}
			else if (TypeId.UNIQUE_COLLECTION_NAME.equals(name)) {
				return TypeId.UNIQUE_COLLECTION;
			}
			else {
				String name2 = name;
				assert name2 != null;
				return IdManager.getCollectionTypeId(name2);		// e.g. UniqueCollection
			}
		}
		else {
			CollectionTypeId collectionTypeId = ((CollectionType)unspecializedElement2).getTypeId();
			TypeId elementTypeId = getElementType().getNormalizedTypeId();
			return collectionTypeId.getSpecializedId(elementTypeId, isIsNullFree(), getLowerValue(), getUpperValue());
		}
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (type instanceof CollectionType) {
			return TypeUtil.conformsToCollectionType(standardLibrary, this, (CollectionType)type);
		}
		if (getUnspecializedElement() != null) {
			return ((Type)getUnspecializedElement()).conformsTo(standardLibrary, type);
		}
		return super.conformsTo(standardLibrary, type);
	}

	@Override
	public Type flattenedType() {
		return getElementType();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		CompleteEnvironment environment = idResolver.getEnvironment();
		StandardLibrary standardLibrary = environment.getOwnedStandardLibrary();
		CompleteInheritance thisInheritance = this.getInheritance(standardLibrary);
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		CompleteInheritance commonInheritance = thisInheritance.getCommonInheritance(thatInheritance);
		org.eclipse.ocl.pivot.Class commonType = commonInheritance.getPivotClass();
		if (type instanceof CollectionType) {
			CollectionType thatCollectionType = (CollectionType)type;
			Type thisElementType = this.getElementType();
			Type thatElementType = ClassUtil.nonNullEMF(thatCollectionType.getElementType());
			boolean commonIsNullFree = this.isIsNullFree() && thatCollectionType.isIsNullFree();
			Type commonElementType = thisElementType.getCommonType(idResolver, thatElementType);
			if ((commonInheritance instanceof CompleteInheritanceImpl) && !((CompleteInheritanceImpl)commonInheritance).isIsAbstract()) {
				CollectionType commonCollectionType = (CollectionType)commonType;
				return environment.getCollectionType(commonCollectionType, commonElementType, commonIsNullFree, null, null);
			}
			else {
				if (isOrdered() && thatCollectionType.isOrdered()) {
					if (isUnique() && thatCollectionType.isUnique()) {
						return environment.getOrderedSetType(commonElementType, commonIsNullFree, null, null);
					}
					else {
						return environment.getSequenceType(commonElementType, commonIsNullFree, null, null);
					}
				}
				else {
					if (isUnique() && thatCollectionType.isUnique()) {
						return environment.getSetType(commonElementType, commonIsNullFree, null, null);
					}
					else {
						return environment.getBagType(commonElementType, commonIsNullFree, null, null);
					}
				}
			}
		}
		else {
			return commonType;
		}
	}

	@Override
	public @NonNull CollectionType getContainerType() {
		TemplateableElement unspecializedElement2 = unspecializedElement;
		return unspecializedElement2 != null ? (CollectionType)unspecializedElement2 : this;
	}

	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return (CollectionTypeId) super.getTypeId();
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof CollectionType)) {
			return false;
		}
		return TypeUtil.isEqualToCollectionType(standardLibrary, this, (CollectionType)type);
	}

	@Override
	public Type getElementType() {
		TemplateSignature templateSignature = getOwnedSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			return templateParameters.get(0);
		}
		else {
			List<TemplateBinding> templateBindings = getOwnedBindings();
			List<TemplateParameterSubstitution> templateParameterSubstitutions = templateBindings.get(0).getOwnedSubstitutions();
			return templateParameterSubstitutions.get(0).getActual();
		}
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		Number lower2 = lower;
		assert lower2 != null;
		return ValueUtil.integerValueOf(lower2);
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		Number upper2 = upper;
		assert upper2 != null;
		return ValueUtil.unlimitedNaturalValueOf(upper2);
	}

	@Override
	public void setElementType(Type newElementType) {				// FIXME delete me once compatibility not needed
		System.err.println(eClass().getName() + ".setElementType() is ignored");
	}

	@Override
	public void setLowerValue(@NonNull IntegerValue lower) {
		setLower(lower.intValue());
	}

	@Override
	public void setUpperValue(@NonNull UnlimitedNaturalValue upper) {
		setUpper(upper.isUnlimited() ? Unlimited.INSTANCE : upper.intValue());
	}
} //CollectionTypeImpl
