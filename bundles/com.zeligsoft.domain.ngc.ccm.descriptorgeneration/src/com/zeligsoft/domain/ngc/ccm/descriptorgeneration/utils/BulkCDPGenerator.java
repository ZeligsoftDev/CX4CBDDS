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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Generate all CDPs within an Deployment Plan or within a package or model.
 * 
 * @author Ernesto Posse (eposse)
 */
public class BulkCDPGenerator extends BaseDescriptorGenerator {

	private static final String CDP_WORKFLOW = "workflow/ngcCDPgeneratorNoPostGeneration.mwe";

	private Set<String> pathNames;

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {

		if (issues.getErrors().length > 0) {
			return;
		}

		Object element = ctx.get(ELEMENT_STRING);

		if (element == null) {
			issues.addError(Messages.GenerateAllCDPs_ErrorElementIsNull);
			return;
		}

		if (!(element instanceof EObject) || !(element instanceof Package)
				&& !(ZDLUtil.isZDLConcept((EObject) element, CCMNames.DEPLOYMENT_PLAN))) {
			issues.addError(NLS.bind(Messages.GenerateAllCDPs_ErrorElementIsNotDeploymentPlanOrPackage, element));
			return;
		}

		pathNames = new HashSet<String>();
		if (element instanceof Package) {
			generateAllDescriptorsFor(CCMNames.DEPLOYMENT_PLAN, (Package)element, CDP_WORKFLOW, monitor, pathNames, issues);
		} else {
			generateCDPForDeploymentPlan((Component) element, monitor, issues);
		}

		ctx.set(getPathnamesSlot(), pathNames);
	}

	private void generateCDPForDeploymentPlan(Component deploymentPlan, ProgressMonitor monitor,
			Issues issues) {
		monitor.beginTask(NLS.bind(Messages.GenerateAllCDPs_TaskTitle, deploymentPlan.getQualifiedName()),
				ProgressMonitor.UNKNOWN);
		
		executeWorkflow(deploymentPlan, CDP_WORKFLOW, monitor, pathNames, issues);
		
		monitor.done();
	}

}
