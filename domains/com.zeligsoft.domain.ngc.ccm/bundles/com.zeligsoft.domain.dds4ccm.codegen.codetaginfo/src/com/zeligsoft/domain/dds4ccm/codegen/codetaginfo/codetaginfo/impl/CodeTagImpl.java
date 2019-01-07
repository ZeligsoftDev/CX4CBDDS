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
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagContext;
import com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.CodeTagType;
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
 * An implementation of the model object '<em><b>Code Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getTag_begin <em>Tag begin</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getTag_end <em>Tag end</em>}</li>
 *   <li>{@link com.zeligsoft.domain.dds4ccm.codegen.codetaginfo.codetaginfo.impl.CodeTagImpl#getContextinfo <em>Contextinfo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeTagImpl extends EObjectImpl implements CodeTag {
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
    protected CodeTagImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return CodetaginfoPackage.Literals.CODE_TAG;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, CodetaginfoPackage.CODE_TAG__GROUP);
		}
		return group;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<String> getName() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__NAME);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUuid() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__UUID);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<CodeTagType> getType() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__TYPE);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTag_begin() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__TAG_BEGIN);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<String> getContents() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__CONTENTS);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTag_end() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__TAG_END);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<CodeTagContext> getContextinfo() {
		return getGroup().list(CodetaginfoPackage.Literals.CODE_TAG__CONTEXTINFO);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodetaginfoPackage.CODE_TAG__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case CodetaginfoPackage.CODE_TAG__CONTEXTINFO:
				return ((InternalEList<?>)getContextinfo()).basicRemove(otherEnd, msgs);
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
			case CodetaginfoPackage.CODE_TAG__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case CodetaginfoPackage.CODE_TAG__NAME:
				return getName();
			case CodetaginfoPackage.CODE_TAG__UUID:
				return getUuid();
			case CodetaginfoPackage.CODE_TAG__TYPE:
				return getType();
			case CodetaginfoPackage.CODE_TAG__TAG_BEGIN:
				return getTag_begin();
			case CodetaginfoPackage.CODE_TAG__CONTENTS:
				return getContents();
			case CodetaginfoPackage.CODE_TAG__TAG_END:
				return getTag_end();
			case CodetaginfoPackage.CODE_TAG__CONTEXTINFO:
				return getContextinfo();
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
			case CodetaginfoPackage.CODE_TAG__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__NAME:
				getName().clear();
				getName().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__UUID:
				getUuid().clear();
				getUuid().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends CodeTagType>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__TAG_BEGIN:
				getTag_begin().clear();
				getTag_begin().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__TAG_END:
				getTag_end().clear();
				getTag_end().addAll((Collection<? extends String>)newValue);
				return;
			case CodetaginfoPackage.CODE_TAG__CONTEXTINFO:
				getContextinfo().clear();
				getContextinfo().addAll((Collection<? extends CodeTagContext>)newValue);
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
			case CodetaginfoPackage.CODE_TAG__GROUP:
				getGroup().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__NAME:
				getName().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__UUID:
				getUuid().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__TYPE:
				getType().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__TAG_BEGIN:
				getTag_begin().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__CONTENTS:
				getContents().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__TAG_END:
				getTag_end().clear();
				return;
			case CodetaginfoPackage.CODE_TAG__CONTEXTINFO:
				getContextinfo().clear();
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
			case CodetaginfoPackage.CODE_TAG__GROUP:
				return group != null && !group.isEmpty();
			case CodetaginfoPackage.CODE_TAG__NAME:
				return !getName().isEmpty();
			case CodetaginfoPackage.CODE_TAG__UUID:
				return !getUuid().isEmpty();
			case CodetaginfoPackage.CODE_TAG__TYPE:
				return !getType().isEmpty();
			case CodetaginfoPackage.CODE_TAG__TAG_BEGIN:
				return !getTag_begin().isEmpty();
			case CodetaginfoPackage.CODE_TAG__CONTENTS:
				return !getContents().isEmpty();
			case CodetaginfoPackage.CODE_TAG__TAG_END:
				return !getTag_end().isEmpty();
			case CodetaginfoPackage.CODE_TAG__CONTEXTINFO:
				return !getContextinfo().isEmpty();
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

} //CodeTagImpl
