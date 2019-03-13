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
package com.zeligsoft.domain.ngc.ccm.descriptorgeneration.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Generate deployment descriptors for all deployment plans within a user
 * selected model.
 * 
 * @author Hua Guo (hguo)
 * 
 */
public class GenerateAllDescriptors extends AbstractWorkflowComponent {
	
	public static final String MODEL_URI_STRING = "modelURI"; //$NON-NLS-1$
	public static final String SRC_GEN = "src-gen"; //$NON-NLS-1$
	public static String ELEMENT_STRING = "element"; //$NON-NLS-1$

	private String srcGen;
	
	private String pathnameSlot;

	/**
	 * Pathnames of generated files will be written into.
	 * 
	 * @param value
	 */
	public void setPathnameSlot(String value) {
		this.pathnameSlot = value;
	}

	/**
	 * @return Pathnames of generated files will be written into.
	 */
	public String getPathnameSlot() {
		return pathnameSlot;
	}
	
	public void setSrcGen( String srcGenPath){
		srcGen = srcGenPath;
	}

	/**
	 * Default constructor which
	 */
	public GenerateAllDescriptors() {
	}

	public void checkConfiguration(Issues issues) {
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		if (issues.getErrors().length > 0) {
			return;
		}

		Package element = (Package) ctx.get(ELEMENT_STRING);

		if (element == null) {
			String errString = Messages.GenerateAllDescriptors_ErrorElementIsNull;
			issues.addError(errString);
			return;
		}

		String modelUriString = element.eResource().getURI().toString();

		String defaultFlow = "workflow/ngcgeneratorNoPostGeneration.mwe"; //$NON-NLS-1$

		List<Element> deploymentPlans = IDL3PlusUtil.getConceptElements(element, CCMNames.DEPLOYMENT_PLAN);
		Set<String> pathnames = new HashSet<String>();
		for (Element aDeploymentPlan : deploymentPlans) {
			String aDeploymentUriString = aDeploymentPlan.eResource().getURI()
					.toString();

			Map<String, String> properties = new HashMap<String, String>();
			properties.put(MODEL_URI_STRING, aDeploymentUriString);
			properties.put(SRC_GEN, srcGen);
			
			HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
			externalSlotContents.put(ELEMENT_STRING, aDeploymentPlan);

			WorkflowEngine workflow = new WorkflowEngine();
			IssuesImpl issuesImpl = new IssuesImpl();

			final boolean configOK = workflow.prepare(defaultFlow,
					new NullProgressMonitor(), properties);
			if (!configOK) {
				issues.addError(Messages.GenerateAllDescriptors_FailurePreparingWorkflow
						+ defaultFlow);
			}
			final boolean executeOK = workflow.executeWorkflow(
					externalSlotContents, issuesImpl);
			pathnames.addAll((Set<String>) workflow.getContext().get(
					getPathnameSlot()));
			if (!executeOK || issuesImpl.getErrors().length > 0) {
				String errString = Messages.GenerateAllDescriptors_FailureExecutingWorkflow
						+ defaultFlow + " on " + modelUriString; //$NON-NLS-1$
				for (MWEDiagnostic issue : issuesImpl.getErrors()) {
					errString += System.getProperty("line.separator") + issue.getMessage(); //$NON-NLS-1$
				}
				issues.addError(errString);
			}
		}
		ctx.set(getPathnameSlot(), pathnames);
	}
}
