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

package com.zeligsoft.ce.rsm.ui.wizard.contentcreators;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Model;

import com.ibm.xtools.common.ui.wizards.config.TemplateConfiguration;
import com.ibm.xtools.common.ui.wizards.handlers.IContentCreator;
import com.zeligsoft.ce.domainregistration.DomainRegistry;
import com.zeligsoft.ce.domainregistration.DomainSpecialization;
import com.zeligsoft.ce.rsm.ui.wizard.l10n.Messages;

/**
 * Class used to create the content
 * 
 * @author sduchesneau
 * 
 */
public class DomainSpecializationContentCreator
		implements IContentCreator {

	DomainSpecialization[] selectedDomains;

	public DomainSpecializationContentCreator(
			DomainSpecialization[] selectedDomains) {
		super();
		this.selectedDomains = selectedDomains;
	}

	public IStatus createContent(IProgressMonitor progressMonitor,
			TemplateConfiguration templateConfiguration, Resource[] resources) {
		if (resources.length > 0) {
			// Rename the root UML Model element to the same name as the file
			// and import the selected models libraries and profiles.
			Model model = (Model) resources[0].getContents().get(0);
			if (model != null) {
				model.setName(templateConfiguration.getFileName());
				BasicDiagnostic libraryDiagnostic = DomainRegistry
					.importModelLibraries(DomainRegistry
						.getLibraries(selectedDomains), model);
				IStatus status = triageDiagnostic(libraryDiagnostic);
				if (!status.isOK()) {
					return status;
				}
				BasicDiagnostic profileDiagnostic = DomainRegistry
					.applyProfiles(DomainRegistry.getProfiles(selectedDomains),
						model);
				status = triageDiagnostic(profileDiagnostic);
				if (!status.isOK()) {
					return status;
				}
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * Triage diagnostics. Show error messages to user and ask for confirmation
	 * to continue or cancel.
	 * 
	 * @param diagnostic
	 * @return status OK if user clicks Yes to continue or false otherwise
	 */
	private IStatus triageDiagnostic(BasicDiagnostic diagnostic) {
		String lineSeperator = System.getProperty("line.separator"); //$NON-NLS-1$
		if (diagnostic != null && !diagnostic.getChildren().isEmpty()) {
			StringBuilder errorMsg = new StringBuilder().append(lineSeperator
				+ lineSeperator);
			for (Diagnostic status : diagnostic.getChildren()) {
				errorMsg.append(status.getMessage()).append(lineSeperator);
			}
			errorMsg.append(lineSeperator);

			if (!MessageDialog.openQuestion(Display.getDefault()
				.getActiveShell(), diagnostic.getMessage(), NLS.bind(
				Messages.DomainSpecializationContentCreator_triageDiagnosticQuestion,
				errorMsg.toString()))) {
				return Status.CANCEL_STATUS;
			}
		}
		return Status.OK_STATUS;
	}
}
