/*******************************************************************************
 * Copyright (c) 2017,2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.XtextNature
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.builder;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.ui.BaseUIActivator;
import org.eclipse.ocl.xtext.base.ui.BaseUiModule;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.ui.messages.BaseUIMessages;

/**
 * Abstract Builder for OCL or QVTd contributions. Currently this involves identifying relevant files subject to
 * extension filtering defined by the excludeExtension/includeExtensions comma-separated file extensionlist
 * and path filtering defined by excludePaths/includepaths comma-separated classpath-style regexes.
 * Default values are supplied as part of the .project buildCommand when the OCL nature is added.
 *
 * The identified files are passed to a separate MultiValidationJob for concurrent non-blocking validation.
 */
public abstract class AbstractValidatingBuilder extends IncrementalProjectBuilder
{
	public static final @NonNull TracingOption BUILDER = new TracingOption(BaseUiPluginHelper.PLUGIN_ID, "builder");

	/**
	 * This is a copy of org.eclipse.jdt.internal.compiler.util.Util.isExcluded
	 *
	 * FIXME BUG 529789 requests its availability in CharOperation.
	 */
	final static boolean isExcluded(char[] path, char[][] inclusionPatterns, char[][] exclusionPatterns, boolean isFolderPath) {
		if (inclusionPatterns == null && exclusionPatterns == null) return false;

		inclusionCheck: if (inclusionPatterns != null) {
			for (int i = 0, length = inclusionPatterns.length; i < length; i++) {
				char[] pattern = inclusionPatterns[i];
				char[] folderPattern = pattern;
				if (isFolderPath) {
					int lastSlash = CharOperation.lastIndexOf('/', pattern);
					if (lastSlash != -1 && lastSlash != pattern.length-1){ // trailing slash -> adds '**' for free (see http://ant.apache.org/manual/dirtasks.html)
						int star = CharOperation.indexOf('*', pattern, lastSlash);
						if ((star == -1
								|| star >= pattern.length-1
								|| pattern[star+1] != '*')) {
							folderPattern = CharOperation.subarray(pattern, 0, lastSlash);
						}
					}
				}
				if (CharOperation.pathMatch(folderPattern, path, true, '/')) {
					break inclusionCheck;
				}
			}
			return true; // never included
		}
		if (isFolderPath) {
			path = CharOperation.concat(path, new char[] {'*'}, '/');
		}
		if (exclusionPatterns != null) {
			for (int i = 0, length = exclusionPatterns.length; i < length; i++) {
				if (CharOperation.pathMatch(exclusionPatterns[i], path, true, '/')) {
					return true;
				}
			}
		}
		return false;
	}

	protected static enum BuildType
	{
		CLEAN, FULL, INCREMENTAL, RECOVERY
	}

