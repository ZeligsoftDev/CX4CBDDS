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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.zeligsoft.base.toolingmodel.MenuInstance;
import com.zeligsoft.base.toolingmodel.MenuItem;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.MenuInstanceImpl#getConcept <em>Concept</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.MenuInstanceImpl#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MenuInstanceImpl extends MenuObjectImpl implements MenuInstance {
	/**
	 * The default value of the '{@link #getConcept() <em>Concept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcept()
	 * @generated
	 * @ordered
	 */
	protected static final String CONCEPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConcept() <em>Concept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcept()
	 * @generated
	 * @ordered
	 */
	protected String concept = CONCEPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuItem> item;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.MENU_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcept(String newConcept) {
		String oldConcept = concept;
		concept = newConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.MENU_INSTANCE__CONCEPT,
					oldConcept, concept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MenuItem> getItem() {
		if (item == null) {
			item = new EObjectResolvingEList<MenuItem>(MenuItem.class, this, ToolingModelPackage.MENU_INSTANCE__ITEM);
		}
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ToolingModelPackage.MENU_INSTANCE__CONCEPT:
			return getConcept();
		case ToolingModelPackage.MENU_INSTANCE__ITEM:
			return getItem();
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
		case ToolingModelPackage.MENU_INSTANCE__CONCEPT:
			setConcept((String) newValue);
			return;
		case ToolingModelPackage.MENU_INSTANCE__ITEM:
			getItem().clear();
			getItem().addAll((Collection<? extends MenuItem>) newValue);
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
		case ToolingModelPackage.MENU_INSTANCE__CONCEPT:
			setConcept(CONCEPT_EDEFAULT);
			return;
		case ToolingModelPackage.MENU_INSTANCE__ITEM:
			getItem().clear();
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
		case ToolingModelPackage.MENU_INSTANCE__CONCEPT:
			return CONCEPT_EDEFAULT == null ? concept != null : !CONCEPT_EDEFAULT.equals(concept);
		case ToolingModelPackage.MENU_INSTANCE__ITEM:
			return item != null && !item.isEmpty();
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
		result.append(" (concept: "); //$NON-NLS-1$
		result.append(concept);
		result.append(')');
		return result.toString();
	}

} //MenuInstanceImpl
