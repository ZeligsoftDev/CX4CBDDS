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
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * Instances of this class will be used by EMF Compare in order to provide difference grouping facilities to
 * the structural differences view.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public interface IDifferenceGroupProvider extends Adapter {

	/**
	 * This will be called internally by the grouping actions in order to determine how the differences should
	 * be grouped in the structural view.
	 * 
	 * @param comparison
	 *            The comparison which is to be displayed in the structural view. By default, its containment
	 *            tree will be displayed.
	 * @return The collection of difference groups that are to be displayed in the structural viewer. An empty
	 *         group will not be displayed at all. If {@code null}, we'll fall back to the default behavior.
	 */
	Collection<? extends IDifferenceGroup> getGroups(Comparison comparison);

	/**
	 * Returns the activation condition based on the scope and comparison objects.
	 * 
	 * @param scope
	 *            The scope on which the group provider will be applied.
	 * @param comparison
	 *            The comparison which is to be displayed in the structural view.
	 * @return The activation condition based on the scope and comparison objects.
	 */
	boolean isEnabled(IComparisonScope scope, Comparison comparison);

	/**
	 * Dispose this difference group provider.
	 */
	void dispose();

	/**
	 * Returns all {@link TreeNode}s that are wrapping the given {@code eObject}. It internally use a cross
	 * reference adapter.
	 * 
	 * @param eObject
	 *            the object from which we want inverse reference.
	 * @return all {@link TreeNode}s targeting the given {@code eObject} through
	 *         {@link org.eclipse.emf.edit.tree.TreePackage.Literals#TREE_NODE__DATA}.
	 */
	List<TreeNode> getTreeNodes(EObject eObject);

	/**
	 * A descriptor that can create adifference group provider. They are used as the values in a
	 * {@link IDifferenceGroupProvider.Descriptor.Registry registry}.
	 * 
	 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
	 */
	interface Descriptor {

		/**
		 * Creates a group provider.
		 * 
		 * @return the newly created group provider or null if error.
		 */
		IDifferenceGroupProvider createGroupProvider();

		/**
		 * A human-readable label for this group. This will be displayed in the EMF Compare UI.
		 * 
		 * @return The label for this group.
		 */
		public String getLabel();

		/**
		 * A human-readable description for this group. This will be displayed in EMF Compare UI.
		 * 
		 * @return
		 */
		public String getDescription();

		/**
		 * Rank of this group. The highest rank enabled {@link IDifferenceGroupProvider} will be used as
		 * default group provider.
		 * 
		 * @return the rank.
		 */
		public int getRank();

		/**
		 * Return the type of Comparison this group provider can handle.
		 * 
		 * @return {@link ComparisonType}
		 */
		public ComparisonType getType();

		/**
		 * A registry of {@link IDifferenceGroupProvider}.
		 */
		interface Registry {
			/**
			 * Returns the list of {@link IDifferenceGroupProvider} contained in the registry.
			 * 
			 * @param scope
			 *            The scope on which the group providers will be applied.
			 * @param comparison
			 *            The comparison which is to be displayed in the structural view.
			 * @return The list of {@link IDifferenceGroupProvider} contained in the registry.
			 */
			Collection<IDifferenceGroupProvider.Descriptor> getGroupProviders(IComparisonScope scope,
					Comparison comparison);

			/**
			 * Returns the default group provider.
			 * 
			 * @param scope
			 *            The scope on which the group providers will be applied.
			 * @param comparison
			 *            The comparison which is to be displayed in the structural view.
			 * @return the default group provider or null if none.
			 */
			IDifferenceGroupProvider.Descriptor getDefaultGroupProvider(IComparisonScope scope,
					Comparison comparison);

			/**
			 * Add to the registry the given {@link IDifferenceGroupProvider}.
			 * 
			 * @param provider
			 *            The given {@link IDifferenceGroupProvider}.
			 * @param className
			 *            The class name of the given provider.
			 * @return The previous value associated with the class name of the given
			 *         {@link IDifferenceGroupProvider}, or null if there was no entry in the registry for the
			 *         class name.
			 */
			IDifferenceGroupProvider.Descriptor add(IDifferenceGroupProvider.Descriptor provider,
					String className);

			/**
			 * Remove from the registry the {@link IDifferenceGroupProvider} designated by the given
			 * {@link String} .
			 * 
			 * @param className
			 *            The given {@link String} representing a {@link IDifferenceGroupProvider}.
			 * @return The {@link IDifferenceGroupProvider} designated by the given {@link String}.
			 */
			IDifferenceGroupProvider.Descriptor remove(String className);

			/**
			 * Clear the registry.
			 */
			void clear();
		}
	}

	/**
	 * Type of comparison a {@link IDifferenceGroupProvider} can handle.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	public static enum ComparisonType {
		/** Only three way comparison. */
		THREE_WAY, //
		/** Only two way comparison. */
		TWO_WAY, // Two way comparison
		/** Can handle both comparison type. */
		BOTH
	}
}
