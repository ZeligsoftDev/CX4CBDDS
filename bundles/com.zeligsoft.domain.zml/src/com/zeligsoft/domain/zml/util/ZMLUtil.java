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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Base ZML domain utilities.
 * 
 * @author jcorchis
 * 
 */
public class ZMLUtil {
	
	public static boolean isMigrationInProgress = false;
	
	/**
	 * Obtains the structural realizations of the specified component interface,
	 * that are currently loaded in the resource set.
	 * 
	 * @param component
	 *            a component interface
	 * @return the available structural realizations, or an empty list if the
	 *         specified interface is not an instance of the
	 *         <tt>ComponentInterface</tt> concept
	 */
	public static EList<Component> getStructuralRealizations(Component component) {
		EList<Component> result;

		if (component == null
			|| !ZDLUtil.isZDLConcept(component, ZMLMMNames.COMPONENT_INTERFACE)) {
			result = ECollections.emptyEList();
		} else {
			result = new UniqueEList.FastCompare<Component>();

			for (Relationship next : component
				.getRelationships(UMLPackage.Literals.GENERALIZATION)) {
				Classifier specific = ((Generalization) next).getSpecific();

				if ((specific instanceof Component)
					&& ZDLUtil.isZDLConcept(specific,
						ZMLMMNames.STRUCTURAL_REALIZATION)) {
					result.add((Component) specific);
				}
			}

			result = new BasicEList.UnmodifiableEList<Component>(result.size(),
				result.toArray());
		}

		return result;
	}

	/**
	 * Obtains the implementation of the specified structural realization, that
	 * are currently loaded in the resource set.
	 * 
	 * @param component
	 *            a structural realization
	 * @return the component implementations, or an empty list if the specified
	 *         structural realization is not an instance of the
	 *         <tt>StructuralRealization</tt> concept or it does not have any
	 *         implementations.
	 */
	public static EList<Artifact> getComponentImplementations(
			Component component) {
		EList<Artifact> result;

		if (component == null
				|| !ZDLUtil.isZDLConcept(component,
						ZMLMMNames.STRUCTURAL_REALIZATION)) {
			result = ECollections.emptyEList();
		} else {
			result = new UniqueEList.FastCompare<Artifact>();

			for (Setting s : UMLUtil.getInverseReferences(component)) {
				if (ZDLUtil.isZDLConcept(s.getEObject(),
						ZMLMMNames.COMPONENT_IMPLEMENTATION)) {
					EObject impl = ZDLUtil
							.getEValue(
									s.getEObject(),
									ZMLMMNames.COMPONENT_IMPLEMENTATION,
									ZMLMMNames.COMPONENT_IMPLEMENTATION__IMPLEMENTATION);
					if (impl != null) {
						result.add((Artifact) impl);
					}
				}
			}

			result = new BasicEList.UnmodifiableEList<Artifact>(result.size(),
					result.toArray());
		}

		return result;
	}

