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
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory;

/**
 * The default implementation of {@link IAccessorFactory.Registry}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class AccessorFactoryRegistryImpl implements IAccessorFactory.Registry {

	/** A map between IAccessorFactory and their class names. */
	private final Map<String, IAccessorFactory> map;

	/**
	 * Default constructor.
	 */
	public AccessorFactoryRegistryImpl() {
		map = new ConcurrentHashMap<String, IAccessorFactory>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory.Registry#getHighestRankingFactory(java.lang.Object)
	 */
	public IAccessorFactory getHighestRankingFactory(Object target) {
		Iterator<IAccessorFactory> factories = getFactories(target).iterator();

		IAccessorFactory ret = null;

		if (factories.hasNext()) {
			IAccessorFactory highestRanking = factories.next();
			while (factories.hasNext()) {
				IAccessorFactory factory = factories.next();
				if (factory.getRanking() > highestRanking.getRanking()) {
					highestRanking = factory;
				}
			}
			ret = highestRanking;
		}

		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory.Registry#getFactories(java.lang.Object)
	 */
	// safe thanks to the isFactoryFor filter
	public List<IAccessorFactory> getFactories(Object target) {
		Iterable<IAccessorFactory> factories = filter(map.values(), isFactoryFor(target));
		List<IAccessorFactory> ret = newArrayList();
		for (IAccessorFactory factory : factories) {
			ret.add(factory);
		}
		return ret;
	}

	/**
	 * A predicate to know if the factory is applicable to the given object.
	 * 
	 * @param target
	 *            the given object.
	 * @return true, if the factory is applicable to the given object, false otherwise.
	 */
	static final Predicate<IAccessorFactory> isFactoryFor(final Object target) {
		return new Predicate<IAccessorFactory>() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see com.google.common.base.Predicate#apply(java.lang.Object)
			 */
			public boolean apply(IAccessorFactory d) {
				return d.isFactoryFor(target);
			}
		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory.Registry#add(java.lang.Object)
	 */
	public IAccessorFactory add(IAccessorFactory factory) {
		Preconditions.checkNotNull(factory);
		return map.put(factory.getClass().getName(), factory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory.Registry#remove(java.lang.Object)
	 */
	public IAccessorFactory remove(String className) {
		return map.remove(className);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory.Registry#clear()
	 */
	public void clear() {
		map.clear();
	}
}
