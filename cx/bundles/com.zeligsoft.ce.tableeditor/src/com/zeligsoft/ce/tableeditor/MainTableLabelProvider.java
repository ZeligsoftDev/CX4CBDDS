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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

/**
 * Label provider for the table. This uses an external table to get its data.
 * 
 * @author sduchesneau
 *
 */
public class MainTableLabelProvider implements ITableEditorProvider  
{
	
	private TableEditorCallback callback;
	private TableEditor editor;

	public MainTableLabelProvider(TableEditor editor)
	{
		this.editor = editor;
		callback = editor.getCallback();
	}

	/**
	 * Get the background color of the cell.
	 */
	public Color getBackground(Object element, int columnIndex)
	{
		int row=0;
		if (element instanceof String)
			row = editor.getRowIndex((String)element);
		
		if (editor.getMouseRow() < 0 || editor.getMouseColumn() < 0)
			return null;
		
		if (editor.getMouseRow() == row && editor.getMouseColumn() == columnIndex)
			return BackgroundColor.VeryLightGray;		
		else if (editor.getMouseRow() == row || editor.getMouseColumn() == columnIndex)
			return BackgroundColor.UberLightGray;
		else
			return null;

	}

	/**
	 * This function determines the text color of the cell. 
	 */
	public Color getForeground(Object element, int columnIndex)
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableFontProvider#getFont(java.lang.Object, int)
	 */
	public Font getFont(Object element, int columnIndex)
	{
		return null;
	}		
	
	/**
	 * Notifies that data has changed in the label provider.
	 * @param notification
	 */
	public void notifyChanged(Notification notification)
	{
		editor.refresh();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object object, int columnIndex)
	{
		if (object instanceof String)
		{			
			String rowId = (String) object;
			
			String[] columnIds = (String[]) editor.getColumnIds();		
			Object columnObject = editor.getColumnObject(columnIds[columnIndex]);		
			
			return callback.getText(columnObject, editor.getRowObject(rowId));
		}		
	
		return "";		
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex)
	{
		if (element instanceof String)
		{			
			String rowId = (String) element;
			
			String[] columnIds = (String[]) editor.getColumnIds();		
			Object columnObject = editor.getColumnObject(columnIds[columnIndex]);		
			
			return callback.getImage(columnObject, editor.getRowObject(rowId));
		}
		
		return null;
	
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener)
	{
		//tableProvider.addListener(listener);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose()
	{
		// the label provider, color provider and the font provider are always the same object
		// so we only need to do this once
		//tableProvider.dispose();
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property)
	{
		//return tableProvider.isLabelProperty(element, property);
		return false;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener)
	{
		//tableProvider.removeListener(listener);
	}	

}
