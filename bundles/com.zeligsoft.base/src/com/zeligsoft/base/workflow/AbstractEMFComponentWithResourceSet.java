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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.AbstractEMFWorkflowComponent;


/**
 * An EMF component (with model slot) that has a slot for sharing a resource-set
 * with other components.  The resource set is inject via a slot whose name is
 * supplied in the <tt>resourceSetSlot</tt> property.
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEMFComponentWithResourceSet
		extends AbstractEMFWorkflowComponent {

	/**
	 * The name of my resource-set slot name property.
	 */
	public static final String RESOURCE_SET_SLOT = "resourceSetSlot"; //$NON-NLS-1$
	
	private String resourceSetSlot;

	/**
	 * Initializes me.
	 */
	public AbstractEMFComponentWithResourceSet() {
		super();
	}
	
	@Override
	public void checkConfiguration(Issues issues) {
		if (requiresModelSlot()) {
			super.checkConfiguration(issues);
		}
		
		checkRequiredConfigProperty(RESOURCE_SET_SLOT, getResourceSetSlot(), issues);
	}
	
	/**
	 * Queries whether the model slot is mandatory.  By default, it is not.
	 * Subclasses may override.
	 * 
	 * @return whether I require a model slot
	 */
	protected boolean requiresModelSlot() {
		return false;
	}
	
	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		setResourceSet((ResourceSet) ctx.get(getResourceSetSlot()));
		
		doInvoke(ctx, monitor, issues);
	}
	
	/**
	 * Implemented by subclasses to provide the invocation behaviour.  Subclasses
	 * should not normally need to override the
	 * {@link #invoke(WorkflowContext, ProgressMonitor, Issues)} template
	 * method, which calls this one at the appropriate point.
	 * 
	 * @param ctx the current workflow context
	 * @param monitor a progress monitor
	 * @param issues gathers issues reported by the component
	 */
	protected abstract void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues);
	
	/**
	 * Obtains the name of my resource-set slot, if it is set.
	 * 
	 * @return my resource-set slot, or <code>null</code> if undefined
	 */
	public String getResourceSetSlot() {
		return resourceSetSlot;
	}
	
	/**
	 * Sets the name of my resource-set slot.
	 * 
	 * @param slotName my resource-set slot, or <code>null</code> if undefined
	 */
	public void setResourceSetSlot(String slotName) {
		resourceSetSlot = slotName;
	}

}
