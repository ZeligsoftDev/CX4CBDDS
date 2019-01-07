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

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.core.commands.DeployCommand;
import com.zeligsoft.ce.deployment.core.commands.UnDeployCommand;

/**
 * Cell modifier for the deployment table. This class is responsible for taking input from the 
 * user and then reflecting the new value of the cell in the table. 
 * 
 * @author smcfee
 *
 */

public class DeploymentTableCellModifier implements ICellModifier {

	/**
	 * Store a copy of the table editor so that we can access its column information.
	 */ 
	private DeploymentTableEditor editor;
	
	/**
	 * Stores the editor.
	 */
	public DeploymentTableCellModifier(DeploymentTableEditor editor)
	{
		super();
		this.editor = editor;
	}
	
	/**
	 * Prevent modification of the header rows.
	 */
	public boolean canModify(Object element, String property) 
	{
		if( element instanceof DeploymentPart )
			return true;
		return false;
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
		
		if( property == editor.MAGIC_STRING )
		{
			if( element instanceof DeploymentPart )
			{
				DeploymentPart part = (DeploymentPart) element;
				result = part.getName();
			}
			else
				result = "";
			
		}
		else
		{
			result = "";
		}
		
		return result;
	}

	/**
	 * Function called when we actually try to modify something through the table. Obviously needs
	 * a hook into the meta-model.
	 */
	public void modify(Object element, String property, Object value) 
	{
		if( value.toString() == "" )
			return;
		
		if( value.toString().equals("undeploy"))
		{
			DeploymentPart sourcePart = (DeploymentPart)((TableItem)element).getData();
			if( sourcePart.getPartDeployedOn() == null ) return;
			if( sourcePart.getPartDeployedOn().getId() != property ) return;
			
			UnDeployCommand command = new UnDeployCommand(sourcePart);		
			UMLModeler.getEditingDomain().getCommandStack().execute(command);	
			return;
		}
		
		// property is the name of the column
		// element is the row
		if( element instanceof TableItem )
		{ 			
			DeploymentPart sourcePart = (DeploymentPart)((TableItem)element).getData();
			DeploymentPart targetPart = null;
			
			for( int i = 0; i < editor.getDeployment().getDeploymentParts().size(); i++ )
			{
				targetPart = ((DeploymentPart)(editor.getDeployment().getDeploymentParts().get(i)));
				
				if( targetPart.getId() == property )
				{
					break;
				}				
			}
				
			DeployCommand command = new DeployCommand(sourcePart, targetPart);		
			UMLModeler.getEditingDomain().getCommandStack().execute(command);									
		}
	}
}
