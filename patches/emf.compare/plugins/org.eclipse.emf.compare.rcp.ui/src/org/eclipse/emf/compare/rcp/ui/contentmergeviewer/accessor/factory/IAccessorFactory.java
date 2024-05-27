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
package org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;

/**
 * A factory of {@link ITypedElement}s.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public interface IAccessorFactory {

	/**
	 * Checks if the target object is applicable to the factory.
	 * 
	 * @param target
	 *            the object for which we want to know if it is applicable to the factory.
	 * @return true if the object is applicable to the factory, false otherwise.
	 */
	boolean isFactoryFor(Object target);

	/**
	 * The ranking of the factory.
	 * 
	 * @return the ranking of the factory.
	 */
	int getRanking();

	/**
	 * Set the ranking of the factory.
	 * 
	 * @param value
	 *            the ranking value.
	 */
	void setRanking(int value);

	/**
	 * Creates an {@link ITypedElement} from an {@link AdapterFactory} and a given object. This accessor is
	 * specific for the left side of the comparison.
	 * 
	 * @param adapterFactory
	 *            the given adapter factory.
	 * @param target
	 *            the given object.
	 * @return an ITypedElement.
	 */
	ITypedElement createLeft(AdapterFactory adapterFactory, Object target);

	/**
	 * Creates an {@link ITypedElement} from an {@link AdapterFactory} and a given object. This accessor is
	 * specific for the right side of the comparison.
	 * 
	 * @param adapterFactory
	 *            the given adapter factory.
	 * @param target
	 *            the given object.
	 * @return an ITypedElement.
	 */
	ITypedElement createRight(AdapterFactory adapterFactory, Object target);

	/**
	 * Creates an {@link ITypedElement} from an {@link AdapterFactory} and a given object. This accessor is
	 * specific for the ancestor side of the comparison.
	 * 
	 * @param adapterFactory
	 *            the given adapter factory.
	 * @param target
	 *            the given object.
	 * @return an ITypedElement.
	 */
	ITypedElement createAncestor(AdapterFactory adapterFactory, Object target);

	/**
	 * The registry of {@link IAccessorFactory}.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	interface Registry {

		/**
		 * Returns the highest ranking factory available for the given object.
		 * 
		 * @param target
		 *            the given object.
		 * @return the highest ranking factory available for the given object.
		 */
		IAccessorFactory getHighestRankingFactory(Object target);

		/**
		 * Returns all the factories available in the registry for the given object.
		 * 
		 * @param target
		 *            the given object.
		 * @return all the factories available in the registry for the given object.
		 */
		Collection<IAccessorFactory> getFactories(Object target);

		/**
		 * Add the given factory to the registry.
		 * 
		 * @param factory
		 *            the given factory.
		 * @return the given factory.
		 */
		IAccessorFactory add(IAccessorFactory factory);

		/**
		 * Remove the factory represented by the given class name.
		 * 
		 * @param className
		 *            the class name of the factory to removed.
		 * @return the factory removed.
		 */
		IAccessorFactory remove(String className);

		/**
		 * Clear the registry.
		 */
		void clear();
	}

}
