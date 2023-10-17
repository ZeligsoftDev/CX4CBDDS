/**
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Operation;
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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MapTypeImpl#getEntryClass <em>Entry Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MapTypeImpl#getKeyType <em>Key Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MapTypeImpl#isKeysAreNullFree <em>Keys Are Null Free</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MapTypeImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.MapTypeImpl#isValuesAreNullFree <em>Values Are Null Free</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MapTypeImpl extends IterableTypeImpl implements MapType
{
	/**
	 * The number of structural features of the '<em>Map Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAP_TYPE_FEATURE_COUNT = IterableTypeImpl.ITERABLE_TYPE_FEATURE_COUNT + 5;
	/**
	 * The number of operations of the '<em>Map Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAP_TYPE_OPERATION_COUNT = IterableTypeImpl.ITERABLE_TYPE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getEntryClass() <em>Entry Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * @since 1.7
	 * <!-- end-user-doc -->
	 * @see #getEntryClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Class entryClass;
	/**
	 * The default value of the '{@link #isKeysAreNullFree() <em>Keys Are Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @see #isKeysAreNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEYS_ARE_NULL_FREE_EDEFAULT = true;
	/**
	 * The flag representing the value of the '{@link #isKeysAreNullFree() <em>Keys Are Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @see #isKeysAreNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final int KEYS_ARE_NULL_FREE_EFLAG = 1 << 12;
	/**
	 * The default value of the '{@link #isValuesAreNullFree() <em>Values Are Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @see #isValuesAreNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUES_ARE_NULL_FREE_EDEFAULT = true;
	/**
	 * The flag representing the value of the '{@link #isValuesAreNullFree() <em>Values Are Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @see #isValuesAreNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUES_ARE_NULL_FREE_EFLAG = 1 << 13;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapTypeImpl()
	{
		super();
		eFlags |= KEYS_ARE_NULL_FREE_EFLAG;
		eFlags |= VALUES_ARE_NULL_FREE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.MAP_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getEntryClass()
	{
		if (entryClass != null && entryClass.eIsProxy())
		{
			InternalEObject oldEntryClass = (InternalEObject)entryClass;
			entryClass = (org.eclipse.ocl.pivot.Class)eResolveProxy(oldEntryClass);
			if (entryClass != oldEntryClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 23, oldEntryClass, entryClass));
			}
		}
		return entryClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.7
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Class basicGetEntryClass()
	{
		return entryClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntryClass(org.eclipse.ocl.pivot.Class newEntryClass)
	{
		org.eclipse.ocl.pivot.Class oldEntryClass = entryClass;
		entryClass = newEntryClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 23, oldEntryClass, entryClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
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
				if (resolve) return getEntryClass();
				return basicGetEntryClass();
			case 24:
				return getKeyType();
			case 25:
				return isKeysAreNullFree();
			case 26:
				return getValueType();
			case 27:
				return isValuesAreNullFree();
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
	public void eSet(int featureID, Object newValue)
	{
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
				setEntryClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case 24:
				setKeyType((Type)newValue);
				return;
			case 25:
				setKeysAreNullFree((Boolean)newValue);
				return;
			case 26:
				setValueType((Type)newValue);
				return;
			case 27:
				setValuesAreNullFree((Boolean)newValue);
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
	public void eUnset(int featureID)
	{
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
				setEntryClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case 24:
				setKeyType((Type)null);
				return;
			case 25:
				setKeysAreNullFree(KEYS_ARE_NULL_FREE_EDEFAULT);
				return;
			case 26:
				setValueType((Type)null);
				return;
			case 27:
				setValuesAreNullFree(VALUES_ARE_NULL_FREE_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
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
				return entryClass != null;
			case 24:
				return getKeyType() != null;
			case 25:
				return ((eFlags & KEYS_ARE_NULL_FREE_EFLAG) != 0) != KEYS_ARE_NULL_FREE_EDEFAULT;
			case 26:
				return getValueType() != null;
			case 27:
				return ((eFlags & VALUES_ARE_NULL_FREE_EFLAG) != 0) != VALUES_ARE_NULL_FREE_EDEFAULT;
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

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMapType(this);
	}

	@Deprecated /* @deprecated no longer duplicates template binding */
	protected Type keyType = null;
	@Deprecated /* @deprecated no longer duplicates template binding */
	protected Type valueType = null;

	@Deprecated /* @deprecated no longer duplicates template binding */
	public Type basicGetKeyType() {
		return getKeyType();
	}

	@Deprecated /* @deprecated no longer duplicates template binding */
	public Type basicGetValueType() {
		return getValueType();
	}

	@Override
	public @NonNull TypeId computeId() {
		if (getUnspecializedElement() == null) {
			return TypeId.MAP;
		}
		else {
			TypeId keyTypeId = getKeyType().getTypeId();
			TypeId valueTypeId = getValueType().getTypeId();
			return TypeId.MAP.getSpecializedId(keyTypeId, valueTypeId, isKeysAreNullFree(), isValuesAreNullFree());
		}
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TypeId computeNormalizedId() {
		if (getUnspecializedElement() == null) {
			return TypeId.MAP;
		}
		else {
			TypeId keyTypeId = getKeyType().getNormalizedTypeId();
			TypeId valueTypeId = getValueType().getNormalizedTypeId();
			return TypeId.MAP.getSpecializedId(keyTypeId, valueTypeId, isKeysAreNullFree(), isValuesAreNullFree());
		}
	}

	@Override
	public Type getKeyType() {
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
	public Type getValueType() {
		TemplateSignature templateSignature = getOwnedSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			return templateParameters.get(1);
		}
		else {
			List<TemplateBinding> templateBindings = getOwnedBindings();
			List<TemplateParameterSubstitution> templateParameterSubstitutions = templateBindings.get(0).getOwnedSubstitutions();
			return templateParameterSubstitutions.get(1).getActual();
		}
	}

	@Override
	public void setKeyType(Type newKeyType) {				// FIXME delete me once compatibility not needed
		System.err.println(eClass().getName() + ".setKeyType() is ignored");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isKeysAreNullFree()
	{
		return (eFlags & KEYS_ARE_NULL_FREE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKeysAreNullFree(boolean newKeysAreNullFree)
	{
		boolean oldKeysAreNullFree = (eFlags & KEYS_ARE_NULL_FREE_EFLAG) != 0;
		if (newKeysAreNullFree) eFlags |= KEYS_ARE_NULL_FREE_EFLAG; else eFlags &= ~KEYS_ARE_NULL_FREE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 25, oldKeysAreNullFree, newKeysAreNullFree));
	}

	@Override
	public void setValueType(Type newValueType) {			// FIXME delete me once compatibility not needed
		System.err.println(eClass().getName() + ".setValueType() is ignored");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isValuesAreNullFree()
	{
		return (eFlags & VALUES_ARE_NULL_FREE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValuesAreNullFree(boolean newValuesAreNullFree)
	{
		boolean oldValuesAreNullFree = (eFlags & VALUES_ARE_NULL_FREE_EFLAG) != 0;
		if (newValuesAreNullFree) eFlags |= VALUES_ARE_NULL_FREE_EFLAG; else eFlags &= ~VALUES_ARE_NULL_FREE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 27, oldValuesAreNullFree, newValuesAreNullFree));
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (type instanceof MapType) {
			return TypeUtil.conformsToMapType(standardLibrary, this, (MapType)type);
		}
		if (getUnspecializedElement() != null) {
			return ((Type)getUnspecializedElement()).conformsTo(standardLibrary, type);
		}
		return super.conformsTo(standardLibrary, type);
	}

	@Override
	public @NonNull MapType getContainerType() {
		TemplateableElement unspecializedElement2 = unspecializedElement;
		return unspecializedElement2 != null ? (MapType)unspecializedElement2 : this;
	}
} //MapTypeImpl
