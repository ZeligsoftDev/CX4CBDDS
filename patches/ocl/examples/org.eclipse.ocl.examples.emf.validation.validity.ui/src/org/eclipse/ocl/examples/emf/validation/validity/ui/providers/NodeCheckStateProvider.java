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

import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;

public class NodeCheckStateProvider implements ICheckStateProvider
{
	public boolean isChecked(Object element) {
		AbstractNode node = (AbstractNode) element;
		return node.isEnabled();
	}

	public boolean isGrayed(Object element) {
		AbstractNode node = (AbstractNode) element;
		return node.isGrayed();
	}
}
