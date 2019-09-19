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

import com.zeligsoft.base.toolingmodel.CreationTool;
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
 * An implementation of the model object '<em><b>Creation Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.CreationToolImpl#getConcept <em>Concept</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.CreationToolImpl#getElementTypeHint <em>Element Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.CreationToolImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreationToolImpl extends ToolImpl implements CreationTool {

	/**
	 * The cached value of the '{@link #getConcept() <em>Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcept()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class concept;

	/**
	 * The default value of the '{@link #getElementTypeHint() <em>Element Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeHint()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeHint() <em>Element Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeHint()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeHint = ELEMENT_TYPE_HINT_EDEFAULT;

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
	protected CreationToolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.CREATION_TOOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getConcept() {
		if (concept != null && concept.eIsProxy()) {
			InternalEObject oldConcept = (InternalEObject) concept;
			concept = (org.eclipse.uml2.uml.Class) eResolveProxy(oldConcept);
			if (concept != oldConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ToolingModelPackage.CREATION_TOOL__CONCEPT, oldConcept, concept));
			}
		}
		return concept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetConcept() {
		return concept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcept(org.eclipse.uml2.uml.Class newConcept) {
		org.eclipse.uml2.uml.Class oldConcept = concept;
		concept = newConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.CREATION_TOOL__CONCEPT,
					oldConcept, concept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTypeHint() {
		return elementTypeHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeHint(String newElementTypeHint) {
		String oldElementTypeHint = elementTypeHint;
		elementTypeHint = newElementTypeHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.CREATION_TOOL__ELEMENT_TYPE_HINT,
					oldElementTypeHint, elementTypeHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExpression() {
		if (expression == null) {
			expression = new EObjectContainmentEList<Expression>(Expression.class, this,
					ToolingModelPackage.CREATION_TOOL__EXPRESSION);
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
		case ToolingModelPackage.CREATION_TOOL__EXPRESSION:
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
		case ToolingModelPackage.CREATION_TOOL__CONCEPT:
			if (resolve)
				return getConcept();
			return basicGetConcept();
		case ToolingModelPackage.CREATION_TOOL__ELEMENT_TYPE_HINT:
			return getElementTypeHint();
		case ToolingModelPackage.CREATION_TOOL__EXPRESSION:
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
		case ToolingModelPackage.CREATION_TOOL__CONCEPT:
			setConcept((org.eclipse.uml2.uml.Class) newValue);
			return;
		case ToolingModelPackage.CREATION_TOOL__ELEMENT_TYPE_HINT:
			setElementTypeHint((String) newValue);
			return;
		case ToolingModelPackage.CREATION_TOOL__EXPRESSION:
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
		case ToolingModelPackage.CREATION_TOOL__CONCEPT:
			setConcept((org.eclipse.uml2.uml.Class) null);
			return;
		case ToolingModelPackage.CREATION_TOOL__ELEMENT_TYPE_HINT:
			setElementTypeHint(ELEMENT_TYPE_HINT_EDEFAULT);
			return;
		case ToolingModelPackage.CREATION_TOOL__EXPRESSION:
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
		case ToolingModelPackage.CREATION_TOOL__CONCEPT:
			return concept != null;
		case ToolingModelPackage.CREATION_TOOL__ELEMENT_TYPE_HINT:
			return ELEMENT_TYPE_HINT_EDEFAULT == null ? elementTypeHint != null
					: !ELEMENT_TYPE_HINT_EDEFAULT.equals(elementTypeHint);
		case ToolingModelPackage.CREATION_TOOL__EXPRESSION:
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
		result.append(" (elementTypeHint: "); //$NON-NLS-1$
		result.append(elementTypeHint);
		result.append(')');
		return result.toString();
	}

} //CreationToolImpl
