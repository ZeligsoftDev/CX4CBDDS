/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.ocl.xtext.base.ui.utilities.ThreadLocalExecutorUI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.XtextResource;

/**
 * BaseDocumentProvider provides an OCL instance whose lifetime correlates
 * with the editor and which is accessible from the Xtext SynchronizedResourceSet.
 */
@SuppressWarnings("deprecation")
public class BaseDocumentProvider extends DeferredDocumentProvider
{
	private @Nullable OCLInternal ocl;		// FIXME move to BaseEditor just like EmbeddedXtextEditor

	public BaseDocumentProvider() {
		super();
	}

	protected @NonNull OCLInternal createOCL() {
		return OCLInternal.newInstance();
	}

	@Override
	protected void disconnected() {
		OCL ocl2 = ocl;
		if (ocl2 != null) {
			ocl = null;
			ocl2.dispose();
		}
		super.disconnected();
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		EnvironmentFactory environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
		if (environmentFactory != null) {
			return (EnvironmentFactoryInternal) environmentFactory;
		}
		return getOCL().getEnvironmentFactory();
	}

	protected @NonNull OCLInternal getOCL() {
		OCLInternal ocl2 = ocl;
		if (ocl2 == null) {
			ocl = ocl2 = createOCL();
		}
		return ocl2;
	}

	public void initOCL(@NonNull BaseEditor baseEditor) {
		ThreadLocalExecutorUI.initPart(baseEditor, null);
		OCLInternal ocl = getOCL();
		ThreadLocalExecutorUI.initPart(baseEditor, ocl.getEnvironmentFactory());
	}

	@Override
	protected void loadResource(XtextResource resource, String document, String encoding) throws CoreException {
		if (resource != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet != null) {
				getEnvironmentFactory().adapt(resourceSet);
			}
		}
		super.loadResource(resource, document, encoding);
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput, String encoding) throws CoreException {
		if (editorInput != null) {
			IResource resource = ClassUtil.getAdapter(editorInput, IResource.class);
			if (resource != null) {
				IProject project = resource.getProject();
				EnvironmentFactoryInternal environmentFactory = getEnvironmentFactory();
				environmentFactory.setProject(project);
			}
		}
		return super.setDocumentContent(document, editorInput, encoding);
	}
}
