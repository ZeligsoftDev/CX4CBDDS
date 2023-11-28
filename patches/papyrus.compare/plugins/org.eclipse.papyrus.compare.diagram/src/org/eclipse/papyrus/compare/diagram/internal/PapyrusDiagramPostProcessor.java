/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;

/**
 * Post-processor used to manage interactions between papyrus diagrams (*.notation files) and the related UML
 * models (*.uml files).
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public class PapyrusDiagramPostProcessor implements IPostProcessor {

	/**
	 * {@inheritDoc}
	 */
	public void postMatch(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postDiff(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postRequirements(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postEquivalences(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void postConflicts(Comparison comparison, Monitor monitor) {
		// Nothing to do here
	}

	/**
	 * creates links between notation and UML changes when they should be linked.
	 * 
	 * @param comparison
	 *            The comparison
	 * @param monitor
	 *            The progress monitor
	 */
	public void postComparison(Comparison comparison, Monitor monitor) {
		if (monitor == null || !monitor.isCanceled()) {
			new PapyrusDiagramPostComparison(comparison).run();
		}
	}
}
