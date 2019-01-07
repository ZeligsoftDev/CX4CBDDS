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

package com.zeligsoft.cx.deployment.treeeditor.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.ui.utils.OverlayImageDescriptor;
import com.zeligsoft.base.ui.utils.ZDLImageRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * The label provider for the left tree. It takes in a deployment part
 * (property) and returns the name and icon for this part.
 * 
 * @author sduchesneau
 */
public class LeftTreeLabelProvider
		implements ILabelProvider {

	private static HashMap<Image, Image> deployedImageHashMap = new HashMap<Image, Image>();

	private static HashMap<Image, Image> errorImageHashMap = new HashMap<Image, Image>();

	private static HashMap<Image, Image> warningImageHashMap = new HashMap<Image, Image>();

	private static final String ICONS_FOLDER = "icons/"; //$NON-NLS-1$

	private static ImageDescriptor descriptor = AbstractUIPlugin
			.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ICONS_FOLDER
					+ "deployed.gif"); //$NON-NLS-1$

	private static ImageDescriptor errorImageDesc = AbstractUIPlugin
			.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ICONS_FOLDER
					+ "error_co.gif"); //$NON-NLS-1$

	private static ImageDescriptor warningImageDesc = AbstractUIPlugin
			.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ICONS_FOLDER
					+ "warning_co.gif"); //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {

		if (!(element instanceof EObject)) {
			return null;
		}
		Image image = null;

		if (element instanceof Property) {
			Property property = (Property) element;
			Type type = property.getType();
			EObject modelElement = ZDeploymentUtil.getModelElement(property);
			if (modelElement != null
					&& ZDLUtil.isZDLConcept(modelElement, ZMLMMNames.PORT)) {
				image = ZDLImageRegistry.getInstance().getZDLIcon(modelElement);
			} else if (type != null) {
				image = ZDLImageRegistry.getInstance().getZDLIcon(type);
			}
		} else if (ZDLUtil.isZDLConcept((EObject) element,
				ZMLMMNames.DEPLOYMENT_PART)) {
			image = ZDLImageRegistry.getInstance().getZDLIcon(
					ZDeploymentUtil.getModelElement((Property) element));
		}

		if (image == null) {
			NamedElement modelElement = ZDeploymentUtil
					.getModelElement((Property) element);
			if (modelElement != null) {
				image = IconService.getInstance().getIcon(
						new EObjectAdapter(modelElement));
			}
		}

		// no icon is found
		if (image == null) {
			return null;
		}

		// Overlay icon to show this deployment part is deployed
		image = displayOverlayIconIfDeployed(image, element);

		// Overlay appropriate icon if the deployment part has validation
		// error/warning
		Map<EObject, Integer> map = DeploymentPartValidationObserver.results;
		Integer severity = map.get(element);
		if (severity != null) {
			if (severity.intValue() == IStatus.ERROR) {
				if (errorImageHashMap.containsKey(image)) {
					image = errorImageHashMap.get(image);
				} else {
					OverlayImageDescriptor overlayImageDescriptor = new OverlayImageDescriptor(
							image, errorImageDesc);
					overlayImageDescriptor
							.setOverlayPosition(PositionConstants.SOUTH_WEST);
					errorImageHashMap.put(image,
							overlayImageDescriptor.createImage());
					image = errorImageHashMap.get(image);
				}
			} else if (severity.intValue() == IStatus.WARNING) {
				if (warningImageHashMap.containsKey(image)) {
					image = warningImageHashMap.get(image);
				} else {
					OverlayImageDescriptor overlayImageDescriptor = new OverlayImageDescriptor(
							image, warningImageDesc);
					overlayImageDescriptor
							.setOverlayPosition(PositionConstants.SOUTH_WEST);
					warningImageHashMap.put(image,
							overlayImageDescriptor.createImage());
					image = warningImageHashMap.get(image);
				}
			}
		}
		return image;

	}

	/**
	 * 
	 * @param baseImage
	 *            the image icon of Object element
	 * @param element
	 * @return an overlay icon if Object element is deployed, or the original 
	 *         image icon of element, otherwise.
	 * @author hguo
	 */
	public Image displayOverlayIconIfDeployed(Image baseImage, Object element) {
		if (descriptor == null) {
			return baseImage;
		}

		Image image = null;
		if (element instanceof Property) {
			if (ZDLUtil.isZDLConcept((EObject) element,
					ZMLMMNames.DEPLOYMENT_PART)) {
				if (ZDeploymentUtil.getDeploymentTargetPart((Property) element) != null) {
					image = deployedImageHashMap.get(baseImage);
					if (image != null) {
						return image;
					}

					OverlayImageDescriptor overlayImageDescriptor = new OverlayImageDescriptor(
							baseImage, descriptor);
					overlayImageDescriptor.setOverlayPosition(PositionConstants.EAST);
					deployedImageHashMap.put(baseImage,
							overlayImageDescriptor.createImage());
					image = deployedImageHashMap.get(baseImage);
				} else {
					image = baseImage;
				}
			}
		} else {
			image = baseImage;
		}
		return image;
	}
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof Property) {
			Property part = (Property) element;

			if( ZDLUtil.isZDLConcept(part, ZMLMMNames.DEPLOYMENT_PART)) {
				if( ZDeploymentUtil.getParentPart(part) == null) {
					return part.getName();
				}
				return ((NamedElement)ZDLUtil.getValue
					(part, ZMLMMNames.DEPLOYMENT_PART, ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT)).getName();
			}
			return part.getName();
		}
		return ""; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
	 *      java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}
}
