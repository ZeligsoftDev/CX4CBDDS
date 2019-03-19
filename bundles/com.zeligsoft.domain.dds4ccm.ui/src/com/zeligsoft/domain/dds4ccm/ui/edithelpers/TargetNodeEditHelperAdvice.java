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
package com.zeligsoft.domain.dds4ccm.ui.edithelpers;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationModelTypeUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.dds4ccm.utils.PropertyVariable;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierProperty;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierPropertyKind;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAString;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;

/**
 * Edit helper to set or create resource property for CIAO+DAnCE type node.
 * 
 * @author ysroh
 * 
 */
public class TargetNodeEditHelperAdvice extends AbstractEditHelperAdvice {

	private static final String INSTANCE_POSTFIX = "Instance"; //$NON-NLS-1$

	private static final String SATISFIER_PROPERTY_VALUE = "corbaloc:iiop:localhost:60070"; //$NON-NLS-1$

	
	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"SetResourceType", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = request.getNewElement();
				EObject container = request.getContainer();
				if (newEObject == null) {
					return null;
				}

				if (!ZDLUtil.isZDLConcept(newEObject, CCMNames.NODE)) {
					return null;
				}

				Component node = (Component) newEObject;

				EObject resource = findTargetResource(newEObject);
				Property satisfierProperty;
				final String modelType = DDS4CCMUtil.getModelType((Element) container);
				if (resource != null) {
					satisfierProperty = getSatisfierProperty(resource, modelType);										
				} else {

					// Going to create a new NodeAddress 'Resource'. Generate a unique name for it.
					final String nodeAddressName = NamingUtil.generateUniqueName("NodeAddress", //$NON-NLS-1$
							container.eContents());
					// Create the Resource in the container
					final Resource nodeAddress = ZDLFactoryRegistry.INSTANCE
							.create(ZDLUtil.createZDLConceptIn(container,
									CCMNames.RESOURCE), Resource.class);
					nodeAddress.setName(nodeAddressName);
					
					// The resource needs a NodeAddress 'satisfierProperty..
					final SatisfierProperty satisfierProp = nodeAddress.addProperty();
					satisfierProp.setKind(SatisfierPropertyKind.ATTRIBUTE);
					final String satisfierPropName = PropertyVariable.NODE_IOR.getName(modelType);	//	DDS4CCMUtil.getPropertyName(modelType, PropertyVariable.NODE_IOR);
					
					satisfierProp.setName(satisfierPropName);
					satisfierProp.setTypeOverride(ZDLFactoryRegistry.INSTANCE
							.create(CORBAUtil.getCORBAPrimitiveType(
									nodeAddress.asClass(), "CORBAString"),
									CORBAString.class));
					
					// set values used in code below
					resource = nodeAddress.asClass();
					satisfierProperty = satisfierProp.asProperty();				
				}

				// create resource property
				Property resourceProperty = node.createOwnedAttribute(
						"resourceProperty", null); //$NON-NLS-1$
				ZDLUtil.addZDLConcept(resourceProperty,
						CCMNames.RESOURCE_PROPERTY);
				ZDLUtil.setValue(resourceProperty, CCMNames.RESOURCE_PROPERTY,
						CCMNames.RESOURCE_PROPERTY__TYPE, resource);

				
				// create default value
				Package instanceContainer = (Package) node
						.createPackagedElement(
								NamingUtil
										.generateUniqueName(
												"_" + node.getName(), node.getPackagedElements()), UMLPackage.Literals.PACKAGE); //$NON-NLS-1$
				String nodeInstanceName = NamingUtil.generateUniqueName(
						node.getName() + INSTANCE_POSTFIX,
						instanceContainer.getPackagedElements());
				InstanceSpecification nodeInstance = (InstanceSpecification) instanceContainer
						.createPackagedElement(nodeInstanceName,
								UMLPackage.Literals.INSTANCE_SPECIFICATION);
				nodeInstance.getClassifiers().add((Classifier) node);

