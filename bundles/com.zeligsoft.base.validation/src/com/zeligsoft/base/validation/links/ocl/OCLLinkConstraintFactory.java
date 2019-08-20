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
package com.zeligsoft.base.validation.links.ocl;

import org.eclipse.uml2.uml.Constraint;

import com.zeligsoft.base.validation.links.IBinaryLinkConstraint;
import com.zeligsoft.base.validation.links.ILinkConstraintFactory;
import com.zeligsoft.base.validation.util.IOCLProvider;
import com.zeligsoft.base.validation.util.InvalidConstraintException;
import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * A factory for link constraints specified in OCL.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLLinkConstraintFactory
		implements ILinkConstraintFactory<IBinaryLinkConstraint> {

	private LinkConstraintContext context;

	/**
	 * Initializes me with my context.
	 * 
	 * @param context
	 *            the context in which the constraints I create are checked
	 */
	public OCLLinkConstraintFactory(LinkConstraintContext context) {
		super();

		this.context = context;
	}

	@Override
	public String getKind() {
		return context.kind();
	}

	@Override
	public String getLanguage() {
		return IOCLProvider.OCL_LANGUAGE;
	}

	@Override
	public Class<IBinaryLinkConstraint> getType() {
		return IBinaryLinkConstraint.class;
	}

	@Override
	public IBinaryLinkConstraint createLinkConstraint(Constraint specification)
			throws InvalidConstraintException {
		
		return new OCLLinkConstraint(specification, context);
	}

}
