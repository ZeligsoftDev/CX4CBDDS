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

package com.zeligsoft.base.deployment.rsm.tooling.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.ibm.xtools.uml.navigator.IModelServerElement;
import com.zeligsoft.base.deployment.rsm.tooling.utils.DeploymentNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A deployment part filter for the Project Explorer. Filters out the
 * IModelServerElements that have the zdl DeploymentNames.DEPLOYMENT_PART
 * concept applied.
 * 
 * @author schafe
 * 
 */
public class DeploymentViewerFilter
		extends ViewerFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		boolean result = true;

		// Return false for IModelServerElements that have
		// the zdl DeploymentNames.DEPLOYMENT_PART concept applied.
		if (element instanceof IModelServerElement) {
			IModelServerElement modelElement = (IModelServerElement) element;
			EObject eObject = modelElement.getModelElementDescriptor()
				.getElement();
			boolean isDeploymentPart = ZDLUtil.isZDLConcept(eObject,
				DeploymentNames.DEPLOYMENT_PART);
			if (isDeploymentPart) {
				result = false;
			}
		}

		return result;
	}

}
