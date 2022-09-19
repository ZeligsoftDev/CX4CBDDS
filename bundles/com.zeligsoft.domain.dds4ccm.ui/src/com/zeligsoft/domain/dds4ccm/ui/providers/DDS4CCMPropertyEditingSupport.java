/**
 * Copyright 2022 ZeligsoftLimited.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMDomainDefinitionsUtils;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.providers.CCMPropertyEditingSupport;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author eposse
 */
public class DDS4CCMPropertyEditingSupport extends CCMPropertyEditingSupport {

	/**
	 * @param viewer
	 */
	public DDS4CCMPropertyEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected boolean canEdit(Object element) {
		return element instanceof IPropertyEntry
				&& !isDomainDefinitionDeploymentPartInDeploymentPlan((IPropertyEntry) element)
				&& super.canEdit(element);
	}

	private boolean isDomainDefinitionDeploymentPartInDeploymentPlan(IPropertyEntry propertyEntry) {
		IPropertyEntry entry = propertyEntry;
		while (entry != null) {
			EObject modelObject = entry.getModelObject();
			if (modelObject instanceof Property
					&& ZDLUtil.isZDLConcept(((Property) modelObject).getOwner(), CCMNames.DEPLOYMENT_PLAN)
					&& ZDLUtil.isZDLConcept(modelObject, ZMLMMNames.DEPLOYMENT_PART) 
					&& DDS4CCMDomainDefinitionsUtils.getDeploymentPartDomainDefinition((Property) modelObject) != null) {
				return true;
			}
			entry = entry.getParent();
		}
		return false;
	}

}
