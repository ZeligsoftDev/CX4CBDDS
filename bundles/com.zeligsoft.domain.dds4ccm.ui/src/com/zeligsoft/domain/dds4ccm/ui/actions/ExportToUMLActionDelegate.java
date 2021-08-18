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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionDelegate;

import com.ibm.xtools.rmp.core.IConverterHandler;
import com.ibm.xtools.rmp.core.internal.convert.ModelExporter;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.export.CX2UML2Exporter;

/**
 * Quick export to UML converting RSA diagram notation to GMF notation for
 * diagram migration to Papyrus
 * 
 * @author Young-Soo Roh
 *
 */
public class ExportToUMLActionDelegate extends ActionDelegate implements
		IObjectActionDelegate, IConverterHandler {

	private static final IContentType EMX_TYPE = Platform
			.getContentTypeManager().getContentType(
					"com.ibm.xtools.uml.msl.umlModelContentType");

	private IFile selectedFile;

	private Shell shell;

	private IWorkbenchPart part;

	/**
	 * Initializes me.
	 */
	public ExportToUMLActionDelegate() {
		super();
	}

	public void run(IAction action) {
		if (selectedFile == null) {
			return;
		}
		
		boolean shouldExport = true;
		IPath umlPath = selectedFile.getFullPath().removeFileExtension().addFileExtension("uml");
		IFile file =ResourcesPlugin.getWorkspace().getRoot().getFile(umlPath);
		if(file.exists()){
			// uml file exist
			shouldExport = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Export UML", "The UML file already exists. Do you want to overwrite the existing one?");
			if(shouldExport){
				try {
					file.delete(true, new NullProgressMonitor());
				} catch (CoreException e) {
					// delete failed.
				}
			}
		}
		
		if (shouldExport) {
			try {
				part.getSite().getPage().getWorkbenchWindow().getWorkbench()
						.getProgressService()
						.busyCursorWhile(new IRunnableWithProgress() {

							@Override
							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								doRun(monitor);
							}
						});
			} catch (Exception e) {
				MessageDialog.openError(shell, "Export to UML",
						"Export failed: " + e.getLocalizedMessage());
			}
		}
	}

	private void doRun(IProgressMonitor monitor) {
		monitor.beginTask("Exporting ... ", 7);

		ModelExporter exporter = (ModelExporter) new CX2UML2Exporter(false, false, this);
		String[] files = Collections.singletonList(selectedFile.getRawLocation().toString()).toArray(new String[0]);
		String dest = selectedFile.getParent().getRawLocation().toString();
		exporter.doExport(files, dest);
		
		monitor.done();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedFile = null;
		IFile file = null;

		if (!selection.isEmpty() && (selection instanceof IStructuredSelection)) {
			IStructuredSelection ssel = (IStructuredSelection) selection;

			Object sel = ssel.getFirstElement();

			if (sel instanceof IFile) {
				file = (IFile) sel;
			} else if (sel instanceof IAdaptable) {
				file = (IFile) ((IAdaptable) sel).getAdapter(IFile.class);
			}

			if (file != null) {
				if ("emx".equals(file.getFileExtension())) {
					String fileName = file.getName();
					InputStream contents = null;

					try {
						contents = file.getContents();
						IContentType[] matches = Platform
								.getContentTypeManager().findContentTypesFor(
										contents, fileName);
						for (IContentType next : matches) {
							if (next.isKindOf(EMX_TYPE)) {
								selectedFile = file;
								break;
							}
						}
					} catch (IOException e) {
						Log.error(Activator.getDefault(), 0,
								"Failed to examine content-types of file: "
										+ file.getFullPath(), e);
					} catch (CoreException e) {
						Log.error(Activator.getDefault(), 0,
								"Failed to examine content-types of file: "
										+ file.getFullPath(), e);
					} finally {
						if (contents != null) {
							try {
								contents.close();
							} catch (IOException e) {
								// no defense
								Log.error(Activator.getDefault(), 0,
										"Failed to close file input stream", e);
							}
						}
					}
				}
			}
		}

		action.setEnabled(selectedFile != null);
	}
	
	@Override
	public void setActivePart(IAction arg0, IWorkbenchPart targetPart) {
		part = targetPart;
		shell = (targetPart == null) ? null : targetPart.getSite().getShell();
	}

	@Override
	public boolean handleLoadResult(Resource arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postConvert(Collection<Resource> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preConvert(Collection<Resource> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean queryOverwrite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void raiseErrorDialog(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
}
