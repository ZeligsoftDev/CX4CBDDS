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
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.CVQualifier;
import com.zeligsoft.cx.langc.Element;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Pointer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementReferenceImpl#getElement <em>Element</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementReferenceImpl#getCvQualifier <em>Cv Qualifier</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementReferenceImpl#getPointerSpec <em>Pointer Spec</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementReferenceImpl#getArrayBounds <em>Array Bounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class ElementReferenceImpl extends BindableValueImpl implements ElementReference {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Element element;

	/**
	 * The default value of the '{@link #getCvQualifier() <em>Cv Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final CVQualifier CV_QUALIFIER_EDEFAULT = CVQualifier.UNQUALIFIED;

	/**
	 * The cached value of the '{@link #getCvQualifier() <em>Cv Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCvQualifier()
	 * @generated
	 * @ordered
	 */
	protected CVQualifier cvQualifier = CV_QUALIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPointerSpec() <em>Pointer Spec</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointerSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<Pointer> pointerSpec;

	/**
	 * The cached value of the '{@link #getArrayBounds() <em>Array Bounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayBounds()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> arrayBounds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (Element)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LangCPackage.ELEMENT_REFERENCE__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement) {
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_REFERENCE__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVQualifier getCvQualifier() {
		return cvQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCvQualifier(CVQualifier newCvQualifier) {
		CVQualifier oldCvQualifier = cvQualifier;
		cvQualifier = newCvQualifier == null ? CV_QUALIFIER_EDEFAULT : newCvQualifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_REFERENCE__CV_QUALIFIER, oldCvQualifier, cvQualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pointer> getPointerSpec() {
		if (pointerSpec == null) {
			pointerSpec = new EDataTypeEList<Pointer>(Pointer.class, this, LangCPackage.ELEMENT_REFERENCE__POINTER_SPEC);
		}
		return pointerSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getArrayBounds() {
		if (arrayBounds == null) {
			arrayBounds = new EObjectContainmentEList<Expression>(Expression.class, this, LangCPackage.ELEMENT_REFERENCE__ARRAY_BOUNDS);
		}
		return arrayBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.ELEMENT_REFERENCE__ARRAY_BOUNDS:
				return ((InternalEList<?>)getArrayBounds()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.ELEMENT_REFERENCE__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case LangCPackage.ELEMENT_REFERENCE__CV_QUALIFIER:
				return getCvQualifier();
			case LangCPackage.ELEMENT_REFERENCE__POINTER_SPEC:
				return getPointerSpec();
			case LangCPackage.ELEMENT_REFERENCE__ARRAY_BOUNDS:
				return getArrayBounds();
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
			case LangCPackage.ELEMENT_REFERENCE__ELEMENT:
				setElement((Element)newValue);
				return;
			case LangCPackage.ELEMENT_REFERENCE__CV_QUALIFIER:
				setCvQualifier((CVQualifier)newValue);
				return;
			case LangCPackage.ELEMENT_REFERENCE__POINTER_SPEC:
				getPointerSpec().clear();
				getPointerSpec().addAll((Collection<? extends Pointer>)newValue);
				return;
			case LangCPackage.ELEMENT_REFERENCE__ARRAY_BOUNDS:
				getArrayBounds().clear();
				getArrayBounds().addAll((Collection<? extends Expression>)newValue);
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
			case LangCPackage.ELEMENT_REFERENCE__ELEMENT:
				setElement((Element)null);
				return;
			case LangCPackage.ELEMENT_REFERENCE__CV_QUALIFIER:
				setCvQualifier(CV_QUALIFIER_EDEFAULT);
				return;
			case LangCPackage.ELEMENT_REFERENCE__POINTER_SPEC:
				getPointerSpec().clear();
				return;
			case LangCPackage.ELEMENT_REFERENCE__ARRAY_BOUNDS:
				getArrayBounds().clear();
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
			case LangCPackage.ELEMENT_REFERENCE__ELEMENT:
				return element != null;
			case LangCPackage.ELEMENT_REFERENCE__CV_QUALIFIER:
				return cvQualifier != CV_QUALIFIER_EDEFAULT;
			case LangCPackage.ELEMENT_REFERENCE__POINTER_SPEC:
				return pointerSpec != null && !pointerSpec.isEmpty();
			case LangCPackage.ELEMENT_REFERENCE__ARRAY_BOUNDS:
				return arrayBounds != null && !arrayBounds.isEmpty();
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
		result.append(" (cvQualifier: ");
		result.append(cvQualifier);
		result.append(", pointerSpec: ");
		result.append(pointerSpec);
		result.append(')');
		return result.toString();
	}

	public boolean write(CodeWriter code, String name) {
		CVQualifier cvQual = getCvQualifier();
		if( cvQual != CVQualifier.UNQUALIFIED
		 && ( ! cvQual.write( code )
		   || ! code.space() ) )
			return false;
		return getElement().write(code, name, getPointerSpec(), getArrayBounds());
	}
} //ElementReferenceImpl
