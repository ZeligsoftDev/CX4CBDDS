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


public class TestItem
{
	private ArrayList<TestItem> children;
	private TestItem parent;
	
	private String name;
	private boolean hidden;
	
	public TestItem()
	{
		parent = null;
		children = new ArrayList<TestItem>();
		hidden = false;
	}
	
	public final TestItem getParent()
	{
		return parent;
	}

	public final void setParent(TestItem parent)
	{
		this.parent = parent;
	}

	public final ArrayList<TestItem> getChildren()
	{
		return children;
	}
	
	public void addChild(TestItem child)
	{
		child.parent = this;
		children.add(child);		
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getDepth()
	{
		int depth = 0;
		TestItem ti = parent;
		
		while (ti != null)
		{
			depth++;
			ti = ti.parent;			
		}
		
		return depth;
	}
	
	public void collapse()
	{
		for (int i=0; i<children.size(); i++)
		{
			children.get(i).hidden = true;
			children.get(i).collapse();
		}		
	}
	
	public void expand()
	{
		for (int i=0; i<children.size(); i++)
		{
			children.get(i).hidden = false;
		}		
	}
	
	public boolean hasChildren()
	{
		if (children.size() > 0)
			return true;
		return false;		
	}
	
	public boolean isVisible()
	{
		return !hidden;		
	}
	
	public boolean childrenVisible()
	{
		if (children.size() > 0 && children.get(0).isVisible())
			return true;
		return false;		
	}
	
	public void destroy()
	{
		if (parent != null)
		{
			parent.children.remove(this);
		}			
		
		children = null;
	}
}
