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
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.provider.EMFCompareEditPlugin;
import org.eclipse.emf.compare.provider.IItemDescriptionProvider;
import org.eclipse.emf.compare.provider.IItemStyledLabelProvider;
import org.eclipse.emf.compare.provider.spec.OverlayImageProvider;
import org.eclipse.emf.compare.provider.utils.IStyledString.IComposedStyledString;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroup;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * An specific {@link ItemProviderAdapter} for groups.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class GroupItemProviderAdapter extends ItemProviderAdapter implements IEditingDomainItemProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider, IItemStyledLabelProvider, IItemDescriptionProvider {

	/** The parent object. */
	private EObject parent;

	/** The group for which we want the item provider. */
	private IDifferenceGroup group;

	/** The overlay provider for the group. */
	private OverlayImageProvider overlayProvider;

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory} needed to create the GroupItemProviderAdapter.
	 * @param parent
	 *            the parent object of the group.
	 * @param group
	 *            the IDifferenceGroup that will be used as item provider.
	 */
	public GroupItemProviderAdapter(AdapterFactory adapterFactory, EObject parent, IDifferenceGroup group) {
		super(adapterFactory);
		this.parent = parent;
		this.group = group;
		this.overlayProvider = new OverlayImageProvider(EMFCompareEditPlugin.INSTANCE);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.provider.IItemDescriptionProvider#getDescription(java.lang.Object)
	 */
	public String getDescription(Object object) {
		return group.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getImage(java.lang.Object)
	 */
	@Override
	public Object getImage(Object object) {
		return overlayProvider.getComposedImage(object, group.getImage());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		return group.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.provider.IItemStyledLabelProvider#getStyledText(java.lang.Object)
	 */
	@Override
	public IComposedStyledString getStyledText(Object object) {
		return group.getStyledName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object object) {
		return parent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object object) {
		return !group.getChildren().isEmpty();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildren(java.lang.Object)
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		List<? extends TreeNode> children = group.getChildren();
		for (TreeNode child : children) {
			Adapter groupItemProvider = EcoreUtil.getExistingAdapter(child, GroupItemProviderAdapter.class);
			if (groupItemProvider == null) {
				// store the parent for later retrieval
				child.eAdapters().add(this);
			}
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == GroupItemProviderAdapter.class;
	}

}
