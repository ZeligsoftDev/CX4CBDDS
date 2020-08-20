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
import com.zeligsoft.ddk.zdl.zdlgen.GenPalettable;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool;
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
 * An implementation of the model object '<em><b>Gen Palette Creation Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl#getElementTypeHint <em>Element Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteCreationToolImpl#getExpressions <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenPaletteCreationToolImpl extends GenPaletteToolImpl implements GenPaletteCreationTool {

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected GenPalettable type;

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
	protected GenPaletteCreationToolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_PALETTE_CREATION_TOOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPalettable getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (GenPalettable) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPalettable basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(GenPalettable newType) {
		GenPalettable oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__TYPE,
					oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElementTypeHint() {
		return elementTypeHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElementTypeHint(String newElementTypeHint) {
		String oldElementTypeHint = elementTypeHint;
		elementTypeHint = newElementTypeHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT, oldElementTypeHint, elementTypeHint));
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
					ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION);
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
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION:
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
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT:
			return getElementTypeHint();
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION:
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
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__TYPE:
			setType((GenPalettable) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT:
			setElementTypeHint((String) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION:
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
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__TYPE:
			setType((GenPalettable) null);
			return;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT:
			setElementTypeHint(ELEMENT_TYPE_HINT_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION:
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
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__TYPE:
			return type != null;
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__ELEMENT_TYPE_HINT:
			return ELEMENT_TYPE_HINT_EDEFAULT == null ? elementTypeHint != null
					: !ELEMENT_TYPE_HINT_EDEFAULT.equals(elementTypeHint);
		case ZDLGenPackage.GEN_PALETTE_CREATION_TOOL__EXPRESSION:
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
		result.append(" (elementTypeHint: "); //$NON-NLS-1$
		result.append(elementTypeHint);
		result.append(')');
		return result.toString();
	}

} //GenPaletteCreationToolImpl
