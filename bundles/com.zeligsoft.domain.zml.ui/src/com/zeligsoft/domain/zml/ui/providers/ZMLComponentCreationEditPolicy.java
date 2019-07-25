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
package com.zeligsoft.domain.zml.ui.providers;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Edit policy to prevent port creation popup menu
 * 
 * @author ysroh
 * 
 */
public class ZMLComponentCreationEditPolicy extends GraphicalEditPolicy {

	@Override
	public Command getCommand(Request request) {

		if (request instanceof EditCommandRequestWrapper) {
			IEditCommandRequest editRequest = ((EditCommandRequestWrapper) request)
					.getEditCommandRequest();
			if (editRequest instanceof CreateElementRequest) {
				CreateElementRequest createRequest = (CreateElementRequest) editRequest;
				if (BaseUIUtil.isUMLPort(createRequest.getElementType())) {
					createRequest.setParameter("uml.port.type", "unspecified"); //$NON-NLS-1$ //$NON-NLS-2$
				} else if (BaseUIUtil.isUMLPart(createRequest.getElementType())) {
					createRequest.setParameter("uml.property.type", "unspecified"); //$NON-NLS-1$//$NON-NLS-2$
				}
			}
		}
		return super.getCommand(request);
	}
}
