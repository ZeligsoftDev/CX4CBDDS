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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;

/**
 * 
 * @author parmvirs
 * 
 */
public class SubStructureIsKeyConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, DDS4CCMNames.MESSAGE_FIELD)) {
			EObject type = (EObject) ZDLUtil.getValue(objToVerify, DDS4CCMNames.MESSAGE_FIELD,
					DDS4CCMNames.MESSAGE_FIELD__IDL_TYPE);
			if (type != null && ZDLUtil.isZDLConcept(type, DDS4CCMNames.DDSMESSAGE)) {
				@SuppressWarnings("unchecked")
				List<EObject> fields = (List<EObject>) ZDLUtil.getValue(type, DDS4CCMNames.DDSMESSAGE,
						DDS4CCMNames.DDSMESSAGE__FIELDS);
				for (EObject field : fields) {
					if (ZDLUtil.isZDLConcept(field, DDS4CCMNames.MESSAGE_FIELD)) {
						Boolean subStructureIsKey = (Boolean) ZDLUtil.getValue(field, DDS4CCMNames.MESSAGE_FIELD,
								DDS4CCMNames.MESSAGE_FIELD__IS_KEY);
						if (subStructureIsKey) {
							Boolean isKey = (Boolean) ZDLUtil.getValue(objToVerify, DDS4CCMNames.MESSAGE_FIELD,
									DDS4CCMNames.MESSAGE_FIELD__IS_KEY);
							if (!isKey) {
								return ctx.createFailureStatus(((NamedElement) objToVerify).getName(),
										((NamedElement) field).getName());
							}
						}
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
