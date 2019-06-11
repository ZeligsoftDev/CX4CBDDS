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

package com.zeligsoft.ce.tableeditor.test;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider
{
	public TreeContentProvider()
	{
	}

	public Object[] getChildren(Object parentElement)
	{
		if (parentElement instanceof TestItem)
		{
			TestItem parentTestItem = (TestItem)parentElement;
			Object[] children = new Object[parentTestItem.getChildren().size()];
			
			for (int i=0; i<parentTestItem.getChildren().size(); i++)
			{
				children[i] = parentTestItem.getChildren().get(i);				
			}
			return children;
		}
		
		
		return null;
	}

	public Object getParent(Object element)
	{
		if (element instanceof TestItem)
		{
			return ((TestItem) element).getParent();			
		}
		return null;
	}

	public boolean hasChildren(Object element)
	{
		if (element instanceof TestItem)
		{
			TestItem ti = (TestItem)element;
			if (ti.getChildren().size() > 0) return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement)
	{
		if (inputElement instanceof ArrayList)
		{
			ArrayList itemList = ((ArrayList) inputElement);
			Object[] itemArray = new Object[itemList.size()];
			
			for (int i=0; i<itemList.size(); i++)
			{
				itemArray[i] = itemList.get(i);				
			}
			return itemArray;			
		}
		
		return null;
	}

	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		// TODO Auto-generated method stub

	}

}
