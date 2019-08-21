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
package com.zeligsoft.domain.omg.ccm.preferences;

/**
 * IPereference constants
 * 
 * @author ysroh
 * 
 */
public final class CCMPreferenceConstants {

	private CCMPreferenceConstants() {
		super();
	}

	public static final String EXPECTED_COMPONENT_SUFFIX = "expected_component_suffix"; //$NON-NLS-1$

	public static final String DEFAULT_EXPECTED_COMPONENT_SUFFIX = "_comp"; //$NON-NLS-1$
	
	public static final String ASSEMBLY_IMPLEMENTATION_SUFFIX = "assembly_suffix"; //$NON-NLS-1$

	public static final String DEFAULT_ASSEMBLY_IMPLEMENTATION_SUFFIX = "_asm"; //$NON-NLS-1$
	
	public static final String MONOLITHIC_IMPLEMENTATION_SUFFIX = "monolithic_suffix"; //$NON-NLS-1$
	
	public static final String DEFAULT_MONOLITHIC_IMPLEMENTATION_SUFFIX = ""; //$NON-NLS-1$

	public static final String IMPLEMENTATION_SUFFIX = "implementation_suffix"; //$NON-NLS-1$

	public static final String DEFAULT_IMPLEMENTATION_SUFFIX = "_impl"; //$NON-NLS-1$

	public static final String PACKAGE_SUFFIX = "package_suffix"; //$NON-NLS-1$

	public static final String DEFAULT_PACKAGE_SUFFIX = ""; //$NON-NLS-1$
	
	public static final String SUBPACKAGE_NAME_CONSTANT= "subpackage_name_constant"; //$NON-NLS-1$
	
	public static final String DEFAULT_SUBPACKAGE_NAME_CONSTANT = "src";  //$NON-NLS-1$

	public static final String DIAGRAM_SUFFIX = "diagram_suffix"; //$NON-NLS-1$

	public static final String DEFAULT_DIAGRAM_SUFFIX = ""; //$NON-NLS-1$
	
	public static final String AUTO_TYPE_SELECTION_DIALOG = "type_selection_dialog"; //$NON-NLS-1$

	public static final Boolean DEFAULT_AUTO_TYPE_SELECTION_DIALOG = false;

}
