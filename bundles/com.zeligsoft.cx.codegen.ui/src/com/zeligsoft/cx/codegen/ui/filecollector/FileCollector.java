/**
 * Copyright 2021 Zeligsoft.
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
 *
 */

package com.zeligsoft.cx.codegen.ui.filecollector;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.util.NLS;

import com.google.common.collect.Sets;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;
import com.zeligsoft.cx.codegen.ui.preferences.CXCodegenUIPreferencesConstants;

/**
 * This class is intended to collect files added, changed, removed or unchanged
 * by transformations, code generators or other "big" operations that affect
 * resources.
 * 
 * The intended use of this class is as follows:
 * 
 * IProject project = ...; 
 * FileCollector fileCollector = new FileCollector();
 * fileCollector.setProject(project); 
 * fileCollector.begin();
 * 
 * //... some big operation changing resources here ...
 * 
 * fileCollector.end();
 * 
 * // Then obtain results using any of the getters:
 * Set<FileCollector.GeneratedFile> filesAdded() = fileCollector.getFileCollection().getFilesAdded();
 * Set<FileCollector.GeneratedFile> filesRemoved() = fileCollector.getFileCollection().getFilesRemoved(); 
 * // ...etc.
 * 
 * @author Ernesto Posse
 */
public class FileCollector {

	/**
	 * Wrapper class to IFile implementing the Comparable interface so that we can
	 * store them in Sets and sort them by path.
	 * 
	 * @author Ernesto Posse
	 */
	public class GeneratedFile implements Comparable<GeneratedFile> {
		private IFile file;

		public GeneratedFile(IFile file) {
			this.file = file;
		}

		public IFile getIFile() {
			return file;
		}

		public IPath getFullPath() {
			return file != null ? file.getFullPath() : null;
		}
		
		@Override
		public String toString() {
			if (file == null) {
				return "null"; //$NON-NLS-1$
			}
			return file.getFullPath().lastSegment();
		}

		@Override
		public boolean equals(Object other) {
			if (this != other)
				return false;
			if (!(other instanceof GeneratedFile))
				return false;
			GeneratedFile otherFile = (GeneratedFile) other;
			if (this.file == otherFile.file || this.file.getFullPath() == otherFile.file.getFullPath())
				return true;
			return false;
		}

		@Override
		public int hashCode() {
			if (file == null)
				return 0;
			String path = file.getFullPath().toPortableString();
			if (path == null)
				return 0;
			return path.hashCode();
		}

		@Override
		public int compareTo(GeneratedFile other) {
			if (other == null)
				throw new NullPointerException();
			if (file == null)
				return -1;
			if (other.getIFile() == null)
				return 1;
			if (getFullPath() == null)
				return -1;
			return getFullPath().toPortableString().compareTo(other.getFullPath().toPortableString());
		}
	}
	
	/**
	 * Instances of this class encapsulate the results of a file collection operation.
	 * 
	 * @author Ernesto Posse
	 */
	public class FileCollection {
		
		// Set of files before the transform is performed
		private Set<GeneratedFile> filesBefore;
		// Set of files after the transform is performed
		private Set<GeneratedFile> filesAfter;
		// Set of files unchanged by the transformation.
		private Set<GeneratedFile> filesUnchanged;
		// Set of files added by the transformation.
		private Set<GeneratedFile> filesAdded;
		// Set of files changed by the transformation.
		private Set<GeneratedFile> filesChanged;
		// Set of files removed by the transformation.
		private Set<GeneratedFile> filesRemoved;
		
		public FileCollection() {
			init();
		}
		
		private void init() {
			filesBefore = new TreeSet<GeneratedFile>();
			filesAfter = new TreeSet<GeneratedFile>();
			filesUnchanged = new TreeSet<GeneratedFile>();
			filesAdded = new TreeSet<GeneratedFile>();
			filesChanged = new TreeSet<GeneratedFile>();
			filesRemoved = new TreeSet<GeneratedFile>();
		}
		
		public Set<GeneratedFile> getFilesBefore() {
			return filesBefore;
		}
		
		public Set<GeneratedFile> getFilesAfter() {
			return filesAfter;
		}

		public Set<GeneratedFile> getFilesUnchanged() {
			return filesUnchanged;
		}
		
		public Set<GeneratedFile> getFilesAdded() {
			return filesAdded;
		}
		
		public Set<GeneratedFile> getFilesChanged() {
			return filesChanged;
		}
		
		public Set<GeneratedFile> getFilesRemoved() {
			return filesRemoved;
		}
		
	}
	
	public class FileCollectionException extends Exception {

		public FileCollectionException(String message) {
			super(message);
		}

		private static final long serialVersionUID = 1L;

	}

	// The project that defines the scope of this file collector.
	private IProject project;
	
	// The collection of files gathered by the file collector.
	private FileCollection fileCollection;

	private static final IEclipsePreferences ECLIPSE_PREFERENCES = InstanceScope.INSTANCE
			.getNode("org.eclipse.core.resources"); //$NON-NLS-1$

