/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.DebugVMPlugin;
import org.eclipse.ocl.examples.debug.vm.data.VMBreakpointData;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;


public abstract class VMLineBreakpoint extends LineBreakpoint {

	/**
	 * Family for breakpoint validation job (@see OCLToggleBreakpointAdapter::toggleLineBreakpoints())
	 */
	public static final @NonNull Object OCL_BREAKPOINT_JOBFAMILY = new Object();

	protected static final String HIT_COUNT = DebugVMPlugin.PLUGIN_ID + ".hitCount"; //$NON-NLS-1$

	protected static final int HIT_COUNT_UNDEFINED = -1;

	/**
	 * Breakpoint attribute storing a breakpoint's conditional expression
	 */
	protected static final String CONDITION = DebugVMPlugin.PLUGIN_ID + ".condition"; //$NON-NLS-1$

	/**
	 * Breakpoint attribute storing a breakpoint's condition enablement
	 */
	protected static final String CONDITION_ENABLED = DebugVMPlugin.PLUGIN_ID + ".conditionEnabled"; //$NON-NLS-1$

	/**
	 * Breakpoint attribute storing a breakpoint's condition suspend policy
	 */
	protected static final String CONDITION_SUSPEND_ON_TRUE = DebugVMPlugin.PLUGIN_ID + ".conditionSuspendOnTrue"; //$NON-NLS-1$


	protected static final String TARGET_URI_ATTR = DebugVMPlugin.PLUGIN_ID + ".unitUri"; //$NON-NLS-1$

	protected static final String RUN_TO_LINE = DebugVMPlugin.PLUGIN_ID + ".runToLine"; //$NON-NLS-1$


	/*
	 * Remark: Keep the default constructor to allow the breakpoint manager to create breakpoint from markers
	 */
	protected VMLineBreakpoint() {
		super();
	}

	protected VMLineBreakpoint(final @NonNull URI sourceURI, int lineNumber, final boolean isRunToLine) throws CoreException {
		final IFile sourceFile = getDebugCore().toFile(sourceURI);
		final IResource markerResource = (sourceFile != null && !isRunToLine) ? sourceFile : ResourcesPlugin.getWorkspace().getRoot();

		final Integer lineNum = Integer.valueOf(lineNumber);

		IWorkspaceRunnable wr = new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				// create the marker
				IMarker marker = markerResource.createMarker(getDebugCore().getBreakpointMarkerId());
				setMarker(marker);

				// add attributes
				final Map<String, Object> attributes = new HashMap<String, Object>();

				if(isRunToLine) {
					attributes.put(IBreakpoint.PERSISTED, Boolean.FALSE);
					attributes.put(VMLineBreakpoint.RUN_TO_LINE, Boolean.TRUE);
				}

				attributes.put(IBreakpoint.ENABLED, Boolean.TRUE);
				attributes.put(IMarker.LINE_NUMBER, lineNum);
				attributes.put(IBreakpoint.ID, getModelIdentifier());
				if(sourceFile == null || isRunToLine) {
					attributes.put(TARGET_URI_ATTR, sourceURI.toString());
				}

				ensureMarker().setAttributes(attributes);
			}
		};

		run(getMarkerRule(markerResource), wr);
	}

	public long getID() {
		return getMarker().getId();
	}

	public URI getUnitURI() throws CoreException {
		IMarker marker = getMarker();
		IResource res = marker.getResource();
		if(res.getType() == IResource.FILE) {
			return VMDebugCore.getResourceURI(marker.getResource());
		}

		String uriStr = marker.getAttribute(TARGET_URI_ATTR, null);
		assert uriStr != null;
		return URI.createURI(uriStr);
	}

	public @NonNull VMNewBreakpointData createNewBreakpointData() throws CoreException {
		@SuppressWarnings("null")@NonNull String string = getUnitURI().toString();
		VMNewBreakpointData newBpData = createNewBreakpointData(string);
		return newBpData;
	}

	public @NonNull VMNewBreakpointData createNewBreakpointData(@NonNull String targetURI) throws CoreException {
		VMNewBreakpointData newBpData = new VMNewBreakpointData(isConditionEnabled(), getCondition(), isConditionSuspendOnTrue(), getHitCount(),
				getID(), getLineNumber(), targetURI);
		return newBpData;
	}

	public @NonNull VMBreakpointData createBreakpointData() throws CoreException {
		VMBreakpointData bpData = new VMBreakpointData(isConditionEnabled(), getCondition(), isConditionSuspendOnTrue(), getHitCount());
		return bpData;
	}

	@Override
	public @NonNull String getModelIdentifier() {
		return getDebugCore().getModelId();
	}

	protected abstract @NonNull VMDebugCore getDebugCore();

	/**
	 * Add this breakpoint to the breakpoint manager,
	 * or sets it as unregistered.
	 */
	public void register(boolean register) throws CoreException {
		if (register) {
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(this);
		} else {
			setRegistered(false);
		}
	}

	public int getHitCount() throws CoreException {
		return ensureMarker().getAttribute(HIT_COUNT, HIT_COUNT_UNDEFINED);
	}

	public void setHitCount(int count) throws CoreException {
		if (getHitCount() != count) {
			if (!isEnabled() && count > -1) {
				setAttributes(new String[] { ENABLED, HIT_COUNT },
						new Object[] { Boolean.TRUE, Integer.valueOf(count) });
			} else {
				setAttributes(new String[] { HIT_COUNT },
						new Object[] { Integer.valueOf(count) });
			}
		}
	}

	public boolean isLineToRunBreakpoint() {
		return getMarker().getAttribute(VMLineBreakpoint.RUN_TO_LINE, false);
	}

	public boolean supportsCondition() {
		return true;
	}

	public String getCondition() throws CoreException {
		return ensureMarker().getAttribute(CONDITION, null);
	}

	public void setCondition(String condition) throws CoreException {
		if (condition != null && condition.trim().length() == 0) {
			condition = null;
		}
		setAttribute(CONDITION, condition);
	}

	public boolean isConditionEnabled() {
		return getMarker().getAttribute(CONDITION_ENABLED, false);
	}

	public void setConditionEnabled(boolean conditionEnabled) throws CoreException {
		setAttribute(CONDITION_ENABLED, Boolean.valueOf(conditionEnabled));
	}

	public boolean isConditionSuspendOnTrue() throws DebugException {
		return ensureMarker().getAttribute(CONDITION_SUSPEND_ON_TRUE, true);
	}

	public void setConditionSuspendOnTrue(boolean suspendOnTrue) throws CoreException {
		if (isConditionSuspendOnTrue() != suspendOnTrue) {
			setAttribute(CONDITION_SUSPEND_ON_TRUE, Boolean.valueOf(suspendOnTrue));
		}
	}

}