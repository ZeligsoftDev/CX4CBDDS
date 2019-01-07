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

import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTag;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagInfo;
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
 * An implementation of the model object '<em><b>Code Tag Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagInfoImpl#getCodetag <em>Codetag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeTagInfoImpl extends EObjectImpl implements CodeTagInfo {
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
    protected CodeTagInfoImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return CodetaginfoPackage.Literals.CODE_TAG_INFO;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, CodetaginfoPackage.CODE_TAG_INFO__GROUP);
		}
		return group;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<String> getFilename() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG_INFO__FILENAME);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<CodeTag> getCodetag() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG_INFO__CODETAG);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodetaginfoPackage.CODE_TAG_INFO__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case CodetaginfoPackage.CODE_TAG_INFO__CODETAG:
				return ((InternalEList<?>)getCodetag()).basicRemove(otherEnd, msgs);
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
			case CodetaginfoPackage.CODE_TAG_INFO__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case CodetaginfoPackage.CODE_TAG_INFO__FILENAME:
				return getFilename();
			case CodetaginfoPackage.CODE_TAG_INFO__CODETAG:
				return getCodetag();
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
			case CodetaginfoPackage.CODE_TAG_INFO__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case CodetaginfoPackage.CODE_TAG_INFO__FILENAME:
				getFilename().clear();
				getFilename().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG_INFO__CODETAG:
				getCodetag().clear();
				getCodetag().addAll((Collection<? extends CodeTag>)newValue);
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
			case CodetaginfoPackage.CODE_TAG_INFO__GROUP:
				getGroup().clear();
				return;
			case CodetaginfoPackage.CODE_TAG_INFO__FILENAME:
				getFilename().clear();
				return;
			case CodetaginfoPackage.CODE_TAG_INFO__CODETAG:
				getCodetag().clear();
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
			case CodetaginfoPackage.CODE_TAG_INFO__GROUP:
				return group != null && !group.isEmpty();
			case CodetaginfoPackage.CODE_TAG_INFO__FILENAME:
				return !getFilename().isEmpty();
			case CodetaginfoPackage.CODE_TAG_INFO__CODETAG:
				return !getCodetag().isEmpty();
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

} //CodeTagInfoImpl
