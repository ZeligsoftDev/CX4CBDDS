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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OrphanCompletePackage;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteURIs;
import org.eclipse.ocl.pivot.internal.complete.PartialModels;
import org.eclipse.ocl.pivot.internal.complete.PartialPackages;
import org.eclipse.ocl.pivot.internal.complete.RootCompletePackages;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TupleTypeManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.MapTypeParameters;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Model</b></em>'.
 * @extends org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteModelImpl#getOrphanCompletePackage <em>Orphan Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteModelImpl#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteModelImpl#getOwningCompleteEnvironment <em>Owning Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteModelImpl#getPartialModels <em>Partial Models</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompleteModelImpl#getPrimitiveCompletePackage <em>Primitive Complete Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompleteModelImpl extends NamedElementImpl implements CompleteModel, org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal
{
	/**
	 * The number of structural features of the '<em>Complete Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_MODEL_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Complete Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_MODEL_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The cached value of the '{@link #getOrphanCompletePackage() <em>Orphan Complete Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrphanCompletePackage()
	 * @generated
	 * @ordered
	 */
	protected OrphanCompletePackage orphanCompletePackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.COMPLETE_MODEL;
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
			case 6:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompletePackages()).basicAdd(otherEnd, msgs);
			case 7:
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
			case 6:
				return ((InternalEList<?>)getOwnedCompletePackages()).basicRemove(otherEnd, msgs);
			case 7:
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
			case 7:
				return eInternalContainer().eInverseRemove(this, 4, CompleteEnvironment.class, msgs);
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
				return getName();
			case 5:
				return getOrphanCompletePackage();
			case 6:
				return getOwnedCompletePackages();
			case 7:
				return getOwningCompleteEnvironment();
			case 8:
				return getPartialModels();
			case 9:
				return getPrimitiveCompletePackage();
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
			case 6:
				getOwnedCompletePackages().clear();
				getOwnedCompletePackages().addAll((Collection<? extends CompletePackage>)newValue);
				return;
			case 7:
				setOwningCompleteEnvironment((CompleteEnvironment)newValue);
				return;
			case 8:
				getPartialModels().clear();
				getPartialModels().addAll((Collection<? extends Model>)newValue);
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
			case 6:
				getOwnedCompletePackages().clear();
				return;
			case 7:
				setOwningCompleteEnvironment((CompleteEnvironment)null);
				return;
			case 8:
				getPartialModels().clear();
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
				return orphanCompletePackage != null;
			case 6:
				return ownedCompletePackages != null && !ownedCompletePackages.isEmpty();
			case 7:
				return getOwningCompleteEnvironment() != null;
			case 8:
				return partialModels != null && !partialModels.isEmpty();
			case 9:
				return primitiveCompletePackage != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case 0:
				return allOwnedElements();
			case 1:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case 2:
				return getOwnedCompletePackage((String)arguments.get(0));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * The cached value of the '{@link #getOwnedCompletePackages() <em>Owned Complete Packages</em>}' containment reference list.
	 */
	protected /*final @NonNull*/ RootCompletePackages ownedCompletePackages;

	/**
	 * The cached value of the '{@link #getPartialModels() <em>Partial Roots</em>}' reference list.
	 */
	protected /*final @NonNull*/ PartialModels partialModels;

	/**
	 * The cached value of the '{@link #getPrimitiveCompletePackage() <em>Primitive Complete Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveCompletePackage()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveCompletePackage primitiveCompletePackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteModelImpl()
	{
		super();
	}

	/**
	 * Map from each partial Class to the CompleteClass that supervises its merge. CompleteClass are created lazily.
	 */
	private /*final @NonNull*/ CompleteEnvironmentInternal completeEnvironment;

	/**
	 * Map from complete to/from package URI.
	 */
	private final @NonNull CompleteURIs completeURIs = new CompleteURIs(this);

	protected /*final @NonNull*/ EnvironmentFactoryInternal environmentFactory;

	private Orphanage orphanage = null;

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompleteModel(this);
	}

	/**
	 * Partial models such as the OCL Standard Library have their own distinct package URI. These partial
	 * models are merged by mapping the package URI to a complete URI. DomainConstants.METAMODEL_NAME is the
	 * complete URI for all contributions merged as the overall OCL metamodel.
	 */
	@Override
	public void addPackageURI2completeURI(@NonNull String packageURI, @NonNull String newCompleteURI) {
		completeURIs.addPackageURI2completeURI(packageURI, newCompleteURI);
	}

	@Override
	public boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		return completeEnvironment.conformsTo(firstType, firstSubstitutions, secondType, secondSubstitutions);
	}

	@Override
	public void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass, @NonNull CompleteClassInternal completeClass) {
		completeEnvironment.didAddClass(partialClass, completeClass);
	}

	@Override
	public void didAddCompletePackage(@NonNull CompletePackageInternal completePackage) {
		completeURIs.didAddCompletePackage(completePackage);
	}

	@Override
	public void didAddNestedPackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		ownedCompletePackages.didAddPackage(pivotPackage);
	}

	@Override
	public void didAddPartialModel(@NonNull Model partialModel) {
		completeURIs.didAddPartialModel(partialModel);
	}

	@Override
	public void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		completeEnvironment.didRemoveClass(pivotType);
	}

	@Override
	public void didRemoveCompletePackage(@NonNull CompletePackageInternal completePackage) {
		if (completePackage == primitiveCompletePackage) {
			primitiveCompletePackage = null;
		}
		completeURIs.didRemoveCompletePackage(completePackage);
	}

	@Override
	public void didRemoveNestedPackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		ownedCompletePackages.didRemovePackage(pivotPackage);
	}

	@Override
	public void didRemovePartialModel(@NonNull Model partialModel) {
		completeURIs.didRemovePartialModel(partialModel);
	}

	@Override
	public synchronized void dispose() {
		completeEnvironment.dispose();
		ownedCompletePackages.dispose();
		completeURIs.dispose();
		Orphanage orphanage2 = orphanage;
		if (orphanage2 != null) {
			orphanage2.removePackageListener(getOrphanCompletePackage().getPartialPackages());
			orphanage = null;
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
	public @NonNull Iterable<@NonNull CompletePackageInternal> getAllCompletePackages() {
		return completeURIs.getAllCompletePackages();
	}

	@Override
	public @NonNull Iterable<@NonNull ? extends CompletePackage> getAllCompletePackagesWithUris() {
		return completeURIs.getAllCompletePackagesWithUris();
	}

	@Override
	public @NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<@NonNull Type> typeParameters) {
		return completeClass.getCollectionType(typeParameters);
	}

	public @NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		CollectionTypeParameters<@NonNull Type> typeParameters = TypeUtil.createCollectionTypeParameters(elementType, isNullFree, lower, upper);
		return completeClass.getCollectionType(typeParameters);
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType) {
		return completeEnvironment.getCompleteClass(pivotType);
	}

	@Override
	public @NonNull CompleteEnvironmentInternal getCompleteEnvironment() {
		assert completeEnvironment != null;
		return completeEnvironment;
	}

	@Override
	public @NonNull CompletePackageInternal getCompletePackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		return ownedCompletePackages.getCompletePackage(asPackage);
	}

	@Override
	public @Nullable CompletePackageInternal getCompletePackageByURI(@NonNull String packageURI) {
		return completeURIs.getCompletePackageByURI(packageURI);
	}

	@Override
	public @Nullable String getCompleteURI(@Nullable String packageURI) {
		return completeURIs.getCompleteURI(packageURI);
	}

	@Override
	public @NonNull CompleteURIs getCompleteURIs() {
		return completeURIs;
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<@NonNull ? extends Type> parameterTypes, @NonNull Type resultType) {
		return completeEnvironment.getLambdaType(typeName, contextType, parameterTypes, resultType, null);
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<@NonNull ? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		return completeEnvironment.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}

	@Override
	public @NonNull MapType getMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters) {
		return completeClass.getMapType(typeParameters);
	}

	public @Nullable CompletePackage getMemberPackage(@NonNull String memberPackageName) {
		return ownedCompletePackages.getOwnedCompletePackage(memberPackageName);
	}

	public @NonNull Iterable<? extends CompletePackage> getMemberPackages() {
		assert ownedCompletePackages != null;
		return ownedCompletePackages;
	}

	@Override
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull OrphanCompletePackageImpl getOrphanCompletePackage()
	{
		OrphanCompletePackage orphanCompletePackage2 = orphanCompletePackage;
		if (orphanCompletePackage2 == null) {
			orphanCompletePackage2 = orphanCompletePackage = PivotFactory.eINSTANCE.createOrphanCompletePackage();
			ownedCompletePackages.add(orphanCompletePackage2);
		}
		return (OrphanCompletePackageImpl)orphanCompletePackage2;
	}

	@Override
	public @NonNull Orphanage getOrphanage() {
		Orphanage orphanage2 = orphanage;
		if (orphanage2 == null) {
			orphanage2 = orphanage = environmentFactory.getMetamodelManager().createOrphanage();
			PartialPackages partialPackages = getOrphanCompletePackage().getPartialPackages();
			orphanage2.addPackageListener(partialPackages);
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : PivotUtil.getOwnedPackages(orphanage2)) {
				didAddNestedPackage(asPackage);
			}
		}
		return orphanage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull List<CompletePackage> getOwnedCompletePackages() {
		assert ownedCompletePackages != null;
		return ownedCompletePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompleteEnvironment getOwningCompleteEnvironment()
	{
		if (eContainerFeatureID() != (7)) return null;
		return (CompleteEnvironment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompleteEnvironment(CompleteEnvironment newOwningCompleteEnvironment, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningCompleteEnvironment, 7, msgs);
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
		if (newOwningCompleteEnvironment != eInternalContainer() || (eContainerFeatureID() != (7) && newOwningCompleteEnvironment != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningCompleteEnvironment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompleteEnvironment != null)
				msgs = ((InternalEObject)newOwningCompleteEnvironment).eInverseAdd(this, 4, CompleteEnvironment.class, msgs);
			msgs = basicSetOwningCompleteEnvironment(newOwningCompleteEnvironment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 7, newOwningCompleteEnvironment, newOwningCompleteEnvironment));
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return ClassUtil.nonNullState(environmentFactory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Reference types used by the auto-generated overridden body. - Bug 543180
	 * {@link EObjectResolvingEList}, {@link EObjectContainmentWithInverseEList}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull PartialModels getPartialModels() {
		assert partialModels != null;
		return partialModels;
	}

	@Override
	public @NonNull PrimitiveCompletePackageImpl getPrimitiveCompletePackage()
	{
		PrimitiveCompletePackage primitiveCompletePackage2 = primitiveCompletePackage;
		if (primitiveCompletePackage2 == null) {
			primitiveCompletePackage2 = primitiveCompletePackage = PivotFactory.eINSTANCE.createPrimitiveCompletePackage();
			ownedCompletePackages.add(primitiveCompletePackage2);
		}
		return (PrimitiveCompletePackageImpl) primitiveCompletePackage2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @Nullable CompletePackage getOwnedCompletePackage(@Nullable String completeURIorName) {
		CompletePackage completePackage = completeURIs.getCompletePackage(completeURIorName);
		if (completePackage != null) {
			return completePackage;
		}
		return ownedCompletePackages.getOwnedCompletePackage(completeURIorName);
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Package getRootPackage(@NonNull String completeURIorName) {
		CompletePackage completePackage = completeURIs.getCompletePackage(completeURIorName);
		if (completePackage != null) {
			return completePackage.getPrimaryPackage();
		}
		completePackage = getOwnedCompletePackage(completeURIorName);
		return completePackage != null ? completePackage.getPrimaryPackage() : null;
	}

	@Override
	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		return completeEnvironment.getSpecializedType(type, substitutions);
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return completeEnvironment.getOwnedStandardLibrary();
	}

	@Override
	public @NonNull TupleTypeManager getTupleManager() {
		return completeEnvironment.getTupleManager();
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<@NonNull ? extends TypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		return completeEnvironment.getTupleType(typeName, parts, bindings);
	}

	@Override
	public @NonNull CompleteModelInternal init(@NonNull CompleteEnvironmentInternal completeEnvironment) {
		this.completeEnvironment = completeEnvironment;
		this.environmentFactory = completeEnvironment.getEnvironmentFactory();
		partialModels = new PartialModels(this);
		ownedCompletePackages = new RootCompletePackages(this);
		return this;
	}

	/*	public void removedType(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		CompleteClass completeClass = class2completeClass.get(pivotType);
		if (completeClass != null) {
//			completeClass.dispose();
		}
	} */

	@Override
	public void resolveSuperClasses(org.eclipse.ocl.pivot.@NonNull Class specializedClass, org.eclipse.ocl.pivot.@NonNull Class unspecializedClass) {
		List<TemplateBinding> specializedTemplateBindings = specializedClass.getOwnedBindings();
		for (org.eclipse.ocl.pivot.Class superClass : unspecializedClass.getSuperClasses()) {
			List<TemplateBinding> superTemplateBindings = superClass.getOwnedBindings();
			if (superTemplateBindings.size() > 0) {
				List<TemplateParameterSubstitution> superSpecializedTemplateParameterSubstitutions = new ArrayList<TemplateParameterSubstitution>();
				for (TemplateBinding superTemplateBinding : superTemplateBindings) {
					for (TemplateParameterSubstitution superParameterSubstitution : superTemplateBinding.getOwnedSubstitutions()) {
						TemplateParameterSubstitution superSpecializedTemplateParameterSubstitution = null;
						Type superActual = superParameterSubstitution.getActual();
						for (TemplateBinding specializedTemplateBinding : specializedTemplateBindings) {
							for (TemplateParameterSubstitution specializedParameterSubstitution : specializedTemplateBinding.getOwnedSubstitutions()) {
								if (specializedParameterSubstitution.getFormal() == superActual) {
									Type specializedActual = ClassUtil.nonNullModel(specializedParameterSubstitution.getActual());
									TemplateParameter superFormal = ClassUtil.nonNullModel(superParameterSubstitution.getFormal());
									superSpecializedTemplateParameterSubstitution = PivotUtil.createTemplateParameterSubstitution(superFormal, specializedActual);
									break;
								}
							}
							if (superSpecializedTemplateParameterSubstitution != null) {
								break;
							}
						}
						if (superSpecializedTemplateParameterSubstitution != null) {
							superSpecializedTemplateParameterSubstitutions.add(superSpecializedTemplateParameterSubstitution);
						}
					}
				}
				org.eclipse.ocl.pivot.@NonNull Class unspecializedSuperClass = PivotUtil.getUnspecializedTemplateableElement(superClass);
				CompleteClassInternal superCompleteClass = environmentFactory.getMetamodelManager().getCompleteClass(unspecializedSuperClass);
				org.eclipse.ocl.pivot.Class superPivotClass = superCompleteClass.getPrimaryClass();
				if (superPivotClass instanceof CollectionType) {
					if (superSpecializedTemplateParameterSubstitutions.size() == 1) {
						Type templateArgument = superSpecializedTemplateParameterSubstitutions.get(0).getActual();
						if (templateArgument != null) {
							org.eclipse.ocl.pivot.Class specializedSuperClass = completeEnvironment.getCollectionType(superCompleteClass, TypeUtil.createCollectionTypeParameters(templateArgument, false, null, null));
							specializedClass.getSuperClasses().add(specializedSuperClass);
						}
					}
				}
				else {
					List<@NonNull Type> superTemplateArgumentList = new ArrayList<@NonNull Type>(superSpecializedTemplateParameterSubstitutions.size());
					for (TemplateParameterSubstitution superSpecializedTemplateParameterSubstitution : superSpecializedTemplateParameterSubstitutions) {
						Type actual = superSpecializedTemplateParameterSubstitution.getActual();
						if (actual != null) {
							superTemplateArgumentList.add(actual);
						}
					}
					CompleteInheritanceImpl superCompleteInheritance = superCompleteClass.getCompleteInheritance();
					org.eclipse.ocl.pivot.Class specializedSuperType = superCompleteInheritance.getCompleteClass().getPartialClasses().getSpecializedType(superTemplateArgumentList);
					specializedClass.getSuperClasses().add(specializedSuperType);
				}
			}
			else {
				specializedClass.getSuperClasses().add(superClass);
			}
		}
	}
} //CompleteModelImpl
