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
package org.eclipse.ocl.examples.emf.validation.validity.utilities;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;

public class SeveritiesVisibilityFilter implements IVisibilityFilter
{
	private @NonNull Set<Severity> acceptedSeverities = new HashSet<Severity>();

	@Override
	public boolean isVisible(@NonNull AbstractNode element) {
		// if we haven't activated any filtering, then all should be displayed
		if (acceptedSeverities.isEmpty()) {
			return true;
		}
		if (element instanceof AbstractNode) {
			return isAcceptedNode((AbstractNode) element);
		}
		return false;
	}
	
	public void addFilteredSeverity(Severity severity) {
		acceptedSeverities.add(severity);
	}
	
	public boolean removeFilteredSeverity(Severity severity) {
		acceptedSeverities.remove(severity);
		return acceptedSeverities.size() > 0;
	}
	
	private boolean isAcceptedNode(AbstractNode node) {
		Result worstResultForNode = node.getWorstResult();
		if (worstResultForNode != null && acceptedSeverities.contains(worstResultForNode.getSeverity())) {
			return true;
		} else {
			for (AbstractNode child : node.getChildren()) {
				if (isAcceptedNode(child)) {
					return true;
				}
			}
		}
		return false;
	}
}
