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
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Writer;

/**
 * A model writer that gets its target from a slot that is a URI.
 * 
 * @author Toby McClean
 *
 */
public class ModelWriter extends Writer {
	private String targetURISlot;
	
	public String getTargetURISlot() {
		return targetURISlot;
	}

	public void setTargetURISlot(String targetURISlot) {
		this.targetURISlot = targetURISlot;
	}
	
	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		URI targetURI = (URI) ctx.get(targetURISlot);
		if(targetURI != null) {
			this.setUri(targetURI.toString());
			super.invokeInternal(ctx, monitor, issues); 
		}
	}
}