	private static final IEclipsePreferences WORKSPACE_PREFERENCES = InstanceScope.INSTANCE
			.getNode(CodeGenUIPlugin.PLUGIN_ID);

	// Attribute to save the value of this preference to restore it after the
	// transformation.
	private boolean autoRefreshPreference = false;

	private IResourceChangeListener listener;

	private boolean collecting = false;
	
	// Predicate to filter the files considered; only the files for which the predicate is true will be collected.
	// By default, all files are collected.
	private Predicate<IFile> filter = (file) -> true;

	/**
	 * Create a new file collector.
	 */
	public FileCollector() {
	}
	
	public void enableCollecting() {
		collecting = true;
	}
	
	public void disableCollecting() {
		collecting = false;
	}
	
	public boolean isCollectingEnabled() {
		return collecting;
	}
	
	/**
	 * Sets the project for the file collector.
	 * 
	 * @param project The project that defines the scope of this file collector.
	 */
	public void setProject(IProject project) {
		if (project != null) {
			this.project = project;
		} else {
			CodeGenUIPlugin.getDefault().error(Messages.FileCollector_NullProject, null);
		}
	}
	
	/**
	 * Resets the file collector's project to null.
	 */
	public void resetProject() {
		this.project = null;
	}
	
	public FileCollection getFileCollection() {
		return fileCollection;
	}
	
	public void setFilter(Predicate<IFile> filter) {
		this.filter = filter;
	}

