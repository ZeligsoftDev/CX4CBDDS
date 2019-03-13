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
package com.zeligsoft.cx.langc.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.langc.FolderName;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.LinkableArtifact;
import com.zeligsoft.cx.langc.SubSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SystemImpl#getSubSystems <em>Sub Systems</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SystemImpl#getPublicFolders <em>Public Folders</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SystemImpl#getArtifacts <em>Artifacts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EObjectImpl implements com.zeligsoft.cx.langc.System {
	/**
	 * The cached value of the '{@link #getSubSystems() <em>Sub Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<SubSystem> subSystems;

	/**
	 * The cached value of the '{@link #getPublicFolders() <em>Public Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<FolderName> publicFolders;

	/**
	 * The cached value of the '{@link #getArtifacts() <em>Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkableArtifact> artifacts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubSystem> getSubSystems() {
		if (subSystems == null) {
			subSystems = new EObjectContainmentEList<SubSystem>(SubSystem.class, this, LangCPackage.SYSTEM__SUB_SYSTEMS);
		}
		return subSystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FolderName> getPublicFolders() {
		if (publicFolders == null) {
			publicFolders = new EObjectContainmentEList<FolderName>(FolderName.class, this, LangCPackage.SYSTEM__PUBLIC_FOLDERS);
		}
		return publicFolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LinkableArtifact> getArtifacts() {
		if (artifacts == null) {
			artifacts = new EObjectContainmentEList<LinkableArtifact>(LinkableArtifact.class, this, LangCPackage.SYSTEM__ARTIFACTS);
		}
		return artifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.SYSTEM__SUB_SYSTEMS:
				return ((InternalEList<?>)getSubSystems()).basicRemove(otherEnd, msgs);
			case LangCPackage.SYSTEM__PUBLIC_FOLDERS:
				return ((InternalEList<?>)getPublicFolders()).basicRemove(otherEnd, msgs);
			case LangCPackage.SYSTEM__ARTIFACTS:
				return ((InternalEList<?>)getArtifacts()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.SYSTEM__SUB_SYSTEMS:
				return getSubSystems();
			case LangCPackage.SYSTEM__PUBLIC_FOLDERS:
				return getPublicFolders();
			case LangCPackage.SYSTEM__ARTIFACTS:
				return getArtifacts();
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
			case LangCPackage.SYSTEM__SUB_SYSTEMS:
				getSubSystems().clear();
				getSubSystems().addAll((Collection<? extends SubSystem>)newValue);
				return;
			case LangCPackage.SYSTEM__PUBLIC_FOLDERS:
				getPublicFolders().clear();
				getPublicFolders().addAll((Collection<? extends FolderName>)newValue);
				return;
			case LangCPackage.SYSTEM__ARTIFACTS:
				getArtifacts().clear();
				getArtifacts().addAll((Collection<? extends LinkableArtifact>)newValue);
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
			case LangCPackage.SYSTEM__SUB_SYSTEMS:
				getSubSystems().clear();
				return;
			case LangCPackage.SYSTEM__PUBLIC_FOLDERS:
				getPublicFolders().clear();
				return;
			case LangCPackage.SYSTEM__ARTIFACTS:
				getArtifacts().clear();
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
			case LangCPackage.SYSTEM__SUB_SYSTEMS:
				return subSystems != null && !subSystems.isEmpty();
			case LangCPackage.SYSTEM__PUBLIC_FOLDERS:
				return publicFolders != null && !publicFolders.isEmpty();
			case LangCPackage.SYSTEM__ARTIFACTS:
				return artifacts != null && !artifacts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl
