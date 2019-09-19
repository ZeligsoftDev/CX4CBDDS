/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.toolingmodel.impl;

import com.zeligsoft.base.toolingmodel.CreateAction;
import com.zeligsoft.base.toolingmodel.Expression;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.CreateActionImpl#getCreateConcept <em>Create Concept</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.CreateActionImpl#getTypeHint <em>Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.CreateActionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateActionImpl extends MenuActionImpl implements CreateAction {
	/**
	 * The default value of the '{@link #getCreateConcept() <em>Create Concept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateConcept()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATE_CONCEPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateConcept() <em>Create Concept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateConcept()
	 * @generated
	 * @ordered
	 */
	protected String createConcept = CREATE_CONCEPT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeHint() <em>Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeHint()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeHint() <em>Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeHint()
	 * @generated
	 * @ordered
	 */
	protected String typeHint = TYPE_HINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.CREATE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateConcept() {
		return createConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateConcept(String newCreateConcept) {
		String oldCreateConcept = createConcept;
		createConcept = newCreateConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.CREATE_ACTION__CREATE_CONCEPT,
					oldCreateConcept, createConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeHint() {
		return typeHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeHint(String newTypeHint) {
		String oldTypeHint = typeHint;
		typeHint = newTypeHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.CREATE_ACTION__TYPE_HINT,
					oldTypeHint, typeHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpression() {
		if (expression == null) {
			expression = new EObjectContainmentEList<Expression>(Expression.class, this,
					ToolingModelPackage.CREATE_ACTION__EXPRESSION);
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ToolingModelPackage.CREATE_ACTION__EXPRESSION:
			return ((InternalEList<?>) getExpression()).basicRemove(otherEnd, msgs);
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
		case ToolingModelPackage.CREATE_ACTION__CREATE_CONCEPT:
			return getCreateConcept();
		case ToolingModelPackage.CREATE_ACTION__TYPE_HINT:
			return getTypeHint();
		case ToolingModelPackage.CREATE_ACTION__EXPRESSION:
			return getExpression();
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
		case ToolingModelPackage.CREATE_ACTION__CREATE_CONCEPT:
			setCreateConcept((String) newValue);
			return;
		case ToolingModelPackage.CREATE_ACTION__TYPE_HINT:
			setTypeHint((String) newValue);
			return;
		case ToolingModelPackage.CREATE_ACTION__EXPRESSION:
			getExpression().clear();
			getExpression().addAll((Collection<? extends Expression>) newValue);
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
		case ToolingModelPackage.CREATE_ACTION__CREATE_CONCEPT:
			setCreateConcept(CREATE_CONCEPT_EDEFAULT);
			return;
		case ToolingModelPackage.CREATE_ACTION__TYPE_HINT:
			setTypeHint(TYPE_HINT_EDEFAULT);
			return;
		case ToolingModelPackage.CREATE_ACTION__EXPRESSION:
			getExpression().clear();
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
		case ToolingModelPackage.CREATE_ACTION__CREATE_CONCEPT:
			return CREATE_CONCEPT_EDEFAULT == null ? createConcept != null
					: !CREATE_CONCEPT_EDEFAULT.equals(createConcept);
		case ToolingModelPackage.CREATE_ACTION__TYPE_HINT:
			return TYPE_HINT_EDEFAULT == null ? typeHint != null : !TYPE_HINT_EDEFAULT.equals(typeHint);
		case ToolingModelPackage.CREATE_ACTION__EXPRESSION:
			return expression != null && !expression.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (createConcept: "); //$NON-NLS-1$
		result.append(createConcept);
		result.append(", typeHint: "); //$NON-NLS-1$
		result.append(typeHint);
		result.append(')');
		return result.toString();
	}

} //CreateActionImpl
