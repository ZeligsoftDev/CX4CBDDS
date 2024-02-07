/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.type;

import javax.xml.namespace.QName;

import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class QNameType extends AbstractTypeImpl {

	public QNameType(TypeSystem typeSystem, String name) {
		super(typeSystem, name);
	}

	@Override
	public Feature[] getContributedFeatures() {
		final Type string = getTypeSystem().getStringType();
		return new Feature[] { new PropertyImpl(this, "namespaceURI", string) {
			public Object get(Object target) {
				QName q = (QName) target;
				return q.getNamespaceURI();
			}
		}, new PropertyImpl(this, "localPart", string) {
			public Object get(Object target) {
				QName q = (QName) target;
				return q.getLocalPart();
			}
		}, new PropertyImpl(this, "prefix", string) {
			public Object get(Object target) {
				QName q = (QName) target;
				return q.getPrefix();
			}
		} };
	}

	public boolean isInstance(Object o) {
		return o instanceof QName;
	}

	public Object newInstance() {
		return new UnsupportedOperationException(
				"Qnames can not be instanciated manually.");
	}

}