	@Override
	protected IProject[] build(final int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		if (BUILDER.isActive()) {
			BUILDER.println(getDebugName() + " build " + getKindAsString(kind));
		}
		long startTime = System.currentTimeMillis();
		int selectionSize = -1;
		int unselectionSize = -1;
		IProject project = getProject();
		assert project != null;
		String builderName = getBuilderName();
		String projectName = project.getName();
		try {
			String initializingMessage = StringUtil.bind(BaseUIMessages.MultiValidationJob_Initializing, builderName, projectName);
			SubMonitor subMonitor = SubMonitor.convert(monitor, initializingMessage, 3);
		//	if (BUILDER.isActive()) {
		//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " converted from: " + NameUtil.debugSimpleName(monitor));
		//	}
			//	Work item 1: MultiValidationJob_Initializing
			//
			AbstractBuildSelector buildSelector;
			IResourceDelta delta;
			if (kind == FULL_BUILD) {
				getProject().deleteMarkers(getMarkerId(), true, IResource.DEPTH_INFINITE);
				buildSelector = createBuildSelector(project, BuildType.FULL, args, subMonitor);
				delta = null;
			} else if (kind == AUTO_BUILD){
				delta = getDelta(getProject());
				buildSelector = createBuildSelector(project, BuildType.INCREMENTAL, args, subMonitor);
			} else if (kind == INCREMENTAL_BUILD){
				//	delta = getDelta(getProject());
				//	buildSelector = createBuildSelector(project, BuildType.INCREMENTAL, args, subMonitor);
				return null; 		// FIXME BUG 544189 there is no incremental support.
			} else {		// CLEAN_BUILD never happens
				//	delta = getDelta(getProject());
				//	buildSelector = createBuildSelector(project, BuildType.INCREMENTAL, args, subMonitor);
				return null;
			}
		//	if (BUILDER.isActive()) {
		//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " worked 1");
		//	}
			subMonitor.worked(1);
			//
			//	Work item 2: MultiValidationJob_Selecting
			//
			String selectingMessage = StringUtil.bind(BaseUIMessages.MultiValidationJob_Selecting, builderName, projectName);
		//	if (BUILDER.isActive()) {
		//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " subTask: " + selectingMessage);
		//	}
			subMonitor.subTask(selectingMessage);
			selectionSize = buildSelector.selectResources(delta);
			unselectionSize = buildSelector.deleteRemovedResourceMarkers();
		//	if (BUILDER.isActive()) {
		//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " worked: 1");
		//	}
			subMonitor.worked(1);
			//
			//	Work item 3: MultiValidationJob_Queuing
			//
			if (selectionSize > 0) {
				String queueingMessage = StringUtil.bind(BaseUIMessages.MultiValidationJob_Queuing, builderName, selectionSize, projectName);
			//	if (BUILDER.isActive()) {
			//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " subTask: " + queueingMessage);
			//	}
				subMonitor.subTask(queueingMessage);
				buildSelector.buildResources();
			//	if (BUILDER.isActive()) {
			//		long endTime = System.currentTimeMillis();
			//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " worked: 1");
			//		BUILDER.println("Selected " + selectionSize + " elements in " + (endTime-startTime) + " ms for " + projectName + " on " + Thread.currentThread().getName());
			//	}
				subMonitor.worked(1);
			}
			//
		//	if (BUILDER.isActive()) {
		//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(subMonitor) + " done");
		//	}
			subMonitor.done();
		} catch (CoreException e) {
			getLog().error(e.getMessage(), e);
			throw e;
		} catch (OperationCanceledException e) {
			handleCanceled(e);
		} catch (Exception e) {
			getLog().error(e.getMessage(), e);
			forgetLastBuiltState();
		} finally {
			if (BUILDER.isActive()) {
				long endTime = System.currentTimeMillis();
				BUILDER.println((endTime-startTime) + " ms to select/unselect " + selectionSize + "/" + unselectionSize + " elements on \"" + Thread.currentThread().getName() + "\"");
			}
			if (monitor != null) {
			//	if (BUILDER.isActive()) {
			//		BUILDER.println(Thread.currentThread().getName() + " " + NameUtil.debugSimpleName(monitor) + " done2");
			//	}
				monitor.done();
			}
		//	if (BUILDER.isActive()) {
		//				String message = "Pre-build " + getProject().getName() + " in " + (System.currentTimeMillis() - startTime) + " ms";
			//			getLog().info(message);
		//				BUILDER.println(Thread.currentThread().getName() + " log " + message);
		//	}
		}
		return null;
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		if (BUILDER.isActive()) {
			BUILDER.println(getDebugName() + " clean");
		}
		BaseUIActivator.cancelMultiValidationJob();
		getProject().deleteMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);	// Temporary zap, see Bug 544737
	}

	protected abstract @NonNull AbstractBuildSelector createBuildSelector(@NonNull IProject project, @NonNull BuildType buildType,
			@Nullable Map<String, String> args, @NonNull IProgressMonitor monitor);

	protected abstract @NonNull String getBuilderName();

	protected String getDebugName() {
		String name = getClass().getName();
		int lastIndex = name.lastIndexOf(".");
		return (lastIndex >= 0 ? name.substring(lastIndex+1) : name) + "-" + getBuildConfig(); // + "@" + Integer.toHexString(System.identityHashCode(this));
	}

	private String getKindAsString(int kind) {
		switch (kind) {
			case IncrementalProjectBuilder.AUTO_BUILD: return "AUTO_BUILD";
			case IncrementalProjectBuilder.CLEAN_BUILD: return "CLEAN_BUILD";
			case IncrementalProjectBuilder.FULL_BUILD: return "FULL_BUILD";
			case IncrementalProjectBuilder.INCREMENTAL_BUILD: return "INCREMENTAL_BUILD";
		}
		return "OTHER_BUILD";
	}

	protected abstract Logger getLog();

	protected /*abstract*/ @NonNull String getMarkerId() {		// FIXME Chn age to abxstract after 2019-03M3 once QVTd catches up
		return BaseUiModule.MARKER_ID;
	}

	private void handleCanceled(Throwable t) {
		BaseUIActivator.cancelMultiValidationJob();
	}
}
