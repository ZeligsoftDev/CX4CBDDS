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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.IPropertyEntry;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * CCM property entry for CCM properties dialog.
 * 
 * @author ysroh
 * 
 */
public class CCMPropertyEntry implements IPropertyEntry {

	protected IPropertyEntry parent = null;

	protected String value = null;

	protected ArrayList<IPropertyEntry> children = new ArrayList<IPropertyEntry>();

	protected EObject modelObject;

	protected final static String DEFAULT_INSTANCE_NAME = CCMUtil.DEFAULT_PROPERTY_INSTANCE_NAME;

	/**
	 * Constructor
	 * 
	 * @param parent
	 * @param modelObject
	 */
	public CCMPropertyEntry(IPropertyEntry parent, EObject modelObject) {
		this.modelObject = modelObject;
		this.parent = parent;
		if (parent != null) {
			parent.getChildren().add(this);
		}
	}

	public CCMPropertyEntry(EObject modelObject) {

		this(null, modelObject);
	}

	/**
	 * Queries the children of this entry
	 */
	public List<IPropertyEntry> getChildren() {
		return children;
	}

	@Override
	public int hashCode() {
		return modelObject.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (obj instanceof IPropertyEntry) {
			IPropertyEntry entry = (IPropertyEntry) obj;
			return parent == entry.getParent() && modelObject == entry.getModelObject();
		}
		return false;
	}
	
	/**
	 * Queries the default value
	 */
	public String getDefaultValue() {
		String returnValue = UML2Util.EMPTY_STRING;

		if (!(getRootEntry().getModelObject() instanceof Property)) {
			// if the root is part definition then no default value
			return returnValue;
		}
		if (!isLeaf() || this == getRootEntry()) {
			return returnValue;
		}
		Class definition = (Class) ((Property) getRootEntry().getModelObject())
				.getType();
		if (definition != null) {
			Property property = definition.getOwnedAttribute(
					DEFAULT_INSTANCE_NAME, null);
			if (property != null && property.getDefaultValue() != null) {

				returnValue = CCMUtil.getInstanceValueForEntry(
						((InstanceValue) property.getDefaultValue())
								.getInstance(), this.getModelObject(),
						getDefiningFeaturesForAncestorSlots(this));
			}
		}
		return returnValue == null ? UML2Util.EMPTY_STRING : returnValue;
	}

	public EObject getModelObject() {
		return modelObject;
	}

	public String getModelObjectName() {
		if (modelObject != null) {
			return EMFCoreUtil.getName(modelObject);
		}
		return UML2Util.EMPTY_STRING;
	}

	public IPropertyEntry getParent() {
		return parent;
	}

	/**
	 * Queries the entry column label for the viewer
	 */
	public String getPropertyColumnLabel(int column) {
		if (column == 0) {
			if (ZDLUtil.isZDLConcept(modelObject,
					CXDomainNames.CXATTRIBUTE)
					|| ZDLUtil.isZDLConcept(modelObject,
							CXDomainNames.CXFIELD)
					|| ZDLUtil.isZDLConcept(modelObject,
							CCMNames.SATISFIER_PROPERTY)
					|| ZDLUtil.isZDLConcept(modelObject,
							CCMNames.RESOURCE_PROPERTY)
					|| ZDLUtil.isZDLConcept(modelObject, CCMNames.PROPERTY)) {
				String typeName = Messages.CCMPropertyEntry_TypeUndefinedLabel;
				Type type = ((Property) modelObject).getType();
				if (type != null) {
					typeName = ":" + type.getName(); //$NON-NLS-1$
					if (ZDLUtil.isZDLConcept(type,
							CXDomainNames.CXTYPE_DEF)) {
						type = (Type) CORBAUtil.getTypeDefType(type);
						String typedefType = Messages.CCMPropertyEntry_TypeUndefinedLabel;
						if (type != null) {
							typedefType = type.getName();
						}
						typeName = typeName + ":" + typedefType; //$NON-NLS-1$
					} else if (isMultiValue()) {
						Property member = CCMUtil
								.getMembersAttribute((DataType) type);
						String memberType = Messages.CCMPropertyEntry_TypeUndefinedLabel;
						if (member != null && member.getType() != null) {
							memberType = member.getType().getName();
						}
						typeName = typeName + ":" + memberType; //$NON-NLS-1$
					}
				}
				if (ZDLUtil.isZDLConcept(modelObject,
						CXDomainNames.CXATTRIBUTE)) {
					if (modelObject.eContainer() != null
							&& ZDLUtil.isZDLConcept(modelObject.eContainer(),
									ZMLMMNames.PORT_TYPE)) {
						return EMFCoreUtil.getName(modelObject.eContainer())
								+ "::" + getModelObjectName() + typeName; //$NON-NLS-1$
					}
				}
				return getModelObjectName() + typeName;
			}

			if (modelObject instanceof Property) {
				Property p = (Property) modelObject;
				if (p.getName().equals(CXDomainNames.CXSTRUCT__MEMBERS)
						|| p.getName().equals("member")) { //$NON-NLS-1$
					return p.getType().getName();
				}
			}

			if (modelObject instanceof ValueSpecification) {
				Slot slot = (Slot) modelObject.eContainer();
				StructuralFeature feature = slot.getDefiningFeature();
				if (feature.getType() != null) {
					return feature.getType().getName();
				}
			}

			if (ZDLUtil.isZDLConcept(modelObject, ZMLMMNames.DEPLOYMENT_PART)) {
				return ZDeploymentUtil.getQualifiedName((Property) modelObject);
			}

			return getModelObjectName();
		} else if (column == 1) {
			if (!isLeaf()) {
				return UML2Util.EMPTY_STRING;
			}
			String value = getValue();
			if (isMultiValue()) {
				// for sequence and arrays
				return value;
			}
			if (isDefaultValue() && this != getRootEntry()
					&& getRootEntry().getModelObject() instanceof Property
					&& !isMultiValue()) {
				return value + " " //$NON-NLS-1$
						+ Messages.CCMPropertyEntry_DefaultValueLabel;
			}
			return value;
		}
		return UML2Util.EMPTY_STRING;
	}

