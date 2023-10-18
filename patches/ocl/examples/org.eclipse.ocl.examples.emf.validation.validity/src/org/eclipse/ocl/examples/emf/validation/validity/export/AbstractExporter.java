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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;

/**
 * Exports ocl validation results.
 */
public abstract class AbstractExporter implements IValidityExporter
{
	protected final @NonNull List<LeafConstrainingNode> validationErrors = new ArrayList<LeafConstrainingNode>();
	protected final @NonNull List<LeafConstrainingNode> validationFailures = new ArrayList<LeafConstrainingNode>();
	protected final @NonNull List<LeafConstrainingNode> validationInfos = new ArrayList<LeafConstrainingNode>();
	protected final @NonNull List<LeafConstrainingNode> validationSuccess = new ArrayList<LeafConstrainingNode>();
	protected final @NonNull List<LeafConstrainingNode> validationWarnings = new ArrayList<LeafConstrainingNode>();

	private void clearMaps() {
		validationSuccess.clear();
		validationErrors.clear();
		validationFailures.clear();
		validationWarnings.clear();
		validationInfos.clear();
	}

	/**
	 * Returns a stream containing the initial contents to be given to new
	 * exported validation results file resource instances.
	 * 
	 * @param s
	 * 							The contents to be appended
	 * @param rootNode
	 * 							The validation result model
	 * @param exportedFileName
	 * 							The target file name or null if not known and not to be reported
	 * 
	 * @throws IOException 
	 */
	protected abstract void createContents(@NonNull Appendable s, @NonNull RootNode rootNode, @Nullable String exportedFileName) throws IOException;

	public @NonNull String export(@NonNull RootNode rootNode, @Nullable String exportedFileName) {
		StringBuilder s = new StringBuilder();
		try {
			export(s, rootNode, exportedFileName);
		} catch (IOException e) { /* StringBuilder doesn't throw IOExceptions */ }
		return s.toString();
	}

	public void export(@NonNull Appendable s, @NonNull RootNode rootNode, @Nullable String exportedFileName) throws IOException {
		populateMaps(rootNode);
		createContents(s, rootNode, exportedFileName);
		clearMaps();
	}

	protected int getConstraintCount() {
		return validationErrors.size() + validationFailures.size() + validationInfos.size() + validationSuccess.size() + validationWarnings.size();
	}

	@Override
	public @NonNull IValidityExporter getExporter() {
		return this;
	}

	protected String getMessage(Result result) {
		if (result == null) {
			return null;
		}
		StringWriter message = new StringWriter();
		Object diagnostic = result.getDiagnostic();
		if (diagnostic == null) {
			message.append("null diagnostic message");
		} else if (diagnostic instanceof Diagnostic) {
			boolean isFirst = true;
			List<Diagnostic> diagnosticChildren = ((Diagnostic) diagnostic)
					.getChildren();
			if (diagnosticChildren != null && !diagnosticChildren.isEmpty()) {
				for (Diagnostic child : diagnosticChildren) {
					if (isFirst) {
						message.append(child.getMessage());
						isFirst = false;
					} else {
						message.append("\n" + child.getMessage());
					}
				}
			} else {
				message.append(((Diagnostic) diagnostic).getMessage());
			}
			return message.toString();
		} else {
			return diagnostic.toString();
		}
		Throwable exception = result.getException();
		if (exception != null) {
			message.append('\n');
			exception.printStackTrace(new PrintWriter(message));
		}
		return message.toString();
	}

	protected String getSeverity(Result result) {
		if (result != null) {
			return result.getSeverity().getName();
		}
		return null;
	}

	private void populateMaps(RootNode rootNode) {
		for (ValidatableNode validatableNode : rootNode.getValidatableNodes()) {
			populateMaps(validatableNode);
		}
	}

	private void populateMaps(ValidatableNode validatableNode) {
		if (validatableNode instanceof ResultValidatableNode){
			ResultValidatableNode resultValidatableNode = (ResultValidatableNode) validatableNode;
			Result result = resultValidatableNode.getWorstResult();
			if (result != null){
				LeafConstrainingNode leafConstrainingNode = result.getLeafConstrainingNode();
				Severity severity = result.getSeverity();
				switch (severity.getValue()) {
					case Severity.OK_VALUE :
						validationSuccess.add(leafConstrainingNode);
						break;
					case Severity.ERROR_VALUE :
						validationErrors.add(leafConstrainingNode);
						break;
					case Severity.FATAL_VALUE :
						validationFailures.add(leafConstrainingNode);
						break;
					case Severity.WARNING_VALUE :
						validationWarnings.add(leafConstrainingNode);
						break;
					case Severity.INFO_VALUE :
						validationInfos.add(leafConstrainingNode);
						break;
					default :
						break;
				}
			}
		} else {
			for(ValidatableNode node : validatableNode.getChildren()){
				populateMaps(node);
			}
		}
	}
}
