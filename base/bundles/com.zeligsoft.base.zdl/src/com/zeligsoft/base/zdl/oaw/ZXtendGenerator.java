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
package com.zeligsoft.base.zdl.oaw;

import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.expression.ExceptionHandler;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;

/**
 * An {@link XtendComponent} which uses our ResourceManager.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class ZXtendGenerator extends XtendComponent {
	
	ResourceManager manager;
	
	@Override
	public void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		setExceptionHandler(new ZExceptionHandler(this, issues));
		super.invokeInternal2(ctx, monitor, issues);
	}
	
	@Override
	public ResourceManager getResourceManager() {
		if(null == manager) {
			manager = new ZResourceManager();
		}
		return manager;
	}

	@Override
	public void setResourceManager(ResourceManager resourceManager) {
		// do nothing
	}
	
	public static class ZExceptionHandler implements ExceptionHandler {
		private Issues issues;
		private WorkflowComponent component;
		
		public ZExceptionHandler(WorkflowComponent component, Issues issues) {
			this.issues = issues;
		}
		
		public void setIssues(Issues issues) {
			this.issues = issues;
		}
		
		@Override
		public void handleRuntimeException(RuntimeException ex,
				SyntaxElement element, ExecutionContext ctx,
				Map<String, Object> additionalContextInfo) {
			
			if(issues != null) {
				issues.addError(
					component,
					ex.getMessage(), element);
				issues.addError(ex.toString(), element);
			}
			throw ex;
		}
	}
}
