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
package com.zeligsoft.base.util;

import java.net.URL;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.internal.core.Workflow;

/**
 * Implementations of this interface are used to view the workflow at various
 * points in its execution.
 */
@SuppressWarnings("restriction")
public interface IWorkflowCallbacks {

	public URL getWorkflowUrl();
	public void preInvoke(WorkflowContext ctx, Issues issues);
	public void postInvoke(Workflow workflow, Issues issues);

	public static final IWorkflowCallbacks Null = new Adapter();

	public static class Adapter implements IWorkflowCallbacks {
		@Override
		public URL getWorkflowUrl() { return null; }
		@Override
		public void preInvoke(WorkflowContext ctx, Issues issues) { /* empty */ }
		@Override
		public void postInvoke(Workflow workflow, Issues issues) { /* empty */ }
	}
}
