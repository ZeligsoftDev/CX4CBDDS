/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal.accessorfactory;

import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl.AbstractAccessorFactory;
import org.eclipse.papyrus.compare.diagram.ide.ui.internal.context.PapyrusContextUtil;

/**
 * Returns a special PapyrusAccessor when the comparison took place in a Papyrus context, otherwise the call
 * is delegated to a the normal CompareAccessorFactories.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
@SuppressWarnings("restriction")
public class PapyrusAccessorFactoryWrapper extends AbstractAccessorFactory {

	/**
	 * The types for which we return a special Papyrus CompareAccessor.
	 */
	private static final Set<String> OVERRIDE_TYPES = Sets.newHashSet(
			"org.eclipse.emf.compare.rcp.ui.eTreeDiff", "org.eclipse.emf.compare.rcp.ui.eMatch", //$NON-NLS-1$ //$NON-NLS-2$
			"org.eclipse.emf.compare.rcp.ui.eResourceDiff", "NODE_TYPE__EMF_EOBJECT", //$NON-NLS-1$ //$NON-NLS-2$
			"NODE_TYPE__EMF_RESOURCE", "NODE_TYPE__EMF_RESOURCESET", "NODE_TYPE__EMF_COMPARISON"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	/**
	 * {@inheritDoc}
	 */
	public boolean isFactoryFor(Object target) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		final IAccessorFactory highestRankingFactory = getHighestRankingFactory(target);
		if (highestRankingFactory != null) {
			final ITypedElement left = highestRankingFactory.createLeft(adapterFactory, target);
			return wrapIfNecessary(left);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ITypedElement createRight(AdapterFactory adapterFactory, Object target) {
		final IAccessorFactory highestRankingFactory = getHighestRankingFactory(target);
		if (highestRankingFactory != null) {
			final ITypedElement right = highestRankingFactory.createRight(adapterFactory, target);
			return wrapIfNecessary(right);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ITypedElement createAncestor(AdapterFactory adapterFactory, Object target) {
		final IAccessorFactory highestRankingFactory = getHighestRankingFactory(target);
		if (highestRankingFactory != null) {
			final ITypedElement ancestor = highestRankingFactory.createAncestor(adapterFactory, target);
			return wrapIfNecessary(ancestor);
		}
		return null;
	}

	/**
	 * Checks the given {@link ITypedElement} and wraps it in a PapyrusAccessor if needed.
	 * 
	 * @param element
	 *            the {@linked ITypedElement} to check.
	 * @return the wrapped {@code element} if a PapyrusAccessor is needed, the original {@code element}
	 *         otherwise.
	 */
	private ITypedElement wrapIfNecessary(ITypedElement element) {
		if (element instanceof ICompareAccessor) {
			final ICompareAccessor accessor = (ICompareAccessor)element;
			if (PapyrusContextUtil.isPapyrusContext(accessor.getComparison())
					&& isOverrideType(element.getType())) {
				return new PapyrusAccessorWrapper(accessor);
			}
		}
		return element;
	}

	/**
	 * Determines whether the given type is one of the types we override in a Papyrus context.
	 * 
	 * @param type
	 *            the type to check.
	 * @return {@code true} if the type is one of the types we override, {@code false} otherwise.
	 */
	private boolean isOverrideType(String type) {
		return OVERRIDE_TYPES.contains(type);
	}

	/**
	 * Searches the highest ranking factory for the given target, disregarding {@code this} factory itself.
	 * 
	 * @param target
	 *            the target for which the highest ranking factory is to be determined.
	 * @return the highest ranking factory which is not this class itself, {@code null} if no other factory
	 *         could be determined.
	 */
	private IAccessorFactory getHighestRankingFactory(Object target) {
		IAccessorFactory.Registry factoryRegistry = EMFCompareRCPUIPlugin.getDefault()
				.getAccessorFactoryRegistry();

		Iterator<IAccessorFactory> factories = factoryRegistry.getFactories(target).iterator();

		IAccessorFactory ret = null;

		while (factories.hasNext()) {
			IAccessorFactory factory = factories.next();

			// Temporary fix for Bug 543707 (https://bugs.eclipse.org/bugs/show_bug.cgi?id=543707)
			// Can be removed once Bug 543707 is resolved
			if (factory.getClass().getName().equals(
					"org.eclipse.emf.compare.diagram.ide.ui.sirius.internal.SiriusDiffAccessorFactory") //$NON-NLS-1$
					|| factory.getClass().getName().equals(
							"org.eclipse.emf.compare.diagram.ide.ui.sirius.internal.SiriusMatchAccessorFactory")) { //$NON-NLS-1$
				continue;
			}

			// Do not use this or another higher ranking factory to avoid endless loops
			if (factory.getRanking() >= this.getRanking()) {
				continue;
			}
			if (ret == null || factory.getRanking() > ret.getRanking()) {
				ret = factory;
			}
		}

		return ret;
	}

}
