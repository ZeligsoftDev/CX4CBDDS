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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.IterateCallExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IterateCallExpCSImpl#getAccumulators <em>Accumulators</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IterateCallExpCSImpl extends IterationCallExpCSImpl implements IterateCallExpCS
{
	/**
	 * The number of structural features of the '<em>Iterate Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ITERATE_CALL_EXP_CS_FEATURE_COUNT = IterationCallExpCSImpl.ITERATION_CALL_EXP_CS_FEATURE_COUNT + 1;
	/**
	 * The cached value of the '{@link #getAccumulators() <em>Accumulators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccumulators()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCS> accumulators;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateCallExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.ITERATE_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VariableCS> getAccumulators()
	{
		if (accumulators == null)
		{
			accumulators = new EObjectEList<VariableCS>(VariableCS.class, this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 20);
		}
		return accumulators;
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 20:
				return getAccumulators();
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 20:
				getAccumulators().clear();
				getAccumulators().addAll((Collection<? extends VariableCS>)newValue);
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 20:
				getAccumulators().clear();
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 20:
				return accumulators != null && !accumulators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IterateCallExpCSImpl
