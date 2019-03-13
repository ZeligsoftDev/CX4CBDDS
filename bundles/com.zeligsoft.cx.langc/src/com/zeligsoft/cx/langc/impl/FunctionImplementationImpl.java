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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.CodeBlock;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionImplementation;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.NamedReference;
import com.zeligsoft.cx.langc.Pointer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionImplementationImpl#getBody <em>Body</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionImplementationImpl#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class FunctionImplementationImpl extends UserElementImpl implements FunctionImplementation {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock body;

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
	protected FunctionImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.FUNCTION_IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(CodeBlock newBody, NotificationChain msgs) {
		CodeBlock oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION_IMPLEMENTATION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(CodeBlock newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION_IMPLEMENTATION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION_IMPLEMENTATION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION_IMPLEMENTATION__BODY, newBody, newBody));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LangCPackage.FUNCTION_IMPLEMENTATION__FUNCTION, oldFunction, function));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION_IMPLEMENTATION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.FUNCTION_IMPLEMENTATION__BODY:
				return basicSetBody(null, msgs);
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
			case LangCPackage.FUNCTION_IMPLEMENTATION__BODY:
				return getBody();
			case LangCPackage.FUNCTION_IMPLEMENTATION__FUNCTION:
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
			case LangCPackage.FUNCTION_IMPLEMENTATION__BODY:
				setBody((CodeBlock)newValue);
				return;
			case LangCPackage.FUNCTION_IMPLEMENTATION__FUNCTION:
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
			case LangCPackage.FUNCTION_IMPLEMENTATION__BODY:
				setBody((CodeBlock)null);
				return;
			case LangCPackage.FUNCTION_IMPLEMENTATION__FUNCTION:
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
			case LangCPackage.FUNCTION_IMPLEMENTATION__BODY:
				return body != null;
			case LangCPackage.FUNCTION_IMPLEMENTATION__FUNCTION:
				return function != null;
		}
		return super.eIsSet(featureID);
	}

	public boolean write(CodeWriter code, String name, List<Pointer> pointerSpec, List<Expression> arrayBounds) {
		return false;
	}

	@Override
	protected boolean writeDecl(CodeWriter code) {
		return true;
	}

	@Override
	protected boolean writeDefn(CodeWriter code) {

		if( ! code.newline()
		 || ! getFunction().getLinkage().write(code, false)
		 || ! code.space()
		 || ! getFunction().getReturnType().write(code, null)
		 || ! code.space()
		 || ! code.write( getFunction().getName().getName() )
		 || ! code.write( '(' ) )
			return false;

		if( ! getFunction().getParameters().isEmpty() )
		{
			if( ! code.space() )
				return false;

			boolean first = true;
			for( NamedReference param : getFunction().getParameters() )
			{
				if( ! first )
					code.write( ", " );
				else
					first = false;
	
				param.write( code );
			}

			if( ! code.space() )
				return false;
		}

		if( ! code.write( ')' ) )
			return false;

		return getBody().write( code );
	}

} //FunctionImplementationImpl
