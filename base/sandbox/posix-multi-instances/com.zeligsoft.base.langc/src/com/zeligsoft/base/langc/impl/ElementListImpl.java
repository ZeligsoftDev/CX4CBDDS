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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.base.langc.Dependency;
import com.zeligsoft.base.langc.DependencyBlob;
import com.zeligsoft.base.langc.DependencyList;
import com.zeligsoft.base.langc.Directive;
import com.zeligsoft.base.langc.ElementList;
import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.LangCPackage;
import com.zeligsoft.base.langc.SystemInclude;
import com.zeligsoft.base.langc.UserElement;
import com.zeligsoft.base.langc.UserInclude;
import com.zeligsoft.base.langc.m2t.CWriter;
import com.zeligsoft.base.langc.m2t.CodeWriter;
import com.zeligsoft.base.langc.util.Partitioner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementListImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementListImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementListImpl#getDeclIncludes <em>Decl Includes</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementListImpl#getDefnIncludes <em>Defn Includes</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementListImpl#getPublicDirectives <em>Public Directives</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.impl.ElementListImpl#getPrivateDirectives <em>Private Directives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("nls")
public class ElementListImpl extends EObjectImpl implements ElementList {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UserElement> elements;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected FileName name;

	/**
	 * The cached value of the '{@link #getDeclIncludes() <em>Decl Includes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclIncludes()
	 * @generated
	 * @ordered
	 */
	protected DependencyList declIncludes;

	/**
	 * The cached value of the '{@link #getDefnIncludes() <em>Defn Includes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefnIncludes()
	 * @generated
	 * @ordered
	 */
	protected DependencyList defnIncludes;

	/**
	 * The cached value of the '{@link #getPublicDirectives() <em>Public Directives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicDirectives()
	 * @generated
	 * @ordered
	 */
	protected EList<Directive> publicDirectives;

