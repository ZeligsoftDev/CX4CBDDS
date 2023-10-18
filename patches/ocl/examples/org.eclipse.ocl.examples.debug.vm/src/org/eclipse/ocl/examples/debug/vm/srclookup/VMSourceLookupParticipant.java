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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.core.VMStackFrame;


public class VMSourceLookupParticipant extends AbstractSourceLookupParticipant
{
	protected final @NonNull VMDebugCore debugCore;
	
	public VMSourceLookupParticipant(@NonNull VMDebugCore debugCore) {
		this.debugCore = debugCore;
	}
	
    public String getSourceName(Object object) throws CoreException {    	
    	if (object instanceof VMStackFrame) {
			VMStackFrame frame = (VMStackFrame) object;
			URI unitURI = frame.getUnitURI();
			if (unitURI.isFile()) {
				return unitURI.toFileString();
			}
			IFile sourceFile = findSourceFile(unitURI);
			if(sourceFile != null) {
				return sourceFile.getProjectRelativePath().toString();
			}
        } 
        
        return null;
    }
    
	private IFile findSourceFile(URI unitURI) {
		return debugCore.resolveWorskpaceFile(unitURI);
	}
}
