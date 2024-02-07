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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;


public class GoToValidatableNodeMarker {
	
	private IMarker gotoMarker;
	
	private IFile resourceFile;
	
	private final Map<String, Object> attributesMap = new HashMap<String, Object>();
	
	private EObject target;
	
	/** 
	 * The Constructor.
	 * 
	 * @param file the resource file
	 * @param eObject
	 */
	public GoToValidatableNodeMarker(@NonNull IFile file, @NonNull EObject eObject){
		this.resourceFile = file;
		this.target = eObject;
	}
	
	/**
	 * Return the {IMarker} to go to.
	 * 
	 * @return the IMarker
	 */
	public IMarker getIMarker() {
		try {
			if (resourceFile.exists()) {
				attributesMap.put(EValidator.URI_ATTRIBUTE,
					EcoreUtil.getURI(target).toString());

				gotoMarker = resourceFile.createMarker(EValidator.MARKER);
				gotoMarker.setAttributes(attributesMap);

				return gotoMarker;
			}
		} catch (CoreException exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return null;
	}
}
