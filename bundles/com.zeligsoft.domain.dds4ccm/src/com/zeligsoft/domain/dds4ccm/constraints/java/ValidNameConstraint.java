/**
 * Copyright 2023 Northrop Grumman Systems Corporation.
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

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Validates whether an entity name is valid, i.e. that it doesn't contain illegal characters.
 * 
 * @author Ernesto Posse
 */
public class ValidNameConstraint extends AbstractModelConstraint {
	
	private static final String VALID_NAME_REGEX = "[a-zA-Z_](\\w|\\.)*";
	private static final Pattern VALID_NAME_PATTERN = Pattern.compile(VALID_NAME_REGEX);
	private static final Predicate<String> VALID_NAME_PREDICATE = VALID_NAME_PATTERN.asMatchPredicate();

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();
		
		if (ZDLUtil.isZDLConcept(objToVerify, ZMLMMNames.NAMED_ELEMENT)) {
			Object nameObj = ZDLUtil.getValue(objToVerify, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME);
			if (nameObj instanceof String) {
				String name = (String)nameObj;
				if (VALID_NAME_PREDICATE.test(name)) {
					return ctx.createSuccessStatus();
				}
			}
			String invalidName = nameObj != null ? nameObj.toString() : "<null>";
			return ctx.createFailureStatus(invalidName);
		}

		return null;
	}
}
