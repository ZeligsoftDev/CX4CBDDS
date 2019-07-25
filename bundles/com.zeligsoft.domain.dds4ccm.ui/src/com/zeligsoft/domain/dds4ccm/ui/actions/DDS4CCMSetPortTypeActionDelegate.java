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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.List;

import com.zeligsoft.cx.ui.actions.SetPortTypeActionDelegate;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Set port type action delegate for DDS4CCM
 * 
 * @author ysroh
 * 
 */
public class DDS4CCMSetPortTypeActionDelegate extends SetPortTypeActionDelegate {

	@Override
	protected List<String> getPortTypeableConcepts() {
		List<String> concepts = super.getPortTypeableConcepts();
		concepts.add(ZMLMMNames.INTERFACE);
		return concepts;
	}
}
