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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.Enumerator;
import com.zeligsoft.cx.langc.LangCPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.EnumImpl#getEnumerators <em>Enumerators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class EnumImpl extends NamedElementImpl implements com.zeligsoft.cx.langc.Enum {
	/**
	 * The cached value of the '{@link #getEnumerators() <em>Enumerators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerators()
	 * @generated
	 * @ordered
	 */
	protected EList<Enumerator> enumerators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.ENUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enumerator> getEnumerators() {
		if (enumerators == null) {
			enumerators = new EObjectContainmentEList<Enumerator>(Enumerator.class, this, LangCPackage.ENUM__ENUMERATORS);
		}
		return enumerators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.ENUM__ENUMERATORS:
				return ((InternalEList<?>)getEnumerators()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.ENUM__ENUMERATORS:
				return getEnumerators();
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
			case LangCPackage.ENUM__ENUMERATORS:
				getEnumerators().clear();
				getEnumerators().addAll((Collection<? extends Enumerator>)newValue);
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
			case LangCPackage.ENUM__ENUMERATORS:
				getEnumerators().clear();
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
			case LangCPackage.ENUM__ENUMERATORS:
				return enumerators != null && !enumerators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override protected boolean writeDefn(CodeWriter code) { return true; }

	@Override
	protected boolean writeDecl(CodeWriter code) {
		if( ! code.write( "enum " )
		 || ! code.write( getName().getName() )
		 || ! code.openBrace() )
			return false;

		boolean first = true;
		for( Enumerator enumerator : getEnumerators() )
		{
			if( first )
				first = false;
			else if( ! code.writeLn( ',' ) )
				return false;
			if( ! enumerator.write( code ) )
				return false;
		}

		return code.newline()
			&& code.closeBrace( false )
			&& code.terminate();
	}
} //EnumImpl
