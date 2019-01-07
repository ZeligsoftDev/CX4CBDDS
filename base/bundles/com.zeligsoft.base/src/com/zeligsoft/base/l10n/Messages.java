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
package com.zeligsoft.base.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized messages for the RSM-oAW plug-in.
 *
 * @author Christian W. Damus (cdamus)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.base.l10n.messages"; //$NON-NLS-1$

	public static String RSMWriter_noModel;

	public static String RSMWriter_saveFailed;
	
	public static String RSMReader_loadFailed;
	
	public static String RSMReader_noResourceSet;

	public static String ModelMerge_mergeSaveFailed;
	
	public static String DefineProfile_noProfile;

	public static String WorkflowUtil_closeFailed;

	public static String WorkflowUtil_exception;

	public static String WorkflowUtil_openFailed;
	
	public static String WorkflowUtil_problems;
	
	public static String Dependency_Graph_Cycle_Detected;
	
	public static String Depends_On;
	
	public static String MoveProjectFailed;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