	/**
	 * The cached value of the '{@link #getPrivateDirectives() <em>Private Directives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivateDirectives()
	 * @generated
	 * @ordered
	 */
	protected EList<Directive> privateDirectives;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.ELEMENT_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UserElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<UserElement>(UserElement.class, this, LangCPackage.ELEMENT_LIST__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileName getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(FileName newName, NotificationChain msgs) {
		FileName oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_LIST__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(FileName newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.ELEMENT_LIST__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.ELEMENT_LIST__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_LIST__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyList getDeclIncludes() {
		return declIncludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclIncludes(DependencyList newDeclIncludes, NotificationChain msgs) {
		DependencyList oldDeclIncludes = declIncludes;
		declIncludes = newDeclIncludes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_LIST__DECL_INCLUDES, oldDeclIncludes, newDeclIncludes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclIncludes(DependencyList newDeclIncludes) {
		if (newDeclIncludes != declIncludes) {
			NotificationChain msgs = null;
			if (declIncludes != null)
				msgs = ((InternalEObject)declIncludes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.ELEMENT_LIST__DECL_INCLUDES, null, msgs);
			if (newDeclIncludes != null)
				msgs = ((InternalEObject)newDeclIncludes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.ELEMENT_LIST__DECL_INCLUDES, null, msgs);
			msgs = basicSetDeclIncludes(newDeclIncludes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_LIST__DECL_INCLUDES, newDeclIncludes, newDeclIncludes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyList getDefnIncludes() {
		return defnIncludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefnIncludes(DependencyList newDefnIncludes, NotificationChain msgs) {
		DependencyList oldDefnIncludes = defnIncludes;
		defnIncludes = newDefnIncludes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_LIST__DEFN_INCLUDES, oldDefnIncludes, newDefnIncludes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefnIncludes(DependencyList newDefnIncludes) {
		if (newDefnIncludes != defnIncludes) {
			NotificationChain msgs = null;
			if (defnIncludes != null)
				msgs = ((InternalEObject)defnIncludes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.ELEMENT_LIST__DEFN_INCLUDES, null, msgs);
			if (newDefnIncludes != null)
				msgs = ((InternalEObject)newDefnIncludes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.ELEMENT_LIST__DEFN_INCLUDES, null, msgs);
			msgs = basicSetDefnIncludes(newDefnIncludes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.ELEMENT_LIST__DEFN_INCLUDES, newDefnIncludes, newDefnIncludes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Directive> getPublicDirectives() {
		if (publicDirectives == null) {
			publicDirectives = new EObjectContainmentEList<Directive>(Directive.class, this, LangCPackage.ELEMENT_LIST__PUBLIC_DIRECTIVES);
		}
		return publicDirectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Directive> getPrivateDirectives() {
		if (privateDirectives == null) {
			privateDirectives = new EObjectContainmentEList<Directive>(Directive.class, this, LangCPackage.ELEMENT_LIST__PRIVATE_DIRECTIVES);
		}
		return privateDirectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.ELEMENT_LIST__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case LangCPackage.ELEMENT_LIST__NAME:
				return basicSetName(null, msgs);
			case LangCPackage.ELEMENT_LIST__DECL_INCLUDES:
				return basicSetDeclIncludes(null, msgs);
			case LangCPackage.ELEMENT_LIST__DEFN_INCLUDES:
				return basicSetDefnIncludes(null, msgs);
			case LangCPackage.ELEMENT_LIST__PUBLIC_DIRECTIVES:
				return ((InternalEList<?>)getPublicDirectives()).basicRemove(otherEnd, msgs);
			case LangCPackage.ELEMENT_LIST__PRIVATE_DIRECTIVES:
				return ((InternalEList<?>)getPrivateDirectives()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.ELEMENT_LIST__ELEMENTS:
				return getElements();
			case LangCPackage.ELEMENT_LIST__NAME:
				return getName();
			case LangCPackage.ELEMENT_LIST__DECL_INCLUDES:
				return getDeclIncludes();
			case LangCPackage.ELEMENT_LIST__DEFN_INCLUDES:
				return getDefnIncludes();
			case LangCPackage.ELEMENT_LIST__PUBLIC_DIRECTIVES:
				return getPublicDirectives();
			case LangCPackage.ELEMENT_LIST__PRIVATE_DIRECTIVES:
				return getPrivateDirectives();
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
			case LangCPackage.ELEMENT_LIST__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends UserElement>)newValue);
				return;
			case LangCPackage.ELEMENT_LIST__NAME:
				setName((FileName)newValue);
				return;
			case LangCPackage.ELEMENT_LIST__DECL_INCLUDES:
				setDeclIncludes((DependencyList)newValue);
				return;
			case LangCPackage.ELEMENT_LIST__DEFN_INCLUDES:
				setDefnIncludes((DependencyList)newValue);
				return;
			case LangCPackage.ELEMENT_LIST__PUBLIC_DIRECTIVES:
				getPublicDirectives().clear();
				getPublicDirectives().addAll((Collection<? extends Directive>)newValue);
				return;
			case LangCPackage.ELEMENT_LIST__PRIVATE_DIRECTIVES:
				getPrivateDirectives().clear();
				getPrivateDirectives().addAll((Collection<? extends Directive>)newValue);
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
			case LangCPackage.ELEMENT_LIST__ELEMENTS:
				getElements().clear();
				return;
			case LangCPackage.ELEMENT_LIST__NAME:
				setName((FileName)null);
				return;
			case LangCPackage.ELEMENT_LIST__DECL_INCLUDES:
				setDeclIncludes((DependencyList)null);
				return;
			case LangCPackage.ELEMENT_LIST__DEFN_INCLUDES:
				setDefnIncludes((DependencyList)null);
				return;
			case LangCPackage.ELEMENT_LIST__PUBLIC_DIRECTIVES:
				getPublicDirectives().clear();
				return;
			case LangCPackage.ELEMENT_LIST__PRIVATE_DIRECTIVES:
				getPrivateDirectives().clear();
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
			case LangCPackage.ELEMENT_LIST__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case LangCPackage.ELEMENT_LIST__NAME:
				return name != null;
			case LangCPackage.ELEMENT_LIST__DECL_INCLUDES:
				return declIncludes != null;
			case LangCPackage.ELEMENT_LIST__DEFN_INCLUDES:
				return defnIncludes != null;
			case LangCPackage.ELEMENT_LIST__PUBLIC_DIRECTIVES:
				return publicDirectives != null && !publicDirectives.isEmpty();
			case LangCPackage.ELEMENT_LIST__PRIVATE_DIRECTIVES:
				return privateDirectives != null && !privateDirectives.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	private boolean writeDependencies(CodeWriter code, DependencyList deps) {

		if( deps == null )
			return true;

		for( Dependency dep : deps.getDependencies() )
			if( ( dep instanceof UserInclude )
			 && ! dep.refersTo( this )
			 && ! dep.write( code ) )
				return false;
		if( ! code.newline() )
			return false;

		for( Dependency dep : deps.getDependencies() )
			if( ( dep instanceof SystemInclude )
			 && ! dep.write( code ) )
				return false;
		if( ! code.newline() )
			return false;

		for( Dependency dep : deps.getDependencies() )
			if( ( dep instanceof DependencyBlob )
			 && ! dep.write( code ) )
				return false;
		return code.newline();
	}

	public boolean write(CWriter writer) {

//		writer.decl().enableWrites();
		if( ! writeDependencies( writer.decl(), getDeclIncludes() ) )
			return false;

//		if( ! writer.defn().newline()
//		 || ! writer.defn().write( "#include \"" )
//		 || ! writer.defn().write( Partitioner.includePath( getName() ) )
//		 || ! writer.defn().writeLn( '"' )
//		 || ! writer.defn().newline() )
//			return false;
//
//		writer.defn().enableWrites();
		if( ! writeDependencies( writer.defn(), getDefnIncludes() ) )
			return false;

		if( getPublicDirectives() != null )
		{
			for( Directive directive : getPublicDirectives() )
				if( ! directive.write(writer.decl() ) )
					return false;

			if( getPublicDirectives().size() > 0 )
				writer.decl().newline();
		}

		if( getPrivateDirectives() != null )
		{
			for( Directive directive : getPrivateDirectives() )
				if( ! directive.write(writer.defn() ) )
					return false;

			if( getPrivateDirectives().size() > 0 )
				writer.defn().newline();
		}

		for( UserElement element : getElements() )
			if( ! element.write( writer ) )
				return false;

		return true;
	}

} //DeclarationContextImpl
