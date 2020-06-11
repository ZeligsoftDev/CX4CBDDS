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
package com.zeligsoft.domain.dds4ccm.ui.command;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.IPapyrusDiagnostician;
import org.eclipse.papyrus.infra.services.validation.commands.ValidateSubtreeCommand;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

public class ValidateCXModelCommand extends ValidateSubtreeCommand {

	public ValidateCXModelCommand(EObject selectedElement, IPapyrusDiagnostician diagnostician) {
		super(selectedElement, diagnostician);
	}

	@Override
	protected void runValidation(EObject validateElement) {
		super.runValidation(validateElement);

		// print out validation message to console output
		int errors = 0;
		int warnings = 0;
		for (Diagnostic diag : diagnostic.getChildren()) {
			if (diag.getSeverity() == Diagnostic.ERROR) {
				errors++;
			} else if (diag.getSeverity() == Diagnostic.WARNING) {
				warnings++;
			}
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("Validated Model : ").append(validateElement.eResource().getURI().toString());
		buffer.append(System.lineSeparator());
		buffer.append("Validation - ").append(errors).append(" error(s), ");
		buffer.append(warnings).append(" error(s)");
		buffer.append(System.lineSeparator());
		BaseUIUtil.writeToConsole(buffer.toString());
	}
}
