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

package com.zeligsoft.cx.deployment.rsm.editor.providers;

import java.util.Collection;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.ce.tableeditor.ITableEditorProvider;
import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;


/**
 * Label provider for the deployment table. This is where cell contents and look and feel can be
 * customized.
 * 
 * @author smcfee
 *
 */
public class DeploymentTableLabelProvider implements ITableEditorProvider  
{
	Component deployment;
	
	public DeploymentTableLabelProvider(Component deployment)
	{
		this.deployment = deployment;
		//super(adapterFactory);
	}

	/**
	 * Get the background color of the cell. This is grey for a header cell and white otherwise.
	 */
	public Color getBackground(Object element, int columnIndex)
	{
		//if( element instanceof DeploymentTableRow )
		//{
			//return ColorConstants.button;
		//}		
		return ColorConstants.white;
	}

	/**
	 * This function determines the text color of the cell. For now we don't care. 
	 */
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}

	/**
	 * For now, do nothing.
	 * SWT fonts are a bit more complicated than AWT fonts unfortunately.
	 * When we want to change the font depending on the cell we will do it here.
	 */
	public Font getFont(Object element, int columnIndex)
	{
		//Font font = new Font(null, "Arial", 20, SWT.NONE);
		//return font;
		return null; 
	}		
	
	public void notifyChanged(Notification notification)
	{
	}
	
	public String getColumnText(Object object, int columnIndex)
	{
				
		if (object instanceof Property)
		{
			Property rowPart = (Property) object;
			if (rowPart == null)
				return "";
	
			Collection<Property> col = ZDeploymentUtil.getDeploymentParts(deployment);
			
			Property columnPart = null;
			int i=0;
			for (Property prop: col)
			{
				if (i == columnIndex)
				{
					columnPart = prop;
					break;
				}
				i++;
			}
		
		
			if(ZDeploymentUtil.getPartDeployedOn(rowPart) == columnPart)
			{
				return "X";
			}	
		}		
		
		return "";		
	}

	public Font getFont(Object element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Color getBackground(Object element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Color getForeground(Object element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Image getColumnImage(Object element, int columnIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void addListener(ILabelProviderListener listener)
	{
		// TODO Auto-generated method stub
		
	}

	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener)
	{
		// TODO Auto-generated method stub
		
	}
}
