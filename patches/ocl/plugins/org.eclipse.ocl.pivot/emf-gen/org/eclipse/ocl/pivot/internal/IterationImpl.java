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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.TemplateBinding;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.IterationImpl#getOwnedAccumulators <em>Owned Accumulators</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.IterationImpl#getOwnedIterators <em>Owned Iterators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterationImpl extends OperationImpl implements Iteration
{
	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ITERATION_FEATURE_COUNT = OperationImpl.OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ITERATION_OPERATION_COUNT = OperationImpl.OPERATION_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getOwnedAccumulators() <em>Owned Accumulators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAccumulators()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedAccumulators;

	/**
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedIterators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationImpl()
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
		return PivotPackage.Literals.ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Parameter> getOwnedIterators()
	{
		if (ownedIterators == null)
		{
			ownedIterators = new EObjectContainmentEList<Parameter>(Parameter.class, this, 28);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull List<Parameter> getOwnedAccumulators()
	{
		if (ownedAccumulators == null)
		{
			ownedAccumulators = new EObjectContainmentEList<Parameter>(Parameter.class, this, 27);
		}
		return ownedAccumulators;
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
			case 11:
				return ((InternalEList<?>)getOwnedConstraints()).basicRemove(otherEnd, msgs);
			case 12:
				return ((InternalEList<?>)getOwnedBindings()).basicRemove(otherEnd, msgs);
			case 13:
				return basicSetOwnedSignature(null, msgs);
			case 15:
				return basicSetBodyExpression(null, msgs);
			case 20:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
			case 21:
				return ((InternalEList<?>)getOwnedPostconditions()).basicRemove(otherEnd, msgs);
			case 22:
				return ((InternalEList<?>)getOwnedPreconditions()).basicRemove(otherEnd, msgs);
			case 23:
				return basicSetOwningClass(null, msgs);
			case 27:
				return ((InternalEList<?>)getOwnedAccumulators()).basicRemove(otherEnd, msgs);
			case 28:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
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
				return getName();
			case 5:
				return isIsMany();
			case 6:
				return isIsRequired();
			case 7:
				if (resolve) return getType();
				return basicGetType();
			case 8:
				return getImplementation();
			case 9:
				return getImplementationClass();
			case 10:
				return isIsStatic();
			case 11:
				return getOwnedConstraints();
			case 12:
				return getOwnedBindings();
			case 13:
				return getOwnedSignature();
			case 14:
				return getUnspecializedElement();
			case 15:
				return getBodyExpression();
			case 16:
				return isIsInvalidating();
			case 17:
				return isIsTransient();
			case 18:
				return isIsTypeof();
			case 19:
				return isIsValidating();
			case 20:
				return getOwnedParameters();
			case 21:
				return getOwnedPostconditions();
			case 22:
				return getOwnedPreconditions();
			case 23:
				return getOwningClass();
			case 24:
				if (resolve) return getPrecedence();
				return basicGetPrecedence();
			case 25:
				return getRaisedExceptions();
			case 26:
				return getRedefinedOperations();
			case 27:
				return getOwnedAccumulators();
			case 28:
				return getOwnedIterators();
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
				setIsRequired((Boolean)newValue);
				return;
			case 7:
				setType((Type)newValue);
				return;
			case 8:
				setImplementation((LibraryFeature)newValue);
				return;
			case 9:
				setImplementationClass((String)newValue);
				return;
			case 10:
				setIsStatic((Boolean)newValue);
				return;
			case 11:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 12:
				getOwnedBindings().clear();
				getOwnedBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case 13:
				setOwnedSignature((TemplateSignature)newValue);
				return;
			case 14:
				setUnspecializedElement((TemplateableElement)newValue);
				return;
			case 15:
				setBodyExpression((LanguageExpression)newValue);
				return;
			case 16:
				setIsInvalidating((Boolean)newValue);
				return;
			case 17:
				setIsTransient((Boolean)newValue);
				return;
			case 18:
				setIsTypeof((Boolean)newValue);
				return;
			case 19:
				setIsValidating((Boolean)newValue);
				return;
			case 20:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case 21:
				getOwnedPostconditions().clear();
				getOwnedPostconditions().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 22:
				getOwnedPreconditions().clear();
				getOwnedPreconditions().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 23:
				setOwningClass((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case 24:
				setPrecedence((Precedence)newValue);
				return;
			case 25:
				getRaisedExceptions().clear();
				getRaisedExceptions().addAll((Collection<? extends Type>)newValue);
				return;
			case 26:
				getRedefinedOperations().clear();
				getRedefinedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case 27:
				getOwnedAccumulators().clear();
				getOwnedAccumulators().addAll((Collection<? extends Parameter>)newValue);
				return;
			case 28:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends Parameter>)newValue);
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
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case 7:
				setType((Type)null);
				return;
			case 8:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case 9:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case 10:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case 11:
				getOwnedConstraints().clear();
				return;
			case 12:
				getOwnedBindings().clear();
				return;
			case 13:
				setOwnedSignature((TemplateSignature)null);
				return;
			case 14:
				setUnspecializedElement((TemplateableElement)null);
				return;
			case 15:
				setBodyExpression((LanguageExpression)null);
				return;
			case 16:
				setIsInvalidating(IS_INVALIDATING_EDEFAULT);
				return;
			case 17:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case 18:
				setIsTypeof(IS_TYPEOF_EDEFAULT);
				return;
			case 19:
				setIsValidating(IS_VALIDATING_EDEFAULT);
				return;
			case 20:
				getOwnedParameters().clear();
				return;
			case 21:
				getOwnedPostconditions().clear();
				return;
			case 22:
				getOwnedPreconditions().clear();
				return;
			case 23:
				setOwningClass((org.eclipse.ocl.pivot.Class)null);
				return;
			case 24:
				setPrecedence((Precedence)null);
				return;
			case 25:
				getRaisedExceptions().clear();
				return;
			case 26:
				getRedefinedOperations().clear();
				return;
			case 27:
				getOwnedAccumulators().clear();
				return;
			case 28:
				getOwnedIterators().clear();
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
				return isIsMany() != IS_MANY_EDEFAULT;
			case 6:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case 7:
				return type != null;
			case 8:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case 9:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case 10:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case 11:
				return ownedConstraints != null && !ownedConstraints.isEmpty();
			case 12:
				return ownedBindings != null && !ownedBindings.isEmpty();
			case 13:
				return ownedSignature != null;
			case 14:
				return unspecializedElement != null;
			case 15:
				return bodyExpression != null;
			case 16:
				return ((eFlags & IS_INVALIDATING_EFLAG) != 0) != IS_INVALIDATING_EDEFAULT;
			case 17:
				return ((eFlags & IS_TRANSIENT_EFLAG) != 0) != IS_TRANSIENT_EDEFAULT;
			case 18:
				return ((eFlags & IS_TYPEOF_EFLAG) != 0) != IS_TYPEOF_EDEFAULT;
			case 19:
				return ((eFlags & IS_VALIDATING_EFLAG) != 0) != IS_VALIDATING_EDEFAULT;
			case 20:
				return ownedParameters != null && !ownedParameters.isEmpty();
			case 21:
				return ownedPostconditions != null && !ownedPostconditions.isEmpty();
			case 22:
				return ownedPreconditions != null && !ownedPreconditions.isEmpty();
			case 23:
				return getOwningClass() != null;
			case 24:
				return precedence != null;
			case 25:
				return raisedExceptions != null && !raisedExceptions.isEmpty();
			case 26:
				return redefinedOperations != null && !redefinedOperations.isEmpty();
			case 27:
				return ownedAccumulators != null && !ownedAccumulators.isEmpty();
			case 28:
				return ownedIterators != null && !ownedIterators.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitIteration(this);
	}

} //IterationImpl
