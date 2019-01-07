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


package com.zeligsoft.ce.tableeditor;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Content provider for the tree table.
 * 
 * @author sduchesneau
 *
 */
public class HorizontalTreeTableContentProvider implements IStructuredContentProvider, IChangeNotifier
{
	private ITreeContentProvider contentProvider;
	private Object[] rootElements;
	private ArrayList<INotifyChangedListener> listeners;
	private boolean updateFlatList;
	//private boolean updateLabelProvider;
	private ArrayList<Object> flatListOfElements;

	

	HorizontalTreeTableContentProvider(ITreeContentProvider contentProvider)
	{			
		this.contentProvider = contentProvider;
		
		listeners = new ArrayList<INotifyChangedListener>();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement)
	{
		rootElements = contentProvider.getElements(inputElement);
		
		int depth = getMaximumDepth(rootElements, 0);
		
		Integer[] rows = new Integer[depth+1];
		
		for (int i = 0; i <= depth; i++)
		{
			rows[i] = new Integer(i);
		}	
		
		return rows;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose()
	{
	}	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		contentProvider.inputChanged(viewer, oldInput, newInput);
		notifyDataChanged();
	}
	
	/**
	 * Get the maximum depth of all the objects in the content provider.
	 */
	private int getMaximumDepth(Object[] elements, int depth)
	{
		int maxDepth = depth;
		for (Object elem: elements)
		{
			if (contentProvider.getChildren(elem) != null && contentProvider.getChildren(elem).length > 0)
			{
				int tmpDepth = getMaximumDepth(contentProvider.getChildren(elem), depth+1);
				
				if (tmpDepth > maxDepth)
				{
					maxDepth = tmpDepth;
				}
			}
		}		
		return maxDepth;		
	}
	
	/**
	 * Get the depth of an element.  
	 */
	public int getElementDepth(Object object)
	{
		Object obj = object;
		
		int depth = 0;
		
		while (getParent(obj) != null)
		{
			depth++;
			obj = contentProvider.getParent(obj);
		}
		return depth;		
	}
	
	/**
	 * Get a flat list of all the elements.
	 */
	public ArrayList<Object> getFlatListOfElements()	
	{
		try
		{
			if (updateFlatList == false)
			return flatListOfElements;		
		
			flatListOfElements = getFlatListOfElements(convertArrayToList(rootElements));
			updateFlatList = false;
			return flatListOfElements;
		
		}
		catch (Exception ex)
		{
			int j=0;
			j++;
			
		}
		
		return new ArrayList<Object>();

	}
	
	/**
	 * Get all the children of a given element.  This function is recursive an will get the children of the 
	 * children etc...
	 */	
	public ArrayList<Object> getAllChildren(Object object)
	{
		ArrayList<Object> objectList = new ArrayList<Object>();
		for (Object obj: contentProvider.getChildren(object))
		{
			objectList.add(obj);
			objectList.addAll(getAllChildren(obj));
		}
		return objectList;		
	}
	
	private ArrayList<Object> getFlatListOfElements(ArrayList<Object> elementList)
	{
		ArrayList<Object> flatListOfElements = new ArrayList<Object>();
		for (Object obj: elementList)
		{
			flatListOfElements.add(obj);
			if (contentProvider.getChildren(obj).length > 0)
			{
				flatListOfElements.addAll(getFlatListOfElements(convertArrayToList(contentProvider.getChildren(obj))));
			}			
		}
		return flatListOfElements;		
	}
	
	private ArrayList<Object> convertArrayToList(Object[] array)
	{
		ArrayList<Object> list = new ArrayList<Object>();
		
		if (array == null) return list;
		
		for (int i=0; i<array.length; i++)
		{
			list.add(array[i]);		
		}		
		
		return list;		
	}
	
	/**
	 * Get the children of a given element.
	 */
	public Object[] getChildren(Object object)
	{
		return contentProvider.getChildren(object);		
	}
		
	/**
	 * Get the number of elements.
	 */
	public int getNumElements()
	{
		return getFlatListOfElements().size();		
	}
	
	/**
	 * Get the parent of an element.
	 */	
	public Object getParent(Object object)
	{
		Object parent = contentProvider.getParent(object);
		
		if (parent == null)
			return null;
		
		for (Object obj: getFlatListOfElements())
		{
			if (obj == parent)	 // the parent is in the list of all the elements
				return parent;
		}
		
		// get flat list of elements gets all the elements, so if the parent is not 
		// in the list of elements, it is another object that we don't care about
		// so we return null
		return null;
	}
	
	/**
	 * Get the index of a given element.
	 */
	public int indexOfElement(Object object)	
	{
		ArrayList<Object> objectList = getFlatListOfElements();
		return objectList.indexOf(object);		
	}
	
	/**
	 * Get the element at a given index.
	 */	
	public Object getElement(int index)
	{
		ArrayList<Object> objectList = getFlatListOfElements();
		return objectList.get(index);			
	}
	
	/**
	 * This clears the update flat list cache and forces an update next time we get the flat list of elements.
	 */
	public void notifyDataChanged()
	{
		updateFlatList = true;
		fireNotifyChanged(null);
	}
	
	public void addListener(INotifyChangedListener notifyChangedListener)
	{
		if (!listeners.contains(notifyChangedListener))
		{
			listeners.add(notifyChangedListener);			
		}		
	}

	public void fireNotifyChanged(Notification notification)
	{
		for (INotifyChangedListener listener: listeners)
		{
			listener.notifyChanged(notification);			
		}		
	}

	public void removeListener(INotifyChangedListener notifyChangedListener)
	{
		if (listeners.contains(notifyChangedListener))
		{
			listeners.remove(notifyChangedListener);			
		}		
	}
}
