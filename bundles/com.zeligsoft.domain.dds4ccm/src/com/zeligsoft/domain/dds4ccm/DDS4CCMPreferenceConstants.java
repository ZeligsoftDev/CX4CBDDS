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
package com.zeligsoft.domain.dds4ccm;

/**
 * DDS4CCM preference constants
 * 
 * @author ysroh
 * 
 */
public final class DDS4CCMPreferenceConstants {

	private DDS4CCMPreferenceConstants() {
		super();
	}

	/**
	 * IDL file fixed header
	 */
	public static final String IDL_FIXED_HEADER = "IDL_FIXED_HEADER"; //$NON-NLS-1$

	/**
	 * Default value for IDL file fixed header
	 */
	public static final String DEFAULT_IDL_FIXED_HEADER = ""; //$NON-NLS-1$
	
	/**
	 * IDL file fixed footer
	 */
	public static final String IDL_FIXED_FOOTER = "IDL_FIXED_FOOTER"; //$NON-NLS-1$

	/**
	 * Default value for IDL file fixed footer
	 */
	public static final String DEFAULT_IDL_FIXED_FOOTER = ""; //$NON-NLS-1$

	/**
	 * Default sequence bound
	 */
	public static final String IDL_SEQUENCE_BOUND = "IDL_SEQUENCE_BOUND"; //$NON-NLS-1$

	/**
	 * Default value for sequence bound
	 */
	public static final String DEFAULT_IDL_SEQUENCE_BOUND = "100"; //$NON-NLS-1$
	
	/**
	 * Enable codegen util feature
	 */
	public static final String ENABLE_CODEGEN = "ENABLE_DDS4CCM_CODEGEN"; //$NON-NLS-1$

	/**
	 * Default for enable codegen util feature
	 */
	public static final boolean DEFAULT_ENABLE_CODEGEN = false;

	public static final String GLOBAL_LOCATION_PREFIX = "GOBAL_LOCATION_PREFIX"; //$NON-NLS-1$

	public static final String DEFAULT_GLOBAL_LOCATION_PREFIX = ""; //$NON-NLS-1$
	
	/**
	 * Asynchronous connector type for axcioma migration
	 */
	public static final String ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION = "ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION"; //$NON-NLS-1$

	/**
	 * Default value for asynchronous connector type for axcioma migration
	 */
	public static final String DEFAULT_ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION = ConnectorType.AMI4CCM_Connector.name();
	
	/**
	 * Synchronous connector type for axcioma migration
	 */
	public static final String SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION = "SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION"; //$NON-NLS-1$

	/**
	 * Default value for synchronous connector type for axcioma migration
	 */
	public static final String DEFAULT_SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION = ConnectorType.CORBA4CCM_Connector.name();


	
}