	/**
	 * Return current value
	 */
	public String getValue() {
		if (value == null) {
			if (modelObject instanceof ValueSpecification) {
				StructuralFeature feature = ((Slot) modelObject.eContainer())
						.getDefiningFeature();
				if (!ZDLUtil.isZDLConcept(feature.getType(),
						CXDomainNames.CXSEQUENCE)
						&& !ZDLUtil.isZDLConcept(feature.getType(),
								CXDomainNames.CXARRAY)
						&& !ZDLUtil.isZDLConcept(feature.getType(),
								CXDomainNames.CXSTRUCT)) {
					value = CCMUtil
							.getValueFromValueSpecification((ValueSpecification) modelObject);
				}
			} else {
				value = getOverrideValue();
			}
			if (UML2Util.isEmpty(value)) {
				value = getDefaultValue();
			}
		}

		return value;
	}

	/**
	 * Queries the root component instance
	 * 
	 * @return
	 */
	public InstanceSpecification getRootInstanceSpecification() {
		IPropertyEntry entry = getRootEntry();
		Property property = null;

		if (entry.getModelObject() instanceof Component) {
			property = ((Component) entry.getModelObject()).getOwnedAttribute(
					DEFAULT_INSTANCE_NAME, null);
		} else if (entry.getModelObject() instanceof Property) {
			property = (Property) entry.getModelObject();
		}

		if (property != null && property.getDefaultValue() != null) {
			return ((InstanceValue) property.getDefaultValue()).getInstance();
		}
		return null;
	}

	/**
	 * Queries the root component instance
	 * 
	 * @return
	 */
	protected InstanceSpecification createRootInstanceSpecification(
			IPropertyEntry entry, Slot containerSlot, Package container,
			Type definition, String instanceName) {
		InstanceSpecification propertyInstance = null;
		instanceName = NamingUtil.generateUniqueName(instanceName,
				container.getPackagedElements());

		propertyInstance = (InstanceSpecification) container
				.createPackagedElement(instanceName,
						UMLPackage.Literals.INSTANCE_SPECIFICATION);

		propertyInstance.getClassifiers().add((Classifier) definition);

		Property instanceAttr;

		if (entry.getModelObject() instanceof Component) {
			instanceAttr = ((Component) entry.getModelObject())
					.getOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
			if (instanceAttr == null) {
				instanceAttr = ((Component) entry.getModelObject())
						.createOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
			}
		} else {
			instanceAttr = (Property) entry.getModelObject();
		}

		InstanceValue value;
		if (containerSlot != null) {
			value = (InstanceValue) containerSlot.createValue(null, null,
					UMLPackage.Literals.INSTANCE_VALUE);
		} else {
			value = (InstanceValue) instanceAttr.createDefaultValue(null, null,
					UMLPackage.Literals.INSTANCE_VALUE);
		}

		value.setInstance(propertyInstance);
		return propertyInstance;
	}

	private boolean isCompositeType(Type type) {
		if (type != null
				&& (ZDLUtil.isZDLConcept(type, CXDomainNames.CXSTRUCT)
						|| ZDLUtil.isZDLConcept(type,
								CXDomainNames.CXSEQUENCE)
						|| ZDLUtil.isZDLConcept(type,
								CXDomainNames.CXARRAY)
						|| ZDLUtil.isZDLConcept(type, CCMNames.RESOURCE) || ZDLUtil
							.isZDLConcept(type, ZMLMMNames.PORT_TYPE))) {
			return true;
		}
		return false;
	}

