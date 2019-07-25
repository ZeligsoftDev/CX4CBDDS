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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.BlockInitializer;
import com.zeligsoft.cx.langc.BuiltInType;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Pointer;
import com.zeligsoft.cx.langc.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.BlockInitializerImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockInitializerImpl extends ExpressionImpl implements BlockInitializer {
	/**
	 * The cached value of the '{@link #getExprs() <em>Exprs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> exprs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockInitializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.BLOCK_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExprs() {
		if (exprs == null) {
			exprs = new EObjectContainmentEList<Expression>(Expression.class, this, LangCPackage.BLOCK_INITIALIZER__EXPRS);
		}
		return exprs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.BLOCK_INITIALIZER__EXPRS:
				return ((InternalEList<?>)getExprs()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.BLOCK_INITIALIZER__EXPRS:
				return getExprs();
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
			case LangCPackage.BLOCK_INITIALIZER__EXPRS:
				getExprs().clear();
				getExprs().addAll((Collection<? extends Expression>)newValue);
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
			case LangCPackage.BLOCK_INITIALIZER__EXPRS:
				getExprs().clear();
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
			case LangCPackage.BLOCK_INITIALIZER__EXPRS:
				return exprs != null && !exprs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	private final static ElementReference voidPtrType = LangCFactory.eINSTANCE.createElementReference();
	static
	{
		BuiltInType voidBuiltIn = LangCFactory.eINSTANCE.createBuiltInType();
		voidBuiltIn.setType(PrimitiveType.VOID);
		voidPtrType.setElement(voidBuiltIn);
		voidPtrType.getPointerSpec().add(Pointer.CONST_POINTER);
	}

	private ElementReference type;

	@Override
	public ElementReference basicGetType() {
		if( type != null ) {
			if( getExprs() == null
			 || getExprs().size() <= 0 )
				type = voidPtrType;
			else {
				type = EcoreUtil.copy(getExprs().get(0).getType());
				type.getPointerSpec().add(Pointer.CONST_POINTER);
			}
		}

		return type;
	}

	@Override
	public boolean write(CodeWriter code) {
		if( ! code.openBrace() )
			return false;

		boolean first = true;
		for( Expression init : getExprs() )
		{
			if( first )
				first = false;
			else if( ! code.write( ',' )
				  || ! code.space() )
				return false;

			init.write( code );
		}

		return code.closeBrace( false );
	}

} //BlockInitializerImpl
