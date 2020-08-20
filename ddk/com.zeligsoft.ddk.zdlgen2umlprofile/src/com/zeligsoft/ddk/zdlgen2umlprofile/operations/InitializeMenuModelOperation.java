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
 * 
 * The class that performs the generation of the ZDLGen to UMLProfile transformation.
 * 
 * @author tmcclean
 *
 */
public class InitializeMenuModelOperation implements IRunnableWithProgress {
	/**
	 * The path to the zdlgen2umlprofile workflow file.
	 */
	public static String workflow_path = "workflows/initializeMenuModel.oaw"; //$NON-NLS-1$

	public static String SOURCE_MODEL_URI = "sourceModelURI"; //$NON-NLS-1$
	public static String TARGET_MODEL_URI = "targetMenuModelURI"; //$NON-NLS-1$
	public static String SPECIALIZATION_NAME = "specialization"; //$NON-NLS-1$

	private Shell shell;
	private Map<String, String> properties;
	private Map<String, Object> slots;
	private String workflowFile;
	
	private IStatus status;

	public InitializeMenuModelOperation(Shell shell, Map<String, String> properties, String workflowFile) {
		this(shell, properties, null, workflowFile);
	}
	
	public InitializeMenuModelOperation(Shell shell, Map<String, String> properties, Map<String, Object> slots, String workflowFile) {
		super();
		this.shell = shell;
		this.properties = properties;
		this.workflowFile = workflowFile;
		this.slots = slots;
	}
	
	public void run() {

		try {
			new ProgressMonitorDialog(getShell()).run(false, true, this);

		} catch (InvocationTargetException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {

		URL workflow = Activator.getDefault().getBundle().getEntry(workflowFile);
		status = WorkflowUtil.executeWorkflow(workflow, monitor, properties, slots);
		
		if (!status.isOK()) {
			Activator.log(status);
		}
	}

	protected Shell getShell() {
		return shell;
	}

	/**
	 * After execution of the workflow, provides the status object indicating
	 * how it fared.
	 * 
	 * @return the workflow's status, or <code>null</code> if it is not yet
	 *     executed
	 */
	public IStatus getStatus() {
		return status;
	}
}
