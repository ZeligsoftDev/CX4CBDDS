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
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Constraint for IDLFile Container
 * 
 * @author Lee Simbeye (lsimbeye)
 * 
 */
public class ContainedIDLFileConstraint extends AbstractModelConstraint {
	/**
	 * IDLFiles cannot be contained within another IDLFile or a IDLModule
	 */
	public ContainedIDLFileConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CORBADomainNames.IDLFILE)) {

			if (!checkContainer(objToVerify)) {
				return ctx.createFailureStatus(objToVerify);
			}
		}

		return ctx.createSuccessStatus();

	}

	private boolean checkContainer(EObject eobj) {

		EObject owner = eobj.eContainer();
		boolean bool = true;
		if ((ZDLUtil.isZDLConcept(owner, CORBADomainNames.IDLFILE))
				|| (ZDLUtil.isZDLConcept(owner, CORBADomainNames.CORBAMODULE))) {
			return false;
		} else if (owner.eContainer() != null) {
			bool = checkContainer(owner);
		}
		return bool;
	}
}
