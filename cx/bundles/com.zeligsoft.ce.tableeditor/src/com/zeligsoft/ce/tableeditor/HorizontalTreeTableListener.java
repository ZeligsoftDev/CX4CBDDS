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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * This class handles a modification of the RSM model.
 * 
 * @author sduchesneau
 */
public class HorizontalTreeTableListener implements INotifyChangedListener, MouseMoveListener, MouseListener, IChangeNotifier
{
	private TableEditor editor;
	private Point mouseDownPoint;
	private HorizontalTreeTableContentProvider contentProvider;
	private ArrayList<INotifyChangedListener> listeners;  
	
	HorizontalTreeTableListener(TableEditor editor)
	{
		this.editor = editor;
		contentProvider = editor.getHorizontalTreeTableContentProvider();
		
		listeners = new ArrayList<INotifyChangedListener>();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.INotifyChangedListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification)
	{
		editor.refresh();		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseMoveListener#mouseMove(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseMove(MouseEvent e)
	{
		editor.refreshCrosshair(-1, -1);
		
	}	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseDoubleClick(MouseEvent e)
	{		
	}

	/**
	 * Save the point where the mouse was pressed down
	 */
	public void mouseDown(MouseEvent e)
	{
		mouseDownPoint = new Point(e.x, e.y);
	}

	/**
	 * If the object is in its expanded state, collapse it, else expand it
	 */
	public void mouseUp(MouseEvent e)
	{
		Point mouseUpPoint = new Point(e.x, e.y);
		
		Table table = editor.getHorizontalTreeTable();
		int columnCount = table.getColumnCount();
				
		int row = table.getTopIndex();
		int column=0;
		
		boolean found=false;
		while (row < table.getItemCount())
		{
			TableItem item = table.getItem(row);
			for (column = 0; column < columnCount; column++)
			{
				Rectangle rect = item.getBounds(column);
				if (rect.contains(mouseDownPoint))
				{
					if (rect.contains(mouseUpPoint))
					{
						found = true;
						break;
					}
					else
					{
						return;
					}
				}
			}
			if (found)
				break;
			row++;
		}
		
		String[] columnIds = (String[]) editor.getColumnIds();		
		Object columnObject = editor.getColumnObject(columnIds[column]);		
		int depth = contentProvider.getElementDepth(columnObject);

		if (depth != row)
			return;
		
		Object[] children = contentProvider.getChildren(columnObject);		
		if (children.length <= 0) return;  // if this object doesn't have any children, we know it can't be expanded or collapsed
		
		if (editor.isColumnVisible(column+1))  // look if first child is hidden
		{
			editor.expandColumnObject(column);
		}
		else
		{
			editor.collapseColumnObject(column);
		}
		
		fireNotifyChanged(null);
		editor.refresh();
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
