/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Element;

public abstract class CallExpStepper extends PostStepper
{
/*	public @NonNull UnitLocation createUnitLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
		INode startNode = null;
		INode endNode = null;
		ModelElementCS csStartElement = getCsElement(element);
		if (NavigationUtil.isNavigationInfixExp(csStartElement)) {
			assert csStartElement != null;
			ModelElementCS csEndElement = ((InfixExpCS)csStartElement).getArgument();
			if (csEndElement != null) {
				startNode = NodeModelUtils.getNode(csStartElement);
				endNode = NodeModelUtils.getNode(csEndElement);
			}
		}
		else if (csStartElement != null) {
			startNode = NodeModelUtils.getNode(csStartElement);
			endNode = startNode;
		}
		return createUnitLocation(evalEnv, element, startNode, endNode);
	} */

	@Override
	public @Nullable Element getFirstElement(@NonNull Element element) {
		return element instanceof CallExp ? ((CallExp)element).getOwnedSource() : element;
	}
}
