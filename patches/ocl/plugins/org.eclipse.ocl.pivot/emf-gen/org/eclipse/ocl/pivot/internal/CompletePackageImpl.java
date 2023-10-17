/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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
import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.complete.CompleteClassInternal;
import org.eclipse.ocl.pivot.internal.complete.CompleteClasses;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal;
import org.eclipse.ocl.pivot.internal.complete.NestedCompletePackages;
import org.eclipse.ocl.pivot.internal.complete.PartialPackages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Package</b></em>'.
 * @extends org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompletePackageImpl#getOwnedCompleteClasses <em>Owned Complete Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompletePackageImpl#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompletePackageImpl#getOwningCompleteModel <em>Owning Complete Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompletePackageImpl#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CompletePackageImpl#getPartialPackages <em>Partial Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("unused")
public class CompletePackageImpl extends NamedElementImpl implements CompletePackage, org.eclipse.ocl.pivot.internal.complete.CompletePackageInternal
{

	/**
	 * The number of structural features of the '<em>Complete Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_PACKAGE_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5;
	/**
	 * The number of operations of the '<em>Complete Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETE_PACKAGE_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.COMPLETE_PACKAGE;
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
			case 5:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompleteClasses()).basicAdd(otherEnd, msgs);
			case 6:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedCompletePackages()).basicAdd(otherEnd, msgs);
			case 7:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompleteModel((CompleteModel)otherEnd, msgs);
			case 8:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompletePackage((CompletePackage)otherEnd, msgs);
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
			case 5:
				return ((InternalEList<?>)getOwnedCompleteClasses()).basicRemove(otherEnd, msgs);
			case 6:
				return ((InternalEList<?>)getOwnedCompletePackages()).basicRemove(otherEnd, msgs);
			case 7:
				return basicSetOwningCompleteModel(null, msgs);
			case 8:
				return basicSetOwningCompletePackage(null, msgs);
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
				return eInternalContainer().eInverseRemove(this, 6, CompleteModel.class, msgs);
			case 8:
				return eInternalContainer().eInverseRemove(this, 6, CompletePackage.class, msgs);
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
				return getOwnedCompleteClasses();
			case 6:
				return getOwnedCompletePackages();
			case 7:
				return getOwningCompleteModel();
			case 8:
				return getOwningCompletePackage();
			case 9:
				return getPartialPackages();
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
				getOwnedCompleteClasses().clear();
				getOwnedCompleteClasses().addAll((Collection<? extends CompleteClass>)newValue);
				return;
			case 6:
				getOwnedCompletePackages().clear();
				getOwnedCompletePackages().addAll((Collection<? extends CompletePackage>)newValue);
				return;
			case 7:
				setOwningCompleteModel((CompleteModel)newValue);
				return;
			case 8:
				setOwningCompletePackage((CompletePackage)newValue);
				return;
			case 9:
				getPartialPackages().clear();
				getPartialPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
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
				getOwnedCompleteClasses().clear();
				return;
			case 6:
				getOwnedCompletePackages().clear();
				return;
			case 7:
				setOwningCompleteModel((CompleteModel)null);
				return;
			case 8:
				setOwningCompletePackage((CompletePackage)null);
				return;
			case 9:
				getPartialPackages().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
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
				return ownedCompleteClasses != null && !ownedCompleteClasses.isEmpty();
			case 6:
				return ownedCompletePackages != null && !ownedCompletePackages.isEmpty();
			case 7:
				return getOwningCompleteModel() != null;
			case 8:
				return getOwningCompletePackage() != null;
			case 9:
				return partialPackages != null && !partialPackages.isEmpty();
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
				return getOwnedCompleteClass((String)arguments.get(0));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	private /*final*/ /*@NonNull*/ String nsPrefix;
	private /*final*/ /*@NonNull*/ String nsURI;
	/**
	 * The cached value of the '{@link #getOwnedCompleteClasses() <em>Owned Complete Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCompleteClasses()
	 * @generated NOT
	 * @ordered
	 */
	protected @Nullable CompleteClasses ownedCompleteClasses;
	/**
	 * The cached value of the '{@link #getOwnedCompletePackages() <em>Owned Complete Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCompletePackages()
	 * @generated NOT
	 * @ordered
	 */
	protected @Nullable NestedCompletePackages ownedCompletePackages;
	//	private /*final*/ /*@NonNull*/ PackageId packageId;

	/**
	 * The cached value of the '{@link #getPartialPackages() <em>Partial Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialPackages()
	 * @generated NOT
	 * @ordered
	 */
	protected final @NonNull PartialPackages partialPackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CompletePackageImpl()
	{
		partialPackages = new PartialPackages(this);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCompletePackage(this);
	}

