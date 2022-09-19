/**
 * Copyright 2022 Zeligsoft Limited.
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
package com.zeligsoft.domain.dds4ccm.ui.providers;

import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;

import com.zeligsoft.domain.idl3plus.ui.providers.IDL3PlusDeploymentPropertiesSection;
import com.zeligsoft.domain.omg.ccm.ui.providers.CCMDeploymentPropertiesSection;

/**
 * @author eposse
 */
public class DDS4CCMDeploymentPropertiesSectionProvider extends IDL3PlusDeploymentPropertiesSection {

	@Override
	protected EditingSupport getEditingSupport(TreeViewer treeViewer) {
		return new DDS4CCMPropertyEditingSupport(treeViewer);
	}

}
