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
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages;

/**
 * Generator for all CDDs within an DomainDefinition or within a model or package.
 * 
 * @author Ernesto Posse (eposse)
 */
public class BulkCDDGenerator extends BaseDescriptorGenerator {

	private static final String CDD_WORKFLOW = "workflow/ngcCDDgeneratorNoPostGeneration.mwe";

	private Set<String> pathNames;

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
		
		if (element instanceof Namespace) {
			generateAllDescriptorsFor(DDS4CCMNames.DOMAIN_DEPLOYMENT, (Namespace)element, CDD_WORKFLOW, monitor, pathNames, issues);
		}

		ctx.set(getPathnamesSlot(), pathNames);
	}

}
