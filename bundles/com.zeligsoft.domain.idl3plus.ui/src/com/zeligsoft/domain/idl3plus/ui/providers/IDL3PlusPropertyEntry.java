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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.ui.providers.CCMPropertyEntry;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * DDS4CCM property entry
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusPropertyEntry extends CCMPropertyEntry {

	/**
	 * constructor
	 * 
	 * @param modelObject
	 */
	public IDL3PlusPropertyEntry(EObject modelObject) {
		super(modelObject);
	}

	/**
	 * constructor
	 * 
	 * @param parent
	 * @param modelObject
	 */
	public IDL3PlusPropertyEntry(IPropertyEntry parent, EObject modelObject) {
		super(parent, modelObject);
	}

	@Override
	protected Class getDeploymentPartDefinition(Property deploymentPart) {

		Class definition = super.getDeploymentPartDefinition(deploymentPart);
		if (definition != null) {
			return definition;
		}

		Object obj = ZDLUtil.getValue(deploymentPart,
				ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		if (obj == null) {
			return null;
		}
		if (ZDLUtil.isZDLConcept((EObject) obj, IDL3PlusNames.DATA_SPACE)) {
			definition = (Component) ((Property) obj).getType();
		} else if (ZDLUtil.isZDLConcept((EObject) obj,
				IDL3PlusNames.CONNECTOR_DEF)) {
			definition = (Component) obj;
		} else {
			return null;
		}
		return definition;
	}

	public IPropertyEntry addChild(EObject modelElement) {
		return new IDL3PlusPropertyEntry(this, modelElement);
	}

	@Override
	public InstanceSpecification getRootInstanceSpecification() {
		IPropertyEntry rootEntry = getRootEntry();
		Property property = null;
		if (ZDLUtil.isZDLConcept(rootEntry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
			return (InstanceSpecification) ZDLUtil
					.getValue(
							rootEntry.getModelObject(),
							IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
							IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE);
		} else if (ZDLUtil.isZDLConcept(rootEntry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEF)) {
			property = ((Component) rootEntry.getModelObject())
					.getOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
			if (property != null && property.getDefaultValue() != null) {
				return ((InstanceValue) property.getDefaultValue())
						.getInstance();
			}
			return null;
		}
		return super.getRootInstanceSpecification();
	}

	@Override
	protected Package getRootInstanceContainer() {

		Package container = null;
		IPropertyEntry rootEntry = getRootEntry();

		if (ZDLUtil.isZDLConcept(rootEntry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
			return (Package) rootEntry.getModelObject();

		} else if (ZDLUtil.isZDLConcept(rootEntry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEF)) {
			// root element is a component definition that stores
			// default values

			Property property = ((Component) rootEntry.getModelObject())
					.getOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
			InstanceSpecification defaultInstance = null;
			if (property != null && property.getDefaultValue() != null) {
				defaultInstance = ((InstanceValue) property.getDefaultValue())
						.getInstance();
				container = (Package) defaultInstance.eContainer();
				property.destroy();
			}
			property = ((Component) rootEntry.getModelObject())
					.createOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
			if (defaultInstance != null) {
				InstanceValue value = (InstanceValue) property
						.createDefaultValue(null, null,
								UMLPackage.Literals.INSTANCE_VALUE);
				value.setInstance(defaultInstance);
			}
			if (container == null) {
				String containerName = NamingUtil.generateUniqueName("_" //$NON-NLS-1$
						+ rootEntry.getModelObjectName(), property.eContainer()
						.eContents());
				EObject partContainer = (EObject) property.eContainer();
				container = (Package) ((Component) partContainer)
						.createPackagedElement(containerName,
								UMLPackage.Literals.PACKAGE);
			}
			return container;
		} else if (ZDLUtil.isZDLConcept(rootEntry.getModelObject(),
				IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
			Property property = (Property) rootEntry.getModelObject();
			InstanceSpecification partInstance = null;
			if (property.getDefaultValue() != null) {
				partInstance = ((InstanceValue) property.getDefaultValue())
						.getInstance();
				container = (Package) partInstance.eContainer();
			}

			if (partInstance != null) {
				InstanceValue value = (InstanceValue) property
						.createDefaultValue(null, null,
								UMLPackage.Literals.INSTANCE_VALUE);
				value.setInstance(partInstance);
			}

			if (container == null) {
				String containerName = NamingUtil.generateUniqueName("_" //$NON-NLS-1$
						+ rootEntry.getModelObjectName(), property.eContainer()
						.eContainer().eContents());
				EObject partContainer = (EObject) property.eContainer();

				container = (Package) ((Component) partContainer)
						.createPackagedElement(containerName,
								UMLPackage.Literals.PACKAGE);
			}
			return container;
		}
		return super.getRootInstanceContainer();
	}

	@Override
	protected InstanceSpecification createRootInstanceSpecification(
			IPropertyEntry entry, Slot containerSlot, Package container,
			Type definition, String instanceName) {

		if (ZDLUtil.isZDLConcept(entry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEF)
				|| ZDLUtil.isZDLConcept(entry.getModelObject(),
						IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)
				|| ZDLUtil.isZDLConcept(entry.getModelObject(), IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {

			InstanceSpecification propertyInstance = null;
			instanceName = NamingUtil.generateUniqueName(instanceName,
					container.getPackagedElements());

			propertyInstance = (InstanceSpecification) container
					.createPackagedElement(instanceName,
							UMLPackage.Literals.INSTANCE_SPECIFICATION);

			propertyInstance.getClassifiers().add((Classifier) definition);

			if (ZDLUtil.isZDLConcept(entry.getModelObject(),
					IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
				// this is connector default value binding
				ZDLUtil.setValue(
						entry.getModelObject(),
						IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
						IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE,
						propertyInstance);

			} else if (ZDLUtil.isZDLConcept(entry.getModelObject(),
					IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
				InstanceValue value;
				if (containerSlot != null) {
					value = (InstanceValue) containerSlot.createValue(null,
							null, UMLPackage.Literals.INSTANCE_VALUE);
				} else {
					value = (InstanceValue) ((Property) entry.getModelObject())
							.createDefaultValue(null, null,
									UMLPackage.Literals.INSTANCE_VALUE);
				}
				value.setInstance(propertyInstance);
			} else {
				Property instanceAttr;

				instanceAttr = ((Component) entry.getModelObject())
						.getOwnedAttribute(DEFAULT_INSTANCE_NAME, null);

				InstanceValue value;
				if (containerSlot != null) {
					value = (InstanceValue) containerSlot.createValue(null,
							null, UMLPackage.Literals.INSTANCE_VALUE);
				} else {
					value = (InstanceValue) instanceAttr.createDefaultValue(
							null, null, UMLPackage.Literals.INSTANCE_VALUE);
				}

				value.setInstance(propertyInstance);
			}
			return propertyInstance;
		}

		return super.createRootInstanceSpecification(entry, containerSlot,
				container, definition, instanceName);
	}

	@Override
	protected Type getModelDefinition(IPropertyEntry entry) {
		if (ZDLUtil.isZDLConcept(entry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
			return (Type) ZDLUtil.getValue(entry.getModelObject(),
					IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
					IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION);

		} else if (ZDLUtil.isZDLConcept(entry.getModelObject(),
				IDL3PlusNames.CONNECTOR_DEF)) {
			return (Type) entry.getModelObject();
		} else if (ZDLUtil.isZDLConcept(entry.getModelObject(),
				IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
			Port port = (Port) ZDLUtil.getValue(entry.getModelObject(),
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			Property parentPart = ZDeploymentUtil
					.getParentPart((Property) entry.getModelObject());
			Property dataSpace = IDL3PlusUtil.getDataSpaceFromPerPort(port,
					parentPart);
			return dataSpace.getType();
		}
		return super.getModelDefinition(entry);
	}

	@Override
	public String getDefaultValue() {
		String returnValue = UML2Util.EMPTY_STRING;
		if (!isLeaf() || this == getRootEntry()) {
			return returnValue;
		}
		if (getRootEntry().getModelObject() instanceof Property) {
			EObject connectDef = ((Property) getRootEntry().getModelObject())
					.getType();
			if (connectDef != null && ZDLUtil.isZDLConcept(connectDef, IDL3PlusNames.CONNECTOR_DEF)) {
				return IDL3PlusUtil.getDefaultValueForConnector(
						(Property) getRootEntry().getModelObject(),
						getModelObject(),
						getDefiningFeaturesForAncestorSlots(this));
			} else if (ZDLUtil.isZDLConcept((Property) getRootEntry()
					.getModelObject(),
					IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
				return IDL3PlusUtil.getDefaultValueforPerPort(
						(Property) getRootEntry().getModelObject(),
						getModelObject(),
						getDefiningFeaturesForAncestorSlots(this));
			}
		}
		return super.getDefaultValue();
	}

	@Override
	protected void cleanInstances() {
		if (ZDLUtil.isZDLConcept(this.getRootEntry().getModelObject(),
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING)) {
			InstanceSpecification instance = getRootInstanceSpecification();
			if (instance == null) {
				return;
			}
			cleanInstanceSpecification(instance, false, false);
		} else if (ZDLUtil.isZDLConcept(this.getRootEntry().getModelObject(),
				IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
			InstanceSpecification instance = getRootInstanceSpecification();
			if (instance != null) {
				cleanInstanceSpecification(instance, false, false);
			}
		} else {
			super.cleanInstances();
		}
		
		if (ZDLUtil.isZDLConcept(this.getRootEntry().getModelObject(),
				IDL3PlusNames.PER_PORT_CONNECTOR_TYPE_DEPLOYMENT_PART)) {
			((Property) this.getRootEntry().getModelObject())
					.setDefaultValue(null);
		}
	}

	@Override
	public IPropertyEntry createNewEntry(EObject element) {
		return new IDL3PlusPropertyEntry(element);
	}
}
