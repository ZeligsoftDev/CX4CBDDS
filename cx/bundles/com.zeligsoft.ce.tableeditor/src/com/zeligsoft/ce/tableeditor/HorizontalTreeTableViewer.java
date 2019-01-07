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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Table;

/**
 * This is the viewer for a tree table.
 * @author sduchesneau
 *
 */
public class HorizontalTreeTableViewer extends TableViewer
{
	private TableEditor tableEditor;
	
	/**
	 * Constructor.  Still requires knowledge of the tableEditor to properly update (until proper listening is implemented.)
	 * @param table
	 * @param tableEditor
	 */
	public HorizontalTreeTableViewer(Table table, TableEditor tableEditor)
	{
		super(table);
		this.tableEditor = tableEditor;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.StructuredViewer#refresh()
	 */
	public void refresh()
	{
		tableEditor.notifyChanged();
		
		if (tableEditor.getMainTable() != null)
			tableEditor.resetColumns();
		
		//tableEditor.setNumVisibleRows(tableEditor.maximumHorizontalTreeTableVisibleDepth() + 1);
	
		super.refresh();		
	}
	
	public void insert(Object element, int position)
	{
		refresh();		
	}
	
	public void remove(final Object[] elements)
	{
		refresh();		
	}
	
	public void remove(Object element)
	{
		refresh();		
	}
	
	public void refresh2()
	{
		super.refresh();
		
	}
}
