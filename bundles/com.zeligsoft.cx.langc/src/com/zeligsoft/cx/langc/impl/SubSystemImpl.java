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

import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.FolderName;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.SubSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SubSystemImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SubSystemImpl#getFolders <em>Folders</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SubSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SubSystemImpl#getPublicFolders <em>Public Folders</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class SubSystemImpl extends EObjectImpl implements SubSystem {
	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementList> files;

	/**
	 * The cached value of the '{@link #getFolders() <em>Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<FolderName> folders;

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
	 * The cached value of the '{@link #getPublicFolders() <em>Public Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<FolderName> publicFolders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.SUB_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementList> getFiles() {
		if (files == null) {
			files = new EObjectResolvingEList<ElementList>(ElementList.class, this, LangCPackage.SUB_SYSTEM__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FolderName> getFolders() {
		if (folders == null) {
			folders = new EObjectContainmentEList<FolderName>(FolderName.class, this, LangCPackage.SUB_SYSTEM__FOLDERS);
		}
		return folders;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.SUB_SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FolderName> getPublicFolders() {
		if (publicFolders == null) {
			publicFolders = new EObjectContainmentEList<FolderName>(FolderName.class, this, LangCPackage.SUB_SYSTEM__PUBLIC_FOLDERS);
		}
		return publicFolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.SUB_SYSTEM__FOLDERS:
				return ((InternalEList<?>)getFolders()).basicRemove(otherEnd, msgs);
			case LangCPackage.SUB_SYSTEM__PUBLIC_FOLDERS:
				return ((InternalEList<?>)getPublicFolders()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.SUB_SYSTEM__FILES:
				return getFiles();
			case LangCPackage.SUB_SYSTEM__FOLDERS:
				return getFolders();
			case LangCPackage.SUB_SYSTEM__NAME:
				return getName();
			case LangCPackage.SUB_SYSTEM__PUBLIC_FOLDERS:
				return getPublicFolders();
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
			case LangCPackage.SUB_SYSTEM__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends ElementList>)newValue);
				return;
			case LangCPackage.SUB_SYSTEM__FOLDERS:
				getFolders().clear();
				getFolders().addAll((Collection<? extends FolderName>)newValue);
				return;
			case LangCPackage.SUB_SYSTEM__NAME:
				setName((String)newValue);
				return;
			case LangCPackage.SUB_SYSTEM__PUBLIC_FOLDERS:
				getPublicFolders().clear();
				getPublicFolders().addAll((Collection<? extends FolderName>)newValue);
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
			case LangCPackage.SUB_SYSTEM__FILES:
				getFiles().clear();
				return;
			case LangCPackage.SUB_SYSTEM__FOLDERS:
				getFolders().clear();
				return;
			case LangCPackage.SUB_SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LangCPackage.SUB_SYSTEM__PUBLIC_FOLDERS:
				getPublicFolders().clear();
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
			case LangCPackage.SUB_SYSTEM__FILES:
				return files != null && !files.isEmpty();
			case LangCPackage.SUB_SYSTEM__FOLDERS:
				return folders != null && !folders.isEmpty();
			case LangCPackage.SUB_SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LangCPackage.SUB_SYSTEM__PUBLIC_FOLDERS:
				return publicFolders != null && !publicFolders.isEmpty();
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

} //SubSystemImpl
