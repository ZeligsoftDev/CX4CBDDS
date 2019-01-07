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

import com.zeligsoft.base.toolingmodel.PropertyDefinition;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl#getContentHint <em>Content Hint</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.PropertyDefinitionImpl#getSection <em>Section</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyDefinitionImpl extends NamedElementImpl implements
		PropertyDefinition {

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContentHint() <em>Content Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentHint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentHint() <em>Content Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentHint()
	 * @generated
	 * @ordered
	 */
	protected String contentHint = CONTENT_HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSection() <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected static final String SECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSection() <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected String section = SECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.PROPERTY_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ToolingModelPackage.PROPERTY_DEFINITION__READ_ONLY,
					oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ToolingModelPackage.PROPERTY_DEFINITION__VISIBLE,
					oldVisible, visible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentHint() {
		return contentHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentHint(String newContentHint) {
		String oldContentHint = contentHint;
		contentHint = newContentHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ToolingModelPackage.PROPERTY_DEFINITION__CONTENT_HINT,
					oldContentHint, contentHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSection() {
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(String newSection) {
		String oldSection = section;
		section = newSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ToolingModelPackage.PROPERTY_DEFINITION__SECTION,
					oldSection, section));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ToolingModelPackage.PROPERTY_DEFINITION__READ_ONLY:
			return isReadOnly();
		case ToolingModelPackage.PROPERTY_DEFINITION__VISIBLE:
			return isVisible();
		case ToolingModelPackage.PROPERTY_DEFINITION__CONTENT_HINT:
			return getContentHint();
		case ToolingModelPackage.PROPERTY_DEFINITION__SECTION:
			return getSection();
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
		case ToolingModelPackage.PROPERTY_DEFINITION__READ_ONLY:
			setReadOnly((Boolean) newValue);
			return;
		case ToolingModelPackage.PROPERTY_DEFINITION__VISIBLE:
			setVisible((Boolean) newValue);
			return;
		case ToolingModelPackage.PROPERTY_DEFINITION__CONTENT_HINT:
			setContentHint((String) newValue);
			return;
		case ToolingModelPackage.PROPERTY_DEFINITION__SECTION:
			setSection((String) newValue);
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
		case ToolingModelPackage.PROPERTY_DEFINITION__READ_ONLY:
			setReadOnly(READ_ONLY_EDEFAULT);
			return;
		case ToolingModelPackage.PROPERTY_DEFINITION__VISIBLE:
			setVisible(VISIBLE_EDEFAULT);
			return;
		case ToolingModelPackage.PROPERTY_DEFINITION__CONTENT_HINT:
			setContentHint(CONTENT_HINT_EDEFAULT);
			return;
		case ToolingModelPackage.PROPERTY_DEFINITION__SECTION:
			setSection(SECTION_EDEFAULT);
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
		case ToolingModelPackage.PROPERTY_DEFINITION__READ_ONLY:
			return readOnly != READ_ONLY_EDEFAULT;
		case ToolingModelPackage.PROPERTY_DEFINITION__VISIBLE:
			return visible != VISIBLE_EDEFAULT;
		case ToolingModelPackage.PROPERTY_DEFINITION__CONTENT_HINT:
			return CONTENT_HINT_EDEFAULT == null ? contentHint != null
					: !CONTENT_HINT_EDEFAULT.equals(contentHint);
		case ToolingModelPackage.PROPERTY_DEFINITION__SECTION:
			return SECTION_EDEFAULT == null ? section != null
					: !SECTION_EDEFAULT.equals(section);
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
		result.append(" (readOnly: "); //$NON-NLS-1$
		result.append(readOnly);
		result.append(", visible: "); //$NON-NLS-1$
		result.append(visible);
		result.append(", contentHint: "); //$NON-NLS-1$
		result.append(contentHint);
		result.append(", section: "); //$NON-NLS-1$
		result.append(section);
		result.append(')');
		return result.toString();
	}

} //PropertyDefinitionImpl
