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
package com.zeligsoft.base.validation.util;

import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Profile;

/**
 * The interface of objects that provide the context required to transform OCL
 * constraints defined on some ZDL concept in the context of a profile that
 * manifests this concept.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface IOCLProvider {

	/**
	 * Constant declaration of the <tt>"OCL"</tt> language name, as it appears
	 * in {@link OpaqueExpression} elements in ZDL models.
	 */
	String OCL_LANGUAGE = "OCL"; //$NON-NLS-1$
	
	/**
	 * Queries the ZDL concept in which context the OCL constraint condition is
	 * defined.
	 * 
	 * @return the contextual concept's qualified name
	 */
	String getConcept();

	/**
	 * Queries the OCL specification of the constraint condition.
	 * 
	 * @return the OCL text
	 */
	String getOCL();

	/**
	 * Configures the specified helper's environment for parsing my constraint
	 * text in the specified profile context. This includes, at the very least,
	 * setting the helper's context classifier.
	 * 
	 * @param helper
	 *            the OCL helper to configure
	 * @param env
	 *            the helper's parsing environment
	 * @param profile
	 *            the domain profile context in which we are parsing the
	 *            constraint
	 */
	@SuppressWarnings("rawtypes")
	void configure(OCLHelper helper, UMLEnvironment env, Profile profile);
}
