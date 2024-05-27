/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.mergeviewer;

import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.jface.viewers.IInputSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Control;

/**
 * A specific {@link IInputSelectionProvider} for EMF Compare.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public interface IMergeViewer extends IInputSelectionProvider {

	/**
	 * {@inheritDoc}
	 */
	MergeViewerSide getSide();

	/**
	 * Returns the primary control associated with this viewer.
	 * 
	 * @return the SWT control which displays this viewer's content
	 */
	Control getControl();

	/**
	 * Refreshes this viewer completely with information freshly obtained from this viewer's model.
	 */
	void refresh();

	/**
	 * Sets or clears the input for this viewer.
	 * 
	 * @param input
	 *            the input of this viewer, or <code>null</code> if none
	 */
	void setInput(Object input);

	/**
	 * Sets a new selection for this viewer and optionally makes it visible.
	 * <p>
	 * Subclasses must implement this method.
	 * </p>
	 * 
	 * @param selection
	 *            the new selection
	 * @param reveal
	 *            <code>true</code> if the selection is to be made visible, and <code>false</code> otherwise
	 */
	void setSelection(ISelection selection, boolean reveal);

	/**
	 * An enum that represents the side of the viewer and provides utilty methods to manage sides.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	enum MergeViewerSide {

		/** Values: left side, right side, ancestor side. */
		LEFT, RIGHT, ANCESTOR;

		/**
		 * Get the opposite side of this side.
		 * 
		 * @return the opposite side of this side.
		 */
		public MergeViewerSide opposite() {
			final MergeViewerSide opposite;
			switch (this) {
				case LEFT:
					opposite = RIGHT;
					break;
				case RIGHT:
					opposite = LEFT;
					break;
				case ANCESTOR:
					opposite = ANCESTOR;
					break;
				default:
					throw new IllegalStateException(); // happy compiler :)
			}
			return opposite;
		}

		/**
		 * Get the side value from the given {@link DifferenceSource}.
		 * 
		 * @param source
		 *            the given DifferenceSource.
		 * @return the side value from the given DifferenceSource.
		 */
		public static MergeViewerSide getValueFrom(DifferenceSource source) {
			switch (source) {
				case LEFT:
					return LEFT;
				case RIGHT:
					return RIGHT;
				default:
					throw new IllegalStateException();
			}
		}

		/**
		 * Converts this side to DifferenceSource.
		 * 
		 * @return the DifferenceSource equivalent to this side.
		 */
		public DifferenceSource convertToDifferenceSource() {
			switch (this) {
				case LEFT:
					return DifferenceSource.LEFT;
				case RIGHT:
					return DifferenceSource.RIGHT;
				default:
					throw new IllegalStateException();
			}
		}
	}
}
