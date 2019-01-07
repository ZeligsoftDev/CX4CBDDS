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

package com.zeligsoft.base.rsm.tooling.actions;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * Abstract ActionDelegate that supports the creating of elements using
 * <code>CreateElementRequest</code>. This ActionDelegate uses the
 * IElementType service to create the actual elements.
 * 
 * @author jcorchis
 * 
 */
public abstract class AbstractElementTypeActionDelegate
		extends AbstractZeligsoftActionDelegate {

	/**
	 * Implement to return an instance of <code>CreateElementRequest</code> in
	 * order to create the appropriate model element based on this
	 * ActionDelegate.
	 * 
	 * @return the CreateElementRequest
	 */
	abstract protected CreateElementRequest getCreateElementRequest();

	/**
	 * Consults the EditHelpContext to provide an <code>EditCommand</code>
	 * 
	 * @return
	 */
	@Override
	protected ICommand getCommand() {
		ICommand result = null;

		CreateElementRequest request = getCreateElementRequest();

		if (request != null) {
			IElementType contextType = ElementTypeRegistry.getInstance()
				.getElementType(request.getEditHelperContext());

			if (contextType != null) {
				ICommand createCommand = contextType.getEditCommand(request);

				if (createCommand != null && createCommand.canExecute()) {
					result = createCommand;
				}

			}
		}
		return result;
	}
}
