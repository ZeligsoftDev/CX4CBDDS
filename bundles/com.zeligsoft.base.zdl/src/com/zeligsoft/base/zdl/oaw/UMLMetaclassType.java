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
package com.zeligsoft.base.zdl.oaw;

import java.util.Set;

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;

/**
 * An oAW type encapsulating UML metaclasses.  A UML metaclass understands how
 * to burst {@link UMLBubble}s in the invocation of UML metamodel features.
 * 
 * @author Christian W. Damus (Zeligsoft)
 */
class UMLMetaclassType
		extends AbstractTypeImpl {

	private ZDLMetamodel metamodel;

	private Type delegate;

	/**
	 * @param metamodel
	 * @param delegate
	 *            the "real" UML type
	 */
	public UMLMetaclassType(ZDLMetamodel metamodel, Type delegate) {
		super(metamodel.getTypeSystem(), delegate.getName());
		
		this.delegate = delegate;
		this.metamodel = metamodel;
	}

	@Override
	public Feature[] getContributedFeatures() {
		Feature[] delegates = ((AbstractTypeImpl) delegate)
			.getContributedFeatures();
		Feature[] result = new Feature[delegates.length];

		int i = 0;
		for (Feature next : delegates) {
			if (next instanceof Property) {
				result[i++] = new UMLProperty((Property) next);
			} else if (next instanceof Operation) {
				result[i++] = new UMLOperation((Operation) next);
			} else {
				// there shouldn't be anything else; metaclases don't have
				// enumeration literals
				result[i++] = next;
			}
		}

		return result;
	}
	
	@Override
	protected Set<? extends Type> internalGetSuperTypes() {
		Set<Type> result = new java.util.HashSet<Type>(delegate.getSuperTypes());
		
		if (result.remove(metamodel.getBasicEObjectType())) {
			// don't add EObject as a supertype of itself
			result.add(metamodel.getEObjectType());
		}
		
		return result;
	}

	@Override
	public boolean isAbstract() {
		return delegate.isAbstract();
	}

	@Override
	protected boolean internalIsAssignableFrom(Type t) {
		if (t instanceof ZDLConceptType) {
			if (this.metamodel.hasContextProfile()) {
				ZDLConceptType zct = (ZDLConceptType) t;
				if (!UML2Util.isEmpty(zct.getMetaclass())) {
					Type metatype = this.metamodel.getTypeForName(zct
							.getMetaclass());
					if (metatype != null) {
						return super.isAssignableFrom(metatype);
					}
				}
				// assume assignability of the particular profile mapping
				return false;
			} else {
				return true;
			}
		}

		return super.internalIsAssignableFrom(t);
	}

	public boolean isInstance(Object o) {
		return delegate.isInstance(UMLBubble.burst(o));
	}

	public Object newInstance() {
		return delegate.newInstance();
	}

	private class UMLProperty
			extends PropertyImpl {

		private Property delegate;

		UMLProperty(Property delegate) {
			super(UMLMetaclassType.this, delegate.getName(), delegate
				.getReturnType());

			this.delegate = delegate;
		}

		public Object get(Object target) {
			return delegate.get(UMLBubble.burst(target));
		}

		@Override
		public void set(Object target, Object newValue) {
			delegate.set(UMLBubble.burst(target), UMLBubble.burst(newValue));
		}
	}

	private class UMLOperation
			extends OperationImpl {

		private Operation delegate;

		UMLOperation(Operation delegate) {
			super(UMLMetaclassType.this, delegate.getName(), delegate
				.getReturnType(), delegate.getParameterTypes().toArray(
				new Type[delegate.getParameterTypes().size()]));
			
			this.delegate = delegate;
		}
		
		@Override
		protected Object evaluateInternal(Object target, Object[] params) {
			return delegate.evaluate(UMLBubble.burst(target), UMLBubble.burst(params));
		}
	}
}