	/**
	 * Refreshes the files for the given project.
	 * 
	 * @param project	An {@link IProject} The project to refresh
	 * @param monitor 	An {@link IProgressMonitor}. If null is provided, it will use a {@link NullProgressMonitor}
	 */
	public static void refreshWorkspace(IProject project, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			CodeGenUIPlugin.getDefault().info(NLS.bind(Messages.FileCollector_ProjectRefresh, project.getName()));
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		} catch (CoreException e) {
			CodeGenUIPlugin
				.getDefault()
				.error(
					Messages.FileCollector_ProjectRefreshFailed,
					e);
		} catch (NullPointerException e) {
			CodeGenUIPlugin
				.getDefault()
				.error(
					Messages.FileCollector_ProjectRefreshFailed_NullProject,
					e);
		}
	}
	
	public void refreshWorkspace() {
		refreshWorkspace(project, null);
	}

	/**
	 * Returns the set of files in the project.
	 * 
	 * @return Set<GeneratedFile>
	 */
	public Set<GeneratedFile> collectFiles() {
		Set<GeneratedFile> files = new TreeSet<GeneratedFile>();
		if (!isCollectingEnabled())
			return files;
		IResourceVisitor visitor = new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource != null && resource.getType() == IResource.FILE 
						&& filter.test((IFile) resource)) {
					files.add(new GeneratedFile((IFile) resource));
					return false;
				}
				return true;
			}
		};

		try {
			project.accept(visitor);
		} catch (CoreException e) {
			CodeGenUIPlugin.getDefault().error(Messages.FileCollector_CoreException, e);
		}
		return files;
	}

	/**
	 * Begin file collection. 
	 * 
	 * Initializes the variables for the sets of files to collect, collects the current set of 
	 * files in the project, enables the auto-refresh preference to be able to detect file changes
	 * resulting from non Eclipse resource-API operations, and sets up a resource listener.
	 * 
	 * @param refreshWorkspace	A {@code boolean} indicating whether the workspace should be
	 *                          refreshed before starting to collect files, to ensure that 
	 *                          external file changes before the operation are not treated as
	 *                          new file changes.
	 * @param autoRefresh	A {@code boolean} indicating whether to enable auto-refresh during
	 *                      file collection, to account for external changes.
	 * 
	 * @throws FileCollectionException if the project is null.
	 */
	public void begin(boolean refreshWorkspace, boolean autoRefresh) throws FileCollectionException {
		if (project == null) {
			FileCollectionException exception = new FileCollectionException(Messages.FileCollector_NullProject);
			CodeGenUIPlugin.getDefault().error(Messages.FileCollector_NullProject, exception);
			throw exception;
		}
		if (refreshWorkspace) {
			refreshWorkspace();
		}
		saveAutoRefreshPreference();
		if (autoRefresh) {
			enableAutoRefresh();
		} else {
			disableAutoRefresh();
		}
		enableCollecting();
		// We start with an empty file collection.
		fileCollection = new FileCollection();
		// We collect the files that exist now.
		fileCollection.getFilesBefore().addAll(collectFiles());
		// We initialize the set of unchanged files to the set of files before the transformation,
		// and the listener will modify it by removing files whenever changes are detected.
		fileCollection.getFilesUnchanged().addAll(Sets.newTreeSet(fileCollection.getFilesBefore()));
		// We create a resource listener to detect file additions, changes or removals.
		setupResourceListener();
	}
	
	/**
	 * Begin file collection. 
	 * 
	 * It is equivalent to {@code begin(true,false)}
	 * 
	 * @throws FileCollectionException if the project is null.
	 * 
	 * @see {@link #begin(boolean,boolean)}
	 */
	public void begin() throws FileCollectionException {
		begin(true, false);
	}

	/**
	 * Ends file collection. 
	 * 
	 * Collects files again (if enabled), stops collecting files, disables the resource listener 
	 * and restores the auto-refresh preference.
	 */
	public void end() {
		tearDownResourceListener();
		if (WORKSPACE_PREFERENCES.getBoolean(CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_AFTER,
				CXCodegenUIPreferencesConstants.FILE_COLLECTOR_FILES_AFTER_DEFAULT)) {
			fileCollection.getFilesAfter().addAll(collectFiles());
		}
		disableCollecting();
		restoreAutoRefreshPreference();
	}

	private void saveAutoRefreshPreference() {
		autoRefreshPreference = ECLIPSE_PREFERENCES.getBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, false);
		CodeGenUIPlugin.getDefault().info(NLS.bind(Messages.FileCollector_SavingAutoRefreshPreference, autoRefreshPreference));
	}

	private void restoreAutoRefreshPreference() {
		CodeGenUIPlugin.getDefault().info(NLS.bind(Messages.FileCollector_RestoringAutoRefreshPreference, autoRefreshPreference));
		ECLIPSE_PREFERENCES.putBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, autoRefreshPreference);
	}

	/**
	 * Enables auto-refresh to account for external file updates, i.e. resource updates done
	 * externally or by means other than using Eclipse resource-changing APIs. 
	 */
	private void enableAutoRefresh() {
		CodeGenUIPlugin.getDefault().info(Messages.FileCollector_EnablingAutoRefresh);
		ECLIPSE_PREFERENCES.putBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, true);
	}
	
	/**
	 * Disables auto-refresh to avoid considering external file updates, i.e. resource updates done
	 * externally or by means other than using Eclipse resource-changing APIs. 
	 */
	private void disableAutoRefresh() {
		CodeGenUIPlugin.getDefault().info(Messages.FileCollector_DisablingAutoRefresh);
		ECLIPSE_PREFERENCES.putBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, false);
	}

	private void setupResourceListener() {
		if (!isCollectingEnabled())
			return;
		class FileChangeDeltaVisitor implements IResourceDeltaVisitor {

			private Set<GeneratedFile> files;
			private Set<GeneratedFile> added = new TreeSet<GeneratedFile>();
			private Set<GeneratedFile> changed = new TreeSet<GeneratedFile>();
			private Set<GeneratedFile> removed = new TreeSet<GeneratedFile>();

			public Set<GeneratedFile> getAdded() {
				return added;
			}

			public Set<GeneratedFile> getChanged() {
				return changed;
			}

			public Set<GeneratedFile> getRemoved() {
				return removed;
			}

			public FileChangeDeltaVisitor(Set<GeneratedFile> files) {
				this.files = files;
			}

			@Override
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (!isCollectingEnabled())
					return false;
				IResource resource = delta.getResource();
				if (resource != null && resource.getProject() == project 
						&& resource.getType() == IResource.FILE && filter.test((IFile) resource)) {
					// If the resource is part of the delta, it is either added, changed or removed
					// so we remove it from the resources list so that only untouched resources
					// remain there.
					files.remove(new GeneratedFile((IFile) resource));
					// Depending on the kind of change, we add it to the relevant set.
					switch (delta.getKind()) {
					case IResourceDelta.ADDED:
						added.add(new GeneratedFile((IFile) resource));
						break;
					case IResourceDelta.CHANGED:
						changed.add(new GeneratedFile((IFile) resource));
						break;
					case IResourceDelta.REMOVED:
						removed.add(new GeneratedFile((IFile) resource));
						break;
					default:
						break;
					}
					return false;
				}
				return true;
			}
		}
		class CollectingFileChangeListener implements IResourceChangeListener {
			private Set<GeneratedFile> files;

			public CollectingFileChangeListener(Set<GeneratedFile> files) {
				this.files = files;
			}

			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				if (!isCollectingEnabled())
					return;
				IResourceDelta delta = event.getDelta();
				FileChangeDeltaVisitor visitor = new FileChangeDeltaVisitor(files);
				try {
					delta.accept(visitor);
					getFileCollection().getFilesAdded().addAll(visitor.getAdded());
					getFileCollection().getFilesChanged().addAll(visitor.getChanged());
					getFileCollection().getFilesRemoved().addAll(visitor.getRemoved());
				} catch (CoreException e) {
					CodeGenUIPlugin.getDefault().error(Messages.FileCollector_ResourceListener_CoreException, e);
				}
			}
		}
		listener = new CollectingFileChangeListener(fileCollection.getFilesUnchanged());
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(listener);
	}

	private void tearDownResourceListener() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(listener);
	}

}
