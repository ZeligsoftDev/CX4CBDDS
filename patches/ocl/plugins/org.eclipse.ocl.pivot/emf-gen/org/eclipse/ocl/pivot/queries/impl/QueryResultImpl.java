/**
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.queries.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.queries.QueriesPackage;
import org.eclipse.ocl.pivot.queries.QueryResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Result</b></em>'.
 * @since 1.18
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl#getSelf <em>Self</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.queries.impl.QueryResultImpl#getErrors <em>Errors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QueryResultImpl extends ElementImpl implements QueryResult {
	/**
	 * The number of structural features of the '<em>Query Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_RESULT_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Query Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_RESULT_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getSelf() <em>Self</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelf()
	 * @generated
	 * @ordered
	 */
	protected EObject self;

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected String result = RESULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpressionInOCL expression;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression value;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> errors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.QUERY_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getSelf() {
		if (self != null && self.eIsProxy()) {
			InternalEObject oldSelf = (InternalEObject)self;
			self = eResolveProxy(oldSelf);
			if (self != oldSelf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldSelf, self));
			}
		}
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSelf() {
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelf(EObject newSelf) {
		EObject oldSelf = self;
		self = newSelf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldSelf, self));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionInOCL getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(ExpressionInOCL newExpression, NotificationChain msgs) {
		ExpressionInOCL oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 3, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(ExpressionInOCL newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ElementImpl.ELEMENT_FEATURE_COUNT + 3), null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ElementImpl.ELEMENT_FEATURE_COUNT + 3), null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 3, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(OCLExpression newValue, NotificationChain msgs) {
		OCLExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 4, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(OCLExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ElementImpl.ELEMENT_FEATURE_COUNT + 4), null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ElementImpl.ELEMENT_FEATURE_COUNT + 4), null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 4, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getErrors() {
		if (errors == null) {
			errors = new EDataTypeUniqueEList<String>(String.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 5);
		}
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(String newResult) {
		String oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 2, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return basicSetExpression(null, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return basicSetValue(null, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (resolve) return getSelf();
				return basicGetSelf();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return getQuery();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return getResult();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return getExpression();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return getValue();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return getErrors();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setSelf((EObject)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setQuery((String)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setResult((String)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setExpression((ExpressionInOCL)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setValue((OCLExpression)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				getErrors().clear();
				getErrors().addAll((Collection<? extends String>)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setSelf((EObject)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setQuery(QUERY_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setResult(RESULT_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setExpression((ExpressionInOCL)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setValue((OCLExpression)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				getErrors().clear();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return self != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT.equals(result);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return expression != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return value != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return errors != null && !errors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (query: ");
		result.append(query);
		result.append(", result: ");
		result.append(result);
		result.append(", errors: ");
		result.append(errors);
		result.append(')');
		return result.toString();
	}


} //QueryResultImpl
