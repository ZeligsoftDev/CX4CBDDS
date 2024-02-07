/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;

public abstract class AbstractNodeContentProvider implements ITreeContentProvider
{
	public static final @NonNull Object @NonNull [] NO_OBJECTS = new @NonNull Object[0];

	private final @NonNull ValidityManager validityManager;

	public AbstractNodeContentProvider(@NonNull ValidityManager validityManager) {
		this.validityManager = validityManager;
	}

	@Override
	public void dispose() {}

	@Override
	public Object[] getElements(Object inputElement) {
		RootNode rootNode = validityManager.getRootNode();
		if (rootNode == null) {
			return NO_OBJECTS;
		}
		List<@NonNull ? extends AbstractNode> validatableNodes = getRootNodes(rootNode);
		List<@NonNull AbstractNode> visibleNodes = new ArrayList<>(validatableNodes.size());
		for (@NonNull AbstractNode node : validatableNodes) {
			if (node.isVisible()) {
				visibleNodes.add(node);
			}
		}
		return visibleNodes.toArray(new Object[visibleNodes.size()]);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return ((AbstractNode)parentElement).getVisibleChildren();
	}

	@Override
	public Object getParent(Object element) {
		return ((AbstractNode)element).getParent();
	}

	protected abstract @NonNull List<@NonNull ? extends AbstractNode> getRootNodes(@NonNull RootNode rootNode);

	@Override
	public boolean hasChildren(Object element) {
		AbstractNode[] validatableNodes = ((AbstractNode)element).getVisibleChildren();
		return validatableNodes.length > 0;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
}
