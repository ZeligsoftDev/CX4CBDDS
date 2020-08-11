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
package com.zeligsoft.ddk.zdlgen2umlprofile.operations;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;


/**
 * Runnable which runs the GeneratePropertiesUI workflow.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class GeneratePropertiesUIOperation
		implements IRunnableWithProgress {

	public static final String SPECIALIZATION_NAME = "specialization"; //$NON-NLS-1$;

	/**
	 * The URI of the output resource tooling model.
	 */
	public static String TARGET_TOOLINGMODEL_URI = "targetToolingModelURI";//$NON-NLS-1$

	/**
	 * The URI of the source resource domain model.
	 */
	public static String SOURCE_ZDLMODEL_URI = "sourceModelURI"; //$NON-NLS-1$
	
	/**
	 * The path to the workflow file which generates the Properties UI tooling model.
	 */
	public static String GENERATE_PROPERTIESUI_WORKFLOW_URI = "workflows/generatePropertiesUI.oaw"; //$NON-NLS-1$

	private Shell shell;
	private Map<String, String> properties;
	private Map<String, Object> slots;
	private String workflowFile;
	
	private IStatus status;
	
	/**
	 * 
	 * @param shell
	 * @param properties
	 * @param workflowFile
	 */
	public GeneratePropertiesUIOperation(Shell shell, Map<String, String> properties, String workflowFile) {
		this(shell, properties, null, workflowFile);
	}
	
	/**
	 * Create an instance of the this operation.
	 * @param shell
	 * @param properties
	 * @param slots
	 * @param workflowFile
	 */
	public GeneratePropertiesUIOperation(Shell shell, Map<String, String> properties, Map<String, Object> slots, String workflowFile) {
		super();
		this.shell = shell;
		this.properties = properties;
		this.workflowFile = workflowFile;
		this.slots = slots;
	}

	/**
	 * Creates an instance of {@link ProgressMonitorDialog} and runs this
	 * instance.
	 */
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
			
		URL workflow = Activator.getDefault().getBundle().getEntry(workflowFile);
		status = WorkflowUtil.executeWorkflow(workflow, monitor, properties, slots);
		
		if (!status.isOK()) {
			Activator.getDefault().getLog().log(status);
		}
	}

	protected Shell getShell() {
		return shell;
	}
}
