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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.resources.IPathmapManager;

import com.zeligsoft.base.util.ZeligsoftURIConverter;


/**
 * A workflow component that sets up a resource set that can be shared by all of
 * the subsequent components in a workflow. The resource set created by this
 * component is published in the slot name supplied to it in the
 * <tt>resourceSetSlot</tt> property.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class SetupResourceSet
		extends AbstractEMFComponentWithResourceSet {

	static {
		ResourceSet rset = new ResourceSetImpl();
		
		enablePathmaps(rset);
		
		makePathmapsGlobal(rset);
	}
	
	/**
	 * Initializes me.
	 */
	public SetupResourceSet() {
		super();
	}
	
	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		ResourceSet rset = getResourceSet();
		
		if (rset == null) {
			rset = new ResourceSetImpl();
			enablePathmaps(rset);
			
			setResourceSet(rset);
			ctx.set(getResourceSetSlot(), rset);
		}
		
		// ensure that URIs resolved from relative URIs are corrected to
		// eliminate '..' segments that cause unwanted resource aliasing
		ZeligsoftURIConverter.install(rset);
	}

	/**
	 * Enables pathmap URI management in the GMF style on the specified
	 * resource-set.
	 * 
	 * @param rset a resource set
	 */
	public static void enablePathmaps(ResourceSet rset) {
		// TODO: Is there a place common to base-oAW and ddk.zdl where for this?
		
		// first, check whether a path-map adapter is already attached
		for (Adapter next : rset.eAdapters()) {
			if (next instanceof IPathmapManager) {
				return;  // nothing to do
			}
		}

		TransactionalEditingDomain domain = GMFEditingDomainFactory
			.getInstance().createEditingDomain();

		if (domain != null) {
			for (Adapter next : domain.getResourceSet().eAdapters()) {
				if (next instanceof IPathmapManager) {
					// move the adapter
					domain.getResourceSet().eAdapters().remove(next);
					rset.eAdapters().add(next);
					break;
				}
			}
		}
	}

	private static void makePathmapsGlobal(ResourceSet rset) {
		Map<URI, URI> sourceMap = rset.getURIConverter().getURIMap();
		Map<URI, URI> targetMap = URIConverter.URI_MAP;
		
		for (Map.Entry<URI, URI> next : sourceMap.entrySet()) {
			targetMap.put(next.getKey(), next.getValue());
		}
	}
}
