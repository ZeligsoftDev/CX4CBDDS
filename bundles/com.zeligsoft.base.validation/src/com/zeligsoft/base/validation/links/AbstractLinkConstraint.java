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
package com.zeligsoft.base.validation.links;

import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * A partial implementation of the {@link ILinkConstraint} protocol, useful for
 * subclassing. Subclasses need only implement the
 * {@link ILinkConstraint#test(java.util.Map)} method.
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractLinkConstraint
		implements ILinkConstraint {

	private final String id;

	private final String name;

	private final LinkConstraintContext context;

	/**
	 * Initializes me with my id, name, and context.
	 * 
	 * @param id
	 *            my unique identifier
	 * @param name
	 *            my name, localized if possible
	 * @param context
	 *            my application context selector
	 */
	public AbstractLinkConstraint(String id, String name,
			LinkConstraintContext context) {
		this.id = id;
		this.name = name;
		this.context = context;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public LinkConstraintContext getContext() {
		return context;
	}

	@Override
	public String getName() {
		return name;
	}

}
