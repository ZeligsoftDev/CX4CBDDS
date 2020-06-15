/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.validation.handler.AbstractCommandHandler;

import com.zeligsoft.base.validation.ui.commands.ValidateCXModelCommand;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMDiagnostician;

/**
 * Handler for validating a subtree
 */
public class CXValidationHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		EObject selectedElement = getSelectedElement();
		if (selectedElement == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return GMFtoEMFCommandWrapper.wrap(new ValidateCXModelCommand(selectedElement, new DDS4CCMDiagnostician()));
	}
}
