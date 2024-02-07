/**
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.LambdaTypeManager;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TupleTypeManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.MapTypeParameters;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Environment</b></em>'.
 * @extends org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteEnvironmentImpl#getOwnedCompleteModel <em>Owned Complete Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteEnvironmentImpl#getOwnedStandardLibrary <em>Owned Standard Library</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompleteEnvironmentImpl extends ElementImpl implements CompleteEnvironment, org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal
{
	/**
	 * The number of structural features of the '<em>Complete Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_ENVIRONMENT_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 2;
	/**
	 * The number of operations of the '<em>Complete Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_ENVIRONMENT_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteEnvironmentImpl()
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
		return PivotPackage.Literals.COMPLETE_ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetOwnedCompleteModel(CompleteModel newOwnedCompleteModel, NotificationChain msgs)
	{
		CompleteModel oldOwnedCompleteModel = ownedCompleteModel;
		ownedCompleteModel = (CompleteModelInternal) newOwnedCompleteModel;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.Literals.COMPLETE_ENVIRONMENT__OWNED_COMPLETE_MODEL.getFeatureID(), oldOwnedCompleteModel, newOwnedCompleteModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedCompleteModel(CompleteModel newOwnedCompleteModel)
	{
		if (newOwnedCompleteModel != ownedCompleteModel)
		{
			NotificationChain msgs = null;
			if (ownedCompleteModel != null)
				msgs = ((InternalEObject)ownedCompleteModel).eInverseRemove(this, 7, CompleteModel.class, msgs);
			if (newOwnedCompleteModel != null)
				msgs = ((InternalEObject)newOwnedCompleteModel).eInverseAdd(this, 7, CompleteModel.class, msgs);
			msgs = basicSetOwnedCompleteModel(newOwnedCompleteModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, newOwnedCompleteModel, newOwnedCompleteModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetOwnedStandardLibrary(StandardLibrary newOwnedStandardLibrary, NotificationChain msgs)
	{
		StandardLibrary oldOwnedStandardLibrary = ownedStandardLibrary;
		ownedStandardLibrary = (StandardLibraryInternal) newOwnedStandardLibrary;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.Literals.COMPLETE_ENVIRONMENT__OWNED_STANDARD_LIBRARY.getFeatureID(), oldOwnedStandardLibrary, newOwnedStandardLibrary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedStandardLibrary(StandardLibrary newOwnedStandardLibrary)
	{
		if (newOwnedStandardLibrary != ownedStandardLibrary)
		{
			NotificationChain msgs = null;
			if (ownedStandardLibrary != null)
				msgs = ((InternalEObject)ownedStandardLibrary).eInverseRemove(this, 4, StandardLibrary.class, msgs);
			if (newOwnedStandardLibrary != null)
				msgs = ((InternalEObject)newOwnedStandardLibrary).eInverseAdd(this, 4, StandardLibrary.class, msgs);
			msgs = basicSetOwnedStandardLibrary(newOwnedStandardLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, newOwnedStandardLibrary, newOwnedStandardLibrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case 4:
				if (ownedCompleteModel != null)
					msgs = ((InternalEObject)ownedCompleteModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (4), null, msgs);
				return basicSetOwnedCompleteModel((CompleteModel)otherEnd, msgs);
			case 5:
				if (ownedStandardLibrary != null)
					msgs = ((InternalEObject)ownedStandardLibrary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (5), null, msgs);
				return basicSetOwnedStandardLibrary((StandardLibrary)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case 0:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case 3:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case 4:
				return basicSetOwnedCompleteModel(null, msgs);
			case 5:
				return basicSetOwnedStandardLibrary(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
				return getOwnedCompleteModel();
			case 5:
				return getOwnedStandardLibrary();
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
				setOwnedCompleteModel((CompleteModel)newValue);
				return;
			case 5:
				setOwnedStandardLibrary((StandardLibrary)newValue);
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
				setOwnedCompleteModel((CompleteModel)null);
				return;
			case 5:
				setOwnedStandardLibrary((StandardLibrary)null);
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
				return ownedCompleteModel != null;
			case 5:
				return ownedStandardLibrary != null;
		}
		return eDynamicIsSet(featureID);
	}
	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteEnvironment(this);
	}
	protected /*final @NonNull*/ EnvironmentFactoryInternal environmentFactory;
	protected /*final @NonNull*/ CompleteModelInternal ownedCompleteModel;
	protected /*final @NonNull*/ StandardLibraryInternal ownedStandardLibrary;
	protected final @NonNull Map<org.eclipse.ocl.pivot.Class, CompleteClassInternal> class2completeClass = new WeakHashMap<org.eclipse.ocl.pivot.Class, CompleteClassInternal>();

	/**
	 * The known lambda types.
	 */
	private LambdaTypeManager lambdaManager = null;			// Lazily created

	/**
	 * The known tuple types.
	 */
	private @Nullable TupleTypeManager tupleManager = null;			// Lazily created
	private boolean isCodeGeneration = false;

	@Override
	public void addOrphanClass(org.eclipse.ocl.pivot.@NonNull Class pivotElement) {
		if (pivotElement.getUnspecializedElement() != null) {
			assert pivotElement.getUnspecializedElement().getUnspecializedElement() == null;
		}
		else {
			assert (pivotElement instanceof LambdaType)
			|| (pivotElement instanceof TupleType);
		}
		pivotElement.setOwningPackage(ownedCompleteModel.getOrphanage());
	}

	@Override
	public boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		//
		//	Resolve first template parameters to its substitution
		//
		TemplateParameter firstTemplateParameter = firstType.isTemplateParameter();
		if (firstTemplateParameter != null) {
			Type firstSubstitution = firstSubstitutions.get(firstTemplateParameter);
			if (firstSubstitution != null) {
				firstType = firstSubstitution;
			}
		}
		//
		//	Accrue solution to the econd template parameter
		//
		TemplateParameter secondTemplateParameter = secondType.isTemplateParameter();
		if (secondTemplateParameter != null) {
			//			Type secondSubstitution = secondSubstitutions.get(secondTemplateParameter);
			//			if (secondSubstitution != null) {
			//				secondType = secondSubstitution;
			//			}
			secondType = secondSubstitutions.put(secondTemplateParameter, firstType);
			return true;
		}
		if (firstType == secondType) {
			return true;
		}
		//
		//	Normalize types to their behavioral class
		//
		CompleteClass firstCompleteClass = getCompleteClass(firstType);
		CompleteClass secondCompleteClass = getCompleteClass(secondType);
		if (firstCompleteClass == secondCompleteClass) {
			return true;
		}
	//	firstType = firstCompleteClass.getPrimaryClass();
		Type behavioralClass = secondCompleteClass.getBehavioralClass();
		if (behavioralClass != secondType) {
			secondCompleteClass = getCompleteClass(behavioralClass);		// See Bug 574431 for disussion of this dodgy downcast
			secondType = behavioralClass;
		}
		//
		//	Use specialized conformance for constructed types, inheritance tree intersection for simple types
		//
		if (firstType == secondType) {
			return true;
		}
		else if ((firstType instanceof DataType) && (secondType instanceof DataType)) {
			if ((firstType instanceof CollectionType) && (secondType instanceof CollectionType)) {
				return conformsToCollectionType((CollectionType)firstType, firstSubstitutions, (CollectionType)secondType, secondSubstitutions);
			}
			else if ((firstType instanceof MapType) && (secondType instanceof MapType)) {
				return conformsToMapType((MapType)firstType, firstSubstitutions, (MapType)secondType, secondSubstitutions);
			}
			else if ((firstType instanceof LambdaType) && (secondType instanceof LambdaType)) {
				return conformsToLambdaType((LambdaType)firstType, firstSubstitutions, (LambdaType)secondType, secondSubstitutions);
			}
			else if ((firstType instanceof TupleType) && (secondType instanceof TupleType)) {
				return conformsToTupleType((TupleType)firstType, firstSubstitutions, (TupleType)secondType, secondSubstitutions);
			}
		}
		firstCompleteClass = getCompleteClass(firstType);
		secondCompleteClass = getCompleteClass(secondType);
		CompleteInheritance firstInheritance = firstCompleteClass.getCompleteInheritance();
		CompleteInheritance secondInheritance = secondCompleteClass.getCompleteInheritance();
		return firstInheritance.isSubInheritanceOf(secondInheritance);
	}

	/*	@Override
	public boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		CollectionType firstCollectionType2 = (CollectionType)firstCollectionType;
		CollectionType secondCollectionType2 = (CollectionType)secondCollectionType;
		TemplateParameterSubstitutions firstSubstitutions = TemplateParameterSubstitutionVisitor.createBindings(this, firstCollectionType2, secondCollectionType2);
		TemplateParameterSubstitutions secondSubstitutions = TemplateParameterSubstitutionVisitor.createBindings(this, secondCollectionType2, firstCollectionType2);
		return conformsToCollectionType(firstCollectionType2, firstSubstitutions, secondCollectionType2, secondSubstitutions);
	} */

	protected boolean conformsToCollectionType(@NonNull CollectionType firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull CollectionType secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		org.eclipse.ocl.pivot.Class firstContainerType = firstType.getContainerType();
		org.eclipse.ocl.pivot.Class secondContainerType = secondType.getContainerType();
		if (firstContainerType != secondContainerType) {
			CompleteClass firstContainerCompleteClass = getCompleteClass(firstContainerType);
			CompleteClass secondContainerCompleteClass = getCompleteClass(secondContainerType);
			CompleteInheritance firstContainerInheritance = firstContainerCompleteClass.getCompleteInheritance();
			CompleteInheritance secondContainerInheritance = secondContainerCompleteClass.getCompleteInheritance();
			if (!firstContainerInheritance.isSubInheritanceOf(secondContainerInheritance)) {
				return false;
			}
		}
		Type firstElementType = firstType.getElementType();
		Type secondElementType = secondType.getElementType();
		if ((firstElementType == null) || (secondElementType == null)) {
			return false;
		}
		IntegerValue firstLower = firstType.getLowerValue();
		IntegerValue secondLower = secondType.getLowerValue();
		if (firstLower.compareTo(secondLower) < 0) {
			return false;
		}
		UnlimitedNaturalValue firstUpper = firstType.getUpperValue();
		UnlimitedNaturalValue secondUpper = secondType.getUpperValue();
		if (firstUpper.compareTo(secondUpper) > 0) {
			return false;
		}
		return conformsTo(firstElementType, firstSubstitutions, secondElementType, secondSubstitutions);
	}

	protected boolean conformsToLambdaType(@NonNull LambdaType actualType, @NonNull TemplateParameterSubstitutions actualSubstitutions,
			@NonNull LambdaType requiredType, @NonNull TemplateParameterSubstitutions requiredSubstitutions) {
		Type actualContextType = actualType.getContextType();
		Type requiredContextType = requiredType.getContextType();
		if ((actualContextType == null) || (requiredContextType == null)) {
			return false;
		}
		if (!conformsTo(actualContextType, actualSubstitutions, requiredContextType, requiredSubstitutions)) {
			return false;
		}
		Type actualResultType = actualType.getResultType();
		Type requiredResultType = requiredType.getResultType();
		if ((actualResultType == null) || (requiredResultType == null)) {
			return false;
		}
		if (!conformsTo(requiredResultType, requiredSubstitutions, actualResultType, actualSubstitutions)) {	// contravariant
			return false;
		}
		List<Type> actualParameterTypes = actualType.getParameterType();
		List<Type> requiredParameterTypes = requiredType.getParameterType();
		int iMax = actualParameterTypes.size();
		if (iMax != requiredParameterTypes.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			Type actualParameterType = actualParameterTypes.get(i);
			Type requiredParameterType = requiredParameterTypes.get(i);
			if ((actualParameterType == null) || (requiredParameterType == null)) {
				return false;
			}
			if (!conformsTo(actualParameterType, actualSubstitutions, requiredParameterType, requiredSubstitutions)) {
				return false;
			}
		}
		return true;
	}

	protected boolean conformsToMapType(@NonNull MapType firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull MapType secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		//		org.eclipse.ocl.pivot.Class firstContainerType = firstType.getContainerType();
		//		org.eclipse.ocl.pivot.Class secondContainerType = secondType.getContainerType();
		//		if (firstContainerType != secondContainerType) {
		//			CompleteClass firstContainerCompleteClass = getCompleteClass(firstContainerType);
		//			CompleteClass secondContainerCompleteClass = getCompleteClass(secondContainerType);
		//			CompleteInheritance firstContainerInheritance = firstContainerCompleteClass.getCompleteInheritance();
		//			CompleteInheritance secondContainerInheritance = secondContainerCompleteClass.getCompleteInheritance();
		//			if (!firstContainerInheritance.isSubInheritanceOf(secondContainerInheritance)) {
		//				return false;
		//			}
		//		}
		Type firstKeyType = firstType.getKeyType();
		Type secondKeyType = secondType.getKeyType();
		if ((firstKeyType == null) || (secondKeyType == null)) {
			return false;
		}
		if (!conformsTo(firstKeyType, firstSubstitutions, secondKeyType, secondSubstitutions)) {
			return false;
		}
		Type firstValueType = firstType.getValueType();
		Type secondValueType = secondType.getValueType();
		if ((firstValueType == null) || (secondValueType == null)) {
			return false;
		}
		return conformsTo(firstValueType, firstSubstitutions, secondValueType, secondSubstitutions);
	}

	protected boolean conformsToTupleType(@NonNull TupleType actualType, @NonNull TemplateParameterSubstitutions actualSubstitutions,
			@NonNull TupleType requiredType, @NonNull TemplateParameterSubstitutions requiredSubstitutions) {
		List<Property> actualProperties = actualType.getOwnedProperties();
		List<Property> requiredProperties = requiredType.getOwnedProperties();
		if (actualProperties.size() != requiredProperties.size()) {
			return false;
		}
		for (Property actualProperty : actualProperties) {
			Property requiredProperty = NameUtil.getNameable(requiredProperties, actualProperty.getName());
			if (requiredProperty == null) {
				return false;
			}
			Type actualPropertyType = actualProperty.getType();
			Type requiredPropertyType = requiredProperty.getType();
			if ((actualPropertyType == null) || (requiredPropertyType == null)) {
				return false;
			}
			if (!conformsTo(actualPropertyType, actualSubstitutions, requiredPropertyType, requiredSubstitutions)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass, @NonNull CompleteClassInternal completeClass) {
		//		assert partialClass.getUnspecializedElement() == null;
		CompleteClass oldCompleteClass = class2completeClass.put(partialClass, completeClass);
		assert (oldCompleteClass == null) ||(oldCompleteClass == completeClass);
	}

	@Override
	public void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		class2completeClass.remove(pivotType);
	}

	@Override
	public void dispose() {
		class2completeClass.clear();
		if (lambdaManager != null) {
			lambdaManager.dispose();
			lambdaManager = null;
		}
		if (tupleManager != null) {
			tupleManager.dispose();
			tupleManager = null;
		}
	}

	@Override
	public @Nullable CollectionType findCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<@NonNull Type> typeParameters) {
		return completeClass.findCollectionType(typeParameters);
	}

	@Override
	public @Nullable MapType findMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters) {
		return completeClass.findMapType(typeParameters);
	}

	@Override
	public @NonNull CollectionType getBagType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getBagType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getBagType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getBagType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public @NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<@NonNull Type> typeParameters) {
		return completeClass.getCollectionType(typeParameters);
	}

	@Override
	public @NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return getCollectionType((CollectionType)metamodelManager.getPrimaryClass(containerType), metamodelManager.getPrimaryType(elementType), isNullFree, lower, upper);
	}

	@Override
	public @NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return getCollectionType((CollectionType)metamodelManager.getPrimaryClass(containerType), metamodelManager.getPrimaryType(elementType), false, lower, upper);
	}

	@Override
	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		CompleteClassInternal completeClass = ownedCompleteModel.getCompleteClass(containerType);
		if (isUnspecializedType(completeClass, elementType)) {
			return containerType;
		}
		CollectionTypeParameters<@NonNull Type> typeParameters = TypeUtil.createCollectionTypeParameters(elementType, isNullFree, lower, upper);
		@SuppressWarnings("unchecked")
		T specializedType = (T) completeClass.getCollectionType(typeParameters);
		return specializedType;
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType) {
		if (pivotType instanceof TemplateParameter) {
			pivotType = PivotUtil.getLowerBound((TemplateParameter) pivotType, getOwnedStandardLibrary().getOclAnyType());
		}
		if (pivotType instanceof ElementExtension) {
			Stereotype stereotype = ((ElementExtension)pivotType).getStereotype();
			if (stereotype != null) {
				pivotType = stereotype;
			}
		}
		CompleteClassInternal completeClass = class2completeClass.get(pivotType);
		if (completeClass != null) {
			return completeClass;
		}
		else if (pivotType instanceof PrimitiveType) {
			CompletePackageInternal primitiveCompletePackage = ownedCompleteModel.getPrimitiveCompletePackage();
			return primitiveCompletePackage.getCompleteClass((PrimitiveType)pivotType);
		}
		else if ((pivotType instanceof CollectionType) && (((CollectionType)pivotType).getUnspecializedElement() != null)) {
			CompletePackageInternal orphanCompletePackage = ownedCompleteModel.getOrphanCompletePackage();
			return orphanCompletePackage.getCompleteClass((CollectionType)pivotType);
		}
		else if (pivotType instanceof org.eclipse.ocl.pivot.Class) {
			org.eclipse.ocl.pivot.Package pivotPackage = ((org.eclipse.ocl.pivot.Class)pivotType).getOwningPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			CompletePackageInternal completePackage = ownedCompleteModel.getCompletePackage(pivotPackage);
			return completePackage.getCompleteClass((org.eclipse.ocl.pivot.Class) pivotType);
		}
		else {
			throw new UnsupportedOperationException("TemplateType");
		}
	}

	@Override
	public @NonNull CompleteModelInternal getOwnedCompleteModel() {
		return ClassUtil.nonNullState(ownedCompleteModel);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return ClassUtil.nonNullState(environmentFactory);
	}

	public @NonNull LambdaTypeManager getLambdaManager() {
		LambdaTypeManager lambdaManager2 = lambdaManager;
		if (lambdaManager2 == null) {
			lambdaManager2 = lambdaManager = new LambdaTypeManager(this);
		}
		return lambdaManager2;
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<@NonNull ? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		LambdaTypeManager lambdaManager = getLambdaManager();
		return lambdaManager.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}

	@Override
	public @NonNull MapType getMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters) {
		return completeClass.getMapType(typeParameters);
	}

	@Override
	public @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type keyType, @NonNull Type valueType) {
		return getMapType(containerType, keyType, true, valueType, true);
	}

	@Override
	public @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class containerType, @NonNull Type keyType, boolean keysAreNullFree, @NonNull Type valueType, boolean valuesAreNullFree) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return getMapType((MapType)metamodelManager.getPrimaryClass(containerType), metamodelManager.getPrimaryType(keyType), keysAreNullFree, metamodelManager.getPrimaryType(valueType), valuesAreNullFree);
	}

	/**
	 * @since 1.7
	 */
	@Override
	public @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class containerType, org.eclipse.ocl.pivot.@NonNull Class entryClass) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return getMapType((MapType)metamodelManager.getPrimaryClass(containerType), metamodelManager.getPrimaryClass(entryClass));
	}

	@Override
	public @NonNull MapType getMapType(@NonNull MapType containerType, @NonNull Type keyType, @NonNull Type valueType) {
		return getMapType(containerType, keyType, true, valueType, true);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public @NonNull MapType getMapType(@NonNull MapType containerType, @NonNull Type keyType, boolean keysAreNullFree, @NonNull Type valueType, boolean valuesAreNullFree) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		CompleteClassInternal completeClass = ownedCompleteModel.getCompleteClass(containerType);
		if (isUnspecializedType(completeClass, keyType, valueType)) {
			return containerType;
		}
		MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters = TypeUtil.createMapTypeParameters(keyType, keysAreNullFree, valueType, valuesAreNullFree);
		MapType specializedType = ownedCompleteModel.getMapType(completeClass, typeParameters);
		return specializedType;
	}

	/**
	 * @since 1.7
	 */
	public @NonNull MapType getMapType(@NonNull MapType containerType, org.eclipse.ocl.pivot.@NonNull Class entryType) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		TemplateSignature templateSignature = containerType.getOwnedSignature();
		if (templateSignature == null) {
			throw new IllegalArgumentException("Map type must have a template signature");
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		if (templateParameters.size() != 2) {
			throw new IllegalArgumentException("Map type must have exactly two template parameter");
		}
		//	boolean isUnspecialized = (keyType == templateParameters.get(0)) && (valueType == templateParameters.get(1));
		//	if (isUnspecialized) {
		//		return containerType;
		//	}
		CompleteClassInternal completeClass = ownedCompleteModel.getCompleteClass(containerType);
		MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters = TypeUtil.createMapTypeParameters(entryType);
		MapType specializedType = ownedCompleteModel.getMapType(completeClass, typeParameters);
		return specializedType;
	}

	//	@Override
	//	public @NonNull MetamodelManager getMetamodelManager() {
	//		assert metamodelManager != null;
	//		return metamodelManager;
	//	}

	@Override
	public org.eclipse.ocl.pivot.Package getNestedPackage(org.eclipse.ocl.pivot.@NonNull Package domainPackage, @NonNull String name) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		CompletePackage completePackage = metamodelManager.getCompletePackage(domainPackage);
		CompletePackage memberPackage = completePackage.getOwnedCompletePackage(name);
		return memberPackage != null ? memberPackage.getPrimaryPackage() : null;
	}

	@Override
	public org.eclipse.ocl.pivot.Class getNestedType(org.eclipse.ocl.pivot.@NonNull Package domainPackage, @NonNull String name) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		CompletePackage completePackage = metamodelManager.getCompletePackage(domainPackage);
		return completePackage.getMemberType(name);
	}

	@Override
	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getOrderedSetType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getOrderedSetType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getSequenceType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getSequenceType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getSetType(), elementType, isNullFree, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return getCollectionType(ownedStandardLibrary.getSetType(), elementType, false, lower, upper);
	}

	@Override
	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		if ((substitutions == null) || substitutions.isEmpty()) {
			return type;
		}
		TemplateParameter asTemplateParameter = type.isTemplateParameter();
		if (asTemplateParameter != null) {
			Type boundType = substitutions.get(asTemplateParameter);
			org.eclipse.ocl.pivot.Class asClass = boundType != null ? boundType.isClass() : null;
			return asClass != null ? asClass : type;
		}
		else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			CollectionType unspecializedType = PivotUtil.getUnspecializedTemplateableElement(collectionType);
			if (!substitutions.isEmpty()) {
				TemplateParameter templateParameter = unspecializedType.getOwnedSignature().getOwnedParameters().get(0);
				Type templateArgument = substitutions.get(templateParameter);
				if (templateArgument == null) {
					templateArgument = templateParameter;
				}
				if (templateArgument != null) {
					return getCollectionType(unspecializedType, templateArgument, null, null);
				}
			}
			return collectionType;
		}
		else if (type instanceof TupleType) {
			return getTupleManager().getTupleType((TupleType) type, substitutions);
		}
		else if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			String typeName = ClassUtil.nonNullModel(lambdaType.getName());
			Type contextType = ClassUtil.nonNullModel(lambdaType.getContextType());
			@NonNull List<@NonNull Type> parameterType = PivotUtil.getParameterType(lambdaType);
			Type resultType = ClassUtil.nonNullModel(lambdaType.getResultType());
			return getLambdaManager().getLambdaType(typeName, contextType, parameterType, resultType, substitutions);
		}
		else if (type instanceof org.eclipse.ocl.pivot.Class) {
			//
			//	Get the bindings of the type.
			//
			org.eclipse.ocl.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.pivot.Class)type);
			//
			//	Prepare the template argument list, one template argument per template parameter.
			//
			TemplateSignature templateSignature = unspecializedType.getOwnedSignature();
			if (templateSignature != null) {
				List<@NonNull TemplateParameter> templateParameters = ClassUtil.nullFree(templateSignature.getOwnedParameters());
				List<@NonNull Type> templateArguments = new ArrayList<@NonNull Type>(templateParameters.size());
				for (@NonNull TemplateParameter templateParameter : templateParameters) {
					Type templateArgument = substitutions.get(templateParameter);
					templateArguments.add(templateArgument != null ? templateArgument : templateParameter);
				}
				PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
				return metamodelManager.getLibraryType(unspecializedType, templateArguments);
			}
		}
		return type;
	}

	@Override
	public @NonNull StandardLibraryInternal getOwnedStandardLibrary() {
		return ClassUtil.nonNullState(ownedStandardLibrary);
	}

	@Override
	public @NonNull TupleTypeManager getTupleManager() {
		TupleTypeManager tupleManager2 = tupleManager;
		if (tupleManager2 == null) {
			tupleManager = tupleManager2 = new TupleTypeManager(this);
		}
		return tupleManager2;
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<@NonNull ? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		return getTupleManager().getTupleType(typeName, parts, bindings);
	}

	@Override
	public @NonNull CompleteEnvironmentInternal init(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
		CompleteModelInternal completeModelInternal = ((CompleteModelInternal)PivotFactory.eINSTANCE.createCompleteModel()).init(this);
		setOwnedCompleteModel(completeModelInternal);
		setOwnedStandardLibrary(((StandardLibraryInternal)PivotFactory.eINSTANCE.createStandardLibrary()).init(completeModelInternal));
		return this;
	}

	@Override
	public boolean isCodeGeneration() {
		return isCodeGeneration ;
	}

	/**
	 * Return true if elementTypes are the TemplateParameters of one of the unspecialized type of one of the
	 * partial types of completeClass.
	 */
	private boolean isUnspecializedType(@NonNull CompleteClassInternal completeClass, @NonNull Type @NonNull ... elementTypes) {
		Iterable<org.eclipse.ocl.pivot.@NonNull Class> partialClasses = PivotUtil.getPartialClasses(completeClass);
		for (int i = 0; i < elementTypes.length; i++) {
			@NonNull Type elementType = elementTypes[i];
			boolean isUnspecializedElement = false;
			for (org.eclipse.ocl.pivot.@NonNull Class partialClass : partialClasses) {
				TemplateSignature templateSignature = partialClass.getOwnedSignature();
				if (templateSignature == null) {
					throw new IllegalArgumentException(completeClass.getName() + " type must have a template signature");
				}
				List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
				if (templateParameters.size() != elementTypes.length) {
					throw new IllegalArgumentException(completeClass.getName() + " type must have exactly " + elementTypes.length + " template parameter");
				}
				if (elementType == templateParameters.get(i)) {
					isUnspecializedElement = true;
					break;
				}
			}
			if (!isUnspecializedElement) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setCodeGeneration(boolean isCodeGeneration) {
		this.isCodeGeneration = isCodeGeneration;
	}
} //CompleteEnvironmentImpl
