/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.ui.providers;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.service.ITraversalStrategy;

public class DDS4CCMTraversalStrategy implements ITraversalStrategy {

	private TreeIterator<EObject> itor = null;
	private IProgressMonitor monitor;

	@Override
	public void startTraversal(Collection<? extends EObject> traversalRoots, IProgressMonitor monitor) {

		this.itor = EcoreUtil.getAllContents(traversalRoots);
		this.monitor = monitor;

	}

	@Override
	public boolean hasNext() {
		return itor.hasNext();
	}

	@Override
	public EObject next() {
		return itor.next();
	}

	@Override
	public boolean isClientContextChanged() {
		return false;
	}

	@Override
	public void elementValidated(EObject element, IStatus status) {
		monitor.worked(1);
	}

}
