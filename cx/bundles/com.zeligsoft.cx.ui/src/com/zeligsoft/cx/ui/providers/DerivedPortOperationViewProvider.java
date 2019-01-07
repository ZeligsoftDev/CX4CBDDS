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

package com.zeligsoft.cx.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.domain.zml.ui.viewcustomizers.ZMLComponentViewCustomizer;

/**
 * 
 * @author jcorchis
 * 
 */
@SuppressWarnings("rawtypes")
public class DerivedPortOperationViewProvider
		extends AbstractViewProvider {
	
	private Map<String, Class> viewMap = new HashMap<String, Class>();
	{
		viewMap.put(ZMLComponentViewCustomizer.PORT_OPERATIONS_VIEW_TYPE, ListCompartmentViewFactory.class);
	}

	@Override
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		return viewMap.get(semanticHint);
	}
	
	

}
