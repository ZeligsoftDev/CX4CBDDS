/*******************************************************************************
 * Copyright (c) 2013, 2020 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.RootNodeImpl#getResultSets <em>Result Sets</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.RootNodeImpl#getConstrainingNodes <em>Constraining Nodes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.RootNodeImpl#getValidatableNodes <em>Validatable Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootNodeImpl extends MinimalEObjectImpl.Container implements RootNode {
	/**
	 * The number of structural features of the '<em>Root Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_NODE_FEATURE_COUNT = 3;

	/**
	 * The cached value of the '{@link #getResultSets() <em>Result Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultSet> resultSets;

	/**
	 * The cached value of the '{@link #getConstrainingNodes() <em>Constraining Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RootConstrainingNode> constrainingNodes;

	/**
	 * The cached value of the '{@link #getValidatableNodes() <em>Validatable Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidatableNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RootValidatableNode> validatableNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValidityPackage.Literals.ROOT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull EList<ResultSet> getResultSets() {
		if (resultSets == null) {
			resultSets = new BasicInternalEList<ResultSet>(ResultSet.class);
		}
		return resultSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT // Bug 414352 workaround
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull EList<RootConstrainingNode> getConstrainingNodes() {
		if (constrainingNodes == null) {
			constrainingNodes = new EObjectContainmentWithInverseEList<RootConstrainingNode>(RootConstrainingNode.class, this, ValidityPackage.Literals.ROOT_NODE__CONSTRAINING_NODES.getFeatureID(), ValidityPackage.Literals.ROOT_CONSTRAINING_NODE__ROOT_NODE.getFeatureID());
		}
		return constrainingNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT // Bug 414352 workaround
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull EList<RootValidatableNode> getValidatableNodes() {
		if (validatableNodes == null) {
			validatableNodes = new EObjectContainmentWithInverseEList<RootValidatableNode>(RootValidatableNode.class, this, ValidityPackage.Literals.ROOT_NODE__VALIDATABLE_NODES.getFeatureID(), ValidityPackage.Literals.ROOT_VALIDATABLE_NODE__ROOT_NODE.getFeatureID());
		}
		return validatableNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResultSets()).basicAdd(otherEnd, msgs);
			case 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstrainingNodes()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValidatableNodes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 0:
				return ((InternalEList<?>)getResultSets()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getConstrainingNodes()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getValidatableNodes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 0:
				return getResultSets();
			case 1:
				return getConstrainingNodes();
			case 2:
				return getValidatableNodes();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case 0:
				getResultSets().clear();
				getResultSets().addAll((Collection<? extends ResultSet>)newValue);
				return;
			case 1:
				getConstrainingNodes().clear();
				getConstrainingNodes().addAll((Collection<? extends RootConstrainingNode>)newValue);
				return;
			case 2:
				getValidatableNodes().clear();
				getValidatableNodes().addAll((Collection<? extends RootValidatableNode>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case 0:
				getResultSets().clear();
				return;
			case 1:
				getConstrainingNodes().clear();
				return;
			case 2:
				getValidatableNodes().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case 0:
				return resultSets != null && !resultSets.isEmpty();
			case 1:
				return constrainingNodes != null && !constrainingNodes.isEmpty();
			case 2:
				return validatableNodes != null && !validatableNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootImpl
