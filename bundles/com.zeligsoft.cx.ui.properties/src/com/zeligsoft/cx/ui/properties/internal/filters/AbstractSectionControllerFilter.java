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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.StructuredSelection;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

public abstract class AbstractSectionControllerFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		EObject eObject = null;
		if (toTest instanceof EObject) {
			eObject = (EObject) toTest;
		} else if (toTest instanceof IAdaptable) {
			eObject = (EObject) ((IAdaptable) toTest).getAdapter(EObject.class);
		} else if (toTest instanceof StructuredSelection) {
			eObject = BaseUIUtil.getEObjectFromSelection((StructuredSelection) toTest);
		}

		if (eObject == null) {
			return false;
		}
		return doSelect(eObject);
	}

	public abstract boolean doSelect(EObject eObject);
}
