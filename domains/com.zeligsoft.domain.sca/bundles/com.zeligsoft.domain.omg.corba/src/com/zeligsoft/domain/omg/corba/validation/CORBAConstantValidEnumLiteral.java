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
package com.zeligsoft.domain.omg.corba.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Validate that CORBAConstant's default value contains one of the enumeration
 * literal from it's enum type
 * 
 * @author ysroh
 * 
 */
public class CORBAConstantValidEnumLiteral extends AbstractModelConstraint {

	public CORBAConstantValidEnumLiteral() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CORBADomainNames.CORBACONSTANT)) {
			EObject type = ZDLUtil.getEValue(objToVerify,
					CORBADomainNames.CORBACONSTANT,
					CORBADomainNames.CORBATYPED__IDL_TYPE);
			if (type == null
					|| !ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAENUM)) {
				return ctx.createSuccessStatus();
			}
			String value = (String) ZDLUtil.getValue(objToVerify,
					CORBADomainNames.CORBACONSTANT,
					CORBADomainNames.CORBACONSTANT__DEFAULT);
			for (EnumerationLiteral l : ((Enumeration) type).getOwnedLiterals()) {
				if (l.getName().equals(value)) {
					return ctx.createSuccessStatus();
				}
			}
			return ctx.createFailureStatus();
		}

		return ctx.createSuccessStatus();
	}
}
