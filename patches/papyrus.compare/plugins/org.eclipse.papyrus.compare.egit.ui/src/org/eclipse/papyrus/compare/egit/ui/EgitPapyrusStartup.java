/*
 *  Copyright (c) 2017 Ericsson and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Simon Delisle - initial API and implementation
 */
package org.eclipse.papyrus.compare.egit.ui;

import org.eclipse.ui.IStartup;

/**
 * This class is not supposed to actually do something other than starting this plug-in to ensure that the
 * command org.eclipse.papyrus.compare.egit.ui.internal.actions.ModelMergeTool is available (see plugin.xml).
 */
public class EgitPapyrusStartup implements IStartup {

	@Override
	public void earlyStartup() {
		// Nothing to do
	}

}
