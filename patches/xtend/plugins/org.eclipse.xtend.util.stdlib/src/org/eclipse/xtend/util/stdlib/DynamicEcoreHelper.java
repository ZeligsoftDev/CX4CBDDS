/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DynamicEcoreHelper {

	private EFactory factory;
	private EPackage pack;

	public DynamicEcoreHelper( EPackage pack ) {
		this.pack = pack;
		this.factory = pack.getEFactoryInstance();
	}

	public DynamicEcoreHelper(EObject system) {
		this( system.eClass().getEPackage() );
	}

	public EObject create( String className ) {
		return factory.create((EClass)pack.getEClassifier(className));
	}

	public void setName(EObject object, String name) {
		set( object, "name", name );
	}

	public String getName(EObject object ) {
		return (String)get( object, "name" );
	}

	public Object get(EObject object, String feature ) {
		EStructuralFeature f = object.eClass().getEStructuralFeature(feature);
		if ( f == null ) return null;
		return object.eGet( f );
	}

	public List<?> getMany(EObject object, String feature ) {
		return (List<?>)get( object, feature );
	}

	public void set(EObject object, String feature, Object newValue) {
		object.eSet( object.eClass().getEStructuralFeature(feature) , newValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(EObject object, String feature, EObject newValue) {
		((Collection)object.eGet( object.eClass().getEStructuralFeature(feature) )).add(newValue);
	}

	public boolean isInstance( EObject object, String typeName ) {
		return object.eClass().getName().equals(typeName);
	}

	public String sget(EObject object, String feature) {
		return (String)get(object, feature);
	}

	public EObject eget(EObject object, String feature) {
		return (EObject)get(object, feature);
	}

	public int iget(EObject object, String feature) {
		return (Integer)get( object, feature);
	}

	public void addAll(EObject object, String feature, List<EObject> elements) {
		for (EObject o : elements) {
			add( object, feature, o);
		}
	}

	public List<EObject> getAllChildren(EObject emodel, String typeName) {
		List<EObject> res = new ArrayList<EObject>();
		for (Iterator<EObject> iterator = emodel.eAllContents(); iterator.hasNext();) {
			EObject o = iterator.next();
			if ( isInstance(o, typeName) ) res.add(o);
		}
		return res;
	}

}
