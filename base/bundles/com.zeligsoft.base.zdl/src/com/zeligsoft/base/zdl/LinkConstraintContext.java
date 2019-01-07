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
package com.zeligsoft.base.zdl;

/**
 * An enumeration of contexts in which a Zeligsoft application may evaluate link
 * constraints.
 * 
 * @author Christian W. Damus (cdamus)
 */
public enum LinkConstraintContext {
	/**
	 * The link-constraint context for constraining the creation of connections
	 * in diagram editors.
	 */
	DIAGRAM("diagram", false), //$NON-NLS-1$

	/**
	 * The link-constraint context for constraining the drag-and-drop of model
	 * elements in the deployment editors. At least some constraint must be
	 * defined that is applicable to a given (source, target) link pair in order
	 * to pass the check.  
	 * 
	 * The source can be deployed to the target.
	 */
	DEPLOYMENT("deployment", true), //$NON-NLS-1$
	
	/**
	 * The link-constraint context for constraining the drag-and-drop of model
	 * elements in the deployment editors. At least some constraint must be
	 * defined that is applicable to a given (source, target) link pair in order
	 * to pass the check.
	 * 
	 */
	DEPLOYMENT_CONTAINER("deploymentContainer", true), //$NON-NLS-1$
	
	/**
	 * The link-constraint context for constraining the drag-and-drop of model
	 * elements in the deployment editors. At least some constraint must be
	 * defined that is applicable to a given (source, target) link pair in order
	 * to pass the check.
	 * 
	 * The source can be a deploymentPart in the target.
	 */
	DEPLOYMENT_PART("deploymentPart", true), //$NON-NLS-1$
	
	/**
	 * The link-constraint context for constraining the drag-and-drop of model
	 * elements in the deployment editors. At least some constraint must be
	 * defined that is applicable to a given (source, target) link pair in order
	 * to pass the check.
	 * 
	 * The source can be configured for deployment on the target.
	 */
	DEPLOYMENT_PART_CONFIGURE("deploymentPartConfigure", true); //$NON-NLS-1$

	private final String kind;

	private final boolean explicit;

	LinkConstraintContext(String kind, boolean explicit) {
		this.kind = kind;
		this.explicit = explicit;
	}

	/**
	 * Obtains the ZDL link-constraint kind that I map to.
	 * 
	 * @return my ZDL kind
	 */
	public String kind() {
		return kind;
	}

	/**
	 * Queries whether any set of objects to be checked in the link-constraint
	 * context must have at least some constraint explicitly defined that is
	 * applicable in order to pass.
	 * 
	 * @return <code>true</code> if link-constraint checks in this context
	 *         require at least one constraint to be applicable in order to
	 *         pass; <code>false</code> if a check that finds no applicable
	 *         constraints should just pass
	 */
	public boolean isExplicit() {
		return explicit;
	}
}
