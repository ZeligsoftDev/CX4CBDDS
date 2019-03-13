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
package com.zeligsoft.base.ui.viewcustomizers;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * View customizer for UML Component views.
 * 
 * @author jcorchis
 * 
 */
public class ComponentViewCustomizer
		extends BaseViewCustomizer {	
	
	/**
	 * The only instance of <code>ComponentViewCustomizer</code>
	 */
	public static ComponentViewCustomizer INSTANCE = new ComponentViewCustomizer();

	protected ComponentViewCustomizer() {
		// do not instantiate
	}

	/**
	 * Sets the Component View style so that the External View is shown when
	 * visualized. The list compartments are not visible.
	 * 
	 * @param view
	 *            the <code>Node</code> view for a <code>Component</code>.
	 */
	@Override
	public void customizeView(View view) {
		
		// Do not customize the view if the context of the Component is RSMs
		// Struture diagram, the defaults are sufficient.
		if (view.eContainer() instanceof Diagram
			&& "Structure".equals(((Diagram) view.eContainer()).getType())) {//$NON-NLS-1$
			return;
		}
		
		super.customizeView(view);		
	}	

}
