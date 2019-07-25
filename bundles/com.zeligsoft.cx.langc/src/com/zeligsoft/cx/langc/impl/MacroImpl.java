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

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Macro;
import com.zeligsoft.cx.langc.Name;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Macro</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.MacroImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.MacroImpl#getReplacement <em>Replacement</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.MacroImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class MacroImpl extends DirectiveImpl implements Macro {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Name> parameters;

	/**
	 * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacement()
	 * @generated
	 * @ordered
	 */
	protected Expression replacement;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Name name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MacroImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.MACRO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Name> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Name>(Name.class, this, LangCPackage.MACRO__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getReplacement() {
		return replacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplacement(Expression newReplacement, NotificationChain msgs) {
		Expression oldReplacement = replacement;
		replacement = newReplacement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.MACRO__REPLACEMENT, oldReplacement, newReplacement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacement(Expression newReplacement) {
		if (newReplacement != replacement) {
			NotificationChain msgs = null;
			if (replacement != null)
				msgs = ((InternalEObject)replacement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.MACRO__REPLACEMENT, null, msgs);
			if (newReplacement != null)
				msgs = ((InternalEObject)newReplacement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.MACRO__REPLACEMENT, null, msgs);
			msgs = basicSetReplacement(newReplacement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.MACRO__REPLACEMENT, newReplacement, newReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(Name newName, NotificationChain msgs) {
		Name oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.MACRO__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Name newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.MACRO__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.MACRO__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.MACRO__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.MACRO__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case LangCPackage.MACRO__REPLACEMENT:
				return basicSetReplacement(null, msgs);
			case LangCPackage.MACRO__NAME:
				return basicSetName(null, msgs);
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
			case LangCPackage.MACRO__PARAMETERS:
				return getParameters();
			case LangCPackage.MACRO__REPLACEMENT:
				return getReplacement();
			case LangCPackage.MACRO__NAME:
				return getName();
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
			case LangCPackage.MACRO__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Name>)newValue);
				return;
			case LangCPackage.MACRO__REPLACEMENT:
				setReplacement((Expression)newValue);
				return;
			case LangCPackage.MACRO__NAME:
				setName((Name)newValue);
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
			case LangCPackage.MACRO__PARAMETERS:
				getParameters().clear();
				return;
			case LangCPackage.MACRO__REPLACEMENT:
				setReplacement((Expression)null);
				return;
			case LangCPackage.MACRO__NAME:
				setName((Name)null);
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
			case LangCPackage.MACRO__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case LangCPackage.MACRO__REPLACEMENT:
				return replacement != null;
			case LangCPackage.MACRO__NAME:
				return name != null;
		}
		return super.eIsSet(featureID);
	}

	public boolean write(CodeWriter code) {

		if( ! code.write( "#define " )
		 || ! code.write( getName().getName() ) )
			return false;

		if( getParameters() != null
		 && getParameters().size() > 0 )
		{
			code.write( "( " );
			boolean first = true;
			for( Name param : getParameters() )
			{
				if( first )
					first = false;
				else if( ! code.write( ", " ) )
					return false;
				code.write( param.getName() );
			}
			code.write( " )" );
		}

		if( getReplacement() != null )
		{
			if( ! code.space()
			 || ! getReplacement().write( code ) )
				return false;
		}

		return true;
	}

} //MacroImpl
