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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionContributor;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionInfo;

/**
 * Utility to repair the worker function operations on structural realizations.
 * 
 * This class synchronizes, in the least possible destructive manner, the worker
 * functions on the structural realizations by: <li>
 * Removing any worker functions operations that are no longer backed by a
 * provides port operation or an interface realization operation</li> <li>Adds
 * any new worker functions operations that are missing in the component
 * interface of the structural realization by either provides port or interface
 * realization</li>
 * 
 * @author jcorchis
 * 
 */
public class WorkerFunctionRepair {

	// Instance
	public static WorkerFunctionRepair INSTANCE = new WorkerFunctionRepair();

	// Map from concept to worker function contributor
	private Map<String, List<WorkerFunctionContributorInfo>> contributors = null;
	
	/**
	 * Creates a new instance of WorkerFunctionRepair.
	 */
	public WorkerFunctionRepair() {
		super();
		
		initializeContributors();
	}
	
	private void initializeContributors() {

		contributors =  new HashMap<String, List<WorkerFunctionContributorInfo>>();
		
		String namespace = "com.zeligsoft.cx.codegen"; //$NON-NLS-1$
		String extensionPointName = "workerfunctioncontributor"; //$NON-NLS-1$
		IExtension[] extensions = Platform.getExtensionRegistry()
		.getExtensionPoint(namespace, extensionPointName).getExtensions();

		if (extensions.length <= 0) {
			return;
		}
	
		for (int i = 0; i < extensions.length; i += 1) {
			IConfigurationElement[] entries = extensions[i]
				.getConfigurationElements();
			
			// Loop thru <concept> tags
			for (int i2 = 0; i2 < entries.length; i2 += 1) {
				String classString = entries[i2].getAttribute("class"); //$NON-NLS-1$
				String conceptString = entries[i2].getAttribute("concept"); //$NON-NLS-1$
				String workerFunctionConceptString = entries[i2].getAttribute("workerFunctionConcept");  //$NON-NLS-1$
				String domain = entries[i2].getAttribute("domain"); //$NON-NLS-1$
				String bundleString = entries[i2].getDeclaringExtension().getNamespaceIdentifier();
				
				try {
					Bundle bundle = Platform.getBundle(bundleString);
					if (bundle == null) {
						// Error in the plugin.xml most likely
						Activator.getDefault().error("Cannot find bundle " + bundleString, null); //$NON-NLS-1$
						throw new IllegalArgumentException(
							NLS.bind("Cannot find bundle " + bundleString, bundleString)); //$NON-NLS-1$
					}
					@SuppressWarnings("unchecked")					
					Class<WorkerFunctionContributor> clazz = (Class<WorkerFunctionContributor>) bundle.loadClass(classString);
					WorkerFunctionContributor contributor = clazz.newInstance();
					WorkerFunctionContributorInfo info = 
						new WorkerFunctionContributorInfo(contributor, domain, conceptString, 
								workerFunctionConceptString);
					List<WorkerFunctionContributorInfo> infoList = contributors.get(conceptString);
					if(infoList == null) {
						infoList = new ArrayList<WorkerFunctionContributorInfo>();
						contributors.put(conceptString, infoList);
					}
					infoList.add(info);
				} catch(ClassNotFoundException ce) {
					Activator.getDefault().error("Failed to load worker contributor class=" + classString + ", concept=" + conceptString, ce); //$NON-NLS-1$ //$NON-NLS-2$
				} catch(InstantiationException ie) {
					Activator.getDefault().error("Failed to load worker contributor class=" + classString + ", concept=" + conceptString, ie); //$NON-NLS-1$ //$NON-NLS-2$
				} catch (IllegalAccessException ee) {
					Activator.getDefault().error("Failed to load worker contributor class=" + classString + ", concept=" + conceptString, ee); //$NON-NLS-1$ //$NON-NLS-2$
				}	
			}
		}
	}

	/**
	 * Synchronizes the worker functions for the given structural realization.
	 * 
	 * @param structuralRealization
	 */
	public void repair(Component structuralRealization) {
		doRepair(structuralRealization);
	}

	/**
	 * Synchronizes the worker functions for the given Collection of structural
	 * realizations.
	 * 
	 * @param structuralRealizations
	 */

	public void repair(Collection<Component> structuralRealizations) {

		for (Component thisComponent : structuralRealizations) {
			doRepair(thisComponent);
		}

	}

