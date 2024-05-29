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
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups;

import static com.google.common.collect.Lists.newArrayListWithCapacity;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.emf.edit.tree.TreePackage;

/**
 * Abstract implementation of {@link IDifferenceGroupProvider}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public abstract class AbstractDifferenceGroupProvider extends AdapterImpl implements IDifferenceGroupProvider2 {

	/** The cross reference adapter used by the difference group provider. */
	private final ECrossReferenceAdapter crossReferenceAdapter;

	/**
	 * A human-readable label for this group provider. This will be displayed in the EMF Compare UI.
	 * 
	 * @since 4.1
	 */
	protected String label;

	/**
	 * The initial activation state of the group provider.
	 * 
	 * @since 4.1
	 */
	protected boolean activeByDefault;

	/**
	 * Groups held by this {@link IDifferenceGroupProvider}.
	 */
	private Collection<? extends IDifferenceGroup> groups;

	private Comparison comparison;

	/**
	 * Default constructor.
	 */
	public AbstractDifferenceGroupProvider() {
		crossReferenceAdapter = new ECrossReferenceAdapter() {
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.ecore.util.ECrossReferenceAdapter#isIncluded(org.eclipse.emf.ecore.EReference)
			 */
			@Override
			protected boolean isIncluded(EReference eReference) {
				return eReference == TreePackage.Literals.TREE_NODE__DATA;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#getLabel()
	 * @since 4.1
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#setLabel(java.lang.String)
	 * @since 4.1
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#defaultSelected()
	 * @since 4.1
	 */
	public boolean defaultSelected() {
		return activeByDefault;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#setDefaultSelected(boolean)
	 * @since 4.1
	 */
	public void setDefaultSelected(boolean active) {
		this.activeByDefault = active;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#isEnabled(org
	 *      .eclipse.emf.compare.scope.IComparisonScope, org.eclipse.emf.compare.Comparison)
	 * @since 4.1
	 */
	public boolean isEnabled(IComparisonScope scope, Comparison comparison) {
		return true;
	}

	/**
	 * Returns the cross reference adapter used by this difference group provider.
	 * 
	 * @return the crossReferenceAdapter the cross reference adapter used by this difference group provider.
	 */
	protected final ECrossReferenceAdapter getCrossReferenceAdapter() {
		return crossReferenceAdapter;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#getTreeNodes(java.lang.Object)
	 */
	public List<TreeNode> getTreeNodes(EObject eObject) {
		Collection<Setting> inverseReferences = crossReferenceAdapter
				.getNonNavigableInverseReferences(eObject);
		List<TreeNode> ret = newArrayListWithCapacity(inverseReferences.size());
		for (Setting setting : inverseReferences) {
			ret.add((TreeNode)setting.getEObject());
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == IDifferenceGroupProvider.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#getGroups(org.eclipse.emf.compare.Comparison)
	 * @since 4.1
	 */
	public Collection<? extends IDifferenceGroup> getGroups(Comparison aComparison) {
		if (!groupsAreBuilt() || comparison != aComparison) {
			dispose();
			this.comparison = aComparison;
			groups = buildGroups(comparison);
		}
		return groups;
	}

	/**
	 * Builds the groups for this comparison. The framework expects that all groups are fully initialized (
	 * their sub tree should be built). Extending {@link IDifferenceGroupProvider2} needs to override this
	 * method to provid groups.
	 * 
	 * @param aComparison
	 *            comparison against which the groups will be built.
	 * @return Newly built collections of {@link IDifferenceGroup}.
	 * @since 4.1
	 */
	protected Collection<? extends IDifferenceGroup> buildGroups(Comparison aComparison) {
		return ImmutableList.of();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider2#groupsAreBuilt()
	 * @since 4.1
	 */
	public boolean groupsAreBuilt() {
		return groups != null && comparison != null;
	}

	/**
	 * @return comparison against which the groups has been built.
	 * @since 4.1
	 */
	protected Comparison getComparison() {
		return comparison;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider#dispose()
	 * @since 4.1
	 */
	public void dispose() {
		comparison = null;
		if (groups != null) {
			for (IDifferenceGroup group : groups) {
				group.dispose();
			}
			groups = null;
		}

	}
}
