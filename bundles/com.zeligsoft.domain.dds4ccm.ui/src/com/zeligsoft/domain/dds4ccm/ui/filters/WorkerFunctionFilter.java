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

package com.zeligsoft.domain.dds4ccm.ui.filters;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * WorkerFunctionImpl filter
 * 
 * @author ysroh
 * 
 */
public class WorkerFunctionFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean result = true;

		EObject eObject = null;
		if (element instanceof IAdaptable) {
			eObject = (EObject) ((IAdaptable) element)
					.getAdapter(EObject.class);
		} else if (element instanceof EObject) {
			eObject = (EObject) element;
		}
		if (eObject != null && eObject instanceof Element) {
			if (ZDLUtil.isZDLProfile((Element) eObject,
					DDS4CCMDomainFilter.DDS4CCM_PROFILE_NAME)
					&& (ZDLUtil.isZDLConcept(eObject,
							ZMLMMNames.WORKER_FUNCTION))) {
				return false;
			}
		}

		return result;
	}
}
