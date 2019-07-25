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

package com.zeligsoft.domain.zml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.l10n.Messages;

/**
 * Supporting utility helper for Zeligsoft Deployment models. *
 * 
 * @author smcfee
 * 
 */
public class ZDeploymentUtil {
	
	/**
	 * Returns the qualified name of the deployment part.
	 * 
	 * @param part
	 * @return
	 */
	public static String getQualifiedName(Property part) {
		if( ZDeploymentUtil.getParentPart(part) == null) {
			return part.getName();
		}
		Property dp = part;
		String qn = ""; //$NON-NLS-1$
		while( dp != null ) {
			Property pdp = ZDeploymentUtil.getParentPart(dp);
			if( pdp == null) {
				qn = dp.getName() + qn;
			} else {
				qn = " :: " + ZDeploymentUtil.getModelElement(dp).getName() + qn; //$NON-NLS-1$
			}
			dp = pdp;					
		}
		return qn;
	}

	/**
	 * Given a deployment part, returns its deployment. This is always the owner
	 * in the current metamodel but an API is provided in case this changes.
	 * 
	 * @param deploymentPart
	 */
	public static Component getDeployment(Property deploymentPart) {
		if (!isDeploymentPart(deploymentPart))
			return null;

		return (Component) deploymentPart.getOwner();
	}

	/**
	 * Function to return the configuration for a passed deployment part.
	 * 
	 * @param deploymentPart
	 * @return Null if the passed deployment part is not a deployment part.
	 */
	public static InstanceSpecification getConfiguration(Property deploymentPart) {
		if (!isDeploymentPart(deploymentPart))
			return null;

		Object config = ZDLUtil.getValue(deploymentPart,
			ZMLMMNames.DEPLOYMENT_PART,
			ZMLMMNames.DEPLOYMENT_PART__CONFIGURATION);
		if (config instanceof InstanceSpecification)
			return (InstanceSpecification) config;

		return null;
	}