	/**
	 * Synchronizes the worker function names with the renamed port name.
	 * 
	 * @param structuralRealizations
	 * @param renamedPortMap
	 */
	public void rename(Collection<Component> structuralRealizations,
			Map<Port, String> renamedPortMap) {

		for (Component thisComponent : structuralRealizations) {
			doRename(thisComponent, renamedPortMap);
		}

	}

	/**
	 * Internal rename.
	 */
	private void doRename(Component structuralRealization,
			Map<Port, String> renamedPortMap) {

		if (ZDLUtil.isZDLConcept(structuralRealization,
			ZMLMMNames.STRUCTURAL_REALIZATION)) {

			// A map of the required worker functions for the structural
			// realization
			Map<Port, List<WorkerFunctionInfo>> target = buildTargetMap(structuralRealization, new HashMap<WorkerFunctionInfo, WorkerFunctionContributorInfo>());
			rename(structuralRealization, target, renamedPortMap);
		}
	}

	/**
	 * Internal repair.
	 */
	private void doRepair(Component structuralRealization) {

		
		if (ZDLUtil.isZDLConcept(structuralRealization,
			ZMLMMNames.STRUCTURAL_REALIZATION)) {
	
			// A map of the required worker functions for the structural
			// realization
			Map<WorkerFunctionInfo, WorkerFunctionContributorInfo> opContributorMap = new HashMap<WorkerFunctionInfo, WorkerFunctionContributorInfo>();
			Map<Port, List<WorkerFunctionInfo>> target = buildTargetMap(structuralRealization, opContributorMap);
			prune(structuralRealization, target);
			grow(structuralRealization, target, opContributorMap);
			migrate(structuralRealization, opContributorMap);
		}
	}

	private void migrate(Component structuralRealization,
			Map<WorkerFunctionInfo, WorkerFunctionContributorInfo> opContributorMap) {
		
		@SuppressWarnings("unchecked")
		List<Operation> workerFunctions = (List<Operation>) ZDLUtil.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		
		for(Operation wf : workerFunctions) {
			if(!WorkerFunctionUtil.INSTANCE.hasWorkerFunctionImplementation(wf)) {
				createWorkerFunctionImpl(structuralRealization, wf);
			}
		}
	}

	/**
	 * Builds a map which defines what operations a structural realization
	 * requires if it were up-to-date.
	 * 
	 * @param componentInterface
	 * @return
	 */
	private Map<Port, List<WorkerFunctionInfo>> buildTargetMap(
			Component structuralRealization, Map<WorkerFunctionInfo, WorkerFunctionContributorInfo> opContributorMap) {

		Map<Port, List<WorkerFunctionInfo>> target = new HashMap<Port, List<WorkerFunctionInfo>>();
		
		for( Entry<String, List<WorkerFunctionContributorInfo>> concept : contributors.entrySet() ) {
			List<WorkerFunctionContributorInfo> infoList = concept.getValue();
			if(infoList != null) {
				for(WorkerFunctionContributorInfo info : infoList) {
					String domain = info.domain;
					if(UML2Util.isEmpty(domain) || ZDLUtil.isZDLProfile(structuralRealization, domain)) {
						if( info.contributor != null && ZDLUtil.isZDLConcept(structuralRealization, concept.getKey())) {
							Map<Port, List<WorkerFunctionInfo>> localTarget = new HashMap<Port, List<WorkerFunctionInfo>>();
							info.contributor.buildTargetMap(structuralRealization, localTarget);
							target.putAll(localTarget);
							for(List<WorkerFunctionInfo> opList : localTarget.values()) {
								for(WorkerFunctionInfo op : opList) {
									opContributorMap.put(op, info);
								}
							}
						}
					}
				}
			}
		}

		return target;
	}

