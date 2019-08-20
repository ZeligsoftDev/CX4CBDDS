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
package com.zeligsoft.domain.dds4ccm.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;

/**
 * Check to see if the model require migration
 * 
 * @author ysroh
 * 
 */
public class CheckModelMigrationConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (objToVerify == null
				|| !ZDLUtil.isZDLConcept(objToVerify,
						DDS4CCMNames.DDS4_CCMMODEL)) {
			return ctx.createSuccessStatus();
		}

		boolean result = DDS4CCMMigrationUtil
				.isMigrationRequired((Model) objToVerify);
		if (result == true) {
			return ctx.createFailureStatus();
		}
		return ctx.createSuccessStatus();
	}
}
