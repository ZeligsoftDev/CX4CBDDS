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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * A partial implementation of the {@link IBinaryLinkConstraint} protocol,
 * useful for subclassing. Sublasses need only implement the
 * {@link IBinaryLinkConstraint#test(EObject, EObject)} operation.
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractBinaryLinkConstraint
		extends AbstractLinkConstraint
		implements IBinaryLinkConstraint {

	private String sourceRole;

	private String targetRole;

	/**
	 * Initializes me with my ID, name, and context.
	 * 
	 * @param id
	 *            my unique identifier
	 * @param name
	 *            my name, localized if possible
	 * @param context
	 *            my application context selector
	 */
	public AbstractBinaryLinkConstraint(String id, String name,
			LinkConstraintContext context) {
		this(id, name, context, "source", "target"); //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * Initializes me with my idname, context, and source/target role names.
	 * 
	 * @param id
	 *            my unique identifier
	 * @param name
	 *            my name, localized if possible
	 * @param context
	 *            my application context selector
	 * @param sourceRole
	 *            my source role name
	 * @param targetRole
	 *            my target role name
	 */
	public AbstractBinaryLinkConstraint(String id, String name,
			LinkConstraintContext context, String sourceRole, String targetRole) {
		super(id, name, context);

		this.sourceRole = sourceRole;
		this.targetRole = targetRole;
	}

	@Override
	public String getSourceRole() {
		return sourceRole;
	}

	@Override
	public String getTargetRole() {
		return targetRole;
	}

	@Override
	public void setSourceRole(String name) {
		this.sourceRole = name;
	}

	@Override
	public void setTargetRole(String name) {
		this.targetRole = name;
	}

	@Override
	public boolean test(Map<String, ? extends EObject> tuple) {
		return test(tuple.get(getSourceRole()), tuple.get(getTargetRole()));
	}

}
