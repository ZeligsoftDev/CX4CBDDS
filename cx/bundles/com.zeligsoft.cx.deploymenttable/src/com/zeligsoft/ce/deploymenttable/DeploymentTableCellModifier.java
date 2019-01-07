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

import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.core.commands.DeployCommand;
import com.zeligsoft.ce.deployment.core.commands.UnDeployCommand;
import com.zeligsoft.ce.tableeditor.MainTableCellModifier;


/**
 * Cell modifier for the deployment table. This class is responsible for taking input from the 
 * user and then reflecting the new value of the cell in the table. 
 * 
 * @author smcfee
 *
 */
public class DeploymentTableCellModifier extends MainTableCellModifier
{

	/**
	 * Stores the editor.
	 */
	public DeploymentTableCellModifier()
	{		
		super();
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
	 *
	 * element is the object for the row -- e.g. DeploymentComponentPartImpl property is the 
	 * column name
	 */
	public Object getValue(Object element, String property) 
	{
		Object result = null;

		result = "";
		return result;
	}

	/**
	 * Function called when we actually try to modify something through the table. Obviously needs
	 * a hook into the meta-model.
	 */
	public void modify(Object rowElement, Object columnElement, Object value) 
	{
		if( value.toString() == "" )
			return;
		
		
		
		if (rowElement instanceof DeploymentPart && columnElement instanceof DeploymentPart)
		{
			DeploymentPart sourcePart = (DeploymentPart) rowElement;
			if (sourcePart == null)
				return;
			
			DeploymentPart targetPart = (DeploymentPart) columnElement;
			if (targetPart == null)
				return;
			
			String targetId = targetPart.getId();
			
			TransactionalEditingDomain editDomain = TransactionUtil.getEditingDomain(sourcePart.getContainingDeployment());
		
			if( value.toString().equals("undeploy"))
			{
				if( sourcePart.getPartDeployedOn() == null ) return;
				if( sourcePart.getPartDeployedOn().getId() != targetId ) return;
			
				UnDeployCommand command = new UnDeployCommand(sourcePart);		
				editDomain.getCommandStack().execute(command);
				return;
			}
		
			//property is the name of the column element is the row
			DeployCommand command = new DeployCommand(sourcePart, targetId);		
			editDomain.getCommandStack().execute(command);
		}		
		
	}
}
