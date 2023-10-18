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
package org.eclipse.ocl.examples.debug.srclookup;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.debug.vm.srclookup.VMSourcePathComputer;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;

public class OCLSourcePathComputer extends VMSourcePathComputer
{
	public static final @NonNull String ID = "org.eclipse.ocl.examples.debug.srclookup.OCLSourcePathComputer";  //$NON-NLS-1$
	
	public @NonNull String getId() {
		return ID;
	}

	protected URI getModuleFile(@NonNull ILaunchConfiguration configuration) throws CoreException {
//      String moduleFileName = configuration.getAttribute(LaunchConstants.MODULE, ""); //$NON-NLS-1$
		Map<String, Object> attributes = configuration.getAttributes();
		Object contextObject = attributes.get(OCLLaunchConstants.CONTEXT_OBJECT);
		Object expressionObject = attributes.get(OCLLaunchConstants.EXPRESSION_OBJECT);
	    URI uri = null;
		if (((contextObject == null) || (contextObject instanceof EObject)) && (expressionObject instanceof ExpressionInOCL)) {
			uri = EcoreUtil.getURI((ExpressionInOCL) expressionObject);
		}
		else {
			String moduleFileName = configuration.getAttribute(OCLLaunchConstants.CONSTRAINT_URI, ""); //$NON-NLS-1$
			uri = URI.createURI(moduleFileName);
		}
		@NonNull URI trimFragment = uri.trimFragment();
		URI moduleURI = PivotUtilInternal.getNonASURI(trimFragment);
		return moduleURI;
//      IFile moduleFile = getWorkspaceFile(moduleUri);
//      if (moduleFile == null) {
      	//IStatus errorStatus = MiscUtil.makeErrorStatus( 
      		//	NLS.bind(Messages.VMLaunchConfigurationDelegate_transformationFileNotFound, moduleFileName));
      	//throw new CoreException(errorStatus);
//      }
      
//      return moduleFile;
	}
}
