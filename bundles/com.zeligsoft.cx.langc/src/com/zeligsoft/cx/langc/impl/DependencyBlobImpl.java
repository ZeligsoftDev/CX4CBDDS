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
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.zeligsoft.cx.codegen.UserEditableRegion;
import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.DependencyBlob;
import com.zeligsoft.cx.langc.LangCPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Blob</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.DependencyBlobImpl#getText <em>Text</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.DependencyBlobImpl#getMarkerComment <em>Marker Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class DependencyBlobImpl extends DependencyImpl implements DependencyBlob {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarkerComment() <em>Marker Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkerComment()
	 * @generated
	 * @ordered
	 */
	protected static final String MARKER_COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMarkerComment() <em>Marker Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkerComment()
	 * @generated
	 * @ordered
	 */
	protected String markerComment = MARKER_COMMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyBlobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.DEPENDENCY_BLOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.DEPENDENCY_BLOB__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMarkerComment() {
		return markerComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkerComment(String newMarkerComment) {
		String oldMarkerComment = markerComment;
		markerComment = newMarkerComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.DEPENDENCY_BLOB__MARKER_COMMENT, oldMarkerComment, markerComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.DEPENDENCY_BLOB__TEXT:
				return getText();
			case LangCPackage.DEPENDENCY_BLOB__MARKER_COMMENT:
				return getMarkerComment();
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
			case LangCPackage.DEPENDENCY_BLOB__TEXT:
				setText((String)newValue);
				return;
			case LangCPackage.DEPENDENCY_BLOB__MARKER_COMMENT:
				setMarkerComment((String)newValue);
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
			case LangCPackage.DEPENDENCY_BLOB__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case LangCPackage.DEPENDENCY_BLOB__MARKER_COMMENT:
				setMarkerComment(MARKER_COMMENT_EDEFAULT);
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
			case LangCPackage.DEPENDENCY_BLOB__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case LangCPackage.DEPENDENCY_BLOB__MARKER_COMMENT:
				return MARKER_COMMENT_EDEFAULT == null ? markerComment != null : !MARKER_COMMENT_EDEFAULT.equals(markerComment);
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
		result.append(" (text: ");
		result.append(text);
		result.append(", markerComment: ");
		result.append(markerComment);
		result.append(')');
		return result.toString();
	}

	public boolean write(CodeWriter code) {

		boolean hasMarkerComment
			= this.markerComment != null
		   && this.markerComment.length() > 0;

		return ( ! hasMarkerComment || code.writeLn( this.markerComment ) )
			&& code.writeLn( getText().trim() )
			&& ( ! hasMarkerComment || code.writeLn( UserEditableRegion.userEditEnd() ) );
	}

} //DependencyBlobImpl
