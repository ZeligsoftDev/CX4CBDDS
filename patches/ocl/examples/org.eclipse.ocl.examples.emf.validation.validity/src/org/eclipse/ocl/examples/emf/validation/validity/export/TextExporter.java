/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.export;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.messages.ValidityMessages;

/**
 * Exports ocl validation results as a txt file.
 */
public class TextExporter extends AbstractExporter
{
	public static final @NonNull String EXPORTER_TYPE = "text";
	public static final @NonNull TextExporter INSTANCE = new TextExporter();

	private void appendLogFile(LeafConstrainingNode node, @NonNull Appendable s, String severity) throws IOException {
		Resource resource = node.getConstraintResource();
		if (resource != null) {
			s.append("\t\t\t Resource: " + resource.getURI() + "\n");
		} else {
			s.append("\t\t\t Resource: "
				+ ValidityMessages.ValidityView_Constraints_LabelProvider_NonExistentResource
				+ "\n");
		}
		s.append("\t\t\t Invariant: " + node.getLabel() + "\n");
		
		String expression = node.getConstraintString();
		if (expression != null) {
			s.append("\t\t\t Expression: " + expression + "\n");
		} else {
			s.append("\t\t\t Expression: "
				+ ValidityMessages.ValidityView_Constraints_LabelProvider_ExpressionNotAvailable
				+ "\n");
		}
		s.append("\t\t\t Severity: " + severity + "\n");
		s.append("\t\t\t Message: " + getMessage(node.getWorstResult()) + "\n");
		s.append("\t\t\t\t-------------\n");
	}

	/**
	 * Returns a stream containing the initial contents to be given to new
	 * exported validation results file resource instances.
	 * 
	 * @throws IOException 
	 */
	@Override
	public void createContents(@NonNull Appendable text, @NonNull RootNode rootNode, @Nullable String exportedFileName) throws IOException {
		text.append("==== GENERAL INFORMATION ====\n");
		if (exportedFileName != null) {
			text.append("Output file name: " + exportedFileName + "\n");
		}
		text.append("Author: " + System.getProperty("user.name") + "\n");
		text.append("\n");
		text.append("\n");
		text.append("==== RESOURCES USED ====\n");
		text.append("Model checked: \n");
		List<String> uriStrings = new ArrayList<String>();
		for (RootValidatableNode rootValidatableNode : rootNode.getValidatableNodes()) {
			Resource eResource = rootValidatableNode.getConstrainedObject().eResource();
			uriStrings.add(eResource.getURI().toString());
		}
		Collections.sort(uriStrings);
		for (String uriString : uriStrings) {
			text.append("\t\t\t\t" + uriString + "\n");
		}
		text.append("\n");
		text.append("\n");
		text.append("==== METRICS ====\n");
		
		int total = getConstraintCount();
		text.append("Total number of evaluated constraints: " + total + "\n");
		text.append("- Number of Success: " + validationSuccess.size() + "\n");
		text.append("- Number of Infos: " + validationInfos.size() + "\n");
		text.append("- Number of Warnings: " + validationWarnings.size() + "\n");
		text.append("- Number of Errors: " + validationErrors.size() + "\n");
		text.append("- Number of Failures: " + validationFailures.size() + "\n");
		text.append("\n");
		text.append("\n");
		text.append("==== LOGS ====\n");
		
		if (validationSuccess.size() == total) {
			text.append("No log to display: models has been successfully validated.\n");
		} else {
			Set<Object> loggedConstrainingObjects = new HashSet<Object>();
			if (!validationInfos.isEmpty()) {
				text.append("- Informations:\n");
				for (LeafConstrainingNode infoNode : validationInfos) {
					if (loggedConstrainingObjects.add(infoNode.getConstrainingObject())) {
						appendLogFile(infoNode, text, Severity.INFO.getLiteral());
					}
				}
			}
			if (!validationWarnings.isEmpty()) {
				text.append("- Warnings:\n");
				for (LeafConstrainingNode warningNode : validationWarnings) {
					if (loggedConstrainingObjects.add(warningNode.getConstrainingObject())) {
						appendLogFile(warningNode, text, Severity.WARNING.getLiteral());
					}
				}
			}
			if (!validationErrors.isEmpty()) {
				text.append("- Errors:\n");
				for (LeafConstrainingNode errorNode : validationErrors) {
					if (loggedConstrainingObjects.add(errorNode.getConstrainingObject())) {
						appendLogFile(errorNode, text, Severity.ERROR.getLiteral());
					}
				}
			}
			if (!validationFailures.isEmpty()) {
				text.append("- Failures:\n");
				for (LeafConstrainingNode failureNode : validationFailures) {
					if (loggedConstrainingObjects.add(failureNode.getConstrainingObject())) {
						appendLogFile(failureNode, text, Severity.FATAL.getLiteral());
					}
				}
			}
		}
	}
	
	public @NonNull String getExporterType() { return EXPORTER_TYPE; }

	@Override
	public @NonNull String getPreferredExtension() { return "txt"; }
}
