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
package com.zeligsoft.domain.omg.ccm.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Verifies that no assembly implementation contains monolithic part
 * 
 * @author parmvirs
 * 
 */

public class NoMonolithicPartsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		for (Property part : ((Component) objToVerify).getAttributes()) {
			if (part.getType() != null) {
				if (ZDLUtil.isZDLConcept(part.getType(),
						CCMNames.MONOLITHIC_IMPLEMENTATION)) {
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
