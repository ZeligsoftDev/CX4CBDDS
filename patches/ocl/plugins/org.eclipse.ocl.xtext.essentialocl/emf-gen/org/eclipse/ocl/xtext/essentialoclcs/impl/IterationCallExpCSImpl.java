/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl#getCoIterators <em>Co Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl#getIterators <em>Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterationCallExpCSImpl#getReferredIteration <em>Referred Iteration</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IterationCallExpCSImpl extends CallExpCSImpl implements IterationCallExpCS
{
	/**
	 * The number of structural features of the '<em>Iteration Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ITERATION_CALL_EXP_CS_FEATURE_COUNT = CallExpCSImpl.CALL_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getCoIterators() <em>Co Iterators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCS> coIterators;

	/**
	 * The cached value of the '{@link #getIterators() <em>Iterators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCS> iterators;

	/**
	 * The cached value of the '{@link #getReferredIteration() <em>Referred Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredIteration()
	 * @generated
	 * @ordered
	 */
	protected Iteration referredIteration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationCallExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.ITERATION_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VariableCS> getCoIterators()
	{
		if (coIterators == null)
		{
			coIterators = new EObjectEList<VariableCS>(VariableCS.class, this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17);
		}
		return coIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iteration getReferredIteration()
	{
		return referredIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredIteration(Iteration newReferredIteration)
	{
		Iteration oldReferredIteration = referredIteration;
		referredIteration = newReferredIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 19, oldReferredIteration, referredIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VariableCS> getIterators()
	{
		if (iterators == null)
		{
			iterators = new EObjectEList<VariableCS>(VariableCS.class, this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 18);
		}
		return iterators;
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17:
				return getCoIterators();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 18:
				return getIterators();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 19:
				return getReferredIteration();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17:
				getCoIterators().clear();
				getCoIterators().addAll((Collection<? extends VariableCS>)newValue);
				return;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 18:
				getIterators().clear();
				getIterators().addAll((Collection<? extends VariableCS>)newValue);
				return;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 19:
				setReferredIteration((Iteration)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17:
				getCoIterators().clear();
				return;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 18:
				getIterators().clear();
				return;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 19:
				setReferredIteration((Iteration)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 17:
				return coIterators != null && !coIterators.isEmpty();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 18:
				return iterators != null && !iterators.isEmpty();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 19:
				return referredIteration != null;
		}
		return super.eIsSet(featureID);
	}

} //IterationCallExpCSImpl
