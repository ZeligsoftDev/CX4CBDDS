/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.markers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;


public class GoToConstrainingNodeMarker {
	
	private IMarker gotoMarker;
	
	private final IFile resourceFile;
	
	/**
	 * The Constructor.
	 * 
	 * @param file the resource file
	 */
	public GoToConstrainingNodeMarker(@NonNull IFile file){
		this.resourceFile = file;
	}
	
	public IFile getResourceFile(){
		return resourceFile;
	}
	
	/**
	 * Return the {IMarker} to go to.
	 * 
	 * @return the IMarker
	 */
	public IMarker getIMarker() {
		try {
			if (resourceFile.exists()) {
				gotoMarker = resourceFile.createMarker(EValidator.MARKER);
				return gotoMarker;
			}
		} catch (CoreException exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return null;
	}
}
