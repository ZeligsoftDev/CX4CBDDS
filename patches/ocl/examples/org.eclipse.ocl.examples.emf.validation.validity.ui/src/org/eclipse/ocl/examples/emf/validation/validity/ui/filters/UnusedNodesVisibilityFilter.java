/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.filters;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.IVisibilityFilter;

public class UnusedNodesVisibilityFilter implements IVisibilityFilter
{
	@Override
	public boolean isVisible(@NonNull AbstractNode abstractNode) {
		if ((abstractNode instanceof ResultConstrainingNode) || (abstractNode instanceof ResultValidatableNode)) {
			return abstractNode.isEnabled(); //(parent != null) && parent.isEnabled();
		}
		if (abstractNode.isEnabled()) {
			return true;
		}
		for (@SuppressWarnings("null")@NonNull AbstractNode child : abstractNode.getChildren()) {
			if (isUsed(child)) {
				return true;
			}
		}
		return false;
	}

	
	protected boolean isUsed(@NonNull AbstractNode node) {
		if ((node instanceof ResultConstrainingNode) || (node instanceof ResultValidatableNode)) {
			return false;
		}
		for (AbstractNode child : node.getVisibleChildren()) {
			if (child.isEnabled()) {
				return true;
			}
		}
		return false;
	}

}
