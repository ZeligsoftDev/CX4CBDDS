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
package org.eclipse.internal.xtend.xtend.types;

import java.util.List;

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

public class AdviceContextType extends AbstractTypeImpl {

	public static final String TYPE_NAME = "xtend::AdviceContext";

	public AdviceContextType(TypeSystem typeSystem) {
		super(typeSystem, TYPE_NAME);
	}
	@Override
	public Feature[] getContributedFeatures() {
		return new Feature[] {
				new PropertyImpl(AdviceContextType.this,"name",getTypeSystem().getStringType()) {
					public Object get(Object target) {
						return ((AdviceContext)target).getName();
					}
				},
				new PropertyImpl(AdviceContextType.this,"paramTypes",getTypeSystem().getListType(getTypeSystem().getTypeType())) {
					public Object get(Object target) {
						return ((AdviceContext)target).getParamTypes();
					}
				},
				new PropertyImpl(AdviceContextType.this,"paramNames",getTypeSystem().getListType(getTypeSystem().getStringType())) {
					public Object get(Object target) {
						return ((AdviceContext)target).getParamNames();
					}
				},
				new PropertyImpl(AdviceContextType.this,"paramValues",getTypeSystem().getListType(getTypeSystem().getObjectType())) {
					public Object get(Object target) {
						return ((AdviceContext)target).getParamValues();
					}
				},
				new OperationImpl(AdviceContextType.this,"proceed",getTypeSystem().getObjectType()) {

					@Override
					protected Object evaluateInternal(Object target, Object[] params) {
						return ((AdviceContext)target).proceed();
					}
				},
				new OperationImpl(AdviceContextType.this,"proceed",getTypeSystem().getObjectType(),getTypeSystem().getListType(getTypeSystem().getObjectType())) {

					@SuppressWarnings("unchecked")
					@Override
					protected Object evaluateInternal(Object target, Object[] params) {
						return ((AdviceContext)target).proceed(((List<Object>)params[0]).toArray());
					}
				}
		};
	}

	public boolean isInstance(Object o) {
		return o instanceof AdviceContext;
	}

	public Object newInstance() {
		throw new UnsupportedOperationException();
	}

}
