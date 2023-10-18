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
package org.eclipse.ocl.examples.debug.vm;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.data.VMBreakpointData;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.LineNumberProvider;
import org.eclipse.ocl.pivot.Element;


public class VMBreakpointManager
{
	protected final @NonNull VMVirtualMachine vmVirtualMachine;
	private final @NonNull UnitManager fUnitManager;
	private final @NonNull Map<EObject, VMBreakpoint> fElement2Breakpoint = new HashMap<EObject, VMBreakpoint>();

	// FIXME - Simulates an fBreakpointID that does not come from the VM client
	// based on the knowledge that marker long fBreakpointID is used (positive number)
	// this one will be negative long
	private long fPrivateBreakpointID = 0;


	public VMBreakpointManager(@NonNull VMVirtualMachine vmVirtualMachine, @Nullable CompiledUnit mainUnit) {
		if(mainUnit == null) {
			throw new IllegalArgumentException("null main unit"); //$NON-NLS-1$
		}
		this.vmVirtualMachine = vmVirtualMachine;
		fUnitManager = new UnitManager(mainUnit);
	}

	public @NonNull VMDebugCore getDebugCore() {
		return vmVirtualMachine.getDebugCore();
	}

	public @NonNull UnitManager getUnitManager() {
		return fUnitManager;
	}

	public synchronized @NonNull List<VMBreakpoint> getBreakpoints(Element e) {
		VMBreakpoint breakpoint = fElement2Breakpoint.get(e);
		return (breakpoint != null) ? Collections.singletonList(breakpoint) : Collections.<VMBreakpoint>emptyList();
	}


	public synchronized @Nullable VMBreakpoint createBreakpoint(VMNewBreakpointData data) {
		// FIXME - raise CoreEXxc... for invalid uris
		URI uri = URI.createURI(data.getTargetURI());

		// FIXME - a temp hack to get correct source URI when running a separate VM
		if (uri.isPlatformResource() && isPlatformDeployed()) {
			uri = URI.createPlatformPluginURI(uri.toPlatformString(true), true);
		}

		if (fUnitManager.getCompiledModule(uri) == null) {
			// FIXME - unify on using encoded form, only UI should receive decoded
			uri = URI.createURI(URI.decode(uri.toString()));
		}

		int line = data.getLine();
		Element targetElement = getBreakpointableElement(uri, line);
		if(targetElement == null) {
			return null;
		}

		VMBreakpoint vmBreakpoint = vmVirtualMachine.createBreakpoint(targetElement, data, false);
		fElement2Breakpoint.put(targetElement, vmBreakpoint);
		return vmBreakpoint;
	}


	public synchronized @NonNull VMBreakpoint createVMPrivateBreakpoint(URI unitURI, @NonNull Element element, int line, boolean isTemporary) throws CoreException {
		@SuppressWarnings("null")@NonNull String string = unitURI.toString();
		VMBreakpoint breakpoint = vmVirtualMachine.createBreakpoint(element, --fPrivateBreakpointID, line, string, isTemporary);
		fElement2Breakpoint.put(element, breakpoint);
		return breakpoint;
	}

	public synchronized VMBreakpoint[] getAllBreakpoints() {
		return fElement2Breakpoint.values().toArray(new VMBreakpoint[fElement2Breakpoint.size()]);
	}

	public synchronized Element getBreakpointableElement(@NonNull URI targetURI, int lineNumber) {
		LineNumberProvider lineNumberProvider = fUnitManager.getLineNumberProvider(targetURI);
		if (lineNumberProvider == null) {
			return null;
		}
		CompiledUnit unit = fUnitManager.getCompiledModule(targetURI);
		if (unit == null) {
			return null;
		}
		List<Element> elements = vmVirtualMachine.getRunnerFactory().getValidBreakpointLocator().getBreakpointableElementsForLine(unit, lineNumberProvider, lineNumber);
		if (elements.isEmpty()) {
			return null;
		}

		return elements.get(0);
	}


	public boolean removeBreakpoint(@NonNull VMBreakpoint breakpoint) {
		return removeBreakpoint(breakpoint.getID());
	}

	public synchronized boolean removeBreakpoint(long breakpointID) {
		for(Map.Entry<EObject, VMBreakpoint> entry : fElement2Breakpoint.entrySet()) {
			VMBreakpoint next = entry.getValue();
			if(breakpointID == next.getID()) {
				fElement2Breakpoint.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}


	public synchronized boolean changeBreakpoint(long breakpointID, @Nullable VMBreakpointData data) {
		VMNewBreakpointData newBreakpointData = null;

		for(Map.Entry<EObject, VMBreakpoint> entry : fElement2Breakpoint.entrySet()) {
			VMBreakpoint next = entry.getValue();
			if(breakpointID == next.getID()) {
				fElement2Breakpoint.remove(entry.getKey());
				if (data != null) {
					newBreakpointData = new VMNewBreakpointData(data, breakpointID, next.getLineNumber(), next.getUri());
				}
				break;
			}
		}

		if(newBreakpointData != null) {
			createBreakpoint(newBreakpointData);
			return true;
		}

		return false;
	}

	private boolean isPlatformDeployed() {
		CompiledUnit mainUnit = getUnitManager().getMainUnit();
		return mainUnit.getURI().isPlatformPlugin();
	}
}
