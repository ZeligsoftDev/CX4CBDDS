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
package com.zeligsoft.domain.idl3plus.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.ui.providers.CCMDeploymentPropertiesSection;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * DDS4CCM deployment properties section
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusDeploymentPropertiesSection extends
		CCMDeploymentPropertiesSection {

	protected boolean isValidSelection(EObject object) {
		boolean result = super.isValidSelection(object);
		if (result) {
			return true;
		}
		if (ZDLUtil.isZDLConcept(object,
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
			return true;
		}

		if (ZDLUtil.isZDLConcept(object, IDL3PlusNames.CONNECTOR_DEF)
				&& IDL3PlusUtil.getTemplateModule(object) == null) {
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
				if (ZDLUtil
						.isZDLConcept((EObject) obj, IDL3PlusNames.DATA_SPACE)) {
					return true;
				}
			}
		}
		
		if (ZDLUtil.isZDLConcept(object,
				IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
			EObject port = (EObject) ZDLUtil.getValue(context,
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			EObject portType = (EObject) ZDLUtil.getValue(port,
					ZMLMMNames.PORT, ZMLMMNames.PORT__PORTTYPE);
			if (portType instanceof Interface
					&& "DDS_DCPS::CCM_DDS::ConnectorStatusListener".equals(((Interface) portType).getQualifiedName())) { //$NON-NLS-1$
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	protected IContentProvider getContentProvider() {
		return new IDL3PlusPropertyContentProvider();
	}

	@Override
	protected List<IPropertyEntry> getRootPropertyEntries(EObject object) {
		List<IPropertyEntry> entries = new ArrayList<IPropertyEntry>();
		entries.add(new IDL3PlusPropertyEntry(object));
		return entries;
	}
}
