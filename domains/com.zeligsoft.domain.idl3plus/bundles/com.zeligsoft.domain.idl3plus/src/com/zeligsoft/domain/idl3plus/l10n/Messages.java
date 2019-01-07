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
package com.zeligsoft.domain.idl3plus.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.domain.idl3plus.l10n.Messages"; //$NON-NLS-1$
	public static String IDL3PlusUtil_Exception_NullModuleToInstantiateParameter;
	public static String IDL3PlusUtil_Exception_TemplateDoesNotHaveSignature;
	public static String IDL3PlusUtil_Exception_NullModuleInstantiateToRepairParameter;
	public static String IDL3PlusUtil_Exception_InvalidModuleInstantiateToRepairParameter;
	public static String InterfaceRealizationKey_ImplementingClassifierNotNull;
	public static String StereotypeApplicationKey_Exception_BaseElementCanNotBeNull;
	public static String StereotypeApplicationKey_Exception_StereotypeCanNotBeNull;
	public static String TemplateBindingKey_Exception_ElementMustHaveAncestor;
	public static String TemplateSignatureKey_Exception_MustHaveAncestor;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
