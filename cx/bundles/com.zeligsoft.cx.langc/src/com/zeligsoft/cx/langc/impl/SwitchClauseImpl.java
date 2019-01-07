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

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Statement;
import com.zeligsoft.cx.langc.SwitchClause;
import com.zeligsoft.cx.langc.VariableDeclarationStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.SwitchClauseImpl#isFallthrough <em>Fallthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class SwitchClauseImpl extends CodeBlockImpl implements SwitchClause {
	/**
	 * The default value of the '{@link #isFallthrough() <em>Fallthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFallthrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FALLTHROUGH_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isFallthrough() <em>Fallthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFallthrough()
	 * @generated
	 * @ordered
	 */
	protected boolean fallthrough = FALLTHROUGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.SWITCH_CLAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFallthrough() {
		return fallthrough;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFallthrough(boolean newFallthrough) {
		boolean oldFallthrough = fallthrough;
		fallthrough = newFallthrough;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.SWITCH_CLAUSE__FALLTHROUGH, oldFallthrough, fallthrough));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.SWITCH_CLAUSE__FALLTHROUGH:
				return isFallthrough() ? Boolean.TRUE : Boolean.FALSE;
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
			case LangCPackage.SWITCH_CLAUSE__FALLTHROUGH:
				setFallthrough(((Boolean)newValue).booleanValue());
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
			case LangCPackage.SWITCH_CLAUSE__FALLTHROUGH:
				setFallthrough(FALLTHROUGH_EDEFAULT);
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
			case LangCPackage.SWITCH_CLAUSE__FALLTHROUGH:
				return fallthrough != FALLTHROUGH_EDEFAULT;
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
		result.append(" (fallthrough: ");
		result.append(fallthrough);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isForceBraces() {
		if( super.isForceBraces() )
			return true;

		// otherwise the clause only needs braces if it declares variables
		for( Statement stmt : getStatements() )
			if( stmt instanceof VariableDeclarationStatement )
				return true;
		return false;
	}

	protected boolean writeLabels( CodeWriter code )
	{
		return code.decIndent()
			&& code.writeLn( "default:" ) //$NON-NLS-1$
			&& code.incIndent();
	}

	@Override
	public boolean write(CodeWriter code)
	{
		if( ! writeLabels( code ) )
			return false;

		return code.decIndent()
			&& super.write( code )
			&& code.incIndent();
	}

} //SwitchClauseImpl
