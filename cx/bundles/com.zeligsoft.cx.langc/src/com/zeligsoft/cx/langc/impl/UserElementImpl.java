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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.ElementKind;
import com.zeligsoft.cx.langc.FileName;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.UserElement;
import com.zeligsoft.cx.langc.m2t.CWriter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.UserElementImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.UserElementImpl#getDefn <em>Defn</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public abstract class UserElementImpl extends ElementImpl implements UserElement {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ElementKind KIND_EDEFAULT = ElementKind.DEFAULT;
	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ElementKind kind = KIND_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDefn() <em>Defn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefn()
	 * @generated
	 * @ordered
	 */
	protected FileName defn;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.USER_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ElementKind newKind) {
		ElementKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.USER_ELEMENT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileName getDefn() {
		if (defn != null && defn.eIsProxy()) {
			InternalEObject oldDefn = (InternalEObject)defn;
			defn = (FileName)eResolveProxy(oldDefn);
			if (defn != oldDefn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LangCPackage.USER_ELEMENT__DEFN, oldDefn, defn));
			}
		}
		return defn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileName basicGetDefn() {
		return defn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefn(FileName newDefn) {
		FileName oldDefn = defn;
		defn = newDefn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.USER_ELEMENT__DEFN, oldDefn, defn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.USER_ELEMENT__KIND:
				return getKind();
			case LangCPackage.USER_ELEMENT__DEFN:
				if (resolve) return getDefn();
				return basicGetDefn();
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
			case LangCPackage.USER_ELEMENT__KIND:
				setKind((ElementKind)newValue);
				return;
			case LangCPackage.USER_ELEMENT__DEFN:
				setDefn((FileName)newValue);
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
			case LangCPackage.USER_ELEMENT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case LangCPackage.USER_ELEMENT__DEFN:
				setDefn((FileName)null);
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
			case LangCPackage.USER_ELEMENT__KIND:
				return kind != KIND_EDEFAULT;
			case LangCPackage.USER_ELEMENT__DEFN:
				return defn != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

	protected boolean writeDecl(CodeWriter code) { return false; }
	protected boolean writeDefn(CodeWriter code) { return false; }

	public boolean write(CWriter writer) {

		switch(getKind()) {
		case HEADER_ONLY:
			return writeDefn(writer.decl());
		case IMPL_ONLY:
			return writeDefn(writer.defn());
		default:
			return writeDecl(writer.decl())
				&& writeDefn(writer.defn());
		}
	}

} //UserElementImpl
