/*******************************************************************************
 * Copyright (c) 2017,2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.XtextNature
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.builder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.ui.BaseUIActivator;
import org.eclipse.ocl.xtext.base.ui.builder.AbstractValidatingBuilder.BuildType;

/**
 * An AbstractBuildSelector performs the selection of files to be built from within a project.
 * Selection is based on inclusion/exclusion of file-extensions/file-paths.
 */
public abstract class AbstractBuildSelector implements IResourceVisitor, IResourceDeltaVisitor
{
	protected final @NonNull IProject project;
	protected final @NonNull BuildType buildType;
	private final @NonNull IProgressMonitor monitor;
	private final @NonNull Map<@NonNull String, @Nullable Boolean> extension2included = new HashMap<>();
	private final char[][] exclusionPatterns;
	private final char[][] inclusionPatterns;

	private final @NonNull Set<@NonNull IFile> removedFiles = new HashSet<>();
	private final @NonNull Set<@NonNull ValidationEntry> selectedEntries = new HashSet<>();

	protected AbstractBuildSelector(@NonNull IProject project, @NonNull BuildType buildType, @Nullable Map<String, String> args, @NonNull IProgressMonitor monitor) {
		this.project = project;
		this.buildType = buildType;
		this.monitor = monitor;
		String[] disabledPathArray = null;
		String[] enabledPathArray = null;
		if (args != null) {
			String includedExtensions = args.get("enabledExtensions");
			if (includedExtensions != null) {
				for (@NonNull String includedExtension : includedExtensions.split(",")) {
					@SuppressWarnings("unused") Boolean oldIncludes = extension2included.put(includedExtension, Boolean.TRUE);
					// assert oldIncludes != null; double true is not an issue
				}
			}
			String excludedExtensions = args.get("disabledExtensions");
			if (excludedExtensions != null) {
				for (@NonNull String excludedExtension : excludedExtensions.split(",")) {
					@SuppressWarnings("unused") Boolean oldExcludes = extension2included.put(excludedExtension, Boolean.FALSE);
					// assert oldExcludes != null; double false / conflicting false is not really an issue
				}
			}
			String enabledPaths = args.get("enabledPaths");
			if (enabledPaths != null) {
				enabledPathArray = enabledPaths.split(",");
			}
			String disabledPaths = args.get("disabledPaths");
			if (disabledPaths != null) {
				disabledPathArray = disabledPaths.split(",");
			}
		}
		if (enabledPathArray != null) {
			inclusionPatterns = new char[enabledPathArray.length][];
			for (int i = 0; i < enabledPathArray.length; i++) {
				String enabledPath = enabledPathArray[i];
				inclusionPatterns[i] = (enabledPath.length() > 0 ? enabledPath : "**").toCharArray();
			}
		}
		else {
			inclusionPatterns = null;
		}
		if (disabledPathArray != null) {
			exclusionPatterns = new char[disabledPathArray.length][];
			for (int i = 0; i < disabledPathArray.length; i++) {
				String disabledPath = disabledPathArray[i];
				exclusionPatterns[i] = (disabledPath.length() > 0 ? disabledPath : "**").toCharArray();
			}
		}
		else {
			exclusionPatterns = null;
		}
	}

	public void buildResources() {
		MultiValidationJob multiValidationJob = BaseUIActivator.getMultiValidationJob();
		if (multiValidationJob != null) {
			multiValidationJob.addValidations(selectedEntries);
		}
	}

	protected @NonNull ValidationEntry createValidationEntry(@NonNull IFile iFile) {
		return new ValidationEntry(iFile, getMarkerId(iFile));
	}

	/**
	 * Return the appropriate Problem Marked Id for the results of validating iFile.
	 * Defaults to "org.eclipse.emf.ecore.diagnostic". Subclasses should override.
	 */
	protected @NonNull String getMarkerId(@NonNull IFile iFile) {
		return EValidator.MARKER;
	}

