/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.ui.commands;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.SelectionUtil;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * ExportCompleteOCLHandler supports exporting embedded OCL to a separate Complete OCL document.
 *
 * @since 1.4
 */
public class ExportCompleteOCLHandler extends AbstractHandler
{
	public static @Nullable ResourceSet getResourceSet(@Nullable Object evaluationContext) {
		Object o = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
		if (!(o instanceof IEditorPart)) {
			return null;
		}
		IEditingDomainProvider editingDomainProvider = ClassUtil.getAdapter((IEditorPart)o, IEditingDomainProvider.class);
		if (editingDomainProvider != null) {
			EditingDomain editingDomain = editingDomainProvider.getEditingDomain();
			if (editingDomain == null) {
				return null;
			}
			ResourceSet resourceSet = editingDomain.getResourceSet();
			return resourceSet;
		}
		XtextEditor xtextEditor = ClassUtil.getAdapter((IEditorPart)o, XtextEditor.class);
		if (xtextEditor != null) {
			IXtextDocument document = xtextEditor.getDocument();
			ResourceSet resourceSet = document.readOnly(new IUnitOfWork<ResourceSet, XtextResource>() {
				@Override
				public ResourceSet exec(@Nullable XtextResource xtextResource) {
					if (xtextResource == null) {
						return null;
					}
					EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
					if (environmentFactory != null) {
						return environmentFactory.getResourceSet();
					}
					else {
						return xtextResource.getResourceSet();
					}
				}
			});
			return resourceSet;
		}
		return null;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		if (shell == null) {
			return null;
		}
		Resource selectedResource = getSelectedResource(event);
		if (selectedResource == null) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, BaseUIMessages.MissingSelection);
			return null;
		}
		ResourceSet resourceSet = selectedResource.getResourceSet();
		if (resourceSet == null) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, BaseUIMessages.MissingSelectionResourceSet);
			return null;
		}
		URI modelURI = selectedResource.getURI();
		if (!modelURI.isHierarchical()) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Hierarchical URI required:\n" + modelURI);
			return null;
		}
		if (!modelURI.isRelative()) {
			modelURI = modelURI.deresolve(URIUtil.PLATFORM_RESOURCE);
			if (!modelURI.isRelative()) {
				MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Relative URI required:\n" + modelURI);
				return null;
			}
		}
		URI exportURI = getExportURI(shell, modelURI);
		if (exportURI == null) {
			return null;
		}
		OCLInternal ocl = OCLInternal.newInstance(resourceSet);		// Don't reuse an OCL since export trashes its pivot input.
		try {
			EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
			ASResource asResource = getASResource(shell, environmentFactory, selectedResource);
			if (asResource == null) {
				return null;
			}
			exportEmbeddedOCL(shell, environmentFactory, asResource, exportURI);
			return null;
		}
		finally {
			ocl.dispose();
		}
	}

	protected @Nullable Resource exportEmbeddedOCL(@NonNull Shell shell, @NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull ASResource asResource, @NonNull URI exportURI) {
		ResourceSetImpl csResourceSet = new ResourceSetImpl();
		environmentFactory.adapt(csResourceSet);
		BaseCSResource oclResource = (BaseCSResource) csResourceSet.createResource(exportURI, CompleteOCLCSPackage.eCONTENT_TYPE);
		if (oclResource == null) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Failed to create:\n" + exportURI);
			return null;
		}
		oclResource.updateFrom(asResource, environmentFactory);
		try {
			oclResource.save(null);
		} catch (IOException e) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Failed to save '" + exportURI + "':\n" + e.getMessage());
			return null;
		}
		return oclResource;
	}

	protected ASResource getASResource(@NonNull Shell shell, @NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Resource selectedResource) {
		Element asRoot;
		try {
			asRoot = environmentFactory.loadResource(selectedResource, null);
		} catch (ParserException e) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Failed to load:\n" + e.getMessage());
			return null;
		}
		if (asRoot == null) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Failed to load");
			return null;
		}
		Resource asResource = asRoot.eResource();
		if ((asResource == null) || !(asResource instanceof ASResource)) {
			MessageDialog.openError(shell, BaseUIMessages.ExportError_Title, "Failed to load");
			return null;
		}
		return (ASResource) asResource;
	}

	protected @Nullable URI getExportURI(Shell shell, URI modelURI) {
		URI oclURI = modelURI.trimFileExtension().appendFileExtension("ocl");
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile outFile = root.getFile(new Path(oclURI.toString()));
		SaveAsDialog dlg = new SaveAsDialog(shell);
		dlg.setOriginalFile(outFile);
		dlg.create();
		if (shell != null) {
			shell.setText(BaseUIMessages.Export_ShellTitle);
		}
		dlg.setTitle(BaseUIMessages.Export_Title);
		dlg.setMessage(BaseUIMessages.Export_Description);
		int status = dlg.open();
		if (status != SaveAsDialog.OK) {
			return null;
		}
		IPath file = dlg.getResult();
		if (file == null) {
			return null;
		}
		return URI.createPlatformResourceURI(file.toString(), true);
	}

	protected @Nullable Resource getSelectedResource(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection == null) {
			return null;
		}
		IEditorPart part = HandlerUtil.getActiveEditor(event);
		if (part == null) {
			return null;
		}
		Notifier notifier = SelectionUtil.getNotifierSelection(selection, part);
		if (notifier instanceof Resource) {
			return (Resource) notifier;
		}
		if (notifier instanceof EObject) {
			return ((EObject)notifier).eResource();
		}
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		//		System.out.println("setEnabled " + evaluationContext);
		setBaseEnabled(getResourceSet(evaluationContext) != null);
	}
}
