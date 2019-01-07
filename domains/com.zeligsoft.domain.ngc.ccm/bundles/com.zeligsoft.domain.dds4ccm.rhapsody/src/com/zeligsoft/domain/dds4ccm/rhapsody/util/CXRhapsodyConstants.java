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
package com.zeligsoft.domain.dds4ccm.rhapsody.util;


/**
 * @author prismtech
 *
 */
public final class CXRhapsodyConstants {
	
	public static final String ZDL_CONCEPT_PROPERTY = "CX.DomainModel.DefiningConcept";
	
	public static final String DEPLOYMENT_INSTANT_VALUE_TAG_NAME = "instanceValue";
	
	public static final String DEFAULT_PROPERTY_INSTANCE_NAME = "_defaultInstance";
	
	private CXRhapsodyConstants() {
		// singleton should not be able to create instances outside of myself
	}
}
