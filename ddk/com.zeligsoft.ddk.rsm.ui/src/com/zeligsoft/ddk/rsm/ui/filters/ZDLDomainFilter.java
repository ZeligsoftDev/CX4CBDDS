/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.rsm.ui.filters;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.filters.AbstractDomainFilter;

/**
 * SCA Domain Filter
 * 
 * @author Toby McClean
 * 
 */
public class ZDLDomainFilter
		extends AbstractDomainFilter {

	public ZDLDomainFilter() {
		super(ZDLUtil.ZDL_NAMESPACE_URI);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	@Override
	public boolean select(Object toTest) {
		EObject eObject = null;
		if (toTest instanceof EObject) {
			eObject = (EObject) toTest;
		} else if (toTest instanceof IAdaptable) {
			eObject = ((IAdaptable) toTest).getAdapter(EObject.class);
		} else if (toTest instanceof StructuredSelection) {
			eObject = BaseUIUtil
				.getEObjectFromSelection((StructuredSelection) toTest);
		}

		if (eObject == null) {
			return false;
		}

		if (!(eObject instanceof Element)) {
			return false;
		}
		
		if (!ZDLUtil.isZDLProfile((Element) eObject, "ZDL")) { //$NON-NLS-1$
			return false;
		}
		List<Class> concepts = ZDLUtil.getZDLConcepts(eObject);
		if (!concepts.isEmpty()) {
			return true;
		}
		return false;
	}
}
