/*******************************************************************************
 * Copyright (c) 2015 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Philip Langer - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;

/**
 * A strategy for updating the model with changes made from within a content merge viewer.
 * 
 * @author Philip Langer <planger@eclipsesource.com>
 */
public interface IModelUpdateStrategy {

	/**
	 * Specifies whether the value in the model can to be updated on the given {@code side}.
	 * 
	 * @param diff
	 *            The diff acting as context of the potential model update.
	 * @param side
	 *            The side to check.
	 * @return <code>true</code> if the value can be updated, <code>false</code> otherwise.
	 */
	public boolean canUpdate(Diff diff, MergeViewerSide side);

	/**
	 * Returns a command for updating the underlying model with the given {@code newValue} on the given
	 * {@code side}.
	 * 
	 * @param diff
	 *            The diff acting as context of the model update.
	 * @param newValue
	 *            The new value to be set.
	 * @param side
	 *            The side on which the update is to be performed.
	 * @return A command to perform the model update.
	 */
	public Command getModelUpdateCommand(Diff diff, Object newValue, MergeViewerSide side);

}
