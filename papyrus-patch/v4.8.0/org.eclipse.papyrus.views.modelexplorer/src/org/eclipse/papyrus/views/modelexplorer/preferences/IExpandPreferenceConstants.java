/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.preferences;

/**
 * Interface to define preference constants for the expand Action.
 * @since 3.0
 */
public interface IExpandPreferenceConstants {

	/** The max level to expand action preference. */
	public static final String PREF_MAX_LEVEL_TO_EXPAND = "maxLevelToExpand"; //$NON-NLS-1$

	/** The default value of the expand action preference. */
	public static final int DEFAULT_MAX_LEVEL_TO_EXPAND_VALUE = 15;

}
