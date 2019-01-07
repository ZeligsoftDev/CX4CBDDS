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

package com.zeligsoft.cx.deployment.rsm.editor.providers;

import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.ce.tableeditor.TableEditor;
import com.zeligsoft.ce.tableeditor.TableEditorCallback;
import com.zeligsoft.deployment.rsm.tooling.ext.commands.CreateAllocationCommand;
import com.zeligsoft.deployment.rsm.tooling.ext.commands.DeleteAllocationCommand;
import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;

/** 
 * This class implements the callback functions needed for the table editor.
 *  @author sduchesneau  
 */
public class DeploymentTableEditorCallback extends TableEditorCallback
{
	TableEditor editor;
	Component deployment;
	
	public DeploymentTableEditorCallback(TableEditor editor, Component deployment)
	{
		this.editor = editor;
		this.deployment = deployment;
	}
	

	/**
	 * When the user double clicks on a cell, it deploys/undeploys the source element on the corresponding target element. 
	 */
	@Override
	public void doubleClick(Object columnObject, Object rowObject)
	{
		if (columnObject instanceof Property && rowObject instanceof Property)
		{
			
			Property targetPart = (Property) columnObject;
			if (targetPart == null)
				return;
			
			Property sourcePart = (Property) rowObject;
			if (sourcePart == null)
				return;			
			
			
			AbstractTransactionalCommand command = null;

			// check if this guy is already deployed
			if(ZDeploymentUtil.getPartDeployedOn(sourcePart) != null && ZDeploymentUtil.getPartDeployedOn(sourcePart) == targetPart)
				command = new DeleteAllocationCommand(sourcePart, "Undeploy");
			else
				command = new CreateAllocationCommand(deployment, sourcePart, targetPart, "Deploy");
			
			try
			{
				OperationHistoryFactory.getOperationHistory().execute(command, null, null);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();				
			}
		}	
	}

	
	/**
	 * Opens a right click menu to enable you call generation from the deployment table.
	 */
	@Override
	public void rightClick(MouseEvent e)
	{
	    final Shell shell = editor.getShell();	    
	    
		Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
	    
		// Zeligsoft Generate item
		item.setText("Zeligsoft generate");
	    Listener selectionListener = new Listener()
	    {
	    	public void handleEvent(Event e)
	    	{
	    		zeligsoftGenerate();
	    	}
	    };	    		
	    item.addListener(SWT.Selection, selectionListener);

	    menu.setVisible(true);
		
	}
	
	/**
	 * Entry point for zeligsoft generation.
	 */
	protected void zeligsoftGenerate()
	{	
	}

	
	/**
	 * nothing yet
	 */
	@Override
	public Image getImage(Object columnObject, Object rowObject)
	{
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Returns an X if a source part is deployment on a target part.
	 */
	@Override
	public String getText(Object columnObject, Object rowObject)
	{
		if (columnObject instanceof Property && rowObject instanceof Property)
		{
			Property targetPart = (Property) columnObject;
			if (targetPart == null)
				return "";
			
			Property sourcePart = (Property) rowObject;
			if (sourcePart == null)
				return "";			
	
			if(ZDeploymentUtil.getPartDeployedOn(sourcePart) == targetPart)
			{
				return "X";
			}	
		}		
		
		return "";
	}
}
