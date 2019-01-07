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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;

/**
 * This is the content provider for the deployment table editor.  It provides the input in form of a tree.
 * For input it takes the deployment.  It returns the deployment parts (Properties).
 * 
 *  @author sduchesneau
 */
public class TreeContentProvider implements ITreeContentProvider
{
	//AdapterFactoryContentProvider.ViewerRefresh viewerRefresh;
	private Viewer viewer;
	private EContentAdapter contentAdapter;	
	private Component deployment;

	public Object[] getChildren(Object parentElement)
	{
		if (parentElement instanceof Property)
		{
			Property parentPart = (Property) parentElement;
			
			Collection<Property> col = ZDeploymentUtil.getDeploymentChildren(parentPart);
			
			Property[] childArray = new Property[col.size()];

			int i=0;
			for (Property prop: col)
			{
				childArray[i] = prop;
				i++;
			}
			return childArray;
		}
		
		return null;
	}

	public Object getParent(Object element)
	{
		if (element instanceof Property)
		{
			Property part = (Property) element;
			return ZDeploymentUtil.getParentPart(part);
		}
		
		return null;
	}

	public boolean hasChildren(Object element)
	{
		
		if (getChildren(element).length > 0)
			return true;
		return false;
	}

	public Object[] getElements(Object inputElement)
	{
		if (inputElement instanceof Component)
		{
			deployment = (Component) inputElement;

			if (contentAdapter == null)
			{
					
				EList<Adapter> adapters = deployment.eAdapters();
				
				EContentAdapter contentAdapter = new EContentAdapter()
				{
					public void notifyChanged(Notification notification)
					 {
					 	super.notifyChanged(notification);
						//NotifyChangedToViewerRefresh.handleNotifyChanged(viewer, notification.getNotifier(),  notification.getEventType(),
								 //notification.getFeature(), notification.getOldValue(), notification.getNewValue(), notification.getPosition());
						viewer.refresh();
					 }
				};
					
				this.contentAdapter = contentAdapter;
				adapters.add(contentAdapter);
			}
			
			Collection<Property> col = ZDeploymentUtil.getRootDeploymentParts(deployment);
			
			Property[] partArray = new Property[col.size()];

			int i=0;
			for (Property prop: col)
			{
				partArray[i] = prop;
				i++;
			}
			return partArray;		
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose()
	{
		EList<Adapter> adapters = deployment.eAdapters();
		adapters.remove(contentAdapter);
		contentAdapter = null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		this.viewer = viewer;
	}
}
