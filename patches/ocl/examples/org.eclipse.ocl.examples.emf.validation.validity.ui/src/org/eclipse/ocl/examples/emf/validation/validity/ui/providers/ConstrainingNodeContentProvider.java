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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class ConstrainingNodeContentProvider extends AbstractNodeContentProvider
{
	public ConstrainingNodeContentProvider(@NonNull ValidityManager validityManager) {
		super(validityManager);
	}

	@Override
	protected @NonNull List<@NonNull RootConstrainingNode> getRootNodes(@NonNull RootNode rootNode) {
		return ClassUtil.nullFree(rootNode.getConstrainingNodes());
	}
}
