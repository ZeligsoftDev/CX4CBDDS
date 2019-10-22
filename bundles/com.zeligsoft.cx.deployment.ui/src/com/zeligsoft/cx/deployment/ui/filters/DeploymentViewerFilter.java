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

package com.zeligsoft.cx.deployment.ui.filters;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

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
		EObject eObject = null;
		if (element instanceof IAdaptable) {
			eObject = ((IAdaptable) element).getAdapter(EObject.class);
		} else if (element instanceof EObject) {
			eObject = (EObject) element;
		}
		
		if (eObject != null) {
			// if licensing fails this class will not be found
			try {
				Class.forName("com.zeligsoft.base.zdl.util.ZDLUtil"); //$NON-NLS-1$
			} catch (ClassNotFoundException ex) {
				return false;
			}
			
			if ((ZDLUtil.isZDLConcept(eObject, ZMLMMNames.DEPLOYMENT_PART))
				|| (ZDLUtil.isZDLConcept(eObject, ZMLMMNames.ALLOCATION))) {
				return false;
			}
			
			// hide packages containing instance specification for CCM properties
			if (eObject instanceof Package && eObject.eContainer() != null
					&& ZDLUtil.isZDLConcept(eObject.eContainer(), ZMLMMNames.DEPLOYMENT)) {
				return false;
			}
		}

		return result;
	}

}
