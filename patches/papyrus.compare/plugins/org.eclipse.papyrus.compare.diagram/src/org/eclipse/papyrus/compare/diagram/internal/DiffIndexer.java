/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import com.google.common.collect.LinkedHashMultimap;

import java.util.Set;

import org.eclipse.emf.compare.Diff;

/**
 * A DiffIndexer allows to store {@link Diff}s by arbitrary keys. It basically wrpas a Multimap, but it could
 * be enriched to index several different kinds of relations between {@link Diff}s.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public class DiffIndexer {

	/** The multimap used to indef Diffs. */
	private final LinkedHashMultimap<Object, Diff> equivalentDiffsByKey;

	/**
	 * Constructor.
	 */
	public DiffIndexer() {
		this.equivalentDiffsByKey = LinkedHashMultimap.create();
	}

	/**
	 * Store a Diff in the index.
	 * 
	 * @param key
	 *            The key to use
	 * @param diff
	 *            The Diff to index
	 */
	public void putEquivalentDiff(Object key, Diff diff) {
		equivalentDiffsByKey.put(key, diff);
	}

	/**
	 * Retrieve all the {@link Diff}s for the given key.
	 * 
	 * @param key
	 *            The key
	 * @return A Set od diffs indexed for the given key, which may be empty but never <code>null</code>.
	 */
	public Set<Diff> getEquivalentDiffs(Object key) {
		return equivalentDiffsByKey.get(key);
	}

	/**
	 * Retrieve all the keys in the index.
	 * 
	 * @return a Set of all the keys contained in this indexer.
	 */
	public Set<Object> getEquivalentDiffsKeySet() {
		return equivalentDiffsByKey.keySet();
	}
}
