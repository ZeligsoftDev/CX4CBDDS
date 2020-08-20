/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.impl;

import com.zeligsoft.ddk.zdl.zdlgen.Expression;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

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
 * An implementation of the model object '<em><b>Gen Menu Create Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl#getTypeHint <em>Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl#getCreateConcept <em>Create Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuCreateActionImpl#getExpressions <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenMenuCreateActionImpl extends GenMenuActionImpl implements GenMenuCreateAction {
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
	 * The cached value of the '{@link #getCreateConcept() <em>Create Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateConcept()
	 * @generated
	 * @ordered
	 */
	protected GenDomainConcept createConcept;

	/**
	 * The cached value of the '{@link #getExpressions() <em>Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> expressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenMenuCreateActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_MENU_CREATE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTypeHint() {
		return typeHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeHint(String newTypeHint) {
		String oldTypeHint = typeHint;
		typeHint = newTypeHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_CREATE_ACTION__TYPE_HINT,
					oldTypeHint, typeHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainConcept getCreateConcept() {
		if (createConcept != null && createConcept.eIsProxy()) {
			InternalEObject oldCreateConcept = (InternalEObject) createConcept;
			createConcept = (GenDomainConcept) eResolveProxy(oldCreateConcept);
			if (createConcept != oldCreateConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT, oldCreateConcept, createConcept));
			}
		}
		return createConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainConcept basicGetCreateConcept() {
		return createConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreateConcept(GenDomainConcept newCreateConcept) {
		GenDomainConcept oldCreateConcept = createConcept;
		createConcept = newCreateConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT,
					oldCreateConcept, createConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectContainmentEList<Expression>(Expression.class, this,
					ZDLGenPackage.GEN_MENU_CREATE_ACTION__EXPRESSION);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__EXPRESSION:
			return ((InternalEList<?>) getExpressions()).basicRemove(otherEnd, msgs);
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
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__TYPE_HINT:
			return getTypeHint();
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT:
			if (resolve)
				return getCreateConcept();
			return basicGetCreateConcept();
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__EXPRESSION:
			return getExpressions();
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
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__TYPE_HINT:
			setTypeHint((String) newValue);
			return;
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT:
			setCreateConcept((GenDomainConcept) newValue);
			return;
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__EXPRESSION:
			getExpressions().clear();
			getExpressions().addAll((Collection<? extends Expression>) newValue);
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
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__TYPE_HINT:
			setTypeHint(TYPE_HINT_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT:
			setCreateConcept((GenDomainConcept) null);
			return;
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__EXPRESSION:
			getExpressions().clear();
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
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__TYPE_HINT:
			return TYPE_HINT_EDEFAULT == null ? typeHint != null : !TYPE_HINT_EDEFAULT.equals(typeHint);
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__CREATE_CONCEPT:
			return createConcept != null;
		case ZDLGenPackage.GEN_MENU_CREATE_ACTION__EXPRESSION:
			return expressions != null && !expressions.isEmpty();
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
		result.append(" (typeHint: "); //$NON-NLS-1$
		result.append(typeHint);
		result.append(')');
		return result.toString();
	}

} //GenMenuCreateActionImpl
