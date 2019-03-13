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

package com.zeligsoft.cx.codegen.ui.actions;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.base.util.ZeligsoftURIConverter;

/**
 * Executes a sequence of Workflows in an Eclipse <code>Job</code>.
 * 
 * @author jcorchis
 * 
 */
public class TransformAction
		extends AbstractTransformAction {

	/**
	 * Default constructor
	 */
	public TransformAction() {
		super();
	}
	
	@Override
	public void run() {
		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return;
		}

		ZeligsoftURIConverter.install(TransactionUtil.getEditingDomain(element)
			.getResourceSet());

		doTransform();
	}

	@Override
	public void joinThread(WorkspaceJob transformJob)
			throws InterruptedException {
		// Do not join the thread as it will join the UI thread, which will hang the UI until all the workflows have completed

		// Do nothing
	}

}
