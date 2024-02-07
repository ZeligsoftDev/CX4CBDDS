/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class SaveASHandler extends AbstractHandler
{
	public SaveASHandler() {}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (!(editor instanceof XtextEditor)) {
			return null;
		}
		IEditorInput editorInput = editor.getEditorInput();
		if (!(editorInput instanceof IFileEditorInput)) {
			return null;
		}
		IXtextDocument document = ((XtextEditor)editor).getDocument();
		URI asURI = null;
		try {
			asURI = document.readOnly(new IUnitOfWork<URI, XtextResource>()
			{
				@Override
				public URI exec(@Nullable XtextResource resource) throws Exception {
					if (resource instanceof BaseCSResource) {
						Resource asResource = ((BaseCSResource)resource).getASResource();
						return asResource.getURI();
					}
					else {
						return null;
					}
				}
			});
		} catch (Exception e) {}
		if (asURI == null) {
			return null;
		}
		IFile srcFile = ((IFileEditorInput)editorInput).getFile();
		IProject srcProject = srcFile.getProject();
        URI projectURI = URI.createPlatformResourceURI(srcProject.getFullPath().toString() + "/", true);
        URI outURI = URIUtil.deresolve(asURI, projectURI);
        IPath outPath = new Path(outURI.toString());
		IFile outFile = srcProject.getFile(outPath);
		Shell shell = editor.getEditorSite().getShell();
		SaveAsDialog dlg = new SaveAsDialog(shell);
		dlg.setOriginalFile(outFile);
		dlg.create();
		if (shell != null) {
			shell.setText(BaseUIMessages.SaveAS_ShellTitle);
		}
		dlg.setTitle(BaseUIMessages.SaveAS_Title);
		dlg.setMessage(NLS.bind(BaseUIMessages.SaveAS_Description, asURI));
		int status = dlg.open();
		if (status != SaveAsDialog.OK) {
			return null;
		}
		final IPath file = dlg.getResult();
		if (file == null) {
			return null;
		}
        final URI newURI = URI.createPlatformResourceURI(file.toString(), true);
		try {
			document.modify(new IUnitOfWork<Object, XtextResource>()
			{
				@Override
				public Object exec(@Nullable XtextResource resource) throws Exception {
					if (resource instanceof BaseCSResource) {
						ASResource asResource = ((BaseCSResource)resource).getASResource();
						URI oldURI = asResource.getURI();
						boolean wasSaveable = asResource.isSaveable();
						try {
							asResource.setURI(newURI);
							asResource.setSaveable(true);
							asResource.save(null);
						} finally {
							asResource.setURI(oldURI);
							asResource.setSaveable(wasSaveable);
						}
					}
					return null;
				}
			});
		} catch (Throwable e) {
			MessageDialog.openError( shell, BaseUIMessages.SaveError_Title,
				e.getLocalizedMessage());
		}
		return null;
	}
}
