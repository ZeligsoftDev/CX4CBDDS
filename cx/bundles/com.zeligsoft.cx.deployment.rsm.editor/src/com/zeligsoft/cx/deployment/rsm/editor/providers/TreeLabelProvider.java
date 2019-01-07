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


import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Property;

/**
 * The label provider for both the horizontal table tree and the vertical tree.  It takes in a deployment part (property)
 * and returns the name of this part.
 * 
 *  @author sduchesneau 
 */
public class TreeLabelProvider implements ILabelProvider
{

	public Image getImage(Object element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(Object element)
	{
		if (element instanceof Property)
		{
			Property part = (Property) element;
			return part.getName();			
			
		}
		return "";
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
