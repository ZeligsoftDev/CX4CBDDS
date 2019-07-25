/**
 * Copyright 2018 ADLINK Technology Limited.
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
package com.zeligsoft.base.zdl.oaw;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.zeligsoft.base.util.ZeligsoftURIConverter;
import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.l10n.Messages;

/**
 * A one-stop-shopping for ZDL models in the workspace and in the JDT classpath.
 * The ZDL metamodel manager keeps tabs on changes in the workspace, maintaining
 * an up-to-date mapping of ZDL models. It also finds (and caches) ZDL models in
 * binary plug-ins in the target platform.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLMetamodelManager {
	/** File extension (with dot) to use as primary filter for ZDL models. */
	private static final String UML_FILE_EXTENSION = "." + UMLResource.FILE_EXTENSION; //$NON-NLS-1$
	
	/** Job-family token for the jobs that update the workspace ZDL model store. */
	private static final Object ZDL_JOB_FAMILY = new Object();

	/**
	 * The singleton instance of the ZDL metamodel manager.
	 */
	public static ZDLMetamodelManager INSTANCE = new ZDLMetamodelManager();

	/**
	 * Mapping of ZDL models found in the workspace, by file. These can change
	 * over the duration of an Eclipse session.
	 */
	private Map<IFile, Model> workspaceModels = new java.util.concurrent.ConcurrentHashMap<IFile, Model>();

	/**
	 * Mapping of static ZDL models found in deployed plug-ins, mapped by path
	 * to the plug-in JAR. These are assumed not to change over the duration of
	 * an Eclipse session (the mapping is not updated except to add new finds).
	 */
	private Map<IPath, Set<Model>> deployedModels = new java.util.HashMap<IPath, Set<Model>>();

	/**
	 * The resource set in which we load the ZDL models.
	 */
	private ResourceSet zdlResources = new ResourceSetImpl();

	/** The currently-pending work item. */
	private WorkItem pending;

	/** Queue of workspace ZDL searches to be processed by jobs. */
	private Queue<WorkItem> workItems = new ConcurrentLinkedQueue<WorkItem>();

	/** Patern used to extract a plug-in ID from its versioned JAR file name. */
	private Pattern pluginJarPattern = Pattern.compile("([^_]+)_.*\\.jar"); //$NON-NLS-1$
	
	/**
	 * Not instantiable by clients.
	 */
	private ZDLMetamodelManager() {
		super();

		ZeligsoftURIConverter.install(zdlResources);
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(new ZDLResourceChangeListener());

		find(workspace.getRoot());
	}

	/**
	 * Obtains a mapping of files to ZDL models across the entire workspace. If
	 * the finder-job is currently updating the ZDL mapping, then this method
	 * will wait for it to finish before returning the mapping.
	 * 
	 * @return the current ZDL model mapping
	 * @throws ZDLsNotAvailableException
	 *             on any problem in waiting for the ZDL finder job to finish
	 */
	public Map<IFile, Model> getWorkspaceZDLModels()
			throws ZDLsNotAvailableException {

		if (isPending()) {
			// wait for the job, unless we have some scheduling rule that
			// could result in a deadlock
			Job current = Job.getJobManager().currentJob();
			
			if ((current == null) || (current.getRule() == null)) {
				try {
					Job.getJobManager().join(ZDL_JOB_FAMILY, null);
				} catch (InterruptedException e) {
					throw new ZDLsNotAvailableException(
						Messages.ZDLMetamodelManager_interrupt, e);
				}
			} else if ((pending.rule() != null)
				&& (current.getRule().isConflicting(pending.rule()))) {
				
				// OK, so we have a rule, which means that probably the ZDL job
				// is waiting for us to relinquish it. Let's do the work on its
				// behalf, then
				pending.perform(new NullProgressMonitor());
			}
		}

		return workspaceModels;
	}

	/**
	 * Obtains the mapping of deployed ZDL models, by path to the plug-in JAR
	 * that contains zero or more ZDLs. Thus, the absences of ZDLs in a plug-in
	 * is cached for performance.
	 * 
	 * @return the mapping of deployed ZDL models
	 */
	public Map<IPath, Set<Model>> getDeployedZDLModels() {
		return deployedModels;
	}

	/**
	 * Obtains the ZDL model at the specified URI, if it is a ZDL model.
	 * 
	 * @param uri
	 *            a URI
	 * @return the ZDL model at that URI, or <code>null</code> if the URI does
	 *         not resolve to a ZDL model
	 */
	public Model getZDLModel(URI uri) {
		Model result = null;
		Resource res = zdlResources.getResource(uri, true);
		// TODO: Revisit with EMF content types

		if ((res != null) && res.isLoaded()) {
			Model model = (Model) EcoreUtil.getObjectByType(res.getContents(),
				UMLPackage.Literals.MODEL);

			if ((model != null)
				&& ZDLMetamodel.isStereotypedAs(model,
					ZDLMetamodel.DOMAIN_MODEL)) {

				result = model;
			} else {
				// not a ZDL model; unload the resource
				res.unload();
				zdlResources.getResources().remove(res);
			}
		}

		return result;
	}

	/**
	 * Queries the (cached) set of ZDL models deployed in the plug-in at the
	 * specified path.
	 * 
	 * @param jarPath
	 *            the path to the plug-in JAR
	 * @return the ZDL models deployed in it, which could be (usually is) an
	 *         empty set
	 */
	public Set<Model> getDeployedZDLModels(IPath jarPath) {
		Set<Model> result = getDeployedZDLModels().get(jarPath);

		if (result != null) {
			return result;
		}

		// cache the result now
		result = new java.util.HashSet<Model>();
		getDeployedZDLModels().put(jarPath, result);

		ZipFile zipFile;
		try {
			zipFile = new ZipFile(jarPath.toOSString());
		} catch (IOException e) {
			Activator.getDefault().error(
				NLS.bind(Messages.ZDLMetamodelManager_openJar, jarPath), e);
			return result;
		}

		try {
			for (Enumeration<? extends ZipEntry> entries = zipFile.entries(); entries
				.hasMoreElements();) {
				ZipEntry entry = entries.nextElement();

				if (entry.getName().endsWith(UML_FILE_EXTENSION)) {
					Matcher m = pluginJarPattern.matcher(jarPath.lastSegment());
					if (m.matches()) {
						URI uri = URI.createPlatformPluginURI(m.group(1) + '/'
							+ entry.getName(), true);
						
						URI mapping = findMapping(uri);
						if (mapping != null) {
							uri = mapping;
						}
						
						Model zdl = getZDLModel(uri);
	
						if (zdl != null) {
							result.add(zdl);
						}
					}
				}
			}
		} finally {
			try {
				zipFile.close();
			} catch (IOException e) {
				Activator.getDefault().error(
					NLS.bind(Messages.ZDLMetamodelManager_closeJar, jarPath), e);
			}
		}

		return result;
	}
	
	private URI findMapping(URI uri) {
		URI result = null;
		int length = 0;
		
		for (Map.Entry<URI, URI> next : URIConverter.URI_MAP.entrySet()) {
			URI prefix = next.getValue();
			if (prefix.isPrefix()) {
				URI mapping = uri.replacePrefix(prefix, next.getKey());
				
				if ((mapping != null) && (prefix.segmentCount() > length)) {
					length = prefix.segmentCount();
					result = mapping;
				}
			}
		}
		
		if (result != null) {
			// mappings may chain
			URI mapping = findMapping(result);
			
			if (mapping != null) {
				result = mapping;
			}
		}
		
		return result;
	}

	/**
	 * A job that takes an item from the queue of ZDL search/update work items
	 * and performs it asynchronously.
	 * 
	 * @author Christian W. Damus (Zeligsoft)
	 */
	private class ZDLJob
			extends Job {

		private WorkItem workItem;

		/**
		 * Initializes me with my work item
		 * 
		 * @param workItem
		 *            my work item
		 */
		public ZDLJob(WorkItem workItem) {
			super(workItem.label());

			this.workItem = workItem;
			setRule(workItem.rule());
		}

		@Override
		public boolean belongsTo(Object family) {
			return family == ZDL_JOB_FAMILY;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			IStatus result = workItem.isDone()
				? workItem.status()
				: workItem.perform(monitor);

			dequeue();
				
			return result;
		}
	}

	/**
	 * Gets the next work-item from the queue. If there is another work-item to
	 * perform, I schedule another task to follow me.
	 * 
	 * @return whether another job was scheduled (because another work-item was
	 *         waiting)
	 */
	boolean dequeue() {
		boolean result = false;

		synchronized (workItems) {
			pending = workItems.poll();

			if (pending != null) {
				result = true;
				new ZDLJob(pending).schedule();
			}
		}

		return result;
	}

	/**
	 * Queries whether I am currently working on updates to the ZDL models in
	 * the workspace.
	 * 
	 * @return whether ZDL updates are pending
	 */
	public boolean isPending() {
		synchronized (workItems) {  // synch on the same monitor as {en,de}queue
			return pending != null;
		}
	}

	/**
	 * Enqueues a work-item to find ZDL models in the specified workspace scope.
	 * 
	 * @param scope
	 *            the scope in which to search for ZDL models; could be a single
	 *            file or even the entire workspace
	 */
	public void find(IResource scope) {
		// append a new work-item to the queue
		enqueue(new FindModels(scope));
	}
	
	/**
	 * Adds a new work-item to the queue and ensures that the ZDL job is
	 * awakened to process it, if necessary.
	 * 
	 * @param workItem
	 *            the new work-item to process
	 */
	void enqueue(WorkItem workItem) {
		synchronized (workItems) {
			// append a new work-item to the queue
			workItems.offer(workItem);

			if (!isPending()) {
				dequeue();
			}
		}
	}

	/**
	 * Enqueues a work-item to update ZDL models as indicated by the set of
	 * files to remove from the ZDL mappings and files to update in the ZDL
	 * mappings.
	 * 
	 * @param filesToRemove
	 *            files that have been deleted, and should therefore be removed
	 *            from the ZDL mappings
	 * @param filesToUpdate
	 *            files that are added or changed, and should therefore be
	 *            updated in the ZDL mappings
	 */
	public void update(Set<IFile> filesToRemove, Set<IFile> filesToUpdate) {
		// append a new work-item to the queue
		enqueue(new UpdateModels(filesToRemove, filesToUpdate));
	}

	/**
	 * Removes from my workspace mapping the ZDL model persisted in the
	 * specified file (if any).
	 * 
	 * @param file
	 *            a file that may contain a ZDL model
	 */
	private void removeModel(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
			true);

		Resource res = zdlResources.getResource(uri, false);
		if ((res != null) && res.isLoaded()) {
			res.unload();
			zdlResources.getResources().remove(res);
			workspaceModels.remove(file);
		}
	}

	/**
	 * An abstraction of a ZDL find/update job in the workspace, to be performed
	 * in the background.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private abstract class WorkItem {

		private boolean done = false;
		
		private IStatus status = null;
		
		/**
		 * Obtains a label to use for the job that executes me.
		 * 
		 * @return my label
		 */
		abstract String label();

		/**
		 * <p>
		 * The scheduling rule that the job should use that executes me, or
		 * <code>null</code> if none is needed.
		 * </p><p>
		 * <b>Note</b> that, in most cases, this should be <code>null</code>
		 * because the oAW builder often responds to the same stimuli (or
		 * invokes API that schedules these work items) and would deadlock on
		 * joining the ZDL job family in the
		 * {@link ZDLMetamodelManager#getWorkspaceZDLModels()} API.
		 * </p>
		 * 
		 * @return my scheduling rule
		 */
		abstract ISchedulingRule rule();

		/**
		 * Executes me.
		 * 
		 * @param monitor
		 *            a monitor that I may use to report progress
		 * @return a status indicating any potential problems that I ran into
		 */
		final IStatus perform(IProgressMonitor monitor) {
			this.status = doPerform(monitor);
			return status();
		}
		
		/**
		 * Does my thing.
		 * 
		 * @param monitor
		 *            a monitor that I may use to report progress
		 * @return a status indicating any potential problems that I ran into
		 */
		abstract IStatus doPerform(IProgressMonitor monitor);
		
		/**
		 * Tells me that I have finished my work.
		 */
		final void done() {
			done = true;
		}
		
		/**
		 * Queries whether I have finished my work.  Probably, I would not want
		 * to do it again.
		 * 
		 * @return whether I have already been completed.
		 */
		final boolean isDone() {
			return done;
		}
		
		/**
		 * Queries the status of my last execution, if I have been executed.
		 * 
		 * @return my last status
		 */
		final IStatus status() {
			return status;
		}
	}

	/**
	 * A concrete work-item for finding new ZDL models in some subset of the
	 * workspace.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class FindModels
			extends WorkItem {

		private IResource scope;

		/**
		 * Initializes me with the subset of the workspace that I search.
		 * 
		 * @param scope
		 *            my workspace subset
		 */
		FindModels(IResource scope) {
			this.scope = scope;
		}

		@Override
		String label() {
			return Messages.ZDLMetamodelManager_locating_zdls;
		}

		@Override
		ISchedulingRule rule() {
			return scope;
		}

		@Override
		IStatus doPerform(IProgressMonitor monitor) {
			try {
				scope.accept(new ZDLVisitor(), IResource.NONE);
			} catch (CoreException e) {
				return e.getStatus();
			} finally {
				done();
			}

			return Status.OK_STATUS;
		}
	}

	/**
	 * A concrete work-item for updating existing ZDL models in response to
	 * workspace change notifications.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class UpdateModels
			extends WorkItem {

		Set<IFile> filesToRemove;

		Set<IFile> filesToUpdate;

		/**
		 * Initializes me with a set of ZDL models to remove and to update,
		 * according to deletions (in the former case) and adds/changes (in the
		 * latter case) of files in the workspace.
		 * 
		 * @param filesToRemove
		 *            the deleted files
		 * @param filesToUpdate
		 *            the added/changed files
		 */
		UpdateModels(Set<IFile> filesToRemove, Set<IFile> filesToUpdate) {
			this.filesToRemove = filesToRemove;
			this.filesToUpdate = filesToUpdate;
		}

		@Override
		String label() {
			return Messages.ZDLMetamodelManager_updating_zdls;
		}

		@Override
		ISchedulingRule rule() {
			return null;
		}

		@Override
		IStatus doPerform(IProgressMonitor monitor) {
			try {
				for (IFile next : filesToRemove) {
					removeModel(next);
				}
	
				ZDLVisitor visitor = new ZDLVisitor();
	
				for (IFile next : filesToUpdate) {
					if (next.exists()) {
						try {
							next.accept(visitor, IResource.NONE);
						} catch (CoreException e) {
							Activator.getDefault().error(
								NLS.bind(Messages.ZDLMetamodelManager_updateZDL,
									next.getFullPath()), e);
						}
					} else {
						removeModel(next);
					}
				}
			} finally {
				done();
			}
			
			return Status.OK_STATUS;
		}
	}

	/**
	 * A combined workspace/change visitor used by the ZDL workspace-processing
	 * work-items to discover ZDL models in the first case and to schedule
	 * updates to the ZDL cache in the second case.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLVisitor
			implements IResourceProxyVisitor, IResourceDeltaVisitor {

		/**
		 * When processing a workspace change, UML files that were
		 * added/changed.
		 */
		Set<IFile> filesToUpdate;

		/** When processing a workspace change, UML files that were deleted. */
		Set<IFile> filesToRemove;

		/**
		 * Visits (statically) a workspace resource. If it looks like a UML
		 * model, we dig deeper to load it and see whether it is a ZDL model. If
		 * so, it is added to the cache.
		 */
		public boolean visit(IResourceProxy proxy)
				throws CoreException {

			if ((proxy.getType() == IResource.FILE)
				&& (proxy.getName().endsWith(UML_FILE_EXTENSION))) {
				visit((IFile) proxy.requestResource());
			}

			return true;
		}

		/**
		 * Attempts to load the specified file as an EMF resource and, if it is
		 * a ZDL model, retains it.
		 * 
		 * @param file
		 *            a workspace file to visit
		 */
		private void visit(IFile file) {
			URI uri = URI.createPlatformResourceURI(file.getFullPath()
				.toString(), true);

			Resource res = zdlResources.getResource(uri, false);
			if ((res != null) && res.isLoaded()) {
				// we are re-visiting an existing ZDL resource. Unload it
				res.unload();
			}

			Model zdl = getZDLModel(uri);
			if (zdl != null) {
				workspaceModels.put(file, zdl);
			}
		}

		/**
		 * Visits the specified resource change, looking for deleted, added, and
		 * changed files that may be ZDL models. Any that are found will be
		 * scheduled on the background ZDL job's work-queue to process
		 * asynchronously.
		 */
		public boolean visit(IResourceDelta delta)
				throws CoreException {

			IResource res = delta.getResource();
			if (res.getType() == IResource.ROOT) {
				filesToRemove = new java.util.HashSet<IFile>();
				filesToUpdate = new java.util.HashSet<IFile>();
			} else if ((res.getType() == IResource.FILE)
				&& res.getName().endsWith(UML_FILE_EXTENSION)) {

				switch (delta.getKind()) {
					case IResourceDelta.REMOVED :
						filesToRemove.add((IFile) res);
						break;
					case IResourceDelta.ADDED :
					case IResourceDelta.CHANGED :
						filesToUpdate.add((IFile) res);
						break;
				}
			}

			return true;
		}
	}

	/**
	 * A workspace listener that quickly processes resource changes to see
	 * whether any potential ZDL models are affected, and queue them for deeper
	 * processing asynchronously.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLResourceChangeListener
			implements IResourceChangeListener {

		public void resourceChanged(IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				try {
					ZDLVisitor visitor = new ZDLVisitor();
					event.getDelta().accept(visitor);

					// enqueue an update work-item
					update(visitor.filesToRemove, visitor.filesToUpdate);
				} catch (CoreException e) {
					Activator.getDefault().error(
						NLS.bind(Messages.ZDLMetamodelManager_analyzeDelta,
							event.getDelta().getFullPath()), e);
				}
			}
		}

	}
}
