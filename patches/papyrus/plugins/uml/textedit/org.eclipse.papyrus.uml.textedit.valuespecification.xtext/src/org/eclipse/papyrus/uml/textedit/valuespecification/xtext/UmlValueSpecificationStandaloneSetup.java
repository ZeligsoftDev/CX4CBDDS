/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext;


/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class UmlValueSpecificationStandaloneSetup extends UmlValueSpecificationStandaloneSetupGenerated {

	public static void doSetup() {
		new UmlValueSpecificationStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