	@Override
	public void assertSamePackage(org.eclipse.ocl.pivot.Package pivotPackage) {
		assert pivotPackage != null;
		if (getOwningCompletePackage() == null) {
			//		if ((this instanceof OrphanCompletePackage) || (this instanceof ParentCompletePackage) || (this instanceof PrimitiveCompletePackage)) {
			org.eclipse.ocl.pivot.Package parentPackage = pivotPackage.getOwningPackage();
			//			assert parentPackage == null;
			String typeBasedNsURI = pivotPackage.getURI();
			String serverBasedNsURI = getURI();
			if (typeBasedNsURI == null) {
				//				assert serverBasedNsURI == null;
			}
			else {
				CompleteModelInternal completeModel = getCompleteModel();
				assert (serverBasedNsURI == null) || (completeModel.getCompletePackageByURI(typeBasedNsURI) == completeModel.getCompletePackageByURI(serverBasedNsURI));
			}
		}
		else {
			String typeBasedNsURI = pivotPackage.getURI();
			String serverBasedNsURI = getURI();
			assert (typeBasedNsURI == serverBasedNsURI) || typeBasedNsURI.equals(serverBasedNsURI);
		}
	}

	protected void didAddNestedPackage(@NonNull CompleteModel completeModel, org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		/*		CompletePackage completePackage = null;
		String name = pivotPackage.getName();
//		String packageURI = pivotPackage.getURI();
//		if (packageURI != null) {										// Explicit packageURI for explicit package (merge)
//			completePackage = completeURI2completePackage.get(packageURI);
//		}
		if (name != null) {										// Null packageURI can merge into same named package
			completePackage = getOwnedCompletePackage(name);
		}
		if (completePackage == null) {
			completePackage = getPartialPackages().createCompletePackage(pivotPackage);
			completePackage.assertSamePackage(pivotPackage);
		} */
		getPartialPackages().add(pivotPackage);
		if (ownedCompleteClasses != null) {
			ownedCompleteClasses.didAddPackage(pivotPackage);
		}
		//		completePackage.addTrackedPackage(pivotPackage);
		//		for (org.eclipse.ocl.pivot.Package nestedPackage : pivotPackage.getOwnedPackages()) {
		//			if (nestedPackage != null) {
		//				addPackage(completePackage, nestedPackage);
		//			}
		//		}
	}

