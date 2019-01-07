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
package com.zeligsoft.ce.deploymenttable;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.core.commands.DeployCommand;
import com.zeligsoft.ce.deployment.core.commands.UnDeployCommand;
import com.zeligsoft.ce.tableeditor.TableEditor;
import com.zeligsoft.ce.tableeditor.TableEditorCallback;

public class DeploymentTableEditorCallback extends TableEditorCallback
{
	TableEditor editor;
	
	DeploymentTableEditorCallback(TableEditor editor)
	{
		this.editor = editor;		
	}
	
	@Override
	public void doubleClick(Object columnObject, Object rowObject)
	{
		if (columnObject instanceof DeploymentPart && rowObject instanceof DeploymentPart)
		{
			
			DeploymentPart targetPart = (DeploymentPart) columnObject;
			if (targetPart == null)
				return;
			
			DeploymentPart sourcePart = (DeploymentPart) rowObject;
			if (sourcePart == null)
				return;			
			
			String targetId = targetPart.getId();
			
			TransactionalEditingDomain editDomain = TransactionUtil.getEditingDomain(sourcePart.getContainingDeployment());
		
			// check if this guy is already deployed
			if(sourcePart.getPartDeployedOn() != null && sourcePart.getPartDeployedOn().getId() == targetId)
			{
				UnDeployCommand command = new UnDeployCommand(sourcePart);		
				editDomain.getCommandStack().execute(command);
			}
			else
			{
		
				//property is the name of the column element is the row
				DeployCommand command = new DeployCommand(sourcePart, targetId);		
				editDomain.getCommandStack().execute(command);
			}
		}
	}

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
	
	protected void zeligsoftGenerate()
	{	
	}
	
	
	
}
