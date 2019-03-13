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
package com.zeligsoft.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.emf.mwe.internal.core.Workflow;
import org.eclipse.emf.mwe.internal.core.ast.util.WorkflowFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitorAdapter;

import com.zeligsoft.base.Activator;
import com.zeligsoft.base.l10n.Messages;

/**
 * Static utilities for working with oAW workflows and related objects.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("restriction")
public class WorkflowUtil {

	/**
	 * Not instantiable by clients.
	 */
	private WorkflowUtil() {
		super();
	}

	/**
	 * Executes an oAW workflow, returning its status in the Eclipse way rather
	 * than sending all diagnostic information into the ether.
	 * 
	 * @param workflowURL
	 *            URL (such as a platform:/plugin URL) of the workflow to run
	 * @param monitor
	 *            an optional progress monitor (may be <code>null</code>)
	 * @param parameters
	 *            optional workflow parameters (may be <code>null</code>)
	 * @param slots
	 *            optional slot values (may be <code>null</code>)
	 * 
	 * @return a status indicating problems, if any, in the execution of the
	 *         workflow. If there are no problems, then the result is an OK
	 *         status
	 */
	public static IStatus executeWorkflow(URL workflowURL,
			IProgressMonitor monitor, Map<String, String> parameters,
			Map<String, ?> slots) {

		// handle optional parameters
		ProgressMonitor pm = (monitor == null)
			? new NullProgressMonitor()
			: new ProgressMonitorAdapter(monitor);
		if (parameters == null) {
			parameters = Collections.emptyMap();
		}
		if (slots == null) {
			slots = Collections.emptyMap();
		}

		Issues issues = new IssuesImpl();

		// create the workflow object
		WorkflowFactory factory = new WorkflowFactory();
		final Workflow workflow;

		InputStream input = null;

		try {
			input = workflowURL.openStream();
			workflow = factory.parseInitAndCreate(input, workflowURL.getFile(),
				parameters, WorkflowFactory.getDefaultConverter(), issues);
		} catch (IOException e) {
			Activator.getDefault().error(Messages.WorkflowUtil_openFailed, e);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				Messages.WorkflowUtil_openFailed, e);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				Activator.getDefault().error(Messages.WorkflowUtil_closeFailed,
					e);
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					Messages.WorkflowUtil_closeFailed, e);
			}
		}
		if (issues.hasErrors()) {
			return toStatus(Activator.PLUGIN_ID, issues);
		}

		// check the workflow configuration
		workflow.checkConfiguration(issues);
		if (issues.hasErrors()) {
			return toStatus(Activator.PLUGIN_ID, issues);
		}

		// populate the context with slot values
		WorkflowContext ctx = new WorkflowContextDefaultImpl();
		for (Map.Entry<String, ?> next : slots.entrySet()) {
			ctx.set(next.getKey(), next.getValue());
		}

		// execute the workflow
		pm.started(workflow, ctx);
		try {
			workflow.invoke(ctx, pm, issues);
		} catch (Exception e) {
			Activator.getDefault().error(Messages.WorkflowUtil_exception, e);
			issues.addError(workflow, NLS.bind(Messages.WorkflowUtil_exception,
				e.getLocalizedMessage()), e);
		} finally {
			pm.finished(workflow, ctx);
		}

		return toStatus(Activator.PLUGIN_ID, issues);
	}

	/**
	 * Converts an oAW <tt>Issues</tt> object to an Eclipse status.
	 * 
	 * @param source
	 *            the ID of the plug-in creating the status (used as the source
	 *            of the statuses that I create)
	 * @param issues
	 *            the issues to convert
	 * @return the status object providing the information captured in the
	 *         issues
	 */
	public static IStatus toStatus(String source, Issues issues) {
		List<IStatus> statuses = new java.util.ArrayList<IStatus>();

		MWEDiagnostic[] errors = issues.getErrors();
		if (errors != null) {
			for (MWEDiagnostic next : errors) {
				statuses.add(toStatus(source, IStatus.ERROR, next));
			}
		}

		MWEDiagnostic[] warnings = issues.getWarnings();
		if (warnings != null) {
			for (MWEDiagnostic next : warnings) {
				statuses.add(toStatus(source, IStatus.WARNING, next));
			}
		}

		return statuses.isEmpty()
			? Status.OK_STATUS
			: new MultiStatus(source, 1, statuses.toArray(new IStatus[statuses
				.size()]), Messages.WorkflowUtil_problems, null);

	}

	private static IStatus toStatus(String source, int severity, MWEDiagnostic issue) {
		if (issue.getElement() instanceof Throwable) {
			return new Status(severity, source, issue.getMessage(),
				(Throwable) issue.getElement());
		}
		return new Status(severity, source, issue.getMessage());
	}

	public static IStatus executeWorkflow(IWorkflowCallbacks callbacks,
			URL workflowURL, IProgressMonitor monitor,
			Map<String, String> parameters) {

		// handle optional parameters
		ProgressMonitor pm = (monitor == null)
			? new NullProgressMonitor()
			: new ProgressMonitorAdapter(monitor);
		if (parameters == null) {
			parameters = Collections.emptyMap();
		}

		Issues issues = new IssuesImpl();

		// create the workflow object
		WorkflowFactory factory = new WorkflowFactory();
		final Workflow workflow;

		InputStream input = null;

		try {
			input = workflowURL.openStream();
			workflow = factory.parseInitAndCreate(input, workflowURL.getFile(),
				parameters, WorkflowFactory.getDefaultConverter(), issues);
		} catch (IOException e) {
			Activator.getDefault().error(Messages.WorkflowUtil_openFailed, e);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				Messages.WorkflowUtil_openFailed, e);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				Activator.getDefault().error(Messages.WorkflowUtil_closeFailed,
					e);
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					Messages.WorkflowUtil_closeFailed, e);
			}
		}
		if (issues.hasErrors()) {
			return toStatus(Activator.PLUGIN_ID, issues);
		}

		// check the workflow configuration
		workflow.checkConfiguration(issues);
		if (issues.hasErrors()) {
			return toStatus(Activator.PLUGIN_ID, issues);
		}

		// create a new context and execute and provide the callback with an opportunity
		// to populate the slots (and do whatever else is needed)
		WorkflowContext ctx = new WorkflowContextDefaultImpl();
		callbacks.preInvoke(ctx, issues);

		// last chance to abort before invoke the workflow
		if(issues.hasErrors())
			return toStatus(Activator.PLUGIN_ID, issues);

		// execute the workflow
		pm.started(workflow, ctx);
		try {
			workflow.invoke(ctx, pm, issues);
		} catch (Exception e) {
			Activator.getDefault().error(Messages.WorkflowUtil_exception, e);
			issues.addError(workflow, NLS.bind(Messages.WorkflowUtil_exception,
				e.getLocalizedMessage()), e);
		} finally {
			pm.finished(workflow, ctx);
		}

		// execute the result callback before the workflow is lost
		callbacks.postInvoke(workflow, issues);

		return toStatus(Activator.PLUGIN_ID, issues);
	}
}
