/*******************************************************************************
 * Copyright (c) 2013, 2020 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Fix the severity set
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultSet;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getResultValidatableNode <em>Result Validatable Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getDiagnostic <em>Diagnostic</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getValidatableNode <em>Validatable Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getLeafConstrainingNode <em>Leaf Constraining Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getResultConstrainingNode <em>Result Constraining Node</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultImpl extends MinimalEObjectImpl.Container implements Result {
	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RESULT_FEATURE_COUNT = 8;

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
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final Severity SEVERITY_EDEFAULT = Severity.UNKNOWN;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected Severity severity = SEVERITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiagnostic() <em>Diagnostic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnostic()
	 * @generated
	 * @ordered
	 */
	protected static final Object DIAGNOSTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagnostic() <em>Diagnostic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnostic()
	 * @generated
	 * @ordered
	 */
	protected Object diagnostic = DIAGNOSTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final Throwable EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected Throwable exception = EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValidityPackage.Literals.RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResultSet getResultSet() {
		if (eContainerFeatureID() != (0)) return null;
		return (ResultSet)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultSet(ResultSet newResultSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResultSet, 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultSet(ResultSet newResultSet) {
		if (newResultSet != eInternalContainer() || (eContainerFeatureID() != (0) && newResultSet != null)) {
			if (EcoreUtil.isAncestor(this, newResultSet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResultSet != null)
				msgs = ((InternalEObject)newResultSet).eInverseAdd(this, 1, ResultSet.class, msgs);
			msgs = basicSetResultSet(newResultSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
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
	 * @generated
	 */
	@Override
	public void setResultValidatableNode(ResultValidatableNode newResultValidatableNode) {
		resultValidatableNode = newResultValidatableNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverityGen(Severity newSeverity) {
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
	}
	public void setSeverity(Severity newSeverity) {
		if (newSeverity != severity || newSeverity == SEVERITY_EDEFAULT) {
			setSeverityGen(newSeverity);
			if (eContainer() != null) {
				getResultValidatableNode().setWorstResult(this);
				getResultConstrainingNode().setWorstResult(this);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getDiagnostic() {
		return diagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiagnostic(Object newDiagnostic) {
		diagnostic = newDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ValidatableNode getValidatableNode() {
		return getResultValidatableNode().getParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public @NonNull LeafConstrainingNode getLeafConstrainingNode() {
		return (LeafConstrainingNode) getResultConstrainingNode().getParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public @NonNull ResultConstrainingNode getResultConstrainingNode() {
		return getResultValidatableNode().getResultConstrainingNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Throwable getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setException(Throwable newException) {
		exception = newException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResultSet((ResultSet)otherEnd, msgs);
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
				return basicSetResultSet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case 0:
				return eInternalContainer().eInverseRemove(this, 1, ResultSet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
				return getResultSet();
			case 1:
				if (resolve) return getResultValidatableNode();
				return basicGetResultValidatableNode();
			case 2:
				return getSeverity();
			case 3:
				return getDiagnostic();
			case 4:
				return getValidatableNode();
			case 5:
				return getLeafConstrainingNode();
			case 6:
				return getResultConstrainingNode();
			case 7:
				return getException();
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
			case 0:
				setResultSet((ResultSet)newValue);
				return;
			case 1:
				setResultValidatableNode((ResultValidatableNode)newValue);
				return;
			case 2:
				setSeverity((Severity)newValue);
				return;
			case 3:
				setDiagnostic(newValue);
				return;
			case 7:
				setException((Throwable)newValue);
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
				setResultSet((ResultSet)null);
				return;
			case 1:
				setResultValidatableNode((ResultValidatableNode)null);
				return;
			case 2:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case 3:
				setDiagnostic(DIAGNOSTIC_EDEFAULT);
				return;
			case 7:
				setException(EXCEPTION_EDEFAULT);
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
				return getResultSet() != null;
			case 1:
				return resultValidatableNode != null;
			case 2:
				return severity != SEVERITY_EDEFAULT;
			case 3:
				return DIAGNOSTIC_EDEFAULT == null ? diagnostic != null : !DIAGNOSTIC_EDEFAULT.equals(diagnostic);
			case 4:
				return getValidatableNode() != null;
			case 5:
				return getLeafConstrainingNode() != null;
			case 6:
				return getResultConstrainingNode() != null;
			case 7:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(getLeafConstrainingNode());
		result.append(": ");
		result.append(getValidatableNode());
		result.append(" => ");
		result.append(severity);
		result.append(" : ");
		result.append(diagnostic);
		result.append(" : ");
		result.append(exception);
		return result.toString();
	}

} //ResultImpl
