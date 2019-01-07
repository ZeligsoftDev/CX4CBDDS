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

import com.zeligsoft.base.Activator;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Package;

/**
 * Subclass for RSMWriter that takes an existing resource and adds to it instead of creating a new one.
 * 
 * @author Sean McFee
 *
 */
public class RSMAppender extends RSMWriter {

	
	/**
	 * Initializes me.
	 */
	public RSMAppender() {
		super();
	}		

	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		Package model = (Package)ctx.get(getModelSlot());
		
		if( issues.getErrors().length > 0) {
			return;
		}
		
		// If we keep the warnings the transaction will be rolled back.
		// Instead, report them here and clear the issues list.
		for( MWEDiagnostic issue : issues.getWarnings()) {
			Activator.getDefault().warning(issue.getMessage());
		}
		issues.clear();
		
		// take care of the stereotypes applied to UML elements
		addStereotypeApplications(model.eResource(), model);
	}
	
}
