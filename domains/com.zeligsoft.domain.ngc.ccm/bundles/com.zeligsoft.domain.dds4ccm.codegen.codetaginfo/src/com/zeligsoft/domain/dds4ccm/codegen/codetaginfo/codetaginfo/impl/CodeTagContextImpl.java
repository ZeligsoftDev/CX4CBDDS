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

package com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl;

import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodetaginfoPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Tag Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl#getComponent_name <em>Component name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl#getClass_name <em>Class name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagContextImpl#getOperation_name <em>Operation name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeTagContextImpl extends EObjectImpl implements CodeTagContext {
    /**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
    protected FeatureMap group;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected CodeTagContextImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return CodetaginfoPackage.Literals.CODE_TAG_CONTEXT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, CodetaginfoPackage.CODE_TAG_CONTEXT__GROUP);
		}
		return group;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getComponent_name() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG_CONTEXT__COMPONENT_NAME);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getClass_name() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG_CONTEXT__CLASS_NAME);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOperation_name() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG_CONTEXT__OPERATION_NAME);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodetaginfoPackage.CODE_TAG_CONTEXT__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
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
			case CodetaginfoPackage.CODE_TAG_CONTEXT__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case CodetaginfoPackage.CODE_TAG_CONTEXT__COMPONENT_NAME:
				return getComponent_name();
			case CodetaginfoPackage.CODE_TAG_CONTEXT__CLASS_NAME:
				return getClass_name();
			case CodetaginfoPackage.CODE_TAG_CONTEXT__OPERATION_NAME:
				return getOperation_name();
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
			case CodetaginfoPackage.CODE_TAG_CONTEXT__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case CodetaginfoPackage.CODE_TAG_CONTEXT__COMPONENT_NAME:
				getComponent_name().clear();
				getComponent_name().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG_CONTEXT__CLASS_NAME:
				getClass_name().clear();
				getClass_name().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG_CONTEXT__OPERATION_NAME:
				getOperation_name().clear();
				getOperation_name().addAll((Collection<? extends String>)newValue);
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
			case CodetaginfoPackage.CODE_TAG_CONTEXT__GROUP:
				getGroup().clear();
				return;
			case CodetaginfoPackage.CODE_TAG_CONTEXT__COMPONENT_NAME:
				getComponent_name().clear();
				return;
			case CodetaginfoPackage.CODE_TAG_CONTEXT__CLASS_NAME:
				getClass_name().clear();
				return;
			case CodetaginfoPackage.CODE_TAG_CONTEXT__OPERATION_NAME:
				getOperation_name().clear();
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
			case CodetaginfoPackage.CODE_TAG_CONTEXT__GROUP:
				return group != null && !group.isEmpty();
			case CodetaginfoPackage.CODE_TAG_CONTEXT__COMPONENT_NAME:
				return !getComponent_name().isEmpty();
			case CodetaginfoPackage.CODE_TAG_CONTEXT__CLASS_NAME:
				return !getClass_name().isEmpty();
			case CodetaginfoPackage.CODE_TAG_CONTEXT__OPERATION_NAME:
				return !getOperation_name().isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(')');
		return result.toString();
	}

} //CodeTagContextImpl