	/**
	 * When the operation passed is not null, makes a copy of the provided Operation 
	 * and adds it to the given structural realization. 
	 * 
	 * When the operation passed is null, creates a new Operation and adds it to the
	 * given structural realization.
	 * 
	 * The method also sets the worker function property values.
	 * 
	 * @param structuralRealization
	 * @param thisOperation
	 * @param receivingPort
	 * @param workerFunctionConcept 
	 * @return the new Operation
	 */
	private static Operation createWorkerFunction(Component structuralRealization, WorkerFunctionInfo thisOperation,
			Port receivingPort, String workerFunctionConcept) {
		
		Operation replicatedOperation = null;
		
		if( thisOperation != null ) {
			replicatedOperation = EcoreUtil.copy(thisOperation.getOperation());
			replicatedOperation.setVisibility(VisibilityKind.PRIVATE_LITERAL);
			String newName = getWorkerFunctionName(thisOperation.getOperation(), receivingPort);
			replicatedOperation.setName(newName);	
		} else {
			replicatedOperation = UMLFactory.eINSTANCE.createOperation();
			replicatedOperation.setVisibility(VisibilityKind.PRIVATE_LITERAL);
			replicatedOperation.setName(receivingPort.getName() + "_worker"); //$NON-NLS-1$
		}
		
		if (replicatedOperation != null) {
			structuralRealization.getOwnedOperations().add(replicatedOperation);
			if(workerFunctionConcept == null || workerFunctionConcept.length() == 0) {
				ZDLUtil.addZDLConcept(replicatedOperation,
						ZMLMMNames.WORKER_FUNCTION);
			} else {
				ZDLUtil.addZDLConcept(replicatedOperation, workerFunctionConcept);
			}
			if( thisOperation != null && thisOperation.getOperation() != null) {
				// only port operations have an eResource. Property operations do not.
				if( thisOperation.getOperation().eResource() != null) {
					ZDLUtil.setValue(replicatedOperation, ZMLMMNames.WORKER_FUNCTION,
						ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION, thisOperation.getOperation());
				}
				thisOperation.configure(replicatedOperation);
			}
			String uuid = UUID.randomUUID().toString();
			if (thisOperation != null) {
				String opUuid = thisOperation.getUuid();
				if (!UML2Util.isEmpty(opUuid)) {
					uuid = opUuid;
				}
			}
			ZDLUtil.setValue(replicatedOperation, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT, receivingPort);
			ZDLUtil.setValue(replicatedOperation, ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__UUID, uuid);
		}

		return replicatedOperation;
	}
	
	private static OpaqueBehavior createWorkerFunctionImpl(Component structuralRealization, 
			Operation op) {
		OpaqueBehavior replicatedBehavior = null;
		
		if(op != null) {
			replicatedBehavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
			replicatedBehavior.setVisibility(VisibilityKind.PRIVATE_LITERAL);
			replicatedBehavior.setName(WorkerFunctionUtil.INSTANCE
					.workerFunctionImplDefaultName(op.getName()));
			replicatedBehavior.setSpecification(op);
			
			for(Parameter p : op.getOwnedParameters()) {
				Parameter copyOfP = EcoreUtil.copy(p);
				replicatedBehavior.getOwnedParameters().add(copyOfP);
			}
		}
		
		if(replicatedBehavior != null) {
			structuralRealization.getOwnedBehaviors().add(replicatedBehavior);
			ZDLUtil.addZDLConcept(replicatedBehavior, ZMLMMNames.WORKER_FUNCTION_IMPL);
		}
		
		return replicatedBehavior;
	}

	/**
	 * Generates a worker function name based on the given operation and port.
	 * 
	 * @param operation
	 *            the required base Operation that the worker function is based.
	 * @param port
	 *            an optional Port
	 * @return the worker function name
	 */
	private static String getWorkerFunctionName(Operation operation, Port port) {
		String newName = (port != null)
			? port.getName() + '_' + operation.getName()
			: operation.getName();
		return newName;

	}

