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

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.l10n.Messages;


/**
 * A workflow component that defines a profile.
 *
 * @author Christian W. Damus (cdamus)
 */
public class DefineProfile extends WorkflowComponentWithModelSlot {

	/**
	 * Initializes me.
	 */
	public DefineProfile() {
		super();
	}

	/**
	 * Defines the input profile.
	 */
	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		Object model = ctx.get(getModelSlot());
		
		if (!(model instanceof Profile)) {
			issues.addError(this, Messages.DefineProfile_noProfile, model);
			return;
		}
		
		((Profile) model).define();
	}
}
