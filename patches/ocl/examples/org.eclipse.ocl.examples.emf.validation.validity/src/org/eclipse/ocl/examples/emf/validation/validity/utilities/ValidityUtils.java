/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;

public class ValidityUtils
{
	/**
	 * Return all enabled result constraining nodes at and below constrainingNode.
	 */
	public static @NonNull List<ResultConstrainingNode> getEnabledResultConstrainingNodes(@NonNull ConstrainingNode constrainingNode) {
		List<ResultConstrainingNode> resultConstrainingNodes = new ArrayList<ResultConstrainingNode>();
		if (constrainingNode instanceof ResultConstrainingNode) {
			ResultConstrainingNode resultConstrainingNode = (ResultConstrainingNode) constrainingNode;
			if (resultConstrainingNode.isEnabled()) {
				resultConstrainingNodes.add(resultConstrainingNode);
			}
		}
		for (TreeIterator<EObject> tit = constrainingNode.eAllContents(); tit.hasNext(); ) {
			Object eObject = tit.next();
			if (eObject instanceof ResultConstrainingNode) {
				ResultConstrainingNode resultConstrainingNode = (ResultConstrainingNode) eObject;
				if (resultConstrainingNode.isEnabled()) {
					resultConstrainingNodes.add(resultConstrainingNode);
				}
			}
		}
		return resultConstrainingNodes;
	}

	/**
	 * Return all enabled result validatable nodes at and below validatableNode.
	 */
	public static @NonNull List<ResultValidatableNode> getEnabledResultValidatableNodes(@NonNull ValidatableNode validatableNode) {
		List<ResultValidatableNode> resultValidatableNodes = new ArrayList<ResultValidatableNode>();
		if (validatableNode instanceof ResultValidatableNode) {
			ResultValidatableNode resultValidatableNode = (ResultValidatableNode) validatableNode;
			if (resultValidatableNode.isEnabled()) {
				resultValidatableNodes.add(resultValidatableNode);
			}
		}
		for (TreeIterator<EObject> tit = validatableNode.eAllContents(); tit.hasNext(); ) {
			Object eObject = tit.next();
			if (eObject instanceof ResultValidatableNode) {
				ResultValidatableNode resultValidatableNode = (ResultValidatableNode) eObject;
				if (resultValidatableNode.isEnabled()) {
					resultValidatableNodes.add(resultValidatableNode);
				}
			}
		}
		return resultValidatableNodes;
	}
}
