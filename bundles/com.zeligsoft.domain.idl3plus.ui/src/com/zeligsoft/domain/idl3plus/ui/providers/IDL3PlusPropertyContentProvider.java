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
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.connectorregistry.ConnectorRegistry;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.ui.providers.CCMPropertyContentProvider;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * IDL3Plus deployment properties content provider
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusPropertyContentProvider extends CCMPropertyContentProvider {

	private static final ConnectorRegistry CONNECTOR_REGISTRY_INSTANCE = ConnectorRegistry.getInstance();

	@Override
	public Object[] getChildren(Object parentElement) {

		Object[] childrenArray = super.getChildren(parentElement);
		if (childrenArray.length > 0) {
			return childrenArray;
		}

		// if there were no children from CCM domain then try IDL3Plus domain
		ArrayList<IPropertyEntry> children = new ArrayList<IPropertyEntry>();
		IPropertyEntry entry = (IPropertyEntry) parentElement;
		EObject modelObject = entry.getModelObject();
		if (ZDLUtil.isZDLConcept(modelObject,
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
			EObject definition = (EObject) ZDLUtil.getValue(modelObject,
					IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
					IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION);
			if (definition != null) {
				children.add(entry.addChild(definition));
			}
		} else if (ZDLUtil
				.isZDLConcept(modelObject, ZMLMMNames.DEPLOYMENT_PART)) {
			Object modelElement = ZDLUtil.getValue(modelObject,
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if (modelElement == null) {
				return children.toArray();
			}
			if (ZDLUtil.isZDLConcept((EObject) modelElement,
					IDL3PlusNames.DATA_SPACE)) {
				if (((Property) modelElement).getType() != null) {
					children.add(entry.addChild(((Property) modelElement)
							.getType()));
				}
			} else if (ZDLUtil.isZDLConcept((EObject) modelElement,
					IDL3PlusNames.CONNECTOR_DEF)) {
				children.add(entry.addChild((Component) modelElement));
			} else if (ZDLUtil.isZDLConcept((EObject) modelElement,
					ZMLMMNames.PORT)) {
				EObject parentPart = ZDeploymentUtil
						.getParentPart((Property) modelObject);
				EObject part = (EObject) ZDLUtil.getValue(parentPart,
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
				if (part instanceof Property) {
					Property dataSpace = IDL3PlusUtil.getDataSpaceFromPerPort(
							(Port) modelElement, (Property) part);
					if (dataSpace != null && dataSpace.getType() != null) {
						children.add(entry.addChild(dataSpace.getType()));
					}
				}
			}
		} else if (ZDLUtil
				.isZDLConcept(modelObject, IDL3PlusNames.CONNECTOR_DEF)) {
			// get properties of the component
			Component component = (Component) entry.getModelObject();
			IPropertyEntry grandParent = entry.getParent();
			EObject grandParentEObject = grandParent.getModelObject();
			Property grandParentProperty = null;
			if (grandParentEObject instanceof Property) {
				grandParentProperty = (Property) grandParentEObject;
			}
			Iterator<Property> itor = component.getAllAttributes().iterator();
			while (itor.hasNext()) {
				Property property = itor.next();
				if (!IDL3PlusUtil.filter(grandParentProperty, property)) {
					if (ZDLUtil.isZDLConcept(property,
							CXDomainNames.CXATTRIBUTE)) {
						children.add(entry.addChild(property));
					} else if (ZDLUtil.isZDLConcept(property, ZMLMMNames.PORT)) {
						if (property.getType() != null
								&& ZDLUtil.isZDLConcept(property.getType(),
										ZMLMMNames.PORT_TYPE)) {
							if (!((Class) property.getType()).getOwnedAttributes()
									.isEmpty()) {
								children.add(entry.addChild(property));
							}
						}
					}
				}
			}
		} else if (ZDLUtil.isZDLConcept(modelObject, ZMLMMNames.PORT)) {
			Property property = (Property) modelObject;
			if (property.getType() != null
					&& ZDLUtil.isZDLConcept(property.getType(),
							ZMLMMNames.PORT_TYPE)) {
				for (Property attr : ((Class) property.getType())
						.getOwnedAttributes()) {
					if (ZDLUtil.isZDLConcept(attr,
							CXDomainNames.CXATTRIBUTE) && !IDL3PlusUtil.filter(property, attr)) {
						children.add(entry.addChild(attr));
					}
				}
			}
		}
		return children.toArray();
	}

	@Override
	protected Slot getSequenceMemberSlot(IPropertyEntry entry) {
		return ((IDL3PlusPropertyEntry) entry).getSequenceMemberSlot();
	}
}
