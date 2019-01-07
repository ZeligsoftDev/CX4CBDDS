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
package com.zeligsoft.domain.zml.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import com.zeligsoft.domain.zml.util.ZMLUtil;

public class StructureRealizationMustHaveAtLeastOneImplementation extends
		AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public StructureRealizationMustHaveAtLeastOneImplementation() {

		super();

	}

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil
				.isZDLConcept(objToVerify, ZMLMMNames.STRUCTURAL_REALIZATION)) {

			EList<Artifact> impls = ZMLUtil
					.getComponentImplementations((Component) objToVerify);

			if (impls.size() >= 1) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { objToVerify });
			}
		}

		return ctx.createSuccessStatus();
	}
}
