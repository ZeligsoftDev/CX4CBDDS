/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.IllegalLibraryException;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.library.oclany.OclAnyUnsupportedOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.osgi.util.NLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Library</b></em>'.
 * @extends org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.StandardLibraryImpl#getOwningCompleteEnvironment <em>Owning Complete Environment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StandardLibraryImpl extends ElementImpl implements StandardLibrary, org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal
{
	/**
	 * The number of structural features of the '<em>Standard Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STANDARD_LIBRARY_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Standard Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STANDARD_LIBRARY_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardLibraryImpl()
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
		return PivotPackage.Literals.STANDARD_LIBRARY;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompleteEnvironment getOwningCompleteEnvironment()
	{
		if (eContainerFeatureID() != (4)) return null;
		return (CompleteEnvironment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompleteEnvironment(CompleteEnvironment newOwningCompleteEnvironment, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningCompleteEnvironment, 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompleteEnvironment(CompleteEnvironment newOwningCompleteEnvironment)
	{
		if (newOwningCompleteEnvironment != eInternalContainer() || (eContainerFeatureID() != (4) && newOwningCompleteEnvironment != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningCompleteEnvironment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompleteEnvironment != null)
				msgs = ((InternalEObject)newOwningCompleteEnvironment).eInverseAdd(this, 5, CompleteEnvironment.class, msgs);
			msgs = basicSetOwningCompleteEnvironment(newOwningCompleteEnvironment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, newOwningCompleteEnvironment, newOwningCompleteEnvironment));
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompleteEnvironment((CompleteEnvironment)otherEnd, msgs);
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
				return basicSetOwningCompleteEnvironment(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case 4:
				return eInternalContainer().eInverseRemove(this, 5, CompleteEnvironment.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
				return getOwningCompleteEnvironment();
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
				setOwningCompleteEnvironment((CompleteEnvironment)newValue);
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
				setOwningCompleteEnvironment((CompleteEnvironment)null);
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
				return getOwningCompleteEnvironment() != null;
		}
		return eDynamicIsSet(featureID);
	}
	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitStandardLibrary(this);
	}
	private static final Logger logger = LogManager.getLogger(StandardLibraryInternal.class);

	/**
	 * The URI used by default for the OCL Standard Library. NB. This
	 * constant is repeated in GenerateOCLstdlibModel.mwe2 and in
	 * org.eclipse.ocl.pivot/plugin.xml.
	 */
	public static final @NonNull String DEFAULT_OCL_STDLIB_URI = LibraryConstants.STDLIB_URI;

	/**
	 * The URI to provide the default Standard Library. This value may be
	 * reassigned pior to any OCL analysis or evaluation to select a different
	 * default. Alternatively the need for default may be bypassed by explicitly
	 * invoking loadLibrary().
	 */
	protected @NonNull String defaultStandardLibraryURI = DEFAULT_OCL_STDLIB_URI;

	protected boolean explicitDefaultStandardLibraryURI = false;

	private @Nullable BagType bagType = null;
	private @Nullable PrimitiveType booleanType = null;
	private org.eclipse.ocl.pivot.@Nullable Class classType = null;
	private @Nullable CollectionType collectionType = null;
	private org.eclipse.ocl.pivot.@Nullable Class enumerationType = null;
	private @Nullable PrimitiveType integerType = null;
	private org.eclipse.ocl.pivot.@Nullable Package libraryPackage = null;
	private @Nullable MapType mapType = null;
	private @Nullable AnyType oclAnyType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclComparableType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclElementType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclEnumerationType = null;
	private @Nullable Operation oclInvalidOperation = null;
	private @Nullable Property oclInvalidProperty = null;
	private @Nullable InvalidType oclInvalidType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclLambdaType = null;
	private @Nullable SelfType oclSelfType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclStereotypeType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclSummableType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclTupleType = null;
	private org.eclipse.ocl.pivot.@Nullable Class oclTypeType = null;
	private @Nullable VoidType oclVoidType = null;
	private @Nullable CollectionType orderedCollectionType = null;
	private @Nullable OrderedSetType orderedSetType = null;
	private @Nullable PrimitiveType realType = null;
	private @Nullable SequenceType sequenceType = null;
	private @Nullable SetType setType = null;
	private @Nullable PrimitiveType stringType = null;
	private @Nullable CollectionType uniqueCollectionType = null;
	private @Nullable PrimitiveType unlimitedNaturalType = null;

	private @Nullable Map<String, org.eclipse.ocl.pivot.Class> nameToLibraryTypeMap = null;

	protected /*final*/ /*@NonNull*/ CompleteModelInternal completeModel;
	protected /*final*/ /*@NonNull*/ EnvironmentFactoryInternal environmentFactory;

	@Override
	public @Nullable AnyType basicGetOclAnyType() {
		return oclAnyType;
	}

	@Override
	public @Nullable Operation basicGetOclInvalidOperation() {
		return oclInvalidOperation;
	}

	@Override
	public @Nullable Property basicGetOclInvalidProperty() {
		return oclInvalidProperty;
	}

	@Override
	public @Nullable InvalidType basicGetOclInvalidType() {
		return oclInvalidType;
	}

	@Deprecated
	@Override
	public void defineLibraryType(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		Map<String, org.eclipse.ocl.pivot.Class> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
		if (nameToLibraryTypeMap2 == null) {
			nameToLibraryTypeMap = nameToLibraryTypeMap2 = new HashMap<>();
		}
		String name = pivotType.getName();
		org.eclipse.ocl.pivot.Class oldType = nameToLibraryTypeMap2.put(name, pivotType);
		if ((oldType != null) && (oldType != pivotType)) {
			logger.warn("Conflicting pivot type '" + name + "'");
		}
	}

	@Override
	public void defineLibraryTypes(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> pivotTypes) {
		Map<String, org.eclipse.ocl.pivot.Class> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
		if (nameToLibraryTypeMap2 == null) {
			nameToLibraryTypeMap = nameToLibraryTypeMap2 = new HashMap<>();
		}
		for (org.eclipse.ocl.pivot.@NonNull Class pivotType : pivotTypes) {
			String name = pivotType.getName();
			org.eclipse.ocl.pivot.Class oldType = nameToLibraryTypeMap2.put(name, pivotType);
			if ((oldType != null) && (oldType != pivotType)) {
				if (!(oldType instanceof PrimitiveType) || !(pivotType instanceof PrimitiveType)) {		// User primitives may only be DataType e.g. testQVTrLoad_ATL2QVTr_qvtre
					logger.warn("Conflicting pivot type '" + name + "'");
				}
			}
		}
	}

	@Override
	public void dispose() {
		resetLibrary();
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getASClass(@NonNull String className) {
		return environmentFactory.getMetamodelManager().getASClass(className);
	}

	@Override
	public @NonNull Iterable<@NonNull ? extends CompletePackage> getAllCompletePackages() {
		return environmentFactory.getMetamodelManager().getAllCompletePackages();
	}

	@Override
	public @NonNull BagType getBagType() {
		BagType bagType2 = bagType;
		if (bagType2 == null) {
			bagType2 = bagType = resolveRequiredTemplateableType(BagType.class, TypeId.BAG_NAME, 1);
		}
		return bagType2;
	}

	@Override
	public @Nullable PrimitiveType getBehavioralClass(@NonNull Class<?> instanceClass) {
		return (PrimitiveType)PivotUtil.getBehavioralClass(this, instanceClass);
	}

	@Override
	public @NonNull PrimitiveType getBooleanType() {
		PrimitiveType booleanType2 = booleanType;
		if (booleanType2 == null) {
			booleanType2 = booleanType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.BOOLEAN_NAME);
		}
		return booleanType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getClassType() {
		org.eclipse.ocl.pivot.Class classType2 = classType;
		if (classType2 == null) {
			classType2 = classType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.CLASS_NAME);
		}
		return classType2;
	}

	@Override
	public @NonNull CollectionType getCollectionType() {
		CollectionType collectionType2 = collectionType;
		if (collectionType2 == null) {
			collectionType2 = collectionType = resolveRequiredTemplateableType(CollectionType.class, TypeId.COLLECTION_NAME, 1);
		}
		return collectionType2;
	}

	@Override
	public @NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class containerType,
			@NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return environmentFactory.getCompleteEnvironment().getCollectionType(containerType, elementType, isNullFree, lower, upper);
	}

	@Override
	public @NonNull CollectionType getCollectionType(org.eclipse.ocl.pivot.@NonNull Class containerType,
			@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		return environmentFactory.getCompleteEnvironment().getCollectionType(containerType, elementType, false, lower, upper);
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return ClassUtil.nonNullState(completeModel);
	}

	@Override
	public @NonNull String getDefaultStandardLibraryURI() {
		return defaultStandardLibraryURI;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getEnumerationType() {
		org.eclipse.ocl.pivot.Class enumerationType2 = enumerationType;
		if (enumerationType2 == null) {
			enumerationType2 = enumerationType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.ENUMERATION_NAME);
		}
		return enumerationType2;
	}

	@Override
	@NonNull
	public CompleteInheritance getInheritance(org.eclipse.ocl.pivot.@NonNull Class type) {
		return environmentFactory.getMetamodelManager().getInheritance(type);
	}

	@Override
	public @NonNull PrimitiveType getIntegerType() {
		PrimitiveType integerType2 = integerType;
		if (integerType2 == null) {
			integerType2 = integerType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.INTEGER_NAME);
		}
		return integerType2;
	}

	@Override
	public org.eclipse.ocl.pivot.Class getLibraryType(@NonNull String typeName) {
		Map<String, org.eclipse.ocl.pivot.Class> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
		if (nameToLibraryTypeMap2 == null) {
			nameToLibraryTypeMap = nameToLibraryTypeMap2 = new HashMap<>();
			loadDefaultLibrary(defaultStandardLibraryURI);
		}
		return nameToLibraryTypeMap2.get(typeName);
	}

	@Override
	public @NonNull MapType getMapType() {
		MapType mapType2 = mapType;
		if (mapType2 == null) {
			mapType2 = mapType = resolveRequiredTemplateableType(MapType.class, TypeId.MAP_NAME, 2);
		}
		return mapType2;
	}

	@Override
	public @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class containerType,
			@NonNull Type keyType, @NonNull Type valueType) {
		return getMapType(containerType, keyType, true, valueType, true);
	}

	//	@Override
	/**
	 * @since 1.6
	 */
	public @NonNull MapType getMapType(org.eclipse.ocl.pivot.@NonNull Class containerType,
			@NonNull Type keyType, boolean keysAreNullFree, @NonNull Type valueType, boolean valuesAreNullFree) {
		return environmentFactory.getCompleteEnvironment().getMapType(containerType, keyType, keysAreNullFree, valueType, valuesAreNullFree);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMetaclass(@NonNull Type classType) {
		return environmentFactory.getMetamodelManager().getMetaclass(classType);
	}

	@Override
	public @NonNull Type getMetaType(@NonNull Type instanceType) {
	//	if (instanceType instanceof PrimitiveType) {
	//		return getASClass(TypeId.PRIMITIVE_TYPE_NAME);
	//	}
		//		throw new UnsupportedOperationException();
		return getMetaclass(instanceType);
	}

	@Override
	public org.eclipse.ocl.pivot.Package getNsURIPackage(@NonNull String nsURI) {
		CompletePackage completePackage = completeModel.getCompletePackageByURI(nsURI);
		return completePackage != null ? completePackage.getPrimaryPackage() : null;
	}

	@Override
	public @NonNull AnyType getOclAnyType() {
		AnyType oclAnyType2 = oclAnyType;
		if (oclAnyType2 == null) {
			oclAnyType2 = oclAnyType = resolveRequiredSimpleType(AnyType.class, TypeId.OCL_ANY_NAME);
		}
		return oclAnyType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclComparableType() {
		org.eclipse.ocl.pivot.Class oclComparableType2 = oclComparableType;
		if (oclComparableType2 == null) {
			oclComparableType2 = oclComparableType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_COMPARABLE_NAME);
		}
		return oclComparableType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclElementType() {
		org.eclipse.ocl.pivot.Class oclElementType2 = oclElementType;
		if (oclElementType2 == null) {
			oclElementType2 = oclElementType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_ELEMENT_NAME);
		}
		return oclElementType2;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclEnumerationType() {
		org.eclipse.ocl.pivot.Class oclEnumerationType2 = oclEnumerationType;
		if (oclEnumerationType2 == null) {
			oclEnumerationType2 = oclEnumerationType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_ENUMERATION_NAME);
		}
		return oclEnumerationType2;
	}

	@Override
	public @NonNull Operation getOclInvalidOperation() {
		Operation oclInvalidOperation2 = oclInvalidOperation;
		if (oclInvalidOperation2 == null) {
			AnyType anyType = getOclAnyType();
			InvalidType invalidType = getOclInvalidType();
			List<Operation> invalidOperations = invalidType.getOwnedOperations();
			String invalidName = "oclBadOperation";
			oclInvalidOperation2 = NameUtil.getNameable(invalidOperations, invalidName);
			if (oclInvalidOperation2 == null) {
				oclInvalidOperation2 = PivotFactory.eINSTANCE.createOperation();
				oclInvalidOperation2.setName(invalidName);
				oclInvalidOperation2.setType(anyType);
				oclInvalidOperation2.setImplementation(OclAnyUnsupportedOperation.INSTANCE);
				invalidOperations.add(oclInvalidOperation2);
			}
			oclInvalidOperation = oclInvalidOperation2;
		}
		return oclInvalidOperation2;
	}

	@Override
	public @NonNull Property getOclInvalidProperty() {
		Property oclInvalidProperty2 = oclInvalidProperty;
		if (oclInvalidProperty2 == null) {
			AnyType anyType = getOclAnyType();
			InvalidType invalidType = getOclInvalidType();
			List<Property> invalidProperties = invalidType.getOwnedProperties();
			String invalidName = "oclBadProperty";
			oclInvalidProperty2 = NameUtil.getNameable(invalidProperties, invalidName);
			if (oclInvalidProperty2 == null) {
				oclInvalidProperty2 = PivotFactory.eINSTANCE.createProperty();
				oclInvalidProperty2.setName(invalidName);
				oclInvalidProperty2.setType(anyType);
				oclInvalidProperty2.setImplementation(OclAnyUnsupportedOperation.INSTANCE);
				invalidProperties.add(oclInvalidProperty2);
			}
			oclInvalidProperty = oclInvalidProperty2;
		}
		return oclInvalidProperty2;
	}

	@Override
	public @NonNull InvalidType getOclInvalidType() {
		InvalidType oclInvalidType2 = oclInvalidType;
		if (oclInvalidType2 == null) {
			oclInvalidType2 = oclInvalidType = resolveRequiredSimpleType(InvalidType.class, TypeId.OCL_INVALID_NAME);
		}
		return oclInvalidType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclLambdaType() {
		org.eclipse.ocl.pivot.Class oclLambdaType2 = oclLambdaType;
		if (oclLambdaType2 == null) {
			oclLambdaType2 = oclLambdaType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, "OclLambda");
		}
		return oclLambdaType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclMessageType() {
		return getRequiredLibraryType("OclMessage");
	}

	@Override
	public @NonNull SelfType getOclSelfType() {
		SelfType oclSelfType2 = oclSelfType;
		if (oclSelfType2 == null) {
			oclSelfType2 = oclSelfType = resolveRequiredSimpleType(SelfType.class, TypeId.OCL_SELF_NAME);
		}
		return oclSelfType2;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclStereotypeType() {
		org.eclipse.ocl.pivot.Class oclStereotypeType2 = oclStereotypeType;
		if (oclStereotypeType2 == null) {
			oclStereotypeType2 = oclStereotypeType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_STEREOTYPE_NAME);
		}
		return oclStereotypeType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclSummableType() {
		org.eclipse.ocl.pivot.Class oclSummableType2 = oclSummableType;
		if (oclSummableType2 == null) {
			oclSummableType2 = oclSummableType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_SUMMABLE_NAME);
		}
		return oclSummableType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclTupleType() {
		org.eclipse.ocl.pivot.Class oclTupleType2 = oclTupleType;
		if (oclTupleType2 == null) {
			oclTupleType2 = oclTupleType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_TUPLE_NAME);
		}
		return oclTupleType2;
	}

	@Override
	public Type getOclType(@NonNull String typeName) {
		return environmentFactory.getMetamodelManager().getOclType(typeName);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getOclTypeType() {
		org.eclipse.ocl.pivot.Class oclTypeType2 = oclTypeType;
		if (oclTypeType2 == null) {
			oclTypeType2 = oclTypeType = resolveRequiredSimpleType(org.eclipse.ocl.pivot.Class.class, TypeId.OCL_TYPE_NAME);
		}
		return oclTypeType2;
	}

	@Override
	public @NonNull VoidType getOclVoidType() {
		VoidType oclVoidType2 = oclVoidType;
		if (oclVoidType2 == null) {
			oclVoidType2 = oclVoidType = resolveRequiredSimpleType(VoidType.class, TypeId.OCL_VOID_NAME);
		}
		return oclVoidType2;
	}

	@Override
	public @Nullable Element getOperationTemplateParameter(@NonNull Operation anOperation, int index) {
		anOperation = PivotUtil.getUnspecializedTemplateableElement(anOperation);
		return anOperation.getTypeParameters().get(index);
	}

	@Override
	public @NonNull CollectionType getOrderedCollectionType() {
		CollectionType orderedCollectionType2 = orderedCollectionType;
		if (orderedCollectionType2 == null) {
			orderedCollectionType2 = orderedCollectionType = resolveRequiredTemplateableType(CollectionType.class, TypeId.ORDERED_COLLECTION_NAME, 1);
		}
		return orderedCollectionType2;
	}

	@Override
	public @NonNull OrderedSetType getOrderedSetType() {
		OrderedSetType orderedSetType2 = orderedSetType;
		if (orderedSetType2 == null) {
			orderedSetType2 = orderedSetType = resolveRequiredTemplateableType(OrderedSetType.class, TypeId.ORDERED_SET_NAME, 1);
		}
		return orderedSetType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Package getPackage() {
		org.eclipse.ocl.pivot.Package libraryPackage2 = libraryPackage;
		if (libraryPackage2 == null) {
			libraryPackage2 = libraryPackage = getOclAnyType().getOwningPackage();
			assert libraryPackage2 != null;
		}
		return libraryPackage2;
	}

	@Override
	public @Nullable Type getPrimitiveType(@NonNull PrimitiveTypeId typeId) {
		return TypeUtil.getPrimitiveType(this, typeId);
	}

	@Override
	public @NonNull PrimitiveType getRealType() {
		PrimitiveType realType2 = realType;
		if (realType2 == null) {
			realType2 = realType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.REAL_NAME);
		}
		return realType2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getRequiredLibraryType(@NonNull String typeName) {
		org.eclipse.ocl.pivot.Class type = getLibraryType(typeName);
		if (type == null) {
			//			nameToLibraryTypeMap = null;
			type = getLibraryType(typeName);	// FIXME just a debug retry
			Map<String, org.eclipse.ocl.pivot.Class> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
			if ((nameToLibraryTypeMap2 == null) || nameToLibraryTypeMap2.isEmpty()) {
				throw new IllegalLibraryException(PivotMessagesInternal.EmptyLibrary_ERROR_);
			}
			else {
				throw new IllegalLibraryException(NLS.bind(PivotMessagesInternal.MissingLibraryType_ERROR_, typeName));
			}
		}
		return type;
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Package getRootPackage(@NonNull String completeURIorName) {
		Package rootPackage = completeModel.getRootPackage(completeURIorName);
		if (rootPackage == null) {
			if (PivotConstants.METAMODEL_NAME.equals(completeURIorName)) {
				environmentFactory.getMetamodelManager().getASmetamodel();
				rootPackage = completeModel.getRootPackage(completeURIorName);
			}
		}
		return rootPackage;
	}

	@Override
	public @NonNull SequenceType getSequenceType() {
		SequenceType sequenceType2 = sequenceType;
		if (sequenceType2 == null) {
			sequenceType2 = sequenceType = resolveRequiredTemplateableType(SequenceType.class, TypeId.SEQUENCE_NAME, 1);
		}
		return sequenceType2;
	}

	@Override
	public @NonNull SetType getSetType() {
		SetType setType2 = setType;
		if (setType2 == null) {
			setType2 = setType = resolveRequiredTemplateableType(SetType.class, TypeId.SET_NAME, 1);
		}
		return setType2;
	}

	@Override
	public @NonNull PrimitiveType getStringType() {
		PrimitiveType stringType2 = stringType;
		if (stringType2 == null) {
			stringType2 = stringType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.STRING_NAME);
		}
		return stringType2;
	}

	@Override
	public @NonNull CollectionType getUniqueCollectionType() {
		CollectionType uniqueCollectionType2 = uniqueCollectionType;
		if (uniqueCollectionType2 == null) {
			uniqueCollectionType2 = uniqueCollectionType = resolveRequiredTemplateableType(CollectionType.class, TypeId.UNIQUE_COLLECTION_NAME, 1);
		}
		return uniqueCollectionType2;
	}

	@Override
	public @NonNull PrimitiveType getUnlimitedNaturalType() {
		PrimitiveType unlimitedNaturalType2 = unlimitedNaturalType;
		if (unlimitedNaturalType2 == null) {
			unlimitedNaturalType2 = unlimitedNaturalType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.UNLIMITED_NATURAL_NAME);
		}
		return unlimitedNaturalType2;
	}

	@Override
	public @NonNull StandardLibraryInternal  init(@NonNull CompleteModelInternal completeModel) {
		this.completeModel = completeModel;
		this.environmentFactory = completeModel.getEnvironmentFactory();
		return this;
	}

	@Override
	public boolean isExplicitDefaultStandardLibraryURI() {
		return explicitDefaultStandardLibraryURI;
	}

	public boolean isOrdered(Type sourceType) {
		if (sourceType instanceof OrderedSetType) {
			return true;
		}
		if (sourceType instanceof SequenceType) {
			return true;
		}
		return false;
	}

	public boolean isUnique(Type sourceType) {
		if (sourceType instanceof OrderedSetType) {
			return true;
		}
		if (sourceType instanceof SetType) {
			return true;
		}
		return false;
	}

	@Override
	public @Nullable Resource loadDefaultLibrary(@Nullable String uri) {
		return environmentFactory.getMetamodelManager().loadDefaultLibrary(uri);
	}

	public void resetLibrary() {
		bagType = null;
		booleanType = null;
		classType = null;
		collectionType = null;
		enumerationType = null;
		integerType = null;
		libraryPackage = null;
		mapType = null;
		oclAnyType = null;
		oclComparableType = null;
		oclElementType = null;
		oclEnumerationType = null;
		oclInvalidOperation = null;
		oclInvalidProperty = null;
		oclInvalidType = null;
		oclLambdaType = null;
		oclSelfType = null;
		oclSummableType = null;
		oclTupleType = null;
		oclTypeType = null;
		oclVoidType = null;
		orderedCollectionType = null;
		orderedSetType = null;
		realType = null;
		sequenceType = null;
		setType = null;
		stringType = null;
		uniqueCollectionType = null;
		unlimitedNaturalType = null;
		nameToLibraryTypeMap = null;
	}

	protected @NonNull <T extends TemplateableElement> T resolveRequiredSimpleType(@NonNull Class<T> requiredClassType, @NonNull String name) {
		org.eclipse.ocl.pivot.Class type = getRequiredLibraryType(name);
		if (requiredClassType.isAssignableFrom(type.getClass())) {
			@SuppressWarnings("unchecked")
			T type2 = (T) type;
			return type2;
		}
		else {
			throw new IllegalLibraryException(name + " is not a " + requiredClassType.getSimpleName());
		}
	}

	protected @NonNull <T extends TemplateableElement> T resolveRequiredTemplateableType(@NonNull Class<T> requiredClassType, @NonNull String name, int parameterCount) {
		org.eclipse.ocl.pivot.Class type = getRequiredLibraryType(name);
		if (requiredClassType.isAssignableFrom(type.getClass())) {
			if (type.getOwnedSignature() == null) {
				throw new IllegalLibraryException(name + " is not a templated type");
			}
			else if (type.getOwnedSignature().getOwnedParameters().size() != parameterCount) {
				throw new IllegalLibraryException(name + " is not a templated type with " + parameterCount + " argument" + (parameterCount != 1 ? "s" : ""));
			}
			@SuppressWarnings("unchecked")
			T type2 = (T) type;
			return type2;
		}
		else {
			throw new IllegalLibraryException(name + " is not a " + requiredClassType.getSimpleName());
		}
	}

	@Override
	public void setDefaultStandardLibraryURI(@NonNull String defaultStandardLibraryURI) {
		assert !PivotUtilInternal.isASURI(defaultStandardLibraryURI);
		this.defaultStandardLibraryURI = defaultStandardLibraryURI;
		this.explicitDefaultStandardLibraryURI = true;
	}

} //StandardLibraryImpl
