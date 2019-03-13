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
package com.zeligsoft.base.validation.provider.java;

import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.uml2.uml.Constraint;

import com.zeligsoft.base.validation.provider.IZDLConstraintFactory;
import com.zeligsoft.base.validation.util.InvalidConstraintException;
import com.zeligsoft.base.validation.util.ValidationUtil;

/**
 * A factory for constraints defined in the <tt>Java</tt> language. These
 * constraints specify a class in the bundle that deploys the ZDL model in which
 * the constraint is defined.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class JavaConstraintFactory
		implements IZDLConstraintFactory {

	private static String LANG_JAVA = "Java"; //$NON-NLS-1$

	/**
	 * Initializes me.
	 */
	public JavaConstraintFactory() {
		super();
	}

	@Override
	public String getLanguage() {
		return LANG_JAVA;
	}

	@Override
	public IModelConstraint createConstraint(Constraint umlConstraint,
			String body, IConstraintDescriptor descriptor)
			throws InvalidConstraintException {

		// some people like to put trailing semicolons
		body = body.trim();
		while (body.endsWith(";")) { //$NON-NLS-1$
			body = body.substring(0, body.length() - 1);
			body = body.trim();
		}

		return new JavaConstraint(body, ValidationUtil
			.getPluginID(umlConstraint), descriptor);
	}
}
