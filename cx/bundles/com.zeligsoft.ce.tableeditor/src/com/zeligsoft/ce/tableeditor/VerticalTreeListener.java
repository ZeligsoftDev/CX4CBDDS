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

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Class used to listen to changes done to the vertical tree.  It is used to synchronize
 * the deployment table with the left tree.
 */
public class VerticalTreeListener implements TreeListener, MouseMoveListener	
{
	private TableEditor editor;
	
	VerticalTreeListener(TableEditor editor)
	{
		this.editor = editor;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.TreeListener#treeCollapsed(org.eclipse.swt.events.TreeEvent)
	 */
	public void treeCollapsed(TreeEvent e)
	{
		// treeCollapsed and treeExpanded are called before the tree is collapsed/expanded
		// so here I get the Tree Item that we clicked to find out its expanded state
		// I set it to the opposite, so that when getVisibleVerticalTreeParts is called, the tree item 
		// will be in the expected state and getVisibleVerticalTreeParts will work properly
		
		TreeItem ti = (TreeItem) e.item;	
		ti.setExpanded(!ti.getExpanded());
		
		// TODO hard coded table listener, see bug 12987
		editor.getMainTableListener().handleEvent(null);	
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.TreeListener#treeExpanded(org.eclipse.swt.events.TreeEvent)
	 */
	public void treeExpanded(TreeEvent e)
	{
		TreeItem ti = (TreeItem) e.item;
		ti.setExpanded(!ti.getExpanded());
	
		// TODO hard coded table listener, see bug 12987
		editor.getMainTableListener().handleEvent(null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseMoveListener#mouseMove(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseMove(MouseEvent e)
	{
		editor.refreshCrosshair(-1, -1);		
	}	
}
