/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.message.xtext;



/**
 * Initialization support for running Xtext languages
 * without equinox extension registry.
 */
public class UmlMessageStandaloneSetup extends UmlMessageStandaloneSetupGenerated {

	/**
	 * Do setup.
	 */
	public static void doSetup() {
		new UmlMessageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
