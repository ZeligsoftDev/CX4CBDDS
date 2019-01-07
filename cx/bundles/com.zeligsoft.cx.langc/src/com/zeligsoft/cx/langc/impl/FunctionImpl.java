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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Function;
import com.zeligsoft.cx.langc.FunctionImplementation;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.LinkageSpec;
import com.zeligsoft.cx.langc.NamedReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionImpl#getLinkage <em>Linkage</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.FunctionImpl#getDefaultImpl <em>Default Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class FunctionImpl extends NamedElementImpl implements Function {
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
	protected EList<NamedReference> parameters;

	/**
	 * The default value of the '{@link #getLinkage() <em>Linkage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkage()
	 * @generated
	 * @ordered
	 */
	protected static final LinkageSpec LINKAGE_EDEFAULT = LinkageSpec.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getLinkage() <em>Linkage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkage()
	 * @generated
	 * @ordered
	 */
	protected LinkageSpec linkage = LINKAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultImpl() <em>Default Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultImpl()
	 * @generated
	 * @ordered
	 */
	protected FunctionImplementation defaultImpl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.FUNCTION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION__RETURN_TYPE, oldReturnType, newReturnType);
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
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedReference> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<NamedReference>(NamedReference.class, this, LangCPackage.FUNCTION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkageSpec getLinkage() {
		return linkage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkage(LinkageSpec newLinkage) {
		LinkageSpec oldLinkage = linkage;
		linkage = newLinkage == null ? LINKAGE_EDEFAULT : newLinkage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION__LINKAGE, oldLinkage, linkage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionImplementation getDefaultImpl() {
		return defaultImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultImpl(FunctionImplementation newDefaultImpl, NotificationChain msgs) {
		FunctionImplementation oldDefaultImpl = defaultImpl;
		defaultImpl = newDefaultImpl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION__DEFAULT_IMPL, oldDefaultImpl, newDefaultImpl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultImpl(FunctionImplementation newDefaultImpl) {
		if (newDefaultImpl != defaultImpl) {
			NotificationChain msgs = null;
			if (defaultImpl != null)
				msgs = ((InternalEObject)defaultImpl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION__DEFAULT_IMPL, null, msgs);
			if (newDefaultImpl != null)
				msgs = ((InternalEObject)newDefaultImpl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.FUNCTION__DEFAULT_IMPL, null, msgs);
			msgs = basicSetDefaultImpl(newDefaultImpl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.FUNCTION__DEFAULT_IMPL, newDefaultImpl, newDefaultImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.FUNCTION__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case LangCPackage.FUNCTION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case LangCPackage.FUNCTION__DEFAULT_IMPL:
				return basicSetDefaultImpl(null, msgs);
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
			case LangCPackage.FUNCTION__RETURN_TYPE:
				return getReturnType();
			case LangCPackage.FUNCTION__PARAMETERS:
				return getParameters();
			case LangCPackage.FUNCTION__LINKAGE:
				return getLinkage();
			case LangCPackage.FUNCTION__DEFAULT_IMPL:
				return getDefaultImpl();
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
			case LangCPackage.FUNCTION__RETURN_TYPE:
				setReturnType((ElementReference)newValue);
				return;
			case LangCPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends NamedReference>)newValue);
				return;
			case LangCPackage.FUNCTION__LINKAGE:
				setLinkage((LinkageSpec)newValue);
				return;
			case LangCPackage.FUNCTION__DEFAULT_IMPL:
				setDefaultImpl((FunctionImplementation)newValue);
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
			case LangCPackage.FUNCTION__RETURN_TYPE:
				setReturnType((ElementReference)null);
				return;
			case LangCPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				return;
			case LangCPackage.FUNCTION__LINKAGE:
				setLinkage(LINKAGE_EDEFAULT);
				return;
			case LangCPackage.FUNCTION__DEFAULT_IMPL:
				setDefaultImpl((FunctionImplementation)null);
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
			case LangCPackage.FUNCTION__RETURN_TYPE:
				return returnType != null;
			case LangCPackage.FUNCTION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case LangCPackage.FUNCTION__LINKAGE:
				return linkage != LINKAGE_EDEFAULT;
			case LangCPackage.FUNCTION__DEFAULT_IMPL:
				return defaultImpl != null;
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
		result.append(" (linkage: ");
		result.append(linkage);
		result.append(')');
		return result.toString();
	}

	@Override
	protected boolean writeDecl(CodeWriter code) {
		if( ! getLinkage().write(code, true)
		 || ! code.space()
		 || ! getReturnType().write(code, null)
		 || ! code.space()
		 || ! code.write( getName().getName() )
		 || ! code.write( '(' ) )
			return false;

		if( ! getParameters().isEmpty() )
		{
			if( ! code.space() )
				return false;

			boolean first = true;
			for( NamedReference param : getParameters() )
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

		return code.write( ");" )
			&& code.newline();
	}

	@Override
	protected boolean writeDefn(CodeWriter code) {
		return true;
	}

} //FunctionImpl
