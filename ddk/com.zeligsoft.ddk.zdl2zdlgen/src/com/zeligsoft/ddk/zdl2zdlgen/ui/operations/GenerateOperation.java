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
package com.zeligsoft.ddk.zdl2zdlgen.ui.operations;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.ddk.zdl2zdlgen.Activator;

/**
 * 
 * The class that performs the ZDL to ZDLGen transformation.
 * 
 * @author tmcclean
 * 
 */
public class GenerateOperation
		implements IRunnableWithProgress {

	public static final String SOURCE_MODEL_URI = "sourceModelURI"; //$NON-NLS-1$

	public static final String TARGET_MODEL_URI = "targetModelURI"; //$NON-NLS-1$
	
	/**
	 * A list of domain models (ZDLs) to import.
	 */
	public static final String DOMAIN_MODELS = "domainModels"; //$NON-NLS-1$
	
	/**
	 * A list of referenced ZDLGen models.
	 */
	public static final String REFERENCED_MODELS = "referencedModels"; //$NON-NLS-1$
	
	/**
	 * The name of the resource-set slot.
	 */
	public static final String RESOURCE_SET = "rset"; //$NON-NLS-1$

	private Shell shell;

	private Map<String, String> properties;

	private Map<String, Object> slots;
	
	private String workflowFile;
	
	private IStatus status;

	public GenerateOperation(Shell shell, Map<String, String> genProperties,
			Map<String, Object> genSlots, String zdl2zdlgen_workflow) {
		super();
		this.shell = shell;
		this.properties = genProperties;
		this.workflowFile = zdl2zdlgen_workflow;
		this.slots = genSlots;
	}

	public void run() {
		try {
			new ProgressMonitorDialog(getShell()).run(true, true, this);
		} catch (InvocationTargetException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run(IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException {
		
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
