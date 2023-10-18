/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.oclstdlib.scoping.JavaClassScope;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

/**
 * OCLstdlibJavaClassPathResourceForIEditorInputFactory passes the project from the editorInput to a
 * JavaClassScope adapter onn the created resource for subsequent classPath resolution.
 */
public class OCLstdlibJavaClassPathResourceForIEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory
{
	@Override
	public Resource createResource(IEditorInput editorInput) {
		Resource csResource = super.createResource(editorInput);
		if ((csResource instanceof BaseCSResource) && (editorInput instanceof FileEditorInput)) {
			IProject project = ((FileEditorInput)editorInput).getFile().getProject();
			if (project != null) {
				JavaClassScope.getAdapter((BaseCSResource) csResource, project);
			}
		}
		return csResource;
	}
}
