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

package com.prismtech.domain.sca.ppls.editor.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author mciobanu
 */

public class Messages
		extends NLS {
	
	private static final String BUNDLE_NAME = Messages.class.getName();
	
	public static String VPToCPMappingTreeView_configuration_point;
	
	public static String VPToCPMappingTreeView_configuration_point_configuration;
	
	public static String VPToCPMappingTreeView_configuration_point_property;
	
	public static String VPToCPMappingTreeView_configuration_point_value;
	
	public static String VPToCPMappingTreeView_configuration_point_value_empty;
	
	public static String VPToCPMappingTreeView_configuration_point_generate;
	
	public static String VPToCPMappingTreeView_label;
	
	public static String VPToCPMappingTreeView_search_initial_text;

	private Messages() {
		// Do not instantiate
	}
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
