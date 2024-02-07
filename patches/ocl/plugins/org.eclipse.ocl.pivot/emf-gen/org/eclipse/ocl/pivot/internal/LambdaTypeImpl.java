/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Behavior;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lambda Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaTypeImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaTypeImpl#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.LambdaTypeImpl#getResultType <em>Result Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LambdaTypeImpl extends DataTypeImpl implements LambdaType
{
	/**
	 * The number of structural features of the '<em>Lambda Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAMBDA_TYPE_FEATURE_COUNT = DataTypeImpl.DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Lambda Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAMBDA_TYPE_OPERATION_COUNT = DataTypeImpl.DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected Type contextType;

	/**
	 * The cached value of the '{@link #getParameterType() <em>Parameter Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> parameterType;

	/**
	 * The cached value of the '{@link #getResultType() <em>Result Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultType()
	 * @generated
	 * @ordered
	 */
	protected Type resultType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LambdaTypeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.LAMBDA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getContextType()
	{
		if (contextType != null && contextType.eIsProxy())
		{
			InternalEObject oldContextType = (InternalEObject)contextType;
			contextType = (Type)eResolveProxy(oldContextType);
			if (contextType != oldContextType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 23, oldContextType, contextType));
			}
		}
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetContextType()
	{
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContextType(Type newContextType)
	{
		Type oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 23, oldContextType, contextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Type> getParameterType()
	{
		if (parameterType == null)
		{
			parameterType = new EObjectResolvingEList<Type>(Type.class, this, 24);
		}
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getResultType()
	{
		if (resultType != null && resultType.eIsProxy())
		{
			InternalEObject oldResultType = (InternalEObject)resultType;
			resultType = (Type)eResolveProxy(oldResultType);
			if (resultType != oldResultType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 25, oldResultType, resultType));
			}
		}
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetResultType()
	{
		return resultType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultType(Type newResultType)
	{
		Type oldResultType = resultType;
		resultType = newResultType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 25, oldResultType, resultType));
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
				if (resolve) return getContextType();
				return basicGetContextType();
			case 24:
				return getParameterType();
			case 25:
				if (resolve) return getResultType();
				return basicGetResultType();
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
				setContextType((Type)newValue);
				return;
			case 24:
				getParameterType().clear();
				getParameterType().addAll((Collection<? extends Type>)newValue);
				return;
			case 25:
				setResultType((Type)newValue);
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
				setContextType((Type)null);
				return;
			case 24:
				getParameterType().clear();
				return;
			case 25:
				setResultType((Type)null);
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
				return contextType != null;
			case 24:
				return parameterType != null && !parameterType.isEmpty();
			case 25:
				return resultType != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitLambdaType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		return IdManager.getLambdaTypeId(this);
	}

	@Override
	public @NonNull TypeId computeNormalizedId() {
		List<Type> parameterTypes = getParameterType();
		@NonNull TypeId @NonNull [] typeIds = new @NonNull TypeId[2+parameterTypes.size()];
		typeIds[0] = getContextType().getNormalizedTypeId();
		typeIds[1] = getResultType().getNormalizedTypeId();
		for (int i = 0; i < parameterTypes.size(); i++) {
			typeIds[2+i] = parameterTypes.get(i).getNormalizedTypeId();
		}
		ParametersId parametersId = IdManager.getParametersId(typeIds);
		String name = NameUtil.getSafeName(this);
		return IdManager.getLambdaTypeId(name, parametersId);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof LambdaType)) {
			return false;
		}
		return TypeUtil.conformsToLambdaType(standardLibrary, this, (LambdaType)type);
	}

	private ParametersId parametersId = null;

	@Override
	public @NonNull ParametersId getParametersId() {
		ParametersId parametersId2 = parametersId;
		if (parametersId2 == null) {
			synchronized (this) {
				parametersId2 = parametersId;
				if (parametersId2 == null) {
					List<Type> parameterTypes = getParameterType();
					@NonNull TypeId @NonNull [] typeIds = new @NonNull TypeId[2+parameterTypes.size()];
					typeIds[0] = getContextType().getTypeId();
					typeIds[1] = getResultType().getTypeId();
					for (int i = 0; i < parameterTypes.size(); i++) {
						typeIds[2+i] = parameterTypes.get(i).getTypeId();
					}
					parametersId = parametersId2 = IdManager.getParametersId(typeIds);
				}
			}
		}
		return parametersId2;
	}

	@Override
	public @NonNull List<? extends Type> getParameterTypes() {
		return getParameterType();
	}
} //LambdaTypeImpl
