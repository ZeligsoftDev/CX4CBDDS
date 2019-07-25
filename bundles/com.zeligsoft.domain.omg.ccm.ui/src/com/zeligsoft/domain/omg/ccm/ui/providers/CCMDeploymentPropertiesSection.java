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
package com.zeligsoft.domain.omg.ccm.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.properties.sections.AbstractDeploymentPropertiesCustomSection;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * CCM deployment properties section
 * 
 * @author ysroh
 * 
 */
public class CCMDeploymentPropertiesSection extends
		AbstractDeploymentPropertiesCustomSection {

	protected boolean isValidSelection(EObject object) {
		if (ZDLUtil.isZDLConcept(object, CCMNames.CCMCOMPONENT)
				|| ZDLUtil.isZDLConcept(object, CCMNames.NODE)
				|| ZDLUtil.isZDLConcept(object, CCMNames.BRIDGE)
				|| ZDLUtil.isZDLConcept(object, CCMNames.INTERCONNECT)
				|| ZDLUtil.isZDLConcept(object, CCMNames.HOME)
				|| ZDLUtil.isZDLConcept(object, CCMNames.CONTAINER_PROCESS)) {
			return true;
		}
		if (ZDLUtil.isZDLConcept(object, ZMLMMNames.DEPLOYMENT_PART)) {
			Object obj = ZDLUtil.getValue(object, ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if (obj == null || !(obj instanceof EObject)) {
				return false;
			}
			if (ZDeploymentUtil.getDeploymentChildren((Property) object)
					.isEmpty()) {
				if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.CCMCOMPONENT)
						|| ZDLUtil
								.isZDLConcept((EObject) obj, CCMNames.CCMPART)
						|| ZDLUtil.isZDLConcept((EObject) obj,
								CCMNames.CONTAINER_PROCESS)
						|| ZDLUtil.isZDLConcept((EObject) obj,
								CCMNames.NODE_INSTANCE)
						|| ZDLUtil.isZDLConcept((EObject) obj,
								CCMNames.BRIDGE_INSTANCE)
						|| ZDLUtil.isZDLConcept((EObject) obj,
								CCMNames.INTERCONNECT_INSTANCE)
						|| ZDLUtil.isZDLConcept((EObject)obj, 
								CCMNames.HOME_INSTANCE)) {
					return true;
				}
			}else if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.CCMPART)) {
				EObject definition = (EObject) ZDLUtil.getValue((EObject) obj,
						ZMLMMNames.PART, ZMLMMNames.PART__DEFINITION);
				if (!CCMUtil.isAssemblyComponent(definition)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return root entry
	 */
	protected List<IPropertyEntry> getRootPropertyEntries(EObject object) {
		List<IPropertyEntry> entries = new ArrayList<IPropertyEntry>();
		entries.add(new CCMPropertyEntry(object));
		return entries;
	}

	/**
	 * Return content provider
	 */
	protected IContentProvider getContentProvider() {
		return new CCMPropertyContentProvider();
	}

	/**
	 * Return editing support
	 */
	protected EditingSupport getEditingSupport(TreeViewer treeViewer) {
		return new CCMPropertyEditingSupport(treeViewer);
	}
}
