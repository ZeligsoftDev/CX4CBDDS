/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.preferences;

/**
 * Defines specific preference constants for papyrus navigator.
 *
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface INavigatorPreferenceConstants {

	/**
	 * the preference for displaying the warning popup when element will be
	 * transform into another one
	 */
	public static final String PREF_NAVIGATOR_TRANSFORM_INTO_SHOW_POPUP = "org.eclipse.papyrus.navigator.TransformInto.showPopupDialog"; //$NON-NLS-1$
	
	/**
	 * If this preferences is set to true. Then the model explorer will expand node on double click.
	 * @since 3.0
	 */
	public static final String PREF_EXPAND_NODE_ON_DOUBLE_CLICK = "org.eclipse.papyrus.modelexplorer.ModelExplorerView.expandOnDoubleClick"; //$NON-NLS-1$
}
