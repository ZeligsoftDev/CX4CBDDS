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
package com.zeligsoft.base.langc.impl;

import org.eclipse.emf.ecore.EClass;

import com.zeligsoft.base.langc.BuiltInType;
import com.zeligsoft.base.langc.ElementReference;
import com.zeligsoft.base.langc.LangCFactory;
import com.zeligsoft.base.langc.LangCPackage;
import com.zeligsoft.base.langc.Literal;
import com.zeligsoft.base.langc.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.impl.LiteralImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LiteralImpl extends ExpressionImpl implements Literal {
	/**
	 * The default value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected static final PrimitiveType PRIMITIVE_TYPE_EDEFAULT = PrimitiveType.INT8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getPrimitiveType() {
		// TODO: implement this method to return the 'Primitive Type' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.LITERAL__PRIMITIVE_TYPE:
				return getPrimitiveType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LangCPackage.LITERAL__PRIMITIVE_TYPE:
				return getPrimitiveType() != PRIMITIVE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	private ElementReference builtInType;

	@Override
	public ElementReference basicGetType() {
		if(this.builtInType == null) {
			BuiltInType bit = LangCFactory.eINSTANCE.createBuiltInType();
			bit.setType(getPrimitiveType());

			this.builtInType = LangCFactory.eINSTANCE.createElementReference();
			this.builtInType.setElement(bit);
		}

		return this.builtInType;
	}

} //LiteralImpl
