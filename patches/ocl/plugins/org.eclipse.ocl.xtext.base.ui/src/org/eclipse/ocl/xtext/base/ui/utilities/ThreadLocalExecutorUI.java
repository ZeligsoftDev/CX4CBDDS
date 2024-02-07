/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * The ThreadLocalExecutorUI enhances ThreadLocalExecutor to maintain a distinct ThreadLocal context for each
 * active open WorkbenchPart.
 *
 * @since 1.14
 */
public class ThreadLocalExecutorUI extends ThreadLocalExecutor implements IPartListener
{
	/**
	 * Establish the initActivePart to initEnvironmentfactory at a time when the initActivePart may not be consistently
	 * activated; i.e. while responding to an action in another part.
	 *
	 * If initActivePart is null the prevailing activePart is used to provide support for OCL-blind applications
	 * such as the Sample Ecore Editor.
	 *
	 * If initEnvironmentfactory is null a new activePart will be defining a new initEnvironmentfactory later.
	 */
	public static void initPart(@Nullable IWorkbenchPart initActivePart, @Nullable EnvironmentFactoryInternal initEnvironmentfactory) {
		assert (initActivePart != null) || (initEnvironmentfactory != null);
		ThreadLocalExecutor threadLocalExecutor = get();
		if (threadLocalExecutor instanceof ThreadLocalExecutorUI) {
			((ThreadLocalExecutorUI)threadLocalExecutor).localInitPart(initActivePart, initEnvironmentfactory);
		}
	}

	private @Nullable IWorkbenchPart activePart = null;;

	/**
	 * An IWorkbenchPart to EnvironmentFactoryInternal binding is present for every OCL-using IWorkbenchPart.
	 * The binding is explicitly established for OCL-aware IWorkbenchParts by calls of initPart and destroyed by partClosed.
	 * The binding is implicitly established for OCL-blind IWorkbenchParts by calls of initPart from lazy OCL creation and destroyed by a partClosed.
	 */
	protected final @NonNull Map<@NonNull IWorkbenchPart, @NonNull EnvironmentFactoryInternal> part2environmentFactory = new HashMap<>();

	public ThreadLocalExecutorUI() {}

	/**
	 * Close all editors using EnvironmentFactory instances. THs method is intended solely for use at the end of tests
	 * for which an auto-editor created by the debugger may be hard to locate.
	 */
	public static void closeEditors() {
		ThreadLocalExecutor threadLocalExecutor = get();
		((ThreadLocalExecutorUI)threadLocalExecutor).localCloseEditors();
	}

	@Override
	protected @NonNull ThreadLocalExecutor createInstance() {
		if (Display.getCurrent() == null) {
			return super.createInstance();
		}
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			IPartService partService = activeWorkbenchWindow.getPartService();
			if (partService != null) {
				partService.addPartListener(this);
			}
		}
		return this;
	}

	@Override
	protected @NonNull String getThreadName() {
		return "[" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(activePart) + "]";
	}

	private void localCloseEditors() {
		for (@NonNull IWorkbenchPart part : new ArrayList<>(part2environmentFactory.keySet())) {
			if (part instanceof IEditorPart) {
				IEditorPart editorPart = (IEditorPart)part;
				editorPart.getSite().getPage().closeEditor(editorPart, false);
			}
		}
	}

	protected void localInitPart(@Nullable IWorkbenchPart initActivePart, @Nullable EnvironmentFactoryInternal initEnvironmentfactory) {
		if (initEnvironmentfactory != basicGetEnvironmentFactory()) {			// == if a late not-active init
			setEnvironmentFactory(null);
		}
		if (initActivePart == null) {			// If implicit OCL-bland init
			initActivePart = this.activePart;
			assert initActivePart != null;
		}
		if (initEnvironmentfactory != null) {
			EnvironmentFactoryInternal oldEnvironmentFactory = part2environmentFactory.put(initActivePart, initEnvironmentfactory);
			assert oldEnvironmentFactory == null;
			if (THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
				THREAD_LOCAL_ENVIRONMENT_FACTORY.println(getThreadName() + " Init [" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(initActivePart) + "] " + toString());
			}
		}
	}

	@Override
	protected void localAttachEnvironmentFactory(@NonNull EnvironmentFactoryInternal newEnvironmentFactory) {
		super.localAttachEnvironmentFactory(newEnvironmentFactory);
		if (Display.getCurrent() != null) {
			getClass();
		}
	}

	@Override
	protected void localDetachEnvironmentFactory(@NonNull EnvironmentFactory environmentFactory) {
		super.localDetachEnvironmentFactory(environmentFactory);
		if (Display.getCurrent() != null) {
			getClass();
		}
	}

	@Override
	protected synchronized void localReset() {
		IWorkbenchPart activePart2 = activePart;
		if (activePart2 != null) {
			part2environmentFactory.remove(activePart2);
		}
		super.localReset();
	}

	@Override
	public void partActivated(IWorkbenchPart newActivePart) {
		assert newActivePart != null;
		EnvironmentFactoryInternal environmentFactory = part2environmentFactory.get(newActivePart);
		setEnvironmentFactory(environmentFactory);
		EnvironmentFactory partEnvironmentFactory = newActivePart.getAdapter(EnvironmentFactory.class);
		if ((partEnvironmentFactory == null) && (environmentFactory != null)) {		// OCL-blind editor
			environmentFactory.detach(this);
		}
		if (THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
			THREAD_LOCAL_ENVIRONMENT_FACTORY.println(getThreadName() + " partActivated [" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(newActivePart) + "] " + toString());
		}
		activePart = newActivePart;
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		if (THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
			THREAD_LOCAL_ENVIRONMENT_FACTORY.println(getThreadName() + " partBroughtToTop [" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(part) + "] " + toString());
		}
	}

	@Override
	public void partClosed(IWorkbenchPart oldOpenPart) {
		assert oldOpenPart != null;
		assert oldOpenPart != activePart;
		if (THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
			THREAD_LOCAL_ENVIRONMENT_FACTORY.println(getThreadName() + " partClosed [" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(oldOpenPart) + "] " + toString());
		}
		@SuppressWarnings("unused")
		EnvironmentFactoryInternal oldEnvironmentFactory = part2environmentFactory.remove(oldOpenPart);
	}

	@Override
	public void partDeactivated(IWorkbenchPart oldActivePart) {
		assert oldActivePart != null;
		if (THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
			THREAD_LOCAL_ENVIRONMENT_FACTORY.println(getThreadName() + " partDeactivated [" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(oldActivePart) + "] " + toString());
		}
		EnvironmentFactoryInternal environmentFactory = localBasicGetEnvironmentFactory();
		if (environmentFactory != null) {
			EnvironmentFactory partEnvironmentFactory = oldActivePart.getAdapter(EnvironmentFactory.class);
			part2environmentFactory.put(oldActivePart, environmentFactory);    // part2environmentFactory persists for an activate
			if (partEnvironmentFactory == null) {		// OCL-blind editor
				environmentFactory.attach(this);
			}
		}
		else {
			part2environmentFactory.remove(oldActivePart);
		}
		activePart = null;
		setEnvironmentFactory(null);

	}

	@Override
	public void partOpened(IWorkbenchPart newOpenPart) {
		if (THREAD_LOCAL_ENVIRONMENT_FACTORY.isActive()) {
			THREAD_LOCAL_ENVIRONMENT_FACTORY.println(getThreadName() + " partOpened [" + Thread.currentThread().getName() + ":" + NameUtil.debugSimpleName(newOpenPart) + "] " + toString());
		}
	}
}