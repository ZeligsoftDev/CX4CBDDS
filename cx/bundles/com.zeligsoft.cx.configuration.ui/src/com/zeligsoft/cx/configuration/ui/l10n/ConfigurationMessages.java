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
package com.zeligsoft.cx.configuration.ui.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * NLS implementation for Configuration messages.
 *  
 * @author jcorchis
 *
 */
public class ConfigurationMessages
		extends NLS {
	
	private ConfigurationMessages() {
		// do not instantiate
	}
	
	
	private static final String BUNDLE_NAME = ConfigurationMessages.class.getName();
	
	
	/**
	 *  Unconfigure command label
	 */ 
	public static String Command_label_UnConfigure;
	
	
	/**
	 * Config command label
	 */
	public static String Command_label_Configure;
	
	/**
	 * Title of the Configuration Selection Dialog
	 */
	public static String Configuration_Dialog_title;
	
	/**
	 * Dialog message for the configuration dialog 
	 */
	public static String Configuration_Dialog_message;
	
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, ConfigurationMessages.class);
	}

}
