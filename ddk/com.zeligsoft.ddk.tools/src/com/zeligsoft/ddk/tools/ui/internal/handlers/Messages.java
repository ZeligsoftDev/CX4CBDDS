/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.ddk.tools.ui.internal.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.zeligsoft.ddk.tools.ui.internal.handlers.messages"; //$NON-NLS-1$
	public static String AbsorbMergedPackagesHandler_DialogTitle;
	public static String AbsorbMergedPackagesWorker_NoPackageMergesFound;
	public static String AbsorbMergedPackagesWorker_NotIStructureSelection;
	public static String AbsorbMergedPackagesWorker_NotSize1Selection;
	public static String AbsorbMergedPackagesWorker_RootElementNotPackage;
	public static String AbsorbMergedPackagesWorker_SelectionNotAFile;
	public static String AbsorbMergedPackagesWorker_SelectionNotUmlFile;
	public static String AbsorbMergedPackagesWorker_SelectionRequirements;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
