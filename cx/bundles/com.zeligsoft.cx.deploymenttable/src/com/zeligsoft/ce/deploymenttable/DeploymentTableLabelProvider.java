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

package com.zeligsoft.ce.deploymenttable;

import java.util.ArrayList;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.tableeditor.ITableEditorProvider;


/**
 * Label provider for the deployment table. This is where cell contents and look and feel can be
 * customized.
 * 
 * @author smcfee
 *
 */
public class DeploymentTableLabelProvider extends AdapterFactoryLabelProvider implements ITableEditorProvider  
{
	
	public DeploymentTableLabelProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
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
		if (object instanceof DeploymentPart)
		{
			DeploymentPart part = (DeploymentPart) object;
			if (part == null)
				return "";
	
			// See if the part is deployed on a part with the name of the current column.
			ArrayList<DeploymentPart> deploymentParts = part.getContainingDeployment().getDeploymentParts();
			
			DeploymentPart dp = part.getPartDeployedOn();
			if (dp != null)
			{
				if(((DeploymentPart)deploymentParts.get(columnIndex)).getId() == dp.getId())
				{
					return "X";
				}
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
}
