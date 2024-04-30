/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer;

import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;

/**
 * Constants used by org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement
 * implementations.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public final class TypeConstants {

	/** Used by accessors displaying diffs as a tree. */
	public static final String TYPE_ETREE_DIFF = EMFCompareRCPUIPlugin.PLUGIN_ID + ".eTreeDiff"; //$NON-NLS-1$

	/** Used by accessors displaying diffs as a list. */
	public static final String TYPE_ELIST_DIFF = EMFCompareRCPUIPlugin.PLUGIN_ID + ".eListDiff"; //$NON-NLS-1$

	/** Used by accessors displaying diffs as text. */
	public static final String TYPE_ETEXT_DIFF = EMFCompareRCPUIPlugin.PLUGIN_ID + ".eTextDiff"; //$NON-NLS-1$

	/** Used by accessors displaying diffs as resource. */
	public static final String TYPE_ERESOURCE_DIFF = EMFCompareRCPUIPlugin.PLUGIN_ID + ".eResourceDiff"; //$NON-NLS-1$

	/** Used by accessors displaying matches. */
	public static final String TYPE_EMATCH = EMFCompareRCPUIPlugin.PLUGIN_ID + ".eMatch"; //$NON-NLS-1$

	/** Used when the comparison failed and we want to fallback to text merge. */
	public static final String TYPE_FALLBACK_TEXT = EMFCompareRCPUIPlugin.PLUGIN_ID + ".fallbackText"; //$NON-NLS-1$

	/**
	 * Private constructor.
	 */
	private TypeConstants() {
	}
}
