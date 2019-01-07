/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.zeligsoft.ce.domainregistration.l10n;

import org.eclipse.osgi.util.NLS;
/**
 * 
 * @author ysroh
 *
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.ce.domainregistration.l10n.messages"; //$NON-NLS-1$

	public static String DomainRegistry_DomainLogMessage;

	public static String DomainRegistry_DomainLogEndMessage;
	
	public static String DomainRegistry_PartLogMessage;
	
	public static String DomainRegistry_UMLLibraryError;

	public static String DomainRegistry_UMLLibraryErrorMessage;
	
	public static String DomainRegistry_UMLLibraryLoadErrorMessage;

	public static String DomainRegistry_UMLProfileError;

	public static String DomainRegistry_UMLProfileErrorMessage;

	public static String DomainRegistry_UMLProfileLoadErrorMessage;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
