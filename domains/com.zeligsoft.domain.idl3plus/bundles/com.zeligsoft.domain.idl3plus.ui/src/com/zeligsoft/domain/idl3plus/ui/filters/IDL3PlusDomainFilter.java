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
package com.zeligsoft.domain.idl3plus.ui.filters;

import com.zeligsoft.cx.ui.filters.AbstractDomainFilter;

/**
 * CCM Domain Filter
 * 
 * @author smcfee
 * 
 */
public class IDL3PlusDomainFilter
		extends AbstractDomainFilter {

	public static final String IDL3PLUS_PROFILE_NAME = "cxIDL3Plus"; //$NON-NLS-1$

	public IDL3PlusDomainFilter() {
		super(IDL3PLUS_PROFILE_NAME);
	}

}
