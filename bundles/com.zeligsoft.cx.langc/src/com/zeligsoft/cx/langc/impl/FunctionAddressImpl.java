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
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionAddress;
import com.zeligsoft.cx.langc.FunctionPointer;
import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.NamedReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionAddressImpl#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionAddressImpl extends ExpressionImpl implements FunctionAddress {
	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Function function;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.FUNCTION_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject)function;
			function = (Function)eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LangCPackage.FUNCTION_ADDRESS__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		Function oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION_ADDRESS__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.FUNCTION_ADDRESS__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
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
			case LangCPackage.FUNCTION_ADDRESS__FUNCTION:
				setFunction((Function)newValue);
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
			case LangCPackage.FUNCTION_ADDRESS__FUNCTION:
				setFunction((Function)null);
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
			case LangCPackage.FUNCTION_ADDRESS__FUNCTION:
				return function != null;
		}
		return super.eIsSet(featureID);
	}

	private ElementReference element;

	@Override
	public ElementReference basicGetType() {
		if( element == null ) {
			FunctionPointer ptr = LangCFactory.eINSTANCE.createFunctionPointer();
			ptr.setReturnType(EcoreUtil.copy(getFunction().getReturnType()));
			for(NamedReference param : getFunction().getParameters())
				ptr.getParameters().add(param.getType());
		}

		return element;
	}

	@Override
	public boolean write(CodeWriter code) {
		return code.write( getFunction().getName().getName() );
	}

} //FunctionAddressImpl
