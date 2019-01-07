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
package com.zeligsoft.domain.omg.dds.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages 
	extends NLS {
	private static final String BUNDLE_NAME = Messages.class.getName();
	

	private Messages() {
		// Do not instantiate
	}

	public static String Wizard__Default_Model_name;
	public static String Wizard__NewModelPage_description;
	public static String Wizard__NewModelPage_title;
	public static String Wizard__NewProjectPage_description;
	public static String Wizard__NewProjectPage_title;
	
	public static String 
		CommandLabel_ComponentPartEditHelperAdvice_getAfterCreateCommand;
	public static String 
		CommandLabel_DomainPartEditHelperAdvice_getAfterCreateCommand;
	public static String 
		CommandLabel_DDSConnectorEditHelperAdvice_getAfterCreateCommand;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
