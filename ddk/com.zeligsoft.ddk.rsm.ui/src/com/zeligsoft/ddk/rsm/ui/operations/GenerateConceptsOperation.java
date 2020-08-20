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
package com.zeligsoft.ddk.rsm.ui.operations;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.ddk.rsm.ui.Activator;
import com.zeligsoft.ddk.rsm.ui.l10n.Messages;

/**
 * Operation to run the GenerateZDLConceptsConstants workflow file.
 * 
 * @author jcorchis
 * 
 */
public class GenerateConceptsOperation
		implements IRunnableWithProgress {
	
	public static String MODEL_URI_STRING = "modelURI";//$NON-NLS-1$
	public static String SRC_GEN = "src-gen";//$NON-NLS-1$
	public static String SOURCE_MODEL = "sourceModel"; //$NON-NLS-1$
	public static String PACKAGE_NAME = "packageName";//$NON-NLS-1$
	
	/**
	 * The path to the GenerateConcepts workflow file.
	 */
	public static String GENERATE_CONCEPTS_WORKFLOW_URI = "workflows/GenerateZDLConceptConstants.oaw"; //$NON-NLS-1$

	private Shell shell;

	private Map<String, String> properties = new HashMap<String, String>();

	private IContainer destFolder;

	private Package model;
	
	private String packageName;

	public GenerateConceptsOperation(Shell shell,
			org.eclipse.uml2.uml.Package model, IContainer dest,
			String packageName) {
		this.shell = shell;
		this.model = model;
		this.destFolder = dest;
		this.packageName = packageName;
	}

	public void run() {
		try {
			new ProgressMonitorDialog(getShell()).run(true, true, this);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException {
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		properties.put(SRC_GEN, destFolder.getLocation().toOSString());
		properties.put(MODEL_URI_STRING, model.eResource().getURI().toString());
		properties.put(PACKAGE_NAME, packageName);
		URL workflow = Activator.getDefault().getBundle().getEntry(
			GENERATE_CONCEPTS_WORKFLOW_URI);
		
		IStatus status = WorkflowUtil.executeWorkflow(workflow, new NullProgressMonitor(), properties,
			null);
		if(!status.isOK()) {
			Activator.getDefault().getLog().log(status);
		} else {
			try {
				root.findMember(destFolder.getFullPath()).refreshLocal(1,
					new NullProgressMonitor());
			} catch (CoreException e) {
				Activator
					.getDefault()
					.error(
						NLS
							.bind(
								Messages.ZDLConstantsGenerationActionDelegate_exception_refreshing_Workspace_resource,
								destFolder), e);
			}
			
		}
	}

	protected Shell getShell() {
		return shell;
	}

}
