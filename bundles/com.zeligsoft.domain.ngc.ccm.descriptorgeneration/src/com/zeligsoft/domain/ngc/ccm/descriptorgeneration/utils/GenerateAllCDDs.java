/**
 * Copyright 2022 Zeligsoft Technology Limited.
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
package com.zeligsoft.domain.ngc.ccm.descriptorgeneration.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMDomainDefinitionsUtils;
import com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages;

/**
 * Generate CDDs within an DomainDefinition or within a model.
 * 
 * @author Ernesto Posse (eposse)
 * 
 */
public class GenerateAllCDDs extends AbstractWorkflowComponent {

	private static final String MODEL_URI_STRING = "modelURI"; //$NON-NLS-1$
	private static final String SRC_GEN = "src-gen"; //$NON-NLS-1$
	private static final String ELEMENT_STRING = "element"; //$NON-NLS-1$
	private static final String WORKFLOW = "workflow/ngcCDDgeneratorNoPostGeneration.mwe";

	private String srcGenPath;
	private String pathNameSlot;
	private Set<String> pathNames;

	/**
	 * Pathnames of generated files will be written into.
	 * 
	 * @param value
	 */
	public void setPathnameSlot(String value) {
		this.pathNameSlot = value;
	}

	/**
	 * @return Pathnames of generated files will be written into.
	 */
	public String getPathnameSlot() {
		return pathNameSlot;
	}

	public void setSrcGen(String srcGenPath) {
		this.srcGenPath = srcGenPath;
	}

	public void checkConfiguration(Issues issues) {
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {

		if (issues.getErrors().length > 0) {
			return;
		}

		Object element = ctx.get(ELEMENT_STRING);

		if (element == null) {
			issues.addError(Messages.GenerateAllCDDs_ErrorElementIsNull);
			return;
		}

		if (!(element instanceof EObject) || !(element instanceof Package)
				&& !(ZDLUtil.isZDLConcept((EObject) element, DDS4CCMNames.DOMAIN_DEFINITION))) {
			issues.addError(NLS.bind(Messages.GenerateAllCDDs_ErrorElementIsNotDomainDefinitionOrPackage, element));
			return;
		}

		pathNames = new HashSet<String>();
		if (element instanceof Package) {
			traversePackage((Package) element, ctx, monitor, issues);
		} else {
			generateCDDForDomainDefinition((Component) element, ctx, monitor, issues);
		}

		ctx.set(getPathnameSlot(), pathNames);
	}

	private void generateCDDForDomainDefinition(Component domainDefinition, WorkflowContext ctx,
			ProgressMonitor monitor, Issues issues) {
		List<Component> domainDeployments = DDS4CCMDomainDefinitionsUtils.getDomainDeployments(domainDefinition);
		int numberOfDeployments = domainDeployments.size();
		monitor.beginTask(NLS.bind(Messages.GenerateAllCDDs_TaskTitle, domainDefinition.getQualifiedName()),
				numberOfDeployments);
		for (Component domainDeployment : domainDeployments) {
			if (monitor.isCanceled()) {
				break;
			}
			generateCDDforDomainDeployment(domainDeployment, ctx, monitor, issues);
		}
		monitor.done();
	}

	private void generateCDDforDomainDeployment(Component domainDeployment, WorkflowContext ctx,
			ProgressMonitor monitor, Issues issues) {
		// Gather the workflow parameters
		String domainDeploymentUriString = domainDeployment.eResource().getURI().toString();

		Map<String, String> properties = new HashMap<String, String>();
		properties.put(MODEL_URI_STRING, domainDeploymentUriString);
		properties.put(SRC_GEN, srcGenPath);

		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		externalSlotContents.put(ELEMENT_STRING, domainDeployment);

		WorkflowEngine workflowEngine = new WorkflowEngine();
		Issues subWorkflowIssues = new IssuesImpl();

		// Prepare workflow engine
		final boolean configOK = workflowEngine.prepare(WORKFLOW, monitor, properties);
		if (!configOK) {
			issues.addError(NLS.bind(Messages.GenerateAllCDDs_FailurePreparingWorkflow, WORKFLOW,
					domainDeployment.getQualifiedName()));
		}

		// Check if the user has cancelled the operation
		if (monitor.isCanceled()) {
			return;
		}

		// Execute workflow
		final boolean executeOK = workflowEngine.executeWorkflow(externalSlotContents, subWorkflowIssues);
		if (!executeOK || subWorkflowIssues.getErrors().length > 0) {
			StringBuilder errorStrBuilder = new StringBuilder();
			errorStrBuilder.append(NLS.bind(Messages.GenerateAllCDDs_FailureExecutingWorkflow, WORKFLOW,
					domainDeployment.getQualifiedName()));
			for (MWEDiagnostic issue : subWorkflowIssues.getErrors()) {
				errorStrBuilder.append(System.getProperty("line.separator"));
				errorStrBuilder.append(issue.getMessage()); // $NON-NLS-1$
			}
			issues.addError(errorStrBuilder.toString());
		}

		// Get workflow output: set of paths
		@SuppressWarnings("unchecked")
		final Set<String> paths = (Set<String>) workflowEngine.getContext().get(getPathnameSlot());
		if (paths != null) {
			pathNames.addAll(paths);
		}
	}

	private void traversePackage(Package umlPackage, WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		List<Component> allDomainDefinitions = DDS4CCMDomainDefinitionsUtils.getAllDomainDefinitions(umlPackage);
		int numberOfDeployments = allDomainDefinitions.size();
		monitor.beginTask(NLS.bind(Messages.GenerateAllCDDs_TaskTitle, umlPackage.getQualifiedName()),
				numberOfDeployments);
		for (Component domainDefinition : allDomainDefinitions) {
			if (monitor.isCanceled()) {
				break;
			}
			generateCDDForDomainDefinition(domainDefinition, ctx, monitor, issues);
		}
		monitor.done();
	}
}
