/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *	Obeo - Add selection facilities
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;

public class ValidityNodeCheckStateListener implements ICheckStateListener
{
	private final @NonNull ValidityView validityView;	
	
	public ValidityNodeCheckStateListener(@NonNull ValidityView validityView) {
		this.validityView = validityView;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent)
	 */
	public void checkStateChanged(CheckStateChangedEvent event) { 
//		long start = System.currentTimeMillis();
		RootNode rootNode = validityView.getValidityManager().getRootNode();
		assert rootNode != null;
		Object element = event.getElement();
//		System.out.format(Thread.currentThread().getName() + " %3.3f update start\n", (System.currentTimeMillis() - start) * 0.001);
		if (element instanceof AbstractNode) {
			AbstractNode abstractNode = (AbstractNode) element;
			boolean enabled = event.getChecked();
			abstractNode.setEnabled(enabled);
			/*
			 * Propagate the new checked/enabled state of this node to all non-Result children and at the leaves across to the other tree's results.
			 */
			updateEnabledState(abstractNode, enabled);
			/*
			 * Propgation of the corresponding grayed states up is performed as a total traversal during redraw since this ensures that
			 * each node is visited just once, whereas propagating across and up is surprisingly wasteful.
			 */
		}
		validityView.redraw();
//		System.out.format(Thread.currentThread().getName() + " %3.3f redraw end\n", (System.currentTimeMillis() - start) * 0.001);
	}

	/**
	 * Select/Deselect all children nodes and propagates selection to
	 * grand-children nodes.
	 * 
	 * @param abstractNode
	 *            the abstract node.
	 * @param enabled
	 *            true when the node is checked, false otherwise.
	 */
	private void updateEnabledState(@NonNull AbstractNode node, boolean enabled) {
		if (node instanceof ResultValidatableNode) {
			ResultConstrainingNode otherTreeNode = ((ResultValidatableNode) node).getResultConstrainingNode();
			otherTreeNode.setEnabled(enabled);
		} else if (node instanceof ResultConstrainingNode) {
			ResultValidatableNode otherTreeNode = ((ResultConstrainingNode) node).getResultValidatableNode();
			otherTreeNode.setEnabled(enabled);
		}
		else {
			for (AbstractNode child : node.getChildren()) {
				node.setEnabled(enabled);
				if (child != null) {
					updateEnabledState(child, enabled);
				}
			}	
		}
	}
}
