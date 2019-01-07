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

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;


/**
 * Cell modifier for the deployment table. This class is responsible for taking input from the 
 * user and then reflecting the new value of the cell in the table. 
 * 
 * @author sduchesneau
 *
 */
public abstract class TableEditorCellModifier implements ICellModifier
{

	/**
	 * Store a copy of the table editor so that we can access the column objects.
	 */ 	
	TableEditor editor;
	
	/**
	 * Stores the editor.
	 */
	public TableEditorCellModifier()
	{		
		super();
		editor = null;
	}
	
	/**
	 * Prevent modification of the header rows.
	 */
	public boolean canModify(Object element, String property) 
	{
		return true;
	}

	/**
	 * Returns the value of a cell once it has been modified.  
	 */
	public Object getValue(Object element, String property) 
	{
		Object result = null;

		result = "";
		return result;
	}

	/**
	 * Function called when we actually try to modify something through the table. 
	 */
	public void modify(Object element, String property, Object value) 
	{
		if( value.toString() == "" )
			return;
		
		if (editor == null)
			return;
		
		if( element instanceof TableItem )
		{
			String rowId = (String) ((TableItem)element).getData();
			
			Object rowObject = editor.getRowObject(rowId);			
			Object columnObject = editor.getColumnObject(property);
			
			modify(rowObject, columnObject, value);
			
			// TODO listener is hard coded, see bug 12987
			editor.getMainTableListener().handleEvent(null);
		}		
	}

	/**
	 * Function called when we actually try to modify something through the table. 
	 */
	public abstract void modify(Object rowElement, Object columnElement, Object value);

	public void setEditor(TableEditor editor)
	{
		this.editor = editor;
	}	
}
