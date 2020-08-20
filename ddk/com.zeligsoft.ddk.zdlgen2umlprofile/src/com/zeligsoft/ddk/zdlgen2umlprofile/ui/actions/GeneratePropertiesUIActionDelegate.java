/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.CodegenException;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.operations.GeneratePropertiesUIOperation;

/**
 * @author Toby McClean (tmcclean)
 * 
 */
public class GeneratePropertiesUIActionDelegate
		extends AbstractZDLGenPopupAction
		implements ICodegenAction {

	private String TOOLING_FILE_EXTENSION = "ztooling";//$NON-NLS-1$


	private IStatus doAction(final IWorkbenchPart part, 
			final Shell shell, final GenDomainSpecialization specialization) {

		URI sourceZDLModelURI = specialization.eResource().getURI();
		IPath path = new Path(specialization.getResourceName());
		path = path.removeLastSegments(1);
		String resourceName = sourceZDLModelURI.lastSegment();
		if (UML2Util.isEmpty(resourceName)) {
			resourceName = specialization.getName();
		} 
		
		path = path.append(resourceName);
		path = path.removeFileExtension();
		path = path.addFileExtension(TOOLING_FILE_EXTENSION);
		
		URI result = null;
		String plugin = specialization.getPluginName();
		if (!UML2Util.isEmpty(plugin)) {
			result = URI.createPlatformResourceURI(plugin, true);
			for (String seg : path.segments()) {
				result = result.appendSegment(URI.encodeSegment(seg, false));
			}
		}
		
		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return Status.CANCEL_STATUS;
		}

		IFile sourceFile = WorkspaceSynchronizer.getFile(specialization
			.eResource());
		IProject outputProject = sourceFile.getProject();

		final Map<String, String> genProperties = new HashMap<String, String>();
		final Map<String, Object> genSlots = new HashMap<String, Object>();

		genProperties.put(GeneratePropertiesUIOperation.SOURCE_ZDLMODEL_URI,
			sourceZDLModelURI.toString());
		genProperties.put(GeneratePropertiesUIOperation.SPECIALIZATION_NAME, 
				specialization.getName());
		genSlots.put(GeneratePropertiesUIOperation.TARGET_TOOLINGMODEL_URI,
				result);

		final GeneratePropertiesUIOperation op = new GeneratePropertiesUIOperation(
			shell, genProperties, genSlots,
			GeneratePropertiesUIOperation.GENERATE_PROPERTIESUI_WORKFLOW_URI);

		try {
			if(part != null) {
				IProgressService service = part.getSite().getPage()
					.getWorkbenchWindow().getWorkbench().getProgressService();
	
				service.busyCursorWhile(new WorkspaceModifyOperation() {
	
					@Override
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException,
							InterruptedException {
	
						op.run(monitor);
					}
				});
			} else {
				op.run(new NullProgressMonitor());
			}
		} catch (InvocationTargetException e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
		} catch (InterruptedException e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
		}

		// Refresh the output directory
		try {
			outputProject.refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			return e.getStatus();
		}
		
		return Status.OK_STATUS;
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction#execute(com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject, java.util.Map)
	 */
	@Override
	public IStatus execute(GenDomainObject genObject,
			Map<Object, Object> context) throws CodegenException {
		if(genObject instanceof GenDomainSpecialization) {
			return doAction(getActivePart(context), getShell(context),
					(GenDomainSpecialization) genObject);
		} else {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 
					"Can only execute the generate properties for a GenDomainSpecialization."); //$NON-NLS-1$
		}
	}
}
