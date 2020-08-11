/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.rsm.tooling.ext.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized messages for the extended ZDL tooling plug-in.
 *
 * @author Christian W. Damus (Zeligsoft)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.ddk.zdl.rsm.tooling.ext.l10n.messages"; //$NON-NLS-1$

	public static String AddCommentAdvice_label;

	public static String ConfigureDomainConstraintAdvice_descPrefix;

	public static String ConfigureDomainConstraintAdvice_dfltProject;

	public static String ConfigureDomainConstraintAdvice_label;

	public static String ConfigureDomainConstraintAdvice_mesgPrefix;
	
	public static String SetEndVisibilityAdvice_label;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
