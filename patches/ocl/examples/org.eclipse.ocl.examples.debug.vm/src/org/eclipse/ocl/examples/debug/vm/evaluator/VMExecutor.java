/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;

public interface VMExecutor extends ExecutorInternal
{
	Object execute();
	@NonNull NamedElement getDebuggable();
	@NonNull String getPluginId();
	void saveModels();
	void setSuspendOnStartUp(boolean suspendOnStartup);
}
