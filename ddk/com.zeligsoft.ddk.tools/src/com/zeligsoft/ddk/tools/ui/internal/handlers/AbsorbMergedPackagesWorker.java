/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.ddk.tools.ui.internal.handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Worker class that performs the merging of MergePackage elements into the referencing model.
 * This calls is separate from the core command handler/action handler to enable reuse in a
 * variety of Eclipse menu/command environments that have existed of the past decade.
 *
 */
public class AbsorbMergedPackagesWorker {
	
	/**
	 * Exception thrown if selection is not conform to expectations
	 *
	 */
	private static class IllegalSelectionException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public IllegalSelectionException(String message) {
			super(message + " " + Messages.AbsorbMergedPackagesWorker_SelectionRequirements); //$NON-NLS-1$
		}
		
	}
	
	/**
	 * Exception thrown if there is nothing to merge.
	 */
	private static class NoPackageMergeElementsException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public NoPackageMergeElementsException(String message) {
			super(message);
		}
		
	}
	
	private final ISelection selection;

	public AbsorbMergedPackagesWorker(final ISelection selection) {
		this.selection = selection;
		
	}

	private void raiseCoreExceptionError(Throwable ex) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, com.zeligsoft.ddk.tools.Activator.PLUGIN_ID,
				ex.getMessage(), ex));
	}
	
	private void raiseCoreExceptionWarning(Throwable ex) throws CoreException {
		throw new CoreException(new Status(IStatus.WARNING, com.zeligsoft.ddk.tools.Activator.PLUGIN_ID,
				ex.getMessage(), ex));
	}
	
	public IPath doWork() throws CoreException {
		try {
			// sanity check the exception. The menu configuration should prevent most of these, but...
			if(!(selection instanceof IStructuredSelection)) {
				throw new IllegalSelectionException(Messages.AbsorbMergedPackagesWorker_NotIStructureSelection);
			}
			final IStructuredSelection ss = (IStructuredSelection)selection;
			if(ss.size() != 1) {
				throw new IllegalSelectionException(Messages.AbsorbMergedPackagesWorker_NotSize1Selection);
			}
			
			final Object sel = ss.getFirstElement();
			if(!(sel instanceof IFile)) {
				throw new IllegalSelectionException(Messages.AbsorbMergedPackagesWorker_SelectionNotAFile);
			}
			final IFile file = (IFile)sel;
			if(!(file.getFileExtension().equals("uml"))) { //$NON-NLS-1$
				throw new IllegalSelectionException(Messages.AbsorbMergedPackagesWorker_SelectionNotUmlFile);
			}
			
			// derive the new file from the existing files name.
			final IFile newFile = file.getParent().getFile(new Path(file.getName().replace(".uml", ".merged.uml"))); //$NON-NLS-1$ //$NON-NLS-2$
			
			// load the existing model
			final ResourceSet rset = new ResourceSetImpl();
			final URI fileURI = URI.createURI("platform:/resource/" + file.getFullPath().toString()); //$NON-NLS-1$
			Resource res = rset.getResource(fileURI, true);
			final EObject rootObj = res.getContents().get(0);
			if(!(rootObj instanceof org.eclipse.uml2.uml.Package)) {
				throw new IllegalSelectionException(Messages.AbsorbMergedPackagesWorker_RootElementNotPackage);
			}
			
			// merge any/all PackageMerge Elements
			final org.eclipse.uml2.uml.Package rootPkg = (org.eclipse.uml2.uml.Package)rootObj;
			Map<String, String> options = new HashMap<>();
			final Map<EObject, List<EObject>> merges = UMLUtil.merge(rootPkg, options);
			
			if(merges.size() == 0) {
				throw new NoPackageMergeElementsException(Messages.AbsorbMergedPackagesWorker_NoPackageMergesFound);
			}
		
			// save the modified model to the new path
			res.setURI(URI.createURI("platform:/resource/" + newFile.getFullPath().toString())); //$NON-NLS-1$
			
			res.save(null);
			return newFile.getFullPath();
			
		} catch (IOException e) {
			raiseCoreExceptionError(e);
		} catch (NoPackageMergeElementsException e) {
			raiseCoreExceptionWarning(e);
		} catch (IllegalSelectionException e) {
			raiseCoreExceptionError(e);
		}
		return null;
	}
}
