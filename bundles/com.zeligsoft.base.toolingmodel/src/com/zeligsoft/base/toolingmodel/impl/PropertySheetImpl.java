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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.PropertySheet;
import com.zeligsoft.base.toolingmodel.PropertySource;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Sheet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl#getDomainModelURI <em>Domain Model URI</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl#getPropertySource <em>Property Source</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertySheetImpl#getPropertyDefinition <em>Property Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertySheetImpl extends PropertiesObjectImpl implements
		PropertySheet {

	/**
	 * The default value of the '{@link #getDomainModelURI() <em>Domain Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_MODEL_URI_EDEFAULT = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getDomainModelURI() <em>Domain Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModelURI()
	 * @generated
	 * @ordered
	 */
	protected String domainModelURI = DOMAIN_MODEL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPropertySource() <em>Property Source</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertySource()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertySource> propertySource;

	/**
	 * The cached value of the '{@link #getPropertyDefinition() <em>Property Definition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDefinition> propertyDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySheetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.PROPERTY_SHEET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainModelURI() {
		return domainModelURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainModelURI(String newDomainModelURI) {
		String oldDomainModelURI = domainModelURI;
		domainModelURI = newDomainModelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ToolingModelPackage.PROPERTY_SHEET__DOMAIN_MODEL_URI,
					oldDomainModelURI, domainModelURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertySource> getPropertySource() {
		if (propertySource == null) {
			propertySource = new EObjectContainmentEList<PropertySource>(
					PropertySource.class, this,
					ToolingModelPackage.PROPERTY_SHEET__PROPERTY_SOURCE);
		}
		return propertySource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyDefinition> getPropertyDefinition() {
		if (propertyDefinition == null) {
			propertyDefinition = new EObjectContainmentEList<PropertyDefinition>(
					PropertyDefinition.class, this,
					ToolingModelPackage.PROPERTY_SHEET__PROPERTY_DEFINITION);
		}
		return propertyDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_SOURCE:
			return ((InternalEList<?>) getPropertySource()).basicRemove(
					otherEnd, msgs);
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_DEFINITION:
			return ((InternalEList<?>) getPropertyDefinition()).basicRemove(
					otherEnd, msgs);
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
		case ToolingModelPackage.PROPERTY_SHEET__DOMAIN_MODEL_URI:
			return getDomainModelURI();
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_SOURCE:
			return getPropertySource();
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_DEFINITION:
			return getPropertyDefinition();
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
		case ToolingModelPackage.PROPERTY_SHEET__DOMAIN_MODEL_URI:
			setDomainModelURI((String) newValue);
			return;
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_SOURCE:
			getPropertySource().clear();
			getPropertySource().addAll(
					(Collection<? extends PropertySource>) newValue);
			return;
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_DEFINITION:
			getPropertyDefinition().clear();
			getPropertyDefinition().addAll(
					(Collection<? extends PropertyDefinition>) newValue);
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
		case ToolingModelPackage.PROPERTY_SHEET__DOMAIN_MODEL_URI:
			setDomainModelURI(DOMAIN_MODEL_URI_EDEFAULT);
			return;
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_SOURCE:
			getPropertySource().clear();
			return;
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_DEFINITION:
			getPropertyDefinition().clear();
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
		case ToolingModelPackage.PROPERTY_SHEET__DOMAIN_MODEL_URI:
			return DOMAIN_MODEL_URI_EDEFAULT == null ? domainModelURI != null
					: !DOMAIN_MODEL_URI_EDEFAULT.equals(domainModelURI);
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_SOURCE:
			return propertySource != null && !propertySource.isEmpty();
		case ToolingModelPackage.PROPERTY_SHEET__PROPERTY_DEFINITION:
			return propertyDefinition != null && !propertyDefinition.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (domainModelURI: "); //$NON-NLS-1$
		result.append(domainModelURI);
		result.append(')');
		return result.toString();
	}

} //PropertySheetImpl
