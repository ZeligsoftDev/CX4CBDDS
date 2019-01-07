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
package com.zeligsoft.base.validation.test.constraints;

import static com.zeligsoft.base.validation.test.TestValidationNames.OTHER;
import static com.zeligsoft.base.validation.test.TestValidationNames.OTHER__NAME;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING__IS_ENABLED;
import static com.zeligsoft.base.validation.test.TestValidationNames.THING__OTHER;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;


/**
 * Test constraint for JUnit testing of the ZDL validation framework.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ThingConstraint
		extends AbstractModelConstraint {

	/**
	 * Initializes me.
	 */
	public ThingConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		String id = ctx.getCurrentConstraintId();
		
		if (id.endsWith("batch.1")) {
			return checkBatchOne(ctx);
		}
		
		return ctx.createSuccessStatus();
	}
	
	private IStatus checkBatchOne(IValidationContext ctx) {
		Element thing = (Element) ctx.getTarget();
		
		boolean isEnabled = (Boolean) ZDLUtil.getValue(thing, THING, THING__IS_ENABLED);
		
		if (isEnabled) {
			@SuppressWarnings("unchecked")
			List<Element> others = (List<Element>) ZDLUtil.getValue(thing, THING, THING__OTHER);
			
			boolean found = false;
			
			for (Element next : others) {
				if (ZDLUtil.isZDLConcept(next, OTHER)) {
					String otherName = (String) ZDLUtil.getValue(next, OTHER, OTHER__NAME);
					if ("Bob".equals(otherName)) {
						found = true;
						break;
					}
				}
			}
			
			if (!found) {
				return ctx.createFailureStatus(new Object[] {thing});
			}
		}
		
		return ctx.createSuccessStatus();
	}

}
