/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.type;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("rawtypes")
public class EMapEntryType extends AbstractTypeImpl {

	public static boolean isEMapEntry(ETypedElement element) {
		EClassifier t = element.getEType();
		return element.eContainer() instanceof EClass
				&& t != null && t.getInstanceClass() != null
				&& Map.Entry.class.isAssignableFrom(t.getInstanceClass())
				&& !element.isMany();
	}

	public static boolean isEMapEntryObject(Object o) {
		return o instanceof Map.Entry;
	}

	private Type keyType;
	private Type valueType;
	private EClassifier emfType;

	public EMapEntryType(TypeSystem typeSystem, String name,
			EClassifier innerType) {
		super(typeSystem, name);
		determineTypes(innerType);
	}

	private void determineTypes(EClassifier emfType) {
		this.emfType = emfType;
		EClass str2str = EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY;
		if (emfType instanceof EClass
				&& str2str.isSuperTypeOf((EClass) emfType)) {
			keyType = getTypeSystem().getStringType();
			valueType = getTypeSystem().getStringType();
		} else {
			keyType = getTypeSystem().getObjectType();
			valueType = getTypeSystem().getObjectType();
		}
	}

	@Override
	public Feature[] getContributedFeatures() {
		return new Feature[] { new PropertyImpl(this, "value", valueType) {
			public Object get(Object target) {
				Map.Entry ent = (Map.Entry) target;
				return ent.getValue();
			}
		}, new PropertyImpl(this, "key", keyType) {
			public Object get(Object target) {
				Map.Entry ent = (Map.Entry) target;
				return ent.getKey();
			}
		}, new OperationImpl(this, "setValue", valueType, valueType) {
			@SuppressWarnings("unchecked")
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				Map.Entry ent = (Map.Entry) target;
				Object old = ent.getValue();
				ent.setValue(params[0]);
				return old;
			}
		} };
	}

	public Type getKeyType() {
		return keyType;
	}

	public Type getValueType() {
		return valueType;
	}

	public EClassifier getEmfType() {
		return emfType;
	}

	public boolean isInstance(Object o) {
		return o instanceof Map.Entry;
	}

	public Object newInstance() {
		throw new UnsupportedOperationException(
				"Map entries can not be instantiated standlaone");
	}

}
