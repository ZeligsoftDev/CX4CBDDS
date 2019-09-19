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

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.PropertySource;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl#getConceptName <em>Concept Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertySourceImpl#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertySourceImpl extends PropertiesObjectImpl implements PropertySource {

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDefinition> definition;

	/**
	 * The default value of the '{@link #getConceptName() <em>Concept Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONCEPT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConceptName() <em>Concept Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConceptName()
	 * @generated
	 * @ordered
	 */
	protected String conceptName = CONCEPT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 7326;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.PROPERTY_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyDefinition> getDefinition() {
		if (definition == null) {
			definition = new EObjectResolvingEList<PropertyDefinition>(PropertyDefinition.class, this,
					ToolingModelPackage.PROPERTY_SOURCE__DEFINITION);
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConceptName() {
		return conceptName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptName(String newConceptName) {
		String oldConceptName = conceptName;
		conceptName = newConceptName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.PROPERTY_SOURCE__CONCEPT_NAME,
					oldConceptName, conceptName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ToolingModelPackage.PROPERTY_SOURCE__ORDER, oldOrder,
					order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ToolingModelPackage.PROPERTY_SOURCE__DEFINITION:
			return getDefinition();
		case ToolingModelPackage.PROPERTY_SOURCE__CONCEPT_NAME:
			return getConceptName();
		case ToolingModelPackage.PROPERTY_SOURCE__ORDER:
			return getOrder();
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
		case ToolingModelPackage.PROPERTY_SOURCE__DEFINITION:
			getDefinition().clear();
			getDefinition().addAll((Collection<? extends PropertyDefinition>) newValue);
			return;
		case ToolingModelPackage.PROPERTY_SOURCE__CONCEPT_NAME:
			setConceptName((String) newValue);
			return;
		case ToolingModelPackage.PROPERTY_SOURCE__ORDER:
			setOrder((Integer) newValue);
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
		case ToolingModelPackage.PROPERTY_SOURCE__DEFINITION:
			getDefinition().clear();
			return;
		case ToolingModelPackage.PROPERTY_SOURCE__CONCEPT_NAME:
			setConceptName(CONCEPT_NAME_EDEFAULT);
			return;
		case ToolingModelPackage.PROPERTY_SOURCE__ORDER:
			setOrder(ORDER_EDEFAULT);
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
		case ToolingModelPackage.PROPERTY_SOURCE__DEFINITION:
			return definition != null && !definition.isEmpty();
		case ToolingModelPackage.PROPERTY_SOURCE__CONCEPT_NAME:
			return CONCEPT_NAME_EDEFAULT == null ? conceptName != null : !CONCEPT_NAME_EDEFAULT.equals(conceptName);
		case ToolingModelPackage.PROPERTY_SOURCE__ORDER:
			return order != ORDER_EDEFAULT;
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
		result.append(" (conceptName: "); //$NON-NLS-1$
		result.append(conceptName);
		result.append(", order: "); //$NON-NLS-1$
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //PropertySourceImpl
