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

package com.zeligsoft.ce.deployment.provider;

import java.util.ArrayList;

import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * A very simple class used for the multiple header rows. Will likely be removed once we evolve the
 * table GUI. Header rows have a concept of depth which allows us to put deployment parts at the right 
 * level.
 * 
 * @author smcfee
 *
 */
public class TableHeaderRow implements ITableItemLabelProvider {

	private int depth = 0;
	private Deployment deployment;
	
	public TableHeaderRow(int j, Deployment d) {
		depth = j;		 
		deployment = d;
	}

	public int getDepth() {
		return depth;
	}

	// TableHeader row is a temporary class, so I've made it its own item provider.
	
	public Object getColumnImage(Object object, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
			
		// For a header row, display the name of the part for this column in this row if the 
		// depth of the part matches the depth of this row.
		if( columnIndex != 0 )
		{
			// Find the part with the name of this column.
			ArrayList<DeploymentPart> deploymentParts = deployment.getDeploymentParts();
			String columnName = deploymentParts.get(columnIndex - 1).getName();
			
			DeploymentPart dp = null;
			for( int i = 0; i < deployment.getDeploymentParts().size(); i++ ) {
				dp = deployment.getDeploymentParts().get(i);
				if( dp.getName() == columnName )
					break;
			}
			
			if( getDepth() == dp.getDepth() )
			{
				return dp.getName();
			}			
		}
		
		return "";
	}
}
