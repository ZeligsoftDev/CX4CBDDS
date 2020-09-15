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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

/**
 * Check to see if the CXBound values are property set
 * 
 * @author ysroh
 * 
 */
public class CORBABoundValueConstraint extends AbstractModelConstraint {

	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		List<EObject> bounds = new ArrayList<EObject>();
		if (ZDLUtil.isZDLConcept(objToVerify, CXDomainNames.CXARRAY)) {
			bounds = (List<EObject>) ZDLUtil.getValue(objToVerify,
					CXDomainNames.CXARRAY,
					CXDomainNames.CXARRAY__BOUNDS);
		} else if (ZDLUtil.isZDLConcept(objToVerify,
				CXDomainNames.CXFIELD)) {
			bounds = (List<EObject>) ZDLUtil.getValue(objToVerify,
					CXDomainNames.CXFIELD,
					CXDomainNames.CXFIELD__BOUNDS);
		} else if (ZDLUtil.isZDLConcept(objToVerify,
				CXDomainNames.CXSEQUENCE)) {
			EObject bound = ZDLUtil.getEValue(objToVerify,
					CXDomainNames.CXSEQUENCE,
					CXDomainNames.CXSEQUENCE__BOUNDS);
			if (bound != null) {
				bounds.add(bound);
			}
		} else if (ZDLUtil.isZDLConcept(objToVerify,
				CXDomainNames.CXBOUNDED)) {
			EObject bound = ZDLUtil.getEValue(objToVerify,
					CXDomainNames.CXBOUNDED,
					CXDomainNames.CXBOUNDED__BOUNDS);
			if (bound != null) {
				bounds.add(bound);
			}
		} else {
			return ctx.createSuccessStatus();
		}
		for (EObject bound : bounds) {
			String stringBound = (String) ZDLUtil.getValue(bound,
					CXDomainNames.CXBOUND,
					CXDomainNames.CXBOUND__VALUE);
			EObject constantBound = ZDLUtil.getEValue(bound,
					CXDomainNames.CXBOUND,
					CXDomainNames.CXBOUND__CONSTANT);
			if (UML2Util.isEmpty(stringBound) && constantBound == null) {
				return ctx.createFailureStatus();
			} else if (!UML2Util.isEmpty(stringBound) && constantBound != null) {
				return ctx.createFailureStatus();
			}
		}

		return ctx.createSuccessStatus();
	}
}
