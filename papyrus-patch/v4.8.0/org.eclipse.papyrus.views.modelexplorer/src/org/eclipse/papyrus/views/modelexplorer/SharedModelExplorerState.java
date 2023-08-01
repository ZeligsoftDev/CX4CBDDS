/*
 * Copyright (c) 2014 CEA and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.views.modelexplorer;

import java.util.Arrays;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Set;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.ui.IMemento;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;


/**
 * Shared persistent state (especially of tool-bar toggle actions) of the Model Explorer view pages.
 */
class SharedModelExplorerState extends EventManager {

	private static final String LINKING_MEMENTO = "linkWithEditor"; //$NON-NLS-1$

	private static final String ENABLED_ATTR = "enabled"; //$NON-NLS-1$

	private static final String SORTING_MEMENTO = "sorting"; //$NON-NLS-1$

	private static final String ALPHA_SORTED_ATTR = "alphaSorted"; //$NON-NLS-1$

	private boolean linkingEnabled;

	private boolean alphaSorted;

	/** The active content extensions are persisted by the Common Navigator Framework, so we don't have to. */
	private Set<String> navigatorContentExtensions = Sets.newHashSet();

	SharedModelExplorerState() {
		super();
	}

	public void setLinkingEnabled(boolean linkingEnabled) {
		boolean oldValue = this.linkingEnabled;
		this.linkingEnabled = linkingEnabled;

		if (oldValue != linkingEnabled) {
			fireStateChanged(StateChangedEvent.LINKING_ENABLED);
		}
	}

	public boolean isLinkingEnabled() {
		return linkingEnabled;
	}

	public void setAlphaSorted(boolean alphaSorted) {
		boolean oldValue = this.alphaSorted;
		this.alphaSorted = alphaSorted;

		if (oldValue != alphaSorted) {
			fireStateChanged(StateChangedEvent.ALPHA_SORTED);
		}
	}

	public boolean isAlphaSorted() {
		return alphaSorted;
	}

	public void updateNavigatorContentExtensions(String[] contentExtensionIDs, boolean activate) {
		Set<String> oldValue = ImmutableSet.copyOf(this.navigatorContentExtensions);

		if (activate) {
			this.navigatorContentExtensions.addAll(Arrays.asList(contentExtensionIDs));
		} else {
			this.navigatorContentExtensions.removeAll(Arrays.asList(contentExtensionIDs));
		}

		if (!oldValue.equals(this.navigatorContentExtensions)) {
			fireStateChanged(StateChangedEvent.CONTENT_EXTENSIONS);
		}
	}

	public String[] getNavigatorContentExtensions() {
		return Iterables.toArray(navigatorContentExtensions, String.class);
	}

	void load(IMemento memento) {
		readLinking(memento);
		readSorting(memento);
		// Persistence of CNF content extensions is handled by that framework
	}

	public void save(IMemento memento) {
		writeLinking(memento);
		writeSorting(memento);
		// Persistence of CNF content extensions is handled by that framework
	}

	private void readLinking(IMemento memento) {
		IMemento linking = memento.getChild(LINKING_MEMENTO);
		if (linking != null) {
			Boolean enabled = linking.getBoolean(ENABLED_ATTR);
			this.linkingEnabled = (enabled != null) && enabled.booleanValue();
		}
	}

	private void writeLinking(IMemento memento) {
		IMemento linking = memento.getChild(LINKING_MEMENTO);
		if (linking == null) {
			linking = memento.createChild(LINKING_MEMENTO);
		}
		linking.putBoolean(ENABLED_ATTR, isLinkingEnabled());
	}

	private void readSorting(IMemento memento) {
		IMemento sorting = memento.getChild(SORTING_MEMENTO);
		if (sorting != null) {
			Boolean sorted = sorting.getBoolean(ALPHA_SORTED_ATTR);
			this.alphaSorted = (sorted != null) && sorted.booleanValue();
		}
	}

	private void writeSorting(IMemento memento) {
		IMemento sorting = memento.getChild(SORTING_MEMENTO);
		if (sorting == null) {
			sorting = memento.createChild(SORTING_MEMENTO);
		}
		sorting.putBoolean(ALPHA_SORTED_ATTR, isAlphaSorted());
	}

	public void addListener(StateChangedListener listener) {
		addListenerObject(listener);
	}

	public void removeListener(StateChangedListener listener) {
		removeListenerObject(listener);
	}

	void fireStateChanged(int eventType) {
		if (isListenerAttached()) {
			StateChangedEvent event = new StateChangedEvent(this, eventType);
			Object[] listeners = getListeners();
			for (int i = 0; i < listeners.length; i++) {
				try {
					((StateChangedListener) listeners[i]).sharedStateChanged(event);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in shared state listener.", e);
				}
			}
		}
	}

	//
	// Nested types
	//

	static class StateChangedEvent extends EventObject {

		public static final int LINKING_ENABLED = 1;

		public static final int ALPHA_SORTED = 2;

		public static final int CONTENT_EXTENSIONS = 3;

		private static final long serialVersionUID = 1L;

		private final int type;

		StateChangedEvent(SharedModelExplorerState source, int type) {
			super(source);
			this.type = type;
		}

		@Override
		public SharedModelExplorerState getSource() {
			return (SharedModelExplorerState) super.getSource();
		}

		public int getEventType() {
			return type;
		}
	}

	/**
	 * Call-back interface for notification of changes in the shared Model Explorer state.
	 */
	static interface StateChangedListener extends EventListener {

		void sharedStateChanged(StateChangedEvent event);
	}
}
