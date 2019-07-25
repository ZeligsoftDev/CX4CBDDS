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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.FunctionPointer;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Pointer;
import com.zeligsoft.cx.langc.m2t.CWriter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Pointer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionPointerImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionPointerImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class FunctionPointerImpl extends UserElementImpl implements FunctionPointer {
	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected ElementReference returnType;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementReference> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionPointerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.FUNCTION_POINTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(ElementReference newReturnType, NotificationChain msgs) {
		ElementReference oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION_POINTER__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(ElementReference newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION_POINTER__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION_POINTER__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION_POINTER__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementReference> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ElementReference>(ElementReference.class, this, LangCPackage.FUNCTION_POINTER__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.FUNCTION_POINTER__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case LangCPackage.FUNCTION_POINTER__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.FUNCTION_POINTER__RETURN_TYPE:
				return getReturnType();
			case LangCPackage.FUNCTION_POINTER__PARAMETERS:
				return getParameters();
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
			case LangCPackage.FUNCTION_POINTER__RETURN_TYPE:
				setReturnType((ElementReference)newValue);
				return;
			case LangCPackage.FUNCTION_POINTER__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ElementReference>)newValue);
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
			case LangCPackage.FUNCTION_POINTER__RETURN_TYPE:
				setReturnType((ElementReference)null);
				return;
			case LangCPackage.FUNCTION_POINTER__PARAMETERS:
				getParameters().clear();
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
			case LangCPackage.FUNCTION_POINTER__RETURN_TYPE:
				return returnType != null;
			case LangCPackage.FUNCTION_POINTER__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean write(CWriter writer) {
		return false;
	}

	public boolean write(CodeWriter code, String name, List<Pointer> pointerSpec, List<Expression> arrayBounds) {
		if( ! getReturnType().write( code, null )
		 || ! code.write( "(*" )
		 || ! writePointerSpec(code, pointerSpec)
		 || ! code.space()
		 || ! writeArrayBounds(code, arrayBounds)
		 || ! code.write( ")( " ) )
			return false;

		for( ElementReference elementRef : getParameters() )
			if( ! elementRef.write( code, name ) )
				return false;

		return code.write( ')' );
	}

} //FunctionPointerImpl
