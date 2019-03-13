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
package com.zeligsoft.base.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.diagram.ui.Activator;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Icon provider for Zeligsoft's diagram types.
 * 
 * @author ysroh
 * 
 */
public class ZeligsoftDiagramIconProvider implements IIconProvider {

	private final static String DIAGRAM_ICON_PATH = "icons/obj16/component_diagram.gif"; //$NON-NLS-1$

	private final static String COMPONENT_DIAGRAM_TYPE = "Component"; //$NON-NLS-1$

	private static ImageDescriptor componentDiagramImageDesc;

	private Image diagramIconImage = null;

	static {
		// get product specific icon if available
		componentDiagramImageDesc = BaseUIUtil
				.getIconImageDescriptorFromProductBundle(DIAGRAM_ICON_PATH);
		if (componentDiagramImageDesc == null) {
			// get default diagram icon
			Bundle pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);
			componentDiagramImageDesc = ImageDescriptor
					.createFromURL(pluginBundle.getEntry(DIAGRAM_ICON_PATH));
		}
	}

	@Override
	public Image getIcon(IAdaptable hint, int flags) {

		if (hint == null) {
			return null;
		}
		Diagram diagram = (Diagram) hint.getAdapter(Diagram.class);
		if (diagram != null) {
			if (COMPONENT_DIAGRAM_TYPE.equals(diagram.getType())
					&& componentDiagramImageDesc != null) {
				if (diagramIconImage == null) {
					diagramIconImage = componentDiagramImageDesc.createImage();

				}
				return diagramIconImage;
			}
		}

		return null;
	}

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof IconOperation) {
			IconOperation iconOperation = (IconOperation) operation;

			IAdaptable adapter = iconOperation.getHint();

			if (adapter == null) {
				return false;
			}

			Diagram diagram = (Diagram) adapter.getAdapter(Diagram.class);
			if (diagram != null) {
				if (COMPONENT_DIAGRAM_TYPE.equals(diagram.getType())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

}
