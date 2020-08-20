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
package com.zeligsoft.ddk.zdl.zdlgen.codegen;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;

/**
 * A code generation action contributed to the ZDLGen model editor
 * context menu. If the implementing class also implements the 
 * {@link ISelectionChangedListener} interface, then it will be
 * registered for selection changes in the editor. However, this
 * interface is designed to be implementable in non-UI-dependent code.
 * 
 * @author prismtech
 *
 */
public interface ICodegenAction {
	public static final String SHELL = "shell"; //$NON-NLS-1$
	public static final String ACTIVE_PART = "activePart"; //$NON-NLS-1$
	public static final String WORKSPACE_URI = "workspaceURI"; //$NON-NLS-1$
	public static final String MODEL_URI = "modelURI"; //$NON-NLS-1$
	
	/**
	 * Runs code generation on an input selected by the user. The
	 * {@code context} map contains at least the following mappings:
	 * <ul>
	 * 	<li>{@code org.eclipse.swt.widgets.Shell.class} &rarr; the 
	 *  {@link Shell} to use as the parent for any interactive dialogs.</li>
	 * </ul>
	 * 
	 * @param genObject
	 * 		the ZDL Generator model element on which I am invoked
	 * @param context
	 * 		a map containing potentially useful information about the 
	 * 		context of the invocation
	 * @return
	 * 		a status indicating possible informational or warning results
	 * 		of the generation, or even errors if it could not be
	 * 		completed normally
	 * @throws CodegenException
	 * 		on a fatal error that prevents normal processing. Outputs
	 * 		may be partially generated and in an inconsistent state
	 */
	public abstract IStatus execute(
			GenDomainObject genObject, 
			Map<Object, Object> context) throws CodegenException;
}
