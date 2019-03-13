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
package com.zeligsoft.domain.ngc.ccm.idltouml.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.base.workflow.AbstractEMFComponentWithResourceSet;

/**
 * @author Toby McClean (tmcclean)
 *
 */
@SuppressWarnings("nls")
public class CreateTargetPackageComponent extends AbstractEMFComponentWithResourceSet {

	/**
	 * 
	 */
	public CreateTargetPackageComponent() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 */
	@Override
	protected void doInvoke(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		
		Resource res =getResourceSet().createResource(URI.createURI(getUri() + "NewModel.emx"));
		Package newModel = UMLFactory.eINSTANCE.createPackage();
		Profile standardProfile =
			com.zeligsoft.base.util.RSMUtil.loadPackage(getResourceSet(), URI.createURI(UMLResource.STANDARD_PROFILE_URI));
		newModel.applyProfile(standardProfile);
		res.getContents().add(newModel);
		
		
		ctx.set(getModelSlot(), newModel);
		
	}

}