	/**
	 * Rename worker function according to the port name change
	 * 
	 * @param structuralRealization
	 * @param target
	 * @param renamedPortMap
	 */
	private void rename(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, Map<Port, String> renamedPortMap) {

		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
			.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		for (Operation thisWorkerFunction : existingWorkerFunctions) {

			Port thisPort = (Port) ZDLUtil.getValue(thisWorkerFunction,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
			Operation thisOperation = (Operation) ZDLUtil.getValue(
				thisWorkerFunction, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);

			List<WorkerFunctionInfo> operations = target.get(thisPort);
			if (operations != null) {
				Iterator<WorkerFunctionInfo> iter = operations.iterator();
				boolean found = false;
				while (iter.hasNext() && !found) {
					WorkerFunctionInfo op = iter.next();
					if (renamedPortMap != null) {
						if (op.getOperation() == thisOperation) {
							if (thisPort != null) {
								final String newOperationName = String.format("%s_%s", thisPort.getName(),  //$NON-NLS-1$
										thisOperation.getName());
								final String desiredOperationName = String.format("%s_%s",  //$NON-NLS-1$
										renamedPortMap.get(thisPort),
										thisOperation.getName());
								
								if (desiredOperationName
									.equals(thisWorkerFunction.getName())) {
									thisWorkerFunction.setName(newOperationName);
								}
								WorkerFunctionUtil.INSTANCE.renameWorkerFunctionImpls(thisWorkerFunction, 
										desiredOperationName, newOperationName);
							} else {
								final String newOperationName = op.getOperation().getName();
								final String oldOperationName = thisWorkerFunction.getName();
								if (!oldOperationName.equals(newOperationName)) {
									thisWorkerFunction.setName(newOperationName);
								}
								
								WorkerFunctionUtil.INSTANCE.renameWorkerFunctionImpls(thisWorkerFunction, 
										oldOperationName, newOperationName);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Removes all of the worker functions from the given structural realization
	 * if they no longer have a representation in its component interface.
	 * 
	 * @param structuralRealization
	 * @param target
	 */
	private void prune(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target) {

		List<Operation> toRemove = new ArrayList<Operation>();
		
		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
			.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		
		for( Operation o : existingWorkerFunctions ) {
			toRemove.add(o);
			synchronizeWorkerParametersAndWorkerName(o);
		}
		
		for( Entry<String, List<WorkerFunctionContributorInfo>> concept : contributors.entrySet() ) {
			if( ZDLUtil.isZDLConcept(structuralRealization, concept.getKey())) {
				for(WorkerFunctionContributorInfo info : concept.getValue()){
					info.contributor.filterPruneList(structuralRealization, target, toRemove);
				}
			}
		}
		
		for(Operation o : toRemove) {
			WorkerFunctionUtil.INSTANCE.destroyWorkerFunctionImpls(o);
		}

		// destroy the worker functions
		for(Operation op : toRemove) {
			((Element) op).destroy();
			existingWorkerFunctions.remove(op);
		}
		
		// Remove WorkerFunctionImpls where corresponding worker function no
		// longer exist. This may happen if user deletes worker function
		// manually.
		@SuppressWarnings("unchecked")
		List<EObject> workerImpls = (List<EObject>) ZDLUtil.getValue(
				structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER_IMPL);
		Iterator<EObject> itor = workerImpls.iterator();
		while (itor.hasNext()) {
			EObject impl = itor.next();
			Object worker = ZDLUtil.getValue(impl,
					ZMLMMNames.WORKER_FUNCTION_IMPL,
					ZMLMMNames.WORKER_FUNCTION_IMPL__WORKER_FUNCTION);
			if (worker == null) {
				itor.remove();
				((Element) impl).destroy();
			}
		}
	}

	/**
	 * Adds any new required worker functions to the given structural
	 * realization if they do not already exist.
	 * 
	 * @param structuralRealization
	 * @param target
	 * @param opContributorMap 
	 */
	private void grow(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, Map<WorkerFunctionInfo, WorkerFunctionContributorInfo> opContributorMap) {

		Map<Port, List<WorkerFunctionInfo>> toAdd = new HashMap<Port, List<WorkerFunctionInfo>>();
		
		// make a copy of target map
		for( Port thisPort : target.keySet() ) {
			toAdd.put(thisPort, new ArrayList<WorkerFunctionInfo>());
			toAdd.get(thisPort).addAll(target.get(thisPort));
		}

		for(List<WorkerFunctionContributorInfo> infoList : contributors.values()) {
			for( WorkerFunctionContributorInfo contributorInfo : infoList ) {
				if( UML2Util.isEmpty(contributorInfo.domain) ||
						ZDLUtil.isZDLProfile(structuralRealization, contributorInfo.domain)){
					if( ZDLUtil.isZDLConcept(structuralRealization, contributorInfo.concept)) {
						contributorInfo.contributor.filterGrowList(structuralRealization, target, toAdd);
					}
				}
			}
		}
		
		// implementation worker functions
		Iterator<Port> iter = toAdd.keySet().iterator();
		while (iter.hasNext()) {
			Port thisPort = iter.next();
			List<WorkerFunctionInfo> operations = toAdd.get(thisPort);
			if(operations != null && operations.size() > 0) {
				for (WorkerFunctionInfo thisOperation : operations) {
					WorkerFunctionContributorInfo info = opContributorMap.get(thisOperation);
					Operation workerFunction = createWorkerFunction(structuralRealization, thisOperation,
						thisPort, info.workerFunctionConcept);
					if(workerFunction != null) {
						createWorkerFunctionImpl(structuralRealization, workerFunction);
					}
				}
			} else if( thisPort != null ) {
				Operation workerFunction = createWorkerFunction(structuralRealization, null, thisPort, null);
				if(workerFunction != null) {
					createWorkerFunctionImpl(structuralRealization, workerFunction);
				}
			}
		}
	}
	
	/**
	 * Synchronizes worker function parameter types with original operation
	 * parameters, Also synchronizes worker name with operation name
	 * 
	 * @param structuralRealization
	 */
	private void synchronizeWorkerParametersAndWorkerName(Operation workerFunction) {
		Operation interfaceOperation = (Operation) ZDLUtil.getValue(
				workerFunction, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
		
		if (interfaceOperation != null) {
			HashMap<String, Type> interfaceOperationParameters = new HashMap<String, Type>();
			HashMap<String, Type> paramsToAdd = new HashMap<String, Type>();
			
			String newWorkerName = null;
			EObject port = (EObject) ZDLUtil.getValue(workerFunction,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
			if (port != null) {
				newWorkerName = getWorkerFunctionName(interfaceOperation, (Port) port);
				workerFunction.setName(newWorkerName);
			}
			for (Parameter interfaceParam : interfaceOperation
					.getOwnedParameters()) {
				interfaceOperationParameters.put(interfaceParam.getName(), interfaceParam.getType());
			}
			paramsToAdd.putAll(interfaceOperationParameters);
			
			Iterator<Parameter> workerIterator = workerFunction.getOwnedParameters()
					.iterator();		
			while (workerIterator.hasNext()) {
				Parameter workerParam = workerIterator.next();
				if (interfaceOperationParameters.containsKey(workerParam.getName())) {
					workerParam.setType(interfaceOperationParameters.get(workerParam.getName()));
					paramsToAdd.remove(workerParam.getName());
				} else {
					workerIterator.remove();
					EcoreUtil.delete(workerParam);
				}
			}
			if (!paramsToAdd.isEmpty()) {
				for (String name : paramsToAdd.keySet()) {
					workerFunction.createOwnedParameter(name, paramsToAdd.get(name));
				}
			}
			// now look at the implementations worker functions for the operation
			for (EObject workerImpl :WorkerFunctionUtil.getWorkerFunctionImpls(workerFunction)) {
				paramsToAdd.clear();
				paramsToAdd.putAll(interfaceOperationParameters);

				if (newWorkerName != null) {
					((OpaqueBehavior) workerImpl)
							.setName(WorkerFunctionUtil.INSTANCE
									.workerFunctionImplDefaultName(newWorkerName));
				}
				
				Iterator<Parameter> workerImplIterator = ((OpaqueBehavior) workerImpl)
						.getOwnedParameters().iterator();
				while (workerImplIterator.hasNext()) {
					Parameter workerImplParam = workerImplIterator.next();
					if (interfaceOperationParameters.containsKey(workerImplParam.getName())) {
						workerImplParam.setType(interfaceOperationParameters
								.get(workerImplParam.getName()));
						paramsToAdd.remove(workerImplParam.getName());
					} else {
						workerImplIterator.remove();
						EcoreUtil.delete(workerImplParam);
					}
				}
				if (!paramsToAdd.isEmpty()) {
					for (String name : paramsToAdd.keySet())
						((OpaqueBehavior) workerImpl).createOwnedParameter(
								name, paramsToAdd.get(name));
				}
			}
		}
	}
	
	/**
	 *  Internal classes
	 */
	
	/**
	 * A book keeping class for maintaining the information about the
	 * contributors.
	 */
	private static class WorkerFunctionContributorInfo {
		public WorkerFunctionContributor contributor = null;
		public String concept = null;
		public String workerFunctionConcept = null;
		public String domain = null;
		
		public WorkerFunctionContributorInfo(WorkerFunctionContributor contributor, String domain, String concept, String workerFunctionConcept) {
			this.contributor = contributor;
			this.concept = concept;
			this.workerFunctionConcept = workerFunctionConcept;
			this.domain = domain;
		}
	}
	
}
