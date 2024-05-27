/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups;

import static com.google.common.collect.Sets.newLinkedHashSet;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupProviderChange;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.EmptyDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

/**
 * This class will be used by the EMF Compare UI to group differences together in the structural differences
 * tree viewer.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public final class StructureMergeViewerGrouper {

	/** An empty difference group provider. */
	private final IDifferenceGroupProvider empty;

	/**
	 * The currently selected group provider. This is what will compute and give us the groups we need to
	 * display.
	 */
	private IDifferenceGroupProvider provider;

	/** List of all TreeViewers on which this grouper is applied. */
	private final List<StructuredViewer> viewers;

	/** The {@link EventBus} associated with this grouper. */
	private final EventBus eventBus;

	/** The set of registered group provider that has been set on this grouper. */
	private final Set<IDifferenceGroupProvider> registeredGroupProviders;

	/**
	 * Constructs the difference grouper.
	 * 
	 * @param eventBus
	 *            The {@link EventBus} which will be associated with this difference grouper.
	 */
	public StructureMergeViewerGrouper(EventBus eventBus) {
		this.empty = new EmptyDifferenceGroupProvider();
		this.eventBus = eventBus;
		this.provider = empty;
		this.viewers = Lists.newArrayList();
		this.registeredGroupProviders = newLinkedHashSet();
	}

	/**
	 * Sets the instance that will provide the groups to be displayed in the structural differences view.
	 * 
	 * @param provider
	 *            The provider that will be use to compute the groups that are to be displayed in the UI.
	 */
	public void setProvider(IDifferenceGroupProvider provider) {
		if (this.provider != provider) {
			this.provider = provider;
			refreshViewers();
			eventBus.post(new DifferenceGroupProviderChange(provider));
		}
	}

	/**
	 * Get the {@link IDifferenceGroupProvider} associated to this StructureMergeViewerGrouper.
	 * 
	 * @return the provider associated to this StructureMergeViewerGrouper
	 */
	public IDifferenceGroupProvider getProvider() {
		return provider;
	}

	/**
	 * Refreshes the viewers registered with this grouper.
	 */
	private void refreshViewers() {
		for (StructuredViewer viewer : viewers) {
			Adapter root = (Adapter)viewer.getInput();
			if (root != null) {
				Notifier target = root.getTarget();
				registerDifferenceGroupProvider(target, provider);
			}
		}
	}

	/**
	 * Registers the selected IDifferenceGroupProvider to the given Notifier.
	 * 
	 * @param notifier
	 *            the given Notifier.
	 * @param groupProvider
	 *            the selected IDifferenceGroupProvider.
	 */
	protected void registerDifferenceGroupProvider(Notifier notifier,
			IDifferenceGroupProvider groupProvider) {
		List<Adapter> eAdapters = notifier.eAdapters();
		Adapter oldGroupProvider = EcoreUtil.getAdapter(eAdapters, IDifferenceGroupProvider.class);
		if (oldGroupProvider != null) {
			eAdapters.remove(oldGroupProvider);
		}
		eAdapters.add(groupProvider);
		registeredGroupProviders.add(groupProvider);
	}

	/**
	 * Install this grouper on the given viewer.
	 * <p>
	 * Note that this will also install a dispose listener on that viewer in order to remove the grouper
	 * whenever the viewer is disposed.
	 * </p>
	 * 
	 * @param viewer
	 *            The viewer on which the grouper will be installed.
	 */
	public void install(final StructuredViewer viewer) {
		viewer.getControl().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				uninstall(viewer);
			}
		});
		viewers.add(viewer);
	}

	/**
	 * Uninstall this grouper from the given viewer.
	 * 
	 * @param viewer
	 *            The viewer from which the grouper should be removed.
	 */
	public void uninstall(StructuredViewer viewer) {
		Object input = viewer.getInput();
		final Notifier notifier;
		if (input instanceof Notifier) {
			notifier = (Notifier)input;
		} else if (input instanceof Adapter) {
			notifier = ((Adapter)input).getTarget();
		} else {
			notifier = null;
		}
		if (notifier != null) {
			List<Adapter> eAdapters = notifier.eAdapters();
			Adapter groupProvider = EcoreUtil.getAdapter(eAdapters, IDifferenceGroupProvider.class);
			if (provider != groupProvider) {
				throw new IllegalStateException();
			}
			eAdapters.remove(provider);
		}
		for (IDifferenceGroupProvider registeredGroupProvider : registeredGroupProviders) {
			registeredGroupProvider.dispose();
		}
		viewers.remove(viewer);
	}
}
