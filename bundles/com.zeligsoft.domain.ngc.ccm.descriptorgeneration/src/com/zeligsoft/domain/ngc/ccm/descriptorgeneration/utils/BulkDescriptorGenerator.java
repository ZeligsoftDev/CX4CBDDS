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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Generate deployment descriptors for all deployment plans within a user
 * selected model.
 * 
 * @author Hua Guo (hguo)
 * @author Ernesto Posse (eposse)
 */
public class BulkDescriptorGenerator extends BaseDescriptorGenerator {
	
	private static final String CDD_WORKFLOW = "workflow/ngcCDDgeneratorNoPostGeneration.mwe";
	private static final String CDP_WORKFLOW = "workflow/ngcCDPgeneratorNoPostGeneration.mwe";

	public BulkDescriptorGenerator() {
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		if (issues.getErrors().length > 0) {
			return;
		}

		Package umlPackage = (Package) ctx.get(ELEMENT_STRING);

		if (umlPackage == null) {
			String errString = Messages.GenerateAllDescriptors_ErrorElementIsNull;
			issues.addError(errString);
			return;
		}

		Set<String> pathnames = new HashSet<String>();

		generateAllDescriptorsFor(DDS4CCMNames.DOMAIN_DEPLOYMENT, umlPackage, CDD_WORKFLOW, monitor, pathnames, issues);
		generateAllDescriptorsFor(CCMNames.DEPLOYMENT_PLAN, umlPackage, CDP_WORKFLOW, monitor, pathnames, issues);
		
		ctx.set(getPathnamesSlot(), pathnames);
	}
}
