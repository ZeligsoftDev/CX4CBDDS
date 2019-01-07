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
package com.zeligsoft.ce.deployment.tableeditor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import com.zeligsoft.ce.deployment.provider.TableHeaderRow;

/**
 * Label provider for the deployment table. This is where cell contents and look and feel can be
 * customized.
 * 
 * @author smcfee
 *
 */
public class DeploymentTableLabelProvider extends AdapterFactoryLabelProvider implements
		ITableLabelProvider, ITableColorProvider, ITableFontProvider  {
	
	DeploymentTableEditor editor;

	public DeploymentTableLabelProvider(AdapterFactory adapterFactory, DeploymentTableEditor editor) {
		super(adapterFactory);
		this.editor = editor;
	}

	/**
	 * Get the background color of the cell. This is grey for a header cell and white otherwise.
	 */
	public Color getBackground(Object element, int columnIndex) {
		if( element instanceof TableHeaderRow || columnIndex == 0)
		{
			return ColorConstants.button;
		}		
		return ColorConstants.white;
	}

	/**
	 * This function determines the text color of the cell. For now we don't care. 
	 */
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}

	/**
	 * For now, do nothing.
	 * SWT fonts are a bit more complicated than AWT fonts unfortunately.
	 * When we want to change the font depending on the cell we will do it here.
	 */
	public Font getFont(Object element, int columnIndex) {
		return null; 
	}
	
	
	public void notifyChanged(Notification notification)
	{
		editor.refresh();		
	}

}
