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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMBreakpoint;
import org.eclipse.ocl.examples.debug.vm.VMBreakpointManager;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LoopExp;

public class IterateBreakpointHelper {

	private final Set<VMBreakpoint> fBreakpoints;
	private final @NonNull VMBreakpointManager fBPM;

	public IterateBreakpointHelper(@NonNull VMBreakpointManager breakpointManager) {
		fBPM = breakpointManager;
		fBreakpoints = new HashSet<VMBreakpoint>();
	}
	
	public VMBreakpoint stepIterateElement(LoopExp element, UnitLocation currentLocation) {			
/*		Root currentModule = currentLocation.getModule();

		LineNumberProvider lineNumProvider = getLineNumberProvider(currentModule);
		if(lineNumProvider == null) {
			return null;
		}

		OCLExpression<EClassifier> body = element.getBody();
		if (body == null) {
			return null;
		}

		int bodyLine = lineNumProvider.getLineNumber(body.getStartPosition());
		int elementLine = lineNumProvider.getLineNumber(element.getStartPosition());

		ASTNode iterateBreakpointedElement = body;

		// ensure we can suspend after stepping within iterator if it's body
		// is spread across multiple lines
		if (body instanceof BlockExp) {
			BlockExp blockExp = (BlockExp) body;
			int bodyEndLine = lineNumProvider.getLineNumber(blockExp.getEndPosition());
			if ((bodyEndLine == elementLine) || blockExp.getBody().isEmpty()) {
				return null;
			}
			
			iterateBreakpointedElement = blockExp.getBody().get(0);
		} else if (bodyLine == elementLine) {
			return null;
		}


		URI unitURI = currentLocation.getURI();
		VMBreakpoint breakpoint = createIterateBreakpoint(unitURI, iterateBreakpointedElement, elementLine);

		return breakpoint; */
		return null;
	}		

	public boolean isIterateBreakpoint(VMBreakpoint breakpoint) {
		return fBreakpoints.contains(breakpoint);
	}

	public VMBreakpoint createIterateBreakpoint(URI unitURI, @NonNull Element breakpointedElement, int line) {
		VMBreakpoint breakpoint = null;
		try {
			breakpoint = fBPM.createVMPrivateBreakpoint(unitURI, breakpointedElement, line, false);
			fBreakpoints.add(breakpoint);
		} catch (CoreException e) {
			fBPM.getDebugCore().log(e.getStatus());
		}
		return breakpoint;
	}

	public void removeIterateBreakpoint(@NonNull VMBreakpoint breakpoint) {
		fBPM.removeBreakpoint(breakpoint);
		fBreakpoints.remove(breakpoint);
	}

	public void removeAllIterateBreakpoints() {
		for (@SuppressWarnings("null")@NonNull VMBreakpoint brk : fBreakpoints) {
			fBPM.removeBreakpoint(brk);
		}
		
		fBreakpoints.clear();
	}
	
//    private LineNumberProvider getLineNumberProvider(Element module) {
//    	return ASTBindingHelper.getModuleSourceBinding(module).getLineNumberProvider();
//    }	
}