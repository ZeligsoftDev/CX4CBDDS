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
package com.zeligsoft.cx.preferences;

/**
 * IPereference constants
 * 
 * @author ysroh
 * 
 */
public final class CXPreferenceConstants {

	private CXPreferenceConstants() {
		super();
	}

	// Preference identifier for IDL comment generation
	public static final String GENERATE_IDL_COMMENT = "generate_idl_comment"; //$NON-NLS-1$
	
	public static final boolean GENERATE_IDL_COMMENT_DEFAULT = false;
	
	// Preference identifier for CDT project name suffix
	public static final String CDT_PROJECT_SUFFIX = "cdt_suffix"; //$NON-NLS-1$

	// Default value
	public static final String DEFAULT_CDT_PROJECT_SUFFIX = "_generatedSRC"; //$NON-NLS-1$	

	// Preference identifies for user's source code comments
	public static final String GENERATED_FILE_COMMENT = "generated_file_comment"; //$NON-NLS-1$

	// Default user's source code comments
	public static final String DEFAULT_GENERATED_FILE_COMMENT = ""; //$NON-NLS-1$
	
	// Preference identifier for PostFix
	public static final String PREFERENCE_PORTTYPE_SUFFIX = "suffix"; //$NON-NLS-1$

	// Default value
	public static final String DEFAULT_PREFERENCE_PORTTYPE_SUFFIX = "Inv"; //$NON-NLS-1$	

	// Preference identifier for make location
	public static final String MAKE_LOCATION = "make"; //$NON-NLS-1$

	// Default value
	public static String DEFAULT_MAKE_LOCATION = ""; //$NON-NLS-1$

	// Preference identifier for component interface post-fix
	public static final String COMPONENT_INTERFACE_SUFFIX = "component_interface_suffix"; //$NON-NLS-1$

	// Default value
	public static final String DEFAULT_COMPONENT_INTERFACE_SUFFIX = "Interface"; //$NON-NLS-1$

	// Preference identifier for implementation post-fix
	public static final String IMPLEMENTATION_SUFFIX = "implementation_suffix"; //$NON-NLS-1$

	// Default value
	public static final String DEFAULT_IMPLEMENTATION_SUFFIX = "Impl"; //$NON-NLS-1$

	// Preference identifier for package post-fix
	public static final String PACKAGE_SUFFIX = "package_suffix"; //$NON-NLS-1$

	// Default value
	public static final String DEFAULT_PACKAGE_SUFFIX = ""; //$NON-NLS-1$

	// Preference identifier for package post-fix
	public static final String DIAGRAM_SUFFIX = "diagram_suffix"; //$NON-NLS-1$

	// Default value
	public static final String DEFAULT_DIAGRAM_SUFFIX = ""; //$NON-NLS-1$

	// Preference identifier for auto create component interface option
	public static final String AUTO_CREATE_COMPONENT_INTERFACE = "auto_create_CI"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_AUTO_CREATE_COMPONENT_INTERFACE = true;

	// Preference identifier for auto create implementation option
	public static final String AUTO_CREATE_IMPLEMENTATION = "auto_create_implementation"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_AUTO_CREATE_IMPLEMENTATION = true;

	// Preference identifier for auto create package option
	public static final String AUTO_CREATE_PACKAGE = "auto_create_package"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_AUTO_CREATE_PACKAGE = true;

	// Preference identifier for auto create diagram option
	public static final String AUTO_CREATE_DIAGRAM = "auto_create_diagram"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_AUTO_CREATE_DIAGRAM = true;

	// Preference identifier for use default check box
	public static final String USE_DEFAULT_CI_SUFFIX = "use_default_ci_suffix"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_USE_DEFAULT_CI_SUFFIX = true;

	// Preference identifier for use default check box
	public static final String USE_DEFAULT_IMPL_SUFFIX = "use_default_impl_suffix"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_USE_DEFAULT_IMPL_SUFFIX = true;

	// Preference identifier for use default check box
	public static final String USE_DEFAULT_PKG_SUFFIX = "use_default_pkg_suffix"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_USE_DEFAULT_PKG_SUFFIX = true;

	// Preference identifier for use default check box
	public static final String USE_DEFAULT_DIAG_SUFFIX = "use_default_diag_suffix"; //$NON-NLS-1$

	// Default value
	public static final Boolean DEFAULT_USE_DEFAULT_DIAG_SUFFIX = true;
	
	// search workspace preference from the selection dialog
	public static final String SEARCH_WORKSPACE = "search_workspace"; //$NON-NLS-1$

	public static final boolean DEFAULT_SEARCH_WORKSPACE = false;

	// search workspace preference from the selection dialog
	public static final String SEARCH_PROJECT = "search_project"; //$NON-NLS-1$

	public static final boolean DEFAULT_SEARCH_PROJECT = false;
	
	// search workspace preference from the selection dialog
	public static final String SOURCE_DPI = "source_dpi"; //$NON-NLS-1$

	public static final String FILE_COLLECTOR_FILES_ADDED = "file_collector_files_added"; //$NON-NLS-1$

	public static final boolean FILE_COLLECTOR_FILES_ADDED_DEFAULT = true;

	public static final String FILE_COLLECTOR_FILES_CHANGED = "file_collector_files_changed"; //$NON-NLS-1$

	public static final boolean FILE_COLLECTOR_FILES_CHANGED_DEFAULT = true;

	public static final String FILE_COLLECTOR_FILES_REMOVED = "file_collector_files_removed"; //$NON-NLS-1$

	public static final boolean FILE_COLLECTOR_FILES_REMOVED_DEFAULT = true;

	public static final String FILE_COLLECTOR_FILES_UNCHANGED = "file_collector_files_unchanged"; //$NON-NLS-1$

	public static final boolean FILE_COLLECTOR_FILES_UNCHANGED_DEFAULT = false;

	public static final String FILE_COLLECTOR_FILES_BEFORE = "file_collector_files_before"; //$NON-NLS-1$

	public static final boolean FILE_COLLECTOR_FILES_BEFORE_DEFAULT = false;

	public static final String FILE_COLLECTOR_FILES_AFTER = "file_collector_files_after"; //$NON-NLS-1$

	public static final boolean FILE_COLLECTOR_FILES_AFTER_DEFAULT = false;
	
}
