/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.extender;

import static com.google.common.collect.Lists.newArrayList;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender.Registry;

/**
 * The default implementation of the {@link Registry}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class DifferenceGroupExtenderRegistryImpl implements Registry {

	/** A map that associates the class name to theirs {@link IDifferenceGroupExtender}s. */
	private final Map<String, IDifferenceGroupExtender> map;

	/**
	 * Constructs the registry.
	 */
	public DifferenceGroupExtenderRegistryImpl() {
		map = new ConcurrentHashMap<String, IDifferenceGroupExtender>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender.Registry#getExtenders()
	 */
	public List<IDifferenceGroupExtender> getExtenders() {
		Iterable<IDifferenceGroupExtender> extenders = map.values();
		List<IDifferenceGroupExtender> ret = newArrayList();
		for (IDifferenceGroupExtender groupExtender : extenders) {
			ret.add(groupExtender);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender.Registry#add
	 *      (org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender)
	 */
	public IDifferenceGroupExtender add(IDifferenceGroupExtender provider) {
		Preconditions.checkNotNull(provider);
		return map.put(provider.getClass().getName(), provider);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender.Registry#remove(java.lang.String)
	 *      )
	 */
	public IDifferenceGroupExtender remove(String className) {
		return map.remove(className);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender
	 *      .Registry#clear()
	 */
	public void clear() {
		map.clear();
	}
}
