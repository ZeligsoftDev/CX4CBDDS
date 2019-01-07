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
package com.zeligsoft.domain.idl3plus.ui.utils;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zeligsoft.cx.ui.utils.CXWidgetFactory;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;

/**
 * Port decoration image registry
 * 
 * @author ysroh
 * 
 */
public class PortDecorationImages {

	private static ImageRegistry imageRegistry = null;

	private static final String ICONS_FOLDER = "icons/obj16/"; //$NON-NLS-1$

	public static final String PUBLISHER_ICON = ICONS_FOLDER
			+ "publisher-port.gif"; //$NON-NLS-1$

	public static final String CONSUMER_ICON = ICONS_FOLDER
			+ "consumer-port.gif"; //$NON-NLS-1$

	public static final String FACET_ICON = ICONS_FOLDER + "facet-port.gif"; //$NON-NLS-1$

	public static final String RECEPTACLE_ICON = ICONS_FOLDER
			+ "receptacle-port.gif"; //$NON-NLS-1$

	/**
	 * Get image
	 * 
	 * @param String
	 *            key
	 * @return Image image
	 */
	public static Image getImage(String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * Get imageRegistry
	 * 
	 * @return ImageRegistry imageRegistry
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = Activator.getDefault().getImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * Queries the default publisher icon
	 * 
	 * @param portSide
	 * @return
	 */
	public static Image getPublisherIcon(int portSide) {
		return getPortIcon(Activator.PLUGIN_ID, PUBLISHER_ICON, portSide);
	}

	/**
	 * Queries the default consumer icon
	 * 
	 * @param portSide
	 * @return
	 */
	public static Image getConsumerIcon(int portSide) {
		return getPortIcon(Activator.PLUGIN_ID, CONSUMER_ICON, portSide);
	}

	/**
	 * Queries the default facet icon
	 * 
	 * @param portSide
	 * @return
	 */
	public static Image getFacetIcon(int portSide) {
		return getPortIcon(Activator.PLUGIN_ID, FACET_ICON, portSide);
	}

	/**
	 * Queries the default receptacle icon
	 * 
	 * @param portSide
	 * @return
	 */
	public static Image getReceptacleIcon(int portSide) {
		return getPortIcon(Activator.PLUGIN_ID, RECEPTACLE_ICON, portSide);
	}

	public static Image getPortIcon(String pluginId, String location,
			int portSide) {
		String key = pluginId + "_" + location + "_" + portSide;//$NON-NLS-1$ //$NON-NLS-2$
		Image image = getImageRegistry().get(key);
		if (image != null) {
			return image;
		}
		ImageDescriptor descriptor = AbstractUIPlugin
				.imageDescriptorFromPlugin(pluginId, location);

		if (descriptor == null) {
			Activator.getDefault().error(
					Messages.PortDecorationImages_IconNotFoundError + pluginId
							+ "/" //$NON-NLS-1$
							+ location, new IllegalArgumentException());
			return null;
		}
		ImageData data = descriptor.getImageData();
		switch (portSide) {
		case PositionConstants.WEST:
			data = CXWidgetFactory.rotate(descriptor.getImageData(), SWT.DOWN);
			break;
		case PositionConstants.NORTH:
			data = CXWidgetFactory.rotate(descriptor.getImageData(), SWT.LEFT);
			break;
		case PositionConstants.SOUTH:
			data = CXWidgetFactory.rotate(descriptor.getImageData(), SWT.RIGHT);
			break;
		}
		ImageDescriptor newDescriptor = ImageDescriptor
				.createFromImageData(data);
		getImageRegistry().put(key, newDescriptor.createImage());
		return getImageRegistry().get(key);
	}
}
