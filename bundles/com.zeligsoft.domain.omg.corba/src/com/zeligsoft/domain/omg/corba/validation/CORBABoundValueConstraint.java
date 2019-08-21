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
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Check to see if the CORBABound values are property set
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
		if (ZDLUtil.isZDLConcept(objToVerify, CORBADomainNames.CORBAARRAY)) {
			bounds = (List<EObject>) ZDLUtil.getValue(objToVerify,
					CORBADomainNames.CORBAARRAY,
					CORBADomainNames.CORBAARRAY__BOUNDS);
		} else if (ZDLUtil.isZDLConcept(objToVerify,
				CORBADomainNames.CORBAFIELD)) {
			bounds = (List<EObject>) ZDLUtil.getValue(objToVerify,
					CORBADomainNames.CORBAFIELD,
					CORBADomainNames.CORBAFIELD__BOUNDS);
		} else if (ZDLUtil.isZDLConcept(objToVerify,
				CORBADomainNames.CORBASEQUENCE)) {
			EObject bound = ZDLUtil.getEValue(objToVerify,
					CORBADomainNames.CORBASEQUENCE,
					CORBADomainNames.CORBASEQUENCE__BOUNDS);
			if (bound != null) {
				bounds.add(bound);
			}
		} else if (ZDLUtil.isZDLConcept(objToVerify,
				CORBADomainNames.CORBABOUNDED)) {
			EObject bound = ZDLUtil.getEValue(objToVerify,
					CORBADomainNames.CORBABOUNDED,
					CORBADomainNames.CORBABOUNDED__BOUNDS);
			if (bound != null) {
				bounds.add(bound);
			}
		} else {
			return ctx.createSuccessStatus();
		}
		for (EObject bound : bounds) {
			String stringBound = (String) ZDLUtil.getValue(bound,
					CORBADomainNames.CORBABOUND,
					CORBADomainNames.CORBABOUND__VALUE);
			EObject constantBound = ZDLUtil.getEValue(bound,
					CORBADomainNames.CORBABOUND,
					CORBADomainNames.CORBABOUND__CONSTANT);
			if (UML2Util.isEmpty(stringBound) && constantBound == null) {
				return ctx.createFailureStatus();
			} else if (!UML2Util.isEmpty(stringBound) && constantBound != null) {
				return ctx.createFailureStatus();
			}
		}

		return ctx.createSuccessStatus();
	}
}
