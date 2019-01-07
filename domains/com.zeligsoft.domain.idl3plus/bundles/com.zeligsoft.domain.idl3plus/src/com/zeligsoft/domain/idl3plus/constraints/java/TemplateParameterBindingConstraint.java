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
package com.zeligsoft.domain.idl3plus.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.TemplateSignature;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;

/**
 * Check for missing template parameter binding
 * 
 * @author ysroh
 * 
 */
public class TemplateParameterBindingConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public TemplateParameterBindingConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		if (!ZDLUtil.isZDLConcept(objToVerify, IDL3PlusNames.MODULE_BINDING)) {
			return null;
		}

		TemplateSignature template = (TemplateSignature) ZDLUtil.getValue(
				objToVerify, IDL3PlusNames.MODULE_BINDING,
				IDL3PlusNames.MODULE_BINDING__TEMPLATE);

		for (TemplateParameter parm : template.getParameters()) {
			boolean found = false;
			for (TemplateParameterSubstitution sub : ((TemplateBinding) objToVerify)
					.getParameterSubstitutions()) {
				if (parm.equals(sub.getFormal())) {
					found = true;
				}
			}
			if (!found) {
				return ctx.createFailureStatus(parm);
			}
		}

		return null;
	}
}
