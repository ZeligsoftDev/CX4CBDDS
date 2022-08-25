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
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMGenerationUtils;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class CollectPathnames extends AbstractWorkflowComponent {

	private String pathnamesSlot;

	/**
	 * Pathnames of generated files will be written into.
	 * 
	 * @param value
	 */
	public void setPathnamesSlot(String value) {
		this.pathnamesSlot = value;
	}

	/**
	 * @return Pathnames of generated files will be written into.
	 */
	public String getPathnamesSlot() {
		return pathnamesSlot;
	}

	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		Set<String> generatedPathnames = new HashSet<String>();

		NamedElement element = (NamedElement) ctx.get("element"); //$NON-NLS-1$
		String path = DDS4CCMGenerationUtils.path(element);
		IProject project = ProjectFactory.getProject(element, null,
				ProjectFactory.MODE_CREATE_BASIC);
		IFile cdp = project.getFile(path + element.getName() + ".cdp"); //$NON-NLS-1$
		generatedPathnames.add(cdp.getLocation().toOSString());
		@SuppressWarnings("rawtypes")
		List parts = (List) ZDLUtil.getValue(element, CCMNames.DEPLOYMENT_PLAN,
				ZMLMMNames.DEPLOYMENT__PART);
		for (Object p : parts) {
			EObject def = ZDLUtil.getEValue((EObject) p,
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if (ZDLUtil.isZDLConcept(def, CCMNames.DOMAIN)) {
				IFile cdd = project.getFile(path
						+ ((NamedElement) def).getName() + ".cdd"); //$NON-NLS-1$
				generatedPathnames.add(cdd.getLocation().toOSString());
			}
		}
		ctx.set(getPathnamesSlot(), generatedPathnames);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		// TODO Auto-generated method stub
	}

}