	public void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if (ownedCompleteClasses != null) {
			ownedCompleteClasses.didAddClass(partialClass);
		}
	}

	public void didAddNestedPackage(org.eclipse.ocl.pivot.@NonNull Package nestedPackage) {
		getOwnedCompletePackages().didAddPackage(nestedPackage);
	}

	public void didAddPartialPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (ownedCompleteClasses != null) {
			ownedCompleteClasses.didAddPackage(partialPackage);
		}
	}

	public void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		if ((partialClass instanceof PrimitiveType) && !(this instanceof PrimitiveCompletePackage)) {
			getCompleteModel().getPrimitiveCompletePackage().didRemoveClass(partialClass);
		}
		else {
			if (ownedCompleteClasses != null) {
				ownedCompleteClasses.didRemoveClass(partialClass);
			}
		}
	}

	public void didRemoveNestedPackage(org.eclipse.ocl.pivot.@NonNull Package nestedPackage) {
		getOwnedCompletePackages().didRemovePackage(nestedPackage);
	}

	public void didRemovePartialPackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (ownedCompleteClasses != null) {
			ownedCompleteClasses.didRemovePackage(partialPackage);
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getAllClasses() {
		return Iterables.transform(ClassUtil.<CompleteClass>nullFree(getOwnedCompleteClasses()), new Function<@NonNull CompleteClass, org.eclipse.ocl.pivot.@NonNull Class>()
		{
			@Override
			public org.eclipse.ocl.pivot.@NonNull Class apply(@NonNull CompleteClass input) {
				return input.getPrimaryClass();
			}
		});
	}

	@Override
	public @NonNull CompleteClassInternal getCompleteClass(org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		return ClassUtil.nonNullState(getOwnedCompleteClass(pivotType.getName()));
	}

	@Override
	public @NonNull CompleteInheritanceImpl getCompleteInheritance(@NonNull CompleteClassInternal completeClass) {
		assert this != getCompleteModel().getOrphanCompletePackage();		// OrphanCompletePackage overrides
		return getPartialPackages().getCompleteInheritance(completeClass);
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		for (EObject eContainer = eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof CompleteModelInternal) {
				return (CompleteModelInternal) eContainer;
			}
		}
		throw new IllegalStateException();
	}

	@Override
	public EPackage getEPackage() {
		for (org.eclipse.ocl.pivot.Package partialPackage : getPartialPackages()) {
			EPackage ePackage = partialPackage.getEPackage();
			if (ePackage != null) {
				return ePackage;
			}
		}
		return null;
	}

	@Override
	public int getIndex(org.eclipse.ocl.pivot.Package p1) {
		return getPartialPackages().indexOf(p1);
	}

	@Override
	public org.eclipse.ocl.pivot.Class getMemberType(String name) {
		CompleteClass completeClass = name != null ? getOwnedCompleteClass(name) : null;
		return completeClass != null ? completeClass.getPrimaryClass() : null;
	}

	@Override
	public String getNsPrefix() {
		return nsPrefix;
	}

	@Override
	public CompleteClassInternal getOwnedCompleteClass(String name) {
		return getOwnedCompleteClasses().getOwnedCompleteClass(name);
	}

	@Override
	public CompletePackageInternal getOwnedCompletePackage(@Nullable String name) {
		return getOwnedCompletePackages().getOwnedCompletePackage(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull CompleteClasses getOwnedCompleteClasses()
	{
		CompleteClasses ownedCompleteClasses2 = ownedCompleteClasses;
		if (ownedCompleteClasses2 == null)
		{
			ownedCompleteClasses = ownedCompleteClasses2 = new CompleteClasses(this);
		}
		return ownedCompleteClasses2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull NestedCompletePackages getOwnedCompletePackages()
	{
		NestedCompletePackages ownedCompletePackages2 = ownedCompletePackages;
		if (ownedCompletePackages2 == null)
		{
			ownedCompletePackages = ownedCompletePackages2 = new NestedCompletePackages(this);
		}
		return ownedCompletePackages2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompleteModel getOwningCompleteModel()
	{
		if (eContainerFeatureID() != (7)) return null;
		return (CompleteModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompleteModel(CompleteModel newOwningCompleteModel, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningCompleteModel, 7, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompleteModel(CompleteModel newOwningCompleteModel)
	{
		if (newOwningCompleteModel != eInternalContainer() || (eContainerFeatureID() != (7) && newOwningCompleteModel != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningCompleteModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompleteModel != null)
				msgs = ((InternalEObject)newOwningCompleteModel).eInverseAdd(this, 6, CompleteModel.class, msgs);
			msgs = basicSetOwningCompleteModel(newOwningCompleteModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 7, newOwningCompleteModel, newOwningCompleteModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @Nullable CompletePackage getOwningCompletePackage() {
		if (eContainerFeatureID() != (8)) return null;
		return (CompletePackage)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompletePackage(CompletePackage newOwningCompletePackage, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningCompletePackage, 8, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompletePackage(CompletePackage newOwningCompletePackage)
	{
		if (newOwningCompletePackage != eInternalContainer() || (eContainerFeatureID() != (8) && newOwningCompletePackage != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningCompletePackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompletePackage != null)
				msgs = ((InternalEObject)newOwningCompletePackage).eInverseAdd(this, 6, CompletePackage.class, msgs);
			msgs = basicSetOwningCompletePackage(newOwningCompletePackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, newOwningCompletePackage, newOwningCompletePackage));
	}

	@Override
	public @NonNull PartialPackages getPartialPackages() {
		return partialPackages;
	}

	@Override
	public final org.eclipse.ocl.pivot.@NonNull Package getPrimaryPackage() {
		for (org.eclipse.ocl.pivot.Package partialPackage : getPartialPackages()) {
			if (partialPackage != null) {
				return partialPackage;
			}
		}
		//		assert false;
		// If there are no pivot packages (e.g. for an orphan) return the metamodel to avoid an NPE constructing a CompleteInheritance
		Package partialPackage = getCompleteModel().getStandardLibrary().getOclAnyType().getOwningPackage();
		return ClassUtil.nonNullState(partialPackage);
	}

	@Override
	public @NonNull CompletePackageInternal getRootCompletePackage() {
		for (EObject eContainer = eContainer(); eContainer instanceof CompletePackageInternal; eContainer = eContainer.eContainer()) {
			CompletePackageInternal completePackageInternal = (CompletePackageInternal)eContainer;
			if (completePackageInternal.getOwningCompletePackage() == null) {
				return (CompletePackageInternal)eContainer;
			}
		}
		return this;
	}

	@Override
	public Type getType(String metatypeName) {
		CompleteClass completeClass = getOwnedCompleteClass(metatypeName);
		return completeClass != null ? completeClass.getPrimaryClass() : null;
	}

	@Override
	public String getURI() {
		return nsURI;
	}

	@Override
	public void init(String name, @Nullable String nsPrefix, @Nullable String nsURI) {
		setName(name);
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
	}
} //CompletePackageImpl
