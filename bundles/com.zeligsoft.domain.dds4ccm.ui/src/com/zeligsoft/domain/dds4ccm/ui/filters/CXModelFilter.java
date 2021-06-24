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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * CX model explore content filter
 * 
 * @author ysroh
 * 
 */
public class CXModelFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean result = true;

		EObject eObject = EMFHelper.getEObject(element);
		if (eObject == null) {
			return result;
		}

		// Hide non local models
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eObject);
		if (element instanceof EObjectTreeElement && ((EObjectTreeElement) element).getParent() == null
				&& domain.isReadOnly(eObject.eResource())) {
			URI uri = URIConverter.INSTANCE.normalize(eObject.eResource().getURI());
			if ("platform".equals(uri.scheme()) && "resource".equals(uri.segment(0))) {  //$NON-NLS-1$//$NON-NLS-2$
				return true;
			}
			return false;
		}

		if (eObject instanceof Element
				&& ZDLUtil.isZDLProfile((Element) eObject, DDS4CCMDomainFilter.DDS4CCM_PROFILE_NAME)) {
			// filter out elements from CX model
			if (ZDLUtil.isZDLConcept(eObject, ZMLMMNames.WORKER_FUNCTION)) {
				return false;
			}
			if (ZDLUtil.isZDLConcept(eObject, ZMLMMNames.WORKER_FUNCTION_IMPL)) {
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

		// filter out CX annotations
		if (eObject instanceof EAnnotation) {
			EAnnotation ea = (EAnnotation) eObject;
			String source = ea.getSource();
			if (!UML2Util.isEmpty(source) && (source.startsWith("cx") || source.startsWith("zcx"))) { //$NON-NLS-1$ //$NON-NLS-2$
				return false;
			}
		}

		// filter out CX Domain models
		if (eObject.eResource() != null && domain.isReadOnly(eObject.eResource()) && ZDLUtil.isZDLConcept(eObject, ZDLNames.DOMAIN_MODEL)) {
			return false;
		}

		return result;
	}
}