	/**
	 * Queries the override value from the instance
	 * 
	 * @return
	 */
	protected String getOverrideValue() {

		if (!(modelObject instanceof Property)) {
			return null;
		}

		Type type = ((Property) modelObject).getType();
		if (isCompositeType(type)) {
			return null;
		}

		if (!ZDLUtil.isZDLConcept(modelObject, CXDomainNames.CXATTRIBUTE)
				&& !ZDLUtil.isZDLConcept(modelObject,
						CXDomainNames.CXFIELD)
				&& !ZDLUtil.isZDLConcept(modelObject,
						CCMNames.SATISFIER_PROPERTY)
				&& !ZDLUtil.isZDLConcept(modelObject, CCMNames.PROPERTY)) {
			return null;
		}
		InstanceSpecification partInstance = getRootInstanceSpecification();

		if (partInstance != null) {
			return CCMUtil.getInstanceValueForEntry(partInstance,
					(Property) this.getModelObject(),
					getDefiningFeaturesForAncestorSlots(this));
		}
		return null;

	}

	/**
	 * Queries if current value is same as default value
	 */
	public boolean isDefaultValue() {
		if (isMultiValue()) {
			return UML2Util.isEmpty(value);
		}
		return getValue().equals(getDefaultValue());
	}

	/**
	 * Queries if this entry is a leaf entry
	 */
	public boolean isLeaf() {

		if (modelObject instanceof ValueSpecification) {
			StructuralFeature feature = ((Slot) modelObject.eContainer())
					.getDefiningFeature();
			if (feature.getType() != null
					&& !ZDLUtil.isZDLConcept(feature.getType(),
							CXDomainNames.CXSTRUCT)
					&& !ZDLUtil.isZDLConcept(feature.getType(),
							CXDomainNames.CXSEQUENCE)
					&& !ZDLUtil.isZDLConcept(feature.getType(),
							CXDomainNames.CXARRAY)) {
				return true;
			}
		}
		if (!(modelObject instanceof Property)) {
			return false;
		}

		Type type = ((Property) modelObject).getType();
		if (type != null
				&& (ZDLUtil.isZDLConcept(type, CXDomainNames.CXSTRUCT)
						|| ZDLUtil.isZDLConcept(type,
								CXDomainNames.CXSEQUENCE) || ZDLUtil
							.isZDLConcept(type, CXDomainNames.CXARRAY))) {
			return false;
		}

		if (ZDLUtil.isZDLConcept(modelObject, CCMNames.SATISFIER_PROPERTY)
				|| ZDLUtil.isZDLConcept(modelObject, CCMNames.PROPERTY)) {
			return true;
		}
		if (ZDLUtil.isZDLConcept(modelObject, CXDomainNames.CXFIELD)) {
			return true;
		}
		if (((Property) modelObject).getName().startsWith("member")) { //$NON-NLS-1$
			return true;
		}
		if (!ZDLUtil.isZDLConcept(modelObject, CXDomainNames.CXATTRIBUTE)) {
			return false;
		}

		return true;
	}

	/**
	 * Sets the value for this entry and saves it to the disk
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
		// nothing to do if this is non-leaf entry
		if (parent == null) {
			return;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(modelObject);
		ICommand command = new AbstractTransactionalCommand(
				editingDomain,
				Messages.CCMPropertiesDialog_ActionLabel, null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				IPropertyEntry rootEntry = getRootEntry();

				Package container = getRootInstanceContainer();

				saveValue(null, rootEntry, container);
				EObject containerParent = container.eContainer();
				if (container.allOwnedElements().isEmpty()) {
					if (containerParent != null
							&& !ZDLUtil.isZDLConcept(containerParent,
									CCMNames.DOMAIN)
							&& containerParent instanceof Class) {
						container.destroy();
					}
					if (rootEntry.getModelObject() instanceof Class) {
						// delete instance property from the definition
						Property property = ((Class) rootEntry.getModelObject())
								.getOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
						property.destroy();
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		editingDomain.getCommandStack().execute(GMFtoEMFCommandWrapper.wrap(command));

	}

	/**
	 * Get or Create a package for instance specifications
	 * 
	 * @param rootEntry
	 * @return
	 */
	protected Package getRootInstanceContainer() {
		IPropertyEntry rootEntry = getRootEntry();
		Property property;
		Package container = null;

		// root element is a ccm component
		if (rootEntry.getModelObject() instanceof Class) {
			Class clazz = (Class) rootEntry.getModelObject();
			property = clazz.getOwnedAttribute(DEFAULT_INSTANCE_NAME, null);
			InstanceSpecification partInstance = null;
			if (property != null && property.getDefaultValue() != null) {
				partInstance = ((InstanceValue) property.getDefaultValue())
						.getInstance();
				container = (Package) partInstance.eContainer();
			}
			if (property == null) {
				property = clazz.createOwnedAttribute(DEFAULT_INSTANCE_NAME,
						null);
			}
		} else {

			// root element is a deployment part
			property = (Property) rootEntry.getModelObject();

			if (property.getDefaultValue() != null) {
				InstanceSpecification partInstance = ((InstanceValue) property
						.getDefaultValue()).getInstance();
				container = (Package) partInstance.eContainer();
			}
		}
		if (container == null) {
			String containerName = NamingUtil.generateUniqueName("_" //$NON-NLS-1$
					+ rootEntry.getModelObjectName(), property.eContainer()
					.eContents());
			EObject partContainer = (EObject) property.eContainer();
			if (partContainer instanceof Component) {
				container = (Package) ((Component) partContainer)
						.createPackagedElement(containerName,
								UMLPackage.Literals.PACKAGE);
			} else {
				container = (Package) ((Package) partContainer)
						.createPackagedElement(containerName,
								UMLPackage.Literals.PACKAGE);
			}
		}
		return container;
	}

