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
package org.eclipse.ocl.examples.debug.vm.srclookup;

import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;

public abstract class VMSourceLookupDirector extends AbstractSourceLookupDirector {	
	
//	private static final String PDE_SOURCE_LOOKUP_DIRECTOR_ID = "org.eclipse.pde.ui.launcher.PDESourceLookupDirector";
	
//	private ISourceLookupDirector fPDEdelegate;
	
	public VMSourceLookupDirector() {
//		try {
//			IPersistableSourceLocator newSourceLocator = DebugPlugin.getDefault().getLaunchManager()
//				.newSourceLocator(PDE_SOURCE_LOOKUP_DIRECTOR_ID);
			
//			if(newSourceLocator instanceof ISourceLookupDirector) {
//				fPDEdelegate = (ISourceLookupDirector) newSourceLocator;
//			}
//		} catch (CoreException e) {
//			getDebugCore().log(e.getStatus());
//		}
	}

	protected abstract @NonNull VMDebugCore getDebugCore();
	
	public void initializeParticipants() {
		addParticipants(new ISourceLookupParticipant[] { new VMSourceLookupParticipant(getDebugCore()) });
//		if(fPDEdelegate != null) {
//			fPDEdelegate.initializeParticipants();
//			addParticipants(fPDEdelegate.getParticipants());
//		}
	}
}
