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
package com.zeligsoft.base.langc.impl;

import com.zeligsoft.base.langc.FolderName;
import com.zeligsoft.base.langc.FunctionImplementation;
import com.zeligsoft.base.langc.LangCPackage;
import com.zeligsoft.base.langc.LinkableArtifact;
import com.zeligsoft.base.langc.UserElement;
import com.zeligsoft.base.langc.NamedElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linkable Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.impl.LinkableArtifactImpl#getRootElements <em>Root Elements</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.LinkableArtifactImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.LinkableArtifactImpl#getFunctionImplementations <em>Function Implementations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkableArtifactImpl extends EObjectImpl implements LinkableArtifact {
	/**
	 * The cached value of the '{@link #getRootElements() <em>Root Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UserElement> rootElements;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFunctionImplementations() <em>Function Implementations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionImplementation> functionImplementations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkableArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.LINKABLE_ARTIFACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserElement> getRootElements() {
		if (rootElements == null) {
			rootElements = new EObjectResolvingEList<UserElement>(UserElement.class, this, LangCPackage.LINKABLE_ARTIFACT__ROOT_ELEMENTS);
		}
		return rootElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.LINKABLE_ARTIFACT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionImplementation> getFunctionImplementations() {
		if (functionImplementations == null) {
			functionImplementations = new EObjectResolvingEList<FunctionImplementation>(FunctionImplementation.class, this, LangCPackage.LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS);
		}
		return functionImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.LINKABLE_ARTIFACT__ROOT_ELEMENTS:
				return getRootElements();
			case LangCPackage.LINKABLE_ARTIFACT__NAME:
				return getName();
			case LangCPackage.LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS:
				return getFunctionImplementations();
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
			case LangCPackage.LINKABLE_ARTIFACT__ROOT_ELEMENTS:
				getRootElements().clear();
				getRootElements().addAll((Collection<? extends UserElement>)newValue);
				return;
			case LangCPackage.LINKABLE_ARTIFACT__NAME:
				setName((String)newValue);
				return;
			case LangCPackage.LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS:
				getFunctionImplementations().clear();
				getFunctionImplementations().addAll((Collection<? extends FunctionImplementation>)newValue);
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
			case LangCPackage.LINKABLE_ARTIFACT__ROOT_ELEMENTS:
				getRootElements().clear();
				return;
			case LangCPackage.LINKABLE_ARTIFACT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LangCPackage.LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS:
				getFunctionImplementations().clear();
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
			case LangCPackage.LINKABLE_ARTIFACT__ROOT_ELEMENTS:
				return rootElements != null && !rootElements.isEmpty();
			case LangCPackage.LINKABLE_ARTIFACT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LangCPackage.LINKABLE_ARTIFACT__FUNCTION_IMPLEMENTATIONS:
				return functionImplementations != null && !functionImplementations.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LinkableArtifactImpl
