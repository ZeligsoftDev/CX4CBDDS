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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import com.zeligsoft.base.l10n.Messages;


/**
 * A workflow component for loading a resource into a workflow's resource set
 * which is specified in the <tt>resourceSetSlot</tt>.
 *
 * @author Christian W. Damus (cdamus)
 */
public class RSMReader
		extends AbstractEMFComponentWithResourceSet {

	/**
	 * The property name for my input URI.
	 */
	public static final String URI_PROPERTY = "uri"; //$NON-NLS-1$

	/**
	 * Initializes me.
	 */
	public RSMReader() {
		super();
	}

	/**
	 * I do require the model slot, which I populate with the resource's first
	 * root element.
	 */
	@Override
	protected boolean requiresModelSlot() {
		return true;
	}
	
	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		URI uri = URI.createURI(getUri(), true);

		if( getResourceSet() == null ) {
			throw new IllegalArgumentException(Messages.RSMReader_noResourceSet);
		}
		
		// this will use the correct resource implementation because RSM
		// registers it
		Resource res = getResourceSet().getResource(uri, true);
		if (!res.isLoaded() || res.getContents().isEmpty()) {
			issues.addError(this, Messages.RSMReader_loadFailed);
		}

		EObject root = res.getContents().get(0);

		// publish the root in my slot
		ctx.set(getModelSlot(), root);
	}

}
