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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result ConstrainingNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultConstrainingNodeImpl#getResultValidatableNode <em>Result Validatable Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultConstrainingNodeImpl extends ConstrainingNodeImpl implements ResultConstrainingNode {
	/**
	 * The number of structural features of the '<em>Result Constraining Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RESULT_CONSTRAINING_NODE_FEATURE_COUNT = ConstrainingNodeImpl.CONSTRAINING_NODE_FEATURE_COUNT + 1;
	/**
	 * The cached value of the '{@link #getResultValidatableNode() <em>Result Validatable Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultValidatableNode()
	 * @generated
	 * @ordered
	 */
	protected ResultValidatableNode resultValidatableNode;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultConstrainingNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValidityPackage.Literals.RESULT_CONSTRAINING_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResultValidatableNode getResultValidatableNode() {
		if (resultValidatableNode != null && resultValidatableNode.eIsProxy()) {
			InternalEObject oldResultValidatableNode = (InternalEObject)resultValidatableNode;
			resultValidatableNode = (ResultValidatableNode)eResolveProxy(oldResultValidatableNode);
			if (resultValidatableNode != oldResultValidatableNode) {
			}
		}
		return resultValidatableNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultValidatableNode basicGetResultValidatableNode() {
		return resultValidatableNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT		// To eliminate a spurious warning line
	 */
	public NotificationChain basicSetResultValidatableNode(ResultValidatableNode newResultValidatableNode, NotificationChain msgs) {
		resultValidatableNode = newResultValidatableNode;
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultValidatableNode(ResultValidatableNode newResultValidatableNode) {
		if (newResultValidatableNode != resultValidatableNode) {
			NotificationChain msgs = null;
			if (resultValidatableNode != null)
				msgs = ((InternalEObject)resultValidatableNode).eInverseRemove(this, 8, ResultValidatableNode.class, msgs);
			if (newResultValidatableNode != null)
				msgs = ((InternalEObject)newResultValidatableNode).eInverseAdd(this, 8, ResultValidatableNode.class, msgs);
			msgs = basicSetResultValidatableNode(newResultValidatableNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 8:
				if (resultValidatableNode != null)
					msgs = ((InternalEObject)resultValidatableNode).eInverseRemove(this, 8, ResultValidatableNode.class, msgs);
				return basicSetResultValidatableNode((ResultValidatableNode)otherEnd, msgs);
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
			case 8:
				return basicSetResultValidatableNode(null, msgs);
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
			case 8:
				if (resolve) return getResultValidatableNode();
				return basicGetResultValidatableNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case 8:
				setResultValidatableNode((ResultValidatableNode)newValue);
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
			case 8:
				setResultValidatableNode((ResultValidatableNode)null);
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
			case 8:
				return resultValidatableNode != null;
		}
		return super.eIsSet(featureID);
	}
} //ResultConstrainingNodeImpl
