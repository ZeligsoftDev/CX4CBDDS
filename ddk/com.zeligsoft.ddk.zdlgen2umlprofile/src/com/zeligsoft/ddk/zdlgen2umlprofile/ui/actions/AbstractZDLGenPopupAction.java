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
package com.zeligsoft.ddk.zdlgen2umlprofile.ui.actions;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.codegen.ICodegenAction;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages;

/**
 * An abstraction to be used for ZDLGen actions
 * that are part of the ZDLGen editor
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public abstract class AbstractZDLGenPopupAction {

	public AbstractZDLGenPopupAction() {
		super();
	}

	/**
	 * Checks that the model being imported does not have external cross
	 * references to any resource that
	 * <ul>
	 * <li>is an EMX file</li>
	 * <li>is not a pathmap:// URI</li>
	 * </ul>
	 * Any problems found are reported to the user in a dialog, and generation
	 * does not proceed.
	 * 
	 * @param domain the domain specialization to check
	 * 
	 * @return whether the external cross-references are OK
	 */
	protected boolean validateExternalCrossReferences(GenDomainSpecialization domain) {
		
		final Resource zdlResource = domain.getDomainSpecialization()
			.eResource();
		
		// find all referenced (directly or not) packages to check them for
		// bad HREFs, because all of the referenced ZDLs will constribute to
		// the profile we are generating
		Set<Package> packages = new java.util.HashSet<Package>();
		for (GenDomainBlockReference next : domain.getDomainBlocks()) {
			if (next.getTarget() != null) {
				getPackageClosure(packages, next.getTarget());
			}
		}
		for (GenDomainModelLibraryReference next : domain
			.getDomainModelLibraries()) {
			if (next.getTarget() != null) {
				getPackageClosure(packages, next.getTarget());
			}
		}
	
		@SuppressWarnings("serial")
		IStatus status = new EcoreUtil.ExternalCrossReferencer(packages) {
	
			private Map<Resource, IStatus> messages = new java.util.HashMap<Resource, IStatus>();
	
			IStatus go() {
				findExternalCrossReferences();
	
				Collection<IStatus> results = messages.values();
				return results.isEmpty()
					? Status.OK_STATUS
					: new MultiStatus(Activator.PLUGIN_ID, 0, results
						.toArray(new IStatus[results.size()]),
						ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_0,
						null);
			}
	
			@Override
			protected void add(InternalEObject object, EReference reference,
					EObject crossReferencedEObject) {
	
				Resource res = crossReferencedEObject.eResource();
				
				// the ZDL resource that we are generating from is, of course,
				// a platform:/resource URI
				if ((res != null) && (res != zdlResource)) {
					URI uri = res.getURI();
	
					if ("emx".equalsIgnoreCase(uri.fileExtension())) { //$NON-NLS-1$
						if (!messages.containsKey(res)) {
							messages
								.put(
									res,
									new Status(
										IStatus.ERROR,
										Activator.PLUGIN_ID,
										ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_1
											+ uri));
						}
					} else if (!"pathmap".equals(uri.scheme())) { //$NON-NLS-1$
						if (!messages.containsKey(res)) {
							messages
								.put(
									res,
									new Status(
										IStatus.ERROR,
										Activator.PLUGIN_ID,
										NLS
											.bind(
												ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_2,
												uri)));
						}
					}
				}
			}
		}.go();
	
		if (!status.isOK()) {
			ErrorDialog
				.openError(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell(),
					ZDLGen2UMLProfileMessages.GenerateProfilePopupAction_errorDlgTitle,
					status.getMessage(), status);
			return false;
		}
	
		return true;
	}

	private void getPackageClosure(Set<Package> packages, GenDomainPackageableElement genPackage) {
		if (genPackage instanceof GenDomainModelLibrary) {
			packages.add(((GenDomainModelLibrary) genPackage)
				.getDomainModelLibrary());
		} else {
			GenDomainBlock block = (GenDomainBlock) genPackage;
			Package domainBlock = block.getDomainBlock();
	
			if ((domainBlock != null) && !packages.contains(domainBlock)) {
				packages.add(domainBlock);
	
				for (GenDomainBlockRelation next : block.getRelations()) {
					if (next.getTarget() != null) {
						getPackageClosure(packages, next.getTarget());
					}
				}
			}
		}
	}

	protected void ensurePath(URI uri) throws CoreException {
		if (!uri.isPlatformResource()) {
			throw new IllegalArgumentException("Not a platform:/resource URI: " + uri); //$NON-NLS-1$
		}
		
		String[] segments = uri.segments();
		int end = segments.length - 1;
		ResourcesPlugin.getWorkspace().getRoot();
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(segments[1]);
		if (!project.exists()) {
			project.create(null);
			project.open(null);
		}
		
		IContainer container = project;
		
		for (int i = 2; i < end; i++) {
			IFolder folder = container.getFolder(new Path(URI.decode(segments[i])));
			
			if (!folder.exists()) {
				folder.create(true, true, null);
			}
				
			container = folder;
		}
	}

	protected IFile getFile(URI uri) {
		// strip the "resource" segment from the path
		IPath path = new Path(URI.decode(uri.path())).removeFirstSegments(1);
		
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}

	protected void openEditor(IWorkbenchPage page, IFile file) {
		if(null == page) {
			throw new IllegalArgumentException("The page (IWorkbenchPage) parameter can not be null."); //$NON-NLS-1$
		}
		
		if(null == file) {
			throw new IllegalArgumentException("The file (IFile) parameter can not be null."); //$NON-NLS-1$
		}
		
		IEditorRegistry reg = page.getWorkbenchWindow().getWorkbench()
			.getEditorRegistry();
		
		IEditorDescriptor defaultEditor = reg.getDefaultEditor(file.getName());
		if(null != defaultEditor) {
			String editorID = defaultEditor.getId();
			try {
				page.openEditor(new FileEditorInput(file), editorID);
			} catch (PartInitException e) {
				Log.error(Activator.getDefault(), 0,
						"Exception opening editor with id " +  //$NON-NLS-1$
							editorID + 
							", for file " + file.getName(), e); //$NON-NLS-1$
			}
		} else {
			Log.info(Activator.getDefault(), 0, 
					"Could not find a defaul editor for file: "  //$NON-NLS-1$
						+ file.getName());
		}
	}

	/**
	 * @param context
	 * @return
	 */
	protected Shell getShell(Map<Object, Object> context) {
		Object shellObj = context.get(ICodegenAction.SHELL);
		Shell theShell = null;
		if(shellObj != null && shellObj instanceof Shell) {
			theShell = (Shell) shellObj;
		}
		return theShell;
	}

	protected IWorkbenchPart getActivePart(Map<Object, Object> context) {
		Object obj = context.get(ICodegenAction.ACTIVE_PART);
		IWorkbenchPart part = null;
		if(obj != null && obj instanceof IWorkbenchPart) {
			part = (IWorkbenchPart) obj;
		}
		return part;
	}

}