	public @Nullable Boolean isSelected(@NonNull IResource resource) {
		if (resource instanceof IFile) {
			String fileExtension = resource.getFileExtension();
			if (extension2included.get(fileExtension) != Boolean.TRUE) {
				return Boolean.FALSE;
			}
			String filePath = resource.getProjectRelativePath().toString();
			char[] path = filePath.toCharArray();
			boolean isExcluded = AbstractValidatingBuilder.isExcluded(path, inclusionPatterns, exclusionPatterns, false);
			//				System.out.println(filePath + " isExcluded " + isExcluded);
			return isExcluded ? Boolean.FALSE : Boolean.TRUE;
		}
		else if (resource instanceof IFolder) {
			// FIXME BUG 544734 this match doesn't work for non-trivial folder paths
		//	String filePath = resource.getProjectRelativePath().toString();
		//	char[] path = filePath.toCharArray();
		//	boolean isExcluded = AbstractValidatingBuilder.isExcluded(path, inclusionPatterns, exclusionPatterns, true);
			//				System.out.println(filePath + " isExcluded " + isExcluded);
			return /*isExcluded ? Boolean.FALSE :*/ null;
		}
		else {
			return null;
		}
	}

	public int selectResources(@Nullable IResourceDelta delta) throws CoreException {
		//			progress.subTask(selectingResourcesMessage);
		if (delta == null) {			// full
			project.accept(this, IResource.DEPTH_INFINITE, IResource.NONE);
		}
		else {							// auto / incremental
			delta.accept(this);
		}
		return selectedEntries.size();
	}

	@Override
	public boolean visit(IResource resource) throws CoreException {
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		assert resource != null;
		//			System.out.println(NameUtil.debugSimpleName(this) + " visit " + resource);
		Boolean isSelected = isSelected(resource);
		if (isSelected == Boolean.TRUE) {
			IFile iFile = (IFile) resource;
			selectedEntries.add(createValidationEntry(iFile));
			return true;
		}
		else if (isSelected == null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		IResource resource = delta.getResource();
		if (resource instanceof IProject) {
			return (resource == project) && project.isOpen();
		}
		if (resource instanceof IContainer) {
			return true;
		}
		if (resource instanceof IStorage) {
			if (delta.getKind() == IResourceDelta.REMOVED) {
				//					System.out.println(NameUtil.debugSimpleName(this) + " remove " + resource);
				Boolean isSelected = isSelected(resource);
				if (isSelected == Boolean.TRUE) {
				//	IPath fullPath = ((IFile) resource).getFullPath();
				//	assert fullPath != null;
					removedFiles.add((IFile) resource);
					return true;
				}
				else if (isSelected == null) {
					return true;
				}
				else {
					return false;
				}
			} else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
				//					System.out.println(NameUtil.debugSimpleName(this) + " update " + resource);
				Boolean isSelected = isSelected(resource);
				if (isSelected == Boolean.TRUE) {
					IFile iFile = (IFile) resource;
					selectedEntries.add(createValidationEntry(iFile));
					return true;
				}
				else if (isSelected == null) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}

	public void deleteMarkers() {
		for (@NonNull ValidationEntry entry : selectedEntries) {
			try {
				entry.deleteMarkers();
			} catch (CoreException e) {
				// e.printStackTrace();  -- if deleteMarkers fails we probably don't want extra noise
			}
		}
	}

	protected int deleteRemovedResourceMarkers() {
		for (@NonNull IFile removedFile : removedFiles) {
			try {
				String markerId = getMarkerId(removedFile);
			//	if (AbstractValidatingBuilder.BUILDER.isActive()) {
			//		AbstractValidatingBuilder.BUILDER.println("Remove \"" + markerId + "\" markers from \"" + removedFile.getFullPath() + "\"");
			//	}
				removedFile.deleteMarkers(markerId, true, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
			//	e.printStackTrace();
			}
		}
		return removedFiles.size();
	}
}