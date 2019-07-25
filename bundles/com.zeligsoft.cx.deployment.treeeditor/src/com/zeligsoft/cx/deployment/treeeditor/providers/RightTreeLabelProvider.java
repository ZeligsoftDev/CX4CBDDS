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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.ui.utils.ZDLImageRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * The label provider for the left tree. It takes in a deployment part
 * (property) and returns the name and icon for this part. This will also
 * display the parts which are deployed in bold.
 * 
 * @author sduchesneau
 */
public class RightTreeLabelProvider
		implements ILabelProvider, IFontProvider {

	Font boldFont;

	/**
	 * Constructor
	 */
	public RightTreeLabelProvider(Font font) {
		FontData fontDataArray[] = font.getFontData();
		FontData fontData = null;

		if (fontDataArray.length > 0)
			fontData = new FontData(fontDataArray[0].getName(),
				fontDataArray[0].getHeight(), SWT.BOLD);
		else
			fontData = new FontData("Arial", 8, SWT.BOLD); //$NON-NLS-1$

		boldFont = new Font(null, fontData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		
		Image image = null;
		
		if( element instanceof EObject ) {
			if( ZDLUtil.isZDLConcept((EObject)element, ZMLMMNames.DEPLOYMENT_PART)) {
				image = ZDLImageRegistry.getInstance().getZDLIcon(
						ZDeploymentUtil.getModelElement((Property)element));
				if( image != null ) {
					return image;
				}
			}
		}
		
		if (element instanceof Property) {
			Property property = (Property) element;
			Type type = property.getType();
			if (type != null) {
				image = ZDLImageRegistry.getInstance().getZDLIcon(type);
			}
		} 
		
		if (image == null){			
			NamedElement modelElement = ZDeploymentUtil.getModelElement((Property)element);
			if (modelElement != null){
				image = IconService.getInstance().getIcon(new EObjectAdapter(modelElement));
			}
			
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
				return ZDeploymentUtil.getQualifiedName(part);
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
		boldFont.dispose();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
	 */
	@Override
	public Font getFont(Object element) {
		if (element instanceof Property) {
			Property part = (Property) element;
			boolean isPartOrAncestorDeployed = false;

			while (part != null) {
				if (ZDeploymentUtil.getDeploymentTargetPart(part) != null) {
					isPartOrAncestorDeployed = true;
					break;
				}

				part = ZDeploymentUtil.getParentPart(part);
			}

			if (isPartOrAncestorDeployed) {
				return boldFont;
			}
		}

		return null;
	}

}