	/**
	 * Returns the component interface for the given structural realization.
	 * 
	 * @param component
	 *            a structural realization
	 * @return the structural realization's component interface or null
	 */
	public static Component getComponentInterface(
			Component structuralRealization) {
		Component result = null;

		if (structuralRealization != null
			&& ZDLUtil.isZDLConcept(structuralRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION)) {
			result = (Component) ZDLUtil.getValue(structuralRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
		}

		return result;
	}

	/**
	 * Removes all the worker functions that are defined in the given structural
	 * realization.
	 * 
	 * @param structuralRealization
	 * @param componentInterface
	 */
	public static void deleteWorkerFunctionOperations(
			Component structuralRealization) {

		if (structuralRealization != null
			&& ZDLUtil.isZDLConcept(structuralRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION)) {
			List<Operation> ownedOperations = structuralRealization
				.getOwnedOperations();
			ownedOperations = new java.util.ArrayList<Operation>(
				ownedOperations);
			for (Operation thisOperation : ownedOperations) {
				if (ZDLUtil.isZDLConcept(thisOperation,
					ZMLMMNames.WORKER_FUNCTION)) {
					thisOperation.destroy();
				}
			}
		}
	}

	/**
	 * This method finds all the structural realizations for the given component
	 * interface and removes all worker function Operations
	 * 
	 * @param componentInterface
	 * @param receivingPort
	 */
	public static void removeOwnedPortOperationsFromSRs(
			Component componentInterface, Port receivingPort) {
		List<Component> structuralRealizations = getStructuralRealizations(componentInterface);
		for (Component thisSR : structuralRealizations) {
			removeOwnedPortOperations(thisSR, receivingPort);
		}
	}

	/**
	 * Removes the port Operations from the structural realizations that are
	 * defined by receiving Port.
	 * 
	 * @param structuralRealization
	 * @param receivingPort
	 */
	private static void removeOwnedPortOperations(
			Component structuralRealization, Port receivingPort) {
		List<Operation> portWorkerFunctions = getExistingPortWorkerFunction(
			structuralRealization, receivingPort);
		for (Operation thisOperation : portWorkerFunctions) {
			thisOperation.destroy();
		}
	}

	/**
	 * Adds Operations on the given structural realization based on the port
	 * operations in the given component interface.
	 * 
	 * @param structuralRealization
	 * @param componentInterface
	 */
	public static void createWorkerFunctionOperations(
			Component structuralRealization, Component componentInterface) {

		if (componentInterface != null
			&& ZDLUtil.isZDLConcept(componentInterface,
				ZMLMMNames.COMPONENT_INTERFACE)) {

			// Add Port realization interface operations
			EList<Port> ownedPorts = componentInterface.getOwnedPorts();
			for (Port thisPort : ownedPorts) {
				if (ZDLUtil.isZDLConcept(thisPort, ZMLMMNames.PORT)) {
					addOwnedPortOperations(structuralRealization, thisPort);
				}
			}

			// Add InterfaceRealization operations
			EList<InterfaceRealization> irs = componentInterface
				.getInterfaceRealizations();
			for (InterfaceRealization thisInterfaceRealization : irs) {
				Interface thisInterface = thisInterfaceRealization
					.getContract();
				if (ZDLUtil.isZDLConcept(thisInterface, ZMLMMNames.INTERFACE)) {
					addInterfaceRealizationOperations(structuralRealization,
						thisInterface);
				}
			}
		}
	}

	/**
	 * This method finds all the structural realizations for the given component
	 * interface and adds duplicates of all the realized Operations defined by
	 * the receiving port.
	 * 
	 * @param componentInterface
	 * @param receivingPort
	 */
	public static void addOwnedPortOperationsToSRs(
			Component componentInterface, Port receivingPort) {
		List<Component> structuralRealizations = getStructuralRealizations(componentInterface);
		for (Component thisSR : structuralRealizations) {
			addOwnedPortOperations(thisSR, receivingPort);
		}
	}

	/**
	 * Makes duplicates of all provided Operations defined by the given Port and
	 * adds them to the given structural realization.
	 * 
	 * @param structuralRealization
	 * @param receivingPort
	 */
	private static void addOwnedPortOperations(Component structuralRealization,
			Port receivingPort) {

		if ((receivingPort != null && ZDLUtil.isZDLConcept(receivingPort,
			ZMLMMNames.PORT))
			&& (structuralRealization != null && ZDLUtil.isZDLConcept(
				structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION))) {

			EList<Interface> providesInterfaces = receivingPort.getProvideds();

			for (Interface thisInterface : providesInterfaces) {
				if (ZDLUtil.isZDLConcept(thisInterface, ZMLMMNames.INTERFACE)) {
					List<Operation> allOperations = thisInterface
						.getAllOperations();
					for (Operation thisOperation : allOperations) {
						replicateOperation(structuralRealization,
							thisOperation, receivingPort);
					}
				}
			}
		}

	}

	/**
	 * Adds the operations to the structural realization defined by the given
	 * interface. This method will also add any inherited operations.
	 * 
	 * @param structuralRealization
	 * @param interfase
	 */
	private static void addInterfaceRealizationOperations(
			Component structuralRealization, Interface interfase) {

		if (interfase != null) {
			List<Operation> allOperations = interfase.getAllOperations();
			for (Operation thisOperation : allOperations) {
				replicateOperation(structuralRealization, thisOperation, null);
			}
		}
	}

	/**
	 * Makes a copy of the provided Operation and adds it to the given
	 * structural realization. The method also set the work function properties
	 * values.
	 * 
	 * @param structuralRealization
	 * @param operation
	 * @param receivingPort
	 * @return
	 */
	private static Operation replicateOperation(
			Component structuralRealization, Operation operation,
			Port receivingPort) {
		Operation replicatedOperation = EcoreUtil.copy(operation);
		if (replicatedOperation != null) {
			structuralRealization.getOwnedOperations().add(replicatedOperation);
			ZDLUtil.addZDLConcept(replicatedOperation,
				ZMLMMNames.WORKER_FUNCTION);
			ZDLUtil.setValue(replicatedOperation, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION, operation);
			ZDLUtil.setValue(replicatedOperation, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT, receivingPort);
		}

		return replicatedOperation;
	}

	/**
	 * Returns all work functions on the given structural realization that
	 * reference the given Port.
	 * 
	 * @param structuralRealization
	 * @param port
	 * @return
	 */
	private static List<Operation> getExistingPortWorkerFunction(
			Component structuralRealization, Port port) {

		List<Operation> workerFunctionOperations = new ArrayList<Operation>();

		if (structuralRealization != null
			&& ZDLUtil.isZDLConcept(structuralRealization,
				ZMLMMNames.STRUCTURAL_REALIZATION)) {
			List<Operation> currentOperations = structuralRealization
				.getOwnedOperations();

			for (Operation thisOperation : currentOperations) {
				if (ZDLUtil.isZDLConcept(thisOperation,
					ZMLMMNames.WORKER_FUNCTION)
					&& (port == ZDLUtil.getValue(thisOperation,
						ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT))) {
					workerFunctionOperations.add(thisOperation);
				}
			}
		}

		return workerFunctionOperations;
	}

	/**
	 * Queries the interface from the imported packages of the given context.
	 * 
	 * @param context
	 *            model element
	 * @param qualifiedName
	 *            qualified name of the interface to find
	 * @return
	 */
	public static Interface getInterfaceFromImportedPackages(Element context,
			String qualifiedName) {

		Iterator<Package> itor = context.getModel().getImportedPackages()
			.iterator();

		while (itor.hasNext()) {
			Resource resource = EcoreUtil.getRootContainer(itor.next())
				.eResource();
			Collection<NamedElement> elements = UMLUtil.findNamedElements(
				resource, qualifiedName);

			if (elements.iterator().hasNext()) {
				NamedElement element = elements.iterator().next();
				if (element instanceof Interface) {
					return (Interface) element;
				}
			}
		}
		return null;
	}

}
