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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * ResourceSetListener which synchronizes the worker functions on structural
 * realizations when changes are made on a component interface.
 * 
 * @author jcorchis
 * 
 */
public class PortOperationsTrigger
		extends WorkerFunctionRepairTrigger {

	/**
	 * The types of objects that this trigger is interested in
	 */
	private static final Class<?>[] RELEVANT_TYPES = {Port.class, Operation.class};
	
	/**
	 * Create me.
	 */
	public PortOperationsTrigger() {
		super();
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {

		componentsToRepair.clear();

		CompoundCommand cc = new CompoundCommand("WorkerFunctionRepair"); //$NON-NLS-1$

		// get the moved ports so that we don't treat them as deleted and added
		Set<Port> movedPorts = getMovedPortsWithUnambiguousSRs(event);
		
		Set<EObject> deletedEObjects = getDeletedObjects(event);
		for (EObject thisEObject : deletedEObjects) {
			if (thisEObject instanceof Generalization) {
				Component c = getSRImpactedByDeleteGen(event,
					(Generalization) thisEObject);
				if (c != null) {
					componentsToRepair.add(c);
				}
			} else if ((thisEObject instanceof Port)
				&& !movedPorts.contains(thisEObject)) {
				
				// moved ports are handled differently
				RecordingCommand rc = getOperationsToDestroy(event,
					(Port) thisEObject);
				if (rc != null) {
					cc.append(rc);
				}
			} else if (thisEObject instanceof InterfaceRealization) {
				componentsToRepair.addAll(getSRsImpactedByDeleteIR(event,
					(InterfaceRealization) thisEObject));
			}
		}

		Set<EObject> addedEObjects = getAddedObjects(event);
		for (EObject thisEObject : addedEObjects) {
			if (thisEObject instanceof Generalization) {
				Component c = getSRImpactedByAddGen(event,
					(Generalization) thisEObject);
				if (c != null) {
					componentsToRepair.add(c);
				}
			} else if ((thisEObject instanceof Port)
				&& !movedPorts.contains(thisEObject)) {
				
				componentsToRepair.addAll(getSRsImpactedByAddPort(event,
					(Port) thisEObject));
			} else if (thisEObject instanceof InterfaceRealization) {
				componentsToRepair.addAll(getSRsImpactedByAddIR(event,
					(InterfaceRealization) thisEObject));
			}
		}
		
		for (Port port : movedPorts) {
			cc.append(movePortWorkerFunctions(event, port));
		}

		Set<EObject> renamedObjects = getRenamedObject(event, RELEVANT_TYPES);
		Set<Component> componentsToRename = new HashSet<Component>();
		for (EObject thisEObject : renamedObjects) {
			if (thisEObject instanceof Port) {
				componentsToRename.addAll(getSRsImpactedByAddPort(event,
					(Port) thisEObject));
			}
		}

		if (!componentsToRename.isEmpty()) {
			final Set<Component> pleaseRename = componentsToRename;
			final Map<Port, String> portMap = getRenamedPortMap(event);
			cc.append(new RecordingCommand(event.getEditingDomain()) {

				@Override
				protected void doExecute() {
					WorkerFunctionRepair.INSTANCE.rename(pleaseRename, portMap);
				}
			});
		}

		componentsToRepair.addAll(getSRsImpactedByPortTypeChanged(event));
		componentsToRepair.addAll(getSRsImpactedByGeneralizationChange(event));
		componentsToRepair.addAll(getSRsImpactedByIsConjugatedChange(event));
		
		if (!componentsToRepair.isEmpty()) {
			final Set<Component> pleaseRepair = componentsToRepair;
			cc.append(new RecordingCommand(event.getEditingDomain()) {

				@Override
				protected void doExecute() {
					WorkerFunctionRepair wfr = new WorkerFunctionRepair();
					wfr.repair(pleaseRepair);
				}

			});
		}

		if (cc.canExecute()) {
			return cc.unwrap();
		}
		return null;

	}

	/**
	 * Safely determines if the given object is a message port.
	 * 
	 * @param port
	 * @return
	 */
	private boolean safeIsPort(Object port) {
		return port instanceof EObject
			&& ZDLUtil.isZDLConcept((EObject) port, ZMLMMNames.PORT);
	}

	/**
	 * Returns Map containing new port as key and the old port name as value.
	 * 
	 * @param event
	 * @return
	 */
	private Map<Port, String> getRenamedPortMap(ResourceSetChangeEvent event) {
		Map<Port, String> renamedPortMap = new HashMap<Port, String>();

		for (Notification thisNotification : event.getNotifications()) {
			int eventType = thisNotification.getEventType();
			if (eventType == Notification.SET) {
				if (thisNotification.getNotifier() instanceof Port) {
					if (thisNotification.getNewValue() instanceof String
						&& thisNotification.getOldValue() != null) {
						renamedPortMap.put((Port) thisNotification
							.getNotifier(), (String) thisNotification
							.getOldValue());
					}
				}
			}
		}
		return renamedPortMap;

	}

	/**
	 * Returns the structural realizations impacted by the deletion in the given
	 * generalization.
	 * 
	 * @param event
	 * @param generalization
	 * @return
	 */
	private Component getSRImpactedByDeleteGen(ResourceSetChangeEvent event,
			Generalization generalization) {

		Component result = null;

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			Object feature = thisNotification.getFeature();
			Object newValue = thisNotification.getNewValue();
			Object oldValue = thisNotification.getOldValue();
			Object notifier = thisNotification.getNotifier();
			int eventType = thisNotification.getEventType();

			if (feature instanceof EReference
				&& eventType == Notification.REMOVE
				&& safeIsStructuralRealization(notifier)
				&& oldValue == generalization && newValue == null) {

				result = (Component) notifier;
				break;
			}

		}

		return result;

	}

	/**
	 * Returns the structural realizations impacted by the addition in the given
	 * generalization.
	 * 
	 * @param event
	 * @param generalization
	 * @return
	 */
	private Component getSRImpactedByAddGen(ResourceSetChangeEvent event,
			Generalization generalization) {

		Component result = null;

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			Object feature = thisNotification.getFeature();
			Object newValue = thisNotification.getNewValue();
			Object oldValue = thisNotification.getOldValue();
			Object notifier = thisNotification.getNotifier();
			int eventType = thisNotification.getEventType();

			if (feature instanceof EReference && eventType == Notification.ADD
				&& safeIsStructuralRealization(notifier) && oldValue == null
				&& newValue == generalization) {

				result = (Component) notifier;
				break;
			}

		}

		return result;

	}

	/**
	 * Returns a set of structural realizations impacted by the change in a
	 * generalization.
	 * 
	 * @param event
	 * @return
	 */
	private Set<Component> getSRsImpactedByGeneralizationChange(
			ResourceSetChangeEvent event) {
		Set<Component> result = new HashSet<Component>();

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			Object notifier = thisNotification.getNotifier();

			if (notifier instanceof Generalization) {

				Object feature = thisNotification.getFeature();

				if (UMLPackage.Literals.GENERALIZATION__GENERAL == feature
					&& safeIsStructuralRealization(((Generalization) notifier)
						.getSpecific())) {
					result.add((Component) ((Generalization) notifier)
						.getSpecific());
					continue;
				}

				if (UMLPackage.Literals.GENERALIZATION__SPECIFIC == feature
					&& safeIsComponentInterface(((Generalization) notifier)
						.getGeneral())) {
					result.add((Component) ((Generalization) notifier)
						.getGeneral());
				}
			}
		}

		return result;
	}

	/**
	 * Returns a set of structural realizations impacted by the addition of the
	 * given port.
	 * 
	 * @param event
	 * @param port
	 * @return
	 */
	private Set<Component> getSRsImpactedByAddPort(
			ResourceSetChangeEvent event, Port port) {

		Set<Component> result = new HashSet<Component>();
		if (ZDLUtil.isZDLConcept(port, ZMLMMNames.PORT)) {
			EObject container = port.eContainer();
			if (ZDLUtil.isZDLConcept(container, ZMLMMNames.COMPONENT_INTERFACE)) {
				// return the collection of SR for this CI
				result.addAll(ZMLUtil
					.getStructuralRealizations((Component) container));
			}

		}

		return result;

	}

	/**
	 * Whenever a port is deleted we do not have enough information discern the
	 * worker functions related to that deleted port and pure interface worker
	 * functions, so we must remove the operations directly and not use the
	 * repair like the remainder of the events.
	 * 
	 * @param event
	 * @param port
	 * @return
	 */
	private RecordingCommand getOperationsToDestroy(
			ResourceSetChangeEvent event, Port port) {
		final List<Operation> result = new ArrayList<Operation>();

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			Object feature = thisNotification.getFeature();
			final Object notifier = thisNotification.getNotifier();
			int eventType = thisNotification.getEventType();

			if (eventType == Notification.SET
				&& (feature instanceof EReference && ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT
					.equals(((EReference) feature).getName()))
				&& (notifier instanceof EObject && "WorkerFunction".equals(((EObject) notifier).eClass().getName()))) {//$NON-NLS-1$
				// Collect all the operations, whose stereotype references the
				// Port that is being deleted.
				EObject eObj = (EObject) notifier;
				EReference operationRef = (EReference) eObj.eClass()
					.getEStructuralFeature("base_Operation");//$NON-NLS-1$
				if (operationRef != null) {
					Operation op = (Operation) eObj.eGet(operationRef);
					if (op != null) {
						result.add(op);
					}
				}
			}
		}
		
		// is the port still attached?  (i.e., just moved to another container)
		if (port.eResource() != null) {
			// also include any operations that are still associated with the
			// port, in the case that it wasn't actually destroyed but is moved to
			// another ComponentInterface (but in circumstances in which the
			// worker functions cannot be preserved)
			for( EObject extantWorker : ZDLUtil.getInverseReferences(
					port, ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT)) {
				result.add((Operation)extantWorker);
			}
		}
		
		if (!result.isEmpty()) {

			return new RecordingCommand(TransactionUtil.getEditingDomain(event
					.getEditingDomain())) {

				@Override
				protected void doExecute() {
					for (int i = 0; i < result.size(); i++) {
						Operation next = result.get(i);
						if( next.eContainer() != null && next.eResource() != null) {
							WorkerFunctionUtil.INSTANCE.destroyWorkerFunctionImpls(next);
						}
						next.destroy();
					}
				}

			};
		}
		return null;
	}

	/**
	 * Returns a set of structural realization that are impacted by the change
	 * of port type on a component interface.
	 * 
	 * @param event
	 * @return
	 */
	private Set<Component> getSRsImpactedByPortTypeChanged(
			ResourceSetChangeEvent event) {

		Set<Component> result = new HashSet<Component>();

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			final Object notifier = thisNotification.getNotifier();
			Object feature = thisNotification.getFeature();

			if (UMLPackage.Literals.TYPED_ELEMENT__TYPE == feature
				&& safeIsPort(notifier)) {
				org.eclipse.uml2.uml.Class owner = ((Port) notifier)
					.getClass_();
				if (safeIsComponentInterface(owner)) {
					result.addAll(ZMLUtil
						.getStructuralRealizations((Component) owner));
				}
			}
		}

		return result;
	}

	/**
	 * Returns a set of structural realizations impacted by the addition of the
	 * given interface realization.
	 * 
	 * @param event
	 * @param interfaceRealization
	 * @return
	 */
	private Set<Component> getSRsImpactedByAddIR(ResourceSetChangeEvent event,
			InterfaceRealization interfaceRealization) {

		Set<Component> result = new HashSet<Component>();
		if (ZDLUtil.isZDLConcept(interfaceRealization
			.getImplementingClassifier(), ZMLMMNames.COMPONENT_INTERFACE)) {
			// return the collection of SRs for this CI
			result.addAll(ZMLUtil
				.getStructuralRealizations((Component) interfaceRealization
					.getImplementingClassifier()));

		}
		return result;
	}

	/**
	 * Returns a set of structural realizations impacted by the deletion of the
	 * given interface realization.
	 * 
	 * @param event
	 * @param interfaceRealization
	 * @return
	 */
	private Set<Component> getSRsImpactedByDeleteIR(
			ResourceSetChangeEvent event,
			InterfaceRealization interfaceRealization) {

		Set<Component> result = new HashSet<Component>();

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {

			Object feature = thisNotification.getFeature();
			Object newValue = thisNotification.getNewValue();
			Object oldValue = thisNotification.getOldValue();
			Object notifier = thisNotification.getNotifier();
			int eventType = thisNotification.getEventType();

			if (feature instanceof EReference
				&& eventType == Notification.REMOVE
				&& safeIsComponentInterface(notifier)
				&& oldValue == interfaceRealization && newValue == null) {

				result.addAll(ZMLUtil
					.getStructuralRealizations((Component) notifier));
				break;
			}

		}

		return result;

	}

	/**
	 * Returns a set of structural realization that are impacted by the change
	 * of port conjugation on a component interface.
	 * 
	 * @param event
	 * @return
	 */
	private Set<Component> getSRsImpactedByIsConjugatedChange(
			ResourceSetChangeEvent event) {

		Set<Component> result = new HashSet<Component>();

		List<Notification> notifications = event.getNotifications();
		for (Notification thisNotification : notifications) {
			
			Object feature = thisNotification.getFeature();
	
			if(feature instanceof EAttribute){
				if(((EAttribute)feature).getName().equals(ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)) {
				
					Element port = UMLUtil
						.getBaseElement((EObject) thisNotification.getNotifier());
					
					if(port == null){
						continue;
					}
					
					EObject owner = ((Port) port).eContainer();
					
					if (safeIsComponentInterface(owner)) {
						result.addAll(ZMLUtil.getStructuralRealizations((Component) owner));
					}
				}
			}
		}

		return result;
	}

	/**
	 * Finds all {@link Port}s that are moved from one
	 * <tt>ComponentInterface</tt> that has only a single
	 * <tt>StructuralRealization</tt> to another that also has only a single
	 * <tt>StructuralRealization</tt>.
	 * 
	 * @param event
	 *            the resource-set delta
	 * @return the ports, which may be (hopefully usually) an empty set
	 */
	private Set<Port> getMovedPortsWithUnambiguousSRs(
			ResourceSetChangeEvent event) {
		Set<Port> result = new HashSet<Port>();

		for (Notification msg : event.getNotifications()) {
			final int type = msg.getEventType();
			switch (type) {
				case Notification.REMOVE :
				case Notification.REMOVE_MANY :
					Object notifier = msg.getNotifier();

					if ((msg.getFeature() == UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE)
						&& safeIsComponentInterfaceWithSingleSR(notifier)) {

						// removals from a CI having exactly one SR are
						// interesting to look at
						switch (type) {
							case Notification.REMOVE : {
								Object oldValue = msg.getOldValue();
								if (safeIsPortOfInterfaceWithSingleSR(oldValue)) {
									// woo hoo! A result
									result.add((Port) oldValue);
								}
							}
								break;
							case Notification.REMOVE_MANY : {
								Collection<?> oldValue = (Collection<?>) msg
									.getOldValue();
								for (Object next : oldValue) {
									if (safeIsPortOfInterfaceWithSingleSR(next)) {
										// woo hoo! A result
										result.add((Port) next);
									}
								}
							}
								break;
						}
					}
					break;
			}
		}

		return result;
	}

	/**
	 * Queries whether a port is currently attached and is a port of a CI that
	 * has only a single SR.
	 * 
	 * @param port
	 *            a putative port
	 * @return whether it is an existing port of a CI with a single SR
	 */
	private boolean safeIsPortOfInterfaceWithSingleSR(Object port) {
		if (!safeIsPort(port)) {
			return false;
		}
		
		// is it just moved? (i.e., now re-attached)
		Port ePort = (Port) port;
		EObject parent = ePort.eContainer();
		return (ePort.eResource() != null)
			&& safeIsComponentInterfaceWithSingleSR(parent);
	}

	/**
	 * Creates a command that moves the worker functions associated with the
	 * specified port to the one and only structural realization of its new
	 * owning component interface. It is a prerequisite of this method that the
	 * port be one of the
	 * {@linkplain #getMovedPortsWithUnambiguousSRs(ResourceSetChangeEvent)
	 * moved ports} in the current resource-set change event.
	 * 
	 * @param event
	 *            the resource-set change event
	 * @param port
	 *            a moved port
	 * @return a command that brings its worker functions along
	 */
	private Command movePortWorkerFunctions(ResourceSetChangeEvent event,
			final Port port) {

		// we already know that there is exactly one SR because that was a
		// precondition of processing this port
		final Component owner = ZMLUtil.getStructuralRealizations(
			(Component) port.getOwner()).get(0);
		final Resource destinationResource = owner.eResource();

		final List<EObject> workers = ZDLUtil.getInverseReferences(port,
			ZMLMMNames.WORKER_FUNCTION,
			ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);

		return new RecordingCommand(event.getEditingDomain()) {

			@Override
			protected void doExecute() {
				for (EObject next : workers) {
					Operation worker = (Operation) next;
					Resource oldResource = next.eResource();
					final List<EObject> workerImpls = 
						WorkerFunctionUtil.getWorkerFunctionImpls(worker);

					owner.getOwnedOperations().add(worker);

					if (oldResource != destinationResource) {
						// transfer stereotype applications
						destinationResource.getContents().addAll(
							worker.getStereotypeApplications());
					}
					
					for(EObject impl : workerImpls) {
						Behavior behavior = (Behavior) impl;
						owner.getOwnedBehaviors().add(behavior);
						
						if(oldResource != destinationResource) {
							destinationResource.getContents().addAll(
									behavior.getStereotypeApplications());
						}
					}
				}
			}
		};
	}
}
