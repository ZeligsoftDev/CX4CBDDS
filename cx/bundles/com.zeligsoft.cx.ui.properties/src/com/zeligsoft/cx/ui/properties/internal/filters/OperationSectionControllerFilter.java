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
package com.zeligsoft.cx.ui.properties.internal.filters;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class OperationSectionControllerFilter extends
		AbstractSectionControllerFilter {

	@Override
	public boolean doSelect(EObject eObject) {
		if (ZDLUtil.isZDLConcept(eObject, ZMLMMNames.COMPONENT_INTERFACE)
				|| ZDLUtil.isZDLConcept(eObject,
						ZMLMMNames.STRUCTURAL_REALIZATION)
				|| ZDLUtil.isZDLConcept(eObject, ZMLMMNames.DEPLOYMENT)
				|| ZDLUtil.isZDLConcept(eObject, ZMLMMNames.PORT_TYPE)) {
			return true;
		}
		return false;
	}

}
