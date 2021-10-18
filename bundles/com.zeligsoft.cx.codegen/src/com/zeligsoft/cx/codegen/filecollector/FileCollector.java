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

package com.zeligsoft.cx.codegen.filecollector;

import java.util.Set;
import java.util.TreeSet;

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
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.util.NLS;

import com.google.common.collect.Sets;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.filecollector.FileCollector.GeneratedFile;
import com.zeligsoft.cx.codegen.l10n.Messages;


/**
 * This class is intended to collect files added, changed, removed or unchanged by
 * transformations, code generators or other "big" operations that affect resources.
 * 
 * The intended use of this class is as follows:
 * 
 * IProject project = ...;
 * FileCollector fileCollector = new FileCollector(project);
 * fileCollector.begin();
 * 
 * //... some big operation changing resources here ...
 * 
 * fileCollector.end();
 * 
 * // Then report the results to the console ...
 * fileCollector.report();
 * 
 * //... or obtain results using any of the getters:
 * Set<FileCollector.GeneratedFile> filesAdded = fileCollector.getFilesAdded();
 * Set<FileCollector.GeneratedFile> filesAdded = fileCollector.getFilesRemoved();
 * // ...etc.
 * 
 * @author Ernesto Posse
 */
public class FileCollector {
	
	// Wrapper class to IFile implementing the Comparable interface 
	// so that we can store them in Sets and sort them by path.
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
	
	// The project that defines the scope of this file collector.
	private IProject project;
	
	// Set of files before the transform is performed
	private Set<GeneratedFile> filesBefore;
	// Set of files after the transform is performed 
	private Set<GeneratedFile> filesAfter;
	// Set of files unchanged by the transformation.
	private Set<GeneratedFile> unchangedFiles;
	// Set of files added by the transformation.
	private Set<GeneratedFile> filesAdded;
	// Set of files changed by the transformation.
	private Set<GeneratedFile> filesChanged;
	// Set of files removed by the transformation.
	private Set<GeneratedFile> filesRemoved;

	private IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode("org.eclipse.core.resources"); //$NON-NLS-1$

	// Attribute to save the value of this preference to restore it after the transformation.
	private boolean autoRefreshPreference = false;

	private IResourceChangeListener listener;
	
	private boolean collecting = false;

	/**
	 * Create a new file collector for the given project.
	 * 
	 * @param project	The project that defines the scope of this file collector.
	 */
	public FileCollector(IProject project) {
		if (project != null) {
			this.project = project;
		} else {
			CodeGenPlugin.getDefault().error(Messages.FileCollector_NullProject, null);
		}
	}

	public Set<GeneratedFile> getFilesBefore() {
		return filesBefore;
	}

	public Set<GeneratedFile> getFilesAfter() {
		return filesAfter;
	}

