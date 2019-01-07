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

package com.zeligsoft.cx.deployment.treeeditor.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderPolicy;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.GlobalActionHandlerOperation;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Implements IProviderPolicy for DeploymentTreeGlobalActionHandlerProvider
 * 
 * @author ysroh
 * 
 */
public class DeploymentTreeGlobalActionHandlerPolicy
		implements IProviderPolicy {

	public static String ACTION = ""; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProviderPolicy#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {

		if (operation instanceof GlobalActionHandlerOperation) {
			IGlobalActionHandlerContext context = ((GlobalActionHandlerOperation) operation)
				.getContext();
			EObject tempObject = BaseUIUtil.getEObjectFromSelection(context
				.getActivePart().getSite().getSelectionProvider()
				.getSelection());

			if (tempObject instanceof Component) {
				// Check to see if this is open action for deployment tree
				if (ZDLUtil
					.isZDLConcept(tempObject, ZMLMMNames.DEPLOYMENT)) {
					if (context.getActionId() == GlobalActionId.OPEN) {
						ACTION = DeploymentEditorMessages.DeploymentTreeGlobalOpenActionHandler_OpenDeploymentEditorActionLabel;
						return true;
					}
				}
			}
		}
		return false;
	}

}
