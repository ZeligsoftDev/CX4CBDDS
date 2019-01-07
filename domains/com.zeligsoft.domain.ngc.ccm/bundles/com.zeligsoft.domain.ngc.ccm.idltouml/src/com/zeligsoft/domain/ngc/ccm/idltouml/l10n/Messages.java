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
package com.zeligsoft.domain.ngc.ccm.idltouml.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.domain.ngc.ccm.idltouml.l10.messages"; //$NON-NLS-1$
	public static String CCM2UMLResolveAll_Error_CantRemapElement;
	public static String CCMPSMUtils_Error_SourcePartOfResource;
	public static String CCMPSMUtils_Error_StandardProfile;
	public static String UMLModelMerge_Error_CantAccessClass;
	public static String UMLModelMerge_Error_CantFindBundle;
	public static String UMLModelMerge_Error_CantFindClass;
	public static String UMLModelMerge_Error_CantInstantiateClass;
	public static String UMLModelMerge_Error_Merging;
	public static String UMLModelMerge_Error_ResourceHasNoPackage;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
