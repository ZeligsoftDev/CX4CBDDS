/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.VMBreakpoint;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;
import org.eclipse.ocl.pivot.Element;

public class OCLBreakpoint extends VMBreakpoint
{
	public OCLBreakpoint(@NonNull Element element, @NonNull VMNewBreakpointData data, boolean isTemporary)  {
		super(element, data, isTemporary);
	}

	public OCLBreakpoint(@NonNull Element element, long id, int line, @NonNull String targetURI, boolean isTemporary)  {
		super(element, id, line, targetURI, isTemporary);
	}
}