	public Set<GeneratedFile> getUnchangedFiles() {
		return unchangedFiles;
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

	public Set<GeneratedFile> collectFiles() {
		Set<GeneratedFile> files = new TreeSet<GeneratedFile>();
		if (!collecting) 
			return files;
		IResourceVisitor visitor = new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource != null && resource.getType() == IResource.FILE) {
					files.add(new GeneratedFile((IFile) resource));
					return false;
				}
				return true;
			}
		};
		
		try {
			project.accept(visitor);
		} catch (CoreException e) {
			CodeGenPlugin.getDefault().error(Messages.FileCollector_CoreException, e);
		}
		return files;
	}
	
	public void begin() {
		saveAutoRefreshPreference();
		enableAutoRefresh();
		collecting = true;
		filesAfter = new TreeSet<GeneratedFile>();
		filesAdded = new TreeSet<GeneratedFile>();
		filesChanged = new TreeSet<GeneratedFile>();
		filesRemoved = new TreeSet<GeneratedFile>();
		filesBefore = collectFiles();
		// We initialize the unchangedFiles to the set of files before the transformation,
		// and the listener will modify it by removing files whenever changes are detected.
		unchangedFiles = Sets.newTreeSet(filesBefore);
		setupResourceListener();
	}
	
	public void end() {
		collecting = false;
		tearDownResourceListener();
		restoreAutoRefreshPreference();
	}

	private void saveAutoRefreshPreference() {
		autoRefreshPreference = prefs.getBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, false);
	}
	
	private void restoreAutoRefreshPreference() {
		prefs.putBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, autoRefreshPreference);
	}
	
	private void enableAutoRefresh() {
		// We need to enable the auto-refresh preference so that the resource listener can
		// detect changes made outside of Eclipse or by non-Eclipse resource changing APIs.
		// Normally generators invoked by a workflow should only use Eclipse resource-changing APIs,
		// but we cannot guarrantee that.
		prefs.putBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, true);
	}

	private void setupResourceListener() {
		if (!collecting)
			return;
		class FileChangeDeltaVisitor implements IResourceDeltaVisitor {
			
			private Set<GeneratedFile> files;
			private Set<GeneratedFile> added = new TreeSet<GeneratedFile>();
			private Set<GeneratedFile> changed = new TreeSet<GeneratedFile>();
			private Set<GeneratedFile> removed = new TreeSet<GeneratedFile>();
			
			public Set<GeneratedFile> getAdded() { return added; }
			public Set<GeneratedFile> getChanged() { return changed; }
			public Set<GeneratedFile> getRemoved() { return removed; }
			
			public FileChangeDeltaVisitor(Set<GeneratedFile> files) {
				this.files = files;
			}
			@Override
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (!collecting) 
					return false;
				IResource resource = delta.getResource();
				if (resource != null && (resource.getType() == IResource.FILE)) {
					// If the resource is part of the delta, it is either added, changed or removed
					// so we remove it from the resources list so that only untouched resources
					// remain there.
					files.remove(new GeneratedFile((IFile) resource));
					// Depending on the kind of change, we add it to the relevant set.
					switch (delta.getKind()) {
					case IResourceDelta.ADDED:
						System.out.println("ADDED:   " + resource.getFullPath().toOSString());
						added.add(new GeneratedFile((IFile) resource));
						break;
					case IResourceDelta.CHANGED:
						System.out.println("CHANGED: " + resource.getFullPath().toOSString());
						changed.add(new GeneratedFile((IFile) resource));
						break;
					case IResourceDelta.REMOVED:
						System.out.println("REMOVED: " + resource.getFullPath().toOSString());
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
		class GeneratorUpdatesDetector implements IResourceChangeListener {
			private Set<GeneratedFile> files;
			public GeneratorUpdatesDetector(Set<GeneratedFile> files) {
				this.files = files;
			}
			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				if (!collecting)
					return;
				IResourceDelta delta = event.getDelta();
				FileChangeDeltaVisitor visitor = new FileChangeDeltaVisitor(files);
				try {
					delta.accept(visitor);
					getFilesAdded().addAll(visitor.getAdded());
					getFilesChanged().addAll(visitor.getChanged());
					getFilesRemoved().addAll(visitor.getRemoved());
				} catch (CoreException e) {
					CodeGenPlugin.getDefault().error(Messages.FileCollector_ResourceListener_CoreException, e);
				}
			}
		}
		listener = new GeneratorUpdatesDetector(unchangedFiles);
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(listener);
	}

	private void tearDownResourceListener() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(listener);
	}

	public void report() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(NLS.bind(Messages.FileCollector_FilesUpdatedTitleMessage, project.getName()));
		buffer.append(Messages.FileCollector_SeparatorLine);
		if (collecting) {
			buffer.append(NLS.bind(Messages.FileCollector_Warning_StillCollecting, project.getName()));
			buffer.append(System.lineSeparator());
		}
		writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesBeforeTitleMessage, project.getName()), filesBefore);
		writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesAfterTitleMessage, project.getName()), filesAfter);
		writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesAddedTitleMessage, project.getName()), filesAdded);
		writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesChangedTitleMessage, project.getName()), filesChanged);
		writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesRemovedTitleMessage, project.getName()), filesRemoved);
		writeFileList(buffer, NLS.bind(Messages.FileCollector_FilesUnchangedTitleMessage, project.getName()), unchangedFiles);
		BaseUIUtil.writeToConsole(buffer.toString());
	}

	private void writeFileList(StringBuffer buffer, String title, Set<GeneratedFile> files) {
		buffer.append(title);
		buffer.append(System.lineSeparator());
		for (GeneratedFile file : files) {
			buffer.append(file.getFullPath().toOSString());
			buffer.append(System.lineSeparator());
		}
		buffer.append(System.lineSeparator());
	}

}
