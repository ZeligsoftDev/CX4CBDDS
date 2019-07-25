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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * CCM deployment properties content provider.
 * 
 * @author ysroh
 * 
 */
public class CCMPropertyContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		ArrayList<IPropertyEntry> children = new ArrayList<IPropertyEntry>();
		IPropertyEntry entry = (IPropertyEntry) parentElement;
		EObject modelObject = entry.getModelObject();
		if (ZDLUtil.isZDLConcept(modelObject, ZMLMMNames.DEPLOYMENT_PART)) {
			Object modelElement = ZDLUtil.getValue(modelObject,
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if (modelElement == null) {
				return children.toArray();
			}
			if (ZDLUtil.isZDLConcept((EObject) modelElement, CCMNames.CCMPART)
				|| ZDLUtil.isZDLConcept((EObject)modelElement, CCMNames.HOME_INSTANCE)) {
				if (((Property) modelElement).getType() != null) {
					children.add(entry.addChild(((Property) modelElement)
							.getType()));
				}
			} else if (ZDLUtil.isZDLConcept((EObject) modelElement,
					CCMNames.CCMCOMPONENT)
					|| ZDLUtil.isZDLConcept((EObject) modelElement,
							CCMNames.CONTAINER_PROCESS)
					|| ZDLUtil.isZDLConcept((EObject) modelElement, 
							CCMNames.HOME)) {
				children.add(entry.addChild((EObject) modelElement));
			} else if (ZDLUtil.isZDLConcept((EObject) modelElement,
					CCMNames.NODE_INSTANCE)
					|| ZDLUtil.isZDLConcept((EObject) modelElement,
							CCMNames.BRIDGE_INSTANCE)
					|| ZDLUtil.isZDLConcept((EObject) modelElement,
							CCMNames.INTERCONNECT_INSTANCE)) {
				if (((Property) modelElement).getType() != null) {
					children.add(entry.addChild(((Property) modelElement)
							.getType()));
				}
			}
		} else if (ZDLUtil.isZDLConcept(modelObject, CCMNames.CCMCOMPONENT)
				|| ZDLUtil.isZDLConcept(modelObject, CCMNames.HOME)) {
			// get properties of the component/home
			Class componentOrHome = (Class) entry.getModelObject();
			Iterator<Property> itor = componentOrHome.getAllAttributes().iterator();
			while (itor.hasNext()) {
				Property property = itor.next();
				if (ZDLUtil.isZDLConcept(property,
						CORBADomainNames.CORBAATTRIBUTE)
						|| ZDLUtil.isZDLConcept(property, CCMNames.PROPERTY)) {
					children.add(entry.addChild(property));
				}
			}
		} else if (ZDLUtil
				.isZDLConcept(modelObject, CCMNames.CONTAINER_PROCESS)) {
			Iterator<Property> itor = ((Component) modelObject)
					.getAllAttributes().iterator();
			while (itor.hasNext()) {
				Property property = itor.next();
				if (ZDLUtil.isZDLConcept(property, CCMNames.PROPERTY)) {
					children.add(entry.addChild(property));
				}
			}
		} else if (ZDLUtil.isZDLConcept(modelObject, CCMNames.NODE)
				|| ZDLUtil.isZDLConcept(modelObject, CCMNames.INTERCONNECT)
				|| ZDLUtil.isZDLConcept(modelObject, CCMNames.BRIDGE)) {
			// get properties from the node
			Component component = (Component) entry.getModelObject();
			Iterator<Property> itor = component.getAllAttributes().iterator();
			while (itor.hasNext()) {
				Property property = itor.next();
				if (ZDLUtil.isZDLConcept(property, CCMNames.RESOURCE_PROPERTY)) {
					children.add(entry.addChild(property));
				}
			}
		} else if (ZDLUtil
				.isZDLConcept(modelObject, CCMNames.RESOURCE_PROPERTY)) {
			// get properties from the resource
			Class resource = (Class) ((Property) modelObject).getType();
			if (resource == null) {
				return children.toArray();
			}
			Iterator<Property> itor = resource.getAllAttributes().iterator();
			while (itor.hasNext()) {
				Property property = itor.next();
				if (ZDLUtil.isZDLConcept(property, CCMNames.SATISFIER_PROPERTY)) {
					children.add(entry.addChild(property));
				}
			}
		} else if (ZDLUtil.isZDLConcept(modelObject,
				CORBADomainNames.CORBAATTRIBUTE)
				|| ZDLUtil.isZDLConcept(modelObject,
						CORBADomainNames.CORBAFIELD)
				|| modelObject instanceof ValueSpecification
				|| ZDLUtil.isZDLConcept(modelObject, CCMNames.PROPERTY)) {
			Type type;

			if (modelObject instanceof InstanceValue) {
				StructuralFeature feature = ((Slot) modelObject.eContainer())
						.getDefiningFeature();
				if (feature.getType() == null) {
					return children.toArray();
				}
				type = feature.getType();
			} else {
				type = ((Property) modelObject).getType();
			}
			// add child if the type is CORBAStruct
			if (type == null) {
				return children.toArray();
			}
			if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASTRUCT)) {
				DataType struct = (DataType) type;
				Iterator<Property> itor = struct.getAllAttributes().iterator();
				while (itor.hasNext()) {
					Property property = itor.next();
					if (ZDLUtil.isZDLConcept(property,
							CORBADomainNames.CORBAFIELD)) {
						children.add(entry.addChild(property));
					}
				}
			} else if (ZDLUtil.isZDLConcept(type,
					CORBADomainNames.CORBASEQUENCE)
					|| ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAARRAY)) {
				((CCMPropertyEntry) entry).migrateSequenceValue();
				Slot slot = getSequenceMemberSlot(entry);
				if (slot != null) {
					for (ValueSpecification value : slot.getValues()) {
						children.add(entry.addChild(value));
					}
				}
			}
		}

		return children.toArray();

	}
	
	protected Slot getSequenceMemberSlot(IPropertyEntry entry){
		return ((CCMPropertyEntry) entry).getSequenceMemberSlot();
	}

	public Object getParent(Object element) {
		return ((IPropertyEntry) element).getParent();
	}

	public boolean hasChildren(Object element) {
		return !((IPropertyEntry) element).isLeaf();
	}

	@SuppressWarnings("rawtypes")
	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof List) {
			return ((List) inputElement).toArray();
		}
		return null;
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}
}
