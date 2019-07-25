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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Validation client-context selector for the ZDL domain-model content type.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLModelInstanceSelector
		implements IClientSelector {

	/**
	 * Initializes me.
	 */
	public ZDLModelInstanceSelector() {
		super();
	}

	@Override
	public boolean selects(Object object) {
		boolean result = false;

		if (object instanceof Element) {
			// model element
			result = !ZDLUtil.getZDLProfiles((Element) object).isEmpty();
		} else if (object instanceof EObject) {
			// stereotype application or profile class instance
			EObject root = EcoreUtil.getRootContainer(((EObject) object)
				.eClass());
			if (root instanceof Profile) {
				result = !ZDLUtil.getZDLProfiles((Profile) root).isEmpty();
			}
		}

		return result;
	}

}
