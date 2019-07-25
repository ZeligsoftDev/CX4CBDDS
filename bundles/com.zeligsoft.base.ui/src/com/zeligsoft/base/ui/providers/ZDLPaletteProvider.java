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

package com.zeligsoft.base.ui.providers;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement; 
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.ui.IEditorPart;


/**
 * GMF diagram-editor palette provider that, basically, just delegates to the
 * dynamic ZDL-driven {@link ZDLPaletteFactory}.
 * 
 * @author Christian W. Damus
 */
@SuppressWarnings("rawtypes") // GMF is not J2SE 5.0
public class ZDLPaletteProvider extends AbstractProvider implements IPaletteProvider {

	/**
	 * Initializes me.
	 */
	public ZDLPaletteProvider() {
		super();
	}
	
	@Override
	public void contributeToPalette(IEditorPart editorPart, Object o,
			PaletteRoot paletteRoot, Map map) {
		new ZDLPaletteFactory((DiagramEditor) editorPart).fillPalette(paletteRoot);
	}

	@Override
	public void setContributions(IConfigurationElement configurationElement) {
		 // nothing to do
	}

	@Override
	public boolean provides(IOperation operation) {
		return false;
	}

}