	protected Class getDeploymentPartDefinition(Property deploymentPart) {
		Object obj = ZDLUtil.getValue(deploymentPart,
				ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		if (obj == null) {
			return null;
		}
		Class definition;
		if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.CCMPART)) {
			definition = (Component) ((Property) obj).getType();
		} else if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.CCMCOMPONENT)
				|| ZDLUtil.isZDLConcept((EObject) obj,
						CCMNames.CONTAINER_PROCESS)) {
			definition = (Component) obj;
		} else if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.HOME)) {
			definition = (Class) obj;
		} else if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.HOME_INSTANCE)) {
			definition = (Class) ((Property) obj).getType();
		} else if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.NODE_INSTANCE)
				|| ZDLUtil
						.isZDLConcept((EObject) obj, CCMNames.BRIDGE_INSTANCE)
				|| ZDLUtil.isZDLConcept((EObject) obj,
						CCMNames.INTERCONNECT_INSTANCE)) {
			definition = (Component) ((Property) obj).getType();
		} else {
			return null;
		}
		return definition;
	}

	/**
	 * Create an instance specification to override default CCM properties.
	 * 
	 * @param entry
	 * @param container
	 */
	protected void saveValue(Slot containerSlot, IPropertyEntry entry,
			Package container) {
		InstanceSpecification propertyInstance = null;

		if (containerSlot != null) {
			if (entry.getModelObject() instanceof InstanceValue) {
				propertyInstance = ((InstanceValue) entry.getModelObject())
						.getInstance();
			} else {
				if (!containerSlot.getValues().isEmpty()) {
					propertyInstance = ((InstanceValue) containerSlot
							.getValues().get(0)).getInstance();
				}
			}
		} else {
			propertyInstance = getRootInstanceSpecification();
		}

		Type definition;
		if (entry.getModelObject() instanceof InstanceValue) {
			definition = ((Slot) entry.getModelObject().eContainer())
					.getDefiningFeature().getType();
		} else {
			definition = getModelDefinition(entry);
		}

		if (definition == null) {
			return;
		}
		String instanceName = definition.getName()
				+ Messages.CCMPropertiesDialog_InstancePostFix;
		if (propertyInstance == null) {
			propertyInstance = createRootInstanceSpecification(entry,
					containerSlot, container, definition, instanceName);

		}

		Iterator<IPropertyEntry> itor2;
		if (isCompositeType(definition)) {
			itor2 = entry.getChildren().iterator();
		} else {
			List<IPropertyEntry> allEntryList = new ArrayList<IPropertyEntry>();
			if (entry.getModelObject() instanceof Component) {
				allEntryList.addAll(entry.getChildren());
				itor2 = allEntryList.iterator();

			} else {
				for (IPropertyEntry e : entry.getChildren()) {
					allEntryList.addAll(e.getChildren());
				}
				itor2 = allEntryList.iterator();
			}
		}

		Map<NamedElement, Slot> slotMap = BaseUIUtil
				.getFeatureSlotMap(propertyInstance);
		while (itor2.hasNext()) {

			IPropertyEntry subEntry = itor2.next();

			if (subEntry.getModelObject() instanceof InstanceValue) {

				StructuralFeature feature = ((Slot) subEntry.getModelObject()
						.eContainer()).getDefiningFeature();
				if (feature.getType() != null
						&& !ZDLUtil.isZDLConcept(feature.getType(),
								CXDomainNames.CXSTRUCT)) {
					InstanceSpecification spec = ((InstanceValue) subEntry
							.getModelObject()).getInstance();
					ValueSpecification propertyValue = spec.getSpecification();
					if (propertyValue == null
							|| !(propertyValue instanceof LiteralString)) {
						if (propertyValue != null) {
							propertyValue.destroy();
						}
						propertyValue = (LiteralString) spec
								.createSpecification(null, null,
										UMLPackage.Literals.LITERAL_STRING);
					}
					((LiteralString) propertyValue).setValue(subEntry
							.getValue());
				} else {
					saveValue((Slot) subEntry.getModelObject().eContainer(),
							subEntry, container);
				}
				continue;
			}

			Property attribute = (Property) subEntry.getModelObject();

			if (attribute.getType() == null) {
				continue;
			}
			Slot destSlot = slotMap.get(attribute);
			if (destSlot != null && !isCompositeType(attribute.getType())) {
				Object[] valueArray = destSlot.getValues().toArray();

				for (int i = 0; i < valueArray.length; i++) {
					ValueSpecification value = (ValueSpecification) valueArray[i];
					if (value instanceof InstanceValue) {
						InstanceSpecification tempInstance = ((InstanceValue) value)
								.getInstance();
						value.destroy();
						if (tempInstance != null) {
							tempInstance.destroy();
						}
					}
				}
			}

			if (subEntry.isDefaultValue()
					&& !isCompositeType(attribute.getType())) {
				if (destSlot != null) {
					destSlot.destroy();
				}
				continue;
			}

			if (destSlot == null) {
				destSlot = propertyInstance.createSlot();
				destSlot.setDefiningFeature((StructuralFeature) ((Classifier) attribute
						.eContainer()).getFeature(attribute.getName()));
			}

			if (isCompositeType(attribute.getType())) {
				if (!((ZDLUtil.isZDLConcept(attribute.getType(),
						CXDomainNames.CXSEQUENCE) && subEntry == this) || (ZDLUtil
						.isZDLConcept(attribute.getType(),
								CXDomainNames.CXARRAY) && subEntry == this))) {
					saveValue(destSlot, subEntry, container);
					continue;
				}
			}

			instanceName = attribute.getType().getName()
					+ Messages.CCMPropertiesDialog_InstancePostFix;

			instanceName = NamingUtil.generateUniqueName(instanceName,
					container.getPackagedElements());

			InstanceSpecification attributeInstance = (InstanceSpecification) container
					.createPackagedElement(instanceName,
							UMLPackage.Literals.INSTANCE_SPECIFICATION);

			attributeInstance.getClassifiers().add(
					(Classifier) attribute.getType());

			LiteralString propertyValue = (LiteralString) attributeInstance
					.createSpecification(null, null,
							UMLPackage.Literals.LITERAL_STRING);

			propertyValue.setValue(subEntry.getValue());
			InstanceValue slotValue = (InstanceValue) destSlot.createValue(
					null, null, UMLPackage.Literals.INSTANCE_VALUE);
			slotValue.setInstance(attributeInstance);
		}

		if (propertyInstance.getSlots().isEmpty()
				&& !(entry.getModelObject() instanceof InstanceValue)) {
			if (containerSlot != null) {
				containerSlot.destroy();
			}

			propertyInstance.destroy();

			if (containerSlot == null
					&& entry.getModelObject() instanceof Property) {
				((Property) entry.getModelObject()).getDefaultValue().destroy();
			}
		}
	}

	protected Type getModelDefinition(IPropertyEntry entry) {
		Type definition = null;
		if (entry.getModelObject() instanceof Class) {
			// root element is a ccm component
			return (Type) entry.getModelObject();
		}
		Property property = (Property) entry.getModelObject();
		if (isCompositeType(property.getType())) {
			definition = property.getType();
		} else {
			definition = getDeploymentPartDefinition(property);
		}
		return definition;
	}

	/**
	 * Queries the root entry.
	 * 
	 * @return
	 */
	public IPropertyEntry getRootEntry() {
		IPropertyEntry entry = this;
		IPropertyEntry parent = getParent();
		while (parent != null) {
			entry = parent;
			parent = entry.getParent();
		}
		return entry;
	}

	/**
	 * Queries if the model element type is a sequence
	 */
	public boolean isMultiValue() {
		if (modelObject instanceof Property
				&& ((Property) modelObject).getType() != null) {
			return ZDLUtil.isZDLConcept(((Property) modelObject).getType(),
					CXDomainNames.CXSEQUENCE)
					|| ZDLUtil.isZDLConcept(((Property) modelObject).getType(),
							CXDomainNames.CXARRAY);
		}
		return false;
	}

	public static boolean isMultiValueDecendent(IPropertyEntry entry) {
		if (entry.isMultiValue()) {
			return true;
		}
		if (entry.getParent() != null) {
			return CCMPropertyEntry.isMultiValueDecendent(entry.getParent());
		}
		return false;
	}

	/**
	 * Add new child to this entry
	 */
	public IPropertyEntry addChild(EObject modelElement) {
		return new CCMPropertyEntry(this, modelElement);
	}

	/**
	 * Queries the hierarchy of elements with instance specification for given
	 * property
	 * 
	 * @param entry
	 * @return ancestor elements or null if not found
	 */
	public static List<EObject> getDefiningFeaturesForAncestorSlots(
			IPropertyEntry entry) {
		List<EObject> result = new ArrayList<EObject>();
		getDefiningFeaturesForAncestorSlots(entry, result);
		return result;
	}

	private static void getDefiningFeaturesForAncestorSlots(
			IPropertyEntry entry, List<EObject> result) {
		if (ZDLUtil.isZDLConcept(entry.getModelObject(), ZMLMMNames.PORT)) {
			result.add(entry.getModelObject());
		} else if (ZDLUtil.isZDLConcept(entry.getModelObject(),
				CCMNames.RESOURCE_PROPERTY)) {
			result.add(entry.getModelObject());
		} else if (ZDLUtil.isZDLConcept(entry.getModelObject(),
				CXDomainNames.CXATTRIBUTE)
				|| ZDLUtil.isZDLConcept(entry.getModelObject(),
						CXDomainNames.CXFIELD)
				|| ZDLUtil.isZDLConcept(entry.getModelObject(),
						CCMNames.PROPERTY)) {
			Property property = (Property) entry.getModelObject();
			if (property.getType() != null
					&& (ZDLUtil.isZDLConcept(property.getType(),
							CXDomainNames.CXSTRUCT)
							|| ZDLUtil.isZDLConcept(property.getType(),
									CXDomainNames.CXSEQUENCE) || ZDLUtil
								.isZDLConcept(property.getType(),
										CXDomainNames.CXARRAY))) {
				result.add(entry.getModelObject());
			}
		} else if (entry.getModelObject() instanceof ValueSpecification) {
			result.add(entry.getModelObject());
			result.add(((Slot) entry.getModelObject().eContainer())
					.getDefiningFeature());
		}
		if (entry.getParent() != null) {

			getDefiningFeaturesForAncestorSlots(entry.getParent(), result);
		}
	}

	/**
	 * Add new entry for sequence
	 */
	public void addSequenceMemberInstance() {
		if (!isMultiValue()) {
			return;
		}
		final List<EObject> list = getDefiningFeaturesForAncestorSlots(this);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(modelObject);
		ICommand command = new AbstractTransactionalCommand(editingDomain, Messages.CCMPropertiesDialog_ActionLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				EObject type = ((Property) modelObject).getType();
				Property member = CCMUtil.getMembersAttribute((DataType) type);
				Slot slot = getSequenceMemberSlot();
				if (slot == null) {
					setValue(UML2Util.EMPTY_STRING);
					Slot parentSlot = CCMUtil.getInstanceSlotForProperty(
							getRootInstanceSpecification(),
							(Property) modelObject, list);
					InstanceSpecification instance = ((InstanceValue) parentSlot
							.getValues().get(0)).getInstance();
					
					Command cmd = BaseUtil.getDeleteCommand(Collections.singleton(instance.getSpecification()));
					if (cmd.canExecute()) {
						TransactionUtil.getEditingDomain(modelObject).getCommandStack().execute(cmd);
					}
					slot = instance.createSlot();
					slot.setDefiningFeature(member);
				}
				if (ZDLUtil.isZDLConcept(type, CXDomainNames.CXARRAY)) {
					int bound = CORBAUtil.getBound(type);
					int slotSize = slot.getValues().size();
					for (int i = slotSize; i < bound; i++) {
						addMemberInstance(member, slot);
					}
					if (slotSize > bound) {
						for (int i = slotSize; i > bound; i--) {
							InstanceValue value = (InstanceValue) slot
									.getValues().remove(
											slot.getValues().size() - 1);
							// force remove instance value for this sequence
							// entry
							cleanInstanceValue(value, true);
						}
						cleanInstances();
					}
				} else {
					addMemberInstance(member, slot);
				}
				return CommandResult.newOKCommandResult();
			}
		};
		
		Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
		editingDomain.getCommandStack().execute(emfCommand);
	}

	private void addMemberInstance(Property member, Slot slot) {

		if (!URIConverter.INSTANCE.normalize(member.eResource().getURI())
				.isPlatformPlugin()
				&& (member.getUpper() != -1 || member.getLower() != 0)) {
			// fix member multiplicity
			member.setUpper(-1);
			member.setLower(0);
		}
		Type type = slot.getDefiningFeature().getType();
		if (type == null) {
			return;
		}

		Package container = getRootInstanceContainer();
		String instanceName = type.getName()
				+ Messages.CCMPropertiesDialog_InstancePostFix;

		instanceName = NamingUtil.generateUniqueName(instanceName,
				container.getPackagedElements());
		InstanceSpecification memberInstance = (InstanceSpecification) container
				.createPackagedElement(instanceName,
						UMLPackage.Literals.INSTANCE_SPECIFICATION);

		memberInstance.getClassifiers().add((Classifier) member.getType());
		InstanceValue slotValue = (InstanceValue) slot.createValue(null, null,
				UMLPackage.Literals.INSTANCE_VALUE);
		slotValue.setInstance(memberInstance);
	}

	/**
	 * Remove last entry from the sequence
	 */
	public void removeSequenceMemberInstance() {
		if (!isMultiValue()) {
			return;
		}
		List<EObject> definingFeatures = CCMPropertyEntry.getDefiningFeaturesForAncestorSlots(this);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(modelObject);
		ICommand command = new AbstractTransactionalCommand(editingDomain, Messages.CCMPropertiesDialog_ActionLabel,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				Slot slot = getSequenceMemberSlot();
				if (slot == null) {
					return CommandResult.newOKCommandResult();
				}
				EObject type = ((Property) modelObject).getType();
				if (ZDLUtil.isZDLConcept(type, CXDomainNames.CXARRAY)) {
					Iterator<ValueSpecification> itor = slot.getValues()
							.iterator();
					while (itor.hasNext()) {
						InstanceValue value = (InstanceValue) itor.next();
						itor.remove();
						cleanInstanceValue(value, true);
					}
					cleanInstances();
				} else {
					if (!slot.getValues().isEmpty()) {
						InstanceValue value = (InstanceValue) slot.getValues()
								.remove(slot.getValues().size() - 1);
						// force remove instance value for this sequence entry
						cleanInstanceValue(value, true);
					}

					if (slot.getValues().isEmpty()) {
						editingDomain.getCommandStack().execute(BaseUtil.getDeleteCommand(slot));
						InstanceSpecification partInstance = getRootInstanceSpecification();
						Slot propertySlot = CCMUtil.getInstanceSlotForProperty(partInstance, (Property) modelObject, definingFeatures);
						Iterator<ValueSpecification> itor = propertySlot.getValues().iterator();
						while (itor.hasNext()) {
							InstanceValue value = (InstanceValue) itor.next();
							itor.remove();
							cleanInstanceValue(value, true);
						}
						editingDomain.getCommandStack().execute(BaseUtil.getDeleteCommand(propertySlot));
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		
		Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
		editingDomain.getCommandStack().execute(emfCommand);
	}

	/**
	 * clean instance specifications that might be left empty
	 */
	protected void cleanInstances() {
		IPropertyEntry entry = getRootEntry();
		Property property = null;
		InstanceValue instanceValue = null;

		if (entry.getModelObject() instanceof Component) {
			property = ((Component) entry.getModelObject()).getOwnedAttribute(
					DEFAULT_INSTANCE_NAME, null);
		} else {
			property = (Property) entry.getModelObject();
		}

		if (property != null && property.getDefaultValue() != null) {
			instanceValue = (InstanceValue) property.getDefaultValue();
		}
		if (instanceValue == null) {
			return;
		}
		Package container = getRootInstanceContainer();
		cleanInstanceValue(instanceValue, false);
		if (container.getPackagedElements().isEmpty()) {
			List<EObject> toDelete = new ArrayList<EObject>();
			toDelete.add(container);
			if (entry.getModelObject() instanceof Component) {
				toDelete.add(property);
			}
			Command cmd = BaseUtil.getDeleteCommand(toDelete);
			if (cmd.canExecute()) {
				TransactionUtil.getEditingDomain(property).getCommandStack().execute(cmd);
			}
		}
	}

	/**
	 * Queries if the given instance value belongs to member slot
	 * 
	 * @param instanceValue
	 * @return
	 */
	private boolean isMemberInstanceValue(InstanceValue instanceValue) {
		if (instanceValue.eContainer() instanceof Slot) {
			String featureName = ((Slot) instanceValue.eContainer())
					.getDefiningFeature().getName();
			if (CXDomainNames.CXSTRUCT__MEMBERS.equals(featureName)
					|| "member" //$NON-NLS-1$
					.equals(featureName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Clean instance value recursively going through all of its slot members
	 * 
	 * @param instanceValue
	 *            instance value to clean
	 * @param cleanMemberInstanceValue
	 *            delete instance value when this instance value belong to
	 *            member slot
	 */
	protected void cleanInstanceValue(InstanceValue instanceValue,
			boolean cleanMemberInstanceValue) {

		boolean memberInstanceValue = isMemberInstanceValue(instanceValue);
		InstanceSpecification instance = instanceValue.getInstance();
		if (instance == null) {
			return;
		}

		cleanInstanceSpecification(instance, cleanMemberInstanceValue,
				memberInstanceValue);
		if (instance.getSlots().isEmpty()
				&& (instance.getSpecification() == null || cleanMemberInstanceValue)) {
			if (memberInstanceValue && !cleanMemberInstanceValue) {
				return;
			}
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(instanceValue);
			if (domain == null) {
				EcoreUtil.delete(instanceValue);
			} else {
				Command cmd = BaseUtil.getDeleteCommand(Collections.singleton(instanceValue));
				if (cmd.canExecute()) {
					domain.getCommandStack().execute(cmd);
				}
			}
		}
	}

	/**
	 * Helper method to clean instance specification recursively
	 * 
	 * @param instance
	 * @param cleanMemberInstanceValue
	 *            flag to clean member instance value
	 * @param isMemberInstanceValueInstance
	 *            set to true if this instance belong to member instance value
	 */
	protected void cleanInstanceSpecification(InstanceSpecification instance,
			boolean cleanMemberInstanceValue,
			boolean isMemberInstanceValueInstance) {
		Map<String, Slot> map = BaseUIUtil.getSlotMap(instance);
		List<EObject> toDelete = new ArrayList<EObject>();
		for (String p : map.keySet()) {
			Slot slot = map.get(p);
			Object[] values = slot.getValues().toArray();
			for (Object v : values) {
				cleanInstanceValue((InstanceValue) v, cleanMemberInstanceValue);
			}
			Iterator<ValueSpecification> itor = slot.getValues().iterator();
			while (itor.hasNext()) {
				if (itor.next() == null) {
					itor.remove();
				}
			}
			if (slot.getValues().isEmpty()) {
				toDelete.add(slot);
			}
		}
		if (instance.getSlots().isEmpty()
				&& (instance.getSpecification() == null || cleanMemberInstanceValue)) {
			if (!cleanMemberInstanceValue && isMemberInstanceValueInstance) {
				return;
			}
			toDelete.add(instance);
		}
		Command cmd = BaseUtil.getDeleteCommand(toDelete);
		if(cmd.canExecute()) {
			TransactionUtil.getEditingDomain(modelObject).getCommandStack().execute(cmd);
		}
	}

	/**
	 * Return Sequence member slot if it exists
	 * 
	 * @return
	 */
	public Slot getSequenceMemberSlot() {
		if (modelObject instanceof Property) {
			Type type = ((Property) modelObject).getType();
			if (type != null
					&& (ZDLUtil.isZDLConcept(type,
							CXDomainNames.CXSEQUENCE) || ZDLUtil
							.isZDLConcept(type, CXDomainNames.CXARRAY))) {
				DataType sequence = (DataType) type;
				InstanceSpecification partInstance = getRootInstanceSpecification();
				if (partInstance != null) {
					Property members = CCMUtil.getMembersAttribute(sequence);
					return CCMUtil.getInstanceSlotForProperty(partInstance,
							members, CCMPropertyEntry
									.getDefiningFeaturesForAncestorSlots(this));
				}
			}
		}
		return null;
	}

	/**
	 * Migrate old style primitive sequence values
	 */
	public void migrateSequenceValue() {
		if (modelObject instanceof Property && isMultiValue()) {
			Type type = ((Property) modelObject).getType();
			if (type != null
					&& ZDLUtil.isZDLConcept(type,
							CXDomainNames.CXSEQUENCE)) {
				final DataType sequence = (DataType) type;
				InstanceSpecification partInstance = getRootInstanceSpecification();
				if (partInstance != null) {
					final Slot slot = CCMUtil.getInstanceSlotForProperty(
							partInstance, (Property) modelObject,
							CCMPropertyEntry
									.getDefiningFeaturesForAncestorSlots(this));
					if (slot != null && !slot.getValues().isEmpty()) {

						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(modelObject);
						ICommand command = new AbstractTransactionalCommand(editingDomain,
								Messages.CCMPropertiesDialog_ActionLabel, null) {

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								InstanceValue value = (InstanceValue) slot
										.getValues().get(0);
								String sequenceValue = CCMUtil
										.getValueFromValueSpecification(value);

								if (UML2Util.isEmpty(sequenceValue)
										|| !value.getInstance().getSlots()
												.isEmpty()) {
									return CommandResult.newOKCommandResult();
								}

								// parse old comma separated sequence values
								sequenceValue = sequenceValue.replaceAll(
										"\"", ""); //$NON-NLS-1$//$NON-NLS-2$
								String[] splits = sequenceValue.split(","); //$NON-NLS-1$

								Property membersAttribute = CCMUtil
										.getMembersAttribute(sequence);
								Slot memberSlot = null;
								if (splits.length == 0
										|| sequenceValue.isEmpty()
										|| membersAttribute == null) {
									return CommandResult.newOKCommandResult();
								}
								memberSlot = value.getInstance().createSlot();
								memberSlot.setDefiningFeature(membersAttribute);
								if (!URIConverter.INSTANCE.normalize(
										membersAttribute.eResource().getURI())
										.isPlatformPlugin()
										&& (membersAttribute.getUpper() != -1 || membersAttribute
												.getLower() != 0)) {
									// fix member multiplicity
									membersAttribute.setUpper(-1);
									membersAttribute.setLower(0);
								}
								for (String val : splits) {
									if (!UML2Util.isEmpty(val)) {

										Package container = getRootInstanceContainer();
										String instanceName = membersAttribute
												.getType().getName()
												+ Messages.CCMPropertiesDialog_InstancePostFix;

										instanceName = NamingUtil
												.generateUniqueName(
														instanceName,
														container
																.getPackagedElements());

										InstanceSpecification attributeInstance = (InstanceSpecification) container
												.createPackagedElement(
														instanceName,
														UMLPackage.Literals.INSTANCE_SPECIFICATION);

										attributeInstance.getClassifiers().add(
												(Classifier) membersAttribute
														.getType());

										LiteralString propertyValue = (LiteralString) attributeInstance
												.createSpecification(
														null,
														null,
														UMLPackage.Literals.LITERAL_STRING);
										propertyValue.setValue(val);

										InstanceValue slotValue = (InstanceValue) memberSlot
												.createValue(
														null,
														null,
														UMLPackage.Literals.INSTANCE_VALUE);
										slotValue
												.setInstance(attributeInstance);
									}
								}
								Command cmd = BaseUtil.getDeleteCommand(
										Collections.singletonList(value.getInstance().getSpecification()));
								TransactionUtil.getEditingDomain(modelObject).getCommandStack().execute(cmd);

								return CommandResult.newOKCommandResult();
							}
						};

						Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
						editingDomain.getCommandStack().execute(emfCommand);
					}
				}
			}
		}
	}

	@Override
	public IPropertyEntry createNewEntry(EObject element) {
		return new CCMPropertyEntry(element);
	}
}
