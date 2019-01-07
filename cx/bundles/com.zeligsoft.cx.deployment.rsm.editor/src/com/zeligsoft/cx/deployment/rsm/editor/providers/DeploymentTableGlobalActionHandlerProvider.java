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

package com.zeligsoft.cx.deployment.rsm.editor.providers;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandlerProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;

import com.zeligsoft.cx.deployment.rsm.editor.ui.actions.DeploymentTableGlobalOpenActionHandler;




/**
 *  This class is GlobalActionHandlerProvider for deployment table.
 *  Purpose of this provider is to provide proper handler for deployment table action
 *  @author ysroh
 */

public class DeploymentTableGlobalActionHandlerProvider extends
		AbstractGlobalActionHandlerProvider {

	public DeploymentTableGlobalActionHandlerProvider() {
		super();
	}

	public IGlobalActionHandler getGlobalActionHandler(
			IGlobalActionHandlerContext context) {
		if (context != null && context.getActionId() == GlobalActionId.OPEN) {
			return new DeploymentTableGlobalOpenActionHandler();
		}

		return null;
	}

}
