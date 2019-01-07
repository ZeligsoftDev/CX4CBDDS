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
package com.zeligsoft.domain.idl3plus.ui.internal.providers.filter;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.edit.MObjectType;
import org.eclipse.gmf.runtime.emf.core.util.EObjectUtil;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;

/**
 * A filter to hide the contents of a template module instantiation. So that
 * we don't see the elements of it that were expanded based on its bindings.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class TemplateModuleContentsFilter extends ViewerFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers
	 * .Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object anElement) {
		boolean result = true;
		Object element = resolveElement(anElement);

		if (element instanceof EObject) {
			EObject container = ((EObject) element).eContainer();

			if(container != null) {
				result = !ZDLUtil.isZDLConcept(container,
					IDL3PlusNames.MODULE_INSTANTIATION );
			}
		}

		return result;
	}

	/**
	 * Given an Object unwrap it and return the EObject that it is
	 * adapting.
	 * 
	 * @param anElement
	 * 		An object that could potentially be an adapter.
	 * @return
	 * 		The EObject that may have been adapted.
	 */
	protected EObject resolveElement(Object anElement) {
		EObject returnValue = null;
		if (anElement instanceof EObject)
			returnValue = (EObject) anElement;
		else if (anElement instanceof IAdaptable) {
			returnValue = (EObject) ((IAdaptable) anElement)
					.getAdapter(EObject.class);
		}

		if ((returnValue != null)
				&& (EObjectUtil.getType(returnValue) != MObjectType.MODELING)) {
			returnValue = null;
		}

		return returnValue;
	}
	
	
}
