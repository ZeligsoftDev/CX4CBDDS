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

package com.zeligsoft.cx.deployment.treeeditor.providers;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandlerProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;

import com.zeligsoft.cx.deployment.treeeditor.actions.DeploymentTreeGlobalOpenActionHandler;

/**
 * This class is GlobalActionHandlerProvider for deployment tree. Purpose of
 * this provider is to provide proper handler for deployment tree action
 * 
 * @author ysroh
 */

public class DeploymentTreeGlobalActionHandlerProvider extends AbstractGlobalActionHandlerProvider
{

	public DeploymentTreeGlobalActionHandlerProvider()
	{
		super();
	}

	@Override
	public IGlobalActionHandler getGlobalActionHandler(IGlobalActionHandlerContext context)
	{
		if (context != null && context.getActionId() == GlobalActionId.OPEN)
		{
			return new DeploymentTreeGlobalOpenActionHandler();
		}

		return null;
	}

}
