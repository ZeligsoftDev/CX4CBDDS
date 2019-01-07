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
package com.zeligsoft.base.validation.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized strings for the ZDL Validation Framework.
 *
 * @author Christian W. Damus (cdamus)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.base.validation.l10n.messages"; //$NON-NLS-1$

	public static String ConstraintMetadata_defaultDesc;

	public static String JavaConstraint_classAccess;

	public static String JavaConstraint_instantiation;

	public static String JavaConstraint_noBundle;

	public static String JavaConstraint_noSuchClass;

	public static String LinkConstraintManager_create;

	public static String PreloadRegistry_badConcept;

	public static String PreloadRegistry_badURI;

	public static String ValidationUtil_unknownProvider;

	public static String ZDLConstraintManager_dupeID;

	public static String ZDLConstraintManager_dupeLanguage;

	public static String ZDLConstraintManager_initFailed;

	public static String ZDLConstraintManager_noLanguage;
	
	public static String ZDLMultiplicityConstraint_between;
	
	public static String ZDLMultiplicityConstraint_less;
	
	public static String ZDLMultiplicityConstraint_more;
	
	public static String ZDLMultiplicityConstraint_exact;
	
	public static String ZDLMultiplicityConstraint_required;
	
	public static String multiplicityConstraint_name;
	
	public static String multiplicityConstraint_desc;
	
	public static String OCLLinkConstraint_noBody;

	public static String OCLLinkConstraint_noSource;

	public static String OCLLinkConstraint_noTarget;

	public static String OCLLinkConstraint_parseFailed;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
