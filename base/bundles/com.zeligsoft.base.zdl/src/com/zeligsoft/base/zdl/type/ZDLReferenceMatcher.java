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
package com.zeligsoft.base.zdl.type;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A GMF element-type element matcher for the owners of ZDL domain references.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLReferenceMatcher
		implements IElementMatcher {

	private final String concept;

	private final String reference;

	/**
	 * Initializes me with the qualified name of the concept that I match.
	 * 
	 * @param concept
	 *            the concept's qualified name
	 * @param reference
	 *            the name of the domain reference
	 */
	public ZDLReferenceMatcher(String concept, String reference) {
		this.concept = concept;
		this.reference = reference;
	}

	public boolean matches(EObject object) {
		return ZDLUtil.hasZDLProperty(object, concept, reference);
	}

}
