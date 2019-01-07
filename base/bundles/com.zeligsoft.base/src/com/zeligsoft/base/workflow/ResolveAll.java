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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;
/**
 * A workflow component that resolves all proxies in the contextual resource
 * set.  The optional <tt>modelSlot</tt> specifies a {@link URI} or a collection
 * of <tt>URI</tt>s of resources to load into the resource set before resolving
 * all proxies.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ResolveAll
		extends AbstractEMFComponentWithResourceSet {

	/**
	 * Default constructor
	 */
	public ResolveAll() {
		super();
	}

	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		if (!UML2Util.isEmpty(getModelSlot())) {
			loadResources(ctx);
		}
		
		EcoreUtil.resolveAll(getResourceSet());
	}
	
	/**
	 * Ensures that the resources specified in the <tt>modelSlot</tt> are loaded.
	 * 
	 * @param ctx the current workflow context
	 */
	private void loadResources(WorkflowContext ctx) {
		Object value = ctx.get(getModelSlot());
		
		if (value instanceof Collection<?>) {
			Collection<?> values = (Collection<?>) value;
			
			for (Object next : values) {
				loadResource(next);
			}
		} else {
			loadResource(value);
		}
	}
	
	/**
	 * Given a URI or a Resource, ensures that the resource is loaded in the
	 * resource set.
	 * 
	 * @param uriOrResource a {@link URI} or a {@link Resource}
	 */
	private void loadResource(Object uriOrResource) {
		Resource res = null;
		boolean createdResource = false;
		
		if (uriOrResource instanceof URI) {
			URI uri = (URI) uriOrResource;
			res = getResourceSet().getResource(uri, false);
			if (res == null) {
				createdResource = true;
				res = getResourceSet().createResource(uri);
			}
		} else if (uriOrResource instanceof Resource) {
			res = (Resource) uriOrResource;
		}
	
		if ((res != null) && !res.isLoaded()) {
			try {
				res.load(Collections.EMPTY_MAP);
			} catch (Exception e) {
				// resource doesn't exist.  That is OK
				res.unload();
				if (createdResource) {
					getResourceSet().getResources().remove(res);
				}
			}
		}
	}	
}
