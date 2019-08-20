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
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.Dependency;
import com.zeligsoft.cx.langc.DependencyBlob;
import com.zeligsoft.cx.langc.DependencyList;
import com.zeligsoft.cx.langc.Directive;
import com.zeligsoft.cx.langc.Element;
import com.zeligsoft.cx.langc.ElementList;
import com.zeligsoft.cx.langc.FileName;
import com.zeligsoft.cx.langc.LangCPackage;
import com.zeligsoft.cx.langc.Name;
import com.zeligsoft.cx.langc.SystemInclude;
import com.zeligsoft.cx.langc.UserElement;
import com.zeligsoft.cx.langc.UserInclude;
import com.zeligsoft.cx.langc.m2t.CWriter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getDeclIncludes <em>Decl Includes</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getDefnIncludes <em>Defn Includes</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getPublicDirectives <em>Public Directives</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.ElementListImpl#getPrivateDirectives <em>Private Directives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
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
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> types;

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
	public EList<Element> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<Element>(Element.class, this, LangCPackage.ELEMENT_LIST__TYPES);
		}
		return types;
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
			case LangCPackage.ELEMENT_LIST__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
			case LangCPackage.ELEMENT_LIST__TYPES:
				return getTypes();
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
			case LangCPackage.ELEMENT_LIST__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Element>)newValue);
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
			case LangCPackage.ELEMENT_LIST__TYPES:
				getTypes().clear();
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
			case LangCPackage.ELEMENT_LIST__TYPES:
				return types != null && !types.isEmpty();
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

	private boolean writeDependencies(CodeWriter code, DependencyList depList, boolean includeSelf) {

		if( depList == null )
			return code.newline();

		// Sort the dependencies to ensure consisent order between generations.
		SortedSet<Dependency> deps
			= new TreeSet<Dependency>(
					new DependencyComparator( this ) );
		deps.addAll( depList.getDependencies() );

		// Write the self dep (if it exists) first, then the other user includes, then
		// the system includes, and finally the blobs (deps that the user has added).

		Iterator<Dependency> depIter = deps.iterator();
		if( ! depIter.hasNext() )
			return code.newline();

		Dependency first = depIter.next();
		if( first.refersTo( this ) )
		{
			if( includeSelf )
			{
				if( ! code.newline()
				 || ! first.write( code ) )
					return false;
			}
			first = null;
		}

		if( ! code.newline() )
			return false;

		if( first != null
		 && ! first.write( code ) )
			return false;

		while( depIter.hasNext() )
			if( ! depIter.next().write( code ) )
				return false;

		return code.newline();
	}

	public boolean write(CWriter writer) {

		writer.decl().enableWrites();
		if( ! writeDependencies( writer.decl(), getDeclIncludes(), false ) )
			return false;

		if( ! writeDependencies( writer.defn(), getDefnIncludes(), true ) )
			return false;
		writer.defn().enableWrites();

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

	private static class DependencyComparator implements Comparator<Dependency>
	{
		private final ElementList self;

		public DependencyComparator( ElementList self )
		{
			this.self = self;
		}

		public int compare( Dependency dep1, Dependency dep2 )
		{
			if( dep1.refersTo( self ) )
				return dep2.refersTo( self ) ? 0 : -1;
			else if( dep2.refersTo( self ) )
				return 1;

			if( dep1 instanceof UserInclude
			 || dep2 instanceof UserInclude )
			{
				if( ! ( dep1 instanceof UserInclude ) )
					return 1;
				if( ! ( dep2 instanceof UserInclude ) )
					return -1;
				return
					NameComparator.compareTo(
							((UserInclude) dep1).getFilename(),
							((UserInclude) dep2).getFilename() );
			}
			if( dep1 instanceof SystemInclude
			 || dep2 instanceof SystemInclude )
			{
				if( ! ( dep1 instanceof SystemInclude ) )
					return 1;
				if( ! ( dep2 instanceof SystemInclude ) )
					return -1;
				return
					NameComparator.compareTo(
							((SystemInclude) dep1).getFilename(),
							((SystemInclude) dep2).getFilename() );
			}
			if( dep1 instanceof DependencyBlob
			 || dep2 instanceof DependencyBlob )
			{
				if( ! ( dep1 instanceof DependencyBlob ) )
					return 1;
				if( ! ( dep2 instanceof DependencyBlob ) )
					return -1;

				DependencyBlob depBlob1 = (DependencyBlob)dep1;
				DependencyBlob depBlob2 = (DependencyBlob)dep2;
				int marker_rc = depBlob1.getMarkerComment().compareTo( depBlob2.getMarkerComment() );
				return
					marker_rc != 0
						? marker_rc
						: depBlob1.getText().compareTo( depBlob2.getText() );
			}

			return 0;
		}
	}

	private static class NameComparator implements Comparator<Name>
	{
		public int compare( Name name1, Name name2 )
		{
			return compareTo( name1, name2 );
		}

		public static int compareTo( Name name1, Name name2 )
		{
			Iterator<String> it1 = extractComponents( name1 ).iterator();
			Iterator<String> it2 = extractComponents( name2 ).iterator();

			while( it1.hasNext()
				&& it2.hasNext() )
			{
				int compare = it1.next().compareTo( it2.next() );
				if( compare != 0 )
					return compare;
			}

			if( it2.hasNext() )
				return -1;
			else if( it1.hasNext() )
				return 1;
			return 0;
		}

		private static List<String> extractComponents( Name name )
		{
			List<String> components
				= name.getParent() != null
					? extractComponents( name.getParent() )
					: new LinkedList<String>();
			components.add( name.getName() );
			return components;
		}
	}
}
