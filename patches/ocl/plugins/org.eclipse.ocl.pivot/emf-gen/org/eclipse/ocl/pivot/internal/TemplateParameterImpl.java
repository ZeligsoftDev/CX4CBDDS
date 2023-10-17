/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ids.AbstractGeneralizedIdImpl;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.TemplateParameterImpl#getConstrainingClasses <em>Constraining Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.TemplateParameterImpl#getOwningSignature <em>Owning Signature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateParameterImpl
		extends TypeImpl
		implements TemplateParameter {

	/**
	 * The number of structural features of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_PARAMETER_FEATURE_COUNT = TypeImpl.TYPE_FEATURE_COUNT + 2;
	/**
	 * The number of operations of the '<em>Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_PARAMETER_OPERATION_COUNT = TypeImpl.TYPE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getConstrainingClasses() <em>Constraining Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Class> constrainingClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TEMPLATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getConstrainingClasses()
	{
		if (constrainingClasses == null)
		{
			constrainingClasses = new EObjectResolvingEList<org.eclipse.ocl.pivot.Class>(org.eclipse.ocl.pivot.Class.class, this, 5);
		}
		return constrainingClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateSignature getOwningSignature() {
		if (eContainerFeatureID() != (6)) return null;
		return (TemplateSignature)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningSignature(TemplateSignature newOwningSignature, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningSignature, 6, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningSignature(TemplateSignature newOwningSignature)
	{
		if (newOwningSignature != eInternalContainer() || (eContainerFeatureID() != (6) && newOwningSignature != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningSignature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningSignature != null)
				msgs = ((InternalEObject)newOwningSignature).eInverseAdd(this, 4, TemplateSignature.class, msgs);
			msgs = basicSetOwningSignature(newOwningSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, newOwningSignature, newOwningSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case 6:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningSignature((TemplateSignature)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
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
				return basicSetOwningSignature(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case 6:
				return eInternalContainer().eInverseRemove(this, 4, TemplateSignature.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
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
				return getConstrainingClasses();
			case 6:
				return getOwningSignature();
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
				getConstrainingClasses().clear();
				getConstrainingClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case 6:
				setOwningSignature((TemplateSignature)newValue);
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
				getConstrainingClasses().clear();
				return;
			case 6:
				setOwningSignature((TemplateSignature)null);
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
				return constrainingClasses != null && !constrainingClasses.isEmpty();
			case 6:
				return getOwningSignature() != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTemplateParameter(this);
	}

	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		org.eclipse.ocl.pivot.Class lowerBound = PivotUtil.getLowerBound(this, standardLibrary.getOclAnyType());
		return standardLibrary.getInheritance(lowerBound);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getNormalizedType(@NonNull StandardLibrary standardLibrary) {
		try {
			return getInheritance(standardLibrary).getPivotClass();
		}
		catch (Throwable e) {
			return standardLibrary.getOclAnyType();			// FIXME should never happen
		}
	}

	private /*@LazyNonNull*/ TemplateParameterId templateParameterId;

	@Override
	public @NonNull TemplateParameterId getTemplateParameterId() {
		assert eContainer() != null;
		TemplateParameterId templateParameterId2 = templateParameterId;
		if (templateParameterId2 == null) {
			synchronized (this) {
				templateParameterId2 = templateParameterId;
				if (templateParameterId2 == null) {
					TemplateSignature templateSignature1 = getOwningSignature();
					assert templateSignature1 != null;
					TemplateableElement templateableElement = templateSignature1.getOwningElement();
					AbstractGeneralizedIdImpl<?> generalizedTypeId;
					if (templateableElement instanceof Operation) {
						generalizedTypeId = (AbstractGeneralizedIdImpl<?>)((Operation)templateableElement).getOperationId();
					}
					else if (templateableElement instanceof org.eclipse.ocl.pivot.Class) {
						generalizedTypeId = (AbstractGeneralizedIdImpl<?>)((org.eclipse.ocl.pivot.Class)templateableElement).getTypeId();
					}
					else {
						assert false; //templateableElement != null;
						generalizedTypeId = null;
					}
					if (generalizedTypeId != null) {
						List<@NonNull TemplateParameter> templateParameters = PivotUtil.getTemplateParameters(this);
						assert templateParameters != null;
						int index = templateParameters.indexOf(this);
						assert index >= 0;
						templateParameterId = templateParameterId2 = generalizedTypeId.getTemplateParameterId(index, PivotUtil.getName(this));
					}
					assert templateParameterId2 != null;
				}
			}
		}
		return templateParameterId2;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TypeId getNormalizedTypeId() {
		return IdManager.getTemplateParameterIndexId(this);
	}

	@Override
	public @NonNull TemplateParameterId getTypeId() {
		return getTemplateParameterId();
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class isClass() {
		return null;
	}

	@Override
	public @NonNull TemplateParameter isTemplateParameter() {
		return this;
	}

	@Override
	public @NonNull Type specializeIn(/*@NonNull*/ CallExp expr, @Nullable Type selfType) {
		assert expr != null;
		if (selfType != null) {
			EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(expr);
			PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
			return metamodelManager.specializeType(this, expr, selfType, null);
		}
		return this;
	}
} //TemplateParameterImpl
