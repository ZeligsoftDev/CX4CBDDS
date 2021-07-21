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
package com.zeligsoft.domain.dds4ccm.ui.internal.filters;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.filters.DDS4CCMDomainFilter;

public class CBDDSPropertiesFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		EObject eo = null;
		if (toTest instanceof EObject) {
			eo = (EObject) toTest;
		} else if (toTest instanceof IAdaptable) {
			eo = ((IAdaptable) toTest).getAdapter(EObject.class);
		} else if (toTest instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) toTest;
			Object input = selection.getFirstElement();
			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) input;
				View view = (View) graphicalEditPart.getModel();
				eo = view.getElement();
			} else {
				eo = resolveSemanticObject(input);
			}
		}
		if (eo == null || !(eo instanceof Element)) {
			return false;
		}

		return ZDLUtil.isZDLProfile((Element) eo, DDS4CCMDomainFilter.DDS4CCM_PROFILE_NAME);
	}

	private EObject resolveSemanticObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		} else if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			if (EMFHelper.getEObject(adaptable) != null) {
				return EMFHelper.getEObject(adaptable);
			}
		}
		return null;
	}
}
