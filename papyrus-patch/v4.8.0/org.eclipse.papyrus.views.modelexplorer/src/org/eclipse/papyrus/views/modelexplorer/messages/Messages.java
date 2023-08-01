/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Messages class for the plugin org.eclipse.papyrus.views.modelexplorer.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.views.modelexplorer.messages.messages"; //$NON-NLS-1$

	public static String RenameLabelCommand_DialogMessage;

	static {
		// Initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
