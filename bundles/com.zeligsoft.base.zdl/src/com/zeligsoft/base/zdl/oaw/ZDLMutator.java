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

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;

/**
 * The mutator (setter) operation for a ZDL property, which works around the
 * fact that the oAW expression language doesn't have an assignment operator.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLMutator
		extends OperationImpl {

	private ZDLProperty property;

	/**
	 * Initializes me with the property that I mutate.
	 * 
	 * @param property
	 *            my property
	 */
	public ZDLMutator(ZDLProperty property) {
		super(property.getOwner(), mutatorName(property), property.getOwner()
			.getTypeSystem().getVoidType(), property.getReturnType());

		this.property = property;
	}

	@Override
	protected Object evaluateInternal(Object target, Object[] params) {
		property.set(target, params[0]);
		return null;
	}

	/**
	 * Computes the name of the mutator operation for the specified property.
	 * This is formed by prepending <tt>set</tt> onto the property name with
	 * an initial upper-case character.
	 * 
	 * @param property
	 *            a ZDL property
	 * @return the name of its mutator operation
	 */
	private static String mutatorName(ZDLProperty property) {
		String result = property.getName();

		return new StringBuilder("set").appendCodePoint( //$NON-NLS-1$
			Character.toUpperCase(result.codePointAt(0))).append(
			result.substring(1)).toString();
	}
}
