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

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * Table listener that informs the deployment table that something has changed.
 * 
 * @author sduchesneau
 *
 */
public class MainTableListener implements Listener, MouseMoveListener, MouseListener
{
	private TableEditor editor;
	TableEditorCallback callback;
	
	MainTableListener(TableEditor editor)
	{
		this.editor = editor;
		callback = editor.getCallback();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event)
	{
		editor.notifyRowsChanged();
		editor.refresh();
	}
	
	private Point findCell(Point point)
	{
		
		Table table = editor.getMainTable();
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
				if (rect.contains(point))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			row++;
        }
		
		return new Point(column, row);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseMoveListener#mouseMove(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseMove(MouseEvent e)
	{
		Point point = new Point(e.x, e.y);
		Point tablePoint = findCell(point);
		
		editor.refreshCrosshair(tablePoint.x, tablePoint.y);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseDoubleClick(MouseEvent e)
	{
		Point point = new Point(e.x, e.y);
		Point tablePoint = findCell(point);

		int column = tablePoint.x;
		int row = tablePoint.y;
		
		String[] columnIds = (String[]) editor.getColumnIds();		
		Object columnObject = editor.getColumnObject(columnIds[column]);		

		ArrayList<String> rowIds = editor.getVisibleRows();
		Object rowObject = editor.getRowObject(rowIds.get(row));		
		
		callback.doubleClick(columnObject, rowObject);
		editor.getMainTableViewer().refresh();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseDown(MouseEvent e)
	{
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
	 */
	public void mouseUp(MouseEvent e)
	{
		if (e.button == 3)	// right click
		{
			callback.rightClick(e);		
		}
	}	
}