				Slot nodeSlot = nodeInstance.createSlot();
				nodeSlot.setDefiningFeature((StructuralFeature) ((Classifier) resourceProperty
						.eContainer()).getFeature(resourceProperty.getName()));
				Property defaultInstanceAttr = node.createOwnedAttribute(
						CCMUtil.DEFAULT_PROPERTY_INSTANCE_NAME, null);

				String resourceInstanceName = NamingUtil.generateUniqueName(
						((Class) resource).getName() + INSTANCE_POSTFIX,
						instanceContainer.getPackagedElements());
				InstanceSpecification resourceInstance = (InstanceSpecification) instanceContainer
						.createPackagedElement(resourceInstanceName,
								UMLPackage.Literals.INSTANCE_SPECIFICATION);
				resourceInstance.getClassifiers().add((Classifier)resource);

				InstanceValue value = (InstanceValue) nodeSlot.createValue(
						null, null, UMLPackage.Literals.INSTANCE_VALUE);
				value.setInstance(resourceInstance);

				Slot satisfierSlot = resourceInstance.createSlot();
				satisfierSlot
						.setDefiningFeature((StructuralFeature) ((Classifier) satisfierProperty
								.eContainer()).getFeature(satisfierProperty
								.getName()));

				InstanceSpecification attributeInstance = (InstanceSpecification) instanceContainer
						.createPackagedElement(satisfierProperty.getName()
								+ INSTANCE_POSTFIX,
								UMLPackage.Literals.INSTANCE_SPECIFICATION);

				attributeInstance.getClassifiers().add(
						(Classifier) satisfierProperty.getType());

				LiteralString propertyValue = (LiteralString) attributeInstance
						.createSpecification(null, null,
								UMLPackage.Literals.LITERAL_STRING);

				propertyValue.setValue(SATISFIER_PROPERTY_VALUE);
				InstanceValue slotValue = (InstanceValue) satisfierSlot
						.createValue(null, null,
								UMLPackage.Literals.INSTANCE_VALUE);
				slotValue.setInstance(attributeInstance);

				value = (InstanceValue) defaultInstanceAttr.createDefaultValue(
						null, null, UMLPackage.Literals.INSTANCE_VALUE);

				value.setInstance(nodeInstance);

				return CommandResult.newOKCommandResult(newEObject);
			}
		};
	}

	/**
	 * Find Resource for CIAO+DAnCE node property type
	 * 
	 * @param context
	 * @return
	 */
	private EObject findTargetResource(EObject context) throws ExecutionException{
		EObject root = EcoreUtil.getRootContainer(context);
		TreeIterator<Object> itor = EcoreUtil.getAllContents(root, true);
		while (itor.hasNext()) {
			Object obj = itor.next();
			if (!(obj instanceof EObject)) {
				continue;
			}
			if (!(obj instanceof Package) && !(obj instanceof Class)) {
				itor.prune();
				continue;
			}
			if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.RESOURCE)) {
				Property satisfierProperty = getSatisfierProperty((Class)obj, DDS4CCMUtil.getModelType((Class)obj));
				if (satisfierProperty != null) {
					return (EObject) obj;
				}
				/**
				 * satisfierProperty = ((Class) resource).getOwnedAttribute(
							SATISFIER_PROPERTY_NAME, null);
				 * */
			}
		}
		return null;
	}
	
	/**
	 * Find model type specific satisfierProperty for a given NodeAddress
	 * 
	 *  @param resource
	 *  			represents a NodeAddress
	 *  @param modelType
	 *  			type of the model: ATCD or AXCIOMA
	 *  @return	modelType specific StringIOR property instance for the NodeAddress
	 */	
	private Property getSatisfierProperty(EObject resource, String modelType) throws ExecutionException{
		
		final Resource nodeAddress = ZDLFactoryRegistry.INSTANCE.create(resource, Resource.class);
		Property satisfierProperty = null;
		for(SatisfierProperty sp : nodeAddress.getProperty()) {
			if(PropertyVariable.NODE_IOR.matches(sp.getName(), modelType)) {							
				satisfierProperty = sp.asProperty();
				break;
			}
		}
		if(satisfierProperty == null){
			throw new ExecutionException("Model is not well formed. Resource instance found without having a StringIOR property");
		}
		return satisfierProperty;
		
	}
}
