/*******************************************************************************
 * Copyright (c) 2013, 2019 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.swt.widgets.Tree;

/**
 * The ValidationViewRefreshJob provides a delayed refresh of the Validation View trees
 * avoiding the heavy UI thrashing that might occur if each model change updated imeediately.
 */
public class ValidityViewRefreshJob extends Job
{
	private class DisplayRefresh implements Runnable
	{
		protected final @Nullable IProgressMonitor monitor;
		private final @NonNull AbstractNode @Nullable [] grayedValidatableNodes;
		private final @NonNull AbstractNode @Nullable [] grayedConstrainingNodes;

		public DisplayRefresh(@Nullable IProgressMonitor monitor, @Nullable List<AbstractNode> grayedValidatableNodes,
				@Nullable List<AbstractNode> grayedConstrainingNodes) {
			this.monitor = monitor;
			this.grayedValidatableNodes = grayedValidatableNodes != null ? grayedValidatableNodes.toArray(new @NonNull AbstractNode[grayedValidatableNodes.size()]) : null;
			this.grayedConstrainingNodes = grayedConstrainingNodes != null ? grayedConstrainingNodes.toArray(new @NonNull AbstractNode[grayedConstrainingNodes.size()]) : null;
		}

		@Override
		public void run() {
//			long start = System.currentTimeMillis();
//			System.out.format(Thread.currentThread().getName() + " %3.3f Redraw start\n", (System.currentTimeMillis() - start) * 0.001);
			assert monitor != null;
			try {
				final @SuppressWarnings("null")@NonNull Monitor emfMonitor = BasicMonitor.toMonitor(monitor);
				if (!emfMonitor.isCanceled()) {
//					System.out.format(Thread.currentThread().getName() + " %3.3f Redraw refresh ConstrainingNodes\n", (System.currentTimeMillis() - start) * 0.001);
					constrainingNodesViewer.refresh();
				}
				if (!emfMonitor.isCanceled()) {
///					System.out.format(Thread.currentThread().getName() + " %3.3f Redraw refresh ValidatableNodes\n", (System.currentTimeMillis() - start) * 0.001);
					validatableNodesViewer.refresh();
				}
				if (!emfMonitor.isCanceled() && (grayedConstrainingNodes != null)) {
//					System.out.format(Thread.currentThread().getName() + " %3.3f Redraw setGrayed ConstrainingNodes\n", (System.currentTimeMillis() - start) * 0.001);
					constrainingNodesViewer.setGrayedElements(grayedConstrainingNodes);
				}
				if (!emfMonitor.isCanceled() && (grayedValidatableNodes != null)) {
//					System.out.format(Thread.currentThread().getName() + " %3.3f Redraw setGrayed ValidatableNodes\n", (System.currentTimeMillis() - start) * 0.001);
					validatableNodesViewer.setGrayedElements(grayedValidatableNodes);
				}
//				System.out.format(Thread.currentThread().getName() + " %3.3f Redraw done\n", (System.currentTimeMillis() - start) * 0.001);



//			System.out.println(Thread.currentThread().getName() + " - DisplayRefresh.start");
//			try {
//				// For large models intelligent selective update is costly so just do a full refresh
//				validatableNodesViewer.refresh();
//				constrainingNodesViewer.refresh();
			}
			finally {
				displayRefresh = null;
//				System.out.println(Thread.currentThread().getName() + " - DisplayRefresh.end");
				synchronized (refreshQueue) {
					if (!refreshQueue.isEmpty()) {
						schedule(IDEValidityManager.SLOW_REFRESH_DELAY);
					}
				}
			}
		}
	}

	private Set<AbstractNode> refreshQueue = new HashSet<AbstractNode>();
	private ValidityView validityView = null;
	private CheckboxTreeViewer validatableNodesViewer = null;
	private CheckboxTreeViewer constrainingNodesViewer = null;
	private DisplayRefresh displayRefresh = null;

	public ValidityViewRefreshJob() {
		super("Validation View Refresh");
	}

	public void add(@Nullable AbstractNode node) {
		synchronized (refreshQueue) {
			if (refreshQueue.isEmpty()) {
				schedule(IDEValidityManager.FAST_REFRESH_DELAY);
			}
			if (node != null) {
				refreshQueue.add(node);
			}
		}
	}

	public void initViewers(@NonNull ValidityView validityView,
			@NonNull CheckboxTreeViewer validatableNodesViewer, @NonNull CheckboxTreeViewer constrainingNodesViewer) {
		this.validityView = validityView;
		this.validatableNodesViewer = validatableNodesViewer;
		this.constrainingNodesViewer = constrainingNodesViewer;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
//		System.out.println(Thread.currentThread().getName() + " - RefreshJob.start");
		if (displayRefresh != null) {
//			System.out.println(Thread.currentThread().getName() + " - RefreshJob.skip");
			return Status.CANCEL_STATUS;
		}
		if (monitor.isCanceled()) {
//			System.out.println(Thread.currentThread().getName() + " - RefreshJob.abort");
			return Status.CANCEL_STATUS;
		}
		if ((validatableNodesViewer == null) || (constrainingNodesViewer == null)) {
//			System.out.println(Thread.currentThread().getName() + " - RefreshJob viewers not-ready");
			return Status.CANCEL_STATUS;
		}
		ValidityModel model = validityView.getValidityManager().getModel();
		if (model == null) {
//			System.out.println(Thread.currentThread().getName() + " - RefreshJob model not-ready");
			return Status.CANCEL_STATUS;
		}
		synchronized (refreshQueue) {
			refreshQueue.clear();
		}

		List<@NonNull AbstractNode> grayedValidatableNodes = new ArrayList<@NonNull AbstractNode>();
		List<@NonNull AbstractNode> grayedConstrainingNodes = new ArrayList<@NonNull AbstractNode>();
		model.refreshModel(grayedValidatableNodes, grayedConstrainingNodes);

		displayRefresh = new DisplayRefresh(monitor, grayedValidatableNodes, grayedConstrainingNodes);
		Tree tree = validatableNodesViewer.getTree();
		if (!tree.isDisposed()) {
			tree.getDisplay().asyncExec(displayRefresh);
		}
//		System.out.println(Thread.currentThread().getName() + " - RefreshJob.done");
		return Status.OK_STATUS;
	}
}