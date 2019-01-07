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
package com.zeligsoft.base.validation.provider.ocl;


import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.validation.util.IOCLProvider;
import com.zeligsoft.base.validation.util.OCLCache;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Implementation of an OCL constraint from a ZDL model.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLConstraint
		extends ModelConstraint implements IOCLProvider {

	/**
	 * The qualified name of the ZDL concept that defines me.
	 */
	private String concept;

	/**
	 * My OCL expression text.
	 */
	private String ocl;

	/**
	 * Initializes me with the text of my OCL expression and my descriptor.
	 * 
	 * @param concept
	 *            the domain concept that defines the constraint
	 * @param ocl
	 *            the text of my OCL constraint expression
	 * @param descriptor
	 *            my constraint descriptor
	 */
	OCLConstraint(String concept, String ocl, IConstraintDescriptor descriptor) {
		super(descriptor);

		this.concept = concept;
		//we need to replace all backslashes with a double backslash as org.eclipse.ocl_3.0+
		//seems to evaluate the ocl string before our regex matcher is able to get to it, causing
		//the escape sequence to be evaluated prematurely.
		this.ocl = ocl.replaceAll("\\\\", "\\\\\\\\"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public String getConcept() {
		return concept;
	}

	@Override
	public String getOCL() {
		return ocl;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void configure(OCLHelper helper, UMLEnvironment env, Profile profile) {
		helper.setContext(ZDLUtil.getZDLConcept(profile, getConcept()));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();

		// this concept is known to exist, otherwise we would not have obtained
		// this constraint from the target element
		Class zdl = ZDLUtil.getZDLConcept(target, concept);
		Profile profile = ZDLUtil.getZDLProfile(target, zdl);

		// this profile is known to exist, otherwise we could not have
		// determined that this target object is an instance of my concept
		OCLCache cache = OCLCache.adapt(profile);

		try {
			Constraint constraint = cache.getConstraint(this);

			if (cache.getOCL().check(target, constraint)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[]{target});
			}
		} catch (ParserException e) {
			// TODO: Log
			throw new WrappedException(e);
		}
	}
}
