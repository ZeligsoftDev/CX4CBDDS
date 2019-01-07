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
package com.zeligsoft.base.workflow;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * A workflow component that cleans up a resource set that was shared by all
 * of the previous components in a workflow. The resource set cleaned by this
 * component is found in the slot name supplied to it in the 
 * <tt>resourceSetSlot</tt> property.
 * 
 * @author Toby McClean
 *
 */
public class CleanupResourceSet extends AbstractEMFComponentWithResourceSet {
	
	private String unloadResourcesSlot;
	
	/**
	 * Initializes me.
	 */
	public CleanupResourceSet() {
		super();
	}
	
	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		ResourceSet rset = getResourceSet();
		boolean unloadResources = true;
		if(getUnloadResourcesSlot() != null) {
			Object unloadResourcesObject = ctx.get(getUnloadResourcesSlot());
			if(unloadResourcesObject != null) {
				unloadResources = (Boolean) ctx.get(getUnloadResourcesSlot());
			}
		}
		
		
		if(unloadResources && rset != null) {
			for(Resource r : rset.getResources()) {
				r.unload();
			}
		}
	}
	
	/**
	 * Accessor that returns a string representing the slot
	 * where the unloadResources flag can be found.
	 * 
	 * @return A string for the slot
	 */
	public String getUnloadResourcesSlot() {
		return unloadResourcesSlot;
	}
	
	/**
	 * Set the value for the slot where the unloadResources
	 * flag can be found.
	 * 
	 * @param slotName a string for the slot name
	 */
	public void setUnloadResourcesSlot(String slotName) {
		unloadResourcesSlot = slotName;
	}
}
