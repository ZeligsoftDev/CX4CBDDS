/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EObservableAdapterList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2.IFileCallback;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.generator.FileSystemAccessRequest;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.7
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class ParallelBuilderParticipant extends BuilderParticipant {
	private static final Logger logger = LogManager.getLogger(ParallelBuilderParticipant.class);

	/**
	 * Encapsulate all the information for the processing of a single 
	 * resource on its own thread.
	 * 
	 * @since 2.9
	 * @noreference This class is not intended to be referenced by clients.
	 */
	protected static class ParallelBuildContext implements IBuildContext {
		final IResourceDescription.Delta delta;
		final IBuildContext buildContextDelegate;
		final Map<String, OutputConfiguration> outputConfigurations; 
		final Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers;
		final FileSystemAccessQueue fileSystemAccessQueue;
		final Queue<ParallelBuildContext> afterGenerateQueue;
		final EclipseResourceFileSystemAccess2 synchronousFileSystemAccess;
		final IProgressMonitor progressMonitor;
		final Resource resource;
		
		public ParallelBuildContext(
				Delta delta,
				IBuildContext buildContextDelegate,
				Map<String, OutputConfiguration> outputConfigurations,
				Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers,
				FileSystemAccessQueue fileSystemAccessQueue,
				Queue<ParallelBuildContext> afterGenerateQueue,
				EclipseResourceFileSystemAccess2 delegate,
				IProgressMonitor progressMonitor) {
			this.delta = delta;
			if (delta.getNew() != null) {
				resource = buildContextDelegate.getResourceSet().getResource(delta.getUri(), true);
			} else {
				resource = null;
			}
			this.buildContextDelegate = buildContextDelegate;
			this.outputConfigurations = outputConfigurations;
			this.generatorMarkers = generatorMarkers;
			this.fileSystemAccessQueue = fileSystemAccessQueue;
			this.afterGenerateQueue = afterGenerateQueue;
			this.synchronousFileSystemAccess = delegate;
			this.progressMonitor = progressMonitor;
		}
		
		public URI getURI() {
			return delta.getUri();
		}

		@Override
		public IProject getBuiltProject() {
			return buildContextDelegate.getBuiltProject();
		}

		@Override
		public List<Delta> getDeltas() {
			return buildContextDelegate.getDeltas();
		}

		@Override
		public ResourceSet getResourceSet() {
			return buildContextDelegate.getResourceSet();
		}

		@Override
		public BuildType getBuildType() {
			return buildContextDelegate.getBuildType();
		}

		@Deprecated
		@Override
		public void needRebuild() {
			buildContextDelegate.needRebuild();
		}
		
		@Override
		public void needRebuild(IProject project) {
			if (ParallelBuildContext.class == getClass()) {
				buildContextDelegate.needRebuild(project);
			} else {
				needRebuild();
			}
		}
		
		@Override
		public boolean isSourceLevelURI(URI uri) {
			return buildContextDelegate.isSourceLevelURI(uri);
		}
		
		public IGeneratorContext getGeneratorContext() {
			CancelIndicator cancelIndicator = new MonitorBasedCancelIndicator(progressMonitor);
			GeneratorContext context = new GeneratorContext();
			context.setCancelIndicator(cancelIndicator);
			return context;
		}
		
	}
	
	@Inject private BuildExecutors executors;
	
	private static final class Tripwire implements EObservableAdapterList.Listener {

		private static final Logger log = LogManager.getLogger(Tripwire.class);
		
		@Override
		public void added(Notifier notifier, Adapter adapter) {
			String message = "Added adapter to resource set during code generation: " + adapter;
			IllegalStateException exception = new IllegalStateException(message);
			log.error(message, exception);
		}

		@Override
		public void removed(Notifier notifier, Adapter adapter) {
			String message = "Removed adapter to resource set during code generation: " + adapter;
			IllegalStateException exception = new IllegalStateException(message);
			log.error(message, exception);
		}
		
	}
	
	private static final int QUEUE_CAPACITY = 50;
	
	private static final int QUEUE_POLL_TIMEOUT = 50;

	/**
	 * @see #handleChangedContents(ParallelBuildContext, IFileSystemAccess2)
	 */
	@Override
	protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess access)
			throws CoreException {
		handleChangedContents((ParallelBuildContext) context, (IFileSystemAccess2) access);
	}
	
	/**
	 * @since 2.9
	 */
	protected void handleChangedContents(ParallelBuildContext context, IFileSystemAccess2 access)
			throws CoreException {
		Resource resource = context.resource;
		saveResourceStorage(resource, access);
		if (shouldGenerate(resource, context)) {
			getGenerator2().doGenerate(resource, access, context.getGeneratorContext());
		}
	}
	
	@Override
	protected void doBuild(
			List<Delta> deltas, 
			Map<String, OutputConfiguration> outputConfigurations,
			Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers, 
			IBuildContext context,
			EclipseResourceFileSystemAccess2 access, 
			IProgressMonitor progressMonitor) throws CoreException {
		BlockingQueue<FileSystemAccessRequest> requestQueue = newBlockingQueue(QUEUE_CAPACITY);
		// This queue is only used from the current thread
		// thus there is no need for a blocking queue. The add operation should also not block the
		// builder thread
		Queue<ParallelBuildContext> afterGenerateQueue = new ArrayDeque<ParallelBuildContext>(QUEUE_CAPACITY);
		
		FileSystemAccessQueue fileSystemAccessQueue = new FileSystemAccessQueue(requestQueue, progressMonitor);
		Tripwire tripwire = new Tripwire();
		EList<Adapter> adapters = context.getResourceSet().eAdapters();
		EObservableAdapterList observableAdapters = (EObservableAdapterList) adapters;
		adapters.add(fileSystemAccessQueue);
		observableAdapters.addListener(tripwire);
		try {
			SubMonitor subMonitor = SubMonitor.convert(progressMonitor, 1);
			subMonitor.subTask("Compiling...");
			access.setMonitor(subMonitor.split(1));
			
			List<ListenableFuture<?>> tasks = Lists.newArrayList();
	
			ListeningExecutorService executor = executors.getExecutor();
			for (IResourceDescription.Delta delta : deltas) {
				if (getResourceServiceProvider().canHandle(delta.getUri())) {
					try {
						ParallelBuildContext parallelBuildContext = new ParallelBuildContext(delta, context, outputConfigurations, generatorMarkers, fileSystemAccessQueue, afterGenerateQueue, access, progressMonitor);
						Runnable runnable = createRunnable(parallelBuildContext);
						tasks.add(executor.submit(runnable));
					} catch (Exception e) {
						addMarkerAndLogError(delta.getUri(), e);
					}
				}
			}
			
			ListenableFuture<List<Object>> generatorResult = Futures.successfulAsList(tasks);
			
			List<SimpleEntry<URI, Throwable>> exceptions = Lists.newArrayList();
			boolean interrupted = false;
			try {
				/*
				 * it is important to check generatorResult and requestQueue second
				 * as it can happen that if you use !requestQueue.isEmpty() || !generatorResult.isDone()
				 * that the generatorResult.isDone() becomes true after requestQueue.isEmpty() was checked
				 * and thus requestQueue.isEmpty() changes back to false
				 * but we stop the while loop anyway and thus miss generated files.
				 */
				while (!generatorResult.isDone() || !requestQueue.isEmpty()) {
					if (subMonitor.isCanceled()) {
						cancelProcessing(requestQueue, afterGenerateQueue, generatorResult);
						throw new OperationCanceledException();
					}
	
					FileSystemAccessRequest request = null;
					try {
						request = requestQueue.poll(QUEUE_POLL_TIMEOUT, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
						interrupted = true;
					}
					if (request != null) {
						try {
							request.run();
						} catch (OperationCanceledException e) {
							cancelProcessing(requestQueue, afterGenerateQueue, generatorResult);
							throw e;
						} catch (Exception e) {
							Throwable cause = e;
							if (cause instanceof CoreException) {
								cause = cause.getCause();
							}
							exceptions.add(new SimpleEntry<URI, Throwable>(request.getUri(), cause));
						}
					}
				}
			} finally {
				if (interrupted) {
					Thread.currentThread().interrupt();
				}
				for (SimpleEntry<URI, Throwable> exception : exceptions) {
					addMarkerAndLogError(exception.getKey(), exception.getValue());
				}
			}
		} finally {
			observableAdapters.removeListener(tripwire);
			adapters.remove(fileSystemAccessQueue);
		}
	}

	private void cancelProcessing(BlockingQueue<FileSystemAccessRequest> requestQueue, Queue<ParallelBuildContext> afterGenerateQueue, ListenableFuture<?> generatorResult) {
		// make sure waiting put on the queue are processed by freeing space in the queue
		requestQueue.clear();
		// stop processing of resources immediately
		generatorResult.cancel(true);
		for (ParallelBuildContext context : afterGenerateQueue) {
			try {
				getGenerator2().afterGenerate(context.resource, context.synchronousFileSystemAccess, context.getGeneratorContext());
			} catch (Exception e) {
				logger.error("Error running afterGenerate hook", e);
			}
		}
	}

	
	/**
	 * @since 2.9
	 */
	protected Runnable createRunnable(final ParallelBuildContext buildContext) {
		final IGenerator2 generator = getGenerator2();
		final Resource resource = buildContext.resource;
		if (resource != null) {
			generator.beforeGenerate(resource, buildContext.synchronousFileSystemAccess, buildContext.getGeneratorContext());
			buildContext.afterGenerateQueue.add(buildContext);
		}
		return new Runnable() {

			@Override
			public void run() {
				Delta delta = buildContext.delta;
				try {
					Set<IFile> derivedResources = getDerivedResources(delta, buildContext.outputConfigurations, buildContext.generatorMarkers);

					FileSystemAccessQueue fileSystemAccessQueue = buildContext.fileSystemAccessQueue;
					IFileSystemAccess2 fsa = getParallelFileSystemAccess(delta, buildContext, derivedResources, fileSystemAccessQueue, buildContext.synchronousFileSystemAccess);
					boolean generated = doGenerate(delta, buildContext, fsa);
					
					final Runnable derivedResourceCallback = getFlushAndCleanDerivedResourcesCallback(buildContext, derivedResources, generated);
					fileSystemAccessQueue.sendAsync(delta.getUri(), new Runnable() {

						@Override
						public void run() {
							try {
								derivedResourceCallback.run();
							} finally {
								if (resource != null) {
									generator.afterGenerate(resource, buildContext.synchronousFileSystemAccess, buildContext.getGeneratorContext());
									buildContext.afterGenerateQueue.remove(buildContext);
								}
							}
						}
						
					});
				} catch (OperationCanceledException e)  {
					// do nothing 
				} catch (Throwable e) {
					addMarkerAndLogError(delta.getUri(), e);
				}
			}

		};
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	protected boolean doGenerate(IResourceDescription.Delta delta, IBuildContext context, IFileSystemAccess access) throws OperationCanceledException {
		if (delta.getNew() != null) {
			try {
				handleChangedContents(delta, context, access);
			} catch (OperationCanceledException e) {
				throw e;
			} catch (Exception e) {
				addMarkerAndLogError(delta.getUri(), e);
			}
			return true;
		}
		return false;
	}

	protected <E> BlockingQueue<E> newBlockingQueue(int capacity) {
		return new LinkedBlockingQueue<E>(capacity);
	}

	/**
	 * @since 2.9
	 */
	protected Runnable getFlushAndCleanDerivedResourcesCallback(
			final ParallelBuildContext buildContext,
			final Set<IFile> derivedResources,
			final boolean generated) {
		return new Runnable() {

			@Override
			public void run() {
				try {
					EclipseResourceFileSystemAccess2 synchronousFileSystemAccess = buildContext.synchronousFileSystemAccess;
					if (generated) {
						synchronousFileSystemAccess.flushSourceTraces();
					}
					cleanDerivedResources(buildContext.delta, derivedResources, buildContext, synchronousFileSystemAccess, buildContext.progressMonitor);
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}

		};
	}

	/**
	 * @since 2.14
	 */
	protected IFileSystemAccess2 getParallelFileSystemAccess(final IResourceDescription.Delta delta,
			final IBuildContext context, Set<IFile> derivedResources, FileSystemAccessQueue fileSystemAccessQueue, IFileSystemAccess2 delegate) {
		String currentSourceFolder = getCurrentSourceFolder(context, delta);
		IFileCallback postProcessor = getPostProcessor(delta, context, derivedResources);
		return new ParallelFileSystemAccess(delegate, delta, fileSystemAccessQueue, currentSourceFolder, postProcessor);
	}

}
