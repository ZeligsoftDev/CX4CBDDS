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

package com.zeligsoft.cx.deployment.rsm.editor;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.uml2.uml.Component;

/**
 * This class defines the input of the deployment editor.  It is required to 
 * start the deployment editor.  Name, tool tip text, and deployment must be set. 
 *  
 *  @author sduchesneau
 */
public class DeploymentEditorInput implements IEditorInput
{
	private String name;
	private String toolTipText;
	private Component deployment;
	
	/**
	 * Set the name of the deployment.
	 * @param name
	 * 		the name of the deployment
	 */
	public void setName(String name)
	{
		this.name = name;		
	}

	/**
	 * Set the deployment
	 * @param deployment
	 * 		this is an UML component describing the deployment.   
	 */
	public void setDeployment(Component deployment)
	{
		this.deployment = deployment;		
	}
	
	/**
	 * Get the depoyment.
	 * @returns The deployment (Component)
	 */
	public Component getDeployment()
	{
		return deployment;
		
	}	
		
	/**
	 * This sets the tool tip text (the text displayed when you drag your mouse the tab.) 
	 */
	public void setToolTipText(String toolTipText)
	{
		this.toolTipText = toolTipText;		
	}

	public boolean exists()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public ImageDescriptor getImageDescriptor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getName()
	{
		return name;
	}

	public IPersistableElement getPersistable()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getToolTipText()
	{
		// TODO Auto-generated method stub
		return toolTipText;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof DeploymentEditorInput) {
			if (deployment == ((DeploymentEditorInput) o).getDeployment()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		if(getDeployment() != null)
			return getDeployment().hashCode();
		else
			return super.hashCode();
	}
}