	/**
	 * Function to return the model element for a passed deployment part.
	 * 
	 * @param deploymentPart
	 * @return The model element.
	 */
	public static NamedElement getModelElement(Property deploymentPart) {
		if (!isDeploymentPart(deploymentPart))
			return null;

		Object modelElement = ZDLUtil.getValue(deploymentPart,
			ZMLMMNames.DEPLOYMENT_PART,
			ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		if (modelElement instanceof NamedElement)
			return (NamedElement) modelElement;

		return null;
	}

	/**
	 * 
	 * @param deploymentPart
	 * @return
	 */
	public static Component getModelComponent(Property deploymentPart) {
		if (deploymentPart.getType() instanceof Component)
			return (Component) deploymentPart.getType();

		return null;

	}

	/**
	 * Factory-like function to create and return a deployment.
	 */
	public static Component createDeployment(org.eclipse.uml2.uml.Package package1, String deploymentName) {
		Component newDeployment = (Component) ZDLUtil.createZDLConcept(package1,
			ZMLMMNames.DEPLOYMENT);
		newDeployment.setName(deploymentName);

		package1.getPackagedElements().add(newDeployment);

		return newDeployment;
	}

	/**
	 * Factory-like function to create and return a deployment part.
	 * 
	 * @param deployment
	 *            The deployment in which this part will be added.
	 * @param modelElement
	 *            The model element to base the deployment part from. If this is
	 *            not a Component, Property, or Connector an exception will be
	 *            thrown.
	 * @param parentPart
	 * 			The part to which the deployment part will be a child. Can be null for a top-level part.
	 * @return
	 */
	public static Property createDeploymentPart(Component deployment,
			NamedElement modelElement, Property parentPart, String conceptString) {
		
		Property deploymentPart = null;
		boolean isDeploymentComponentPart = false;
		String partName = modelElement.getName();
		int nameInteger = 2;
		while( deployment.getMember(partName) != null) {
			partName = modelElement.getName() + "_" + Integer.toString(nameInteger++); //$NON-NLS-1$
		}

		if (modelElement instanceof Component) {
			deploymentPart = deployment.createOwnedAttribute(partName,
					(Component) modelElement);
			if (ZDLUtil.isZDLConcept(modelElement,
					ZMLMMNames.STRUCTURAL_REALIZATION)
					|| ZDLUtil.isZDLConcept(modelElement,
							ZMLMMNames.COMPONENT_INTERFACE)) {
				isDeploymentComponentPart = true;
			}
		}
		else if (modelElement instanceof Property) {
			deploymentPart = deployment.createOwnedAttribute(partName, ((Property) modelElement).getType());
			Property property = (Property) modelElement;
			if (ZDLUtil.isZDLConcept(property.getType(),ZMLMMNames.STRUCTURAL_REALIZATION)
				|| ZDLUtil.isZDLConcept(property.getType(),ZMLMMNames.COMPONENT_INTERFACE)) {
				isDeploymentComponentPart = true;
			}
		} 
		else if (modelElement instanceof Connector) {
			deploymentPart = deployment.createOwnedAttribute(partName,
				((Connector) modelElement).getType());
		} 
		else {
			throw new IllegalArgumentException(
				Messages.ZDeploymentUtil_CreateDeploymentPartErrorMsg
					+ " " + modelElement.getClass()); //$NON-NLS-1$ 
		}
		
		if (isDeploymentComponentPart) {
			String conceptStringToApply = ZMLMMNames.COMPONENT_DEPLOYMENT_PART;
			if (conceptString != null) {
				conceptStringToApply = conceptString;
			}
			ZDLUtil.addZDLConcept(deploymentPart, conceptStringToApply);
			ZDLUtil.setValue(deploymentPart,
					ZMLMMNames.COMPONENT_DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT, modelElement);

			// Set the selected implementation of the component deployment part
			// only if there is only one attached to the definition of the part
			if(ZDLUtil.isZDLConcept(modelElement, "SCA::SCA_SoftwarePackage::SCAPart")){ //$NON-NLS-1$
				EObject definition = (EObject) ZDLUtil.getValue(modelElement, "SCA::SCA_SoftwarePackage::SCAPart", "definition"); //$NON-NLS-1$ //$NON-NLS-2$
				if(definition != null && ZDLUtil.isZDLConcept(definition, ZMLMMNames.STRUCTURAL_REALIZATION)){
					List<NamedElement> potentialImplementations = new ArrayList<NamedElement>();
					for (Setting s : UML2Util.getInverseReferences(definition)) {
						if (s.getEObject() instanceof Manifestation) {
							Manifestation m = (Manifestation) s.getEObject();
							for (NamedElement ne : m.getClients()) {
								if (ZDLUtil.isZDLConcept(ne, "SCA::SCA_SoftwarePackage::SCAImplementation") && !potentialImplementations.contains(ne)) { //$NON-NLS-1$
									potentialImplementations.add(ne);
									if (potentialImplementations.size() > 1) {
										break;
									}
								}
							}
							if (potentialImplementations.size() > 1) {
								break;
							}
						}
					}
					if (potentialImplementations.size() == 1) {
						ZDLUtil.setValue(
							deploymentPart,
							ZMLMMNames.COMPONENT_DEPLOYMENT_PART,
							ZMLMMNames.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION,
							potentialImplementations.get(0));
					}
				}
			}
		} else {
			String conceptStringToApply = ZMLMMNames.DEPLOYMENT_PART;
			if( conceptString != null ) {
				conceptStringToApply = conceptString;
			}
			ZDLUtil.addZDLConcept(deploymentPart, conceptStringToApply);
			ZDLUtil.setValue(deploymentPart, ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT, modelElement);
		}

		if (parentPart != null) {
			setParentPart(deploymentPart, parentPart);
		}

		return deploymentPart;
	}

	/**
	 * Returns the parent part of a sub-component, or null if there is no
	 * parent.
	 * 
	 * @param part
	 */
	public static Property getParentPart(Property part) {
		List<EObject> referencing = ZDLUtil.getInverseReferences(part,
			ZMLMMNames.DEPLOYMENT_PART,
			ZMLMMNames.DEPLOYMENT_PART__NESTED_PART);
		if (referencing.size() > 0)
			return (Property) referencing.get(0);

		return null;
	}
	
	/**
	 * Sets the parent part of a sub-component (by adding it to the child list
	 * of its parent-to-be)
	 * 
	 * @param sc1
	 * @param parentPart
	 */
	@SuppressWarnings("unchecked")
	public static void setParentPart(Property sc1, Property parentPart) {
		EList<EObject> children = (EList<EObject>) ZDLUtil.getValue(parentPart,
			ZMLMMNames.DEPLOYMENT_PART,
			ZMLMMNames.DEPLOYMENT_PART__NESTED_PART);
		children.add(sc1);
	}

	/**
	 * 
	 * @param part
	 * @return Returns true if the part passed is a deployment part, otherwise
	 *         false.
	 */
	public static boolean isDeploymentPart(NamedElement part) {
		if (part == null)
			return false;

		return ZDLUtil.isZDLConcept(part, ZMLMMNames.DEPLOYMENT_PART);
	}

	/**
	 * Get the list of deployment parts in a deployment.
	 * 
	 * @param deployment
	 * @return Returns a list of deployment parts.
	 */
	public static Collection<Property> getDeploymentParts(Component deployment) {
		List<Property> retVal = new ArrayList<Property>();

		for (Property part : deployment.getOwnedAttributes()) {
			if (isDeploymentPart(part)) {
				retVal.add(part);
			}
		}

		return retVal;
	}
	
	/**
	 * Get the list of root deployment parts in a deployment.
	 * The root deployment parts must be deployable elements, or
	 * StructuredClassifiers with ownedAttributes that are
	 * deployable elements.
	 * 
	 * @param Component deployment
	 * @return Collection<Property>
	 */
	public static Collection<Property> getRootDeployableParts(
			Component deployment) {
		
		List<Property> retVal = new ArrayList<Property>();
		for (Property property : getDeploymentParts(deployment)) {
			Type propertyType = property.getType();
			if ((getParentPart(property) == null)
					&& (propertyType != null) ){	
				
				//If the property type is a deployable element, 
				//add the property to the collection.
				if (ZDLUtil.isZDLConcept(propertyType, ZMLMMNames.DEPLOYABLE_ELEMENT)){
					retVal.add(property);					
				}
				
				//If the property type is a StructuredClassifier and 
				//has an owned attribute that is a deployable element,
				//add the property to the collection.
				else if (propertyType instanceof StructuredClassifier){
					StructuredClassifier classifier = (StructuredClassifier) propertyType;
					EList<Property> ownedAttributes = classifier.getOwnedAttributes();
					
					for (Property ownedProperty : ownedAttributes) {
						if ((ownedProperty.getType()!= null) 
								&& (ZDLUtil.isZDLConcept(ownedProperty.getType(), ZMLMMNames.DEPLOYABLE_ELEMENT))){
							retVal.add(property);
							break;
						}		
					}						
				}				
			}
		}
		return retVal;
	}


	/**
	 * Get the list of root deployment parts in a deployment.
	 * 
	 * @param deployment
	 * @return Returns a list of deployment parts.
	 */
	public static Collection<Property> getRootDeploymentParts(
			Component deployment) {
		List<Property> retVal = new ArrayList<Property>();

		for (Property part : getDeploymentParts(deployment)) {
			if (getParentPart(part) == null) {
				retVal.add(part);
			}
		}

		return retVal;
	}

	/**
	 * Returns a list of allocations in the passed deployment.
	 * 
	 * @param deployment
	 * @return
	 */
	public static Collection<Dependency> getAllocations(Component deployment) {
		List<Dependency> retVal = new ArrayList<Dependency>();

		for (PackageableElement pkgElem : deployment.getPackagedElements()) {
			if (ZDLUtil.isZDLConcept(pkgElem, ZMLMMNames.ALLOCATION)) {
				retVal.add((Dependency) pkgElem);
			}
		}

		return retVal;
	}

	/**
	 * Gets the list of children parts for a given deployment part.
	 * 
	 * @param prop
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Collection<Property> getDeploymentChildren(Property prop) {
		return (List<Property>) ZDLUtil.getValue(prop,
			ZMLMMNames.DEPLOYMENT_PART,
			ZMLMMNames.DEPLOYMENT_PART__NESTED_PART);
	}

	/**
	 * Returns the deployment part in a given deployment that references the
	 * passed model element.
	 * 
	 * This is not guaranteed to be unique (for example multiple deployment
	 * parts referencing the same property).
	 * 
	 * @param deployment
	 * @param modelElement
	 * @return
	 */
	public static List<Property> getDeploymentPartForModelElement(
			Component deployment, NamedElement modelElement) {
		List<Property> returnValue = new ArrayList<Property>();

		Collection<Property> nestedParts = getDeploymentParts(deployment);

		for (Property deploymentPart : nestedParts) {
			if (getModelElement(deploymentPart) == modelElement) {
				returnValue.add(deploymentPart);
			}
		}

		return returnValue;
	}

	/**
	 * Returns all the deployments in a given model.
	 * 
	 * @param model
	 * @return
	 */
	public static Collection<Object> getDeploymentsForModel(Model model) {
		ArrayList<Object> retVal = new ArrayList<Object>();

		for (PackageableElement pe : model.getPackagedElements()) {
			if (pe instanceof Component) {
				if (ZDLUtil.isZDLConcept(pe, ZMLMMNames.DEPLOYMENT)) {
					retVal.add(pe);
				}
			}
			else if (pe instanceof Package){
				retVal.addAll(getDeploymentsForPackage((Package)pe));
			}
		}

		return retVal;
	}
	
	/**
	 * Returns all the deployments in a given package.
	 * 
	 * @param org.eclipse.uml2.uml.Package package
	 * @return Collection<Object>
	 */
	public static Collection<Object> getDeploymentsForPackage(org.eclipse.uml2.uml.Package package1) {
		ArrayList<Object> retVal = new ArrayList<Object>();

		for (PackageableElement pe : package1.getPackagedElements()) {
			if (pe instanceof Component) {
				if (ZDLUtil.isZDLConcept(pe, ZMLMMNames.DEPLOYMENT)) {
					retVal.add(pe);
				}
			}
			else if (pe instanceof Package){
				retVal.addAll(getDeploymentsForPackage((Package)pe));
			}
		}

		return retVal;
	}

	/**
	 * Builds a deployment part and all relevant substructure out of a passed
	 * model element.
	 * 
	 * @param partToCreate
	 *            The model element out of which we are creating the deployment
	 *            part.
	 * @param deployment
	 *            The deployment in which this part is to be added.
	 * @param modelParent
	 *            The parent of the model element so that it can be determined
	 *            where to put the deployment part in the hierarchy. If the
	 *            deployment part is to be created at the root this will be
	 *            null.
	 * 
	 * @return
	 */
	public static Property buildDeploymentPartFromModelElement(
			NamedElement partToCreate, Component deployment,
			NamedElement modelParent, NamedElement selectedStructuralRealization) {

		Property parentPart = null;
		if (modelParent != null) {
			// If the modelParent passed in is not null, there must be a part in
			// this deployment that can serve as the logical parent in order to
			// add this part.
			for (Property part : ZDeploymentUtil.getDeploymentParts(deployment)) {
				NamedElement possibleModelElement = ZDeploymentUtil
					.getModelComponent(part);
				if (possibleModelElement == modelParent) {
					parentPart = part;
				} else if (possibleModelElement != null
					&& ZDLUtil.isZDLConcept(possibleModelElement,
						ZMLMMNames.COMPONENT_INTERFACE)) {
					Component candidateComponentRealization = null;
					ArrayList<Component> srList = ZDeploymentUtil
						.getStructuralRealizations((Component) possibleModelElement);
					if (srList.size() > 0) {
						candidateComponentRealization = srList.get(0);
					}

					if (candidateComponentRealization == modelParent) {
						parentPart = part;

					}
				}
			}
			if (parentPart == null) {
				// There is no valid place to put the deployment part.
				return null;
			} else if (partToCreate instanceof Property) {
				for (Property child : getDeploymentChildren(parentPart)) {
					Element childModelElement = getModelElement(child);
					if (childModelElement instanceof Property
							&& ((Property) childModelElement).getName() == ((Property) partToCreate)
									.getName()
							&& ((Property) childModelElement).getType() == ((Property) partToCreate)
									.getType()) {
						return null;
					}
				}
			}
		}
		Property newPart = createDeploymentPart(deployment, partToCreate, parentPart, null );
				//ValidationUtil.getLinkContext(LinkConstraintContext.DEPLOYMENT_PART, partToCreate, parentPart));

		synchronizeDeploymentParts(newPart);

		Component structuralRealization = null;
		if (modelParent != null
			&& ZDLUtil.isZDLConcept(modelParent,
				ZMLMMNames.STRUCTURAL_REALIZATION)) {
			// throw new Exception... this should not be a SR
		} else if (selectedStructuralRealization instanceof Component) {
			structuralRealization = (Component) selectedStructuralRealization;
		}

		if (partToCreate instanceof Component) {
			buildDeploymentSubstructureBasedOnComponent(
				(Component) partToCreate, newPart, structuralRealization);
		} else if (partToCreate instanceof Property
			&& ((Property) partToCreate).getType() instanceof Component) {
			buildDeploymentSubstructureBasedOnComponent(
				getModelComponent(newPart), newPart, structuralRealization);
		}
		return newPart;
	}

	/**
	 * Recursive function to create deployment substructure to reflect a UML
	 * component.
	 * 
	 * @param component -
	 *            the component we are building substructure for.
	 * @param parentPart -
	 *            the parent part for any new deployment parts created in this
	 *            method.
	 * @param structuralRealization
	 *            the structural realization of this element if it is a
	 *            component interface. unused if not component interface
	 */
	protected static void buildDeploymentSubstructureBasedOnComponent(
			Component component, Property parentPart,
			Component structuralRealization) {

		Component deployment = (Component) parentPart.getOwner();

		// The list of parts from which to create substructure will
		// vary depending on whether we are working with a
		// <<ComponentInterface>>
		List<Property> componentParts = new ArrayList<Property>();
		List<Connector> connectorParts = new ArrayList<Connector>();

		if (ZDLUtil.isZDLConcept(component, ZMLMMNames.COMPONENT_INTERFACE)) {
			ArrayList<Component> srList = getStructuralRealizations(component);
			if (structuralRealization == null && srList.size() == 1) {
				// by default we select the only structural realization
				componentParts = srList.get(0).getOwnedAttributes();
				connectorParts = srList.get(0).getOwnedConnectors();
			} else if (structuralRealization != null
				&& srList.contains(structuralRealization)) {
				componentParts = structuralRealization.getOwnedAttributes();
				connectorParts = structuralRealization.getOwnedConnectors();
			} else if (!srList.contains(structuralRealization)) {
				// throw new Exception("Structural realization not for the right
				// part.");
			}
		} else {
			componentParts = component.getOwnedAttributes();
			connectorParts = component.getOwnedConnectors();
		}
		for (Property substructureElement : componentParts) {
			if (!(isDeploymentPart(substructureElement))
				&& substructureElement.getType() instanceof Class) {
				if (ValidationUtil.canLink(LinkConstraintContext.DEPLOYMENT_PART,
						substructureElement.getType(), parentPart.getType())) {
					String conceptString = ValidationUtil.getLinkContext(
							LinkConstraintContext.DEPLOYMENT_PART,
							substructureElement.getType(),
							parentPart.getType());
					Property sc1 = createDeploymentPart(
							deployment,
							substructureElement, 
							parentPart,
							conceptString);
					if (substructureElement.getType() instanceof Component) {
						buildDeploymentSubstructureBasedOnComponent(
								(Component) substructureElement.getType(), sc1,
								null);
					}
				}
			} else if (substructureElement instanceof Port) {
				if ((((Port) substructureElement).getType() != null)
						&& (parentPart.getType() != null))
					if (ValidationUtil.canLink(
							LinkConstraintContext.DEPLOYMENT_PART,
							substructureElement, parentPart.getType())) {
						String conceptString = ValidationUtil.getLinkContext(
								LinkConstraintContext.DEPLOYMENT_PART, 
								substructureElement, parentPart.getType());
						createDeploymentPart(deployment, substructureElement,
								parentPart, conceptString);
					}
			}
		}
		for (Connector substructureElement : connectorParts) {
			if (ValidationUtil.canLink(LinkConstraintContext.DEPLOYMENT_PART,
					substructureElement, parentPart.getType())) {
				String conceptString = ValidationUtil.getLinkContext(
						LinkConstraintContext.DEPLOYMENT_PART, 
						substructureElement, parentPart.getType());
				createDeploymentPart(deployment, substructureElement, parentPart, conceptString);
			}
		}
	}

	public static ArrayList<Component> getStructuralRealizations(
			Component component) {
		ArrayList<Component> srList = new ArrayList<Component>();

		EList<Relationship> relList = component.getRelationships();

		for (Relationship rel : relList) {
			if (rel instanceof Generalization) {
				Generalization gen = (Generalization) rel;
				if (gen.getOwner() instanceof Component) {
					srList.add((Component) gen.getOwner());
				}
			}
		}
		return srList;
	}

	/**
	 * Gets the source part of the passed allocation.
	 * 
	 * @param allocation
	 * @return
	 */
	public static Property getSourcePartForAllocation(Dependency allocation) {
		if (allocation.getClients() == null){
			return null;
		}
		if (allocation.getClients().size() > 0)
			return (Property) allocation.getClients().get(0);
		return null;
	}

	/**
	 * Gets the target part of the passed allocation.
	 * 
	 * @param allocation
	 * @return
	 */
	public static Property getTargetPartForAllocation(Dependency allocation) {
		if (allocation.getSuppliers().size() > 0)
			return (Property) allocation.getSuppliers().get(0);
		return null;
	}

	/**
	 * Gets the allocation in which the passed part is the source.
	 * 
	 * @param source
	 * @return
	 */
	public static Dependency getAllocationForSourcePart(Property source) {
		
		if (source == null){
			return null;
		}
		EList<Relationship> relList = source.getRelationships();

		for (Relationship rel : relList) {
			if (rel instanceof Dependency
				&& getSourcePartForAllocation((Dependency) rel) == source) {
				return (Dependency) rel;
			}
		}

		return null;
	}

	/**
	 * Gets the allocation in which the passed part is the target.
	 * 
	 * @param target
	 * @return
	 */
	public static ArrayList<Dependency> getAllocationsForTargetPart(
			Property target) {
		
		if (target == null){
			return null;
		}
		ArrayList<Dependency> allocationList = new ArrayList<Dependency>();

		EList<Relationship> relList = target.getRelationships();

		for (Relationship rel : relList) {
			if (rel instanceof Dependency
				&& getTargetPartForAllocation((Dependency) rel) == target) {
				allocationList.add((Dependency) rel);
			}
		}

		return allocationList;
	}

	/**
	 * Gets the source parts deployed on this target part.
	 * 
	 * @param target
	 * @return
	 */
	public static Collection<Property> getDeploymentSourceParts(Property target) {
		ArrayList<Property> sourceParts = new ArrayList<Property>();
		ArrayList<Dependency> allocationList = getAllocationsForTargetPart(target);

		for (Dependency allocation : allocationList) {
			for( NamedElement element : allocation.getClients()) {
				sourceParts.add((Property)element);
			}
		}
		return sourceParts;
	}

	/**
	 * Gets the target part of an allocation when passed the source part.
	 * 
	 * @param source
	 * @return
	 * 		If the source part is deployed, the target part. Otherwise, null.
	 */
	public static Property getDeploymentTargetPart(Property source) {
		Dependency allocation = getAllocationForSourcePart(source);
		if (allocation != null) {
			if (allocation.getSuppliers().size() > 0)
				return (Property) allocation.getSuppliers().get(0);
		}
		return null;

	}

	/**
	 * Delete the deployment part passed as a parameter. Also deletes all its
	 * children.
	 * 
	 * @param deletingPart
	 */
	public static void deleteDeploymentPart(Property deletingPart) {
		Collection<Property> removeList = new ArrayList<Property>();

		Collection<Dependency> allocationList = getAllocations((Component) deletingPart
			.getOwner());

		removeList.add(deletingPart);
		for (Property part : getDescendants(deletingPart)) {
			removeList.add(part);
		}
		for (Property part : removeList) {
			if (part != null)
				DestroyElementCommand.destroy(part);
		}
		for (Dependency allocation : allocationList) {
			if (allocation.getSuppliers().size() == 0
				|| allocation.getClients().size() == 0) {
				DestroyElementCommand.destroy(allocation);
			}
		}
	}

	/**
	 * Returns a list of all descendants of the passed deployment part.
	 * 
	 * @param parent
	 * @return
	 */
	public static Collection<Property> getDescendants(Property parent) {
		Collection<Property> retVal = new ArrayList<Property>();

		for (Property child : getDeploymentChildren(parent)) {
			retVal.add(child);
			retVal.addAll(getDescendants(child));
		}

		return retVal;
	}

	/**
	 * Given a deployment part, make sure that the deployment is synchronized
	 * with the part. This means that wherever this part's model element is used
	 * in the UML model, there is a corresponding deployment part (where
	 * applicable) in the deployment.
	 * 
	 * @param deploymentPart -
	 *            the part we are synchronizing
	 */
	public static void synchronizeDeploymentParts(Property deploymentPart) {
		if (!ZDLUtil.isZDLConcept(deploymentPart,
			ZMLMMNames.DEPLOYMENT_PART))
			return;

		Property parentPart = getParentPart(deploymentPart);

		if (parentPart == null)
			return;

		Component deployment = (Component) deploymentPart.getOwner();

		for (Property candidatePart : getDeploymentParts(deployment)) {
			Component deploymentPartComponent = getModelComponent(parentPart);
			Component candidatePartComponent = getModelComponent(candidatePart);

			if (deploymentPartComponent == candidatePartComponent) {
				// we must add a child corresponding to deployment part if it
				// does not yet exist.
				boolean found = false;

				for (Property candidatePartChild : getDeploymentChildren(candidatePart)) {
					if (getModelElement(candidatePartChild) == getModelElement(deploymentPart)) {
						found = true;
					}
				}

				if (!found) {
					String conceptString = ValidationUtil.getLinkContext(
							LinkConstraintContext.DEPLOYMENT_PART, 
							getModelElement(deploymentPart), candidatePart);
					
					Property newPart = createDeploymentPart(deployment,
							getModelElement(deploymentPart), candidatePart,
							conceptString);
					NamedElement part = getModelElement(deploymentPart);
					if (part instanceof Component) {
						buildDeploymentSubstructureBasedOnComponent(
								(Component) getModelElement(deploymentPart),
								newPart, null);
					} else if (part instanceof Property
							&& ((Property) getModelElement(deploymentPart))
									.getType() instanceof Component) {
						buildDeploymentSubstructureBasedOnComponent(
								getModelComponent(newPart), newPart, null);
					}
				}
			}
		}
	}
}
