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

package com.zeligsoft.base.ui.utils;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.util.IEditStringProvider;

import com.ibm.xtools.common.ui.navigator.utils.EObjectEditStringProvider;
import com.ibm.xtools.common.ui.navigator.utils.ICommonViewerContentDescriber;
import com.ibm.xtools.uml.navigator.factory.UMLNavigatorWrapperFactory;

/**
 * Utility for identifying wrapped elements in the Modelers' ProjectExplorer
 * elements.
 * 
 * @author jcorchis
 * 
 */
public class ModelerContentDescriber
		implements ICommonViewerContentDescriber {

	@Override
	public EObject getDisplayableContainer(EObject arg0) {
		EObject container = arg0.eContainer();
		while (container != null && container instanceof EAnnotation) {
			container = container.eContainer();
		}
		return container;
	}

	@Override
	public IEditStringProvider getEditStringProvider() {
		return EObjectEditStringProvider.INSTANCE;
	}

	@Override
	public Object getViewerElement(EObject arg0) {
		return UMLNavigatorWrapperFactory.getInstance().getViewerElement(arg0);
	}

}
